package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for RegimenType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ReasonForRegimenSwitchSubs" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimen" type="{}CodedSimpleType"/>
 *         &lt;element name="PrescribedRegimenTypeCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenLineCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenDuration" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenDispensedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateRegimenStarted" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DateRegimenStartedDD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenStartedMM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenStartedYYYY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEnded" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateRegimenEndedDD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEndedMM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEndedYYYY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PrescribedRegimenInitialIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenCurrentIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TypeOfPreviousExposureCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PoorAdherenceIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReasonForPoorAdherence" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="ReasonRegimenEndedCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="SubstitutionIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SwitchIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegimenType", propOrder = { "visitID", "visitDate", "reasonForRegimenSwitchSubs", "prescribedRegimen",
        "prescribedRegimenTypeCode", "prescribedRegimenLineCode", "prescribedRegimenDuration",
        "prescribedRegimenDispensedDate", "dateRegimenStarted", "dateRegimenStartedDD", "dateRegimenStartedMM",
        "dateRegimenStartedYYYY", "dateRegimenEnded", "dateRegimenEndedDD", "dateRegimenEndedMM", "dateRegimenEndedYYYY",
        "prescribedRegimenInitialIndicator", "prescribedRegimenCurrentIndicator", "typeOfPreviousExposureCode",
        "poorAdherenceIndicator", "reasonForPoorAdherence", "reasonRegimenEndedCode", "substitutionIndicator",
        "switchIndicator" })
public class RegimenType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "ReasonForRegimenSwitchSubs")
	protected String reasonForRegimenSwitchSubs;
	
	@XmlElement(name = "PrescribedRegimen", required = true)
	protected CodedSimpleType prescribedRegimen;
	
	@XmlElement(name = "PrescribedRegimenTypeCode")
	protected String prescribedRegimenTypeCode;
	
	@XmlElement(name = "PrescribedRegimenLineCode")
	protected String prescribedRegimenLineCode;
	
	@XmlElement(name = "PrescribedRegimenDuration")
	protected String prescribedRegimenDuration;
	
	@XmlElement(name = "PrescribedRegimenDispensedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar prescribedRegimenDispensedDate;
	
	@XmlElement(name = "DateRegimenStarted", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateRegimenStarted;
	
	@XmlElement(name = "DateRegimenStartedDD")
	protected String dateRegimenStartedDD;
	
	@XmlElement(name = "DateRegimenStartedMM")
	protected String dateRegimenStartedMM;
	
	@XmlElement(name = "DateRegimenStartedYYYY")
	protected String dateRegimenStartedYYYY;
	
	@XmlElement(name = "DateRegimenEnded")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateRegimenEnded;
	
	@XmlElement(name = "DateRegimenEndedDD")
	protected String dateRegimenEndedDD;
	
	@XmlElement(name = "DateRegimenEndedMM")
	protected String dateRegimenEndedMM;
	
	@XmlElement(name = "DateRegimenEndedYYYY")
	protected String dateRegimenEndedYYYY;
	
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
	 * Gets the value of the prescribedRegimen property.
	 * 
	 * @return possible object is {@link CodedSimpleType }
	 */
	public CodedSimpleType getPrescribedRegimen() {
		return prescribedRegimen;
	}
	
	/**
	 * Sets the value of the prescribedRegimen property.
	 * 
	 * @param value allowed object is {@link CodedSimpleType }
	 */
	public void setPrescribedRegimen(CodedSimpleType value) {
		this.prescribedRegimen = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenTypeCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenTypeCode() {
		return prescribedRegimenTypeCode;
	}
	
	/**
	 * Sets the value of the prescribedRegimenTypeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenTypeCode(String value) {
		this.prescribedRegimenTypeCode = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenLineCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenLineCode() {
		return prescribedRegimenLineCode;
	}
	
	/**
	 * Sets the value of the prescribedRegimenLineCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenLineCode(String value) {
		this.prescribedRegimenLineCode = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenDuration property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenDuration() {
		return prescribedRegimenDuration;
	}
	
	/**
	 * Sets the value of the prescribedRegimenDuration property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenDuration(String value) {
		this.prescribedRegimenDuration = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenDispensedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getPrescribedRegimenDispensedDate() {
		return prescribedRegimenDispensedDate;
	}
	
	/**
	 * Sets the value of the prescribedRegimenDispensedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setPrescribedRegimenDispensedDate(XMLGregorianCalendar value) {
		this.prescribedRegimenDispensedDate = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStarted property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateRegimenStarted() {
		return dateRegimenStarted;
	}
	
	/**
	 * Sets the value of the dateRegimenStarted property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateRegimenStarted(XMLGregorianCalendar value) {
		this.dateRegimenStarted = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedDD property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedDD() {
		return dateRegimenStartedDD;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedDD property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedDD(String value) {
		this.dateRegimenStartedDD = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedMM property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedMM() {
		return dateRegimenStartedMM;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedMM property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedMM(String value) {
		this.dateRegimenStartedMM = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedYYYY property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedYYYY() {
		return dateRegimenStartedYYYY;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedYYYY property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedYYYY(String value) {
		this.dateRegimenStartedYYYY = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEnded property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateRegimenEnded() {
		return dateRegimenEnded;
	}
	
	/**
	 * Sets the value of the dateRegimenEnded property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateRegimenEnded(XMLGregorianCalendar value) {
		this.dateRegimenEnded = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedDD property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedDD() {
		return dateRegimenEndedDD;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedDD property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedDD(String value) {
		this.dateRegimenEndedDD = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedMM property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedMM() {
		return dateRegimenEndedMM;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedMM property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedMM(String value) {
		this.dateRegimenEndedMM = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedYYYY property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedYYYY() {
		return dateRegimenEndedYYYY;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedYYYY property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedYYYY(String value) {
		this.dateRegimenEndedYYYY = value;
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
	
}
