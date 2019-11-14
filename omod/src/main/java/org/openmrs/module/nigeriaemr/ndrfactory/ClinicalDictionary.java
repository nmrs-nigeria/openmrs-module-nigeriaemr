package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.*;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.CodedSimpleType;
import org.openmrs.module.nigeriaemr.model.ndr.HIVEncounterType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

public class ClinicalDictionary {

    public final static int Weight_Concept_Id = 5089,
            Child_Height_Concept_Id = 5090,
            Patient_Family_Planning_Method_Code_Concept_Id = 374,
            Noted_Side_Effects_Concept_Id = 159935,
            CD4_Concept_Id = 6,
            CD4_Test_Date_Concept_Id = 7,
            Next_Appointment_Date_Concept_Id = 5096,
            Systolic_Blood_Pressure_Concept_Id = 5085,
            Dystolic_Blood_Pressure_Concept_Id = 5086,
            Pregnancy_Breastfeeding_Status_Concept_Id = 165050,
            Patient_Family_Planning_Concept_Id = 5271,
            Functional_Status_Concept_Id = 165039,
            WHO_Clinical_Stage_Concept_Id = 5356,
            TB_Status_Concept_Id = 1659,
            Other_OI_Other_Problem_Concept_Id = 160170,
            ARV_Drug_Adherence_Concept_Id = 165290,
            Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id = 19,
            Cotrimoxazole_Dose_Concept_Id = 20,
            Cotrimoxazole_Adherence_Concept_Id = 161652,
            Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id = 22,
            INH_Dose_Concept_Id = 23,
            INH_Adherence_Concept_Id = 161653,
            Why_Poor_Fair_INH_Drug_Adherence_Concept_Id = 25;

    private Map<Integer, String> map = new HashMap<>();

    private StringJoiner notedSide_Effects = new StringJoiner(",");
    private StringJoiner otherOI_Effects = new StringJoiner(",");

    public ClinicalDictionary() {
        loadDictionary();
        //  FileHandler handler = LoggerUtils.getHandler();
        // logger.addHandler(handler);

    }

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        map.put(123, "12");
        //adherence
        map.put(165289, "P");
        map.put(165287, "G");
        map.put(165288, "F");
        //encounter type WHO clinical stage concept

        map.put(1204, "1");
        map.put(1205, "2");
        map.put(1206, "3");
        map.put(1207, "4");

        map.put(1220, "I");//pediatric
        map.put(1221, "II");
        map.put(1222, "III");
        map.put(1223, "IV");

        //Family planning
        map.put(190, "FP1");
        map.put(780, "FP2");
        map.put(5279, "FP3");
        map.put(5278, "FP4");
        map.put(5275, "FP5");
        map.put(1489, "FP6");

        //TB Status
        map.put(1660, "1");
        map.put(142177, "2");
        map.put(1662, "3");
        map.put(1661, "5");
        map.put(1663, "4");

        //OTHER OI
        map.put(117543, "1");
        map.put(114100, "2");
        map.put(119566, "3");
        map.put(5334, "4");
        map.put(140238, "5");
        map.put(143264, "6");

        //Noted_Side_Effects_Concept_Id
        map.put(133473, "1");
        map.put(139084, "2");
        map.put(119566, "3");
        map.put(116743,"3");
        map.put(5226, "4");
        map.put(165767,"5");
        map.put(512, "6");
        map.put(165052, "7");
        map.put(121629, "8");
        map.put(165053, "9");
        map.put(125886, "10");
        map.put(138291, "11");

        //functional status
        map.put(159468, "W");
        map.put(160026, "A");
        map.put(162752, "B");

