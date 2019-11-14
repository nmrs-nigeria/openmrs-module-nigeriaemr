/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.CodedSimpleType;
import org.openmrs.module.nigeriaemr.model.ndr.RegimenType;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.getXmlDate;

public class PharmacyDictionary {

    //  Logger logger = Logger.getLogger(PharmacyDictionary.class);
    public final static int Medication_Duration_Concept_Id = 159368;

    public final static int TB_regimen_Concept_set = 165728;
    public final static int OI_regimen_Concept_set = 165726;
    public final static int OI_Drug_Concept_Id = 165727;
    //public final static int Prescribed_Regimen_Line_Concept_Id=165708;
    public final static int Prescribed_Regimen_Line_Concept_Id = 165724;
    public final static int Adult_Ist_Regimen_Line_Concept_Id = 164506;
    public final static int Pediatric_Ist_Regimen_Line_Concept_Id = 164507;
    public final static int Adult_2nd_Regimen_Line_Concept_Id = 164513;
    public final static int Pediatric_2nd_Regimen_Line_Concept_Id = 164514;
    public final static int Adult_3rd_Regimen_Line_Concept_Id = 165702;
    public final static int Pediatric_3rd_Regimen_Line_Concept_Id = 165703;
    public final static int Pick_Up_Reason_Concept_Id = 165774;
    public final static int switch_Indicator_Concept_Id = 165772;
    public final static int substitution_Indicator_Concept_Id = 165665;

    public PharmacyDictionary() {
        loadDictionary();
    }
    private Map<Integer, String> regimenMap = new HashMap<>();
    private Map<Integer, String> regimenCodeDescTextMap = new HashMap<>();

