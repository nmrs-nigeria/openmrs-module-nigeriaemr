package org.openmrs.module.nigeriaemr.ndrfactory;

import com.mchange.v2.encounter.EncounterCounter;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.util.OpenmrsUtil;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.*;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Date;
import java.util.*;
import org.apache.commons.codec.language.Soundex;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.getXmlDate;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;

//on master
public class NDRMainDictionary {

    public final static int Patient_Deceased_Indicator_Concept_Id = 0;
    public final static int Date_Patient_Died_Concept_Id = 1543;
    public final static int Dead_Concept_Id = 160432;
    public final static int Patient_Primary_Language_Code_Concept_Id = 0;
    public final static int Patient_Education_Level_Code_Concept_Id = 1712;
    public final static int Patient_Occupation_Code_Concept_Id = 1542;
    public final static int Patient_Marital_Status_Code_Concept_Id = 1054;
    public final static int HIV_Enrollment_Date_Concept_Id = 160555;
    public final static int Patient_Died_From_Illness_Value_Concept_Id = 0;
    public final static int Patient_Died_From_Illness_Concept_Id = 0;
    public final static int Diagnosis_Date_Concept_Id = 0;
    public final static int Estimated_Delivery_Date_Concept_Id = 5596;
    public final static int Patient_Pregnancy_Status_Concept_Id = 1434;
    public final static int Care_Entry_Point = 160540;
    public final static int Date_Confirmed_HIV = 160554;
    public final static int Mode_of_HIV_Test = 164947;
    public final static int Date_Transfer_In = 160534;
    public final static int Prior_ART = 165242;
    public final static int Facility_Transferred_From = 160535;
    public final static int CD4_count_at_start_of_ART = 164429;
    public final static int WHO_Clinical_Stage_ART_Start = 5356;//165286
    public final static int Reason_Medically_Eligible = 162225;
    public final static int Medically_Eligible_Date = 162227;
    public final static int Weight_At_ART_Start_Concept_Id = 165582;
    public final static int Height_At_ART_Start_Concept_Id = 165581;
    public final static int Patient_Functional_Status_Concept_Id = 165039;
    private String appDirectory = "";

    private static Map<Integer, String> map = new HashMap<>();
    private ClinicalDictionary clinicalDictionary = null;
    private PMTCTDictionary pmtctDictionary = null;
    private HTSDictionary htsDictionary = null;
    private LabDictionary labDictionary = null;
    private PharmacyDictionary pharmDictionary = null;
    private NDRCommonQuestionsDictionary commonQuestionDictionary = null;

    public NDRMainDictionary() {
        loadDictionary();
        clinicalDictionary = new ClinicalDictionary();
        pmtctDictionary = new PMTCTDictionary();
        htsDictionary = new HTSDictionary();
        labDictionary = new LabDictionary();
        pharmDictionary = new PharmacyDictionary();
        commonQuestionDictionary = new NDRCommonQuestionsDictionary();

    }

