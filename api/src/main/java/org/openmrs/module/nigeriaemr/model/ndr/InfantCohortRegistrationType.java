package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantCohortRegistrationType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantCohortRegistrationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateOfFirstVisit" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="AgeAtFirstVisit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ChildHospitalRegNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfantSex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ChildEntryPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ANC"/>
 *               &lt;enumeration value="LD"/>
 *               &lt;enumeration value="Postnatal"/>
 *               &lt;enumeration value="Immunization"/>
 *               &lt;enumeration value="OPD"/>
 *               &lt;enumeration value="Inpatient"/>
 *               &lt;enumeration value="Nutrition"/>
 *               &lt;enumeration value="FamilyPlanning"/>
 *               &lt;enumeration value="TransferIn"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MotherHospitalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MotherANCNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MotherStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="HIV+"/>
 *               &lt;enumeration value="Syphilis+"/>
 *               &lt;enumeration value="HepatitisB+"/>
 *               &lt;enumeration value="HIVSyphilis+"/>
 *               &lt;enumeration value="HIVHBV+"/>
 *               &lt;enumeration value="SyphilisHBV+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MotherARTInitiationTiming" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="PriorOnPregnancy"/>
 *               &lt;enumeration value="InitiatedLessThan36Weeks"/>
 *               &lt;enumeration value="InitiatedGreaterThan36Weeks"/>
 *               &lt;enumeration value="InitiatedAtLabourAndDelivery"/>
 *               &lt;enumeration value="InitiatedAfterDelivery"/>
 *               &lt;enumeration value="None"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MotherHIVARTRegimen" type="{}MotherCurrentARTRegimenType" minOccurs="0"/>
 *         &lt;element name="MotherSyphilisTreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="MotherHepatitisBTreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="InfantHBVProphylaxis" type="{}InfantHBVProphylaxisType" minOccurs="0"/>
 *         &lt;element name="InfantARVProphylaxisType" type="{}InfantARVProphylaxisType" minOccurs="0"/>
 *         &lt;element name="InfantARVProphylaxisTiming" type="{}InfantARVProphylaxisTimingType" minOccurs="0"/>
 *         &lt;element name="CTXAgeCategory" type="{}CTXAgeCategoryType" minOccurs="0"/>
 *         &lt;element name="FirstPCR" type="{}PCRTestType" minOccurs="0"/>
 *         &lt;element name="SecondPCR" type="{}ConfirmatoryPCRType" minOccurs="0"/>
 *         &lt;element name="ThirdPCR" type="{}ConfirmatoryPCRType" minOccurs="0"/>
 *         &lt;element name="ConfirmatoryPCR" type="{}ConfirmatoryPCRType" minOccurs="0"/>
 *         &lt;element name="RapidAntibodyTest" type="{}InfantRapidAntibodyTestType" minOccurs="0"/>
 *         &lt;element name="OutcomeAt18Months" type="{}InfantOutcomeStatusType" minOccurs="0"/>
 *         &lt;element name="ARTEnrollment" type="{}InfantARTEnrollmentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantCohortRegistrationType", propOrder = { "dateOfBirth", "dateOfFirstVisit", "ageAtFirstVisit",
        "childHospitalRegNo", "infantSex", "childEntryPoint", "motherHospitalNumber", "motherANCNumber", "motherStatus",
        "motherARTInitiationTiming", "motherHIVARTRegimen", "motherSyphilisTreatmentStartDate",
        "motherHepatitisBTreatmentStartDate", "infantHBVProphylaxis", "infantARVProphylaxisType",
        "infantARVProphylaxisTiming", "ctxAgeCategory", "firstPCR", "secondPCR", "thirdPCR", "confirmatoryPCR",
        "rapidAntibodyTest", "outcomeAt18Months", "artEnrollment" })
public class InfantCohortRegistrationType {
	
	@XmlElement(name = "DateOfBirth")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfBirth;
	
	@XmlElement(name = "DateOfFirstVisit")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfFirstVisit;
	
	@XmlElement(name = "AgeAtFirstVisit")
	protected Integer ageAtFirstVisit;
	
	@XmlElement(name = "ChildHospitalRegNo")
	protected String childHospitalRegNo;
	
