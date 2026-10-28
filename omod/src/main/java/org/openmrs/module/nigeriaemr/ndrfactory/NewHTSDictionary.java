package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.ClinicalTB.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.Demographics.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.HIVResult.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.HivKnowledge.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.IndexContactTesting.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.PostTestCounselling.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.PregnantStatus.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.RiskAssessment.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.SexPartnerRisk.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.STIs.*;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.RecencySyp.RECENCY_RESULT;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.RecencySyp.SYPHILIS;
import static org.openmrs.module.nigeriaemr.ndrfactory.concepts.HTSConcepts.Sessions.*;


public class NewHTSDictionary {

    Utils utils = new Utils();

    public NewHTSDictionary() {
        loadDictionary();
        loadBooleanDictionary();
        loadYNCodeTypeDictionary();
    }

    private final Map<Integer, String> htsDictionary = new HashMap<>();
    private final Map<Integer, Boolean> htsBooleanDictionary = new HashMap<>();
    private final Map<Integer, YNCodeType> htsYNCodeTypeDict = new HashMap<>();
    private final Map<Integer, String> settingsMap = new HashMap<>();
    private final Map<Integer, String> ictMap = new HashMap<>();

    private void loadDictionary() {
        //setting: F=Facility, C=Community
        settingsMap.put(166509, "F");
        settingsMap.put(163488, "C");
        settingsMap.put(160539, "F"); //CT
        settingsMap.put(160529, "F"); //TB
        settingsMap.put(160548, "C");
        settingsMap.put(5271, "F"); //FP
        settingsMap.put(160542, "F"); //OPD
        settingsMap.put(161629, "F"); //Ward
        settingsMap.put(165788, "F"); //Bloodbank
        settingsMap.put(165838, "F"); //StandaloneHTS
        settingsMap.put(5622, "C"); //Others
        settingsMap.put(160545, "C"); //Outreach
        settingsMap.put(160546,"F"); //STI

        //modality: C=CT, I=In-patient, O=Outpatient, S=Others
        htsDictionary.put(160539, "C");
        htsDictionary.put(1896, "I");
        htsDictionary.put(160542, "O");
        htsDictionary.put(5622, "S");
        htsDictionary.put(160546, "O");
        htsDictionary.put(1882, "O");
        htsDictionary.put(166020, "O");
        htsDictionary.put(5964, "O");
        htsDictionary.put(167159, "O");
        htsDictionary.put(167155, "O");
        htsDictionary.put(167158, "O");
        htsDictionary.put(167161, "O");
        htsDictionary.put(68, "O");
        htsDictionary.put(167160, "O");
        htsDictionary.put(163488, "O");



        //marital status
        htsDictionary.put(1057, "S"); //Single
        htsDictionary.put(5555, "M"); //Married
        htsDictionary.put(1058, "D"); //Divorced
        htsDictionary.put(1056, "A"); //Separated
        htsDictionary.put(1060, "G"); //Living with partner
        htsDictionary.put(1059, "W"); //Widowed

        //session type: 1=Individual, 2=Couple, 3=Index Contact Testing, 4=Previously Self tested
        htsDictionary.put(165792, "1");
        htsDictionary.put(165789, "2");
        htsDictionary.put(167350, "3");
        htsDictionary.put(165885, "4");

        //HIVST result: NR=Non-Reactive, R=Reactive
        htsDictionary.put(1229, "NR");
        htsDictionary.put(1228, "R");

        //Relationship to Index:
        // M=Mother, F=Father, C=Biological Child, S=Spouse, L=Live-in Partner, B=Boyfriend/Girlfriend,
        // P=Casual Partner, N=Social Network
        htsDictionary.put(970, "M");
        htsDictionary.put(971, "F");
        htsDictionary.put(167355, "C");
        htsDictionary.put(5617, "S");
        htsDictionary.put(167353, "L");
        htsDictionary.put(163567, "B");
        htsDictionary.put(167349, "P");
        htsDictionary.put(167348, "N");

        //Duration of Breastfeeding: LT6 = Less than 6 months, GTE6 = 6 months or more
        htsDictionary.put(167347, "LT6");
        htsDictionary.put(167344, "GTE6");

        //Syphilis test result: NR=Non-Reactive, R=Reactive
        htsDictionary.put(165894, "NR");
        htsDictionary.put(165895, "R");

        //Recency testing result: R=Recent, L=Long-term
        htsDictionary.put(165852, "R");
        htsDictionary.put(165851, "L");

        //TestedForHIVBeforeWithinThisYear
        //1=Not previously tested, 2=Previously tested negative, 3=Previously tested positive in HIV Care,
        // 4=Previously tested positive not in HIV Care
        htsDictionary.put(165815, "1");
        htsDictionary.put(165816, "2");
        htsDictionary.put(165817, "3");
        htsDictionary.put(165882, "4");


        //ICT Form
        //Category of Client ND=Newly Diagnosed, VU=Virally Unsuppressed, RTT=Returned to Treatment after IIT, OT=Others
        ictMap.put(1687, "ND");
        ictMap.put(167682, "VU");
        ictMap.put(167681, "RTT");
        ictMap.put(5622, "OT");


        //Relationship to Index:
        // 1=Mother, 2=Father, 3=Biological Child, 4=Spouse, 5=Live-in Partner,
        // 6=Boyfriend/Girlfriend, 7=Casual Partner, 8=Social Network
        // Remap these
        ictMap.put(970, "1");
        ictMap.put(971, "2");
        ictMap.put(1528, "3");
        ictMap.put(165040, "4");
        ictMap.put(167353, "5");
        ictMap.put(163567, "6");
        ictMap.put(163565, "7");
        ictMap.put(167348, "8");

        //gender
        htsDictionary.put(165184, "M");
        htsDictionary.put(165185, "F");


        // Notification method A=Passive/Client Referral, B=Provider Assisted, C=Contract,
        // D=Dual Referral, E=No notification needed/Known HIV positive,
        // F=Notification not recommended for safety of Index Client
        htsDictionary.put(167673, "A");
        htsDictionary.put(167672, "B");
        htsDictionary.put(167671, "C");
        htsDictionary.put(167670, "D");
        htsDictionary.put(167669, "E");
        htsDictionary.put(167667, "F");


        //FollowUpAppointmentLocation FAC=Facility, WRK=Workplace, HOM=Home, OTH=Others
        ictMap.put(166509, "FAC");
        ictMap.put(164406, "WRK");
        ictMap.put(1536, "HOM");
        ictMap.put(5622, "OTH");


    }

    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        htsBooleanDictionary.put(1065, true);
        htsBooleanDictionary.put(1066, false);
        htsBooleanDictionary.put(1, true);
        htsBooleanDictionary.put(2, false);

    }

    private void loadYNCodeTypeDictionary() {
        htsYNCodeTypeDict.put(1065, YNCodeType.YES);
        htsYNCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;

        if (htsYNCodeTypeDict.containsKey(key)) {
            response = htsYNCodeTypeDict.get(key);
        }

        return response;
    }

    private boolean getBooleanMappedValue(int key) {
        if (htsBooleanDictionary.containsKey(key)) {
            Boolean value = htsBooleanDictionary.get(key);
            return value != null ? value : false;
        }
        return false;
    }

    private String mapNrR(int conceptId) {
        if (conceptId == 703) {
            return "R";
        }
        if (conceptId == 664) {
            return "NR";
        }
        return null;
    }

    //NDR 1.7.2.0 enum mapper for FinalTestResult: Pos/Neg.
    private String mapPosNeg(int conceptId) {
        if (conceptId == 703) {
            return "Pos";
        }
        if (conceptId == 664) {
            return "Neg";
        }
        return null;
    }

    private String mapL6GT6 (int conceptId){
        if (conceptId == 167344) {
            return "GT6M";
        }
        if (conceptId == 167345) {
            return "LT3M";
        }
        return null;
    }

    private String ageGroup (int conceptId){
        if (conceptId == 167576) {
            return "LT15";
        }
        if (conceptId == 167575) {
            return "GTE15";
        }
        return null;
    }

    //PostCounselling
    //Category of Client S=Self, P=Partner, CG=Caregiver, SN=Social Network
    private String categoryOfClient (int conceptId){
        if (conceptId == 978) {
            return "S";
        }
        if (conceptId == 165041) {
            return "P";
        }
        if (conceptId == 167549) {
            return "CG";
        }
        if (conceptId == 167348) {
            return "SN";
        }
        return null;
    }


    private String contactAttempts (int conceptId){
        if (conceptId == 162135) {
            return "1";
        }
        if (conceptId == 165644) {
            return "2";
        }
        if (conceptId == 165645) {
            return "3";
        }
        if (conceptId == 165646) {
            return "4";
        }
        if (conceptId == 165647) {
            return "5";
        }
        if (conceptId == 165648) {
            return "6";
        }
        return null;
    }


    private String getYesNoMappedValue(int key) {
        return getBooleanMappedValue(key) ? "Yes" : "No";
    }

    private String getYNMappedValue(int key) {
        return getBooleanMappedValue(key) ? "Y" : "N";
    }

    public HIVTestingReportType createClientIntakeTags(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept, HIVTestingReportType hivTestingReport) throws DatatypeConfigurationException {

        Obs obs;

        //for client Code
        String htsID = String.valueOf(patient.getPatientIdentifier(Utils.HTS_IDENTIFIER_INDEX));
        if (htsID != null) {
            hivTestingReport.setClientCode(htsID);
        }

        //visit date and ID
        if (enc.getVisit() != null) {
            hivTestingReport.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
        } else {
            hivTestingReport.setVisitID(enc.getEncounterId().toString());
        }
        hivTestingReport.setVisitDate(utils.getXmlDate(enc.getEncounterDatetime()));

        //setting (F=Facility, C=Community)
        obs = extractObs(SETTINGS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivTestingReport.setSetting(getSettings(obs.getValueCoded().getConceptId()));
        }

        //modality: C=CT, I=In-patient, O=Outpatient, S=Others
        obs = extractObs(MODALITY, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String modality = getMappedValue(obs.getValueCoded().getConceptId());
            hivTestingReport.setModality(modality);

            //if modality is Others, pull the free-text from the separate "Other, specify" concept
            if ("S".equals(modality)) {
                Obs otherObs = extractObs(OTHERS, groupedObsByConcept);
                if (otherObs != null && otherObs.getValueText() != null) {
                    hivTestingReport.setOtherModality(otherObs.getValueText());
                }
            }
        }

        //client age - derive from patient birthdate and encounter date
        if (patient.getBirthdate() != null && enc.getEncounterDatetime() != null) {
            Integer ageInYears = patient.getAge(enc.getEncounterDatetime());
            if (ageInYears != null) {
                hivTestingReport.setClientAge(ageInYears);
            }
        }

        //sex - derive from patient gender
        if (patient.getGender() != null) {
            hivTestingReport.setSex(patient.getGender().toUpperCase());
        }

        //put all non required fields inside a try-catch
        try {

            //marital status
            obs = extractObs(MARITAL_STATUS, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setMaritalStatus(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //no. of wives/co-wives
            obs = extractObs(NUMBER_OF_WIVES, groupedObsByConcept);
            if (obs != null && obs.getValueText() != null) {
                hivTestingReport.setNoOfAllWives(Integer.parseInt(obs.getValueText()));
            }

            //no. of owned children less than 15 years
            obs = extractObs(NO_OF_CHILDREN, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                hivTestingReport.setNoOfOwnChildrenLessThan15Years((int) Math.round(obs.getValueNumeric()));
            }

            // session type: 1=Individual, 2=Couple, 3=Index, 4=Previously Tested
            obs = extractObs(TYPE_OF_SESSION, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                String session = getMappedValue(obs.getValueCoded().getConceptId());
                hivTestingReport.setSessionType(session);

                // If Previously Tested, capture HIVST result (NR=Non-Reactive, R=Reactive)
                if ("4".equals(session)) {
                    Obs hivstObs = extractObs(HIVST_RESULT, groupedObsByConcept);
                    if (hivstObs != null && hivstObs.getValueCoded() != null) {
                        hivTestingReport.setHIVSTResult(getMappedValue(hivstObs.getValueCoded().getConceptId()));
                    }
                }

                if ("3".equals(session)) {
                    Obs indexObs = extractObs(INDEX_ID, groupedObsByConcept);
                    if (indexObs != null && indexObs.getValueText() != null) {
                        hivTestingReport.setIndexClientId(indexObs.getValueText());
                    }
                    Obs relationshipObs = extractObs(RELATIONSHIP_INDEX, groupedObsByConcept);
                    if (relationshipObs != null && relationshipObs.getValueCoded() != null) {
                        hivTestingReport.setRelationshipToIndex(
                                getMappedValue(relationshipObs.getValueCoded().getConceptId()));
                    }
                }
            }

            //client is pregnant (Yes/No)
            obs = extractObs(CLIENT_PREGNANT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setClientIsPregnant(getYesNoMappedValue(obs.getValueCoded().getConceptId()));
            }

            //breastfeeding (Yes/No)
            obs = extractObs(BREASTFEEDING, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                String breastfeeding = getYesNoMappedValue(obs.getValueCoded().getConceptId());
                hivTestingReport.setBreastfeeding(breastfeeding);

                //only capture duration when breastfeeding is Yes
                if ("Yes".equals(breastfeeding)) {
                    Obs durationObs = extractObs(DURATION_BREASTFEEDING, groupedObsByConcept);
                    if (durationObs != null && durationObs.getValueCoded() != null) {
                        hivTestingReport.setDurationOfBreastfeeding(
                                getMappedValue(durationObs.getValueCoded().getConceptId()));
                    }
                }
            }

            //syphilis test result (NR/R)
            obs = extractObs(SYPHILIS, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setSyphilisTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //recency testing result (R=Recent, L=Long-term)
            obs = extractObs(RECENCY_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivTestingReport.setRecencyTestingResult(getMappedValue(obs.getValueCoded().getConceptId()));
            }

            //signature - completed by
            try {
                hivTestingReport.setCompletedBy(enc.getEncounterProviders().stream().findFirst().get().getProvider().getName());
            } catch (Exception ex) {
                LoggerUtils.write(NewHTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }

            //date completed
            if (enc.getEncounterDatetime() != null) {
                hivTestingReport.setDateCompleted(utils.getXmlDate(enc.getEncounterDatetime()).toString());
            }

        } catch (Exception ex) {
            LoggerUtils.write(NewHTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return hivTestingReport;

    }

    public HIVTestResultType createHIVTestResult(Patient patient,  Map<Object, List<Obs>> groupedObsByConcept) {
        TestResultType testResult = createTestResultType(groupedObsByConcept);
        if (testResult == null) {
            return null;
        }

        HIVTestResultType hIVTestResultType = new HIVTestResultType();
        hIVTestResultType.setTestResult(testResult);
        return hIVTestResultType;
    }

    public IndexContactTestingType createIndexContactTesting(Encounter indexTestingEncounter) {
        if (indexTestingEncounter == null) {
            return null;
        }

        IndexContactTestingType indexContactTestingType = new IndexContactTestingType();

        try {

            List<Obs> partnerObs = new ArrayList<>(indexTestingEncounter.getAllObs());
            Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(partnerObs);

            //ART Clinic (Y/N)
            Obs obs = extractObs(IS_ART_CLINIC, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                indexContactTestingType.setARTClinic(getYNMappedValue(obs.getValueCoded().getConceptId()));
            }

            //Index Client ID Type (HTS/ART)
            if (obs != null && obs.getValueText() != null) {
                indexContactTestingType.setIndexClientID(obs.getValueText());
            }

            //Client Category (ND/VU/RTT/OT)
            obs = extractObs(CLIENT_CATEGORY, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                indexContactTestingType.setClientCategory(getMappedValue2(obs.getValueCoded().getConceptId()));
            }

            //Offered Index Testing Services (Yes/No)
            obs = extractObs(OFFERED_INDEX_TESTING, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                indexContactTestingType.setOfferedIndexTestingServices(getYesNoMappedValue(obs.getValueCoded().getConceptId()));
            }

            //Accepted Index Testing Services (Yes/No)
            obs = extractObs(ACCEPTED_INDEX_TESTING, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                indexContactTestingType.setAcceptedIndexTestingServices(getYesNoMappedValue(obs.getValueCoded().getConceptId()));
            }

            List<IndexContactType> indexContactTypes = createIndexContact(groupedObsByConcept);
            indexContactTestingType.getIndexContact().addAll(indexContactTypes);


        } catch (Exception ex) {
            LoggerUtils.write(NewHTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }


        return indexContactTestingType;
    }

    private List<IndexContactType> createIndexContact(Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        List<IndexContactType> indexContacts = new ArrayList<>();


        try {
            List<Obs> allIndexGroupObs = groupedObsByConcept.get(INDEX_CONTACT_GROUPING);
            if (allIndexGroupObs == null) {
                return indexContacts;
            }

            AtomicInteger serial = new AtomicInteger(0);

            allIndexGroupObs.forEach(gObs -> {

                IndexContactType indexContact = new IndexContactType();

                List<Obs> allMembersValue = new ArrayList<>(gObs.getGroupMembers());

                Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);
                //extract all the members using the concept

                indexContact.setSerialNo(String.valueOf(serial.incrementAndGet()));

                //Relationship to Index (1-8)
                Obs obs = extractObs(INDEX_RELATIONSHIP, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setRelationshipToIndex(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                //Sex (M/F)
                obs = extractObs(SEX, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setSex(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                //Age Group (LT15/GTE15)
                obs = extractObs(AGE_GROUP, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    String ageGroup = ageGroup(obs.getValueCoded().getConceptId());
                    if (ageGroup != null && !ageGroup.isEmpty()) {
                        indexContact.setAgeGroup(ageGroup);
                    }
                }

                //Notification Method (A-F)
                obs = extractObs(NOTIFICATION_METHOD, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setNotificationMethod(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                //Follow-up Appointment Location (FAC/WRK/HOM/OTH)
                obs = extractObs(FOLLOWUP_APP, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setFollowUpAppointmentLocation(getMappedValue2(obs.getValueCoded().getConceptId()));
                }

                //Contact Attempts
                obs = extractObs(CONTACT_ATTEMPT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    String attempt = contactAttempts(obs.getValueCoded().getConceptId());
                    if (attempt != null && !attempt.isEmpty()) {
                        indexContact.setContactAttempts(Integer.valueOf(attempt));
                    }
                }

                //Known HIV Positive (Yes/No)
                obs = extractObs(KNOWN_POSITIVES, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setKnownHIVPositive(getYesNoMappedValue(obs.getValueCoded().getConceptId()));
                }

                //HIV Test Result (Pos/Neg)
                obs = extractObs(HIV_RESULT, allMembers);
                if (obs != null && obs.getValueCoded() != null) {
                    indexContact.setHIVTestResult(mapPosNeg(obs.getValueCoded().getConceptId()));
                }

                //Date Tested
                obs = extractObs(HIV_RESULT_DATE, allMembers);
                if (obs != null && obs.getValueDatetime() != null) {
                    indexContact.setDateTested(utils.getXmlDate(obs.getValueDatetime()));
                }

                //Date Enrolled on ART
                obs = extractObs(DATE_ENROLL_ART, allMembers);
                if (obs != null && obs.getValueDatetime() != null) {
                    indexContact.setDateEnrolledOnART(utils.getXmlDate(obs.getValueDatetime()));
                }

                //Date Enrolled in OVC
                obs = extractObs(DATE_OVC_ENROLL, allMembers);
                if (obs != null && obs.getValueDatetime() != null) {
                    indexContact.setDateEnrolledInOVC(utils.getXmlDate(obs.getValueDatetime()));
                }

                //OVC ID
                obs = extractObs(OVC_ID, allMembers);
                if (obs != null && obs.getValueText() != null) {
                    indexContact.setOVCID(obs.getValueText());
                }


                indexContacts.add(indexContact);

            });
        } catch (Exception ex) {
            LoggerUtils.write(NewHTSDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return indexContacts;
    }

    //NDR 1.7.2.0 TestResultType: ScreeningTestResult (R/NR), SuspectedAcuteHIVInfection (Yes/No),
    //ConfirmatoryTestResult (R/NR), screening/confirmatory dates, and FinalTestResult (Pos/Neg).
    public TestResultType createTestResultType(Map<Object, List<Obs>> groupedObsByConcept) {

        TestResultType testResultType = new TestResultType();

        //screening test result (R/NR)
        Obs screeningObs = extractObs(SCREENING_TEST_RESULT, groupedObsByConcept);
        String screening = (screeningObs != null && screeningObs.getValueCoded() != null)
                ? mapNrR(screeningObs.getValueCoded().getConceptId())
                : null;
        if (screening != null) {
            testResultType.setScreeningTestResult(screening);
        }

        //screening test result date
        Obs screeningDateObs = extractObs(SCREENING_TEST_RESULT_DATE, groupedObsByConcept);
        if (screeningDateObs != null && screeningDateObs.getValueDatetime() != null) {
            testResultType.setScreeningTestResultDate(utils.getXmlDate(screeningDateObs.getValueDatetime()));
        }

        //suspected acute HIV infection (Yes/No)
        Obs suspectedObs = extractObs(SUSPECTED_ACUTE_INFECTION, groupedObsByConcept);
        if (suspectedObs != null && suspectedObs.getValueCoded() != null) {
            testResultType.setSuspectedAcuteHIVInfection(getYesNoMappedValue(suspectedObs.getValueCoded().getConceptId()));
        }

        //confirmatory test result (R/NR) - only relevant when screening is R
        if ("R".equals(screening)) {
            Obs confirmObs = extractObs(CONFIRMATORY_TEST_RESULT, groupedObsByConcept);
            if (confirmObs != null && confirmObs.getValueCoded() != null) {
                String confirmatory = mapNrR(confirmObs.getValueCoded().getConceptId());
                if (confirmatory != null) {
                    testResultType.setConfirmatoryTestResult(confirmatory);
                }
            }

            Obs confirmDateObs = extractObs(CONFIRMATORY_TEST_RESULT_date, groupedObsByConcept);
            if (confirmDateObs != null && confirmDateObs.getValueDatetime() != null) {
                testResultType.setConfirmatoryTestResultDate(utils.getXmlDate(confirmDateObs.getValueDatetime()));
            }
        }

        //final test result (Pos/Neg)
        Obs finalObs = extractObs(FINAL_RESULT, groupedObsByConcept);
        if (finalObs != null && finalObs.getValueCoded() != null) {
            String finalResult = mapPosNeg(finalObs.getValueCoded().getConceptId());
            if (finalResult != null) {
                testResultType.setFinalTestResult(finalResult);
            }
        }

        if (testResultType.getScreeningTestResult() == null
                && testResultType.getSuspectedAcuteHIVInfection() == null
                && testResultType.getConfirmatoryTestResult() == null
                && testResultType.getFinalTestResult() == null) {
            return null;
        }

        return testResultType;
    }

    //NDR 1.7.2.0 enum mapper for ScreeningTestResult / ConfirmatoryTestResult: NR=Negative, R=Positive.

    public KnowledgeAssessmentType createKnowledgeAssessmentType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        if (htsIdentifier == null) {
            return null;
        }

        KnowledgeAssessmentType knowledgeAssessmentType = new KnowledgeAssessmentType();

        //previously tested HIV negative (boolean)
        Obs obs = extractObs(PREVIOUSLY_TESTED_HIV_NEG, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setPreviouslyTestedHIVNegative(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //time of last HIV negative test (LT3M/GT6M) - only set when the coded answer maps to a known value
        obs = extractObs(TIME_OF_LAST_HIV_NEG, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String timeOfLastNegative = mapL6GT6(obs.getValueCoded().getConceptId());
            if (timeOfLastNegative != null && !timeOfLastNegative.isEmpty()) {
                knowledgeAssessmentType.setTimeOfLastHIVNegativeTest(timeOfLastNegative);
            }
        }

        //client informed about HIV transmission routes
        obs = extractObs(CLIENT_INFORMED_ABOUT_TRANSMISSION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setClientInformedAboutHIVTransmissionRoutes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client pregnant (Yes/No)
        obs = extractObs(CLIENT_PREGNANT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setClientPregnant(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client informed about HIV transmission risk factors
        obs = extractObs(CLIENT_INFORMED_ABOUT_RISK_FACTORS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setClientInformedOfHIVTransmissionRiskFactors(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client informed about preventing HIV
        obs = extractObs(CLIENT_INFORMED_ON_PREVENTION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setClientInformedAboutPreventingHIV(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client informed about possible test results
        obs = extractObs(CLIENT_INFORMED_ABOUT_POSSIBLE_TEST, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setClientInformedAboutPossibleTestResults(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //informed consent for HIV testing given
        obs = extractObs(INFORM_CONSENT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            knowledgeAssessmentType.setInformedConsentForHIVTestingGiven(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (knowledgeAssessmentType.isPreviouslyTestedHIVNegative() == null
                && knowledgeAssessmentType.getTimeOfLastHIVNegativeTest() == null
                && knowledgeAssessmentType.isClientInformedAboutHIVTransmissionRoutes() == null
                && knowledgeAssessmentType.isClientPregnant() == null
                && knowledgeAssessmentType.isClientInformedOfHIVTransmissionRiskFactors() == null
                && knowledgeAssessmentType.isClientInformedAboutPreventingHIV() == null
                && knowledgeAssessmentType.isClientInformedAboutPossibleTestResults() == null
                && knowledgeAssessmentType.isInformedConsentForHIVTestingGiven() == null) {
            return null;
        }

        return knowledgeAssessmentType;
    }

    public HIVRiskAssessmentType createHivRiskAssessment(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        boolean isFemale = "F".equalsIgnoreCase(pts.getGender());
        if (htsIdentifier == null) {
            return null;
        }

        HIVRiskAssessmentType hivRiskAssessmentType = new HIVRiskAssessmentType();

        //ever had sexual intercourse
        Obs obs = extractObs(EVER_HAD_SEXUAL_INTERCOURSE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setEverHadSexualIntercourse(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //more than 1 sex partner during last 3 months
        obs = extractObs(MORE_THAN_ONE_SEX_PARTNER, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setMoreThan1SexPartnerDuringLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //unprotected vaginal sex
        if (!isFemale) {
            obs = extractObs(UNPROTECTED_VAGINAL_SEX, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                hivRiskAssessmentType.setUnprotectedVaginalSex(
                        getBooleanMappedValue(obs.getValueCoded().getConceptId())
                );
            }
        }

        //unprotected sex with casual partner in last 3 months
        obs = extractObs(UNPROTECTED_SEX_WITH_CASUAL_PARTNER_IN_LAST_3_MONTHS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setUnprotectedSexWithCasualPartnerinLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //unprotected sex with regular partner in last 3 months
        obs = extractObs(UNPROTECTED_SEX_WITH_REGULAR_PARTNER_IN_LAST_3_MONTHS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setUnprotectedSexWithRegularPartnerInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //blood transfusion in last 3 months
        obs = extractObs(BLOOD_TRANSFUSION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setBloodTransfussionInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //sex under influence of drugs or alcohol
        obs = extractObs(SEX_UNDER_INFLUENCE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setSexUnderInfluenceOfDrugsOrAlcohol(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //STI in last 3 months
        obs = extractObs(STI_IN_LAST_3_MONTHS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            hivRiskAssessmentType.setSTIInLast3Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (hivRiskAssessmentType.isEverHadSexualIntercourse() == null
                && hivRiskAssessmentType.isMoreThan1SexPartnerDuringLast3Months() == null
                && hivRiskAssessmentType.isUnprotectedVaginalSex() == null
                && hivRiskAssessmentType.isUnprotectedSexWithCasualPartnerinLast3Months() == null
                && hivRiskAssessmentType.isUnprotectedSexWithRegularPartnerInLast3Months() == null
                && hivRiskAssessmentType.isBloodTransfussionInLast3Months() == null
                && hivRiskAssessmentType.isSexUnderInfluenceOfDrugsOrAlcohol() == null
                && hivRiskAssessmentType.isSTIInLast3Months() == null) {
            return null;
        }

        return hivRiskAssessmentType;
    }

    public SyndromicSTIScreeningType createSyndromicsStiType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        if (htsIdentifier == null) {
            return null;
        }

        SyndromicSTIScreeningType syndromicSTIScreeningType = new SyndromicSTIScreeningType();

        //vaginal discharge or burning when urinating (female)
        Obs obs = extractObs(COMPLAINTS_OF_VAGINAL_DISCHARGE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setVaginalDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //lower abdominal pains with or without vaginal discharge (female)
        obs = extractObs(COMPLAINTS_OF_LOWER_ABDOMINAL_PAINS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setLowerAbdominalPainsWithOrWithoutVaginalDischarge(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //urethral discharge or burning when urinating (male)
        obs = extractObs(COMPLAINTS_OF_URETHRAL_DISCHARGE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setUrethralDischargeOrBurningWhenUrinating(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //scrotal swelling and pain (male)
        obs = extractObs(COMPLAINTS_OF_SCROTAL_PAIN, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setScrotalSwellingAndPain(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //genital sore (both sexes)
        obs = extractObs(COMPLAINTS_OF_GENITAL_SORE, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setGenitalSore(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //genital sore or swollen inguinal lymph nodes (both sexes)
        obs = extractObs(COMPLAINTS_OF_SWOLLEN_LYMPH, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            syndromicSTIScreeningType.setGenitalSoreOrSwollenInguinalLymphNodes(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (syndromicSTIScreeningType.isVaginalDischargeOrBurningWhenUrinating() == null
                && syndromicSTIScreeningType.isLowerAbdominalPainsWithOrWithoutVaginalDischarge() == null
                && syndromicSTIScreeningType.isUrethralDischargeOrBurningWhenUrinating() == null
                && syndromicSTIScreeningType.isScrotalSwellingAndPain() == null
                && syndromicSTIScreeningType.isGenitalSore() == null
                && syndromicSTIScreeningType.isGenitalSoreOrSwollenInguinalLymphNodes() == null) {
            return null;
        }

        return syndromicSTIScreeningType;
    }

    public SexPartnerRiskAssessmentType createSexPartnerRiskAssessment(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        if (htsIdentifier == null) {
            return null;
        }

        SexPartnerRiskAssessmentType sexPartnerRiskAssessmentType = new SexPartnerRiskAssessmentType();

        //partner newly diagnosed on ART less than 3 to 6 months
        Obs obs = extractObs(PARTNER_NEWY_DIAGNOSED, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            sexPartnerRiskAssessmentType.setPartnerNewlyDiagnosedOnARTLessThan3To6Months(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //partner pregnant receiving ARV for PMTCT
        obs = extractObs(PREGNANT_ON_ARV, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            sexPartnerRiskAssessmentType.setPartnerPregnantReceivingARVForPMTCT(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //partner adolescent 10 to 19 known HIV infected
        obs = extractObs(ADOLESCENT_10_19, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            sexPartnerRiskAssessmentType.setPartnerAdolescent10To19KnownHIVInfected(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //partner known positive not regularly on drugs
        obs = extractObs(NOT_REGULARLY_TAKING_MEDS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            sexPartnerRiskAssessmentType.setPartnerKnownPositiveNotRegularlyOnDrugs(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //partner known positive recently returned after LTFU
        obs = extractObs(RETURNED_AFTER_LTFU, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            sexPartnerRiskAssessmentType.setPartnerKnownPositiveRecentlyReturnedAfterLTFU(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (sexPartnerRiskAssessmentType.isPartnerNewlyDiagnosedOnARTLessThan3To6Months() == null
                && sexPartnerRiskAssessmentType.isPartnerPregnantReceivingARVForPMTCT() == null
                && sexPartnerRiskAssessmentType.isPartnerAdolescent10To19KnownHIVInfected() == null
                && sexPartnerRiskAssessmentType.isPartnerKnownPositiveNotRegularlyOnDrugs() == null
                && sexPartnerRiskAssessmentType.isPartnerKnownPositiveRecentlyReturnedAfterLTFU() == null) {
            return null;
        }

        return sexPartnerRiskAssessmentType;
    }


    public PostTestCounsellingType createPostTestCouncellingType(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);
        if (htsIdentifier == null) {
            return null;
        }

        PostTestCounsellingType postTestCounsellingType = new PostTestCounsellingType();

        //tested for HIV before within this year (coded 1-4)
        Obs obs = extractObs(TESTED_WITHIN_THE_YEAR, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String testedBefore = getMappedValue(obs.getValueCoded().getConceptId());
            if (testedBefore != null && !testedBefore.isEmpty()) {
                postTestCounsellingType.setTestedForHIVBeforeWithinThisYear(testedBefore);
            }
        }

        //accepted index testing
        obs = extractObs(ACCEPTED_INDEX_TESTING, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setAcceptedIndexTesting(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //provided with information on FP and dual contraception
        obs = extractObs(INFO_ON_FP_DUAL_CONTRACEPTION, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setProvidedWithInformationOnFPandDualContraception(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client or partner use FP methods other than condoms
        obs = extractObs(FP_METHODS, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setClientOrPartnerUseFPMethodsOtherThanCondoms(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client or partner use condoms as one FP method
        obs = extractObs(CONDOM_AS_FP_METHOD, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setClientOrPartnerUseCondomsAsOneFPMethods(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //client received HIV test result
        obs = extractObs(CLIENT_RECEIVED_RESULT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setClientRecievedHIVTestResult(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //correct condom use demonstrated
        obs = extractObs(CONDOM_USE_DEMO, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setCorrectCondomUseDemonstrated(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //HIV self-test kits provided
        obs = extractObs(HIVST_PROVIDED, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setHIVSelfTestKitsProvided(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //HIV self-test kits count
        obs = extractObs(NUMBER_OF_KIT, groupedObsByConcept);
        if (obs != null && obs.getValueNumeric() != null) {
            postTestCounsellingType.setHIVSelfTestKitsCount(obs.getValueNumeric().intValue());
        }

        //condoms provided to client
        obs = extractObs(CONDOMS_PROVIDED_TO_CLIENT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setCondomsProvidedToClient(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        //category of client (S/P/CG/SN) - only set when the coded answer maps to a known value
        obs = extractObs(CLIENTS_RECEIVING_KIT, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            String category = categoryOfClient(obs.getValueCoded().getConceptId());
            if (category != null && !category.isEmpty()) {
                postTestCounsellingType.setCategoryOfClient(category);
            }
        }


        //client referred to other services
        obs = extractObs(REFERRED_TO_OTHER_SERVICES, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            postTestCounsellingType.setClientReferredToOtherServices(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }

        if (postTestCounsellingType.getTestedForHIVBeforeWithinThisYear() == null
                && postTestCounsellingType.isAcceptedIndexTesting() == null
                && postTestCounsellingType.isProvidedWithInformationOnFPandDualContraception() == null
                && postTestCounsellingType.isClientOrPartnerUseFPMethodsOtherThanCondoms() == null
                && postTestCounsellingType.isClientOrPartnerUseCondomsAsOneFPMethods() == null
                && postTestCounsellingType.isClientRecievedHIVTestResult() == null
                && postTestCounsellingType.isCorrectCondomUseDemonstrated() == null
                && postTestCounsellingType.isHIVSelfTestKitsProvided() == null
                && postTestCounsellingType.getHIVSelfTestKitsCount() == null
                && postTestCounsellingType.isCondomsProvidedToClient() == null
                && postTestCounsellingType.getCategoryOfClient() == null
                && postTestCounsellingType.isClientReferredToOtherServices() == null) {
            return null;
        }

        return postTestCounsellingType;
    }

    public ClinicalTBScreeningType createClinicalTbScreening(Patient pts, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        PatientIdentifier htsIdentifier = pts.getPatientIdentifier(ConstantsUtil.HTS_IDENTIFIER_INDEX);

        if (htsIdentifier == null) {
            return null;
        }

        ClinicalTBScreeningType clinicalTBScreeningType = new ClinicalTBScreeningType();

        Obs obs = extractObs(CURRENT_COUGH, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setCurrentlyCough(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(WEIGHT_LOSS, groupedObsByConcept);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setWeightLoss(obs.getValueAsBoolean());
        }
        obs = extractObs(FEVER, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            clinicalTBScreeningType.setFever(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(NIGHT_SWEATS, groupedObsByConcept);
        if (obs != null && obs.getValueAsBoolean() != null) {
            clinicalTBScreeningType.setNightSweats(obs.getValueAsBoolean());
        }

        return clinicalTBScreeningType;
    }


    private String getMappedValue(int conceptID) {
        try {
            return htsDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getSettings(int conceptID) {
        try {
            return settingsMap.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue2(int conceptID) {
        try {
            return ictMap.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

}
