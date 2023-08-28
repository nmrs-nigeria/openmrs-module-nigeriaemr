package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for HIVQuestionsType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVQuestionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CareEntryPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *               &lt;enumeration value="12"/>
 *               &lt;enumeration value="13"/>
 *               &lt;enumeration value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstConfirmedHIVTestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FirstHIVTestMode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="HIVAb"/>
 *               &lt;enumeration value="HIVPCR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WhereFirstHIVTest" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="PriorArt" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="MedicallyEligibleDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonMedicallyEligible" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InitialAdherenceCounselingCompletedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PatientTransferredIn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TransferredInDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TransferredInFrom" type="{}FacilityType" minOccurs="0"/>
 *         &lt;element name="TransferredInFromPatId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstARTRegimen" type="{}CodedSimpleType" minOccurs="0"/>
 *         &lt;element name="ARTStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="WHOClinicalStageARTStart" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="II"/>
 *               &lt;enumeration value="III"/>
 *               &lt;enumeration value="IV"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WeightAtARTStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ChildHeightAtARTStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FunctionalStatusStartART" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="W"/>
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="B"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CD4AtStartOfART" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="PatientTransferredOut" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TransferredOutStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransferredOutDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FacilityReferredTo" type="{}FacilityType" minOccurs="0"/>
 *         &lt;element name="PatientHasDied" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StatusAtDeath" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeathDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SourceOfDeathInformation" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="CauseOfDeathHIVRelated" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="U"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CauseOfDeath" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="B24"/>
 *               &lt;enumeration value="A09"/>
 *               &lt;enumeration value="B54"/>
 *               &lt;enumeration value="O95"/>
 *               &lt;enumeration value="B99"/>
 *               &lt;enumeration value="J22"/>
 *               &lt;enumeration value="A16"/>
 *               &lt;enumeration value="I24"/>
 *               &lt;enumeration value="C50"/>
 *               &lt;enumeration value="J44"/>
 *               &lt;enumeration value="C53"/>
 *               &lt;enumeration value="K74"/>
 *               &lt;enumeration value="C18"/>
 *               &lt;enumeration value="E14"/>
 *               &lt;enumeration value="C15"/>
 *               &lt;enumeration value="C96"/>
 *               &lt;enumeration value="C34"/>
 *               &lt;enumeration value="I99"/>
 *               &lt;enumeration value="UU1"/>
 *               &lt;enumeration value="C61"/>
 *               &lt;enumeration value="N18"/>
 *               &lt;enumeration value="C16"/>
 *               &lt;enumeration value="I64"/>
 *               &lt;enumeration value="C76"/>
 *               &lt;enumeration value="X27"/>
 *               &lt;enumeration value="W74"/>
 *               &lt;enumeration value="W19"/>
 *               &lt;enumeration value="X09"/>
 *               &lt;enumeration value="Y09"/>
 *               &lt;enumeration value="X58"/>
 *               &lt;enumeration value="X49"/>
 *               &lt;enumeration value="V89"/>
 *               &lt;enumeration value="X84"/>
 *               &lt;enumeration value="G04"/>
 *               &lt;enumeration value="A99"/>
 *               &lt;enumeration value="B05"/>
 *               &lt;enumeration value="G03"/>
 *               &lt;enumeration value="A41"/>
 *               &lt;enumeration value="UU2"/>
 *               &lt;enumeration value="K92"/>
 *               &lt;enumeration value="P21"/>
 *               &lt;enumeration value="Q89"/>
 *               &lt;enumeration value="P36"/>
 *               &lt;enumeration value="P23"/>
 *               &lt;enumeration value="P07"/>
 *               &lt;enumeration value="P95"/>
 *               &lt;enumeration value="R99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DrugAllergies" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="EnrolledInHIVCareDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="InitialTBStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StoppedTreatment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DateStoppedTreatment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForStoppedTreatment" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TBTreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVQuestionsType", propOrder = { "careEntryPoint", "firstConfirmedHIVTestDate", "firstHIVTestMode",
        "whereFirstHIVTest", "priorArt", "medicallyEligibleDate", "reasonMedicallyEligible",
        "initialAdherenceCounselingCompletedDate", "patientTransferredIn", "transferredInDate", "transferredInFrom",
        "transferredInFromPatId", "firstARTRegimen", "artStartDate", "whoClinicalStageARTStart", "weightAtARTStart",
        "childHeightAtARTStart", "functionalStatusStartART", "cd4AtStartOfART", "patientTransferredOut",
        "transferredOutStatus", "transferredOutDate", "facilityReferredTo", "patientHasDied", "statusAtDeath", "deathDate",
        "sourceOfDeathInformation", "causeOfDeathHIVRelated", "causeOfDeath", "drugAllergies", "enrolledInHIVCareDate",
        "initialTBStatus", "stoppedTreatment", "dateStoppedTreatment", "reasonForStoppedTreatment", "tbTreatmentStartDate" })
