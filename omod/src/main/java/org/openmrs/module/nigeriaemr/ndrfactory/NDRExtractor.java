package org.openmrs.module.nigeriaemr.ndrfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.model.ndr.ConditionType;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class NDRExtractor {
	
	ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Gets the user context from the thread local. This might be accessed by several threads at the
	 * same time.
	 * 
	 * @return The current UserContext for this thread.
	 * @should fail if session hasnt been opened
	 */
	
	public void extract(Integer patientId, String DATIMID, String reportFolder, String formattedDate,
	        JAXBContext jaxbContext, Date lastDate, Date currentDate, int batchId) throws Exception {
		NDRConverter generator = new NDRConverter(Utils.getNmrsConnectionDetails(), lastDate, currentDate);
		Container cnt;
		try {
			Patient patient = Context.getPatientService().getPatient(patientId);
			String pepFarId = Utils.getPatientPEPFARId(patient);
			
			if (pepFarId != null) { //remove forward slashes / from file names
				pepFarId = pepFarId.replace("/", "_").replace(".", "_");
			} else {
				pepFarId = "";
			}
			try {
				LoggerUtils.write(NdrFragmentController.class.getName(),
				    "#################### #################### ####################", LoggerUtils.LogFormat.FATAL,
				    LoggerUtils.LogLevel.live);
				LoggerUtils.write(NdrFragmentController.class.getName(),
				    "Started Export for patient with id: " + patient.getId(), LoggerUtils.LogFormat.INFO,
				    LoggerUtils.LogLevel.live);
				
				cnt = generator.createContainer(patient);
				
			}
			catch (Exception ex) {
				LoggerUtils.write(NdrFragmentController.class.getName(), MessageFormat.format(
				    "Could not parse patient with id: {0},{1},{2} ", Integer.toString(patient.getId()), "\r\n",
				    ex.getMessage()), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
				cnt = null;
			}
			
			if (cnt != null) {
				LoggerUtils.write(NdrFragmentController.class.getName(), "Got data for patient with ID: " + patient.getId(),
				    LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
				try {
					String fileName = Utils.getIPReportingState() + Utils.getIPReportingLgaCode() + "_" + DATIMID + "_"
					        + pepFarId + "_" + formattedDate;
					
					fileName = fileName.replaceAll("/", "_");
					
					File dir = new File(reportFolder);
					if (!dir.exists())
						dir.mkdir();
					String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
					
					File aXMLFile = new File(xmlFile);
					if (aXMLFile.exists())
						aXMLFile.delete();
					boolean b = aXMLFile.createNewFile();
					
					LoggerUtils.write(NDRExtractor.class.getName(), "creating xml file : " + xmlFile + "was successful : "
					        + b, LoggerUtils.LogFormat.INFO, LoggerUtils.LogLevel.live);
					if (cnt.getMessageHeader() != null) {
						cnt.setValidation(generator.getValidation(patientId.toString()));
						writeFile(patient, reportFolder, cnt, aXMLFile, jaxbContext, batchId);
					} else {
						boolean delete = aXMLFile.delete();
						if (!delete)
							aXMLFile.deleteOnExit();
					}
				}
				catch (Exception ex) {
					LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
					    LoggerUtils.LogLevel.live);
					throw ex;
				}
			}
		}
		catch (Exception e) {
			LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			throw e;
		}
	}
	
	public synchronized void writeFile(Patient patient, String reportFolder, Container container, File file,
	        JAXBContext jaxbContext, int batchId) throws Exception {
		Marshaller jaxbMarshaller = null;
		try {
			if (patient.isVoided()) {
				jaxbMarshaller = NDRUtils.createMarshaller(jaxbContext, true);
			} else {
				jaxbMarshaller = NDRUtils.createMarshaller(jaxbContext, false);
			}
			jaxbMarshaller.marshal(container, file);
		}
		catch (Exception ex) {
			if (ex instanceof JAXBException && ((JAXBException) ex).getLinkedException() != null) {
				writeErrorCsv(patient, reportFolder, ((JAXBException) ex).getLinkedException().getMessage(), container,
				    file, jaxbContext, batchId);
			}
			LoggerUtils.write(NdrFragmentController.class.getName(), "File " + file.getName() + " throw an exception \n"
			        + ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
			throw ex;
		}
	}
	
	private synchronized void writeErrorCsv(Patient patient, String reportFolder,
											String message, Container container, File file, JAXBContext jaxbContext, int batchId) {
		boolean deleted = file.delete();
		if(!deleted) file.deleteOnExit();
		String newReportFolder = reportFolder + "-error";
		File dir2 = new File(reportFolder);
		File dir = new File(newReportFolder);
		try {
			if (!dir.exists()) dir.mkdir();
			String xmlFile = Paths.get(newReportFolder, file.getName()).toString();
			File aXMLFile = new File(xmlFile);
			if (aXMLFile.exists()) aXMLFile.delete();
			boolean b = aXMLFile.createNewFile();
			Marshaller jaxbMarshaller = NDRUtils.createMarshaller(jaxbContext, true);
			jaxbMarshaller.marshal(container, aXMLFile);
		}catch (Exception ex){
			LoggerUtils.write(NdrFragmentController.class.getName(), "File " + file.getName() + " throw an exception \n"
					+ ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
		}

		String csvFile = Paths.get(dir2.getParent(), batchId+"_error_list.csv").toString();

		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(Paths.get(csvFile), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			try (final CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
				if(container != null && container.getIndividualReport() != null && container.getIndividualReport().getCondition() != null
				&& container.getIndividualReport().getCondition().size() > 0){
					String stopped = "ACTIVE_TREATMENT";
					for(ConditionType conditionType : container.getIndividualReport().getCondition()){
						if(conditionType.getConditionSpecificQuestions() != null &&
								conditionType.getConditionSpecificQuestions().getHIVQuestions() != null){
							if(conditionType.getConditionSpecificQuestions().getHIVQuestions().isStoppedTreatment() != null &&
									conditionType.getConditionSpecificQuestions().getHIVQuestions().isStoppedTreatment()){
								stopped = "STOPPED_TREATMENT";
							}else{
								stopped = "NOT_AVAILABLE";
							}
						}
					}
					printer.printRecord(file.getName(), patient.getId(),stopped, patient.getPersonName(), message);
				}else {
					printer.printRecord(file.getName(), patient.getId()," ", patient.getPersonName(), message);
				}
			}
			writer.close();
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(),
			    "File error_list.csv throw an exception \n" + ex.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}finally {
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//	public static void main(String[] args) throws JsonProcessingException {
	//		User user = new User();
	//		user.setName("test");
	//		User user2 = new User();
	//		user2.setName("test2");
	//		Person person = new Person();
	//		Person person2 = new Person();
	//		user2.setPerson(person2);
	//		person.setPersonChangedBy(user);
	//		user.setPerson(person);
	//
	//		ObjectMapper objectMapper = new ObjectMapper();
	//		System.out.println(objectMapper.writeValueAsString(user));
	//	}
}
