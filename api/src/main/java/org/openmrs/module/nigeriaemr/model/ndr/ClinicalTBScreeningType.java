package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ClinicalTBScreeningType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClinicalTBScreeningType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrentlyCough" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="WeightLoss" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Fever" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NightSweats" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClinicalTBScreeningType", propOrder = { "currentlyCough", "weightLoss", "fever", "nightSweats" })
public class ClinicalTBScreeningType {
	
	@XmlElement(name = "CurrentlyCough")
	protected Boolean currentlyCough;
	
	@XmlElement(name = "WeightLoss")
	protected Boolean weightLoss;
	
	@XmlElement(name = "Fever")
	protected Boolean fever;
	
	@XmlElement(name = "NightSweats")
	protected Boolean nightSweats;
	
	/**
	 * Gets the value of the currentlyCough property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isCurrentlyCough() {
		return currentlyCough;
	}
	
	/**
	 * Sets the value of the currentlyCough property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setCurrentlyCough(Boolean value) {
		this.currentlyCough = value;
	}
	
	/**
	 * Gets the value of the weightLoss property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isWeightLoss() {
		return weightLoss;
	}
	
	/**
	 * Sets the value of the weightLoss property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setWeightLoss(Boolean value) {
		this.weightLoss = value;
	}
	
	/**
	 * Gets the value of the fever property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isFever() {
		return fever;
	}
	
	/**
	 * Sets the value of the fever property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setFever(Boolean value) {
		this.fever = value;
	}
	
	/**
	 * Gets the value of the nightSweats property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNightSweats() {
		return nightSweats;
	}
	
	/**
	 * Sets the value of the nightSweats property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNightSweats(Boolean value) {
		this.nightSweats = value;
	}
	
}