        //ARV Drug Adherence
        map.put(165287, "G");
        map.put(165288, "P");
        map.put(165289, "F");
        map.put(160124, "1a");//"AZT-3TC-EFV"
        map.put(1652, "1b");//"AZT-3TC-NVP"
        map.put(104565, "1c");//"TDF-FTC-EFV"
        map.put(164854, "1d");//"TDF-FTC-NVP"
        map.put(164505, "1e"); //"TDF-3TC-EFV"
        map.put(162565, "1f");//"TDF-3TC-NVP"
        map.put(817, "1g"); //"AZT-3TC-ABC" same as ABC/3TC/AZT
        map.put(165522, "1h"); //"AZT-3TC-TDF” same as TDF-3TC-AZT
        map.put(162563, "1l"); //"ABC-3TC-EFV"
        map.put(165681, "1m"); //"TDF-3TC-DTG"
        map.put(165686, "1n"); //"TDF-3TC-EFV400"
        map.put(165682, "1o"); //"TDF-FTC-DTG"
        map.put(165687, "1p"); //"TDF-FTC-EFV400"
        map.put(165523, "2a"); //"TDF-FTC-LPV/r"
        map.put(162201, "2b");//"TDF-3TC-LPV/r"
        map.put(165524, "2c"); //"TDF-FTC-ATV/r"
        map.put(164512, "2d");//"TDF-3TC-ATV/r"
        map.put(162561, "2e");//"AZT-3TC-LPV/r"
        map.put(164511, "2f");//"AZT-3TC-ATV/r"
        map.put(165530, "2h");//"AZT-TDF-3TC-LPV/r"
        map.put(165537, "2i");//"TDF-AZT-3TC-ATV/r"
        map.put(165688, "3a ");//"DRV/r-DTG + 1-2 NRTIs"
        map.put(160124, "4a");//"AZT-3TC-EFV"
        map.put(1652, "4b");//"AZT-3TC-NVP"
        map.put(162563, "4c");//"ABC-3TC-EFV"
        map.put(162199, "4d");//"ABC-3TC-NVP"
        map.put(817, "4e");//"AZT-3TC-ABC" Same as ABC-3TC-AZT
        map.put(792, "4f");//"d4T-3TC-NVP"
        map.put(166074, "4g"); // Nelson Added Concept in NigeriaMRS and mapped it here as code already exist on NDR.
        map.put(165691, "4h"); //ABC-3TC-DTG
        map.put(165693, "4i"); //ABC-3TC-EFV400
        map.put(162200, "4j"); //ABC-3TC-LPV/r
        map.put(165692, "4k"); //ABC-FTC-DTG
        map.put(165694, "4l"); //ABC-FTC-EFV400
        map.put(165690, "4m"); //ABC-FTC-NVP
        map.put(162561, "4n"); //AZT-3TC-LPV/r
        map.put(165695, "4o");//AZT-3TC-RAL
        map.put(165681, "4p"); //TDF-3TC-DTG
        map.put(164505, "4q"); //TDF-3TC-EFV// Add PrescribedRegimenCode and Code Description in NDR
        map.put(165686, "4r"); //TDF-3TC-EFV400
        map.put(162565, "4s"); // TDF-3TC-NVP
        map.put(165682, "4t"); // TDF-FTC-DTG
        map.put(104565, "4u"); //TDF-FTC-EFV
        map.put(165687, "4v"); // TDF-FTC-EFV400
        map.put(164854, "4w");// TDF-FTC-NVP
        map.put(162200, "5a");;//"ABC-3TC-LPV/r"
        map.put(162561, "5b");;//"AZT-3TC-LPV/r"
        map.put(162560, "5c");;//"d4T-3TC-LPV/r"
        map.put(165526, "5e");;//"ABC-3TC-ddi"
        map.put(165696, "5g");//ABC-3TC-RAL
        map.put(164511, "5h"); // AZT-3TC-ATV/r
        map.put(165695, "5i");  //AZT-3TC-RAL
        map.put(164512, "5j"); //TDF-3TC-ATV/r
        map.put(162201, "5k");//TDF-3TC-LPV/r
        map.put(165698, "6a"); //DRV/r + 2 NRTIs + 2 NNRTI
        map.put(165700, "6b"); //DRV/r +2NRTIs
        map.put(165688, "6c"); //DRV/r-DTG + 1-2 NRTIs
        map.put(165701, "6d"); //DRV/r-RAL + 1-2NRTIs
        map.put(165697, "6e"); //DTG+2 NRTIs
        map.put(165699, "6f"); //RAL + 2 NRTIs
        map.put(86663, "9a");//"AZT" Concept ID didnt match. So, Changed concept id from 26 to 86663 as defined In NMRS
        map.put(78643, "9b");//3TC Concept ID didnt match. So, changed ID from 27 to 78643 as defined In NMRS
        map.put(80586, "9c");//"NVP" Concept ID didnt match. So, Changed concept id from 28 to 80586 as defined in NMRS
        map.put(630, "9d");//"AZT-3TC" Concept ID didnt match. So, Changed concept id from 29 to 630 as defined on NMRS
        map.put(165544, "9e");//"AZT-NVP" Concept ID didnt match. So, Changed concept id from 30 to 165544 as defined in NMRS
        map.put(104567, "9f");//"FTC-TDF" Concept ID didnt match. So, Changed concept id from 31 to 104567 as defined in NMRS
        map.put(161363, "9g");//"3TC-d4T"  Concept ID didnt match. So, Changed concept id from 32 to 104567 as defined in NMRS
        map.put(166075, "9h"); //"3TC-d4T" Changed the code desc from 3TC-4DT to 3TC-NVP and Created new concept for it on NMRS and replaced the initial Concpet Id of 33 to 166075
        map.put(161364, "Unknown NDR Code APINSs Instance");//TDF/3TC Missing Drug Combination without NDR Code
        map.put(165631, "Missing NDR Code from IHVN Instance"); //Dolutegravir
        map.put(1674, "Missing NDR Code frm IHVN Instance");//RIFAMPICIN/ISONIAZID/PYRAZINAMIDE/ETHAMBUTOL PROPHYLAXIS

    }

    private String getMappedValue(int conceptID) {
        if (map.containsKey(conceptID)) {
            return map.get(conceptID);
        }
        return null;
    }

    /*
         Completed
     */
    List<HIVEncounterType> createHIVEncounterType(Patient patient, List<Encounter> allPatientEncounterList, List<Obs> allPatientObsList) throws DatatypeConfigurationException {

        List<HIVEncounterType> hivEncounterTypeList = new ArrayList<>();
        HIVEncounterType hivEncounterType = null;
        //Turn these to class level constants letter
        Integer[] encounterTypeArr = {
            Utils.ADULT_INITIAL_ENCOUNTER_TYPE,
            Utils.LAB_ORDER_AND_RESULT_ENCOUNTER_TYPE,
            Utils.PHARMACY_ENCOUNTER_TYPE,
            Utils.CARE_CARD_ENCOUNTER_TYPE};
        Set<Date> visitDateSet = Utils.extractUniqueVisitsForEncounterTypes(patient, allPatientEncounterList, encounterTypeArr);

        Date artStartDate = Utils.extractARTStartDate(patient, allPatientObsList);//Optimize for performance
        for (Date date : visitDateSet) {
            List<Obs> obsPerVisitDate = Utils.extractObsPerVisitDate(date, allPatientObsList);
            if (obsPerVisitDate != null && !obsPerVisitDate.isEmpty()) {
                hivEncounterType = createHIVEncounterType(patient, date, obsPerVisitDate, artStartDate);
            }
            hivEncounterTypeList.add(hivEncounterType);
        }
        return hivEncounterTypeList;
    }

    public HIVEncounterType createHIVEncounterType(Patient patient, Date visitDate, List<Obs> obsListForOneVisit, Date artStartDate)
            throws DatatypeConfigurationException {

        String ndrCode="";
        int valueCoded;

        CodedSimpleType codedSimpleType;
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        //Check for nulls before calling these methods

        String pepfarID = pepfarIdentifier.getIdentifier();
        String visitID = Utils.getVisitId(pepfarID, visitDate);
        HIVEncounterType hivEncounterType = new HIVEncounterType();
        hivEncounterType.setVisitID(visitID);
        hivEncounterType.setVisitDate(Utils.getXmlDate(visitDate));
        //artStartDate=Utils.extractARTStartDate(patient, allObsForPatient);
        if (artStartDate != null) {
          int  monthsOnARV = Utils.getDateDiffInMonth(artStartDate, visitDate);
            hivEncounterType.setDurationOnArt(monthsOnARV);
        }
        Obs obs = Utils.extractObs(Utils.WEIGHT_CONCEPT, obsListForOneVisit); // Weight
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setWeight(obs.getValueNumeric().intValue());
        }
        obs = Utils.extractObs(Utils.CHILD_HEIGHT_CONCEPT, obsListForOneVisit); // Height
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setChildHeight(obs.getValueNumeric().intValue());
        }
        Obs obsSystolic = Utils.extractObs(Utils.BLOOD_PRESSURE_SYSTOLIC_CONCEPT, obsListForOneVisit);
        Obs obsDystolic = Utils.extractObs(Utils.BLOOD_PRESSURE_DYSTOLIC_CONCEPT, obsListForOneVisit);
        if (obsSystolic != null && obsSystolic.getValueNumeric() != null && obsDystolic != null && obsDystolic.getValueNumeric() != null) {
            String  systolicBP = String.valueOf(obsSystolic.getValueNumeric().intValue());
            String  diastolicBP = String.valueOf(obsDystolic.getValueNumeric().intValue());
            String  bloodPressure = StringUtils.join(systolicBP, "/", diastolicBP);
            hivEncounterType.setBloodPressure(bloodPressure);
        }
        obs = Utils.extractObs(Utils.PREGNANCY_BREASTFEEDING_CONCEPT, obsListForOneVisit);
        //Verify that all value coded concepts has been mapped
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setEDDandPMTCTLink(ndrCode);
        }
        obs = Utils.extractObs(Utils.FAMILY_PLANNING_STATUS_CONCEPT, obsListForOneVisit);
        //Does False Mean Not on Family Planning

        if (obs != null && obs.getValueCoded() != null) {
            if (obs.getValueCoded().getConceptId() == Utils.Yes_Concept_Id) {
                hivEncounterType.setPatientFamilyPlanningCode("FP");

                //Verify that all family planning methods are mapped
                obs = Utils.extractObs(Utils.FAMILY_PLANNING_METHOD_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setPatientFamilyPlanningMethodCode(ndrCode);
                }
            }else {
                hivEncounterType.setPatientFamilyPlanningCode("NOFP");
            }
                obs = Utils.extractObs(Utils.FUNCTIONAL_STATUS_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setFunctionalStatus(ndrCode);
                }
                obs = Utils.extractObs(Utils.WHO_CLINICAL_STAGE_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setWHOClinicalStage(ndrCode);
                }
                obs = Utils.extractObs(Utils.TB_STATUS_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setTBStatus(ndrCode);
                }
                //How do we extract multiple OIs per encounter
            List<Obs> obsL = Utils.extractObsList(Utils.OTHER_OI_OTHER_PROBLEMS, obsListForOneVisit);
                if (!obsL.isEmpty()) {
                    for (Obs ob : obsL) {
                        if (ob != null && ob.getValueCoded() != null) {
                            valueCoded = ob.getValueCoded().getConceptId();
                            otherOI_Effects.add(getMappedValue(valueCoded));
                        }
                    }
                    hivEncounterType.setOtherOIOtherProblems(otherOI_Effects.toString());
                }
                //  obs = Utils.extractObs(Utils.NOTED_SIDE_EFFECT_CONCEPT, obsListForOneVisit);
                obsL = Utils.extractObsList(Utils.NOTED_SIDE_EFFECT_CONCEPT, obsListForOneVisit);
                if (!obsL.isEmpty()) {
                    for (Obs ob : obsL) {
                        if (ob != null && ob.getValueCoded() != null) {

                            valueCoded = ob.getValueCoded().getConceptId();
                            notedSide_Effects.add(getMappedValue(valueCoded));
                        }
                    }
                    hivEncounterType.setNotedSideEffects(notedSide_Effects.toString());
                }
                obs = Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT, obsListForOneVisit);

                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    obs = Utils.extractObs(valueCoded, obsListForOneVisit);
                    if (obs != null && obs.getValueCoded() != null) {
                        valueCoded = obs.getValueCoded().getConceptId();
                        String  regimenName = obs.getValueCoded().getName().getName();
                        ndrCode = getMappedValue(valueCoded);
                        codedSimpleType = new CodedSimpleType();
                        codedSimpleType.setCode(ndrCode);
                        codedSimpleType.setCodeDescTxt(regimenName);
                        hivEncounterType.setARVDrugRegimen(codedSimpleType);
                    }
                }

                //Get the drugs that was entered for the day
                obs = Utils.extractObs(Utils.OI_DRUGS_GROUPING_CONCEPT_SET, obsListForOneVisit);
                if (obs != null) {

                    Set<Obs> obsGroupMembersSet = obs.getGroupMembers();
                    List<Obs> obsGroupMembersList = new ArrayList<>(obsGroupMembersSet);
                    Obs  oiDrugNameObs = Utils.extractObsByValues(Utils.OI_DRUGS_CONCEPT, Utils.COTRIMOXAZOLE_DRUG_CONCEPT, obsGroupMembersList);
                    // What to do if they select wrong strength for CTX
                    if (oiDrugNameObs != null) {
                      Obs  oiStrengthObs = Utils.extractObs(Utils.ARV_DRUG_STRENGTH_CONCEPT, obsGroupMembersList);
                        if (oiStrengthObs != null && oiStrengthObs.getValueCoded() != null) {
                            valueCoded = oiStrengthObs.getValueCoded().getConceptId();
                            switch (valueCoded) {
                                case Utils.STRENGTH_240MG:
                                    ndrCode = "CTX240";
                                    break;
                                case Utils.STRENGTH_480MG:
                                    ndrCode = "CTX480";
                                    break;
                                case Utils.STRENGTH_960MG:
                                    ndrCode = "CTX960";
                                    break;
                                default:
                                    ndrCode = "CTX960";
                                    break;
                            }
                        }
                        codedSimpleType = new CodedSimpleType();
                        codedSimpleType.setCode(ndrCode);
                        codedSimpleType.setCodeDescTxt(ndrCode);
                        hivEncounterType.setCotrimoxazoleDose(codedSimpleType);
                    }
                }
                obs = Utils.extractObs(Utils.COTRIMOXAZOLE_ADHERENCE_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setCotrimoxazoleAdherence(ndrCode);
                }
                obs = Utils.extractObs(Utils.INH_ADHERENCE_CONCEPT, obsListForOneVisit);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivEncounterType.setINHAdherence(ndrCode);
                }
                obs = Utils.extractObs(Utils.CD4_COUNT_CONCEPT, obsListForOneVisit);

                if (obs != null && obs.getValueNumeric() != null) {
                    int  cd4Count = obs.getValueNumeric().intValue();
                    hivEncounterType.setCD4(cd4Count);
                    hivEncounterType.setCD4TestDate(Utils.getXmlDate(obs.getObsDatetime()));
                }
                DateTime nextAppointmentDate = Utils.extractMedicationDuration(visitDate, obsListForOneVisit);
                if (nextAppointmentDate != null) {
                    hivEncounterType.setNextAppointmentDate(Utils.getXmlDate(nextAppointmentDate.toDate()));
                }
            }
        return hivEncounterType;
    }

