package org.openmrs.module.nigeriaemr.ndrUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.*;
import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.model.ndr.EncountersType;
import org.openmrs.module.nigeriaemr.model.ndr.FacilityType;
import org.openmrs.module.nigeriaemr.ndrfactory.ClinicalDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.LabDictionary;
import org.openmrs.module.nigeriaemr.ndrfactory.PharmacyDictionary;
import org.openmrs.module.nigeriaemr.omodmodels.Version;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.openmrs.module.nigeriaemr.util.ZipUtil;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.util.OpenmrsUtil;

public class Utils {
	
	public final static int HIV_Enrollment_Encounter_Type_Id = 14;
	
	public final static int Pharmacy_Encounter_Type_Id = 13;
	
	public final static int Laboratory_Encounter_Type_Id = 11;
	
	public final static int Care_card_Encounter_Type_Id = 12;
	
	public final static int Adult_Ped_Initial_Encounter_Type_Id = 8;
	
	public final static int Client_Tracking_And_Termination_Encounter_Type_Id = 15;
	
	public final static int Client_Intake_Form_Encounter_Type_Id = 20;
	
	public final static int Patient_PEPFAR_Id = 4;
	
	public final static int Patient_Hospital_Id = 3;
	
	public final static int Patient_RNLSerial_No = 3;
	
	public final static int Reason_For_Termination = 165470;
	
	public final static int Antenatal_Registration_Encounter_Type_Id = 10;
	
	public final static int Delivery_Encounter_Type_Id = 16;
	
	public final static int Child_Birth_Detail_Encounter_Type_Id = 9;
	
	public final static int Child_Followup_Encounter_Type_Id = 18;
	
	public final static int Partner_register_Encounter_Id = 19;//Check this data from the database when there is record
	
	public final static int Admission_Simple_Client_intake = 2;
	
	/* RegimenType specific concepts by Bright */
	public final static int CURRENT_REGIMEN_LINE_CONCEPT = 165708; // From Pharmacy Form
	
	public final static int ADULT_FIRST_LINE_REGIMEN_CONCEPT = 164506; // From Pharmacy Form
	
	public final static int ADULT_SECOND_LINE_REGIMEN_CONCEPT = 164513; // From Pharmacy Form
	
	public final static int ADULT_THRID_LINE_REGIMEN_CONCEPT = 165702; // From Pharmacy Form
	
	public final static int CHILD_FIRST_LINE_REGIMEN_CONCEPT = 164507; // From Pharmacy Form
	
	public final static int CHILD_SECOND_LINE_REGIMEN_CONCEPT = 164514; // From Pharmacy Form
	
	public final static int CHILD_THRID_LINE_REGIMEN_CONCEPT = 165703; // From Pharmacy Form
	
	public final static int PICKUP_REASON_CONCEPT = 165774; // From Pharmacy Form
	
	public final static int PICKUP_REASON_CONCEPT_SUBSTITUTE_VALUE = 165665; // From Pharmacy Form
	
	public final static int PICKUP_REASON_CONCEPT_SWITCH_VALUE = 165772;// From Pharmacy Order Form
	
	public final static int REGIMEN_MEDICATION_PLAN = 165771;// From Care Card Follow Up
	
	public final static int REGIMEN_MEDICATION_PLAN_SUBSTITUTE_REGIMEN_CONCEPT_VALUE = 165769;// From Care Card Follow Up Answer to Regimen Medication Plan
	
	public final static int REGIMEN_MEDICATION_PLAN_SWITCH_REGIMEN_CONCEPT_VALUE = 165768;// From Care Card
	
	public final static int REASON_FOR_REGIMEN_SUBSTITUTION_OR_SWITCH_CONCEPT = 165056; // From Care Card Follow Up
	
	public final static int ARV_DRUGS_GROUPING_CONCEPT_SET = 162240;// Human immunodeficiency virus treatment regimen from Pharmacy Form
	
	public final static int MEDICATION_DURATION_CONCEPT = 159368;// Medication Duration Concept From Pharmacy Form
	
	public final static int OI_DRUGS_GROUPING_CONCEPT_SET = 165726;//OI Medication Grouping Concept from Pharmacy Form
	
	public final static int OI_DRUGS_CONCEPT = 165727; // OI Drugs Concept from Pharmacy Form
	
	public final static String ART_CODE = "ART"; // Code for ART
	
	public final static int VISIT_TYPE_CONCEPT = 164181; // Visit Type concept from Pharmacy Forms
	
	public final static int VISIT_TYPE_INITIAL_CONCEPT = 164180; // Initial Visit from Pharmacy Forms
	
	public final static int VISIT_TYPE_FOLLOWUP_CONCEPT = 160530; // Follow up Visit from Pharmacy Forms
	
	public final static int NEXT_APPOINTMENT_DATE_CONCEPT = 5096; // Next Appointment Date Concept Care Card
	
	public final static int NUMBER_OF_MISSED_DOSES_PER_MONTH_CONCEPT = 165836;// From Pharmacy Form
	
	public final static int MISSED_DOSES_FAIR_ADHERENCE_CONCEPT = 165834;// FAIR ADHERENCE
	
	public final static int MISSED_MEDICATION_POOR_ADHERENCE_CONCEPT = 165835;// POOR ADHERENCE
	
	public final static int ARV_ADHERENCE_CONCEPT = 165290;// ARV ADHERENCE CONCEPT From Care Card
	
	public final static int ARV_ADHERENCE_FAIR_ADHERENCE_CONCEPT = 165288; // ARV ADHERENCE From Care Card
	
	public final static int ARV_ADHERENCE_POOR_ADHERENCE_CONCEPT = 165289; // ARV ADHERENCE From Care Card
	
	public final static List<Integer> encounterTypeIds = Arrays.asList(ConstantsUtil.ADMISSION_ENCOUNTER_TYPE,
	    Utils.Laboratory_Encounter_Type_Id, Utils.PHARMACY_ENCOUNTER_TYPE, Utils.Partner_register_Encounter_Id);
	