    /*
		Concept ID for regimen to be gotten from
     */
    public void loadDictionary() {
        //key is concept id, value is NDR coded value

        regimenMap.put(160124, "1a");//"AZT-3TC-EFV"
        regimenMap.put(1652, "1b");//"AZT-3TC-NVP"
        regimenMap.put(104565, "1c");//"TDF-FTC-EFV"
        regimenMap.put(164854, "1d");//"TDF-FTC-NVP"
        regimenMap.put(164505, "1e"); //"TDF-3TC-EFV"
        regimenMap.put(162565, "1f");//"TDF-3TC-NVP"
        regimenMap.put(817, "1g"); //"AZT-3TC-ABC" same as ABC/3TC/AZT
        regimenMap.put(165522, "1h"); //"AZT-3TC-TDF” same as TDF-3TC-AZT
        regimenMap.put(162563, "1l"); //"ABC-3TC-EFV"
        regimenMap.put(165681, "1m"); //"TDF-3TC-DTG"
        regimenMap.put(165686, "1n"); //"TDF-3TC-EFV400"
        regimenMap.put(165682, "1o"); //"TDF-FTC-DTG"
        regimenMap.put(165687, "1p"); //"TDF-FTC-EFV400"
        regimenMap.put(165523, "2a"); //"TDF-FTC-LPV/r"
        regimenMap.put(162201, "2b");//"TDF-3TC-LPV/r"
        regimenMap.put(165524, "2c"); //"TDF-FTC-ATV/r"
        regimenMap.put(164512, "2d");//"TDF-3TC-ATV/r"
        regimenMap.put(162561, "2e");//"AZT-3TC-LPV/r"
        regimenMap.put(164511, "2f");//"AZT-3TC-ATV/r"
        regimenMap.put(165530, "2h");//"AZT-TDF-3TC-LPV/r"
        regimenMap.put(165537, "2i");//"TDF-AZT-3TC-ATV/r"
        regimenMap.put(165688, "3a ");//"DRV/r-DTG + 1-2 NRTIs"
        regimenMap.put(160124, "4a");//"AZT-3TC-EFV"
        regimenMap.put(1652, "4b");//"AZT-3TC-NVP"
        regimenMap.put(162563, "4c");//"ABC-3TC-EFV"
        regimenMap.put(162199, "4d");//"ABC-3TC-NVP"
        regimenMap.put(817, "4e");//"AZT-3TC-ABC" Same as ABC-3TC-AZT
        regimenMap.put(792, "4f");//"d4T-3TC-NVP"
        regimenMap.put(166074, "4g"); // Nelson Added Concept in NigeriaMRS and mapped it here as code already exist on NDR.
        regimenMap.put(165691, "4h"); //ABC-3TC-DTG
        regimenMap.put(165693, "4i"); //ABC-3TC-EFV400
        regimenMap.put(162200, "4j"); //ABC-3TC-LPV/r
        regimenMap.put(165692, "4k"); //ABC-FTC-DTG
        regimenMap.put(165694, "4l"); //ABC-FTC-EFV400
        regimenMap.put(165690, "4m"); //ABC-FTC-NVP
        regimenMap.put(162561, "4n"); //AZT-3TC-LPV/r
        regimenMap.put(165695, "4o");//AZT-3TC-RAL
        regimenMap.put(165681, "4p"); //TDF-3TC-DTG
        regimenMap.put(164505, "4q"); //TDF-3TC-EFV// Add PrescribedRegimenCode and Code Description in NDR
        regimenMap.put(165686, "4r"); //TDF-3TC-EFV400
        regimenMap.put(162565, "4s"); // TDF-3TC-NVP
        regimenMap.put(165682, "4t"); // TDF-FTC-DTG
        regimenMap.put(104565, "4u"); //TDF-FTC-EFV
        regimenMap.put(165687, "4v"); // TDF-FTC-EFV400
        regimenMap.put(164854, "4w");// TDF-FTC-NVP
        regimenMap.put(162200, "5a");;//"ABC-3TC-LPV/r"
        regimenMap.put(162561, "5b");;//"AZT-3TC-LPV/r"
        regimenMap.put(162560, "5c");;//"d4T-3TC-LPV/r"
        regimenMap.put(165526, "5e");;//"ABC-3TC-ddi"
        regimenMap.put(165696, "5g");//ABC-3TC-RAL
        regimenMap.put(164511, "5h"); // AZT-3TC-ATV/r
        regimenMap.put(165695, "5i");  //AZT-3TC-RAL
        regimenMap.put(164512, "5j"); //TDF-3TC-ATV/r
        regimenMap.put(162201, "5k");//TDF-3TC-LPV/r
        regimenMap.put(165698, "6a"); //DRV/r + 2 NRTIs + 2 NNRTI
        regimenMap.put(165700, "6b"); //DRV/r +2NRTIs
        regimenMap.put(165688, "6c"); //DRV/r-DTG + 1-2 NRTIs
        regimenMap.put(165701, "6d"); //DRV/r-RAL + 1-2NRTIs
        regimenMap.put(165697, "6e"); //DTG+2 NRTIs
        regimenMap.put(165699, "6f"); //RAL + 2 NRTIs
        regimenMap.put(86663, "9a");//"AZT" Concept ID didnt match. So, Changed concept id from 26 to 86663 as defined In NMRS
        regimenMap.put(78643, "9b");//3TC Concept ID didnt match. So, changed ID from 27 to 78643 as defined In NMRS
        regimenMap.put(80586, "9c");//"NVP" Concept ID didnt match. So, Changed concept id from 28 to 80586 as defined in NMRS
        regimenMap.put(630, "9d");//"AZT-3TC" Concept ID didnt match. So, Changed concept id from 29 to 630 as defined on NMRS
        regimenMap.put(165544, "9e");//"AZT-NVP" Concept ID didnt match. So, Changed concept id from 30 to 165544 as defined in NMRS
        regimenMap.put(104567, "9f");//"FTC-TDF" Concept ID didnt match. So, Changed concept id from 31 to 104567 as defined in NMRS
        regimenMap.put(161363, "9g");//"3TC-d4T"  Concept ID didnt match. So, Changed concept id from 32 to 104567 as defined in NMRS
        regimenMap.put(166075, "9h"); //"3TC-d4T" Changed the code desc from 3TC-4DT to 3TC-NVP and Created new concept for it on NMRS and replaced the initial Concpet Id of 33 to 166075
        regimenMap.put(161364, "Unknown NDR Code APINSs Instance");//TDF/3TC Missing Drug Combination without NDR Code
        regimenMap.put(165631, "Missing NDR Code from IHVN Instance"); //Dolutegravir
        regimenMap.put(1674, "Missing NDR Code frm IHVN Instance");//RIFAMPICIN/ISONIAZID/PYRAZINAMIDE/ETHAMBUTOL PROPHYLAXIS

		
 /*regimenMap.put(165257, "CTX480");
		regimenMap.put(76488, "UnknownCode");
		regimenMap.put(1679, "UnknownCode");
		regimenMap.put(80945, "UnknownCode"); */
        //Added By Nelson
        regimenMap.put(165257, "CTX480");//
        regimenMap.put(76488, "FLUC");//Added By Nelson
        regimenMap.put(1679, "H");
        regimenMap.put(80945, "CTX960");

        /* Added by Bright Ibezim */
        regimenMap.put(164506, "10");
        regimenMap.put(164513, "20");
        regimenMap.put(165702, "30");
        regimenMap.put(164507, "10");
        regimenMap.put(164514, "20");
        regimenMap.put(164703, "30");
        /* Added by Bright Ibezim Reason for substitusion and switch */
        regimenMap.put(102, "1");
        regimenMap.put(165048, "2");
        regimenMap.put(160559, "3");
        regimenMap.put(160567, "4");
        regimenMap.put(160561, "5");
        regimenMap.put(159834, "6");
        regimenMap.put(163523, "7");
        regimenMap.put(160566, "8");
        regimenMap.put(160569, "9");

        //key is concept id, value is NDR code text
        regimenCodeDescTextMap.put(160124, "AZT-3TC-EFV");
        regimenCodeDescTextMap.put(1652, "AZT-3TC-NVP");
        regimenCodeDescTextMap.put(104565, "DF-FTC-EFV");
        regimenCodeDescTextMap.put(164854, "TDF-FTC-NVP");
        regimenCodeDescTextMap.put(164505, "TDF-3TC-EFV");
        regimenCodeDescTextMap.put(162565, "TDF-3TC-NVP");
        regimenCodeDescTextMap.put(817, "AZT-3TC-ABC");
        regimenCodeDescTextMap.put(165522, "AZT-3TC-TDF");
        regimenCodeDescTextMap.put(162563, "ABC-3TC-EFV");
        regimenCodeDescTextMap.put(165681, "TDF-3TC-DTG");
        regimenCodeDescTextMap.put(165686, "TDF-3TC-EFV400");
        regimenCodeDescTextMap.put(165682, "TDF-FTC-DTG");
        regimenCodeDescTextMap.put(165687, "TDF-FTC-EFV400");
        regimenCodeDescTextMap.put(165523, "TDF-FTC-LPV/r");
        regimenCodeDescTextMap.put(162201, "TDF-3TC-LPV/r");
        regimenCodeDescTextMap.put(165524, "TDF-FTC-ATV/r");
        regimenCodeDescTextMap.put(164512, "TDF-3TC-ATV/r");
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(164511, "AZT-3TC-ATV/r");
        regimenCodeDescTextMap.put(165530, "AZT-TDF-3TC-LPV/r");
        regimenCodeDescTextMap.put(165537, "TDF-AZT-3TC-ATV/r");
        regimenCodeDescTextMap.put(165688, "DRV/r-DTG + 1-2 NRTIs");
        regimenCodeDescTextMap.put(160124, "AZT-3TC-EFV");
        regimenCodeDescTextMap.put(1652, "AZT-3TC-NVP");
        regimenCodeDescTextMap.put(162563, "ABC-3TC-EFV");
        regimenCodeDescTextMap.put(162199, "ABC-3TC-NVP");
        regimenCodeDescTextMap.put(817, "AZT-3TC-ABC");
        regimenCodeDescTextMap.put(792, "d4T-3TC-NVP");
        regimenCodeDescTextMap.put(165691, "ABC-3TC-DTG");
        regimenCodeDescTextMap.put(165693, "ABC-3TC-EFV400");
        regimenCodeDescTextMap.put(162200, "ABC-3TC-LPV/r");
        regimenCodeDescTextMap.put(165692, "ABC-FTC-DTG");
        regimenCodeDescTextMap.put(165694, "ABC-FTC-EFV400");
        regimenCodeDescTextMap.put(165690, "ABC-FTC-NVP");
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(165695, "AZT-3TC-RAL");
        regimenCodeDescTextMap.put(165681, "TDF-3TC-DTG");
        regimenCodeDescTextMap.put(164505, "TDF-3TC-EFV");
        regimenCodeDescTextMap.put(165686, "TDF-3TC-EFV400");
        regimenCodeDescTextMap.put(162565, "TDF-3TC-NVP");
        regimenCodeDescTextMap.put(165682, "TDF-FTC-DTG");
        regimenCodeDescTextMap.put(104565, "TDF-FTC-EFV");
        regimenCodeDescTextMap.put(165687, "TDF-FTC-EFV400");
        regimenCodeDescTextMap.put(164854, "TDF-FTC-NVP");
        regimenCodeDescTextMap.put(162200, "ABC-3TC-LPV/r");
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(162560, "d4T-3TC-LPV/r");
        regimenCodeDescTextMap.put(165526, "ABC-3TC-ddi");
        regimenCodeDescTextMap.put(165696, "ABC-3TC-RAL");
        regimenCodeDescTextMap.put(164511, "AZT-3TC-ATV/r");
        regimenCodeDescTextMap.put(165695, "AZT-3TC-RAL");
        regimenCodeDescTextMap.put(164512, "TDF-3TC-ATV/r");
        regimenCodeDescTextMap.put(162201, "TDF-3TC-LPV/r");
        regimenCodeDescTextMap.put(165698, "DRV/r + 2 NRTIs + 2 NNRTI");
        regimenCodeDescTextMap.put(165700, "DRV/r +2NRTIs");
        regimenCodeDescTextMap.put(165688, "DRV/r-DTG + 1-2 NRTIs");
        regimenCodeDescTextMap.put(165701, "DRV/r-RAL + 1-2 NRTIs");
        regimenCodeDescTextMap.put(165697, "DTG+2 NRTIs");
        regimenCodeDescTextMap.put(165699, "RAL + 2 NRTIs");
        regimenCodeDescTextMap.put(86663, "AZT");//"AZT" Concept ID didnt match. So, Changed concept id from 26 to 86663 as defined in NMRS
        regimenCodeDescTextMap.put(78643, "3TC");// 3TC Concept ID didnt match . So , Changed concept Id from 27 to 78643 as defined in NMRS
        regimenCodeDescTextMap.put(80586, "NVP");//"NVP" Concept ID didnt match. So, Changed concept id from 28 to 80586 as defined in NMRS
        regimenCodeDescTextMap.put(630, "AZT-3TC");//"AZT-3TC" Concept ID didnt match. So, Changed concept id from 29 to 630 as defined in NMRS
        regimenCodeDescTextMap.put(165544, "AZT-NVP");//"AZT-NVP" Concept ID didnt match. So, Changed concept id from 30 to 165544 as defined in NMRS
        regimenCodeDescTextMap.put(104567, "FTC-TDF");//"FTC-TDF" Concept ID didnt match. So, Changed concept id from 31 to 104567 as defined in NMRS
        regimenCodeDescTextMap.put(161363, "3TC-D4T");//"3TC-d4T"  Concept ID didnt match. So, Changed concept id from 32 to 104567 as defined n NMRS
        regimenCodeDescTextMap.put(166075, "3TC-NVP"); //"3TC-d4T" Changed the code desc from 3TC-4DT to 3TC-NVP and Created new concept for it on NMRS and replaced the initial Concpet Id of 33 to 166075
        regimenCodeDescTextMap.put(165257, "Cotrimoxazole 480mg"); //Defined Concept name is CTX prophylaxis. Check with Dr. Sunday for clearification
        regimenCodeDescTextMap.put(76488, "FLUCONAZOLE");//Added By Nelson
        regimenCodeDescTextMap.put(1679, "Isoniazid");//Added By Nelson
        regimenCodeDescTextMap.put(80945, "Nystatin");//Added By Nelson
        regimenCodeDescTextMap.put(161364, "TDF/3TC"); //Missing NDR Code lamivudine/fenofovir from APINS Instance
        regimenCodeDescTextMap.put(165631, "Dolutegravir");// Missing NDR Code from IHVN Instance
        regimenCodeDescTextMap.put(1674, "RIFAMPICIN/ISONIAZID/PYRAZINAMIDE/ETHAMBUTOL PROPHYLAXIS");// Missing NDR Code from IHVN Instance

        //Added By Nelson Attah
        //OI drug
        regimenCodeDescTextMap.put(71160, "CTX960");//71160 "C00"); //Cotrimoxazole 800mg 105281 No NDR Code
        /*regimenCodeDescTextMap.put("Cotrimoxotrimoxazole 960mg"
        regimenCodeDescTextMap.put("Cotrimoxazole 800mg", "CTX8azole 480mg", "CTX480");
        regimenCodeDescTextMap.put("Cotrimoxazole 400mg", "CTX400");
        regimenCodeDescTextMap.put("Cotrimoxazole 240mg/5ml", "CTX240");
        regimenCodeDescTextMap.put("Fluconazole", "FLUC");
        regimenCodeDescTextMap.put("Dapsone", "DDS");
        regimenCodeDescTextMap.put("Isoniazid-Pyridoxine", "INHB6");*/

    }

