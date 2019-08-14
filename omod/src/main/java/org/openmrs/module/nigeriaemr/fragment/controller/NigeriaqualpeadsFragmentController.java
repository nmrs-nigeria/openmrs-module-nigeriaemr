package org.openmrs.module.nigeriaemr.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.nigeriaQualFactory.NigQualUtil;
import org.openmrs.module.nigeriaemr.nigeriaQualFactory.NigeriaQualPaedGenerator;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NigeriaqualpeadsFragmentController {
	
	public void controller() {
	}
	
	public String getNigeriaQualPeadsReport(@RequestParam(value = "start", required = false) Date startDate,
	        @RequestParam(value = "end", required = false) Date endDate, HttpServletRequest request) throws IOException,
	        JAXBException, SAXException {
		
		Utils util = new Utils();
		String reportType = "nigeriaqualpeads";
		String reportFolder = util.ensureReportFolderExist(request, reportType);
		String facilityId = Utils.getFacilityLocalId();
		
		List<Patient> patientList = NigQualUtil.generatePaediatricPatientListing();
		
		NigeriaQualPaedGenerator generator = new NigeriaQualPaedGenerator(facilityId, reportFolder, startDate, endDate);
		for (Patient patient : patientList) {
			
			generator.createAherenceFile(patient);
			generator.createPediatricARTRegimenFile(patient);
			generator.createPediatricBaselineFile(patient);
			generator.createPediatricClinicalEvaluationFile(patient);
			generator.createPediatricCotrimoxazoleFile(patient);
			generator.createPediatricEducationFile(patient);
			generator.createPediatricLinkageFile(patient);
			generator.createPediatricPatientDemographicsFile(patient);
			generator.createPediatricPatientMonitoringFile(patient);
			generator.createPediatricPatientStatusFile(patient);
			generator.createPediatricTuberculosisFile(patient);
		}
		
		String zipFileName = Utils.getIPShortName() + "_" + Utils.getFacilityDATIMId() + "_"
		        + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".zip";
		return util.ZipFolder(request, reportFolder, zipFileName, reportType);
	}
	
}
