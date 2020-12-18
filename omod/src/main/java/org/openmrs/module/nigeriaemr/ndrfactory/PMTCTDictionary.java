/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.AntenatalRegistrationType.Syphilis;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PMTCTDictionary {
    Utils utils = new Utils();
    private final PharmacyDictionary pharmacyDictionary;
    private final ClinicalDictionary clinicalDictionary;

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
    //Delivery encounter concepts
    final static int Time_Of_Hiv_Diagnosis_Concept_Id = 164851;
    final static int Gestation_Age_At_Delivery_Concept_Id = 1409;
    final static int Hbv_Status_Concept_Id = 159430;
    final static int Hcv_Status_Concept_Id = 161471;
    final static int Woman_On_Art_Concept_Id = 165563;
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
    final static int Mean_Upper_Arm_Circumference_Concept_Id = 1343;
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

    //Health facility Visit
    private static int visit_Date = 1769;
    private static int visit_Status = 166129;
    private static int weight = 5089;
    private static int breast_Feeding = 165047;
    private static int cotrimoxazole_conceptID = 0;
//    private static int prescribedRegimen_conceptID = 165708;
    private static int prescribedRegimenLineCode_conceptID = 165708;
    private static int maternalOutcome_conceptID = 160085;

    public PMTCTDictionary() {
        pharmacyDictionary = new PharmacyDictionary();
        clinicalDictionary = new ClinicalDictionary();
        loadDictionary();
    }

    private Map<Integer, String> pmtctDictionary = new HashMap<>();
    private Map<Integer, String> maternalOutcome = new HashMap<>();
    private Map<Integer, String> timing = new HashMap<>();
    private Map<Integer, String> fpm = new HashMap<>();
    private Map<Integer, Integer> tb = new HashMap<>();

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        pmtctDictionary = new HashMap<>();
        pmtctDictionary.put(703, "Pos");
        pmtctDictionary.put(664, "Neg");
        pmtctDictionary.put(1065, "Y");
        pmtctDictionary.put(1066, "N");
        pmtctDictionary.put(165478, "1");
        pmtctDictionary.put(165477, "2");
        pmtctDictionary.put(5630, "Unbooked");
        pmtctDictionary.put(5526, "EBF");
        pmtctDictionary.put(164857, "ERF");
        pmtctDictionary.put(160429, "Alive");
        pmtctDictionary.put(164970, "1");
        pmtctDictionary.put(165860, "Within 72 hrs of facility delivery");
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
        pmtctDictionary.put(166127, "L"); // TP = Transferred to another PMTCT cohort (new pregnancy)
        pmtctDictionary.put(166128, "DC"); // TA = Transitioned to ART clinic
        pmtctDictionary.put(160031, "X");
        pmtctDictionary.put(5240, "LTFU");
        pmtctDictionary.put(160432, "D");
        //Point of entry
        pmtctDictionary.put(1622, "1"); // TA = Transitioned to ART clinic
        pmtctDictionary.put(164850, "2");
        pmtctDictionary.put(1180, "3");
        pmtctDictionary.put(166121, "4");
        //Viral Load Period
        pmtctDictionary.put(166122, "1");
        pmtctDictionary.put(166123, "2");
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
        tb.put(1661, 4);
        tb.put(1662, 5);

        //Maternal Outcome
        maternalOutcome = new HashMap<>();
        maternalOutcome.put(160432, "Dead");
        maternalOutcome.put(166126, "A");
        maternalOutcome.put(160563, "TO");
        maternalOutcome.put(166127, "TP");
        maternalOutcome.put(166128, "TA");
        maternalOutcome.put(5240, "LTFU");

        //pmtctDictionary.put(165860, "4");
    }

    public AntenatalRegistrationType createAntenatalRegistrationType(Patient pts, Encounter enc, List<Integer> anthenatalObsList) throws DatatypeConfigurationException {
        try {
            AntenatalRegistrationType registrationType = new AntenatalRegistrationType();
            PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            Obs obs = new Obs();
            int value_numeric;

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
            registrationType.setVisitDate(convertedDate);
            if (enc != null) {
                registrationType.setVisitID(String.valueOf(enc.getEncounterDatetime().getTime()));
            }

            obs = extractObs(Last_Menstural_Period_Concept_Id, anthenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getObsDatetime() != null) {
                registrationType.setLastMenstralPeriod(utils.getXmlDate(obs.getObsDatetime()));
            }
            obs = extractObs(Gestational_Age_At_ANC_Registration_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                registrationType.setGestationalAgeAtANCRegistration(value_numeric);
            }

            obs = extractObs(Gravida_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                registrationType.setGravida(value_numeric);
            }
            obs = extractObs(Parity_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                registrationType.setParity(value_numeric);
            }
            obs = extractObs(Source_Of_Referal_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                registrationType.setSourceOfReferral(obs.getValueText());
            }
            obs = extractObs(EDD_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getObsDatetime() != null) {
                registrationType.setExpectedDateOfDelivery(utils.getXmlDate(obs.getObsDatetime()));
            }

            //get data for Syphilis and add to antenatal reg type
            LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull all SYPHILIS", LogFormat.FATAL, LogLevel.live);
            Syphilis syphilis = new Syphilis();
            obs = extractObs(Test_For_Syphilis_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueCoded() != null) {
                syphilis.setTestedForSyphilis(getMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Syphilis_Test_Result_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueCoded() != null) {
                syphilis.setSyphilisTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Treated_For_Syphilis_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueCoded() != null) {
                syphilis.setTreatedForSyphilis(getMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(Reffered_Syphilis_Positive_Client_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueCoded() != null) {
                syphilis.setReferredSyphilisPositiveClient(getMappedValue(obs.getValueCoded().getConceptId()));
            }
            registrationType.setSyphilis(syphilis);
            LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling SYPHILIS", LogFormat.FATAL, LogLevel.live);

            //}
            return registrationType;
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }

    }

    public DeliveryEncounterType createDeliveryEncounterType(Patient pts, Encounter enc, List<Integer> anthenatalObsList) throws DatatypeConfigurationException {
        DeliveryEncounterType deliveryEncounterType = new DeliveryEncounterType();
        
        try {

            PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            //PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

           
            int value_numeric;

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
            deliveryEncounterType.setVisitDate(convertedDate);
            if(enc != null){
                deliveryEncounterType.setVisitID(String.valueOf(enc.getEncounterDatetime().getTime()));
            }

            Obs obs = extractObs(Time_Of_Hiv_Diagnosis_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                deliveryEncounterType.setTimeOfHIVDiagnosis(utils.getXmlDateTime(obs.getValueDatetime()).toString());
            }
            obs = extractObs(Gestation_Age_At_Delivery_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
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

            //}
            return deliveryEncounterType;
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
           // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
        
        return deliveryEncounterType;
    }

    public ChildBirthDetailsType createChildBirthDetailsType(Patient pts, Encounter enc, List<Integer> antenatalObsList) throws DatatypeConfigurationException {
       
         ChildBirthDetailsType childBirthDetailsType = new ChildBirthDetailsType();
        
        try {
           // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);

           
            int value_numeric;
            float value_float;

            // if (pmtctIdentifier != null) {
            Obs obs = extractObs(Hiv_Exposed_Infant_Number_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                try {
                    childBirthDetailsType.setChildEIDNumber(obs.getValueText());
                } catch (Exception ex) {
                    LoggerUtils.write(PMTCTDictionary.class.getName(), "Error on Hiv_Exposed_Infant_Number_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }
            }
            LoggerUtils.write(PMTCTDictionary.class.getName(), "About to pull all data for CHILD_BIRTH_DETAIL_TYPE", LogFormat.FATAL, LogLevel.debug);
            obs = extractObs(Date_of_Birth_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                childBirthDetailsType.setChildDateOfBirth(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObs(Child_Sex_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                childBirthDetailsType.setChildSexCode(obs.getValueText());
            }
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
                value_float = (float) Math.round(obs.getValueNumeric());
                childBirthDetailsType.setAPGARScore(value_float);
            }
            obs = extractObs(Head_Circumference_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_float = (float) Math.round(obs.getValueNumeric());
                childBirthDetailsType.setHeadCircumferenceAtBirth(value_float);
            }
            obs = extractObs(Mean_Upper_Arm_Circumference_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_float = (float) Math.round(obs.getValueNumeric());
                childBirthDetailsType.setBirthMUAC(value_float);
            }
            obs = extractObs(Birth_Length_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_float = (float) Math.round(obs.getValueNumeric());
                childBirthDetailsType.setBirthLenght(value_float);
            }
            obs = extractObs(Birth_Weight_concept_Id, antenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_float = (float) Math.round(obs.getValueNumeric());
                childBirthDetailsType.setBirthWeight(value_float);
            }
            obs = extractObs(Immunization_Received_At_Birth_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                childBirthDetailsType.setImmunizationReceived(obs.getValueText());
            }
            LoggerUtils.write(PMTCTDictionary.class.getName(), "Finished pulling all data for CHILD_BIRTH_DETAIL_TYPE", LogFormat.FATAL, LogLevel.debug);

            //}
            return childBirthDetailsType;
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
           // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
        
        return childBirthDetailsType;
    }

    public ChildFollowupType createChildFollowupType(Patient pts, Encounter enc, List<Integer> antenatalObsList) throws DatatypeConfigurationException {
       
        ChildFollowupType childFollowupType = new ChildFollowupType();
        try {
          // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            
            int value_numeric;

            //if (pmtctIdentifier != null) {
            Obs obs = extractObs(Infant_Arv_Type_Concept_Id, antenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getValueCoded() != null) {
                try {
                    childFollowupType.setInfantARVType(getMappedValue(obs.getValueCoded().getConceptId()));
                } catch (Exception ex) {
                    LoggerUtils.write(PMTCTDictionary.class.getName(), "Error on Infant_Arv_Type_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }
            }
            obs = extractObs(Timimg_Of_Arv_Prophylaxis_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueCoded() != null) {
                childFollowupType.setTimingOfARVProphylaxis(getMappedValue(obs.getValueCoded().getConceptId()));

            }
            obs = extractObs(Age_At_Ctx_Initiation_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueNumeric() != null) {
                value_numeric = (int) Math.round(obs.getValueNumeric());
                childFollowupType.setAgeAtCTXInitiation(value_numeric);
            }
            obs = extractObs(Infant_Outcome_at_18_Months_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                childFollowupType.setInfantOutcomeAt18Months(obs.getValueText());
            }
            obs = extractObs(Date_Linked_to_Art_Clinic_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                childFollowupType.setDateLinkedToARTClinic(utils.getXmlDate(obs.getValueDatetime()));
            }
            obs = extractObs(Art_Enrollment_No_Concept_Id, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                childFollowupType.setARTEnrollmentNumber(obs.getValueText());
            }
            //}

            return childFollowupType;
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            //throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
        
        return childFollowupType;
    }

    public ImmunizationType createImmunizationType(Patient pts, Encounter enc, List<Integer> antenatalObsList) throws DatatypeConfigurationException {
       
         ImmunizationType immunizationType = new ImmunizationType();
        try {
           
           // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
            immunizationType.setVisitDate(convertedDate);

            Obs obs = extractObs(Immunization_Date, antenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getValueDatetime() != null) {
                immunizationType.setImmunizationDate(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObs(Lot_Number, antenatalObsList);
            if (obs != null && obs.getValueText() != null) {
                immunizationType.setLotNumber(obs.getValueText());
            }

            //}
            return immunizationType;

        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
          //  throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
        
        return immunizationType;
    }

    public InfantPCRTestingType createInfantPcr(Patient pts, Encounter enc, List<Integer> antenatalObsList) throws DatatypeConfigurationException {
        
         InfantPCRTestingType infantPCRTestingType = new InfantPCRTestingType();
         
        try {
           // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);

           

            //if (pmtctIdentifier != null) {
            Obs obs = extractObs(Date_Sample_Collected, antenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getValueDatetime() != null) {
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
            if (obs != null && obs.getValueDatetime() != null) {

                Instant instant = Instant.ofEpochMilli(obs.getValueDatetime().getTime());
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDate dateOfTest_local = localDateTime.toLocalDate();
                LocalDate now = LocalDate.now();
                Period period = Period.between(now, dateOfTest_local);

                infantPCRTestingType.setAgeAtTest(period.getYears());
            }

            //}
            return infantPCRTestingType;
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
           // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
        
        return infantPCRTestingType;
    }

    public List<HealthFacilityVisitsType> createHealthFacilityVisit(List<Encounter> maternalCohortEncounters) {

        List<HealthFacilityVisitsType> healthFacilityVisitsTypes = new ArrayList<>();
        for(Encounter maternalCohortEncounter : maternalCohortEncounters) {
            Set<Obs> obsSet = maternalCohortEncounter.getAllObs();
            List<Obs> obsList = new ArrayList<>(obsSet);
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
            HealthFacilityVisitsType healthFacilityVisitsType = new HealthFacilityVisitsType();
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
                healthFacilityVisitsType.setBreastFeeding(ndrCode);
            }

            obs = extractObs(prescribedRegimenLineCode_conceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded  = obs.getValueCoded().getConceptId();
                String ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                healthFacilityVisitsType.setPrescribedRegimenLineCode(ndrCode);
                Obs valueObs = Utils.extractObs(valueCoded, groupedObsByConcept); // PrescribedRegimen
                if (valueObs != null) {
                    valueCoded = valueObs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    CodedSimpleType codedSimpleType = new CodedSimpleType();
                    codedSimpleType.setCode(ndrCode);
                    codedSimpleType.setCodeDescTxt( pharmacyDictionary.getRegimenCodeDescTextMapValue(valueCoded));
                    healthFacilityVisitsType.setPrescribedRegimen(codedSimpleType);
                }
            }
            obs = extractObs(maternalOutcome_conceptID, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                int valueCoded = obs.getValueCoded().getConceptId();
                String ndrCode = getMaternalMappedValue(valueCoded);
                healthFacilityVisitsType.setMaternalOutcome(ndrCode);
            }
            healthFacilityVisitsTypes.add(healthFacilityVisitsType);
        }

        return healthFacilityVisitsTypes;
    }

    public MaternalCohortType createMaternalCohort(Encounter maternalCohortEncounter, Map<Object, List<Obs>> groupedObsByConcept){
        MaternalCohortType maternalCohortType = new MaternalCohortType();
        //visit date and ID
        maternalCohortType.setVisitID(String.valueOf(maternalCohortEncounter.getVisit().getVisitId()));
        maternalCohortType.setVisitDate(utils.getXmlDate(maternalCohortEncounter.getEncounterDatetime()));

        Obs obs = extractObs(viralLoadPeriod_ConceptID, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            int valueCoded = obs.getValueCoded().getConceptId();
            String ndrCode = getMappedValue(valueCoded);
            maternalCohortType.setViralLoadPeriod(ndrCode);
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
            maternalCohortType.setPmtctEntryPoint(ndrCode);
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
            maternalCohortType.setTimingOfArtInitiation(ndrCode);
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
            maternalCohortType.setFamilyPlanningCounselling(ndrCode);
        }
        obs = extractObs(familyPlanningMethod_ConceptID, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            int valueCoded = obs.getValueCoded().getConceptId();
            String ndrCode = getFpmMappedValue(valueCoded);
            maternalCohortType.setFamilyPlanningMethod(ndrCode);
        }
        return maternalCohortType;
    }

    private String getMappedValue(int conceptID) {
        try {
            return pmtctDictionary.get(conceptID);
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
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getTimingMappedValue(int conceptID) {
        try {
            return timing.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }
    private String getFpmMappedValue(int conceptID) {
        try {
            return fpm.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private int getTbMappedValue(int conceptID) {
        try {
            return tb.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return 0;
        }
    }
}
