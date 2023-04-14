package org.openmrs.module.nigeriaemr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.ServiceContext;
import org.openmrs.module.nigeriaemr.NDREvent;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.DatimMap;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.omodmodels.FacilityLocation;
import org.openmrs.module.nigeriaemr.page.controller.CustomNdrPageController;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.openmrs.module.nigeriaemr.util.Partition;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import java.io.*;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NdrExtractionService {
	
	ObjectMapper mapper = new ObjectMapper();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	static DecimalFormat df = new DecimalFormat("#.##");
	
	JAXBContext jaxbContext;
	
	NDRExtractor ndrExtractor;
	
	@Autowired
	org.openmrs.module.nigeriaemr.SocketServer socketServer;
	
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
	
	public NdrExtractionService(JAXBContext jaxbContext, boolean b) throws Exception {
		this.jaxbContext = jaxbContext;
		this.ndrExtractor = new NDRExtractor();
	}
	
	public Integer saveExport(String fullContextPath, String contextPath, List<Integer> filteredPatients, String DATIMID,
	        Date lastDate, Date currentDate, boolean automatic, String opt) throws Exception {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		int patientSize = filteredPatients.size();
		int batch = Utils.getBatchSize();
		
		List<List<Integer>> partitions = Partition.ofSize(filteredPatients, batch);
		String reportType = "NDR";
		String reportFolder = Utils.ensureReportFolderExist(fullContextPath, reportType);
		String formattedDate;
		if (currentDate == null) {
			formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
		} else {
			formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(currentDate);
		}
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
		if (lastDate == null)
			ndrExportBatch.setLastExportDate(new Date());
		ndrExportBatch.setStatus("Processing");
		ndrExportBatch.setPatients(patientSize);
		ndrExportBatch.setOwner(Context.getAuthenticatedUser());
		ndrExportBatch.setReportFolder(reportFolder);
		ndrExportBatch.setContextPath(contextPath);
		ndrExportBatch.setAutomatic(automatic);
		
		ndrExportBatch.setDateStarted(new Date());
		ndrExportBatch.setDateEnded(new Date());
		
		String name = IPReportingState + "_" + IPReportingLgaCode + "_" + DATIMID + formattedDate;
		name = name.replaceAll("/", "_");
		
		ndrExportBatch.setName(name);
		nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch, false);
		for (List<Integer> patients : partitions) {
			String fileName = IPReportingState + "_" + IPReportingLgaCode + "_" + DATIMID + "_{pepFarId}_" + formattedDate;
			fileName = fileName.replaceAll("/", "_");
			// Start export process
			NDRExport ndrExport = new NDRExport();
			ndrExport.setDateStarted(currentDate);
			//			if (currentDate == null) ndrExport.setDateStarted(new Date());
			ndrExport.setPatients(1);
			ndrExport.setOwner(Context.getAuthenticatedUser());
			ndrExport.setName(fileName);
			ndrExport.setVoided(false);
			ndrExport.setStatus("Processing");
			ndrExport.setLastDate(lastDate);
			ndrExport.setContextPath(contextPath);
			ndrExport.setReportFolder(reportFolder);
			ndrExport.setBatchId(ndrExportBatch.getId());
			ndrExport.setDateEnded(new Date());
			ndrExport.setDateUpdated(new Date());
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
		
		return ndrExportBatch.getId();
	}
	
	public void export(NDRExport ndrExport, String opt) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		//check if batch is still valid
		NDRExportBatch ndrExportBatch = nigeriaemrService.getNDRExportBatchById(ndrExport.getBatchId());
		if (ndrExportBatch == null
		        || (!ndrExportBatch.getStatus().equalsIgnoreCase("Processing") && !ndrExportBatch.getStatus()
		                .equalsIgnoreCase("Restarted"))) {
			LoggerUtils.write(NdrExtractionService.class.getName(), "skipping", LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			Context.evictFromSession(ndrExportBatch);
			return;
		}
		Context.evictFromSession(ndrExportBatch);
		try {
			String formattedDate = null;
			String DATIMID = Utils.getFacilityDATIMId();
			if (ndrExport.getDateStarted() != null) {
				formattedDate = new SimpleDateFormat("ddMMyy").format(ndrExport.getDateStarted());
			} else {
				formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());
			}
			
			List<Integer> patients;
			if (ndrExport.getErrorPatientsList() != null && !ndrExport.getErrorPatientsList().isEmpty()) {
				String patientList = ndrExport.getErrorPatientsList();
				patients = (List<Integer>) mapper.readValue(patientList, List.class);
			} else {
				String patientList = ndrExport.getPatientsList();
				patients = (List<Integer>) mapper.readValue(patientList, List.class);
			}
			
			String status = "Done";
			for (Integer patientId : patients) {
				try {
					long startTime = System.currentTimeMillis();
					
					ndrExtractor.extract(patientId, DATIMID, ndrExport.getReportFolder(), formattedDate, jaxbContext,
					    ndrExport.getLastDate(), ndrExport.getDateStarted(), ndrExportBatch.getId(), opt);
					
					long endTime = System.currentTimeMillis();
					LoggerUtils.write(NdrExtractionService.class.getName(), patientId + "  " + (endTime - startTime)
					        + " milli secs : ", LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
				}
				catch (Exception ex) {
					//					nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), "Failed", true);
					status = "Failed";
				}
				
			}
			nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), status, true);
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrExtractionService.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), "Failed", true);
		}
	}
	
	public String getFileList(boolean auto) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		List<Map<String, Object>> fileMaps = new ArrayList<>();
		String response = "";

		try
		{
			List<NDRExportBatch> ndrExportBatches  = nigeriaemrService.getExportBatchByStartMode(auto, false);

			if (ndrExportBatches != null && ndrExportBatches.size() > 0)
			{
				for (NDRExportBatch ndrExportBatch : ndrExportBatches)
				{
					if ("Done".equalsIgnoreCase(ndrExportBatch.getStatus()) || "Restarted".equalsIgnoreCase(ndrExportBatch.getStatus()))
					{
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
					fileMap.put("ndrBatchIds", ndrExportBatch.getNdrBatchIds());
					fileMap.put("status", ndrExportBatch.getStatus());
					fileMap.put("errorLogsPulled", ndrExportBatch.getErrorLogsPulled());

					if(active)
					{
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
		} catch (JsonProcessingException ex)
		{
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
			if (paths.length > 3) {
				String fileName = paths[4];
				String folder = Paths
				        .get(new File(fullContextPath).getParentFile().toString(), "downloads", "NDR", fileName).toString();
				File fileToDelete = new File(folder);
				if (fileToDelete.exists()) {
					boolean d = fileToDelete.delete();
					if (!d)
						if (fileToDelete.exists()) {
							fileToDelete.deleteOnExit();
						}
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
		Context.getAdministrationService().updateGlobalProperty("check_batch","false");
		try {
			int idInt = Integer.parseInt(id);
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			NDREvent ndrEvent = (NDREvent) ServiceContext.getInstance().getApplicationContext().getBean("ndrEvent");
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
			boolean updateBatch = false;
			NDRExportBatch ndrExportBatch = nigeriaemrService.getNDRExportBatchById(idInt);
			//read failed file
			List<Integer> failedIds = new ArrayList<>();
			File dir = new File(ndrExportBatch.getReportFolder());
			String errorList = Paths.get(dir.getParent(), ndrExportBatch.getId()+"_error_list.csv").toString();
			File csvFile = new File(errorList);
			if (csvFile.exists()) {
				try {
					Reader in = new FileReader(errorList);
					Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
					for (CSVRecord csvRecord : records) {
						failedIds.add(Integer.parseInt(csvRecord.get(1)));
					}
					in.close();
				}catch (Exception ignored){}
			}
			for (NDRExport ndrExport : ndrExports) {
				Context.evictFromSession(ndrExport);
				if(!deleted && !"resume".equalsIgnoreCase(action)) {
					if (!"failed".equalsIgnoreCase(action)) {
						deleteFolder(ndrExportBatch.getReportFolder());
						deletePath(fullContextPath, ndrExportBatch.getPath());
						deleteFolder(ndrExportBatch.getReportFolder() +"-error");
					}
					deletePath(fullContextPath, ndrExportBatch.getErrorPath());
					deletePath(fullContextPath, ndrExportBatch.getErrorList());
					deleteFolder(ndrExportBatch.getReportFolder() + "-error");
					deleted = true;
				}

				List<Integer> ids = (List<Integer>) mapper.readValue(ndrExport.getPatientsList(), List.class);
				List<Integer> result;
				if(failedIds.size() > 0) {
					result = failedIds.stream().distinct().filter(ids::contains).collect(Collectors.toList());
				}else {
					result = ids;
				}

				try {
					ndrExport.setErrorPatientsList(new ObjectMapper().writeValueAsString(result));
				}
				catch (JsonProcessingException e) {
					e.printStackTrace();
					throw new Exception("Error Processing Export");
				}

				nigeriaemrService.updateStatus(ndrExport.getId(), ndrExport.getBatchId(), "Processing", false);
				if(!updateBatch){
					nigeriaemrService.updateExportBatch(idInt, "Restarted", false);
					updateBatch = true;
				}
				ndrEvent.send(ndrExport);
			}
			Context.getAdministrationService().updateGlobalProperty("check_batch","true");
			return true;
		}
		catch (Exception e) {
			Context.getAdministrationService().updateGlobalProperty("check_batch","true");
			return false;
		}
	}
	
	public void checkIfExportIsComplete() {
		String checkBatch = Context.getAdministrationService().getGlobalProperty("check_batch");
		if ("true".equalsIgnoreCase(checkBatch)) {
			NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
			try {
				List<NDRExportBatch> ndrExportBatches = nigeriaemrService.getExportBatchByStatus("Done", false);
				for (NDRExportBatch ndrExportBatch : ndrExportBatches) {
					String IPReportingState = Utils.getIPReportingState();
					String IPReportingLgaCode = Utils.getIPReportingLgaCode();
					String DATIMID = Utils.getFacilityDATIMId();
					String formattedDate;
					if (ndrExportBatch.getDateStarted() != null) {
						formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(ndrExportBatch.getDateStarted());
					} else {
						formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
					}
					String fileName = IPReportingState + IPReportingLgaCode + "_" + DATIMID + "_" + formattedDate;
					fileName = fileName.replaceAll("/", "_");
					String zipFileName = fileName + ".zip";
					String errorZipFileName = fileName + "_error" + ".zip";
					String path = Utils.ZipFolder(ndrExportBatch.getContextPath(), ndrExportBatch.getReportFolder(),
					    zipFileName, "NDR");
					File dir = new File(ndrExportBatch.getReportFolder());
					String errorReportFolder = ndrExportBatch.getReportFolder() + "-error";
					String errorPath = Utils.ZipFolder(ndrExportBatch.getContextPath(), dir.getParent(), errorReportFolder,
					    errorZipFileName, "NDR");
					String csvFile = Paths.get(dir.getParent(), ndrExportBatch.getId() + "_error_list.csv").toString();
					String errorList = Paths.get(ndrExportBatch.getContextPath(), "downloads", "NDR",
					    ndrExportBatch.getId() + "_error_list.csv").toString();
					int numError = getNumberOfPatientsWithError(csvFile);
					String status;
					if (!"no new patient record found".equalsIgnoreCase(errorPath)) {
						ndrExportBatch.setPath(path);
						if (numError > 0) {
							ndrExportBatch.setErrorPath(errorPath);
							ndrExportBatch.setErrorList(errorList);
							status = "Completed with " + numError + " Errors";
						} else {
							status = "Completed";
						}
					} else if (!"no new patient record found".equalsIgnoreCase(path)) {
						ndrExportBatch.setPath(path);
						status = "Completed";
					} else {
						status = "Failed";
					}
					ndrExportBatch.setStatus(status);
					nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch, false);
				}
				if (ndrExportBatches.size() > 0) {
					//Notify the Extraction view that extraction is completed
					System.out.println("Data Extraction Completed");
					socketServer.refresh();
				}
			}
			catch (Exception e) {
				LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
				    LoggerUtils.LogLevel.live);
				//ignore error
			}
			
			try {
				List<NDRExportBatch> ndrExportBatchesInProgress = nigeriaemrService.getExportBatchByStatus("Processing",
				    false);
				List<NDRExportBatch> ndrExportBatchesRestarted = nigeriaemrService
				        .getExportBatchByStatus("Restarted", false);
				
				processBatchInProgress(nigeriaemrService, ndrExportBatchesInProgress, false);
				processBatchInProgress(nigeriaemrService, ndrExportBatchesRestarted, true);
			}
			catch (Exception e) {
				LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
				    LoggerUtils.LogLevel.live);
				//ignore error
			}
		}
	}
	
	private void processBatchInProgress(NigeriaemrService nigeriaemrService, List<NDRExportBatch> ndrExportBatchesInProgress,
										boolean restarted) throws IOException {
		if (ndrExportBatchesInProgress != null) {
			for (NDRExportBatch ndrExportBatch : ndrExportBatchesInProgress) {
				Map<String, Object> conditions = new HashMap<>();
				conditions.put("status", "Done");
				conditions.put("batchId", ndrExportBatch.getId());
				List<NDRExport> doneNdrExports = nigeriaemrService.getExports(conditions, null, false);

				conditions.put("status", "Failed");
				conditions.put("batchId", ndrExportBatch.getId());
				List<NDRExport> FailedNdrExports = nigeriaemrService.getExports(conditions, null, false);
				int count = 0;
				for (NDRExport ndrExport : doneNdrExports) {
					String patient = ndrExport.getPatientsList();
					List values = mapper.readValue(patient, List.class);
					count = count + values.size();
				}
				for (NDRExport ndrExport : FailedNdrExports) {
					String patient = ndrExport.getPatientsList();
					List values = mapper.readValue(patient, List.class);
					count = count + values.size();
				}
				if (ndrExportBatch.getPatients().equals(count)) {
					ndrExportBatch.setPatientsProcessed(count);
					ndrExportBatch.setStatus("Done");
					ndrExportBatch.setDateEnded(new Date());
					ndrExportBatch.setDateUpdated(new Date());
					nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch, restarted);
				}else{
					ndrExportBatch.setPatientsProcessed(count);
					ndrExportBatch.setDateUpdated(new Date());
					nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch, restarted);
				}
			}
		}
	}
	
	private int getNumberOfPatientsWithError(String errorList) throws IOException {
		File csvFile = new File(errorList);
		int num = 0;
		if (csvFile.exists()) {
			Reader in = new FileReader(errorList);
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			for (CSVRecord ignored : records) {
				num += 1;
			}
		}
		return num;
	}
	
	public List<Integer> getPatientIds(Date from, Date to, List<String> patientIds, boolean includeVoided) {
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getPatientsByObsDate(from, to, patientIds, includeVoided);
	}
}