    private void loadDictionary() {
        map.put(123, "PatientDeceasedIndicator");
        map.put(124, "DeceasedIndicator");
        map.put(125, "DeceasedIndicator");
        map.put(126, "DeceasedIndicator");
        map.put(122, "P"); //Pregnant
        map.put(127, "NP");
        map.put(128, "NK");
        map.put(129, "PMTCT");
        //concept id for the education level
        /*map.put(1714, "1");
        map.put(1713, "2");
        map.put(1107, "3");
        map.put(1067, "4");
        map.put(5622, "5");
        map.put(160289, "6");
        map.put(160294, "7");
        map.put(160293, "8");
        map.put(160292, "9");
        map.put(160291, "10");
        map.put(160290, "11");
        map.put(160300, "12");
        map.put(160299, "13");
        map.put(160298, "14");
        map.put(163122, "15");
        map.put(163123, "16");
        map.put(159785, "17");
        map.put(164212, "18");
        map.put(164211, "19");
        map.put(164210, "20");*/
        //conceptIds for occupation code
        //TODO occuation concept id has not been found in the db cross check before using this coded concepts
        map.put(1538, "EMP");
        map.put(162946, "EMP");
        map.put(162944, "EMP");
        map.put(163333, "EMP");
        map.put(162591, "EMP");
        map.put(164831, "EMP");
        map.put(160295, "UNK");
        map.put(159465, "STU");
        map.put(123801, "UNE");
        //marital status concept id
        //TODO marital status concept id has not been found in the db cross check before using this coded concepts
        map.put(1056, "S");
        map.put(1057, "NM");
        map.put(1058, "D");
        map.put(1059, "W");
        map.put(5555, "M");
        map.put(1060, "LWP");
        map.put(135704, "LA");
        map.put(5622, "Other");
        //functional status concept id
        map.put(162750, "W");
        map.put(162752, "B");
        map.put(160026, "A");
        //hiv question type WHO clinical stage concept
        map.put(165282, "I");
        map.put(165283, "II");
        map.put(165284, "III");
        map.put(165285, "IV");
        //tb status concept
        map.put(1663, "CT");
        map.put(142177, "DS");
        map.put(1661, "DD");
        map.put(1660, "NS");
        map.put(1662, "OT");
        map.put(160737, "NA");

        //care entry point
        map.put(160539, "3"); //HTS
        map.put(160538, "9"); //ANC/PMTCT
        map.put(160537, "12"); //In Patient
        map.put(160536, "12");//Current Clinic Patient
        map.put(160542, "2");//OPD
        map.put(160541, "6");//TB DOTS
        map.put(160543, "4");//Outreaches
        map.put(160545, "11");
        map.put(160546, "1");
        map.put(160547, "5");
        map.put(160548, "10");
        map.put(160550, "11");
        map.put(160551, "13");
        map.put(160563, "14");

        /*
        map.put(160549, "AOP");
        map.put(160544, "UFC");
        map.put(160552, "NP");
        map.put(160564, "VS");
        map.put(161359, "PHBC");
        map.put(159937, "MCHP");
        map.put(162223, "VMCC");
        map.put(164949, "HIVAb");
        map.put(164948, "HIVPCR");
         */
        map.put(0, "");
        map.put(0, "");

    }

    private String getMappedValue(int conceptID) {
        if (map.containsKey(conceptID)) {
            return map.get(conceptID);
        }
        return "";
    }

    /*static HIVQuestionsType createHIVQuestionType(Obs firstRegimenObs, Date ARTStartDate, Date EnrollmentDate, List<Obs> obs) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}*/
    public PatientDemographicsType createPatientDemographicType2(Patient patient, FacilityType facility, DBConnection openmrsConn, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException {
        return commonQuestionDictionary.createPatientDemographicsType(patient, facility, allPatientObsList, allPatientEncounterList, openmrsConn);
    }

    public CommonQuestionsType createCommonQuestionType2(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException {
        CommonQuestionsType commonQuestionsType = null;
        commonQuestionsType = commonQuestionDictionary.createCommonQuestionType(patient, allPatientEncounterList, allPatientObsList);
        return commonQuestionsType;
    }

    public ConditionSpecificQuestionsType createCommConditionSpecificQuestionsType(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException {
        return commonQuestionDictionary.createConditionSpecificQuestionType(patient, allPatientEncounterList, allPatientObsList);
    }

    public List<HIVEncounterType> createHIVEncounterType(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allObs) throws DatatypeConfigurationException {
        return clinicalDictionary.createHIVEncounterType(patient, allPatientEncounterList, allObs);
    }

    public List<RegimenType> createRegimenTypeList(Patient patient, List<Encounter> allEncounterForPatient, List<Obs> allPatientObsList) throws DatatypeConfigurationException {
        List<RegimenType> allRegimenTypeList = new ArrayList<RegimenType>();
        allRegimenTypeList.addAll(pharmDictionary.createRegimenTypeList(patient, allEncounterForPatient, allPatientObsList));
        allRegimenTypeList.addAll(pharmDictionary.createOIRegimenTypeList(patient, allEncounterForPatient, allPatientObsList));
        return allRegimenTypeList;

    }

    /*   public List<LaboratoryReportType> createLaboratoryOrderAndResult(Patient pts, List<Encounter> enc, List<Obs> labObsList)
            throws DatatypeConfigurationException {
        return labDictionary.createLaboratoryOrderAndResult(pts, enc, labObsList );
    }*/
    public LaboratoryReportType createLaboratoryOrderAndResult(Patient pts, Encounter enc, List<Obs> labObsList)
            throws DatatypeConfigurationException {
        return labDictionary.createLaboratoryOrderAndResult(pts, enc, labObsList);
    }

    public ChildBirthDetailsType createChildBirthDetailsType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createChildBirthDetailsType(pts, null, antenatalObsList);
    }

    public ChildFollowupType createChildFollowupType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createChildFollowupType(pts, null, antenatalObsList);
    }

    public ImmunizationType createImmunizationType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createImmunizationType(pts, null, antenatalObsList);
    }

