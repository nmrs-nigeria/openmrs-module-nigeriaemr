/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.*;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObsByConceptId;
import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.getObs;

public class LabDictionary {

    Utils utils = new Utils();
    public LabDictionary() {
        loadLabTestDictionary();
        loadLabTestUnitDictionary();
        loadLabTestUnitDescription();
        loadOtherCodedValues();
    }

    public final static int CD4_Count_Concept_Id = 5497;
    public final static int SERUM_CREATININE_CONCEPT_ID = 164364;
    public final static int WEIGHT_CONCEPT_ID = 5089;
    public final static int WHO_STAGING_CONCEPT_ID = 5356;
    public final static int PCV_HCT_CONCEPT_ID = 1015;
    public final static int ALT_SGPT_CONCEPT_ID = 654;
    public final static int Viral_Load_CONCEPT_ID = 856;

    final static int Ordered_By_Concept_Id = 164987;

    final static int Ordered_Date_Concept_id = 164989;

    final static int Checked_By_Concept_Id = 164983;
    final static int Checked_By_Date_Concept_Id = 164984;

    final static int Reported_By_Date_Concept_Id = 1644984;
    final static int REPORTED_BY_CONCEPT_ID = 164982;
    final static int Numeric_DataType_Concept_Id = 1;
    final static int Coded_DataType_ConceptId = 2;
    final static int Text_DataType_ConceptId = 3;
    final static int Visit_Type_Concept_Id = 164181;

    // final static int Laboratory_Identifier_Concept_Id = 164409;
    final static int Laboratory_Identifier_Concept_Id = 165715;
    final static int SAMPLE_COLLECTION_DATE = 159951;

    //TODO: replace placeholder concept ids (0) with real concepts when available
    public final static int
            Specimen_Type_Concept_Id = 162476,
            Sample_Received_At_Lab_Date_Concept_Id = 165716,
            Sample_Logged_Remotely_Concept_Id = 167614,
            Lab_Registration_Number_Concept_Id = 165394,
            PCR_POC_Lab_Name_Concept_Id = 166233,
            PCR_POC_Lab_Sample_Number_Concept_Id = 165715,
            Viral_Load_Indication_Concept_Id = 164980,
            Viral_Load_Result_Concept_Id = 856,
            Viral_Load_Result_Date_Concept_Id = 0,
            EID_Indication_Concept_Id = 167321,
            EID_Entry_Point_Concept_Id = 0,
            EID_Result_Concept_Id = 167623,
            EID_Age_Concept_Id = 167582,
            CD4_Cell_Count_Concept_Id = 5497,
            CD4_Percentage_Concept_Id = 730,
            CD4_LFA_Result_Concept_Id = 167088,
            Random_Glucose_Concept_Id = 160053,
            HBsAG_Result_Concept_Id = 159430,
            HCV_Antibody_Result_Concept_Id = 1325,
            HBV_Viral_Load_Concept_Id = 167503,
            HCV_Viral_Load_Concept_Id = 167534,
            VDRL_Syphilis_Result_Concept_Id = 167450,
            Serology_For_CrAg_Result_Concept_Id = 167090,
            CSF_For_CrAg_Result_Concept_Id = 167082,
            TB_LFLAM_Result_Concept_Id = 166697,
            HPV_Result_Concept_Id = 167583,
            Cytology_VIA_PapSmear_Result_Concept_Id = 165927,
            Urinalysis_Concept_Id = 160987,
            Lab_ART_Start_Date_Concept_Id = 0,
            Drug_Regimen_Line_Concept_Id = 167548,
            ARV_Prophylaxis_Received_Concept_Id = 167322;

    private Map<Integer, Integer> labTestDictionary = new HashMap<>();
    private Map<Integer, String> labTestUnits = new HashMap<>();
    private Map<String, String> labTestUnitDescription = new HashMap<>();
    private Map<Integer, String> CodedAnswerDictionary = new HashMap<>();

