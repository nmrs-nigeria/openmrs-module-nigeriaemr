package org.openmrs.module.nigeriaemr.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.nigeriaQualFactory.NigeriaQUALGenerator;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  * Controller for a fragment that shows all users  
 */
public class NigeriaqualFragmentController {
	
	public void controller() {
	}
	
	public String getNigeriaQualReport(@RequestParam(value = "start", required = false) Date startDate,
	        @RequestParam(value = "end", required = false) Date endDate, HttpServletRequest request)
			throws JAXBException, SAXException, IOException, XMLStreamException {
		
		Utils util = new Utils();
		String reportType = "NigeriaQual";
		String reportFolder = util.ensureReportFolderExist(request, reportType);

		NigeriaQUALGenerator generator = new NigeriaQUALGenerator(Utils.getNigeriaQualId(),startDate, endDate);
		List<Patient> patients = Context.getPatientService().getAllPatients()
				.stream().filter(p->p.getId() == 7).collect(Collectors.toList());


		for(Patient patient: patients){

			generator.createArtFile(patient, reportFolder);
			generator.createArtAdherenceFile(patient, reportFolder);
			generator.createBaselineParametersFile(patient, reportFolder);
			generator.createClinicalEvaluationVisitsFile(patient, reportFolder);//this is skipped
			generator.createCOTRIMOXAZOLEFile(patient, reportFolder);
			generator.createPatientDemographicFile(patient, reportFolder);
			generator.createPatientStatusDuringReviewPeriodFile(patient, reportFolder);
			generator.createTuberculosisFile(patient, reportFolder);
			generator.createViralLoadTestingFile(patient, reportFolder);
			generator.createMissedAppointmentsAndPatientTrackingFile(patient, reportFolder);
			generator.createHepatitisBFile(patient, reportFolder);
			generator.createARTRegimenFile(patient, reportFolder);
			generator.createPatientMonitoringReviewPeriodFile(patient,reportFolder);
		}

		String zipFileName = Utils.getIPShortName()+ "_" +Utils.getFacilityDATIMId()+"_"+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())+".zip";
		return util.ZipFolder(request, reportFolder,zipFileName, reportType);
	}
}
