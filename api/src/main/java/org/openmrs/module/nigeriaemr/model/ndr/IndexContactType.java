package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for IndexContactType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexContactType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SerialNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RelationshipToIndex">
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
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Sex">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AgeGroup">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="LT15"/>
 *               &lt;enumeration value="GTE15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NotificationMethod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="B"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="E"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FollowUpAppointmentLocation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FAC"/>
 *               &lt;enumeration value="WRK"/>
 *               &lt;enumeration value="HOM"/>
 *               &lt;enumeration value="OTH"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ContactAttempts" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="KnownHIVPositive" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateTested" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateEnrolledOnART" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateEnrolledInOVC" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="OVCID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexContactType", propOrder = { "serialNo", "relationshipToIndex", "sex", "ageGroup",
        "notificationMethod", "followUpAppointmentLocation", "contactAttempts", "knownHIVPositive", "hivTestResult",
        "dateTested", "dateEnrolledOnART", "dateEnrolledInOVC", "ovcid" })
public class IndexContactType {
	
	@XmlElement(name = "SerialNo", required = true)
	protected String serialNo;
	
	@XmlElement(name = "RelationshipToIndex", required = true)
	protected String relationshipToIndex;
	
	@XmlElement(name = "Sex", required = true)
	protected String sex;
	
	@XmlElement(name = "AgeGroup", required = true)
	protected String ageGroup;
	
	@XmlElement(name = "NotificationMethod")
	protected String notificationMethod;
	
	@XmlElement(name = "FollowUpAppointmentLocation")
	protected String followUpAppointmentLocation;
	
	@XmlElement(name = "ContactAttempts")
	protected Integer contactAttempts;
	
	@XmlElement(name = "KnownHIVPositive")
	protected String knownHIVPositive;
	
	@XmlElement(name = "HIVTestResult")
	protected String hivTestResult;
	
	@XmlElement(name = "DateTested")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateTested;
	
	@XmlElement(name = "DateEnrolledOnART")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateEnrolledOnART;
	
	@XmlElement(name = "DateEnrolledInOVC")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateEnrolledInOVC;
	
	@XmlElement(name = "OVCID")
	protected String ovcid;
	
	/**
	 * Gets the value of the serialNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSerialNo() {
		return serialNo;
	}
	
	/**
	 * Sets the value of the serialNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSerialNo(String value) {
		this.serialNo = value;
	}
	
	/**
	 * Gets the value of the relationshipToIndex property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRelationshipToIndex() {
		return relationshipToIndex;
	}
	
	/**
	 * Sets the value of the relationshipToIndex property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRelationshipToIndex(String value) {
		this.relationshipToIndex = value;
	}
	
	/**
	 * Gets the value of the sex property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Sets the value of the sex property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSex(String value) {
		this.sex = value;
	}
	
	/**
	 * Gets the value of the ageGroup property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAgeGroup() {
		return ageGroup;
	}
	
	/**
	 * Sets the value of the ageGroup property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAgeGroup(String value) {
		this.ageGroup = value;
	}
	
	/**
	 * Gets the value of the notificationMethod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNotificationMethod() {
		return notificationMethod;
	}
	
	/**
	 * Sets the value of the notificationMethod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNotificationMethod(String value) {
		this.notificationMethod = value;
	}
	
	/**
	 * Gets the value of the followUpAppointmentLocation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFollowUpAppointmentLocation() {
		return followUpAppointmentLocation;
	}
	
	/**
	 * Sets the value of the followUpAppointmentLocation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFollowUpAppointmentLocation(String value) {
		this.followUpAppointmentLocation = value;
	}
	
	/**
	 * Gets the value of the contactAttempts property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getContactAttempts() {
		return contactAttempts;
	}
	
	/**
	 * Sets the value of the contactAttempts property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setContactAttempts(Integer value) {
		this.contactAttempts = value;
	}
	
	/**
	 * Gets the value of the knownHIVPositive property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getKnownHIVPositive() {
		return knownHIVPositive;
	}
	
	/**
	 * Sets the value of the knownHIVPositive property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setKnownHIVPositive(String value) {
		this.knownHIVPositive = value;
	}
	
	/**
	 * Gets the value of the hivTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVTestResult() {
		return hivTestResult;
	}
	
	/**
	 * Sets the value of the hivTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVTestResult(String value) {
		this.hivTestResult = value;
	}
	
	/**
	 * Gets the value of the dateTested property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateTested() {
		return dateTested;
	}
	
	/**
	 * Sets the value of the dateTested property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateTested(XMLGregorianCalendar value) {
		this.dateTested = value;
	}
	
	/**
	 * Gets the value of the dateEnrolledOnART property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateEnrolledOnART() {
		return dateEnrolledOnART;
	}
	
	/**
	 * Sets the value of the dateEnrolledOnART property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateEnrolledOnART(XMLGregorianCalendar value) {
		this.dateEnrolledOnART = value;
	}
	
	/**
	 * Gets the value of the dateEnrolledInOVC property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateEnrolledInOVC() {
		return dateEnrolledInOVC;
	}
	
	/**
	 * Sets the value of the dateEnrolledInOVC property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateEnrolledInOVC(XMLGregorianCalendar value) {
		this.dateEnrolledInOVC = value;
	}
	
	/**
	 * Gets the value of the ovcid property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOVCID() {
		return ovcid;
	}
	
	/**
	 * Sets the value of the ovcid property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOVCID(String value) {
		this.ovcid = value;
	}
	
}
