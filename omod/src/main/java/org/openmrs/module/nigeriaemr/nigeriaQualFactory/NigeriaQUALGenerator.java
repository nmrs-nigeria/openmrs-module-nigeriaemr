package org.openmrs.module.nigeriaemr.nigeriaQualFactory;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.DataPatientMonitoringReviewPeriod;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.art.ARTRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.art.ArtRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.artadherencerecord.ARTAdherenceRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.artadherencerecord.ArtAdherenceRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.artregimenduringreviewperiod.ARTRegimenDuringReviewPeriodRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.artregimenduringreviewperiod.ARTRegimenDuringReviewPeriodRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters.BaselineParametersRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters.BaselineParametersRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod.ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod.ClinicalEvaluationVisitsInReviewPeriodRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.cotrimoxazole.COTRIMOXAZOLERecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.cotrimoxazole.COTRIMOXAZOLERecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.hepatitisb.HepatitisBRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.hepatitisb.HepatitisBRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.missedappointmentsandpatienttracking.MissedAppointmentsAndPatientTrackingRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.missedappointmentsandpatienttracking.MissedAppointmentsAndPatientTrackingRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.patientdemographics.PatientDemographicsRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.patientdemographics.PatientDemographicsRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod.PatientStatusDuringReviewPeriodDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod.PatientStatusDuringReviewPeriodRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.tuberculosis.TuberculosisRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.tuberculosis.TuberculosisRecordType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.viralloadtesting.ViralLoadTestingRecordDataSetType;
import org.openmrs.module.nigeriaemr.model.nigeriaqual.viralloadtesting.ViralLoadTestingRecordType;
import org.openmrs.module.nigeriaemr.ndrfactory.ClinicalDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.LabDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.NDRMainDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.PharmacyDictionary;
import org.xml.sax.SAXException;

