package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for HIVEncounterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVEncounterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DurationOnArt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ChildHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BloodPressure" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="EDDandPMTCTLink" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="PMTCT"/>
 *               &lt;enumeration value="NP"/>
 *               &lt;enumeration value="NK"/>
 *               &lt;enumeration value="BF"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientFamilyPlanningCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FP"/>
 *               &lt;enumeration value="NOFP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientFamilyPlanningMethodCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="FunctionalStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="W"/>
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="B"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WHOClinicalStage" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TBStatus" minOccurs="0">
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
 *         &lt;element name="OtherOIOtherProblems" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="NotedSideEffects" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="ARVDrugRegimen" type="{}CodedSimpleType" minOccurs="0"/>
 *         &lt;element name="ARVDrugAdherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WhyPoorFairARVDrugAdherence" minOccurs="0">
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
 *               &lt;enumeration value="15"/>
 *               &lt;enumeration value="16"/>
 *               &lt;enumeration value="17"/>
 *               &lt;enumeration value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CotrimoxazoleDose" type="{}CodedSimpleType" minOccurs="0"/>
 *         &lt;element name="CotrimoxazoleAdherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WhyPoorFairCotrimoxazoleDrugAdherence" minOccurs="0">
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
 *               &lt;enumeration value="15"/>
 *               &lt;enumeration value="16"/>
 *               &lt;enumeration value="17"/>
 *               &lt;enumeration value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="INHDose" type="{}CodedSimpleType" minOccurs="0"/>
 *         &lt;element name="INHAdherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WhyPoorFairINHDrugAdherence" minOccurs="0">
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
 *               &lt;enumeration value="15"/>
 *               &lt;enumeration value="16"/>
 *               &lt;enumeration value="17"/>
 *               &lt;enumeration value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CD4" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CD4TestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForRegimenSwitchSubs" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenInitialIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenCurrentIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TypeOfPreviousExposureCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PoorAdherenceIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReasonForPoorAdherence" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="ReasonRegimenEndedCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="SubstitutionIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SwitchIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NextAppointmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="StoppedRegimen" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DateStoppedRegimen" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForStoppedRegimen" minOccurs="0">
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
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MethodofTBDiagnosis" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M1"/>
 *               &lt;enumeration value="M2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVEncounterType", propOrder = { "visitID", "visitDate", "durationOnArt", "weight", "childHeight",
        "bloodPressure", "edDandPMTCTLink", "patientFamilyPlanningCode", "patientFamilyPlanningMethodCode",
        "functionalStatus", "whoClinicalStage", "tbStatus", "otherOIOtherProblems", "notedSideEffects", "arvDrugRegimen",
        "arvDrugAdherence", "whyPoorFairARVDrugAdherence", "cotrimoxazoleDose", "cotrimoxazoleAdherence",
        "whyPoorFairCotrimoxazoleDrugAdherence", "inhDose", "inhAdherence", "whyPoorFairINHDrugAdherence", "cd4",
        "cd4TestDate", "reasonForRegimenSwitchSubs", "prescribedRegimenInitialIndicator",
        "prescribedRegimenCurrentIndicator", "typeOfPreviousExposureCode", "poorAdherenceIndicator",
        "reasonForPoorAdherence", "reasonRegimenEndedCode", "substitutionIndicator", "switchIndicator",
        "nextAppointmentDate", "stoppedRegimen", "dateStoppedRegimen", "reasonForStoppedRegimen", "methodofTBDiagnosis" })
