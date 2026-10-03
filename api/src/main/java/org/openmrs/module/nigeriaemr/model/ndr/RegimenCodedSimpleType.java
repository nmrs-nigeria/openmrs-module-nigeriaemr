package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RegimenCodedSimpleType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimenCodedSimpleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{}CodeType"/>
 *         &lt;element name="CodeDescTxt" type="{}CodeDescTxtType" minOccurs="0"/>
 *         &lt;element name="NDRCode" type="{}CodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegimenCodedSimpleType", propOrder = { "code", "codeDescTxt", "ndrCode" })
public class RegimenCodedSimpleType {
	
	@XmlElement(name = "Code", required = true)
	protected String code;
	
	@XmlElement(name = "CodeDescTxt")
	protected String codeDescTxt;
	
	@XmlElement(name = "NDRCode")
	protected String ndrCode;
	
	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the value of the code property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCode(String value) {
		this.code = value;
	}
	
	/**
	 * Gets the value of the codeDescTxt property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCodeDescTxt() {
		return codeDescTxt;
	}
	
	/**
	 * Sets the value of the codeDescTxt property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCodeDescTxt(String value) {
		this.codeDescTxt = value;
	}
	
	/**
	 * Gets the value of the ndrCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNDRCode() {
		return ndrCode;
	}
	
	/**
	 * Sets the value of the ndrCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNDRCode(String value) {
		this.ndrCode = value;
	}
	
}