    private void loadLabTestDictionary() {
        labTestDictionary = new HashMap<>();
        labTestDictionary.put(654, 2);//SERUM GLUTAMIC-PYRUVIC TRANSAMINASE
        labTestDictionary.put(653, 4);//SERUM GLUTAMIC-OXALOACETIC TRANSAMINASE
        labTestDictionary.put(655, 7);//TOTAL BILIRUBIN
        labTestDictionary.put(CD4_Count_Concept_Id, 11);//CD4 COUNT
        //labTestDictionary.put(730, 11);//CD4%
        labTestDictionary.put(1319, 12);//LYMPHOCYTE COUNT
        //labTestDictionary.put(1338, 12);//LYMPHOCYTES (%) - MICROSCOPIC EXAM
        labTestDictionary.put(1007, 18);//HIGH-DENSITY LIPOPROTEIN CHOLESTEROL
        labTestDictionary.put(1008, 19);//LOW-DENSITY LIPOPROTEIN CHOLESTEROL
        labTestDictionary.put(164364, 21);//Serum creatinine (mg/dL)
        labTestDictionary.put(160053, 31);//Glucose measurement, serum, fasting (mmol/dL)
        labTestDictionary.put(1015, 34);//HEMATOCRIT
        labTestDictionary.put(159430, 42);//Hepatitis B Surface Antigen Test
        labTestDictionary.put(1325, 43);//HEPATITIS C TEST - QUALITATIVE
        labTestDictionary.put(32, 50);//MALARIAL SMEAR "
        labTestDictionary.put(885, 52);//PAPANICOLAOU SMEAR "
        labTestDictionary.put(785, 54);//ALKALINE PHOSPHATASE
        labTestDictionary.put(729, 56);//Platelets
        labTestDictionary.put(1133, 57);//SERUM POTASSIUM
        labTestDictionary.put(717, 59);//TOTAL PROTEIN "
        labTestDictionary.put(1132, 64);//SERUM SODIUM
        labTestDictionary.put(299, 70);//VDRL "
        labTestDictionary.put(1006, 72);//TOTAL CHOLESTEROL
        labTestDictionary.put(1009, 74);//TRIGLYCERIDES
        labTestDictionary.put(856, 80);//HIV VIRAL LOAD
        labTestDictionary.put(678, 82);//WHITE BLOOD CELLS
        //labTestDictionary.put(165398, 0);//Additional Lab Tests
        //labTestDictionary.put(1025, 0);//BASOPHILS
        //labTestDictionary.put(1341, 0);//BASOPHILS (%) - MICROSCOPIC EXAM
        //labTestDictionary.put(1024, 0);//EOSINOPHILS
        //labTestDictionary.put(1023, 0);//MONOCYTES
        //labTestDictionary.put(1339, 0);//MONOCYTES (%) - MICROSCOPIC EXAM
        labTestDictionary.put(1022, 13);//NEUTROPHILS
        labTestDictionary.put(45, 58);//URINE PREGNANCY TEST
        labTestDictionary.put(165765,80);//Viral Load Order
        labTestDictionary.put(167088,83);//CD4 LFA RESULT
        labTestDictionary.put(167090,84);//Serology for CrAg Result
        labTestDictionary.put(166697,85);//Other Test (TB-LAM, LF-LAM,etc)
        labTestDictionary.put(167082,86);//CSF for CrAg
        labTestDictionary.put(167084,87);//CSF for MCS Result
        labTestDictionary.put(167623,95);//EID
    }