    public String getRegimenMapValue(int value_coded) {
        //old implementation return regimenMap.get(value_coded);
        if (regimenMap.containsKey(value_coded)) {
            return regimenMap.get(value_coded);
        }
        return "";
    }

    public String getRegimenCodeDescTextMapValue(int value_coded) {
        //old implementation return regimenCodeDescTextMap.get(value_coded);
        if (regimenCodeDescTextMap.containsKey(value_coded)) {
            return regimenCodeDescTextMap.get(value_coded);
        }
        return "";
    }

    public List<RegimenType> createRegimenTypeList(Patient patient, List<Encounter> allEncounterForPatient,List<Obs> patientsObsList) throws DatatypeConfigurationException{
        List<RegimenType> regimenTypeList=new ArrayList<>();
        Integer[] targetEncounterTypes={Utils.CARE_CARD_ENCOUNTER_TYPE,Utils.PHARMACY_ENCOUNTER_TYPE};
        RegimenType regimenType;
        List<Obs> obsPerVisit;
        Set<Date> visitDateSet=Utils.extractUniqueVisitsForEncounterTypes(patient, allEncounterForPatient, targetEncounterTypes);
        for(Date visitDate: visitDateSet){
            obsPerVisit=Utils.extractObsPerVisitDate(visitDate, patientsObsList);
            regimenType=createRegimenType(patient, visitDate, obsPerVisit);
            regimenTypeList.add(regimenType);
        }
        return regimenTypeList;
    }
    
