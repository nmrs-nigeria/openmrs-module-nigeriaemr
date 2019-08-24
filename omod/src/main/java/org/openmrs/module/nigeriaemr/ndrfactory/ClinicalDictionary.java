package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.model.ndr.CodedSimpleType;
import org.openmrs.module.nigeriaemr.model.ndr.HIVEncounterType;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

public class ClinicalDictionary {

    public final static int Weight_Concept_Id = 5089,
            Child_Height_Concept_Id = 5090,
            Patient_Family_Planning_Method_Code_Concept_Id = 4,
            Noted_Side_Effects_Concept_Id = 159935,
            //CD4_Concept_Id=6,
            //CD4_Test_Date_Concept_Id=7,
            Next_Appointment_Date_Concept_Id = 5096,
            Systolic_Blood_Pressure_Concept_Id = 5085,
            Dystolic_Blood_Pressure_Concept_Id = 5086,
            Pregnancy_Breastfeeding_Status_Concept_Id = 165050,
            Patient_Family_Planning_Concept_Id = 5271,
            Functional_Status_Concept_Id = 165039,
            WHO_Clinical_Stage_Concept_Id = 5356,
            TB_Status_Concept_Id = 1659,
            Other_OI_Other_Problem_Concept_Id = 1728,
            ARV_Drug_Adherence_Concept_Id = 165290,
            Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id = 19,
            Cotrimoxazole_Dose_Concept_Id = 20,
            Cotrimoxazole_Adherence_Concept_Id = 161652,
            Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id = 22,
            INH_Dose_Concept_Id = 23,
            INH_Adherence_Concept_Id = 161653,
            Why_Poor_Fair_INH_Drug_Adherence_Concept_Id = 25;

    private Map<Integer, String> map = new HashMap<>();

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

        map.put(1204,"1");
        map.put(1205,"2");
        map.put(1206,"3");
        map.put(1207,"4");

        map.put(1220,"I");//pediatric
        map.put(1221,"II");
        map.put(1222,"III");
        map.put(1223,"IV");

        //Family planning
        map.put(190,"FP1");
        map.put(780,"FP2");
        map.put(5279,"FP3");
        map.put(5278,"FP4");
        map.put(5275,"FP5");
        map.put(1489,"FP6");

        //TB Status
        map.put(1660,"1");
        map.put(142177,"2");
        map.put(1662,"3");
        map.put(1661,"5");
        map.put(1663,"4");

        //OTHER OI
        map.put(117543,"1");
        map.put(114100,"2");
        map.put(119566,"3");
        map.put(5334,"4");
        map.put(140238,"5");
        map.put(143264,"6");

        //Noted_Side_Effects_Concept_Id
        map.put(133473,"1");
        map.put(139084,"2");
        map.put(119566,"3");
        map.put(5226,"4");
       // map.put(5229,"4");
        map.put(512,"6");
        map.put(165052,"7");
        map.put(121629,"8");
        map.put(165053,"9");
        map.put(125886,"10");
        map.put(138291,"11");



    }

    private String getMappedValue(int conceptID) {
        if (map.containsKey(conceptID)) {
            return map.get(conceptID);
        }
        return null;
    }


    public HIVEncounterType createHIVEncounterType(Patient patient, Encounter enc, List<Obs> obsList)
            throws DatatypeConfigurationException {

        HIVEncounterType hivEncounter = new HIVEncounterType();
        

        Date artStartDate = Utils.getARTStartDate(patient);

        String visitID = Utils.getVisitId(patient, enc);
        hivEncounter.setVisitID(visitID);
        hivEncounter.setVisitDate(Utils.getXmlDate(enc.getEncounterDatetime()));

        if (artStartDate != null && (enc.getEncounterDatetime().after(artStartDate) || enc.getEncounterDatetime().equals(artStartDate))) {
            Calendar startCalendar = new GregorianCalendar();
            startCalendar.setTime(enc.getEncounterDatetime());
            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(artStartDate);

            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            int monthOnART = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH); //enc.getEncounterDatetime().getMonth() - artStartDate.getMonth(); // Months.monthsBetween(d1, d2).getMonths();
            hivEncounter.setDurationOnArt(monthOnART);
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
                            if(obs.getValueBoolean() != null){
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
                            try{
                                LoggerUtils.write(ClinicalDictionary.class.getName(), "About to pull Other_OI_Other_Problem_Concept_Id", LogFormat.FATAL, LogLevel.debug);
                                value_coded = obs.getValueCoded().getConceptId();
                                hivEncounter.setOtherOIOtherProblems(getMappedValue(value_coded));
                                LoggerUtils.write(ClinicalDictionary.class.getName(), "Finished pulling Other_OI_Other_Problem_Concept_Id", LogFormat.FATAL, LogLevel.debug);

                            }catch (Exception ex){

                            }

                            break;
                        case Noted_Side_Effects_Concept_Id:

                            value_coded = obs.getValueCoded().getConceptId();
                            hivEncounter.setNotedSideEffects(getMappedValue(value_coded));

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

                    /*case ARV_Drug_Regimen_Concept_Id:
					value_coded = obs.getValueCoded().getConceptId();
					cst = new CodedSimpleType();
					cst.setCode(getMappedValue(value_coded));
					cst.setCodeDescTxt(obs.getValueCodedName().getName());
					hivEncounter.setARVDrugRegimen(cst);
					break;*/
 /*case CD4_Concept_Id:
					value_numeric = (int) Math.round(obs.getValueNumeric());
					hivEncounter.setCD4(value_numeric);
					break;
				case CD4_Test_Date_Concept_Id:
					value_datetime = obs.getValueDatetime();
					hivEncounter.setCD4TestDate(Utils.getXmlDate(value_datetime));
					break;*/
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
        return hivEncounter;
    }


    private String resolvePatientFamilyPlanningCode(Boolean value){

        if(value){
            return "FP";
        }else{
            return "NOFP";
        }
    }



}