    private void loadOtherCodedValues() {
        CodedAnswerDictionary = new HashMap<>();
        //visit type
        CodedAnswerDictionary.put(160530, "R"); //repeat
        CodedAnswerDictionary.put(164180, "B"); //baseline

        //TODO: replace placeholder keys (0) with real OpenMRS answer concept ids when available
        //SpecimenTypeCode
        CodedAnswerDictionary.put(1000, "WholeBlood");
        CodedAnswerDictionary.put(1002, "Plasma");
        CodedAnswerDictionary.put(165568, "DBS");
        CodedAnswerDictionary.put(166615, "PBS");

        //ViralLoadIndicationCode
        CodedAnswerDictionary.put(167607, "Baseline");
        CodedAnswerDictionary.put(167608, "Routine");
        CodedAnswerDictionary.put(167609, "ClinicalFailure");
        CodedAnswerDictionary.put(0, "ImmunologicFailure");
        CodedAnswerDictionary.put(167610, "Confirmation");
        CodedAnswerDictionary.put(167539, "RecentInfection");
        CodedAnswerDictionary.put(166122, "Gestation3236Weeks");
        CodedAnswerDictionary.put(167309, "EarlyHIVDetection");

        //EIDIndicationCode check to un-retire
        CodedAnswerDictionary.put(167314, "EIDAtBirth");
        CodedAnswerDictionary.put(167313, "EIDAt6To8Weeks");
        CodedAnswerDictionary.put(167312, "EIDAt2To12Months");
        CodedAnswerDictionary.put(167611, "RepeatInvalidTest");
        CodedAnswerDictionary.put(167612, "RepeatAfterBreastfeedingCessation");

        //EIDResultCode / HBsAG / HCVAntibody / SerologyForCrAg / CSFForCrAg / TBLFLAM / HPV
        CodedAnswerDictionary.put(664, "Negative");
        CodedAnswerDictionary.put(703, "Positive");
        CodedAnswerDictionary.put(163611, "Invalid");

        //CD4LFAResultCode
        CodedAnswerDictionary.put(167086, "LessThan200");
        CodedAnswerDictionary.put(167087, "GTEqual200");

        //VDRLSyphilisResultCode
        CodedAnswerDictionary.put(167450, "NonReactive");
        CodedAnswerDictionary.put(1228, "Reactive");

        //DrugRegimenLineCode
        CodedAnswerDictionary.put(167547, "FirstLine");
        CodedAnswerDictionary.put(167546, "SecondLine");
        CodedAnswerDictionary.put(167545, "ThirdLine");

        //ARVProphylaxisReceivedCode
        CodedAnswerDictionary.put(165544, "AZT_NVP");
        CodedAnswerDictionary.put(808, "NVP");
        CodedAnswerDictionary.put(167605, "AZT_3TC_NVP_RAL");
        CodedAnswerDictionary.put(5622, "Others");
        CodedAnswerDictionary.put(1066, "No");
    }

    private String eidAge (int conceptId){
        if (conceptId == 163733) {
            return "LessThanOrEqual72hrs";
        }
        if (conceptId == 167098) {
            return "GreaterThan72hrsLessThan2Months";
        }
        if (conceptId == 167312) {
            return "GreaterThanOrEqual2MonthsTo12Months";
        }
        if (conceptId == 167102) {
            return "GreaterThan12Months";
        }
        return null;
    }

    private void loadLabTestUnitDictionary() {
        labTestUnits = new HashMap<>();
        labTestUnits.put(88, "48");
        labTestUnits.put(315, "60");
        labTestUnits.put(1153, "398");
        labTestUnits.put(365, "311");
        labTestUnits.put(331, "25");
        labTestUnits.put(1717, "48");
        labTestUnits.put(1168, "398");
        labTestUnits.put(366, "311");
        labTestUnits.put(1169, "48");
        labTestUnits.put(1718, "398");
        labTestUnits.put(367, "311");
        labTestUnits.put(1716, "48");
        labTestUnits.put(1170, "398");
        labTestUnits.put(1531, "311");
        labTestUnits.put(1719, "48");
        labTestUnits.put(1156, "398");
        labTestUnits.put(451, "257");
        labTestUnits.put(1150, "48");
        labTestUnits.put(7777906, "398");
        labTestUnits.put(1528, "257");
        labTestUnits.put(7777907, "398");
        labTestUnits.put(228, "136");
        labTestUnits.put(1529, "93");
        labTestUnits.put(375, "25");
        labTestUnits.put(1175, "311");
        labTestUnits.put(1159, "311");
        labTestUnits.put(313, "257");
        labTestUnits.put(308, "93");
        labTestUnits.put(309, "93");
        labTestUnits.put(1176, "311");
        labTestUnits.put(1530, "93");
        labTestUnits.put(329, "398");
        labTestUnits.put(332, "25");
    }

    private void loadLabTestUnitDescription() {
        labTestUnitDescription = new HashMap<>();
        labTestUnitDescription.put("48", "CellsPerMicroLiter,cell/ul");
        labTestUnitDescription.put("60", "CopiesPerMilliLiter,copies/ml");
        labTestUnitDescription.put("398", "percent,%");
        labTestUnitDescription.put("311", "MilliMolesPerLiter,mmol/L");
        labTestUnitDescription.put("25", "BillionPerLiter,10*9/L");
        labTestUnitDescription.put("257", "MicroMole,umol");
        labTestUnitDescription.put("136", "GramsPerDeciLiter,g/dL");
        labTestUnitDescription.put("93", "GramsPerDeciLiter,U/L");
    }

