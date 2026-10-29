package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PepFollowUpVisitType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PepFollowUpVisitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ModeOfExposure" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DurationBeforePepProvided" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BloodPressure" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="HivStatusAtExposure" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NotedSideEffects" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="0"/>
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
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SyndromicSTIScreening" minOccurs="0">
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
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RiskReductionServices" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Adherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PepRegimen" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DatePepGivenStart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DatePepGivenStop" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FollowUpHivTestResult1st6Weeks" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FollowUpHivTestResult2nd3Months" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FollowUpHivTestResult3rd6Months" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReferIfPositive" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NextAppointmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PepFollowUpVisitType", propOrder = { "visitID", "visitDate", "modeOfExposure", "durationBeforePepProvided",
        "bloodPressure", "hivStatusAtExposure", "notedSideEffects", "syndromicSTIScreening", "riskReductionServices",
        "adherence", "pepRegimen", "datePepGivenStart", "datePepGivenStop", "followUpHivTestResult1St6Weeks",
        "followUpHivTestResult2Nd3Months", "followUpHivTestResult3Rd6Months", "referIfPositive", "nextAppointmentDate" })
public class PepFollowUpVisitType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "ModeOfExposure")
	protected String modeOfExposure;
	
	@XmlElement(name = "DurationBeforePepProvided")
	protected String durationBeforePepProvided;
	
	@XmlElement(name = "BloodPressure")
	protected String bloodPressure;
	
	@XmlElement(name = "HivStatusAtExposure")
	protected String hivStatusAtExposure;
	
	@XmlElement(name = "NotedSideEffects")
	protected String notedSideEffects;
	
	@XmlElement(name = "SyndromicSTIScreening")
	protected String syndromicSTIScreening;
	
	@XmlElement(name = "RiskReductionServices")
	protected String riskReductionServices;
	
	@XmlElement(name = "Adherence")
	protected String adherence;
	
	@XmlElement(name = "PepRegimen")
	protected String pepRegimen;
	
	@XmlElement(name = "DatePepGivenStart")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar datePepGivenStart;
	
	@XmlElement(name = "DatePepGivenStop")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar datePepGivenStop;
	
	@XmlElement(name = "FollowUpHivTestResult1st6Weeks")
	protected String followUpHivTestResult1St6Weeks;
	
	@XmlElement(name = "FollowUpHivTestResult2nd3Months")
	protected String followUpHivTestResult2Nd3Months;
	
	@XmlElement(name = "FollowUpHivTestResult3rd6Months")
	protected String followUpHivTestResult3Rd6Months;
	
	@XmlElement(name = "ReferIfPositive")
	protected String referIfPositive;
	
	@XmlElement(name = "NextAppointmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar nextAppointmentDate;
	
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
	 * Gets the value of the modeOfExposure property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getModeOfExposure() {
		return modeOfExposure;
	}
	
	/**
	 * Sets the value of the modeOfExposure property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setModeOfExposure(String value) {
		this.modeOfExposure = value;
	}
	
	/**
	 * Gets the value of the durationBeforePepProvided property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDurationBeforePepProvided() {
		return durationBeforePepProvided;
	}
	
	/**
	 * Sets the value of the durationBeforePepProvided property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDurationBeforePepProvided(String value) {
		this.durationBeforePepProvided = value;
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
	 * Gets the value of the hivStatusAtExposure property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHivStatusAtExposure() {
		return hivStatusAtExposure;
	}
	
	/**
	 * Sets the value of the hivStatusAtExposure property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHivStatusAtExposure(String value) {
		this.hivStatusAtExposure = value;
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
	 * Gets the value of the syndromicSTIScreening property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSyndromicSTIScreening() {
		return syndromicSTIScreening;
	}
	
	/**
	 * Sets the value of the syndromicSTIScreening property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSyndromicSTIScreening(String value) {
		this.syndromicSTIScreening = value;
	}
	
	/**
	 * Gets the value of the riskReductionServices property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRiskReductionServices() {
		return riskReductionServices;
	}
	
	/**
	 * Sets the value of the riskReductionServices property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRiskReductionServices(String value) {
		this.riskReductionServices = value;
	}
	
	/**
	 * Gets the value of the adherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAdherence() {
		return adherence;
	}
	
	/**
	 * Sets the value of the adherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAdherence(String value) {
		this.adherence = value;
	}
	
	/**
	 * Gets the value of the pepRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPepRegimen() {
		return pepRegimen;
	}
	
	/**
	 * Sets the value of the pepRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPepRegimen(String value) {
		this.pepRegimen = value;
	}
	
	/**
	 * Gets the value of the datePepGivenStart property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDatePepGivenStart() {
		return datePepGivenStart;
	}
	
	/**
	 * Sets the value of the datePepGivenStart property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDatePepGivenStart(XMLGregorianCalendar value) {
		this.datePepGivenStart = value;
	}
	
	/**
	 * Gets the value of the datePepGivenStop property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDatePepGivenStop() {
		return datePepGivenStop;
	}
	
	/**
	 * Sets the value of the datePepGivenStop property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDatePepGivenStop(XMLGregorianCalendar value) {
		this.datePepGivenStop = value;
	}
	
	/**
	 * Gets the value of the followUpHivTestResult1St6Weeks property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFollowUpHivTestResult1St6Weeks() {
		return followUpHivTestResult1St6Weeks;
	}
	
	/**
	 * Sets the value of the followUpHivTestResult1St6Weeks property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFollowUpHivTestResult1St6Weeks(String value) {
		this.followUpHivTestResult1St6Weeks = value;
	}
	
	/**
	 * Gets the value of the followUpHivTestResult2Nd3Months property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFollowUpHivTestResult2Nd3Months() {
		return followUpHivTestResult2Nd3Months;
	}
	
	/**
	 * Sets the value of the followUpHivTestResult2Nd3Months property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFollowUpHivTestResult2Nd3Months(String value) {
		this.followUpHivTestResult2Nd3Months = value;
	}
	
	/**
	 * Gets the value of the followUpHivTestResult3Rd6Months property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFollowUpHivTestResult3Rd6Months() {
		return followUpHivTestResult3Rd6Months;
	}
	
	/**
	 * Sets the value of the followUpHivTestResult3Rd6Months property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFollowUpHivTestResult3Rd6Months(String value) {
		this.followUpHivTestResult3Rd6Months = value;
	}
	
	/**
	 * Gets the value of the referIfPositive property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferIfPositive() {
		return referIfPositive;
	}
	
	/**
	 * Sets the value of the referIfPositive property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferIfPositive(String value) {
		this.referIfPositive = value;
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
	
}