public class HIVQuestionsType {
	
	@XmlElement(name = "CareEntryPoint")
	protected String careEntryPoint;
	
	@XmlElement(name = "FirstConfirmedHIVTestDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar firstConfirmedHIVTestDate;
	
	@XmlElement(name = "FirstHIVTestMode")
	protected String firstHIVTestMode;
	
	@XmlElement(name = "WhereFirstHIVTest")
	protected String whereFirstHIVTest;
	
	@XmlElement(name = "PriorArt")
	protected String priorArt;
	
	@XmlElement(name = "MedicallyEligibleDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar medicallyEligibleDate;
	
	@XmlElement(name = "ReasonMedicallyEligible")
	protected String reasonMedicallyEligible;
	
	@XmlElement(name = "InitialAdherenceCounselingCompletedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar initialAdherenceCounselingCompletedDate;
	
	@XmlElement(name = "PatientTransferredIn")
	protected Boolean patientTransferredIn;
	
	@XmlElement(name = "TransferredInDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar transferredInDate;
	
	@XmlElement(name = "TransferredInFrom")
	protected FacilityType transferredInFrom;
	
	@XmlElement(name = "TransferredInFromPatId")
	protected String transferredInFromPatId;
	
	@XmlElement(name = "FirstARTRegimen")
	protected CodedSimpleType firstARTRegimen;
	
	@XmlElement(name = "ARTStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar artStartDate;
	
	@XmlElement(name = "WHOClinicalStageARTStart")
	protected String whoClinicalStageARTStart;
	
	@XmlElement(name = "WeightAtARTStart")
	protected Integer weightAtARTStart;
	
	@XmlElement(name = "ChildHeightAtARTStart")
	protected Integer childHeightAtARTStart;
	
	@XmlElement(name = "FunctionalStatusStartART")
	protected String functionalStatusStartART;
	
	@XmlElement(name = "CD4AtStartOfART")
	protected String cd4AtStartOfART;
	
	@XmlElement(name = "PatientTransferredOut")
	protected Boolean patientTransferredOut;
	
	@XmlElement(name = "TransferredOutStatus")
	protected String transferredOutStatus;
	
	@XmlElement(name = "TransferredOutDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar transferredOutDate;
	
	@XmlElement(name = "FacilityReferredTo")
	protected FacilityType facilityReferredTo;
	
	@XmlElement(name = "PatientHasDied")
	protected Boolean patientHasDied;
	
	@XmlElement(name = "StatusAtDeath")
	protected String statusAtDeath;
	
	@XmlElement(name = "DeathDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar deathDate;
	
	@XmlElement(name = "SourceOfDeathInformation")
	protected String sourceOfDeathInformation;
	
	@XmlElement(name = "CauseOfDeathHIVRelated")
	protected String causeOfDeathHIVRelated;
	
	@XmlElement(name = "CauseOfDeath")
	protected String causeOfDeath;
	
	@XmlElement(name = "DrugAllergies")
	protected String drugAllergies;
	
	@XmlElement(name = "EnrolledInHIVCareDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar enrolledInHIVCareDate;
	
	@XmlElement(name = "InitialTBStatus")
	protected String initialTBStatus;
	
	@XmlElement(name = "StoppedTreatment")
	protected Boolean stoppedTreatment;
	
	@XmlElement(name = "DateStoppedTreatment")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateStoppedTreatment;
	
	@XmlElement(name = "ReasonForStoppedTreatment")
	protected String reasonForStoppedTreatment;
	
	@XmlElement(name = "TBTreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar tbTreatmentStartDate;
	
	/**
	 * Gets the value of the careEntryPoint property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCareEntryPoint() {
		return careEntryPoint;
	}
	
	/**
	 * Sets the value of the careEntryPoint property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCareEntryPoint(String value) {
		this.careEntryPoint = value;
	}
	
	/**
	 * Gets the value of the firstConfirmedHIVTestDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFirstConfirmedHIVTestDate() {
		return firstConfirmedHIVTestDate;
	}
	
	/**
	 * Sets the value of the firstConfirmedHIVTestDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFirstConfirmedHIVTestDate(XMLGregorianCalendar value) {
		this.firstConfirmedHIVTestDate = value;
	}
	
	/**
	 * Gets the value of the firstHIVTestMode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFirstHIVTestMode() {
		return firstHIVTestMode;
	}
	
	/**
	 * Sets the value of the firstHIVTestMode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFirstHIVTestMode(String value) {
		this.firstHIVTestMode = value;
	}
	
	/**
	 * Gets the value of the whereFirstHIVTest property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhereFirstHIVTest() {
		return whereFirstHIVTest;
	}
	
	/**
	 * Sets the value of the whereFirstHIVTest property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhereFirstHIVTest(String value) {
		this.whereFirstHIVTest = value;
	}
	
	/**
	 * Gets the value of the priorArt property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPriorArt() {
		return priorArt;
	}
	
	/**
	 * Sets the value of the priorArt property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPriorArt(String value) {
		this.priorArt = value;
	}
	
	/**
	 * Gets the value of the medicallyEligibleDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMedicallyEligibleDate() {
		return medicallyEligibleDate;
	}
	
	/**
	 * Sets the value of the medicallyEligibleDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMedicallyEligibleDate(XMLGregorianCalendar value) {
		this.medicallyEligibleDate = value;
	}
	
	/**
	 * Gets the value of the reasonMedicallyEligible property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonMedicallyEligible() {
		return reasonMedicallyEligible;
	}
	
	/**
	 * Sets the value of the reasonMedicallyEligible property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonMedicallyEligible(String value) {
		this.reasonMedicallyEligible = value;
	}
	
	/**
	 * Gets the value of the initialAdherenceCounselingCompletedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getInitialAdherenceCounselingCompletedDate() {
		return initialAdherenceCounselingCompletedDate;
	}
	
	/**
	 * Sets the value of the initialAdherenceCounselingCompletedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setInitialAdherenceCounselingCompletedDate(XMLGregorianCalendar value) {
		this.initialAdherenceCounselingCompletedDate = value;
	}
	
	/**
	 * Gets the value of the patientTransferredIn property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientTransferredIn() {
		return patientTransferredIn;
	}
	
	/**
	 * Sets the value of the patientTransferredIn property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientTransferredIn(Boolean value) {
		this.patientTransferredIn = value;
	}
	
	/**
	 * Gets the value of the transferredInDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTransferredInDate() {
		return transferredInDate;
	}
	
	/**
	 * Sets the value of the transferredInDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTransferredInDate(XMLGregorianCalendar value) {
		this.transferredInDate = value;
	}
	
	/**
	 * Gets the value of the transferredInFrom property.
	 * 
	 * @return possible object is {@link FacilityType }
	 */
	public FacilityType getTransferredInFrom() {
		return transferredInFrom;
	}
	
	/**
	 * Sets the value of the transferredInFrom property.
	 * 
	 * @param value allowed object is {@link FacilityType }
	 */
	public void setTransferredInFrom(FacilityType value) {
		this.transferredInFrom = value;
	}
	
	/**
	 * Gets the value of the transferredInFromPatId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredInFromPatId() {
		return transferredInFromPatId;
	}
	
	/**
	 * Sets the value of the transferredInFromPatId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredInFromPatId(String value) {
		this.transferredInFromPatId = value;
	}
	
	/**
	 * Gets the value of the firstARTRegimen property.
	 * 
	 * @return possible object is {@link CodedSimpleType }
	 */
	public CodedSimpleType getFirstARTRegimen() {
		return firstARTRegimen;
	}
	
	/**
	 * Sets the value of the firstARTRegimen property.
	 * 
	 * @param value allowed object is {@link CodedSimpleType }
	 */
	public void setFirstARTRegimen(CodedSimpleType value) {
		this.firstARTRegimen = value;
	}
	
	/**
	 * Gets the value of the artStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getARTStartDate() {
		return artStartDate;
	}
	
	/**
	 * Sets the value of the artStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setARTStartDate(XMLGregorianCalendar value) {
		this.artStartDate = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStageARTStart property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStageARTStart() {
		return whoClinicalStageARTStart;
	}
	
	/**
	 * Sets the value of the whoClinicalStageARTStart property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStageARTStart(String value) {
		this.whoClinicalStageARTStart = value;
	}
	
	/**
	 * Gets the value of the weightAtARTStart property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getWeightAtARTStart() {
		return weightAtARTStart;
	}
	
	/**
	 * Sets the value of the weightAtARTStart property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setWeightAtARTStart(Integer value) {
		this.weightAtARTStart = value;
	}
	
	/**
	 * Gets the value of the childHeightAtARTStart property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getChildHeightAtARTStart() {
		return childHeightAtARTStart;
	}
	
	/**
	 * Sets the value of the childHeightAtARTStart property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setChildHeightAtARTStart(Integer value) {
		this.childHeightAtARTStart = value;
	}
	
	/**
	 * Gets the value of the functionalStatusStartART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFunctionalStatusStartART() {
		return functionalStatusStartART;
	}
	
	/**
	 * Sets the value of the functionalStatusStartART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFunctionalStatusStartART(String value) {
		this.functionalStatusStartART = value;
	}
	
	/**
	 * Gets the value of the cd4AtStartOfART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4AtStartOfART() {
		return cd4AtStartOfART;
	}
	
	/**
	 * Sets the value of the cd4AtStartOfART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4AtStartOfART(String value) {
		this.cd4AtStartOfART = value;
	}
	
	/**
	 * Gets the value of the patientTransferredOut property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientTransferredOut() {
		return patientTransferredOut;
	}
	
	/**
	 * Sets the value of the patientTransferredOut property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientTransferredOut(Boolean value) {
		this.patientTransferredOut = value;
	}
	
	/**
	 * Gets the value of the transferredOutStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredOutStatus() {
		return transferredOutStatus;
	}
	
	/**
	 * Sets the value of the transferredOutStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredOutStatus(String value) {
		this.transferredOutStatus = value;
	}
	
	/**
	 * Gets the value of the transferredOutDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTransferredOutDate() {
		return transferredOutDate;
	}
	
	/**
	 * Sets the value of the transferredOutDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTransferredOutDate(XMLGregorianCalendar value) {
		this.transferredOutDate = value;
	}
	
	/**
	 * Gets the value of the facilityReferredTo property.
	 * 
	 * @return possible object is {@link FacilityType }
	 */
	public FacilityType getFacilityReferredTo() {
		return facilityReferredTo;
	}
	
	/**
	 * Sets the value of the facilityReferredTo property.
	 * 
	 * @param value allowed object is {@link FacilityType }
	 */
	public void setFacilityReferredTo(FacilityType value) {
		this.facilityReferredTo = value;
	}
	
	/**
	 * Gets the value of the patientHasDied property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientHasDied() {
		return patientHasDied;
	}
	
	/**
	 * Sets the value of the patientHasDied property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientHasDied(Boolean value) {
		this.patientHasDied = value;
	}
	
	/**
	 * Gets the value of the statusAtDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStatusAtDeath() {
		return statusAtDeath;
	}
	
	/**
	 * Sets the value of the statusAtDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStatusAtDeath(String value) {
		this.statusAtDeath = value;
	}
	
	/**
	 * Gets the value of the deathDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDeathDate() {
		return deathDate;
	}
	
	/**
	 * Sets the value of the deathDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDeathDate(XMLGregorianCalendar value) {
		this.deathDate = value;
	}
	
	/**
	 * Gets the value of the sourceOfDeathInformation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSourceOfDeathInformation() {
		return sourceOfDeathInformation;
	}
	
	/**
	 * Sets the value of the sourceOfDeathInformation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSourceOfDeathInformation(String value) {
		this.sourceOfDeathInformation = value;
	}
	
	/**
	 * Gets the value of the causeOfDeathHIVRelated property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeathHIVRelated() {
		return causeOfDeathHIVRelated;
	}
	
	/**
	 * Sets the value of the causeOfDeathHIVRelated property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeathHIVRelated(String value) {
		this.causeOfDeathHIVRelated = value;
	}
	
	/**
	 * Gets the value of the causeOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	
	/**
	 * Sets the value of the causeOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeath(String value) {
		this.causeOfDeath = value;
	}
	
	/**
	 * Gets the value of the drugAllergies property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDrugAllergies() {
		return drugAllergies;
	}
	
	/**
	 * Sets the value of the drugAllergies property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDrugAllergies(String value) {
		this.drugAllergies = value;
	}
	
	/**
	 * Gets the value of the enrolledInHIVCareDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getEnrolledInHIVCareDate() {
		return enrolledInHIVCareDate;
	}
	
	/**
	 * Sets the value of the enrolledInHIVCareDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setEnrolledInHIVCareDate(XMLGregorianCalendar value) {
		this.enrolledInHIVCareDate = value;
	}
	
	/**
	 * Gets the value of the initialTBStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInitialTBStatus() {
		return initialTBStatus;
	}
	
	/**
	 * Sets the value of the initialTBStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInitialTBStatus(String value) {
		this.initialTBStatus = value;
	}
	
	/**
	 * Gets the value of the stoppedTreatment property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isStoppedTreatment() {
		return stoppedTreatment;
	}
	
	/**
	 * Sets the value of the stoppedTreatment property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setStoppedTreatment(Boolean value) {
		this.stoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the dateStoppedTreatment property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateStoppedTreatment() {
		return dateStoppedTreatment;
	}
	
	/**
	 * Sets the value of the dateStoppedTreatment property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateStoppedTreatment(XMLGregorianCalendar value) {
		this.dateStoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the reasonForStoppedTreatment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForStoppedTreatment() {
		return reasonForStoppedTreatment;
	}
	
	/**
	 * Sets the value of the reasonForStoppedTreatment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForStoppedTreatment(String value) {
		this.reasonForStoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the tbTreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTBTreatmentStartDate() {
		return tbTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the tbTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTBTreatmentStartDate(XMLGregorianCalendar value) {
		this.tbTreatmentStartDate = value;
	}
	
}
