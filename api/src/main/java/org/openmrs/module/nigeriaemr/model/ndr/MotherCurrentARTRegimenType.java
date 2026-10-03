package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MotherCurrentARTRegimenType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MotherCurrentARTRegimenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegimenCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegimenDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegimenNDRCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MotherCurrentARTRegimenType", propOrder = { "regimenCode", "regimenDescription", "regimenNDRCode" })
public class MotherCurrentARTRegimenType {
	
	@XmlElement(name = "RegimenCode")
	protected String regimenCode;
	
	@XmlElement(name = "RegimenDescription")
	protected String regimenDescription;
	
	@XmlElement(name = "RegimenNDRCode")
	protected String regimenNDRCode;
	
	/**
	 * Gets the value of the regimenCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRegimenCode() {
		return regimenCode;
	}
	
	/**
	 * Sets the value of the regimenCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRegimenCode(String value) {
		this.regimenCode = value;
	}
	
	/**
	 * Gets the value of the regimenDescription property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRegimenDescription() {
		return regimenDescription;
	}
	
	/**
	 * Sets the value of the regimenDescription property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRegimenDescription(String value) {
		this.regimenDescription = value;
	}
	
	/**
	 * Gets the value of the regimenNDRCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRegimenNDRCode() {
		return regimenNDRCode;
	}
	
	/**
	 * Sets the value of the regimenNDRCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRegimenNDRCode(String value) {
		this.regimenNDRCode = value;
	}
	
}
