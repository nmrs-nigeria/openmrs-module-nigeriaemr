package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.DRTBTreatmentRegisterType.FollowUpInvestigation;
import org.openmrs.module.nigeriaemr.model.ndr.DRTBInPatientDischargeFormType.TbRegimenToBeContinuedAtDoTFacility;
import org.openmrs.module.nigeriaemr.model.ndr.DRTBInPatientDischargeFormType.AdverseReaction;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class TBDictionary {
    Utils utils = new Utils();

    //TB Screening
    public static int Have_cough = 143264;
    public static int weight_loss = 832;
    public static int have_Fever = 140238;
    public static int Night_sweats = 133027;
    public static int TuberculosisContact = 124068;
    //public static int TBScreeningScore = 165808;

    //TB Referral For Community and Facility
    public static int Referringfacilityname = 161550;
    public static int DateofReferral = 163181;
    public static int Addressofreferringorganization = 165482;
    public static int NameofReferringOrg = 161103;
    public static int PhoneofReferringOrg  = 165487;
    public static int ReasonForReferral = 1887;
    public static int PersonMakingReferral = 166681;
    public static int OtherProvMakingReferral = 166682;
    public static int NameofReceivingOrg  = 165508;
    public static int NameofComHealthWrk = 164141;
    public static int OutcomeofTBReferral = 166685;
    public static int PhoneofReceivingOrg = 165486;
    public static int  TBTreatmentoutcomeDate = 166675;
    public static int  TUBERCULOSISDRUGTREATMENTSTARTDATE= 1113;

    //TB INDEX PATIENT CONTACT INVESTIGATION FORM
    public static int  NameofTBcontactinvestigator= 166715;
    //public static int  Sputumsamplescollected = 166733;
    public static int PhoneTBcontactinvestigator = 166717;
    public static int DateofContactTracing  = 166718;
    public static int LGATBNUmber = 166688;
    public static int NumberHouseholdContacts = 166720;
    public static int TypeofTB = 166723;
    public static int  ConsentForContactTracing = 166721;
    public static int  TBContactName = 166724;
    public static int  TBContactAge = 166725;
    public static int  TBContactSex = 166726;
    public static int  TBContactNumber = 166727;
    public static int  RtnTBIndexCase = 166728;
    public static int  CoughLess2wks = 166729;
    public static int  RecentWeightLoss = 1858;
    public static int  NightSweat = 166801;
    public static int  Presumptive_Identified = 166731;
    public static int  Presumptive_Identified_referred = 166732;
    //public static int  Sputumsamplescollected = 166733;
    public static int  TBDiagnosed = 166734;

    //Presumptive TB Register
    public static int  SpecimenID = 166735;
    public static int  IsClientHealthWorker = 166736;
    public static int  ReferralSource = 165847;
    public static int  SiteofTB = 160040;
    public static int  TBSpecimenCollectionDate = 166737;
    public static int  DateSentToLab = 166738;
    public static int  TBResultDate = 166740;
    public static int  TBPCRChecking = 162202;
    public static int  AFBResult = 166741;
    public static int  OtherTBTestType = 166742;
    public static int  OtherTBTestResult = 166743;
    public static int  ChestXRay = 165972;
    public static int  TBClinicalDiagnosed = 166744;
    public static int  PreviouslyKnownHIV = 166798;
    public static int  HIVTestPerformed = 164401;
    public static int  ResultofHIVTest = 159427;
    public static int  OutcomeofTBInvegigation = 166745;
    public static int  TBTreatmentStarted = 1270;
    public static int   MTBDetected = 165973;
    public static int  Reason_not_ONTB = 166746;

    //DR-TB Treatment Registration Form
    public static int PatientSerialNumber = 166583;
    public static int PlaceOfInitiation = 166534;
    public static int ReferringFacilityState = 166535;
    public static int ReferringFacilityLGA = 166536;
    public static int PreviouslyOnTB2ndLineDrug = 166538;
    public static int TB2ndlinedrugstartdate = 166539;
    public static int TypefTreatmentRegimen = 166540;
    public static int DateTreatmentStarted = 166692;
    public static int NameofAmino = 166758;
    public static int ResistantPattern = 166760;
    public static int SiteofDisease = 166696;
    public static int RegistrationGroup = 159990;
    public static int GeneXpert = 166646;
    public static int AFB = 166595;
    public static int Culture = 159982;
    public static int DSTResult = 159984;
    public static int XRayDone = 166543;
    public static int XRayResult = 166761;
    public static int SmearResult = 166580;
    public static int CultureResult = 166783;
    public static int SmearCultureResultDate = 166574;
    public static int Months = 167003;
    public static int HIVStatus = 159576;
    public static int EnrolledinCare = 159811;
    public static int ARTStartDate = 159599;
    public static int CPT = 160434;
    public static int CPTStartDate = 166582;
    public static int TBtreatmentOutcome = 159786;
    public static int OutcomeDate = 159787;

    //TB Tracking and Interruption
    public static int TrackingAttempts = 166618;
    public static int Date_of_LastDrugIntake = 166623;
    public static int ModeOfTracking = 166622;
    public static int ContactPatient = 166624;
    public static int PersonContacted = 165466;
    public static int ReasonForAbsence = 166625;
    public static int OtherReason = 166139;
    public static int SolutionToAbsence = 166626;
    public static int TBTrackingOutcome = 166627;

    //TB Laboratory Register
    public static int NTBLCP = 166613;
    public static int LabName = 164422;
    public static int LabLGA = 166015;
    public static int SpecimenStatus = 166584;
    public static int ReasonRejection = 166585;
    public static int TypeofTBPresumptive = 166586;
    public static int HealthProvider = 166736;
    public static int TestHIVLab = 166587;
    public static int MTBDeceted = 166589;
    public static int SpecifyMTBDeceted = 166588;
    public static int InvalidTest = 166591;
    public static int ReasonforAFBTest = 166765;
    public static int OtherTestType = 166742;
    public static int OtherTestTypeResult = 166657;
    public static int TBTestResultDate = 159964;

    //LGAHealthFacilityTBCentralRegisterType
    public static int DateTBRegistered = 166686;
    public static int TypeofTBPatient = 166687;
    public static int ETBUniqueNumber = 166689;
    public static int FacilityStartedTreatment = 166690;
    public static int WeightAtStart = 166691;
    public static int TBRegimens = 166804;
    public static int DateStartedTBTreatment = 166692;
    public static int ReferredFromComm = 166693;
    public static int ReferredFromPmmSite = 166694;
    public static int IsDOTProvided = 166695;
    public static int OtherTest_TB_LAM = 166697;
    public static int AFB_Month_0 = 166700;
    public static int AFB_Month_2 = 166701;
    public static int AFB_Month_5 = 166702;
    public static int AFB_Month_6 = 166703;
    public static final int AFB_Result_Date = 166704;
    public static int Biopsy_Result = 166705;
    public static int IPTStartDate = 165994;
    public static int HIVStatusatEndofTB = 166706;

    //Specimen Exam Request
    public static int SpecimenCollectionDate = 159951;
    public static int HIVTestRequested = 165819;
    public static int ReasonforScreening = 164082;
    public static int TestTypeRequest = 165879;
    public static int OtherSpecimenType = 166764;
    public static int NumberSenttoLab = 166773;
    public static int DateFirstPCRSample = 164986;
    public static int DateSecondPCRSample = 165007;
    public static int PersonRequestingExam = 166775;
    public static int Email = 166430;
    public static int HealthFacilityName = 162724;
    public static int RefferingFacilityState = 166779;

    //Specimen Exam Result
    public static int LabNumber = 164409;
    public static int MTBnotDetected = 165974;
    public static int OtherTBTest = 166655;
    public static int DateAFBSampleReceived = 166592;
    public static int SpecimenSource = 162476;
    public static int AFBSpecimenApperance = 166594;
    public static int AFBSmearResult = 166785;
    public static int AFBExaminedBy = 166596;
    public static int AFBResultDate = 166651;
    public static int TypeofCulture = 166599;
    public static int CultureSampleDate = 166600;
    public static int SolidCultureResult = 166602;
    public static int ResultofComfirmatoryMTB = 166604;
    public static int CultureExaminedBy = 166605;
    public static int CultureResultDate = 166606;
    public static int TypeofLPADST = 166607;
    public static int DateLPADSTSampleReceived = 166608;
    public static int LPADSTSpecimenType = 166609;
    public static int LPAResult = 166610;
    public static int LPADSTExaminedBy = 166611;
    public static int TestResultReceivedDate = 160082;
    public static int TestResultCheckedBy = 166612;

    //Treatment Monitoring
    public static int TypeOfRegimen = 166666;
    public static int TreatmentAgeGroup = 165720;
    public static int PregnancyStatus = 165050;
    public static int AntiTBDrugs= 165304;
    public static int ARVDrugStrength= 165725;
    public static int DrugFrequency= 165723;
    public static int TBDrugDuration = 166838;
    public static int QtyPrescribed = 160856;
    public static int SelectOutcome = 166672;

    public static int cough = 143264;
    public static int fever = 140238;
    public static int weightloss = 832;
    public static int nightsweats = 133027;
    public static int historyOfContactsWithTBPatients = 165967;
    public static int GeneXpertTB = 165975;
    public static int ChestXrayTB = 165972;
    public static int CultureTBResult = 165969;
    public static int ActiveTB = 164500;
    public static int AgeLessThanOneYearContactTBpatient = 165982;
    public static int AbnormalChestXRay = 152526;
    public static int ActiveHepatitis = 165983;
    public static int TBDiagnosisInThreeYears = 165981;
    public static int HighAlcoholConsumption = 165984;
    public static int SevereImmuneSuppression = 165979;
    public static int PriorAllergyToINH = 165985;
    public static int HistoryPoorTreatmentAdherence = 165980;
    public static int IsPatientEligibleIPT = 165986;
    public static int DateIPTStart = 165994;
    public static int WeightIPTStart = 165996;
    public static int INHDailyDose = 165997;
    public static int TBSymptoms = 165998;
    public static int HepatitisSymptoms = 165999;
    public static int NeurologicSymptoms = 166000;
    public static int Rash = 512;
    public static int Adherence = 166001;
    public static int ReferredForFurtherServices = 166002;
    public static int OutcomeOfIPT = 166007;
    public static int ReasonsForStoppingIPT = 166012;
    public static int DateOfOutcome = 166008;
    public static int NextAppointmentDate = 5096;

    //TB Patient Referral or Transfer
    public static int TBReasonForReferral = 166782;
    public static int FacilityCode = 5937;
    public static int LGA = 166015;
    public static int ReferringFacilityName = 161550;
    public static int FacilityReferredTo = 165483;
    public static int ReferredFacilityLGA = 166781;
    public static int ReferredFacilityState = 166780;
    public static int TypeOfTBPatient = 166687;
    public static int FormCompleted = 166458;
    public static int OtherReferrals = 165912;
    public static int specimenID = 159968;
    public static int MycobacteriumuTberculosisDetectedWithRifampinResistance = 162203;


    private Map<Integer, String> tbDictionary = new HashMap<>();
    private Map<Integer, String> tbDictionary2 = new HashMap<>();
    private Map<Integer, String> tbDictionary3 = new HashMap<>();
    private Map<Integer, Boolean> tbBooleanDictionary = new HashMap<>();
    private Map<Integer, YNCodeType> tbYNCodeTypeDict = new HashMap<>();

    private void loadDictionary() {
        tbDictionary = new HashMap<>();
        tbDictionary2 = new HashMap<>();
        tbDictionary3 = new HashMap<>();

        //TB Referral For Community and Facility
        tbDictionary.put(161356, "TuberculosisDiagnosisClassification");
        tbDictionary.put(1185, "Treatment");
        tbDictionary.put(155006, "AdverseEffect");
        tbDictionary.put(1887, "Other");
        tbDictionary.put(166634, "CommunityTBWorker");
        tbDictionary.put(166633, "CommunityVolunteer");
        tbDictionary.put(166639, "CommunityInformant");
        tbDictionary.put(166134, "CommunityPharmacy");
        tbDictionary.put(166392, "PatentMedicineShop");
        tbDictionary.put(1575, "TraditionalBirthAttendant");
        tbDictionary.put(166457, "HealthLaboratoryWorker");
        tbDictionary.put(166682, "Other");
        tbDictionary.put(166683, "TBConfirmed");
        tbDictionary.put(166684, "TBNotConfirmed");
        tbDictionary.put(974, "Uncle");
        tbDictionary.put(975, "Aunt");
        tbDictionary.put(160729, "Brother");
        tbDictionary.put(160728, "Daughter");
        tbDictionary.put(971, "Father");
        tbDictionary.put(5618, "Friend");
        tbDictionary.put(164945, "Husband");
        tbDictionary.put(970, "Mother");
        tbDictionary.put(1527, "Parent");
        tbDictionary.put(160730, "Sister");
        tbDictionary.put(160727, "Son");
        tbDictionary.put(164994, "Wife");
        tbDictionary.put(165650, "Eight");
        tbDictionary.put(165647, "Five");
        tbDictionary.put(165646, "Four");
        tbDictionary.put(165651, "Nine");
        tbDictionary.put(165643, "One");
        tbDictionary.put(165649, "Seven");
        tbDictionary.put(165648, "Six");
        tbDictionary.put(165652, "Ten");
        tbDictionary.put(165645, "Three");
        tbDictionary.put(165644, "Two");
        tbDictionary.put(166753, "DRTB");
        tbDictionary.put(166752, "DSTB");
        tbDictionary.put(166754, "NoTB");
        tbDictionary.put(159413, "Agree");
        tbDictionary.put(162570, "DeclinedToAnswer");
        tbDictionary.put(165185, "FEMALE");
        tbDictionary.put(165184, "MALE");
        tbDictionary.put(1065, "Yes");
        tbDictionary.put(1066, "No");
        tbDictionary.put(42, "Pulmonary");
        tbDictionary.put(156204, "ExtraPulmonary");
        tbDictionary.put(664, "Negative");
        tbDictionary.put(165973, "MTBDetected");
        tbDictionary.put(163611, "Invalid");
        tbDictionary.put(703, "Positive");
        tbDictionary.put(704, "Positive");
        tbDictionary.put(1067, "Unknown");
        tbDictionary.put(162204, "rif_resistance_not_detected");
        tbDictionary.put(162203, "rif_resistance_detected");
        tbDictionary.put(164104, "rif_resistance_indeterminate");

        //DR-TB
        tbDictionary.put(159977, "New");
        tbDictionary.put(160033, "Relapse");
        tbDictionary.put(166641, "TreatmentAfterFailure");
        tbDictionary.put(166642, "TreatmentAfterLossToFollowUp");
        tbDictionary.put(166643, "OthersPreviouslyTreated");
        tbDictionary.put(166707, "TBPatient");
        tbDictionary.put(166644, "UnknownPreviousTB");
        tbDictionary.put(166711, "TransferredIn");
        tbDictionary.put(160034, "Died");
        tbDictionary.put(5240, "LostToFollowup");
        tbDictionary.put(166575, "ShorterRegimen_Injectable");
        tbDictionary.put(166576, "ShorterRegimen_BDQ");
        tbDictionary.put(166577, "Individualized_PREXDR");
        tbDictionary.put(166578, "Individualized_XDR");
        tbDictionary.put(160247, "Resistant");
        tbDictionary.put(166722, "Susceptible");
        tbDictionary.put(159958, "Susceptible");
        tbDictionary.put(164412, "PositiveSmear");
        tbDictionary.put(164413, "NegativeSmear");
        tbDictionary.put(1118, "NotDone");
        tbDictionary.put(160008, "Contaminated");
        tbDictionary.put(138571, "Positive");

        tbDictionary.put(166547, "Month1");
        tbDictionary.put(166548, "Month2");
        tbDictionary.put(166549, "Month3");
        tbDictionary.put(166550, "Month4");
        tbDictionary.put(166551, "Month5");
        tbDictionary.put(166552, "Month6");
        tbDictionary.put(166553, "Month7");
        tbDictionary.put(166554, "Month8");
        tbDictionary.put(166555, "Month9");
        tbDictionary.put(166556, "Month10");
        tbDictionary.put(166557, "Month11");
        tbDictionary.put(166558, "Month12");
        tbDictionary.put(166559, "Month13");
        tbDictionary.put(166560, "Month14");
        tbDictionary.put(166561, "Month15");
        tbDictionary.put(166562, "Month16");
        tbDictionary.put(166563, "Month17");
        tbDictionary.put(166564, "Month18");
        tbDictionary.put(166565, "Month19");
        tbDictionary.put(166566, "Month20");
        tbDictionary.put(166567, "Month21");
        tbDictionary.put(166568, "Month22");
        tbDictionary.put(166569, "Month23");
        tbDictionary.put(166570, "Month24");
        tbDictionary.put(166571, "Month25");
        tbDictionary.put(166572, "Month26");
        tbDictionary.put(166573, "Month27");



        //LGAHealthFacilityTBCentralRegisterType
        tbDictionary3.put(159878, "New");
        tbDictionary3.put(159875, "Relapse");
        tbDictionary3.put(159873, "TreatmentAfterDefault");
        tbDictionary3.put(166708, "TreatmentAfterLTFU");
        tbDictionary3.put(166709, "OthersPreviouslyTreated");
        tbDictionary3.put(166710, "UnknownPreviousTB");
        tbDictionary3.put(166711, "TransferredInTB");
        tbDictionary.put(78385, "Kanamycin");
        tbDictionary.put(72794, "Capreomycin");
        tbDictionary.put(656, "Isoniazid");
        tbDictionary.put(82772, "Prothionamide");
        tbDictionary.put(955, "Moxifloxacin");
        tbDictionary.put(73581, "Clofazimine");
        tbDictionary.put(745, "Ethambutol");
        tbDictionary.put(82900, "Pyrazinamide");
        tbDictionary.put(78879, "Linezolid");
        tbDictionary.put(163143, "Bedaquiline");
        tbDictionary.put(163144, "Delamanid");

        tbDictionary.put(78280, "Isoniazid");
        tbDictionary.put(84360, "Streptomycin");
        tbDictionary.put(78788, "Levofloxacin");
        tbDictionary.put(80133, "Moxifloxacin");
        tbDictionary.put(73449, "Ciprofloxacin");
        tbDictionary.put(81022, "Ofloxacin");
        tbDictionary.put(75976, "Ethionamide");
        tbDictionary.put(74123, "Cycloserine");
        tbDictionary.put(84836, "Terizidone");

        tbDictionary.put(166619, "FirstAttempt");
        tbDictionary.put(166728, "SecondAttempt");
        tbDictionary.put(166721, "ThirdAttempt");

        tbDictionary.put(165791, "HomeVisit");
        tbDictionary.put(166293, "HomeVisitPhoneCalls");
        tbDictionary.put(160639, "Guardian");

        tbDictionary.put(161642, "TreatmentSupporter");
        tbDictionary.put(165301, "WasSick");
        tbDictionary.put(1737, "NoTransportFare");

        tbDictionary.put(159492, "TransferredOut");
        tbDictionary.put(162192, "PatientForgotToAttendAppointment");
        tbDictionary.put(160586, "FeltBetterAndStoppedTakingMedication");

        tbDictionary.put(165896, "NotPermittedToLeaveWork");
        tbDictionary.put(165897, "LostAppointmentCard");
        tbDictionary.put(165898, "StillHadDrugs");

        tbDictionary.put(5841, "HerbalTraditionalMedicine");
        tbDictionary.put(164929, "ActiveStatus");
        tbDictionary.put(164928, "InactiveStatus");

        //Specimen Request
        tbDictionary.put(166777, "Diagnosis");
        tbDictionary.put(162202, "XpertOrMTBOrRIF");
        tbDictionary.put(165423, "SmearForAFB");
        tbDictionary.put(166767, "TBLAMP");
        tbDictionary.put(166768, "TBLAM");
        tbDictionary.put(166769, "QuantiferonOrTST");
        tbDictionary.put(166770, "FirstLineLPA");
        tbDictionary.put(166542, "SecondLineLPA");
        tbDictionary.put(1465, "Culture");
        tbDictionary.put(166771, "PhenotypicFirstLineDST");
        tbDictionary.put(166772, "PhenotypicSecondLineDST");
        tbDictionary.put(166742, "Others");

        //Specimen Examination Result
        tbDictionary.put(165282, "1");
        tbDictionary.put(165283, "2");
        tbDictionary.put(159985, "Scanty");
        tbDictionary.put(1362, "OnePlus");
        tbDictionary.put(1363, "TwoPlus");
        tbDictionary.put(1364, "ThreePlus");
        tbDictionary.put(166786, "BaselineCulture");
        tbDictionary.put(166788, "MonthOfFollowUp");
        tbDictionary.put(161919, "Contaminated");
        tbDictionary.put(166789, "LPA");
        tbDictionary.put(166790, "SolidCultureDST");
        tbDictionary.put(166791, "LiquidCultureDST");
        tbDictionary.put(166792, "Resistant");
        tbDictionary.put(159956, "Resistant");
        tbDictionary.put(166793, "Susceptible");
        tbDictionary.put(1138, "Indeterminate");
        tbDictionary.put(767, "Rifampicin");
        tbDictionary.put(162303, "FluoroquilinoneOrCyclic");
        tbDictionary.put(166795, "LowLevelKanamycin");
        tbDictionary.put(75948, "Ethambuthol");
        tbDictionary.put(71060, "Amikacin");
        tbDictionary.put(438, "Streptomycin");
        tbDictionary.put(163101, "Other");


        tbDictionary.put(1528, "Pediatric");
        tbDictionary.put(165709, "Adult");
        tbDictionary.put(165049, "Breastfeeding");
        tbDictionary.put(165047, "NotPregnant");
        tbDictionary.put(165048, "Pregnant");
        tbDictionary.put(83352, "Rifabutin");
        tbDictionary.put(1675, "RHZE");
        tbDictionary.put(768, "RHZ");
        tbDictionary.put(1108, "EH");
        tbDictionary.put(166063, "1g");
        tbDictionary.put(165076, "100mg");
        tbDictionary.put(165075, "150mg");
        tbDictionary.put(165074, "300mg");
        tbDictionary.put(166054, "400mg");
        tbDictionary.put(166061, "150mgOr75mg");
        tbDictionary.put(165622, "300mgOr150mg");
        tbDictionary.put(166062, "150mgOr75mgOr40mg");

        tbDictionary2.put(166063, "1g");
        tbDictionary2.put(165076, "100mg");
        tbDictionary2.put(165075, "150mg");
        tbDictionary2.put(165074, "300mg");
        tbDictionary2.put(166054, "400mg");
        tbDictionary2.put(166061, "150mg/75mg");
        tbDictionary2.put(165622, "300mg/150mg");
        tbDictionary2.put(166062, "150mg/75mg/40mg");
        tbDictionary2.put(162401, "Kit");
        tbDictionary2.put(5622, "Other");

        tbDictionary.put(162401, "Kit");
        tbDictionary.put(160862, "OD");
        tbDictionary.put(160858, "BD");
        tbDictionary.put(165721, "2BD");
        tbDictionary.put(166056, "3BD");
        tbDictionary.put(166057, "4BD");
        tbDictionary.put(160870, "QDS");
        tbDictionary.put(5622, "Other");
        tbDictionary.put(165722, "3cePerWeek");
        tbDictionary.put(166058, "Nocte");
        tbDictionary.put(166667, "TwoMonths");
        tbDictionary.put(166668, "FourMonths");
        tbDictionary.put(166670, "TenMonths");
        tbDictionary.put(166671, "TwelveMonths");
        tbDictionary.put(166679, "TreatmentSupporter");
        tbDictionary.put(5619, "HealthCareWorker");

        //IPT FORM
        tbDictionary.put(164096, "PTBNegative");
        tbDictionary.put(165974, "MTBNotDetected");
        tbDictionary.put(165971, "NonSuggestive");
        tbDictionary.put(165970, "Suggestive");
        tbDictionary.put(159405, "Good");
        tbDictionary.put(159407, "Poor");
        tbDictionary.put(166004, "DevelopedActiveTB");
        tbDictionary.put(160034, "Died");
        tbDictionary.put(166003, "IPTCompleted");
        tbDictionary.put(166006, "LostToFollowUp");
        tbDictionary.put(166005, "StoppedIPT");
        tbDictionary.put(159492, "TransferredOut");
        tbDictionary.put(166010, "DevelopedNeurologicalSymptoms");
        tbDictionary.put(166009, "DevelopedSymptomsOfHepatitis");
        tbDictionary.put(166011, "PoorAdherence");

        //TB Patient Referral
        tbDictionary.put(1285, "TransferToOtherCenter");
        tbDictionary.put(1696, "ReferringPerson");
        tbDictionary.put(165773, "New");
        tbDictionary.put(160033, "Relapse");
        tbDictionary.put(166641, "TBTreatmentAfterFailure");
        tbDictionary.put(166642, "TreatmentAfterLossToFollowUp");
        tbDictionary.put(166643, "OtherPreviouslyTreated");
        tbDictionary2.put(166644, "PatientsWithUnknownPreviousTBTreatmentHistory");
        tbDictionary.put(160563, "TransferIn");

        tbDictionary.put(166776, "FollowUp");
        tbDictionary.put(166777, "Diagnosis");
        tbDictionary.put(164433, "MonthOfTreatment");

        tbDictionary2.put(703, "PositiveCulture");
        tbDictionary2.put(664, "NegativeCulture");
        tbDictionary2.put(160008, "Contaminated");
        tbDictionary.put(159972, "Contaminated");

        tbDictionary.put(159791, "Cured");
        tbDictionary.put(1663, "TreatmentCompleted");
        tbDictionary.put(159874, "TreatmentFailed");
        tbDictionary.put(160034, "Died");
        tbDictionary.put(5240, "LostToFollowUp");
        tbDictionary.put(160737, "NotEvaluated");
        tbDictionary.put(164424, "RemovedFromRegister");

        tbDictionary2.put(159791, "Cure_Outcome");
        tbDictionary2.put(1663, "CompletedTreatmentForDisease");
        tbDictionary2.put(160034, "Die");
        tbDictionary2.put(5240, "LostToFollowup");
        tbDictionary2.put(160737, "NotAssessed");
        tbDictionary2.put(164424, "PATToMultiDrgResistantTBReg");
        tbDictionary2.put(159874, "TBTXFailure");
        tbDictionary2.put(159790, "TBTXFailureAndSmearPosAt3Mnth");
        tbDictionary2.put(159789, "TBTXFailureAndSmearPosAt5Mnth");
        tbDictionary2.put(159788, "TBTXFailureAndSmearPosAt8Mnth");

        tbDictionary.put(166976, "WHOShortOralMDRTB");
        tbDictionary.put(166973, "ShortOralMDRTB");
        tbDictionary.put(166967, "ShortOralPreXDRTB");
        tbDictionary.put(166969, "LongOralMDROrRRTB");
        tbDictionary.put(166972, "PreXDRTB");
        tbDictionary.put(166961, "FluoroquinoloneSusceptible");
        tbDictionary.put(166964, "FluoroquinoloneResistant");

        tbDictionary.put(166977, "FourToSixBdqMfx");
        tbDictionary.put(166974, "FourToSixBdq");
        tbDictionary.put(166968, "SixBdqPmn");
        tbDictionary.put(166970, "SixBdqMfx");
        tbDictionary.put(166962, "SixMfxLzd");
        tbDictionary.put(166965, "SixLzdCfc");

        tbDictionary.put(166839, "SkinRashWithOrWithoutItching");
        tbDictionary.put(215, "Jaundice");
        tbDictionary.put(29, "Hepatitis");
        tbDictionary.put(159298, "VisualImpairment");
        tbDictionary.put(112989, "Shock");
        tbDictionary.put(113478, "Purpura");
        tbDictionary.put(121849, "AcuteRenalFailure");
        tbDictionary.put(868, "Anorexia");
        tbDictionary.put(5978, "Nausea");
        tbDictionary.put(151, "AbdominalPain");
        tbDictionary.put(80, "JointPains");
        //tbDictionary.put(0, "BurningOrnumbnessInTheHandsOrFeet");
        tbDictionary.put(166840, "OrangeOrRedUrine");

        tbDictionary.put(166986, "StopAntiTBDrugs");
        tbDictionary.put(166987, "StopAntiTBDrugsAndReferToTheMedicalOfficer");
        tbDictionary.put(166988, "StopEthambutol");
        tbDictionary.put(166989, "StopEthambutolAndReferToTheMedicalOfficer");
        tbDictionary.put(166990, "StopRifampicin");
        tbDictionary.put(166991, "StopRifampicinAndReferToTheMedicalOfficer");
        tbDictionary.put(166992, "GiveDrugsWithSmallMealsOrJustBeforeBedtime");
        tbDictionary.put(166993, "AdvisePatientPillsSipsOfWater");
        tbDictionary.put(166994, "SipsOfWaterAndIfSympPersistReferToHospital");
        tbDictionary.put(166995, "Pyridoxine50To100mgDaily");
        tbDictionary.put(166996, "Reassurance");
        tbDictionary.put(166997, "CounselPatientsBeforeStartingTreatment");
        tbDictionary.put(166998, "EncourageIncreaseFluidIntake");
        tbDictionary.put(166999, "ReassurePatientsBeforeIncreaseFluidIntake");
        tbDictionary.put(167000, "GiveDrugsBeforeBedtime");
        tbDictionary.put(167001, "ChangeIntermittentToDailyRifampicinAdmin");
        //Treatment Card From
        tbDictionary.put(1056, "Separated");
        tbDictionary.put(1057, "NeverMarried");
        tbDictionary.put(1058, "Divorced");
        tbDictionary.put(1059, "Widowed");
        tbDictionary.put(1060, "Livingwithpartner");
        tbDictionary.put(5555, "Married");
        tbDictionary.put(1538, "Farmer");
        tbDictionary.put(162946, "Teacher");
        tbDictionary.put(162944, "Civilservant");
        tbDictionary.put(163333, "Engineer");
        tbDictionary.put(162591, "MedicalofficerOrDoctor");
        tbDictionary.put(164831, "Laboratorytechnician");
        tbDictionary.put(160295, "Housewife");
        tbDictionary.put(159465, "Student");
        tbDictionary.put(123801, "Unemployed");
        tbDictionary.put(1540, "Employee");
        tbDictionary.put(159461, "Retired");
        tbDictionary.put(1175, "Notapplicable");
        tbDictionary.put(164419, "Totalunder5yrs");
        tbDictionary.put(166631, "5yrsandabove");
        tbDictionary.put(165303, "ARTfacility");
        tbDictionary.put(160546, "STIclinic");
        tbDictionary.put(166634, "CommunityTBWorker");
        tbDictionary.put(166707, "NewTBpatient");
        tbDictionary.put(166637, "Privateforprofit");
        tbDictionary.put(166635, "DOTSfacility");
        tbDictionary.put(166638, "StandaloneLab");
        tbDictionary.put(166636, "Faithbasedorganization");

        //Start here
        tbDictionary2.put(166641, "TreatmentAfterFailure");
        tbDictionary2.put(166708, "TreatmentAfterIIT");
        tbDictionary2.put(166643, "Otherpreviouslytreated");
        tbDictionary2.put(166644, "PTunknownprevTBTXhistory");
        tbDictionary2.put(160563, "TranferIn");
        tbDictionary2.put(159977, "New");
        tbDictionary2.put(160033, "Relapse");

    }

    public TBDictionary() {
        loadDictionary();
        loadBooleanDictionary();
        loadYNCodeTypeDictionary();
    }

    //TB Patient Referral
    public List<TBPatientReferralType> createTBPatientReferralType(List<Encounter> tbPatientReferralEncounters) {
        List<TBPatientReferralType> tBPatientReferralType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : tbPatientReferralEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBPatientReferralType referral = new TBPatientReferralType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if(enc.getVisit() != null){
                    referral.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    referral.setVisitID(enc.getEncounterId().toString());
                }
                referral.setVisitDate(convertedDate);

                Obs obs = extractObs(TBReasonForReferral, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    referral.setTBReasonForReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(FacilityCode, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    referral.setFacilityCode(obs.getValueNumeric().toString());
                }
                obs = extractObs(LGA, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setLGA(obs.getValueText());
                }
                obs = extractObs(ReferringFacilityName, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setReferringFacilityName(obs.getValueText());
                }
                obs = extractObs(ReferringFacilityLGA, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setReferringFacilityLGA(obs.getValueText());
                }
                obs = extractObs(166779, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setReferringFacilityState(obs.getValueText());
                }
                obs = extractObs(FacilityReferredTo, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setFacilityReferredTo(obs.getValueText());
                }
                obs = extractObs(ReferredFacilityLGA, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setReferredFacilityLGA(obs.getValueText());
                }
                obs = extractObs(ReferredFacilityState, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setReferredFacilityState(obs.getValueText());
                }
                obs = extractObs(TypeOfTBPatient, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    referral.setTypeOfTBPatient(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(FormCompleted, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    referral.setFormCompleted(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OtherReferrals, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setOtherReferrals(obs.getValueText());
                }
                obs = extractObs(specimenID, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    referral.setSpecimenID(obs.getValueNumeric().toString());
                }
                obs = extractObs(SmearResult, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setSmearResult(obs.getValueText());
                }
                obs = extractObs(MycobacteriumuTberculosisDetectedWithRifampinResistance, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setMycobacteriumuTBDetectedWithRifampinResistance(obs.getValueText());
                }
                obs = extractObs(CultureResult, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setCultureResult(obs.getValueText());
                }
                obs = extractObs(OtherTBTestResult, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    referral.setOtherTBTestResult(obs.getValueText());
                }
                tBPatientReferralType.add(referral);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return tBPatientReferralType.isEmpty() ? null : tBPatientReferralType;
    }

    //IPT
    public List<TBScreeningIPTmonitoringType> createTBScreeningIPTmonitoringType(Patient patient,List<Encounter> iptMonitoringEncounters) {
        List<TBScreeningIPTmonitoringType> iptMonitoringType = new ArrayList<>();
        try {
            for (Encounter enc : iptMonitoringEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBScreeningIPTmonitoringType ipt = new TBScreeningIPTmonitoringType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    ipt.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    ipt.setVisitID(enc.getEncounterId().toString());
                }

                ipt.setVisitDate(convertedDate);

                Obs obs = extractObs(cough, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setCough(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(fever, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setFever(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(weight_loss, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setWeightLoss(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(nightsweats, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setNightSweats(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(historyOfContactsWithTBPatients, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setHistoryOfContactsWithTBPatients(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(GeneXpertTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setGeneXpertTB(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ChestXrayTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setChestXrayTB(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(CultureTBResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setCulture(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ActiveTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setActiveTB(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(AgeLessThanOneYearContactTBpatient, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setAgeLessThanOneYearContactTBpatient(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(AbnormalChestXRay, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setAbnormalChestXRay(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ActiveHepatitis, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setActiveHepatitis(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBDiagnosisInThreeYears, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setTBDiagnosisInThreeYears(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HighAlcoholConsumption, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setHighAlcoholConsumption(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(SevereImmuneSuppression, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setSevereImmuneSuppression(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PriorAllergyToINH, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setPriorAllergyToINH(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HistoryPoorTreatmentAdherence, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setHistoryPoorTreatmentAdherence(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(IsPatientEligibleIPT, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setIsPatientEligibleIPT(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(DateIPTStart, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        ipt.setDateIPTStart(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(WeightIPTStart,groupedObsByConcept);
                if(obs != null && obs.getValueNumeric() != null){
                    int value_numeric = (int)Math.round(obs.getValueNumeric());
                    ipt.setWeightIPTStart(value_numeric);
                }
                obs = extractObs(INHDailyDose,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    ipt.setINHDailyDose(obs.getValueText());
                }
                obs = extractObs(TBSymptoms, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setTBSymptoms(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HepatitisSymptoms, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setHepatitisSymptoms(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(NeurologicSymptoms, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setNeurologicSymptoms(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Rash, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setRash(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Adherence, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setAdherence(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReferredForFurtherServices, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setReferredForFurtherServices(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OutcomeOfIPT, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setOutcomeOfIPT(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReasonsForStoppingIPT, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    ipt.setReasonsForStoppingIPT(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(DateOfOutcome, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        ipt.setDateOfOutcome(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(NextAppointmentDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        ipt.setNextAppointmentDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                iptMonitoringType.add(ipt);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return iptMonitoringType.isEmpty() ? null : iptMonitoringType;
    }

    //TB Screening
    public List<TBScreeningType> createTBScreeningType(Patient patient,List<Encounter> tbScreeningEncounters) {
        List<TBScreeningType> tBScreeningType = new ArrayList<>();
        try {
            for (Encounter enc : tbScreeningEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBScreeningType screening = new TBScreeningType();
                PatientIdentifier tbId = patient.getPatientIdentifier(Utils.TB_IDENTIFIER_INDEX);
                Date enrollmentDate = Utils.extractEnrollmentDate(patient, Utils.TB_SCREENING_ENCOUNTER_TYPE);

                if(enc.getVisit() != null){
                    screening.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    screening.setVisitID(enc.getEncounterId().toString());
                }
                if (enrollmentDate != null) {
                    screening.setDateOfVisit(utils.getXmlDate(enrollmentDate));
                }
                screening.setTBRegistrationId(tbId.getIdentifier());
                Obs obs = extractObs(Have_cough, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setCurrentCough(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(weight_loss, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setWeightLoss(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(weight_loss, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setWeightLoss(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(have_Fever, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setFever(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Night_sweats, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setNightSweats(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TuberculosisContact, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    screening.setContactWithTBPatient(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(165808, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    screening.setTBScreeningScore(obs.getValueNumeric().intValue());
                }
                tBScreeningType.add(screening);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return tBScreeningType.isEmpty() ? null : tBScreeningType;
    }

    //TB Community And FacilityReferralType
    public List<TBCommunityAndFacilityReferralType>createTBCommunityAndFacilityReferralType(List<Encounter> tbCommunityAndFacilityReferralEncounters) {
        List<TBCommunityAndFacilityReferralType> tBtbCommunityAndFacilityReferralType = new ArrayList<>();
        try {
            for (Encounter enc : tbCommunityAndFacilityReferralEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBCommunityAndFacilityReferralType communityAndFacilityReferralType = new TBCommunityAndFacilityReferralType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    communityAndFacilityReferralType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    communityAndFacilityReferralType.setVisitID(enc.getEncounterId().toString());
                }

                communityAndFacilityReferralType.setVisitDate(convertedDate);

                Obs obs = Utils.extractObs(Referringfacilityname,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setReferringFacility(obs.getValueText());
                }
                obs = extractObs(DateofReferral, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        communityAndFacilityReferralType.setDateofReferral(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = Utils.extractObs(Addressofreferringorganization,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setAddressofReferringOrganization(obs.getValueText());
                }
                obs = Utils.extractObs(NameofReferringOrg,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setNameOfReferringPerson(obs.getValueText());
                }
                obs = Utils.extractObs(PhoneofReferringOrg,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setPhoneNumberOfRefferingOrganization(obs.getValueText());
                }
                obs = extractObs(ReasonForReferral, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    communityAndFacilityReferralType.setReasonForReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PersonMakingReferral, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    communityAndFacilityReferralType.setProfileOfReferringPerson(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = Utils.extractObs(OtherProvMakingReferral,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setOtherProfileOfReferringPersonSpecify(obs.getValueText());
                }
                obs = Utils.extractObs(NameofReceivingOrg,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setReceivingOrganization(obs.getValueText());
                }
                obs = Utils.extractObs(NameofComHealthWrk,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setNameOfHealthWorkerAtReceivingOrganization(obs.getValueText());
                }
                obs = extractObs(OutcomeofTBReferral, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    communityAndFacilityReferralType.setOutcomeOfReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = Utils.extractObs(PhoneofReceivingOrg,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setPhoneNumberOfRecivingOrganization(obs.getValueText());
                }
                obs = extractObs(TBTreatmentoutcomeDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        communityAndFacilityReferralType.setTBTreatmentOutcomeDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166807, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        communityAndFacilityReferralType.setDateOfArrivalAtReferredOrganization(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = Utils.extractObs(166808,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    communityAndFacilityReferralType.setNameOfHealthWorkerAtReceivingOrganization(obs.getValueText());
                }
                obs = extractObs(TUBERCULOSISDRUGTREATMENTSTARTDATE, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        communityAndFacilityReferralType.setTBDrugTreatmentStartDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                tBtbCommunityAndFacilityReferralType.add(communityAndFacilityReferralType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return tBtbCommunityAndFacilityReferralType.isEmpty() ? null : tBtbCommunityAndFacilityReferralType;
    }

    //TB IndexPatient Contact Investigation
    public List<TBIndexPatientContactInvestigationType> createTBIndexPatientContactInvestigationType(List<Encounter> tbIndexContactEncounters) {
        List<TBIndexPatientContactInvestigationType> tBIndexContactType = new ArrayList<>();
        try {
            for (Encounter enc : tbIndexContactEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBIndexPatientContactInvestigationType indexPatientContactInvestigationType = new TBIndexPatientContactInvestigationType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    indexPatientContactInvestigationType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    indexPatientContactInvestigationType.setVisitID(enc.getEncounterId().toString());
                }
                indexPatientContactInvestigationType.setVisitDate(convertedDate);
                Obs obs = extractObs(NameofTBcontactinvestigator, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setTBContactInvestigator(obs.getValueText());
                }
                obs = extractObs(PhoneTBcontactinvestigator, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setPhoneNumberOfTBContactInvestigator(obs.getValueText());
                }
                obs = extractObs(DateofContactTracing, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        indexPatientContactInvestigationType.setDateOfTBContactTracing(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(LGATBNUmber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setLGATBNumber(obs.getValueText());
                }
                obs = extractObs(NumberHouseholdContacts, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setNumberOfHouseholdContacts(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TypeofTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setTypeOfTB(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ConsentForContactTracing, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setConsentForContactTracing(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBContactName, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setTBContactName(obs.getValueText());
                }
                obs = extractObs(TBContactAge, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    indexPatientContactInvestigationType.setTBContactAge(value_numeric);
                }
                obs = extractObs(TBContactSex, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setTBContactSex(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBContactNumber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setTBContactPhoneNumber(obs.getValueText());
                }
                obs = extractObs(RtnTBIndexCase, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setRelationshipWithTBIndexCase(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(CoughLess2wks, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setCoughGreaterThanOrEqualTo2Weeks(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(RecentWeightLoss, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setRecentWeightLoss(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(NightSweat, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    indexPatientContactInvestigationType.setNightSweat(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(have_Fever, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setFever(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Presumptive_Identified, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setSputumSamplesCollected(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Presumptive_Identified_referred, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setPresumptiveTBCaseReferredForDiagnosis(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBDiagnosed, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    indexPatientContactInvestigationType.setTBDiagnosed(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                tBIndexContactType.add(indexPatientContactInvestigationType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return tBIndexContactType.isEmpty() ? null : tBIndexContactType;
    }

    //Presumptive TB Register
    public List<PresumptiveTBRegisterType> createPresumptiveTBRegisterType(Patient patient,List<Encounter> presumptiveTBRegisterEncounters) {
        List<PresumptiveTBRegisterType> presumptiveTBRegisterType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : presumptiveTBRegisterEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                PresumptiveTBRegisterType presumptive = new PresumptiveTBRegisterType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    presumptive.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    presumptive.setVisitID(enc.getEncounterId().toString());
                }
                presumptive.setVisitDate(convertedDate);

                Obs obs = extractObs(SpecimenID, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    presumptive.setSpecimenIdentificationNumber(obs.getValueText());
                }
                obs = extractObs(TypeofTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setTypeOfPresumptiveTB(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(IsClientHealthWorker, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setIsClientAHealthWorker(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReferralSource, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    presumptive.setClientReferredBy(obs.getValueText());
                }
                obs = extractObs(SiteofTB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setSiteOfDisease(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBSpecimenCollectionDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        presumptive.setSpecimenCollectionDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(TBResultDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        presumptive.setResultReleaseDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(TBPCRChecking, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setXpertOrMTBOrRIFResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(AFBResult, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    presumptive.setAFBResult(obs.getValueNumeric().floatValue());
                }
                obs = extractObs(ChestXRay, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setXRayResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBClinicalDiagnosed, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setClinicallyDiagnosed(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PreviouslyKnownHIV, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setPreviouslyKnownHIVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(HIVTestPerformed, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setTestedForHIV(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OutcomeofTBInvegigation, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setOutcomeOfTBInvestigation(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBTreatmentStarted, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    presumptive.setTBTreatmentStarted(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                presumptiveTBRegisterType.add(presumptive);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return presumptiveTBRegisterType.isEmpty() ? null : presumptiveTBRegisterType;
    }

    //DR-TB Treatment Registration Form
    public List<DRTBTreatmentRegisterType> createDRTBTreatmentRegisterType(Patient patient,List<Encounter> drTreatmentRegisterTypeEncounters) {
        List<DRTBTreatmentRegisterType> drTreatmentRegisterType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : drTreatmentRegisterTypeEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                DRTBTreatmentRegisterType dRTBTreatmentRegisterType = new DRTBTreatmentRegisterType();
                //PatientIdentifier tbId = patient.getPatientIdentifier(Utils.TB_IDENTIFIER_INDEX);
                Date enrollmentDate = Utils.extractEnrollmentDate(patient, Utils.DRTB_TREATMENT_ENCOUNTER_TYPE);

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    dRTBTreatmentRegisterType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    dRTBTreatmentRegisterType.setVisitID(enc.getEncounterId().toString());
                }

                dRTBTreatmentRegisterType.setVisitDate(convertedDate);

                Obs obs = extractObs(PatientSerialNumber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    dRTBTreatmentRegisterType.setPatientSerialNumber(obs.getValueText());
                }

                if (enrollmentDate != null) {
                    dRTBTreatmentRegisterType.setDateRegistered(utils.getXmlDate(enrollmentDate));
                }
                obs = extractObs(PlaceOfInitiation, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    dRTBTreatmentRegisterType.setPlaceOfInitiation(obs.getValueText());
                }
                obs = extractObs(Referringfacilityname, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    dRTBTreatmentRegisterType.setReferringHealthFacility(obs.getValueText());
                }
                obs = extractObs(ReferringFacilityState, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    dRTBTreatmentRegisterType.setReferringFacilityState(obs.getValueText());
                }
                obs = extractObs(ReferringFacilityLGA, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    dRTBTreatmentRegisterType.setReferringFacilityLGA(obs.getValueText());
                }
                obs = extractObs(PreviouslyOnTB2ndLineDrug, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setPreviouslyOnTB2NdLineDrug(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(5089, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    dRTBTreatmentRegisterType.setWeight(obs.getValueNumeric().floatValue());
                }

                obs = extractObs(5090, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    dRTBTreatmentRegisterType.setHeight(obs.getValueNumeric().floatValue());
                }

                obs = extractObs(TypefTreatmentRegimen, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setTypeOfTreatmentRegimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(DateTreatmentStarted, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        dRTBTreatmentRegisterType.setDateTreatmentStarted(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(SiteofDisease, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setSiteOfDisease(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(RegistrationGroup, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setRegistrationGroup(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(GeneXpert, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setGeneXpert(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(AFB, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setAFB(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(Culture, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setCulture(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                LoggerUtils.write(TBDictionary.class.getName(), "About to pull all LPAResul", LogFormat.FATAL, LogLevel.live);

                List<LPAResultType> lpaResultTypeList = createLPAResultType(groupedObsByConcept);
                if (lpaResultTypeList.size() > 0) {
                    dRTBTreatmentRegisterType.setLPAResult(lpaResultTypeList);
                }

                LoggerUtils.write(TBDictionary.class.getName(), "About to pull all DSTResul", LogFormat.FATAL, LogLevel.live);
                List<DSTResultType> dstResultTypeList = createDSTResultType(groupedObsByConcept);
                if (dstResultTypeList.size() > 0) {
                    dRTBTreatmentRegisterType.setDSTResult(dstResultTypeList);
                }

                List<DRTBTreatmentRegisterType.FollowUpInvestigation> followUpList = createFollowUp(groupedObsByConcept);
                assert followUpList != null;
                if (followUpList.size() > 0) {
                    dRTBTreatmentRegisterType.setFollowUpInvestigation(followUpList);
                }


                obs = extractObs(XRayDone, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setXRayDone(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(HIVStatus, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setHIVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                /*obs = extractObs(EnrolledinCare, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setE(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }*/

                obs = extractObs(ARTStartDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        dRTBTreatmentRegisterType.setARTStartDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(CPT, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setCPT(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(CPTStartDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        dRTBTreatmentRegisterType.setCPTStartDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(TBtreatmentOutcome, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    dRTBTreatmentRegisterType.setOutcome(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(OutcomeDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        dRTBTreatmentRegisterType.setOutcomeDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }



                /*try {
                    List<FollowUpInvestigation> followupinvestigation = new ArrayList<>();
                    List<Person> person2 = new ArrayList<>();
                    person2.add(patient.getPerson());
                    List<Encounter> encounter2 = new ArrayList<>();
                    encounter2.add(enc);
                    List<Concept> concepts = new ArrayList<>();
                    concepts.add(new Concept(167003));
                    List<Obs> obs7 = Context.getObsService().getObservations(person2, encounter2, concepts, null, null, null, null, null, null, null, null, false);
                    FollowUpInvestigation followup = new FollowUpInvestigation();

                    for (Obs obssingle : obs7) {
                        followup.

                    }
                }catch (Exception ex) {

                }*/



                drTreatmentRegisterType.add(dRTBTreatmentRegisterType);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return drTreatmentRegisterType.isEmpty() ? null : drTreatmentRegisterType;
    }

    private List<FollowUpInvestigation> createFollowUp(Map<Object, List<Obs>> groupedObsByConcept) {
        List<FollowUpInvestigation> followUpTypes = new ArrayList<>();
        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(166544);

            allIndexGroupObs.forEach(gObs -> {

                FollowUpInvestigation followup = new FollowUpInvestigation();

                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());
                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                //extract all the members using the concept
                Obs obs = extractObs(167003, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    followup.setMonth(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(166580, allMembers);
                if (obs != null && obs.getValueText() != null) {
                    followup.setSmearResult(obs.getValueText());
                }

                obs = extractObs(166783, allMembers);
                if (obs != null && obs.getValueText() != null) {
                    followup.setCultureResult(obs.getValueText());
                }
                obs = extractObs(166574, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        followup.setResultDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                followUpTypes.add(followup);
            });
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return followUpTypes.isEmpty() ? null :  followUpTypes;
    }

    public List<LPAResultType> createLPAResultType(Map<Object, List<Obs>> groupedObsByConcept) {
        List<LPAResultType> lpaResultTypes = new ArrayList<>();

        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(167118);

            allIndexGroupObs.forEach(gObs -> {

                        LPAResultType lparesult = new LPAResultType();

                        List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());

                        Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                        //extract all the members using the concept
                        Obs obs = extractObs(166758, allMembers);
                        if (obs != null && obs.getValueCoded() != null) {
                            lparesult.setNameOfAminoglycoside(getMappedValue(obs.getValueCoded().getConceptId()));
                        }

                        obs = extractObs(166760, allMembers);
                        if (obs != null && obs.getValueCoded() != null) {
                            lparesult.setNameOfAminoglycosideResistantPattern(getMappedValue(obs.getValueCoded().getConceptId()));
                        }

                        lpaResultTypes.add(lparesult);

                    }

            );
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(159987);

            allIndexGroupObs.forEach(gObs -> {

                        LPAResultType lparesult = new LPAResultType();

                        List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());


                        Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                        //extract all the members using the concept
                        Obs obs = extractObs(166759, allMembers);
                        if (obs != null && obs.getValueCoded() != null) {
                            lparesult.setNameOofQuinolone(getMappedValue(obs.getValueCoded().getConceptId()));
                        }

                        obs = extractObs(166760, allMembers);
                        if (obs != null && obs.getValueCoded() != null) {
                            lparesult.setNameOofQuinoloneResistantPattern(getMappedValue(obs.getValueCoded().getConceptId()));
                        }
                        lpaResultTypes.add(lparesult);

                    }

            );
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return lpaResultTypes.isEmpty() ? null :  lpaResultTypes;
    }

    public List<DSTResultType> createDSTResultType(Map<Object, List<Obs>> groupedObsByConcept) {
        List<DSTResultType> dstResultTypes = new ArrayList<>();

        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(167120);
            allIndexGroupObs.forEach(gObs -> {
                DSTResultType dstResult = new DSTResultType();
                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());
                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                //extract all the members using the concept
                Obs obs = extractObs(160021, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dstResult.setNameDSTResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(159984, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dstResult.setNameDSTResultResistantPattern(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                dstResultTypes.add(dstResult);
            });
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return dstResultTypes.isEmpty() ? null :  dstResultTypes;
    }

    //TB Tracking and Interruption
    public List<TBInterruptionTrackingType> createTBInterruptionTrackingType(List<Encounter> tBInterruptionTrackingEncounters) {
        List<TBInterruptionTrackingType> tBInterruptionTrackingType = new ArrayList<>();
        try {
            for (Encounter enc : tBInterruptionTrackingEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBInterruptionTrackingType interruptionTracking = new TBInterruptionTrackingType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    interruptionTracking.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    interruptionTracking.setVisitID(enc.getEncounterId().toString());
                }
                interruptionTracking.setVisitDate(convertedDate);

                Obs obs = extractObs(TrackingAttempts, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setTrackingAttempts(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Date_of_LastDrugIntake, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        interruptionTracking.setDateOfLastDrugIntake(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(ModeOfTracking, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setModeOfTracking(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ContactPatient, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setPatientContacted(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PersonContacted, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setPersonContacted(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReasonForAbsence, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setReasonForAbsence(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OtherReason, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    interruptionTracking.setOtherReasonRorDefaulting(obs.getValueText());
                }
                obs = extractObs(SolutionToAbsence, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    interruptionTracking.setSolutionToAbsence(obs.getValueText());
                }
                obs = extractObs(TBTrackingOutcome, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    interruptionTracking.setTBTrackingOutcome(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                tBInterruptionTrackingType.add(interruptionTracking);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return tBInterruptionTrackingType.isEmpty() ? null : tBInterruptionTrackingType;
    }

    //TB Laboratory Register
    public List<TBLaboratoryRegisterType> createTBLaboratoryRegisterType(List<Encounter> tBLaboratoryRegisterEncounters) {
        List<TBLaboratoryRegisterType> tBLaboratoryRegisterType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : tBLaboratoryRegisterEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBLaboratoryRegisterType tbLaboratoryRegister = new TBLaboratoryRegisterType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    tbLaboratoryRegister.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    tbLaboratoryRegister.setVisitID(enc.getEncounterId().toString());
                }
                tbLaboratoryRegister.setVisitDate(convertedDate);

                Obs obs = extractObs(NTBLCP, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setNTBLCPOrTB04(obs.getValueText());
                }
                obs = extractObs(LabName, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setLaboratoryName(obs.getValueText());
                }
                obs = extractObs(LabLGA, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setLGA(obs.getValueText());
                }
                obs = extractObs(SpecimenID, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    tbLaboratoryRegister.setSpecimenIdentificationNumber(obs.getValueNumeric().toString());
                }
                obs = extractObs(DateSentToLab, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        tbLaboratoryRegister.setDateSpecimenWasSentToLaboratory(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(SpecimenStatus, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setSpecimenStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReasonRejection, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setReasonForSpecimenRejection(obs.getValueText());
                }
                obs = extractObs(Referringfacilityname, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setReferringFacilityName(obs.getValueText());
                }
                obs = extractObs(TypeofTBPresumptive, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setTypeOfTBPresumptive(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(SiteofDisease, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setTBSiteOfDisease(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HealthProvider, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setHealthCareProvider(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HIVStatus, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setHIVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TestHIVLab, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setTestedForHIVInTheLab(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OtherSpecimenType, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setSpecifyTypeOfSpecimen(obs.getValueText());
                }
                obs = extractObs(166614, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setSpecifyTestsRequired(obs.getValueText());
                }
                obs = extractObs(MTBDeceted, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setWasMTBDetected(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(SpecifyMTBDeceted, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setSpecifyDetectedMTB(obs.getValueText());
                }
                obs = extractObs(InvalidTest, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setInvalidOrIncompleteTest(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReasonforAFBTest, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setReasonForAFBTest(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(AFBResult, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    tbLaboratoryRegister.setAFBResult(obs.getValueNumeric().floatValue());
                }
                obs = extractObs(OtherTestType, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setOtherTBTestType(obs.getValueText());
                }
                obs = extractObs(OtherTestTypeResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    tbLaboratoryRegister.setOtherTBTestsResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166401, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    tbLaboratoryRegister.setNameOfReporter(obs.getValueText());
                }
                obs = extractObs(TBTestResultDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        tbLaboratoryRegister.setTuberculosisTestResultDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                tBLaboratoryRegisterType.add(tbLaboratoryRegister);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return tBLaboratoryRegisterType.isEmpty() ? null : tBLaboratoryRegisterType;
    }

    //LGA Health Facility TBCentralRegister
    public List<LGAHealthFacilityTBCentralRegisterType> createLGAHealthFacility(List<Encounter> lGAHealthFacilityTypeEncounters) {
        List<LGAHealthFacilityTBCentralRegisterType> lGAHealthFacilityType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : lGAHealthFacilityTypeEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                LGAHealthFacilityTBCentralRegisterType healthfacility = new LGAHealthFacilityTBCentralRegisterType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    healthfacility.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    healthfacility.setVisitID(enc.getEncounterId().toString());
                }
                healthfacility.setVisitDate(convertedDate);

                Obs obs = extractObs(DateTBRegistered, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        healthfacility.setDateRegistered(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(TypeofTBPatient, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setTypeOfPatient(getMappedValue3(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(LGATBNUmber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setLGATBNumber(obs.getValueText());
                }
                obs = extractObs(ETBUniqueNumber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setETBMangerUniqueNumber(obs.getValueText());
                }
                obs = extractObs(FacilityStartedTreatment, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setFacilityWherePatientStartedTreatment(obs.getValueText());
                }
                obs = extractObs(WeightAtStart, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    healthfacility.setWeightAtTheStartOfTreatment(obs.getValueNumeric().floatValue());
                }
                obs = extractObs(TBRegimens, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setTreatmentRegimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(DateStartedTBTreatment, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        healthfacility.setDateTreatmentStarted(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(ReferredFromComm, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setReferredFromCommunity(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(ReferredFromPmmSite, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setReferredFromPPMSite(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(IsDOTProvided, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setIsDOTProvidedByTS(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(SiteofDisease, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setSiteOfDisease(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TBPCRChecking, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setXpertMTBOrRIF(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(OtherTest_TB_LAM, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setOtherTest(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(AFB_Month_0, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setMonth0SmearResult(obs.getValueText());
                    obs = extractObs(AFB_Result_Date, groupedObsByConcept);
                    if (obs != null && obs.getValueDate() != null) {
                        try {
                            healthfacility.setMonth0SmearResultDate(utils.getXmlDate(obs.getValueDate()));
                        } catch (Exception ex) {
                            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }
                    }
                }

                obs = extractObs(AFB_Month_2, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setMonth2Or3SmearResult(obs.getValueText());
                    obs = extractObs(AFB_Result_Date, groupedObsByConcept);
                    if (obs != null && obs.getValueDate() != null) {
                        try {
                            healthfacility.setMonth2Or3SmearResultDate(utils.getXmlDate(obs.getValueDate()));
                        } catch (Exception ex) {
                            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }
                    }
                }

                obs = extractObs(AFB_Month_5, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setMonth5SmearResult(obs.getValueText());
                    obs = extractObs(AFB_Result_Date, groupedObsByConcept);
                    if (obs != null && obs.getValueDate() != null) {
                        try {
                            healthfacility.setMonth5SmearResultDate(utils.getXmlDate(obs.getValueDate()));
                        } catch (Exception ex) {
                            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }
                    }
                }

                obs = extractObs(AFB_Month_6, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setMonth6SmearResult(obs.getValueText());
                    obs = extractObs(AFB_Result_Date, groupedObsByConcept);
                    if (obs != null && obs.getValueDate() != null) {
                        try {
                            healthfacility.setMonth6SmearResultDate(utils.getXmlDate(obs.getValueDate()));
                        } catch (Exception ex) {
                            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                        }
                    }
                }

                obs = extractObs(ChestXRay, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setXRayResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(Biopsy_Result, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setBiopsyResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TBtreatmentOutcome, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setTreatmentOutcome(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TBTreatmentoutcomeDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        healthfacility.setOutcomeDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(PreviouslyKnownHIV, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setPreviouslyKnownHIVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(HIVTestPerformed, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    healthfacility.setTestedForHIV(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }


                obs = extractObs(166714, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    healthfacility.setRemarks(obs.getValueText());
                }


                lGAHealthFacilityType.add(healthfacility);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return lGAHealthFacilityType.isEmpty() ? null : lGAHealthFacilityType;
    }

    //TB Specimen Examination Request Form
    public List<SpecimenExaminationRequestFormType> createSpecimenExaminationRequest(List<Encounter> specimenExaminationRequestEncounters) {
        List<SpecimenExaminationRequestFormType> specimenExaminationRequestFormType = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : specimenExaminationRequestEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                SpecimenExaminationRequestFormType specimenrequest = new SpecimenExaminationRequestFormType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    specimenrequest.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    specimenrequest.setVisitID(enc.getEncounterId().toString());
                }
                specimenrequest.setVisitDate(convertedDate);

                Obs obs = extractObs(SpecimenCollectionDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenrequest.setSpecimenCollectionDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(SpecimenID, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setSpecimenIdentificationNumber(obs.getValueText());
                }
                obs = extractObs(LGATBNUmber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setLGAOrTBNumber(obs.getValueText());
                }
                obs = extractObs(TypeofTBPresumptive, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setTypeOfPresumptiveTB(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(SiteofDisease, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setSiteOfDisease(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HealthProvider, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setIsPatientAHealthWorker(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HIVStatus, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setHIVStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HIVTestRequested, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setHIVTestRequested(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(ReasonforScreening, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setReasonForExamination(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TestTypeRequest, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenrequest.setTestTypeRequest(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OtherSpecimenType, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setTypeOfSpecimen(obs.getValueText());
                }
                obs = extractObs(NumberSenttoLab, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    specimenrequest.setNumberSentToLaboratory(obs.getValueNumeric().intValue());
                }
                obs = extractObs(DateFirstPCRSample, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenrequest.setFirstSampleCollectionDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(DateSecondPCRSample, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenrequest.setSecondSampleCollectionDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(PersonRequestingExam, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setNameOfPersonRequestingExamination(obs.getValueText());
                }
                obs = extractObs(Email, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setEmail(obs.getValueText());
                }
                obs = extractObs(159635, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setPhoneNumber(obs.getValueText());
                }
                obs = extractObs(HealthFacilityName, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setNameOfHealthFacility(obs.getValueText());
                }
                obs = extractObs(RefferingFacilityState, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenrequest.setState(obs.getValueText());
                }
                specimenExaminationRequestFormType.add(specimenrequest);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return specimenExaminationRequestFormType.isEmpty() ? null : specimenExaminationRequestFormType;
    }

    //Specimen Examination Result Form
    public List<SpecimenExaminationResultFormType> createSpecimenExaminationResultFormType(List<Encounter> specimenExaminationResultEncounters) {
        List<SpecimenExaminationResultFormType> specimenExaminationResultFormType = new ArrayList<>();
        try {
            for (Encounter enc : specimenExaminationResultEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                SpecimenExaminationResultFormType specimenexam = new SpecimenExaminationResultFormType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    specimenexam.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    specimenexam.setVisitID(enc.getEncounterId().toString());
                }
                specimenexam.setVisitDate(convertedDate);

                Obs obs = extractObs(Referringfacilityname, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setNameOfRequestingHealthFacility(obs.getValueText());
                }
                obs = extractObs(ReferringFacilityState, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setStateOfRequestingHealthFacility(obs.getValueText());
                }
                obs = extractObs(LGATBNUmber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setLGAOrTBNumber(obs.getValueText());
                }
                obs = extractObs(164422, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setNameOfLaboratory(obs.getValueText());
                }
                obs = extractObs(LabNumber, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setLaboratorySerialNumber(obs.getValueText());
                }
                obs = extractObs(MTBnotDetected, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setMTBNotDetected(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(OtherTBTest, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setOtherTestTypeSpecified(obs.getValueText());
                }
                obs = extractObs(OtherTestTypeResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setOtherTestTypeSpecified(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(DateAFBSampleReceived, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setDateAFBSmearSampleReceived(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(162476, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setSpecimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(AFBSpecimenApperance, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setAppearance(obs.getValueText());
                }
                obs = extractObs(166785, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(AFBExaminedBy, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setAFBSmearResultExaminedBy(obs.getValueText());
                }
                obs = extractObs(AFBResultDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setDateOfAFBSmearMicroscopyResult(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(TypeofCulture, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setTypeOfCultureResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(CultureSampleDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setDateCultureSampleReceived(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(SolidCultureResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setSolidCultureResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                /*obs = extractObs(SpecimenSource, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setLiquidCultureResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }*/
                obs = extractObs(ResultofComfirmatoryMTB, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setResultOfConfirmatoryTestForMTB(obs.getValueText());
                }
                obs = extractObs(ResultofComfirmatoryMTB, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setCultureExaminedBy(obs.getValueText());
                }
                obs = extractObs(CultureResultDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setCultureDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(TypeofLPADST, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setTypeOfLPAOrDSTMethodUsed(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(DateLPADSTSampleReceived, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setDateSampleReceived(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(LPADSTSpecimenType, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setLPASpecimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(LPAResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setLPAResults(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(167116, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setLPADrugs(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(DSTResult, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setDSTResults(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(167117, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setDSTDrugs(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(LPADSTExaminedBy, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setDSTExaminedBy(obs.getValueText());
                }
                obs = extractObs(DateLPADSTSampleReceived, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setDSTDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(159427, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    specimenexam.setHIVTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(TestResultReceivedDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        specimenexam.setHIVTestResultDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(TestResultCheckedBy, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    specimenexam.setResultCheckedAndReleasedBy(obs.getValueText());
                }

                specimenExaminationResultFormType.add(specimenexam);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return specimenExaminationResultFormType.isEmpty() ? null : specimenExaminationResultFormType;
    }

    //TB Treatment Monitoring
    public List<TBTreatmentMonitoringType> createTBTreatmentMonitoringType(List<Encounter> tbTreatmentMonitoringTypeEncounters) {
        List<TBTreatmentMonitoringType> tbMonitoring = new ArrayList<>();
        NumericType numeric = null;
        try {
            for (Encounter enc : tbTreatmentMonitoringTypeEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                TBTreatmentMonitoringType monitoring = new TBTreatmentMonitoringType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    monitoring.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    monitoring.setVisitID(enc.getEncounterId().toString());
                }
                monitoring.setVisitDate(convertedDate);

                Obs obs = extractObs(TypeOfRegimen, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setTypeOfRegimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TreatmentAgeGroup, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setTreatmentAgeGroup(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(PregnancyStatus, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setPregnancyAndBreastfeedingStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(AntiTBDrugs, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setIntensivePhaseAntiTBDrugs(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(ARVDrugStrength, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setIntensivePhaseAntiTBDrugStrength(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(DrugFrequency, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setIntensivePhaseDrugFrequency(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TBDrugDuration, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setIntensivePhaseTBDrugDuration(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(QtyPrescribed, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    monitoring.setIntensivePhaseQuantityOfMedicationPrescribed(obs.getValueNumeric().intValue());
                }

                /*obs = extractObs(AntiTBDrugs, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setContinuityPhaseAntiTBDrugs(getMappedValue(obs.getValueCoded().getConceptId()));
                }*/

                obs = extractObs(ARVDrugStrength, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setIntensivePhaseAntiTBDrugStrength(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                /*obs = extractObs(DrugFrequency, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setContinuityPhaseDrugFrequency(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TBDrugDuration, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setContinuityPhaseTBDrugDuration(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(QtyPrescribed, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    numeric = new NumericType();
                    numeric.setValue1(obs.getValueNumeric().intValue());
                    monitoring.setContinuityPhaseQuantityOfMedicationPrescribed(numeric);
                }*/

                obs = extractObs(SelectOutcome, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setSelectOutcome(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(TBTreatmentoutcomeDate, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        monitoring.setTBTreatmentOutcomeDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(163556, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    monitoring.setDOTProviderType(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = Utils.extractObs(1473,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    monitoring.setDOTProviderName(obs.getValueText());
                }

                tbMonitoring.add(monitoring);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return tbMonitoring.isEmpty() ? null : tbMonitoring;
    }

    //DRTBInPatientDischargeFormType
    public List<DRTBInPatientDischargeFormType>createDRTBInPatientDischargeFormType(List<Encounter> drtbInPatientDischargeEncounters) {
        List<DRTBInPatientDischargeFormType> drtbInPatientDischargeFormType = new ArrayList<>();
        try {
            for (Encounter enc : drtbInPatientDischargeEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                DRTBInPatientDischargeFormType drtbInPatientDischarge = new DRTBInPatientDischargeFormType();
                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

                if(enc.getVisit() != null){
                    drtbInPatientDischarge.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                }else{
                    drtbInPatientDischarge.setVisitID(enc.getEncounterId().toString());
                }

                drtbInPatientDischarge.setVisitDate(convertedDate);

                Obs obs = Utils.extractObs(166818,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setTreatmentCentre(obs.getValueText());
                }
                obs = Utils.extractObs(166819,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setState(obs.getValueText());
                }
                obs = extractObs(166820, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        drtbInPatientDischarge.setDateOfAdmission(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166821, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        drtbInPatientDischarge.setDateOfDischarge(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = Utils.extractObs(166822,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setRegistrationNumber(obs.getValueText());
                }
                obs = extractObs(166823, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        drtbInPatientDischarge.setDateOfRegistration(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166824, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        drtbInPatientDischarge.setDateOfTreatmentInitiation(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = Utils.extractObs(165508,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setFacilityPatientIsDischargedTo(obs.getValueText());
                }
                obs = Utils.extractObs(LGA,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setLGAOfState(obs.getValueText());
                }
                obs = extractObs(166662, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    drtbInPatientDischarge.setAnyCoMorbidity(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                    obs = Utils.extractObs(166663,groupedObsByConcept);
                    if(obs != null && obs.getValueText() != null){
                        drtbInPatientDischarge.setSpecifiedCoMorbidities(obs.getValueText());
                    }
                    /*obs = Utils.extractObs(PhoneofReferringOrg,groupedObsByConcept);
                    if(obs != null && obs.getValueText() != null){
                        drtbInPatientDischarge.setSpecifiedDrugsUsed(obs.getValueText());
                    }*/
                }
                obs = Utils.extractObs(166979,groupedObsByConcept);
                if(obs != null && obs.getValueCoded() != null){
                    drtbInPatientDischarge.setShortRegimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = Utils.extractObs(166980,groupedObsByConcept);
                if(obs != null && obs.getValueCoded() != null){
                    drtbInPatientDischarge.setComposition(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                List<DRTBInPatientDischargeFormType.TbRegimenToBeContinuedAtDoTFacility> tbRegimenToBeContinuedAtDoTFacilityList = createDoT(groupedObsByConcept);
                assert tbRegimenToBeContinuedAtDoTFacilityList != null;
                if (tbRegimenToBeContinuedAtDoTFacilityList.size() > 0) {
                    drtbInPatientDischarge.setTbRegimenToBeContinuedAtDoTFacility(tbRegimenToBeContinuedAtDoTFacilityList);
                }

                List<DRTBInPatientDischargeFormType.AdverseReaction> adverseReactionList = creatadverseReactionList(groupedObsByConcept);
                assert adverseReactionList != null;
                if (adverseReactionList.size() > 0) {
                    drtbInPatientDischarge.setAdverseReaction(adverseReactionList);
                }

                obs = Utils.extractObs(166810,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setNameOfSTBLCOPatientIsDischargedTo(obs.getValueText());
                }

                obs = Utils.extractObs(166811,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setPhoneNoOfSTBLCO(obs.getValueText());
                }
                obs = Utils.extractObs(166812,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setNameOfStateDRTBFocalPerson(obs.getValueText());
                }
                obs = Utils.extractObs(166813,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setPhoneNoOfStateDRTBFocalPerson(obs.getValueText());
                }
                obs = Utils.extractObs(166814,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setNameOfTreatmentCentreDoctor(obs.getValueText());
                }
                obs = Utils.extractObs(166815,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setPhoneNoOfTreatmentCentreDoctor(obs.getValueText());
                }
                obs = Utils.extractObs(166816,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setNameOfTreatmentCentreMatron(obs.getValueText());
                }
                obs = Utils.extractObs(166817,groupedObsByConcept);
                if(obs != null && obs.getValueText() != null){
                    drtbInPatientDischarge.setPhoneNoOfTreatmentCentreMatron(obs.getValueText());
                }
                drtbInPatientDischargeFormType.add(drtbInPatientDischarge);
            }
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return drtbInPatientDischargeFormType.isEmpty() ? null : drtbInPatientDischargeFormType;
    }

    private List<DRTBInPatientDischargeFormType.AdverseReaction> creatadverseReactionList(Map<Object, List<Obs>> groupedObsByConcept) {
        List<DRTBInPatientDischargeFormType.AdverseReaction> adverseReactionTypes = new ArrayList<>();
        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(166676);
            allIndexGroupObs.forEach(gObs -> {
                DRTBInPatientDischargeFormType.AdverseReaction adverse = new AdverseReaction();
                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());
                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                //extract all the members using the concept
                Obs obs = extractObs(166674, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    adverse.setType(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166664, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        adverse.setDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166677, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    adverse.setManagement(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                adverseReactionTypes.add(adverse);
            });
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return adverseReactionTypes.isEmpty() ? null :  adverseReactionTypes;
    }

    private List<TbRegimenToBeContinuedAtDoTFacility> createDoT(Map<Object, List<Obs>> groupedObsByConcept) {
        List<TbRegimenToBeContinuedAtDoTFacility> doTFacilityTypes = new ArrayList<>();
        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(165728);
            allIndexGroupObs.forEach(gObs -> {
                TbRegimenToBeContinuedAtDoTFacility dotFacility = new TbRegimenToBeContinuedAtDoTFacility();
                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());
                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                NumericType numeric = null;
                //extract all the members using the concept
                Obs obs = extractObs(165304, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dotFacility.setDrug(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(165725, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dotFacility.setStrength(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(165723, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dotFacility.setFrequency(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166838, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    dotFacility.setDuration(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(160856, groupedObsByConcept);
                if (obs != null && obs.getValueNumeric() != null) {
                    dotFacility.setQtyPrescribed(obs.getValueNumeric().intValue());
                }
                doTFacilityTypes.add(dotFacility);
            });
        } catch (Exception ex) {
            LoggerUtils.write(TBDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return doTFacilityTypes.isEmpty() ? null :  doTFacilityTypes;
    }

    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        tbBooleanDictionary.put(1065, true);
        tbBooleanDictionary.put(1066, false);

    }

    private void loadYNCodeTypeDictionary() {
        tbYNCodeTypeDict.put(1065, YNCodeType.YES);
        tbYNCodeTypeDict.put(1066, YNCodeType.NO);
        tbYNCodeTypeDict.put(1, YNCodeType.YES);
        tbYNCodeTypeDict.put(2, YNCodeType.NO);
    }


    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;

        if (tbYNCodeTypeDict.containsKey(key)) {
            response = tbYNCodeTypeDict.get(key);
        }
        return response;
    }

    private Boolean getBooleanMappedValue(int key) {
        if (tbBooleanDictionary.containsKey(key)) {
            return tbBooleanDictionary.get(key);
        } else {
            return tbBooleanDictionary.get(key);
        }
    }

    private Boolean getBooleanMappedValue(double key) {
        if (tbBooleanDictionary.containsKey(key)) {
            return tbBooleanDictionary.get(key);
        } else {
            return tbBooleanDictionary.get(key);
        }
    }

    private String getMappedValue(int conceptID) {
        try {
            return tbDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue2(int conceptID) {
        try {
            return tbDictionary2.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue3(int conceptID) {
        try {
            return tbDictionary3.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

}
