package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRConverter;
import org.xml.sax.SAXException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.service.CommunityTesters;
import org.openmrs.module.nigeriaemr.service.PatientContacts;
import org.springframework.web.bind.annotation.RequestParam;

public class NdrFragmentController {
	
	public void controller() {
	}
	
	public String generateNDRFile(HttpServletRequest request) throws DatatypeConfigurationException, IOException,
	        SAXException, JAXBException, Throwable {
		
		DBConnection openmrsConn = Utils.getNmrsConnectionDetails();
		
		//check i fglobal variable for logging exists
		LoggerUtils.checkLoggerGlobalProperty(openmrsConn);
		
		//create report download folder at the server. skip if already exist
		Utils util = new Utils();
		String reportType = "NDR";
		String reportFolder = util.ensureReportFolderExist(request, reportType);
		
		//Create an xml file and save in today's folder
		NDRConverter generator = new NDRConverter(Utils.getIPFullName(), Utils.getIPShortName(), openmrsConn);
		
		List<Patient> patients = Context.getPatientService().getAllPatients();
		
		String facilityName = Utils.getFacilityName();
		String DATIMID = Utils.getFacilityDATIMId();
		String FacilityType = "FAC";
		String IPShortName = Utils.getIPShortName();
		String formattedDate = new SimpleDateFormat("ddMMyy").format(new Date());
		
		FacilityType facility = Utils.createFacilityType(facilityName, DATIMID, FacilityType);
		
		try {
			//
			//            patients.parallelStream().forEach(patient -> {
			//
			//                Container cnt = null;
			//                try {
			//                    LoggerUtils.write(NdrFragmentController.class.getName(), "#################### #################### ####################", LogFormat.FATAL, LogLevel.live);
			//                    LoggerUtils.write(NdrFragmentController.class.getName(), "Started Export for patient with id: "
			//                            + patient.getId(), LoggerUtils.LogFormat.INFO,LogLevel.live);
			//                    long startTime = System.currentTimeMillis();
			//                    cnt = generator.createContainer(patient, facility);
			//                    long endTime = System.currentTimeMillis();
			//                    LoggerUtils.write(NdrFragmentController.class.getName(), "Finished Export for patient with id: "
			//                            + patient.getId() + ", Time Taken: " + (endTime - startTime) + " milliseconds",
			//                            LoggerUtils.LogFormat.INFO,LogLevel.live);
			//                } catch (Exception ex) {
			//                    LoggerUtils.write(NdrFragmentController.class.getName(), MessageFormat.format(
			//                            "Could not parse patient with id: {0},{1},{2} ", Integer.toString(patient.getId()), "\r\n",
			//                            ex.getMessage()), LogFormat.FATAL,LogLevel.live);
			//                    cnt = null;
			//                }
			//
			//                if (cnt != null) {
			//
			//                    try {
			//                        cnt.setValidation(generator.getValidation());
			//                        String fileName = IPShortName + "_" + DATIMID + "_" + formattedDate + "_"
			//                                + Utils.getPatientPEPFARId(patient);
			//
			//                        // old implementation		String xmlFile = reportFolder + "\\" + fileName + ".xml";
			//                        String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
			//
			//                        File aXMLFile = new File(xmlFile);
			//                        Boolean b;
			//                        if (aXMLFile.exists()) {
			//                            b = aXMLFile.delete();
			//                            System.out.println("deleting file : " + xmlFile + "was successful : " + b);
			//                        }
			//                        b = aXMLFile.createNewFile();
			//
			//                        System.out.println("creating xml file : " + xmlFile + "was successful : " + b);
			//                        generator.writeFile(cnt, aXMLFile);
			//                    } catch (Exception ex) {
			//                        LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,LogLevel.live);
			//                    }
			//                }
			//
			//            });
			//			
			for (Patient patient : patients) {
				
				if (patient.getId() == 14 || patient.getId() == 19 || patient.getId() == 21) {
					Container cnt = null;
					try {
						LoggerUtils
						        .write(NdrFragmentController.class.getName(),
						            "#################### #################### ####################", LogFormat.FATAL,
						            LogLevel.live);
						LoggerUtils.write(NdrFragmentController.class.getName(), "Started Export for patient with id: "
						        + patient.getId(), LoggerUtils.LogFormat.INFO, LogLevel.live);
						long startTime = System.currentTimeMillis();
						cnt = generator.createContainer(patient, facility);
						long endTime = System.currentTimeMillis();
						LoggerUtils.write(NdrFragmentController.class.getName(), "Finished Export for patient with id: "
						        + patient.getId() + " Time Taken: " + (endTime - startTime) + " milliseconds",
						    LoggerUtils.LogFormat.INFO, LogLevel.live);
					}
					catch (Exception ex) {
						LoggerUtils.write(
						    NdrFragmentController.class.getName(),
						    MessageFormat.format("Could not parse patient with id: {0},{1},{2} ",
						        Integer.toString(patient.getId()), "\r\n", ex.getMessage()), LogFormat.FATAL, LogLevel.live);
						cnt = null;
					}
					
					if (cnt != null) {
						LoggerUtils.write(NdrFragmentController.class.getName(),
						    "Got data for patient with ID: " + patient.getId(), LogFormat.INFO, LogLevel.live);
						try {
							
							String fileName = IPShortName + "_" + DATIMID + "_" + formattedDate + "_"
							        + Utils.getPatientPEPFARId(patient);
							
							// old implementation		String xmlFile = reportFolder + "\\" + fileName + ".xml";
							String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
							
							File aXMLFile = new File(xmlFile);
							Boolean b;
							if (aXMLFile.exists()) {
								b = aXMLFile.delete();
								System.out.println("deleting file : " + xmlFile + "was successful : " + b);
							}
							b = aXMLFile.createNewFile();
							
							System.out.println("creating xml file : " + xmlFile + "was successful : " + b);
							generator.writeFile(cnt, aXMLFile);
						}
						catch (Exception ex) {
							LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
							    LogLevel.live);
						}
					}
					
				}
				
			}
			
			//Update ndr last run date
			Utils.updateLast_NDR_Run_Date(new Date());
			
			String zipFileName = IPShortName + "_" + DATIMID + "_" + formattedDate + ".zip";
			String response = "Files Exported successfully, view uploaded files here: \n"
			        + util.ZipFolder(request, reportFolder, zipFileName, reportType);
			return response;
			//request.getContextPath() + "/downloads/" + zipFileName;
			
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LogLevel.live);
			//Update ndr last run date
			Utils.updateLast_NDR_Run_Date(new Date());
			
			String zipFileName = IPShortName + "_" + DATIMID + "_" + formattedDate + ".zip";
			util.ZipFolder(request, reportFolder, zipFileName, reportType);
			
			//throw new Throwable(LoggerUtils.getExportPath());
			String response = "Some files exported with errors, view error log here: \n" + LoggerUtils.getExportPath();
			return response;
		}
		
	}
	
	//get host for openmrs instance
	public String retrieveBiometricServer(String msg) {
		System.out.println("This is from the UI: " + msg);
		return Utils.getBiometricServer();
	}
	
	// pull community testers from the web.
	public String reloadTester() {
		
		CommunityTesters ctService = new CommunityTesters();
		
		try {
			ctService.refreshCommunityTesterList();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			return "Error occurred, operation aborted!";
		}
		
		return "The data was refreshed successfully";
		
	}
	
	public String getIndexContacts(@RequestParam(value = "indexClientId", required = true) int indexClientId) {
		
		PatientContacts pcService = new PatientContacts();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(pcService.getAllPatientContactsByIndexId(indexClientId));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
		
	}
	
}
