/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.apache.commons.lang3.StringUtils;
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

    private static Map<Integer, String> map = new HashMap<>();

    private PharmacyDictionary pharmacyDictionary;
    NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
    NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);

    public NDRCommonQuestionsDictionary() {
        loadDictionary();
        pharmacyDictionary = new PharmacyDictionary();
    }
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

        //care entry point
        map.put(160539, "3"); //HTS
        map.put(160538, "9"); //ANC/PMTCT
        map.put(160536, "12"); //In Patient
        map.put(160537, "12");//Current Clinic Patient
        //map.put(160542, "2");//OPD

        map.put(160542, "1");//OPD
        map.put(160536, "2");// Inpatient
        map.put(160539, "3");//  VCT
        map.put(160541, "4"); //TB DOT
        map.put(160546, "5");//  STI Clinic
        map.put(160538, "6");//  ANC/PMTCT
        map.put(160563, "7");//  Transfer-in
        map.put(160545, "8");// Outreaches HIV enrollment
        map.put(165794, "9");// Index testing

        map.put(160541, "6");//TB DOTS
        map.put(160543, "4");//CBO
        map.put(160545, "4");//Outreaches
        map.put(160546, "1"); //STI
        //  map.put(5622, ""); //Other

        //Mode of HIV Test
        map.put(164949, "HIVAb");
        map.put(164948, "HIVPCR");

        //Prior ART Exposure
        map.put(1107, "N");
        map.put(165241, "E");
        map.put(165240, "P");
        map.put(165238, "T");
        map.put(165239, "T");
        //Reason Medically Eligible
        map.put(164426, "1");
        map.put(5497, "2");
        map.put(730, "3");
        map.put(164427, "4");

        //VA Causes of Death
        map.put(166348,"VAA");
        map.put(166347,"VAC");

        //Causes of Death
        map.put(166304,"B24");
        map.put(166305,"A09");
        map.put(166306,"B54");
        map.put(166307,"O95");
        map.put(166308,"B99");
        map.put(166309,"J22");
        map.put(166310,"A16");
        map.put(166311,"I24");
        map.put(166312,"C50");
        map.put(166313,"J44");
        map.put(166314,"C53");
        map.put(166315,"K74");
        map.put(166316,"C18");
        map.put(166317,"E14");
        map.put(166318,"C15");
        map.put(166319,"C96");
        map.put(166320,"C34");
        map.put(166321,"I99");
        map.put(166322,"UU1");
        map.put(166323,"C61");
        map.put(166324,"N18");
        map.put(166325,"C16");
        map.put(166326,"I64");
        map.put(166327,"C76");
        map.put(166331,"X27");
        map.put(166332,"W74");
        map.put(166350,"W19");
        map.put(166333,"X09");
        map.put(166334,"Y09");
        map.put(166335,"X58");
        map.put(122255,"X49");
        map.put(166336,"V89");
        map.put(125538,"X84");
        map.put(166339,"G04");
        map.put(166340,"A99");
        map.put(166328,"A41");
        map.put(166329,"G03");
        map.put(166330,"B05");
        map.put(166337,"UU2");
        map.put(166338,"K92");
        map.put(118350,"W19");
        map.put(166341,"P21");
        map.put(166342,"Q89");
        map.put(166343,"P36");
        map.put(166344,"P23");
        map.put(166345,"P07");
        map.put(166346,"P95");

        hivQuestionDictionary.put(165891, "1");
        hivQuestionDictionary.put(165892, "2");
        hivQuestionDictionary.put(5622, "3");
        hivQuestionDictionary.put(165890, "4");

    }

    public PatientDemographicsType createPatientDemographicsType(Patient pts, FacilityType facility, Map<Object, List<Obs>> groupedObsByEncounterTypes) throws DatatypeConfigurationException {
        /*
            PatientDemographicsType
              -PatientIdentifier
               -TreatmentFacility
  -OtherPatientIdentifiers
  -PatientDateOfBirth
  -PatientSexCode
  -PatientDeceasedIndicator
  -PatientDeceasedDate
  -PatientPrimaryLanguageCode
  -PatientEducationLevelCode
  -PatientOccupationCode
  -PatientMaritalStatusCode
  -StateOfNigeriaOriginCode
  -PatientNotes (NoteType)
  -FingerPrints
  -EnrolleeCode
  -TelephoneType
  -Extension
  -EmailAddress
  -TelephoneTypeCode

         */
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
                if(ancIds != null && ancIds.size() > 0){
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

            if(identifiersType.getIdentifier().size() > 0) {
                demo.setOtherPatientIdentifiers(identifiersType);
            }

            /*if (pidHospital != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidHospital.getIdentifier());
                idt.setIDTypeCode("HN"); //EDITED BY APIN TEAM
                identifiersType.getIdentifier().add(idt);
                *//*if(demo.getPatientIdentifier() == null){
                    demo.setPatientIdentifier(pidHospital.getIdentifier());
                }*//*
            }
            if (htsId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(htsId.getIdentifier());
                idt.setIDTypeCode("HTS");
                identifiersType.getIdentifier().add(idt);
                *//*if(demo.getPatientIdentifier() == null){
                    demo.setPatientIdentifier(htsId.getIdentifier());
                }*//*
            }

            if (ancId != null) {
                idt = new IdentifierType();
                idt.setIDNumber(ancId.getIdentifier());
                idt.setIDTypeCode("ANC");
                identifiersType.getIdentifier().add(idt);

            }else{
                List<String> ancIds = utils.getIds(groupedObsByEncounterTypes.get(ConstantsUtil.GENERAL_ANTENATAL_CARE_ENCOUNTER_TYPE),165567);
                if(ancIds != null && ancIds.size() > 0){
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
            if (pidOthers != null) {
                idt = new IdentifierType();
                idt.setIDNumber(pidOthers.getIdentifier());
                idt.setIDTypeCode("EID");  //EDITED BY APIN TEAM
                identifiersType.getIdentifier().add(idt);
            }

            if(identifiersType.getIdentifier().size() > 0) {
                demo.setOtherPatientIdentifiers(identifiersType);
            }

            if(demo.getPatientIdentifier() == null){
                return null;
            }*/

            if(pts.isVoided() && pepfarid != null){
                NigeriaPatientService nigeriaPatientService = Context.getService(NigeriaPatientService.class);
                List<Integer> patientIds = nigeriaPatientService.getPatientIdsByIdentifiersByType(pepfarid.getIdentifier(),4);
                if(patientIds.size() > 0) return null;
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
            Integer[] formEncounterTypeTargets = {Utils.ADULT_INITIAL_ENCOUNTER_TYPE, Utils.PED_INITIAL_ENCOUNTER_TYPE, Utils.INITIAL_ENCOUNTER_TYPE, Utils.HIV_Enrollment_Encounter_Type_Id, Utils.Client_Tracking_And_Termination_Encounter_Type_Id};

            List<Obs> obsListForEncounterTypesValues = Utils.extractObsList(groupedObsByEncounterTypes, Arrays.asList(formEncounterTypeTargets));


            List<Integer> obsCodeList = Arrays.asList(Utils.REASON_FOR_TERMINATION_CONCEPT,
                    Utils.DATE_OF_TERMINATION_CONCEPT,Utils.EDUCATIONAL_LEVEL_CONCEPT,
                    Utils.OCCUPATIONAL_STATUS_CONCEPT,Utils.MARITAL_STATUS_CONCEPT
            );
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
            if(obsList != null && obsList.size() >0) {
                List<Obs> obsnew = groupedObsByConcept.get(Utils.DEAD_CONCEPT);
                if (obsnew != null && obsnew.size() >0) {
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

    /*

HIVQuestionsType
 -CareEntryPoint (160540)
 -FirstConfirmedHIVTestDate(160554)
 -FirstHIVTestMode(164947)
 -WhereFirstHIVTest
 -PriorArt (165242)
 -MedicallyEligibleDate (162227)
 -ReasonMedicallyEligible (162225)
 -InitialAdherenceCounselingCompletedDate (165038)
 -TransferredInDate (160534)
 -TransferredInFrom (160535)
 -TransferredInFromPatId
 -FirstARTRegimen (165708)(164506,164513,165702,164507,164514,165703)
 -ARTStartDate (159599)
 -WHOClinicalStageARTStart (5356)
 -WeightAtARTStart (165582)
 -ChildHeightAtARTStart (165581)
 -FunctionalStatusStartART (165039)
 -CD4AtStartOfART (164429)
 -PatientTransferredOut (165470)(159492)
 -TransferredOutStatus(165470)(159492)
 -TransferredOutDate (165469)
 -FacilityReferredTo
 -PatientHasDied (165470)(165889)
 -StatusAtDeath
 -DeathDate(165469)
 -SourceOfDeathInformation (162568)
 -CauseOfDeathHIVRelated (165889,(165886,165887)) (163534,Yes(1065),No(1066))
 -DrugAllergies (165419)
 -EnrolledInHIVCareDate
 -InitialTBStatus (1659)
     */
    public HIVQuestionsType createHIVQuestionType(Patient patient, Map<Object, List<Obs>> groupedpatientBaselineObsByConcept,
                                                  Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType) throws DatatypeConfigurationException {
        Integer[] targetEncounterTypes = {Utils.HIV_Enrollment_Encounter_Type_Id, Utils.ART_COMMENCEMENT_ENCOUNTER_TYPE, Utils.Client_Tracking_And_Termination_Encounter_Type_Id};
        HIVQuestionsType hivQuestionsType = null;
        List<Obs> obsList = Utils.extractObsList(groupedpatientBaselineObsByEncounterType, Arrays.asList(targetEncounterTypes));
        List<Integer> obsNewList = obsList.stream().map(Obs::getObsId).collect(Collectors.toList());
        Obs obs;
        int valueCoded, valueNumericInt;
        String ndrCodedValue;

        Date valueDateTime;
        String ndrCode;
        FacilityType facilityType;
        CodedSimpleType cst;

        List<Integer> obsCodeList = Arrays.asList(Utils.CARE_ENTRY_POINT_CONCEPT,Utils.DATE_OF_HIV_DIAGNOSIS_CONCEPT,
                Utils.MODE_OF_HIV_TEST,Utils.PRIOR_ART_CONCEPT,Utils.MEDICAL_ELIGIBLE_DATE_CONCEPT,Utils.REASON_MEDICALLY_ELIGIBLE_CONCEPT,
                Utils.DATE_INITIAL_ADHERENCE_COUNCELING_CONCEPT,Utils.TRANSFERRED_IN_DATE,Utils.TRANSFERRED_IN_FROM,
                Utils.CURRENT_REGIMEN_LINE_CONCEPT,Utils.WHO_CLINICAL_STAGGING_AT_START_CONCEPT,Utils.WEIGHT_AT_START_CONCEPT,
                Utils.CHILD_HEIGHT_AT_START, Utils.CHILD_HEIGHT_AT_START,Utils.FUNCTIONAL_STATUS_ART_START,
                Utils.CD4_AT_START,Utils.TRANSFER_OUT_DATE,Utils.INITIAL_TB_STATUS);

        Map<Object, List<Obs>> obsListId = Utils.groupedByConceptIdsOnly(obsList);

        if (!obsList.isEmpty()) {
            hivQuestionsType = new HIVQuestionsType();
            obs =  Utils.extractObs(Utils.CARE_ENTRY_POINT_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null){
                    if (!ndrCode.equals("")) {
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
                    if (!ndrCode.equals("")) {
                        hivQuestionsType.setFirstHIVTestMode(ndrCode);
                    }
                }
            }
            // Where first tested positive missing

            obs =  Utils.extractObs(Utils.PRIOR_ART_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                ndrCode = getMappedValue(valueCoded);
                if (ndrCode != null) {
                    hivQuestionsType.setPriorArt(ndrCode);
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
            //Need to create a transferred in patient id
            obs =  Utils.extractObs(Utils.CURRENT_REGIMEN_LINE_CONCEPT,obsListId);
            if (obs != null && obs.getValueCoded() != null) {
                valueCoded = obs.getValueCoded().getConceptId();
                obs = Utils.extractObs(valueCoded, obsListId);
                if (obs != null && obs.getValueCoded() != null) {
                    valueCoded = obs.getValueCoded().getConceptId();
                    ndrCode = pharmacyDictionary.getRegimenMapValue(valueCoded);
                    if (ndrCode != null) {
                        cst = new CodedSimpleType();
                        cst.setCode(ndrCode);
                        cst.setCodeDescTxt(obs.getValueCoded().getName().getName());
                        hivQuestionsType.setFirstARTRegimen(cst);
                    }

                }
            }
            Date artStartDate = Utils.extractARTStartDate(groupedpatientBaselineObsByConcept);//Obs(Utils.ART_START_DATE_CONCEPT, obsList);
            if (artStartDate != null) {
                //valueDateTime=obs.getValueDate();
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
            obs =  Utils.extractObs(Utils.WEIGHT_AT_START_CONCEPT,obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                valueNumericInt = obs.getValueNumeric().intValue();
                hivQuestionsType.setWeightAtARTStart(valueNumericInt);
            }
            obs =  Utils.extractObs(Utils.CHILD_HEIGHT_AT_START,obsListId);
            if (obs != null && obs.getValueNumeric() != null) {
                valueNumericInt = obs.getValueNumeric().intValue();
                hivQuestionsType.setChildHeightAtARTStart(valueNumericInt);
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
                        valueDateTime = obs.getValueDate();
                        hivQuestionsType.setDeathDate(utils.getXmlDate(valueDateTime));
                    }
                }
            }

            //Causes of Death
            obs = Utils.extractObsByValues(Utils.CAUSE_OF_DEATH, Utils.ADULT_CASES_OF_DEATH, obsList);
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
            }

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
