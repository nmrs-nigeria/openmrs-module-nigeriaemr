package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RegisterHBVType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterHBVType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KnownPositive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TreatmentReferral" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NotTreated"/>
 *               &lt;enumeration value="PriorOnHBVTreatment"/>
 *               &lt;enumeration value="NewOnProphylaxis"/>
 *               &lt;enumeration value="Referred"/>
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
@XmlType(name = "RegisterHBVType", propOrder = { "knownPositive", "testResult", "treatmentReferral" })
public class RegisterHBVType {
	
	@XmlElement(name = "KnownPositive")
	protected Boolean knownPositive;
	
	@XmlElement(name = "TestResult")
	protected String testResult;
	
	@XmlElement(name = "TreatmentReferral")
	protected String treatmentReferral;
	
	/**
	 * Gets the value of the knownPositive property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isKnownPositive() {
		return knownPositive;
	}
	
	/**
	 * Sets the value of the knownPositive property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setKnownPositive(Boolean value) {
		this.knownPositive = value;
	}
	
	/**
	 * Gets the value of the testResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTestResult() {
		return testResult;
	}
	
	/**
	 * Sets the value of the testResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTestResult(String value) {
		this.testResult = value;
	}
	
	/**
	 * Gets the value of the treatmentReferral property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTreatmentReferral() {
		return treatmentReferral;
	}
	
	/**
	 * Sets the value of the treatmentReferral property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTreatmentReferral(String value) {
		this.treatmentReferral = value;
	}
	
}
