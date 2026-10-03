package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for TestResultType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScreeningTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NR"/>
 *               &lt;enumeration value="R"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ScreeningTestResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SuspectedAcuteHIVInfection" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConfirmatoryTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NR"/>
 *               &lt;enumeration value="R"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConfirmatoryTestResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FinalTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
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
@XmlType(name = "TestResultType", propOrder = { "screeningTestResult", "screeningTestResultDate",
        "suspectedAcuteHIVInfection", "confirmatoryTestResult", "confirmatoryTestResultDate", "finalTestResult" })
public class TestResultType {
	
	@XmlElement(name = "ScreeningTestResult")
	protected String screeningTestResult;
	
	@XmlElement(name = "ScreeningTestResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar screeningTestResultDate;
	
	@XmlElement(name = "SuspectedAcuteHIVInfection")
	protected String suspectedAcuteHIVInfection;
	
	@XmlElement(name = "ConfirmatoryTestResult")
	protected String confirmatoryTestResult;
	
	@XmlElement(name = "ConfirmatoryTestResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar confirmatoryTestResultDate;
	
	@XmlElement(name = "FinalTestResult")
	protected String finalTestResult;
	
	/**
	 * Gets the value of the screeningTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getScreeningTestResult() {
		return screeningTestResult;
	}
	
	/**
	 * Sets the value of the screeningTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setScreeningTestResult(String value) {
		this.screeningTestResult = value;
	}
	
	/**
	 * Gets the value of the screeningTestResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getScreeningTestResultDate() {
		return screeningTestResultDate;
	}
	
	/**
	 * Sets the value of the screeningTestResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setScreeningTestResultDate(XMLGregorianCalendar value) {
		this.screeningTestResultDate = value;
	}
	
	/**
	 * Gets the value of the suspectedAcuteHIVInfection property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSuspectedAcuteHIVInfection() {
		return suspectedAcuteHIVInfection;
	}
	
	/**
	 * Sets the value of the suspectedAcuteHIVInfection property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSuspectedAcuteHIVInfection(String value) {
		this.suspectedAcuteHIVInfection = value;
	}
	
	/**
	 * Gets the value of the confirmatoryTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getConfirmatoryTestResult() {
		return confirmatoryTestResult;
	}
	
	/**
	 * Sets the value of the confirmatoryTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setConfirmatoryTestResult(String value) {
		this.confirmatoryTestResult = value;
	}
	
	/**
	 * Gets the value of the confirmatoryTestResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getConfirmatoryTestResultDate() {
		return confirmatoryTestResultDate;
	}
	
	/**
	 * Sets the value of the confirmatoryTestResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setConfirmatoryTestResultDate(XMLGregorianCalendar value) {
		this.confirmatoryTestResultDate = value;
	}
	
	/**
	 * Gets the value of the finalTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFinalTestResult() {
		return finalTestResult;
	}
	
	/**
	 * Sets the value of the finalTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFinalTestResult(String value) {
		this.finalTestResult = value;
	}
	
}
