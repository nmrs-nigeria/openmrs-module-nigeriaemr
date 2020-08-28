package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NDRExtractor {
	
	private final Integer patientId;
	
	private final String DATIMID;
	
	private final String reportFolder;
	
	private final int counter;
	
	private final UserContext userContext;
	
	private final String formattedDate;
	
	private final NDRConverter generator;
	
	private final JAXBContext jaxbContext;
	
	private final int exportProcessId;
	
	NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
	
	public NDRExtractor(UserContext userContext) {
		this.patientId = null;
		this.DATIMID = null;
		this.reportFolder = null;
		this.counter = 0;
		this.userContext = userContext;
		this.formattedDate = null;
		this.generator = null;
		this.jaxbContext = null;
		this.exportProcessId = 0;
	}
	
	public NDRExtractor(String patientId, String DATIMID, String reportFolder, int counter, UserContext userContext,
	    String formattedDate, JAXBContext jaxbContext, Date lastDate, Date currentDate, int exportProcessId) {
		this.patientId = Integer.parseInt(patientId);
		this.DATIMID = DATIMID;
		this.reportFolder = reportFolder;
		this.counter = counter;
		this.userContext = userContext;
		this.formattedDate = formattedDate;
		this.generator = new NDRConverter(Utils.getIPFullName(), Utils.getIPShortName(), Utils.getNmrsConnectionDetails(),
		        lastDate, currentDate);
		this.jaxbContext = jaxbContext;
		this.exportProcessId = exportProcessId;
		
	}
	
	/**
	 * Gets the user context from the thread local. This might be accessed by several threads at the
	 * same time.
	 * 
	 * @return The current UserContext for this thread.
	 * @should fail if session hasnt been opened
	 */
	
	public void extract() {
		Container cnt;
		Context.setUserContext(userContext);
		Context.openSessionWithCurrentUser();
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
					
					String fileName = Utils.getIPShortName() + "_" + DATIMID + "_" + counter + "_" + formattedDate + "_"
					        + pepFarId;
					
					String xmlFile = Paths.get(reportFolder, fileName + ".xml").toString();
					
					File aXMLFile = new File(xmlFile);
					boolean b = aXMLFile.createNewFile();
					
					System.out.println("creating xml file : " + xmlFile + "was successful : " + b);
					if (cnt.getMessageHeader() != null) {
						writeFile(cnt, aXMLFile);
					}
				}
				catch (Exception ex) {
					LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
					    LoggerUtils.LogLevel.live);
				}
			}
			Context.closeSession();
		}
		catch (Exception e) {
			Context.clearSession();
			Context.closeSession();
		}
	}
	
	public void writeFile(Container container, File file) {
		try {
			Marshaller jaxbMarshaller = NDRUtils.createMarshaller(jaxbContext);
			jaxbMarshaller.marshal(container, file);
		}
		catch (Exception ex) {
			LoggerUtils.write(NdrFragmentController.class.getName(), "File " + file.getName() + " throw an exception \n"
			        + ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
		}
	}
	
	public void checkIfExportIsComplete(){
		Context.setUserContext(this.userContext);
		Context.openSessionWithCurrentUser();
		try {
			String IPReportingState = Utils.getIPReportingState();
			String IPReportingLgaCode = Utils.getIPReportingLgaCode();
			Map<String, Object> condition = new HashMap<>();
			condition.put("status", "Done");
			List<NDRExport> exports = nigeriaemrService.getExports(condition, false);
			for (NDRExport ndrExport : exports) {
				String DATIMID = Utils.getFacilityDATIMId();
				String formattedDate = new SimpleDateFormat("ddMMyyHHmmss").format(ndrExport.getDateStarted());
				String fileName = IPReportingState + IPReportingLgaCode + "_" + DATIMID + "_" + formattedDate;
				Utils.updateLast_NDR_Run_Date(ndrExport.getDateStarted());
				String zipFileName = fileName + ".zip";

				ndrExport.setStatus("Processing"); // update to Processing so another thread won't pick it up
				nigeriaemrService.saveNdrExportItem(ndrExport);

				String path = Utils.ZipFolder(ndrExport.getContextPath(), ndrExport.getReportFolder(), zipFileName, "NDR");
				if(!"no new patient record found".equalsIgnoreCase(path)) {
					ndrExport.setPath(path);
					ndrExport.setDateEnded(new Date());
					ndrExport.setStatus("Completed");
				}else {
					ndrExport.setDateEnded(new Date());
					ndrExport.setStatus("Failed");
				}
				nigeriaemrService.saveNdrExportItem(ndrExport);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			//ignore error
		}


		//Check if any currently in process has failed
		Map<String, Object> condition = new HashMap<>();
		condition.put("status", "Processing");
		List<NDRExport> processingExports = nigeriaemrService.getExports(condition, false);
		if(processingExports.size() > 0){
			for(NDRExport ndrExport: processingExports){
				if(Utils.getDateDiffInMinutes(ndrExport.getDateEnded(), new Date()) > 20){
					ndrExport.setDateEnded(new Date());
					ndrExport.setStatus("Failed");
					nigeriaemrService.saveNdrExportItem(ndrExport);
				}
			}
		}
		Context.closeSession();
	}
}
