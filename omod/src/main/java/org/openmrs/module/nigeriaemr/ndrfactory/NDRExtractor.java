package org.openmrs.module.nigeriaemr.ndrfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.Consumer;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.api.service.impl.NigeriaEncounterServiceImpl;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.DatimMap;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
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
	        JAXBContext jaxbContext, Date lastDate, Date currentDate) {
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
					        + pepFarId;
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
						writeFile(cnt, aXMLFile, jaxbContext);
					}
				}
				catch (Exception ex) {
					LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
					    LoggerUtils.LogLevel.live);
				}
			}
		}
		catch (Exception e) {
			LoggerUtils.write(NDRExtractor.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
			throw e;
		}
	}
	
	public synchronized void writeFile(Container container, File file, JAXBContext jaxbContext) {
		try {
			Marshaller jaxbMarshaller = NDRUtils.createMarshaller(jaxbContext);
			jaxbMarshaller.marshal(container, file);
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(), "File " + file.getName() + " throw an exception \n"
			        + ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
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
				String fileName = IPReportingState + IPReportingLgaCode + "_" + DATIMID + "_" + formattedDate;
				String zipFileName = fileName + ".zip";
				
				String path = Utils.ZipFolder(ndrExportBatch.getContextPath(), ndrExportBatch.getReportFolder(),
				    zipFileName, "NDR");
				String status;
				if (!"no new patient record found".equalsIgnoreCase(path)) {
					ndrExportBatch.setPath(path);
					status = "Completed";
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
					List<NDRExport> ndrExports = nigeriaemrService.getExports(conditions, null, false);
					int count = 0;
					for (NDRExport ndrExport : ndrExports) {
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
}
