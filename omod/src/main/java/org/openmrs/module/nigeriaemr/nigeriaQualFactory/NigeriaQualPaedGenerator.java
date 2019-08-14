package org.openmrs.module.nigeriaemr.nigeriaQualFactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartadherencerecord.PediatricARTAdherenceRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartadherencerecord.PediatricARTAdherenceRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment.PediatricARTRegimenSinceStartingTreatmentRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment.PediatricARTRegimenSinceStartingTreatmentRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters.PediatricBaselineParametersRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters.PediatricBaselineParametersRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricclinicalevaluationInreviewperiod.PediatricClinicalEvaluationInReviewPeriodRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricclinicalevaluationInreviewperiod.PediatricClinicalEvaluationInReviewPeriodRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod.PediatricCotrimoxazoleRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod.PediatricCotrimoxazoleRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation.PediatricEducationRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation.PediatricEducationRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriclinkage.PediatricLinkageRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriclinkage.PediatricLinkageRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientdemographics.PediatricPatientDemographicsRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientdemographics.PediatricPatientDemographicsRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod.PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod.PediatricPatientMonitoringDuringReviewPeriodRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod.PediatricPatientStatusRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod.PediatricPatientStatusRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatrictuberculosis.PediatricTuberculosisRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatrictuberculosis.PediatricTuberculosisRecordType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrfactory.ClinicalDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.LabDictionary;
import org.xml.sax.SAXException;

