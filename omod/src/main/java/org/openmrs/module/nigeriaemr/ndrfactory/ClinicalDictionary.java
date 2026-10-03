package org.openmrs.module.nigeriaemr.ndrfactory;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.model.ndr.CodedSimpleType;
import org.openmrs.module.nigeriaemr.model.ndr.HIVEncounterType;
import org.openmrs.module.nigeriaemr.model.ndr.RegimenCodedSimpleType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigDecimal;
import java.util.*;

public class ClinicalDictionary {

    Utils utils = new Utils();

    public final static int Weight_Concept_Id = 5089,
            Child_Height_Concept_Id = 5090,
            DSD_FAC_CONCEPT_ID = 166276,
            DSD_COMMUNITY_CONCEPT_ID = 166510,
            Patient_Family_Planning_Method_Code_Concept_Id = 374,
            Noted_Side_Effects_Concept_Id = 159935,
            CD4_Concept_Id = 6,
            CD4_Test_Date_Concept_Id = 7,
            Next_Appointment_Date_Concept_Id = 5096,
            Systolic_Blood_Pressure_Concept_Id = 5085,
            Dystolic_Blood_Pressure_Concept_Id = 5086,
            Pregnancy_Breastfeeding_Status_Concept_Id = 165050,
            Patient_Family_Planning_Concept_Id = 167636,
            Functional_Status_Concept_Id = 165039,
            WHO_Clinical_Stage_Concept_Id = 5356,
            TB_Status_Concept_Id = 1659,
            Other_OI_Other_Problem_Concept_Id = 160170,
            ARV_Drug_Adherence_Concept_Id = 165290,
            Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id = 19,
            Cotrimoxazole_Dose_Concept_Id = 165069,
            Cotrimoxazole_Adherence_Concept_Id = 161652,
            Why_Poor_Fair_Cotrimoxazole_Adherence_Concept_Id = 166131,
            INH_Dose_Concept_Id = 23,
            INH_Adherence_Concept_Id = 161653,
            Why_Poor_Fair_INH_Drug_Adherence_Concept_Id = 25;

    //TODO: replace placeholder concept ids with real concepts when available
    public final static int Height_Concept_Id = 5090,
            BMI_MUAC_Concept_Id = 1342,//**
            Disclosure_Status_Concept_Id = 167591,
            Cryptococcal_Status_Concept_Id = 167130,
            Cervical_Cancer_Screening_Status_Concept_Id = 167139,
            Cervical_Treatment_Provided_Concept_Id = 167150,
            Hepatitis_Status_Concept_Id = 166036,
            DSD_Status_Code_Concept_Id = 167126,
            Date_Devolved_Concept_Id = 167602,
            Cotrimoxazole_Code_Concept_Id = 0,
            INH_Dose_Strength_Concept_Id = 0,
            Type_Of_Previous_Exposure_Concept_Id = 0,
            Reason_For_Poor_Adherence_Concept_Id = 0,
            Reason_Regimen_Ended_Concept_Id = 0,
            Prescribed_Regimen_Current_Indicator_Concept_Id = 0,
            TPT_Medication_Concept_Id = 1264,
            TPT_Dose_Concept_Id = 167526,
            TPT_Adherence_Code_Concept_Id = 161652,
            Other_Drugs_Prescribed_Concept_Id = 0,
            VL_Result_Concept_Id = 856,
            VL_Indication_Concept_Id = 164980,
            EAC_Code_Concept_Id = 167651,
            Random_Blood_Sugar_Concept_Id = 9,
            Other_Tests_Done_Concept_Id = 0,
            Consult_Hospitalise_Refer_Concept_Id = 167650,
            Health_Insurance_Code_Concept_Id = 167456,
            Duration_On_ART_Concept_Id = 167590;

    private final Map<Integer, String> map = new HashMap<>();
    private final Map<Integer, String> fpmap = new HashMap<>();

