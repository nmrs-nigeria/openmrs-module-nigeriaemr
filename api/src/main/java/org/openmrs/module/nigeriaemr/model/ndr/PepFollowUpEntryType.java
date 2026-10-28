package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PepFollowUpEntryType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PepFollowUpEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FollowUpVisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="HivResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EarlyHivDetectionViralLoadResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="TargetDetected"/>
 *               &lt;enumeration value="TargetNotDetected"/>
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
@XmlType(name = "PepFollowUpEntryType", propOrder = { "followUpVisitDate", "hivResult", "earlyHivDetectionViralLoadResult" })
public class PepFollowUpEntryType {
	
	@XmlElement(name = "FollowUpVisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar followUpVisitDate;
	
	@XmlElement(name = "HivResult")
	protected String hivResult;
	
	@XmlElement(name = "EarlyHivDetectionViralLoadResult")
	protected String earlyHivDetectionViralLoadResult;
	
	/**
	 * Gets the value of the followUpVisitDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFollowUpVisitDate() {
		return followUpVisitDate;
	}
	
	/**
	 * Sets the value of the followUpVisitDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFollowUpVisitDate(XMLGregorianCalendar value) {
		this.followUpVisitDate = value;
	}
	
	/**
	 * Gets the value of the hivResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHivResult() {
		return hivResult;
	}
	
	/**
	 * Sets the value of the hivResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHivResult(String value) {
		this.hivResult = value;
	}
	
	/**
	 * Gets the value of the earlyHivDetectionViralLoadResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEarlyHivDetectionViralLoadResult() {
		return earlyHivDetectionViralLoadResult;
	}
	
	/**
	 * Sets the value of the earlyHivDetectionViralLoadResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEarlyHivDetectionViralLoadResult(String value) {
		this.earlyHivDetectionViralLoadResult = value;
	}
	
}
