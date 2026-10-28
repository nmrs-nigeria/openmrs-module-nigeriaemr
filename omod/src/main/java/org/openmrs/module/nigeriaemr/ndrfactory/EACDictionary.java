package org.openmrs.module.nigeriaemr.ndrfactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.module.nigeriaemr.model.ndr.EACType;
import org.openmrs.module.nigeriaemr.model.ndr.YNCodeType;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class EACDictionary {

    Utils utils = new Utils();

    //TODO: replace placeholder concept ids with the real EAC concepts when available
    public static final int ASSESSMENT_DATE = 0;
    public static final int EAC_SESSION_TYPE = 166097;
    public static final int ARV_PLAN = 0;
    public static final int SESSION_NUMBER = 166097;
    public static final int ADHERENCE_LEVEL = 165290;
    public static final int MISSED_DOSES = 166255;
    public static final int BARRIER_TYPE = 0;
    public static final int INTERVENTION_PROVIDED = 0;
    public static final int INTERVENTION_TOOL = 0;
    public static final int FOLLOWUP_DATE = 165036;
    public static final int REPEAT_VL_SAMPLE_COLLECTED_DATE = 166296;
    public static final int REPEAT_VIRAL_LOAD_RESULT = 856;
    public static final int REPEAT_VL_RESULT_RECEIVED_DATE = 166296;
    public static final int REPEAT_VL_OUTCOME_CODE = 167330;
    public static final int VL_PLAN_OUTCOME_CODE = 165771;
    public static final int EAC_MONITORING_OUTCOME_CODE = 167326;

    private final Map<Integer, String> eacSessionTypeDict = new HashMap<>();
    private final Map<Integer, String> arvPlanDict = new HashMap<>();
    private final Map<Integer, String> sessionNumberDict = new HashMap<>();
    private final Map<Integer, String> adherenceLevelDict = new HashMap<>();
    private final Map<Integer, String> barrierTypeDict = new HashMap<>();
    private final Map<Integer, String> interventionProvidedDict = new HashMap<>();
    private final Map<Integer, String> interventionToolDict = new HashMap<>();
    private final Map<Integer, String> repeatVLOutcomeDict = new HashMap<>();
    private final Map<Integer, String> vlPlanOutcomeDict = new HashMap<>();
    private final Map<Integer, String> eacMonitoringOutcomeDict = new HashMap<>();
    private final Map<Integer, YNCodeType> ynCodeTypeDict = new HashMap<>();

    public EACDictionary() {
        loadDictionary();
    }

    private void loadDictionary() {
        //TODO: map answer concept ids to NDR enumeration codes

        //SessionNumber: Session1..Session6
        sessionNumberDict.put(165643, "Session1");
        sessionNumberDict.put(165644, "Session2");
        sessionNumberDict.put(165645, "Session3");
        sessionNumberDict.put(165646, "Session4");
        sessionNumberDict.put(165647, "Session5");
        sessionNumberDict.put(165648, "Session6");

        //AdherenceLevel: Good, Fair, Poor
        adherenceLevelDict.put(165287, "Good");
        adherenceLevelDict.put(165288, "Fair");
        adherenceLevelDict.put(165289, "Poor");

        //BarrierType
        barrierTypeDict.put(0, "Forgot");
        barrierTypeDict.put(0, "KnowledgeBeliefs");
        barrierTypeDict.put(0, "SideEffects");
        barrierTypeDict.put(0, "PhysicalIllness");
        barrierTypeDict.put(0, "SubstanceUse");
        barrierTypeDict.put(0, "Depression");
        barrierTypeDict.put(0, "PillBurden");
        barrierTypeDict.put(0, "LostRanOutOfDrugs");
        barrierTypeDict.put(0, "Transport");
        barrierTypeDict.put(0, "ChildRefusing");
        barrierTypeDict.put(0, "Scheduling");
        barrierTypeDict.put(0, "FearDisclosureFamilyPartner");
        barrierTypeDict.put(0, "FoodInsecurity");
        barrierTypeDict.put(0, "DrugStockOut");
        barrierTypeDict.put(0, "LongWaitingTime");
        barrierTypeDict.put(0, "Stigma");
        barrierTypeDict.put(0, "Other");

        //InterventionProvided
        interventionProvidedDict.put(0, "Education");
        interventionProvidedDict.put(0, "CounselingIndividual");
        interventionProvidedDict.put(0, "CounselingGroup");
        interventionProvidedDict.put(0, "PeerSupport");
        interventionProvidedDict.put(0, "TreatmentBuddy");
        interventionProvidedDict.put(0, "ExtendedDrugPickUp");
        interventionProvidedDict.put(0, "CommunityARTGroup");
        interventionProvidedDict.put(0, "DirectlyObservedTherapy");
        interventionProvidedDict.put(0, "Other");

        //InterventionTool
        interventionToolDict.put(0, "PillBox");
        interventionToolDict.put(0, "Calendar");
        interventionToolDict.put(0, "IncentiveCalendarPeds");
        interventionToolDict.put(0, "ARVSwallowingInstruction");
        interventionToolDict.put(0, "WrittenInstructions");
        interventionToolDict.put(0, "PhoneCallsSMS");
        interventionToolDict.put(0, "Alarms");
        interventionToolDict.put(0, "Other");

        //RepeatVLOutcomeCode
        repeatVLOutcomeDict.put(167329, "Undetectable");
        repeatVLOutcomeDict.put(167328, "SuppressedButDetectable");
        repeatVLOutcomeDict.put(167327, "Unsuppressed");

        //VLPlanOutcomeCode
        vlPlanOutcomeDict.put(1257, "RemainOnCurrentRegimen");
        vlPlanOutcomeDict.put(165768, "RegimenSwitchedBySwitchCommittee");
        vlPlanOutcomeDict.put(166002, "ReferToDoctorForFurtherManagement");

        //EACMonitoringOutcomeCode
        eacMonitoringOutcomeDict.put(167325, "EACCompleted");
        eacMonitoringOutcomeDict.put(167324, "EACStopped");
        eacMonitoringOutcomeDict.put(160432, "Dead");
        eacMonitoringOutcomeDict.put(166006, "LostToFollowUp");
        eacMonitoringOutcomeDict.put(159492, "TransferredOut");

        //MissedDoses (YNCodeType)
        ynCodeTypeDict.put(1065, YNCodeType.YES);
        ynCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private String lookup(Map<Integer, String> dict, int conceptId) {
        return dict.get(conceptId);
    }

    private YNCodeType getYNCodeTypeValue(int conceptId) {
        return ynCodeTypeDict.get(conceptId);
    }

    public EACType createEACType(Patient patient, Encounter enc, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {

        EACType eacType = new EACType();

        //VisitID
        if (enc.getVisit() != null) {
            eacType.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
        } else {
            eacType.setVisitID(enc.getEncounterId().toString());
        }

        //VisitDate
        XMLGregorianCalendar visitDate = utils.getXmlDate(enc.getEncounterDatetime());
        eacType.setVisitDate(visitDate);

        Obs obs;

        try {
            //AssessmentDate
            obs = extractObs(ASSESSMENT_DATE, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                eacType.setAssessmentDate(utils.getXmlDate(obs.getValueDate()));
            }

            //EACSessionType
            obs = extractObs(EAC_SESSION_TYPE, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setEACSessionType(lookup(eacSessionTypeDict, obs.getValueCoded().getConceptId()));
            }

            //ARVPlan
            obs = extractObs(ARV_PLAN, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setARVPlan(lookup(arvPlanDict, obs.getValueCoded().getConceptId()));
            }

            //SessionNumber
            obs = extractObs(SESSION_NUMBER, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setSessionNumber(lookup(sessionNumberDict, obs.getValueCoded().getConceptId()));
            }

            //AdherenceLevel
            obs = extractObs(ADHERENCE_LEVEL, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setAdherenceLevel(lookup(adherenceLevelDict, obs.getValueCoded().getConceptId()));
            }

            //MissedDoses
            obs = extractObs(MISSED_DOSES, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setMissedDoses(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
            }

            //BarrierType
            obs = extractObs(BARRIER_TYPE, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setBarrierType(lookup(barrierTypeDict, obs.getValueCoded().getConceptId()));
            }

            //InterventionProvided
            obs = extractObs(INTERVENTION_PROVIDED, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setInterventionProvided(lookup(interventionProvidedDict, obs.getValueCoded().getConceptId()));
            }

            //InterventionTool
            obs = extractObs(INTERVENTION_TOOL, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setInterventionTool(lookup(interventionToolDict, obs.getValueCoded().getConceptId()));
            }

            //FollowupDate
            obs = extractObs(FOLLOWUP_DATE, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                eacType.setFollowupDate(utils.getXmlDate(obs.getValueDate()));
            }

            //RepeatVLSampleCollectedDate
            obs = extractObs(REPEAT_VL_SAMPLE_COLLECTED_DATE, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                eacType.setRepeatVLSampleCollectedDate(utils.getXmlDate(obs.getValueDate()));
            }

            //RepeatViralLoadResult
            obs = extractObs(REPEAT_VIRAL_LOAD_RESULT, groupedObsByConcept);
            if (obs != null && obs.getValueNumeric() != null) {
                eacType.setRepeatViralLoadResult(BigDecimal.valueOf(obs.getValueNumeric()));
            }

            //RepeatVLResultReceivedDate
            obs = extractObs(REPEAT_VL_RESULT_RECEIVED_DATE, groupedObsByConcept);
            if (obs != null && obs.getValueDate() != null) {
                eacType.setRepeatVLResultReceivedDate(utils.getXmlDate(obs.getValueDate()));
            }

            //RepeatVLOutcomeCode
            obs = extractObs(REPEAT_VL_OUTCOME_CODE, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setRepeatVLOutcomeCode(lookup(repeatVLOutcomeDict, obs.getValueCoded().getConceptId()));
            }

            obs = extractObs(VL_PLAN_OUTCOME_CODE, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                Integer outcomeConceptId = obs.getValueCoded().getConceptId();
                eacType.setVLPlanOutcomeCode(lookup(vlPlanOutcomeDict, outcomeConceptId));
                Integer dateConcept = null;

                switch (outcomeConceptId) {
                    case 1257: // RemainOnCurrentRegimen
                        dateConcept = 166301;
                        break;

                    case 165768: // RegimenSwitchedBySwitchCommittee
                        dateConcept = 165337;
                        break;

                    case 166002: // ReferToDoctorForFurtherManagement
                        dateConcept = 167686;
                        break;

                    default:
                        break;
                }

                if (dateConcept != null) {
                    Obs dateObs = extractObs(dateConcept, groupedObsByConcept);
                    if (dateObs != null && dateObs.getValueDate() != null) {
                        eacType.setVLPlanOutcomeDate(utils.getXmlDate(dateObs.getValueDate()));
                    }
                }
            }

            //EACMonitoringOutcomeCode
            obs = extractObs(EAC_MONITORING_OUTCOME_CODE, groupedObsByConcept);
            if (obs != null && obs.getValueCoded() != null) {
                eacType.setEACMonitoringOutcomeCode(lookup(eacMonitoringOutcomeDict, obs.getValueCoded().getConceptId()));
            }

        } catch (Exception ex) {
            LoggerUtils.write(EACDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return eacType;
    }

    public List<EACType> createEACTypeList(Patient patient, Map<Integer, List<Encounter>> groupedEncounters) throws DatatypeConfigurationException {
        List<EACType> eacTypes = new ArrayList<>();
        if (groupedEncounters == null) {
            return eacTypes;
        }
        List<Encounter> eacEncounters = groupedEncounters.get(org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil.EAC_ENCOUNTER_TYPE);
        if (eacEncounters == null || eacEncounters.isEmpty()) {
            return eacTypes;
        }
        for (Encounter enc : eacEncounters) {
            try {
                List<Obs> obsList = new ArrayList<>(enc.getAllObs());
                Map<Object, List<Obs>> groupedObsByConcept = Utils.groupedByConceptIdsOnly(obsList);
                EACType eacType = createEACType(patient, enc, groupedObsByConcept);
                if (eacType != null) {
                    eacTypes.add(eacType);
                }
            } catch (Exception ex) {
                LoggerUtils.write(EACDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
            }
        }
        return eacTypes;
    }
}