/*
    public HIVEncounterType createHIVEncounterType(Patient patient, Encounter enc, List<Obs> obsList)
            throws DatatypeConfigurationException {

        HIVEncounterType hivEncounter = new HIVEncounterType();

        Date artStartDate = Utils.getARTStartDate(patient);

        String visitID = Utils.getVisitId(patient, enc);
        hivEncounter.setVisitID(visitID);
        hivEncounter.setVisitDate(Utils.getXmlDate(enc.getEncounterDatetime()));

        Date EnrollmentDate = Utils.getHIVEnrollmentDate(patient);
        Date dateOfLastReport = enc.getEncounterDatetime();

        if (dateOfLastReport != null && artStartDate !=null && (dateOfLastReport.after(artStartDate) || dateOfLastReport.equals(artStartDate))) {

            Period period = Period.between(new java.sql.Date(dateOfLastReport.getTime()).toLocalDate(), new java.sql.Date(EnrollmentDate.getTime()).toLocalDate());
            int diff = period.getMonths();
            hivEncounter.setDurationOnArt(diff);
        }

        int conceptID;
        int value_numeric;
        int value_coded;
        Date value_datetime;
        String SystolicBloodPressure = "";
        String DistolicBloodPressure = "";
        CodedSimpleType cst;

        for (Obs obs : obsList) {
            try {
                conceptID = obs.getConcept().getConceptId();

                //   if (patient.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX) != null) {
                switch (conceptID) {
                    case Child_Height_Concept_Id:

                        value_numeric = (int) Math.round(obs.getValueNumeric());
                        hivEncounter.setChildHeight(value_numeric);

                        break;
                    case Weight_Concept_Id:

                        value_numeric = (int) Math.round(obs.getValueNumeric());
                        hivEncounter.setWeight(value_numeric);

                        break;
                    case Systolic_Blood_Pressure_Concept_Id:

                        SystolicBloodPressure = String.valueOf((int) Math.round(obs.getValueNumeric()));

                        break;
                    case Dystolic_Blood_Pressure_Concept_Id:

                        DistolicBloodPressure = String.valueOf((int) Math.round(obs.getValueNumeric()));

                        break;
                    case Pregnancy_Breastfeeding_Status_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Pregnancy_Breastfeeding_Status_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setEDDandPMTCTLink(getMappedValue(value_coded));

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Pregnancy_Breastfeeding_Status_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Patient_Family_Planning_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Patient_Family_Planning_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        if (obs.getValueBoolean() != null) {
                            hivEncounter.setPatientFamilyPlanningCode(resolvePatientFamilyPlanningCode(obs.getValueBoolean()));
                        }

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Patient_Family_Planning_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Patient_Family_Planning_Method_Code_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Patient_Family_Planning_Method_Code_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();

                        hivEncounter.setPatientFamilyPlanningMethodCode(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Patient_Family_Planning_Method_Code_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Functional_Status_Concept_Id:
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Functional_Status_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setFunctionalStatus(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Functional_Status_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case WHO_Clinical_Stage_Concept_Id:
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull WHO_Clinical_Stage_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setWHOClinicalStage(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling WHO_Clinical_Stage_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case TB_Status_Concept_Id:

                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setTBStatus(getMappedValue(value_coded));

                        break;
                    case Other_OI_Other_Problem_Concept_Id:
                        try {
                            LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Other_OI_Other_Problem_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                            value_coded = obs.getValueCoded().getConceptId();
                            otherOI_Effects.add(getMappedValue(value_coded));
                            // hivEncounter.setOtherOIOtherProblems(getMappedValue(value_coded));
                            LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Other_OI_Other_Problem_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }

                        break;
                    case Noted_Side_Effects_Concept_Id:

                        value_coded = obs.getValueCoded().getConceptId();
                        notedSide_Effects.add(getMappedValue(value_coded));
                        //  hivEncounter.setNotedSideEffects(getMappedValue(value_coded));

                        break;

                    case ARV_Drug_Adherence_Concept_Id:
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull ARV_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setARVDrugAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling ARV_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id:
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setWhyPoorFairARVDrugAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Cotrimoxazole_Dose_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Cotrimoxazole_Dose_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        cst = new CodedSimpleType();
                        cst.setCode(getMappedValue(value_coded));
                        cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        hivEncounter.setCotrimoxazoleDose(cst);
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Cotrimoxazole_Dose_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Cotrimoxazole_Adherence_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Cotrimoxazole_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setCotrimoxazoleAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Cotrimoxazole_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setWhyPoorFairCotrimoxazoleDrugAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case INH_Dose_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull INH_Dose_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        cst = new CodedSimpleType();
                        cst.setCode(getMappedValue(value_coded));
                        cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        hivEncounter.setINHDose(cst);
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling INH_Dose_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case INH_Adherence_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull INH_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setINHAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling INH_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Why_Poor_Fair_INH_Drug_Adherence_Concept_Id:

                        LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Why_Poor_Fair_INH_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                        value_coded = obs.getValueCoded().getConceptId();
                        hivEncounter.setWhyPoorFairINHDrugAdherence(getMappedValue(value_coded));
                        LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Why_Poor_Fair_INH_Drug_Adherence_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                        break;
                    case Next_Appointment_Date_Concept_Id:

                        value_datetime = obs.getValueDate();
                        hivEncounter.setNextAppointmentDate(Utils.getXmlDate(value_datetime));

                        break;
                    default:
                        break;
                }
                //  }

                switch (conceptID) {
                    case CD4_Concept_Id:
                        value_numeric = (int) Math.round(obs.getValueNumeric());
                        hivEncounter.setCD4(value_numeric);
                        break;
                    case CD4_Test_Date_Concept_Id:
                        value_datetime = obs.getValueDatetime();
                        hivEncounter.setCD4TestDate(Utils.getXmlDate(value_datetime));
                        break;
                    default:
                        break;
                }

            } catch (Exception ex) {
                LoggerUtils.write(ClinicalDictionary.class.getName(), Arrays.toString(ex.getStackTrace()), LogFormat.FATAL, LogLevel.live);
                throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
            }
        }

        if (StringUtils.isNotEmpty(SystolicBloodPressure) && StringUtils.isNotEmpty(DistolicBloodPressure)) {
            String bp = SystolicBloodPressure + "/" + DistolicBloodPressure;
            hivEncounter.setBloodPressure(bp);
        }

        if (otherOI_Effects.length() > 0) {
            hivEncounter.setOtherOIOtherProblems(otherOI_Effects.toString());
        }

        if (notedSide_Effects.length() > 0) {
            hivEncounter.setNotedSideEffects(notedSide_Effects.toString());
        }

        return hivEncounter;
    }
*/
    /*private String resolvePatientFamilyPlanningCode(Boolean value) {

        if (value) {
            return "FP";
        } else {
            return "NOFP";
        }
    }
*/
}