	/* End of RegimenType Constant */
	/*

	
	
	-WhereFirstHIVTest
	
	-
	
	-InitialAdherenceCounselingCompletedDate (165038)
	-TransferredInDate (160534)
	-TransferredInFrom (160535)
	-TransferredInFromPatId
	-FirstARTRegimen (165708)(164506,164513,165702,164507,164514,165703)
	-ARTStartDate (159599)
	-WHOClinicalStageARTStart (5356)
	-WeightAtARTStart (165582)
	-ChildHeightAtARTStart (165581)
	-FunctionalStatusStartART (165039)
	-CD4AtStartOfART (164429)
	-PatientTransferredOut (165470)(159492)
	-TransferredOutStatus(165470)(159492)
	-TransferredOutDate (165469)
	-FacilityReferredTo
	-PatientHasDied (165470)(165889)
	-StatusAtDeath
	-DeathDate(165469)
	-SourceOfDeathInformation (162568)
	-CauseOfDeathHIVRelated (165889,(165886,165887)) (163534,Yes(1065),No(1066))
	-DrugAllergies (165419)
	-EnrolledInHIVCareDate
	-InitialTBStatus (1659)
	   
	    */
	/* Variables specific to HIVQuestionsType */
	public final static int DATE_OF_HIV_DIAGNOSIS_CONCEPT = 160554;
	
	public final static int MODE_OF_HIV_TEST = 164947;
	
	public final static int CARE_ENTRY_POINT_CONCEPT = 160540;
	
	public final static int FACILITY_TRANSFERRED_FROM = 160535;
	
	public final static int REASON_FOR_TERMINATION_CONCEPT = 165470;
	
	public final static int DEAD_CONCEPT = 165889;
	
	public final static int PRIOR_ART_CONCEPT = 165242;
	
	public final static int MEDICAL_ELIGIBLE_DATE_CONCEPT = 162227;
	
	public final static int REASON_MEDICALLY_ELIGIBLE_CONCEPT = 162225;
	
	public final static int DATE_INITIAL_ADHERENCE_COUNCELING_CONCEPT = 165038;
	
	public final static int WHO_CLINICAL_STAGGING_AT_START_CONCEPT = 5356;
	
	public final static int WEIGHT_AT_START_CONCEPT = 165582;
	
	public final static int CHILD_HEIGHT_AT_START = 165581;
	
	public final static int FUNCTIONAL_STATUS_ART_START = 165039;
	
	public final static int CD4_AT_START = 164429;
	
	public final static int TRANSFER_OUT_DATE = 165469;
	
	public final static int DEATH_DATE_CONCEPT = 165469;
	
	public final static int INITIAL_TB_STATUS = 1659;
	
	public final static int TRANSFERRED_IN_DATE = 160534;
	
	public final static int TRANSFERRED_IN_FROM = 160535;
	
	public final static int TRANSFERRED_OUT_CONCEPT = 159492;
	
	/* Variables for HIVEncounterType */
	public final static int ART_START_DATE_CONCEPT = 159599;
	
	public final static int WEIGHT_CONCEPT = 5089;
	
	public final static int CHILD_HEIGHT_CONCEPT = 5090;
	
	public final static int BLOOD_PRESSURE_SYSTOLIC_CONCEPT = 5085;
	
	public final static int BLOOD_PRESSURE_DYSTOLIC_CONCEPT = 5086;
	
	public final static int PREGNANCY_BREASTFEEDING_CONCEPT = 165050;
	
	public final static int FAMILY_PLANNING_STATUS_CONCEPT = 5271;
	
	public final static int FAMILY_PLANNING_METHOD_CONCEPT = 374;
	
	public final static int FUNCTIONAL_STATUS_CONCEPT = 165039;
	
	public final static int WHO_CLINICAL_STAGE_CONCEPT = 5356;
	
	public final static int TB_STATUS_CONCEPT = 1659;
	
	public final static int OTHER_OI_OTHER_PROBLEMS = 160170;
	
	public final static int NOTED_SIDE_EFFECT_CONCEPT = 159935;
	
	public final static int ARV_DRUG_ADHERENCE_CONCEPT = 165290;
	
	public final static int COTRIMOXAZOLE_ADHERENCE_CONCEPT = 161652;
	
	public final static int CD4_COUNT_CONCEPT = 5497;
	
	public final static int COTRIMOXAZOLE_DRUG_CONCEPT = 165257;
	
	public final static int ARV_DRUG_STRENGTH_CONCEPT = 165725;
	
	public final static int STRENGTH_960MG = 165062;
	
	public final static int STRENGTH_480MG = 165060;
	
	public final static int STRENGTH_240MG = 166095;
	
	public final static int INH_ADHERENCE_CONCEPT = 161653;
	
	public final static int ESTIMATED_DATE_OF_DELIVERY = 5596;
	
	/* PREGNANCY STATUS CONCEPTS */
	public final static int CURRENTLY_PREGNANT_CONCEPT = 1434;
	
	public final static int CURRENTLY_BREASTFEEDING_CONCEPT = 5632;
	
	public final static int PREGNANCY_BREASTFEEDING_STATUS = 165050;
	
	/* PatientDemographics Specific Concept */
	public final static int DATE_OF_TERMINATION_CONCEPT = 165469;
	
	public final static int EDUCATIONAL_LEVEL_CONCEPT = 1712;
	
	public final static int OCCUPATIONAL_STATUS_CONCEPT = 1542;
	
	public final static int MARITAL_STATUS_CONCEPT = 1054;
	
	public final static int PRIMARY_LANGUAGE_CONCEPT = 163230;
	
	/* PROGRAM ENROLLMENT CONCEPTS */
	public final static int HIV_ENROLLMENT_PROGRAM_ID = 1;
	
	/* Identifier IDs */
	public static final int PEPFAR_IDENTIFIER_INDEX = 4;
	