	@XmlElement(name = "InfantSex")
	protected String infantSex;
	
	@XmlElement(name = "ChildEntryPoint")
	protected String childEntryPoint;
	
	@XmlElement(name = "MotherHospitalNumber")
	protected String motherHospitalNumber;
	
	@XmlElement(name = "MotherANCNumber")
	protected String motherANCNumber;
	
	@XmlElement(name = "MotherStatus")
	protected String motherStatus;
	
	@XmlElement(name = "MotherARTInitiationTiming")
	protected String motherARTInitiationTiming;
	
	@XmlElement(name = "MotherHIVARTRegimen")
	protected MotherCurrentARTRegimenType motherHIVARTRegimen;
	
	@XmlElement(name = "MotherSyphilisTreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar motherSyphilisTreatmentStartDate;
	
	@XmlElement(name = "MotherHepatitisBTreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar motherHepatitisBTreatmentStartDate;
	
	@XmlElement(name = "InfantHBVProphylaxis")
	protected InfantHBVProphylaxisType infantHBVProphylaxis;
	
	@XmlElement(name = "InfantARVProphylaxisType")
	@XmlSchemaType(name = "string")
	protected InfantARVProphylaxisType infantARVProphylaxisType;
	
	@XmlElement(name = "InfantARVProphylaxisTiming")
	@XmlSchemaType(name = "string")
	protected InfantARVProphylaxisTimingType infantARVProphylaxisTiming;
	
	@XmlElement(name = "CTXAgeCategory")
	@XmlSchemaType(name = "string")
	protected CTXAgeCategoryType ctxAgeCategory;
	
	@XmlElement(name = "FirstPCR")
	protected PCRTestType firstPCR;
	
	@XmlElement(name = "SecondPCR")
	protected ConfirmatoryPCRType secondPCR;
	
	@XmlElement(name = "ThirdPCR")
	protected ConfirmatoryPCRType thirdPCR;
	
	@XmlElement(name = "ConfirmatoryPCR")
	protected ConfirmatoryPCRType confirmatoryPCR;
	
	@XmlElement(name = "RapidAntibodyTest")
	protected InfantRapidAntibodyTestType rapidAntibodyTest;
	
	@XmlElement(name = "OutcomeAt18Months")
	@XmlSchemaType(name = "string")
	protected InfantOutcomeStatusType outcomeAt18Months;
	
	@XmlElement(name = "ARTEnrollment")
	protected InfantARTEnrollmentType artEnrollment;
	
	/**
	 * Gets the value of the dateOfBirth property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets the value of the dateOfBirth property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfBirth(XMLGregorianCalendar value) {
		this.dateOfBirth = value;
	}
	
	/**
	 * Gets the value of the dateOfFirstVisit property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfFirstVisit() {
		return dateOfFirstVisit;
	}
	
	/**
	 * Sets the value of the dateOfFirstVisit property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfFirstVisit(XMLGregorianCalendar value) {
		this.dateOfFirstVisit = value;
	}
	
	/**
	 * Gets the value of the ageAtFirstVisit property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getAgeAtFirstVisit() {
		return ageAtFirstVisit;
	}
	
	/**
	 * Sets the value of the ageAtFirstVisit property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setAgeAtFirstVisit(Integer value) {
		this.ageAtFirstVisit = value;
	}
	
	/**
	 * Gets the value of the childHospitalRegNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildHospitalRegNo() {
		return childHospitalRegNo;
	}
	
	/**
	 * Sets the value of the childHospitalRegNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildHospitalRegNo(String value) {
		this.childHospitalRegNo = value;
	}
	
	/**
	 * Gets the value of the infantSex property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInfantSex() {
		return infantSex;
	}
	
	/**
	 * Sets the value of the infantSex property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInfantSex(String value) {
		this.infantSex = value;
	}
	
	/**
	 * Gets the value of the childEntryPoint property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildEntryPoint() {
		return childEntryPoint;
	}
	
	/**
	 * Sets the value of the childEntryPoint property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildEntryPoint(String value) {
		this.childEntryPoint = value;
	}
	
	/**
	 * Gets the value of the motherHospitalNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherHospitalNumber() {
		return motherHospitalNumber;
	}
	
	/**
	 * Sets the value of the motherHospitalNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherHospitalNumber(String value) {
		this.motherHospitalNumber = value;
	}
	
	/**
	 * Gets the value of the motherANCNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherANCNumber() {
		return motherANCNumber;
	}
	
	/**
	 * Sets the value of the motherANCNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherANCNumber(String value) {
		this.motherANCNumber = value;
	}
	
	/**
	 * Gets the value of the motherStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherStatus() {
		return motherStatus;
	}
	
	/**
	 * Sets the value of the motherStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherStatus(String value) {
		this.motherStatus = value;
	}
	
	/**
	 * Gets the value of the motherARTInitiationTiming property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherARTInitiationTiming() {
		return motherARTInitiationTiming;
	}
	
	/**
	 * Sets the value of the motherARTInitiationTiming property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherARTInitiationTiming(String value) {
		this.motherARTInitiationTiming = value;
	}
	
	/**
	 * Gets the value of the motherHIVARTRegimen property.
	 * 
	 * @return possible object is {@link MotherCurrentARTRegimenType }
	 */
	public MotherCurrentARTRegimenType getMotherHIVARTRegimen() {
		return motherHIVARTRegimen;
	}
	
	/**
	 * Sets the value of the motherHIVARTRegimen property.
	 * 
	 * @param value allowed object is {@link MotherCurrentARTRegimenType }
	 */
	public void setMotherHIVARTRegimen(MotherCurrentARTRegimenType value) {
		this.motherHIVARTRegimen = value;
	}
	
	/**
	 * Gets the value of the motherSyphilisTreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMotherSyphilisTreatmentStartDate() {
		return motherSyphilisTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the motherSyphilisTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMotherSyphilisTreatmentStartDate(XMLGregorianCalendar value) {
		this.motherSyphilisTreatmentStartDate = value;
	}
	
	/**
	 * Gets the value of the motherHepatitisBTreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMotherHepatitisBTreatmentStartDate() {
		return motherHepatitisBTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the motherHepatitisBTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMotherHepatitisBTreatmentStartDate(XMLGregorianCalendar value) {
		this.motherHepatitisBTreatmentStartDate = value;
	}
	
	/**
	 * Gets the value of the infantHBVProphylaxis property.
	 * 
	 * @return possible object is {@link InfantHBVProphylaxisType }
	 */
	public InfantHBVProphylaxisType getInfantHBVProphylaxis() {
		return infantHBVProphylaxis;
	}
	
	/**
	 * Sets the value of the infantHBVProphylaxis property.
	 * 
	 * @param value allowed object is {@link InfantHBVProphylaxisType }
	 */
	public void setInfantHBVProphylaxis(InfantHBVProphylaxisType value) {
		this.infantHBVProphylaxis = value;
	}
	
	/**
	 * Gets the value of the infantARVProphylaxisType property.
	 * 
	 * @return possible object is {@link InfantARVProphylaxisType }
	 */
	public InfantARVProphylaxisType getInfantARVProphylaxisType() {
		return infantARVProphylaxisType;
	}
	
	/**
	 * Sets the value of the infantARVProphylaxisType property.
	 * 
	 * @param value allowed object is {@link InfantARVProphylaxisType }
	 */
	public void setInfantARVProphylaxisType(InfantARVProphylaxisType value) {
		this.infantARVProphylaxisType = value;
	}
	
	/**
	 * Gets the value of the infantARVProphylaxisTiming property.
	 * 
	 * @return possible object is {@link InfantARVProphylaxisTimingType }
	 */
	public InfantARVProphylaxisTimingType getInfantARVProphylaxisTiming() {
		return infantARVProphylaxisTiming;
	}
	
	/**
	 * Sets the value of the infantARVProphylaxisTiming property.
	 * 
	 * @param value allowed object is {@link InfantARVProphylaxisTimingType }
	 */
	public void setInfantARVProphylaxisTiming(InfantARVProphylaxisTimingType value) {
		this.infantARVProphylaxisTiming = value;
	}
	
	/**
	 * Gets the value of the ctxAgeCategory property.
	 * 
	 * @return possible object is {@link CTXAgeCategoryType }
	 */
	public CTXAgeCategoryType getCTXAgeCategory() {
		return ctxAgeCategory;
	}
	
	/**
	 * Sets the value of the ctxAgeCategory property.
	 * 
	 * @param value allowed object is {@link CTXAgeCategoryType }
	 */
	public void setCTXAgeCategory(CTXAgeCategoryType value) {
		this.ctxAgeCategory = value;
	}
	
	/**
	 * Gets the value of the firstPCR property.
	 * 
	 * @return possible object is {@link PCRTestType }
	 */
	public PCRTestType getFirstPCR() {
		return firstPCR;
	}
	
	/**
	 * Sets the value of the firstPCR property.
	 * 
	 * @param value allowed object is {@link PCRTestType }
	 */
	public void setFirstPCR(PCRTestType value) {
		this.firstPCR = value;
	}
	
	/**
	 * Gets the value of the secondPCR property.
	 * 
	 * @return possible object is {@link ConfirmatoryPCRType }
	 */
	public ConfirmatoryPCRType getSecondPCR() {
		return secondPCR;
	}
	
	/**
	 * Sets the value of the secondPCR property.
	 * 
	 * @param value allowed object is {@link ConfirmatoryPCRType }
	 */
	public void setSecondPCR(ConfirmatoryPCRType value) {
		this.secondPCR = value;
	}
	
	/**
	 * Gets the value of the thirdPCR property.
	 * 
	 * @return possible object is {@link ConfirmatoryPCRType }
	 */
	public ConfirmatoryPCRType getThirdPCR() {
		return thirdPCR;
	}
	
	/**
	 * Sets the value of the thirdPCR property.
	 * 
	 * @param value allowed object is {@link ConfirmatoryPCRType }
	 */
	public void setThirdPCR(ConfirmatoryPCRType value) {
		this.thirdPCR = value;
	}
	
	/**
	 * Gets the value of the confirmatoryPCR property.
	 * 
	 * @return possible object is {@link ConfirmatoryPCRType }
	 */
	public ConfirmatoryPCRType getConfirmatoryPCR() {
		return confirmatoryPCR;
	}
	
	/**
	 * Sets the value of the confirmatoryPCR property.
	 * 
	 * @param value allowed object is {@link ConfirmatoryPCRType }
	 */
	public void setConfirmatoryPCR(ConfirmatoryPCRType value) {
		this.confirmatoryPCR = value;
	}
	
	/**
	 * Gets the value of the rapidAntibodyTest property.
	 * 
	 * @return possible object is {@link InfantRapidAntibodyTestType }
	 */
	public InfantRapidAntibodyTestType getRapidAntibodyTest() {
		return rapidAntibodyTest;
	}
	
	/**
	 * Sets the value of the rapidAntibodyTest property.
	 * 
	 * @param value allowed object is {@link InfantRapidAntibodyTestType }
	 */
	public void setRapidAntibodyTest(InfantRapidAntibodyTestType value) {
		this.rapidAntibodyTest = value;
	}
	
	/**
	 * Gets the value of the outcomeAt18Months property.
	 * 
	 * @return possible object is {@link InfantOutcomeStatusType }
	 */
	public InfantOutcomeStatusType getOutcomeAt18Months() {
		return outcomeAt18Months;
	}
	
	/**
	 * Sets the value of the outcomeAt18Months property.
	 * 
	 * @param value allowed object is {@link InfantOutcomeStatusType }
	 */
	public void setOutcomeAt18Months(InfantOutcomeStatusType value) {
		this.outcomeAt18Months = value;
	}
	
	/**
	 * Gets the value of the artEnrollment property.
	 * 
	 * @return possible object is {@link InfantARTEnrollmentType }
	 */
	public InfantARTEnrollmentType getARTEnrollment() {
		return artEnrollment;
	}
	
	/**
	 * Sets the value of the artEnrollment property.
	 * 
	 * @param value allowed object is {@link InfantARTEnrollmentType }
	 */
	public void setARTEnrollment(InfantARTEnrollmentType value) {
		this.artEnrollment = value;
	}
	
}
