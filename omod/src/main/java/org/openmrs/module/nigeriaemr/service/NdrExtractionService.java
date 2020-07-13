package org.openmrs.module.nigeriaemr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import java.io.File;
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
	
	public void export(HttpServletRequest request, List<Patient> filteredPatients,String facilityName,
                       String DATIMID, String FacilityType,Date lastDate,Date currentDate,JAXBContext jaxbContext) {
        //create report download folder at the server. skip if already exist
        String reportType = "NDR";
        String reportFolder = Utils.ensureReportFolderExist(request, reportType);

        String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(currentDate);
        String fileName =  Utils.getIPShortName() + "_ " + facilityName + "_" + DATIMID + "_" + formattedDate;
        org.openmrs.module.nigeriaemr.model.ndr.FacilityType facility = Utils.createFacilityType(facilityName, DATIMID, FacilityType);
        // Start export process
        NDRExport ndrExport = new NDRExport();
        ndrExport.setDateStarted(currentDate);
        ndrExport.setPatients(filteredPatients.size());
        ndrExport.setOwner(Context.getAuthenticatedUser());
        ndrExport.setName(fileName);
        ndrExport.setVoided(false);
        ndrExport.setStatus("Processing");
        ndrExport.setContextPath(request.getContextPath());
        ndrExport.setReportFolder(reportFolder);
        NDRExport export =  nigeriaemrService.saveNdrExportItem(ndrExport);
        int exportProcessId = export.getId();
        UserContext userContext = Context.getUserContext();
        try {
            Thread thread1 = new Thread(() -> {
                try {
                    List<Future<?>> futures = new ArrayList<>();
                    int counter = 0;
                    Context.setUserContext(userContext);
                    Context.openSessionWithCurrentUser();
                    for (Patient patient : filteredPatients) {
                        counter++;

                        int finalCounter = counter;
                        Thread thread = new Thread(() -> {
                            try {
                                NDRExtractor ndrExtractor = new NDRExtractor(patient.getUuid(), DATIMID, reportFolder, facility,
                                        finalCounter, userContext, formattedDate, jaxbContext, lastDate, currentDate, exportProcessId);
                                ndrExtractor.extract();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                        thread.setName("fileName#" + exportProcessId);
                        futures.add(pool.submit(thread));
                    }
                    while (futures.size() > 0) {
                        futures.removeIf(Future::isDone);
                        int processed = filteredPatients.size() - futures.size();
                        if (filteredPatients.size() == processed) {
                            nigeriaemrService.updateStatus(exportProcessId, "Done");
                        }
                        if(processed > 0) {
                            nigeriaemrService.updateNdrExportItemProcessedCount(exportProcessId, processed);
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
            });
            thread1.start();
        }catch (Exception ex){
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            ndrExport.setDateEnded(new Date());
            ndrExport.setStatus("Failed");
            nigeriaemrService.saveNdrExportItem(ndrExport);
        }
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
}
