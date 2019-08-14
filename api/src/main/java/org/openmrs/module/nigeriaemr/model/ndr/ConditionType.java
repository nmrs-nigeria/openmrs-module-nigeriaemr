package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java class for ConditionType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConditionCode" type="{}CodeType"/>
 *         &lt;element name="ProgramArea" type="{}ProgramAreaType"/>
 *         &lt;element name="PatientAddress" type="{}AddressType" minOccurs="0"/>
 *         &lt;element name="CommonQuestions" type="{}CommonQuestionsType" minOccurs="0"/>
 *         &lt;element name="ConditionSpecificQuestions" type="{}ConditionSpecificQuestionsType" minOccurs="0"/>
 *         &lt;element name="Encounters" type="{}EncountersType" minOccurs="0"/>
 *         &lt;element name="LaboratoryReport" type="{}LaboratoryReportType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Regimen" type="{}RegimenType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Immunization" type="{}ImmunizationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionType", propOrder = { "conditionCode", "programArea", "patientAddress", "commonQuestions",
        "conditionSpecificQuestions", "encounters", "laboratoryReport", "regimen", "immunization", "childBirthDetails",
        "childFollowup", "knowledgeAssessment", "hIVRiskAssessment", "clinicalTBScreening", "syndromicSTIScreening",
        "postTestCounselling", "partnerDetails", "infantPCRTesting", "healthFacilityVisits" })
public class ConditionType {
	
	@XmlElement(name = "ConditionCode", required = true)
	protected String conditionCode;
	
	@XmlElement(name = "ProgramArea", required = true)
	protected ProgramAreaType programArea;
	
	@XmlElement(name = "PatientAddress")
	protected AddressType patientAddress;
	
	@XmlElement(name = "CommonQuestions")
	protected CommonQuestionsType commonQuestions;
	
	@XmlElement(name = "ConditionSpecificQuestions")
	protected ConditionSpecificQuestionsType conditionSpecificQuestions;
	
	@XmlElement(name = "Encounters")
	protected EncountersType encounters;
	
	@XmlElement(name = "LaboratoryReport")
	protected List<LaboratoryReportType> laboratoryReport;
	
	@XmlElement(name = "Regimen")
	protected List<RegimenType> regimen;
	
	@XmlElement(name = "Immunization")
	protected List<ImmunizationType> immunization;
	
	@XmlElement(name = "ChildBirthDetails")
	protected List<ChildBirthDetailsType> childBirthDetails;
	
	@XmlElement(name = "ChildFollowup")
	protected List<ChildFollowupType> childFollowup;
	
	@XmlElement(name = "KnowledgeAssessment")
	protected List<KnowledgeAssessmentType> knowledgeAssessment;
	
	@XmlElement(name = "HIVRiskAssessment")
	protected List<HIVRiskAssessmentType> hIVRiskAssessment;
	
	@XmlElement(name = "ClinicalTBScreening")
	protected List<ClinicalTBScreeningType> clinicalTBScreening;
	
	@XmlElement(name = "SyndromicSTIScreening")
	protected List<SyndromicSTIScreeningType> syndromicSTIScreening;
	
	@XmlElement(name = "PostTestCounselling")
	protected List<PostTestCounsellingType> postTestCounselling;
	
	@XmlElement(name = "PartnerDetails")
	protected List<PartnerDetailsType> partnerDetails;
	
	@XmlElement(name = "InfantPCRTesting")
	protected List<InfantPCRTestingType> infantPCRTesting;
	
	@XmlElement(name = "HealthFacilityVisits")
	protected List<HealthFacilityVisitsType> healthFacilityVisits;
	
	/**
	 * Gets the value of the conditionCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getConditionCode() {
		return conditionCode;
	}
	
	/**
	 * Sets the value of the conditionCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setConditionCode(String value) {
		this.conditionCode = value;
	}
	
	/**
	 * Gets the value of the programArea property.
	 * 
	 * @return possible object is {@link ProgramAreaType }
	 */
	public ProgramAreaType getProgramArea() {
		return programArea;
	}
	
	/**
	 * Sets the value of the programArea property.
	 * 
	 * @param value allowed object is {@link ProgramAreaType }
	 */
	public void setProgramArea(ProgramAreaType value) {
		this.programArea = value;
	}
	
	/**
	 * Gets the value of the patientAddress property.
	 * 
	 * @return possible object is {@link AddressType }
	 */
	public AddressType getPatientAddress() {
		return patientAddress;
	}
	
	/**
	 * Sets the value of the patientAddress property.
	 * 
	 * @param value allowed object is {@link AddressType }
	 */
	public void setPatientAddress(AddressType value) {
		this.patientAddress = value;
	}
	
	/**
	 * Gets the value of the commonQuestions property.
	 * 
	 * @return possible object is {@link CommonQuestionsType }
	 */
	public CommonQuestionsType getCommonQuestions() {
		return commonQuestions;
	}
	
