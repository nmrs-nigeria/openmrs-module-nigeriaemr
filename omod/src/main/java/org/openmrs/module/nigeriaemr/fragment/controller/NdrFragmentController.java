package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.Consumer;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaPatientService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.model.ndrMessageLog;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRApiUtils;
import org.openmrs.module.nigeriaemr.omodmodels.*;
import org.openmrs.module.nigeriaemr.service.FacilityLocationService;
import org.openmrs.module.nigeriaemr.service.NdrExtractionService;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NdrFragmentController {
	
	NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);
	
	NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
	
	DBConnection openmrsConn;
	
	FacilityLocationService facilityLocationService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	NdrExtractionService ndrExtractionService;
	
	JAXBContext jaxbContext;
	
	public NdrFragmentController() throws Exception {
		jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
		ndrExtractionService = new NdrExtractionService(jaxbContext, false);
		openmrsConn = Utils.getNmrsConnectionDetails();
		facilityLocationService = new FacilityLocationService();
	}
	
	public void controller() {
	}
	
	public String generateNDRFileByLocation(HttpServletRequest request,
	        @RequestParam(value = "locationId") Integer locationId, @RequestParam(value = "opt") String opt)
	        throws Exception {
		// get date that's bounds to the date the export is kicked off
		Date currentDate = new Date();
		
		FacilityLocation facilityLocation = facilityLocationService.getFacilityLocationByLocationId(locationId).get(0);
		List<Integer> filteredPatientByLocation = facilityLocationService.getPatientLocationById(locationId);
		
		//check if global variable for logging exists
		LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
		LoggerUtils.clearLogFile();
		
		String FacilityType = "FAC";
		
		if (filteredPatientByLocation.size() == 0)
			return "";
		
		return startGenerateFile(request, filteredPatientByLocation, facilityLocation.getDatimCode(), null, currentDate,
		    true, opt);
	}
	
	public String generateCustomNDRFile(HttpServletRequest request,
										@RequestParam(value = "identifiers", required = false) String identifiers,
										@RequestParam(value = "to", required = false) String to,
										@RequestParam(value = "from", required = false) String from, @RequestParam(value = "opt") String opt) throws Exception {
		try {
			// get date that's bounds to the date the export is kicked off
			Date lastDate = null;
			if (from != null && !from.isEmpty()) {
				lastDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
			}
			Date currentDate = null;
			if (to != null && !to.isEmpty()) {
				currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);
			}
			currentDate = Utils.getLastNDRDate();

			List<Integer> patients = new ArrayList<>();
			if (identifiers != null && !identifiers.isEmpty()) {
				String[] ary = identifiers.split(",");
				if (ary.length > 0) {
					List<String> identifierList = new ArrayList<>(Arrays.asList(ary));
					List<Integer> patientIdsFromIdentifiers = nigeriaPatientService.getPatientIdsByIdentifiers(identifierList, null, null);
					identifierList.addAll(patientIdsFromIdentifiers.stream().map(String::valueOf).collect(Collectors.toList()));
					List<Integer> patientIds = ndrExtractionService.getPatientIds(lastDate, currentDate, identifierList, true);
					Set<Integer> set = new HashSet<>(patientIds);
					patients = new ArrayList<>(set);
				}
			} else {
				List<Integer> patientIds = ndrExtractionService.getPatientIds(lastDate, currentDate, null, true);
				if (patientIds != null && patientIds.size() > 0) patients.addAll(patientIds);
			}

			DBConnection openmrsConn = Utils.getNmrsConnectionDetails();

			//check if global variable for logging exists
			LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
			LoggerUtils.clearLogFile();
			LoggerUtils.checkPatientLimitGlobalProperty(openmrsConn);

			String DATIMID = Utils.getFacilityDATIMId();
			return startGenerateFile(request, patients, DATIMID, lastDate, currentDate, false, opt);
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}
	
	public String generateNDRFile(HttpServletRequest request, @RequestParam(value = "opt") String opt) throws Exception {
		// get date that's bounds to the date the export is kicked off
		Date currentDate = new Date();
		DBConnection openmrsConn = Utils.getNmrsConnectionDetails();
		//check if global variable for logging exists
		LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
		LoggerUtils.clearLogFile();
		LoggerUtils.checkPatientLimitGlobalProperty(openmrsConn);
		Date lastDate = Utils.getLastNDRDate();
		List<Integer> patients = ndrExtractionService.getPatientIds(lastDate, currentDate, null, true);
		String DATIMID = Utils.getFacilityDATIMId();
		System.out.println("Current Date: " + currentDate);
		System.out.println("Last Run Date: " + lastDate);
		return startGenerateFile(request, patients, DATIMID, lastDate, currentDate, true, opt);
	}
	
	private String startGenerateFile(HttpServletRequest request, List<Integer> filteredPatients,
									 String DATIMID, Date lastDate, Date currentDate, boolean updateNdrLastRun, String opt) throws Exception {

		// Check that no export is in progress
		Map<String, Object> condition = new HashMap<>();
		condition.put("status", "Processing");
		System.out.println("Before getExport(): ");
		List<NDRExport> exports = nigeriaemrService.getExports(condition, 1, false);
		System.out.println("Export Size: " + exports.size());
		System.out.println("Export: " + exports);
		if (exports.size() > 0) return "You already have an export in process, Kindly wait for it to finish";
		System.out.println("filteredPatients Size: " + filteredPatients.size());
		if (filteredPatients == null || filteredPatients.size() <= 0) return "no new patient record found";
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		System.out.println("fullContextPath: " + fullContextPath);
		UserContext userContext = Context.getUserContext();

		Thread thread = new Thread(() ->
		{
			try {
				Consumer.initialize(userContext, opt);
				
				ndrExtractionService.saveExport(fullContextPath, contextPath, filteredPatients, DATIMID, lastDate, currentDate, updateNdrLastRun, opt);
			} catch (Exception e) {
				LoggerUtils.write(NdrFragmentController.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
						LoggerUtils.LogLevel.live);
			}
		});
		thread.start();
		if (updateNdrLastRun) Utils.updateLast_NDR_Run_Date(new Date());
		return "Export is being processed";
	}
	
	public String getAllFacilityLocation() {
		String response = "";
		try {
			response = mapper.writeValueAsString(facilityLocationService.getAllFacilityLocations());
		}
		catch (JsonProcessingException ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return response;
	}
	
	public String getFileList() throws IOException {
		return ndrExtractionService.getFileList(true);
	}
	
	public String getManualFileList() throws IOException {
		return ndrExtractionService.getFileList(false);
	}
	
	public boolean deleteFile(HttpServletRequest request, @RequestParam(value = "id") String id) {
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		return ndrExtractionService.deleteFile(fullContextPath, id);
	}
	
	public boolean restartFile(HttpServletRequest request, @RequestParam(value = "id") String id,
	        @RequestParam(value = "action") String action) {
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		String finalAction = action == null || action.isEmpty() ? "restart" : action;
		return ndrExtractionService.restartFile(fullContextPath, id, finalAction);
	}
	
	public boolean resumeFile(HttpServletRequest request, @RequestParam(value = "id") String id) {
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		return ndrExtractionService.restartFile(fullContextPath, id, "resume");
	}
	
	public void pauseFile(HttpServletRequest request, @RequestParam(value = "id") String id) {
		ndrExtractionService.pauseFile(id);
	}
	
	//get host for openmrs instance
	public String retrieveBiometricServer(String msg) {
		System.out.println("This is from the UI: " + msg);
		return Utils.getBiometricServer();
	}
	
	public String createFacilityLocation(@RequestParam(value = "falicityLocationString") String falicityLocationString) {
		int response = 0;
		
		try {
			FacilityLocation facilityLocation = mapper.readValue(falicityLocationString, FacilityLocation.class);
			facilityLocation.setCreator(Context.getAuthenticatedUser().toString());
			response = facilityLocationService.createFacilityLocation(facilityLocation);
			
		}
		catch (IOException ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
			return "Error occurred, try again";
		}
		
		if (response != -1) {
			return "Successfully created facility location";
		}
		
		return "Error occurred, try again";
		
	}
	
	public String editFacilityLocation(@RequestParam(value = "facilityLocationString") String facilityLocationString) {
		int response = 0;
		try {
			FacilityLocation facilityLocation = mapper.readValue(facilityLocationString, FacilityLocation.class);
			response = facilityLocationService.editFacilityLocation(facilityLocation);
		}
		catch (Exception ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		if (response > 0) {
			return "Successfully updated facility location";
		}
		
		return "Error occurred, try again";
	}
	
	public void deleteFacilityLocation(@RequestParam(value = "facilityLocationUUID") String facilityLocationUUID) {
		try {
			facilityLocationService.deleteFacilityLocation(facilityLocationUUID);
			
		}
		catch (Exception ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public String getAllLocation() {
		List<LocationModel> locationModels = new ArrayList<>();
		String locationString = "";

		try {

			Context.getLocationService().getAllLocations().stream().forEach(a -> {
				locationModels.add(new LocationModel(a.getName(), a.getLocationId()));
			});

			locationString = mapper.writeValueAsString(locationModels);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}

		return locationString;
	}
	
	public String getPatientLocationAggregate() {
		String responseString = "";
		
		try {
			responseString = mapper.writeValueAsString(facilityLocationService.getPatientLocationAggregate());
		}
		catch (JsonProcessingException ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return responseString;
	}
	
	public String getVersionNumber(HttpServletRequest request) {
		Version version = null;
		String response = "";
		try {
			version = Utils.getNmrsVersion();
			response = mapper.writeValueAsString(version);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public NDRApiResponse auth(HttpServletRequest request, @RequestParam(value = "email", required = true) String email,
	        @RequestParam(value = "password", required = true) String password) throws Exception {
		NDRApiResponse apiRes = new NDRApiResponse();
		try {
			if (email == null || email.isEmpty()) {
				apiRes.message = "The email address is empty";
			}
			if (password == null || password.isEmpty()) {
				apiRes.message = "The Password address is empty";
			}
			NDRApiUtils ndrApiUtils = new NDRApiUtils();
			apiRes = ndrApiUtils.auth(email, password);
			return apiRes;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			apiRes.code = -1;
			apiRes.message = ex.getMessage();
			return apiRes;
		}
	}
	
	public NDRApiResponse reAuth(HttpServletRequest request) throws Exception {
		NDRApiResponse apiRes = new NDRApiResponse();
		try {
			NDRApiUtils ndrApiUtils = new NDRApiUtils();
			apiRes = ndrApiUtils.auth(null, null);
			return apiRes;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			apiRes.code = -1;
			apiRes.message = ex.getMessage();
			return apiRes;
		}
	}
	
	public NDRApiResponse checkAuth(HttpServletRequest request) {
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		NDRApiResponse apiRes = ndrApiUtils.checkAuth();
		return apiRes;
	}
	
	public NDRApiHandshakeSummary pushData(HttpServletRequest request) {
		//Henry: This is needfully done here so that the folder can be retrieved for enumerating the files
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		String downloadFolder = Utils.getDownloadFolder(fullContextPath);
		String reportFolder = Paths.get(downloadFolder, "NDR").toString();
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		NDRApiHandshakeSummary summary = ndrApiUtils.pushData(reportFolder);
		return summary;
	}
	
	public NDRApiHandshakeSummary pushBatchData(HttpServletRequest request) {
		//Henry: This is needfully done here so that the folder can be retrieved for enumerating the files
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		String downloadFolder = Utils.getDownloadFolder(fullContextPath);
		String reportFolder = Paths.get(downloadFolder, "NDR").toString();
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		NDRApiHandshakeSummary summary = ndrApiUtils.pushBatchData(reportFolder);
		return summary;
	}
	
	public Integer getLogs(HttpServletRequest request) {
		System.out.println("\nGet NDR Error Logs called!!!!\n");
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		Integer logSize = ndrApiUtils.getErrorLogs();
		return logSize;
	}
	
	public Integer checkApiExportsWithPendingNdrErrorLogs(HttpServletRequest request) {
		List<NDRExportBatch> ndrExportBatches = nigeriaemrService.getBatchExports();
		return ndrExportBatches.size();
	}
	
	public String getTotalFiles(HttpServletRequest request) {
		//Henry: This is needfully done here so that the folder can be retrieved for enumerating the files
		String contextPath = request.getContextPath();
		String fullContextPath = request.getSession().getServletContext().getRealPath(contextPath);
		String downloadFolder = Utils.getDownloadFolder(fullContextPath);
		String reportFolder = Paths.get(downloadFolder, "NDR").toString();
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		String res = ndrApiUtils.getTotalFiles(reportFolder, contextPath);
		return res;
	}
	
	public void saveNDRBatchIds(HttpServletRequest request, @RequestParam(value = "batchIds") String batchIds,
	        @RequestParam(value = "exportId") Integer exportId) {
		NDRApiUtils ndrApiUtils = new NDRApiUtils();
		ndrApiUtils.saveNDRBatchIds(batchIds, exportId);
		return;
	}
	
	public List<ndrMessageLog> viewErrorLogs(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
		return nigeriaemrService.getNdrMessageLogs(id);
	}
}
