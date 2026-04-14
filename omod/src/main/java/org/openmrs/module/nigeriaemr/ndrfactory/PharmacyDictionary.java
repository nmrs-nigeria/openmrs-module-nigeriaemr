/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.ndr.CodedSimpleType;
import org.openmrs.module.nigeriaemr.model.ndr.RegimenType;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;
import java.util.stream.Collectors;
import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PharmacyDictionary {
    Utils utils = new Utils();

    //  Logger logger = Logger.getLogger(PharmacyDictionary.class);
    public final static int Medication_Duration_Concept_Id = 159368;

    public final static int TB_regimen_Concept_set = 165728;
    public final static int OI_regimen_Concept_set = 165726;
    public final static int OI_Drug_Concept_Id = 165727;
    public final static int ANTI_DRUG_Concept_ID = 165304;
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
    public final static int Pill_Balance = 166406;
    public final static int DSD = 166148;
    public final static int Facility_Dispensing = 166276;
    public final static int Decentralized_Drug_Delivery = 166363;
    public final static int MMD = 166278;

    public PharmacyDictionary() {
        loadDictionary();
    }
    private Map<Integer, String> regimenMap = new HashMap<>();
    private Map<Integer, String> regimenCodeDescTextMap = new HashMap<>();
    private Map<Integer, String> pharmacyDictionary = new HashMap<>();
    /*
		Concept ID for regimen to be gotten from
     */
    public void loadDictionary() {

        regimenMap.put(160124, "1a");//"AZT-3TC-EFV"
        regimenMap.put(1652, "1b");//"AZT-3TC-NVP"
        regimenMap.put(104565, "1c");//"TDF-FTC-EFV"
        regimenMap.put(164854, "1d");//"TDF-FTC-NVP"
        regimenMap.put(164505, "1e"); //"TDF-3TC-EFV"
        regimenMap.put(162565, "1f");//"TDF-3TC-NVP"
        regimenMap.put(817, "1g"); //"ABC-3TC-AZT" same as ABC/3TC/AZT
        regimenMap.put(165522, "1h"); //"AZT-3TC-TDF” same as TDF-3TC-AZT
        //   regimenMap.put(162563, "1l"); //"ABC-3TC-EFV"
        regimenMap.put(165681, "1m"); //"TDF-3TC-DTG"
        regimenMap.put(165682, "1n"); //"TDF-FTC-DTG
        regimenMap.put(165691, "1o"); //"ABC-3TC-DTG"
        regimenMap.put(165692, "1p"); //"ABC-FTC-DTG"

        //added latest new regimen list
        regimenMap.put(160104, "1q"); //D4T-3TC-EFV
        regimenMap.put(166179, "1r"); // ABC-FTC-EFV
        regimenMap.put(165690, "1s"); //ABC-FTC-NVP  //changed to 1s
        regimenMap.put(166181, "1u"); //ABC-3TC-TDF
        regimenMap.put(166183, "1v"); //D4T-3TC-ABC
        regimenMap.put(166185, "1w"); //AZT-TDF-NVP
        regimenMap.put(166186, "1x"); // DDI-3TC-EFV
        regimenMap.put(166187, "1z"); //AZT-3TC-DTG
        //pending concept id for DDI/3TC/ABC
        regimenMap.put(166092, "2m");//"ABC-3TC-ATV/r"
        regimenMap.put(162564, "2h");//"ABC-AZT-LPV/r" change concept ID from 165530
        regimenMap.put(166188, "2i");// DDI-3TC-LPV/r
        regimenMap.put(162559, "2j"); //ABC-DDI-LPV/r
        regimenMap.put(166245, "2k"); // AZT-TDF-ATV/r
        regimenMap.put(165530, "3a");//"AZT-TDF-3TC-LPV/r" // formerlly 2h
        regimenMap.put(165695, "3u");//AZT-3TC-RAL //formerlly 4o
        regimenMap.put(165696, "3v");//ABC-3TC-RAL // change 5g to 3v

        regimenMap.put(165523, "2a"); //"TDF-FTC-LPV/r"
        regimenMap.put(162201, "2b");//"TDF-3TC-LPV/r"
        regimenMap.put(165524, "2c"); //"TDF-FTC-ATV/r"
        regimenMap.put(164512, "2d");//"TDF-3TC-ATV/r"
        regimenMap.put(162561, "2e");//"AZT-3TC-LPV/r"
        regimenMap.put(164511, "2f");//"AZT-3TC-ATV/r"
        regimenMap.put(162563, "4c");//"ABC-3TC-EFV"
        regimenMap.put(162199, "4d");//"ABC-3TC-NVP"
        //  regimenMap.put(817, "4e");//"AZT-3TC-ABC" Same as ABC-3TC-AZT (took it off)
        regimenMap.put(792, "4f");//"d4T-3TC-NVP"
        regimenMap.put(162200, "5a");;//"ABC-3TC-LPV/r"
        regimenMap.put(162560, "5c");;//"d4T-3TC-LPV/r"

        //Added because of IHVN
/*
        ABC-FTC-EFV400   -  165694
        ABC-3TC-EFV400   -  165693
        TDF-FTC-EFV400  -   165687
        TDF-3TC-EFV400  -   165686
 */
        regimenMap.put(165694, "1r"); // ABC-FTC-EFV400
        regimenMap.put(165693, "4c"); // ABC-3TC-EFV400
        regimenMap.put(165687, "1c"); // TDF-FTC-EFV400
        regimenMap.put(165686, "1e"); // TDF-3TC-EFV400

        //added latest regimen
        //regimenMap.put(165525, "5d"); // ddi-3TC-NVP

        regimenMap.put(165526, "1y");;//"ABC-3TC-ddi" //change 5e to 1y
        regimenMap.put(165698, "6a"); //DRV/r + 2 NRTIs + 2 NNRTI
        regimenMap.put(165700, "6b"); //DRV/r +2NRTIs
        regimenMap.put(165688, "6c"); //DRV/r-DTG + 1-2 NRTIs
        regimenMap.put(165701, "6d"); //DRV/r-RAL + 1-2NRTIs
        regimenMap.put(165697, "6e"); //DTG+2 NRTIs
        regimenMap.put(165699, "6f"); //RAL + 2 NRTIs
        //regimenMap.put(165689, "6g");

        //for drug combination
        regimenMap.put(86663, "9a");//"AZT" Concept ID didnt match. So, Changed concept id from 26 to 86663 as defined In NMRS
        regimenMap.put(78643, "9b");//3TC Concept ID didnt match. So, changed ID from 27 to 78643 as defined In NMRS
        //regimenMap.put(80586, "9c");//"NVP" Concept ID didnt match. So, Changed concept id from 28 to 80586 as defined in NMRS
        //regimenMap.put(630, "9d");//"AZT-3TC" Concept ID didnt match. So, Changed concept id from 29 to 630 as defined on NMRS
        regimenMap.put(165544, "9e");//"AZT-NVP" Concept ID didnt match. So, Changed concept id from 30 to 165544 as defined in NMRS
        //regimenMap.put(104567, "9f");//"FTC-TDF" Concept ID didnt match. So, Changed concept id from 31 to 104567 as defined in NMRS
        //regimenMap.put(161363, "9g");//"3TC-d4T"  Concept ID didnt match. So, Changed concept id from 32 to 104567 as defined in NMRS
        //regimenMap.put(166075, "9h"); //"3TC-d4T" Changed the code desc from 3TC-4DT to 3TC-NVP and Created new concept for it on NMRS and replaced the initial Concpet Id of 33 to 166075
      /*  regimenMap.put(161364, "Unknown NDR Code APINSs Instance");//TDF/3TC Missing Drug Combination without NDR Code
        regimenMap.put(165631, "Missing NDR Code from IHVN Instance"); //Dolutegravir
       */ // regimenMap.put(1674, "Missing NDR Code frm IHVN Instance");//RIFAMPICIN/ISONIAZID/PYRAZINAMIDE/ETHAMBUTOL PROPHYLAXIS

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
        regimenCodeDescTextMap.put(166092, "ABC-3TC-ATV/r");
        regimenCodeDescTextMap.put(160124, "AZT-3TC-EFV");
        regimenCodeDescTextMap.put(1652, "AZT-3TC-NVP");
        regimenCodeDescTextMap.put(160104, "D4T-3TC-EFV");
        regimenCodeDescTextMap.put(166179, "ABC-FTC-EFV");
        regimenCodeDescTextMap.put(166181, "ABC-3TC-TDF");
        regimenCodeDescTextMap.put(166183, "D4T-3TC-ABC");
        regimenCodeDescTextMap.put(166185, "AZT-TDF-NVP");
        regimenCodeDescTextMap.put(166186, "DDI-3TC-EFV");
        regimenCodeDescTextMap.put(166187, "AZT-3TC-DTG");
        regimenCodeDescTextMap.put(162564, "ABC-AZT-LPV/r");
        regimenCodeDescTextMap.put(166188, "DDI-3TC-LPV/r");
        regimenCodeDescTextMap.put(162559, "ABC-DDI-LPV/r");
        //regimenCodeDescTextMap.put(104565, "DF-FTC-EFV");
        regimenCodeDescTextMap.put(164854, "TDF-FTC-NVP");
        regimenCodeDescTextMap.put(164505, "TDF-3TC-EFV");
        regimenCodeDescTextMap.put(162565, "TDF-3TC-NVP");
        //regimenCodeDescTextMap.put(817, "AZT-3TC-ABC");
        regimenCodeDescTextMap.put(165522, "AZT-3TC-TDF");
        regimenCodeDescTextMap.put(162563, "ABC-3TC-EFV");
        regimenCodeDescTextMap.put(165681, "TDF-3TC-DTG");
        regimenCodeDescTextMap.put(165686, "TDF-3TC-EFV");
        regimenCodeDescTextMap.put(165682, "TDF-FTC-DTG");
        regimenCodeDescTextMap.put(165687, "TDF-FTC-EFV");
        regimenCodeDescTextMap.put(165523, "TDF-FTC-LPV/r");
        regimenCodeDescTextMap.put(162201, "TDF-3TC-LPV/r");
        regimenCodeDescTextMap.put(165524, "TDF-FTC-ATV/r");
        regimenCodeDescTextMap.put(164512, "TDF-3TC-ATV/r");
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(164511, "AZT-3TC-ATV/r");
        regimenCodeDescTextMap.put(165530, "AZT-TDF-3TC-LPV/r");
        regimenCodeDescTextMap.put(165537, "TDF-AZT-3TC-ATV/r");
        regimenCodeDescTextMap.put(165688, "DRV/r-DTG + 1-2 NRTIs");
        regimenCodeDescTextMap.put(1652, "AZT-3TC-NVP");
        regimenCodeDescTextMap.put(162199, "ABC-3TC-NVP");
        regimenCodeDescTextMap.put(817, "AZT-3TC-ABC");
        regimenCodeDescTextMap.put(792, "d4T-3TC-NVP");
        regimenCodeDescTextMap.put(165691, "ABC-3TC-DTG");
        regimenCodeDescTextMap.put(165693, "ABC-3TC-EFV");
        regimenCodeDescTextMap.put(162200, "ABC-3TC-LPV/r");
        regimenCodeDescTextMap.put(165692, "ABC-FTC-DTG");
        regimenCodeDescTextMap.put(165694, "ABC-FTC-EFV");
        regimenCodeDescTextMap.put(165690, "ABC-FTC-NVP");
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(165695, "AZT-3TC-RAL");
        //regimenCodeDescTextMap.put(165681, "TDF-3TC-DTG");
        //regimenCodeDescTextMap.put(164505, "TDF-3TC-EFV");
        regimenCodeDescTextMap.put(165686, "TDF-3TC-EFV");//TDF-3TC-EFV400
        //regimenCodeDescTextMap.put(162565, "TDF-3TC-NVP");
        //regimenCodeDescTextMap.put(165682, "TDF-FTC-DTG");
        regimenCodeDescTextMap.put(104565, "TDF-FTC-EFV");
        regimenCodeDescTextMap.put(165687, "TDF-FTC-EFV"); // TDF-FTC-EFV400
        regimenCodeDescTextMap.put(162561, "AZT-3TC-LPV/r");
        regimenCodeDescTextMap.put(162560, "d4T-3TC-LPV/r");
        regimenCodeDescTextMap.put(165526, "ABC-3TC-ddi");
        regimenCodeDescTextMap.put(165696, "ABC-3TC-RAL");
        regimenCodeDescTextMap.put(165695, "AZT-3TC-RAL");
        regimenCodeDescTextMap.put(165698, "DRV/r + 2 NRTIs + 2 NNRTI");
        regimenCodeDescTextMap.put(165700, "DRV/r +2NRTIs");
        regimenCodeDescTextMap.put(165701, "DRV/r-RAL + 1-2 NRTIs");
        regimenCodeDescTextMap.put(165697, "DTG+2 NRTIs");
        regimenCodeDescTextMap.put(165699, "RAL + 2 NRTIs");
        regimenCodeDescTextMap.put(86663, "AZT");//"AZT" Concept ID didnt match. So, Changed concept id from 26 to 86663 as defined in NMRS
        regimenCodeDescTextMap.put(78643, "3TC");// 3TC Concept ID didnt match . So , Changed concept Id from 27 to 78643 as defined in NMRS
        //regimenCodeDescTextMap.put(80586, "NVP");//"NVP" Concept ID didnt match. So, Changed concept id from 28 to 80586 as defined in NMRS
        //regimenCodeDescTextMap.put(630, "AZT-3TC");//"AZT-3TC" Concept ID didnt match. So, Changed concept id from 29 to 630 as defined in NMRS
        regimenCodeDescTextMap.put(165544, "AZT-NVP");//"AZT-NVP" Concept ID didnt match. So, Changed concept id from 30 to 165544 as defined in NMRS
        //regimenCodeDescTextMap.put(104567, "FTC-TDF");//"FTC-TDF" Concept ID didnt match. So, Changed concept id from 31 to 104567 as defined in NMRS
        //regimenCodeDescTextMap.put(161363, "3TC-D4T");//"3TC-d4T"  Concept ID didnt match. So, Changed concept id from 32 to 104567 as defined n NMRS
        //regimenCodeDescTextMap.put(166075, "3TC-NVP"); //"3TC-d4T" Changed the code desc from 3TC-4DT to 3TC-NVP and Created new concept for it on NMRS and replaced the initial Concpet Id of 33 to 166075
        regimenCodeDescTextMap.put(165257, "Cotrimoxazole 480mg"); //Defined Concept name is CTX prophylaxis. Check with Dr. Sunday for clearification
        regimenCodeDescTextMap.put(76488, "FLUCONAZOLE");//Added By Nelson
        regimenCodeDescTextMap.put(1679, "Isoniazid-Pyridoxine ");//Added By Nelson
        regimenCodeDescTextMap.put(80945, "Cotrimoxazole 960mg");//Added By Nelson
      /*  regimenCodeDescTextMap.put(161364, "TDF/3TC"); //Missing NDR Code lamivudine/fenofovir from APINS Instance
        regimenCodeDescTextMap.put(165631, "Dolutegravir");// Missing NDR Code from IHVN Instance
        */// regimenCodeDescTextMap.put(1674, "RIFAMPICIN/ISONIAZID/PYRAZINAMIDE/ETHAMBUTOL PROPHYLAXIS");// Missing NDR Code from IHVN Instance

        //Added by APIN Team 02-09-2020
        regimenCodeDescTextMap.put(656 , "Isoniazid (INH)");
        regimenCodeDescTextMap.put(767, "Rifampicin");
        regimenCodeDescTextMap.put(5829, "Pyrazinamide");
        regimenCodeDescTextMap.put(745, "Ethambutol");
        regimenCodeDescTextMap.put(438, "Streptomycin");
        regimenCodeDescTextMap.put(1108, "Isoniazid-Ethambutol");
        regimenCodeDescTextMap.put(1194, "Isoniazid-Rifampicin");
        regimenCodeDescTextMap.put(1677, "Isoniazid-Rifampicin-Ethambutol");
        regimenCodeDescTextMap.put(1131, "Isoniazid-Rifampicin-Pyrazinamide-Ethambutol");
        regimenCodeDescTextMap.put(1674, "Isoniazid-Rifampicin-Pyrazinamide-Ethambutol-Streptomycin");
        regimenCodeDescTextMap.put(1675,"Rifampicin-Isoniazid-Pyrazinamide-Ethambutol Prophylaxis");
        regimenCodeDescTextMap.put(83352,"RIFABUTIN");

        regimenMap.put(656, "H");
        regimenMap.put(767, "R");
        regimenMap.put(5829, "Z");
        regimenMap.put(745, "E");
        regimenMap.put(438, "S");
        regimenMap.put(1108, "HE");
        regimenMap.put(1194, "HR");
        regimenMap.put(1677, "HRE");
        regimenMap.put(1131, "HRZE");
        regimenMap.put(1674, "HRZES");
        regimenMap.put(1675,"HRZES");
        regimenMap.put(83352,"RF");
        regimenMap.put(165257, "CTX480");//
        regimenMap.put(76488, "FLUC");
        regimenMap.put(1679, "INHB6");
        regimenMap.put(80945, "CTX960");


        //added new regimen
        //  regimenCodeDescTextMap.put(160104, "D")
        //OI drug
        regimenCodeDescTextMap.put(71160, "CTX960");//71160 "C00"); //Cotrimoxazole 800mg 105281 No NDR Code

        pharmacyDictionary.put(166276,"DSD1");
        pharmacyDictionary.put(166363,"DSD2");
        pharmacyDictionary.put(166153,"FD2");
        pharmacyDictionary.put(166151,"FD1");
        pharmacyDictionary.put(166279,"FD3");
        pharmacyDictionary.put(166134,"DDD04");
        pharmacyDictionary.put(166135,"DDD03");
        pharmacyDictionary.put(166280,"DDD06");
        pharmacyDictionary.put(166364,"DDD02");
        pharmacyDictionary.put(166365,"DDD05");
        pharmacyDictionary.put(166366,"DDD01");
        pharmacyDictionary.put(5622,"DDD07");
        pharmacyDictionary.put(166281,"MMD1");
        pharmacyDictionary.put(166282,"MMD2");
        pharmacyDictionary.put(166283,"MMD3");
        pharmacyDictionary.put(167107,"FBM2");
        pharmacyDictionary.put(167108,"FBM3");
        pharmacyDictionary.put(167109,"FBM4");
        pharmacyDictionary.put(167110,"FBM5");
        pharmacyDictionary.put(167111,"FBM6");
        pharmacyDictionary.put(167112,"FBM7");
        pharmacyDictionary.put(167115,"CBM6");
        pharmacyDictionary.put(167114,"CBM4");
        pharmacyDictionary.put(167113,"CBM3");
    }

    public String getRegimenMapValue(int value_coded) {
        //old implementation return regimenMap.get(value_coded);
        if (regimenMap.containsKey(value_coded)) {
            return regimenMap.get(value_coded);
        }
        return null;
    }

    public String getDSDMapValue(int value_coded) {
        //old implementation return regimenMap.get(value_coded);
        if (regimenMap.containsKey(value_coded)) {
            return regimenMap.get(value_coded);
        }
        return null;
    }

    public String getPharmacyMapValue(int value_coded) {
        if (pharmacyDictionary.containsKey(value_coded)) {
            return pharmacyDictionary.get(value_coded);
        }
        return null;
    }

    public String getRegimenCodeDescTextMapValue(int value_coded) {
        //old implementation return regimenCodeDescTextMap.get(value_coded);
        if (regimenCodeDescTextMap.containsKey(value_coded)) {
            return regimenCodeDescTextMap.get(value_coded);
        }
        return null;
    }

    public List<RegimenType> createRegimenTypeList(Patient patient, Map<Integer,List<Encounter>> groupedEncounters) throws DatatypeConfigurationException {
        List<RegimenType> regimenTypeList = new ArrayList<RegimenType>();

        RegimenType regimenType = null;
        List<Obs> obsPerVisit = null;
        List<Encounter> allPharmacyEncounterForPatient = groupedEncounters.get(Utils.PHARMACY_ENCOUNTER_TYPE);
        if(allPharmacyEncounterForPatient != null) {
            for (Encounter enc : allPharmacyEncounterForPatient) {
                obsPerVisit =  new ArrayList<>(enc.getAllObs());
                Date visitDate = DateUtils.truncate(enc.getEncounterDatetime(), Calendar.DATE);
                regimenType = createRegimenType(patient, visitDate, obsPerVisit);
                regimenTypeList.add(regimenType);
                regimenTypeList.addAll(createOITypes(patient, enc, obsPerVisit));
            }
        }
        return regimenTypeList;
    }

    public RegimenType createRegimenType(Patient patient, Date visitDate, List<Obs> obsListForAVisit) throws DatatypeConfigurationException {

        String visitID = "";
        Date stopDate = null;
        DateTime stopDateTime = null, startDateTime = null;
        RegimenType regimenType = null;
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        String pepfarID = "";
        String ndrCode = "";
        Obs obs = null;
        int valueCoded = 0, durationInDays = 0;
        CodedSimpleType codedSimpleType = null;
        Map<Object, List<Obs>> map = Utils.groupedByConceptIdsOnly(obsListForAVisit);
        if (!obsListForAVisit.isEmpty() && pepfarIdentifier != null && map.get(Utils.CURRENT_REGIMEN_LINE_CONCEPT) != null) {
            pepfarID = pepfarIdentifier.getIdentifier();

            visitID = Utils.getVisitId(pepfarID, visitDate);

            regimenType = new RegimenType();
            regimenType.setVisitID(visitID);
            regimenType.setVisitDate(utils.getXmlDate(visitDate));

            obs = Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT, map); //PrescribedRegimenLineCode
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getRegimenMapValue(valueCoded);
                regimenType.setPrescribedRegimenLineCode(ndrCode);
                regimenType.setPrescribedRegimenTypeCode(Utils.ART_CODE);
                Obs valueObs = Utils.extractObs(valueCoded, map); // PrescribedRegimen
                if (valueObs != null) {
                    valueCoded = valueObs.getValueCoded().getConceptId();
                    ndrCode = getRegimenMapValue(valueCoded);
                    if(ndrCode != null) {
                        codedSimpleType = new CodedSimpleType();
                        codedSimpleType.setCode(ndrCode);
//                    codedSimpleType.setCodeDescTxt(valueObs.getValueCoded().getName().getName());
                        codedSimpleType.setCodeDescTxt(getRegimenCodeDescTextMapValue(valueCoded));
                        regimenType.setPrescribedRegimen(codedSimpleType);
                    }
                }
                regimenType.setPrescribedRegimenDispensedDate(utils.getXmlDate(visitDate));//PrescribedRegimenDispensedDate
                stopDateTime = retrieveMedicationDuration(visitDate, map);
                startDateTime = new DateTime(visitDate);
                if (stopDateTime != null) {
                    durationInDays = Utils.getDateDiffInDays(startDateTime.toDate(), stopDateTime.toDate());
                    regimenType.setPrescribedRegimenDuration(String.valueOf(durationInDays));//PrescribedRegimenDuration
                    stopDate = stopDateTime.toDate();
                    regimenType.setDateRegimenEnded(utils.getXmlDate(stopDate));
                    regimenType.setDateRegimenEndedDD(Utils.getDayDD(stopDate));
                    regimenType.setDateRegimenEndedMM(Utils.getMonthMM(stopDate));
                    regimenType.setDateRegimenEndedYYYY(Utils.getYearYYYY(stopDate));
                }
            }
            regimenType.setDateRegimenStarted(utils.getXmlDate(visitDate));
            regimenType.setDateRegimenStartedDD(Utils.getDayDD(visitDate));
            regimenType.setDateRegimenStartedMM(Utils.getMonthMM(visitDate));
            regimenType.setDateRegimenStartedYYYY(Utils.getYearYYYY(visitDate));

            obs = extractObs(Pill_Balance, map);
            if(obs != null && obs.getValueText() != null){
                int value_integer = Integer.parseInt((obs.getValueText()));
                regimenType.setPillBalance(value_integer);
            }
            obs = Utils.extractObs(DSD, map); //DSD
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getPharmacyMapValue(valueCoded);
                regimenType.setDifferentiatedServiceDelivery(ndrCode);
                Obs valueObs = Utils.extractObs(valueCoded, map); // Dispensing
                if (valueObs != null) {
                    valueCoded = valueObs.getValueCoded().getConceptId();
                    ndrCode = getPharmacyMapValue(valueCoded);
                    if(ndrCode != null) {
                        regimenType.setDispensing(ndrCode);
                    }
                }
            }
            obs = extractObs(MMD, map);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getPharmacyMapValue(valueCoded);
                regimenType.setMultiMonthDispensing(ndrCode);
            }
        }
        return regimenType;
    }

    public DateTime retrieveMedicationDuration(Date visitDate, Map<Object,List<Obs>> obsList) {
        DateTime stopDateTime = null;
        DateTime startDateTime = null;
        int durationDays = 0;
        Obs obs = null;

        Obs obsGroup = Utils.extractObs(Utils.ARV_DRUGS_GROUPING_CONCEPT_SET, obsList);
        if (obsGroup != null) {
            Set<Obs> obsGroupSet = null;
            try {
                Obs obsNew = Context.getObsService().getObs(obsGroup.getId());
                if(obsNew != null){
                    obsGroupSet = obsNew.getGroupMembers();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            if(obsGroupSet != null && obsGroupSet.size() > 0) {
                obs = Utils.extractObsByConceptId(Utils.MEDICATION_DURATION_CONCEPT, new ArrayList<>(obsGroupSet));
            }
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

    private RegimenType createOIType(Patient pts, Encounter enc, List<Obs> OIDrugObs) {
        RegimenType regimenType = new RegimenType();

        try {

            List<Integer> obsCodeList = Arrays.asList(OI_Drug_Concept_Id,
                    ANTI_DRUG_Concept_ID, Medication_Duration_Concept_Id);

            Map<Object, List<Obs>> OIDrugObsList = Utils.groupedByConceptIdsOnly(OIDrugObs);

            CodedSimpleType cst;

            regimenType.setVisitID(Utils.getVisitId(pts, enc));
            regimenType.setVisitDate(utils.getXmlDate(enc.getEncounterDatetime()));

            //set regimen
            Obs obs = Utils.extractObs(OI_Drug_Concept_Id, OIDrugObsList);

            if (obs != null && obs.getValueCoded() != null) {
                try {
                    cst = new CodedSimpleType();
                    cst.setCode(getRegimenMapValue(obs.getValueCoded().getConceptId()));
//                    cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                    cst.setCodeDescTxt(getRegimenCodeDescTextMapValue(obs.getValueCoded().getConceptId()));
                    regimenType.setPrescribedRegimen(cst);
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on OI_Drug_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }
            } else {
                //set regimen--do this for TB
                obs = Utils.extractObs(ANTI_DRUG_Concept_ID, OIDrugObsList);
                try {
                    cst = new CodedSimpleType();
                    cst.setCode(getRegimenMapValue(obs.getValueCoded().getConceptId()));
//                    cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                    cst.setCodeDescTxt(getRegimenCodeDescTextMapValue(obs.getValueCoded().getConceptId()));
                    regimenType.setPrescribedRegimen(cst);
                } catch (Exception ex) {
                    LoggerUtils.write(PharmacyDictionary.class.getName(), "Error on OI_Drug_Concept_Id: " + ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }

            }

            try {
                //set type code
                if (obs != null && obs.getObsGroup().getConcept().getConceptId() == OI_regimen_Concept_set) {
                    regimenType.setPrescribedRegimenTypeCode("OI");
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
            regimenType.setPrescribedRegimenDispensedDate(utils.getXmlDate(enc.getEncounterDatetime()));

            //set regimen start date
            Calendar cal = Calendar.getInstance();
            cal.setTime(enc.getEncounterDatetime());
            regimenType.setDateRegimenStarted(utils.getXmlDate(enc.getEncounterDatetime()));
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

        } catch (Exception ex) {
            LoggerUtils.write(PharmacyDictionary.class.getName(), Arrays.toString(ex.getStackTrace()), LogFormat.FATAL, LogLevel.live);
            //  throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }

        return regimenType;
    }

    public List<RegimenType> createOITypes(Patient pts, Encounter enc, List<Obs> pharmacyObsList) {

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
                // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
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
                // throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
            }
        }
        return regimenTypeList;
    }

    private List<Encounter> filterCareCardEncounters(List<Encounter> allPatientEncounters) {

        return allPatientEncounters.stream()
                .filter(a -> a.getEncounterType().getEncounterTypeId().equals(Utils.CARE_CARD_ENCOUNTER_TYPE))
                .collect(Collectors.toList());

    }

    private List<Obs> getLastCardObsbyVisit(Date visitDate, List<Encounter> careCardObs) {

        List<Obs> response = new ArrayList<>();

        for (Encounter enc : careCardObs) {

            Date tempVisitDate = DateUtils.truncate(enc.getEncounterDatetime(), Calendar.DATE);

            int durationInDays = Utils.getDateDiffInDays(tempVisitDate, visitDate);

            if (visitDate.equals(tempVisitDate)) {
                // same day pickup
                response = enc.getAllObs().stream().collect(Collectors.toList());
                break;
            } else if (durationInDays > 1 && durationInDays < 29) {
                //care follow up within a month
                response = enc.getAllObs().stream().collect(Collectors.toList());
                break;

            }

        }

        return response;

    }

}
