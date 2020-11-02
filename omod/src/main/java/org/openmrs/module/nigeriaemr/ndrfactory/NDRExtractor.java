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
						writeFile(patient, formattedDate, reportFolder, cnt, aXMLFile, jaxbContext, batchId);
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
	
	public synchronized void writeFile(Patient patient, String formattedDate, String reportFolder, Container container,
	        File file, JAXBContext jaxbContext, int batchId) throws Exception {
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
		file.delete();
		String newReportFolder = reportFolder + File.separator+ "error";
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
				printer.printRecord(file.getName(),patient.getId(), patient.getPersonName(), message);
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
	
	public void checkIfExportIsComplete() {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		try {
			List<NDRExportBatch> ndrExportBatches = nigeriaemrService.getExportBatchByStatus("Done", false);
			for (NDRExportBatch ndrExportBatch : ndrExportBatches) {
				String IPReportingState = Utils.getIPReportingState();
				String IPReportingLgaCode = Utils.getIPReportingLgaCode();
				String DATIMID = Utils.getFacilityDATIMId();
				String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(ndrExportBatch.getDateStarted());
				String formattedDate2 = new SimpleDateFormat("ddMMyy").format(ndrExportBatch.getId());
				String fileName = IPReportingState + IPReportingLgaCode + "_" + DATIMID + "_" + formattedDate;
				String zipFileName = fileName + ".zip";
				String errorZipFileName = fileName + "_error" + ".zip";
				String path = Utils.ZipFolder(ndrExportBatch.getContextPath(), ndrExportBatch.getReportFolder(),
						zipFileName, "NDR");
				File dir = new File(ndrExportBatch.getReportFolder());
				String errorReportFolder = ndrExportBatch.getReportFolder() + File.separator+ "error";
				String errorPath = Utils.ZipFolder(ndrExportBatch.getContextPath(),dir.getParent(), errorReportFolder,
						errorZipFileName, "NDR");
				String csvFile = Paths.get(dir.getParent(), ndrExportBatch.getId()+"_error_list.csv").toString();
				String errorList = Paths.get(ndrExportBatch.getContextPath(), "downloads", "NDR", ndrExportBatch.getId()+"_error_list.csv").toString();
				int numError = getNumberOfPatientsWithError(csvFile);
				String status;
				if (!"no new patient record found".equalsIgnoreCase(path)) {
					ndrExportBatch.setPath(path);
					if(numError > 0){
						ndrExportBatch.setErrorPath(errorPath);
						ndrExportBatch.setErrorList(errorList);
						status = "Completed with "+numError+" Errors";
					}else {
						status = "Completed";
					}
				} else {
					status = "Failed";
				}
				ndrExportBatch.setStatus(status);
				nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch);
			}
		}
		catch (Exception e) {
			LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			//ignore error
		}

		try {
			List<NDRExportBatch> ndrExportBatchesInProgress = nigeriaemrService.getExportBatchByStatus("Processing", false);
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
						nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch);
					}else{
						ndrExportBatch.setPatientsProcessed(count);
						ndrExportBatch.setDateUpdated(new Date());
						nigeriaemrService.saveNdrExportBatchItem(ndrExportBatch);
					}
				}
			}
		}catch (Exception e) {
			LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
					LoggerUtils.LogLevel.live);
			//ignore error
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
