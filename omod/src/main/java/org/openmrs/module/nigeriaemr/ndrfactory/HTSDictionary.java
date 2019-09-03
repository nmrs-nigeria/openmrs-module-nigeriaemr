/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.*;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class HTSDictionary {

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
    private static int Partner_syphilis_status = 299;
    private static int Partner_referred_to = 164960;
    //Health facility Visit
    private static int Visit_Date = 1769;
    private static int Visit_Status = 166061;
    private static int Weight = 5089;
    private static int Breast_Feeding = 165876;
    
       //client intake fields
    public static int  HTS_Client_Intake_SETTING_ConceptID = 165839;
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
    
    
    //HIV Testing Result
    public static int SCREENING_TEST_RESULT = 165840;
    public static int CONFIRMATORY_TEST_RESULT = 165841;
    public static int TIE_BREAKER_RESULT = 165842;
    public static int SCREENING_TEST_RESULT_DATE = 165844;
    public static int CONFIRMATORY_TEST_RESULT_date = 165845;
    public static int TIE_BREAKER_RESULT_DATE = 165846;
    
    //Index Notification Services
    public static int PARTNER_ELICITATION_GROUPING_CONCEPT=165858;
    public static int PARTNER_GENDER_CONCEPT=165857;
    public static int PARTNER_INDEX_TYPE_CONCEPT=165798;
    public static int PARTNER_INDEX_DESCRIPTIVE_ADDRESS_CONCEPT=166012;
    public static int PARTNER_INDEX_RELATION_PHONE_CONCEPT=166022;
    //HIV Recency Testing
    public static int HIV_RECENCY_TEST_NAME_CONCEPT=165849;
    public static int HIV_RECENCY_TEST_DATE_CONCEPT=165850;
    public static int HIV_RECENCY_ASSAY_CONCEPT=165853;
    public static int SAMPLE_TEST_DATE_CONCEPT=165854;
    public static int SAMPLE_TEST_RESULT_CONCEPT=165855;
    public static int FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT=165856;
    
    

    public HTSDictionary() {
        loadDictionary();
        loadBooleanDictionary();
    }

    private Map<Integer, String> htsDictionary = new HashMap<>();
    private Map<Integer, Boolean> htsBooleanDictionary = new HashMap<>();

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        htsDictionary.put(1065, "Y");
        htsDictionary.put(1066, "N");
        htsDictionary.put(703, "Pos");
        htsDictionary.put(664, "Neg");
        htsDictionary.put(1228, "R");
        htsDictionary.put(1229, "NR");
        htsDictionary.put(1382, "FP");
        htsDictionary.put(1610, "ART");
        htsDictionary.put(5622, "Other");
        htsDictionary.put(165815, "1");
        htsDictionary.put(165816, "2");
        htsDictionary.put(165817, "3");
        htsDictionary.put(165882, "4");
    }

    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        htsBooleanDictionary.put(1065, true);
        htsBooleanDictionary.put(1066, false);

    }

    private Boolean getBooleanMappedValue(int key) {
        Boolean uio = htsBooleanDictionary.get(key);
        if (htsBooleanDictionary.containsKey(key)) {
            return htsBooleanDictionary.get(key);
        } else {
            return htsBooleanDictionary.get(key);
        }
    }

    public KnowledgeAssessmentType createKnowledgeAssessmentType(Patient pts, List<Encounter> enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        KnowledgeAssessmentType knowledgeAssessmentType = null;
        
        if (htsIdentifier != null) {
            LoggerUtils.write(HTSDictionary.class.getName(), "htsIdentifier is not null", LogFormat.INFO, LogLevel.live);
            knowledgeAssessmentType = new KnowledgeAssessmentType();

            Obs obs = extractObs(Previously_Tested_Hiv_Negative_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null){
                knowledgeAssessmentType.setPreviouslyTestedHIVNegative(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Pregnant_Concept_Id, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                knowledgeAssessmentType.setClientPregnant(obs.getValueAsBoolean());
            }
            obs = extractObs(Client_Informed_About_Transsmission_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutHIVTransmissionRoutes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_About_Risk_Factors_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedOfHIVTransmissionRiskFactors(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_On_Prevention_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutPreventingHIV(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Informed_About_Possible_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                knowledgeAssessmentType.setClientInformedAboutPossibleTestResults(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Informed_Consent_For_Hiv_Testing_Concept_Id, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                knowledgeAssessmentType.setInformedConsentForHIVTestingGiven(obs.getValueAsBoolean());
            }

            if(knowledgeAssessmentType.isEmpty()){
                return null;
            }
        }

        return knowledgeAssessmentType;
    }



   public HIVRiskAssessmentType createHivRiskAssessment(Patient pts, List<Encounter> enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        HIVRiskAssessmentType hivRiskAssessmentType = new HIVRiskAssessmentType();

        if (htsIdentifier != null) {
            Obs obs = extractObs(Ever_Had_Sexual_Intercourse_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setEverHadSexualIntercourse(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Blood_Transfussion_In_Last_3_Months, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                hivRiskAssessmentType.setBloodTransfussionInLast3Months(obs.getValueAsBoolean());
            }
            obs = extractObs(Unprotected_Sex_With_Casual_Partner_In_Last_3_Months, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setUnprotectedSexWithCasualPartnerinLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Unprotected_Sex_With_Regular_Partner_In_Last_3_Months, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setUnprotectedSexWithRegularPartnerInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Sti_In_Last_3_Months, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setsTIInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(More_Than_1_Sex_Partner, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setMoreThan1SexPartnerDuringLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
        }
        if(hivRiskAssessmentType.isEmpty())
            return null;

        return hivRiskAssessmentType;
    }

    public SyndromicSTIScreeningType createSyndromicsStiType(Patient pts, List<Encounter> enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        SyndromicSTIScreeningType syndromicSTIScreeningType = null;

        if (htsIdentifier != null) {
            syndromicSTIScreeningType = new SyndromicSTIScreeningType();
            Obs obs = extractObs(Complaints_of_vaginal_discharge_or_burning_when_urinating, obsList);
            if (obs != null && obs.getValueCoded() != null){

                syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));

            }else {
                //handles male
                syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(false);
            }
            obs = extractObs(Complaints_of_lower_abdominal_pains_with_or_without_vaginal_discharge, obsList);
            if (obs != null && obs.getValueCoded() != null) {

                syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            } else  {
                //handles male
                syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(false);
            }
            obs = extractObs(Complaints_of_urethral_discharge_or_burning_when_urinating, obsList);
            if (obs != null && obs.getValueCoded() != null)
            {
                syndromicSTIScreeningType.setUrethralDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            else {
                //handles female
                syndromicSTIScreeningType.setUrethralDischargeOrBurningWhenUrinating(false);

            }
            obs = extractObs(Complaints_of_scrotal_swelling_and_pain, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                syndromicSTIScreeningType.setScrotalSwellingAndPain(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            } else {
               //handles female
                syndromicSTIScreeningType.setScrotalSwellingAndPain(false);
            }
            obs = extractObs(Complaints_of_genital_sore, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                syndromicSTIScreeningType.setGenitalSoreOrSwollenInguinalLymphNodes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
        }

        return syndromicSTIScreeningType;
    }

    public PostTestCounsellingType createPostTestCouncellingType(Patient pts, List<Encounter> enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        PostTestCounsellingType postTestCounsellingType = null;

        if (htsIdentifier != null) {
            postTestCounsellingType = new PostTestCounsellingType();
            Obs obs = extractObs(Have_you_been_tested_for_HIV_before_within_this_year, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Have_you_been_tested_for_HIV_before_within_this_year", LogFormat.FATAL, LogLevel.debug);
                postTestCounsellingType.setTestedForHIVBeforeWithinThisYear(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Have_you_been_tested_for_HIV_before_within_this_year", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(HIV_Request_and_Result_form_signed_by_tester, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.sethIVRequestAndResultFormSignedByTester(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(HIV_Request_and_Result_form_filled_with_CT_Intake_Form, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.sethIVRequestAndResultFormFilledWithCTIForm(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_received_HIV_test_result, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setClientRecievedHIVTestResult(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Post_test_counseling_done, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setPostTestCounsellingDone(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Risk_reduction_plan_developed, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setRiskReductionPlanDeveloped(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Post_test_disclosure_plan_developed, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setPostTestDisclosurePlanDeveloped(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Will_bring_partner_for_HIV_testing, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setWillBringPartnerForHIVTesting(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Will_bring_own_children_Less_5_years_for_HIV_testing, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setWillBringOwnChildrenForHIVTesting(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Provided_with_information_on_FP_and_dual_contraception, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setProvidedWithInformationOnFPandDualContraception(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Partner_use_FP_methods, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setClientOrPartnerUseFPMethodsOtherThanCondoms(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_Partner_use_condoms_as_FP_method, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                postTestCounsellingType.setClientOrPartnerUseCondomsAsOneFPMethods(obs.getValueAsBoolean());
            }
            obs = extractObs(Correct_condom_use_demonstrated, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setCorrectCondomUseDemonstrated(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Condoms_provided_to_client, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                postTestCounsellingType.setCondomsProvidedToClient(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Client_referred_to_other_services, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                postTestCounsellingType.setClientReferredToOtherServices(obs.getValueAsBoolean());
            }
        }

        return postTestCounsellingType;
    }

    public ClinicalTBScreeningType createClinicalTbScreening(Patient pts, List<Encounter> enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

        if (htsIdentifier == null) {
            return null;
        }
        ClinicalTBScreeningType clinicalTBScreeningType = new ClinicalTBScreeningType();

        Obs obs = extractObs(Current_Cough, obsList);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setCurrentlyCough(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(Weight_loss, obsList);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setWeightLoss(obs.getValueAsBoolean());
        }
        obs = extractObs(Fever, obsList);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setFever(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(Night_sweats, obsList);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setNightSweats(obs.getValueAsBoolean());
        }

        return clinicalTBScreeningType;
    }

   /* public ClinicalTBScreeningType createClinicalTbScreening(Patient pts, Encounter enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        ClinicalTBScreeningType clinicalTBScreeningType = new ClinicalTBScreeningType();

        if (htsIdentifier != null) {

            Obs obs = extractObs(Current_Cough, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                clinicalTBScreeningType.setCurrentlyCough(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Weight_loss, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                clinicalTBScreeningType.setWeightLoss(obs.getValueAsBoolean());
            }
            obs = extractObs(Fever, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                clinicalTBScreeningType.setFever(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Night_sweats, obsList);
            if (obs != null && obs.getValueAsBoolean() != null) {
                clinicalTBScreeningType.setNightSweats(obs.getValueAsBoolean());
            }

        }

        return clinicalTBScreeningType;
    }*/

    public PartnerDetailsType createPartnerDetails(Patient pts, Encounter enc, List<Obs> obsList) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

        PartnerDetailsType partnerDetailsType = new PartnerDetailsType();
        int value_numeric;

        if (htsIdentifier != null) {

            Obs obs = extractObs(Partner_Age, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                partnerDetailsType.setPartnerAge(value_numeric);
            }
            obs = extractObs(Partner_preTest_counselled_, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPreTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_accepts_HIV_test, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerAcceptsHIVTest(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_HIV_test_result, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHIVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_postTest_counseled, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPostTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_HBV_status, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHBVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_HCV_status, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHCVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs = extractObs(Partner_syphilis_status, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerSyphilisStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
            }

            obs = extractObs(Partner_referred_to, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(HTSDictionary.class.getName(), "About to pull Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerReferredTo(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(HTSDictionary.class.getName(), "Finished pulling Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
            }

        }

        return partnerDetailsType;
    }

    public HealthFacilityVisitsType createHealthFacilityVisit(Patient pts, Encounter enc, List<Obs> obsList) throws DatatypeConfigurationException {
        HealthFacilityVisitsType healthFacilityVisitsType = new HealthFacilityVisitsType();

        return healthFacilityVisitsType;
    }

    private String getMappedValue(int conceptID) {
        try {
            return htsDictionary.get(conceptID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }
}