import org.openmrs.module.nigeriaemr.ndrUtils.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NigeriaQUALGenerator {
	
	private String facilityId;
	
	private Date startDate;
	
	private Date endDate;
	
	public NigeriaQUALGenerator(String facilityId, Date startDate, Date endDate) {
		this.facilityId = facilityId;
		this.startDate = startDate;
		this.endDate = endDate;
		loadRegimenMap();
	}
	
	private HashMap<Integer, Integer> map1;
	
	private void loadRegimenMap(){
		map1 = new HashMap<>();
		map1.put(1652, 1); //"NVP/AZT/3TC"
		map1.put(164854, 2); //"NVP/TDF/FTC"
		map1.put(162565, 2); //"NVP/TDF/3TC"
		map1.put(162199, 4); //"NVP/ABC/3TC"
		map1.put(160124, 5);//"EFV/AZT/3TC"
		map1.put(104565, 6); //"EFV/TDF/FTC"
		map1.put(164505, 6); //"EFV/TDF/3TC"
		map1.put(162563, 8);//"EFV/ABC/3TC"
		map1.put(162201, 11);//"LPVr/TDF/FTC"
		map1.put(162561, 12); // "LPVr/AZT/3TC"
		map1.put(165530, 13); //"LPVr/TDF/AZT/3TC"
		map1.put(162200, 15);//"LPVr/ABC/3TC"
		map1.put(164511,24);//"ATVr/AZT/3TC"
		map1.put(164512, 25);//"ATVr/TDF/3TC"
		map1.put(165537, 26);//"3TC/TDF/AZT/ATVr"
	}
	
	private ARTRecordType artRecordType(Patient pts) {
		// TODO  insert correct data from database
		ARTRecordType dataARTRecord = new ARTRecordType();
		Date artStartDate = Utils.getARTStartDate(pts);
		
		dataARTRecord.setPatientID(Utils.getPatientPEPFARId(pts));
		if (artStartDate != null) {
			dataARTRecord.setPatientEverStartedOnART("yes");
			dataARTRecord.setARTStartDate(Utils.formatDate(artStartDate, "dd/MM/yyyy"));
		} else {
			dataARTRecord.setPatientEverStartedOnART("no");
			dataARTRecord.setARTStartDate("");
		}
		
		dataARTRecord.setFacilityID(this.facilityId);
		dataARTRecord.setUploadDt(Utils.formatDate(new Date(), "dd/MM/yyyy"));
		
		dataARTRecord.setUploaderId("");
		dataARTRecord.setWebUploadFlag("NO");
		dataARTRecord.setReviewPeriodID("1");
		
		return dataARTRecord;
	}
	
	private ARTAdherenceRecordType artAdherenceRecordType(Patient pts) {
		// TODO  insert correct data from database
		ARTAdherenceRecordType artAdherenceRecordType = new ARTAdherenceRecordType();
		
		Obs lastAdherence = Utils.getLastAdherenceObs(pts, endDate);
		Obs highestCD4Obs = Utils.getHighestCD4Obs(pts);
		
		artAdherenceRecordType.setPatientID(Utils.getPatientPEPFARId(pts));
		if (lastAdherence == null) {
			artAdherenceRecordType.setARTAdherenceAssessmentPerformedDuringLast3Months("NO");
			artAdherenceRecordType.setLastDateOfAssessment("");
		} else if (Utils.getDateDiffInMonth(lastAdherence.getObsDatetime(), endDate) <= 3) {
			artAdherenceRecordType.setARTAdherenceAssessmentPerformedDuringLast3Months("YES");
		}
		if (lastAdherence != null) {
			artAdherenceRecordType.setLastDateOfAssessment(Utils.formatDate(lastAdherence.getObsDatetime()));
		}
		
		if (highestCD4Obs != null) {
			artAdherenceRecordType.setHighestCD4SinceARTinitiation(highestCD4Obs.getValueNumeric().toString());
			artAdherenceRecordType.setDateOfHighestCD4Test(Utils.formatDate(highestCD4Obs.getObsDatetime()));
		}
		
		artAdherenceRecordType.setFacilityID(this.facilityId);
		
		return artAdherenceRecordType;
	}
	
	private BaselineParametersRecordType baselineParametersRecordType(Patient pts) {
		// TODO  insert correct data from database
		
		Obs cd4Obs = Utils.getInitialObs(pts, LabDictionary.CD4_Count_Concept_Id);
		Obs weightObs = Utils.getInitialObs(pts, ClinicalDictionary.Weight_Concept_Id);
		Obs whoObs = Utils.getInitialObs(pts, ClinicalDictionary.WHO_Clinical_Stage_Concept_Id);
		
		BaselineParametersRecordType dataBaselineParameters = new BaselineParametersRecordType();
		dataBaselineParameters.setPatientID(Utils.getPatientPEPFARId(pts));
		
		if (cd4Obs != null) {
			dataBaselineParameters.setCD4Count(cd4Obs.getValueNumeric().toString());
			dataBaselineParameters.setCD4CountDate(Utils.formatDate(cd4Obs.getObsDatetime(), "dd/MM/yyyy"));
		}
		
		if (weightObs != null) {
			dataBaselineParameters.setWeight(weightObs.getValueNumeric().toString());
			dataBaselineParameters.setWeightDate(Utils.formatDate(weightObs.getObsDatetime(), "dd/MM/yyyy"));
		}
		
		if (whoObs != null) {
			String whoStage = NigQualUtil.getWHOStageNumber(whoObs);
			dataBaselineParameters.setWHOClinicalStage(whoStage);
			dataBaselineParameters.setWHOClinicalStateDate(Utils.formatDate(whoObs.getObsDatetime(), "dd/MM/yyyy"));
		}
		
		dataBaselineParameters.setFacilityID(this.facilityId);
		
		dataBaselineParameters.setReviewPeriod("1");
		dataBaselineParameters.setUploadDT(Utils.formatDate(new Date()));
		dataBaselineParameters.setUploaderId("7788");
		dataBaselineParameters.setWebUploadFlag("4");
		return dataBaselineParameters;
	}
	
	private ClinicalEvaluationVisitsInReviewPeriodRecordType clinicalEvaluationInReviewPeriod(Patient pts) {
		
		List<Encounter> lastEncounters = Utils.getLastEncounters(pts, endDate);
		
		ClinicalEvaluationVisitsInReviewPeriodRecordType dataClinicalEvaluationInReviewPeriod = new ClinicalEvaluationVisitsInReviewPeriodRecordType();
		dataClinicalEvaluationInReviewPeriod.setPatientID(Utils.getPatientPEPFARId(pts));
		
		Date encounterDate;
		for (int i = 0; i < lastEncounters.size(); i++) {
			encounterDate = lastEncounters.get(i).getEncounterDatetime();
			String dateString = Utils.formatDate(encounterDate);
			if (i == 0) {
				dataClinicalEvaluationInReviewPeriod.setVisit1(dateString);
			}
			if (i == 1) {
				dataClinicalEvaluationInReviewPeriod.setVisit2(dateString);
			}
			if (i == 2) {
				dataClinicalEvaluationInReviewPeriod.setVisit3(dateString);
			}
			if (i == 3) {
				dataClinicalEvaluationInReviewPeriod.setVisit4(dateString);
				break;
			}
		}
		
		dataClinicalEvaluationInReviewPeriod.setFacilityID(this.facilityId);
		dataClinicalEvaluationInReviewPeriod.setReviewPeriodID("1");
		dataClinicalEvaluationInReviewPeriod.setWebUploadFlag("NO");
		return dataClinicalEvaluationInReviewPeriod;
	}
	
	private COTRIMOXAZOLERecordType cotrimoxazole(Patient pts) {
		
		Obs ctx_in_review_period = Utils.getLastObs(pts, ClinicalDictionary.Cotrimoxazole_Adherence_Concept_Id, endDate);
		
		COTRIMOXAZOLERecordType dataCOTRIMOXAZOLE = new COTRIMOXAZOLERecordType();
		dataCOTRIMOXAZOLE.setPatientID(Utils.getPatientPEPFARId(pts));
		
		if (ctx_in_review_period != null) {
			dataCOTRIMOXAZOLE.setPatientReceiveCotrimoxazoleDuringReviewPeriod("Yes");
			dataCOTRIMOXAZOLE.setDateOfLastPrescription(Utils.formatDate(ctx_in_review_period.getObsDatetime()));
			dataCOTRIMOXAZOLE.setPatientCurrentlyOnCotrimoxazoleProphylaxis("Yes");
		} else {
			dataCOTRIMOXAZOLE.setPatientReceiveCotrimoxazoleDuringReviewPeriod("No");
			dataCOTRIMOXAZOLE.setPatientCurrentlyOnCotrimoxazoleProphylaxis("No");
		}
		
		dataCOTRIMOXAZOLE.setFacilityID(this.facilityId);
		dataCOTRIMOXAZOLE.setWebUploadFlag("No");
		dataCOTRIMOXAZOLE.setReviewPeriodID("1");
		return dataCOTRIMOXAZOLE;
	}
	
	private HepatitisBRecordType hepatitisB(Patient pts) {

		//TODO: hB = 159430
		Concept hbConcept = Context.getConceptService().getConcept(159430);
		Optional<Obs> hbsObs =  Context.getObsService().getObservationsByPersonAndConcept(pts.getPerson(), hbConcept)
				.stream().max(Comparator.comparing(Obs::getObsDatetime));


		HepatitisBRecordType dataHepatitisB = new HepatitisBRecordType();
		dataHepatitisB.setPatientID(Utils.getPatientPEPFARId(pts));

		if(hbsObs !=null && hbsObs.isPresent()){
			Obs hb = hbsObs.get();
			dataHepatitisB.setHepatitisBAssayEverDoneForPatient("Yes");
			dataHepatitisB.setResultOfHepatitisBAssay(hb.getValueCoded().getName().getName());
		}
		else{
			dataHepatitisB.setHepatitisBAssayEverDoneForPatient("No");
		}

		Encounter enc = Utils.getLastEncounter(pts, endDate);

		if(enc !=null){
			dataHepatitisB.setClinicalEvaluationARTFormFilledAtLastVisit("Yes");
		}
		else {
			dataHepatitisB.setClinicalEvaluationARTFormFilledAtLastVisit("No");
		}

		dataHepatitisB.setFacilityID(this.facilityId);
		dataHepatitisB.setUploaderId("7788");
		dataHepatitisB.setWebUploadFlag("No");
		dataHepatitisB.setReviewPeriodID("");
		return dataHepatitisB;
	}
	
	private MissedAppointmentsAndPatientTrackingRecordType missedAppointmentsAndPatientTrackingRecordType(Patient pts) {
		// TODO  insert correct data from database
		Date date = new Date();
		MissedAppointmentsAndPatientTrackingRecordType missedAppointmentsAndPatientTrackingRecordType = new MissedAppointmentsAndPatientTrackingRecordType();
		missedAppointmentsAndPatientTrackingRecordType.setPatientID(Utils.getPatientPEPFARId(pts));
		
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setAttemptedContact("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setDateOfAttemptedContact(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setOutcomeOfTracking("Good");
		missedAppointmentsAndPatientTrackingRecordType.setReasonForLTFU("not doing well");
		missedAppointmentsAndPatientTrackingRecordType.setCauseOfDeath("");
		missedAppointmentsAndPatientTrackingRecordType.setCauseOfDeath("");
		missedAppointmentsAndPatientTrackingRecordType.setFacilityID(this.facilityId);
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1Date(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1AttemptedContact("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1AttemptedContactDate(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1OutcomeOfTracking("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1ReasonForLFTU("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment1CauseOfDeath("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2Date(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2AttemptedContact("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2AttemptedContactDate(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2OutcomeOfTracking("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2ReasonForLFTU("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment2CauseOfDeath("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3Date(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3AttemptedContact("Yes");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3AttemptedContactDate(date.toString());
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3OutcomeOfTracking("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3ReasonForLFTU("");
		missedAppointmentsAndPatientTrackingRecordType.setMissedAppointment3CauseOfDeath("");
		missedAppointmentsAndPatientTrackingRecordType.setReviewPeriodID("");
		missedAppointmentsAndPatientTrackingRecordType.setUploaderId("");
		missedAppointmentsAndPatientTrackingRecordType.setUploadDt("");
		missedAppointmentsAndPatientTrackingRecordType.setWebUploadFlag("");
		return missedAppointmentsAndPatientTrackingRecordType;
	}
	
	private PatientDemographicsRecordType patientDemographicsRecordType(Patient pts) {
		
		List<Obs> enrollmentObs = Utils.getHIVEnrollmentObs(pts);
		Obs enrollmentDateObs = Utils.extractObs(NDRMainDictionary.HIV_Enrollment_Date_Concept_Id, enrollmentObs);
		Obs occupationObs = Utils.extractObs(NDRMainDictionary.Patient_Occupation_Code_Concept_Id, enrollmentObs);
		Obs educationalObs = Utils.extractObs(NDRMainDictionary.Patient_Education_Level_Code_Concept_Id, enrollmentObs);
		Obs maritalObs = Utils.extractObs(NDRMainDictionary.Patient_Marital_Status_Code_Concept_Id, enrollmentObs);
		
		Encounter lastEncounter = Utils.getLastEncounter(pts, endDate);
		
		PatientDemographicsRecordType dataPatientDemographics = new PatientDemographicsRecordType();
		dataPatientDemographics.setFirstname("");
		dataPatientDemographics.setLastname("");
		
		if (lastEncounter != null && Utils.getDateDiffInMonth(lastEncounter.getEncounterDatetime(), endDate) <= 3) {
			dataPatientDemographics.setClinicalVisit3MonthsPriorToReview("YES");
		} else {
			dataPatientDemographics.setClinicalVisit3MonthsPriorToReview("NO");
		}
		if (maritalObs != null) {
			dataPatientDemographics.setMaritalStatus(maritalObs.getValueCoded().getName().getName());
		}
		
		dataPatientDemographics.setPatientID(Utils.getPatientPEPFARId(pts));
		dataPatientDemographics.setHosiptalNo(Utils.getPatientHospitalNo(pts));
		dataPatientDemographics.setRNLSerialNO(Utils.getPatientRNLSerialNo(pts));
		dataPatientDemographics.setGender(pts.getGender());
		dataPatientDemographics.setDateofBirth(pts.getPerson().getBirthdate().toString());
		dataPatientDemographics.setAGE(pts.getAge().toString());
		dataPatientDemographics.setHospitalAdmissionDuringReview("NO");
		
		if (occupationObs != null) {
			dataPatientDemographics.setOccupation(occupationObs.getValueCoded().getName().getName());
		}
		if (educationalObs != null) {
			dataPatientDemographics.setEducation(educationalObs.getValueCoded().getName().getName());
		}
		dataPatientDemographics.setWardVillageTownOfResidence(pts.getPersonAddress().getCityVillage());
		dataPatientDemographics.setLGAOfResidence(pts.getPersonAddress().getStateProvince());
		dataPatientDemographics.setStateOfResidence(pts.getPersonAddress().getAddress1());
		dataPatientDemographics.setStateOfOrigin(pts.getPersonAddress().getAddress1());
		dataPatientDemographics.setTribe("");
		dataPatientDemographics.setFacilityID(this.facilityId);
		
		if (enrollmentDateObs != null) {
			dataPatientDemographics.setDateEnrolled(Utils.formatDate(enrollmentDateObs.getValueDate(), "dd/MM/yyyy"));
		}
		
		dataPatientDemographics.setWebUploadFlag("4");
		dataPatientDemographics.setReviewPeriod("");
		return dataPatientDemographics;
	}
	
	private PatientStatusDuringReviewPeriodRecordType patientStatusDuringReviewPeriodRecordType(Patient pts) {
		
		Obs patientStatusObs = Utils.getReasonForTerminationObs(pts);
		
		PatientStatusDuringReviewPeriodRecordType dataPatientStatusReviewPeriod = new PatientStatusDuringReviewPeriodRecordType();
		dataPatientStatusReviewPeriod.setPatientID(Utils.getPatientPEPFARId(pts));
		dataPatientStatusReviewPeriod.setFacilityID(this.facilityId);
		
		if (patientStatusObs != null && patientStatusObs.getValueCoded() != null) {
			switch (patientStatusObs.getValueCoded().getConceptId()) {
				case 159492: //transferred out
					dataPatientStatusReviewPeriod.setStatus("TRANSFERRED OUT");
					dataPatientStatusReviewPeriod.setTransferredOut("Yes");
					dataPatientStatusReviewPeriod.setDateOfStatusChange(Utils.formatDate(patientStatusObs.getObsDatetime()));
					dataPatientStatusReviewPeriod.setTransferredOutDate(Utils.formatDate(patientStatusObs.getObsDatetime()));
					break;
				case 142928: //death by electrocution
					dataPatientStatusReviewPeriod.setStatus("DEATH");
					dataPatientStatusReviewPeriod.setDeath("Yes");
					dataPatientStatusReviewPeriod.setDateOfStatusChange(Utils.formatDate(patientStatusObs.getObsDatetime()));
					dataPatientStatusReviewPeriod.setDeathDate(Utils.formatDate(patientStatusObs.getObsDatetime()));
					break;
				default:
					dataPatientStatusReviewPeriod.setDeath("No");
					dataPatientStatusReviewPeriod.setTransferredOut("No");
					dataPatientStatusReviewPeriod.setDiscontinuedCare("No");
			}
		}
		
		/*dataPatientStatusReviewPeriod.setDiscontinuedCare("Yes");
		dataPatientStatusReviewPeriod.setDiscontinuedCareDate(date.toString());
		dataPatientStatusReviewPeriod.setDiscontinuedCareReason("");
		dataPatientStatusReviewPeriod.setDiscontinuedCareReasonOther("2 Month");*/
		
		return dataPatientStatusReviewPeriod;
	}
	
	private ARTRegimenDuringReviewPeriodRecordType aRTRegimenDuringReviewPeriodRecordType(Patient pts) {

		Date artStartDate =  Utils.getARTStartDate(pts);

		ARTRegimenDuringReviewPeriodRecordType dataRegimenDuringReview = new ARTRegimenDuringReviewPeriodRecordType();
		dataRegimenDuringReview.setPatientID(Utils.getPatientPEPFARId(pts));
		if(artStartDate!=null && artStartDate.before(startDate)) {
			dataRegimenDuringReview.setPatientOnARTFirstDayOFReviewPeriod("Yes");
		}
		else{
			dataRegimenDuringReview.setPatientOnARTFirstDayOFReviewPeriod("No");
		}
		if(artStartDate!=null && artStartDate.before(endDate)) {
			dataRegimenDuringReview.setPatientOnARTAnytimeDuringReviewPeriod("Yes");
		}
		else {
			dataRegimenDuringReview.setPatientOnARTAnytimeDuringReviewPeriod("No");
		}

		List<Encounter> pharmacyEnc = Utils.getAllRegimenObs(pts);

		if(pharmacyEnc.size() > 0){
			Obs firstRegimen = Utils.getRegimenFromObs( new ArrayList<>(pharmacyEnc.get(0).getAllObs()));

			if(firstRegimen !=null){
				Obs durationObs = Utils.extractObs(PharmacyDictionary.Medication_Duration_Concept_Id, new ArrayList<>(pharmacyEnc.get(0).getAllObs()));

				int drugDuration =0;
				if(durationObs !=null) {
					drugDuration = (int) Math.round(durationObs.getValueNumeric());
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(firstRegimen.getObsDatetime());
				cal.add(Calendar.DATE, drugDuration);

				dataRegimenDuringReview.set1STRegimen(String.valueOf(map1.get(firstRegimen.getValueCoded().getConceptId())));
				dataRegimenDuringReview.set1StRegimenStartDate(Utils.formatDate(firstRegimen.getObsDatetime()));
				dataRegimenDuringReview.set1StRegimenChangeDate(Utils.formatDate(cal.getTime()));
			}

			if(pharmacyEnc.size() > 1){
				Obs secondRegimen = Utils.getRegimenFromObs( new ArrayList<>(pharmacyEnc.get(1).getAllObs()));
				if(secondRegimen !=null){
					Obs durationObs = Utils.extractObs(PharmacyDictionary.Medication_Duration_Concept_Id, new ArrayList<>(pharmacyEnc.get(1).getAllObs()));

					int drugDuration = 0;
					if(durationObs !=null){
						drugDuration = (int) Math.round(durationObs.getValueNumeric());
					}
					Calendar cal = Calendar.getInstance();
					cal.setTime(secondRegimen.getObsDatetime());
					cal.add(Calendar.DATE, drugDuration);

					dataRegimenDuringReview.set2NdRegimen(String.valueOf(map1.get(secondRegimen.getValueCoded().getConceptId())));
					dataRegimenDuringReview.set2NdRegimenStartDate(Utils.formatDate(secondRegimen.getObsDatetime()));
					dataRegimenDuringReview.set2NdRegimenChangeDate(Utils.formatDate(cal.getTime()));
				}
			}

			if(pharmacyEnc.size() > 2){
				Obs thirdRegimen = Utils.getRegimenFromObs( new ArrayList<>(pharmacyEnc.get(2).getAllObs()));
				if(thirdRegimen !=null){
					Obs durationObs = Utils.extractObs(PharmacyDictionary.Medication_Duration_Concept_Id, new ArrayList<>(pharmacyEnc.get(1).getAllObs()));
					int drugDuration = (int) Math.round(durationObs.getValueNumeric());
					Calendar cal = Calendar.getInstance();
					cal.setTime(thirdRegimen.getObsDatetime());
					cal.add(Calendar.DATE, drugDuration);

					dataRegimenDuringReview.set3RdRegimen(String.valueOf(map1.get(thirdRegimen.getValueCoded().getConceptId())));
					dataRegimenDuringReview.set3RdRegimenStartDate(Utils.formatDate(thirdRegimen.getObsDatetime()));
					dataRegimenDuringReview.set3RdRegimenChangeDate(Utils.formatDate(cal.getTime()));
				}
			}

			Obs lastRegimen = Utils.getRegimenFromObs( new ArrayList<>(pharmacyEnc.get(pharmacyEnc.size()-1).getAllObs()));
			if(lastRegimen !=null){
				dataRegimenDuringReview.setDateofLastDrugPickup(Utils.formatDate(lastRegimen.getObsDatetime()));
			}
		}
		//dataRegimenDuringReview.setOtherRegimenSpecify("Dead");

		dataRegimenDuringReview.setFacilityID(this.facilityId);
		dataRegimenDuringReview.setReviewPeriod("1");
		dataRegimenDuringReview.setUploaderId("8");
		dataRegimenDuringReview.setWebUploadFlag("4");
		return dataRegimenDuringReview;
	}
	
	private TuberculosisRecordType tuberculosisRecordType(Patient pts) {
		
		List<Obs> careCardBeforeReviewPeriodObs = Utils.getCareCardObs(pts, startDate);
		List<Obs> careCardWithinReviewPeriodObs = Utils.getCareCardObs(pts, endDate);
		
		//TODO: 1659 tb status, 160170 OI infections, 143264 = cough, 140238 = Fever
		int TB_Status_Concept_Id = 1659;
		int OI_Infection_Concept_Id = 160170;
		
		Obs TbObsPrior = Utils.extractObs(TB_Status_Concept_Id, careCardBeforeReviewPeriodObs);
		Obs TbObsWithinReview = Utils.extractObs(TB_Status_Concept_Id, careCardWithinReviewPeriodObs);
		Obs OIObs = Utils.extractObs(OI_Infection_Concept_Id, careCardWithinReviewPeriodObs);
		
		TuberculosisRecordType tuberculosisRecordType = new TuberculosisRecordType();
		tuberculosisRecordType.setPatientID(Utils.getPatientPEPFARId(pts));
		
		if (TbObsPrior != null) {
			tuberculosisRecordType.setPatientOnTBTreatmentAtStartOfReviewPeriod("Yes");
		}
		if (TbObsWithinReview != null) {
			tuberculosisRecordType.setPatientClinicallyScreenForTBDuringReviewPeriod("Yes");
		}
		if (OIObs != null
		        && (OIObs.getValueCoded().getConceptId() == 143264 || OIObs.getValueCoded().getConceptId() == 140238)) {
			tuberculosisRecordType.setTBClinicalScreeningCriteria(OIObs.getValueCoded().getName().getName());
			tuberculosisRecordType.setTBScreeningCriteriaCurrentCough("Yes");
		}
		//TODO: TB suspected = 142177
		if (TbObsWithinReview != null && TbObsWithinReview.getValueCoded().getConceptId() == 142177) {
			tuberculosisRecordType.setBasedOnScreeningWasPatientedSuspectedToHaveTB("Yes");
		} else {
			tuberculosisRecordType.setBasedOnScreeningWasPatientedSuspectedToHaveTB("No");
		}
		//tuberculosisRecordType.setPatientHaveCRXPerformedDuringReviewPeriod("No");
		//tuberculosisRecordType.setPatientReferredToDOTsClinic("3TC");
		//tuberculosisRecordType.setPatientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture("3TC");
		//TODO: Confirmed TB = 1661
		if (TbObsWithinReview != null && TbObsWithinReview.getValueCoded().getConceptId() == 1661) {
			tuberculosisRecordType.setPatientDiagnosedOfTBInReviewPeriod("Yes");
			tuberculosisRecordType.setTBDiagnosisDate(Utils.formatDate(TbObsWithinReview.getObsDatetime(), "dd/MM/yyyy"));
		} else {
			tuberculosisRecordType.setPatientDiagnosedOfTBInReviewPeriod("No");
		}
		
		if (TbObsWithinReview != null && TbObsWithinReview.getValueCoded().getConceptId() == 1662) {
			tuberculosisRecordType.setPatientStartTBTreatment("Yes");
			tuberculosisRecordType
			        .setTBTreatmentStartDate(Utils.formatDate(TbObsWithinReview.getObsDatetime(), "dd/MM/yyyy"));
		} else {
			tuberculosisRecordType.setPatientStartTBTreatment("No");
		}
		
		//tuberculosisRecordType.setTBScreeningCriteriaContactHistoryWithTBCase("");
		
		tuberculosisRecordType.setTBScreeningCriteriaPoorWeightGain("");
		
		tuberculosisRecordType.setFacilityID(this.facilityId);
		tuberculosisRecordType.setReviewPeriodID("1");
		tuberculosisRecordType.setWebUploadFlag("");
		return tuberculosisRecordType;
	}
	
	private ViralLoadTestingRecordType viralLoadTestingRecordType(Patient pts) {

		//TODO: Viral Load = 856
		Concept vlConcept = Context.getConceptService().getConcept(LabDictionary.Viral_Load_CONCEPT_ID);
		Optional<Obs> vlsObs = Context.getObsService().getObservationsByPersonAndConcept(pts.getPerson(), vlConcept)
		        .stream().max(Comparator.comparing(Obs::getObsDatetime));
		
		ViralLoadTestingRecordType viralLoadTestingRecordType = new ViralLoadTestingRecordType();
		if (vlsObs != null && vlsObs.isPresent()) {
			viralLoadTestingRecordType.setHasPatientReceivedVLTesting("Yes");
			viralLoadTestingRecordType.setResultCopiesPerMl(vlsObs.get().getValueNumeric().toString());
			viralLoadTestingRecordType.setVLTestDate(Utils.formatDate(vlsObs.get().getObsDatetime()));
		} else {
			viralLoadTestingRecordType.setHasPatientReceivedVLTesting("No");
		}
		viralLoadTestingRecordType.setPatientID(Utils.getPatientPEPFARId(pts));
		
		viralLoadTestingRecordType.setFacilityID(this.facilityId);
		
		viralLoadTestingRecordType.setUploaderId("");
		viralLoadTestingRecordType.setWebUploadFlag("");
		viralLoadTestingRecordType.setReviewPeriodID("1");
		return viralLoadTestingRecordType;
	}
	
	private DataPatientMonitoringReviewPeriod createPatientMonitoringReviewPeriod(Patient pts) {
		
		List<Obs> altObs = Utils.getObs(pts, LabDictionary.ALT_SGPT_CONCEPT_ID);
		int altCount = altObs.size();
		List<Obs> cd4Obs = Utils.getObs(pts, LabDictionary.CD4_Count_Concept_Id);
		int cd4Count = cd4Obs.size();
		List<Obs> creatinineObs = Utils.getObs(pts, LabDictionary.SERUM_CREATININE_CONCEPT_ID);
		int cretinineCount = creatinineObs.size();
		List<Obs> pctHCTObs = Utils.getObs(pts, LabDictionary.PCV_HCT_CONCEPT_ID);
		int pctCount = pctHCTObs.size();
		List<Obs> whoObs = Utils.getObs(pts, LabDictionary.WHO_STAGING_CONCEPT_ID);
		int whoCount = whoObs.size();
		List<Obs> weightObs = Utils.getObs(pts, LabDictionary.WEIGHT_CONCEPT_ID);
		int weightCount = weightObs.size();
		
		DataPatientMonitoringReviewPeriod record = new DataPatientMonitoringReviewPeriod();
		for (int i = 0; i <= 4; i++) {
			
			if (i == 0) {
				if (altCount > i) {
					Obs alt1 = altObs.get(i);
					record.setAlt1(alt1.getValueNumeric());
					record.setAlt1Date(alt1.getObsDatetime());
				}
				if (cd4Count > i) {
					Obs cd41 = cd4Obs.get(i);
					record.setCd4Value1(cd41.getValueNumeric());
					record.setCd4Value1Date(cd41.getObsDatetime());
				}
				if (cretinineCount > i) {
					Obs cretinine1 = creatinineObs.get(i);
					record.setCreatinine1(cretinine1.getValueNumeric());
					record.setCreatinine1Date(cretinine1.getObsDatetime());
				}
				if (whoCount > i) {
					Obs who1 = whoObs.get(i);
					
					record.setWho1(who1.getValueNumeric());
					record.setWho1Date(who1.getObsDatetime());
				}
				if (pctCount > i) {
					Obs pct1 = pctHCTObs.get(i);
					record.setPctHct1(pct1.getValueNumeric());
					record.setPctHct1Date(pct1.getObsDatetime());
				}
				if (weightCount > i) {
					Obs weight1 = weightObs.get(i);
					record.setWeight1(weight1.getValueNumeric());
					record.setWeight1Date(weight1.getObsDatetime());
				}
			}
			if (i == 1) {
				if (altCount > i) {
					Obs alt1 = altObs.get(i);
					record.setAlt2(alt1.getValueNumeric());
					record.setAlt2Date(alt1.getObsDatetime());
				}
				if (cd4Count > i) {
					Obs cd41 = cd4Obs.get(i);
					record.setCd4Value2(cd41.getValueNumeric());
					record.setCd4Value2Date(cd41.getObsDatetime());
				}
				if (cretinineCount > i) {
					Obs cretinine1 = creatinineObs.get(i);
					record.setCreatinine2(cretinine1.getValueNumeric());
					record.setCreatinine2Date(cretinine1.getObsDatetime());
				}
				if (whoCount > i) {
					Obs who1 = whoObs.get(i);
					record.setWho2(who1.getValueNumeric());
					record.setWho2Date(who1.getObsDatetime());
				}
				if (pctCount > i) {
					Obs pct1 = pctHCTObs.get(i);
					record.setPctHct2(pct1.getValueNumeric());
					record.setPctHct2Date(pct1.getObsDatetime());
				}
				if (weightCount > i) {
					Obs weight1 = weightObs.get(i);
					record.setWeight2(weight1.getValueNumeric());
					record.setWeight2Date(weight1.getObsDatetime());
				}
			}
			if (i == 2) {
				if (altCount > i) {
					Obs alt1 = altObs.get(i);
					record.setAlt3(alt1.getValueNumeric());
					record.setAlt3Date(alt1.getObsDatetime());
				}
				if (cd4Count > i) {
					Obs cd41 = cd4Obs.get(i);
					record.setCd4Value3(cd41.getValueNumeric());
					record.setCd4Value3Date(cd41.getObsDatetime());
				}
				if (cretinineCount > i) {
					Obs cretinine1 = creatinineObs.get(i);
					record.setCreatinine3(cretinine1.getValueNumeric());
					record.setCreatinine3Date(cretinine1.getObsDatetime());
				}
				if (whoCount > i) {
					Obs who1 = whoObs.get(i);
					record.setWho3(who1.getValueNumeric());
					record.setWho3Date(who1.getObsDatetime());
				}
				if (pctCount > i) {
					Obs pct1 = pctHCTObs.get(i);
					record.setPctHct3(pct1.getValueNumeric());
					record.setPctHct3Date(pct1.getObsDatetime());
				}
				if (weightCount > i) {
					Obs weight1 = weightObs.get(i);
					record.setWeight3(weight1.getValueNumeric());
					record.setWeight3Date(weight1.getObsDatetime());
				}
			}
			
			if (i == 3) {
				if (altCount > i) {
					Obs alt1 = altObs.get(i);
					record.setAlt4(alt1.getValueNumeric());
					record.setAlt4Date(alt1.getObsDatetime());
				}
				if (cd4Count > i) {
					Obs cd41 = cd4Obs.get(i);
					record.setCd4Value4(cd41.getValueNumeric());
					record.setCd4Value4Date(cd41.getObsDatetime());
				}
				if (cretinineCount > i) {
					Obs cretinine1 = creatinineObs.get(i);
					record.setCreatinine4(cretinine1.getValueNumeric());
					record.setCreatinine4Date(cretinine1.getObsDatetime());
				}
				if (whoCount > i) {
					Obs who1 = whoObs.get(i);
					record.setWho4(who1.getValueNumeric());
					record.setWho4Date(who1.getObsDatetime());
				}
				if (pctCount > i) {
					Obs pct1 = pctHCTObs.get(i);
					record.setPctHct4(pct1.getValueNumeric());
					record.setPctHct4Date(pct1.getObsDatetime());
				}
				if (weightCount > i) {
					Obs weight1 = weightObs.get(i);
					record.setWeight4(weight1.getValueNumeric());
					record.setWeight4Date(weight1.getObsDatetime());
				}
			}
		}
		record.setFacilityID(this.facilityId);
		record.setPatientID(Utils.getPatientPEPFARId(pts));
		record.setWebUploadFlag("");
		record.setUploaderId("");
		record.setUploadDt(new Date());
		record.setReviewPeriodID(0);
		
		return record;
	}
	
	private String formatDefault(String d) {
		String date = d;
		if (d != null && d.isEmpty()) {
			date = "01/01/1900";
		}
		return date;
	}
	
	public void createPatientMonitoringReviewPeriodFile(Patient pts, String reportFolder) throws XMLStreamException,
	        IOException {
		
		DataPatientMonitoringReviewPeriod ele = createPatientMonitoringReviewPeriod(pts);
		
		String xmlFile = reportFolder + "\\" + "PatientMonitoringReviewPeriod.xml";
		
		File dfile = new File(xmlFile);
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(dfile));
		writer.writeStartElement("PatientMonitoringDuringReviewPeriod_Record");
		
		writer.writeStartElement("PatientID");
		writer.writeCharacters(StringUtils.trim(ele.getPatientID()));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH001_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCd4Value1())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH001_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCd4Value1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH002_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCd4Value2())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH002_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCd4Value2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH003_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCd4Value3())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH003_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCd4Value3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH004_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCd4Value4())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH004_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCd4Value4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH005_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getPctHct1())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADHOO5_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getPctHct1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH006_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getPctHct2())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH006_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getPctHct2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH007_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getPctHct3())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH007_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getPctHct3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH008_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getPctHct4())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH008_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getPctHct4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH009_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getWeight1())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH009_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWeight1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH010_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getWeight2())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH010_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWeight2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH011_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getWeight3())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH011_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWeight3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH012_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getWeight4())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH012_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWeight4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH013_Value");
		writer.writeCharacters(String.valueOf(ele.getWho1()));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH013_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWho1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH014_Value");
		writer.writeCharacters(String.valueOf(ele.getWho2()));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH014_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWho2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH015_Value");
		writer.writeCharacters(String.valueOf(ele.getWho3()));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH015_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWho3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH016_Value");
		writer.writeCharacters(String.valueOf(ele.getWho4()));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH016_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getWho4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH017_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCreatinine1())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH017_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCreatinine1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH018_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCreatinine2())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH018_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCreatinine2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH019_VALUE");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCreatinine3())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH019_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCreatinine3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH020_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getCreatinine4())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH020_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getCreatinine4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH021_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getAlt1())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH021_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getAlt1Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH022_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getAlt2())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH022_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getAlt2Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH023_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getAlt3())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH023_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getAlt3Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH024_Value");
		writer.writeCharacters(String.valueOf(Math.round(ele.getAlt4())));
		writer.writeEndElement();
		
		writer.writeStartElement("ADH024_TestDate");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getAlt4Date()))));
		writer.writeEndElement();
		
		writer.writeStartElement("FacilityID");
		writer.writeCharacters(String.valueOf(ele.getFacilityID()));
		writer.writeEndElement();
		
		writer.writeStartElement("UploaderId");
		writer.writeCharacters(ele.getUploaderId());
		writer.writeEndElement();
		
		writer.writeStartElement("UploadDt");
		writer.writeCharacters(formatDefault(Utils.formatDate((ele.getUploadDt()))));
		writer.writeEndElement();
		
		writer.writeStartElement("webUploadFlag");
		writer.writeCharacters(ele.getWebUploadFlag());
		writer.writeEndElement();
		
		writer.writeStartElement("ReviewPeriodID");
		writer.writeCharacters(String.valueOf(ele.getReviewPeriodID()));
		writer.writeEndElement();
		
		writer.writeEndElement();
	}
	
	private Marshaller createNigeriaQualMarshaller(JAXBContext jaxbContext) throws JAXBException, SAXException {
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		java.net.URL xsdFilePath = Thread.currentThread().getContextClassLoader().getResource("art_adherence.xsd");
		assert xsdFilePath != null;
		
		/*File schemeFile = new File(
		        "C:\\MGIC\\Project\\JavaProjects\\OpenMRS\\nigeriaemr\\api\\src\\main\\java\\org\\openmrs\\module\\nigeriaemr\\model\\nigeriaqual\\artadherencerecord\\art_adherence.xsd");
		Schema schema = sf.newSchema(schemeFile);*/
		
		Schema schema = sf.newSchema(xsdFilePath);
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		jaxbMarshaller.setSchema(schema);
		
		//Call Validator class to perform the validation
		jaxbMarshaller.setEventHandler(new Validator());
		return jaxbMarshaller;
	}
	
	public void createArtAdherenceFile(Patient patient, String reportFolder) throws IOException, SAXException, JAXBException {
		
		ARTAdherenceRecordType record = artAdherenceRecordType(patient);
		ArtAdherenceRecordDataSetType setType = new ArtAdherenceRecordDataSetType();
		setType.getARTAdherenceRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "art_adherence.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.artadherencerecord");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
		
	}
	
	public void createArtFile(Patient patient, String reportFolder) throws IOException, SAXException, JAXBException {
		
		ArtRecordDataSetType setType = new ArtRecordDataSetType();
		ARTRecordType record = artRecordType(patient);
		setType.getARTRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "art.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.art");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createARTRegimenFile(Patient patient, String reportFolder) throws IOException, SAXException, JAXBException {
		
		ARTRegimenDuringReviewPeriodRecordDataSetType setType = new ARTRegimenDuringReviewPeriodRecordDataSetType();
		ARTRegimenDuringReviewPeriodRecordType record = aRTRegimenDuringReviewPeriodRecordType(patient);
		setType.getARTRegimenDuringReviewPeriodRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "artregimenduringreviewperiod.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.artregimenduringreviewperiod");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createBaselineParametersFile(Patient patient, String reportFolder) throws IOException, SAXException,
	        JAXBException {
		
		BaselineParametersRecordDataSetType setType = new BaselineParametersRecordDataSetType();
		BaselineParametersRecordType record = baselineParametersRecordType(patient);
		setType.getBaselineParametersRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "baselineparameters.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createClinicalEvaluationVisitsFile(Patient patient, String reportFolder) throws IOException, SAXException,
	        JAXBException {
		
		ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType setType = new ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType();
		ClinicalEvaluationVisitsInReviewPeriodRecordType record = clinicalEvaluationInReviewPeriod(patient);
		setType.getClinicalEvaluationVisitsInReviewPeriodRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "clinicalevaluationvisitsinreviewperiod.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createCOTRIMOXAZOLEFile(Patient patient, String reportFolder) throws IOException, SAXException,
	        JAXBException {
		
		COTRIMOXAZOLERecordDataSetType setType = new COTRIMOXAZOLERecordDataSetType();
		COTRIMOXAZOLERecordType record = cotrimoxazole(patient);
		setType.getCOTRIMOXAZOLERecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "cotrimoxazole.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.cotrimoxazole");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createHepatitisBFile(Patient patient, String reportFolder) throws IOException, SAXException, JAXBException {
		
		HepatitisBRecordDataSetType setType = new HepatitisBRecordDataSetType();
		HepatitisBRecordType record = hepatitisB(patient);
		setType.setHepatitisBRecord(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "hepatitisb.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.hepatitisb");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createMissedAppointmentsAndPatientTrackingFile(Patient patient, String reportFolder) throws IOException,
	        SAXException, JAXBException {
		
		MissedAppointmentsAndPatientTrackingRecordDataSetType setType = new MissedAppointmentsAndPatientTrackingRecordDataSetType();
		MissedAppointmentsAndPatientTrackingRecordType record = missedAppointmentsAndPatientTrackingRecordType(patient);
		setType.setMissedAppointmentsAndPatientTrackingRecord(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "missedappointmentsandpatienttracking.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.missedappointmentsandpatienttracking");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createPatientDemographicFile(Patient patient, String reportFolder) throws IOException, SAXException,
	        JAXBException {
		
		PatientDemographicsRecordDataSetType setType = new PatientDemographicsRecordDataSetType();
		PatientDemographicsRecordType record = patientDemographicsRecordType(patient);
		setType.getPatientDemographicsRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "patientdemographics.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.patientdemographics");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createTuberculosisFile(Patient patient, String reportFolder) throws IOException, SAXException, JAXBException {
		
		TuberculosisRecordDataSetType setType = new TuberculosisRecordDataSetType();
		TuberculosisRecordType record = tuberculosisRecordType(patient);
		setType.getTuberculosisRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "tuberculosis.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.tuberculosis");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createViralLoadTestingFile(Patient patient, String reportFolder) throws IOException, SAXException,
	        JAXBException {
		
		ViralLoadTestingRecordDataSetType setType = new ViralLoadTestingRecordDataSetType();
		ViralLoadTestingRecordType record = viralLoadTestingRecordType(patient);
		setType.getViralLoadTestingRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "viralloadtesting.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.viralloadtesting");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public void createPatientStatusDuringReviewPeriodFile(Patient patient, String reportFolder) throws IOException,
	        SAXException, JAXBException {
		
		PatientStatusDuringReviewPeriodDataSetType setType = new PatientStatusDuringReviewPeriodDataSetType();
		PatientStatusDuringReviewPeriodRecordType record = patientStatusDuringReviewPeriodRecordType(patient);
		setType.getPatientStatusDuringReviewPeriodRecord().add(record);
		
		Boolean b;
		String xmlFile = reportFolder + "\\" + "patientstatusduringreviewperiod.xml";
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext
		        .newInstance("org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod");
		Marshaller jaxbMarshaller = createNigeriaQualMarshaller(jaxbContext);
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(setType, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
}
