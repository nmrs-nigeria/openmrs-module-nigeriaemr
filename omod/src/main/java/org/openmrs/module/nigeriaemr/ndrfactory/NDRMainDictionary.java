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
    private  PMTCTDictionary pmtctDictionary = null;
    private HTSDictionary htsDictionary = null;
    private LabDictionary labDictionary = null;
    private PharmacyDictionary pharmDictionary= null;
    private NDRCommonQuestionsDictionary commonQuestionDictionary=null;

    public NDRMainDictionary() {
        loadDictionary();
        clinicalDictionary = new ClinicalDictionary();
        pmtctDictionary = new PMTCTDictionary();
        htsDictionary = new HTSDictionary();
        labDictionary = new LabDictionary();
        pharmDictionary=new PharmacyDictionary();
        commonQuestionDictionary=new NDRCommonQuestionsDictionary();
        
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
        map.put(160563,"14");

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

    public PatientDemographicsType createPatientDemographicsType(Patient pts, FacilityType facility, DBConnection openmrsConn)
            throws DatatypeConfigurationException {
        try {
            PatientDemographicsType demo = new PatientDemographicsType();

            //Identifier 4 is Pepfar ID
            PatientIdentifier pepfarid, pidHospital, pidOthers, htsId, ancId, exposedInfantId, pepId;

            //use combination of rdatimcode and hospital for peffar on surge rivers.
            pepfarid = new PatientIdentifier();
            // pepfarid.setIdentifier(String.valueOf(pts.getPatientIdentifier(4)));

            pidHospital = pts.getPatientIdentifier(5);
            pidOthers = pts.getPatientIdentifier(3);
            htsId = pts.getPatientIdentifier(8);
            ancId = pts.getPatientIdentifier(6);
            exposedInfantId = pts.getPatientIdentifier(7);
            pepId = pts.getPatientIdentifier(9);

            //added a try block to mitigate identifier types 4 and 3 issues
            try {
                demo.setPatientIdentifier(String.valueOf(pts.getPatientIdentifier(4)) );
            } catch (Exception e) {
                //since pepfarId is not existing we use facility datim_code_hospital number_patientId;
                demo.setPatientIdentifier(facility.getFacilityID() + "_" + pts.getPatientIdentifier(8).getIdentifier() + "_" + pts.getId());
            }
            //demo.setPatientIdentifier(pts.getPatientIdentifier(4).getIdentifier());

            IdentifierType idt;
            IdentifiersType identifiersType = new IdentifiersType();
            if (pepfarid != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pepfarid.getIdentifier());
                idt.setIDTypeCode("PN");
                identifiersType.getIdentifier().add(idt);
            }
            if (pepfarid != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pepfarid.getIdentifier());
                idt.setIDTypeCode("PN");
                identifiersType.getIdentifier().add(idt);
            }
            //comments by Johnbosco
            //Initially this code  for Ids use to run only if pepfarId is null
            if (pidHospital != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidHospital.getIdentifier());
                idt.setIDTypeCode("PI");
                identifiersType.getIdentifier().add(idt);
            }
            if (pidOthers != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidOthers.getIdentifier());
                idt.setIDTypeCode("PE");
                identifiersType.getIdentifier().add(idt);
            }
            if (htsId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(htsId.getIdentifier());
                idt.setIDTypeCode("HTS");
                identifiersType.getIdentifier().add(idt);
            }
            if (ancId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(ancId.getIdentifier());
                idt.setIDTypeCode("ANC");
                identifiersType.getIdentifier().add(idt);
            }
            if (exposedInfantId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(exposedInfantId.getIdentifier());
                idt.setIDTypeCode("EI");
                identifiersType.getIdentifier().add(idt);
            }
            if (pepId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pepId.getIdentifier());
                idt.setIDTypeCode("PEP");
                identifiersType.getIdentifier().add(idt);
            }

            demo.setOtherPatientIdentifiers(identifiersType);
            demo.setTreatmentFacility(facility);

            String gender = pts.getGender();
            if (gender.equals("M") || gender.equalsIgnoreCase("Male")) {
                demo.setPatientSexCode("M");
            } else if (gender.equals("F") || gender.equalsIgnoreCase("Female")) {
                demo.setPatientSexCode("F");
            }
            demo.setPatientDateOfBirth(getXmlDate(pts.getBirthdate()));

            /*
             * Edited By Johnbosco
             * */
            //check Finger Print if available
            demo.setFingerPrints(getPatientsFingerPrint(pts.getPatientId(), openmrsConn));

            //collect data for SURGE
            if (Utils.isSurgeSite() == "true") {
                demo.setFamilyName(pts.getFamilyName());
                demo.setFirstName(pts.getGivenName());
                demo.setOtherName(pts.getMiddleName());
                demo.setPhoneNumber(pts.getPerson().getAttribute(8).getValue());
            }

            String testCode = pts.getFamilyName() + " " + pts.getGivenName() + "" + pts.getMiddleName();
            Soundex soundex = new Soundex();
            demo.setEnrolleeCode(soundex.encode(testCode));
            String ndrCodedValue;
            //get all hiv enrollment observations
            List<Obs> enrollmentObs = Utils.getHIVEnrollmentObs(pts);

            if (enrollmentObs == null) {
                return demo;
            }

            //check for disease indicator
            Obs obs = Utils.extractObs(Patient_Deceased_Indicator_Concept_Id, enrollmentObs);
            if (Objects.nonNull(obs)) {
                if (obs.getValueCoded().getConceptId() == Dead_Concept_Id) {
                    demo.setPatientDeceasedIndicator(true);
                    obs = Utils.extractObs(Date_Patient_Died_Concept_Id, enrollmentObs);
                    //set date
                    if (obs != null) {
                        demo.setPatientDeceasedDate(getXmlDate(obs.getObsDatetime()));
                    }
                } else {
                    demo.setPatientDeceasedIndicator(false);
                }
            }
            //check Educational level
            obs = Utils.extractObs(Patient_Education_Level_Code_Concept_Id, enrollmentObs);
            if (obs != null) {
                ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                demo.setPatientEducationLevelCode(ndrCodedValue);
            }
            //check primary Concept Id
            obs = Utils.extractObs(Patient_Primary_Language_Code_Concept_Id, enrollmentObs);
            if (obs != null) {
                ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                demo.setPatientPrimaryLanguageCode(ndrCodedValue);
            }
            //check Occupational Code
            obs = Utils.extractObs(Patient_Occupation_Code_Concept_Id, enrollmentObs);
            if (obs != null) {
                ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                demo.setPatientOccupationCode(ndrCodedValue);
            }
            //check Marital Status Code
            obs = Utils.extractObs(Patient_Marital_Status_Code_Concept_Id, enrollmentObs);
            if (obs != null) {
                ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                demo.setPatientMaritalStatusCode(ndrCodedValue);
            }

            return demo;
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
    }

    public HIVQuestionsType createHIVQuestionType(Patient patient, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {

        try {

            PatientIdentifier pmtctIdentifier = patient.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            PatientIdentifier htsIdentifier = patient.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

            HIVQuestionsType hiv = new HIVQuestionsType();
            boolean onART = false;

            if (pmtctIdentifier != null) {
                //get first regimen
                Obs FirstRegimen = Utils.getFirstRegimen(encounters);

                if (FirstRegimen != null && FirstRegimen.getValueCoded() != null) {
                    String regimenCode = pharmDictionary.getRegimenMapValue(FirstRegimen.getValueCoded().getConceptId());
                    String regimenName = FirstRegimen.getValueCoded().getName().getName();
                    CodedSimpleType codedValue = new CodedSimpleType();
                    if (regimenCode != null) {
                        codedValue.setCode(regimenCode);
                    }
                    if (regimenName != null) {
                        codedValue.setCodeDescTxt(regimenName);
                    }
                    hiv.setFirstARTRegimen(codedValue);
                }

                if (FirstRegimen != null) {
                    onART = true;
                    hiv.setARTStartDate(getXmlDate(FirstRegimen.getObsDatetime()));
                }
            }

            int conceptID;
            double value_numeric;
            int value_coded;
            String value_text;
            Date value_datetime;
            FacilityType ft;

            if (obsList == null || obsList.size() == 0) {
                return hiv;
            }

            for (Obs obs : obsList) {

                conceptID = obs.getConcept().getConceptId();

                if (pmtctIdentifier != null) {

                    switch (conceptID) {

                        case Prior_ART:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setPriorArt(getMappedValue(value_coded));
                            break;
                        case Medically_Eligible_Date:
                            value_datetime = obs.getValueDatetime();
                            hiv.setMedicallyEligibleDate(getXmlDate(value_datetime));
                            break;
                        case Reason_Medically_Eligible:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setReasonMedicallyEligible(getMappedValue(value_coded));
                            break;
                        case 7777862:
                            value_datetime = obs.getValueDate();
                            hiv.setInitialAdherenceCounselingCompletedDate(getXmlDate(value_datetime));
                            break;
                        case Date_Transfer_In: //TODO: check transfer form in case it is not filled in the hiv enrollment form but documented in the transfer form
                            value_datetime = obs.getValueDate();
                            if (value_datetime != null) {
                                hiv.setTransferredInDate(getXmlDate(value_datetime));
                            }
                            break;
                        case Facility_Transferred_From: //TODO: look up the facility and extract the DATIM Code
                            value_text = obs.getValueText();
                            ft = Utils.createFacilityType(value_text, value_text, "FAC");
                            hiv.setTransferredInFrom(ft);
                            break;

                        case WHO_Clinical_Stage_ART_Start:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setWHOClinicalStageARTStart(getMappedValue(value_coded));
                            break;
                        case Weight_At_ART_Start_Concept_Id:
                            value_numeric = obs.getValueNumeric();
                            hiv.setWeightAtARTStart((int) value_numeric);
                            break;
                        case Height_At_ART_Start_Concept_Id:
                            value_numeric = obs.getValueNumeric();
                            hiv.setChildHeightAtARTStart((int) value_numeric);
                            break;
                        case Patient_Functional_Status_Concept_Id:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setFunctionalStatusStartART(getMappedValue(value_coded));
                            break;
                        case CD4_count_at_start_of_ART:
                            value_numeric = obs.getValueNumeric();
                            hiv.setCD4AtStartOfART(String.valueOf(value_numeric));
                            break;
                        case 977: //TODO: transfer out status is outstanding
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            if (value_coded == 211) {
                                hiv.setPatientTransferredOut(true);
                                if (onART) {
                                    hiv.setTransferredOutStatus("A");
                                }
                            } else if (value_coded == 975) {
                                hiv.setPatientHasDied(true);
                                if (onART) {
                                    hiv.setStatusAtDeath("A");
                                }
                            }
                            break;
                        case 980:
                            value_text = obs.getValueText();
                            hiv.setSourceOfDeathInformation(value_text);
                            break;

                        default:
                            break;
                    }
                }

                if (htsIdentifier != null) {
                    switch (conceptID) {
                        case Care_Entry_Point:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setCareEntryPoint(getMappedValue(value_coded));
                            break;

                        case Date_Confirmed_HIV:
                            value_datetime = obs.getValueDate();
                            if (value_datetime != null) {
                                hiv.setFirstConfirmedHIVTestDate(getXmlDate(value_datetime));
                            }
                            break;

                        case Mode_of_HIV_Test:
                            if (null == obs.getValueCoded()) {
                                break;
                            }
                            value_coded = obs.getValueCoded().getConceptId();
                            hiv.setFirstHIVTestMode(getMappedValue(value_coded));
                            break;

                        case 7778238:
                            value_text = obs.getValueText();
                            hiv.setWhereFirstHIVTest(value_text);
                            break;

                        default:
                            break;
                    }
                }

                switch (conceptID) {

                    case HIV_Enrollment_Date_Concept_Id:
                        value_datetime = obs.getValueDatetime();
                        if (value_datetime != null) {
                            hiv.setEnrolledInHIVCareDate(getXmlDate(obs.getValueDatetime()));
                        }
                        break;

                    default:
                        break;
                }
            }
            return hiv;
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }

    }

    public CommonQuestionsType createCommonQuestionType(Patient pts, List<Encounter> encounters, List<Obs> allObs) throws DatatypeConfigurationException {

        try {
            PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

            CommonQuestionsType common = new CommonQuestionsType();
            List<Obs> hivEnrollmentObs = Utils.FilterObsByEncounterTypeId(allObs, Utils.HIV_Enrollment_Encounter_Type_Id); // Utils.getHIVEnrollmentObs(pts);
            Obs obs;

            if (htsIdentifier != null) {

                try {
                    common.setHospitalNumber(pts.getPatientIdentifier(3).getIdentifier());
                } catch (Exception e) {
                    common.setHospitalNumber(pts.getPatientIdentifier(4).getIdentifier());
                }
                /*  Assuming Hospital No is 3*/
                //old code commented for throwing error change by the try and catch code abowe
                //common.setHospitalNumber(pts.getPatientIdentifier(3).getIdentifier());
            }



            try{
                Encounter lastEncounterDate = Utils.getLastEncounter(encounters); //(pts);
                if (lastEncounterDate != null) {
                    common.setDateOfLastReport(getXmlDate(lastEncounterDate.getEncounterDatetime()));
                }

                Date EnrollmentDate = Utils.getHIVEnrollmentDate(pts);
                if (EnrollmentDate != null) {
                    common.setDateOfFirstReport(getXmlDate(EnrollmentDate));
                    common.setDiagnosisDate(getXmlDate(EnrollmentDate));
                }
            }catch (Exception ex){

            }

            if (pts.getGender().equalsIgnoreCase("F")) {

                //set estimated delivery date concept id
                obs = Utils.extractObs(Estimated_Delivery_Date_Concept_Id, hivEnrollmentObs);

                if (obs != null) {
                    common.setEstimatedDeliveryDate(getXmlDate(obs.getValueDatetime()));
                    Boolean status = (Utils.extractObs(Patient_Pregnancy_Status_Concept_Id, hivEnrollmentObs).getValueCoded().getConceptId() == 1);
                    common.setPatientPregnancyStatusCode(status.toString());
                }
            }

            common.setPatientDieFromThisIllness(pts.isDead());
            common.setPatientAge(pts.getAge());

            //set Patient Die From This Illness tag
            obs = Utils.extractObs(Patient_Died_From_Illness_Concept_Id, hivEnrollmentObs);
            LoggerUtils.write(NDRMainDictionary.class.getName(), "About to pull Patient_Died_From_Illness_Concept_Id", LogFormat.FATAL, LogLevel.debug);
            if (obs != null && obs.getValueCoded().getConceptId() == Patient_Died_From_Illness_Value_Concept_Id) {
                common.setPatientDieFromThisIllness(true);
            }
            LoggerUtils.write(NDRMainDictionary.class.getName(), "Finished pulling Patient_Died_From_Illness_Concept_Id", LogFormat.FATAL, LogLevel.debug);

            return common;
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(ex.getMessage());
        }
    }

    /*static HIVQuestionsType createHIVQuestionType(Obs firstRegimenObs, Date ARTStartDate, Date EnrollmentDate, List<Obs> obs) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}*/

    public FingerPrintsType getPatientsFingerPrint(int id, DBConnection connResult) {
        Connection connection;
        try {

            connection = DriverManager.getConnection(connResult.getUrl(), connResult.getUsername(), connResult.getPassword());
            Statement statement = connection.createStatement();
            String sqlStatement = ("SELECT template, fingerPosition, date_created FROM biometricinfo WHERE patient_Id = " + id);
            ResultSet result = statement.executeQuery(sqlStatement);
            FingerPrintsType fingerPrintsType = new FingerPrintsType();
            if (result.next()) {
                HandType rightHand = new HandType();
                HandType leftHand = new HandType();
                ArrayList<FingerType> rightHands = new ArrayList<>();
                ArrayList<FingerType> leftHands = new ArrayList<>();

                do {
                    FingerType fingerType = new FingerType();
                    if (result.getString("fingerPosition").contains("Right")) {
                        fingerType.setType(result.getString("fingerPosition"));
                        fingerType.setFinger(result.getString("template"));
                        rightHands.add(fingerType);
                    } else {
                        fingerType.setType(result.getString("fingerPosition"));
                        fingerType.setFinger(result.getString("template"));
                        leftHands.add(fingerType);
                    }
                } while (result.next());

                rightHand.setFinger(rightHands);
                leftHand.setFinger(leftHands);

                fingerPrintsType.setDateCaptured(new Date(System.currentTimeMillis()));//Utils.getXmlDateTime(result.getDate("date_created")));
                fingerPrintsType.setPresent(true);
                fingerPrintsType.setLeftHand(leftHand);
                fingerPrintsType.setRightHand(rightHand);
            } else {
                connection.close();
                return null;
            }
            connection.close();
            return fingerPrintsType;
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerUtils.write(NDRMainDictionary.class.getName(), e.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return null;
    }
    public PatientDemographicsType createPatientDemographicType2(Patient patient, FacilityType facility, DBConnection openmrsConn,List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException{
        return commonQuestionDictionary.createPatientDemographicsType(patient, facility, allPatientObsList, allPatientEncounterList, openmrsConn);
    }
    public CommonQuestionsType createCommonQuestionType2(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException{
        CommonQuestionsType commonQuestionsType=null;
        commonQuestionsType=commonQuestionDictionary.createCommonQuestionType(patient, allPatientEncounterList, allPatientObsList);
        return commonQuestionsType;
    }
    public ConditionSpecificQuestionsType createCommConditionSpecificQuestionsType(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException{
        return commonQuestionDictionary.createConditionSpecificQuestionType(patient, allPatientEncounterList, allPatientObsList);
    }
    public List<HIVEncounterType> createHIVEncounterType(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allObs) throws DatatypeConfigurationException {
        return clinicalDictionary.createHIVEncounterType(patient, allPatientEncounterList, allObs);
    }

    public List<RegimenType> createRegimenTypeList(Patient patient, List<Encounter> allEncounterForPatient,List<Obs> allPatientObsList) throws DatatypeConfigurationException{
        return  pharmDictionary.createRegimenTypeList(patient, allEncounterForPatient,allPatientObsList);
    }

 /*   public List<LaboratoryReportType> createLaboratoryOrderAndResult(Patient pts, List<Encounter> enc, List<Obs> labObsList)
            throws DatatypeConfigurationException {
        return labDictionary.createLaboratoryOrderAndResult(pts, enc, labObsList );
    }*/

    public LaboratoryReportType createLaboratoryOrderAndResult(Patient pts, Encounter enc, List<Obs> labObsList)
            throws DatatypeConfigurationException {
        return labDictionary.createLaboratoryOrderAndResult(pts, enc, labObsList );
    }

    public ChildBirthDetailsType createChildBirthDetailsType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createChildBirthDetailsType(pts, null, antenatalObsList);
    }

    public ChildFollowupType createChildFollowupType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createChildFollowupType(pts, null,  antenatalObsList);
    }

    public ImmunizationType createImmunizationType(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return pmtctDictionary.createImmunizationType(pts, null, antenatalObsList);
    }
    public InfantPCRTestingType createInfantPcr(Patient pts, List<Encounter> enc, List<Obs> antenatalObsList) throws DatatypeConfigurationException {
        return  pmtctDictionary.createInfantPcr(pts, null,antenatalObsList);
    }

    public List<ClinicalTBScreeningType> createClinicalTbScreening(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<ClinicalTBScreeningType> clinicalTBScreeningTypes = new ArrayList<>();

            ClinicalTBScreeningType clinicalTBScreeningType = htsDictionary.createClinicalTbScreening(pts, encounters, obsList);
            if(clinicalTBScreeningType !=null){
                clinicalTBScreeningTypes.add(clinicalTBScreeningType);
            }

        return clinicalTBScreeningTypes;
    }

    public List<HIVRiskAssessmentType> createHivRiskAssessment(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<HIVRiskAssessmentType> hivRiskAssessmentTypes = new ArrayList<>();

            HIVRiskAssessmentType hivRiskAssessmentType = htsDictionary.createHivRiskAssessment(pts, encounters, obsList);
            if(hivRiskAssessmentType !=null){
                hivRiskAssessmentTypes.add(hivRiskAssessmentType);
            }

        return hivRiskAssessmentTypes;
    }

    public List<KnowledgeAssessmentType> createKnowledgeAssessmentType(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<KnowledgeAssessmentType> knowledgeAssessmentTypes = new ArrayList<>();
            KnowledgeAssessmentType knowledgeAssessmentType = htsDictionary.createKnowledgeAssessmentType(pts, encounters, obsList);
            if(knowledgeAssessmentType !=null){
                knowledgeAssessmentTypes.add(knowledgeAssessmentType);
            }

        return knowledgeAssessmentTypes;
    }

    public List<PostTestCounsellingType> createPostTestCounsellingType(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<PostTestCounsellingType> postTestCounsellingTypes = new ArrayList<>();

            PostTestCounsellingType postTestCounsellingType = htsDictionary.createPostTestCouncellingType(pts, encounters, obsList);
            if(postTestCounsellingType !=null){
                postTestCounsellingTypes.add(postTestCounsellingType);
            }

        return postTestCounsellingTypes;
    }

    public List<SyndromicSTIScreeningType> createSyndromicsStiType(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<SyndromicSTIScreeningType> syndromicSTIScreeningTypes = new ArrayList<>();

            SyndromicSTIScreeningType syndromicSTIScreeningType = htsDictionary.createSyndromicsStiType(pts, encounters, obsList);
            if(syndromicSTIScreeningType !=null){
                syndromicSTIScreeningTypes.add(syndromicSTIScreeningType);
            }

        return syndromicSTIScreeningTypes;
    }

    public List<HealthFacilityVisitsType> createHealthFacilityVisit(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {
        List<HealthFacilityVisitsType> healthFacilityVisitsTypes = new ArrayList<>();
        for(Encounter enc: encounters){
            HealthFacilityVisitsType healthFacilityVisitsType = htsDictionary.createHealthFacilityVisit(pts, enc, obsList);
            if(healthFacilityVisitsType !=null){
                healthFacilityVisitsTypes.add(healthFacilityVisitsType);
            }
        }
        return healthFacilityVisitsTypes;
    }

    public List<PartnerDetailsType> createPartnerDetails(Patient pts, List<Encounter> encounters, List<Obs> obsList) throws DatatypeConfigurationException {

        List<PartnerDetailsType> partnerDetailsTypes = new ArrayList<>();
        for(Encounter enc: encounters) {
            if (enc.getEncounterType().getEncounterTypeId() == Utils.Partner_register_Encounter_Id) {
                PartnerDetailsType p_details =  htsDictionary.createPartnerDetails(pts, enc, obsList);
                if(p_details !=null){
                    partnerDetailsTypes.add(p_details);
                }
            }
        }
        return  partnerDetailsTypes;
    }
}
