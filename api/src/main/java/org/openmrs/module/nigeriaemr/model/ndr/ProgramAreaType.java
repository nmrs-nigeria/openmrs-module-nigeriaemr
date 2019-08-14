package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ProgramAreaType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProgramAreaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProgramAreaCode" type="{}CodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramAreaType", propOrder = { "programAreaCode" })
public class ProgramAreaType {
	
	@XmlElement(name = "ProgramAreaCode", required = true)
	protected String programAreaCode;
	
	/**
	 * Gets the value of the programAreaCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getProgramAreaCode() {
		return programAreaCode;
	}
	
	/**
	 * Sets the value of the programAreaCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setProgramAreaCode(String value) {
		this.programAreaCode = value;
	}
	
}
