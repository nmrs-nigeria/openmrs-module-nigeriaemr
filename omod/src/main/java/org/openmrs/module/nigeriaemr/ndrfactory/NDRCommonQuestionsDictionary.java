/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaPatientService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.page.controller.CommunityTesterPageController;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;
import java.util.stream.Collectors;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

/**
 *
 * @author The Bright The goal of this class is to abstract the creation of a
 * CommonQuestionsType ConditionSpecificQuestionsType HIVQuestionsType
 */
public class NDRCommonQuestionsDictionary {

    public NDRCommonQuestionsDictionary() {
        loadDictionary();
        loadYNCodeTypeDictionary();
        pharmacyDictionary = new PharmacyDictionary();
    }

    private static Map<Integer, String> map = new HashMap<>();
    private static Map<Integer, String> artmap = new HashMap<>();
    private static Map<Integer, String> smap = new HashMap<>();
    private final Map<Integer, YNCodeType> YNCodeTypeDict = new HashMap<>();

    private PharmacyDictionary pharmacyDictionary;
    NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
    NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);


    Utils utils = new Utils();

    private Map<Integer, String> hivQuestionDictionary = new HashMap<>();

    private void loadDictionary() {
        //map.put(123, "PatientDeceasedIndicator");
        //map.put(124, "DeceasedIndicator");
        //map.put(125, "DeceasedIndicator");
        //map.put(126, "DeceasedIndicator");

        //PREGNANCY STATUS
        map.put(165048, "P"); //Pregnant
        map.put(165047, "NP");
        //map.put(128, "NK");
        map.put(165049, "PMTCT");

        //EDUCATIONAL_LEVEL MAPPING
        map.put(1107, "1");
        map.put(1713, "2");
        map.put(1714, "3");
        map.put(160292, "6");

        //PATIENT CARE IN FACILITY_TERMINATED
        /*map.put(159492, "1");
        map.put(165889, "2");
        map.put(165916, "3");*/

        /* OCCUPATIONAL CODE */
        map.put(123801, "UNE");
        map.put(1540, "EMP");
        map.put(159465, "STU");
        map.put(159461, "RET");
        map.put(1175, "NA");
        map.put(1067, "UNK");

        //MARITAL STATUS CODE
        map.put(1057, "S");
        map.put(5555, "M");
        map.put(1058, "D");
        map.put(1056, "A");
        map.put(1059, "W");

        //FUNCTIONAL STATUS
        map.put(159468, "W");
        map.put(162752, "B");
        map.put(160026, "A");

        //WHO STAGING
        map.put(1204, "1");
        map.put(1205, "2");
        map.put(1206, "3");
        map.put(1207, "4");

        // TB Status
        map.put(1660, "1");
        map.put(142177, "2");
        map.put(166042, "3");
        map.put(1661, "5");
        map.put(1662, "4");

        // DISCONTINUED CARE
        map.put(165891, "1");
        map.put(165892, "2");
        map.put(5622, "3");
        map.put(165890, "4");

        //Prior ART Exposure
        artmap.put(165712, "EarlierARV");
        artmap.put(165239, "TransferIn");
        artmap.put(165238, "TransferIn");
        artmap.put(165944, "PREP");
        artmap.put(165241, "PEP");
        artmap.put(165240, "PREP");


        //KPType
        map.put(166285, "FSW");
        map.put(160578, "MSM");
        map.put(166286, "PWID");
        map.put(166287, "TG");
        map.put(162277, "Prisoners");

        map.put(1679,"SixH");
        map.put(104943,"ThreeHP");
        map.put(1194,"ThreeHR");

        map.put(167547, "Firstline");
        map.put(167546, "Secondline");
        map.put(167545, "Thirdline");




        //Cause of Death


        smap.put(162574,"HIVRelated");
        smap.put(167436, "TB");
        smap.put(214, "RoadAccident");
        smap.put(116128, "Malaria");
        smap.put(1295, "COPD");
        smap.put(183, "Hypertension");
        smap.put(119481, "Diabetes");
        smap.put(5622, "Others");

        //Reason for substitution
        map.put(102,"Toxicity_SideEffect");
        map.put(166707,"DuetoNewTB");
        map.put(160561,"NewDrugAvailable");
        map.put(1754,"Stockout");
        map.put(167621,"ClinicalTreatmentFailure");
        map.put(165048,"Pregnancy");
        map.put(160559,"RiskofPregnancy");
        map.put(160566,"ImmunologicFailure");
        map.put(160569,"VirologicFailure");
        map.put(5622,"Other");


        //Mode of HIV Test
        map.put(164949, "HIVAb");
        map.put(164948, "HIVPCR");

        //CD4LFA
        map.put(167086, "LessThan200");
        map.put(167087, "GTEqual200");



        //Reason Medically Eligible
        map.put(164426, "1");
        map.put(5497, "2");
        map.put(730, "3");
        map.put(164427, "4");

        //VA Causes of Death
        map.put(166348,"VAA");
        map.put(166347,"VAC");


        map.put(1679,"SixH");
        map.put(104943,"ThreeHP");
        map.put(1194,"ThreeHR");

        //DR Genotyping
        map.put(167502,"WildType");
        map.put(167499,"ResistantDetected");
        map.put(167498,"NoResistantDetected");
        map.put(167497,"PartialResistant");
        map.put(167496,"Indeterminate");



        hivQuestionDictionary.put(165891, "1");
        hivQuestionDictionary.put(165892, "2");
        hivQuestionDictionary.put(5622, "3");
        hivQuestionDictionary.put(165890, "4");

        hivQuestionDictionary.put(165048, "Pregnant");
        hivQuestionDictionary.put(165049, "Breastfeeding");

    }

    private void loadYNCodeTypeDictionary() {
        YNCodeTypeDict.put(1065, YNCodeType.YES);
        YNCodeTypeDict.put(1066, YNCodeType.NO);
    }

    private String careEntryMap(int conceptId) {
        switch (conceptId) {
            case 160542:
                return "OPD";
            case 160536:
                return "Inpatients";
            case 159940:
                return "HTS";
            case 160541:
                return "TBDOTS";
            case 160538:
                return "ANC_PMTCT";
            case 160563:
                return "TransferIn";
            case 160543:
                return "Community";
            case 160546:
                return "STI";
            case 5622:
                return "Others";
            default:
                return null;
        }
    }



    public PatientDemographicsType createPatientDemographicsType(Patient pts, FacilityType facility, Map<Object, List<Obs>> groupedObsByEncounterTypes) throws DatatypeConfigurationException {

        PatientDemographicsType demo = new PatientDemographicsType();
        try {

            //Identifier 4 is Pepfar ID
            PatientIdentifier pidHospital, pidOthers, htsId, ancId, exposedInfantId, pepId, recencyId, pepfarid, openmrsId, tbId;

            //use combination of rdatimcode and hospital for peffar on surge rivers.
            pepfarid = new PatientIdentifier();
            // pepfarid.setIdentifier(String.valueOf(pts.getPatientIdentifier(4)));

//            PatientIdentifierType pepfaridPatientIdentifierType =
//                    Context.getPatientService().getPatientIdentifierType(Utils.PEPFAR_IDENTIFIER_INDEX);

//            String pepfarid = nigeriaPatientService.getPatientIdentifier(pts,pepfaridPatientIdentifierType);



            pidOthers = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.OTHER_IDENTIFIER_INDEX);
            pidHospital = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.HOSPITAL_IDENTIFIER_INDEX);
            htsId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.HTS_IDENTIFIER_INDEX);
            ancId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.PMTCT_IDENTIFIER_INDEX);
            exposedInfantId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.EXPOSE_INFANT_IDENTIFIER_INDEX);
            pepId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.PEP_IDENTIFIER_INDEX);
            // pepfarid = pts.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
            recencyId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.RECENCY_INDENTIFIER_INDEX);
            tbId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.TB_IDENTIFIER_INDEX );
            openmrsId = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.OPENMRS_IDENTIFIER_INDEX);
            pepfarid = Utils.getPatientIdentifier(pts.getIdentifiers(), Utils.PEPFAR_IDENTIFIER_INDEX);

            /*
            pidHospital = pts.getPatientIdentifier(Utils.HOSPITAL_IDENTIFIER_INDEX);
            pidOthers = pts.getPatientIdentifier(Utils.OTHER_IDENTIFIER_INDEX);
            htsId = pts.getPatientIdentifier(Utils.HTS_IDENTIFIER_INDEX);
            ancId = pts.getPatientIdentifier(Utils.PMTCT_IDENTIFIER_INDEX);
            exposedInfantId = pts.getPatientIdentifier(Utils.EXPOSE_INFANT_IDENTIFIER_INDEX);
            pepId = pts.getPatientIdentifier(Utils.PEP_IDENTIFIER_INDEX);
            pepfarid = pts.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
            recencyId = pts.getPatientIdentifier(Utils.RECENCY_INDENTIFIER_INDEX);
            */

            IdentifierType idt;
            IdentifiersType identifiersType = new IdentifiersType();
            // Use PepfarID as preferred ID if it exist, else use other IDs
            if (pepfarid != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pepfarid.getIdentifier());
                demo.setPatientIdentifier(pepfarid.getIdentifier());
            }else{
                String pepfaridForRedactedPatient = nigeriaPatientService.getPatientIdentifierByPatientsId(pts.getPatientId(), Utils.PEPFAR_IDENTIFIER_INDEX);
                if(pepfaridForRedactedPatient != null) {
                    demo.setPatientIdentifier(pepfaridForRedactedPatient);
                }
            }

            if (pidHospital != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidHospital.getIdentifier());
                idt.setIDTypeCode("HN");
                identifiersType.getIdentifier().add(idt);
            }
            if (pidOthers != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidOthers.getIdentifier());
                idt.setIDTypeCode("EID");
                identifiersType.getIdentifier().add(idt);
            }
            if (htsId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(htsId.getIdentifier());
                idt.setIDTypeCode("HTS");
                identifiersType.getIdentifier().add(idt);
            }
            if (ancId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(ancId.getIdentifier());
                idt.setIDTypeCode("ANC");
                identifiersType.getIdentifier().add(idt);
            }else{
                List<String> ancIds = utils.getIds(groupedObsByEncounterTypes.get(ConstantsUtil.GENERAL_ANTENATAL_CARE_ENCOUNTER_TYPE),165567);
                if(ancIds != null && !ancIds.isEmpty()){
                    idt = new IdentifierType();
                    idt.setIDNumber(ancIds.get(0));
                    idt.setIDTypeCode("ANC");
                    identifiersType.getIdentifier().add(idt);
                }
            }
            if (exposedInfantId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(exposedInfantId.getIdentifier());
                idt.setIDTypeCode("HEI");
                identifiersType.getIdentifier().add(idt);
            }
            if (pepId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pepId.getIdentifier());
                idt.setIDTypeCode("PEP");
                identifiersType.getIdentifier().add(idt);
            }
            if (recencyId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(recencyId.getIdentifier());
                idt.setIDTypeCode("RECENT");
                identifiersType.getIdentifier().add(idt);
            }

            if (tbId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(tbId.getIdentifier());
                idt.setIDTypeCode("TB");
                identifiersType.getIdentifier().add(idt);
            }else{
                if(pepfarid != null){
                    idt = new IdentifierType();
                    idt.setIDNumber(pepfarid.getIdentifier());
                    idt.setIDTypeCode("TB");
                    identifiersType.getIdentifier().add(idt);
                }
            }

            if(!identifiersType.getIdentifier().isEmpty()) {
                demo.setOtherPatientIdentifiers(identifiersType);
            }


            if(pts.isVoided() && pepfarid != null){
                NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);
                List<Integer> patientIds = nigeriaPatientService.getPatientIdsByIdentifiersByType(pepfarid.getIdentifier(),4);
                if(!patientIds.isEmpty()) return null;
            }

            demo.setTreatmentFacility(facility);

            String gender = pts.getGender();
            if (gender.equals("M") || gender.equalsIgnoreCase("Male")) {
                demo.setPatientSexCode("M");
            } else if (gender.equals("F") || gender.equalsIgnoreCase("Female")) {
                demo.setPatientSexCode("F");
            }
            demo.setPatientDateOfBirth(utils.getXmlDate(pts.getBirthdate()));


            //check Finger Print if available
            demo.setFingerPrints(getPatientsFingerPrint(pts.getPatientId()));


            String ndrCodedValue;
            Integer[] formEncounterTypeTargets = {Utils.ADULT_INITIAL_ENCOUNTER_TYPE, Utils.PED_INITIAL_ENCOUNTER_TYPE,
                    Utils.INITIAL_ENCOUNTER_TYPE, Utils.HIV_Enrollment_Encounter_Type_Id,
                    Utils.Discontinuation_Encounter_Type_Id, Utils.Care_Care_1c_Encounter_Type_Id};

            List<Obs> obsListForEncounterTypesValues = Utils.extractObsList(groupedObsByEncounterTypes, Arrays.asList(formEncounterTypeTargets));


            Map<Object, List<Obs>> obsListForEncounterTypes = Utils.groupedByConceptIdsOnly(obsListForEncounterTypesValues);

            Obs obs = null;
            if (!obsListForEncounterTypes.isEmpty()) {
                //check for disease indicator
                obs = Utils.extractObs(Utils.REASON_FOR_TERMINATION_CONCEPT, obsListForEncounterTypes);
                if (obs != null && obs.getValueCoded() != null) {
                    if (obs.getValueCoded().getConceptId() == Utils.DEAD_CONCEPT) {
                        demo.setPatientDeceasedIndicator(true);
                        obs = Utils.extractObs(Utils.DATE_OF_TERMINATION_CONCEPT, obsListForEncounterTypes);
                        //set date
                        if (obs != null) {
                            demo.setPatientDeceasedDate(utils.getXmlDate(obs.getObsDatetime()));
                        }
                    } else {
                        demo.setPatientDeceasedIndicator(false);
                    }
                }
                //check Educational level
                obs = Utils.extractObs(Utils.EDUCATIONAL_LEVEL_CONCEPT, obsListForEncounterTypes);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    if (ndrCodedValue.equals("N")) {
                        demo.setPatientEducationLevelCode("1");
                    } else if (!"".equals(ndrCodedValue)) {
                        demo.setPatientEducationLevelCode(ndrCodedValue);
                    }

                }
                //check primary Concept Id
                //obs = Utils.extractObs(Utils.PRIMARY_LANGUAGE_CONCEPT, obsListForEncounterTypes);
                //if (obs != null) {
                //ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                //demo.setPatientPrimaryLanguageCode(ndrCodedValue);
                // }
                //check Occupational Code
                obs = Utils.extractObs(Utils.OCCUPATIONAL_STATUS_CONCEPT, obsListForEncounterTypes);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    if (!"".equals(ndrCodedValue)) {
                        demo.setPatientOccupationCode(ndrCodedValue);
                    }
                }
                //check Marital Status Code
                obs = Utils.extractObs(Utils.MARITAL_STATUS_CONCEPT, obsListForEncounterTypes);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    if (!"".equals(ndrCodedValue)) {
                        demo.setPatientMaritalStatusCode(ndrCodedValue);
                    }

                }
            }

            return demo;
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LoggerUtils.LogLevel.live);
            //throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }

        return demo;

    }



    public FingerPrintType getPatientsFingerPrint(int id) {
        try {
            List<BiometricInfo> biometricInfos = nigeriaemrService.getBiometricInfoByPatientId(id);
            FingerPrintType fingerPrintsType = new FingerPrintType();
            if (biometricInfos.size() > 0) {
                RightHandType rightFingerType = new RightHandType();
                LeftHandType leftFingerType = new LeftHandType();
                XMLGregorianCalendar dataCaptured = null;
                for (BiometricInfo biometricInfo: biometricInfos) {
                    String fingerPosition = biometricInfo.getFingerPosition();
                    dataCaptured = utils.getXmlDateTime(biometricInfo.getDateCreated());
                    switch (fingerPosition) {
                        case "RightThumb":
                            rightFingerType.setRightThumb(biometricInfo.getTemplate());
                            rightFingerType.setRightThumbQuality(biometricInfo.getImageQuality());
                            break;
                        case "RightIndex":
                            rightFingerType.setRightIndex(biometricInfo.getTemplate());
                            rightFingerType.setRightIndexQuality(biometricInfo.getImageQuality());
                            break;
                        case "RightMiddle":
                            rightFingerType.setRightMiddle(biometricInfo.getTemplate());
                            rightFingerType.setRightMiddleQuality(biometricInfo.getImageQuality());
                            break;
                        case "RightWedding":
                            rightFingerType.setRightWedding(biometricInfo.getTemplate());
                            rightFingerType.setRightWeddingQuality(biometricInfo.getImageQuality());
                            break;
                        case "RightSmall":
                            rightFingerType.setRightSmall(biometricInfo.getTemplate());
                            rightFingerType.setRightSmallQuality(biometricInfo.getImageQuality());
                            break;
                        case "LeftThumb":
                            leftFingerType.setLeftThumb(biometricInfo.getTemplate());
                            leftFingerType.setLeftThumbQuality(biometricInfo.getImageQuality());
                            break;
                        case "LeftIndex":
                            leftFingerType.setLeftIndex(biometricInfo.getTemplate());
                            leftFingerType.setLeftIndexQuality(biometricInfo.getImageQuality());
                            break;
                        case "LeftMiddle":
                            leftFingerType.setLeftMiddle(biometricInfo.getTemplate());
                            leftFingerType.setLeftMiddleQuality(biometricInfo.getImageQuality());
                            break;
                        case "LeftWedding":
                            leftFingerType.setLeftWedding(biometricInfo.getTemplate());
                            leftFingerType.setLeftWeddingQuality(biometricInfo.getImageQuality());
                            break;
                        case "LeftSmall":
                            leftFingerType.setLeftSmall(biometricInfo.getTemplate());
                            leftFingerType.setLeftSmallQuality(biometricInfo.getImageQuality());
                            break;
                    }
                }

                fingerPrintsType.setDateCaptured(dataCaptured);
                fingerPrintsType.setRightHand(rightFingerType);
                fingerPrintsType.setLeftHand(leftFingerType);
                return fingerPrintsType;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.write(NDRMainDictionary.class.getName(), e.getMessage(), LogFormat.FATAL, LoggerUtils.LogLevel.live.live);
        }
        return null;
    }

    public CommonQuestionsType createCommonQuestionType(Patient pts, Encounter lastEncounterDate, Map<Object, List<Obs>> groupedObsByConcept) throws DatatypeConfigurationException {
        Obs obs;
        Date valueDateTime;
        Boolean ndrBooleanCode;
        try {
            PatientIdentifier pepfarIdentifier = pts.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);

            CommonQuestionsType common = new CommonQuestionsType();
            //List<Obs> hivEnrollmentObs = Utils.FilterObsByEncounterTypeId(allObs, Utils.HIV_Enrollment_Encounter_Type_Id); // Utils.getHIVEnrollmentObs(pts);

            if (pepfarIdentifier != null) {

                try {
                    common.setHospitalNumber(pts.getPatientIdentifier(Utils.HOSPITAL_IDENTIFIER_INDEX).getIdentifier());
                } catch (Exception e) {
                    //  common.setHospitalNumber(pts.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX).getIdentifier());
                }
                /*  Assuming Hospital No is 3*/
                //old code commented for throwing error change by the try and catch code abowe
                //common.setHospitalNumber(pts.getPatientIdentifier(3).getIdentifier());
            }

            try {
//                Encounter lastEncounterDate = Utils.getLastEncounter(encounters); //(pts);
                if (lastEncounterDate != null) {
                    common.setDateOfLastReport(utils.getXmlDate(lastEncounterDate.getEncounterDatetime()));
                }

                Date EnrollmentDate = Utils.extractEnrollmentDate(groupedObsByConcept);


                if (EnrollmentDate != null) {
                    common.setDateOfFirstReport(utils.getXmlDate(EnrollmentDate));
                    common.setDiagnosisDate(utils.getXmlDate(EnrollmentDate));
                }else {
                    return null; //Patient was never enrolled in the HIV program
                }
                obs = Utils.extractLastObs(Utils.DATE_OF_HIV_DIAGNOSIS_CONCEPT, groupedObsByConcept);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    common.setDiagnosisDate(utils.getXmlDate(valueDateTime));
                }
            } catch (Exception ex) {
                LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                        LoggerUtils.LogLevel.live);
            }

            if (pts.getGender().equalsIgnoreCase("F")) {

                //set estimated delivery date concept id
                obs = Utils.extractLastObs(Utils.PREGNANCY_BREASTFEEDING_STATUS, groupedObsByConcept);
                if (obs != null && obs.getValueAsBoolean() != null) {
                    ndrBooleanCode = obs.getValueBoolean();
                    if (ndrBooleanCode) {
                        common.setPatientPregnancyStatusCode("P");
                    } else {
                        common.setPatientPregnancyStatusCode("NP");
                    }

                }

            }

            common.setPatientAge(pts.getAge());

            //set Patient Die From This Illness tag

            List<Obs> obsList = groupedObsByConcept.get(Utils.REASON_FOR_TERMINATION_CONCEPT);
            if(obsList != null && !obsList.isEmpty()) {
                List<Obs> obsnew = groupedObsByConcept.get(Utils.DEAD_CONCEPT);
                if (obsnew != null && !obsnew.isEmpty()) {
                    common.setPatientDieFromThisIllness(Boolean.TRUE);
                }
            }else {
                common.setPatientDieFromThisIllness(Boolean.FALSE);
            }
            return common;
        } catch (Exception ex) {
            LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LogFormat.FATAL, LoggerUtils.LogLevel.live);
            throw new DatatypeConfigurationException(ex.getMessage());
        }
    }

    public HIVQuestionsType createHIVQuestionType(Patient patient, Map<Object, List<Obs>> groupedpatientBaselineObsByConcept,
                                                  Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType) throws DatatypeConfigurationException {
        Integer[] targetEncounterTypes = {Utils.HIV_Enrollment_Encounter_Type_Id, Utils.ART_COMMENCEMENT_ENCOUNTER_TYPE,
                Utils.Discontinuation_Encounter_Type_Id, Utils.Care_Care_1c_Encounter_Type_Id};
        HIVQuestionsType hivQuestionsType = null;
        List<Obs> obsList = Utils.extractObsList(groupedpatientBaselineObsByEncounterType, Arrays.asList(targetEncounterTypes));
        List<Integer> obsNewList = obsList.stream().map(Obs::getObsId).collect(Collectors.toList());
        Obs obs;
        int valueCoded, valueNumericInt;
        String ndrCodedValue;

        Date valueDateTime;
        String ndrCode;
        FacilityType facilityType;
        RegimenCodedSimpleType cst;

        Map<Object, List<Obs>> obsListId = Utils.groupedByConceptIdsOnly(obsList);

        if (!obsList.isEmpty()) {
            hivQuestionsType = new HIVQuestionsType();

            obs = Utils.extractObs(167637, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                int answerId = obs.getValueCoded().getConceptId();
                if (answerId == 1065) {
                    hivQuestionsType.setBiometricCaptured(YNCodeType.YES);
                } else if (answerId == 1066) {
                    hivQuestionsType.setBiometricCaptured(YNCodeType.NO);
                }
            }

            obs =  Utils.extractObs(Utils.CARE_ENTRY_POINT_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = careEntryMap(valueCoded);
                if (ndrCode != null){
                    if (!ndrCode.isEmpty()) {
                        hivQuestionsType.setCareEntryPoint(ndrCode);
                    }
                }
            }

            obs =  Utils.extractObs(Utils.DATE_OF_HIV_DIAGNOSIS_CONCEPT,obsListId);
            if (obs != null && obs.getValueDate() != null) {
                valueDateTime = obs.getValueDate();
                hivQuestionsType.setFirstConfirmedHIVTestDate(utils.getXmlDate(valueDateTime));
            }

            obs =  Utils.extractObs(Utils.MODE_OF_HIV_TEST,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null) {
                    if (!ndrCode.isEmpty()) {
                        hivQuestionsType.setFirstHIVTestMode(ndrCode);
                    }
                }
            }

            // Where first tested positive missing
            obs = Utils.extractObs(167586, obsListId);
            if (obs != null && obs.getValueText() != null) {
                hivQuestionsType.setWhereFirstHIVTest(obs.getValueText());
            }

            obs =  Utils.extractObs(Utils.PRIOR_ART_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getPriorValue(valueCoded);
                if (ndrCode != null) {
                    hivQuestionsType.setPriorArt(ndrCode);
                }
            }
            obs = Utils.extractObs(166369, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setKPTypology(ndrCode);
                }
            }

            obs =  Utils.extractObs(Utils.MEDICAL_ELIGIBLE_DATE_CONCEPT,obsListId);
            if (obs != null) {
                valueDateTime = obs.getValueDate();
                hivQuestionsType.setMedicallyEligibleDate(utils.getXmlDate(valueDateTime));
            }
            obs =  Utils.extractObs(Utils.REASON_MEDICALLY_ELIGIBLE_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null) {
                    hivQuestionsType.setReasonMedicallyEligible(ndrCode);
                }
            }
            obs =  Utils.extractObs(Utils.DATE_INITIAL_ADHERENCE_COUNCELING_CONCEPT,obsListId);
            if (obs != null) {
                valueDateTime = obs.getValueDate();
                hivQuestionsType.setInitialAdherenceCounselingCompletedDate(utils.getXmlDate(valueDateTime));
            }

            obs =  Utils.extractObs(Utils.TRANSFERRED_IN_DATE,obsListId);
            if (obs != null) {
                valueDateTime = obs.getValueDate();
                hivQuestionsType.setTransferredInDate(utils.getXmlDate(valueDateTime));
            }
            obs =  Utils.extractObs(Utils.TRANSFERRED_IN_FROM,obsListId);
            if (obs != null) {
                String transferredInFromFacility = "";
                transferredInFromFacility = obs.getValueText();
                facilityType = new FacilityType();
                facilityType.setFacilityName(transferredInFromFacility);
                facilityType.setFacilityTypeCode("FAC");
                facilityType.setFacilityID(StringUtils.upperCase(transferredInFromFacility));
                hivQuestionsType.setTransferredInFrom(facilityType);
            }

            //change if form is updated
            obs =  Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                obs = Utils.extractObs(valueCoded, obsListId);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    if (ndrCode != null) {
                        cst = new RegimenCodedSimpleType();
                        cst.setCode(ndrCode);
                        cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        hivQuestionsType.setFirstARTRegimen(cst);
                    }
                }
            }

            Date artStartDate = Utils.extractARTStartDate(groupedpatientBaselineObsByConcept);
            if (artStartDate != null) {
                hivQuestionsType.setARTStartDate(utils.getXmlDate(artStartDate));
            }

            obs =  Utils.extractObs(Utils.WHO_CLINICAL_STAGGING_AT_START_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null) {
                    hivQuestionsType.setWHOClinicalStageARTStart(ndrCode);
                }
            }
            obs =  Utils.extractObs(160696,obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                valueNumericInt = obs.getValueNumeric().intValue();
                hivQuestionsType.setWeightAtARTStart(valueNumericInt);
            }
            obs =  Utils.extractObs(167595,obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                valueNumericInt = obs.getValueNumeric().intValue();
                hivQuestionsType.setHeightAtARTStart(valueNumericInt);
            }

            obs = Utils.extractObs(167596, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getHIVQuestionMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setPregnancyBFStatusAtStart(ndrCode);
                }
            }

            obs =  Utils.extractObs(Utils.FUNCTIONAL_STATUS_ART_START,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null) {
                    hivQuestionsType.setFunctionalStatusStartART(ndrCode);
                }
            }
            obs =  Utils.extractObs(Utils.CD4_AT_START,obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                valueNumericInt = obs.getValueNumeric().intValue();
                hivQuestionsType.setCD4AtStartOfART(String.valueOf(valueNumericInt));
            }

            obs = Utils.extractObs(167088, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setCD4LFA(ndrCode);
                }
            }

            //Discontinued Care
            obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.DISCONTINUED_CARE, obsList);
            if (obs != null) {
                hivQuestionsType.setStoppedTreatment(Boolean.TRUE);
                obs = Utils.extractObs(Utils.DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivQuestionsType.setReasonForStoppedTreatment(ndrCode);
                }
                obs = Utils.extractLastObs(Utils.DATE_OF_DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setDateStoppedTreatment(utils.getXmlDate(valueDateTime));
                }
            }

            obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.TRANSFERRED_OUT_CONCEPT, obsList);
            if (obs != null) {
                hivQuestionsType.setPatientTransferredOut(Boolean.TRUE);
                obs =  Utils.extractObs(Utils.TRANSFER_OUT_DATE,obsListId);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setTransferredOutDate(utils.getXmlDate(valueDateTime));

                    if (artStartDate != null) {
                        hivQuestionsType.setTransferredOutStatus("A");
                    } else {
                        hivQuestionsType.setTransferredOutStatus("P");
                    }
                }
            }


            obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.DEAD_CONCEPT, obsList);
            if (obs != null || patient.isDead() == true) {
                hivQuestionsType.setPatientHasDied(Boolean.TRUE);
                obs =  Utils.extractObs(Utils.DEATH_DATE_CONCEPT,obsListId);
                if (obs != null || patient.getDeathDate() != null) {
                    if(patient.getDeathDate() != null) {
                        hivQuestionsType.setDeathDate(utils.getXmlDate( patient.getDeathDate()));
                    }else{
                        assert obs != null;
                        valueDateTime = obs.getValueDate();
                        hivQuestionsType.setDeathDate(utils.getXmlDate(valueDateTime));
                    }
                }
            }

            /*obs = Utils.extractObs(165420, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue2(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setCauseOfDeath(ndrCode);
                }
            }*/

            //Causes of Death

            /*obs = Utils.extractObsByValues(Utils.CAUSE_OF_DEATH, Utils.ADULT_CASES_OF_DEATH, obsList);
            if (obs != null) {
                obs = Utils.extractObs(Utils.ADULT_CASES_OF_DEATH, obsListId);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    hivQuestionsType.setCauseOfDeath(ndrCodedValue);
                }
            }else{
                obs = Utils.extractObsByValues(Utils.CAUSE_OF_DEATH, Utils.CHILD_CASES_OF_DEATH, obsList);
                if (obs != null) {
                    obs = Utils.extractObs(Utils.CHILD_CASES_OF_DEATH, obsListId);
                    if (obs != null && obs.getValueCoded() != null) {
                        ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                        hivQuestionsType.setCauseOfDeath(ndrCodedValue);
                    }
                }
            }*/

            //Carecard 1d
            /*obs =  Utils.extractObs(Utils.TRANSFER_OUT_DATE,obsListId);
            if (obs != null) {
                hivQuestionsType.setPatientTransferredOut(Boolean.TRUE);
                valueDateTime = obs.getValueDate();
                if (artStartDate != null) {
                    hivQuestionsType.setTransferredOutStatus("A");
                } else {
                    hivQuestionsType.setTransferredOutStatus("P");
                }
                hivQuestionsType.setTransferredOutDate(utils.getXmlDate(valueDateTime));
            }

            obs =  Utils.extractObs(159495,obsListId);
            if (obs != null && obs.getValueText() != null) {
                String referredFacility = "";
                referredFacility = obs.getValueText();
                facilityType = new FacilityType();
                facilityType.setFacilityName(referredFacility);
                facilityType.setFacilityTypeCode("FAC");
                facilityType.setFacilityID(StringUtils.upperCase(referredFacility));
                hivQuestionsType.setFacilityReferredTo(facilityType);
            }

            obs =  Utils.extractObs(165418,obsListId);
            if (obs != null || patient.isDead() == true) {
                hivQuestionsType.setPatientHasDied(Boolean.TRUE);
            }

            obs =  Utils.extractObs(165418,obsListId);
            if (obs != null || patient.getDeathDate() != null) {
                if(patient.getDeathDate() != null) {
                    hivQuestionsType.setDeathDate(utils.getXmlDate( patient.getDeathDate()));
                }else{
                    assert obs != null;
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setDeathDate(utils.getXmlDate(valueDateTime));
                }
                obs =  Utils.extractObs(167485,obsListId);
                if (obs != null && obs.getValueText() != null) {
                    hivQuestionsType.setSourceOfDeathInformation(obs.getValueText());
                }
                //TODO Cuase of Death
                obs = Utils.extractObs(165420, obsListId);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCode = getMappedValue2(obs.getValueCoded().getConceptId());
                    if (ndrCode != null) {
                        hivQuestionsType.setCauseOfDeath(ndrCode);
                    }
                }
            }*/


            Date enrollmentDate = Utils.extractEnrollmentDate(patient, Utils.HIV_Enrollment_Encounter_Type_Id);
            if (enrollmentDate != null) {
                hivQuestionsType.setEnrolledInHIVCareDate(utils.getXmlDate(enrollmentDate));
            }

            obs =  Utils.extractObs(Utils.INITIAL_TB_STATUS, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                hivQuestionsType.setInitialTBStatus(ndrCode);
            }

            obs = Utils.extractObs(1264, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setTPTMedication(ndrCode);
                }
            }

            obs = Utils.extractObs(167526, obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                hivQuestionsType.setTPTDose(String.valueOf(obs.getValueNumeric()));
            }

            obs = Utils.extractObs(162320, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setTBTreatmentStartDate(utils.getXmlDate(obs.getValueDate()));
            }

            obs = Utils.extractObs(163284, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setTPTCompletionDate(utils.getXmlDate(obs.getValueDate()));
            }

            //TODO Stopped



            /*obs = Utils.extractObs(165309, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setSubstitutionWithin(ndrCode);
                }
            }*/

            Obs obsGroup = Utils.extractObs(165665, obsListId);
            if (obsGroup != null) {
                Set<Obs> members = obsGroup.getGroupMembers();
                if (members != null && !members.isEmpty()) {
                    List<Obs> memberList = new ArrayList<>(members);

                    // Substitution Within
                    Obs substObs = Utils.extractObsByConceptId(165309, memberList);
                    if (substObs != null && substObs.getValueCoded() != null) {
                        ndrCode = getMappedValue(substObs.getValueCoded().getConceptId());
                        if (ndrCode != null) {
                            hivQuestionsType.setSubstitutionWithin(ndrCode);
                        }
                    }

                    // Regimen Substitution Date
                    Obs dateObs = Utils.extractObsByConceptId(165292, memberList);
                    if (dateObs != null && dateObs.getValueDate() != null) {
                        hivQuestionsType.setRegimenSubstitutionDate(
                                utils.getXmlDate(dateObs.getValueDate()));
                    }

                    // Reason for Substitution
                    Obs reasonObs = Utils.extractObsByConceptId(165056, memberList);
                    if (reasonObs != null && reasonObs.getValueCoded() != null) {
                        ndrCode = getMappedValue(reasonObs.getValueCoded().getConceptId());
                        if (ndrCode != null) {
                            hivQuestionsType.setReasonForSubstitution(ndrCode);
                        }
                    }

                    Obs subobs = Utils.extractObsByConceptId(164515, memberList);
                    if (subobs != null && subobs.getValueCoded() != null) {
                        valueCoded = subobs.getValueCoded().getConceptId();
                        ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                        if (ndrCode != null) {
                            cst = new RegimenCodedSimpleType();
                            cst.setCode(ndrCode);
                            cst.setCodeDescTxt(subobs.getValueCoded().getName().getName());
                            hivQuestionsType.setNewRegimenAfterSubstitution(cst);
                        }
                    }
                }
            }

            Obs obsGroupSwitch = Utils.extractObs(165772, obsListId);
            if (obsGroupSwitch != null) {
                Set<Obs> members = obsGroupSwitch.getGroupMembers();
                if (members != null && !members.isEmpty()) {
                    List<Obs> memberList = new ArrayList<>(members);

                    // Switch To
                    Obs switchObs = Utils.extractObsByConceptId(165310, memberList);
                    if (switchObs != null && switchObs.getValueCoded() != null) {
                        ndrCode = getMappedValue(switchObs.getValueCoded().getConceptId());
                        if (ndrCode != null) {
                            hivQuestionsType.setSwitchTo(ndrCode);
                        }
                    }

                    // Regimen Switch Date
                    Obs dateObs = Utils.extractObsByConceptId(165292, memberList);
                    if (dateObs != null && dateObs.getValueDate() != null) {
                        hivQuestionsType.setRegimenSwitchDate(
                                utils.getXmlDate(dateObs.getValueDate()));
                    }

                    // Reason for Switch
                    Obs reasonObs = Utils.extractObsByConceptId(165056, memberList);
                    if (reasonObs != null && reasonObs.getValueCoded() != null) {
                        ndrCode = getMappedValue(reasonObs.getValueCoded().getConceptId());
                        if (ndrCode != null) {
                            hivQuestionsType.setReasonForSwitch(ndrCode);
                        }
                    }

                    Obs swiObs = Utils.extractObsByConceptId(164515, memberList);
                    if (swiObs != null && swiObs.getValueCoded() != null) {
                        valueCoded = swiObs.getValueCoded().getConceptId();
                        ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                        if (ndrCode != null) {
                            cst = new RegimenCodedSimpleType();
                            cst.setCode(ndrCode);
                            cst.setCodeDescTxt(swiObs.getValueCoded().getName().getName());
                            hivQuestionsType.setNewRegimenAfterSwitch(cst);
                        }
                    }
                }
            }


            obs = Utils.extractObs(167508, obsListId);
            if (obs != null && obs.getValueAsBoolean() != null) {
                hivQuestionsType.setDRGenotypingDone(getYNCodeTypeValue(obs.getValueCoded().getConceptId()));
            }

            obs = Utils.extractObs(167506, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setGenotypingSampleDate(utils.getXmlDate(obs.getValueDate()));
            }

            obs = Utils.extractObs(167007, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setGenotypingReceivedDate(utils.getXmlDate(obs.getValueDate()));
            }

            obs = Utils.extractObs(167504, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setDRResult(ndrCode);
                }
            }

            obs = Utils.extractObs(167494, obsListId);
            if (obs != null && obs.getValueText() != null) {
                hivQuestionsType.setIfDRResistant(obs.getValueText());
            }



            /*obs = Utils.extractObsByValues(165309, Utils.DISCONTINUED_CARE, obsList);
            if (obs != null) {
                hivQuestionsType.setStoppedTreatment(Boolean.TRUE);
                obs = Utils.extractObs(Utils.DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivQuestionsType.setReasonForStoppedTreatment(ndrCode);
                }
                obs = Utils.extractLastObs(Utils.DATE_OF_DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setDateStoppedTreatment(utils.getXmlDate(valueDateTime));
                }
            }*/

            /*

            obs = Utils.extractObs(Regimen_Substitution_Date_Concept_Id, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setRegimenSubstitutionDate(utils.getXmlDate(obs.getValueDate()));
            }

            obs = Utils.extractObs(Reason_For_Substitution_Concept_Id, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setReasonForSubstitution(ndrCode);
                }
            }

            obs = Utils.extractObs(Other_Reason_For_Substitution_Concept_Id, obsListId);
            if (obs != null && obs.getValueText() != null) {
                hivQuestionsType.setOtherReasonForSubstitution(obs.getValueText());
            }

            obs = Utils.extractObs(New_Regimen_After_Substitution_Concept_Id, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                if (ndrCode != null) {
                    RegimenCodedSimpleType subRegimen = new RegimenCodedSimpleType();
                    subRegimen.setCode(ndrCode);
                    subRegimen.setCodeDescTxt(obs.getValueCoded().getName().getName());
                    hivQuestionsType.setNewRegimenAfterSubstitution(subRegimen);
                }
            }

            obs = Utils.extractObs(Switch_To_Concept_Id, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setSwitchTo(ndrCode);
                }
            }

            obs = Utils.extractObs(Regimen_Switch_Date_Concept_Id, obsListId);
            if (obs != null && obs.getValueDate() != null) {
                hivQuestionsType.setRegimenSwitchDate(utils.getXmlDate(obs.getValueDate()));
            }

            obs = Utils.extractObs(Reason_For_Switch_Concept_Id, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                ndrCode = getMappedValue(obs.getValueCoded().getConceptId());
                if (ndrCode != null) {
                    hivQuestionsType.setReasonForSwitch(ndrCode);
                }
            }

            obs = Utils.extractObs(Other_Reason_For_Switch_Concept_Id, obsListId);
            if (obs != null && obs.getValueText() != null) {
                hivQuestionsType.setOtherReasonForSwitch(obs.getValueText());
            }

            obs = Utils.extractObs(New_Regimen_After_Switch_Concept_Id, obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                if (ndrCode != null) {
                    RegimenCodedSimpleType switchRegimen = new RegimenCodedSimpleType();
                    switchRegimen.setCode(ndrCode);
                    switchRegimen.setCodeDescTxt(obs.getValueCoded().getName().getName());
                    hivQuestionsType.setNewRegimenAfterSwitch(switchRegimen);
                }
            }

            */




            //Discontinued Care
            /*obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.DISCONTINUED_CARE, obsList);
            if (obs != null) {
                hivQuestionsType.setStoppedTreatment(Boolean.TRUE);
                obs = Utils.extractObs(Utils.DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = getMappedValue(valueCoded);
                    hivQuestionsType.setReasonForStoppedTreatment(ndrCode);
                }
                obs = Utils.extractLastObs(Utils.DATE_OF_DISCONTINUED_CARE, obsListId);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setDateStoppedTreatment(utils.getXmlDate(valueDateTime));
                }
            }*/

            /*obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.TRANSFERRED_OUT_CONCEPT, obsList);
            if (obs != null) {
                hivQuestionsType.setPatientTransferredOut(Boolean.TRUE);
                obs =  Utils.extractObs(Utils.TRANSFER_OUT_DATE,obsListId);
                if (obs != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setTransferredOutDate(utils.getXmlDate(valueDateTime));

                    if (artStartDate != null) {
                        hivQuestionsType.setTransferredOutStatus("A");
                    } else {
                        hivQuestionsType.setTransferredOutStatus("P");
                    }
                }
            }*/


            /*obs = Utils.extractObsByValues(Utils.REASON_FOR_TERMINATION_CONCEPT, Utils.DEAD_CONCEPT, obsList);
            if (obs != null || patient.isDead() == true) {
                hivQuestionsType.setPatientHasDied(Boolean.TRUE);
                obs =  Utils.extractObs(Utils.DEATH_DATE_CONCEPT,obsListId);
                if (obs != null || patient.getDeathDate() != null) {
                    if(patient.getDeathDate() != null) {
                        hivQuestionsType.setDeathDate(utils.getXmlDate( patient.getDeathDate()));
                    }else{
                        valueDateTime = obs.getValueDate();
                        hivQuestionsType.setDeathDate(utils.getXmlDate(valueDateTime));
                    }
                }
            }*/

            //Causes of Death
           /* obs = Utils.extractObsByValues(Utils.CAUSE_OF_DEATH, Utils.ADULT_CASES_OF_DEATH, obsList);
            if (obs != null) {
                obs = Utils.extractObs(Utils.ADULT_CASES_OF_DEATH, obsListId);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    hivQuestionsType.setCauseOfDeath(ndrCodedValue);
                }
            }else{
                obs = Utils.extractObsByValues(Utils.CAUSE_OF_DEATH, Utils.CHILD_CASES_OF_DEATH, obsList);
                if (obs != null) {
                    obs = Utils.extractObs(Utils.CHILD_CASES_OF_DEATH, obsListId);
                    if (obs != null && obs.getValueCoded() != null) {
                        ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                        hivQuestionsType.setCauseOfDeath(ndrCodedValue);
                    }
                }
            }*/

            /*obs = Utils.extractObs(Utils.CAUSE_OF_DEATH,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                hivQuestionsType.setCauseOfDeath(ndrCode);
                if (ndrCode != null) {
                    obs = Utils.extractObs(Utils.ADULT_CASES_OF_DEATH, obsListId);
                    if (obs != null && obs.getValueCoded() != null) {
                        ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                        hivQuestionsType.setCasesOfDeath(ndrCodedValue);
                    }else{
                        obs = Utils.extractObs(Utils.CHILD_CASES_OF_DEATH, obsListId);
                        if (obs != null && obs.getValueCoded() != null) {
                            ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                            hivQuestionsType.setCasesOfDeath(ndrCodedValue);
                        }
                    }
                }
            }*/
            /*
                Use date confirmed positve or visit date of the HIVEnrollmentForm
             */


      /*      obs = Utils.extractLastObs(Utils.PATIENT_CARE_IN_FACILITY_TERMINATED, obsNewList);
            if (obs != null && obs.getValueCoded() != null) {
                obs = Utils.extractObsByValues(Utils.PATIENT_CARE_IN_FACILITY_TERMINATED, Utils.PATIENT_TERMINATED, obsList);
                if (obs != null) {
                    hivQuestionsType.setStoppedTreatment(Boolean.TRUE);
                } else {
                    hivQuestionsType.setStoppedTreatment(Boolean.FALSE);
                }

                obs = Utils.extractLastObs(Utils.PATIENT_DATE_TERMINATED, obsNewList);
                if (obs != null && obs.getValueDate() != null) {
                    valueDateTime = obs.getValueDate();
                    hivQuestionsType.setDateStoppedTreatment(utils.getXmlDate(valueDateTime));
                }

                obs = Utils.extractLastObs(Utils.REASON_FOR_TERMINATION, obsNewList);
                if (obs != null && obs.getValueCoded() != null) {
                    ndrCodedValue = getMappedValue(obs.getValueCoded().getConceptId());
                    hivQuestionsType.setReasonForStoppedTreatment(ndrCodedValue);
                }
            }*/

            //hivQuestionsType.setStoppedTreatment();
            //hivQuestionsType.setDateStoppedTreatment();
            //hivQuestionsType.setReasonForStoppedTreatment();
        }
        return hivQuestionsType;
    }

    private String getMappedValue(int conceptID) {
        try {
            return map.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getPriorValue(int conceptID) {
        try {
            return artmap.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private String getMappedValue2(int conceptID) {
        try {
            return smap.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    private YNCodeType getYNCodeTypeValue(int key) {
        YNCodeType response = YNCodeType.NO;

        if (YNCodeTypeDict.containsKey(key)) {
            response = YNCodeTypeDict.get(key);
        }

        return response;
    }

    private String getHIVQuestionMappedValue(int conceptID) {
        try {
            return hivQuestionDictionary.get(conceptID);
        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            return "";
        }
    }

    public ConditionSpecificQuestionsType createConditionSpecificQuestionType(Patient patient, Map<Object, List<Obs>> groupedpatientBaselineObsByConcept,
                                                                              Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType) throws DatatypeConfigurationException {
        ConditionSpecificQuestionsType conditionSpecificQuestion = new ConditionSpecificQuestionsType();
        HIVQuestionsType hivQuestionType = createHIVQuestionType(patient, groupedpatientBaselineObsByConcept,
                groupedpatientBaselineObsByEncounterType);
        conditionSpecificQuestion.setHIVQuestions(hivQuestionType);
        return conditionSpecificQuestion;
    }
}