	public static final int HOSPITAL_IDENTIFIER_INDEX = 5;
	
	public static final int OTHER_IDENTIFIER_INDEX = 3;
	
	public static final int HTS_IDENTIFIER_INDEX = 8;
	
	public static final int PMTCT_IDENTIFIER_INDEX = 6;
	
	public static final int EXPOSE_INFANT_IDENTIFIER_INDEX = 7;
	
	public static final int PEP_IDENTIFIER_INDEX = 9;
	
	public static final int RECENCY_INDENTIFIER_INDEX = 10;
	
	/* KEY FORMS */
	//--These 4 forms was used to construct a HIVEncounterType
	public final static int ADULT_INITIAL_ENCOUNTER_TYPE = 26;
	
	public final static int INITIAL_ENCOUNTER_TYPE = 8;
	
	public final static int PED_INITIAL_ENCOUNTER_TYPE = 24;
	
	public final static int CARE_CARD_ENCOUNTER_TYPE = 12;
	
	public final static int LAB_ORDER_AND_RESULT_ENCOUNTER_TYPE = 11;
	
	public final static int PHARMACY_ENCOUNTER_TYPE = 13;
	
	public final static int ART_COMMENCEMENT_ENCOUNTER_TYPE = 25;
	
	public final static int PATIENT_CARE_IN_FACILITY_TERMINATED = 165586;
	
	public final static int PATIENT_TERMINATED = 1065;
	
	public final static int PATIENT_DATE_TERMINATED = 165469;
	
	public final static int REASON_FOR_TERMINATION = 165470;
	
	/*
	       HIVQuestionsType
	        
	 */
	
	public static String getPatientIdLimit() {
		return Context.getAdministrationService().getGlobalProperty(LoggerUtils.PATIENT_LIMIT_PROPERTY);
	}
	
	public static List<Obs> extractObsfromEncounter(List<Encounter> encs) {
        List<Obs> responseObs = new ArrayList<>();

        encs.forEach(a -> {
            responseObs.addAll(new ArrayList<>(a.getAllObs()));
        });

        return responseObs;
    }
	
