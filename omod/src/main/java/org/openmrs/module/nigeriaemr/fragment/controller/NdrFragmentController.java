package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRConverter;
import org.openmrs.module.nigeriaemr.api.service.NigeriaPatientService;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
import org.springframework.web.bind.annotation.RequestParam;

public class NdrFragmentController {
	
	NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);
	
	DBConnection openmrsConn;
	
	FacilityLocationService facilityLocationService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	NDRConverter generator;
	
	JAXBContext jaxbContext;
	
	public NdrFragmentController() throws Exception {
		openmrsConn = Utils.getNmrsConnectionDetails();
		facilityLocationService = new FacilityLocationService();
		generator = new NDRConverter(Utils.getIPFullName(), Utils.getIPShortName(), openmrsConn);
		//Create an xml file and save in today's folder
		jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
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

		ExecutorService pool = Executors.newFixedThreadPool(10);
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
						extract(DATIMID, reportFolder, facility, finalCounter, patient, userContext, formattedDate);
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
//			Utils.updateLast_NDR_Run_Date(new Date());

			String zipFileName = Utils.getIPShortName() + "_ " + facilityName + "_" + DATIMID + "_" + formattedDate + ".zip";
			return  Utils.ZipFolder(request.getContextPath(), reportFolder, zipFileName, reportType);
		}
		catch (Exception ex) {
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
	
	/**
	 * Gets the user context from the thread local. This might be accessed by several threads at the
	 * same time.
	 * 
	 * @return The current UserContext for this thread.
	 * @should fail if session hasnt been opened
	 */
	
	private void extract(String DATIMID, String reportFolder, FacilityType facility, int counter, Patient patient,
	        UserContext userContext, String formattedDate) throws Exception {
		Container cnt;
		Context.setUserContext(userContext);
		Context.openSessionWithCurrentUser();
		
		String pepFarId = Utils.getPatientPEPFARId(patient);
		
		if (pepFarId != null) { //remove forward slashes / from file names
			pepFarId = pepFarId.replace("/", "_").replace(".", "_");
		} else {
			pepFarId = "";
		}
		try {
			LoggerUtils.write(NdrFragmentController.class.getName(),
			    "#################### #################### ####################", LogFormat.FATAL, LogLevel.live);
			LoggerUtils.write(NdrFragmentController.class.getName(),
			    "Started Export for patient with id: " + patient.getId(), LogFormat.INFO, LogLevel.live);
			
			cnt = generator.createContainer(patient, facility);
			
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(),
			    MessageFormat.format("Could not parse patient with id: {0},{1},{2} ", Integer.toString(patient.getId()),
			        "\r\n", ex.getMessage()), LogFormat.FATAL, LogLevel.live);
			cnt = null;
		}
		
		if (cnt != null) {
			LoggerUtils.write(NdrFragmentController.class.getName(), "Got data for patient with ID: " + patient.getId(),
			    LogFormat.INFO, LogLevel.live);
			try {
				
				String fileName = Utils.getIPShortName() + "_" + DATIMID + "_" + counter + "_" + formattedDate + "_"
				        + pepFarId;
				
				String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
				
				File aXMLFile = new File(xmlFile);
				boolean b = aXMLFile.createNewFile();
				
				System.out.println("creating xml file : " + xmlFile + "was successful : " + b);
				if (cnt.getMessageHeader() != null) {
					Marshaller jaxbMarshaller = generator.createMarshaller(jaxbContext);
					generator.writeFile(cnt, aXMLFile, jaxbMarshaller);
				}
			}
			catch (Exception ex) {
				LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
			}
		}
		Context.closeSession();
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