	/**
	 * Sets the value of the commonQuestions property.
	 * 
	 * @param value allowed object is {@link CommonQuestionsType }
	 */
	public void setCommonQuestions(CommonQuestionsType value) {
		this.commonQuestions = value;
	}
	
	/**
	 * Gets the value of the conditionSpecificQuestions property.
	 * 
	 * @return possible object is {@link ConditionSpecificQuestionsType }
	 */
	public ConditionSpecificQuestionsType getConditionSpecificQuestions() {
		return conditionSpecificQuestions;
	}
	
	/**
	 * Sets the value of the conditionSpecificQuestions property.
	 * 
	 * @param value allowed object is {@link ConditionSpecificQuestionsType }
	 */
	public void setConditionSpecificQuestions(ConditionSpecificQuestionsType value) {
		this.conditionSpecificQuestions = value;
	}
	
	/**
	 * Gets the value of the encounters property.
	 * 
	 * @return possible object is {@link EncountersType }
	 */
	public EncountersType getEncounters() {
		return encounters;
	}
	
	/**
	 * Sets the value of the encounters property.
	 * 
	 * @param value allowed object is {@link EncountersType }
	 */
	public void setEncounters(EncountersType value) {
		this.encounters = value;
	}
	
	/**
	 * Gets the value of the laboratoryReport property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the laboratoryReport property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getLaboratoryReport().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link LaboratoryReportType }
	 */
	public List<LaboratoryReportType> getLaboratoryReport() {
		if (laboratoryReport == null) {
			laboratoryReport = new ArrayList<LaboratoryReportType>();
		}
		return this.laboratoryReport;
	}
	
	/**
	 * Gets the value of the regimen property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the regimen property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getRegimen().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link RegimenType }
	 */
	public List<RegimenType> getRegimen() {
		if (regimen == null) {
			regimen = new ArrayList<RegimenType>();
		}
		return this.regimen;
	}
	
	/**
	 * Gets the value of the immunization property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the immunization property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getImmunization().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ImmunizationType }
	 */
	public List<ImmunizationType> getImmunization() {
		if (immunization == null) {
			immunization = new ArrayList<ImmunizationType>();
		}
		return this.immunization;
	}
	
	public List<ChildBirthDetailsType> getChildBirthDetails() {
		if (childBirthDetails == null) {
			childBirthDetails = new ArrayList<ChildBirthDetailsType>();
		}
		return this.childBirthDetails;
	}
	
	public List<ChildFollowupType> getChildFollowup() {
		if (childFollowup == null) {
			childFollowup = new ArrayList<ChildFollowupType>();
		}
		return this.childFollowup;
	}
	
	public List<KnowledgeAssessmentType> getKnowledgeAssessment() {
		if (knowledgeAssessment == null) {
			knowledgeAssessment = new ArrayList<KnowledgeAssessmentType>();
			
		}
		return this.knowledgeAssessment;
	}
	
	public List<HIVRiskAssessmentType> getHIVRiskAssessment() {
		if (hIVRiskAssessment == null) {
			hIVRiskAssessment = new ArrayList<HIVRiskAssessmentType>();
			
		}
		return this.hIVRiskAssessment;
	}
	
	public List<ClinicalTBScreeningType> getClinicalTBScreening() {
		if (clinicalTBScreening == null) {
			clinicalTBScreening = new ArrayList<ClinicalTBScreeningType>();
			
		}
		return this.clinicalTBScreening;
	}
	
	public List<SyndromicSTIScreeningType> getSyndromicSTIScreening() {
		if (syndromicSTIScreening == null) {
			syndromicSTIScreening = new ArrayList<SyndromicSTIScreeningType>();
			
		}
		return this.syndromicSTIScreening;
	}
	
	public List<PostTestCounsellingType> getPostTestCounselling() {
		if (postTestCounselling == null) {
			postTestCounselling = new ArrayList<PostTestCounsellingType>();
			
		}
		return this.postTestCounselling;
	}
	
	public List<PartnerDetailsType> getPartnerDetailsType() {
		if (partnerDetails == null) {
			partnerDetails = new ArrayList<PartnerDetailsType>();
			
		}
		return this.partnerDetails;
	}
	
	public List<InfantPCRTestingType> getInfantPCRTesting() {
		if (infantPCRTesting == null) {
			infantPCRTesting = new ArrayList<InfantPCRTestingType>();
			
		}
		return this.infantPCRTesting;
	}
	
	public List<HealthFacilityVisitsType> getHealthFacilityVisits() {
		if (healthFacilityVisits == null) {
			healthFacilityVisits = new ArrayList<HealthFacilityVisitsType>();
			
		}
		return this.healthFacilityVisits;
	}
	
}
