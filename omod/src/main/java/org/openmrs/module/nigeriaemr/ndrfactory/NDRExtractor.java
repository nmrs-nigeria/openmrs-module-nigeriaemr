package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.Container;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class NDRExtractor {
	
	private Patient patient;
	
	private String DATIMID;
	
	private String reportFolder;
	
	private FacilityType facility;
	
	private int counter;
	
	private UserContext userContext;
	
	private String formattedDate;
	
	private Marshaller jaxbMarshaller;
	
	private NDRConverter generator;
	
	public NDRExtractor(Patient patient, String DATIMID, String reportFolder, FacilityType facility, int counter,
	    UserContext userContext, String formattedDate, Marshaller jaxbMarshaller) {
		this.patient = patient;
		this.DATIMID = DATIMID;
		this.reportFolder = reportFolder;
		this.facility = facility;
		this.counter = counter;
		this.userContext = userContext;
		this.formattedDate = formattedDate;
		this.generator = new NDRConverter(Utils.getIPFullName(), Utils.getIPShortName(), Utils.getNmrsConnectionDetails());
		this.jaxbMarshaller = jaxbMarshaller;
		
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
				
				cnt = generator.createContainer(patient, facility);
				
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
						writeFile(cnt, aXMLFile, jaxbMarshaller);
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
	
	public void writeFile(Container container, File file, Marshaller jaxbMarshaller) {
		
		try {
			jaxbMarshaller.marshal(container, file);
		}
		catch (Exception ex) {
			System.out.println("File " + file.getName() + " throw an exception \n" + ex.getMessage());
		}
	}
	
}
