/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.model.ndr.AntenatalRegistrationType.Syphilis;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class PMTCTDictionary {
    Utils utils = new Utils();
    public final static int  anc_no = 165567,
            Mode_of_Delivery = 5630,
            Birth_Weight = 5916,
            Birth_Length = 1439,
            Birth_Outcome = 159917,
            Child_HospitalNo = 167289,
            Child_Entry_Point = 167286,
            Child_Sex = 1533,
    //HIVProphylaxis
            Date_of_Initiation = 1,
            Age_at_InitiationWks = 1,
            Type_of_Prophylaxis = 1,
            Date_Completed = 164952,
    //SyphilisProphylaxis

    //HVBVaccine
            FirstDose_Date = 167490,
            FirstDose_Timing = 167551,
            SecondDose_Date = 167559,
            ThirdDose_Date = 167552,
            DateofBirth = 164802,
            DateofFirstVisit = 165850,//HIV Recency Date
            AgeAtVisit = 167125,
            ChildHosNumber = 167440, InfantSex = 1587;

    public PMTCTDictionary() {
        loadDictionary();
        loadBooleanDictionary();
        pharmacyDictionary = new PharmacyDictionary();
    }

    private Map<Integer, String> pmtctDictionary = new HashMap<>();
    private final Map<Integer, Boolean> pmtctBooleanDictionary = new HashMap<>();
    private final PharmacyDictionary pharmacyDictionary;
    private final Map<Integer, String> outcome = new HashMap<>();


    private void loadDictionary() {
        pmtctDictionary = new HashMap<>();
        pmtctDictionary.put(165048, "P");
        pmtctDictionary.put(165049, "BF");
        pmtctDictionary.put(165766, "OnART");
        pmtctDictionary.put(165553, "NotOnART");
        pmtctDictionary.put(162743, "Suspected");
        pmtctDictionary.put(167451, "NotSuspected");
        pmtctDictionary.put(1301, "TD");
        outcome.put(1302, "TND");
        pmtctDictionary.put(165520, "LT36");
        pmtctDictionary.put(165521, "GTe36");
        pmtctDictionary.put(164850, "LD");
        pmtctDictionary.put(1180, "BF");
        pmtctDictionary.put(1228, "Pos");
        pmtctDictionary.put(1229, "Neg");
        pmtctDictionary.put(167509, "NotTreated");
        pmtctDictionary.put(167524, "Treated");
        pmtctDictionary.put(167525, "Referred");
        pmtctDictionary.put(703, "Pos");
        pmtctDictionary.put(664, "Neg");
        pmtctDictionary.put(167446, "PriorOnHBVTreatment");
        pmtctDictionary.put(167442, "NewOnProphylaxis");
        pmtctDictionary.put(142177, "P");
        pmtctDictionary.put(1660, "NP");
        pmtctDictionary.put(167455, "Inter");
        pmtctDictionary.put(167454, "Intra");
        pmtctDictionary.put(162673, "Vaginal");
        pmtctDictionary.put(1171, "ElectiveCS");
        pmtctDictionary.put(159739, "EmergencyCS");
        pmtctDictionary.put(5622, "Other");
        pmtctDictionary.put(160429, "Alive");
        pmtctDictionary.put(160432, "Dead");
        pmtctDictionary.put(167470,"ANC");
        pmtctDictionary.put(166028,"Postnatal");
        pmtctDictionary.put(783,"Immunization");
        pmtctDictionary.put(160542,"OPD");
        pmtctDictionary.put(1896,"Inpatient");
        pmtctDictionary.put(160552,"Nutrition");
        pmtctDictionary.put(119874,"FamilyPlanning");
        pmtctDictionary.put(160563,"TransferIn");
        pmtctDictionary.put(808, "NVP");
        pmtctDictionary.put(621, "AZT");
        pmtctDictionary.put(165544, "NVP+AZT");
        pmtctDictionary.put(1652, "AZT+3TC+NVP");
        pmtctDictionary.put(1107, "None");
        pmtctDictionary.put(167510, "Within24hrs");
        pmtctDictionary.put(167564,"After24hrs");
        pmtctDictionary.put(1534, "M");
        pmtctDictionary.put(1535,"F");

        pmtctDictionary.put(138571, "HIV+");
        pmtctDictionary.put(112493, "Syphilis+");
        pmtctDictionary.put(111759, "HepatitisB+");
        pmtctDictionary.put(167562, "HIVSyphilis+");
        pmtctDictionary.put(167563, "HIVHBV+");
        pmtctDictionary.put(167633, "SyphilisHBV+");

        pmtctDictionary.put(165519, "PriorOnPregnancy");
        pmtctDictionary.put(165936, "InitiatedLessThan36Weeks");
        pmtctDictionary.put(165937, "InitiatedGreaterThan36Weeks");
        pmtctDictionary.put(165938, "InitiatedAtLabourAndDelivery");
        pmtctDictionary.put(165939, "InitiatedAfterDelivery");

        pmtctDictionary.put(165860 ,"InFacilityWithin72Hrs");
        pmtctDictionary.put(165862 ,"InFacilityAfter72Hrs");
        pmtctDictionary.put(165861 ,"DeliveredOutsideFacilityWithin72Hrs");
        pmtctDictionary.put(165863 ,"DeliveredFacilityAfter72Hrs");
        pmtctDictionary.put(165551, "LT2Months");
        pmtctDictionary.put(165550, "GTe2Months");

        outcome.put(165552,"HIVPositiveLinkedtoART");
        outcome.put(165553,"HIVPositiveNotLinkedToART");
        outcome.put(165554,"HIVNeg");
        outcome.put(1404,"StillBreastfeeding");
        outcome.put(165558,"TransferredOut");
        outcome.put(165557,"LostToFollowUp");
        outcome.put(165556,"Dead");
        outcome.put(703, "Positive");
        outcome.put(664, "Negative");

    }



    public List<InfantCohortRegistrationType> createChildFollowUp(List<Encounter> childFollowUpEncounters) {
        List<InfantCohortRegistrationType> childFollowUpTypes = new ArrayList<>();
        try {
            for (Encounter enc : childFollowUpEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> childFollowUpObsList = Utils.groupedByConceptIdsOnly(obsList);
                InfantCohortRegistrationType followup = new InfantCohortRegistrationType();

                Obs obs = extractObs(DateofBirth, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    followup.setDateOfBirth(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(DateofFirstVisit, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    followup.setDateOfFirstVisit(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(AgeAtVisit, childFollowUpObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    followup.setAgeAtFirstVisit(Integer.parseInt(String.valueOf(obs.getValueNumeric())));
                }

                obs = extractObs(ChildHosNumber, childFollowUpObsList);
                if (obs != null && obs.getValueText() != null) {
                    followup.setChildHospitalRegNo(obs.getValueText());
                }

                obs = extractObs(InfantSex, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    followup.setInfantSex(value);
                }

                obs = extractObs(Child_Entry_Point, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    followup.setChildEntryPoint(value);
                }

                obs = extractObs(163530, childFollowUpObsList);
                if (obs != null && obs.getValueText() != null) {
                    followup.setMotherHospitalNumber(obs.getValueText());
                }

                obs = extractObs(167284, childFollowUpObsList);
                if (obs != null && obs.getValueText() != null) {
                    followup.setMotherANCNumber(obs.getValueText());
                }

                obs = extractObs(167281, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    followup.setMotherStatus(value);
                }

                obs = extractObs(165940, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    followup.setMotherARTInitiationTiming(value);
                }

                MotherCurrentARTRegimenType regimen = null;
                obs = extractObs(160733, childFollowUpObsList); // Concept - Mother's Status
                Integer valueCoded;
                String ndrCode;;
                if (obs != null && obs.getValueCoded() != null) {
                    regimen = new MotherCurrentARTRegimenType();
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    if (ndrCode != null) {
                        regimen.setRegimenCode(ndrCode);
                        regimen.setRegimenDescription(obs.getValueCoded().getName().getName());
                    }
                }

                if(regimen != null)  followup.setMotherHIVARTRegimen(regimen);

                obs = extractObs(164953, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    followup.setMotherSyphilisTreatmentStartDate(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(167277, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    followup.setMotherHepatitisBTreatmentStartDate(utils.getXmlDate(obs.getValueDate()));
                }

                InfantHBVProphylaxisType hbvProphylaxis = new InfantHBVProphylaxisType();

                obs = extractObs(167630, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    int conceptId = obs.getValueCoded().getConceptId();
                    if (conceptId == 167510) { //Within 24hrs
                        hbvProphylaxis.setBirthDoseWithin24Hrs(true);
                    } else if (conceptId == 167564) {
                        hbvProphylaxis.setBirthDoseAfter24Hrs(true);
                    }
                }

                obs = extractObs(167629, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    int conceptId = obs.getValueCoded().getConceptId();

                    if (conceptId == 1065) {
                        hbvProphylaxis.setSecondDoseGiven(true);
                    }
                }

                obs = extractObs(167628, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    int conceptId = obs.getValueCoded().getConceptId();

                    if (conceptId == 1065) {
                        hbvProphylaxis.setThirdDoseGiven(true);
                    }
                }

                followup.setInfantHBVProphylaxis(hbvProphylaxis);

                InfantARVProphylaxisType infant = null;
                obs = extractObs(167322, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        infant = InfantARVProphylaxisType.fromValue(value);
                        followup.setInfantARVProphylaxisType(infant);
                    }
                }

                InfantARVProphylaxisTimingType timing = null;
                obs = extractObs(165864, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        timing = InfantARVProphylaxisTimingType.fromValue(value);
                        followup.setInfantARVProphylaxisTiming(timing);
                    }
                }

                CTXAgeCategoryType ctx = null;
                obs = extractObs(164979, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        ctx = CTXAgeCategoryType.fromValue(value);
                        followup.setCTXAgeCategory(ctx);
                    }
                }

                PCRTestType pcr = new PCRTestType();
                obs = extractObs(167103, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pcr.setAgeAtTest(PCRAgeAtTestType.fromValue(value));
                    }
                }

                obs = extractObs(159951, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    pcr.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(167477, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getOutcome(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pcr.setResult(PCRRapidTestResultType.fromValue(value));
                    }
                }

                obs = extractObs(167475, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    pcr.setDateResultReceived(utils.getXmlDate(obs.getValueDate()));
                }

                followup.setFirstPCR(pcr);

                ConfirmatoryPCRType confirm = new ConfirmatoryPCRType();
                obs = extractObs(167265, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    confirm.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(167266, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getOutcome(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        confirm.setResult(PCRRapidTestResultType.fromValue(value));
                    }
                }
                followup.setSecondPCR(confirm);

                ConfirmatoryPCRType third = new ConfirmatoryPCRType();
                obs = extractObs(167472, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    third.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(167476, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getOutcome(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        third.setResult(PCRRapidTestResultType.fromValue(value));
                    }
                }
                followup.setThirdPCR(third);


                ConfirmatoryPCRType con = new ConfirmatoryPCRType();
                obs = extractObs(167479, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    con.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(167471, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getOutcome(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        con.setResult(PCRRapidTestResultType.fromValue(value));
                    }
                }
                followup.setConfirmatoryPCR(con);


                InfantRapidAntibodyTestType rapidTest = new InfantRapidAntibodyTestType();
                obs = extractObs(167469, childFollowUpObsList);
                if (obs != null && obs.getValueText() != null) {
                    rapidTest.setAgeAtTestMonths(BigInteger.valueOf(obs.getValueNumeric().longValue()));
                }
                obs = extractObs(167467, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    rapidTest.setDateOfTest(utils.getXmlDate(obs.getValueDate()));
                }
                obs = extractObs(167466, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    int conceptId = obs.getValueCoded().getConceptId();
                    if (conceptId == 703) {
                        rapidTest.setResult(PCRRapidTestResultType.valueOf("Positive"));
                    } else if (conceptId == 664) {
                        rapidTest.setResult(PCRRapidTestResultType.valueOf("Negative"));
                    }
                }
                followup.setRapidAntibodyTest(rapidTest);


                InfantOutcomeStatusType outcome = null;
                obs = extractObs(165035, childFollowUpObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getOutcome(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        outcome = InfantOutcomeStatusType.fromValue(value);
                        followup.setOutcomeAt18Months(outcome);
                    }
                }

                InfantARTEnrollmentType enroll = new InfantARTEnrollmentType();
                obs = extractObs(167458, childFollowUpObsList);
                if (obs != null && obs.getValueDate() != null) {
                    enroll.setDateLinkedToARTClinic(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(165560, childFollowUpObsList);
                if (obs != null && obs.getValueText() != null) {
                    enroll.setARTEnrollmentNumber(obs.getValueText());
                }
                followup.setARTEnrollment(enroll);

                childFollowUpTypes.add(followup);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return childFollowUpTypes.isEmpty() ? null :  childFollowUpTypes;
    }

    public List<PMTCTRegisterType> createPMTCTRegister(List<Encounter> pmtctRegisterEncounters) {
        List<PMTCTRegisterType> pmtctRegisterTypes = new ArrayList<>();
        try {
            for (Encounter enc : pmtctRegisterEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> pmtctregisterObsList = Utils.groupedByConceptIdsOnly(obsList);
                PMTCTRegisterType pmptctRegister = new PMTCTRegisterType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if (enc.getVisit() != null) {
                    pmptctRegister.setVisitID(String.valueOf(enc.getVisit().getVisitId()));
                } else {
                    pmptctRegister.setVisitID(enc.getEncounterId().toString());
                }
                pmptctRegister.setVisitDate(convertedDate);

                Obs obs = extractObs(anc_no, pmtctregisterObsList);
                if (obs != null && obs.getValueText() != null) {
                    pmptctRegister.setANCNumber(obs.getValueText());
                }

                PregnancyBreastfeedingStatusType bf = null;
                obs = extractObs(165050, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        bf = PregnancyBreastfeedingStatusType.fromValue(value);
                        pmptctRegister.setPregnancyBreastfeedingStatus(bf);
                    }
                }

                KnownHIVPositiveStatusType knownHIV = null;
                obs = extractObs(165475, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        knownHIV = KnownHIVPositiveStatusType.fromValue(value);
                        pmptctRegister.setKnownHIVPositive(knownHIV);
                    }
                }

                obs = extractObs(167309, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pmptctRegister.setHIVEarlyAcute(value);
                    }
                }

                obs = extractObs(1305, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pmptctRegister.setHIVEarlyViralLoad(value);
                    }
                }

                obs = extractObs(159427, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pmptctRegister.setHIVTRANC(value);
                    }
                }

                obs = extractObs(166033, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pmptctRegister.setHIVRTANC(value);
                    }
                }

                obs = Utils.extractObs(159599, pmtctregisterObsList);
                if (obs != null && obs.getValueDate() != null) {
                    pmptctRegister.setDateOfInitiation(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(165518, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        pmptctRegister.setTimingOfArtInitiation(value);
                    }
                }

                RegisterSyphilisType syphilis = null;
                obs = extractObs(299, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    syphilis = new RegisterSyphilisType();
                    syphilis.setTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(167449, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(syphilis == null) syphilis = new RegisterSyphilisType();
                    syphilis.setTreatmentReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                if(syphilis != null)  pmptctRegister.setSyphilis(syphilis);

                RegisterHBVType hbv = null;
                obs = extractObs(167487, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    hbv = new RegisterHBVType();
                    hbv.setKnownPositive(getBooleanMappedValue(obs.getValueCoded().getConceptId()));
                }
                obs = extractObs(1322, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(hbv == null) hbv = new RegisterHBVType();
                    hbv.setTestResult(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(167448, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    if(hbv == null) hbv = new RegisterHBVType();
                    hbv.setTreatmentReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                if(hbv != null)  pmptctRegister.setHepatitisB(hbv);

                obs = extractObs(0, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    pmptctRegister.setInitiatedOnProphylaxis(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                RegisterTBScreeningType tbscreening = null;
                obs = extractObs(1659, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    tbscreening = new RegisterTBScreeningType();
                    tbscreening.setStatus(getMappedValue(obs.getValueCoded().getConceptId()));
                }

                obs = extractObs(166732, pmtctregisterObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    tbscreening = new RegisterTBScreeningType();
                    tbscreening.setTreatmentReferral(getMappedValue(obs.getValueCoded().getConceptId()));
                }
                if(tbscreening != null)  pmptctRegister.setTBScreening(tbscreening);


                RegisterVLType vl = new RegisterVLType();
                boolean hasVL = false;

                VLMeasurementType lessThan32Weeks =
                        createVLMeasurement(167566, 166123, pmtctregisterObsList);

                if (lessThan32Weeks != null) {
                    vl.setVLLessThan32Weeks(lessThan32Weeks);
                    hasVL = true;
                }


                VLMeasurementType weeks32To36 =
                        createVLMeasurement(167565, 166122, pmtctregisterObsList);

                if (weeks32To36 != null) {
                    vl.setVL32To36Weeks(weeks32To36);
                    hasVL = true;
                }


                VLMeasurementType breastfeeding =
                        createVLMeasurement(167568, 167567, pmtctregisterObsList);

                if (breastfeeding != null) {
                    vl.setVLBreastfeedingPeriod(breastfeeding);
                    hasVL = true;
                }


                if (hasVL) {
                    pmptctRegister.setViralLoad(vl);
                }

                pmtctRegisterTypes.add(pmptctRegister);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }

        return pmtctRegisterTypes.isEmpty() ? null :  pmtctRegisterTypes;

    }



    public List<MotherInfantPairVisitType> createMotherInfant(List<Encounter> motherInfantEncounters) {
        List<MotherInfantPairVisitType> motherInfantTypes = new ArrayList<>();
        try {
            for (Encounter enc : motherInfantEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> motherInfantObsList = Utils.groupedByConceptIdsOnly(obsList);
                MotherInfantPairVisitType motherInfant = new MotherInfantPairVisitType();

                XMLGregorianCalendar convertedDate = utils.getXmlDate(enc.getEncounterDatetime());
                if (enc.getVisit() != null) {
                    motherInfant.setVisitId(String.valueOf(enc.getVisit().getVisitId()));
                } else {
                    motherInfant.setVisitId(enc.getEncounterId().toString());
                }
                motherInfant.setVisitDate(convertedDate);

                Obs obs = extractObs(1438, motherInfantObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    motherInfant.setGestationalAgeWeeks(BigInteger.valueOf(Integer.parseInt(String.valueOf(obs.getValueNumeric()))));
                }

                obs = extractObs(5089, motherInfantObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    motherInfant.setMotherWeightKg(BigDecimal.valueOf((obs.getValueNumeric())));
                }
                obs = extractObs(1439, motherInfantObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    motherInfant.setSFHLenghtCm(BigDecimal.valueOf((obs.getValueNumeric())));
                }

                PregnancyBreastfeedingStatusType bf = null;
                obs = extractObs(165050, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        bf = PregnancyBreastfeedingStatusType.fromValue(value);
                        motherInfant.setMotherCurrentStatus(bf);
                    }
                }

                obs = extractObs(166024, motherInfantObsList); //Concept - was patient referred
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setMotherCurrentARTStatus(value);
                    }
                }

                MotherCurrentARTRegimenType regimen = null;
                obs = extractObs(160733, motherInfantObsList); // Concept - was Maternal partner treated for syphilis
                Integer valueCoded;
                String ndrCode;;
                if (obs != null && obs.getValueCoded() != null) {
                    regimen = new MotherCurrentARTRegimenType();
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    if (ndrCode != null) {
                        regimen.setRegimenCode(ndrCode);
                        regimen.setRegimenDescription(obs.getValueCoded().getName().getName());
                    }
                }

                if(regimen != null)  motherInfant.setMotherCurrentARTRegimen(regimen);

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setMotherCurrentHBVStatus(value);
                    }
                }

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setMotherCurrentHBVDrugName(value);
                    }
                }

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setMotherCurrentSyphilisStatus(value);
                    }
                }

                obs = extractObs(1, motherInfantObsList);
                if (obs != null && obs.getValueText() != null) {
                    motherInfant.setSyphilisDrugAdministered(obs.getValueText());
                }

                PairCardVisitVLType vl = null;
                obs = extractObs(299, motherInfantObsList);
                if (obs != null && obs.getValueDate() != null) {
                    vl = new PairCardVisitVLType();
                    vl.setDateSampleCollected(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(299, motherInfantObsList);
                if (obs != null && obs.getValueDate() != null) {
                    vl = new PairCardVisitVLType();
                    vl.setDateResultReceived(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(299, motherInfantObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    vl = new PairCardVisitVLType();
                    vl.setResultCopiesPerML(BigDecimal.valueOf(obs.getValueNumeric()));
                }

                if(vl != null)  motherInfant.setViralLoad(vl);

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setInfantFeedingPractice(value);
                    }
                }

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setInfantOnCTX(value);
                    }
                }

                obs = extractObs(1305, motherInfantObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    if (value != null) {
                        motherInfant.setReferredToTreatment(value);
                    }
                }

                obs = extractObs(299, motherInfantObsList);
                if (obs != null && obs.getValueDate() != null) {
                    motherInfant.setNextAppointmentDate(utils.getXmlDate(obs.getValueDate()));
                }

                motherInfantTypes.add(motherInfant);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return motherInfantTypes.isEmpty() ? null :  motherInfantTypes;
    }


    private VLMeasurementType createVLMeasurement(int dateConceptId, int resultConceptId, Map<Object, List<Obs>> obsMap) {
        VLMeasurementType measurement = new VLMeasurementType();
        boolean hasData = false;

        Obs obs = extractObs(dateConceptId, obsMap);
        if (obs != null && obs.getValueDate() != null) {
            measurement.setResultDate(utils.getXmlDate(obs.getValueDate()));
            hasData = true;
        }

        obs = extractObs(resultConceptId, obsMap);
        if (obs != null && obs.getValueNumeric() != null) {
            measurement.setResultCopiesPerML(BigDecimal.valueOf(obs.getValueNumeric()));
            hasData = true;
        }
        return hasData ? measurement : null;
    }

    private String getMappedValue(int conceptID) {
        try {
            return pmtctDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LogLevel.live);
            return "";
        }
    }


    private void loadBooleanDictionary() {
        //this was added because the class are boolean variable while the data is obs_coded
        pmtctBooleanDictionary.put(1065, true);
        pmtctBooleanDictionary.put(1066, false);
        pmtctBooleanDictionary.put(1, true);
        pmtctBooleanDictionary.put(2, false);
    }
    private boolean getBooleanMappedValue(int key) {
        if (pmtctBooleanDictionary.containsKey(key)) {
            Boolean value = pmtctBooleanDictionary.get(key);
            return value != null ? value : false;
        }
        return false;
    }

    public String getOutcome(int value_coded) {
        if (outcome.containsKey(value_coded)) {
            return outcome.get(value_coded);
        }
        return null;
    }


    public List<DeliveryChildrenDetailsType> createChildDelivery(List<Encounter> childrenDeliveryEncounters) {
        List<DeliveryChildrenDetailsType> childDeliveryTypes = new ArrayList<>();
        try {
            for (Encounter enc : childrenDeliveryEncounters) {
                Set<Obs> obsSet = enc.getAllObs();
                List<Obs> obsList = new ArrayList<>(obsSet);
                Map<Object, List<Obs>> childDeliveryObsList = Utils.groupedByConceptIdsOnly(obsList);
                DeliveryChildrenDetailsType childDelivery = new DeliveryChildrenDetailsType();

                Obs obs = extractObs(5599, childDeliveryObsList);
                if (obs != null && obs.getValueDate() != null) {
                    childDelivery.setDateOfDelivery(utils.getXmlDate(obs.getValueDate()));
                }

                obs = extractObs(Mode_of_Delivery, childDeliveryObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    childDelivery.setModeOfDelivery(value);
                }

                obs = extractObs(Birth_Weight, childDeliveryObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    childDelivery.setBirthWeightKg(BigDecimal.valueOf(obs.getValueNumeric()));
                }

                obs = extractObs(Birth_Length, childDeliveryObsList);
                if (obs != null && obs.getValueNumeric() != null) {
                    childDelivery.setBirthLengthCm(BigDecimal.valueOf(obs.getValueNumeric()));
                }

                obs = extractObs(Birth_Outcome, childDeliveryObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    childDelivery.setBirthOutcome(value);
                }

                obs = extractObs(Child_HospitalNo, childDeliveryObsList);
                if (obs != null && obs.getValueText() != null) {
                    childDelivery.setChildHospitalNumber(obs.getValueText());
                }

                obs = extractObs(Child_Entry_Point, childDeliveryObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    childDelivery.setChildEntryPoint(value);
                }

                obs = extractObs(Child_Sex, childDeliveryObsList);
                if (obs != null && obs.getValueCoded() != null) {
                    String value = getMappedValue(obs.getValueCoded().getConceptId());
                    childDelivery.setSex(value);
                }



                childDeliveryTypes.add(childDelivery);
            }
        } catch (Exception ex) {
            LoggerUtils.write(PMTCTDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LogLevel.live);
        }
        return childDeliveryTypes.isEmpty() ? null :  childDeliveryTypes;
    }




}
