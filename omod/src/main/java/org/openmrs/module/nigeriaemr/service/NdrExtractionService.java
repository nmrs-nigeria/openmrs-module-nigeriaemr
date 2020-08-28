package org.openmrs.module.nigeriaemr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.openmrs.module.nigeriaemr.util.Partition;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NdrExtractionService {
	
	NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
	
	int numberOfThreads = Integer.parseInt(Utils.getProperty("number_of_ndr_export_threads", 5));
	
	ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);
	
	ObjectMapper mapper = new ObjectMapper();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	static DecimalFormat df = new DecimalFormat("#.##");

    Queue<NDRExport> queue = new LinkedList<>();

	UserContext userContext;

	public NdrExtractionService(UserContext userContext){
	    this.userContext = userContext;
    }

	public void saveExport(HttpServletRequest request, List<Integer> filteredPatients,
                           String DATIMID,Date lastDate,Date currentDate) throws Exception {

        int patientSize  = filteredPatients.size();
        int batch = Utils.getBatchSize();

        int numm = 1;
        if (patientSize > batch) {
            numm += patientSize%batch;
        }

        List<List<Integer>> partitions = Partition.ofSize(filteredPatients,numm);
        NDRExportBatch ndrExportBatch = nigeriaemrService.createExportBatch(lastDate, patientSize);

        for(List<Integer> patients: partitions) {
            String IPReportingState = Utils.getIPReportingState();
            String IPReportingLgaCode = Utils.getIPReportingLgaCode();
            //create report download folder at the server. skip if already exist
            String reportType = "NDR";
            String reportFolder = Utils.ensureReportFolderExist(request, reportType);
            String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(currentDate);
            String fileName = IPReportingState +"_"+ IPReportingLgaCode + "_" + DATIMID + "_{pepFarId}_" + formattedDate;
            // Start export process
            NDRExport ndrExport = new NDRExport();
            ndrExport.setDateStarted(currentDate);
            ndrExport.setPatients(patients.size());
            ndrExport.setOwner(Context.getAuthenticatedUser());
            ndrExport.setName(fileName);
            ndrExport.setVoided(false);
            ndrExport.setStatus("Start");
            ndrExport.setLastDate(lastDate);
            ndrExport.setContextPath(request.getContextPath());
            ndrExport.setReportFolder(reportFolder);
            ndrExport.setBatchId(ndrExportBatch);
            try {
                ndrExport.setPatientsList(new ObjectMapper().writeValueAsString(patients));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new Exception("Error Processing Export");
            }
            nigeriaemrService.saveNdrExportItem(ndrExport);
        }
    }
	
	public void export(JAXBContext jaxbContext, NDRExport ndrExport) throws IOException {
        String DATIMID = Utils.getFacilityDATIMId();
        String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(ndrExport.getDateStarted());
        String patientList = ndrExport.getPatientsList();
        List<String> patients =  (List<String>)mapper.readValue(patientList,List.class);

        UserContext userContext = Context.getUserContext();
        try {
                List<Future<?>> futures = new ArrayList<>();
                int counter = 0;
                Context.setUserContext(userContext);
                Context.openSessionWithCurrentUser();
                for (String patientId : patients) {
                    counter++;

                    int finalCounter = counter;
                    Thread thread = new Thread(() -> {
                        try {
                            NDRExtractor ndrExtractor = new NDRExtractor(patientId, DATIMID, ndrExport.getReportFolder(),
                                    finalCounter, userContext, formattedDate, jaxbContext, ndrExport.getLastDate(), ndrExport.getDateStarted(), ndrExport.getId());
                            ndrExtractor.extract();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    thread.setName("fileName#" + ndrExport.getId());
                    futures.add(pool.submit(thread));
                }
                while (futures.size() > 0) {
                    futures.removeIf(Future::isDone);
                    int processed = patients.size() - futures.size();
                    if (patients.size() == processed) {
                        nigeriaemrService.updateStatus(ndrExport.getId(), "Done");
                    }
                    if(processed > 0) {
                        nigeriaemrService.updateNdrExportItemProcessedCount(ndrExport.getId(), processed);
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                        LoggerUtils.LogLevel.live);
                ndrExport.setDateEnded(new Date());
                ndrExport.setStatus("Failed");
                nigeriaemrService.saveNdrExportItem(ndrExport);
            }
        pool.shutdown();
    }
	
	public String getFileList() {
        List<Map<String, Object>> fileMaps = new ArrayList<>();
        String response = "";

        try {
            List<NDRExport> exports = nigeriaemrService.getExports(false);
            if (exports != null && exports.size() > 0) {
                for (NDRExport ndrExport : exports) {
                    if ("Done".equalsIgnoreCase(ndrExport.getStatus())){
                        ndrExport.setStatus("Processing");
                    }
                    boolean active = !ndrExport.getStatus().equals("Processing");
                    String name = ndrExport.getName() == null ?  "": ndrExport.getName();
                    String owner = ndrExport.getOwner().getName() == null ?  "Admin": ndrExport.getOwner().getName();
                    Map<String, Object> fileMap = new HashMap<>();
                    fileMap.put("owner", owner);
                    fileMap.put("name", name);
                    fileMap.put("dateStarted", sdf.format(ndrExport.getDateStarted()));
                    fileMap.put("total", ndrExport.getPatients());
                    fileMap.put("processed", ndrExport.getPatientsProcessed());
                    fileMap.put("number", ndrExport.getId());
                    fileMap.put("status", ndrExport.getStatus());
                    if(active){
                        if(ndrExport.getPath() != null) {
                            fileMap.put("path", ndrExport.getPath().replace("\\", "\\\\"));
                        }
                        fileMap.put("dateEnded", sdf.format(ndrExport.getDateEnded()));
                        fileMap.put("active", true);
                    }else {
                        if(ndrExport.getPatientsProcessed() != null) {
                            double progress = (ndrExport.getPatientsProcessed().doubleValue() / ndrExport.getPatients().doubleValue() ) * 100;
                            fileMap.put("progress", df.format(progress)  + "%");
                        }else{
                            fileMap.put("progress", "0%");
                        }
                        fileMap.put("active", false);
                        fileMap.put("dateEnded", "");
                    }

                    fileMaps.add(fileMap);
                }
            }
            response = mapper.writeValueAsString(fileMaps);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
	
	public boolean deleteFile(HttpServletRequest request, String id) {
		try {
			int idInt = Integer.parseInt(id);
			NDRExport ndrExport = nigeriaemrService.getNDRExportById(idInt);
			if (ndrExport.getPath() != null) {
				String path = ndrExport.getPath();
				if (path != null) {
					String[] paths = path.split("\\\\");
					if (path.length() > 0) {
						String fileName = paths[4];
						String folder = Paths.get(
						    new File(request.getSession().getServletContext().getRealPath(request.getContextPath()))
						            .getParentFile().toString(), "downloads", "NDR", fileName).toString();
						File fileToDelete = new File(folder);
						if (fileToDelete.exists()) {
							fileToDelete.delete();
						}
					}
				}
				String reportFolder = ndrExport.getReportFolder();
				if (reportFolder != null) {
					FileUtils.deleteFolder(reportFolder, true);
				}
			}
			nigeriaemrService.voidExportEntry(idInt);
			return true;
		}
		catch (Exception ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

    public void process(){
        Context.setUserContext(this.userContext);
        Context.openSessionWithCurrentUser();

        List<NDRExportBatch> ndrExportBatches = nigeriaemrService.getExportBatchByStatus("Processing");
        if(ndrExportBatches.size() == 0){
            List<NDRExportBatch> ndrNewExportBatches = nigeriaemrService.getExportBatchByStatus("New");
            if(ndrNewExportBatches.size()>0) {
                NDRExportBatch ndrExportBatch = ndrNewExportBatches.get(0);
                Map<String, Object> condition = new HashMap<>();
                condition.put("status", "Done");
                condition.put("batchId", ndrExportBatch.getId());
                List<NDRExport> exports = nigeriaemrService.getExports(condition, false);
                nigeriaemrService.updateExportBatch(ndrExportBatch.getId(),"processing");
                queue.addAll(exports);
            }
        }
    }
}
