package org.openmrs.module.nigeriaemr.ndrfactory;

import com.umb.ndr.signer.Signer;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PersonAddress;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
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
	
	private Patient patient;

	private Map<Integer, List<Encounter>> groupedEncounters = new HashMap<>();

	private Map<Object, List<Obs>> groupedObsByConceptIds = new HashMap<>();
	
	private Map<Object, List<Obs>> groupedObsByEncounterTypes = new HashMap<>();
	
	private Map<Object, List<Obs>> groupedObsByVisitDate = new HashMap<>();
	
	private Encounter lastEncounter;
	
	private final DBConnection openmrsConn;
	
	private Map<Object, List<Obs>> groupedpatientBaselineObsByConcept = new HashMap<>();
	
	private Map<Object, List<Obs>> groupedpatientBaselineObsByEncounterType = new HashMap<>();
	
	private final NigeriaEncounterService nigeriaEncounterService;
	
	private final Date fromDate;
	
	private final Date toDate;

    public NDRConverter(DBConnection _openmrsConn, Date fromDate, Date toDate) {
		this.openmrsConn = _openmrsConn;
		this.nigeriaEncounterService = Context.getService(NigeriaEncounterService.class);
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Container createContainer(Patient pts) {

        Container container = new Container();
        String facilityName = Utils.getFacilityName();
        String DATIMID = Utils.getFacilityDATIMId();
        String FacilityType = "FAC";
        boolean hasUpdate = false;


        try {
            patient = pts;

            List<Encounter> filteredEncounters = nigeriaEncounterService.getEncountersByPatient(pts, this.fromDate, this.toDate);


            if(!pts.isVoided()) {
                if (filteredEncounters == null || filteredEncounters.isEmpty()) {
                    return null;
                }
                List<Encounter> encounters = new ArrayList<>(filteredEncounters);
                this.lastEncounter = filteredEncounters.get(filteredEncounters.size() - 1);
                this.groupedEncounters = Utils.extractEncountersByEncounterTypesId(encounters);

                List<Obs> allobs = Utils.extractObsfromEncounter(filteredEncounters);
                Map<String,Map<Object, List<Obs>>> grouped = Utils.groupObs(allobs);
                this.groupedObsByConceptIds = grouped.get("groupedByConceptIds");
                this.groupedObsByEncounterTypes = grouped.get("groupedByEncounterTypes");
                this.groupedObsByVisitDate = grouped.get("groupedObsByVisitDate");
                List<Obs> patientBaselineObs = Context.getObsService().getObservationsByPerson(patient);
                Map<String,Map<Object, List<Obs>>> groupedPatientBaseLine = Utils.groupObs(patientBaselineObs);
                this.groupedpatientBaselineObsByConcept = groupedPatientBaseLine.get("groupedByConceptIds");
                this.groupedpatientBaselineObsByEncounterType = groupedPatientBaseLine.get("groupedByEncounterTypes");

                if(filteredEncounters.size() > 0)  hasUpdate = true;
//                for(Encounter enc: filteredEncounters){
//                    int dateCreatedComp = enc.getDateCreated().compareTo(this.toDate);
//                    int dateModifiedComp = -1;
//                    if (enc.getDateChanged() != null) {
//                        dateModifiedComp = enc.getDateChanged().compareTo(this.toDate);
//                    }
//                    if(dateCreatedComp <= -1 && dateModifiedComp <= -1){
//
//                        break;
//                    }
//                }
            }

            MessageHeaderType header = createMessageHeaderType(pts, hasUpdate);
            FacilityType sendingOrganization = Utils.createFacilityType(facilityName, DATIMID, FacilityType);
            header.setMessageSendingOrganization(sendingOrganization);

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
        }
        return container;
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


            //create hiv condition type with code "86406008"
            ConditionType condition = createHIVCondition();


            individualReport.setPatientDemographics(patientDemography);

            //retrieve latest encounter for client intake form
            Encounter intakeEncounter = Utils.getLatestEncounter(this.groupedEncounters.get(ConstantsUtil.ADMISSION_ENCOUNTER_TYPE));

            if (intakeEncounter != null) {
                List<Obs> intakeObs = new ArrayList<>(intakeEncounter.getAllObs());
                Map<Object, List<Obs>> groupedintakeObsByConcept = Utils.groupedByConceptIdsOnly(intakeObs);
                try {
                    List<HIVTestingReportType> hivReportTypes = createHIVTestingReport(intakeEncounter, groupedintakeObsByConcept);
                    individualReport.getHIVTestingReport().addAll(hivReportTypes);
                } catch (Exception ex) {
                    LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LogLevel.live);
                }
            }

            individualReport.getCondition().add(condition);

            return individualReport;

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                    LoggerUtils.LogLevel.live);
            // throw ex;
        }

        return individualReport;
    }
	
	private List<HIVTestingReportType> createHIVTestingReport(Encounter encounter,  Map<Object, List<Obs>> groupedObsByConcept) {

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

            //for baseline data
            CommonQuestionsType common = mainDictionary.createCommonQuestionType2(this.patient, this.lastEncounter, this.groupedpatientBaselineObsByConcept);
            //create common question tags by calling the factory method and passing the encounter, patient and obs list

            if(common != null && !common.isEmpty() && !patient.isVoided()){
                condition.setCommonQuestions(common);
            }


            ConditionSpecificQuestionsType hivSpecs = mainDictionary.createCommConditionSpecificQuestionsType(this.groupedpatientBaselineObsByConcept,this.groupedpatientBaselineObsByEncounterType);


            if(hivSpecs.getHIVQuestions() != null){
            condition.setConditionSpecificQuestions(hivSpecs);
            }

            //create hiv encounter
            List<HIVEncounterType> hivEncounter = mainDictionary.createHIVEncounterType(this.patient, this.groupedEncounters, this.groupedObsByVisitDate);
            if (hivEncounter != null && hivEncounter.size() > 0) {
                EncountersType encType = new EncountersType();
                encType.getHIVEncounter().addAll(hivEncounter);
                condition.setEncounters(encType);
            }

            List<Encounter> tempEncs = this.groupedEncounters.get(Utils.Laboratory_Encounter_Type_Id);
            if (tempEncs != null && !tempEncs.isEmpty()) {
                for (Encounter each : tempEncs) {
                    List<Obs> obsList = new ArrayList<>(each.getAllObs());
                    LaboratoryReportType laboratoryReport = mainDictionary.createLaboratoryOrderAndResult(patient,
                            each, obsList);
                    if (laboratoryReport != null) {
                        condition.getLaboratoryReport().add(laboratoryReport);
                    }
                }

            }
            //Partner details
            try {
                List<PartnerDetailsType> partnerDetailsType = mainDictionary.createPartnerDetails(patient, this.groupedEncounters, this.groupedObsByConceptIds);
                if (!partnerDetailsType.isEmpty()) {
                    condition.getPartnerDetails().addAll(partnerDetailsType);
                }
            } catch (Exception ex) {
                LoggerUtils.write(NDRMainDictionary.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
                        LogLevel.live);
            }

            List<RegimenType> arvRegimenTypeList = mainDictionary.createRegimenTypeList(patient, this.groupedEncounters);
            if (arvRegimenTypeList != null && arvRegimenTypeList.size() > 0) {
                condition.getRegimen().addAll(arvRegimenTypeList);
            }

            return condition;

        } catch (Exception ex) {
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
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
	
	public String getValidation(String id) {
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
