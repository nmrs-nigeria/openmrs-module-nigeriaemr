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
    }

    private void loadOtherCodedValues() {
        CodedAnswerDictionary = new HashMap<>();
        //visit type
        CodedAnswerDictionary.put(160530, "R"); //repeat
        CodedAnswerDictionary.put(164180, "B"); //baseline

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
            if (laboratoryOrderAndResultList.size() > 0) {
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

    private List<LaboratoryOrderAndResult> createLaboratoryOrderAndResult(Encounter enc,  List<Obs>  obsList)
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
                    labOrderAndResult.setLaboratoryTestTypeCode(String.valueOf(ndrCodedValue));

                    LoggerUtils.write(LabDictionary.class.getName(), "About to pull Laboratory_Result_TEST", LogFormat.FATAL, LogLevel.debug);
                    cst.setCode(Integer.toString(ndrCodedValue));
                    cst.setCodeDescTxt(obs.getConcept().getName().getName());
                    labOrderAndResult.setLaboratoryResultedTest(cst);
                    LoggerUtils.write(LabDictionary.class.getName(), "Finished pulling Laboratory_Result_TEST", LogFormat.FATAL, LogLevel.debug);

                    if (obs.getValueNumeric() != null) {
                        numeric = new NumericType();
                        numeric.setValue1(obs.getValueNumeric().intValue());
                    }

                    if (orderedDate != null) {
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(orderedDate));
                    }else{
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }
//                    labOrderAndResult.setResultedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));

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

                    if(numeric != null) {
                        answer = new AnswerType();
                        answer.setAnswerNumeric(numeric);
                        labOrderAndResult.setLaboratoryResult(answer);
                        labOrderAndResult.setResultedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }
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
                    labOrderAndResult.setLaboratoryTestTypeCode(String.valueOf(ndrCodedValue));
                    cst.setCode(Integer.toString(ndrCodedValue));
                    cst.setCodeDescTxt(obs.getConcept().getName().getName());
                    labOrderAndResult.setLaboratoryResultedTest(cst);

                    //get the answer
                    CodedType ct = null;
                    if (obs.getValueCoded() != null) {
                        ct = new CodedType();
                        ct.setCode(obs.getValueCoded().getName().getName());
                        ct.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        ct.setCodeSystemCode(obs.getValueCoded().getName().getName());
                    }

                    if(ct != null) {
                        answer = new AnswerType();
                        answer.setAnswerCode(ct);
                        labOrderAndResult.setLaboratoryResult(answer);
                        labOrderAndResult.setResultedTestDate(utils.getXmlDate(enc.getEncounterDatetime()));
                    }

                    if (orderedDate != null) {
                        labOrderAndResult.setOrderedTestDate(utils.getXmlDate(orderedDate));
                    }
                    labResultList.add(labOrderAndResult);
                } catch (Exception ex) {
                    LoggerUtils.write(LabDictionary.class.getName(), "Error in Coded_DataType_ConceptId: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
                }
            }
        }
        return labResultList;
    }
}
