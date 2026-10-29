/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.*;
import java.util.stream.Collectors;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;

import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class MortalityDictionary {

    Utils utils = new Utils();

    public MortalityDictionary() {
        loadDictionary();
        loadYNCodeTypeDictionary();
    }

    private Map<Integer, String> mortalityDictionary = new HashMap<>();

    private Map<Integer, String> mortalityDictionary2 = new HashMap<>();

    private Map<Integer, String> mortalityDictionary3 = new HashMap<>();
    private Map<Integer, Boolean> yesNoToggle = new HashMap<>();
    private Map<Integer, Boolean> mortalityBooleanDictionary = new HashMap<>();
    private Map<Integer, YNCodeType> mortalityYNCodeTypeDict = new HashMap<>();

    private void loadDictionary() {
        mortalityDictionary.put(165789,"CoupTest");
        mortalityDictionary.put(165462,"MissAppDate");
        mortalityDictionary.put(165473,"MissPharmDate");
        mortalityDictionary.put(159492,"TransferredOut");
        mortalityDictionary.put(5622,"Others");
        mortalityDictionary2.put(5622,"OthersSpecify");
        mortalityDictionary.put(165889,"Death");
        mortalityDictionary.put(165916,"Discontinued");
        mortalityDictionary.put(165791,"MobilePhone");
        mortalityDictionary.put(1650,"HomeVisit");
        mortalityDictionary2.put(165031,"Sick");
        mortalityDictionary2.put(1737,"LackofTransport");
        mortalityDictionary2.put(162192,"PatientForgottoAttendApp");
        mortalityDictionary2.put(160586,"FeltBetandStopedMed");
        mortalityDictionary2.put(165896,"NotPermtoLeaveWork");
        mortalityDictionary2.put(165897,"LostAppCard");
        mortalityDictionary2.put(165898,"StillHadDrugs");
        mortalityDictionary2.put(5841,"HerbalTradMeds");

        mortalityDictionary.put(161642,"TreatmentSupporter");
        mortalityDictionary.put(162571,"Patient");
        mortalityDictionary.put(160639,"Guardian");

        mortalityDictionary3.put(165891,"ForcedDiscontinuation");
        mortalityDictionary3.put(165892,"MovedOutofArea");
        mortalityDictionary3.put(5622,"Other");
        mortalityDictionary3.put(5488,"AdherenceCounseling");
        mortalityDictionary3.put(165890,"SelfDiscontinuation");
        mortalityDictionary.put(167230,"DuplicateRecord");
        mortalityDictionary.put(167231,"CouldNotVerifyClient");
        mortalityDictionary.put(5240,"LTFU");
       /* mortalityDictionary.put(0,"SelfTransfer");
        mortalityDictionary.put(0,"TreatmentStop");*/

        mortalityDictionary.put(1065, "YES");
        mortalityDictionary.put(1066, "NO");

        //Map OpenMRS concepts to corresponding NDR values
        mortalityDictionary.put(166348,"VAAdultCasesofDeath");
        mortalityDictionary.put(166347,"VAChildCasesofDeath");
        mortalityDictionary.put(5488,"AdherenceCounseling");

        mortalityDictionary.put(165888,"OtherCauseofDeath");
        mortalityDictionary.put(165886,"SuspectedARVSideEffect");
        mortalityDictionary.put(165887,"SuspectedOpportunisticInfection");
        mortalityDictionary.put(1067,"Unknown");

        //Client Indication for verification
        mortalityDictionary.put(167243,"VerificationOngoing");
        mortalityDictionary.put(167244,"RecordDiscontinued");
        mortalityDictionary.put(167245,"RecordVerified");
        /*mortalityDictionary.put(0,"Pending");*/
        mortalityDictionary.put(167246,"Valid");
        mortalityDictionary.put(163611,"Invalid");

        //Causes of Death
        mortalityDictionary.put(166304,"AIDS");
        mortalityDictionary.put(166305,"DiarrheaDysentery");
        mortalityDictionary.put(166306,"Malaria");
        mortalityDictionary.put(166307,"Maternal");
        mortalityDictionary.put(166308,"OtherInfetiousDiseases");
        mortalityDictionary.put(166309,"Pneumonia");
        mortalityDictionary.put(166310,"TB");
        mortalityDictionary.put(166311,"AcuteMyocardialInfection");
        mortalityDictionary.put(166312,"BreastCancer");
        mortalityDictionary.put(166313,"ChronicRespiratoryDiseases");
        mortalityDictionary.put(166314,"CervicalCancer");
        mortalityDictionary.put(166315,"Cirrhosis");
        mortalityDictionary.put(166316,"ColorectalCancer");
        mortalityDictionary.put(166317,"Diabetes");
        mortalityDictionary.put(166318,"EsophagealCancer");
        mortalityDictionary.put(166319,"LeukamiaLymphomas");
        mortalityDictionary.put(166320,"LungCancer");
        mortalityDictionary.put(166321,"OtherCardiovascularDiseases");
        mortalityDictionary.put(166322,"OtherNonCommunicableDiseases");
        mortalityDictionary.put(166323,"ProstateCancer");
        mortalityDictionary.put(166324,"ChronicKidneyDisease");
        mortalityDictionary.put(166325,"StomachCancer");
        mortalityDictionary.put(166326,"Stroke");
        mortalityDictionary.put(166327,"OtherCancers");
        mortalityDictionary.put(166331,"BiteofVenomousAnimal");
        mortalityDictionary.put(166332,"Drowning");
        mortalityDictionary.put(166333,"Fire");
        mortalityDictionary.put(166334,"Homicide");
        mortalityDictionary.put(166335,"OtherInjuries");
        mortalityDictionary.put(122255,"AccidentalPoisoning");
        mortalityDictionary.put(166336,"RoadTraffic");
        mortalityDictionary.put(125538,"SuicideByMultipleMeans");
        mortalityDictionary.put(166339,"Encephalitis");
        mortalityDictionary.put(166340,"HemorrhagicFever");
        mortalityDictionary.put(166328,"Sepsis");
        mortalityDictionary.put(166329,"Meningitis");
        mortalityDictionary.put(166330,"Measles");
        mortalityDictionary.put(166337,"OtherDefinedCausesofChildDeaths");
        mortalityDictionary.put(166338,"OtherDigestiveDiseases");
        mortalityDictionary.put(118350,"Fall");
        mortalityDictionary.put(166341,"BirthAsphyxia");
        mortalityDictionary.put(166342,"CongenitalMalformation");
        mortalityDictionary.put(166343,"NeonatalMeningitis");
        mortalityDictionary.put(166344,"NeonatalPneumonia");
        mortalityDictionary.put(166345,"PretermDelivery");
        mortalityDictionary.put(166346,"Stillbirth");
        mortalityDictionary.put(166155,"DidNotAttempttoTrackPatient");
        mortalityDictionary.put(166154,"TrackedbutUnabletoLocate");



        yesNoToggle.put(1066, Boolean.FALSE);
        yesNoToggle.put(1065, Boolean.TRUE);
        yesNoToggle.put(0, Boolean.FALSE);
        yesNoToggle.put(1, Boolean.TRUE);
    }



    private void loadYNCodeTypeDictionary() {
        mortalityYNCodeTypeDict.put(1065, YNCodeType.YES);
        mortalityYNCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;

        if (mortalityYNCodeTypeDict.containsKey(key)) {
            response = mortalityYNCodeTypeDict.get(key);
        }

        return response;
    }

    private Boolean getBooleanMappedValue(int key) {
        //  Boolean uio = htsBooleanDictionary.get(key);
        if (mortalityBooleanDictionary.containsKey(key)) {
            return mortalityBooleanDictionary.get(key);
        } else {
            return mortalityBooleanDictionary.get(key);
        }
    }

    public MortalityType createMortalityTags(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept,Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType, MortalityType mortality) throws DatatypeConfigurationException {


        Obs obs;

        ClientVerificationType clientVerificationType = createClientVerificationType(patient, groupedObsByConcept,groupedpatientBaselineObsByEncounterType);
        mortality.setClientVerification(clientVerificationType);

        //visit date and ID
        if(enc.getVisit() != null) {
            mortality.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
        }else {
            mortality.setVisitID(enc.getEncounterId().toString());
        }
        mortality.setVisitDate(utils.getXmlDate(enc.getEncounterDatetime()));

        obs = extractObs(165460, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setReasonForTracking(getMappedValue(obs.getValueCoded().getConceptId()));
            obs = extractObs(166138, groupedObsByConcept);
            if (obs != null && obs.getValueText() != null) {
                mortality.setOtherTrackingReason(obs.getValueText());
            }
        }

        obs = extractObs(165461, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setDateofLastActualContact(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(165778, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setDateofMissedScheduledAppointment(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(165463, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setDatePatientContacted(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(165465, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setModeofCommunication(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(165466, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setPersonContacted(getMappedValue(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(165467, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setReasonforDefaulting(getMappedValue2(obs.getValueCoded().getConceptId()));
            obs = extractObs(166139, groupedObsByConcept);
            if (obs != null && obs.getValueText() != null) {
                mortality.setOtherReasonforDefaulting(obs.getValueText());
            }
        }


        obs = extractObs(165586, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setDiscontinued(getMappedValue(obs.getValueCoded().getConceptId()));
        }

        //LTFU
        /*obs = extractObs(5240, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            int valueCodedLTFU = obs.getValueCoded().getConceptId();
            Boolean ndrCodeLTFU = getYesNoToggleValue(valueCodedLTFU);
            mortality.setLosttoFollowup(ndrCodeLTFU);
            obs = extractObs(166157, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                mortality.setReasonforLosttoFollowup(getMappedValue(obs.getValueCoded().getConceptId()));
            }
            obs = extractObs(166152, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                try {
                    mortality.setDateLosttoFollowup(utils.getXmlDate(obs.getValueDate()));
                } catch (Exception ex) {
                    LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }
            }
        }*/

        obs = extractObs(165469, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setDateofTermination(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(165470, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setReasonforTermination(getMappedValue(obs.getValueCoded().getConceptId()));


            //LTFU
            /*obs = extractObs(166157, groupedObsByConcept);
            if (obs != null) {
                mortality.setLosttoFollowup(Boolean.TRUE);
                obs = extractObs(166157, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    mortality.setReasonforLosttoFollowup(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(166152, groupedObsByConcept);
                if (obs != null && obs.getValueDate() != null) {
                    try {
                        mortality.setDateLosttoFollowup(utils.getXmlDate(obs.getValueDate()));
                    } catch (Exception ex) {
                        LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                    }
                }
            }*/

            //Transferred Out
            obs = extractObs(159495, groupedObsByConcept);
            if (obs != null && obs.getValueText() != null) {
                mortality.setTransferredOutTo(obs.getValueText());
            }
            //Death
            obs = extractObs(165889, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                mortality.setDeath(getMappedValue(obs.getValueCoded().getConceptId()));
                obs = extractObs(165915, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    mortality.setOtherCauseofDeath(obs.getValueText());
                }
                obs = extractObs(166349, groupedObsByConcept);
                if (obs != null && obs.getValueCoded() != null) {
                    int valueCoded = obs.getValueCoded().getConceptId();
                    String ndrCode = getMappedValue(valueCoded);
                    if(ndrCode != null) {
                        mortality.setVACauseofDeath(ndrCode);
                    }
                    Obs valueObs = Utils.extractObs(valueCoded, groupedObsByConcept);
                    if (valueObs != null) {
                        valueCoded = valueObs.getValueCoded().getConceptId();
                        ndrCode = getMappedValue(valueCoded);
                        if(ndrCode != null) {
                            mortality.setCauseOfDeath(ndrCode);
                        }
                    }
                }
            }

            //Discontinue
            obs = extractObs(165916, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                mortality.setDiscontinuedCare(getMappedValue3(obs.getValueCoded().getConceptId()));
                obs = extractObs(165917, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    mortality.setDiscontinueCareOtherSpecify(obs.getValueText());
                }
            }
        }

        /*obs = extractObs(167222, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setIndicationforClientVerification(getMappedValue2(obs.getValueCoded().getConceptId()));
        }

        obs = extractObs(167236, groupedObsByConcept);
        if (obs != null && obs.getValueText() != null) {
            mortality.setClientVerificationOther(obs.getValueText());
        }*/

        obs = extractObs(165775, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setDateReturnedtoCare(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        obs = extractObs(165776, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            mortality.setReffferedFor(getMappedValue3(obs.getValueCoded().getConceptId()));
        }
        obs = extractObs(165459, groupedObsByConcept);
        if (obs != null && obs.getValueText() != null) {
            mortality.setNameofContactTracer(obs.getValueText());
        }
        obs = extractObs(165777, groupedObsByConcept);
        if (obs != null && obs.getValueDate() != null) {
            try {
                mortality.setContactTrackerSignatureDate(utils.getXmlDate(obs.getValueDate()));
            } catch (Exception ex) {
                LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }

        return mortality;
    }

    private ClientVerificationType createClientVerificationType(Patient patient, Map<Object, List<Obs>> groupedObsByConcept,Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType) {
        ClientVerificationType clientVerificationType = new ClientVerificationType();
        Integer[] targetEncounterTypes = {Utils.Client_Tracking_And_Termination_Encounter_Type_Id};
        List<Obs> obsList = Utils.extractObsList(groupedpatientBaselineObsByEncounterType, Arrays.asList(targetEncounterTypes));

        Obs obs = extractObs(167221, groupedObsByConcept);
        if (obs != null && obs.getValueCoded() != null) {
            clientVerificationType.setClientVerification(getMappedValue(obs.getValueCoded().getConceptId()));
            if (obs.getValueCoded().getConceptId() == 1065) {
                obs = Utils.extractObsByValues(167222,167223,obsList);
                if (obs != null) {
                    clientVerificationType.setPickupByProxy("TRUE");
                }

                obs = Utils.extractObsByValues(167222,167224,obsList);
                if (obs != null) {
                    clientVerificationType.setDuplicatedDemographic("TRUE");
                }

                obs = Utils.extractObsByValues(167222,167225,obsList);
                if (obs != null) {
                    clientVerificationType.setNoRecapture("TRUE");
                }else{
                    clientVerificationType.setNoRecapture("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167226,obsList);
                if (obs != null) {
                    clientVerificationType.setBatchPickupDates("TRUE");
                }else{
                    clientVerificationType.setBatchPickupDates("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167227,obsList);
                if (obs != null) {
                    clientVerificationType.setLastVisitIsOver18M("TRUE");
                }else{
                    clientVerificationType.setLastVisitIsOver18M("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167228,obsList);
                if (obs != null) {
                    clientVerificationType.setARTStartPickupDate("TRUE");
                }else{
                    clientVerificationType.setARTStartPickupDate("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167229,obsList);
                if (obs != null) {
                    clientVerificationType.setNoInitBiometric("TRUE");
                }else{
                    clientVerificationType.setNoInitBiometric("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167232,obsList);
                if (obs != null) {
                    clientVerificationType.setIncompleteVisitData("TRUE");
                }else{
                    clientVerificationType.setIncompleteVisitData("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167233,obsList);
                if (obs != null) {
                    clientVerificationType.setRepeatEncounterNoPrint("TRUE");
                }else{
                    clientVerificationType.setRepeatEncounterNoPrint("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167234,obsList);
                if (obs != null) {
                    clientVerificationType.setLongIntervalsARVPickup("TRUE");
                }else{
                    clientVerificationType.setLongIntervalsARVPickup("FALSE");
                }

                obs = Utils.extractObsByValues(167222,167235,obsList);
                if (obs != null) {
                    clientVerificationType.setSameSexDOBARTStartDate("TRUE");
                }else{
                    clientVerificationType.setSameSexDOBARTStartDate("FALSE");
                }

                obs = extractObs(167236, groupedObsByConcept);
                if (obs != null && obs.getValueText() != null) {
                    clientVerificationType.setOtherSpecifyForCV(obs.getValueText());
                }

                try {
                    List<Obs> allIndexGroupObs = groupedObsByConcept.get(167242);
                    if (allIndexGroupObs != null && !allIndexGroupObs.isEmpty()) {
                        allIndexGroupObs.forEach(gObs -> {
                            List<Obs> allMembersValue = new ArrayList<>(gObs.getGroupMembers());
                            Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);

                            Obs obs1 = extractObs(167241, allMembers);
                            if (obs1 != null && obs1.getValueDate() != null) {
                                try {
                                    clientVerificationType.setCT1STDate(utils.getXmlDate(obs1.getValueDate()));
                                } catch (Exception ex) {
                                    LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                                }
                            }

                            obs1 = extractObs(167239, allMembers);
                            if (obs1 != null && obs1.getValueCoded() != null) {
                                clientVerificationType.setFirstStatus(getMappedValue(obs1.getValueCoded().getConceptId()));
                            }

                            obs1 = extractObs(167238, allMembers);
                            if (obs1 != null && obs1.getValueCoded() != null) {
                                clientVerificationType.setFirstOutcome(getMappedValue(obs1.getValueCoded().getConceptId()));
                            }
                        });
                    }
                } catch (Exception ex) {
                    LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }

                try {
                    List<Obs> allIndexGroupObs = groupedObsByConcept.get(165902);
                    if (allIndexGroupObs != null && !allIndexGroupObs.isEmpty()) {
                        // Sort the list of observations by date_created in descending order
                        allIndexGroupObs.sort(Comparator.comparing(Obs::getDateCreated).reversed());

                        // Get the first observation (latest observation with latest date_created)
                        Obs latestObs = allIndexGroupObs.get(0);

                        // Now you can use this latest observation as needed
                        if (latestObs != null) {
                            List<Obs> allMembersValue = new ArrayList<>(latestObs.getGroupMembers());
                            Map<Object, List<Obs>> allMembers = Utils.groupedByConceptIdsOnly(allMembersValue);

                            Obs obs1 = extractObs(167241, allMembers);
                            if (obs1 != null && obs1.getValueDate() != null) {
                                try {
                                    clientVerificationType.setCT2NdDate(utils.getXmlDate(obs1.getValueDate()));
                                } catch (Exception ex) {
                                    LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                                }
                            }

                            obs1 = extractObs(167239, allMembers);
                            if (obs1 != null && obs1.getValueCoded() != null) {
                                clientVerificationType.setSecondStatus(getMappedValue(obs1.getValueCoded().getConceptId()));
                            }

                            obs1 = extractObs(167238, allMembers);
                            if (obs1 != null && obs1.getValueCoded() != null) {
                                clientVerificationType.setSecondOutcome(getMappedValue(obs1.getValueCoded().getConceptId()));
                            }
                        }
                    }
                } catch (Exception ex) {
                    LoggerUtils.write(MortalityDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
                }

            }
        }
        if (clientVerificationType.isEmpty()) {
            return null;
        }

        return clientVerificationType;
    }


    private String getMappedValue(int conceptID) {
        try {
            return mortalityDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue2(int conceptID) {
        try {
            return mortalityDictionary2.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue3(int conceptID) {
        try {
            return mortalityDictionary3.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private boolean getYesNoToggleValue(int conceptID) {
        try {
            return yesNoToggle.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return Boolean.FALSE;
        }
    }
}