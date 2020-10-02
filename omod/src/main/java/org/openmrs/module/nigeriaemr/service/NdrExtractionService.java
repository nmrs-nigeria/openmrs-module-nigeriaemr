package org.openmrs.module.nigeriaemr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.ServiceContext;
import org.openmrs.module.nigeriaemr.NDREvent;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.DatimMap;
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
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NdrExtractionService {
	
	ObjectMapper mapper = new ObjectMapper();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	static DecimalFormat df = new DecimalFormat("#.##");
	
	JAXBContext jaxbContext;
	
	NDRExtractor ndrExtractor;
	
	public NdrExtractionService(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
		ndrExtractor = new NDRExtractor();
		Context.openSession();
		Context.setUserContext(Context.getUserContext());
		Context.openSessionWithCurrentUser();
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege(NigeriaemrConfig.MODULE_PRIVILEGE);
		Context.addProxyPrivilege("Get Patients");
		Context.addProxyPrivilege("Get Observations");
		Context.addProxyPrivilege("Get Encounters");
		Context.addProxyPrivilege("Get Concepts");
		
	}
	
	public NdrExtractionService() throws Exception {
		this.jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
		this.ndrExtractor = new NDRExtractor();
	}
	
	public void saveExport(String fullContextPath, String contextPath, List<Integer> filteredPatients, String DATIMID,
	        Date lastDate, Date currentDate) throws Exception {
		
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		int patientSize = filteredPatients.size();
		int batch = Utils.getBatchSize();
		
		List<List<Integer>> partitions = Partition.ofSize(filteredPatients, batch);
		String reportType = "NDR";
		String reportFolder = Utils.ensureReportFolderExist(fullContextPath, reportType);
		String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(currentDate);
		String IPReportingState;
		String IPReportingLgaCode;
		Optional<DatimMap> datimMap = Optional.ofNullable(nigeriaemrService.getDatatimMapByDataimId(DATIMID));
		if (datimMap.isPresent()) {
			IPReportingState = datimMap.get().getStateCode().toString();
			IPReportingLgaCode = datimMap.get().getLgaCode().toString();
		} else {
			IPReportingState = Utils.getIPReportingState();
			IPReportingLgaCode = Utils.getIPReportingLgaCode();
		}
		
		NDRExportBatch ndrExportBatch = new NDRExportBatch();
		ndrExportBatch.setDateCreated(new Date());
		ndrExportBatch.setDateUpdated(new Date());
		ndrExportBatch.setLastExportDate(lastDate);
		ndrExportBatch.setStatus("Processing");
		ndrExportBatch.setPatients(patientSize);
		ndrExportBatch.setOwner(Context.getAuthenticatedUser());
		ndrExportBatch.setReportFolder(reportFolder);
		ndrExportBatch.setContextPath(contextPath);
		String name = IPReportingState + "_" + IPReportingLgaCode + "_" + DATIMID + formattedDate;
		ndrExportBatch.setName(name);
		nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch);
		for (List<Integer> patients : partitions) {
			String fileName = IPReportingState + "_" + IPReportingLgaCode + "_" + DATIMID + "_{pepFarId}_" + formattedDate;
			// Start export process
			NDRExport ndrExport = new NDRExport();
			ndrExport.setDateStarted(currentDate);
			ndrExport.setPatients(patients.size());
			ndrExport.setOwner(Context.getAuthenticatedUser());
			ndrExport.setName(fileName);
			ndrExport.setVoided(false);
			ndrExport.setStatus("Processing");
			ndrExport.setLastDate(lastDate);
			ndrExport.setContextPath(contextPath);
			ndrExport.setReportFolder(reportFolder);
			ndrExport.setBatchId(ndrExportBatch.getId());
			try {
				ndrExport.setPatientsList(new ObjectMapper().writeValueAsString(patients));
			}
			catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new Exception("Error Processing Export");
			}
			NDREvent ndrEvent = (NDREvent) ServiceContext.getInstance().getApplicationContext().getBean("ndrEvent");
			NDRExport ndrExport1 = nigeriaemrService.saveNdrExportItem(ndrExport);
			ndrEvent.send(ndrExport1);
		}
	}
	
	public void export(NDRExport ndrExport) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		//check if batch is still valid
		NDRExportBatch ndrExportBatch = nigeriaemrService.getNDRExportBatchById(ndrExport.getBatchId());
		if (ndrExportBatch == null || !ndrExportBatch.getStatus().equalsIgnoreCase("Processing")) {
			LoggerUtils.write(NdrExtractionService.class.getName(), "skipping", LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			return;
		}
		Context.evictFromSession(ndrExportBatch);
		
		try {
			String DATIMID = Utils.getFacilityDATIMId();
			String formattedDate = new SimpleDateFormat("ddMMyy").format(ndrExport.getDateStarted());
			String patientList = ndrExport.getPatientsList();
			List<Integer> patients = (List<Integer>) mapper.readValue(patientList, List.class);
			for (Integer patientId : patients) {
				long startTime = System.currentTimeMillis();
				
				ndrExtractor.extract(patientId, DATIMID, ndrExport.getReportFolder(), formattedDate, jaxbContext,
				    ndrExport.getLastDate(), ndrExport.getDateStarted(), ndrExportBatch.getId());
				
				long endTime = System.currentTimeMillis();
				LoggerUtils.write(NdrExtractionService.class.getName(), patientId + "  " + (endTime - startTime)
				        + " milli secs : ", LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
				
			}
			nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), "Done", true);
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrExtractionService.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), "Failed", true);
		}
	}
	
	public String getFileList() {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
        List<Map<String, Object>> fileMaps = new ArrayList<>();
        String response = "";

        try {
            List<NDRExportBatch> ndrExportBatches  = nigeriaemrService.getExportBatchByStatus(null, false);
            if (ndrExportBatches != null && ndrExportBatches.size() > 0) {
                for (NDRExportBatch ndrExportBatch : ndrExportBatches) {
                    if ("Done".equalsIgnoreCase(ndrExportBatch.getStatus())){
						ndrExportBatch.setStatus("Processing");
                    }
                    boolean active = !ndrExportBatch.getStatus().equalsIgnoreCase("Processing");
					Map<String, Object> fileMap = new HashMap<>();
                    if(ndrExportBatch.getOwner() != null){
						String owner = ndrExportBatch.getOwner().getName() == null ?  "Admin": ndrExportBatch.getOwner().getName();
						fileMap.put("owner", owner);
					}else {
						fileMap.put("owner", "unknown");
					}

                    fileMap.put("name", ndrExportBatch.getName());
                    fileMap.put("dateStarted", sdf.format(ndrExportBatch.getDateStarted()));
                    fileMap.put("total", ndrExportBatch.getPatients());
                    fileMap.put("processed", ndrExportBatch.getPatientsProcessed());
                    fileMap.put("number", ndrExportBatch.getId());
                    fileMap.put("status", ndrExportBatch.getStatus());
                    if(active){
                        if(ndrExportBatch.getPath() != null) {
                            fileMap.put("path", ndrExportBatch.getPath().replace("\\", "\\\\"));
                        }
						fileMap.put("hasError",false);
						if(ndrExportBatch.getErrorPath() != null) {
							fileMap.put("hasError",true);
							fileMap.put("errorPath", ndrExportBatch.getErrorPath().replace("\\", "\\\\"));
							if(ndrExportBatch.getErrorList() != null) {
								fileMap.put("errorList", ndrExportBatch.getErrorList().replace("\\", "\\\\"));
							}
						}
                        fileMap.put("dateEnded", sdf.format(ndrExportBatch.getDateEnded()));
                        fileMap.put("active", true);
                    }else {
                        if(ndrExportBatch.getPatientsProcessed() != null) {
                            double progress = (ndrExportBatch.getPatientsProcessed().doubleValue() / ndrExportBatch.getPatients().doubleValue() ) * 100;
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
            Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
	
	public boolean deleteFile(String fullContextPath, String id) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		try {
			int idInt = Integer.parseInt(id);
			NDRExportBatch ndrExportBatch = nigeriaemrService.getNDRExportBatchById(idInt);
			deletePath(fullContextPath, ndrExportBatch.getPath());
			deletePath(fullContextPath, ndrExportBatch.getErrorPath());
			deletePath(fullContextPath, ndrExportBatch.getErrorList());
			deleteFolder(ndrExportBatch.getReportFolder());
			deleteFolder(ndrExportBatch.getReportFolder() + File.separator + "error");
			nigeriaemrService.voidExportBatchEntry(idInt);
			nigeriaemrService.deleteExports(idInt);
			return true;
			
		}
		catch (Exception ex) {
			Logger.getLogger(NdrExtractionService.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	private void deleteFolder(String reportFolder) {
		if (reportFolder != null) {
			FileUtils.deleteFolder(reportFolder, true);
		}
	}
	
	private void deletePath(String fullContextPath, String path) {
		if (path != null) {
			String[] paths = path.split("\\\\");
			if (path.length() > 0) {
				String fileName = paths[4];
				String folder = Paths
				        .get(new File(fullContextPath).getParentFile().toString(), "downloads", "NDR", fileName).toString();
				File fileToDelete = new File(folder);
				if (fileToDelete.exists()) {
					fileToDelete.delete();
				}
			}
		}
	}
	
	public void pauseFile(String id) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		if (id != null) {
			int idInt = Integer.parseInt(id);
			nigeriaemrService.updateExportBatch(idInt, "Paused", false);
		} else {
			nigeriaemrService.updateAllStatus("Paused");
		}
	}
	
	public boolean restartFile(String fullContextPath,String id, String action) {
		try {
			int idInt = Integer.parseInt(id);
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			NDREvent ndrEvent = (NDREvent) ServiceContext.getInstance().getApplicationContext().getBean("ndrEvent");
			nigeriaemrService.updateExportBatch(idInt, "Processing", false);
			List<NDRExport> ndrExports;
			if("resume".equalsIgnoreCase(action)) {
				 ndrExports = nigeriaemrService.getNDRExportByBatchIdByStatus(idInt, "Processing");
			}else if("failed".equalsIgnoreCase(action)) {
				Map<String, Object> conditions = new HashMap<>();
				conditions.put("batchId", idInt);
				conditions.put("status", "Failed");
				ndrExports = nigeriaemrService.getExports(conditions, null, false);
			}else {
				nigeriaemrService.resetExportBatch(idInt);
				Map<String, Object> conditions = new HashMap<>();
				conditions.put("batchId", idInt);
				nigeriaemrService.updateStatus(0,idInt,"Processing", false);
				ndrExports = nigeriaemrService.getExports(conditions, null, false);

			}
			boolean deleted = false;
			for (NDRExport ndrExport : ndrExports) {
				if("failed".equalsIgnoreCase(action)){
					nigeriaemrService.updateStatus(ndrExport.getId(),idInt,"Processing", false);
				}
				if(!deleted && !"resume".equalsIgnoreCase(action)) {
					NDRExportBatch ndrExportBatch = nigeriaemrService.getNDRExportBatchById(idInt);
					if (!"failed".equalsIgnoreCase(action)) {
						deleteFolder(ndrExportBatch.getReportFolder());
						deletePath(fullContextPath, ndrExportBatch.getPath());
					}
					deletePath(fullContextPath, ndrExportBatch.getErrorPath());
					deletePath(fullContextPath, ndrExportBatch.getErrorList());
					deleteFolder(ndrExportBatch.getReportFolder() + File.separator + "error");
					deleted = true;
				}
				ndrEvent.send(ndrExport);
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
