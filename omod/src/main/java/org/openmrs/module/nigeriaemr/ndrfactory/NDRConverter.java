package org.openmrs.module.nigeriaemr.ndrfactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PersonAddress;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrUtils.Validator;
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
	
	private List<Obs> allobs;
	
	private DBConnection openmrsConn;
	
	public NDRConverter(String _ipName, String _ipCode, DBConnection _openmrsConn) {
		this.ipName = _ipName;
		this.ipCode = _ipCode;
		this.openmrsConn = _openmrsConn;
	}
	
	public Container createContainer(Patient pts, FacilityType facility) throws DatatypeConfigurationException {

        try {
            patient = pts;
            this.facility = facility;
            this.encounters = new ArrayList<>();
            Date lastDate = Utils.getLastNDRDate();

            long startTime = System.currentTimeMillis();
            List<Encounter> encs = Context.getEncounterService().getEncountersByPatient(pts);

            //only run if patient has had any encounter between the last run date and now
          /*  if(lastDate !=null){
                Boolean recentEncounter = encs.stream()
                        .anyMatch(e-> e.getDateCreated().after(lastDate) ||
                                e.getDateChanged().after(lastDate));
                *//*if(recentEncounter == false)
                    return null;*//*
            }*/


            long endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 1000) {
                System.out.println("took too loooong to get encounters : " + (endTime - startTime) + " milli secs : ");
            }

            startTime = System.currentTimeMillis();
            this.allobs = Context.getObsService().getObservationsByPerson(pts);
            endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 1000) {
                System.out.println("took too loooong to get obs : " + (endTime - startTime) + " milli secs : ");
            }

            this.encounters.addAll(encs);
            if (this.encounters == null || this.encounters.isEmpty()) {
                return null;
            }

            Container container = new Container();
            MessageHeaderType header = createMessageHeaderType();
            FacilityType sendingOrganization = Utils.createFacilityType(this.ipName, this.ipCode, "IP");
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
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
    }
	
	private IndividualReportType createIndividualReportType() throws DatatypeConfigurationException {
		
		try {
			
			//create patient data
			PatientDemographicsType patientDemography = new NDRMainDictionary().createPatientDemographicsType(patient,
			    facility, openmrsConn);
			if (patientDemography == null) { //return null if no valid patient data exist
				return null;
			}
			
			//create hiv condition type with code "86406008"
			ConditionType condition = createHIVCondition();
			if (condition == null) {
				return null; //return null if the condition parameters are empty
			}
			
			IndividualReportType individualReport = new IndividualReportType();
			individualReport.setPatientDemographics(patientDemography);
			individualReport.getCondition().add(condition);
			
			return individualReport;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
	
	private ConditionType createHIVCondition() throws DatatypeConfigurationException {
		
		try {
			
			long startTime = System.currentTimeMillis();
			
			NDRMainDictionary mainDictionary = new NDRMainDictionary();
			
			ConditionType condition = new ConditionType();
			condition.setConditionCode("86406008");
			
			//create address
			//This method is throwing exception
			//condition.setPatientAddress(createPatientAddress());
			
			//create program area
			//condition.setProgramArea(createProgramArea());
			
			//create common question tags by calling the factory method and passing the encounter, patient and obs list
			//condition
			// .setCommonQuestions(mainDictionary.createCommonQuestionType(this.patient, this.encounters, this.allobs));
			
			//create condition specific question tag
			//HIVQuestionsType hivQuestionsType = mainDictionary.createHIVQuestionType(patient, this.encounters, this.allobs);
			//if (hivQuestionsType != null) {
			//ConditionSpecificQuestionsType hivSpecificQuestions = new ConditionSpecificQuestionsType();
			//hivSpecificQuestions.setHIVQuestions(hivQuestionsType);
			//condition.setConditionSpecificQuestions(hivSpecificQuestions);
			//}
			
			//create hiv encounter
			//HIVEncounterType hivEncounter = mainDictionary.createHIVEncounterType(this.patient, this.encounters,this.allobs);
			List<HIVEncounterType> hivEncounterTypeList = mainDictionary.createHIVEncounterType(this.patient,
			    this.encounters, this.allobs);
			//condition.getEncounters().getHIVEncounter().addAll(hivEncounterTypeList);
			if (hivEncounterTypeList != null) {
				EncountersType encType = new EncountersType();
				encType.getHIVEncounter().addAll(hivEncounterTypeList);
				condition.setEncounters(encType);
			}
			
			//create Child birth details
			//ChildBirthDetailsType childBirthDetailsType = mainDictionary.createChildBirthDetailsType(patient,
			//this.encounters, this.allobs);
			//if (childBirthDetailsType != null) {
			//condition.getChildBirthDetails().add(childBirthDetailsType);
			//}
			
			//create child follow up
			//ChildFollowupType childFollowupType = mainDictionary.createChildFollowupType(patient, this.encounters,
			//this.allobs);
			//if (childFollowupType != null) {
			//condition.getChildFollowup().add(childFollowupType);
			//}
			
			//create TB screening
			//List<ClinicalTBScreeningType> clinicalTBScreeningType = mainDictionary.createClinicalTbScreening(patient,
			//this.encounters, this.allobs);
			//if (clinicalTBScreeningType != null && !clinicalTBScreeningType.isEmpty()) {
			//condition.getClinicalTBScreening().addAll(clinicalTBScreeningType);
			//}
			
			//List<HIVRiskAssessmentType> hivRiskAssessmentType = mainDictionary.createHivRiskAssessment(patient,
			//this.encounters, this.allobs);
			//if (hivRiskAssessmentType != null) {
			//condition.getHIVRiskAssessment().addAll(hivRiskAssessmentType);
			//}
			
			//immunization Type
			//ImmunizationType immunizationType = mainDictionary.createImmunizationType(patient, this.encounters, this.allobs);
			//if (immunizationType != null) {
			//condition.getImmunization().add(immunizationType);
			//}
			
			//Infant PCR Testing Type
			//InfantPCRTestingType infantPCRTestingType = mainDictionary
			//    .createInfantPcr(patient, this.encounters, this.allobs);
			//if (infantPCRTestingType != null) {
			//condition.getInfantPCRTesting().add(infantPCRTestingType);
			//}
			
			//Knowledge Assessment Type
			//List<KnowledgeAssessmentType> knowledgeAssessmentType = mainDictionary.createKnowledgeAssessmentType(patient,
			// this.encounters, this.allobs);
			//if (knowledgeAssessmentType != null) {
			//condition.getKnowledgeAssessment().addAll(knowledgeAssessmentType);
			//}
			
			//Laboratory Report
			//condition.getLaboratoryReport().add(null);
			
			//condition.getPartnerDetailsType().add(null);
			
			//Post Test Counselling
			//List<PostTestCounsellingType> postTestCounsellingType = mainDictionary.createPostTestCounsellingType(patient,
			// this.encounters, this.allobs);
			//if (postTestCounsellingType != null) {
			//condition.getPostTestCounselling().addAll(postTestCounsellingType);
			//}
			
			List<RegimenType> arvRegimenTypeList = mainDictionary.createRegimenTypeList(patient, encounters, this.allobs);
			if (arvRegimenTypeList != null && !arvRegimenTypeList.isEmpty()) {
				condition.getRegimen().addAll(arvRegimenTypeList);
			}
			
			//Syndromic STI
			//List<SyndromicSTIScreeningType> syndromicSTIScreeningType = mainDictionary.createSyndromicsStiType(patient,
			//this.encounters, this.allobs);
			//if (syndromicSTIScreeningType != null) {
			//condition.getSyndromicSTIScreening().addAll(syndromicSTIScreeningType);
			//}
			
			//
			//List<HealthFacilityVisitsType> healthFacilityVisitsType = mainDictionary.createHealthFacilityVisit(patient,
			//this.encounters, this.allobs);
			//if (healthFacilityVisitsType != null) {
			//condition.getHealthFacilityVisits().addAll(healthFacilityVisitsType);
			//}
			
			//LaboratoryReportType laboratoryReport = mainDictionary.createLaboratoryOrderAndResult(patient, this.encounters,
			// this.allobs);
			//createLaboratoryReportTypes(enc, obsList);
			//condition.getLaboratoryReport().add(laboratoryReport);
			
			long endTime = System.currentTimeMillis();
			if ((endTime - startTime) > 1000) {
				System.out.println("took too long to get obs : " + (endTime - startTime) + " milli secs : ");
			}
			
			return condition;
			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
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
		
		PersonAddress pa = patient.getPersonAddress();
		/*if (pa != null) {
			//p.setTown(pa.getAddress1());
			String lga = pa.getCityVillage();
			String state = pa.getStateProvince();
			
			try {
				String sql = String
				        .format(
				            "SELECT `name`, user_generated_id, 'STATE' AS 'Location' "
				                    + "FROM address_hierarchy_entry WHERE NAME = '%s' "
				                    + "UNION "
				                    + "SELECT `name`, user_generated_id, 'LGA' AS 'Location' FROM address_hierarchy_entry "
				                    + " WHERE NAME ='%s' AND parent_id = (SELECT address_hierarchy_entry_id FROM address_hierarchy_entry\n"
				                    + " WHERE NAME = '%s')", state, lga, state);
				Connection connection = DriverManager.getConnection(this.openmrsConn.getUrl(),
				    this.openmrsConn.getUsername(), this.openmrsConn.getPassword());
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					//String name = result.getString("name");
					String coded_value = result.getString("user_generated_id");
					
					if (result.getString("Location").contains("STATE")) {
						p.setStateCode(coded_value);
					} else {
						p.setLGACode(coded_value);
					}
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				LoggerUtils.write(NDRMainDictionary.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
				    LogLevel.live);
			}
		}*/
		return p;
	}
	
	private MessageHeaderType createMessageHeaderType() throws DatatypeConfigurationException {
		MessageHeaderType header = new MessageHeaderType();
		
		Calendar cal = Calendar.getInstance();
		
		header.setMessageCreationDateTime(Utils.getXmlDateTime(cal.getTime()));
		header.setMessageStatusCode("INITIAL");
		header.setMessageSchemaVersion(new BigDecimal("1.3"));
		header.setMessageUniqueID(UUID.randomUUID().toString());
		return header;
	}
	
	private Marshaller createMarshaller(JAXBContext jaxbContext) throws JAXBException, SAXException {
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		java.net.URL xsdFilePath = Thread.currentThread().getContextClassLoader().getResource("NDR 1.3.xsd");
		
		assert xsdFilePath != null;
		
		Schema schema = sf.newSchema(xsdFilePath);
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		jaxbMarshaller.setSchema(schema);
		
		//Call Validator class to perform the validation
		jaxbMarshaller.setEventHandler(new Validator());
		return jaxbMarshaller;
	}
	
	public void writeFile(Container container, File file) throws SAXException, JAXBException, IOException {
		
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance("org.openmrs.module.nigeriaemr.model.ndr");
			Marshaller jaxbMarshaller = createMarshaller(jaxbContext);
			
			javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
			jaxbMarshaller.marshal(container, file);
			validator.setErrorHandler(errorHandler);
			validator.validate(new StreamSource(file));
		}
		catch (Exception ex) {
			System.out.println("File " + file.getName() + " throw an exception \n" + ex.getMessage());
			throw ex;
		}
	}
}
