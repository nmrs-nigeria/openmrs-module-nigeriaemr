package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RegisterTBScreeningType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterTBScreeningType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="NP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TreatmentReferral" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Inter"/>
 *               &lt;enumeration value="Intra"/>
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
@XmlType(name = "RegisterTBScreeningType", propOrder = { "status", "treatmentReferral" })
public class RegisterTBScreeningType {
	
	@XmlElement(name = "Status")
	protected String status;
	
	@XmlElement(name = "TreatmentReferral")
	protected String treatmentReferral;
	
	/**
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the value of the status property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStatus(String value) {
		this.status = value;
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
