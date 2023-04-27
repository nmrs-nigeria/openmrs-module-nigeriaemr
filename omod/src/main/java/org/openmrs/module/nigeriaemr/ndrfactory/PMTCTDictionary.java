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
import org.openmrs.module.nigeriaemr.model.ndr.AntenatalRegistrationType.Syphilis;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PMTCTDictionary {
    Utils utils = new Utils();
    private final PharmacyDictionary pharmacyDictionary;

    // Logger logger = Logger.getLogger(PMTCTDictionary.class);
    //Antenatal registration concepts
    final static int Date_Of_Visit_Concept_Id = 159590;
    final static int Last_Menstural_Period_Concept_Id = 1427;
    final static int Gestational_Age_At_ANC_Registration_Concept_Id = 1438;
    final static int Gravida_Concept_Id = 5624;
    final static int Parity_Concept_Id = 1053;
    final static int Source_Of_Referal_Concept_Id = 165847;
    final static int EDD_Concept_Id = 5596;
    final static int Test_For_Syphilis_Concept_Id = 165280;
    final static int Syphilis_Test_Result_Concept_Id = 299;
    final static int Treated_For_Syphilis_Concept_Id = 160733;
    final static int Reffered_Syphilis_Positive_Client_Concept_Id = 165517;
    final static int  anc_no = 165567;
    //Delivery encounter concepts
    final static int Time_Of_Hiv_Diagnosis_Concept_Id = 164851;
    final static int Gestation_Age_At_Delivery_Concept_Id = 1409;
    final static int Hbv_Status_Concept_Id = 159430;
    final static int Hcv_Status_Concept_Id = 161471;
    final static int Woman_On_Art_Concept_Id = 160119;
    final static int Art_Started_In_Ld_Ward_Concept_Id = 165563;
    final static int Rom_Delivery_Internal_Concept_Id = 165479;
    final static int Mode_Of_Delivery_Concept_Id = 5630;
    final static int Episiotomy_Concept_Id = 5577;
    final static int Vaginal_Tear_Concept_Id = 165929;
    final static int Feeding_Decision_Concept_Id = 985;
    final static int Maternal_Outcome_Concept_Id = 160085;
    //child birth details concepts
    final static int Hiv_Exposed_Infant_Number_Concept_Id = 165668;
    final static int Date_of_Birth_Concept_Id = 164802;
    final static int Child_Sex_Concept_Id = 1587;
    final static int Hbv_Exposed_Infant_Given_Blg_Within_24_Hours_Concept_Id = 165667;
    final static int Non_Hbv_Exposed_Infant_Given_Blg_Within_24_Hours_Concept_Id = 165930;
    final static int Apgar_Score_Concept_Id = 1504;
    final static int Mean_Upper_Arm_Circumference_Concept_Id = 165935;
    final static int Birth_Length_Concept_Id = 1503;
    final static int Birth_Weight_concept_Id = 5916;
    final static int Head_Circumference_Concept_Id = 5314;
    final static int Immunization_Received_At_Birth_Concept_Id = 5314;
    final static int Infant_Arv_Type_Concept_Id = 164971;
    final static int Timimg_Of_Arv_Prophylaxis_Concept_Id = 165864;
    final static int Age_At_Ctx_Initiation_Concept_Id = 164979;
    final static int Infant_Outcome_at_18_Months_Concept_Id = 165035;
    final static int Date_Linked_to_Art_Clinic_Concept_Id = 166062;
    final static int Art_Enrollment_No_Concept_Id = 165560;
    final static int Arv_Prophylaxis_Concept_Id = 164971;
    //Immunization
    final static int Immunization_Date = 1410;
    final static int Lot_Number = 1420;

    //Infant PCR
    private static final int AgeAtTest = 0;//the concept for this was not found at this time
    private static final int Date_Sample_Collected = 165869;
    private static final int Date_Sample_Sent = 165870;
    private static final int Date_Result_Received = 165874;
    private static final int Date_Caregiver_Given_Result = 165873;
    private static final int Test_Result = 165872;
    private static final int Date_of_Test = 165025;

    //Maternal Cohort
    private static final int viralLoadPeriod_ConceptID = 166124;
    private static final int sampleCollectionDate_ConceptID = 159951;
    private static final int viralLoadResult_ConceptID = 166122;
    private static final int pmtctEntryPoint_ConceptID = 164851;
    private static final int gestationalAgeAtSampleCollection_ConceptID = 166125;
    private static final int gestationalAge_ConceptID = 1438;
    private static final int timingOfArtInitiation_ConceptID = 165518;
    private static final int tbStatus_ConceptID = 1659;
    private static final int gravida_ConceptID = 5624;
    private static final int artStartDate_ConceptID = 159599;
    private static final int dateOfDelivery_ConceptID = 5599;
    private static final int familyPlanningCounselling_ConceptID = 1382;
    private static final int familyPlanningMethod_ConceptID = 374;

    //PMTCTHTS tag concept IDs
    private static final int hts_register_setting_ConceptID = 166025;
    private static final int previouslyKnownHIVPositive_ConceptID = 166030;
    private static final int acceptedHIVTesting_ConceptID = 164167;
    private static final int hivTestResult_ConceptID = 159427;
    private static final int recievedHIVTestResult_ConceptID = 164848;
    private static final int hivRetesting_ConceptID = 166033;
    private static final int testedForHepB_ConceptID = 165514;
    private static final int hepBTestResult_ConceptID = 166036;
    private static final int testedForHepC_ConceptID = 165515;
    private static final int hepCTestResult_ConceptID = 166037;
    private static final int hivHBVCoinfected_ConceptID = 166038;
    private static final int hivHCVCoinfected_ConceptID = 166039;
    private static final int agreedToPartnerNotification_ConceptID = 166039;

    //PMTCTClinicalTBScreening tag concept IDs
    private static final int currentlyCough_ConceptID = 143264;
    private static final int weightLoss_ConceptID = 832;
    private static final int fever_ConceptID = 140238;
    private static final int nightSweats_ConceptID = 133027;
    private static final int contactWithTBPositivePatient_ConceptID = 124068;


    //Health facility Visit
    final static int visit_Date = 1769;
    final static int visit_Status = 166129;
    final static int weight = 5089;
    final static int breast_Feeding = 165047;
    final static int cotrimoxazole_conceptID = 0;
    //    final static int prescribedRegimen_conceptID = 165708;
    final static int prescribedRegimenLineCode_conceptID = 165708;
    final static int maternalOutcome_conceptID = 160085;

    //Partner details
    final static int Partner_Age = 164955;
    final static int Partner_preTest_counselled_ = 164956;
    final static int Partner_accepts_HIV_test = 164957;
    final static int Partner_HIV_test_result = 1436;
    final static int Partner_postTest_counseled = 165571;
    final static int Partner_HBV_status = 165561;
    final static int Partner_HCV_status = 165562;
    final static int Partner_referred_to = 164960;
    final static int SYPHILIS_STATUS_RESULT = 299;

    // Infant Rapid Test
    final static int rapid_test_date = 165025;
    final static int rapid_test_result = 165026;
    final static int rapid_test_age = 0; //not available

    //PMTCT Registration
    final static int GeneralANCNumber = 165567;
    final static int PmtctEntryPoint = 166508;
    final static int HtsRegSetting = 166025;
    final static int Infacility = 166509;
    final static int CommunityBased = 166510;


    public PMTCTDictionary() {
        pharmacyDictionary = new PharmacyDictionary();
        loadDictionary();
    }

    private Map<Integer, String> pmtctDictionary = new HashMap<>();
    private Map<Integer, String> pmtct2Dictionary = new HashMap<>();
    private Map<Integer, String> syphilis = new HashMap<>();
    private Map<Integer, String> maternalOutcome = new HashMap<>();
    private Map<Integer, Boolean> yesNoToggle = new HashMap<>();
    private Map<Integer, String> timing = new HashMap<>();
    private Map<Integer, String> fpm = new HashMap<>();
    private Map<Integer, Integer> tb = new HashMap<>();
    private Map<Integer, String> arv = new HashMap<>();

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        pmtctDictionary = new HashMap<>();
        pmtctDictionary.put(703, "Pos");
        pmtctDictionary.put(664, "Neg");
        pmtctDictionary.put(1065, "Y");
        pmtctDictionary.put(1066, "N");
        pmtctDictionary.put(165478, "2");
        pmtctDictionary.put(165477, "1");
        pmtctDictionary.put(5630, "Unbooked");
        pmtctDictionary.put(5526, "EBF");
        pmtctDictionary.put(164857, "ERF");
        pmtctDictionary.put(160429, "Alive");
        pmtctDictionary.put(164970, "1");
        pmtctDictionary.put(165860, "1");
        pmtctDictionary.put(1228, "Pos");
        pmtctDictionary.put(1229, "Neg");
        pmtctDictionary.put(134612, "Dead");
        pmtctDictionary.put(1170, "1");
        pmtctDictionary.put(1171, "2");
        pmtctDictionary.put(159739, "3");
        pmtctDictionary.put(165544, "2");
        pmtctDictionary.put(1107, "3");
        pmtctDictionary.put(165863, "1");
        pmtctDictionary.put(165862, "2");
        pmtctDictionary.put(165861, "3");
        //Visit status
        pmtctDictionary.put(166126, "A");
        pmtctDictionary.put(160563, "TI");
        pmtctDictionary.put(159492, "TO");
        pmtctDictionary.put(166127, "DC"); // TP = Transferred to another PMTCT cohort (new pregnancy)
        pmtctDictionary.put(166128, "L"); // TA = Transitioned to ART clinic
        pmtctDictionary.put(160031, "X");
        pmtctDictionary.put(5240, "LTFU");
        pmtctDictionary.put(160432, "D");
        //Point of entry
        pmtctDictionary.put(1622, "1");
        pmtctDictionary.put(164850, "2");
        pmtctDictionary.put(1180, "4");
        pmtctDictionary.put(166121, "5");

        pmtct2Dictionary.put(166026, "Prenatal");
        pmtct2Dictionary.put(166027, "Perinatal");
        pmtct2Dictionary.put(1180, "Postpartum_less_than_or_equal_72");
        pmtct2Dictionary.put(166121, "Postpartum_greater_than_72");

        //Viral Load Period
        pmtctDictionary.put(166122, "1");
        pmtctDictionary.put(166123, "2");

        //PMTCT HTS maps
        pmtctDictionary.put(166026, "1");
        pmtctDictionary.put(166027, "2");
        pmtctDictionary.put(166028, "3");
        pmtctDictionary.put(166032, "RHN");
        pmtctDictionary.put(166034, "SHP");

        //partner referred to
        pmtctDictionary.put(1382, "FP");
        pmtctDictionary.put(1610, "ART");
        pmtctDictionary.put(5622, "Other");

        //Child Outcome at 18 months
        pmtctDictionary.put(165552, "1");
        pmtctDictionary.put(165553, "2");
        pmtctDictionary.put(165554, "3");
        pmtctDictionary.put(1404, "4");
        pmtctDictionary.put(165556, "5");
        pmtctDictionary.put(165557, "6");
        pmtctDictionary.put(165558, "7");

        //birth MUAC
        pmtctDictionary.put(165933, "LT");
        pmtctDictionary.put(165934, "GT");

        //pmtctReg
        pmtctDictionary.put(166509, "In_Facility");
        pmtctDictionary.put(166510, "Community_Based");
        pmtctDictionary.put(166511, "Spokes");

        pmtctDictionary.put(166512, "Birth_center");
        pmtctDictionary.put(166513, "Traditional_birth_center");
        pmtctDictionary.put(166514, "PMTCT_CAP");
        pmtctDictionary.put(166515, "Traditional_birth_attendant");

        //ARV
        arv = new HashMap<>();
        arv.put(164970, "AP1");
        arv.put(165544, "AP2");

        //infant Rapid Test Result
        pmtctDictionary.put(1138, "Indet");

        //Family Planning Method
        fpm = new HashMap<>();
        fpm.put(1107, "FP1");
        fpm.put(190, "FP2");
        fpm.put(780, "FP3");
        fpm.put(5279, "FP4");
        fpm.put(159589, "FP5");
        fpm.put(136452, "FP6");
        fpm.put(5622, "FP7");
//        pmtctDictionary.put(166123, "FP8");

        //Timing of ART Initialization
        timing = new HashMap<>();
        timing.put(165519, "AIT1");
        timing.put(165520, "AIT2");
        timing.put(165521, "AIT3");
        timing.put(164850, "AIT4");
        timing.put(1180, "AIT5");
        //Tb Status
        tb = new HashMap<>();
        tb.put(1660, 1);
        tb.put(142177, 2);
        tb.put(166042, 3);
        tb.put(1661, 5);
        tb.put(1662, 4);

        //Maternal Outcome
        maternalOutcome = new HashMap<>();
        maternalOutcome.put(160432, "Dead");
        maternalOutcome.put(166126, "A");
        maternalOutcome.put(160563, "TO");
        maternalOutcome.put(166127, "TP");
        maternalOutcome.put(166128, "TA");
        maternalOutcome.put(5240, "LTFU");

        yesNoToggle.put(1066, Boolean.FALSE);
        yesNoToggle.put(1065, Boolean.TRUE);
        yesNoToggle.put(0, Boolean.FALSE);
        yesNoToggle.put(1, Boolean.TRUE);

        //Timing of HIV
        timing.put(166026,"2");
        timing.put(165825,"3");
        timing.put(165826,"4");
        timing.put(165475,"1");

        //SyphilisStatus
        syphilis.put(1228, "R");
        syphilis.put(1229, "NR");
        syphilis.put(664, "NR");
        syphilis.put(703, "R");

        pmtctDictionary.put(165860, "4");
    }

    public List<AntenatalRegistrationType> createAntenatalRegistrationType(List<Encounter> anteNatalEncounters) {
        List<AntenatalRegistrationType> antenatalRegistrationTypes = new ArrayList<>();
        try {
            for (Encounter enc : anteNatalEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> anthenatalObsList = Utils.groupedByConceptIdsOnly(obsList);
                AntenatalRegistrationType registrationType = new AntenatalRegistrationType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    registrationType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    registrationType.setVisitID(enc.getEncounterId().toString());
                }
                registrationType.setVisitDate(convertedDate);

                Obs obs = extractObs(Last_Menstural_Period_Concept_Id, anthenatalObsList);
                if (obs.getObsDatetime() != null) {
                    registrationType.setLastMenstralPeriod(utils.getXmlDate(obs.getObsDatetime()));
                }
                obs = extractObs(Gestational_Age_At_ANC_Registration_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    registrationType.setGestationalAgeAtANCRegistration(value_numeric);
                }

                obs = extractObs(Gravida_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    registrationType.setGravida(value_numeric);
                }
                obs = extractObs(Parity_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    registrationType.setParity(value_numeric);
                }
                obs = extractObs(Source_Of_Referal_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueText() != null) {
                    registrationType.setSourceOfReferral(obs.getValueText());
                }
                obs = extractObs(EDD_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueDate() != null) {
                    registrationType.setExpectedDateOfDelivery(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(anc_no, anthenatalObsList);
                if (obs != null && obs.getValueText() != null) {
                    registrationType.setAncNumber(obs.getValueText());
                }else{
                    Patient patient = enc.getPatient();
                    PatientIdentifier ancId = patient.getPatientIdentifier(Utils.PMTCT_IDENTIFIER_INDEX);
                    registrationType.setAncNumber(ancId.getIdentifier());
                }

                //get data for Syphilis and add to antenatal reg type
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull all SYPHILIS", LogFormat.FATAL, LogLevel.live);
                Syphilis syphilis = null;
                obs = extractObs(Test_For_Syphilis_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    syphilis = new Syphilis();
                    syphilis.setTestedForSyphilis(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Syphilis_Test_Result_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(syphilis == null) syphilis = new Syphilis();
                    syphilis.setSyphilisTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Treated_For_Syphilis_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(syphilis == null) syphilis = new Syphilis();
                    syphilis.setTreatedForSyphilis(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Reffered_Syphilis_Positive_Client_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(syphilis == null) syphilis = new Syphilis();
                    syphilis.setReferredSyphilisPositiveClient(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                if(syphilis != null)  registrationType.setSyphilis(syphilis);

                antenatalRegistrationTypes.add(registrationType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return antenatalRegistrationTypes.isEmpty() ? null :  antenatalRegistrationTypes;

    }

    public List<DeliveryEncounterType> createDeliveryEncounterType(List<Encounter> anteNatelEncounters) {
        List<DeliveryEncounterType> deliveryEncounterTypes = new ArrayList<>();

        try {
            for(Encounter enc : anteNatelEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> anthenatalObsList = Utils.groupedByConceptIdsOnly(obsList);

                DeliveryEncounterType deliveryEncounterType = new DeliveryEncounterType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    deliveryEncounterType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    deliveryEncounterType.setVisitID(enc.getEncounterId().toString());
                }
                deliveryEncounterType.setVisitDate(convertedDate);


                Obs obs = extractObs(Time_Of_Hiv_Diagnosis_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setTimeOfHIVDiagnosis(getTimingMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Gestation_Age_At_Delivery_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    deliveryEncounterType.setGestationalAgeAtDelivery(value_numeric);
                }
                obs = extractObs(Hbv_Status_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {//conceptId might be 703
                    try {
                        deliveryEncounterType.setHBVStatus(getMappedValue(obs.getValueCoded().getConceptId()));//get the value coded here and know the codee
                    } catch (Exception ex) {
                        LoggerUtils.write(PMTCTDictionary.class.getName(), "Error on Hbv_Status_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(Hcv_Status_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setHCVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Woman_On_Art_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setWomanOnART(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Art_Started_In_Ld_Ward_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setARTStartedInLDWard(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Rom_Delivery_Internal_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setROMDeliveryInterval(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Mode_Of_Delivery_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setModeOfDelivery(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Episiotomy_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setEpisiotomy(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Vaginal_Tear_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setVaginalTear(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Feeding_Decision_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setFeedingDecision(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Maternal_Outcome_Concept_Id, anthenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    deliveryEncounterType.setMaternalOutcome(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                deliveryEncounterTypes.add(deliveryEncounterType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return deliveryEncounterTypes.isEmpty() ? null :  deliveryEncounterTypes;
    }

    public List<ChildBirthDetailsType> createChildBirthDetailsType(List<Encounter> childBirthEncounters) {
        List<ChildBirthDetailsType> childBirthDetailsTypes = new ArrayList<>();
        try {
            for(Encounter enc : childBirthEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> antenatalObsList = Utils.groupedByConceptIdsOnly(obsList);
                ChildBirthDetailsType childBirthDetailsType = new ChildBirthDetailsType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    childBirthDetailsType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    childBirthDetailsType.setVisitID(enc.getEncounterId().toString());
                }
                childBirthDetailsType.setVisitDate(convertedDate);

                Patient patient = enc.getPatient();
                Obs obs = extractObs(Hiv_Exposed_Infant_Number_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueText() != null) {
                    try {
                        childBirthDetailsType.setChildEIDNumber(obs.getValueText());
                    } catch (Exception ex) {
                        LoggerUtils.write(PMTCTDictionary.class.getName(), "Error on Hiv_Exposed_Infant_Number_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull all data for CHILD_BIRTH_DETAIL_TYPE", LogFormat.FATAL, LogLevel.debug);
                if(childBirthDetailsType.getChildEIDNumber() == null){
                    PatientIdentifier exposedInfantId = patient.getPatientIdentifier(Utils.EXPOSE_INFANT_IDENTIFIER_INDEX);
                    childBirthDetailsType.setChildEIDNumber(exposedInfantId.getIdentifier());
                }
                PatientIdentifier hospitalNumber = patient.getPatientIdentifier(Utils.EXPOSE_INFANT_IDENTIFIER_INDEX);
                if(hospitalNumber != null) {
                    childBirthDetailsType.setChildHospitalNumber(hospitalNumber.getIdentifier());
                }
                childBirthDetailsType.setChildDateOfBirth(utils.getXmlDate(patient.getBirthdate()));

                childBirthDetailsType.setChildSexCode(patient.getGender());

                obs = extractObs(Hbv_Exposed_Infant_Given_Blg_Within_24_Hours_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    childBirthDetailsType.setHBVExposedInfantGivenHepBIg(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Non_Hbv_Exposed_Infant_Given_Blg_Within_24_Hours_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    childBirthDetailsType.setNonHBVExposedInfantGivenHBV(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Apgar_Score_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    float value_float = (float) Math.round(obs.getValueNumeric());
                    childBirthDetailsType.setAPGARScore(value_float);
                }
                obs = extractObs(Head_Circumference_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    float value_float = (float) Math.round(obs.getValueNumeric());
                    childBirthDetailsType.setHeadCircumferenceAtBirth(value_float);
                }
                obs = extractObs(Mean_Upper_Arm_Circumference_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    childBirthDetailsType.setBirthMUAC(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Birth_Length_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    float value_float = (float) Math.round(obs.getValueNumeric());
                    childBirthDetailsType.setBirthLenght(value_float);
                }
                obs = extractObs(Birth_Weight_concept_Id, antenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    float value_float = (float) Math.round(obs.getValueNumeric());
                    childBirthDetailsType.setBirthWeight(value_float);
                }
                obs = extractObs(Immunization_Received_At_Birth_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueText() != null) {
                    childBirthDetailsType.setImmunizationReceived(obs.getValueText());
                }

                childBirthDetailsType.setEnrollmentDate(utils.getXmlDate(enc.getEncounterDatetime()));

                obs = extractObs(Timimg_Of_Arv_Prophylaxis_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    childBirthDetailsType.setTimingOfARVProphylaxis(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(Arv_Prophylaxis_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(arv.get(obs.getValueCoded().getConceptId()) == null) {
                        childBirthDetailsType.setArvProphylaxis("AP3");
                    }else {
                        childBirthDetailsType.setArvProphylaxis(arv.get(obs.getValueCoded().getConceptId()));
                    }
                }

                //TODO
//                childBirthDetailsType.setChildStatus("Alive");

                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling all data for CHILD_BIRTH_DETAIL_TYPE", LogFormat.FATAL, LogLevel.debug);

                //}
                childBirthDetailsTypes.add(childBirthDetailsType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return childBirthDetailsTypes.isEmpty() ? null :  childBirthDetailsTypes;
    }

    public List<ChildFollowupType> createChildFollowupType(List<Encounter> antenatalEncounters) {
        List<ChildFollowupType> childFollowupTypes = new ArrayList<>();
        try {
            for(Encounter enc : antenatalEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> antenatalObsList = Utils.groupedByConceptIdsOnly(obsList);
                ChildFollowupType childFollowupType = new ChildFollowupType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    childFollowupType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    childFollowupType.setVisitID(enc.getEncounterId().toString());
                }
                childFollowupType.setVisitDate(convertedDate);

                Obs obs = extractObs(Infant_Arv_Type_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    try {
                        childFollowupType.setInfantARVType(getMappedValue(obs.getValueCoded().getConceptId()));
                    } catch (Exception ex) {
                        LoggerUtils.write(PMTCTDictionary.class.getName(), "Error on Infant_Arv_Type_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(Age_At_Ctx_Initiation_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    childFollowupType.setAgeAtCTXInitiation(value_numeric);
                }
                obs = extractObs(Infant_Outcome_at_18_Months_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    childFollowupType.setInfantOutcomeAt18Months(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Date_Linked_to_Art_Clinic_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueDatetime() != null) {
                    childFollowupType.setDateLinkedToARTClinic(utils.getXmlDate(obs.getValueDatetime()));
                }
                obs = extractObs(Art_Enrollment_No_Concept_Id, antenatalObsList);
                if (obs != null && obs.getValueText() != null) {
                    childFollowupType.setARTEnrollmentNumber(obs.getValueText());
                }
                childFollowupTypes.add(childFollowupType);
            }

        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            //throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }

        return childFollowupTypes.isEmpty() ? null :  childFollowupTypes;
    }

    public List<ImmunizationType> createImmunizationType(List<Encounter> immunizationEncounters) {
        List<ImmunizationType> immunizationTypes = new ArrayList<>();
        try {
            for(Encounter immunizationEncounter : immunizationEncounters) {
                Set<Obs> obsSet = immunizationEncounter.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                ImmunizationType immunizationType = new ImmunizationType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(immunizationEncounter.getEncounterDatetime());
                immunizationType.setVisitDate(convertedDate);
                if(immunizationEncounter.getVisit() != null){
                    immunizationType.setVisitID(String.valueOf(immunizationEncounter.getVisit().getVisitId()));
                }else{
                    immunizationType.setVisitID(immunizationEncounter.getEncounterId().toString());
                }

                Obs obs = extractObs(Immunization_Date, groupedObsByConcept);
                if (obs == null) {
                    continue;
                }
                if (obs.getValueDatetime() != null) {
                    immunizationType.setImmunizationDate(utils.getXmlDate(obs.getValueDate()));
                }
                obs = extractObs(Lot_Number, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    immunizationType.setLotNumber(obs.getValueText());
                }

                immunizationTypes.add(immunizationType);
            }

        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return  immunizationTypes.isEmpty() ? null :  immunizationTypes;
    }

    public List<PartnerDetailsType> createPartnerDetailsType(List<Encounter> pmtctEncounters) {

        List<PartnerDetailsType> partnerDetailsTypes = new ArrayList<>();
        for(Encounter partnerDetailsEncounter : pmtctEncounters) {
            PartnerDetailsType partnerDetailsType = new PartnerDetailsType();

            XMLGregorianCalendar convertedDate = utils.getXmlDate(partnerDetailsEncounter.getEncounterDatetime());
            if(partnerDetailsEncounter.getVisit() != null){
                partnerDetailsType.setVisitID(String.valueOf(partnerDetailsEncounter.getVisit().getVisitId()));
            }else{
                partnerDetailsType.setVisitID(partnerDetailsEncounter.getEncounterId().toString());
            }
            partnerDetailsType.setVisitDate(convertedDate);

            Set<Obs> obsSet = partnerDetailsEncounter.getAllObs();
            List<Obs> obsList = new ArrayList<>(obsSet);
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);

            Obs obs = Utils.extractObs(Partner_Age, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                int value_numeric = (int) Math.round(obs.getValueNumeric());
                partnerDetailsType.setPartnerAge(value_numeric);
            }
            obs = Utils.extractObs(Partner_preTest_counselled_, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPreTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_preTest_counselled_", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_accepts_HIV_test, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerAcceptsHIVTest(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_accepts_HIV_test", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_HIV_test_result, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHIVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_HIV_test_result", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_postTest_counseled, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerPostTestCounseled(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_postTest_counseled", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_HBV_status, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHBVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_HBV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(Partner_HCV_status, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerHCVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_HCV_status", LogFormat.FATAL, LogLevel.debug);
            }
            obs = Utils.extractObs(SYPHILIS_STATUS_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
                String result = syphilis.get(obs.getValueCoded().getConceptId());
                partnerDetailsType.setPartnerSyphilisStatus(result);
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_syphilis_status", LogFormat.FATAL, LogLevel.debug);
            }

            obs = Utils.extractObs(Partner_referred_to, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
                partnerDetailsType.setPartnerReferredTo(getMappedValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling Partner_referred_to", LogFormat.FATAL, LogLevel.debug);
            }
            partnerDetailsTypes.add(partnerDetailsType);
        }


        return partnerDetailsTypes.isEmpty() ? null :  partnerDetailsTypes;
    }

    public List<InfantPCRTestingType> createInfantPCRTestingType(List<Encounter> antenatalEncounters) {
        List<InfantPCRTestingType> infantPCRTestingTypes = new ArrayList<>();
        try {
            for(Encounter enc : antenatalEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> antenatalObsList = Utils.groupedByConceptIdsOnly(obsList);

                InfantPCRTestingType infantPCRTestingType = new InfantPCRTestingType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    infantPCRTestingType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    infantPCRTestingType.setVisitID(enc.getEncounterId().toString());
                }
                infantPCRTestingType.setVisitDate(convertedDate);

                Obs obs = extractObs(Date_Sample_Collected, antenatalObsList);
                if (obs == null) {
                    continue;
                }
                if (obs.getValueDatetime() != null) {
                    infantPCRTestingType.setDateSampleCollected(utils.getXmlDate(obs.getValueDatetime()));

                }
                obs = extractObs(Date_Sample_Sent, antenatalObsList);
                if (obs != null && obs.getValueDatetime() != null) {
                    infantPCRTestingType.setDateSampleSent(utils.getXmlDate(obs.getValueDatetime()));
                }
                obs = extractObs(Date_Result_Received, antenatalObsList);
                if (obs != null && obs.getValueDatetime() != null) {
                    infantPCRTestingType.setDateResultReceivedAtFacility(utils.getXmlDate(obs.getValueDatetime()));
                }
                obs = extractObs(Date_Caregiver_Given_Result, antenatalObsList);
                if (obs != null && obs.getValueDatetime() != null) {
                    infantPCRTestingType.setDateCaregiverGivenResult(utils.getXmlDate(obs.getValueDatetime()));
                }
                obs = extractObs(Test_Result, antenatalObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    infantPCRTestingType.setPCRTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Date_of_Test, antenatalObsList);
                if (obs != null && obs.getValueDate() != null) {
                    LocalDate birthDate = enc.getPatient().getPerson().getBirthdate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    LocalDate testDate = obs.getValueDate().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    int ageAtTest = Period.between(birthDate,testDate).getMonths();

                    infantPCRTestingType.setAgeAtTest(ageAtTest);
                }
                infantPCRTestingTypes.add(infantPCRTestingType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return infantPCRTestingTypes.isEmpty() ? null :  infantPCRTestingTypes;
    }

    public List<HealthFacilityVisitsType> createHealthFacilityVisit(List<Encounter> maternalCohortEncounters) {

        List<HealthFacilityVisitsType> healthFacilityVisitsTypes = new ArrayList<>();
        for (Encounter maternalCohortEncounter : maternalCohortEncounters) {
            Set<Obs> obsSet = maternalCohortEncounter.getAllObs();
            List<Obs> obsList = new ArrayList<>(obsSet);
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
            HealthFacilityVisitsType healthFacilityVisitsType = new HealthFacilityVisitsType();

            if(maternalCohortEncounter.getVisit() != null){
                healthFacilityVisitsType.setVisitID(String.valueOf(maternalCohortEncounter.getVisit().getVisitId()));
            }else{
                healthFacilityVisitsType.setVisitID(maternalCohortEncounter.getEncounterId().toString());
            }

            healthFacilityVisitsType.setVisitDate(utils.getXmlDate(maternalCohortEncounter.getEncounterDatetime()));

            Obs obs = extractObs(visit_Status, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                healthFacilityVisitsType.setVisitStatus(ndrCode);
            }
            obs = extractObs(weight, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                healthFacilityVisitsType.setWeight(obs.getValueNumeric().intValue());
            }
            obs = extractObs(breast_Feeding, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                if(ndrCode != null) {
                    healthFacilityVisitsType.setBreastFeeding(ndrCode);
                }
            }

            obs = extractObs(prescribedRegimenLineCode_conceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                if(ndrCode != null) {
                    healthFacilityVisitsType.setPrescribedRegimenLineCode(ndrCode);
                }
                Obs valueObs = Utils.extractObs(valueCoded, groupedObsByConcept); // PrescribedRegimen
                if (valueObs != null) {
                    valueCoded = valueObs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    if(ndrCode != null) {
                        CodedSimpleType codedSimpleType = new CodedSimpleType();
                        codedSimpleType.setCode(ndrCode);
                        codedSimpleType.setCodeDescTxt(pharmacyDictionary.getRegimenCodeDescTextMapValue(valueCoded));
                        healthFacilityVisitsType.setPrescribedRegimen(codedSimpleType);
                    }
                }
            }
            obs = extractObs(maternalOutcome_conceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMaternalMappedValue(valueCoded);
                if(ndrCode != null) {
                    healthFacilityVisitsType.setMaternalOutcome(ndrCode);
                }
            }
            healthFacilityVisitsTypes.add(healthFacilityVisitsType);
        }
        return healthFacilityVisitsTypes.isEmpty() ? null : healthFacilityVisitsTypes;
    }

    public List<MaternalCohortType> createMaternalCohort(List<Encounter> maternalCohortEncounters) {
        List<MaternalCohortType> maternalCohortTypes = new ArrayList<>();
        for (Encounter maternalCohortEncounter : maternalCohortEncounters) {
            Set<Obs> obsSet = maternalCohortEncounter.getAllObs();
            List<Obs> obsList = new ArrayList<>(obsSet);
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
            MaternalCohortType maternalCohortType = new MaternalCohortType();
            //visit date and ID

            if(maternalCohortEncounter.getVisit() != null){
                maternalCohortType.setVisitID(String.valueOf(maternalCohortEncounter.getVisit().getVisitId()));
            }else{
                maternalCohortType.setVisitID(maternalCohortEncounter.getEncounterId().toString());
            }

            maternalCohortType.setVisitDate(utils.getXmlDate(maternalCohortEncounter.getEncounterDatetime()));

            Obs obs = extractObs(viralLoadPeriod_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                if(ndrCode != null) {
                    maternalCohortType.setViralLoadPeriod(ndrCode);
                }
            }
            obs = extractObs(sampleCollectionDate_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                maternalCohortType.setSampleCollectionDate(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObs(viralLoadResult_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                maternalCohortType.setViralLoadResult(obs.getValueNumeric());
            }
            obs = extractObs(pmtctEntryPoint_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                if(ndrCode != null) {
                    maternalCohortType.setPmtctEntryPoint(ndrCode);
                }
            }
            obs = extractObs(gestationalAgeAtSampleCollection_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                maternalCohortType.setGestationalAgeAtSampleCollection(obs.getValueNumeric().intValue());
            }
            obs = extractObs(gestationalAge_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                maternalCohortType.setGestationalAge(obs.getValueNumeric().intValue());
            }
            obs = extractObs(timingOfArtInitiation_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getTimingMappedValue(valueCoded);
                if(ndrCode != null) {
                    maternalCohortType.setTimingOfArtInitiation(ndrCode);
                }
            }
            obs = extractObs(tbStatus_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                int ndrCode = getTbMappedValue(valueCoded);
                if (ndrCode > 0) maternalCohortType.setTbStatus(ndrCode);
            }
            obs = extractObs(gravida_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                maternalCohortType.setGravida(obs.getValueNumeric().intValue());
            }
            obs = extractObs(artStartDate_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                maternalCohortType.setArtStartDate(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObs(dateOfDelivery_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                maternalCohortType.setDateOfDelivery(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObs(familyPlanningCounselling_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                if(ndrCode != null) {
                    maternalCohortType.setFamilyPlanningCounselling(ndrCode);
                }
            }
            obs = extractObs(familyPlanningMethod_ConceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getFpmMappedValue(valueCoded);
                if(ndrCode != null) {
                    maternalCohortType.setFamilyPlanningMethod(ndrCode);
                }
            }
            maternalCohortTypes.add(maternalCohortType);
        }
        return maternalCohortTypes.isEmpty() ? null : maternalCohortTypes;
    }

    public List<PMTCTHTSType> createPMTCTHTS(List<Encounter> pmtctHTSEncounters) {
        List<PMTCTHTSType> pmtcthtsTypes = new ArrayList<>();
        //filter for PMTCT HTS form
        List<Encounter> fliteredPmtctHTSEncounters= pmtctHTSEncounters
                .stream()
                .filter(c -> c.getForm().getUuid().equals(ConstantsUtil.PMTCT_HTS_FORM_UUID))
                .collect(Collectors.toList());
        if(fliteredPmtctHTSEncounters.size() > 0) {
            for (Encounter pmtctHTSEncounter : fliteredPmtctHTSEncounters) {
                //getting first encounter in list

                PMTCTHTSType pmtcttHTSType = new PMTCTHTSType();
                PMTCTClinicalTBScreeningType pmtctClinicalTBScreeningType = new PMTCTClinicalTBScreeningType();


                Set<Obs> obsSet = pmtctHTSEncounter.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);

                //visit date and ID
                if (pmtctHTSEncounter.getVisit() != null) {
                    pmtcttHTSType.setVisitID(String.valueOf(pmtctHTSEncounter.getVisit().getVisitId()));
                } else {
                    pmtcttHTSType.setVisitID(pmtctHTSEncounter.getEncounterId().toString());
                }
                pmtcttHTSType.setVisitDate(utils.getXmlDate(pmtctHTSEncounter.getEncounterDatetime()));

                Obs obs = extractObs(hts_register_setting_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    String ndrCode = getMappedValue(valueCoded);
                    pmtcttHTSType.setPMTCTEntryPoint(ndrCode);
                }

                obs = extractObs(previouslyKnownHIVPositive_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {

                    int valueCodedPreviouslyKnownHIVPositive = obs.getValueCoded().getConceptId();
                    Boolean ndrCodePreviouslyKnownHIVPositive = getYesNoToggleValue(valueCodedPreviouslyKnownHIVPositive);
                    pmtcttHTSType.setPreviouslyKnownHIVPositive(ndrCodePreviouslyKnownHIVPositive);

                    obs = extractObs(acceptedHIVTesting_ConceptID, groupedObsByConcept);
                    if (obs != null && obs.getValueCoded() != null) {

                        int valueCoded = obs.getValueCoded().getConceptId();
                        Boolean ndrCode = getYesNoToggleValue(valueCoded);
                        pmtcttHTSType.setAcceptedHIVTesting(ndrCode);

                        obs = extractObs(hivTestResult_ConceptID, groupedObsByConcept);
                        if (obs != null && obs.getValueCoded() != null) {
                            pmtcttHTSType.setHIVTestResult(pmtctDictionary.get(obs.getValueCoded().getConceptId()));
                        }
                    }

                    obs = extractObs(recievedHIVTestResult_ConceptID, groupedObsByConcept);
                    if (obs != null && obs.getValueCoded() != null) {
                        int valueCoded = obs.getValueCoded().getConceptId();
                        Boolean ndrCode = getYesNoToggleValue(valueCoded);
                        pmtcttHTSType.setReceivedHIVTestResult(ndrCode);
                    }
                }

                obs = extractObs(hivRetesting_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    String ndrCode = getMappedValue(valueCoded);
                    pmtcttHTSType.setHIVRetesting(ndrCode);
                }

                obs = extractObs(testedForHepB_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtcttHTSType.setTestedForHepB(ndrCode);

                    obs = extractObs(hepBTestResult_ConceptID, groupedObsByConcept);
                    if (obs != null && obs.getValueCoded() != null) {
                        int valueCodedResult = obs.getValueCoded().getConceptId();
                        String ndrCodeResult = getMappedValue(valueCodedResult);
                        pmtcttHTSType.setHepBTestResult(ndrCodeResult);
                    }
                }

                obs = extractObs(testedForHepC_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtcttHTSType.setTestedForHepC(ndrCode);
                    if (ndrCode) {
                        obs = extractObs(hepCTestResult_ConceptID, groupedObsByConcept);
                        if (obs != null && obs.getValueCoded() != null) {
                            int valueCodedResult = obs.getValueCoded().getConceptId();
                            String ndrCodeResult = getMappedValue(valueCodedResult);
                            pmtcttHTSType.setHepCTestResult(ndrCodeResult);
                        }
                    }
                }

                obs = extractObs(hivHBVCoinfected_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtcttHTSType.setHIVHBVCoInfected(ndrCode);
                }

                obs = extractObs(hivHCVCoinfected_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtcttHTSType.setHIVHCVCoInfected(ndrCode);
                }

                obs = extractObs(agreedToPartnerNotification_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtcttHTSType.setAgreedToPartnerNotification(ndrCode);
                }

                obs = extractObs(currentlyCough_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtctClinicalTBScreeningType.setCurrentlyCough(ndrCode);
                }

                obs = extractObs(weightLoss_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtctClinicalTBScreeningType.setWeightLoss(ndrCode);
                }

                obs = extractObs(fever_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtctClinicalTBScreeningType.setFever(ndrCode);
                }

                obs = extractObs(nightSweats_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtctClinicalTBScreeningType.setNightSweats(ndrCode);
                }

                obs = extractObs(contactWithTBPositivePatient_ConceptID, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Boolean ndrCode = getYesNoToggleValue(valueCoded);
                    pmtctClinicalTBScreeningType.setContactWithTBPositivePatient(ndrCode);
                }


                pmtcttHTSType.setClinicalTBScreening(pmtctClinicalTBScreeningType);
                pmtcthtsTypes.add(pmtcttHTSType);
            }
        }
        return pmtcthtsTypes.isEmpty() ? null : pmtcthtsTypes;
    }

    public List<InfantRapidTestType> createInfantRapidTestType(List<Encounter> childFollowUpEncounters) {
        List<InfantRapidTestType> infantRapidTestTypes = new ArrayList<>();
        for(Encounter childFollowUpEncounter : childFollowUpEncounters) {
            Patient patient = childFollowUpEncounter.getPatient();
            Set<Obs> obsSet = childFollowUpEncounter.getAllObs();
            List<Obs> obsList = new ArrayList<>(obsSet);
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
            InfantRapidTestType infantRapidTestType = new InfantRapidTestType();

            XMLGregorianCalendar convertedDate = utils.getXmlDate(childFollowUpEncounter.getEncounterDatetime());
            if(childFollowUpEncounter.getVisit() != null){
                infantRapidTestType.setVisitID(String.valueOf(childFollowUpEncounter.getVisit().getVisitId()));
            }else{
                infantRapidTestType.setVisitID(childFollowUpEncounter.getEncounterId().toString());
            }
            infantRapidTestType.setVisitDate(convertedDate);

            Obs obs = extractObs(rapid_test_date, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                infantRapidTestType.setDateOfTest(utils.getXmlDate(obs.getValueDate()));
                LocalDate birthDate = patient.getPerson().getBirthdate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                LocalDate testDate = obs.getValueDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                int ageAtTest = Period.between(birthDate,testDate).getMonths();
                infantRapidTestType.setAgeAtTest(ageAtTest);
            }

            obs = extractObs(rapid_test_result, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMappedValue(valueCoded);
                if(ndrCode != null) {
                    infantRapidTestType.setRapidTestResult(ndrCode);
                }
            }
            infantRapidTestTypes.add(infantRapidTestType);
        }
        return infantRapidTestTypes.isEmpty() ? null :  infantRapidTestTypes;
    }

    private String getMappedValue(int conceptID) {
        try {
            return pmtctDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }

    private String get2MappedValue(int conceptID) {
        try {
            return pmtct2Dictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMaternalMappedValue(int conceptID) {
        try {
            return maternalOutcome.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }

    private boolean getYesNoToggleValue(int conceptID) {
        try {
            return yesNoToggle.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return Boolean.FALSE;
        }
    }


    private String getTimingMappedValue(int conceptID) {
        try {
            return timing.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }

    private String getFpmMappedValue(int conceptID) {
        try {
            return fpm.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }

    private int getTbMappedValue(int conceptID) {
        try {
            return tb.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return 0;
        }
    }
}