    public List<RegimenType> createOIRegimenTypeList(Patient patient, List<Encounter> allEncounterForPatient,List<Obs> patientsObsList) throws DatatypeConfigurationException{
        List<RegimenType> regimenTypeList=new ArrayList<>();
        Integer[] targetEncounterTypes={Utils.CARE_CARD_ENCOUNTER_TYPE,Utils.PHARMACY_ENCOUNTER_TYPE};
        //RegimenType regimenType=null;
        //List<Obs> obsPerVisit;
        for(Encounter enc: allEncounterForPatient){
            if(enc.getEncounterType().getEncounterTypeId()==Utils.PHARMACY_ENCOUNTER_TYPE){
                //obsPerVisit=new ArrayList<Obs>(enc.getAllObs());
                //regimenType=createOIType(patient, enc, obsPerVisit);
                regimenTypeList.addAll(createOITypes(patient, enc, patientsObsList)); // ));
            }
        }
        return regimenTypeList;
    }

    /*
       Added by Bright Ibezim CDC
     */
    public RegimenType createRegimenType(Patient patient, Date visitDate, List<Obs> obsListForAVisit) throws DatatypeConfigurationException {
        /*
           RegimenType Properties
  -VisitID
  -VisitDate
  -PrescribedRegimenLineCode
  -PrescribedRegimenTypeCode
  -PrescribedRegimenInitialIndicator
  -PrescribedRegimen
  -PrescribedRegimenDispensedDate
  -PrescribedRegimenDuration
  -SubstitutionIndicator
  -SwitchIndicator
  -ReasonForRegimenSwitchSubs
  -DateRegimenStarted
  -DateRegimenStartedDD
  -DateRegimenStartedMM
  -DateRegimenStartedYYYY
  -DateRegimenEnded
  -DateRegimenEndedDD
  -DateRegimenEndedMM
  -DateRegimenEndedYYYY
  -PrescribedRegimenCurrentIndicator
  -TypeOfPreviousExposureCode
  -PoorAdherenceIndicator
  -ReasonForPoorAdherence
  -ReasonRegimenEndedCode
  
         */
        DateTime stopDateTime, startDateTime;
        RegimenType regimenType = null;
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        String ndrCode;
        Obs obs;
        int valueCoded, durationInDays;
        CodedSimpleType codedSimpleType;
        if (!obsListForAVisit.isEmpty() && pepfarIdentifier != null && Utils.contains(obsListForAVisit, Utils.CURRENT_REGIMEN_LINE_CONCEPT)) {
            String pepfarID = pepfarIdentifier.getIdentifier();

            String visitID = Utils.getVisitId(pepfarID, visitDate);

            regimenType = new RegimenType();
            regimenType.setVisitID(visitID);
            regimenType.setVisitDate(getXmlDate(visitDate));
            obs = Utils.extractObs(Utils.VISIT_TYPE_CONCEPT, obsListForAVisit);//PrescribedRegimenInitialIndicator
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.VISIT_TYPE_INITIAL_CONCEPT) {
                    regimenType.setPrescribedRegimenInitialIndicator(Boolean.TRUE);
                } else {
                    regimenType.setPrescribedRegimenInitialIndicator(Boolean.FALSE);
                }
            }
            obs = Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT, obsListForAVisit); //PrescribedRegimenLineCode
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getRegimenMapValue(valueCoded);
                regimenType.setPrescribedRegimenLineCode(ndrCode);
                regimenType.setPrescribedRegimenTypeCode(Utils.ART_CODE);
                obs = Utils.extractObs(valueCoded, obsListForAVisit); // PrescribedRegimen
                if (obs != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getRegimenMapValue(valueCoded);
                    codedSimpleType = new CodedSimpleType();
                    codedSimpleType.setCode(ndrCode);
                    codedSimpleType.setCodeDescTxt(obs.getValueCoded().getName().getName());
                    regimenType.setPrescribedRegimen(codedSimpleType);
                }
                regimenType.setPrescribedRegimenDispensedDate(getXmlDate(visitDate));//PrescribedRegimenDispensedDate
                stopDateTime = retrieveMedicationDuration(visitDate, obsListForAVisit);
                startDateTime = new DateTime(visitDate);
                if (stopDateTime != null) {
                    durationInDays = Utils.getDateDiffInDays(startDateTime.toDate(), stopDateTime.toDate());
                    regimenType.setPrescribedRegimenDuration(String.valueOf(durationInDays));//PrescribedRegimenDuration
                   Date stopDate = stopDateTime.toDate();
                    /*
                         -DateRegimenEnded
                         -DateRegimenEndedDD
                         -DateRegimenEndedMM
                         -DateRegimenEndedYYYY
                     */
                    regimenType.setDateRegimenEnded(getXmlDate(stopDate));
                    regimenType.setDateRegimenEndedDD(Utils.getDayDD(stopDate));
                    regimenType.setDateRegimenEndedMM(Utils.getMonthMM(stopDate));
                    regimenType.setDateRegimenEndedYYYY(Utils.getYearYYYY(stopDate));

                }
            }
            regimenType.setSubstitutionIndicator(retrieveSubstitutionIndicator(obsListForAVisit));//SubstitutionIndicator
            regimenType.setSwitchIndicator(retrieveSwitchIndicator(obsListForAVisit));//SwitchIndicator
            obs = Utils.extractObs(Utils.REASON_FOR_REGIMEN_SUBSTITUTION_OR_SWITCH_CONCEPT, obsListForAVisit);//ReasonForRegimenSwitchSubs
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getRegimenMapValue(valueCoded);
                regimenType.setReasonForRegimenSwitchSubs(ndrCode);
            }
            /*
                -DateRegimenStarted
                -DateRegimenStartedDD
                -DateRegimenStartedMM
                -DateRegimenStartedYYYY
             */
            regimenType.setDateRegimenStarted(getXmlDate(visitDate));
            regimenType.setDateRegimenStartedDD(Utils.getDayDD(visitDate));
            regimenType.setDateRegimenStartedMM(Utils.getMonthMM(visitDate));
            regimenType.setDateRegimenStartedYYYY(Utils.getYearYYYY(visitDate));

            obs = Utils.extractObs(Utils.NUMBER_OF_MISSED_DOSES_PER_MONTH_CONCEPT, obsListForAVisit);
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.MISSED_DOSES_FAIR_ADHERENCE_CONCEPT || valueCoded == Utils.MISSED_MEDICATION_POOR_ADHERENCE_CONCEPT) {
                    regimenType.setPoorAdherenceIndicator(Boolean.TRUE); //PoorAdherenceIndicator
                }
            } else {
                obs = Utils.extractObs(Utils.ARV_ADHERENCE_CONCEPT, obsListForAVisit);
                if (obs != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    if (valueCoded == Utils.ARV_ADHERENCE_FAIR_ADHERENCE_CONCEPT || valueCoded == Utils.ARV_ADHERENCE_POOR_ADHERENCE_CONCEPT) {
                        regimenType.setPoorAdherenceIndicator(Boolean.TRUE);
                    }
                }
            }

        }
        return regimenType;
    }

    public Boolean retrieveSubstitutionIndicator(List<Obs> obsList) {
        Obs obs;
        int valueCoded;
        Boolean ans = Boolean.FALSE;
        obs = Utils.extractObs(Utils.REGIMEN_MEDICATION_PLAN, obsList);
        if (obs != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.REGIMEN_MEDICATION_PLAN_SUBSTITUTE_REGIMEN_CONCEPT_VALUE) {
                ans = Boolean.TRUE;
            }
        } else {
            obs = Utils.extractObs(Utils.PICKUP_REASON_CONCEPT, obsList);
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.PICKUP_REASON_CONCEPT_SUBSTITUTE_VALUE) {
                    ans = Boolean.TRUE;
                }
            }
        }
        return ans;
    }

    public Boolean retrieveSwitchIndicator(List<Obs> obsList) {
        Obs obs;
        int valueCoded;
        Boolean ans = Boolean.FALSE;
        obs = Utils.extractObs(Utils.REGIMEN_MEDICATION_PLAN, obsList);
        if (obs != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.REGIMEN_MEDICATION_PLAN_SWITCH_REGIMEN_CONCEPT_VALUE) {
                ans = Boolean.TRUE;
            }
        } else {
            obs = Utils.extractObs(Utils.PICKUP_REASON_CONCEPT, obsList);
            if (obs != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.PICKUP_REASON_CONCEPT_SWITCH_VALUE) {
                    ans = Boolean.TRUE;
                }
            }
        }
        return ans;
    }

    public DateTime retrieveMedicationDuration(Date visitDate, List<Obs> obsList) {
        DateTime stopDateTime = null;
        DateTime startDateTime;
        int durationDays;
        Obs obs;

        Obs obsGroup = Utils.extractObs(Utils.ARV_DRUGS_GROUPING_CONCEPT_SET, obsList);
        if (obsGroup != null) {
            List<Obs> targetObsList = new ArrayList<>(obsGroup.getGroupMembers());
            obs = Utils.extractObs(Utils.MEDICATION_DURATION_CONCEPT, targetObsList);
            if (obs != null) {
                durationDays = (int) obs.getValueNumeric().doubleValue();
                startDateTime = new DateTime(visitDate);
                stopDateTime = startDateTime.plusDays(durationDays);
            }
        }
        
        /*if (stopDateTime == null) {
            obs = Utils.extractObs(Utils.NEXT_APPOINTMENT_DATE_CONCEPT, obsList);
            if (obs != null) {
                stopDateTime = new DateTime(obs.getValueDate());
            }
        }*/
        return stopDateTime;
    }

    public RegimenType createRegimenType(Patient pts, Encounter enc, List<Obs> pharmacyObsList)
            throws DatatypeConfigurationException {
        try {

            PatientIdentifier pmtctIdentifier = pts.getPatientIdentifier(ConstantsUtil.PMTCT_IDENTIFIER_INDEX);
            // PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

            RegimenType regimenType = new RegimenType();
            CodedSimpleType cst;

            regimenType.setVisitID(Utils.getVisitId(pts, enc));
            regimenType.setVisitDate(Utils.getXmlDate(enc.getEncounterDatetime()));

            Obs obs = Utils.extractObs(Prescribed_Regimen_Line_Concept_Id, pharmacyObsList);
            if (obs == null) {
                return null;
            }

         //   if (pmtctIdentifier != null) {

                try {
                    //set regimen line

                    regimenType.setPrescribedRegimenLineCode(getRegimenMapValue(obs.getValueCoded().getConceptId()));
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on Prescribed_Regimen_Line_Concept_Id: " + ex.getMessage(), LogFormat.DEBUG, LogLevel.live);
                }

                if (obs.getValueCoded() == null) { //if no prescribed regimen, discard the entire regimen object
                    return null;
                }
                cst = new CodedSimpleType();
                try {
                    cst.setCode(getRegimenMapValue(obs.getValueCoded().getConceptId()));
                    cst.setCodeDescTxt(getRegimenCodeDescTextMapValue(obs.getValueCoded().getConceptId()));
                    regimenType.setPrescribedRegimen(cst);
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on PRESCRIBEREGIMEN: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }

                obs = Utils.extractObs(Medication_Duration_Concept_Id, pharmacyObsList);
                if (obs == null) {
                    return null;
                }
                try {
                    int drugDuration = (int) Math.round(obs.getValueNumeric());
                    regimenType.setPrescribedRegimenDuration(String.valueOf(drugDuration));
                    //set dispensed date
                    regimenType.setPrescribedRegimenDispensedDate(Utils.getXmlDate(enc.getEncounterDatetime()));

                    //set type code
                    regimenType.setPrescribedRegimenTypeCode("ARV");

                    //set regimen start date
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(enc.getEncounterDatetime());
                    regimenType.setDateRegimenStarted(getXmlDate(enc.getEncounterDatetime()));
                    regimenType.setDateRegimenStartedDD(StringUtils.leftPad(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2, "0"));
                    regimenType.setDateRegimenStartedMM(StringUtils.leftPad(String.valueOf(cal.get(Calendar.MONTH) + 1), 2, "0"));
                    regimenType.setDateRegimenStartedYYYY(String.valueOf(cal.get(Calendar.YEAR)));

                    // set regimen end date
                    cal.add(Calendar.DATE, drugDuration);
                    regimenType.setDateRegimenEndedDD(StringUtils.leftPad(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2, "0"));
                    regimenType.setDateRegimenEndedMM(String.valueOf(cal.get(Calendar.MONTH) + 1));
                    regimenType.setDateRegimenEndedYYYY(String.valueOf(cal.get(Calendar.YEAR)));
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }

                obs = Utils.extractObs(Pick_Up_Reason_Concept_Id, pharmacyObsList);
                if (obs != null) {
                    obs = Utils.extractObs(obs.getValueCoded().getConceptId(), pharmacyObsList);
                    if (obs != null && obs.getValueCoded() != null) {
                        try {
                            if (obs.getValueCoded().getConceptId() == substitution_Indicator_Concept_Id) {
                                regimenType.setSubstitutionIndicator(true);
                            }
                        } catch (Exception ex) {
                            LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on substitution_Indicator_Concept_Id:" + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }

                        try {
                            //TODO: set switch reason
                            if (obs.getValueCoded().getConceptId() == switch_Indicator_Concept_Id) {
                                regimenType.setSwitchIndicator(true);
                                regimenType.setReasonForRegimenSwitchSubs("");
                            }
                        } catch (Exception ex) {
                            LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on switch_Indicator_Concept_Id:" + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }
                    }
                }

          //  }

            //set regimen code
            /*
		* Modified by Johnbosco 3/14/2019
		* Commented reluctant code Utils.extractObs
		* This code always returns obs as null
		* because the concept id checked by it is not the group concept id
		* */
            //obs = Utils.extractObs(obs.getValueCoded().getConceptId(), pharmacyObsList);
            //set duration
            // drug pick up reason
            return regimenType;
        } catch (Exception ex) {
            LoggerUtils.write(PharmacyDictionary.class.getName(), Arrays.toString(ex.getStackTrace()), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
    }

    private RegimenType createOIType(Patient pts, Encounter enc, List<Obs> OIDrugObsList)
            throws DatatypeConfigurationException {
        try {
            RegimenType regimenType = new RegimenType();
            CodedSimpleType cst;

            regimenType.setVisitID(Utils.getVisitId(pts, enc));
            regimenType.setVisitDate(Utils.getXmlDate(enc.getEncounterDatetime()));

            //set regimen
            Obs obs = Utils.extractObs(OI_Drug_Concept_Id, OIDrugObsList);
            
            if (obs != null && obs.getValueCoded() != null) {
                try {
                    cst = new CodedSimpleType();
                    cst.setCode(getRegimenMapValue(obs.getValueCoded().getConceptId()));
                    cst.setCodeDescTxt(getRegimenCodeDescTextMapValue(obs.getValueCoded().getConceptId()));
                    regimenType.setPrescribedRegimen(cst);
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on OI_Drug_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }
            }

            try {
                //set type code
                if (obs != null && obs.getObsGroup().getConcept().getConceptId() == OI_regimen_Concept_set) {
                    regimenType.setPrescribedRegimenTypeCode("CTX");
                } else if (obs != null && obs.getObsGroup().getConcept().getConceptId() == TB_regimen_Concept_set) {
                    regimenType.setPrescribedRegimenTypeCode("TB");
                }
            } catch (Exception ex) {
                LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on OI_regimen_Concept_set: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }

            //set duration
            int drugDuration = 0;
            obs = Utils.extractObs(Medication_Duration_Concept_Id, OIDrugObsList);
            if (obs != null) {
                drugDuration = (int) Math.round(obs.getValueNumeric());
                regimenType.setPrescribedRegimenDuration(String.valueOf(drugDuration));
            }

            //set dispensed date
            regimenType.setPrescribedRegimenDispensedDate(Utils.getXmlDate(enc.getEncounterDatetime()));

            //set regimen start date
            Calendar cal = Calendar.getInstance();
            cal.setTime(enc.getEncounterDatetime());
            regimenType.setDateRegimenStarted(getXmlDate(enc.getEncounterDatetime()));
            regimenType.setDateRegimenStartedDD(StringUtils.leftPad(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2, "0"));
            regimenType.setDateRegimenStartedMM(StringUtils.leftPad(String.valueOf(cal.get(Calendar.MONTH) + 1), 2, "0"));
            regimenType.setDateRegimenStartedYYYY(String.valueOf(cal.get(Calendar.YEAR)));

            // set regimen end date
            if (drugDuration != 0) {
                cal.add(Calendar.DATE, drugDuration);
                regimenType.setDateRegimenEndedDD(StringUtils.leftPad(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2, "0"));
                regimenType.setDateRegimenEndedMM(String.valueOf(cal.get(Calendar.MONTH) + 1));
                regimenType.setDateRegimenEndedYYYY(String.valueOf(cal.get(Calendar.YEAR)));
            }

            return regimenType;
        } catch (Exception ex) {
            LoggerUtils.write(PharmacyDictionary.class.getName(), Arrays.toString(ex.getStackTrace()), LogFormat.FATAL, LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
    }

    public List<RegimenType> createOITypes(Patient pts, Encounter enc, List<Obs> pharmacyObsList)
            throws DatatypeConfigurationException {

        List<RegimenType> regimenTypeList = new ArrayList<>();
        RegimenType regimenType;

        Set<Obs> groupObsSet = new HashSet<>();
        Set<Obs> drugObsSet;
        List<Obs> drugObsList = new ArrayList<>();

        for (Obs ele : pharmacyObsList) {
            try {
                if (ele.getObsGroup() != null
                        && (ele.getObsGroup().getConcept().getConceptId() == OI_regimen_Concept_set
                        || ele.getObsGroup().getConcept().getConceptId() == TB_regimen_Concept_set)) {
                    groupObsSet.add(ele.getObsGroup());
                }
            } catch (Exception ex) {
                LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on OI_regimen_Concept_set & TB_regimen_Concept_set: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
            }
        }
        for (Obs ele : groupObsSet) {
            try {
                drugObsSet = ele.getGroupMembers();
                drugObsList.addAll(drugObsSet);

                regimenType = createOIType(pts, enc, drugObsList);
                if (regimenType != null && StringUtils.isNotEmpty(regimenType.getPrescribedRegimenDuration())
                        && regimenType.getPrescribedRegimen() != null) {
                    regimenTypeList.add(regimenType);
                }
                drugObsList.clear();
            } catch (Exception ex) {
                LoggerUtils.write(PharmacyDictionary.class.getName(), Arrays.toString(ex.getStackTrace()), LogFormat.DEBUG, LogLevel.live);
                throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
            }
        }
        return regimenTypeList;
    }
}
