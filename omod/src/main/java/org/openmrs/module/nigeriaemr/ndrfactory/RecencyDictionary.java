package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.*;
import java.util.stream.Collectors;
import org.openmrs.*;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class RecencyDictionary {

    Utils utils = new Utils();
    private final PharmacyDictionary pharmacyDictionary;

    //HIV Recency Testing
    public static int HIV_RECENCY_TEST_NAME_CONCEPT = 166216;//formerly 165849
    public static int HIV_RECENCY_TEST_NAME_CONCEPT_OLD = 165849;//now 166216
    public static int HIV_RECENCY_TEST_DATE_CONCEPT = 165850;
    public static int HIV_RECENCY_ASSAY_CONCEPT = 165853;
    public static int SAMPLE_TEST_DATE_CONCEPT = 165854;
    public static int SAMPLE_TEST_RESULT_CONCEPT = 856;
    public static int FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT = 166214;
    public static int OPT_OUT_OF_RTRI = 165805;
    public static int RECENCY_NUMBER = 166209;
    public static int CONTROL_LINE = 166212;
    public static int VERIFICATION_LINE = 166243;
    public static int LONG_TERM_LINE = 166211;
    public static int RECENCY_INTERPRETATION = 166213;
    public static int VIRALLOAD_REQUEST_MADE = 166244;
    public static int VIRAL_LOAD_SAMPLE_COLLECTION_DATE = 159951;
    public static int VIRAL_LOAD_SAMPLE_SENT_DATE = 165988;
    public static int SAMPLE_TYPE = 162476;
    public static int RECEIVING_PCR_LAB = 166233;
    public static int SAMPLE_ID = 165715;
    public static int VIRAL_LOAD_CLASSIFICATION = 166241;
    public static int HIV_VIRAL_LOAD = 856;
    public static final int VIRAL_LOAD_RESULT_DATE = 166423;
    public static final int LINKED_TO_CARE = 166938;
    public static final int DATE_LINKED_TO_CARE = 166939;
    public static final int ARTInitiation = 166940;
    public static final int DATE_ARTInitiation = 166941;
    public static final int ART_Number = 166905;
    public static int CurrentRegimenLine = 165708;
    public static int clientAttendEAC = 166907;
    public static int VLinPast12Months = 166908;
    public static int HIV_VL = 856;
    public static int VLS_ACHIEVED_6MTHS = 166909;
    public static int KP_PP = 166913;
    public static int KPTYPE = 166914;
    public static int PPTYPE = 166915;
    public static int OFFERED_INDEX_TESTING = 166918;
    public static int PROVIDE_CONTACTS = 166919;

    //Partner Information
    private static final int PARTNER_INFORMATION_CONCEPT = 167078;
    private static final int PARTNER_GENDER_CONCEPT = 165857;
    private static final int PARTNER_AGE = 166920;
    private static final int PARTNER_PREGNANT = 166921;
    private static final int CONTACT_PROVIDED = 166922;
    private static final int PARTNER_WITH_INDEX = 166931;
    private static final int GIVEN_KIT = 166933;
    private static final int HIV_RETESTING = 165976;
    private static final int PARTNER_HIV_TESTED = 161557;
    private static final int PARTNER_RESULT = 166936;
    private static final int HIVRECENCY_TESTDATE = 165850;
    private static final int PARTNER_TESTED_RECENCY = 166937;

    public RecencyDictionary() {
        pharmacyDictionary = new PharmacyDictionary();
        loadDictionary();
        loadBooleanDictionary();
        loadYNCodeTypeDictionary();
    }

    private Map<Integer, String> recencyDictionary = new HashMap<>();

    private Map<Integer, String> recencyDictionary2 = new HashMap<>();
    private Map<Integer, Boolean> recencyBooleanDictionary = new HashMap<>();
    private Map<Integer, YNCodeType> recencyYNCodeTypeDict = new HashMap<>();

    private void loadDictionary() {
        //recency
        //recency interpretation
        recencyDictionary.put(165852, "Recent");
        recencyDictionary2.put(165852, "Recent");
        recencyDictionary2.put(165851, "Longterm");
        recencyDictionary.put(165851, "LongTerm");
        recencyDictionary.put(664, "Negative");
        recencyDictionary.put(163611, "Invalid");

        //new final recency result
        recencyDictionary.put(166236, "RitaRecent");
        recencyDictionary.put(166235, "RitaLongterm");
        recencyDictionary.put(166237, "RitaInconclusive");

        recencyDictionary.put(166215, "AS");
        recencyDictionary.put(166246, "OTH");


        recencyDictionary.put(1000, "Plasma");
        recencyDictionary.put(165568, "DBS");

        recencyDictionary.put(166238, "less_than_1000");
        recencyDictionary.put(166239, "greater_than_1000");
        recencyDictionary.put(166240, "Failed");

        recencyDictionary.put(165184, "Male");
        recencyDictionary.put(165185, "Female");

        recencyDictionary.put(1065, "Yes");
        recencyDictionary.put(1066, "No");
        recencyDictionary.put(1067, "DontKnow");
        recencyDictionary.put(1175, "NA");

        recencyDictionary.put(703, "Positive");
        recencyDictionary.put(166935, "Indeterminate");

        //Partner Relationship with index
        recencyDictionary.put(166923, "WifeHusbandFiance");
        recencyDictionary.put(5618, "Friend");
        recencyDictionary.put(166924, "CoResident");
        recencyDictionary.put(166925, "OccationalPartner");
        recencyDictionary.put(166926, "SexualRelationsPayer");
        recencyDictionary.put(166927, "SexualRelationsPayee");
        recencyDictionary.put(166928, "InjectDrug");
        recencyDictionary.put(166929, "UnknownPartner");
        recencyDictionary.put(5256, "Others");

        recencyDictionary.put(166947, "PostiveDiagnosis");
        recencyDictionary.put(166948, "Refused");
        recencyDictionary.put(166949, "NotLocated");
        recencyDictionary.put(166950, "OutsideState");
        recencyDictionary.put(159, "Deceased");

        recencyDictionary.put(166910, "KP");
        recencyDictionary.put(166911, "PP");
        recencyDictionary.put(166912, "GP");

        recencyDictionary.put(160579, "SexWorkers");
        recencyDictionary.put(160578, "MSM");
        recencyDictionary.put(166286, "PWID");
        recencyDictionary.put(166287, "Transgender");

        recencyDictionary.put(166881, "AdolescentGirls");
        recencyDictionary.put(162198, "LDTD");
        recencyDictionary.put(166880, "Prisons");
        recencyDictionary.put(166887, "PregnantWomen");



        //PCR Lab
        recencyDictionary.put(166217, "LIMS190001");
        recencyDictionary.put(166218, "LIMS040001");
        recencyDictionary.put(166219, "LIMS330001");
        recencyDictionary.put(166220, "LIMS150001");
        recencyDictionary.put(166221, "LIMS070001");
        recencyDictionary.put(166222, "LIMS160001");
        recencyDictionary.put(166223, "LIMS320001");
        recencyDictionary.put(166224, "LIMS250001");
        recencyDictionary.put(166225, "LIMS150002");
        recencyDictionary.put(166226, "LIMS250002");
        recencyDictionary.put(166227, "LIMS040002");
        recencyDictionary.put(166228, "LIMS300001");
        recencyDictionary.put(166229, "LIMS080001");
        recencyDictionary.put(166230, "LIMS030001");
        recencyDictionary.put(166231, "LIMS340001");
        recencyDictionary.put(166232, "LIMS350001");
        recencyDictionary.put(166234, "LIMS250003");
    }

    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        recencyBooleanDictionary.put(1065, true);
        recencyBooleanDictionary.put(1066, false);
    }

    private void loadYNCodeTypeDictionary() {
        recencyYNCodeTypeDict.put(1065, YNCodeType.YES);
        recencyYNCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;
        if (recencyYNCodeTypeDict.containsKey(key)) {
            response = recencyYNCodeTypeDict.get(key);
        }
        return response;
    }

    public RecencyType createrecencyTags(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept, RecencyType recencyType) throws DatatypeConfigurationException {

        Obs obs;
        //for recency Code
        PatientIdentifier recencyId = patient.getPatientIdentifier(Utils.RECENCY_INDENTIFIER_INDEX);
        XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());

        if(enc.getVisit() != null){
            recencyType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
        }else{
            recencyType.setVisitID(enc.getEncounterId().toString());
        }

        recencyType.setVisitDate(convertedDate);

        //test name
        obs = extractObs(HIV_RECENCY_TEST_NAME_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setTestName(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        //test date
        obs = extractObs(HIV_RECENCY_TEST_DATE_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            recencyType.setTestDate(utils.getXmlDate(obs.getValueDate()));
        }
        //recency number
        if (recencyId != null) {
            recencyType.setRecencyNumber(recencyId.getIdentifier());
        }
        //control line
        obs = extractObs(CONTROL_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setControlLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        //verification line
        obs = extractObs(VERIFICATION_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setVerificationLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        //long term line
        obs = extractObs(LONG_TERM_LINE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setLongTermLine(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        //recency interpretation
        obs = extractObs(RECENCY_INTERPRETATION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setRecencyInterpretation(getMappedValue2(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(VIRALLOAD_REQUEST_MADE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setViralLoadRequest(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        //date collected
        obs = extractObs(VIRAL_LOAD_SAMPLE_COLLECTION_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyType.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        //sample ID
        obs = extractObs(SAMPLE_ID, groupedObsByConcept);
        if (obs != null && obs.getValueText() != null) {
            recencyType.setPCRLabNumber(obs.getValueText());
        }
        //sample type
        obs = extractObs(SAMPLE_TYPE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setSampleType(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        //date sample sent to PCR Lab
        obs = extractObs(VIRAL_LOAD_SAMPLE_SENT_DATE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyType.setDateSampleSent(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }

        obs = extractObs(166423, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyType.setDateConfirmedVL(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        //receiving PCR LAB
        obs = extractObs(RECEIVING_PCR_LAB, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setPCRLab(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        //VL Classification
        obs = extractObs(VIRAL_LOAD_CLASSIFICATION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setViralLoadResultClassification(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        //final HIV Result
        obs = extractObs(FINAL_HIV_RECENCY_INFECTION_TESTING_ALGORITHM_RESULT_CONCEPT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setFinalRecencyTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        //VL Result Recency
        obs = extractObs(HIV_VIRAL_LOAD,groupedObsByConcept);
        if(obs != null && obs.getValueNumeric() != null){
            recencyType.setViralLoadResult(obs.getValueNumeric());
        }

        //linked to care
        obs = extractObs(LINKED_TO_CARE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setLinkedToCare(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        //Date linked to care
        obs = extractObs(DATE_LINKED_TO_CARE, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyType.setDateLinkedToCare(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }

        obs = extractObs(ARTInitiation, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setInitiatedOnART(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        obs = extractObs(DATE_ARTInitiation, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                recencyType.setDateInitiatedOnART(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(166905,groupedObsByConcept);
        if(obs != null && obs.getValueText() != null){
            recencyType.setARTNumber(obs.getValueText());
        }
        obs = extractObs(CurrentRegimenLine, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            int valueCoded = obs.getValueCoded().getConceptId();
            Obs valueObs = extractObs(valueCoded, groupedObsByConcept); // PrescribedRegimen
            if (valueObs != null) {
                valueCoded = valueObs.getValueCoded().getConceptId();
                String ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                if(ndrCode != null) {
                    recencyType.setRegimen(pharmacyDictionary.getRegimenCodeDescTextMapValue(valueCoded));
                }
            }
        }
        obs = extractObs(clientAttendEAC, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setAdherenceCounselling(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(VLinPast12Months, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setRecordedVL12Month(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(HIV_VIRAL_LOAD,groupedObsByConcept);
        if(obs != null && obs.getValueNumeric() != null){
            recencyType.setVLResult(obs.getValueNumeric().toString());
        }
        obs = extractObs(VLS_ACHIEVED_6MTHS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setVlsSixMonth(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        try {
            obs = extractObs(KP_PP, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                String ndrCode1 = getMapped_Value(obs.getValueCoded().getConceptId());
                if (ndrCode1 != null) {
                    recencyType.setPopulationType(ndrCode1);
                }
                for (int obsCode : new int[]{166914, 166915}) {
                    Obs valueObs = extractObs(obsCode, groupedObsByConcept);
                    if (valueObs != null && valueObs.getValueCoded() != null) {
                        String ndrCode = getMapped_Value(valueObs.getValueCoded().getConceptId());
                        if (ndrCode != null) {
                            recencyType.setSubPopulationType(ndrCode);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        obs = extractObs(OFFERED_INDEX_TESTING, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setOfferedIndexTesting(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(PROVIDE_CONTACTS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            recencyType.setProvidedContacts(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
        }

        return recencyType;
    }

    public List<PartnerInformationType> createIndexNotificationServicesTypes(Map<Object, List<Obs>> groupedObsByConcept) {
        List<PartnerInformationType> partnerNotificationTypes = new ArrayList<>();
        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(PARTNER_INFORMATION_CONCEPT);
            allIndexGroupObs.forEach(gObs -> {
                PartnerInformationType partnerNotificationType = new PartnerInformationType();
                List<Obs> allMembersValue = new ArrayList(gObs.getGroupMembers());
                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);

                //partner gender
                Obs obs = extractObs(PARTNER_GENDER_CONCEPT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerGender(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PARTNER_AGE, allMembers);
                if (obs != null && obs.getValueNumeric() != null) {
                    int value_numeric = (int) Math.round(obs.getValueNumeric());
                    String age = Integer.toString(value_numeric);
                    partnerNotificationType.setPartnerAge(age);
                }
                obs = extractObs(CONTACT_PROVIDED, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setContactInformationProvided(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166931, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setRelationshipWithIndex(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(GIVEN_KIT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setSelfTestingKit(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HIV_RETESTING, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setHivVerificationTesting(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PARTNER_HIV_TESTED, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerTested(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(HIVRECENCY_TESTDATE, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setPartnerTestedDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(PARTNER_RESULT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(PARTNER_TESTED_RECENCY, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerTestedForRecency(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(RECENCY_NUMBER, allMembers);
                if (obs != null && obs.getValueText() != null) {
                    partnerNotificationType.setPartnerRecencyID(obs.getValueText());
                }
                obs = extractObs(HIVRECENCY_TESTDATE, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setPartnerRecencyTestDate(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(RECENCY_INTERPRETATION, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerRecencyResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(LINKED_TO_CARE, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerLinkedToCare(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                //Date linked to care
                obs = extractObs(DATE_LINKED_TO_CARE, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setDatePartnerLinkedToCare(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(ARTInitiation, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerInitiatedOnART(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(DATE_ARTInitiation, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setDatePartnerInitiatedOnART(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }

                obs = extractObs(166942, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerReferredPrEP(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(166943, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerInitiatePrEP(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(166944, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerScheduledRepeatHIVtest(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166945, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setReturnedForRepeatHIV(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(166946, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setDatePartnerRepeatHivTest(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166951, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setReasonPartnerNotTested(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166959, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setPartnerOnART(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(CurrentRegimenLine, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    Obs valueObs = Utils.extractObs(valueCoded, allMembers); // PrescribedRegimen
                    if (valueObs != null) {
                        valueCoded = valueObs.getValueCoded().getConceptId();
                        String ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                        if(ndrCode != null) {
                            partnerNotificationType.setCurrentARTRegimen(pharmacyDictionary.getRegimenCodeDescTextMapValue(valueCoded));
                        }
                    }
                }
                obs = extractObs(166957, allMembers);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        partnerNotificationType.setDateOfLatestVL(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
                obs = extractObs(166956,allMembers);
                if(obs != null && obs.getValueNumeric() != null){
                    partnerNotificationType.setLatestVLResult(obs.getValueNumeric());
                }
                obs = extractObs(166955, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setVLS6Months(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166954, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setEnhancedAdherenceCounselling(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166953, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    partnerNotificationType.setSwitchEvaluatedARTRegimen(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                partnerNotificationTypes.add(partnerNotificationType);
            });
        } catch (Exception ex) {
            LoggerUtils.write(RecencyDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return partnerNotificationTypes.isEmpty() ? null :  partnerNotificationTypes;
    }

    private String getMappedValue(int conceptID) {
        try {
            return recencyDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue2(int conceptID) {
        try {
            return recencyDictionary2.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMapped_Value(int value_coded) {
        if (recencyDictionary.containsKey(value_coded)) {
            return recencyDictionary.get(value_coded);
        }
        return null;
    }
}
