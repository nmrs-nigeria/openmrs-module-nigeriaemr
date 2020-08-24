package org.openmrs.module.nigeriaemr.ndrfactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrUtils.CustomErrorHandler;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.xml.sax.SAXException;

import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;

public class NDRConverter {
	
	//Logger logger = Logger.getLogger(NDRConverter.class);
	private Patient patient;
	
	private FacilityType facility;
	
	private String ipName;
	
	private String ipCode;
	
	private List<Encounter> encounters;
	
	private Map<Integer, List<Encounter>> groupedEncounters;
	
	private Encounter lastEncounter;
	
	private List<Obs> allobs;
	
	private List<Integer> encounterIds;
	
	private DBConnection openmrsConn;
	
	private List<Obs> patientBaselineObs;
	
	private NigeriaEncounterService nigeriaEncounterService;
	
	private NigeriaObsService nigeriaObsService;
	
	private Date fromDate;
	
	private Date toDate;
	
	public NDRConverter(String _ipName, String _ipCode, DBConnection _openmrsConn, Date fromDate, Date toDate) {
		this.ipName = _ipName;
		this.ipCode = _ipCode;
		this.openmrsConn = _openmrsConn;
		this.nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		this.nigeriaObsService = Context.getService(NigeriaObsService.class);
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Container createContainer(Patient pts, FacilityType facility) {

        Container container = new Container();
        Connection connection = null;
        Statement statement = null;
        String facilityName = Utils.getFacilityName();
        String DATIMID = Utils.getFacilityDATIMId();
        String FacilityType = "FAC";
        boolean hasUpdate = false;


        try {
            patient = pts;
            this.facility = facility;
            this.encounters = new ArrayList<>();

            long startTime = System.currentTimeMillis();
            List<Encounter> filteredEncs = nigeriaEncounterService.getEncountersByPatient(pts,this.fromDate,this.toDate);
            this.encounterIds = filteredEncs.stream().map(Encounter::getId).collect(Collectors.toList());
            this.lastEncounter = nigeriaEncounterService.getLastEncounterByPatient(patient, this.fromDate,this.toDate);

            long endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 1000) {
                System.out.println("took too loooong to get encounters : " + (endTime - startTime) + " milli secs : ");
            }
            this.encounters.addAll(filteredEncs);
            if (this.encounters == null || this.encounters.isEmpty()) {
                return null;
            }
            groupedEncounters = Utils.extractEncountersByEncounterTypesId(encounters);

            this.allobs = Utils.extractObsfromEncounter(filteredEncs);
//            this.allobs = nigeriaObsService.getObsByEncounters(encounterIds,false);
            patientBaselineObs = Context.getObsService().getObservationsByPerson(patient);
            if(!pts.isVoided()) {
                if (filteredEncs.isEmpty()) {
                    return null;
                }
            }
            MessageHeaderType header = createMessageHeaderType(pts,hasUpdate);
            //FacilityType sendingOrganization = Utils.createFacilityType(this.ipName, this.ipCode, "IP");
            FacilityType sendingOrganization = Utils.createFacilityType(facilityName, DATIMID, FacilityType);
            header.setMessageSendingOrganization(sendingOrganization);

            container.setMessageHeader(header);

            IndividualReportType individualReportType = createIndividualReportType();

            if (individualReportType == null) {
                return null;
            }

            container.setIndividualReport(individualReportType);
            return container;
        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
        }
        return container;
    }
	
	private IndividualReportType createIndividualReportType() throws DatatypeConfigurationException {

        IndividualReportType individualReport = new IndividualReportType();
        try {
            PatientDemographicsType patientDemography = new NDRMainDictionary().createPatientDemographicType2(patient,facility, allobs);
            if (patientDemography == null) { //return null if no valid patient data exist
                return null;
            }

            //create hiv condition type with code "86406008"
            ConditionType condition = createHIVCondition();

            individualReport.setPatientDemographics(patientDemography);

            //retrieve latest encounter for client intake form
            Encounter intakeEncounter = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.ADMISSION_ENCOUNTER_TYPE));

            if (intakeEncounter != null) {
                List<Obs> intakeObs = new ArrayList<>(intakeEncounter.getAllObs());
                //  if (htsIdentifier != null) {
                try {
                    List<HIVTestingReportType> hivReportTypes = createHIVTestingReport(intakeEncounter, intakeObs);
                    individualReport.getHIVTestingReport().addAll(hivReportTypes);
                } catch (Exception ex) {
                    LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
                }
                //  }
            }

            individualReport.getCondition().add(condition);