    private final StringJoiner notedSide_Effects = new StringJoiner(",");
    private final StringJoiner otherOI_Effects = new StringJoiner(",");
    NigeriaEncounterService nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);

    public ClinicalDictionary() {
        loadDictionary();
    }

    private void loadDictionary() {
        //Map OpenMRS concepts to corresponding NDR values
        map.put(123, "12");
        map.put(165686, "1e");
        //adherence

        //encounter type WHO clinical stage concept
        map.put(1204, "1");
        map.put(1205, "2");
        map.put(1206, "3");
        map.put(1207, "4");

        //pediatric
        map.put(165282, "1");
        map.put(165283, "2");
        map.put(165284, "3");
        map.put(165285, "4");
      /*  map.put(1220, "I");
        map.put(1221, "II");
        map.put(1222, "III");
        map.put(1223, "IV");*/

        //Family planning
        fpmap.put(190, "Condoms");
        fpmap.put(780, "OralContraceptivePills");
        fpmap.put(5279, "InjectableImplantableHormones");
        fpmap.put(5278, "DiaphragmCervicalCap");
        fpmap.put(5275, "IntrauterineDevice");
        fpmap.put(1489, "VasectomyTubalLigationHysterectomy");
        fpmap.put(5622, "Others");




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
        map.put(116743, "3");
        map.put(5226, "4");
        map.put(165767, "5");
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
        map.put(817, "1g"); //"ABC-3TC-AZT" same as ABC/3TC/AZT
        map.put(165522, "1h"); //"AZT-3TC-TDF” same as TDF-3TC-AZT
        //   map.put(162563, "1l"); //"ABC-3TC-EFV"
        map.put(165681, "1m"); //"TDF-3TC-DTG"
        map.put(165682, "1n"); //"TDF-FTC-DTG
        map.put(165691, "1o"); //"ABC-3TC-DTG"
        map.put(165692, "1p"); //"ABC-FTC-DTG"

        //added latest new regimen list
        map.put(160104, "1q"); //D4T-3TC-EFV
        map.put(166179, "1r"); // ABC-FTC-EFV
        map.put(165690, "1s"); //ABC-FTC-NVP  //changed to 1s
        map.put(166181, "1u"); //ABC-3TC-TDF
        map.put(166183, "1v"); //D4T-3TC-ABC
        map.put(166185, "1w"); //AZT-TDF-NVP
        map.put(166186, "1x"); // DDI-3TC-EFV
        map.put(166187, "1z"); //AZT-3TC-DTG
        //pending concept id for DDI/3TC/ABC
        map.put(162564, "2h");//"ABC-AZT-LPV/r" change concept ID from 165530
        map.put(166188, "2i");// DDI-3TC-LPV/r
        map.put(162559, "2j"); //ABC-DDI-LPV/r
        map.put(166245, "2k"); // AZT-TDF-ATV/r
        map.put(166092, "2m"); // ABC-3TC-ATV/r
        map.put(165541, "2n"); // ABC-DDI-SQV/r
        map.put(165527, "2o"); // TDF-FTC-SQV/r
        map.put(165528, "2p"); // TDF-3TC-SQV/r
        map.put(165529, "2q"); // AZT-3TC-SQV/r
        map.put(165534, "2r"); // AZT-3TC-IDV/r
        map.put(166190, "2s"); // D4T-3TC-IDV/r
        map.put(165539, "2t"); // TDF-FTC-IDV/r
        map.put(165533, "2u");// TDF-3TC-IDV/r
        map.put(166191, "2v"); // DDI-3TC-IND/r
        map.put(165542, "2w"); // TDF-DDI-IDV/r
        map.put(166192, "2x"); // AZT-3TC-DRV/r
        map.put(166193, "2y"); // TDF-3TC-DRV/r

        map.put(165530, "3a");//"AZT-TDF-3TC-LPV/r" // formerlly 2h
        map.put(165540, "3b"); // AZT-TDF-FTC-LPV/r
        map.put(165537, "3c");//"TDF-AZT-3TC-ATV/r" //formerly 2i
        map.put(166194, "3d"); // TDF-3TC-DTG-LPV/r
        map.put(166195, "3e"); // TDF-FTC-AZT-ATV/r
        map.put(166196, "3f"); // TDF-3TC-DTG-DRV-RTV
        map.put(166197, "3g"); // ABC-3TC-DTG-ATV/r
        map.put(166198, "3h"); // ABC-3TC-DTG-DRV-RTV
        map.put(166199, "3i"); // ABC-3TC-AZT-LPV/r
        map.put(166200, "3j"); // AZT-3TC-LPV-SQV/r
        map.put(166201, "3k"); // AZT-3TC-LPV-ATV/r
        map.put(166202, "3m"); // ABC-3TC-AZT-EFV
        map.put(166203, "3n"); // ABC-3TC-AZT-ATV/r
        map.put(166204, "3o"); // ABC-3TC-LPV-ATV/r
        map.put(166205, "3p"); // TDF-FTC-LPV-ATV/r
        map.put(165535, "3q"); // TDF-AZT-FTC-IDV/r
        map.put(165531, "3r"); // TDF-AZT-FTC-SQV/r
        map.put(165536, "3s"); // TDF-AZT-3TC-IDV/r
        map.put(165532, "3t"); // TDF-AZT-3TC-SQV/r
        map.put(166206, "3w"); // TDF-3TC-RAL
        map.put(166207, "3x"); // AZT-RAL-ATV/r
        map.put(165695, "3u");//AZT-3TC-RAL //formerlly 4o
        map.put(165696, "3v");//ABC-3TC-RAL // change 5g to 3v

        map.put(165523, "2a"); //"TDF-FTC-LPV/r"
        map.put(162201, "2b");//"TDF-3TC-LPV/r"
        map.put(165524, "2c"); //"TDF-FTC-ATV/r"
        map.put(164512, "2d");//"TDF-3TC-ATV/r"
        map.put(162561, "2e");//"AZT-3TC-LPV/r"
        map.put(164511, "2f");//"AZT-3TC-ATV/r"

        map.put(1652, "4b");//"AZT-3TC-NVP"
        map.put(162563, "4c");//"ABC-3TC-EFV"
        map.put(162199, "4d");//"ABC-3TC-NVP"
        //  map.put(817, "4e");//"AZT-3TC-ABC" Same as ABC-3TC-AZT (took it off)
        map.put(792, "4f");//"d4T-3TC-NVP"
        map.put(166074, "4g"); // Nelson Added Concept in NigeriaMRS and mapped it here as code already exist on NDR.

        map.put(162561, "5b"); //AZT-3TC-LPV/r //formaerlly 4n

        map.put(162200, "5a");;//"ABC-3TC-LPV/r"
        map.put(162561, "5b");;//"AZT-3TC-LPV/r"
        map.put(162560, "5c");;//"d4T-3TC-LPV/r"

        //added latest regimen
        map.put(165525, "5d"); // ddi-3TC-NVP

        map.put(165526, "1y");;//"ABC-3TC-ddi" //change 5e to 1y

        map.put(165698, "6a"); //DRV/r + 2 NRTIs + 2 NNRTI
        map.put(165700, "6b"); //DRV/r +2NRTIs
        map.put(165688, "6c"); //DRV/r-DTG + 1-2 NRTIs
        map.put(165701, "6d"); //DRV/r-RAL + 1-2NRTIs
        map.put(165697, "6e"); //DTG+2 NRTIs
        map.put(165699, "6f"); //RAL + 2 NRTIs
        map.put(165689, "6g");


        map.put(165530,	"3a3");
        map.put(165540,	"3b3");
        map.put(165537,	"3c");
        map.put(166194,	"3d");
        map.put(166195,	"3e");
        map.put(166196,	"3f");
        map.put(166197,	"3g");
        map.put(166198,	"3h");
        map.put(166199,	"3i");
        map.put(166200,	"3j");
        map.put(166201,	"3k");
        map.put(166202,	"3m");
        map.put(166203,	"3n");
        map.put(166204,	"3o");
        map.put(166205,	"3p");
        map.put(165535,	"3q");
        map.put(165531,	"3r");
        map.put(165536,	"3s");
        map.put(165532,	"3t");
        map.put(165695,	"3u");
        map.put(165696,	"3v");
        map.put(166206,	"3w");
        map.put(166207,	"3x");


        //for drug combination
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
        map.put(166192, "2x");
        map.put(166193, "2y");
        map.put(166196, "3f");
        map.put(166198, "3h");
        map.put(167518, "1ee");
        map.put(167517, "1e");


        map.put(165257, "CTX480");//
        map.put(76488, "FLUC");
        map.put(1679, "H");
        map.put(80945, "CTX960");

        //for regimen switch
        map.put(102, "1");

        map.put(165047, "NP");

        map.put(160559, "3");
        map.put(160567, "4");
        map.put(160561, "5");
        map.put(159834, "6");
        map.put(163523, "7");
        map.put(160566, "8");
        map.put(160569, "9");

        //reason for stopped regimen
        map.put(1434, "2");
        map.put(843, "3");
        map.put(159598, "4");
        map.put(5485, "5");
        map.put(1754, "6");
        map.put(819, "7");
        map.put(164435, "8");
        map.put(160016, "9");
        map.put(5622, "10");

        //Method of TB Diagnosis
        map.put(165990, "M1");
        map.put(165991, "M2");




        //DisclosureStatus
        map.put(167592, "OfferedDisclosure");
        map.put(167593, "AcceptedDisclosure");
        map.put(167594, "CommencedPartialDisclosure)");
        map.put(166270, "CompletedFullDisclosure)");

        //CryptococcalStatus
        map.put(167131, "NotScreened");
        map.put(167132, "ScreenedForCryptococcusAg");
        map.put(167133, "CrAgNegative");
        map.put(167134, "CrAgPositive");
        map.put(167135, "CSFCrAgNegativeCommencedOnPreEmptiveTherapy");
        map.put(167136, "DiagnosedWithCryptococcalMeningitis");
        map.put(167137, "CommencedTreatmentForCryptococcalMeningitis");
        map.put(0, "CompletedTreatmentForCryptococcalMeningitis");

        //CervicalCancerScreeningStatus
        map.put(167140, "NotOrdered");
        map.put(167141, "OrderedYetToScreen");
        map.put(167142, "ScreenedNegative");
        map.put(167143, "ScreenedPositiveYetToTreat");
        map.put(167144, "ScreenedPositiveAndTreated");
        map.put(167145, "ScreenedPositiveAndReferred");
        map.put(167146, "ScreenedPositiveAndDeclinedTreatment");
        map.put(167147, "SuspiciousForCancer");
        map.put(167148, "OtherFindings");

        //CervicalTreatmentProvided
        map.put(167151, "CR");
        map.put(167152, "TA");
        map.put(167153, "LE");

        //HepatitisStatus
        map.put(167665, "HepatitisBNegative");
        map.put(167664, "HepatitisBPositive");
        map.put(167663, "HepatitisCNegative");
        map.put(167662, "HepatitisCPositive");
        map.put(167661, "HepatitisBTreatment");
        map.put(0, "HepatitisCTreatment");

        //DSDStatusCode
        map.put(166151, "FBM1");
        map.put(167107, "FBM2");
        map.put(167108, "FBM3");
        map.put(167109, "FBM4");
        map.put(167110, "FBM5");
        map.put(167124, "FBM6");
        map.put(167659, "CBM1");
        map.put(167658, "CBM2");
        map.put(167113, "CBM3");
        map.put(167657, "CBM4");
        map.put(167656, "CBM5");
        map.put(167655, "CBM6");
        map.put(167654, "CBM7");
        map.put(167653, "CBM8");
        map.put(167652, "CBM9");


        //VLIndication
        map.put(164427, "Targeted");
        map.put(161236, "Routine");


        //ConsultHospitaliseRefer
        map.put(167649, "Consult");
        map.put(167648, "Hospitalise");
        map.put(167647, "Referred");

        //HealthInsuranceCode
        map.put(1107, "None");
        map.put(167444, "NHIA");
        map.put(167445, "BHCPF");
        map.put(167443, "SHIA");
        map.put(167452, "HMO");

    }

    public String getMappedValue(int conceptID) {
        if (map.containsKey(conceptID)) {
            return map.get(conceptID);
        }
        return null;
    }

    public String getFPMap(int conceptID) {
        if (fpmap.containsKey(conceptID)) {
            return fpmap.get(conceptID);
        }
        return null;
    }

    //EACCode
    private String eacMap (int conceptId){
        if (conceptId == 165643) {
            return "EAC1";
        }
        if (conceptId == 165644) {
            return "EAC2";
        }
        if (conceptId == 165645) {
            return "EAC3";
        }
        if (conceptId == 1107) {
            return "None";
        }
        if (conceptId == 5622) {
            return "EACAdditional";
        }
        return null;
    }

    private String pregantBF (int conceptId){
        if (conceptId == 165048) {
            return "Pregnant";
        }
        if (conceptId == 165049) {
            return "Breastfeeding";
        }

        return null;
    }


    //CotrimoxazoleCode / TPTMedication
    private String tptMap (int conceptId){
        if (conceptId == 1679) {
            return "SixH";
        }
        if (conceptId == 104943) {
            return "ThreeHP";
        }
        if (conceptId == 1678) {
            return "ThreeHR";
        }
        if (conceptId == 165257) {
            return "QTIP";
        }
        return null;
    }


    /*
         Completed
     */
    public List<HIVEncounterType> createHIVEncounterType(Patient patient, Map<Integer, List<Encounter>> groupedEncounters,
                                                         Map<Object, List<Obs>> groupedObsByVisitDate) throws DatatypeConfigurationException {

        List<HIVEncounterType> hivEncounterTypeList = new ArrayList<HIVEncounterType>();
        HIVEncounterType hivEncounterType = null;
        //Turn these to class level constants letter
        Integer[] encounterTypeArr = {
                Utils.ADULT_INITIAL_ENCOUNTER_TYPE,
                Utils.LAB_ORDER_AND_RESULT_ENCOUNTER_TYPE,
                Utils.PHARMACY_ENCOUNTER_TYPE,
                Utils.CARE_CARD_ENCOUNTER_TYPE};
        List<Encounter> allPatientEncounterList = Utils.extractEncounterList(groupedEncounters, Arrays.asList(encounterTypeArr));
        Set<Date> visitDateSet = Utils.extractUniqueVisitsForEncounterTypes(allPatientEncounterList);
        List<Obs> obsPerVisitDate = null;
//        Date artStartDate = Utils.extractARTStartDate(patient, allPatientObsList);//Optimize for performance
        for (Date date : visitDateSet) {
            String day = Utils.getFullDay(date);
            obsPerVisitDate = groupedObsByVisitDate.get(day);
            if (obsPerVisitDate  != null) {
                if(!obsPerVisitDate.isEmpty()) {
                    hivEncounterType = createHIVEncounterType(patient, date, obsPerVisitDate);
                }
                hivEncounterTypeList.add(hivEncounterType);
            }
        }
        return hivEncounterTypeList;
    }

    public HIVEncounterType createHIVEncounterType(Patient patient, Date visitDate, List<Obs> obsListForOneVisitList) throws DatatypeConfigurationException {

        List<Integer> obsCodeList = Arrays.asList(Utils.NEXT_APPOINTMENT_DATE_CONCEPT,Utils.WEIGHT_CONCEPT,Utils.CHILD_HEIGHT_CONCEPT,
                Utils.BLOOD_PRESSURE_SYSTOLIC_CONCEPT, Utils.BLOOD_PRESSURE_DYSTOLIC_CONCEPT, Utils.PREGNANCY_BREASTFEEDING_CONCEPT,
                Utils.FAMILY_PLANNING_STATUS_CONCEPT,Utils.FAMILY_PLANNING_METHOD_CONCEPT,Utils.FUNCTIONAL_STATUS_CONCEPT,
                Utils.WHO_CLINICAL_STAGE_CONCEPT,Utils.TB_STATUS_CONCEPT, Utils.CURRENT_REGIMEN_LINE_CONCEPT,
                Utils.OI_DRUGS_GROUPING_CONCEPT_SET,Utils.ARV_DRUG_STRENGTH_CONCEPT,
                Utils.COTRIMOXAZOLE_ADHERENCE_CONCEPT, Utils.INH_ADHERENCE_CONCEPT,Utils.CD4_COUNT_CONCEPT,Utils.VISIT_TYPE_CONCEPT,
                Utils.REASON_FOR_REGIMEN_SUBSTITUTION_OR_SWITCH_CONCEPT,Utils.NUMBER_OF_MISSED_DOSES_PER_MONTH_CONCEPT,
                Utils.ARV_ADHERENCE_CONCEPT, Utils.DATE_STOPPED_REGIMEN, Utils.REASON_STOPPED_REGIMEN, Utils.METHOD_OF_DIAGNOSIS);

        Map<Object, List<Obs>> obsListForOneVisit = Utils.groupedByConceptIdsOnly(obsListForOneVisitList);

        HIVEncounterType hivEncounterType = null;
        String visitID = "", pepfarID = "", ndrCode = "";
        //Date artStartDate=null;
        int valueCoded = 0;
        boolean valueBoolean = false;
        Obs obs = null;
        List<Obs> obsL = null;
        CodedSimpleType codedSimpleType = null;
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        //Check for nulls before calling these methods
        //  if (pepfarIdentifier != null) {
        pepfarID = pepfarIdentifier.getIdentifier();
        visitID = Utils.getVisitId(pepfarID, visitDate);
        hivEncounterType = new HIVEncounterType();
        hivEncounterType.setVisitID(visitID);
        hivEncounterType.setVisitDate(utils.getXmlDate(visitDate));

        //DurationOnArt: prefer recorded concept; fall back to months between ART start date and visit date
        obs = Utils.extractObs(Duration_On_ART_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setDurationOnArt(obs.getValueNumeric().intValue());
        }

        obs = Utils.extractObs(Utils.WEIGHT_CONCEPT, obsListForOneVisit); // Weight
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setWeight(obs.getValueNumeric().intValue());
        }
        /*obs = Utils.extractObs(Utils.CHILD_HEIGHT_CONCEPT, obsListForOneVisit); // Height
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setChildHeight(obs.getValueNumeric().intValue());
        }*/
        obs = Utils.extractObs(Height_Concept_Id, obsListForOneVisit); // Height
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setHeight(obs.getValueNumeric().intValue());
        }
        obs = Utils.extractObs(BMI_MUAC_Concept_Id, obsListForOneVisit); // BMIMUAC
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setBMIMUAC(BigDecimal.valueOf(obs.getValueNumeric()));
        }
        Obs obsSystolic = null, obsDystolic = null;
        String bloodPressure = "";
        String systolicBP = "", diastolicBP = "";
        obsSystolic = Utils.extractObs(Utils.BLOOD_PRESSURE_SYSTOLIC_CONCEPT, obsListForOneVisit);
        obsDystolic = Utils.extractObs(Utils.BLOOD_PRESSURE_DYSTOLIC_CONCEPT, obsListForOneVisit);
        if (obsSystolic != null && obsSystolic.getValueNumeric() != null && obsDystolic != null && obsDystolic.getValueNumeric() != null) {
            systolicBP = String.valueOf(obsSystolic.getValueNumeric().intValue());
            diastolicBP = String.valueOf(obsDystolic.getValueNumeric().intValue());
            bloodPressure = StringUtils.join(systolicBP, "/", diastolicBP);
            hivEncounterType.setBloodPressure(bloodPressure);
        }
        obs = Utils.extractObs(Utils.PREGNANCY_BREASTFEEDING_CONCEPT, obsListForOneVisit);
        //Verify that all value coded concepts has been mapped
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = pregantBF(valueCoded);
            hivEncounterType.setPregnancyBFStatus(ndrCode);
        }

        obs = Utils.extractObs(Utils.PREGNANCY_BREASTFEEDING_CONCEPT, obsListForOneVisit);
        //Verify that all value coded concepts has been mapped
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setEDDandPMTCTLink(ndrCode);
        }
        obs = Utils.extractObs(Utils.FAMILY_PLANNING_STATUS_CONCEPT, obsListForOneVisit);
        //Does False Mean Not on Family Planninng
        if (obs != null && obs.getValueAsBoolean() != null) {
            valueBoolean = obs.getValueAsBoolean();
            if (valueBoolean) {
                hivEncounterType.setPatientFamilyPlanningCode("FP");
            } else {
                hivEncounterType.setPatientFamilyPlanningCode("NOFP");
            }
        }
        //Verify that all family planning methods are mapped
        obs = Utils.extractObs(Utils.FAMILY_PLANNING_METHOD_CONCEPT, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getFPMap(valueCoded);
            hivEncounterType.setPatientFamilyPlanningMethodCode(ndrCode);
        }
        obs = Utils.extractObs(Utils.FUNCTIONAL_STATUS_CONCEPT, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setFunctionalStatus(ndrCode);
        }
        obs = Utils.extractObs(Disclosure_Status_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setDisclosureStatus(ndrCode);
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

        obs = Utils.extractObs(Cryptococcal_Status_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setCryptococcalStatus(ndrCode);
        }

        obs = Utils.extractObs(Cervical_Cancer_Screening_Status_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setCervicalCancerScreeningStatus(ndrCode);
        }

        obs = Utils.extractObs(Cervical_Treatment_Provided_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setCervicalTreatmentProvided(ndrCode);
        }

        // TODO enter correct Hepatitis_Status_Concept_Id missing
        obs = Utils.extractObs(Hepatitis_Status_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setHepatitisStatus(ndrCode);
        }

        obs = Utils.extractObs(DSD_Status_Code_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == DSD_FAC_CONCEPT_ID || valueCoded == DSD_COMMUNITY_CONCEPT_ID) {
                Obs modelObs = Utils.extractObs(valueCoded, obsListForOneVisit);
                if (modelObs != null && modelObs.getValueCoded() != null) {
                    hivEncounterType.setDSDStatusCode(getMappedValue(modelObs.getValueCoded().getConceptId()));
                }
            }
        }

        obs = Utils.extractObs(Date_Devolved_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueDate() != null) {
            hivEncounterType.setDateDevolved(utils.getXmlDate(obs.getValueDate()));
        }

        obs = Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT, obsListForOneVisit);
        String regimenName = "";
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            obs = Utils.extractObs(valueCoded, obsListForOneVisit);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                regimenName = obs.getValueCoded().getName().getName();
                ndrCode = getMappedValue(valueCoded);
                RegimenCodedSimpleType regimenCoded = new RegimenCodedSimpleType();
                regimenCoded.setCode(ndrCode);
                regimenCoded.setCodeDescTxt(regimenName);
                hivEncounterType.setARVDrugRegimen(regimenCoded);
            }
        }

        obs = Utils.extractObs(Utils.ARV_DRUG_ADHERENCE_CONCEPT, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setARVDrugAdherence(ndrCode);
        }

        obs = Utils.extractObs(Why_Poor_Fair_ARV_Drug_Adherence_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setWhyPoorFairARVDrugAdherence(ndrCode);
        }

        Obs oiDrugNameObs = null, oiStrengthObs = null;
        //Get the drugs that was entered for the day
        obs = Utils.extractObs(Utils.OI_DRUGS_GROUPING_CONCEPT_SET, obsListForOneVisit);
        if (obs != null) {

            Set<Obs> obsGroupMembersSet = obs.getGroupMembers();
            List<Obs> obsGroupMembersList = new ArrayList<>(obsGroupMembersSet);
//            List<Integer> obsGroupMembersListId = obsGroupMembersList.stream().map(Obs::getObsId).collect(Collectors.toList());
            oiDrugNameObs = Utils.extractObsByValues(Utils.OI_DRUGS_CONCEPT, Utils.COTRIMOXAZOLE_DRUG_CONCEPT, obsGroupMembersList);
            // What to do if they select wrong strength for CTX
            if (oiDrugNameObs != null) {
                oiStrengthObs =Utils.extractObs(Utils.ARV_DRUG_STRENGTH_CONCEPT, obsListForOneVisit);
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

        //Todo INH Dose


        obs = Utils.extractObs(Utils.INH_ADHERENCE_CONCEPT, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setINHAdherence(ndrCode);
        }

        obs = Utils.extractObs(Utils.CD4_COUNT_CONCEPT, obsListForOneVisit);
        int cd4Count = 0;
        if (obs != null && obs.getValueNumeric() != null) {
            cd4Count = obs.getValueNumeric().intValue();
            hivEncounterType.setCD4(cd4Count);
            hivEncounterType.setCD4TestDate(utils.getXmlDate(obs.getObsDatetime()));
        }
        obs = Utils.extractObs(Utils.REASON_FOR_REGIMEN_SUBSTITUTION_OR_SWITCH_CONCEPT, obsListForOneVisit);//ReasonForRegimenSwitchSubs
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setReasonForRegimenSwitchSubs(ndrCode);
        }

        obs = Utils.extractObs(Utils.VISIT_TYPE_CONCEPT, obsListForOneVisit);//PrescribedRegimenInitialIndicator
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.VISIT_TYPE_INITIAL_CONCEPT) {
                hivEncounterType.setPrescribedRegimenInitialIndicator(Boolean.TRUE);
            } else {
                hivEncounterType.setPrescribedRegimenInitialIndicator(Boolean.FALSE);
            }
        }

        obs = Utils.extractObs(Utils.NUMBER_OF_MISSED_DOSES_PER_MONTH_CONCEPT, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.MISSED_DOSES_FAIR_ADHERENCE_CONCEPT || valueCoded == Utils.MISSED_MEDICATION_POOR_ADHERENCE_CONCEPT) {
                hivEncounterType.setPoorAdherenceIndicator(Boolean.TRUE); //PoorAdherenceIndicator
            }
        } else {
            obs = Utils.extractObs(Utils.ARV_ADHERENCE_CONCEPT, obsListForOneVisit);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.ARV_ADHERENCE_FAIR_ADHERENCE_CONCEPT || valueCoded == Utils.ARV_ADHERENCE_POOR_ADHERENCE_CONCEPT) {
                    hivEncounterType.setPoorAdherenceIndicator(Boolean.TRUE);
                }
            }
        }

        hivEncounterType.setSubstitutionIndicator(retrieveSubstitutionIndicator(obsListForOneVisit));//SubstitutionIndicator
        hivEncounterType.setSwitchIndicator(retrieveSwitchIndicator(obsListForOneVisit));//SwitchIndicator

        DateTime nextAppointmentDate = null;
        //  nextAppointmentDate = Utils.extractMedicationDuration(visitDate, obsListForOneVisit);
        obs = Utils.extractObs(Utils.NEXT_APPOINTMENT_DATE_CONCEPT, obsListForOneVisit);
        if (obs != null) {
            nextAppointmentDate = new DateTime(obs.getValueDate());
            hivEncounterType.setNextAppointmentDate(utils.getXmlDate(nextAppointmentDate.toDate()));

        }

        hivEncounterType.setStoppedRegimen(retrieveStoppedRegimen(obsListForOneVisit));//Stopped Regimen
        if (retrieveStoppedRegimen(obsListForOneVisit)) {
            obs = Utils.extractObs(Utils.REASON_STOPPED_REGIMEN, obsListForOneVisit);//ReasonForRegimenStopped
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                hivEncounterType.setReasonForStoppedRegimen(ndrCode);
            }
        }

        DateTime dateStoppedRegimen = null;
        //  nextAppointmentDate = Utils.extractMedicationDuration(visitDate, obsListForOneVisit);
        obs = Utils.extractObs(Utils.DATE_STOPPED_REGIMEN, obsListForOneVisit);
        if (obs != null) {
            dateStoppedRegimen = new DateTime(obs.getValueDate());
            hivEncounterType.setDateStoppedRegimen(utils.getXmlDate(dateStoppedRegimen.toDate()));

        }

        // Method of TB Diagnosis
        obs = Utils.extractObs(Utils.METHOD_OF_DIAGNOSIS, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setMethodofTBDiagnosis(ndrCode);
        }

        obs = Utils.extractObs(TPT_Medication_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = tptMap(valueCoded);
            hivEncounterType.setTPTMedication(ndrCode);
        }

        obs = Utils.extractObs(TPT_Dose_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueText() != null) {
            hivEncounterType.setTPTDose(obs.getValueText());
        }

        obs = Utils.extractObs(TPT_Adherence_Code_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setTPTAdherenceCode(ndrCode);
        }


        obs = Utils.extractObs(VL_Result_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setVLResult(obs.getValueNumeric().intValue());
        }

        obs = Utils.extractObs(VL_Indication_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setVLIndication(ndrCode);
        }

        obs = Utils.extractObs(EAC_Code_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = eacMap(valueCoded);
            hivEncounterType.setEACCode(ndrCode);
        }

        obs = Utils.extractObs(Random_Blood_Sugar_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueNumeric() != null) {
            hivEncounterType.setRandomBloodSugar(BigDecimal.valueOf(obs.getValueNumeric()));
        }

        obs = Utils.extractObs(Consult_Hospitalise_Refer_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setConsultHospitaliseRefer(ndrCode);
        }

        obs = Utils.extractObs(Health_Insurance_Code_Concept_Id, obsListForOneVisit);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            ndrCode = getMappedValue(valueCoded);
            hivEncounterType.setHealthInsuranceCode(ndrCode);
        }

        return hivEncounterType;
    }

    private String resolvePatientFamilyPlanningCode(Boolean value) {

        if (value) {
            return "FP";
        } else {
            return "NOFP";
        }
    }

    private Boolean retrieveSubstitutionIndicator(Map<Object, List<Obs>> obsList) {
        int valueCoded = 0;

        List<Integer> obsCodeList = Arrays.asList(Utils.REGIMEN_MEDICATION_PLAN,
                Utils.REGIMEN_MEDICATION_PLAN_SUBSTITUTE_REGIMEN_CONCEPT_VALUE);

        Obs obs = Utils.extractObs(Utils.REGIMEN_MEDICATION_PLAN,obsList);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.REGIMEN_MEDICATION_PLAN_SUBSTITUTE_REGIMEN_CONCEPT_VALUE) {
                return Boolean.TRUE;
            }
        } else {
            obs = Utils.extractObs(Utils.PICKUP_REASON_CONCEPT,obsList);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.PICKUP_REASON_CONCEPT_SUBSTITUTE_VALUE) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private Boolean retrieveSwitchIndicator(Map<Object, List<Obs>> obsList) {
        int valueCoded = 0;
        List<Integer> obsCodeList = Arrays.asList(Utils.REGIMEN_MEDICATION_PLAN,
                Utils.PICKUP_REASON_CONCEPT);

//        Map<Integer, Obs> obsList = Utils.groupObsByConceptId(obsCodeList, obsIdList);

        Obs obs = Utils.extractObs(Utils.REGIMEN_MEDICATION_PLAN,obsList);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.REGIMEN_MEDICATION_PLAN_SWITCH_REGIMEN_CONCEPT_VALUE) {
                return Boolean.TRUE;
            }
        } else {
            obs = Utils.extractObs(Utils.PICKUP_REASON_CONCEPT,obsList);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                if (valueCoded == Utils.PICKUP_REASON_CONCEPT_SWITCH_VALUE) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private Boolean retrieveStoppedRegimen(Map<Object, List<Obs>> obsList) {
        int valueCoded = 0;
        List<Integer> obsCodeList = Arrays.asList(Utils.REGIMEN_MEDICATION_PLAN,
                Utils.PICKUP_REASON_CONCEPT);

        Obs obs = Utils.extractObs(Utils.REGIMEN_MEDICATION_PLAN,obsList);
        if (obs != null && obs.getValueCoded() != null) {
            valueCoded = obs.getValueCoded().getConceptId();
            if (valueCoded == Utils.REGIMEN_MEDICATION_REASON_STOPPED_REGIMEN_VALUE) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}