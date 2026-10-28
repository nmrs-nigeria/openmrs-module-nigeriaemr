package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PrepDictionary {

    private final Utils utils = new Utils();

    // Patient identifier index used for the PrEP UniqueClientId. TODO: set to the PrEP identifier index.
    private static final int PREP_IDENTIFIER_INDEX = 0;

    // ---- Common coded answers (Yes/No) --------------------------------------------------------
    private static final int YES_CONCEPT = 1065;
    private static final int NO_CONCEPT = 1066;


    // ---- ScreeningAndEligibility concepts -----------------------------------------------------
    private static final int SCR_DATE_OF_VISIT_CONCEPT = 165785;
    private static final int SCR_REFERRED_FROM_CONCEPT = 165480;
    private static final int SCR_SETTING_CONCEPT = 165839;
    private static final int SCR_VISIT_TYPE_CONCEPT = 164181;
    private static final int SCR_POPULATION_TYPE_CONCEPT = 167207;
    private static final int SCR_OCCUPATION_CONCEPT = 166522;
    private static final int SCR_EDUCATION_LEVEL_CONCEPT = 1712;
    private static final int SCR_MARITAL_STATUS_CONCEPT = 1054;
    private static final int SCR_CHILDREN_UNDER5_CONCEPT = 167432;
    private static final int SCR_WEIGHT_CONCEPT = 5089;
    private static final int SCR_TYPE_OF_SESSION_CONCEPT = 165793;
    private static final int SCR_SEX_PARTNERS_CONCEPT = 165186;
    private static final int SCR_PREGNANCY_STATUS_CONCEPT = 165050;
    private static final int SCR_PARTNER_HIV_POSITIVE_CONCEPT = 167760;
    private static final int SCR_PARTNER_INJECTS_DRUGS_CONCEPT = 167759;
    private static final int SCR_PARTNER_SEX_WITH_MEN_CONCEPT = 167758;
    private static final int SCR_PARTNER_TRANSGENDER_CONCEPT = 167431;
    private static final int SCR_PARTNER_MULTIPLE_NO_CONDOM_CONCEPT = 167430;
    private static final int SCR_UNPROTECTED_VAGINAL_CASUAL_CONCEPT = 167429;
    private static final int SCR_UNPROTECTED_ANAL_CONCEPT = 167428;
    private static final int SCR_SHARED_NEEDLES_CONCEPT = 167427;
    private static final int SCR_MORE_THAN_ONE_PARTNER_CONCEPT = 167426;
    private static final int SCR_PAID_FOR_SEX_CONCEPT = 167756;
    private static final int SCR_DRUG_USE_SUBSTANCES_CONCEPT = 167420;
    private static final int ANSWER_COCAINE_CONCEPT = 73650;
    private static final int ANSWER_HEROIN_CONCEPT = 77443;
    private static final int ANSWER_MARIJUANA_CONCEPT = 167749;
    private static final int ANSWER_AMPHETAMINE_CONCEPT = 71172;
    private static final int ANSWER_CODEINE_CONCEPT = 73667;
    private static final int ANSWER_OTHER_DRUGS_CONCEPT = 5622;
    private static final int SCR_ROUTE_OF_ADMINISTRATION_CONCEPT = 167746;
    private static final int ANSWER_ROUTE_INJECT_CONCEPT = 167745;
    private static final int ANSWER_ROUTE_SNIFF_CONCEPT = 167742;
    private static final int ANSWER_ROUTE_SNORT_CONCEPT = 167741;
    private static final int ANSWER_ROUTE_SMOKE_CONCEPT = 167739;

    private static final int SCR_DRUGS_FOR_SEX_ENHANCEMENT_CONCEPT = 167419;
    private static final int SCR_SEX_NO_CONDOM_72H_CONCEPT = 167734;
    private static final int SCR_SHARED_EQUIPMENT_72H_CONCEPT = 167401;
    private static final int SCR_COLD_FLU_2WK_CONCEPT = 167388;
    private static final int SCR_UNPROTECTED_28D_CONCEPT = 167731;
    private static final int SCR_FEMALE_VAGINAL_DISCHARGE_CONCEPT = 167397;
    private static final int SCR_FEMALE_LOWER_ABDO_PAIN_CONCEPT = 167396;
    private static final int SCR_MALE_URETHRAL_DISCHARGE_CONCEPT = 167395;
    private static final int SCR_MALE_SCROTUM_SWELLING_CONCEPT = 167394;
    private static final int SCR_GENITAL_SORES_CONCEPT = 167394;
    private static final int SCR_SWOLLEN_LYMPH_NODES_CONCEPT = 167393;
    private static final int SCR_ANAL_PAIN_STOOLING_CONCEPT = 167803;
    private static final int SCR_ANAL_ITCHING_CONCEPT = 167804;
    private static final int SCR_ANAL_DISCHARGE_CONCEPT = 167805;
    private static final int SCR_LAST_HIV_TEST_TIMEFRAME_CONCEPT = 167418;
    private static final int SCR_RECOMMENDED_HIV_RETEST_CONCEPT = 167416;
    private static final int SCR_TESTED_OTHER_SETTINGS_CONCEPT = 167415;
    private static final int SCR_HIV_TEST_RESULT_CONCEPT = 159427;
    private static final int SCR_ONGOING_RISK_BEHAVIORS_CONCEPT = 167414;
    private static final int SCR_SPECIFIC_EXPOSURE_3M_CONCEPT = 167413;
    private static final int SCR_ACUTE_INFECTION_RETEST_CONCEPT = 167412;
    private static final int SCR_HIV_NEGATIVE_CONCEPT = 167411;
    private static final int SCR_RISK_SCORE_ATLEAST_ONE_CONCEPT = 167410;
    private static final int SCR_NO_SIGNS_ACUTE_INFECTION_CONCEPT = 167409;
    private static final int SCR_NO_INDICATION_PEP_CONCEPT = 167408;
    private static final int SCR_NO_PROTEINURIA_CONCEPT = 167407;
    private static final int SCR_NO_LIVER_ABNORMALITIES_CONCEPT = 167406;
    private static final int SCR_NO_DDI_INJECTABLE_CONCEPT = 167405;
    private static final int SCR_NO_DRUG_HYPERSENSITIVITY_CONCEPT = 167404;
    private static final int SCR_PREP_OFFERED_CONCEPT = 167806;
    private static final int SCR_WILLING_TO_COMMENCE_CONCEPT = 167392;
    private static final int SCR_FIRST_TIME_THIS_YEAR_CONCEPT = 167704;
    private static final int SCR_REFERRED_OTHER_SERVICES_CONCEPT = 167703;
    private static final int SCR_REFERRAL_SERVICE_SPECIFY_CONCEPT = 165912;
    private static final int SCR_DECLINE_REASONS_CONCEPT = 167386;
    private static final int ANSWER_DECLINE_NO_NEED_CONCEPT = 167712;
    private static final int ANSWER_DECLINE_NO_DAILY_MED_CONCEPT = 167711;
    private static final int ANSWER_DECLINE_SIDE_EFFECTS_CONCEPT = 167710;
    private static final int ANSWER_DECLINE_STIGMATIZATION_CONCEPT = 167708;
    private static final int ANSWER_DECLINE_FOLLOWUP_TIME_CONCEPT = 167707;
    private static final int ANSWER_DECLINE_SAFETY_CONCEPT = 167706;
    private static final int ANSWER_DECLINE_EFFECTIVENESS_CONCEPT = 167705;
    private static final int SCR_DECLINE_OTHER_SPECIFY_CONCEPT = 5622;


    // ---- PEP follow-up visit concepts (flat/ungrouped obs on the encounter) --------------------
    private static final int PEP_FUV_MODE_OF_EXPOSURE_CONCEPT = 164843;
    private static final int PEP_FUV_DURATION_BEFORE_PEP_CONCEPT = 164846;
    private static final int PEP_FUV_BLOOD_PRESSURE_CONCEPT = 5085;
    private static final int PEP_FUV_BLOOD_PRESSURE_CONCEPT_Dia = 5086;
    private static final int PEP_FUV_HIV_STATUS_AT_EXPOSURE_CONCEPT = 164844;
    private static final int PEP_FUV_SIDE_EFFECTS_CONCEPT = 0;
    private static final int PEP_FUV_STI_SCREENING_CONCEPT = 160170;
    private static final int PEP_FUV_RISK_REDUCTION_CONCEPT = 165820;
    private static final int PEP_FUV_ADHERENCE_CONCEPT = 164847;
    private static final int PEP_FUV_PEP_REGIMEN_CONCEPT = 164855;
    private static final int PEP_FUV_DATE_PEP_START_CONCEPT = 159599;
    private static final int PEP_FUV_DATE_PEP_STOP_CONCEPT = 163284;
    private static final int PEP_FUV_HIV_RESULT_6WK_CONCEPT = 167695;
    private static final int PEP_FUV_HIV_RESULT_3M_CONCEPT = 167693;
    private static final int PEP_FUV_HIV_RESULT_6M_CONCEPT = 167692;
    private static final int PEP_FUV_REFER_IF_POSITIVE_CONCEPT = 1648;
    private static final int PEP_FUV_NEXT_APPOINTMENT_CONCEPT = 165036;



    // ---- PrEP follow-up visit concepts (flat/ungrouped obs on the encounter) -------------------
    private static final int PREP_FUV_VISIT_TYPE_CONCEPT = 164181;
    private static final int PREP_FUV_DURATION_MONTHS_CONCEPT = 0;
    private static final int PREP_FUV_PREGNANCY_STATUS_CONCEPT = 5272;
    private static final int PREP_FUV_WEIGHT_CONCEPT = 5089;
    private static final int PREP_FUV_BLOOD_PRESSURE_CONCEPT = 140147;
    private static final int PREP_FUV_HTS_RESULT_CONCEPT = 159427;
    private static final int PREP_FUV_SIDE_EFFECTS_CONCEPT = 0;
    private static final int PREP_FUV_STI_SCREENING_CONCEPT = 167367;
    private static final int PREP_FUV_RISK_REDUCTION_CONCEPT = 165820;
    private static final int PREP_FUV_ADHERENCE_CONCEPT = 818;
    private static final int PREP_FUV_REASON_POOR_ADHERENCE_CONCEPT = 0;
    private static final int PREP_FUV_PREP_TYPE_CONCEPT = 167376;
    private static final int PREP_FUV_PREP_REGIMEN_CONCEPT = 167375;
    private static final int PREP_FUV_MONTHS_REFILL_CONCEPT = 167365;
    private static final int PREP_FUV_OTHER_DRUGS_CONCEPT = 167619;
    private static final int PREP_FUV_DATE_URINALYSIS_CONCEPT = 167364;
    private static final int PREP_FUV_URINALYSIS_RESULT_CONCEPT = 167794;
    private static final int PREP_FUV_DATE_HEPATITIS_CONCEPT = 167737;
    private static final int PREP_FUV_HEPATITIS_RESULT_CONCEPT = 166036;
    private static final int PREP_FUV_DATE_SYPHILIS_CONCEPT = 164952;
    private static final int PREP_FUV_SYPHILIS_RESULT_CONCEPT = 167450;
    private static final int PREP_FUV_DATE_LIVER_CONCEPT = 167789;
    private static final int PREP_FUV_LIVER_RESULT_CONCEPT = 167807;
    private static final int PREP_FUV_DATE_OTHER_TESTS_CONCEPT = 167738;
    private static final int PREP_FUV_OTHER_TESTS_RESULT_CONCEPT = 167740;
    private static final int PREP_FUV_SUSPECTED_ACUTE_CONCEPT = 0;
    private static final int PREP_FUV_EARLY_VL_RESULT_CONCEPT = 0;
    private static final int PREP_FUV_NEXT_APPOINTMENT_CONCEPT = 165036;

    // ---- CardEnrollment concepts --------------------------------------------------------------
    private static final int CARD_ENROLLMENT_TYPE_CONCEPT = 160540;
    private static final int CARD_DATE_ENROLLED_CONCEPT = 167384;
    private static final int CARD_PARTNER_ANC_ART_NUMBER_CONCEPT = 167383;
    private static final int CARD_MARITAL_STATUS_CONCEPT = 1054;
    private static final int CARD_OCCUPATION_CONCEPT = 166522;
    private static final int CARD_EDUCATION_LEVEL_CONCEPT = 1712;
    private static final int CARD_HIV_TESTING_POINT_CONCEPT = 167379;
    private static final int CARD_DATE_LAST_HIV_TEST_CONCEPT = 160554;
    private static final int CARD_HIV_TEST_RESULT_CONCEPT = 159427;
    private static final int CARD_DATE_REFERRED_CONCEPT = 167377;
    private static final int CARD_POPULATION_TYPE_CONCEPT = 167207;
    private static final int CARD_OTHER_POPULATION_CONCEPT = 5462;
    private static final int CARD_DATE_INITIAL_ADHERENCE_CONCEPT = 165038;
    private static final int CARD_DATE_STARTED_CONCEPT = 166389;
    private static final int CARD_PREP_TYPE_AT_START_CONCEPT = 167376;
    private static final int CARD_PREP_REGIMEN_CONCEPT = 167375;
    private static final int CARD_WEIGHT_CONCEPT = 5089;
    private static final int CARD_HEIGHT_CONCEPT = 5090;
    private static final int CARD_BMI_CONCEPT = 1342;
    private static final int CARD_IS_PREGNANT_CONCEPT = 5272;
    private static final int CARD_IS_BREASTFEEDING_CONCEPT = 5632;
    private static final int CARD_DRUG_ALLERGIES_CONCEPT = 0;
    private static final int CARD_DDI_CONCEPT = 167405;
    private static final int CARD_URINALYSIS_RESULT_CONCEPT = 160987;
    private static final int CARD_LIVER_FUNCTION_RESULT_CONCEPT = 167484;
    private static final int CARD_REFERRED_AT_INITIATION_CONCEPT = 167647;
    private static final int CARD_DATE_REFERRED_INITIATION_CONCEPT = 165027;
    private static final int CARD_SERVICE_REFERRED_FOR_CONCEPT = 165776;
    private static final int CARD_PEP_COMPLETION_CONCEPT = 0;

    // PEP follow-up entries nested inside the card
    private static final int PEP_ENTRY_GROUP_CONCEPT = 0;
    private static final int PEP_ENTRY_FOLLOWUP_DATE_CONCEPT = 0;
    private static final int PEP_ENTRY_HIV_RESULT_CONCEPT = 0;
    private static final int PEP_ENTRY_EARLY_VL_RESULT_CONCEPT = 0;


    // ---- Discontinuation concepts -------------------------------------------------------------
    private static final int DISC_INTERRUPTION_GROUP_CONCEPT = 167730;
    private static final int DISC_INTERRUPTION_REASON_CONCEPT = 167729;
    private static final int DISC_INTERRUPTION_DATE_CONCEPT = 167588;
    private static final int DISC_INTERRUPTION_WHY_CONCEPT = 167728;
    private static final int DISC_INTERRUPTION_RESTART_DATE_CONCEPT = 160738;
    private static final int DISC_DATE_REFERRED_OUT_CONCEPT = 161561;
    private static final int DISC_FACILITY_REFERRED_TO_CONCEPT = 165483;
    private static final int DISC_DATE_CLIENT_DIED_CONCEPT = 165418;
    private static final int DISC_SOURCE_DEATH_INFO_CONCEPT = 167485;
    private static final int DISC_CAUSE_OF_DEATH_CONCEPT = 1599;
    private static final int DISC_REASON_CONCEPT = 0;
    private static final int DISC_DATE_CONCEPT = 0;
    private static final int DISC_ART_LINK_DATE_CONCEPT = 0;


    private final Map<Integer, String> codedDictionary = new HashMap<>();
    private final Map<Integer, String> pepDictionary = new HashMap<>();
    private final Map<Integer, String> hivResultDictionary = new HashMap<>();
    private final Map<Integer, Boolean> booleanDictionary = new HashMap<>();
    private final Map<Integer, String> screenDictionary = new HashMap<>();
    private final Map<Integer, String> popDictionary = new HashMap<>();

    public PrepDictionary() {
        loadCodedDictionary();
        loadBooleanDictionary();
    }

    private void loadBooleanDictionary() {
        booleanDictionary.put(YES_CONCEPT, Boolean.TRUE);
        booleanDictionary.put(NO_CONCEPT, Boolean.FALSE);
    }

    private void loadCodedDictionary() {
        //----PepFollowUp-------
        //Mode of HIV exposure; use code per tool specification
        //1 = Occupational, 2 = Non-Occupational, 3 = Suspected Acute HIV Infection
        codedDictionary.put(164838, "1");
        codedDictionary.put(164837, "2");
        codedDictionary.put(149741, "3");
        //Time elapsed between exposure and PEP provision;
        // use code per tool specification
        //1=Less than 24 Hours | 2=Less than 48 Hours | 3=Less than 72 Hours | 4=More than 72 Hours
        codedDictionary.put(164449, "1");
        codedDictionary.put(167690, "2");
        codedDictionary.put(163733, "3");
        codedDictionary.put(163734, "4");
        //Exposure HIV status of source person at time of exposure; use code per tool specification
        //1=Positive| 2=Negative | 3=Suspected Acute HIV Infection
        codedDictionary.put(703, "1");
        codedDictionary.put(664, "2");
        codedDictionary.put(1138, "3");
        //Syndromic STI screening results at this PEP follow-up visit
        //0=No syndromic STI symptoms/signs, 1=Urethral discharge, 2=Genital ulcer, 3=Vaginal discharge, 4=Lower abdominal pain,
        //5=Scrotal swelling, 6=Anal warts, 7=Genital warts, 8=Inguinal bubo, 9=Others
        pepDictionary.put(123529, "1");
        pepDictionary.put(864, "2");
        pepDictionary.put(123396, "3");
        pepDictionary.put(157544, "4");
        pepDictionary.put(165812, "5");
        pepDictionary.put(155080, "6");
        pepDictionary.put(139505, "7");
        pepDictionary.put(125207, "8");
        pepDictionary.put(5622, "9");
        //Adherence
        codedDictionary.put(165287, "G");
        codedDictionary.put(165288, "F");
        codedDictionary.put(165289, "P");
        //PEP regimen at this follow-up visit
        //1=TDF+3TC+DTG | 2=Other
        codedDictionary.put(165681, "1");
        codedDictionary.put(5622, "2");
        //HIV Test result followup
        hivResultDictionary.put(703, "Pos");
        hivResultDictionary.put(664, "Neg");
        // Risk reduction services received at this PEP follow-up visit
        //1=Risk Reduction strategies discussed | 2 = Plan 1 plus correct condom use demonstrated
        // | Plan 1 and 2 plus lubricant provided
        codedDictionary.put(167366, "1");
        codedDictionary.put(167699, "2");//468dc653-5000-4903-838b-01258cbfc5ec
        codedDictionary.put(167698, "3");//0d2edd4a-b8aa-48e7-a5ec-2d9e74954cfa
        codedDictionary.put(1065, "Yes");
        codedDictionary.put(1066, "No");

        //1=Initiation, 2=SecondInitiation, 3=Refill/Re-Injection,
        //4=MethodSwitch, 5=Restart, 6=TransferIn, 7=NoPrepProvided,
        //8=Discontinuation, 9=DiscontinuationFollowUp
        codedDictionary.put(167776, "1");
        codedDictionary.put(167775, "2");
        codedDictionary.put(167774, "3");
        codedDictionary.put(167773, "4");
        codedDictionary.put(167772, "5");
        codedDictionary.put(160563, "6");
        codedDictionary.put(167771, "7");
        codedDictionary.put(167770, "8");
        codedDictionary.put(167769, "9");

        //Pregnant Status
        codedDictionary.put(165048, "P");
        codedDictionary.put(167174, "BF");
        codedDictionary.put(165047, "NP");

        //PrEP type at this visit
        //1 = Oral, 2 = Injectable, 3 = Ring, 4 = Others
        codedDictionary.put(167783, "1");
        codedDictionary.put(167743, "2");
        codedDictionary.put(162473, "3");
        codedDictionary.put(5622, "4");

        //PrEP regimen at this visit
        //1 = TDF/FTC, 2 = TDF/3TC,
        // 3 = Cabotegravir, 4= Lenacapavir
        codedDictionary.put(104567, "1");
        codedDictionary.put(161364, "2");
        codedDictionary.put(167523, "3");
        codedDictionary.put(167516, "4");

        //Urinalysis result from register field
        //1= No proteinuria, 2= Proteinuria Present - One +,
        // 3= Proteinuria Present - Two ++, 4= Proteinuria Present - Three +++
        /*codedDictionary.put(, "1");
        codedDictionary.put(, "2");
        codedDictionary.put(, "3");
        codedDictionary.put(, "4");*/

        //Hepatitis test result from register field
        //1= Hepatitis B Postivie, 2 = Hepatitis B Negative, 3= Hepatitis C Positive, 4= Hepatitis C Negative
        //5 = HIV/HBV Coinfected, 6 = HIV/HCV Coinfected
        /*codedDictionary.put(, "1");
        codedDictionary.put(, "2");
        codedDictionary.put(, "3");
        codedDictionary.put(, "4");
        codedDictionary.put(, "5");
        codedDictionary.put(, "6");*/

        //Syphilis test result from register field
        //1= Negative, 2 = Positive, 3= Not Done, 4 = Others
        codedDictionary.put(664, "1");
        codedDictionary.put(703, "2");
        codedDictionary.put(1118, "3");
        //codedDictionary.put(5622, "4");

        // Liver function test result from register field
        // 1=Alanine Aminoransferase (ALT) Normal | 2=Alanine Aminoransferase (ALT) Deranged | 3=Alkaline Phosphatase (ALP) Normal |
        //  4= Alkaline Phosphatase (ALP) Deranged | 5 = Aspartate Aminoransferase (AST) Normal |
        //  6=Aspartate Aminoransferase (AST) Deranged | 7=Gamma Glutamyl transferase (GGT) Normal |
        //  8=Gamma Glutamyl transferase (GGT) Deranged | 9=Bilirubin Normal | 10=Bilirubin Deranged |
        //  11=Albumin Normal | 12=Albumin Deranged | 13=Total protein Normal | 14=Total protein Deranged
        codedDictionary.put(167809, "1");
        codedDictionary.put(167810, "2");
        codedDictionary.put(167811, "3");
        codedDictionary.put(167812, "4");
        codedDictionary.put(167813, "5");
        codedDictionary.put(167814, "6");
        codedDictionary.put(167815, "7");
        codedDictionary.put(167816, "8");
        codedDictionary.put(167817, "9");
        codedDictionary.put(167818, "10");
        codedDictionary.put(167819, "11");
        codedDictionary.put(167820, "12");
        codedDictionary.put(167821, "13");
        codedDictionary.put(167822, "14");

        //Other test result from register field;
        //1=HB/PCV|2=WBC+Diff | 3=ALT|4=AST|5=Creatinine|6=Lipid Profile | 7=HBsAg|
        //8=Urinalysis |9=Sputum AFB |10=Chest Xray |11=Others
        codedDictionary.put(165395, "1");
        codedDictionary.put(649, "2");
        codedDictionary.put(654, "3");
        codedDictionary.put(653, "4");
        codedDictionary.put(165756, "5");
        codedDictionary.put(1010, "6");
        codedDictionary.put(159430, "7");
        codedDictionary.put(302, "8");
        codedDictionary.put(165968, "9");
        codedDictionary.put(12, "10");
        codedDictionary.put(5256, "11");



        //ReferredFrom
        screenDictionary.put(978, "Self");
        screenDictionary.put(0, "Counselor"); //8604a382-4cf7-4c78-a555-1172e004cf4b
        screenDictionary.put(165349, "Peer");
        screenDictionary.put(5256, "Other");

        //FacilitySetting
        screenDictionary.put(160539, "CT");
        screenDictionary.put(160529, "TB");
        screenDictionary.put(160546, "STI");
        screenDictionary.put(5271, "FP");
        screenDictionary.put(160542, "OPD");
        screenDictionary.put(161629, "Ward");
        screenDictionary.put(160545, "Outreach");
        screenDictionary.put(165838, "StandaloneHTS");

        //1=SerodiscordantCouples, 2=SexWorkers, 3=PartnersOfSexWorkers,
        //4=InjectingDrugUsers, 5=AnalSexIndividuals,
        //6=ExposedAdolescentsAndYoungPeople, 7=Transgender,
        //8=OtherPopulation, 9=AtRiskPregnantAndBreastfeedingWomen
        popDictionary.put(167768, "1");
        popDictionary.put(160579, "2");
        popDictionary.put(167767, "3");
        popDictionary.put(167766, "4");
        popDictionary.put(167765, "5");
        popDictionary.put(167763, "6");
        popDictionary.put(166287, "7");
        popDictionary.put(5622, "8");
        popDictionary.put(0, "9"); //7f199288-bebe-4a21-a399-56df6392d9e9
        //TypeSession
        screenDictionary.put(165792, "Individual");
        screenDictionary.put(165789, "Couple");

        //SexPartners
        screenDictionary.put(165184,"Male");
        screenDictionary.put(165185,"Female");
        screenDictionary.put(0,"Both");

        //LastHIVTestTimeFrame
        screenDictionary.put(167725, "LessThan1Month");
        screenDictionary.put(167723, "1To3Months");
        screenDictionary.put(167722, "4To6Months");
        screenDictionary.put(167721, "MoreThan6Months");

        //Result
        screenDictionary.put(703, "Positive");
        screenDictionary.put(664, "Negative");


        //Interrupt
        //InterruptionReason
        codedDictionary.put(165385, "S");
        codedDictionary.put(167587, "D");



    }





    public PrEPType createPrEPType(Patient patient, Map<Integer, List<Encounter>> groupedEncounters) {
        PrEPType prepType = new PrEPType();
        boolean hasValue = false;
        try {
            // Screening & Eligibility (repeatable)
            List<Encounter> screeningEncounters = groupedEncounters.get(ConstantsUtil.PREP_SCREENING_ENCOUNTER_TYPE);
            if (screeningEncounters != null) {
                for (Encounter enc : screeningEncounters) {
                    PrepScreeningAndEligibilityType screening = createScreeningAndEligibility(patient, enc, groupObs(enc));
                    prepType.getScreeningAndEligibility().add(screening);
                    hasValue = true;
                }
            }

            // PEP Follow-up Visit (repeatable)
            List<Encounter> pepFollowUpEncounters = groupedEncounters.get(ConstantsUtil.PEP_FOLLOWUP_ENCOUNTER_TYPE);
            if (pepFollowUpEncounters != null) {
                for (Encounter enc : pepFollowUpEncounters) {
                    PepFollowUpVisitType visit = createPepFollowUpVisit(enc, groupObs(enc));
                    if (visit != null) {
                        prepType.getPepFollowUpVisit().add(visit);
                        hasValue = true;
                    }
                }
            }

            // Card Enrollment (single - latest)
            Encounter cardEncounter = Utils.getLatestEncounter(groupedEncounters.get(ConstantsUtil.PREP_CARD_ENROLLMENT_ENCOUNTER_TYPE));
            if (cardEncounter != null) {
                PrepPepCardEnrollmentType cardEnrollment = createCardEnrollment(patient, groupObs(cardEncounter));
                prepType.setCardEnrollment(cardEnrollment);
                hasValue = true;
            }


            // PrEP Follow-up Visit (repeatable)
            List<Encounter> prepFollowUpEncounters = groupedEncounters.get(ConstantsUtil.PREP_FOLLOWUP_ENCOUNTER_TYPE);
            if (prepFollowUpEncounters != null) {
                for (Encounter enc : prepFollowUpEncounters) {
                    PrepFollowUpVisitType visit = createPrepFollowUpVisit(enc, groupObs(enc));
                    if (visit != null) {
                        prepType.getPrepFollowUpVisit().add(visit);
                        hasValue = true;
                    }
                }
            }

           // Discontinuation (single - latest)
            Encounter discontinuationEncounter = Utils.getLatestEncounter(groupedEncounters.get(ConstantsUtil.PREP_DISCONTINUATION_ENCOUNTER_TYPE));
            if (discontinuationEncounter != null) {
                PrepDiscontinuationType discontinuation = createDiscontinuation(groupObs(discontinuationEncounter));
                if (discontinuation != null) {
                    prepType.setDiscontinuation(discontinuation);
                    hasValue = true;
                }
            }

        } catch (Exception ex) {
            LoggerUtils.write(PrepDictionary.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
        }
        return hasValue ? prepType : null;
    }

    private Map<Object, List<Obs>> groupObs(Encounter encounter) {
        return Utils.groupedByConceptIdsOnly(new ArrayList<>(encounter.getAllObs()));
    }


    // ============================ Screening & Eligibility ======================================

    private PrepScreeningAndEligibilityType createScreeningAndEligibility(Patient patient, Encounter encounter,
                                                                          Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PrepScreeningAndEligibilityType screening = new PrepScreeningAndEligibilityType();

        // UniqueClientId (required) - derive from a patient identifier
        PatientIdentifier prepId = patient.getPatientIdentifier(PREP_IDENTIFIER_INDEX);
        if (prepId != null) {
            screening.setUniqueClientId(prepId.getIdentifier());
        } else if (patient.getPatientIdentifier() != null) {
            screening.setUniqueClientId(patient.getPatientIdentifier().getIdentifier());
        }

        // DateOfVisit (required) - default to encounter date, override if captured as an obs
        Obs obs = extractObs(SCR_DATE_OF_VISIT_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            screening.setDateOfVisit(utils.getXmlDate(obs.getValueDate()));
        } else if (encounter != null && encounter.getEncounterDatetime() != null) {
            screening.setDateOfVisit(utils.getXmlDate(encounter.getEncounterDatetime()));
        }

        setDictCoded(screening::setReferredFrom, SCR_REFERRED_FROM_CONCEPT,screenDictionary, groupedObsByConcept);
        setDictCoded(screening::setSetting, SCR_SETTING_CONCEPT, screenDictionary, groupedObsByConcept);
        setCoded(screening::setVisitType, SCR_VISIT_TYPE_CONCEPT, groupedObsByConcept);
        setDictCoded(screening::setPopulationType, SCR_POPULATION_TYPE_CONCEPT, popDictionary, groupedObsByConcept);
        setText(screening::setOccupation, SCR_OCCUPATION_CONCEPT, groupedObsByConcept);
        setText(screening::setEducationLevel, SCR_EDUCATION_LEVEL_CONCEPT, groupedObsByConcept);
        setText(screening::setMaritalStatus, SCR_MARITAL_STATUS_CONCEPT, groupedObsByConcept);
        setInteger(screening::setNumberOfOwnChildrenUnder5, SCR_CHILDREN_UNDER5_CONCEPT, groupedObsByConcept);
        setDecimal(screening::setWeight, SCR_WEIGHT_CONCEPT, groupedObsByConcept);
        setCoded(screening::setTypeOfSession, SCR_TYPE_OF_SESSION_CONCEPT, groupedObsByConcept);
        setCoded(screening::setSexPartners, SCR_SEX_PARTNERS_CONCEPT, groupedObsByConcept);
        setCoded(screening::setPregnancyStatus, SCR_PREGNANCY_STATUS_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPartnerIsHivPositive, SCR_PARTNER_HIV_POSITIVE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPartnerInjectsDrugs, SCR_PARTNER_INJECTS_DRUGS_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPartnerHasSexWithMen, SCR_PARTNER_SEX_WITH_MEN_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPartnerIsTransgender, SCR_PARTNER_TRANSGENDER_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPartnerHasMultiplePartnersWithoutCondoms, SCR_PARTNER_MULTIPLE_NO_CONDOM_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setUnprotectedVaginalSexWithCasualPartner, SCR_UNPROTECTED_VAGINAL_CASUAL_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setUnprotectedAnalSex, SCR_UNPROTECTED_ANAL_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setSharedNeedlesOrInjectingMaterials, SCR_SHARED_NEEDLES_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setMoreThanOneSexPartner, SCR_MORE_THAN_ONE_PARTNER_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPaidOrBeenPaidForSex, SCR_PAID_FOR_SEX_CONCEPT, groupedObsByConcept);

        screening.setUsesCocaine(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_COCAINE_CONCEPT, groupedObsByConcept));
        screening.setUsesHeroin(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_HEROIN_CONCEPT, groupedObsByConcept));
        screening.setUsesMarijuana(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_MARIJUANA_CONCEPT, groupedObsByConcept));
        screening.setUsesAmphetamine(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_AMPHETAMINE_CONCEPT, groupedObsByConcept));
        screening.setUsesCodeineSyrup(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_CODEINE_CONCEPT, groupedObsByConcept));
        screening.setUsesOtherDrugs(answerSelected(SCR_DRUG_USE_SUBSTANCES_CONCEPT, ANSWER_OTHER_DRUGS_CONCEPT, groupedObsByConcept));

        screening.setRouteInject(answerSelected(SCR_ROUTE_OF_ADMINISTRATION_CONCEPT, ANSWER_ROUTE_INJECT_CONCEPT, groupedObsByConcept));
        screening.setRouteSniff(answerSelected(SCR_ROUTE_OF_ADMINISTRATION_CONCEPT, ANSWER_ROUTE_SNIFF_CONCEPT, groupedObsByConcept));
        screening.setRouteSnort(answerSelected(SCR_ROUTE_OF_ADMINISTRATION_CONCEPT, ANSWER_ROUTE_SNORT_CONCEPT, groupedObsByConcept));
        screening.setRouteSmoke(answerSelected(SCR_ROUTE_OF_ADMINISTRATION_CONCEPT, ANSWER_ROUTE_SMOKE_CONCEPT, groupedObsByConcept));


        setBoolean(screening::setUsesDrugsForSexualEnhancement, SCR_DRUGS_FOR_SEX_ENHANCEMENT_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHadSexWithoutCondomUnkHivStatLast72Hours, SCR_SEX_NO_CONDOM_72H_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setSharedInjectionEquipmentUnkHivStatLast72Hours, SCR_SHARED_EQUIPMENT_72H_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHadColdFluSymptomsLast2Weeks, SCR_COLD_FLU_2WK_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHadUnprotectedSexOrSharedMaterialsLast28Days, SCR_UNPROTECTED_28D_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setFemaleVaginalDischargeOrBurning, SCR_FEMALE_VAGINAL_DISCHARGE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setFemaleLowerAbdominalPain, SCR_FEMALE_LOWER_ABDO_PAIN_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setMaleUrethralDischargeOrBurning, SCR_MALE_URETHRAL_DISCHARGE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setMaleScrotumSwellingAndPain, SCR_MALE_SCROTUM_SWELLING_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setGenitalSores, SCR_GENITAL_SORES_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setSwollenInguinalLymphNodes, SCR_SWOLLEN_LYMPH_NODES_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setAnalPainOnStooling, SCR_ANAL_PAIN_STOOLING_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setAnalItching, SCR_ANAL_ITCHING_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setAnalDischarge, SCR_ANAL_DISCHARGE_CONCEPT, groupedObsByConcept);
        setCoded(screening::setLastHivTestTimeframe, SCR_LAST_HIV_TEST_TIMEFRAME_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setRecommendedForHivRetest, SCR_RECOMMENDED_HIV_RETEST_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setTestedInOtherClinicalSettings, SCR_TESTED_OTHER_SETTINGS_CONCEPT, groupedObsByConcept);
        setCoded(screening::setHivTestResult, SCR_HIV_TEST_RESULT_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setReportsOngoingHivRiskBehaviors, SCR_ONGOING_RISK_BEHAVIORS_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setReportsSpecificHivExposureLast3Months, SCR_SPECIFIC_EXPOSURE_3M_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setAcuteHivInfectionRetestRecommended, SCR_ACUTE_INFECTION_RETEST_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHivNegative, SCR_HIV_NEGATIVE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHivRiskScoreAtLeastOne, SCR_RISK_SCORE_ATLEAST_ONE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setNoSignsOfAcuteHivInfection, SCR_NO_SIGNS_ACUTE_INFECTION_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setNoIndicationForPep, SCR_NO_INDICATION_PEP_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setHasNoProteinuria, SCR_NO_PROTEINURIA_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setNoHistoryOfLiverAbnormalities, SCR_NO_LIVER_ABNORMALITIES_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setNoHistoryOfDrugDrugInteractionsForInjectable, SCR_NO_DDI_INJECTABLE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setNoHistoryOfDrugHypersensitivity, SCR_NO_DRUG_HYPERSENSITIVITY_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setPrepOffered, SCR_PREP_OFFERED_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setWillingToCommencePrEP, SCR_WILLING_TO_COMMENCE_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setReceivedPrepForFirstTimeThisYear, SCR_FIRST_TIME_THIS_YEAR_CONCEPT, groupedObsByConcept);
        setBoolean(screening::setClientReferredToOtherServices, SCR_REFERRED_OTHER_SERVICES_CONCEPT, groupedObsByConcept);
        setText(screening::setReferralServiceSpecify, SCR_REFERRAL_SERVICE_SPECIFY_CONCEPT, groupedObsByConcept);

        screening.setDeclineNoNeedForPrep(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_NO_NEED_CONCEPT, groupedObsByConcept));
        screening.setDeclineDoesNotWishDailyMedication(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_NO_DAILY_MED_CONCEPT, groupedObsByConcept));
        screening.setDeclineConcernAboutSideEffects(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_SIDE_EFFECTS_CONCEPT, groupedObsByConcept));
        screening.setDeclineConcernAboutStigmatization(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_STIGMATIZATION_CONCEPT, groupedObsByConcept));
        screening.setDeclineConcernAboutClinicFollowupTime(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_FOLLOWUP_TIME_CONCEPT, groupedObsByConcept));
        screening.setDeclineConcernAboutSafetyOfMedication(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_SAFETY_CONCEPT, groupedObsByConcept));
        screening.setDeclineConcernAboutEffectiveness(answerSelected(SCR_DECLINE_REASONS_CONCEPT, ANSWER_DECLINE_EFFECTIVENESS_CONCEPT, groupedObsByConcept));
        setText(screening::setDeclineOtherReasonSpecify, SCR_DECLINE_OTHER_SPECIFY_CONCEPT, groupedObsByConcept);

        return screening;
    }

    // ============================ PEP Follow-up visits =========================================

    private PepFollowUpVisitType createPepFollowUpVisit(Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept) {
        // Like the PrEP follow-up visit, PEP follow-up fields are flat (ungrouped) obs on the
        // encounter, so each PEP follow-up encounter yields a single visit.
        PepFollowUpVisitType visit = new PepFollowUpVisitType();
        boolean hasValue = false;

        visit.setVisitDate(utils.getXmlDate(encounter.getEncounterDatetime()));
        hasValue |= setCoded(visit::setModeOfExposure, PEP_FUV_MODE_OF_EXPOSURE_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setDurationBeforePepProvided, PEP_FUV_DURATION_BEFORE_PEP_CONCEPT, groupedObsByConcept);
        hasValue |= setBloodPressure(visit::setBloodPressure, groupedObsByConcept);
        hasValue |= setCoded(visit::setHivStatusAtExposure, PEP_FUV_HIV_STATUS_AT_EXPOSURE_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setNotedSideEffects, PEP_FUV_SIDE_EFFECTS_CONCEPT, groupedObsByConcept);
        hasValue |= setOtherCoded(visit::setSyndromicSTIScreening, PEP_FUV_STI_SCREENING_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setRiskReductionServices, PEP_FUV_RISK_REDUCTION_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setAdherence, PEP_FUV_ADHERENCE_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setPepRegimen, PEP_FUV_PEP_REGIMEN_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDatePepGivenStart, PEP_FUV_DATE_PEP_START_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDatePepGivenStop, PEP_FUV_DATE_PEP_STOP_CONCEPT, groupedObsByConcept);
        hasValue |= setDictCoded(visit::setFollowUpHivTestResult1St6Weeks, PEP_FUV_HIV_RESULT_6WK_CONCEPT, hivResultDictionary, groupedObsByConcept);
        hasValue |= setDictCoded(visit::setFollowUpHivTestResult2Nd3Months, PEP_FUV_HIV_RESULT_3M_CONCEPT, hivResultDictionary, groupedObsByConcept);
        hasValue |= setDictCoded(visit::setFollowUpHivTestResult3Rd6Months, PEP_FUV_HIV_RESULT_6M_CONCEPT, hivResultDictionary, groupedObsByConcept);
        hasValue |= setCoded(visit::setReferIfPositive, PEP_FUV_REFER_IF_POSITIVE_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setNextAppointmentDate, PEP_FUV_NEXT_APPOINTMENT_CONCEPT, groupedObsByConcept);

        if (!hasValue) {
            return null;
        }
        visit.setVisitID(resolveVisitId(encounter));
        return visit;
    }

    // ============================ PrEP Follow-up visits ========================================
    private PrepFollowUpVisitType createPrepFollowUpVisit(Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept) {
        PrepFollowUpVisitType visit = new PrepFollowUpVisitType();
        boolean hasValue = false;
        visit.setVisitDate(utils.getXmlDate(encounter.getEncounterDatetime()));
        hasValue |= setDictCoded(visit::setVisitType, PREP_FUV_VISIT_TYPE_CONCEPT, popDictionary, groupedObsByConcept);
        hasValue |= setInteger(visit::setDurationOnPrepMonths, PREP_FUV_DURATION_MONTHS_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setPregnancyStatus, PREP_FUV_PREGNANCY_STATUS_CONCEPT, groupedObsByConcept);
        hasValue |= setDecimal(visit::setWeight, PREP_FUV_WEIGHT_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setBloodPressure, PREP_FUV_BLOOD_PRESSURE_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setHtsResult, PREP_FUV_HTS_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setNotedSideEffects, PREP_FUV_SIDE_EFFECTS_CONCEPT, groupedObsByConcept);
        hasValue |= setOtherCoded(visit::setSyndromicSTIScreening, PREP_FUV_STI_SCREENING_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setRiskReductionServices, PREP_FUV_RISK_REDUCTION_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setAdherence, PREP_FUV_ADHERENCE_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setReasonForPoorFairAdherence, PREP_FUV_REASON_POOR_ADHERENCE_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setPrepType, PREP_FUV_PREP_TYPE_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setPrepRegimen, PREP_FUV_PREP_REGIMEN_CONCEPT, groupedObsByConcept);
        hasValue |= setInteger(visit::setMonthsOfRefill, PREP_FUV_MONTHS_REFILL_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setOtherDrugsPrescribed, PREP_FUV_OTHER_DRUGS_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDateOfUrinalysis, PREP_FUV_DATE_URINALYSIS_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setUrinalysisResult, PREP_FUV_URINALYSIS_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDateOfHepatitisTest, PREP_FUV_DATE_HEPATITIS_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setHepatitisTestResult, PREP_FUV_HEPATITIS_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDateOfSyphilisTest, PREP_FUV_DATE_SYPHILIS_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setSyphilisTestResult, PREP_FUV_SYPHILIS_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDateOfLiverFunctionTest, PREP_FUV_DATE_LIVER_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setLiverFunctionTestResult, PREP_FUV_LIVER_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setDateOfOtherTests, PREP_FUV_DATE_OTHER_TESTS_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setOtherTestsResult, PREP_FUV_OTHER_TESTS_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(visit::setSuspectedAcuteInfection, PREP_FUV_SUSPECTED_ACUTE_CONCEPT, groupedObsByConcept);
        hasValue |= setText(visit::setEarlyHivDetectionViralLoadResult, PREP_FUV_EARLY_VL_RESULT_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(visit::setNextAppointmentDate, PREP_FUV_NEXT_APPOINTMENT_CONCEPT, groupedObsByConcept);

        if (!hasValue) {
            return null;
        }
        visit.setVisitID(resolveVisitId(encounter));
        return visit;
    }

    private PrepPepCardEnrollmentType createCardEnrollment(Patient patient, Map<Object, List<Obs>> groupedObsByConcept)
            throws DatatypeConfigurationException {
        PrepPepCardEnrollmentType card = new PrepPepCardEnrollmentType();

        if (patient.getPatientIdentifier() != null) {
            card.setHospitalNumber(patient.getPatientIdentifier().getIdentifier());
        }
        PatientIdentifier prepId = patient.getPatientIdentifier(PREP_IDENTIFIER_INDEX);
        if (prepId != null) {
            card.setUniqueId(prepId.getIdentifier());
        }

        setCoded(card::setEnrollmentType, CARD_ENROLLMENT_TYPE_CONCEPT, groupedObsByConcept);
        setDate(card::setDateEnrolled, CARD_DATE_ENROLLED_CONCEPT, groupedObsByConcept);
        setText(card::setPartnerAncOrUniqueArtNumber, CARD_PARTNER_ANC_ART_NUMBER_CONCEPT, groupedObsByConcept);
        setText(card::setMaritalStatus, CARD_MARITAL_STATUS_CONCEPT, groupedObsByConcept);
        setText(card::setOccupation, CARD_OCCUPATION_CONCEPT, groupedObsByConcept);
        setText(card::setEducationLevel, CARD_EDUCATION_LEVEL_CONCEPT, groupedObsByConcept);
        setCoded(card::setHivTestingPoint, CARD_HIV_TESTING_POINT_CONCEPT, groupedObsByConcept);
        setDate(card::setDateOfLastHivTest, CARD_DATE_LAST_HIV_TEST_CONCEPT, groupedObsByConcept);
        setCoded(card::setHivTestResult, CARD_HIV_TEST_RESULT_CONCEPT, groupedObsByConcept);
        setDate(card::setDateReferred, CARD_DATE_REFERRED_CONCEPT, groupedObsByConcept);
        setOtherCoded(card::setPopulationType, CARD_POPULATION_TYPE_CONCEPT, groupedObsByConcept);
        setText(card::setOtherPopulationSpecify, CARD_OTHER_POPULATION_CONCEPT, groupedObsByConcept);
        setDate(card::setDateInitialAdherenceCounseling, CARD_DATE_INITIAL_ADHERENCE_CONCEPT, groupedObsByConcept);
        setDate(card::setDateStarted, CARD_DATE_STARTED_CONCEPT, groupedObsByConcept);
        setCoded(card::setPrepTypeAtStart, CARD_PREP_TYPE_AT_START_CONCEPT, groupedObsByConcept);
        setCoded(card::setPrepRegimen, CARD_PREP_REGIMEN_CONCEPT, groupedObsByConcept);
        setDecimal(card::setWeight, CARD_WEIGHT_CONCEPT, groupedObsByConcept);
        setDecimal(card::setHeight, CARD_HEIGHT_CONCEPT, groupedObsByConcept);
        setDecimal(card::setBMI, CARD_BMI_CONCEPT, groupedObsByConcept);
        setBoolean(card::setIsPregnant, CARD_IS_PREGNANT_CONCEPT, groupedObsByConcept);
        setBoolean(card::setIsBreastfeeding, CARD_IS_BREASTFEEDING_CONCEPT, groupedObsByConcept);
        setText(card::setHistoryOfDrugAllergies, CARD_DRUG_ALLERGIES_CONCEPT, groupedObsByConcept);
        setText(card::setHistoryOfDrugDrugInteractions, CARD_DDI_CONCEPT, groupedObsByConcept);
        setCoded(card::setUrinalysisResult, CARD_URINALYSIS_RESULT_CONCEPT, groupedObsByConcept);
        setCoded(card::setLiverFunctionTestResult, CARD_LIVER_FUNCTION_RESULT_CONCEPT, groupedObsByConcept);
        setCoded(card::setReferredAtInitiation, CARD_REFERRED_AT_INITIATION_CONCEPT, groupedObsByConcept);
        setDate(card::setDateReferredAtInitiation, CARD_DATE_REFERRED_INITIATION_CONCEPT, groupedObsByConcept);
        setText(card::setServiceReferredFor, CARD_SERVICE_REFERRED_FOR_CONCEPT, groupedObsByConcept);
        setCoded(card::setPepCompletion, CARD_PEP_COMPLETION_CONCEPT, groupedObsByConcept);

        List<PepFollowUpEntryType> pepEntries = createPepFollowUpEntries(groupedObsByConcept);
        if (pepEntries != null && !pepEntries.isEmpty()) {
            card.getPepFollowUpEntry().addAll(pepEntries);
        }

        return card;
    }

    private List<PepFollowUpEntryType> createPepFollowUpEntries(Map<Object, List<Obs>> groupedObsByConcept) {
        List<PepFollowUpEntryType> entries = new ArrayList<>();
        List<Obs> groupObsList = groupedObsByConcept.get(PEP_ENTRY_GROUP_CONCEPT);
        if (groupObsList == null) {
            return entries;
        }
        for (Obs group : groupObsList) {
            Map<Object, List<Obs>> members = Utils.groupedByConceptIdsOnly(new ArrayList<>(group.getGroupMembers()));
            PepFollowUpEntryType entry = new PepFollowUpEntryType();
            setDate(entry::setFollowUpVisitDate, PEP_ENTRY_FOLLOWUP_DATE_CONCEPT, members);
            setCoded(entry::setHivResult, PEP_ENTRY_HIV_RESULT_CONCEPT, members);
            setText(entry::setEarlyHivDetectionViralLoadResult, PEP_ENTRY_EARLY_VL_RESULT_CONCEPT, members);
            entries.add(entry);
        }
        return entries;
    }

    // ============================ Discontinuation ==============================================

    private PrepDiscontinuationType createDiscontinuation(Map<Object, List<Obs>> groupedObsByConcept) {
        PrepDiscontinuationType discontinuation = new PrepDiscontinuationType();
        boolean hasValue = false;

        List<PrepInterruptionType> interruptions = createInterruptions(groupedObsByConcept);
        if (!interruptions.isEmpty()) {
            discontinuation.getInterruption().addAll(interruptions);
            hasValue = true;
        }

        hasValue |= setDate(discontinuation::setDateClientReferredOut, DISC_DATE_REFERRED_OUT_CONCEPT, groupedObsByConcept);
        hasValue |= setText(discontinuation::setFacilityReferredTo, DISC_FACILITY_REFERRED_TO_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(discontinuation::setDateClientDied, DISC_DATE_CLIENT_DIED_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(discontinuation::setSourceOfDeathInformation, DISC_SOURCE_DEATH_INFO_CONCEPT, groupedObsByConcept);
        hasValue |= setCodedName(discontinuation::setCauseOfDeath, DISC_CAUSE_OF_DEATH_CONCEPT, groupedObsByConcept);
        hasValue |= setCoded(discontinuation::setDiscontinuedPrepPepReason, DISC_REASON_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(discontinuation::setDiscontinuedPrepPepDate, DISC_DATE_CONCEPT, groupedObsByConcept);
        hasValue |= setDate(discontinuation::setArtLinkDate, DISC_ART_LINK_DATE_CONCEPT, groupedObsByConcept);

        return hasValue ? discontinuation : null;
    }



    private List<PrepInterruptionType> createInterruptions(Map<Object, List<Obs>> groupedObsByConcept) {
        List<PrepInterruptionType> interruptions = new ArrayList<>();
        List<Obs> groupObsList = groupedObsByConcept.get(DISC_INTERRUPTION_GROUP_CONCEPT);
        if (groupObsList == null) {
            return interruptions;
        }
        for (Obs group : groupObsList) {
            Map<Object, List<Obs>> members = Utils.groupedByConceptIdsOnly(new ArrayList<>(group.getGroupMembers()));
            PrepInterruptionType interruption = new PrepInterruptionType();
            setCoded(interruption::setInterruptionReason, DISC_INTERRUPTION_REASON_CONCEPT, members);
            setDate(interruption::setInterruptionDate, DISC_INTERRUPTION_DATE_CONCEPT, members);
            setCoded(interruption::setWhyCode, DISC_INTERRUPTION_WHY_CONCEPT, members);
            setDate(interruption::setDateOfRestart, DISC_INTERRUPTION_RESTART_DATE_CONCEPT, members);
            interruptions.add(interruption);
        }
        return interruptions;
    }

    private String resolveVisitId(Encounter encounter) {
        if (encounter.getVisit() != null) {
            return String.valueOf(encounter.getVisit().getVisitId());
        }
        return String.valueOf(encounter.getEncounterId());
    }




    // ============================ Obs -> value helpers =========================================

    private interface StringSetter {
        void set(String value);
    }

    private interface BooleanSetter {
        void set(Boolean value);
    }

    private interface IntegerSetter {
        void set(Integer value);
    }

    private interface DecimalSetter {
        void set(BigDecimal value);
    }

    private interface DateSetter {
        void set(XMLGregorianCalendar value);
    }


    private boolean setCoded(StringSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String mapped = getMappedValue(obs.getValueCoded().getConceptId());
            if (mapped != null) {
                setter.set(mapped);
                return true;
            }
        }
        return false;
    }

    private boolean setOtherCoded(StringSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String mapped = getOtherMapped(obs.getValueCoded().getConceptId());
            if (mapped != null) {
                setter.set(mapped);
                return true;
            }
        }
        return false;
    }

    private boolean setCodedName(StringSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null && obs.getValueCoded().getName() != null) {
            setter.set(obs.getValueCoded().getName().getName());
            return true;
        }
        return false;
    }


    /** Sets a free-text (valueText) obs. */
    private boolean setText(StringSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueText() != null) {
            setter.set(obs.getValueText());
            return true;
        }
        return false;
    }

    /**
     * Sets a Boolean from a Yes/No coded obs.
     */
    private void setBoolean(BooleanSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            Boolean value = booleanDictionary.get(obs.getValueCoded().getConceptId());
            if (value != null) {
                setter.set(value);
            }
        }
    }

    /** Sets an Integer from a numeric obs. */
    private boolean setInteger(IntegerSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueNumeric() != null) {
            setter.set((int) Math.round(obs.getValueNumeric()));
            return true;
        }
        return false;
    }

    /** Sets a BigDecimal from a numeric obs. */
    private boolean setDecimal(DecimalSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueNumeric() != null) {
            setter.set(BigDecimal.valueOf(obs.getValueNumeric()));
            return true;
        }
        return false;
    }

    /** Sets a date from a valueDate obs. */
    private boolean setDate(DateSetter setter, int conceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                setter.set(utils.getXmlDate(obs.getValueDate()));
                return true;
            } catch (Exception ex) {
                LoggerUtils.write(PrepDictionary.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
            }
        }
        return false;
    }

    private boolean setBloodPressure(StringSetter setter, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs systolicObs = extractObs(PrepDictionary.PEP_FUV_BLOOD_PRESSURE_CONCEPT, groupedObsByConcept);
        Obs diastolicObs = extractObs(PrepDictionary.PEP_FUV_BLOOD_PRESSURE_CONCEPT_Dia, groupedObsByConcept);

        Integer systolic = (systolicObs != null && systolicObs.getValueNumeric() != null)
                ? (int) Math.round(systolicObs.getValueNumeric())
                : null;
        Integer diastolic = (diastolicObs != null && diastolicObs.getValueNumeric() != null)
                ? (int) Math.round(diastolicObs.getValueNumeric())
                : null;

        if (systolic == null || diastolic == null) {
            return false;
        }

        setter.set(systolic + "/" + diastolic);
        return true;
    }

    private boolean answerSelected(int questionConceptId, int answerConceptId, Map<Object, List<Obs>> groupedObsByConcept) {
        if (groupedObsByConcept == null) {
            return false;
        }
        List<Obs> obsList = groupedObsByConcept.get(questionConceptId);
        if (obsList == null) {
            return false;
        }
        for (Obs obs : obsList) {
            if (obs.getValueCoded() != null && obs.getValueCoded().getConceptId() == answerConceptId) {
                return true;
            }
        }
        return false;
    }

    private boolean setDictCoded(StringSetter setter, int conceptId, Map<Integer, String> dictionary, Map<Object, List<Obs>> groupedObsByConcept) {
        Obs obs = extractObs(conceptId, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String mapped = dictionary.get(obs.getValueCoded().getConceptId());
            if (mapped != null) {
                setter.set(mapped);
                return true;
            }
        }
        return false;
    }

    private String getMappedValue(int conceptId) {
        return codedDictionary.get(conceptId);
    }

    private String getOtherMapped(int conceptId) {
        return pepDictionary.get(conceptId);
    }




}