    private int getMappedValue(int conceptID) {
        try {
            return labTestDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            throw ex;
        }
    }

    private String getMappedAnswerValue(int conceptID) {
        if (CodedAnswerDictionary.containsKey(conceptID)) {
            return CodedAnswerDictionary.get(conceptID);
        }
        return "";

    }

    private boolean isValidLabTest(int conceptID) {
        return labTestDictionary.keySet().contains(conceptID);
    }

    private String getLaboratoryTestTypeCode(int conceptId) {

        if (conceptId == Viral_Load_CONCEPT_ID) {
            return "HIV";
        }

        if (conceptId == Serology_For_CrAg_Result_Concept_Id ||
                conceptId == CSF_For_CrAg_Result_Concept_Id) {
            return "HIV";
        }

        if (conceptId == CD4_Count_Concept_Id ||
                conceptId == CD4_LFA_Result_Concept_Id ||
                conceptId == CD4_Percentage_Concept_Id) {
            return "CD4";
        }

        if (conceptId == EID_Result_Concept_Id ||
                conceptId == EID_Indication_Concept_Id) {
            return "EID";
        }

        if (conceptId == HBsAG_Result_Concept_Id ||
                conceptId == HBV_Viral_Load_Concept_Id) {
            return "HBV";
        }

        if (conceptId == HCV_Antibody_Result_Concept_Id ||
                conceptId == HCV_Viral_Load_Concept_Id) {
            return "CV";
        }

        return "OtherTest";
    }

