package org.openmrs.module.nigeriaemr.ndrfactory;

import com.umb.ndr.signer.Signer;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PersonAddress;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.omodmodels.Version;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class NDRConverter {

    Utils utils = new Utils();

    private Patient patient;

    private Map<Integer, List<Encounter>> groupedEncounters = new HashMap<>();

    private Map<String, List<Encounter>> groupedEncountersByUUID = new HashMap<>();

    private Map<Object, List<Obs>> groupedObsByConceptIds = new HashMap<>();

    private Map<Object, List<Obs>> groupedObsByEncounterTypes = new HashMap<>();

    private Map<Object, List<Obs>> groupedObsByVisitDate = new HashMap<>();

    private Encounter lastEncounter;

    private final DBConnection openmrsConn;

    private Map<Object, List<Obs>> groupedpatientBaselineObsByConcept = new HashMap<>();

    private Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType = new HashMap<>();

    private final NigeriaEncounterService nigeriaEncounterService;

    private final NigeriaObsService nigeriaObsService;

    private final Date fromDate;

    private final Date toDate;

    NDRMainDictionary mainDictionary;

    public NDRConverter(DBConnection _openmrsConn, Date fromDate, Date toDate) {
        this.openmrsConn = _openmrsConn;
        this.nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.nigeriaObsService = Context.getService(NigeriaObsService.class);
        mainDictionary = new NDRMainDictionary();
    }

    public Container createContainer(Patient pts) throws Exception {
        String facilityName = Utils.getFacilityName();
        String DATIMID = Utils.getFacilityDATIMId();
        String FacilityType = "FAC";
        boolean hasUpdate = false;

        try {
            patient = pts;
            if(!pts.isVoided()) {
               List<Integer> encounterIds = nigeriaObsService.getPatientEncounterIdsByDate(pts.getId(), this.fromDate, this.toDate);
                if(encounterIds != null && encounterIds.size() > 0) {
                    List<Encounter> filteredEncounters = nigeriaEncounterService.getEncountersByEncounterIds(encounterIds);
                    if (filteredEncounters == null || filteredEncounters.isEmpty()) {
                        return null;
                    }
                    List<Encounter> encounters = new ArrayList<>(filteredEncounters);
                    this.lastEncounter = filteredEncounters.get(filteredEncounters.size() - 1);
                    this.groupedEncounters = Utils.extractEncountersByEncounterTypesId(encounters);
                    this.groupedEncountersByUUID = Utils.extractEncountersByEncounterTypesUUID(encounters);

                    List<Obs> allobs = Utils.extractObsfromEncounter(filteredEncounters);
                    Map<String, Map<Object, List<Obs>>> grouped = Utils.groupObs(allobs);
                    this.groupedObsByConceptIds = grouped.get("groupedByConceptIds");
                    this.groupedObsByEncounterTypes = grouped.get("groupedByEncounterTypes");
                    this.groupedObsByVisitDate = grouped.get("groupedObsByVisitDate");
                    List<Obs> patientBaselineObs = Context.getObsService().getObservationsByPerson(patient);
                    Map<String, Map<Object, List<Obs>>> groupedPatientBaseLine = Utils.groupObs(patientBaselineObs);
                    this.groupedpatientBaselineObsByConcept = groupedPatientBaseLine.get("groupedByConceptIds");
                    this.groupedpatientBaselineObsByEncounterType = groupedPatientBaseLine.get("groupedByEncounterTypes");

                    if (filteredEncounters.size() > 0)
                        for(Encounter enc: filteredEncounters){
                            Date newToDate = this.toDate;
                            if(newToDate == null) newToDate = new Date();
                            int dateCreatedComp = enc.getDateCreated().compareTo(newToDate);
                            int dateModifiedComp = -1;
                            if (enc.getDateChanged() != null) {
                                dateModifiedComp = enc.getDateChanged().compareTo(newToDate);
                            }
                            if(dateCreatedComp <= -1 && dateModifiedComp <= -1){
                                hasUpdate = true;
                                break;
                            }
                        }
                }
            }

            MessageHeaderType header = createMessageHeaderType(pts, hasUpdate);
            org.openmrs.module.nigeriaemr.model.ndr.FacilityType sendingOrganization = Utils.createFacilityType(facilityName, DATIMID, FacilityType);
            header.setMessageSendingOrganization(sendingOrganization);

            Container container = new Container();
            container.setMessageHeader(header);

            IndividualReportType individualReportType = createIndividualReportType();

            if (individualReportType == null) {
                return null;
            }

            container.setIndividualReport(individualReportType);

            this.lastEncounter = null;
            this.groupedEncounters = null;
            this.groupedObsByConceptIds = null;
            this.groupedObsByEncounterTypes = null;
            this.groupedObsByVisitDate = null;
            this.groupedpatientBaselineObsByConcept =null;
            this.groupedpatientBaselineObsByEncounterType = null;

            return container;
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
            throw ex;
        }
    }

    private IndividualReportType createIndividualReportType() {

        IndividualReportType individualReport = new IndividualReportType();
        String facilityName = Utils.getFacilityName();
        String DATIMID = Utils.getFacilityDATIMId();
        FacilityType facility = Utils.createFacilityType(facilityName,DATIMID,"FAC");
        try {
            PatientDemographicsType patientDemography = new NDRMainDictionary().createPatientDemographicType2(patient,facility, this.groupedObsByEncounterTypes);
            if (patientDemography == null) { //return null if no valid patient data exist
                return null;
            }
            individualReport.setPatientDemographics(patientDemography);

            //create hiv condition type with code "86406008"
            ConditionType condition = createHIVCondition();
            individualReport.getCondition().add(condition);

            PMTCTType pmtctType = createPmtctType();

            if(pmtctType != null){
                individualReport.setPmtctType(pmtctType);
            }

            TBType tbType = createtbType();
            if(tbType != null){
                individualReport.setTB(tbType);
            }

            //retrieve latest encounter for client intake form
            Encounter intakeEncounter = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.ADMISSION_ENCOUNTER_TYPE));
            Encounter intakeEncounterV2 = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.ADMISSION_ENCOUNTER_TYPE_V2));

            if (intakeEncounter != null) {
                retriveCreateHIVTestingReport(intakeEncounter, individualReport);
            }else if (intakeEncounterV2 != null){
                retriveCreateHIVTestingReport(intakeEncounterV2,  individualReport);
            }

            Encounter recencyEncounter = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.RECENCY_ENCOUNTER_TYPE));

            if(recencyEncounter !=null){
                retriveCreateRecencyType(recencyEncounter, individualReport);
            }
            Encounter mortalityEncounter = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.MORTALITY_ENCOUNTER_TYPE));
            if(mortalityEncounter !=null){
                retriveCreateMortalityType(mortalityEncounter, individualReport);
            }

            return individualReport;

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LogLevel.live);
            // throw ex;
        }

        return individualReport;
    }

    private void retriveCreateMortalityType(Encounter mortalityEncounter, IndividualReportType individualReport) {
        List<Obs> mortalityObs = new ArrayList<>(mortalityEncounter.getAllObs());
        Map<Object, List<Obs>> groupedmortalityObsByConcept = Utils.groupedByConceptIdsOnly(mortalityObs);
        try {
            List<MortalityType> mortalityTypes = createMortalitytypes(mortalityEncounter, groupedmortalityObsByConcept);
            individualReport.getMortality().addAll(mortalityTypes);
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }
    }

    private List<MortalityType> createMortalitytypes(Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept) {
        NDRMainDictionary mainDictionary = new NDRMainDictionary();
        List<MortalityType> mortalityList = new ArrayList<>();
        try {
            //for each testing to the following
            MortalityType mortality = new MortalityType();
            mortality = mainDictionary.createMortalityType(patient, encounter, groupedObsByConcept,groupedpatientBaselineObsByEncounterType, mortality);
            mortalityList.add(mortality);
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.toString(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }

        return mortalityList;
    }

    private void retriveCreateRecencyType(Encounter recencyEncounter, IndividualReportType individualReport){
        List<Obs> intakeObs = new ArrayList<>(recencyEncounter.getAllObs());
        Map<Object, List<Obs>> groupedintakeObsByConcept = Utils.groupedByConceptIdsOnly(intakeObs);
        try {
            List<RecencyType> recencyTypes = createRecency(recencyEncounter, groupedintakeObsByConcept);
            individualReport.getRecency().addAll(recencyTypes);

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }

    }

    private List<RecencyType> createRecency(Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept) {
        PartnerInformationType partnerInformationType = new PartnerInformationType();
        List<RecencyType> recencyList = new ArrayList<>();
        try {
            //for each testing to the following
            RecencyType recency = new RecencyType();
            recency = mainDictionary.createRecency(patient, encounter, groupedObsByConcept, recency);
            List<PartnerInformationType> partnerInformationTypes = mainDictionary.createPartnerInformationType(groupedObsByConcept);
            if (partnerInformationTypes != null && partnerInformationTypes.size() > 0) {
                partnerInformationType = partnerInformationTypes.get(0);
            }
            recency.setPartnerInformation(partnerInformationTypes);
            recencyList.add(recency);
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.toString(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }
        return recencyList;
    }

    private void retriveCreateHIVTestingReport(Encounter intakeEncounter, IndividualReportType individualReport){
        List<Obs> intakeObs = new ArrayList<>(intakeEncounter.getAllObs());
        Map<Object, List<Obs>> groupedintakeObsByConcept = Utils.groupedByConceptIdsOnly(intakeObs);
        try {
            List<HIVTestingReportType> hivReportTypes = createHIVTestingReport(intakeEncounter, groupedintakeObsByConcept);
            individualReport.getHIVTestingReport().addAll(hivReportTypes);
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }
    }

    private PMTCTType createPmtctType() {
        NDRMainDictionary mainDictionary = new NDRMainDictionary();
        PMTCTType pmtctType = null;
        List<Encounter> pmtctEncounters = this.groupedEncounters.get(ConstantsUtil.MATERNAL_COHORT_TYPE);
        List<Encounter> generalAntenatalCareEncounters = this.groupedEncounters.get(ConstantsUtil.GENERAL_ANTENATAL_CARE_ENCOUNTER_TYPE);
        List<Encounter> deliverRegisterEncounters = this.groupedEncounters.get(ConstantsUtil.DELIVERY_REGISTER_ENCOUNTER_TYPE);
        List<Encounter> childFollowUpEncounters = this.groupedEncounters.get(ConstantsUtil.CHILD_FOLLOW_UP);
        List<Encounter> childBirthEncounters = this.groupedEncounters.get(ConstantsUtil.CHILD_BIRTH_REGISTRATION_ENCOUNTER);
        List<Encounter> partnerEncounters = this.groupedEncounters.get(ConstantsUtil.PARTNER_REGISTER);
        List<Encounter> pmtctHtsRegisterEncounters = this.groupedEncountersByUUID.get(ConstantsUtil.PMTCT_HTS_REGISTER);
        List<Encounter> pmtctRegistrationEncounters = this.groupedEncounters.get(ConstantsUtil.PMTCT_REGISTRATION_ENCOUNTER);

        if(pmtctEncounters != null) {
            List<MaternalCohortType> maternalCohortTypes =  mainDictionary.createMaternalCohort(pmtctEncounters);
            if(maternalCohortTypes != null){
                pmtctType = new PMTCTType();
                pmtctType.setMaternalCohortTypes(maternalCohortTypes);
            }
            List<HealthFacilityVisitsType> healthFacilityVisitTypes = mainDictionary.createHealthFacilityVisits(
                    pmtctEncounters);
            if (healthFacilityVisitTypes != null && healthFacilityVisitTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setHealthFacilityVisitTypes(healthFacilityVisitTypes);
            }
        }
        if(childFollowUpEncounters != null){
            List<ChildFollowupType> childFollowupTypes = mainDictionary.createChildFollowupType(childFollowUpEncounters);
            if (childFollowupTypes != null && childFollowupTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setChildFollowupTypes(childFollowupTypes);
            }

            List<InfantPCRTestingType> infantPCRTestingTypes = mainDictionary.createInfantPCRTestingType(childFollowUpEncounters);
            if (infantPCRTestingTypes != null && infantPCRTestingTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setInfantPCRTestingTypes(infantPCRTestingTypes);
            }

            List<InfantRapidTestType> infantRapidTestTypes = mainDictionary.createInfantRapidTestType(childFollowUpEncounters);
            if (infantRapidTestTypes != null && infantRapidTestTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setInfantRapidTestTypes(infantRapidTestTypes);
            }

//            List<ImmunizationType> immunizationTypes = mainDictionary.createImmunizationType(pmtctEncounters);
//            if (immunizationTypes != null && immunizationTypes.size() > 0) {
//                if (pmtctType == null) pmtctType = new PMTCTType();
//                pmtctType.setImmunizationTypes(immunizationTypes);
//            }

        }
        if(generalAntenatalCareEncounters != null){
            List<PMTCTHTSType> pmtctTHTSType =  mainDictionary.createPMTCTHTS(generalAntenatalCareEncounters);
            if(pmtctTHTSType != null) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setPmtctHTSTYPES(pmtctTHTSType);
            }
            List<AntenatalRegistrationType> antenatalRegistrationTypes = mainDictionary.createAntenatalRegistrationType(
                    generalAntenatalCareEncounters);
            if (antenatalRegistrationTypes != null && antenatalRegistrationTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setAntenatalRegistrationTypes(antenatalRegistrationTypes);
            }
        }

        if(pmtctHtsRegisterEncounters != null){
            List<PMTCTHTSType> pmtctTHTSType =  mainDictionary.createPMTCTHTS(pmtctHtsRegisterEncounters);
            if(pmtctTHTSType != null) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                if(pmtctType.getPmtctHTSTYPES() != null && pmtctType.getPmtctHTSTYPES().size() > 0){
                    pmtctTHTSType.addAll(pmtctType.getPmtctHTSTYPES());
                }
                pmtctType.setPmtctHTSTYPES(pmtctTHTSType);
            }
        }

        /*if(pmtctRegistrationEncounters != null){
            List<PMTCTRegistrationType> pmtctRegistrationTypes =  mainDictionary.createPMTCTRegistration(pmtctRegistrationEncounters);
            if(pmtctRegistrationTypes != null) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                if(pmtctType.getPMTCTRegistration() != null && pmtctType.getPMTCTRegistration().size() > 0){
                    pmtctRegistrationTypes.addAll(pmtctType.getPMTCTRegistration());
                }
                pmtctType.setPMTCTRegistration(pmtctRegistrationTypes);
            }
        }*/

        if(childBirthEncounters != null){
            List<ChildBirthDetailsType> childBirthDetailsTypes = mainDictionary.createChildBirthDetailsType(
                    childBirthEncounters);
            if (childBirthDetailsTypes != null && childBirthDetailsTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setChildBirthDetailsTypes(childBirthDetailsTypes);
            }
        }

        if(deliverRegisterEncounters != null){
            List<DeliveryEncounterType> deliveryEncounterTypes = mainDictionary.createDeliveryEncounterType(
                    deliverRegisterEncounters);
            if (deliveryEncounterTypes != null && deliveryEncounterTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setDeliveryEncounterTypes(deliveryEncounterTypes);
            }
        }

        if(partnerEncounters != null){
            List<PartnerDetailsType> partnerDetailsTypes = mainDictionary.createPartnerDetailsType(
                    partnerEncounters);
            if (partnerDetailsTypes != null && partnerDetailsTypes.size() > 0) {
                if (pmtctType == null) pmtctType = new PMTCTType();
                pmtctType.setPartnerDetailsTypes(partnerDetailsTypes);
            }
        }

        return pmtctType;
    }

    private TBType createtbType() {
        NDRMainDictionary mainDictionary = new NDRMainDictionary();
        TBType tbType = null;
        List<Encounter> tbScreeningEncounters = this.groupedEncounters.get(ConstantsUtil.TB_SCREENING_ENCOUNTER_TYPE);
        List<Encounter> tbCommunityAndFacilityReferralEncounters = this.groupedEncounters.get(ConstantsUtil.TB_COMM_FAC_ENCOUNTER_TYPE);
        List<Encounter> tbIndexContactEncounters = this.groupedEncounters.get(ConstantsUtil.TB_INDEX_CONTACT_ENCOUNTER_TYPE);
        List<Encounter> presumptiveTBRegisterEncounters = this.groupedEncounters.get(ConstantsUtil.PRESUMPTIVE_TB_REGISTER_ENCOUNTER_TYPE);
        List<Encounter> drTreatmentRegisterTypeEncounters = this.groupedEncounters.get(ConstantsUtil.DRTB_TREATMENT_ENCOUNTER_TYPE);
        List<Encounter> drtbInPatientDischargeEncounters = this.groupedEncounters.get(ConstantsUtil.DRTB_DISCHARGE_ENCOUNTER_TYPE);
        List<Encounter> tBInterruptionTrackingEncounters = this.groupedEncounters.get(ConstantsUtil.TB_TRACKING_ENCOUNTER_TYPE);
        List<Encounter> tBLaboratoryRegisterEncounters = this.groupedEncounters.get(ConstantsUtil.TB_LAB_REGISTER_ENCOUNTER_TYPE);
        List<Encounter> lGAHealthFacilityTypeEncounters = this.groupedEncounters.get(ConstantsUtil.TB_LGA_HEALTH_REGISTER_ENCOUNTER_TYPE);
        List<Encounter> specimenExaminationRequestEncounters = this.groupedEncounters.get(ConstantsUtil.SPECIMEN_REQUEST_ENCOUNTER_TYPE);
        List<Encounter> specimenExaminationResultEncounters = this.groupedEncounters.get(ConstantsUtil.SPECIMEN_RESULT_ENCOUNTER_TYPE);
        List<Encounter> tbTreatmentMonitoringTypeEncounters = this.groupedEncounters.get(ConstantsUtil.TB_MONITORING_ENCOUNTER_TYPE);
        List<Encounter> iptMonitoringEncounters = this.groupedEncounters.get(ConstantsUtil.IPT_MONITORING_ENCOUNTER_TYPE);
        List<Encounter> tBPatientReferralEncounters = this.groupedEncounters.get(ConstantsUtil.TB_REFERRAL_ENCOUNTER_TYPE);
        List<Encounter> tbTreatmentCardEncounters = this.groupedEncounters.get(ConstantsUtil.TB_TREATMENT_CARD_ENCOUNTER_TYPE);



        if(tbScreeningEncounters != null){
            List<TBScreeningType> tbScreeningEncounterTypes = mainDictionary.createTbScreeningEncounterType(
                    patient,tbScreeningEncounters);
            if (tbScreeningEncounterTypes != null && tbScreeningEncounterTypes.size() > 0) {
                tbType = new TBType();
                System.out.println("TBType Screening Type");
                tbType.setScreening(tbScreeningEncounterTypes);
            }
        }
        if(tbCommunityAndFacilityReferralEncounters != null){
            List<TBCommunityAndFacilityReferralType> tbCommunityAndFacilityReferralEncounterTypes = mainDictionary.createTbComFacRefEncounterType(tbCommunityAndFacilityReferralEncounters);
            if (tbCommunityAndFacilityReferralEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TBType Screening Type");
                tbType.setCommunityAndFacilityReferral(tbCommunityAndFacilityReferralEncounterTypes);
            }
        }
        if(tbIndexContactEncounters != null){
            List<TBIndexPatientContactInvestigationType> tbIndexContactEncounterTypes = mainDictionary.createTbIndexContactEncounterType(tbIndexContactEncounters);
            if (tbIndexContactEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TBType Contact Type");
                tbType.setIndexPatientContactInvestigation(tbIndexContactEncounterTypes);
            }
        }

        if(presumptiveTBRegisterEncounters != null){
            List<PresumptiveTBRegisterType> presumptiveTBRegisterEncounterTypes = mainDictionary.createPresumptiveTBRegisterEncounterTypes(patient,presumptiveTBRegisterEncounters);
            if (presumptiveTBRegisterEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("presumptiveTBRegisterEncounters started");
                tbType.setPresumptiveTBRegister(presumptiveTBRegisterEncounterTypes);
            }
        }

        if(drTreatmentRegisterTypeEncounters != null){
            List<DRTBTreatmentRegisterType> drTreatmentRegisterTypeEncounterTypes = mainDictionary.createDRTBTreatmentRegisterEncounterTypes(patient,drTreatmentRegisterTypeEncounters);
            if (drTreatmentRegisterTypeEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("DR-TB Reg started");
                tbType.setDRTBTreatmentRegister(drTreatmentRegisterTypeEncounterTypes);
            }
        }

        if(drtbInPatientDischargeEncounters != null){
            List<DRTBInPatientDischargeFormType> drtbInPatientDischargeEncountersTypes = mainDictionary.createDrTBDischargeEncounterTypes(drtbInPatientDischargeEncounters);
            if (drtbInPatientDischargeEncountersTypes != null) {
                if (tbType == null) tbType = new TBType();
                tbType.setDRTBInPatientDischargeForm(drtbInPatientDischargeEncountersTypes);
            }
        }

        if(tBInterruptionTrackingEncounters != null){
            List<TBInterruptionTrackingType> tBInterruptionTrackingEncountersTypes = mainDictionary.createTBInterruptionTrackingEncounterTypes(tBInterruptionTrackingEncounters);
            if (tBInterruptionTrackingEncountersTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TB Tracking");
                tbType.setInterruptionTracking(tBInterruptionTrackingEncountersTypes);
            }
        }

        if(tBLaboratoryRegisterEncounters != null){
            List<TBLaboratoryRegisterType> tBLaboratoryRegisterEncountersTypes = mainDictionary.createTBLaboratoryRegisterTypeEncounterTypes(tBLaboratoryRegisterEncounters);
            if (tBLaboratoryRegisterEncountersTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TB Lab");
                tbType.setLaboratoryRegister(tBLaboratoryRegisterEncountersTypes);
            }
        }

        if(lGAHealthFacilityTypeEncounters != null){
            List<LGAHealthFacilityTBCentralRegisterType> lGAHealthFacilityTypeEncounterTypes = mainDictionary.createLGAHealthFacilityTBCentralRegisterEncounterTypes(lGAHealthFacilityTypeEncounters);
            if (lGAHealthFacilityTypeEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TB LGA Health Facility");
                tbType.setLGAHealthFacilityTBCentralRegister(lGAHealthFacilityTypeEncounterTypes);
            }
        }

        if(specimenExaminationRequestEncounters != null){
            List<SpecimenExaminationRequestFormType> specimenExaminationRequestFormEncounterTypes = mainDictionary.createspecimenrequestEncounterType(specimenExaminationRequestEncounters);
            if (specimenExaminationRequestFormEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("Specimen request");
                tbType.setSpecimenExaminationRequestForm(specimenExaminationRequestFormEncounterTypes);
            }
        }

        if(specimenExaminationResultEncounters != null){
            List<SpecimenExaminationResultFormType> specimenExaminationResultFormEncounterTypes = mainDictionary.createspecimenresultEncounterType(specimenExaminationResultEncounters);
            if (specimenExaminationResultFormEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("Specimen result");
                tbType.setSpecimenExaminationResultForm(specimenExaminationResultFormEncounterTypes);
            }
        }

        if(tbTreatmentMonitoringTypeEncounters != null){
            List<TBTreatmentMonitoringType> tbTBMonitoringEncounterTypes = mainDictionary.createTBTreatmentMonitoringEncounterType(tbTreatmentMonitoringTypeEncounters);
            if (tbTBMonitoringEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                System.out.println("TBType Contact Type");
                tbType.setTreatmentMonitoring(tbTBMonitoringEncounterTypes);
            }
        }

        if (iptMonitoringEncounters != null) {
            List<TBScreeningIPTmonitoringType> iptMonitoringEncounterTypes = mainDictionary.createiptMonitoringEncounterType(
                    patient, iptMonitoringEncounters);
            if (iptMonitoringEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                tbType.setTBScreeningIPTmonitoringType(iptMonitoringEncounterTypes);
            }
        }

        if (tBPatientReferralEncounters != null) {
            List<TBPatientReferralType> tBPatientReferralEncounterTypes = mainDictionary.createTBPatientReferralEncounterType(tBPatientReferralEncounters);
            if (tBPatientReferralEncounterTypes != null) {
                if (tbType == null) tbType = new TBType();
                tbType.setPatientReferralType(tBPatientReferralEncounterTypes);
            }
        }

        /*if (tbTreatmentCardEncounters != null) {
            List<TBPatientTreatmentCardFormType> tbTreatmentCardEncountersTypes = mainDictionary.createTBCardEncounterType(tbTreatmentCardEncounters);
            if (tbTreatmentCardEncountersTypes != null) {
                if (tbType == null) tbType = new TBType();
                tbType.setTBPatientTreatmentCardForm(tbTreatmentCardEncountersTypes);
            }
        }*/

        return tbType;
    }


    private List<HIVTestingReportType> createHIVTestingReport(Encounter encounter, Map<Object, List<Obs>> groupedObsByConcept) {

        //TODO: pull hivtestReport as a list
        NDRMainDictionary mainDictionary = new NDRMainDictionary();

        List<HIVTestingReportType> hivTestingReportList = new ArrayList<>();

        try {

            //for each testing to the following
            HIVTestingReportType hivTestingReport = new HIVTestingReportType();
            PreTestInformationType preTestInfo = new PreTestInformationType();
            PostTestCounsellingType postTestType = new PostTestCounsellingType();

            hivTestingReport = mainDictionary.createHIVTestIntake(patient, encounter, groupedObsByConcept, hivTestingReport);

            HIVTestResultType hIVTestResultType = mainDictionary.createHIVTestResult(patient, groupedObsByConcept);

            IndexNotificationServicesType indexNotificationServicesType = mainDictionary.createIndexNotificationServicesTypes(groupedObsByConcept);

            if (hIVTestResultType != null) {
                hivTestingReport.setHIVTestResult(hIVTestResultType);
            }

            if (indexNotificationServicesType != null) {
                hivTestingReport.setIndexNotificationServices(indexNotificationServicesType);
            }

            //create TB screening
            List<ClinicalTBScreeningType> clinicalTBScreeningType = mainDictionary.createClinicalTbScreening(patient,
                    groupedObsByConcept);

            if (clinicalTBScreeningType != null && !clinicalTBScreeningType.isEmpty()) {

                preTestInfo.setClinicalTBScreening(clinicalTBScreeningType.get(0));
            }

            //HIV Risk assessment
            List<HIVRiskAssessmentType> hivRiskAssessmentType = mainDictionary.createHivRiskAssessment(patient,
                    this.groupedObsByConceptIds);
            if (hivRiskAssessmentType != null && !hivRiskAssessmentType.isEmpty()) {
                preTestInfo.setHIVRiskAssessment(hivRiskAssessmentType.get(0));
            }

            //knowledge assessment
            //Knowledge Assessment Type
            List<KnowledgeAssessmentType> knowledgeAssessmentType = mainDictionary.createKnowledgeAssessmentType(patient,
                    this.groupedObsByConceptIds);
            if (knowledgeAssessmentType != null && !knowledgeAssessmentType.isEmpty()) {
                preTestInfo.setKnowledgeAssessment(knowledgeAssessmentType.get(0));
            }

            //Syndromic STI
            List<SyndromicSTIScreeningType> syndromicSTIScreeningType = mainDictionary.createSyndromicsStiType(patient,
                    this.groupedObsByConceptIds);
            if (syndromicSTIScreeningType != null && syndromicSTIScreeningType.size() > 0) {
                preTestInfo.setSyndromicSTIScreening(syndromicSTIScreeningType.get(0));
            }

            //Post Test Counselling
            List<PostTestCounsellingType> postTestCounsellingType = mainDictionary.createPostTestCounsellingType(patient,
                    this.groupedObsByConceptIds);
            if (postTestCounsellingType != null && postTestCounsellingType.size() > 0) {
                postTestType = postTestCounsellingType.get(0);
            }

            hivTestingReport.setPreTestInformation(preTestInfo);
            hivTestingReport.setPostTestCounselling(postTestType);

            hivTestingReportList.add(hivTestingReport);

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.toString(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }

        return hivTestingReportList;

    }

    private ConditionType createHIVCondition() {

        ConditionType condition = new ConditionType();

        try {

            NDRMainDictionary mainDictionary = new NDRMainDictionary();

            condition.setConditionCode("86406008");

            //create address
            condition.setPatientAddress(createPatientAddress());

            //create program area
            condition.setProgramArea(createProgramArea());

            if(!patient.isVoided()) {

                //for baseline data
                CommonQuestionsType common = mainDictionary.createCommonQuestionType2(this.patient, this.lastEncounter, this.groupedpatientBaselineObsByConcept);
                //create common question tags by calling the factory method and passing the encounter, patient and obs list

                if (common != null && !common.isEmpty() && !patient.isVoided()) {
                    condition.setCommonQuestions(common);
                }


                ConditionSpecificQuestionsType hivSpecs = mainDictionary.createCommConditionSpecificQuestionsType(this.patient,this.groupedpatientBaselineObsByConcept, this.groupedpatientBaselineObsByEncounterType);


                if (hivSpecs.getHIVQuestions() != null) {
                    condition.setConditionSpecificQuestions(hivSpecs);
                }

                //create hiv encounter
                List<HIVEncounterType> hivEncounter = mainDictionary.createHIVEncounterType(this.patient, this.groupedEncounters, this.groupedObsByVisitDate);
                if (hivEncounter != null && hivEncounter.size() > 0) {
                    EncountersType encType = new EncountersType();
                    encType.getHIVEncounter().addAll(hivEncounter);
                    condition.setEncounters(encType);
                }


                List<Encounter> sampleCollectionEncounterType = this.groupedEncounters.get(Utils.Sample_Collection_Encounter_Type_Id);
                Map<String,LaboratoryReportType> sampleCollectionReport = getLabReport(mainDictionary, sampleCollectionEncounterType);

                List<Encounter> labOrderAndResultEncounterType = this.groupedEncounters.get(Utils.Laboratory_Encounter_Type_Id);
                Map<String,LaboratoryReportType> labOrderAndResultReport = getLabReport(mainDictionary, labOrderAndResultEncounterType);

                List<LaboratoryReportType> combinedReport = getCombinedReport(sampleCollectionReport,labOrderAndResultReport);

                condition.getLaboratoryReport().addAll(combinedReport);

                //Partner details -> moved to PMTCT
//                try {
//                    List<PartnerDetailsType> partnerDetailsType = mainDictionary.createPartnerDetails(patient, this.groupedEncounters, this.groupedObsByConceptIds);
//                    if (!partnerDetailsType.isEmpty()) {
//                        condition.getPartnerDetails().addAll(partnerDetailsType);
//                    }
//                } catch (Exception ex) {
//                    LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
//                            LogLevel.live);
//                }

                List<RegimenType> arvRegimenTypeList = mainDictionary.createRegimenTypeList(patient, this.groupedEncounters);
                if (arvRegimenTypeList != null && arvRegimenTypeList.size() > 0) {
                    condition.getRegimen().addAll(arvRegimenTypeList);
                }

                return condition;
            }

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LogLevel.live);
            // throw ex;
        }

        return condition;
    }

    private List<LaboratoryReportType> getCombinedReport(Map<String,LaboratoryReportType> sampleCollectionReport,
                                                         Map<String,LaboratoryReportType> labOrderAndResultReport) {

        List<LaboratoryReportType> result = new ArrayList<>();
        for(String visitDate: labOrderAndResultReport.keySet()){
            if(sampleCollectionReport.get(visitDate) != null) {
                LaboratoryReportType sampleLaboratoryReportType = sampleCollectionReport.get(visitDate);
                LaboratoryReportType labLaboratoryReportType = labOrderAndResultReport.get(visitDate);
                //set ordered date
                if(sampleLaboratoryReportType.getLaboratoryOrderAndResult().size() > 0 &&
                        labLaboratoryReportType.getLaboratoryOrderAndResult().size() > 0 ){
                    List<LaboratoryOrderAndResult> newLaboratoryOrderAndResults = new ArrayList<>();
                    for(LaboratoryOrderAndResult laboratoryOrderAndResult : labLaboratoryReportType.getLaboratoryOrderAndResult()){
                        for(LaboratoryOrderAndResult laboratoryOrderAndResult2: sampleLaboratoryReportType.getLaboratoryOrderAndResult()){
                            if(laboratoryOrderAndResult.getLaboratoryTestTypeCode().equalsIgnoreCase(laboratoryOrderAndResult2.getLaboratoryTestTypeCode())){
                                laboratoryOrderAndResult.setOrderedTestDate(laboratoryOrderAndResult2.getOrderedTestDate());
                            }
                        }
                        laboratoryOrderAndResult.setLaboratoryTestTypeCode(null);
                        newLaboratoryOrderAndResults.add(laboratoryOrderAndResult);
                    }
                    labLaboratoryReportType.setLaboratoryOrderAndResult(newLaboratoryOrderAndResults);
                }
                sampleCollectionReport.remove(visitDate);
                labOrderAndResultReport.put(visitDate,labLaboratoryReportType);
            }
        }
        result.addAll(clearResults(new ArrayList<>(sampleCollectionReport.values())));
        result.addAll(labOrderAndResultReport.values());

        return result;
    }

    private List<LaboratoryReportType> clearResults(List<LaboratoryReportType> values) {
        List<LaboratoryReportType> newList = new ArrayList<>();
        for(LaboratoryReportType laboratoryReportType: values){
            laboratoryReportType.setLaboratoryOrderAndResult(new ArrayList<>());
            newList.add(laboratoryReportType);
        }
        return newList;
    }

    private Map<String,LaboratoryReportType> getLabReport(NDRMainDictionary mainDictionary, List<Encounter> encounterTypes) throws DatatypeConfigurationException {
        Map<String,LaboratoryReportType> laboratoryReports = new HashMap<>();
        if (encounterTypes != null && !encounterTypes.isEmpty()) {
            for (Encounter each : encounterTypes) {
                List<Obs> obsList = new ArrayList<>(each.getAllObs());
                LaboratoryReportType laboratoryReport = mainDictionary.createLaboratoryOrderAndResult(patient,
                        each, obsList);
                if (laboratoryReport != null) {
                    laboratoryReports.put(laboratoryReport.getVisitDate().toString(),laboratoryReport);
                }
            }
        }
        return laboratoryReports;
    }

    /**
     * Create PatientDemographicsType for pts Create CommonQuestionType for pts Create
     * HIVQuestionsType for pts Get all Pharmacy visits for patients For each Pharmacy visit create
     * RegimenType Get all Clinical visits for patients // For each Clinical visits create
     * HIVEncounter // Get all Lab visits for patients // For each of Lab visit create LabReportType
     */
    //
    private ProgramAreaType createProgramArea() {
        ProgramAreaType p = new ProgramAreaType();
        p.setProgramAreaCode("HIV");
        return p;
    }

    private AddressType createPatientAddress() {
        AddressType p = new AddressType();
        p.setAddressTypeCode("H");
        p.setCountryCode("NGA");
        Connection connection = null;
        Statement statement = null;

        PersonAddress pa = patient.getPersonAddress();
        if (pa != null) {
            //p.setTown(pa.getAddress1());
            String lga = pa.getCityVillage();
            String state = pa.getStateProvince();

            try {
                String sql = String
                        .format(
                                "SELECT `name`, user_generated_id, 'STATE' AS 'Location' "
                                        + "FROM address_hierarchy_entry WHERE level_id =2 AND NAME = '%s' "
                                        + "UNION "
                                        + "SELECT `name`, user_generated_id, 'LGA' AS 'Location' FROM address_hierarchy_entry "
                                        + " WHERE level_id =3 AND NAME ='%s' AND parent_id = (SELECT address_hierarchy_entry_id FROM address_hierarchy_entry\n"
                                        + " WHERE level_id =2 AND NAME = '%s')", state, lga, state);

                connection = DriverManager.getConnection(this.openmrsConn.getUrl(), this.openmrsConn.getUsername(),
                        this.openmrsConn.getPassword());
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while (result.next()) {
                    //String name = result.getString("name");
                    if (result.getString("Location").contains("STATE")) {
                        p.setStateCode(result.getString("user_generated_id"));
                    } else {
                        p.setLGACode(result.getString("user_generated_id"));
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                LoggerUtils.write(NDRMainDictionary.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
                        LogLevel.live);
            }
            finally {

                try {
                    if (connection != null) {
                        connection.close();
                    }

                    if (statement != null) {
                        statement.close();
                    }

                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return p;
    }

    private MessageHeaderType createMessageHeaderType(Patient pts, boolean hasUpdate) throws DatatypeConfigurationException {
        MessageHeaderType header = new MessageHeaderType();

        Calendar cal = Calendar.getInstance();

        header.setMessageCreationDateTime(utils.getXmlDateTime(cal.getTime()));
        Boolean isDeleted = pts.getPerson().getVoided();
        String updatedORInitial = (hasUpdate) ? "UPDATED" : "INITIAL";
        String messageStatus = (isDeleted) ? "REDACTED" : updatedORInitial;
        header.setMessageStatusCode(messageStatus);
        //header.setMessageStatusCode("INITIAL");
        header.setMessageSchemaVersion("1.6");
        header.setMessageUniqueID(UUID.randomUUID().toString());
        return header;
    }

    public String getValidation(String id) {
        NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
        String sqlV = "5.7.21-log";//nigeriaemrService.getSqlVersion();
        StringBuilder textToEnc = new StringBuilder();
        textToEnc.append(System.getProperty("os.arch"));
        textToEnc.append("|");
        textToEnc.append(System.getProperty("os.name"));
        textToEnc.append("|");
        textToEnc.append(System.getProperty("os.version"));
        textToEnc.append("|");
        textToEnc.append(System.getProperty("OPENMRS_APPLICATION_DATA_DIRECTORY"));
        textToEnc.append("|");
        textToEnc.append(System.getProperty("java.version"));
        textToEnc.append("|");
        textToEnc.append(System.getProperty("user.home"));
        textToEnc.append("|");
        textToEnc.append(sqlV);
        textToEnc.append("|");
        textToEnc.append(Utils.getModules()); // list of modules and versions
        textToEnc.append("|");
        textToEnc.append(id);
        try {
            Version version = Utils.getNmrsVersion();
            if (version != null) {
                textToEnc.append("|");
                textToEnc.append(version.getPbs());
                textToEnc.append("|");
                textToEnc.append(version.getExport());
            }
            StringBuilder returnVar = new StringBuilder();
            returnVar.append(Signer.encryptText(textToEnc.toString()));
            String hashReturnVar = Base64.getEncoder().encodeToString(returnVar.toString().getBytes());
            returnVar.append("||");
            //add hash of encrpt string
            returnVar.append(hashReturnVar);
            if (version != null) {
                returnVar.append("||");
                returnVar.append(version.getValidator());
            }
            return returnVar.toString();
        }
        catch (Exception e) {
            LoggerUtils.write(NDRConverter.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
            e.printStackTrace();
            return "";
        }
    }
}