public class HIVEncounterType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "DurationOnArt")
	protected Integer durationOnArt;
	
	@XmlElement(name = "Weight")
	protected Integer weight;
	
	@XmlElement(name = "ChildHeight")
	protected Integer childHeight;
	
	@XmlElement(name = "BloodPressure")
	protected String bloodPressure;
	
	@XmlElement(name = "EDDandPMTCTLink")
	protected String edDandPMTCTLink;
	
	@XmlElement(name = "PatientFamilyPlanningCode")
	protected String patientFamilyPlanningCode;
	
	@XmlElement(name = "PatientFamilyPlanningMethodCode")
	protected String patientFamilyPlanningMethodCode;
	
	@XmlElement(name = "FunctionalStatus")
	protected String functionalStatus;
	
	@XmlElement(name = "WHOClinicalStage")
	protected String whoClinicalStage;
	
	@XmlElement(name = "TBStatus")
	protected String tbStatus;
	
	@XmlElement(name = "OtherOIOtherProblems")
	protected String otherOIOtherProblems;
	
	@XmlElement(name = "NotedSideEffects")
	protected String notedSideEffects;
	
	@XmlElement(name = "ARVDrugRegimen")
	protected CodedSimpleType arvDrugRegimen;
	
	@XmlElement(name = "ARVDrugAdherence")
	protected String arvDrugAdherence;
	
	@XmlElement(name = "WhyPoorFairARVDrugAdherence")
	protected String whyPoorFairARVDrugAdherence;
	
	@XmlElement(name = "CotrimoxazoleDose")
	protected CodedSimpleType cotrimoxazoleDose;
	
	@XmlElement(name = "CotrimoxazoleAdherence")
	protected String cotrimoxazoleAdherence;
	
	@XmlElement(name = "WhyPoorFairCotrimoxazoleDrugAdherence")
	protected String whyPoorFairCotrimoxazoleDrugAdherence;
	
	@XmlElement(name = "INHDose")
	protected CodedSimpleType inhDose;
	
	@XmlElement(name = "INHAdherence")
	protected String inhAdherence;
	
	@XmlElement(name = "WhyPoorFairINHDrugAdherence")
	protected String whyPoorFairINHDrugAdherence;
	
	@XmlElement(name = "CD4")
	protected Integer cd4;
	
	@XmlElement(name = "CD4TestDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar cd4TestDate;
	
	@XmlElement(name = "ReasonForRegimenSwitchSubs")
	protected String reasonForRegimenSwitchSubs;
	
	@XmlElement(name = "PrescribedRegimenInitialIndicator")
	protected Boolean prescribedRegimenInitialIndicator;
	
	@XmlElement(name = "PrescribedRegimenCurrentIndicator")
	protected Boolean prescribedRegimenCurrentIndicator;
	
	@XmlElement(name = "TypeOfPreviousExposureCode")
	protected String typeOfPreviousExposureCode;
	
	@XmlElement(name = "PoorAdherenceIndicator")
	protected Boolean poorAdherenceIndicator;
	
	@XmlElement(name = "ReasonForPoorAdherence")
	protected String reasonForPoorAdherence;
	
	@XmlElement(name = "ReasonRegimenEndedCode")
	protected String reasonRegimenEndedCode;
	
	@XmlElement(name = "SubstitutionIndicator")
	protected Boolean substitutionIndicator;
	
	@XmlElement(name = "SwitchIndicator")
	protected Boolean switchIndicator;
	
	@XmlElement(name = "NextAppointmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar nextAppointmentDate;
	
	@XmlElement(name = "StoppedRegimen")
	protected Boolean stoppedRegimen;
	
	@XmlElement(name = "DateStoppedRegimen")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateStoppedRegimen;
	
	@XmlElement(name = "ReasonForStoppedRegimen")
	protected String reasonForStoppedRegimen;
	
	@XmlElement(name = "MethodofTBDiagnosis")
	protected String methodofTBDiagnosis;
	
	/**
	 * Gets the value of the visitID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitID() {
		return visitID;
	}
	
	/**
	 * Sets the value of the visitID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitID(String value) {
		this.visitID = value;
	}
	
	/**
	 * Gets the value of the visitDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets the value of the visitDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setVisitDate(XMLGregorianCalendar value) {
		this.visitDate = value;
	}
	
	/**
	 * Gets the value of the durationOnArt property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getDurationOnArt() {
		return durationOnArt;
	}
	
	/**
	 * Sets the value of the durationOnArt property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setDurationOnArt(Integer value) {
		this.durationOnArt = value;
	}
	
	/**
	 * Gets the value of the weight property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getWeight() {
		return weight;
	}
	
	/**
	 * Sets the value of the weight property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setWeight(Integer value) {
		this.weight = value;
	}
	
	/**
	 * Gets the value of the childHeight property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getChildHeight() {
		return childHeight;
	}
	
	/**
	 * Sets the value of the childHeight property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setChildHeight(Integer value) {
		this.childHeight = value;
	}
	
	/**
	 * Gets the value of the bloodPressure property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	/**
	 * Sets the value of the bloodPressure property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBloodPressure(String value) {
		this.bloodPressure = value;
	}
	
	/**
	 * Gets the value of the edDandPMTCTLink property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEDDandPMTCTLink() {
		return edDandPMTCTLink;
	}
	
	/**
	 * Sets the value of the edDandPMTCTLink property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEDDandPMTCTLink(String value) {
		this.edDandPMTCTLink = value;
	}
	
	/**
	 * Gets the value of the patientFamilyPlanningCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientFamilyPlanningCode() {
		return patientFamilyPlanningCode;
	}
	
	/**
	 * Sets the value of the patientFamilyPlanningCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientFamilyPlanningCode(String value) {
		this.patientFamilyPlanningCode = value;
	}
	
	/**
	 * Gets the value of the patientFamilyPlanningMethodCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientFamilyPlanningMethodCode() {
		return patientFamilyPlanningMethodCode;
	}
	
	/**
	 * Sets the value of the patientFamilyPlanningMethodCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientFamilyPlanningMethodCode(String value) {
		this.patientFamilyPlanningMethodCode = value;
	}
	
	/**
	 * Gets the value of the functionalStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFunctionalStatus() {
		return functionalStatus;
	}
	
	/**
	 * Sets the value of the functionalStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFunctionalStatus(String value) {
		this.functionalStatus = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStage property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStage() {
		return whoClinicalStage;
	}
	
	/**
	 * Sets the value of the whoClinicalStage property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStage(String value) {
		this.whoClinicalStage = value;
	}
	
	/**
	 * Gets the value of the tbStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBStatus() {
		return tbStatus;
	}
	
	/**
	 * Sets the value of the tbStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBStatus(String value) {
		this.tbStatus = value;
	}
	
	/**
	 * Gets the value of the otherOIOtherProblems property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherOIOtherProblems() {
		return otherOIOtherProblems;
	}
	
	/**
	 * Sets the value of the otherOIOtherProblems property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherOIOtherProblems(String value) {
		this.otherOIOtherProblems = value;
	}
	
	/**
	 * Gets the value of the notedSideEffects property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNotedSideEffects() {
		return notedSideEffects;
	}
	
	/**
	 * Sets the value of the notedSideEffects property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNotedSideEffects(String value) {
		this.notedSideEffects = value;
	}
	
	/**
	 * Gets the value of the arvDrugRegimen property.
	 * 
	 * @return possible object is {@link CodedSimpleType }
	 */
	public CodedSimpleType getARVDrugRegimen() {
		return arvDrugRegimen;
	}
	
	/**
	 * Sets the value of the arvDrugRegimen property.
	 * 
	 * @param value allowed object is {@link CodedSimpleType }
	 */
	public void setARVDrugRegimen(CodedSimpleType value) {
		this.arvDrugRegimen = value;
	}
	
	/**
	 * Gets the value of the arvDrugAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARVDrugAdherence() {
		return arvDrugAdherence;
	}
	
	/**
	 * Sets the value of the arvDrugAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARVDrugAdherence(String value) {
		this.arvDrugAdherence = value;
	}
	
	/**
	 * Gets the value of the whyPoorFairARVDrugAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhyPoorFairARVDrugAdherence() {
		return whyPoorFairARVDrugAdherence;
	}
	
	/**
	 * Sets the value of the whyPoorFairARVDrugAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhyPoorFairARVDrugAdherence(String value) {
		this.whyPoorFairARVDrugAdherence = value;
	}
	
	/**
	 * Gets the value of the cotrimoxazoleDose property.
	 * 
	 * @return possible object is {@link CodedSimpleType }
	 */
	public CodedSimpleType getCotrimoxazoleDose() {
		return cotrimoxazoleDose;
	}
	
	/**
	 * Sets the value of the cotrimoxazoleDose property.
	 * 
	 * @param value allowed object is {@link CodedSimpleType }
	 */
	public void setCotrimoxazoleDose(CodedSimpleType value) {
		this.cotrimoxazoleDose = value;
	}
	
	/**
	 * Gets the value of the cotrimoxazoleAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCotrimoxazoleAdherence() {
		return cotrimoxazoleAdherence;
	}
	
	/**
	 * Sets the value of the cotrimoxazoleAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCotrimoxazoleAdherence(String value) {
		this.cotrimoxazoleAdherence = value;
	}
	
	/**
	 * Gets the value of the whyPoorFairCotrimoxazoleDrugAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhyPoorFairCotrimoxazoleDrugAdherence() {
		return whyPoorFairCotrimoxazoleDrugAdherence;
	}
	
	/**
	 * Sets the value of the whyPoorFairCotrimoxazoleDrugAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhyPoorFairCotrimoxazoleDrugAdherence(String value) {
		this.whyPoorFairCotrimoxazoleDrugAdherence = value;
	}
	
	/**
	 * Gets the value of the inhDose property.
	 * 
	 * @return possible object is {@link CodedSimpleType }
	 */
	public CodedSimpleType getINHDose() {
		return inhDose;
	}
	
	/**
	 * Sets the value of the inhDose property.
	 * 
	 * @param value allowed object is {@link CodedSimpleType }
	 */
	public void setINHDose(CodedSimpleType value) {
		this.inhDose = value;
	}
	
	/**
	 * Gets the value of the inhAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getINHAdherence() {
		return inhAdherence;
	}
	
	/**
	 * Sets the value of the inhAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setINHAdherence(String value) {
		this.inhAdherence = value;
	}
	
	/**
	 * Gets the value of the whyPoorFairINHDrugAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhyPoorFairINHDrugAdherence() {
		return whyPoorFairINHDrugAdherence;
	}
	
	/**
	 * Sets the value of the whyPoorFairINHDrugAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhyPoorFairINHDrugAdherence(String value) {
		this.whyPoorFairINHDrugAdherence = value;
	}
	
	/**
	 * Gets the value of the cd4 property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getCD4() {
		return cd4;
	}
	
	/**
	 * Sets the value of the cd4 property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setCD4(Integer value) {
		this.cd4 = value;
	}
	
	/**
	 * Gets the value of the cd4TestDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getCD4TestDate() {
		return cd4TestDate;
	}
	
	/**
	 * Sets the value of the cd4TestDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setCD4TestDate(XMLGregorianCalendar value) {
		this.cd4TestDate = value;
	}
	
	/**
	 * Gets the value of the reasonForRegimenSwitchSubs property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForRegimenSwitchSubs() {
		return reasonForRegimenSwitchSubs;
	}
	
	/**
	 * Sets the value of the reasonForRegimenSwitchSubs property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForRegimenSwitchSubs(String value) {
		this.reasonForRegimenSwitchSubs = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenInitialIndicator property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPrescribedRegimenInitialIndicator() {
		return prescribedRegimenInitialIndicator;
	}
	
	/**
	 * Sets the value of the prescribedRegimenInitialIndicator property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPrescribedRegimenInitialIndicator(Boolean value) {
		this.prescribedRegimenInitialIndicator = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenCurrentIndicator property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPrescribedRegimenCurrentIndicator() {
		return prescribedRegimenCurrentIndicator;
	}
	
	/**
	 * Sets the value of the prescribedRegimenCurrentIndicator property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPrescribedRegimenCurrentIndicator(Boolean value) {
		this.prescribedRegimenCurrentIndicator = value;
	}
	
	/**
	 * Gets the value of the typeOfPreviousExposureCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTypeOfPreviousExposureCode() {
		return typeOfPreviousExposureCode;
	}
	
	/**
	 * Sets the value of the typeOfPreviousExposureCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTypeOfPreviousExposureCode(String value) {
		this.typeOfPreviousExposureCode = value;
	}
	
	/**
	 * Gets the value of the poorAdherenceIndicator property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPoorAdherenceIndicator() {
		return poorAdherenceIndicator;
	}
	
	/**
	 * Sets the value of the poorAdherenceIndicator property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPoorAdherenceIndicator(Boolean value) {
		this.poorAdherenceIndicator = value;
	}
	
	/**
	 * Gets the value of the reasonForPoorAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForPoorAdherence() {
		return reasonForPoorAdherence;
	}
	
	/**
	 * Sets the value of the reasonForPoorAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForPoorAdherence(String value) {
		this.reasonForPoorAdherence = value;
	}
	
	/**
	 * Gets the value of the reasonRegimenEndedCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonRegimenEndedCode() {
		return reasonRegimenEndedCode;
	}
	
	/**
	 * Sets the value of the reasonRegimenEndedCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonRegimenEndedCode(String value) {
		this.reasonRegimenEndedCode = value;
	}
	
	/**
	 * Gets the value of the substitutionIndicator property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSubstitutionIndicator() {
		return substitutionIndicator;
	}
	
	/**
	 * Sets the value of the substitutionIndicator property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSubstitutionIndicator(Boolean value) {
		this.substitutionIndicator = value;
	}
	
	/**
	 * Gets the value of the switchIndicator property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSwitchIndicator() {
		return switchIndicator;
	}
	
	/**
	 * Sets the value of the switchIndicator property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSwitchIndicator(Boolean value) {
		this.switchIndicator = value;
	}
	
	/**
	 * Gets the value of the nextAppointmentDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getNextAppointmentDate() {
		return nextAppointmentDate;
	}
	
	/**
	 * Sets the value of the nextAppointmentDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setNextAppointmentDate(XMLGregorianCalendar value) {
		this.nextAppointmentDate = value;
	}
	
	/**
	 * Gets the value of the stoppedRegimen property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isStoppedRegimen() {
		return stoppedRegimen;
	}
	
	/**
	 * Sets the value of the stoppedRegimen property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setStoppedRegimen(Boolean value) {
		this.stoppedRegimen = value;
	}
	
	/**
	 * Gets the value of the dateStoppedRegimen property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateStoppedRegimen() {
		return dateStoppedRegimen;
	}
	
	/**
	 * Sets the value of the dateStoppedRegimen property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateStoppedRegimen(XMLGregorianCalendar value) {
		this.dateStoppedRegimen = value;
	}
	
	/**
	 * Gets the value of the reasonForStoppedRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForStoppedRegimen() {
		return reasonForStoppedRegimen;
	}
	
	/**
	 * Sets the value of the reasonForStoppedRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForStoppedRegimen(String value) {
		this.reasonForStoppedRegimen = value;
	}
	
	/**
	 * Gets the value of the methodofTBDiagnosis property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMethodofTBDiagnosis() {
		return methodofTBDiagnosis;
	}
	
	/**
	 * Sets the value of the methodofTBDiagnosis property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMethodofTBDiagnosis(String value) {
		this.methodofTBDiagnosis = value;
	}
	
}