import javax.rmi.CORBA.Util;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class NigeriaQualPaedGenerator {
	
	private String facilityId;
	
	private Date startDate;
	
	private Date endDate;
	
	private String reportFolder;
	
	public NigeriaQualPaedGenerator(String facility, String reportFolder, Date startDate, Date endDate) {
		this.facilityId = facility;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reportFolder = reportFolder;
	}
	
	private PediatricARTAdherenceRecordDataSetType createAdherenceRecord(Patient pts) {
		PediatricARTAdherenceRecordDataSetType mainRecord = new PediatricARTAdherenceRecordDataSetType();
		PediatricARTAdherenceRecordType record = new PediatricARTAdherenceRecordType();
		
		Obs adhObs = Utils.getLastAdherenceObs(pts, endDate);
		
		record.setFacilityID(this.facilityId);
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		
		if (adhObs != null) {
			record.setLastDateOfAssessment(Utils.formatDate(adhObs.getObsDatetime()));
			if (Utils.getDateDiffInMonth(adhObs.getObsDatetime(), endDate) <= 3) {
				record.setARTAdherenceAssessmentPerformedDuringLast3Months("YES");
			}
		} else {
			record.setARTAdherenceAssessmentPerformedDuringLast3Months("NO");
			record.setLastDateOfAssessment("");
		}
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricARTAdherenceRecord().add(record);
		return mainRecord;
	}
	
	private PediatricARTRegimenSinceStartingTreatmentRecordDataSetType createPediatricARTRegimenRecord(Patient pts) {
		PediatricARTRegimenSinceStartingTreatmentRecordDataSetType mainRecord = new PediatricARTRegimenSinceStartingTreatmentRecordDataSetType();
		PediatricARTRegimenSinceStartingTreatmentRecordType record = new PediatricARTRegimenSinceStartingTreatmentRecordType();
		Date artStartDate = Utils.getARTStartDate(pts);
		record.setFacilityID(this.facilityId);
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setPatientOnARTAnytimeDuringReviewPeriod(artStartDate != null && artStartDate.after(startDate) ? "Yes" : "No");
		mainRecord.getPediatricARTRegimenSinceStartingTreatmentRecord().add(record);
		return mainRecord;
	}
	
	private PediatricBaselineParametersRecordDataSetType createPediatricBaselineRecord(Patient pts) {
		PediatricBaselineParametersRecordDataSetType mainRecord = new PediatricBaselineParametersRecordDataSetType();
		PediatricBaselineParametersRecordType record = new PediatricBaselineParametersRecordType();
		
		Obs cd4Obs = Utils.getInitialObs(pts, LabDictionary.CD4_Count_Concept_Id);
		Obs weightObs = Utils.getInitialObs(pts, ClinicalDictionary.Weight_Concept_Id);
		Obs whoObs = Utils.getInitialObs(pts, ClinicalDictionary.WHO_Clinical_Stage_Concept_Id);
		Date artStartDate = Utils.getARTStartDate(pts);
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		
		if (artStartDate != null) {
			record.setARTStartDate(Utils.formatDate(Utils.getARTStartDate(pts)));
			record.setPatientEverStartedOnART("Yes");
		} else {
			record.setPatientEverStartedOnART("No");
		}
		
		if (cd4Obs != null) {
			record.setCD4Count(String.valueOf(cd4Obs.getValueNumeric()));
			record.setCD4CountDate(Utils.formatDate(cd4Obs.getObsDatetime()));
		} else {
			record.setCD4NotRecorded("Yes");
		}
		if (weightObs != null) {
			record.setWeight(String.valueOf(weightObs.getValueNumeric()));
			record.setWeightDate(Utils.formatDate(weightObs.getObsDatetime()));
		} else {
			record.setWeightNotRecorded("Yes");
		}
		
		if (whoObs != null) {
			String whoStage = NigQualUtil.getWHOStageNumber(whoObs);
			record.setWHOClinicalStage(whoStage);
			record.setWHOClinicalStateDate(Utils.formatDate(whoObs.getObsDatetime()));
		} else {
			record.setWHOClinicalStageNotRecorded("Yes");
		}
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricBaselineParametersRecord().add(record);
		return mainRecord;
	}
	
	private PediatricClinicalEvaluationInReviewPeriodRecordDataSetType createPediatricClinicalEvaluationRecord(Patient pts) {
		PediatricClinicalEvaluationInReviewPeriodRecordDataSetType mainRecord = new PediatricClinicalEvaluationInReviewPeriodRecordDataSetType();
		PediatricClinicalEvaluationInReviewPeriodRecordType record = new PediatricClinicalEvaluationInReviewPeriodRecordType();
		
		List<Encounter> lastEncounters = Utils.getLastEncounters(pts, endDate);
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setFacilityID(facilityId);
		
		Date encounterDate;
		for (int i = 0; i < lastEncounters.size(); i++) {
			encounterDate = lastEncounters.get(i).getEncounterDatetime();
			String dateString = Utils.formatDate(encounterDate);
			if (i == 0) {
				record.setVisit1(dateString);
			}
			if (i == 1) {
				record.setVisit2(dateString);
			}
			if (i == 2) {
				record.setVisit3(dateString);
			}
			if (i == 4) {
				record.setVisit4(dateString);
				break;
			}
		}
		mainRecord.getPediatricClinicalEvaluationInReviewPeriodRecord().add(record);
		return mainRecord;
	}
	
	private PediatricCotrimoxazoleRecordDataSetType createPediatricCotrimoxazoleRecord(Patient pts) {
		PediatricCotrimoxazoleRecordDataSetType mainRecord = new PediatricCotrimoxazoleRecordDataSetType();
		PediatricCotrimoxazoleRecordType record = new PediatricCotrimoxazoleRecordType();
		
		Obs ctx_in_review_period = Utils.getLastObs(pts, ClinicalDictionary.Cotrimoxazole_Adherence_Concept_Id, endDate);
		Obs firstCotrim = Utils.getInitialObs(pts, ClinicalDictionary.Cotrimoxazole_Adherence_Concept_Id);
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setFacilityID(facilityId);
		if (ctx_in_review_period != null) {
			record.setPatientCurrentlyOnCotrimoxazoleProphylaxis("Yes");
		} else {
			record.setPatientCurrentlyOnCotrimoxazoleProphylaxis("No");
		}
		if (firstCotrim != null) {
			record.setDateOfFirstPrescription(Utils.formatDate(firstCotrim.getObsDatetime()));
		}
		
		//TODO: set age of first prescription and Unit of age measurement
		record.setAgeOfFirstPrescription("");
		record.setUnitOfAgeMeasure("");
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricCotrimoxazoleRecord().add(record);
		return mainRecord;
	}
	
	private PediatricEducationRecordDataSetType createPediatricEducationRecord(Patient pts) {
		PediatricEducationRecordDataSetType mainRecord = new PediatricEducationRecordDataSetType();
		PediatricEducationRecordType record = new PediatricEducationRecordType();
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setFacilityID(this.facilityId);
		
		//TODO:  set value for setMotherReceivedInfantFeedingEducation
		record.setMotherReceivedInfantFeedingEducation("");
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricEducationRecord().add(record);
		return mainRecord;
	}
	
	private PediatricLinkageRecordDataSetType createPediatricLinkageRecord(Patient pts) {
		PediatricLinkageRecordDataSetType mainRecord = new PediatricLinkageRecordDataSetType();
		PediatricLinkageRecordType record = new PediatricLinkageRecordType();
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setFacilityID(this.facilityId);
		record.setChildImmunizationStatus("");
		record.setDidPatientReceivedNutritionSupport("");
		record.setInsecticideTreatedNetsReceived("");
		record.setNoneReceived("");
		record.setNotIndicated("");
		record.setPatientQualifyForNutritionSupporot("");
		record.setPatientReceivedNutritionalAssessmentInReviewPeriod("");
		record.setServicesReceivedByPatient("");
		record.setWaterguardReceived("");
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricLinkageRecord().add(record);
		return mainRecord;
	}
	
	private PediatricPatientDemographicsRecordDataSetType createPediatricPatientDemographicsRecord(Patient pts) {
		PediatricPatientDemographicsRecordDataSetType mainRecord = new PediatricPatientDemographicsRecordDataSetType();
		PediatricPatientDemographicsRecordType record = new PediatricPatientDemographicsRecordType();
		
		Date artStartDate = Utils.getARTStartDate(pts);
		Encounter enc = Utils.getLastEncounter(pts, endDate);
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		assert artStartDate != null;
		if (artStartDate.after(startDate) && artStartDate.before(endDate)) {
			record.setAdmissionDuringReviewPeriod("Yes");
		}
		record.setAge(String.valueOf(Utils.getAge(pts.getBirthdate())));
		record.setCareGiverOccupation("");
		record.setClinicalVisit6MonthsPriorToReviewPeriod("");
		record.setDateEnrolledInCare("");
		record.setDateOfBirth(Utils.formatDate(pts.getDeathDate()));
		if (enc != null) {
			record.setDateOfLastVisit(Utils.formatDate(enc.getEncounterDatetime()));
		}
		record.setCareGiverOccupation("");
		record.setGender(pts.getGender());
		record.setRNLSerialNo(Utils.getPatientRNLSerialNo(pts));
		record.setUnitOfAgeMeasure("");
		record.setHospitalNo(Utils.getPatientHospitalNo(pts));
		record.setPrimaryCareGiver(""); //from paed initial
		record.setClinicalVisit6MonthsPriorToReviewPeriod("");
		record.setStateOfResidence("");
		record.setDeliveryLocation("");
		record.setRecordCompletionPosition("");
		
		mainRecord.getPediatricPatientDemographicsRecord().add(record);
		return mainRecord;
	}
	
	private PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType createPediatricPatientMonitoringRecord(Patient pts) {
		PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType mainRecord = new PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType();
		PediatricPatientMonitoringDuringReviewPeriodRecordType record = new PediatricPatientMonitoringDuringReviewPeriodRecordType();
		
		Obs vlsObs = Utils.getLastObs(pts, LabDictionary.Viral_Load_CONCEPT_ID, endDate);
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setFacilityID(this.facilityId);
		if (vlsObs != null) {
			record.setHasThePatientReceivedViralLoadTesting(Utils.formatDate(vlsObs.getObsDatetime()));
			record.setHasThePatientReceivedViralLoadTesting("Yes");
			record.setViralLoadTestResult(String.valueOf(vlsObs.getValueNumeric()));
		}
		//TODO: finish up this
		record.setPDG001DATE("");
		record.setPDG002DATE("");
		
		record.setUploadDt(Utils.formatDate(new Date()));
		
		mainRecord.getPediatricPatientMonitoringDuringReviewPeriodRecord().add(record);
		return mainRecord;
	}
	
	private PediatricPatientStatusRecordDataSetType createPediatricPatientStatusRecord(Patient pts) {
		PediatricPatientStatusRecordDataSetType mainRecord = new PediatricPatientStatusRecordDataSetType();
		PediatricPatientStatusRecordType record = new PediatricPatientStatusRecordType();
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		//record.set
		//ToDO: this is not done
		
		mainRecord.getPediatricPatientStatusRecord().add(record);
		return mainRecord;
	}
	
	private PediatricTuberculosisRecordDataSetType createPediatricTuberculosisRecord(Patient pts) {
		PediatricTuberculosisRecordDataSetType mainRecord = new PediatricTuberculosisRecordDataSetType();
		PediatricTuberculosisRecordType record = new PediatricTuberculosisRecordType();
		
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		//record.setTBClinicalScreeningCriteria("");
		//TODO: this is not done at all
		
		mainRecord.getPediatricTuberculosisRecord().add(record);
		return mainRecord;
	}
	
	public void createPediatricTuberculosisFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricTuberculosisRecordDataSetType record = createPediatricTuberculosisRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatrictuberculosis";
		String xsdFileName = "PediatricTuberculosis.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatrictuberculosis.xml";
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricPatientStatusFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricPatientStatusRecordDataSetType record = createPediatricPatientStatusRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod";
		String xsdFileName = "PediatricPatientStatusReviewPeriod.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricpatientstatusreviewperiod.xml";
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricPatientMonitoringFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType record = createPediatricPatientMonitoringRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod";
		String xsdFileName = "PediatricPatientMonitoringReviewPeriod.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricpatientmonitoringreviewperiod.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricPatientDemographicsFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricPatientDemographicsRecordDataSetType record = createPediatricPatientDemographicsRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientdemographics";
		String xsdFileName = "PediatricPatientDemographics.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricpatientdemographics.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricLinkageFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricLinkageRecordDataSetType record = createPediatricLinkageRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriclinkage";
		String xsdFileName = "PediatricLinkage.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatriclinkage.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricEducationFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricEducationRecordDataSetType record = createPediatricEducationRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation";
		String xsdFileName = "PediatricEducation.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatriceducation.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricCotrimoxazoleFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricCotrimoxazoleRecordDataSetType record = createPediatricCotrimoxazoleRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod";
		String xsdFileName = "PediatricCotrimoxazoleReportingPeriod.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatriccotrimoxazolereportingperiod.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricClinicalEvaluationFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricClinicalEvaluationInReviewPeriodRecordDataSetType record = createPediatricClinicalEvaluationRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricclinicalevaluationInreviewperiod";
		String xsdFileName = "Pediatric_ClinicalEvaluationInReviewPeriod.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricclinicalevaluationInreviewperiod.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricBaselineFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricBaselineParametersRecordDataSetType record = createPediatricBaselineRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters";
		String xsdFileName = "Pediatric_BaselineParameters.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricbaselineparameters.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createPediatricARTRegimenFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricARTRegimenSinceStartingTreatmentRecordDataSetType record = createPediatricARTRegimenRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment";
		String xsdFileName = "Pediatric_ARTRegimenSinceStartingTreatment.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricARTRegimenSinceStartingTreatment.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
	public void createAherenceFile(Patient pts) throws JAXBException, SAXException, IOException {
		
		PediatricARTAdherenceRecordDataSetType record = createAdherenceRecord(pts);
		String xsdContextPath = "org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartadherencerecord";
		String xsdFileName = "Pediatric_ART_Adherence.xsd";
		String xmlFile = this.reportFolder + "\\" + "pediatricartadherence.xml";
		
		NigQualUtil.createXMLFile(record, xmlFile, xsdContextPath, xsdFileName);
	}
	
}