	private static Date convertDateTimeToDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}
	
	public static List<Obs> getAllObsGroups(List<Obs> obsList, Integer groupingConceptId) {
        List<Obs> response = obsList.stream().filter(obb -> obb.getConcept().getConceptId().equals(groupingConceptId)).collect(Collectors.toList());
        return response;
    }
	
	public static Encounter getLatestEncounter(List<Encounter> filteredEncounters) {
        if (filteredEncounters != null && !filteredEncounters.isEmpty()) {
            filteredEncounters.sort(Comparator.comparing(Encounter::getEncounterDatetime));
            return filteredEncounters.get(filteredEncounters.size() - 1);
        }
        return null;
    }
	
	public static String getFacilityName() {
		return Context.getAdministrationService().getGlobalProperty("Facility_Name");
	}
	
	public static String getFacilityLocalId() {
		return Context.getAdministrationService().getGlobalProperty("facility_local_id");
	}
	
	public static String getNigeriaQualId() {
		return Context.getAdministrationService().getGlobalProperty("nigeria_qual_id");
	}
	
	public static String getFacilityDATIMId() {
		return Context.getAdministrationService().getGlobalProperty("facility_datim_code");
	}
	
	public static String getIPFullName() {
		return Context.getAdministrationService().getGlobalProperty("partner_full_name");
	}
	
	public static String getIPShortName() {
		return Context.getAdministrationService().getGlobalProperty("partner_short_name");
	}
	
	public static String getIPReportingState() {
		return Context.getAdministrationService().getGlobalProperty("partner_reporting_state");
	}
	
	public static String getIPReportingLgaCode() {
		return Context.getAdministrationService().getGlobalProperty("partner_reporting_lga_code");
	}
	
	//date is always saved as yyyy-MM-dd
	public static Date getLastNDRDate() {
		String lastRunDateString = Context.getAdministrationService().getGlobalProperty("ndr_last_run_date");
		if (String.valueOf(lastRunDateString).isEmpty()) {
			return null;
		} else {
			try {
				return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(lastRunDateString);
			}
			catch (Exception e) {
				System.out.println("Last Date was not in the correct format");
				return null;
			}
		}
	}
	
	public static String getBiometricServer() {
		return Context.getAdministrationService().getGlobalProperty("biometric_server");
	}
	
	public static Version getVersionInfo() throws URISyntaxException, IOException {
		
		File f = new File(Utils.class.getClassLoader().getResource("version.json").getFile());
		
		ObjectMapper mapper = new ObjectMapper();
		Version versionModel = mapper.readValue(f, Version.class);
		
		return versionModel;
	}
	
	public static Version getNmrsVersion() {
		
		URL resource = Utils.class.getClassLoader().getResource("version.json");
		try {
			File filePath = Paths.get(resource.toURI()).toFile();
			ObjectMapper mapper = new ObjectMapper();
			Version versionModel = mapper.readValue(filePath, Version.class);
			return versionModel;
		}
		catch (Exception e) {
			LoggerUtils.write(Utils.class.getName(), "Error locating version file: " + e.getMessage(),
			    LoggerUtils.LogFormat.FATAL, LogLevel.live);
			return null;
		}
	}
	
	/*public static List<Encounter> getEncounterByPatientAndEncounterTypeId(Patient patient, int encounterTypeId) {

	    EncounterType encounterType = Context.getEncounterService().getEncounterType(encounterTypeId);
	    Collection<EncounterType> encounterTypes = new ArrayList<>();
	    encounterTypes.add(encounterType);

	    EncounterSearchCriteriaBuilder encounterSearch = new EncounterSearchCriteriaBuilder()
	            .setPatient(patient).setEncounterTypes(encounterTypes).setIncludeVoided(false);

	    List<Encounter> encounter =	Context.getEncounterService().getEncounters(encounterSearch.createEncounterSearchCriteria());
	    return encounter;
	}*/
	public static void updateLast_NDR_Run_Date(Date date) {
		String dateString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		Context.getAdministrationService().updateGlobalProperty("ndr_last_run_date", dateString);
	}
	
	public static String getVisitId(Patient pts, Encounter enc) {
		return enc.getEncounterId().toString(); //getVisit().getVisitId().toString();
		/*String dateString = new SimpleDateFormat("dd-MM-yyyy").format(enc.getEncounterDatetime());
		return pts.getPatientIdentifier(3).getIdentifier() + "-" + dateString;*/
	}
	
	public static String getVisitId(String identifier, Date visitDate) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String visitID = dateFormat.format(visitDate);// + "-" + identifier;
		//DateTime dateTime=new DateTime(visitDate);
		//StringUtils.leftPad(String.valueOf(dateTime), DEAD_CONCEPT, identifier)
		//String visitID = String.valueOf(visitDate.getTime());
		return visitID;
	}
	
	public static boolean contains(List<Obs> obsList, int conceptID) {
		for (Obs ele : obsList) {
			if (ele.getConcept().getConceptId() == conceptID) {
				return true;
			}
		}
		return false;
	}
	
	public static DateTime extractMedicationDuration(Date visitDate, List<Obs> obsList) {
		DateTime stopDateTime = null;
		DateTime startDateTime = null;
		int durationDays = 0;
		Obs obs = null;
		Obs obsGroup = Utils.extractObs(Utils.ARV_DRUGS_GROUPING_CONCEPT_SET, obsList);
		obs = Utils.extractObsGroupMemberWithConceptID(Utils.MEDICATION_DURATION_CONCEPT, obsList, obsGroup);
		if (obs != null) {
			durationDays = (int) obs.getValueNumeric().doubleValue();
			startDateTime = new DateTime(visitDate);
			stopDateTime = startDateTime.plusDays(durationDays);
		}
		if (stopDateTime == null) {
			obs = Utils.extractObs(Utils.NEXT_APPOINTMENT_DATE_CONCEPT, obsList);
			if (obs != null) {
				stopDateTime = new DateTime(obs.getValueDate());
			}
		}
		return stopDateTime;
	}
	
	public static Date extractARTStartDate(Patient patient, List<Obs> allPatientsObsList) {
		Date artStartDate = null;
		Obs obs = Utils.extractObs(Utils.ART_START_DATE_CONCEPT, allPatientsObsList);
		if (obs != null) {
			artStartDate = obs.getValueDate();
		}
		return artStartDate;
	}
	
	public static Map<Integer, List<Encounter>> extractEncountersByEncounterTypesId(List<Encounter> encounters) {
		Map<Integer, List<Encounter>> grouped = new HashMap<>();
		if(encounters != null && encounters.size()>0){
			for (Encounter encounter:encounters){
				if(encounter.getEncounterType()!= null && encounterTypeIds.contains(encounter.getEncounterType().getEncounterTypeId())){
					if(grouped.get(encounter.getEncounterType().getEncounterTypeId()) == null){
						List<Encounter> encs = new ArrayList<>();
						encs.add(encounter);
						grouped.put(encounter.getEncounterType().getEncounterTypeId(), encs);
					}else{
						List<Encounter> groupedEncounters = grouped.get(encounter.getEncounterType().getEncounterTypeId());
						groupedEncounters.add(encounter);
						grouped.put(encounter.getEncounterType().getEncounterTypeId(),groupedEncounters);
					}
				}
			}
		}
		return grouped;
	}
	
	public static Date extractEnrollmentDate(List<Obs> allPatientObs) {
		Date enrollmentDate = null;
		Obs obs = extractLastObs(Utils.DATE_OF_HIV_DIAGNOSIS_CONCEPT, allPatientObs);
		if (obs != null) {
			enrollmentDate = obs.getValueDate();
		}
		return enrollmentDate;
	}
	
	public static PatientProgram extractProgramByID(List<PatientProgram> patientProgramList, int programID) {
		PatientProgram patientProgram = null;
		if (patientProgramList != null && !patientProgramList.isEmpty()) {
			for (PatientProgram ele : patientProgramList) {
				if (ele.getPatientProgramId() == programID) {
					patientProgram = ele;
				}
			}
		}
		return patientProgram;
	}
	
	public static Obs getFirstObsOfConceptByDate(List<Obs> obsList, int conceptID) {
        Obs obs = null;
        List<Obs> regimenLineObsList = new ArrayList<Obs>();
        for (Obs ele : obsList) {
            if (ele.getConcept().getConceptId() == conceptID) {
                regimenLineObsList.add(ele);
            }
        }
        if (!regimenLineObsList.isEmpty()) {
            regimenLineObsList.sort(Comparator.comparing(Obs::getObsDatetime));
            return regimenLineObsList.get(0);
        }
        return null;

    }
	
	public static Obs getLastObsOfConceptByDate(List<Obs> obsList, int conceptID) {
        List<Obs> regimenLineObsList = new ArrayList<Obs>();
        for (Obs ele : obsList) {
            if (ele.getConcept().getConceptId() == conceptID) {
                regimenLineObsList.add(ele);
            }
        }
        if (!regimenLineObsList.isEmpty()) {
            regimenLineObsList.sort(Comparator.comparing(Obs::getObsDatetime));
            int size = regimenLineObsList.size();
            return regimenLineObsList.get(size - 1);
        }
        return null;
    }
	
	public static Set<Date> extractUniqueVisitsForEncounterTypes(List<Encounter> encounterList) {
		Set<Date> visitDateSet = new HashSet<Date>();
		for (Encounter enc : encounterList) {
			visitDateSet.add(DateUtils.truncate(enc.getEncounterDatetime(), Calendar.DATE));
		}
		return visitDateSet;
	}
	
	public static List<Obs> extractObsListForEncounterType(List<Obs> allPatientObsList, Integer[] encounterTypeArr) {
		List<Obs> enrollmentObsList = new ArrayList<Obs>();
		List<Integer> encounterTypeList = new ArrayList<Integer>();
		encounterTypeList.addAll(Arrays.asList(encounterTypeArr));
		for (Obs ele : allPatientObsList) {
			if (encounterTypeList.contains(ele.getEncounter().getEncounterType().getEncounterTypeId())) {
				enrollmentObsList.add(ele);
			}
		}
		return enrollmentObsList;
	}
	
	public static Obs extractPregnancyStatusObs(Patient patient, List<Obs> allObsList) {
		Obs pregnancyObs = null;
		Obs obs = null;
		obs = Utils.getLastObsOfConceptByDate(allObsList, Utils.PREGNANCY_BREASTFEEDING_STATUS);
		if (obs != null) {
			pregnancyObs = obs;
		} else {
			obs = Utils.getLastObsOfConceptByDate(allObsList, Utils.CURRENTLY_PREGNANT_CONCEPT);
			if (obs != null) {
				pregnancyObs = obs;
			}
		}
		
		return pregnancyObs;
	}
	
	public static List<Obs> extractObsPerVisit(Date visitDate, List<Encounter> allEncountersList) {
		List<Obs> obsList = new ArrayList<Obs>();
		for (Encounter enc : allEncountersList) {
			if (enc.getEncounterDatetime().equals(visitDate)) {
				obsList.addAll(enc.getAllObs());
			}
		}
		return obsList;
	}
	
	public static List<Obs> extractObsPerVisitDate(Date visitDate, List<Obs> obsList) {
		List<Obs> obsListForVisitDate = new ArrayList<Obs>();
		DateTime obsDateTime = null;
		DateTime visitDateTime = null;
		for (Obs ele : obsList) {
			if (DateUtils.isSameDay(visitDate, ele.getObsDatetime())) {
				obsListForVisitDate.add(ele);
			}
		}
		return obsListForVisitDate;
	}
	
	public static List<Obs> extractObsPerVisitDateNew(Date visitDate, List<Obs> obsList) {
		List<Obs> obsListForVisitDate = new ArrayList<Obs>();
		DateTime obsDateTime = null;
		DateTime visitDateTime = null;
		
		for (Obs ele : obsList) {
			if (DateUtils.isSameDay(visitDate, ele.getObsDatetime())) {
				obsListForVisitDate.add(ele);
			}
		}
		return obsListForVisitDate;
	}
	
	public static Map<Integer, Obs> extractObs(List<Integer> conceptIDs, List<Obs> obsList) {
		Map<Integer, Obs> details = new HashMap<>();
		if(obsList != null && obsList.size()>0){
			for (Obs obs:obsList){
				if(obs.getConcept()!= null && conceptIDs.contains(obs.getConcept().getConceptId())){
					details.putIfAbsent(obs.getConcept().getConceptId(), obs);
				}
			}
		}
		return details;
	}
	
	public static Obs extractObs(int conceptID, List<Obs> obsList) {

        if (obsList == null) {
            return null;
        }
        return obsList.stream().filter(ele -> ele.getConcept().getConceptId() == conceptID).findFirst().orElse(null);
    }
	
	public static Obs extractLastObs(int conceptID, List<Obs> obsList) {
        Optional<Obs> obs = obsList
				.stream().filter(ele -> ele.getConcept().getConceptId() == conceptID).min(Comparator.comparing(Obs::getObsDatetime));
        return obs.orElse(null);
    }
	
	public static Obs extractLastObsFromSortedList(int conceptID, List<Obs> obsList) {
		Optional<Obs> obs = obsList
				.stream().filter(ele -> ele.getConcept().getConceptId() == conceptID).findFirst();
		return obs.orElse(null);
	}
	
	public static List<Obs> sortObs(List<Obs> obsList) {
		return obsList.stream().sorted(Comparator.comparing(Obs::getObsDatetime))
				.collect(Collectors.toList());
	}
	
	public static List<Obs> extractObsList(int conceptID, List<Obs> obsList) {
        List<Obs> obss = new ArrayList<>();

        if (obsList != null) {

            obss = obsList.stream().filter(ele -> ele.getConcept().getConceptId() == conceptID).collect(Collectors.toList());
        }
        return obss;
    }
	
	public static Date getARTStartDate(Patient patient) {
		
		List<Obs> FirstRegimenObs = getFirstRegimenObs(patient);
		Obs FirstRegimen = getRegimenFromObs(FirstRegimenObs);
		//Obs FirstRegimen = null;
		if (FirstRegimen != null && FirstRegimen.getValueCoded() != null) {
			return FirstRegimen.getObsDatetime();
		}
		return null;
	}
	
	public static Obs extractObsByValues(int conceptID, int valueCoded, List<Obs> obsList) {
		Obs obs = null;
		if (obsList != null) {
			for (Obs ele : obsList) {
				if (ele.getConcept().getConceptId() == conceptID && ele.getValueCoded().getConceptId() == valueCoded) {
					obs = ele;
				}
			}
		}
		return obs;
	}
	
	public static List<Obs> getCareCardObs(Patient patient, Date endDate) {
 		NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		Encounter hivEnrollmentEncounter = nigeriaEncounterService.getLastEncounterByEncounterTypeIds(patient,null, endDate,Arrays.asList(Care_card_Encounter_Type_Id));
//        List<Encounter> hivEnrollmentEncounter = Context.getEncounterService()
//                .getEncountersByPatient(patient).stream()
//                .filter(x -> x.getEncounterDatetime().before(endDate) && x.getEncounterType().getEncounterTypeId() == Care_card_Encounter_Type_Id)
//                .sorted(Comparator.comparing(Encounter::getEncounterDatetime))
//                .collect(Collectors.toList());

        if (hivEnrollmentEncounter != null) {
            return new ArrayList<>(hivEnrollmentEncounter.getAllObs(false));
        } else {
            return null;
        }
    }
	
	//why is this null
	public static List<Obs> getHIVEnrollmentObs(Patient patient) {
		
		return null;
	}
	
	public static List<Encounter> getAllRegimenObs(Patient patient) {
		NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		return nigeriaEncounterService.getEncountersByEncounterTypeIds(patient, null, null,
		    Collections.singletonList(Pharmacy_Encounter_Type_Id));
		//        return Context.getEncounterService()
		//                .getEncountersByPatient(patient).stream()
		//                .filter(x -> x.getEncounterType().getEncounterTypeId() == Pharmacy_Encounter_Type_Id)
		//                .sorted(Comparator.comparing(Encounter::getEncounterDatetime))
		//                .collect(Collectors.toList());
	}
	
	public static List<Obs> getFirstRegimenObs(Patient patient) {

        List<Encounter> arvEncounter = getAllRegimenObs(patient);

        if (arvEncounter != null && arvEncounter.size() > 0) {
            return new ArrayList<>(arvEncounter.get(0).getAllObs(false));
        } else {
            return null;
        }
    }
	
	public static Obs getRegimenFromObs(List<Obs> RegimenObs) {
		
		Obs regimenLine = Utils.extractObs(PharmacyDictionary.Prescribed_Regimen_Line_Concept_Id, RegimenObs);
		if (regimenLine != null && regimenLine.getValueCoded() != null) {
			Obs regimen = Utils.extractObs(regimenLine.getValueCoded().getConceptId(), RegimenObs);
			if (regimen != null && regimen.getValueCoded() != null) {
				return regimen;
			}
		}
		return null;
	}
	
	public static XMLGregorianCalendar getXmlDate(Date date) throws DatatypeConfigurationException {
		XMLGregorianCalendar cal = null;
		if (date != null) {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd").format(date));
		}
		return cal;
	}
	
	public static XMLGregorianCalendar getXmlDateTime(Date date) throws DatatypeConfigurationException {
		XMLGregorianCalendar cal = null;
		if (date != null) {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
			    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date));
		}
		return cal;
	}
	
	public static FacilityType createFacilityType(String facilityName, String facilityID, String facilityTypeCode) {
		FacilityType facilityType = new FacilityType();
		facilityType.setFacilityName(facilityName);
		facilityType.setFacilityID(facilityID);
		facilityType.setFacilityTypeCode(facilityTypeCode);
		return facilityType;
	}
	
	public static int getDateDiffInDays(Date startDate, Date endDate) {
		int dayDiff = 0;
		DateTime startDateTime = new DateTime(startDate);
		DateTime endDateTime = new DateTime(endDate);
		if ((endDateTime.isAfter(startDateTime) || endDateTime.isEqual(startDateTime))) {
			dayDiff = Days.daysBetween(startDateTime, endDateTime).getDays();
		}
		return dayDiff;
	}
	
	public static int getDateDiffInMinutes(Date startDate, Date endDate) {
		int minuteDiff = 0;
		DateTime startDateTime = new DateTime(startDate);
		DateTime endDateTime = new DateTime(endDate);
		if ((endDateTime.isAfter(startDateTime) || endDateTime.isEqual(startDateTime))) {
			minuteDiff = Minutes.minutesBetween(startDateTime, endDateTime).getMinutes();
		}
		return minuteDiff;
	}
	
	public static String getDayDD(Date date) {
		String dayString = "";
		DateTime dateTime = new DateTime(date);
		int day = dateTime.getDayOfMonth();
		dayString = StringUtils.leftPad(String.valueOf(day), 2, "0");
		return dayString;
	}
	
	public static String getMonthMM(Date date) {
		String monthString = "";
		DateTime dateTime = new DateTime(date);
		int month = dateTime.getMonthOfYear();
		monthString = StringUtils.leftPad(String.valueOf(month), 2, "0");
		return monthString;
	}
	
	public static String getYearYYYY(Date date) {
		String yearString = "";
		DateTime dateTime = new DateTime(date);
		int year = dateTime.getYear();
		yearString = String.valueOf(year);
		return yearString;
	}
	
	public static Obs extractObsGroupMemberWithConceptID(int conceptID, List<Obs> obsList, Obs obsGrouping) {
		Obs obs = null;
		for (Obs ele : obsList) {
			if (ele.getConcept().getConceptId() == conceptID && ele.getObsGroup().equals(obsGrouping)) {
				obs = ele;
			}
		}
		return obs;
	}
	
	public void dothings() {
		
	}
	
	public static String ensureDownloadFolderExist(HttpServletRequest request) {
		//create report download folder at the server. skip if already exist
		
		// old implementation // String folder = new File(request.getRealPath(request.getContextPath())).getParentFile().toString() + "\\downloads"; //request.getRealPath(request.getContextPath()) + "\\reports";
		String folder = Paths.get(
		    new File(request.getSession().getServletContext().getRealPath(request.getContextPath())).getParentFile()
		            .toString(), "downloads").toString(); //request.getRealPath(request.getContextPath()) + "\\reports";
		
		File dir = new File(folder);
		Boolean b = dir.mkdir();
		System.out.println("Creating download folder : " + folder + "was successful : " + b);
		return folder;
	}
	
	public static String ensureReportFolderExist(HttpServletRequest request, String reportType) {
		String downloadFolder = ensureDownloadFolderExist(request);
		//old implementation
		// String reportFolder = downloadFolder + "/" + reportType;
		String reportFolder = Paths.get(downloadFolder, reportType).toString();
		//clean up directory
		FileUtils.deleteNonZip(reportFolder);
		File dir = new File(reportFolder);
		dir.mkdir();
		System.out.println(reportType + " folder exist ? : " + dir.exists());
		
		//create today's folder
		boolean b;
		String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		//old implementation
		// String todayFolders = reportFolder + "/" + dateString;
		String todayFolders = Paths.get(reportFolder, dateString).toString();
		dir = new File(todayFolders);
		if (dir.exists()) {
			File[] previousFiles = dir.listFiles();
			assert previousFiles != null;
			for (File f : previousFiles) {
				b = f.delete();
				System.out.println("deleted previous xml successfully ? " + b);
			}
			b = dir.delete();
			System.out.println("deleted previous folder successfully ? " + b);
		}
		dir.mkdir();
		System.out.println(todayFolders + " folder exist ? " + dir.exists());
		
		return todayFolders;
	}
	
	public static String ZipFolder(String contextPath, String folderToZip, String zipFileName, String reportType) {
		
		File toZIP = new File(folderToZip);
		if (!toZIP.exists() || toZIP.listFiles() == null || Objects.requireNonNull(toZIP.listFiles()).length == 0) {
			FileUtils.deleteFolder(folderToZip, true);
			return "no new patient record found";
		}
		
		//Zip today's folder and name it with today's date
		ZipUtil appZip = new ZipUtil(folderToZip);
		appZip.generateFileList(toZIP);
		appZip.zipIt(Paths.get(toZIP.getParent(), zipFileName).toString());
		
		return Paths.get(contextPath, "downloads", reportType, zipFileName).toString();
	}
	
	public static String formatDate(Date date) {
		return formatDate(date, "dd/MM/yyyy");
	}
	
	public static String formatDate(Date date, String format) {
		String dateString = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(format);
			dateString = df.format(date);
		}
		return dateString;
	}
	
	public static String getPatientPEPFARId(Patient patient) {
		PatientIdentifier patientId = null;

		if(!patient.isVoided()){
			patientId = patient.getPatientIdentifier(Patient_PEPFAR_Id);
		}else{
			Set<PatientIdentifier> allPidentifiers = patient.getIdentifiers();
			patientId = allPidentifiers.stream().filter(x-> x.isPreferred()).findFirst().get();
		}
		
		if (patientId != null) {
			return patientId.getIdentifier();
		} else {
			patientId = patient.getPatientIdentifier(5); //hospital number
			if (patientId != null) {
				return patientId.getIdentifier();
			}
			return "";
		}
	}
	
	public static String getPatientHospitalNo(Patient patient) {
		
		PatientIdentifier patientId = patient.getPatientIdentifier(ConstantsUtil.HOSPITAL_IDENTIFIER_INDEX);
		
		if (patientId != null) {
			return patientId.getIdentifier();
		} else {
			return "";
		}
	}
	
	public static String getPatientRNLSerialNo(Patient patient) {
		
		PatientIdentifier patientId = patient.getPatientIdentifier(Patient_RNLSerial_No);
		if (patientId != null) {
			return patientId.getIdentifier();
		} else {
			return "";
		}
	}
	
	public static Obs getReasonForTerminationObs(Patient patient) {
		NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		Encounter encounter = nigeriaEncounterService.getLastEncounterByEncounterTypeIds(patient,null,null,
				Collections.singletonList(Client_Tracking_And_Termination_Encounter_Type_Id));
//        Optional<Encounter> encounter = Context.getEncounterService()
//                .getEncountersByPatient(patient).stream()
//                .filter(x -> x.getEncounterType().getEncounterTypeId() == Client_Tracking_And_Termination_Encounter_Type_Id)
//                .findAny();
		//TODO: change
        if (encounter != null) {
            Optional<Obs> obs = encounter.getAllObs().stream()
                    .filter(x -> x.getValueCoded().getConceptId() == Reason_For_Termination)
                    .findAny();

            if (obs != null && obs.isPresent()) {
                return obs.get();
            }
        }
        return null;
    }
	
	public static Obs getLastAdherenceObs(Patient patient, Date endDate) {

		NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		Encounter lastEncounter = nigeriaEncounterService.getLastEncounterByEncounterTypeIds(patient, null, endDate,
				Arrays.asList(Pharmacy_Encounter_Type_Id,Care_card_Encounter_Type_Id));
		//TODO: change
            Optional<Obs> adherenceObs = lastEncounter.getAllObs().stream()
                    .filter(x -> x.getConcept().getConceptId() == ClinicalDictionary.ARV_Drug_Adherence_Concept_Id
                            || x.getConcept().getConceptId() == ClinicalDictionary.Cotrimoxazole_Adherence_Concept_Id
                            || x.getConcept().getConceptId() == ClinicalDictionary.INH_Adherence_Concept_Id)
                    .findAny();

		return adherenceObs.orElse(null);
    }
	
	@Deprecated
	public static Obs getAllTBStatusObs(Patient patient) {
        Optional<Encounter> encounter = Context.getEncounterService()
                .getEncountersByPatient(patient).stream()
                .filter(x -> x.getEncounterType().getEncounterTypeId() == Client_Tracking_And_Termination_Encounter_Type_Id)
                .findAny();

        if (encounter.isPresent()) {
            Optional<Obs> obs = encounter.get().getAllObs().stream()
                    .filter(x -> x.getValueCoded().getConceptId() == Reason_For_Termination)
                    .findAny();

            if (obs.isPresent()) {
                return obs.get();
            }
        }
        return null;
    }
	
	public static List<Encounter> getLastEncounters(Patient patient, Date endDate) {
		NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		return nigeriaEncounterService.getEncountersByEncounterTypeIds(patient, null, endDate,
				Arrays.asList(Adult_Ped_Initial_Encounter_Type_Id, Care_card_Encounter_Type_Id));
	}
	
	public static Obs getHighestCD4Obs(Patient patient) {
		
		Concept CD4Concept = Context.getConceptService().getConcept(LabDictionary.CD4_Count_Concept_Id);
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getHighestObsByConcept(patient.getPerson(), CD4Concept, null, null, false);
	}
	
	public static Obs getInitialObs(Patient patient, int Concept_Id) {
		Concept concept = Context.getConceptService().getConcept(Concept_Id);
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getFirstObsByConceptId(patient.getPerson(), concept, null, null, false);
	}
	
	public static Obs getLastObs(Patient patient, int Concept_Id, Date endDate) {
		Concept concept = Context.getConceptService().getConcept(Concept_Id);
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getLastObsByConceptId(patient.getPerson(), concept, null, endDate, false);
	}
	
	public static List<Obs> getObs(Patient patient, int conceptId) {
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getObsByConceptId(patient.getPersonId(), conceptId, null, false);
	}

	public static List<Obs> getObs(Patient patient, int conceptId, int encounterId) {
		NigeriaObsService nigeriaObsService = Context.getService(NigeriaObsService.class);
		return nigeriaObsService.getObsByConceptId(patient.getPersonId(), conceptId, Arrays.asList(encounterId), false);
	}
	
	/**
	 * use this instead nigeriaEncounterService.getLastEncounterByPatient(pts, null, endDate)
	 * 
	 * @param patient
	 * @param endDate
	 * @return
	 */
	@Deprecated
	public static Encounter getLastEncounter(Patient patient, Date endDate) {

        Optional<Encounter> encounters = Context.getEncounterService().getEncountersByPatient(patient)
                .stream().filter(x -> x.getEncounterDatetime().before(endDate))
                .max(Comparator.comparing(Encounter::getEncounterDatetime));

		return encounters.orElse(null);

	}
	
	public static int getDateDiffInMonth(Date startDate, Date endDate) {
		
		int monthDiff = 0;
		LocalDate d2 = new LocalDate(new DateTime(endDate));
		LocalDate d1 = new LocalDate(new DateTime(startDate));
		if (startDate != null && (d2.isAfter(d1) || d2.isEqual(d1))) {
			monthDiff = Months.monthsBetween(d1, d2).getMonths();
		}
		return monthDiff;
	}
	
	public static int getAge(Date dateOfBirth) {
		
		LocalDate d2 = new LocalDate(new DateTime(dateOfBirth));
		LocalDate d1 = new LocalDate(new DateTime());
		return Years.yearsBetween(d2, d1).getYears();
	}
	
	public static Obs getElementObs(int pos, List<Obs> s) {
		Iterator<Obs> it = s.iterator();
		int count = 0;
		Obs ele = null;
		while (it.hasNext() && count < pos && pos <= s.size()) {
			ele = it.next();
			count++;
		}
		return ele;
	}
	
	public void writeToFile(String filePath, String content) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if (bw != null) {
					bw.close();
				}
				
				if (fw != null) {
					fw.close();
				}
				
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/*public String ensureTodayDownloadFolderExist(String parentFolder, HttpServletRequest request) {
	    //create today's folder
	    String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	    String todayFolders = parentFolder + "/" + dateString;
	    File dir = new File(todayFolders);
	    Boolean b = dir.mkdir();
	    System.out.println("creating folder : " + todayFolders + "was successful : " + b);
	    return todayFolders;
	}*/
	public static void ShowSystemProps() {
		System.getProperties().list(System.out);
	}
	
	public static DBConnection getNmrsConnectionDetails() {
		
		DBConnection result = new DBConnection();
		
		try {
			
			//            String appDirectory = "";
			//
			//            InputStream inputStream;
			//            Properties props = new Properties();
			//            String OS = (System.getProperty("os.name")).toUpperCase();
			//            /*String prosName = OpenmrsUtil.getRuntimePropertiesFilePathName("openmrs");
			//			String prosName2 = OpenmrsUtil.getRuntimePropertiesFilePathName("nigeriamrs");*/
			//            if (OS.contains("WIN")) {
			//                //get the path for OpenMRS version 2.0.6
			//                appDirectory = System.getenv("WINDIR") + "\\system32\\config\\systemprofile\\Application Data";
			//                appDirectory = Paths.get(appDirectory, "OpenMRS", "openmrs-runtime.properties").toString();
			//                //check if the properties file exists
			//                File _f = new File(appDirectory);
			//                if (!_f.exists()) {
			//                    appDirectory = System.getenv("AppData");
			//                    // old implementation         appDirectory += "\\OpenMRS\\openmrs-runtime.properties";
			//                    appDirectory = Paths.get(appDirectory, "OpenMRS", "openmrs-runtime.properties").toString();
			//                }
			//
			//            } else {
			//                appDirectory = System.getProperty("user.home");
			//                // old implementation          appDirectory += "\\.OpenMRS\\openmrs-runtime.properties";
			//                appDirectory = Paths.get(appDirectory, ".OpenMRS", "openmrs-runtime.properties").toString();
			//            }
			//            //String propFileName = System.getProperty("OPENMRS_INSTALLATION_SCRIPT");
			//            if (null == appDirectory) {
			//                return null;
			//            }
			//            File f = new File(appDirectory);
			//            inputStream = new FileInputStream(f);
			//            //inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
			//
			//            /*Properties p = System.getProperties();
			//			Map<String, String> env = System.getenv();*/
			//            props.load(inputStream);
			//            // throw new FileNotFoundException("property file '" + appDirectory + "' not found in the classpath");
			//starts here
			Properties props;
			props = OpenmrsUtil.getRuntimeProperties("openmrs");
			if (props == null) {
				props = OpenmrsUtil.getRuntimeProperties("openmrs-standalone");
				
			}
			
			result.setUsername(props.getProperty("connection.username"));
			result.setPassword(props.getProperty("connection.password"));
			result.setUrl(props.getProperty("connection.url"));
			
		}
		catch (Exception ex) {
			LoggerUtils.write(Utils.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
		}
		
		return result;
		
	}
	
	public static String isSurgeSite() {
		String isSurge = "";
		try {
			isSurge = Context.getAdministrationService().getGlobalProperty("surge_site");
		}
		catch (Exception e) {
			isSurge = "";
		}
		return isSurge;
	}
	
	public static String getProperty(String propertyName, Object defaultValue) {
		Properties props;
		props = OpenmrsUtil.getRuntimeProperties("openmrs");
		if (props == null) {
			props = OpenmrsUtil.getRuntimeProperties("openmrs-standalone");
		}
		if (props.get(propertyName) != null) {
			return (String) props.get(propertyName);
		} else {
			return String.valueOf(defaultValue);
		}
	}
}
