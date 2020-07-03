package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.api.service.NigeriaPatientService;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRExtractor;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRUtils;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.omodmodels.FacilityLocation;
import org.openmrs.module.nigeriaemr.omodmodels.LocationModel;
import org.openmrs.module.nigeriaemr.omodmodels.Version;
import org.openmrs.module.nigeriaemr.service.FacilityLocationService;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.openmrs.util.OpenmrsUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class NdrFragmentController {
	
	NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);
	
	DBConnection openmrsConn;
	
	FacilityLocationService facilityLocationService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	ExecutorService pool;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	Marshaller jaxbMarshaller;
	
	public NdrFragmentController() throws Exception {
		openmrsConn = Utils.getNmrsConnectionDetails();
		facilityLocationService = new FacilityLocationService();
		this.jaxbMarshaller = NDRUtils.createMarshaller();
		int numberOfThreads = Integer.parseInt(Utils.getProperty("number_of_ndr_export_threads", 10));
		pool = Executors.newFixedThreadPool(numberOfThreads);
	}
	
	public void controller() {
		
	}
	
	public String generateNDRFileByLocation(HttpServletRequest request,
	        @RequestParam(value = "locationId") Integer locationId) {
		
		FacilityLocation facilityLocation = facilityLocationService.getFacilityLocationByLocationId(locationId).get(0);
		List<Integer> filteredPatientByLocation = facilityLocationService.getPatientLocationById(locationId);
		
		//check if global variable for logging exists
		LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
		LoggerUtils.clearLogFile();
		
		List<Patient> patients = nigeriaPatientService.getPatients(filteredPatientByLocation);
		
		String FacilityType = "FAC";
		
		return startGenerateFile(request, patients, facilityLocation.getFacility_name(), facilityLocation.getDatimCode(),
		    FacilityType);
	}
	
	public String generateNDRFile(HttpServletRequest request) {
		
		DBConnection openmrsConn = Utils.getNmrsConnectionDetails();
		
		//check if global variable for logging exists
		LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
		LoggerUtils.clearLogFile();
		LoggerUtils.checkPatientLimitGlobalProperty(openmrsConn);
		List<Patient> patients = null;
		String patientIdLimit = Utils.getPatientIdLimit();
		//		if (patientIdLimit != null && !"".equals(patientIdLimit)) {
		//			String[] patientIdArray = patientIdLimit.split(",");
		//			int startIndex = Integer.parseInt(patientIdArray[0]);
		//			int endIndex = Integer.parseInt(patientIdArray[1]);
		//			patients = nigeriaPatientService.getPatientsInIndex(startIndex, endIndex);
		//		} else {
		Date lastDate = Utils.getLastNDRDate();
		patients = nigeriaPatientService.getPatientsByEncounterDate(lastDate, null);
		//		}
		
		String facilityName = Utils.getFacilityName();
		String DATIMID = Utils.getFacilityDATIMId();
		String FacilityType = "FAC";
		
		return startGenerateFile(request, patients, facilityName, DATIMID, FacilityType);
		
	}
	
	private String startGenerateFile(HttpServletRequest request, List<Patient> filteredPatients,
									 String facilityName, String DATIMID, String FacilityType) {


		//create report download folder at the server. skip if already exist
		String reportType = "NDR";
		String reportFolder = Utils.ensureReportFolderExist(request, reportType);
		String formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());

		FacilityType facility = Utils.createFacilityType(facilityName, DATIMID, FacilityType);

		List<Future<?>> futures = new ArrayList<>();

		try {

			long loop_start_time = System.currentTimeMillis();
			int counter = 0;
			UserContext userContext = Context.getUserContext();

			for (Patient patient : filteredPatients) {
				long startTime = System.currentTimeMillis();
				counter++;

				System.out.println("pateint  " + counter + " of " + filteredPatients.size() + " with ID " + patient.getId());

				int finalCounter = counter;
				Thread thread = new Thread(() -> {
					try {
						NDRExtractor ndrExtractor = new NDRExtractor(patient, DATIMID, reportFolder, facility, finalCounter, userContext, formattedDate, jaxbMarshaller);
						ndrExtractor.extract();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				futures.add(pool.submit(thread));
				long endTime = System.currentTimeMillis();
				LoggerUtils.write(NdrFragmentController.class.getName(),
						"Finished Export for patient with id: " + patient.getId() + " Time Taken: " + (endTime - startTime)
								+ " milliseconds", LogFormat.INFO, LogLevel.live);
				System.out.println("generating ndr took : " + (endTime - startTime) + " milli secs : ");

				long loop_end_time = System.currentTimeMillis();
				System.out.println("generating ndr took : " + (loop_end_time - loop_start_time) + " milli secs : ");
			}

			while (!isComplete(futures)) {
				Thread.sleep(10000);
			}
			Utils.updateLast_NDR_Run_Date(new Date());
            pool.shutdown();
			String zipFileName = Utils.getIPShortName() + "_ " + facilityName + "_" + DATIMID + "_" + formattedDate + ".zip";
			return Utils.ZipFolder(request.getContextPath(), reportFolder, zipFileName, reportType);
		} catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
					LogLevel.live);
			//Update ndr last run date
			Utils.updateLast_NDR_Run_Date(new Date());
			String zipFileName = Utils.getIPShortName() + "_" + DATIMID + "_" + formattedDate + ".zip";
			Utils.ZipFolder(request.getContextPath(), reportFolder, zipFileName, reportType);

			return "Some files exported with errors, view error log here: \n" + LoggerUtils.getExportPath();
		}

	}
	
	public synchronized boolean isComplete(List<Future<?>> futures) {
		Iterator<Future<?>> itr = futures.iterator();
		while (itr.hasNext()) {
			if (itr.next().isDone())
				itr.remove();
			else
				return false;
		}
		return true;
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
	
	public String getFileList(HttpServletRequest request) throws IOException {
		List<Map<String, Object>> fileMaps = new ArrayList<>();
		String reportType = "NDR";
		String response = "";

		try {
			String folder = Paths.get(
					new File(request.getSession().getServletContext().getRealPath(request.getContextPath())).getParentFile()
							.toString(), "downloads", reportType).toString();
			File[] zipFiles = new File(folder).listFiles();
			if (zipFiles != null && zipFiles.length > 0) {
				Arrays.sort(zipFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				int counter = 0;
				for (File file : zipFiles) {
					BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
					Timestamp ts = new Timestamp(attr.lastModifiedTime().toMillis());
					boolean zip = file.getName().toLowerCase().endsWith(".zip");
					Date date = new Date(ts.getTime());
					String dateStr = sdf.format(date);
					Map<String, Object> fileMap = new HashMap<>();
					fileMap.put("name", file.getName());
					fileMap.put("date", dateStr);
					fileMap.put("size", zip ? FileUtils.getFileSize(file.length()) : "TBD");
					fileMap.put("path", file.getName());
					fileMap.put("active", zip);
					fileMap.put("number", counter);
					fileMaps.add(fileMap);
					counter++;
				}
			}
			response = mapper.writeValueAsString(fileMaps);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}

		return response;
	}
	
	public String downloadFile(HttpServletRequest request, @RequestParam(value = "fileName") String fileName) {
		return Paths.get(request.getContextPath(), "downloads", "NDR", fileName).toString();
	}
	
	public boolean deleteFile(HttpServletRequest request, @RequestParam(value = "fileName") String fileName) {
		boolean success = false;
		try {
			String reportType = "NDR";
			String folder = Paths.get(
			    new File(request.getSession().getServletContext().getRealPath(request.getContextPath())).getParentFile()
			            .toString(), "downloads", reportType, fileName).toString();
			File file = new File(folder);
			
			if (file.getName().toLowerCase().endsWith(".zip")) {
				success = file.delete();
			} else {
				return FileUtils.deleteFolder(folder, true);
			}
		}
		catch (Exception ex) {
			Logger.getLogger(NdrFragmentController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return success;
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
}