    public LaboratoryReportType createLaboratoryOrderAndResult(Patient pts, Encounter enc, List<Obs> obsIdList) {

        Map<Object, List<Obs>> labObsList = Utils.groupedByConceptIdsOnly(obsIdList);
        LaboratoryReportType labReportType = new LaboratoryReportType();
        try {

            XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
            labReportType.setVisitID(Utils.getVisitId(pts, enc));
            labReportType.setVisitDate(convertedDate);



            Obs obs =  Utils.extractObs(Visit_Type_Concept_Id, labObsList);
            if (obs != null && obs.getValueCoded() != null) {
                LoggerUtils.write(LabDictionary.class.getName(), "About to pull Visit_Type_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                labReportType.setBaselineRepeatCode(getMappedAnswerValue(obs.getValueCoded().getConceptId()));
                LoggerUtils.write(LabDictionary.class.getName(), "Finished pulling Visit_Type_Concept_Id", LogFormat.FATAL, LogLevel.debug);
            }

            obs = Utils.extractObs(SAMPLE_COLLECTION_DATE, labObsList);
            if (obs != null && obs.getValueDate() != null) {
                XMLGregorianCalendar collectionDate = utils.getXmlDate(obs.getValueDate());
                labReportType.setCollectionDate(collectionDate);
            }else {
                labReportType.setCollectionDate(convertedDate);

            }

            obs = Utils.extractObs(Laboratory_Identifier_Concept_Id, labObsList);
            if (obs != null && obs.getValueText() != null) {
                labReportType.setLaboratoryTestIdentifier(obs.getValueText());
            }

            obs = Utils.extractObs(Ordered_By_Concept_Id, labObsList);
            if (obs != null && obs.getValueText() != null) {
                labReportType.setClinician(obs.getValueText());
            }

            obs = Utils.extractObs(Checked_By_Concept_Id, labObsList);
            if (obs != null && obs.getValueText() != null) {
                labReportType.setCheckedBy(obs.getValueText());
            }

            obs = Utils.extractObs(REPORTED_BY_CONCEPT_ID, labObsList);
            if (obs != null && obs.getValueText() != null) {
                labReportType.setReportedBy(obs.getValueText());
            }

            //if there is no lab order and result, discard
            List<LaboratoryOrderAndResult> laboratoryOrderAndResultList = createLaboratoryOrderAndResult(enc, obsIdList);
            if (!laboratoryOrderAndResultList.isEmpty()) {
                labReportType.getLaboratoryOrderAndResult().addAll(laboratoryOrderAndResultList);
                return labReportType;
            }

//            boolean artStatusFlag = isArtStatusFlag(pts, enc);
//            if(artStatusFlag){
//                labReportType.setARTStatusCode("A");
//            } else {
//                labReportType.setARTStatusCode("N");
//            }

        } catch (Exception ex) {
            LoggerUtils.write(LabDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            System.out.println(ex.getMessage());
        }
        return labReportType;
    }

    private boolean isArtStatusFlag(Patient pts, Encounter enc) {
        boolean artStatusFlag = false;
        List<Obs> myObs = getObs(pts, 162240);
        if(myObs != null) {
            for (Obs ObsPs : myObs) {
                if (ObsPs.getObsDatetime().equals(enc.getEncounterDatetime()) ||
                        ObsPs.getObsDatetime().before(enc.getEncounterDatetime())) {
                    artStatusFlag = true;
                }

            }
        }
        return artStatusFlag;
    }

    public LaboratoryReportType createLabReportType(Patient patient, Date visitDate, List<Obs> labObsForVisit) {

        LaboratoryReportType labReportType = new LaboratoryReportType();
        String visitID = "", pepfarID;
        int conceptID = 0, dataType = 0;
        CodedSimpleType cst;
        AnswerType answer;
        NumericType numeric;
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        if (labObsForVisit != null && !labObsForVisit.isEmpty() && pepfarIdentifier != null) {
            pepfarID = pepfarIdentifier.getIdentifier();
            visitID = Utils.getVisitId(pepfarID, visitDate);

        }
        return labReportType;
    }

    private List<LaboratoryOrderAndResult> createLaboratoryOrderAndResult(Encounter enc, List<Obs> obsList)
            throws DatatypeConfigurationException {

        List<LaboratoryOrderAndResult> labResultList = new ArrayList<>();

        int conceptID;
        int dataType;
        CodedSimpleType cst;

        AnswerType answer;
        NumericType numeric = null;
        Date orderedDate = null;

        Obs obsEle = extractObsByConceptId(Ordered_Date_Concept_id, obsList);
        if (obsEle != null) {
            orderedDate = obsEle.getValueDate();
        }

        LaboratoryOrderAndResult labOrderAndResult;

        for (Obs obs : obsList) {

            labOrderAndResult = new LaboratoryOrderAndResult();
            cst = new CodedSimpleType();

            conceptID = obs.getConcept().getId();
            dataType = obs.getConcept().getDatatype().getConceptDatatypeId();

            int ndrCodedValue;

            if (dataType == Numeric_DataType_Concept_Id && isValidLabTest(conceptID)) {

                try {
                    ndrCodedValue = getMappedValue(conceptID);
                    labOrderAndResult.setLaboratoryTestTypeCode(
                            getLaboratoryTestTypeCode(conceptID)
                    );

                    LoggerUtils.write(LabDictionary.class.getName(), "About to pull Laboratory_Result_TEST", LogFormat.FATAL, LogLevel.debug);
                    cst.setCode(Integer.toString(ndrCodedValue));
                    cst.setCodeDescTxt(obs.getConcept().getName().getName());
                    labOrderAndResult.setLaboratoryResultedTest(cst);
                    LoggerUtils.write(LabDictionary.class.getName(), "Finished pulling Laboratory_Result_TEST", LogFormat.FATAL, LogLevel.debug);

                    if (obs.getValueNumeric() != null) {
                        numeric = new NumericType();
                        numeric.setValue1(obs.getValueNumeric().floatValue());
                    }

                    if (orderedDate != null) {
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(orderedDate));
                    } else {
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }

                    //TODO:revisit this implementation
                    if (labTestUnits.containsKey(conceptID) && numeric != null) {

                        CodedType ct = new CodedType();
                        ct.setCode(labTestUnits.get(conceptID));

                        String[] descriptionText = StringUtils.split(labTestUnitDescription.get(ct.getCode()), ",");
                        if (descriptionText != null) {
                            ct.setCodeDescTxt(descriptionText[0]);
                            ct.setCodeSystemCode(StringEscapeUtils.escapeXml(descriptionText[1]));
                        }
                        numeric.setUnit(ct);
                    }

                    if (numeric != null) {
                        answer = new AnswerType();
                        answer.setAnswerNumeric(numeric);
                        labOrderAndResult.setLaboratoryResult(answer);
                        labOrderAndResult.setResultedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }
                    applyNewLabFields(labOrderAndResult, conceptID, obsList, obs);
                    labResultList.add(labOrderAndResult);

                } catch (Exception ex) {
                    LoggerUtils.write(LabDictionary.class.getName(), "Error in Numeric_DataType_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
                }

            } else if (dataType == Coded_DataType_ConceptId && isValidLabTest(conceptID)) {
                try {
                    cst = new CodedSimpleType();

                    LoggerUtils.write(LabDictionary.class.getName(), "About to pull Coded_DataType_ConceptId", LogFormat.FATAL, LogLevel.debug);
                    //set the lab test code
                    ndrCodedValue = getMappedValue(conceptID);

                    // FIX: previously this next line was immediately overwritten by a second
                    // setLaboratoryTestTypeCode(String.valueOf(ndrCodedValue)) call, which put
                    // the raw NDR integer code (e.g. "83") into LaboratoryTestTypeCode instead
                    // of the schema-valid enum value ("CD4", "OtherTest", etc.). That second
                    // call has been removed.
                    labOrderAndResult.setLaboratoryTestTypeCode(
                            getLaboratoryTestTypeCode(conceptID)
                    );
                    cst.setCode(Integer.toString(ndrCodedValue));
                    cst.setCodeDescTxt(obs.getConcept().getName().getName());
                    labOrderAndResult.setLaboratoryResultedTest(cst);

                    //get the answer
                    CodedType ct = null;
                    if (obs.getValueCoded() != null) {
                        ct = new CodedType();
                        ct.setCode(obs.getValueCoded().getName().getName());
                        ct.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        // NOTE: CodeSystemCode is still being set to the same text as Code/CodeDescTxt
                        // here (pre-existing behavior, not part of the two bugs discussed). If you
                        // have a real coding-system identifier (e.g. "NDR", "CIEL") for this answer,
                        // set that instead — flagging this line so it's easy to find.
                        ct.setCodeSystemCode(obs.getValueCoded().getName().getName());
                    }

                    if (ct != null) {
                        answer = new AnswerType();
                        answer.setAnswerCode(ct);
                        labOrderAndResult.setLaboratoryResult(answer);
                        labOrderAndResult.setResultedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }

                    if (orderedDate != null) {
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(orderedDate));
                    } else {
                        // FIX: coded branch was missing this fallback (numeric branch already had it).
                        // Without it, OrderedTestDate — a required element (minOccurs="1") — was
                        // silently left unset whenever no Ordered_Date_Concept_id obs existed,
                        // producing schema-invalid output for every coded-type result.
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }
                    applyNewLabFields(labOrderAndResult, conceptID, obsList, obs);
                    labResultList.add(labOrderAndResult);
                } catch (Exception ex) {
                    LoggerUtils.write(LabDictionary.class.getName(), "Error in Coded_DataType_ConceptId: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
                }
            }
        }
        return labResultList;
    }

    /**
     * Populates NDR 1.7.2.0 LaboratoryOrderAndResult fields (specimen info, lab registration,
     * PCR/POC lab info, viral load, EID, CD4 detail, glucose, hepatitis/serology, syphilis,
     * CrAg, TB-LAM, HPV, cytology, urinalysis, ART start date, drug regimen line,
     * ARV prophylaxis received). All lookups use placeholder concept ids until production
     * ids are wired.
     */
    private void applyNewLabFields(LaboratoryOrderAndResult lor, int testConceptId, List<Obs> obsList, Obs currentObs) {
        Obs obs;

        // ---- Specimen / PCR-POC lab fields: Viral Load and EID orders only.
        // FIX (per NDR paper form layout): "PCR/POC Lab Sample No.", Sample Type,
        // Date sample tested, Sample logged remotely, and Date Sample Received at PCR/POC Lab
        // sit inside the same boxed section as "Indication for Viral Load" / "Indication for
        // EID" on the source form, separate from the CD4/TB-LAM/serology/HBsAG/etc. panel.
        // Those are rapid/point-of-care tests that don't go through the PCR/POC pipeline, so
        // this whole block is now gated to VL/EID orders instead of applying to every result.
        boolean isVlOrEidTest = testConceptId == Viral_Load_CONCEPT_ID
                || testConceptId == EID_Result_Concept_Id
                || testConceptId == EID_Indication_Concept_Id;
        if (isVlOrEidTest) {
            obs = extractObsByConceptId(SAMPLE_COLLECTION_DATE, obsList);
            if (obs != null && obs.getValueDate() != null) {
                lor.setSpecimenCollectionDate(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObsByConceptId(Specimen_Type_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setSpecimenTypeCode(code);
            }
            obs = extractObsByConceptId(Sample_Received_At_Lab_Date_Concept_Id, obsList);
            if (obs != null && obs.getValueDate() != null) {
                lor.setSampleReceivedAtLabDate(utils.getXmlDate(obs.getValueDate()));
            }
            obs = extractObsByConceptId(Sample_Logged_Remotely_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                int answer = obs.getValueCoded().getConceptId();
                if (answer == 1065) lor.setSampleLoggedRemotely(YNCodeType.YES);
                else if (answer == 1066) lor.setSampleLoggedRemotely(YNCodeType.NO);
            }
            obs = extractObsByConceptId(Lab_Registration_Number_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setLabRegistrationNumber(obs.getValueText());

            obs = extractObsByConceptId(PCR_POC_Lab_Name_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setPCRPOCLabName(obs.getValueText());

            obs = extractObsByConceptId(PCR_POC_Lab_Sample_Number_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setPCRPOCLabSampleNumber(obs.getValueText());
        }

        // ---- Viral Load: only for the HIV viral load test concept.
        // FIX: previously grouped with HBV_Viral_Load_Concept_Id and HCV_Viral_Load_Concept_Id,
        // which would have stamped a generic ViralLoadResult/ViralLoadIndicationCode onto HBV
        // or HCV orders too. The schema already has dedicated HBVViralLoad/HCVViralLoad fields
        // for those (handled separately below), so this block is HIV-only. ----
        boolean isViralLoadTest = testConceptId == Viral_Load_CONCEPT_ID;
        if (isViralLoadTest) {
            obs = extractObsByConceptId(Viral_Load_Indication_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setViralLoadIndicationCode(code);
            }
            obs = extractObsByConceptId(Viral_Load_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setViralLoadResult(BigDecimal.valueOf(obs.getValueNumeric()));
            }
       /* obs = extractObsByConceptId(Viral_Load_Result_Date_Concept_Id, obsList);
        if (obs != null && obs.getValueDate() != null) {
            lor.setViralLoadResultDate(utils.getXmlDate(obs.getValueDate()));
        }*/
        }

        // ---- EID: only for EID indication/result test concepts ----
        boolean isEidTest = testConceptId == EID_Result_Concept_Id
                || testConceptId == EID_Indication_Concept_Id;
        if (isEidTest) {
            obs = extractObsByConceptId(EID_Indication_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setEIDIndicationCode(code);
            }
            obs = extractObsByConceptId(EID_Entry_Point_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setEIDEntryPointCode(obs.getValueText());

            obs = extractObsByConceptId(EID_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setEIDResultCode(code);
            }
            obs = extractObsByConceptId(EID_Age_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = eidAge(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setEIDAgeCode(code);
            }

            // FIX (per request): DrugRegimenLineCode and ARVProphylaxisReceivedCode were
            // previously applied to every order in the encounter. ARVProphylaxisReceivedCode
            // in particular is an EID/PMTCT concept (infant ARV prophylaxis regimen), so both
            // are now scoped to EID orders only and no longer appear on Viral Load, CD4, or
            // other order types.
            /*obs = extractObsByConceptId(Drug_Regimen_Line_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setDrugRegimenLineCode(code);
            }*/
            obs = extractObsByConceptId(ARV_Prophylaxis_Received_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setARVProphylaxisReceivedCode(code);
            }
        }

        // ---- CD4: each field gated on its OWN exact concept, not a shared "CD4" category.
        // FIX: the previous shared isCd4Test grouping caused a CD4 LFA order to also pick up
        // CD4CellCount from a separate CD4 Count order in the same visit, and vice versa —
        // visible in your last output (block 2 and block 4 duplicating each other's numbers).
        // CD4 Count, CD4 Percentage, and CD4 LFA are three distinct tests/orders and should
        // each only carry their own result. ----
        if (testConceptId == CD4_Cell_Count_Concept_Id) {
            obs = extractObsByConceptId(CD4_Cell_Count_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setCD4CellCount(BigDecimal.valueOf(obs.getValueNumeric()));
            }
        }
        if (testConceptId == CD4_Percentage_Concept_Id) {
            obs = extractObsByConceptId(CD4_Percentage_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setCD4Percentage(BigDecimal.valueOf(obs.getValueNumeric()));
            }
        }
        if (testConceptId == CD4_LFA_Result_Concept_Id) {
            obs = extractObsByConceptId(CD4_LFA_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setCD4LFAResultCode(code);
            }
        }

        // ---- Glucose: only for the glucose test concept ----
        if (testConceptId == Random_Glucose_Concept_Id) {
            obs = extractObsByConceptId(Random_Glucose_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setRandomGlucose(BigDecimal.valueOf(obs.getValueNumeric()));
            }
        }

        // ---- Hepatitis B: each field gated on its own exact concept.
        // FIX: previously grouped, which would let an HBsAG antigen order also carry an
        // HBVViralLoad number (or vice versa) from a separate order in the same visit —
        // same class of bug as the CD4 fix above. ----
        if (testConceptId == HBsAG_Result_Concept_Id) {
            obs = extractObsByConceptId(HBsAG_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setHBsAGResultCode(code);
            }
        }
        if (testConceptId == HBV_Viral_Load_Concept_Id) {
            obs = extractObsByConceptId(HBV_Viral_Load_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setHBVViralLoad(BigDecimal.valueOf(obs.getValueNumeric()));
            }
        }

        // ---- Hepatitis C: each field gated on its own exact concept (same reasoning as HBV). ----
        if (testConceptId == HCV_Antibody_Result_Concept_Id) {
            obs = extractObsByConceptId(HCV_Antibody_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setHCVAntibodyResultCode(code);
            }
        }
        if (testConceptId == HCV_Viral_Load_Concept_Id) {
            obs = extractObsByConceptId(HCV_Viral_Load_Concept_Id, obsList);
            if (obs != null && obs.getValueNumeric() != null) {
                lor.setHCVViralLoad(BigDecimal.valueOf(obs.getValueNumeric()));
            }
        }

        // ---- Syphilis: only for the VDRL test concept ----
        if (testConceptId == VDRL_Syphilis_Result_Concept_Id) {
            obs = extractObsByConceptId(VDRL_Syphilis_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setVDRLSyphilisResultCode(code);
            }
        }

        // ---- Cryptococcal / CNS: only for the matching CrAg test concept ----
        if (testConceptId == Serology_For_CrAg_Result_Concept_Id) {
            obs = extractObsByConceptId(Serology_For_CrAg_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setSerologyForCrAgResultCode(code);
            }
        }
        if (testConceptId == CSF_For_CrAg_Result_Concept_Id) {
            obs = extractObsByConceptId(CSF_For_CrAg_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setCSFForCrAgResultCode(code);
            }
        }

        // ---- TB-LAM: only for the TB-LFLAM test concept ----
        if (testConceptId == TB_LFLAM_Result_Concept_Id) {
            obs = extractObsByConceptId(TB_LFLAM_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setTBLFLAMResultCode(code);
            }
        }

        // ---- HPV: only for the HPV test concept ----
        if (testConceptId == HPV_Result_Concept_Id) {
            obs = extractObsByConceptId(HPV_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueCoded() != null) {
                String code = getMappedAnswerValue(obs.getValueCoded().getConceptId());
                if (code != null && !code.isEmpty()) lor.setHPVResultCode(code);
            }
        }

        // ---- Cytology / Urinalysis: only for their own test concepts (free-form text) ----
        if (testConceptId == Cytology_VIA_PapSmear_Result_Concept_Id) {
            obs = extractObsByConceptId(Cytology_VIA_PapSmear_Result_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setCytologyVIAPapSmearResult(obs.getValueText());
        }
        if (testConceptId == Urinalysis_Concept_Id) {
            obs = extractObsByConceptId(Urinalysis_Concept_Id, obsList);
            if (obs != null && obs.getValueText() != null) lor.setUrinalysis(obs.getValueText());
        }
    }


}