            return individualReport;

        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            // throw ex;
        }

        return individualReport;
    }
	
	private List<HIVTestingReportType> createHIVTestingReport(Encounter encounter, List<Obs> allObs) {

        //TODO: pull hivtestReport as a list
        NDRMainDictionary mainDictionary = new NDRMainDictionary();

        List<HIVTestingReportType> hivTestingReportList = new ArrayList<>();

        try {

            //for each testing to the following
            HIVTestingReportType hivTestingReport = new HIVTestingReportType();
            PreTestInformationType preTestInfo = new PreTestInformationType();
            PostTestCounsellingType postTestType = new PostTestCounsellingType();

            hivTestingReport = mainDictionary.createHIVTestIntake(patient, encounter, allObs, hivTestingReport);

            HIVTestResultType hIVTestResultType = mainDictionary.createHIVTestResult(patient, encounter, allObs);

            IndexNotificationServicesType indexNotificationServicesType = mainDictionary.createIndexNotificationServicesTypes(patient, encounter, allObs);

            if (hIVTestResultType != null) {
                hivTestingReport.setHIVTestResult(hIVTestResultType);
            }

            if (indexNotificationServicesType != null) {
                hivTestingReport.setIndexNotificationServices(indexNotificationServicesType);
            }

            //create TB screening
            List<ClinicalTBScreeningType> clinicalTBScreeningType = mainDictionary.createClinicalTbScreening(patient,
                    encounter, allObs);

            if (clinicalTBScreeningType != null && !clinicalTBScreeningType.isEmpty()) {

                preTestInfo.setClinicalTBScreening(clinicalTBScreeningType.get(0));
            }

            //HIV Risk assessment
            List<HIVRiskAssessmentType> hivRiskAssessmentType = mainDictionary.createHivRiskAssessment(patient,
                    encounter, allObs);
            if (hivRiskAssessmentType != null && !hivRiskAssessmentType.isEmpty()) {
                preTestInfo.setHIVRiskAssessment(hivRiskAssessmentType.get(0));
            }

            //knowledge assessment
            //Knowledge Assessment Type
            List<KnowledgeAssessmentType> knowledgeAssessmentType = mainDictionary.createKnowledgeAssessmentType(patient,
                    encounter, allObs);
            if (knowledgeAssessmentType != null && !knowledgeAssessmentType.isEmpty()) {
                preTestInfo.setKnowledgeAssessment(knowledgeAssessmentType.get(0));
            }

            //Syndromic STI
            List<SyndromicSTIScreeningType> syndromicSTIScreeningType = mainDictionary.createSyndromicsStiType(patient,
                    encounter, allObs);
            if (syndromicSTIScreeningType != null && syndromicSTIScreeningType.size() > 0) {
                preTestInfo.setSyndromicSTIScreening(syndromicSTIScreeningType.get(0));
            }

            //Post Test Counselling
            List<PostTestCounsellingType> postTestCounsellingType = mainDictionary.createPostTestCounsellingType(patient,
                    encounter, allObs);
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
	
	private ConditionType createHIVCondition() throws DatatypeConfigurationException {

        ConditionType condition = new ConditionType();

        try {

            long startTime = System.currentTimeMillis();

            NDRMainDictionary mainDictionary = new NDRMainDictionary();

            condition.setConditionCode("86406008");

            //create address
            condition.setPatientAddress(createPatientAddress());

            //create program area
            condition.setProgramArea(createProgramArea());

            //for baseline data
             CommonQuestionsType common = mainDictionary.createCommonQuestionType2(this.patient, this.lastEncounter, patientBaselineObs);
            //create common question tags by calling the factory method and passing the encounter, patient and obs list
            if(!common.isEmpty()){
            condition
                    .setCommonQuestions(common);
            }
            
            
          
           ConditionSpecificQuestionsType hivSpecs = mainDictionary.createCommConditionSpecificQuestionsType(patient, patientBaselineObs);
            if(hivSpecs.getHIVQuestions() != null){
            condition.setConditionSpecificQuestions(hivSpecs);
            }

            //create hiv encounter
            List<HIVEncounterType> hivEncounter = mainDictionary.createHIVEncounterType(this.patient, this.fromDate, this.toDate,
                    this.allobs);
            if (hivEncounter != null && hivEncounter.size() > 0) {
                EncountersType encType = new EncountersType();
                encType.getHIVEncounter().addAll(hivEncounter);
                condition.setEncounters(encType);
            }


             List<Encounter> tempEncs = groupedEncounters.get(Utils.Laboratory_Encounter_Type_Id);
            if (tempEncs != null && !tempEncs.isEmpty()) {
                Date artStartdate = Utils.extractARTStartDate(patient, allobs);
                for (Encounter each : tempEncs) {
                    LaboratoryReportType laboratoryReport = mainDictionary.createLaboratoryOrderAndResult(patient,
                            each, new ArrayList<>(each.getAllObs()), artStartdate);
                    if (laboratoryReport != null) {
                        condition.getLaboratoryReport().add(laboratoryReport);
                    }
                }

            }

            //Partner details
            try {
                List<PartnerDetailsType> partnerDetailsType = mainDictionary.createPartnerDetails(patient, this.groupedEncounters, this.allobs);
                if (!partnerDetailsType.isEmpty()) {
                    condition.getPartnerDetails().addAll(partnerDetailsType);
                }
            } catch (Exception ex) {
                LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                        LogLevel.live);
            }

            List<RegimenType> arvRegimenTypeList = mainDictionary.createRegimenTypeList(patient, groupedEncounters);
            if (arvRegimenTypeList != null && arvRegimenTypeList.size() > 0) {
                condition.getRegimen().addAll(arvRegimenTypeList);
            }

            long endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 1000) {
                System.out.println("took too long to get obs : " + (endTime - startTime) + " milli secs : ");
            }

            return condition;

        } catch (Exception ex) {
            LoggerUtils.write(NdrFragmentController.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            // throw ex;
        }

        return condition;
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
					String coded_value = result.getString("user_generated_id");
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
		
		header.setMessageCreationDateTime(Utils.getXmlDateTime(cal.getTime()));
		Boolean isDeleted = pts.getPerson().getVoided();
		String updatedORInitial = (hasUpdate) ? "UPDATED" : "INITIAL";
		String messageStatus = (isDeleted) ? "REDACTED" : updatedORInitial;
		header.setMessageStatusCode(messageStatus);
		//header.setMessageStatusCode("INITIAL");
		header.setMessageSchemaVersion(new BigDecimal("1.6"));
		header.setMessageUniqueID(UUID.randomUUID().toString());
		return header;
	}
	
}
