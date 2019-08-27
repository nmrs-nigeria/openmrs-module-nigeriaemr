package org.openmrs.module.nigeriaemr.ndrfactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;

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
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.omodmodels.Version;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
            long endTime = System.currentTimeMillis();
            if((endTime - startTime) > 1000){
                System.out.println("took too loooong to get encounters : " + (endTime - startTime) + " milli secs : ");
            }

            startTime = System.currentTimeMillis();
            this.allobs = Context.getObsService().getObservationsByPerson(pts);
            endTime = System.currentTimeMillis();
            if((endTime - startTime) > 1000){
                System.out.println("took too loooong to get obs : " + (endTime - startTime) + " milli secs : ");
            }

            //get all encounters that happened after the last run date

            /*if (lastDate != null) {
            //old implementation
//			for(Encounter enc : encs){
//				if(enc.getEncounterDatetime().after(lastDate)){
//					this.encounters.add(enc);
//				}
//			}

            this.encounters = encs.stream().filter((enc) -> (enc.getEncounterDatetime().after(lastDate))).collect(Collectors.toList());

        } else { // assume this is the first time running this report
            this.encounters.addAll(encs);
        }*/
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
            LoggerUtils.write(NDRConverter.class.getName(), ex.getMessage(), LogFormat.FATAL,LogLevel.live);
            throw new DatatypeConfigurationException(Arrays.toString(ex.getStackTrace()));
        }
    }
	
	private IndividualReportType createIndividualReportType() throws DatatypeConfigurationException {
		
		try {
			
			//create patient data
			PatientDemographicsType patientDemography = createPatientDemographicsType();
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
	
	/**
	 * Create PatientDemographicsType for pts Create CommonQuestionType for pts Create
	 * HIVQuestionsType for pts Get all Pharmacy visits for patients For each Pharmacy visit create
	 * RegimenType Get all Clinical visits for patients // For each Clinical visits create
	 * HIVEncounter // Get all Lab visits for patients // For each of Lab visit create LabReportType
	 */
	//
	private List<HIVEncounterType> getHivEncounterTypes(List<Encounter> encounters, Patient patient, List<Integer> encounterTypes) throws DatatypeConfigurationException {
        List<Encounter> filtered = encounters.stream().filter(a -> encounterTypes.contains(a.getEncounterType().getEncounterTypeId()))
                .collect(Collectors.toList());
        
        List<Encounter> filteredEncs = new ArrayList<>();
        
        filteredEncs = filtered.stream().sorted((a, b) -> Integer.compare(a.getVisit().getVisitId(), b.getVisit().getVisitId())).collect(Collectors.toList());
        
        Integer pvisit = null;
        
        List<Obs> similarObs = new ArrayList<>();
        List<HIVEncounterType> hivencounters = new ArrayList<>();
        Encounter lastEncounter = new Encounter();
        
        ClinicalDictionary clinicalDictionary = new ClinicalDictionary();
        HIVEncounterType hivEncounter = new HIVEncounterType();
        
        for (Encounter enc : filteredEncs) {
            //initial iteration
            if (Objects.isNull(pvisit)) {
                pvisit = enc.getVisit().getVisitId();
                similarObs.addAll(enc.getAllObs());
                lastEncounter = enc;
                
            } else {
                if (Objects.equals(pvisit, enc.getVisit().getVisitId())) {
                    //same list
                    similarObs.addAll(enc.getAllObs());
                    lastEncounter = enc;
                } else {
                    //create new list and re-initialize pVisitId
                    hivEncounter = clinicalDictionary.createHIVEncounterType(patient, lastEncounter, similarObs);
                    hivEncounter.setVisitID(String.valueOf(pvisit));
                    hivEncounter.setVisitDate(Utils.getXmlDate(lastEncounter.getVisit().getStartDatetime()));
                    hivEncounter.setDurationOnArt(getHivDurationOnART(lastEncounter));
                    
                    if (Objects.nonNull(hivEncounter)) {
                        hivencounters.add(hivEncounter);
                    }
                    similarObs.clear();
                    similarObs.addAll(enc.getAllObs());
                    
                    pvisit = enc.getVisit().getVisitId();
                    lastEncounter = enc;
                }
            }
            
        }
        return hivencounters;
        
    }
	
	private Integer getHivDurationOnART(Encounter enc) {
		
		try {
			Date artStartDate = Utils.getARTStartDate(patient);
			
			if (artStartDate != null
			        && (enc.getEncounterDatetime().after(artStartDate) || enc.getEncounterDatetime().equals(artStartDate))) {
				Calendar startCalendar = new GregorianCalendar();
				startCalendar.setTime(enc.getEncounterDatetime());
				Calendar endCalendar = new GregorianCalendar();
				endCalendar.setTime(artStartDate);
				
				int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
				int monthOnART = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH); //enc.getEncounterDatetime().getMonth() - artStartDate.getMonth(); // Months.monthsBetween(d1, d2).getMonths();
				return monthOnART;
			}
		}
		catch (Exception ex) {
			LoggerUtils.write(NDRConverter.class.getName(), "Error on HIVDURATIONONART: " + ex.getMessage(),
			    LogFormat.FATAL, LogLevel.live);
		}
		return null;
	}
	
	private ConditionType createHIVCondition() throws DatatypeConfigurationException {
        
        try {
            
            ConditionType condition = new ConditionType();
            condition.setConditionCode("86406008");
            condition.setProgramArea(createProgramArea());
            condition.setPatientAddress(createPatientAddress());
            condition.setCommonQuestions(createCommonQuestionsType());

            //set hivSpecificQuestions obs
            //TODO: add obs transfer form
            //List<AntenatalRegistrationType> _po = Get the data
            List<Obs> conditionSpecificQObs = Utils.getHIVEnrollmentObs(patient);
            List<Obs> conditionSpecificQObs_1 = Utils.getHIVEnrollmentObs(this.allobs);

            EncountersType encType = new EncountersType();
            condition.setEncounters(encType); //the encType will be populated later

            HIVEncounterType hivEncounter;

            /*
			* Changes By Johnbosco
			* */
            PMTCTDictionary pmtctDictionary = new PMTCTDictionary();
            HTSDictionary htsDictionary = new HTSDictionary();

            /*PregnancyEncounterType pregnancyEncounter;
			HIVTestingEncounterType hivTestingEncounter;
			PMTCTDictionary pmtctDictionary = new PMTCTDictionary();
			HTSDictionary htsDictionary = new HTSDictionary();*/
            ClinicalDictionary clinicalDictionary = new ClinicalDictionary();
            LabDictionary labDictionary = new LabDictionary();
            PharmacyDictionary pharmDictionary=new PharmacyDictionary();
            List<RegimenType> arvRegimenTypeList=null;
            //Added by Bright 
            arvRegimenTypeList=pharmDictionary.createRegimenTypeList(patient, encounters);
            for (Encounter enc : this.encounters) {
               // LoggerUtils.write(NDRConverter.class.getName(), "Started pulling data for encounter: "+enc.getEncounterType().getEncounterTypeId(), LogFormat.INFO, LogLevel.live);

                long startTime = System.currentTimeMillis();
                List<Obs> obsList = new ArrayList<>(enc.getAllObs());

                // create the hiv encounter from Adult initials and care card
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Adult_Ped_Initial_Encounter_Type_Id
                        || enc.getEncounterType().getEncounterTypeId() == Utils.Care_card_Encounter_Type_Id) {
                    
                    hivEncounter = clinicalDictionary.createHIVEncounterType(patient, enc, obsList);
                    
                    if (hivEncounter != null) {
                        encType.getHIVEncounter().add(hivEncounter);
                    }
                    
                    if (conditionSpecificQObs == null) {
                        conditionSpecificQObs = new ArrayList<>();
                    }
                    //collect obs from initial evaluation for HIV specific question
                    conditionSpecificQObs.addAll(obsList);
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Antenatal_Registration_Encounter_Type_Id) { // antenatal registration type
                    AntenatalRegistrationType antenatalRegistration = pmtctDictionary.createAntenatalRegistrationType(patient, enc, obsList);
                    if (antenatalRegistration != null) //add to encounter
                    {
                        encType.getAntenatalRegistration().add(antenatalRegistration);
                    }
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Delivery_Encounter_Type_Id) { // delivery register type
                    DeliveryEncounterType deliveryEncounterType = pmtctDictionary.createDeliveryEncounterType(patient, enc, obsList);
                    if (deliveryEncounterType != null) {
                        encType.getDeliveryEncounter().add(deliveryEncounterType);
                    }
                }

                //if it is drug pick up, create regimen tags
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Pharmacy_Encounter_Type_Id) {
                    List<RegimenType> regimenData = createRegimens(enc, obsList);
                    condition.getRegimen().addAll(regimenData);
                }

                //if it is lab order/result encounter, create the lab order tags
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Laboratory_Encounter_Type_Id) {
                    LaboratoryReportType laboratoryReport = labDictionary.createLaboratoryOrderAndResult(patient, enc, obsList);
                    //createLaboratoryReportTypes(enc, obsList);
                    condition.getLaboratoryReport().add(laboratoryReport);
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Child_Birth_Detail_Encounter_Type_Id) {
                    ChildBirthDetailsType childBirthDetailsType = pmtctDictionary.createChildBirthDetailsType(patient, enc, obsList);
                    if (childBirthDetailsType != null) {
                        condition.getChildBirthDetails().add(childBirthDetailsType);
                    }
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Child_Followup_Encounter_Type_Id) {
                    ChildFollowupType childFollowupType = pmtctDictionary.createChildFollowupType(patient, enc, obsList);
                    if (childFollowupType != null) {
                        condition.getChildFollowup().add(childFollowupType);
                    }
                }
               // LoggerUtils.write(NDRMainDictionary.class.getName(), "About to pull client intake data", LogFormat.INFO, LogLevel.live);
                
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Client_Intake_Form_Encounter_Type_Id || enc.getEncounterType().getEncounterTypeId() == Utils.Admission_Simple_Client_intake) {
                   // LoggerUtils.write(NDRMainDictionary.class.getName(), "Client intake form was entered for patient with id: "+patient.getId(), LogFormat.INFO, LogLevel.live);
                    
                    KnowledgeAssessmentType knowledgeAssessmentType = htsDictionary.createKnowledgeAssessmentType(patient, enc, obsList);
                    if (knowledgeAssessmentType != null) {
                        condition.getKnowledgeAssessment().add(knowledgeAssessmentType);
                    }
                    HIVRiskAssessmentType hivRiskAssessmentType = htsDictionary.createHivRiskAssessment(patient, enc, obsList);
                    if (hivRiskAssessmentType != null) {
                        condition.getHIVRiskAssessment().add(hivRiskAssessmentType);
                    }
                    SyndromicSTIScreeningType syndromicSTIScreeningType = htsDictionary.createSyndromicsStiType(patient, enc, obsList);
                    if (syndromicSTIScreeningType != null) {
                        condition.getSyndromicSTIScreening().add(syndromicSTIScreeningType);
                    }
                    ClinicalTBScreeningType clinicalTBScreeningType = htsDictionary.createClinicalTbScreening(patient, enc, obsList);
                    if (clinicalTBScreeningType != null) {
                        condition.getClinicalTBScreening().add(clinicalTBScreeningType);
                    }
                    PostTestCounsellingType postTestCounsellingType = htsDictionary.createPostTestCouncellingType(patient, enc, obsList);
                    if (postTestCounsellingType != null) {
                        condition.getPostTestCounselling().add(postTestCounsellingType);
                    }
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Partner_register_Encounter_Id) {
                    PartnerDetailsType partnerDetailsType = htsDictionary.createPartnerDetails(patient, enc, obsList);
                    if (partnerDetailsType != null) {
                        condition.getPartnerDetailsType().add(partnerDetailsType);
                    }
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Child_Followup_Encounter_Type_Id) {
                    ImmunizationType immunizationType = pmtctDictionary.createImmunizationType(patient, enc, obsList);
                    if (immunizationType != null) {
                        condition.getImmunization().add(immunizationType);
                    }
                }
                if (enc.getEncounterType().getEncounterTypeId() == Utils.Child_Followup_Encounter_Type_Id) {
                    InfantPCRTestingType infantPCRTestingType = pmtctDictionary.createInfantPcr(patient, enc, obsList);
                    if (infantPCRTestingType != null) {
                        condition.getInfantPCRTesting().add(infantPCRTestingType);
                    }
                }
                /*if (enc.getEncounterType().getEncounterTypeId() == Utils.Partner_register_Encounter_Id) {
                    HealthFacilityVisitsType healthFacilityVisitsType = htsDictionary.createHealthFacilityVisit(patient, enc, obsList);
                    if (healthFacilityVisitsType != null) {
                        condition.getHealthFacilityVisits().add(healthFacilityVisitsType);
                    }
                }*/
                /*if(ArrayUtils.contains(Utils.Pmtcp_Encounter_Type_Ids, enc.getEncounterType().getEncounterTypeId())) {
                    //create child follow up, child birth details, immunization, infant_pcr, infant rapid testing, health facility visits
                    ChildBirthDetailsType childBirthDetailsType = pmtctDictionary.createChildBirthDetailsType(patient, enc, obsList);
                    condition.getChildBirthDetails().add(childBirthDetailsType);
                    ChildFollowupType childFollowupType = pmtctDictionary.createChildFollowupType(patient, enc, obsList);
                    condition.getChildFollowup().add(childFollowupType);
                }*/

                //add pregnancy records
                /*if(enc.getEncounterType().getEncounterTypeId() == 0){ // pregnancy registration type
					 pregnancyEncounter =  pmtctDictionary.createPregnancyRecord(patient, enc);
					if(pregnancyEncounter !=null){
						condition.getPregnancyRecord().add(pregnancyEncounter);
					}
				}

				if(enc.getEncounterType().getEncounterTypeId() == Utils.Client_Intake_Form_Encounter_Type_Id){ //change to HTC encounter type
					hivTestingEncounter = htsDictionary.createHIVTestingEncounter(patient, enc);
					if(hivTestingEncounter !=null){
						condition.getHIVTestRecords().add(hivTestingEncounter);
					}
				}*/

                long endTime = System.currentTimeMillis();
                if((endTime - startTime) > 1000){
                    System.out.println("took too loooong to get obs : " + (endTime - startTime) + " milli secs : ");
                }
            }
            condition.getRegimen().addAll(arvRegimenTypeList);
            //create the HIV Questions from the conditions specific obs
            ConditionSpecificQuestionsType hivSpecificQuestions = new ConditionSpecificQuestionsType();
            HIVQuestionsType hivQuestionsType = new NDRMainDictionary().createHIVQuestionType(patient, conditionSpecificQObs);
            if(null == hivQuestionsType) {
                hivSpecificQuestions.setHIVQuestions(hivQuestionsType);
                //createHIVQuestionsType(conditionSpecificQObs));
                condition.setConditionSpecificQuestions(hivSpecificQuestions);
            }
            return condition;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
	
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
		if (pa != null) {
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
					String name = result.getString("name");
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
				LoggerUtils.write(NDRMainDictionary.class.getName(), e.getMessage(), LogFormat.FATAL, LogLevel.live);
			}
		}
		return p;
	}
	
	private List<RegimenType> createRegimens(Encounter enc, List<Obs> obs) throws DatatypeConfigurationException {
        
        List<RegimenType> regimenList = new ArrayList<>();
        PharmacyDictionary dict = new PharmacyDictionary();
        //regimenList.add(dict.createRegimenType(patient, enc, obs));
        regimenList.addAll(dict.createOITypes(patient, enc, obs));
        return regimenList;
    }
       
	
	/*

	private HIVQuestionsType createHIVQuestionsType(List<Obs> obs) throws DatatypeConfigurationException {
		return new NDRMainDictionary().createHIVQuestionType(patient, obs);
	}

	private LaboratoryReportType createLaboratoryReportTypes(Encounter enc, List<Obs> obs)
	        throws DatatypeConfigurationException {
		return new LabDictionary().createLaboratoryOrderAndResult(patient, enc, obs);
	}*/
	private PatientDemographicsType createPatientDemographicsType() throws DatatypeConfigurationException {
		
		return new NDRMainDictionary().createPatientDemographicsType(patient, facility, openmrsConn);
	}
	
	private CommonQuestionsType createCommonQuestionsType() throws DatatypeConfigurationException {
		
		return new NDRMainDictionary().createCommonQuestionType(patient);
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
