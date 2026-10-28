package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RegisterVLType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterVLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VLLessThan32Weeks" type="{}VLMeasurementType" minOccurs="0"/>
 *         &lt;element name="VL32To36Weeks" type="{}VLMeasurementType" minOccurs="0"/>
 *         &lt;element name="VLBreastfeedingPeriod" type="{}VLMeasurementType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterVLType", propOrder = { "vlLessThan32Weeks", "vl32To36Weeks", "vlBreastfeedingPeriod" })
public class RegisterVLType {
	
	@XmlElement(name = "VLLessThan32Weeks")
	protected VLMeasurementType vlLessThan32Weeks;
	
	@XmlElement(name = "VL32To36Weeks")
	protected VLMeasurementType vl32To36Weeks;
	
	@XmlElement(name = "VLBreastfeedingPeriod")
	protected VLMeasurementType vlBreastfeedingPeriod;
	
	/**
	 * Gets the value of the vlLessThan32Weeks property.
	 * 
	 * @return possible object is {@link VLMeasurementType }
	 */
	public VLMeasurementType getVLLessThan32Weeks() {
		return vlLessThan32Weeks;
	}
	
	/**
	 * Sets the value of the vlLessThan32Weeks property.
	 * 
	 * @param value allowed object is {@link VLMeasurementType }
	 */
	public void setVLLessThan32Weeks(VLMeasurementType value) {
		this.vlLessThan32Weeks = value;
	}
	
	/**
	 * Gets the value of the vl32To36Weeks property.
	 * 
	 * @return possible object is {@link VLMeasurementType }
	 */
	public VLMeasurementType getVL32To36Weeks() {
		return vl32To36Weeks;
	}
	
	/**
	 * Sets the value of the vl32To36Weeks property.
	 * 
	 * @param value allowed object is {@link VLMeasurementType }
	 */
	public void setVL32To36Weeks(VLMeasurementType value) {
		this.vl32To36Weeks = value;
	}
	
	/**
	 * Gets the value of the vlBreastfeedingPeriod property.
	 * 
	 * @return possible object is {@link VLMeasurementType }
	 */
	public VLMeasurementType getVLBreastfeedingPeriod() {
		return vlBreastfeedingPeriod;
	}
	
	/**
	 * Sets the value of the vlBreastfeedingPeriod property.
	 * 
	 * @param value allowed object is {@link VLMeasurementType }
	 */
	public void setVLBreastfeedingPeriod(VLMeasurementType value) {
		this.vlBreastfeedingPeriod = value;
	}
	
}
