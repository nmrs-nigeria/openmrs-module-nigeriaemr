/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class HTSDictionary {

    Utils utils = new Utils();
    //Knowledge assessment
    //private static int Previously_Tested_Hiv_Negative_Concept_Id = 165816;
    // private static int Client_Pregnant_Concept_Id = 166046;
    // private static int Client_Informed_About_Transsmission_Concept_Id = 165801;
    // private static int Client_Informed_About_Risk_Factors_Concept_Id = 165802;
    // private static int Client_Informed_On_Prevention_Concept_Id = 165804;
    // private static int Client_Informed_About_Possible_Concept_Id = 165884;
    //  private static int Informed_Consent_For_Hiv_Testing_Concept_Id = 165805;
    private static int Previously_Tested_Hiv_Negative_Concept_Id = 165799;
    private static int Client_Pregnant_Concept_Id = 1434;
    private static int Client_Informed_About_Transsmission_Concept_Id = 165801;
    private static int Client_Informed_About_Risk_Factors_Concept_Id = 165802;
    private static int Client_Informed_On_Prevention_Concept_Id = 165804;
    private static int Client_Informed_About_Possible_Concept_Id = 165884;
    private static int Informed_Consent_For_Hiv_Testing_Concept_Id = 1710;
    //Risk assessment
    private static int Ever_Had_Sexual_Intercourse_Concept_Id = 165800;
    private static int Blood_Transfussion_In_Last_3_Months = 1063;
    private static int Unprotected_Sex_With_Casual_Partner_In_Last_3_Months = 159218;
    private static int Unprotected_Sex_With_Regular_Partner_In_Last_3_Months = 165803;
    private static int Sti_In_Last_3_Months = 164809;
    private static int More_Than_1_Sex_Partner = 165806;

    //Clinical tb screening
    private static int Current_Cough = 143264;
    private static int Weight_loss = 832;
    private static int Fever = 140238;
    private static int Night_sweats = 133027;
    //Syndronmic Sti
    private static int Complaints_of_vaginal_discharge_or_burning_when_urinating = 165809;
    private static int Complaints_of_lower_abdominal_pains_with_or_without_vaginal_discharge = 165810;
    private static int Complaints_of_urethral_discharge_or_burning_when_urinating = 165811;
    private static int Complaints_of_scrotal_swelling_and_pain = 165812;
    private static int Complaints_of_genital_sore = 165813;
    //Post test councelling
    private static int Have_you_been_tested_for_HIV_before_within_this_year = 165881;
    private static int HIV_Request_and_Result_form_signed_by_tester = 165818;
    private static int HIV_Request_and_Result_form_filled_with_CT_Intake_Form = 165819;
    private static int Client_received_HIV_test_result = 164848;
    private static int Post_test_counseling_done = 159382;
    private static int Risk_reduction_plan_developed = 165820;
    private static int Post_test_disclosure_plan_developed = 165821;
    private static int Will_bring_partner_for_HIV_testing = 165822;
    private static int Will_bring_own_children_Less_5_years_for_HIV_testing = 165823;
    private static int Provided_with_information_on_FP_and_dual_contraception = 1382;
    private static int Client_Partner_use_FP_methods = 165883;
    private static int Client_Partner_use_condoms_as_FP_method = 5571;
    private static int Correct_condom_use_demonstrated = 165824;
    private static int Condoms_provided_to_client = 159777;
    private static int Client_referred_to_other_services = 1648;

    //Client intake form has no concept ids for partner section
    //Partner details
    private static int Partner_Age = 164955;
    private static int Partner_preTest_counselled_ = 164956;
    private static int Partner_accepts_HIV_test = 164957;
    private static int Partner_HIV_test_result = 164958;
    private static int Partner_postTest_counseled = 165571;
    private static int Partner_HBV_status = 165561;
    private static int Partner_HCV_status = 165562;

    private static int Partner_referred_to = 164960;
    //Health facility Visit
    private static int Visit_Date = 1769;
    private static int Visit_Status = 166061;
    private static int Weight = 5089;
    private static int Breast_Feeding = 165876;

    //client intake fields
    public static int HTS_Client_Intake_SETTING_ConceptID = 165839;
    public static int HTS_CLient_Intake_FIRST_TIME_ConceptID = 165790;
    public static int HTS_Client_Intake_SESSION_TYPE_ConceptID = 165793;
    public static int HTS_Client_Intake_REFFERRED_FROM = 165480;
    public static int HTS_Client_Intake_MARITAL_STATUS_ConceptID = 1054;
    public static int HTS_Client_Intake_LESS_THAN_FIVE_CHILDREN = 160312;
    public static int HTS_Client_Intake_NO_OF_COWIFES_ConceptID = 5557;
    public static int HTS_Client_Intake_Client_IDENTIFIED_INDEX = 165794;
    public static int HTS_Client_Intake_INDEX_TYPE = 165798;
    public static int HTS_Client_Intake_INDEX_CLIENT_ID = 165859;
    public static int HTS_Client_Intake_CLIENT_RETESTING = 165976;
    public static int HTS_CLIENT_INTAKE_SETTINGS_OTHERS = 5622;
    public static int HTS_CLIENT_INTAKE_SETTINGS_OTHERS_VALUE = 165966;

    //HIV Testing Result
    public static int SCREENING_TEST_RESULT = 165840;
    public static int CONFIRMATORY_TEST_RESULT = 165841;
    public static int TIE_BREAKER_RESULT = 165842;
    public static int SCREENING_TEST_RESULT_DATE = 165844;
    public static int CONFIRMATORY_TEST_RESULT_date = 165845;
    public static int TIE_BREAKER_RESULT_DATE = 165846;
    public static int FINAL_RESULT = 165843;

    //Index Notification Services
    public static int PARTNER_ELICITATION_GROUPING_CONCEPT = 165858;
    public static int PARTNER_NAME_CONCEPT = 161135;
    public static int PARTNER_GENDER_CONCEPT = 165857;
    public static int PARTNER_INDEX_TYPE_CONCEPT = 165798;
    public static int PARTNER_INDEX_DESCRIPTIVE_ADDRESS_CONCEPT = 166021;
    public static int PARTNER_INDEX_RELATION_PHONE_CONCEPT = 166022;

    //HIV Recency Testing
    public static int HIV_RECENCY_TEST_NAME_CONCEPT = 166216;//formerly 165849
    public static int HIV_RECENCY_TEST_NAME_CONCEPT_OLD = 165849;//now 166216
    public static int HIV_RECENCY_TEST_DATE_CONCEPT = 165850;
    public static int HIV_RECENCY_ASSAY_CONCEPT = 165853;
    public static int SAMPLE_TEST_DATE_CONCEPT = 165854;
    public static int SAMPLE_TEST_RESULT_CONCEPT = 856;
    public static int FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT = 166214;
    public static int OPT_OUT_OF_RTRI = 165805;
    public static int RECENCY_NUMBER = 166209;
    public static int CONTROL_LINE = 166212;
    public static int VERIFICATION_LINE = 166243;
    public static int LONG_TERM_LINE = 166211;
    public static int RECENCY_INTERPRETATION = 166213;
    public static int VIRALLOAD_REQUEST_MADE = 166244;
    public static int VIRAL_LOAD_SAMPLE_COLLECTION_DATE = 159951;
    public static int VIRAL_LOAD_SAMPLE_SENT_DATE = 165988;
    public static int SAMPLE_TYPE = 162476;
    public static int RECEIVING_PCR_LAB = 166233;
    public static int SAMPLE_ID = 165715;
    public static int VIRAL_LOAD_CLASSIFICATION = 166241;

    //syphillis and hepatitis
    private static int SYPHILLIS_STATUS_RESULT = 299;
    private static int HEPATITIS_B_RESULT = 159430;
    private static int HEPATITIS_C_RESULT = 161471;

    public HTSDictionary() {
        loadDictionary();
        loadBooleanDictionary();
        loadYNCodeTypeDictionary();
    }

    private Map<Integer, String> htsDictionary = new HashMap<>();
    private Map<Integer, Boolean> htsBooleanDictionary = new HashMap<>();
    private Map<Integer, YNCodeType> htsYNCodeTypeDict = new HashMap<>();

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        htsDictionary.put(1065, "Y");
        htsDictionary.put(1066, "N");
        htsDictionary.put(1067, "U");
        htsDictionary.put(703, "Pos");
        htsDictionary.put(664, "Neg");
        htsDictionary.put(1228, "R");
        htsDictionary.put(1229, "NR");
        htsDictionary.put(1382, "FP");
        htsDictionary.put(1610, "ART");
        htsDictionary.put(165815, "1");
        htsDictionary.put(165816, "2");
        htsDictionary.put(165817, "3");
        htsDictionary.put(165882, "4");

        //setting
        htsDictionary.put(160539, "1");
        htsDictionary.put(160529, "2");
        htsDictionary.put(160548, "3");
        htsDictionary.put(5271, "4");
        htsDictionary.put(160542, "5");
        htsDictionary.put(161629, "6");
        htsDictionary.put(165788, "7");
        htsDictionary.put(165838, "9");
        htsDictionary.put(5622, "8");
        htsDictionary.put(160545, "7");
        htsDictionary.put(160546,"3");

        //session
        htsDictionary.put(165792, "1");
        htsDictionary.put(165789, "2");
        htsDictionary.put(165885, "3");

        //refferred from
     //   htsDictionary.put(5622, "8");
        htsDictionary.put(978, "1");

        //marital status
        htsDictionary.put(1057, "S");
        htsDictionary.put(5555, "M");
        htsDictionary.put(1058, "D");
        htsDictionary.put(1056, "A");
        htsDictionary.put(1060, "G");
        htsDictionary.put(1059, "W");

        //index type
        htsDictionary.put(165796, "1");
        htsDictionary.put(165797, "2");
        htsDictionary.put(165795, "3");

        //recency
        //recency interpretation
        htsDictionary.put(165852, "R");
        htsDictionary.put(165851, "L");
        htsDictionary.put(664, "Neg");
        htsDictionary.put(163611, "Inv");

        //new final recency result
        htsDictionary.put(166236, "RR");
        htsDictionary.put(166235, "RL");
        htsDictionary.put(166237, "RI");

        htsDictionary.put(166215, "AS");
       htsDictionary.put(166246, "OTH");

        //  htsDictionary.put(165853, "L");
        htsDictionary.put(1000, "P");
        htsDictionary.put(165568, "D");

        htsDictionary.put(166238, "<1000");
        htsDictionary.put(166239, ">1000");
        htsDictionary.put(166240, "failed VL");

        //PCR Lab
        htsDictionary.put(166217, "LIMS190001");
        htsDictionary.put(166218, "LIMS040001");
        htsDictionary.put(166219, "LIMS330001");
        htsDictionary.put(166220, "LIMS150001");
        htsDictionary.put(166221, "LIMS070001");
        htsDictionary.put(166222, "LIMS160001");
        htsDictionary.put(166223, "LIMS320001");
        htsDictionary.put(166224, "LIMS250001");
        htsDictionary.put(166225, "LIMS150002");
        htsDictionary.put(166226, "LIMS250002");
        htsDictionary.put(166227, "LIMS040002");
        htsDictionary.put(166228, "LIMS300001");
        htsDictionary.put(166229, "LIMS080001");
        htsDictionary.put(166230, "LIMS030001");
        htsDictionary.put(166231, "LIMS340001");
        htsDictionary.put(166232, "LIMS350001");
        htsDictionary.put(166234, "LIMS250003");

        //gender
        htsDictionary.put(165184, "M");
        htsDictionary.put(165185, "F");

    }

    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        htsBooleanDictionary.put(1065, true);
        htsBooleanDictionary.put(1066, false);

    }

    private void loadYNCodeTypeDictionary() {
        htsYNCodeTypeDict.put(1065, YNCodeType.YES);
        htsYNCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;

        if (htsYNCodeTypeDict.containsKey(key)) {
            response = htsYNCodeTypeDict.get(key);
        }

        return response;
    }

    private Boolean getBooleanMappedValue(int key) {
        //  Boolean uio = htsBooleanDictionary.get(key);
        if (htsBooleanDictionary.containsKey(key)) {
            return htsBooleanDictionary.get(key);
        } else {
            return htsBooleanDictionary.get(key);
        }
    }

    public HIVTestingReportType createClientIntakeTags(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept, HIVTestingReportType hivTestingReport) throws DatatypeConfigurationException {

        Obs obs;

        List<Integer> obsCodeList = Arrays.asList(HTS_Client_Intake_SETTING_ConceptID,
                HTS_CLient_Intake_FIRST_TIME_ConceptID,HTS_Client_Intake_SESSION_TYPE_ConceptID,
                HTS_Client_Intake_REFFERRED_FROM,HTS_Client_Intake_MARITAL_STATUS_ConceptID,
                HTS_Client_Intake_LESS_THAN_FIVE_CHILDREN,HTS_Client_Intake_NO_OF_COWIFES_ConceptID,
                HTS_Client_Intake_Client_IDENTIFIED_INDEX,HTS_Client_Intake_INDEX_TYPE,
                HTS_Client_Intake_INDEX_CLIENT_ID,HTS_Client_Intake_CLIENT_RETESTING,
                SYPHILLIS_STATUS_RESULT,HEPATITIS_B_RESULT,HEPATITIS_C_RESULT);

        //for client Code
        String htsID = String.valueOf(patient.getPatientIdentifier(Utils.HTS_IDENTIFIER_INDEX));

        if (htsID != null) {
            hivTestingReport.setClientCode(htsID);
        }

        //visit date and ID
        if(enc.getVisit() != null) {
            hivTestingReport.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
        }else {
            hivTestingReport.setVisitID(enc.getEncounterId().toString());
        }
        hivTestingReport.setVisitDate(utils.getXmlDate(enc.getEncounterDatetime()));

        //setting with others been retrieved
        // obs = extractObs(HTS_Client_Intake_SESSION_TYPE_ConceptID, allObs);
        obs = extractObs(HTS_Client_Intake_SETTING_ConceptID, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivTestingReport.setSetting(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //first time visit
        obs = extractObs(HTS_CLient_Intake_FIRST_TIME_ConceptID, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivTestingReport.setFirstTimeVisit(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //put all non required fields inside a try-catch
        try {

            //session
            obs = extractObs(HTS_Client_Intake_SESSION_TYPE_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setSessionType(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //refferred from
            obs = extractObs(HTS_Client_Intake_REFFERRED_FROM, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setReferredFrom(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //marital status

            obs = extractObs(HTS_Client_Intake_MARITAL_STATUS_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setMaritalStatus(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //no. of owned children less than five
            obs = extractObs(HTS_Client_Intake_LESS_THAN_FIVE_CHILDREN, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setNoOfOwnChildrenLessThan5Years(Integer.parseInt(getMappedValue(obs.getValueCoded().getConceptId())));
            }

            //no. of wives/co-wives
            obs = extractObs(HTS_Client_Intake_NO_OF_COWIFES_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueText() != null) {
                hivTestingReport.setNoOfAllWives(Integer.parseInt(obs.getValueText()));
            }

            //is index client
            obs = extractObs(HTS_Client_Intake_Client_IDENTIFIED_INDEX, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setIsIndexClient(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //index type
            if (hivTestingReport.getIsIndexClient().equals("Y")) {
                obs = extractObs(HTS_Client_Intake_INDEX_TYPE, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    hivTestingReport.setIndexType(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                //index client id
                obs = extractObs(HTS_Client_Intake_INDEX_CLIENT_ID, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    hivTestingReport.setIndexClientId(obs.getValueText());
                }
            }

            //client from retesting
            obs = extractObs(HTS_Client_Intake_CLIENT_RETESTING, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setReTestingForResultVerification(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //syphillis and hepatitis result
            //syphilis test result
            obs = extractObs(SYPHILLIS_STATUS_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setSyphilisTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //hepatitis B test result
            obs = extractObs(HEPATITIS_B_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setHBVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //hepatiis C test result
            obs = extractObs(HEPATITIS_C_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setHCVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //signature
            try {
                hivTestingReport.setCompletedBy(enc.getEncounterProviders().stream().findFirst().get().getProvider().getName());
            } catch (Exception ex) {
                LoggerUtils.write(HTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }

        } catch (Exception ex) {
            LoggerUtils.write(HTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return hivTestingReport;

    }

    public HIVTestResultType createHIVTestResult(Patient patient,  Map<Object, List<Obs>> groupedObsByConcept) {
        HIVTestResultType hIVTestResultType = new HIVTestResultType();

        RecencyTestingType recencyTestingType = createRecencyType(patient, groupedObsByConcept);
        TestResultType testResultTypes = createTestResultType(groupedObsByConcept);

        if (recencyTestingType != null) {
            hIVTestResultType.setRecencyTesting(recencyTestingType);
        }

        if (testResultTypes != null) {
            hIVTestResultType.setTestResult(testResultTypes);
        }

        if (hIVTestResultType.getRecencyTesting() == null && hIVTestResultType.getTestResult() == null) {
            return null;
        }

        return hIVTestResultType;
    }

    public IndexNotificationServicesType createIndexNotificationServicesTypes(Map<Object, List<Obs>> groupedObsByConcept) {
        List<PartnerNotificationType> partnerNotificationTypes = new ArrayList<>();
        IndexNotificationServicesType indexNotificationServicesType = new IndexNotificationServicesType();

        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(PARTNER_ELICITATION_GROUPING_CONCEPT);

            allIndexGroupObs.forEach(gObs -> {

                PartnerNotificationType partnerNotificationType = new PartnerNotificationType();

                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());

                List<Integer> obsCodeList = Arrays.asList(PARTNER_NAME_CONCEPT,
                        PARTNER_GENDER_CONCEPT,PARTNER_INDEX_TYPE_CONCEPT,PARTNER_INDEX_DESCRIPTIVE_ADDRESS_CONCEPT,
                        PARTNER_INDEX_RELATION_PHONE_CONCEPT);

                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                //extract all the members using the concept

                //partner gender
                Obs obs = extractObs(PARTNER_GENDER_CONCEPT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerGender(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                //partner index type
                obs = extractObs(PARTNER_INDEX_TYPE_CONCEPT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setIndexRelation(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                partnerNotificationTypes.add(partnerNotificationType);

            });
        } catch (Exception ex) {
            LoggerUtils.write(HTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        if (!partnerNotificationTypes.isEmpty()) {
            indexNotificationServicesType.getPartner().addAll(partnerNotificationTypes);
        } else {
            return null;
        }

        return indexNotificationServicesType;
    }

    //Note returns only one recencyType object
    public RecencyTestingType createRecencyType(Patient patient,  Map<Object, List<Obs>> groupedObsByConcept) {

        RecencyTestingType recencyTestingType = new RecencyTestingType();
        //for recency Code
        PatientIdentifier recencyId = patient.getPatientIdentifier(Utils.RECENCY_INDENTIFIER_INDEX);

        List<Integer> obsCodeList = Arrays.asList(HIV_RECENCY_TEST_NAME_CONCEPT,
                HIV_RECENCY_TEST_DATE_CONCEPT,
                OPT_OUT_OF_RTRI,
                CONTROL_LINE,
                VERIFICATION_LINE,
                LONG_TERM_LINE,
                RECENCY_INTERPRETATION,
                HIV_RECENCY_ASSAY_CONCEPT,
                SAMPLE_TEST_DATE_CONCEPT,
                SAMPLE_TEST_RESULT_CONCEPT,
                FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT,
                VIRAL_LOAD_SAMPLE_COLLECTION_DATE,
                SAMPLE_TYPE,
                RECEIVING_PCR_LAB,
                VIRAL_LOAD_SAMPLE_SENT_DATE,
                VIRALLOAD_REQUEST_MADE,
                SAMPLE_ID,
                VIRAL_LOAD_CLASSIFICATION);

        //test name
        Obs obs = extractObs(HIV_RECENCY_TEST_NAME_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setTestName(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //test date
        obs = extractObs(HIV_RECENCY_TEST_DATE_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            recencyTestingType.setTestDate(utils.getXmlDate(obs.getValueDate()));
        }

        //consent
        obs = extractObs(OPT_OUT_OF_RTRI, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setConsent(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //recency number
        if (recencyId != null) {
            recencyTestingType.setRecencyNumber(recencyId.getIdentifier());
        }

        //control line
        obs = extractObs(CONTROL_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setControlLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //verification line
        obs = extractObs(VERIFICATION_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setVerificationLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //long term line
        obs = extractObs(LONG_TERM_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setLongTermLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //recency interpretation
        obs = extractObs(RECENCY_INTERPRETATION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setRecencyInterpretation(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //rapid recency assay
        obs = extractObs(HIV_RECENCY_ASSAY_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setRapidRecencyAssay(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //VL Sample test date
        obs = extractObs(SAMPLE_TEST_DATE_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            recencyTestingType.setViralLoadConfirmationTestDate(utils.getXmlDate(obs.getValueDate()));
        }

        //result copies
        obs = extractObs(SAMPLE_TEST_RESULT_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueNumeric() != null) {
            recencyTestingType.setViralLoadConfirmationResult(obs.getValueNumeric());
        }

        //final HIV Result
        obs = extractObs(FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setFinalRecencyTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //sample collection
        obs = extractObs(VIRAL_LOAD_SAMPLE_COLLECTION_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyTestingType.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(HTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }

        }

        //sample type
        obs = extractObs(SAMPLE_TYPE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setSampleType(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //receiving PCR LAB
        obs = extractObs(RECEIVING_PCR_LAB, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setPCRLab(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //date sample sent to PCR Lab
        obs = extractObs(VIRAL_LOAD_SAMPLE_SENT_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyTestingType.setDateSampleSent(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(HTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }

        obs = extractObs(VIRALLOAD_REQUEST_MADE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setViralLoadRequest(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //sample ID
        obs = extractObs(SAMPLE_ID, groupedObsByConcept);
        if (obs != null && obs.getValueText() != null) {
            recencyTestingType.setSampleReferenceNumber(obs.getValueText());
        }

        //VL Classification
        obs = extractObs(VIRAL_LOAD_CLASSIFICATION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyTestingType.setViralLoadClassification(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (recencyTestingType.isEmpty()) {
            return null;
        }

        return recencyTestingType;

    }

    public TestResultType createTestResultType(Map<Object, List<Obs>> groupedObsByConcept) {

        TestResultType testResultType = new TestResultType();

        List<Integer> obsCodeList = Arrays.asList(SCREENING_TEST_RESULT,
                CONFIRMATORY_TEST_RESULT,
                TIE_BREAKER_RESULT,
                SCREENING_TEST_RESULT_DATE,
                CONFIRMATORY_TEST_RESULT_date,
                TIE_BREAKER_RESULT_DATE,
                FINAL_RESULT);

        //screening test result
        Obs obs = extractObs(SCREENING_TEST_RESULT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            testResultType.setScreeningTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //confirmatory test result
        obs = extractObs(CONFIRMATORY_TEST_RESULT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            testResultType.setConfirmatoryTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //tie breaker test
        obs = extractObs(TIE_BREAKER_RESULT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            testResultType.setTieBreakerTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //screening test result date
        obs = extractObs(SCREENING_TEST_RESULT_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            testResultType.setScreeningTestResultDate(utils.getXmlDate(obs.getValueDate()));
        }

        //confirmatory test result data
        obs = extractObs(CONFIRMATORY_TEST_RESULT_date, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            testResultType.setConfirmatoryTestResultDate(utils.getXmlDate(obs.getValueDate()));
        }

        //tie test result data
        obs = extractObs(TIE_BREAKER_RESULT_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            testResultType.setTieBreakerTestResultDate(utils.getXmlDate(obs.getValueDate()));
        }

        //final result
        obs = extractObs(FINAL_RESULT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            testResultType.setFinalTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (testResultType.isEmpty()) {
            return null;
        }

        return testResultType;
    }

    public KnowledgeAssessmentType createKnowledgeAssessmentType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        KnowledgeAssessmentType knowledgeAssessmentType = null;

        List<Integer> obsCodeList = Arrays.asList(Previously_Tested_Hiv_Negative_Concept_Id,
                Client_Pregnant_Concept_Id,
                Client_Informed_About_Transsmission_Concept_Id,
                Client_Informed_About_Risk_Factors_Concept_Id,
                Client_Informed_On_Prevention_Concept_Id,
                Client_Informed_About_Possible_Concept_Id,
                Informed_Consent_For_Hiv_Testing_Concept_Id);

        if (htsIdentifier != null) {
            LoggerUtils.write(HTSDictionary.class.getName(), "htsIdentifier is not null", LogFormat.INFO, LogLevel.live);
            knowledgeAssessmentType = new KnowledgeAssessmentType();

            Obs obs = extractObs(Previously_Tested_Hiv_Negative_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setPreviouslyTestedHIVNegative(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Pregnant_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueAsBoolean() != null) {
                knowledgeAssessmentType.setClientPregnant(obs.getValueAsBoolean());
            }
            obs = extractObs(Client_Informed_About_Transsmission_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutHIVTransmissionRoutes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_About_Risk_Factors_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedOfHIVTransmissionRiskFactors(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_On_Prevention_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutPreventingHIV(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_About_Possible_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutPossibleTestResults(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Informed_Consent_For_Hiv_Testing_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueAsBoolean() != null) {
                knowledgeAssessmentType.setInformedConsentForHIVTestingGiven(obs.getValueAsBoolean());
            }

            if (knowledgeAssessmentType.isEmpty()) {
                return null;
            }
        }

        return knowledgeAssessmentType;
    }

    public HIVRiskAssessmentType createHivRiskAssessment(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        HIVRiskAssessmentType hivRiskAssessmentType = new HIVRiskAssessmentType();

        List<Integer> obsCodeList = Arrays.asList(Ever_Had_Sexual_Intercourse_Concept_Id,
                Blood_Transfussion_In_Last_3_Months,
                Unprotected_Sex_With_Casual_Partner_In_Last_3_Months,
                Unprotected_Sex_With_Regular_Partner_In_Last_3_Months,
                Sti_In_Last_3_Months,
                More_Than_1_Sex_Partner);

        if (htsIdentifier != null) {
            Obs obs = extractObs(Ever_Had_Sexual_Intercourse_Concept_Id, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setEverHadSexualIntercourse(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Blood_Transfussion_In_Last_3_Months, groupedObsByConcept);
            if (obs != null && obs.getValueAsBoolean() != null) {
                hivRiskAssessmentType.setBloodTransfussionInLast3Months(obs.getValueAsBoolean());
            }
            obs = extractObs(Unprotected_Sex_With_Casual_Partner_In_Last_3_Months, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setUnprotectedSexWithCasualPartnerinLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Unprotected_Sex_With_Regular_Partner_In_Last_3_Months, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setUnprotectedSexWithRegularPartnerInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Sti_In_Last_3_Months, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setSTIInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(More_Than_1_Sex_Partner, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setMoreThan1SexPartnerDuringLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
        }
        if (hivRiskAssessmentType.isEmpty()) {
            return null;
        }

        return hivRiskAssessmentType;
    }

    public SyndromicSTIScreeningType createSyndromicsStiType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        SyndromicSTIScreeningType syndromicSTIScreeningType = null;

        List<Integer> obsCodeList = Arrays.asList(
                Complaints_of_vaginal_discharge_or_burning_when_urinating,
                Complaints_of_lower_abdominal_pains_with_or_without_vaginal_discharge,
                Complaints_of_urethral_discharge_or_burning_when_urinating,
                Complaints_of_scrotal_swelling_and_pain,
                Complaints_of_genital_sore);

        if (htsIdentifier != null) {
            syndromicSTIScreeningType = new SyndromicSTIScreeningType();
            Obs obs = extractObs(Complaints_of_vaginal_discharge_or_burning_when_urinating, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {

                syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));

            } else {
                //handles male
                syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(false);
            }
            obs = extractObs(Complaints_of_lower_abdominal_pains_with_or_without_vaginal_discharge, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {

                syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            } else {
                //handles male
                syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(false);
            }
            obs = extractObs(Complaints_of_urethral_discharge_or_burning_when_urinating, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                syndromicSTIScreeningType.setUrethralDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            } else {
                //handles female
                syndromicSTIScreeningType.setUrethralDischargeOrBurningWhenUrinating(false);

            }
            obs = extractObs(Complaints_of_scrotal_swelling_and_pain, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                syndromicSTIScreeningType.setScrotalSwellingAndPain(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            } else {
                //handles female
                syndromicSTIScreeningType.setScrotalSwellingAndPain(false);
            }
            obs = extractObs(Complaints_of_genital_sore, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                syndromicSTIScreeningType.setGenitalSoreOrSwollenInguinalLymphNodes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
        }

        return syndromicSTIScreeningType;
    }

    public PostTestCounsellingType createPostTestCouncellingType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        PostTestCounsellingType postTestCounsellingType = null;

        List<Integer> obsCodeList = Arrays.asList(
                Have_you_been_tested_for_HIV_before_within_this_year,
                HIV_Request_and_Result_form_signed_by_tester,
                HIV_Request_and_Result_form_filled_with_CT_Intake_Form,
                Client_received_HIV_test_result,
                Post_test_counseling_done,
                Risk_reduction_plan_developed,
                Post_test_disclosure_plan_developed,
                Will_bring_partner_for_HIV_testing,
                Will_bring_own_children_Less_5_years_for_HIV_testing,
                Provided_with_information_on_FP_and_dual_contraception,
                Client_Partner_use_FP_methods,
                Client_Partner_use_condoms_as_FP_method,
                Correct_condom_use_demonstrated,
                Condoms_provided_to_client,
                Client_referred_to_other_services);

        if (htsIdentifier != null) {
            postTestCounsellingType = new PostTestCounsellingType();
            Obs obs = extractObs(Have_you_been_tested_for_HIV_before_within_this_year, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Have_you_been_tested_for_HIV_before_within_this_year", LogFormat.FATAL, LogLevel.debug);
                postTestCounsellingType.setTestedForHIVBeforeWithinThisYear(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Have_you_been_tested_for_HIV_before_within_this_year", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(HIV_Request_and_Result_form_signed_by_tester, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setHIVRequestAndResultFormSignedByTester(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(HIV_Request_and_Result_form_filled_with_CT_Intake_Form, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setHIVRequestAndResultFormFilledWithCTIForm(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_received_HIV_test_result, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setClientRecievedHIVTestResult(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Post_test_counseling_done, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setPostTestCounsellingDone(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Risk_reduction_plan_developed, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setRiskReductionPlanDeveloped(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Post_test_disclosure_plan_developed, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setPostTestDisclosurePlanDeveloped(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Will_bring_partner_for_HIV_testing, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setWillBringPartnerForHIVTesting(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Will_bring_own_children_Less_5_years_for_HIV_testing, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setWillBringOwnChildrenForHIVTesting(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Provided_with_information_on_FP_and_dual_contraception, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setProvidedWithInformationOnFPandDualContraception(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Partner_use_FP_methods, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setClientOrPartnerUseFPMethodsOtherThanCondoms(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Partner_use_condoms_as_FP_method, groupedObsByConcept);
            if (obs != null && obs.getValueAsBoolean() != null) {
                postTestCounsellingType.setClientOrPartnerUseCondomsAsOneFPMethods(obs.getValueAsBoolean());
            }
            obs = extractObs(Correct_condom_use_demonstrated, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setCorrectCondomUseDemonstrated(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Condoms_provided_to_client, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setCondomsProvidedToClient(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_referred_to_other_services, groupedObsByConcept);
            if (obs != null && obs.getValueAsBoolean() != null) {
                postTestCounsellingType.setClientReferredToOtherServices(obs.getValueAsBoolean());
            }
        }

        return postTestCounsellingType;
    }

    public ClinicalTBScreeningType createClinicalTbScreening(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

        if (htsIdentifier == null) {
            return null;
        }
        List<Integer> obsCodeList = Arrays.asList(
                Current_Cough,
                Weight_loss,
                Fever,
                Night_sweats
        );

        ClinicalTBScreeningType clinicalTBScreeningType = new ClinicalTBScreeningType();

        Obs obs = extractObs(Current_Cough, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setCurrentlyCough(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(Weight_loss, groupedObsByConcept);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setWeightLoss(obs.getValueAsBoolean());
        }
        obs = extractObs(Fever, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setFever(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(Night_sweats, groupedObsByConcept);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setNightSweats(obs.getValueAsBoolean());
        }

        return clinicalTBScreeningType;
    }

    public PartnerDetailsType createPartnerDetails(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) {
        List<Integer> obsCodeList = Arrays.asList(Partner_Age,Partner_preTest_counselled_,Partner_accepts_HIV_test,
                Partner_HIV_test_result,Partner_postTest_counseled,Partner_HBV_status,Partner_HCV_status,
                SYPHILLIS_STATUS_RESULT,Partner_referred_to);
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

        PartnerDetailsType partnerDetailsType = new PartnerDetailsType();
        int value_numeric;

        if (htsIdentifier != null) {
            Obs obs =  Utils.extractObs(Partner_Age, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                partnerDetailsType.setPartnerAge(value_numeric);
            }
            obs =  Utils.extractObs(Partner_preTest_counselled_, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPreTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_accepts_HIV_test, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerAcceptsHIVTest(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
            }
            obs =  Utils.extractObs(Partner_HIV_test_result, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHIVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
            }
            obs =  Utils.extractObs(Partner_postTest_counseled, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPostTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
            }
            obs =  Utils.extractObs(Partner_HBV_status, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHBVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs =  Utils.extractObs(Partner_HCV_status, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHCVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs =  Utils.extractObs(SYPHILLIS_STATUS_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerSyphilisStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
            }

            obs =  Utils.extractObs(Partner_referred_to, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerReferredTo(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
            }

        }

        return partnerDetailsType;
    }

    private String getMappedValue(int conceptID) {
        try {
            return htsDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }
}