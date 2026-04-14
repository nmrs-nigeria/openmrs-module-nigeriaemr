package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ClinicalDictionary clinicalDictionary;
    private RecencyDictionary recencyDictionary;
    private PMTCTDictionary pmtctDictionary;
    private TBDictionary tbDictionary;
    private HTSDictionary htsDictionary;
    private MortalityDictionary mortalityDictionary;
    private LabDictionary labDictionary;
    private PharmacyDictionary pharmDictionary;
    private NDRCommonQuestionsDictionary commonQuestionDictionary;
    private NigeriaEncounterService nigeriaEncounterService;

    public NDRMainDictionary() {
        loadDictionary();
        clinicalDictionary = new ClinicalDictionary();
        mortalityDictionary = new MortalityDictionary();
        pmtctDictionary = new PMTCTDictionary();
        tbDictionary = new TBDictionary();
        recencyDictionary = new RecencyDictionary();
        htsDictionary = new HTSDictionary();
        labDictionary = new LabDictionary();
        pharmDictionary = new PharmacyDictionary();
        commonQuestionDictionary = new NDRCommonQuestionsDictionary();
        nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);

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
        map.put(5622, "10");
        //functional status concept id
        map.put(162750, "W");
        map.put(162752, "B");
        map.put(160026, "A");
        //hiv question type WHO clinical stage concept
        /*map.put(165282, "I");
        map.put(165283, "II");
        map.put(165284, "III");
        map.put(165285, "IV");*/
        map.put(165282, "1");
        map.put(165283, "2");
        map.put(165284, "3");
        map.put(165285, "4");
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
        map.put(160542, "1");//OPD
        map.put(160536, "2");// Inpatient
        map.put(160539, "3");//  VCT
        map.put(160541, "4"); //TB DOT
        map.put(160546, "5");//  STI Clinic
        map.put(160538, "6");//  ANC/PMTCT
        map.put(160563, "7");//  Transfer-in
        map.put(160545, "8");// Outreaches HIV enrollment
        map.put(165794, "9");// Index testing

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

    public PatientDemographicsType createPatientDemographicType2(Patient patient, FacilityType facility, Map<Object, List<Obs>> groupedObsByEncounterTypes) throws DatatypeConfigurationException {
        return commonQuestionDictionary.createPatientDemographicsType(patient, facility, groupedObsByEncounterTypes);
    }

    public CommonQuestionsType createCommonQuestionType2(Patient patient, Encounter lastEncounter, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        return commonQuestionDictionary.createCommonQuestionType(patient, lastEncounter, groupedObsByConcept);
    }

    public ConditionSpecificQuestionsType createCommConditionSpecificQuestionsType(Patient patient,Map<Object, List<Obs>> groupedpatientBaselineObsByConcept,
                                                                                   Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType) throws DatatypeConfigurationException {
        return commonQuestionDictionary.createConditionSpecificQuestionType(patient,groupedpatientBaselineObsByConcept,
                groupedpatientBaselineObsByEncounterType);
    }

    public List<HIVEncounterType> createHIVEncounterType(Patient patient, Map<Integer, List<Encounter>> groupedEncounters,
                                                         Map<Object, List<Obs>> groupedObsByVisitDate) throws DatatypeConfigurationException {
        return clinicalDictionary.createHIVEncounterType(patient, groupedEncounters,  groupedObsByVisitDate);
    }

    public List<RegimenType> createRegimenTypeList(Patient patient, Map<Integer,List<Encounter>> groupedEncounters) throws DatatypeConfigurationException {
        List<RegimenType> allRegimenTypeList = new ArrayList<RegimenType>();
        try{
            allRegimenTypeList.addAll(pharmDictionary.createRegimenTypeList(patient, groupedEncounters));
        }catch(Exception ex){
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
        }
        return allRegimenTypeList;
    }

    public LaboratoryReportType createLaboratoryOrderAndResult(Patient pts, Encounter enc, List<Obs> labObsList)
            throws DatatypeConfigurationException {
        return labDictionary.createLaboratoryOrderAndResult(pts, enc, labObsList);
    }

    public List<ClinicalTBScreeningType> createClinicalTbScreening(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<ClinicalTBScreeningType> clinicalTBScreeningTypes = new ArrayList<>();

        ClinicalTBScreeningType clinicalTBScreeningType = htsDictionary.createClinicalTbScreening(pts, groupedObsByConcept);
        if (clinicalTBScreeningType != null) {
            clinicalTBScreeningTypes.add(clinicalTBScreeningType);
        }

        return clinicalTBScreeningTypes;
    }

    public HIVTestingReportType createHIVTestIntake(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept, HIVTestingReportType hivTestingReport) {

        try {
            return htsDictionary.createClientIntakeTags(patient, enc, groupedObsByConcept, hivTestingReport);
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return hivTestingReport;
    }

    public List<MaternalCohortType> createMaternalCohort(List<Encounter> maternalCohortEncounter){
        return pmtctDictionary.createMaternalCohort(maternalCohortEncounter);
    }

    public  List<PMTCTHTSType> createPMTCTHTS(List<Encounter> pmtctHTSEncounter){
        return pmtctDictionary.createPMTCTHTS(pmtctHTSEncounter);
    }

    public List<HealthFacilityVisitsType> createHealthFacilityVisits(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createHealthFacilityVisit(pmtctEncounters);
    }

    public List<ImmunizationType> createImmunizationType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createImmunizationType(pmtctEncounters);
    }

    public List<DeliveryEncounterType> createDeliveryEncounterType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createDeliveryEncounterType(pmtctEncounters);
    }

    public List<AntenatalRegistrationType> createAntenatalRegistrationType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createAntenatalRegistrationType(pmtctEncounters);
    }

    public List<ChildBirthDetailsType> createChildBirthDetailsType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createChildBirthDetailsType(pmtctEncounters);
    }

    public List<ChildFollowupType> createChildFollowupType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createChildFollowupType(pmtctEncounters);
    }

    public List<InfantPCRTestingType> createInfantPCRTestingType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createInfantPCRTestingType(pmtctEncounters);
    }

    public List<PartnerDetailsType> createPartnerDetailsType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createPartnerDetailsType(pmtctEncounters);
    }

    public List<InfantRapidTestType> createInfantRapidTestType(List<Encounter> pmtctEncounters) {
        return pmtctDictionary.createInfantRapidTestType(pmtctEncounters);
    }

    /*public List<PMTCTRegistrationType> createPMTCTRegistration(List<Encounter> pmtctRegistrationEncounters) {
        return pmtctDictionary.createPMTCTRegistrationType(pmtctRegistrationEncounters);
    }*/

    public HIVTestResultType createHIVTestResult(Patient patient,  Map<Object, List<Obs>> groupedObsByConcept) {
        return htsDictionary.createHIVTestResult(patient, groupedObsByConcept);
    }

    public List<TBScreeningType> createTbScreeningEncounterType(Patient patient,List<Encounter> tbScreeningEncounters) {
        return tbDictionary.createTBScreeningType(patient,tbScreeningEncounters);
    }

    public List<TBScreeningIPTmonitoringType> createiptMonitoringEncounterType(Patient patient, List<Encounter> iptMonitoringEncounters) {
        return tbDictionary.createTBScreeningIPTmonitoringType(patient,iptMonitoringEncounters);
    }

    public List<PresumptiveTBRegisterType> createPresumptiveTBRegisterEncounterTypes(Patient patient,List<Encounter> presumptiveTBRegisterEncounters) {
        return tbDictionary.createPresumptiveTBRegisterType(patient,presumptiveTBRegisterEncounters);
    }

    public List<TBCommunityAndFacilityReferralType> createTbComFacRefEncounterType(List<Encounter> tbCommunityAndFacilityReferralEncounters) {
        return tbDictionary.createTBCommunityAndFacilityReferralType(tbCommunityAndFacilityReferralEncounters);
    }

    public List<TBIndexPatientContactInvestigationType> createTbIndexContactEncounterType(List<Encounter> tbIndexContactEncounters) {
        return tbDictionary.createTBIndexPatientContactInvestigationType(tbIndexContactEncounters);
    }

    public List<DRTBTreatmentRegisterType> createDRTBTreatmentRegisterEncounterTypes(Patient patient, List<Encounter> drTreatmentRegisterTypeEncounters) {
        return tbDictionary.createDRTBTreatmentRegisterType(patient,drTreatmentRegisterTypeEncounters);
    }

    public List<DRTBInPatientDischargeFormType> createDrTBDischargeEncounterTypes(List<Encounter> drtbInPatientDischargeEncounters) {
        return tbDictionary.createDRTBInPatientDischargeFormType(drtbInPatientDischargeEncounters);
    }

    public List<TBInterruptionTrackingType> createTBInterruptionTrackingEncounterTypes(List<Encounter> tBInterruptionTrackingEncounters) {
        return tbDictionary.createTBInterruptionTrackingType(tBInterruptionTrackingEncounters);
    }

    public List<TBLaboratoryRegisterType> createTBLaboratoryRegisterTypeEncounterTypes(List<Encounter> tBLaboratoryRegisterEncounters) {
        return tbDictionary.createTBLaboratoryRegisterType(tBLaboratoryRegisterEncounters);
    }

    public List<SpecimenExaminationRequestFormType> createspecimenrequestEncounterType(List<Encounter> specimenExaminationRequestEncounters) {
        return tbDictionary.createSpecimenExaminationRequest(specimenExaminationRequestEncounters);
    }

    public List<SpecimenExaminationResultFormType> createspecimenresultEncounterType(List<Encounter> specimenExaminationResultEncounters) {
        return tbDictionary.createSpecimenExaminationResultFormType(specimenExaminationResultEncounters);
    }

    public List<LGAHealthFacilityTBCentralRegisterType> createLGAHealthFacilityTBCentralRegisterEncounterTypes(List<Encounter> lGAHealthFacilityTypeEncounters) {
        return tbDictionary.createLGAHealthFacility(lGAHealthFacilityTypeEncounters);
    }

    public List<TBTreatmentMonitoringType> createTBTreatmentMonitoringEncounterType(List<Encounter> tbTreatmentMonitoringTypeEncounters) {
        return tbDictionary.createTBTreatmentMonitoringType(tbTreatmentMonitoringTypeEncounters);
    }

    public List<TBPatientReferralType> createTBPatientReferralEncounterType(List<Encounter> tBPatientReferralEncounters) {
        return tbDictionary.createTBPatientReferralType(tBPatientReferralEncounters);
    }

    /*public List<TBPatientTreatmentCardFormType> createTBCardEncounterType(List<Encounter> tbTreatmentCardEncounters) {
        return tbDictionary.createTBCard(tbTreatmentCardEncounters);
    }*/

    public IndexNotificationServicesType createIndexNotificationServicesTypes(Map<Object, List<Obs>> groupedObsByConcept) {
        IndexNotificationServicesType indexNotificationServicesType = htsDictionary.createIndexNotificationServicesTypes(groupedObsByConcept);
        return indexNotificationServicesType;
    }

    public List<HIVRiskAssessmentType> createHivRiskAssessment(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<HIVRiskAssessmentType> hivRiskAssessmentTypes = new ArrayList<>();
        HIVRiskAssessmentType hivRiskAssessmentType = htsDictionary.createHivRiskAssessment(pts, groupedObsByConcept);
        if (hivRiskAssessmentType != null) {
            hivRiskAssessmentTypes.add(hivRiskAssessmentType);
        }
        return hivRiskAssessmentTypes;
    }

    public List<KnowledgeAssessmentType> createKnowledgeAssessmentType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<KnowledgeAssessmentType> knowledgeAssessmentTypes = new ArrayList<>();
        KnowledgeAssessmentType knowledgeAssessmentType = htsDictionary.createKnowledgeAssessmentType(pts, groupedObsByConcept);
        if (knowledgeAssessmentType != null) {
            knowledgeAssessmentTypes.add(knowledgeAssessmentType);
        }
        return knowledgeAssessmentTypes;
    }

    public List<PostTestCounsellingType> createPostTestCounsellingType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<PostTestCounsellingType> postTestCounsellingTypes = new ArrayList<>();
        PostTestCounsellingType postTestCounsellingType = htsDictionary.createPostTestCouncellingType(pts, groupedObsByConcept);
        if (postTestCounsellingType != null) {
            postTestCounsellingTypes.add(postTestCounsellingType);
        }
        return postTestCounsellingTypes;
    }

    public List<SyndromicSTIScreeningType> createSyndromicsStiType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<SyndromicSTIScreeningType> syndromicSTIScreeningTypes = new ArrayList<>();
        SyndromicSTIScreeningType syndromicSTIScreeningType = htsDictionary.createSyndromicsStiType(pts, groupedObsByConcept);
        if (syndromicSTIScreeningType != null) {
            syndromicSTIScreeningTypes.add(syndromicSTIScreeningType);
        }
        return syndromicSTIScreeningTypes;
    }

    public List<PartnerDetailsType> createPartnerDetails(Patient pts, Map<Integer, List<Encounter>> grouped, Map<Object, List<Obs>> groupedObsByConcept) {
        List<PartnerDetailsType> partnerDetailsTypes = new ArrayList<>();
        List<Encounter> partnerRegisterEncounterId = grouped.get(Utils.Partner_register_Encounter_Id);
        try{
            if (partnerRegisterEncounterId != null && partnerRegisterEncounterId.size() > 0) {
                PartnerDetailsType p_details = htsDictionary.createPartnerDetails(pts, groupedObsByConcept);
                if (p_details != null) {
                    partnerDetailsTypes.add(p_details);
                }
            }
        }catch(Exception ex){
            LoggerUtils.write(NDRMainDictionary.class.getName(),ex.getMessage(),LogFormat.WARNING,LogLevel.debug);
        }
        return partnerDetailsTypes;
    }

    public RecencyType createRecency(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept, RecencyType recency) {
        try {
            return recencyDictionary.createrecencyTags(patient, enc, groupedObsByConcept, recency);
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return recency;
    }

    public List<PartnerInformationType> createPartnerInformationType(Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        return recencyDictionary.createIndexNotificationServicesTypes(groupedObsByConcept);
    }

    public MortalityType createMortalityType(Patient patient, Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept,Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType, MortalityType mortality) {
        try {
            return mortalityDictionary.createMortalityTags(patient, encounter, groupedObsByConcept, groupedpatientBaselineObsByEncounterType,mortality);
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return mortality;
    }
}