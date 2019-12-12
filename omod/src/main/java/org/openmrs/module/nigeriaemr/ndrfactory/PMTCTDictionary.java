/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.AntenatalRegistrationType.Syphilis;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PMTCTDictionary {

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

    public PMTCTDictionary() {
        loadDictionary();
    }

    private Map<Integer, String> pmtctDictionary = new HashMap<>();

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
        //pmtctDictionary.put(165860, "4");
    }

    public AntenatalRegistrationType createAntenatalRegistrationType(Patient pts, Encounter enc, List<Obs> anthenatalObsList) throws DatatypeConfigurationException {
        try {
            AntenatalRegistrationType registrationType = new AntenatalRegistrationType();
            PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            Obs obs = new Obs();
            int value_numeric;

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = Utils.getXmlDate(enc.getEncounterDatetime());
            registrationType.setVisitDate(convertedDate);
            if (enc != null) {
                registrationType.setVisitID(String.valueOf(enc.getEncounterDatetime().getTime()));
            }

            obs = extractObs(Last_Menstural_Period_Concept_Id, anthenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getObsDatetime() != null) {
                registrationType.setLastMenstralPeriod(Utils.getXmlDate(obs.getObsDatetime()));
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
                registrationType.setExpectedDateOfDelivery(Utils.getXmlDate(obs.getObsDatetime()));
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

    public DeliveryEncounterType createDeliveryEncounterType(Patient pts, Encounter enc, List<Obs> anthenatalObsList) throws DatatypeConfigurationException {
        DeliveryEncounterType deliveryEncounterType = new DeliveryEncounterType();
        
        try {

            PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            //PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

           
            int value_numeric;

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = Utils.getXmlDate(enc.getEncounterDatetime());
            deliveryEncounterType.setVisitDate(convertedDate);
            if(enc != null){
                deliveryEncounterType.setVisitID(String.valueOf(enc.getEncounterDatetime().getTime()));
            }

            Obs obs = extractObs(Time_Of_Hiv_Diagnosis_Concept_Id, anthenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                deliveryEncounterType.setTimeOfHIVDiagnosis(Utils.getXmlDateTime(obs.getValueDatetime()).toString());
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

    public ChildBirthDetailsType createChildBirthDetailsType(Patient pts, Encounter enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
       
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
                childBirthDetailsType.setChildDateOfBirth(Utils.getXmlDate(obs.getValueDate()));
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

    public ChildFollowupType createChildFollowupType(Patient pts, Encounter enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
       
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
                childFollowupType.setDateLinkedToARTClinic(Utils.getXmlDate(obs.getValueDatetime()));
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

    public ImmunizationType createImmunizationType(Patient pts, Encounter enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
       
         ImmunizationType immunizationType = new ImmunizationType();
        try {
           
           // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);

            //if (pmtctIdentifier != null) {
            XMLGregorianCalendar convertedDate = Utils.getXmlDate(enc.getEncounterDatetime());
            immunizationType.setVisitDate(convertedDate);

            Obs obs = extractObs(Immunization_Date, antenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getValueDatetime() != null) {
                immunizationType.setImmunizationDate(Utils.getXmlDate(obs.getValueDate()));
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

    public InfantPCRTestingType createInfantPcr(Patient pts, Encounter enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        
         InfantPCRTestingType infantPCRTestingType = new InfantPCRTestingType();
         
        try {
           // PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);

           

            //if (pmtctIdentifier != null) {
            Obs obs = extractObs(Date_Sample_Collected, antenatalObsList);
            if (obs == null) {
                return null;
            }
            if (obs != null && obs.getValueDatetime() != null) {
                infantPCRTestingType.setDateSampleCollected(Utils.getXmlDate(obs.getValueDatetime()));

            }
            obs = extractObs(Date_Sample_Sent, antenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                infantPCRTestingType.setDateSampleSent(Utils.getXmlDate(obs.getValueDatetime()));
            }
            obs = extractObs(Date_Result_Received, antenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                infantPCRTestingType.setDateResultReceivedAtFacility(Utils.getXmlDate(obs.getValueDatetime()));
            }
            obs = extractObs(Date_Caregiver_Given_Result, antenatalObsList);
            if (obs != null && obs.getValueDatetime() != null) {
                infantPCRTestingType.setDateCaregiverGivenResult(Utils.getXmlDate(obs.getValueDatetime()));
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

    private String getMappedValue(int conceptID) {
        try {
            return pmtctDictionary.get(conceptID);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }
}