    public InfantPCRTestingType createInfantPcr(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createInfantPcr(pts, null, antenatalObsList);
    }

    public List<ClinicalTBScreeningType> createClinicalTbScreening(Patient pts, Encounter encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<ClinicalTBScreeningType> clinicalTBScreeningTypes = new ArrayList<>();

        ClinicalTBScreeningType clinicalTBScreeningType = htsDictionary.createClinicalTbScreening(pts, encounters, obsList);
        if (clinicalTBScreeningType != null) {
            clinicalTBScreeningTypes.add(clinicalTBScreeningType);
        }

        return clinicalTBScreeningTypes;
    }

    public HIVTestingReportType createHIVTestIntake(Patient patient, Encounter enc, List<Obs> allObs, HIVTestingReportType hivTestingReport) {

        try {
            return htsDictionary.createClientIntakeTags(patient, enc, allObs, hivTestingReport);
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return hivTestingReport;
    }

    public HIVTestResultType createHIVTestResult(Patient patient, Encounter enc, List<Obs> allObs) {
        return htsDictionary.createHIVTestResult(patient, enc, allObs);
    }

    public List<IndexNotificationServicesType> createIndexNotificationServicesTypes(Patient patient, Encounter enc, List<Obs> allObs) {
        return htsDictionary.createIndexNotificationServicesTypes(patient, enc, allObs);
    }

    public List<HIVRiskAssessmentType> createHivRiskAssessment(Patient pts, Encounter encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<HIVRiskAssessmentType> hivRiskAssessmentTypes = new ArrayList<>();

        HIVRiskAssessmentType hivRiskAssessmentType = htsDictionary.createHivRiskAssessment(pts, encounters, obsList);
        if (hivRiskAssessmentType != null) {
            hivRiskAssessmentTypes.add(hivRiskAssessmentType);
        }

        return hivRiskAssessmentTypes;
    }

    public List<KnowledgeAssessmentType> createKnowledgeAssessmentType(Patient pts, Encounter encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<KnowledgeAssessmentType> knowledgeAssessmentTypes = new ArrayList<>();
        KnowledgeAssessmentType knowledgeAssessmentType = htsDictionary.createKnowledgeAssessmentType(pts, encounters, obsList);
        if (knowledgeAssessmentType != null) {
            knowledgeAssessmentTypes.add(knowledgeAssessmentType);
        }

        return knowledgeAssessmentTypes;
    }

    public List<PostTestCounsellingType> createPostTestCounsellingType(Patient pts, Encounter encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<PostTestCounsellingType> postTestCounsellingTypes = new ArrayList<>();

        PostTestCounsellingType postTestCounsellingType = htsDictionary.createPostTestCouncellingType(pts, encounters, obsList);
        if (postTestCounsellingType != null) {
            postTestCounsellingTypes.add(postTestCounsellingType);
        }

        return postTestCounsellingTypes;
    }

    public List<SyndromicSTIScreeningType> createSyndromicsStiType(Patient pts, Encounter encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<SyndromicSTIScreeningType> syndromicSTIScreeningTypes = new ArrayList<>();

        SyndromicSTIScreeningType syndromicSTIScreeningType = htsDictionary.createSyndromicsStiType(pts, encounters, obsList);
        if (syndromicSTIScreeningType != null) {
            syndromicSTIScreeningTypes.add(syndromicSTIScreeningType);
        }

        return syndromicSTIScreeningTypes;
    }

    public List<HealthFacilityVisitsType> createHealthFacilityVisit(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<HealthFacilityVisitsType> healthFacilityVisitsTypes = new ArrayList<>();
        for (Encounter enc : encounters) {
            HealthFacilityVisitsType healthFacilityVisitsType = htsDictionary.createHealthFacilityVisit(pts, enc, obsList);
            if (healthFacilityVisitsType != null) {
                healthFacilityVisitsTypes.add(healthFacilityVisitsType);
            }
        }
        return healthFacilityVisitsTypes;
    }

    public List<PartnerDetailsType> createPartnerDetails(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {

        List<PartnerDetailsType> partnerDetailsTypes = new ArrayList<>();
        for (Encounter enc : encounters) {
            if (enc.getEncounterType().getEncounterTypeId() == Utils.Partner_register_Encounter_Id) {
                PartnerDetailsType p_details = htsDictionary.createPartnerDetails(pts, enc, obsList);
                if (p_details != null) {
                    partnerDetailsTypes.add(p_details);
                }
            }
        }
        return partnerDetailsTypes;
    }
}
