package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InfantHBVProphylaxisType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantHBVProphylaxisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BirthDoseWithin24Hrs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BirthDoseAfter24Hrs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SecondDoseGiven" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ThirdDoseGiven" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantHBVProphylaxisType", propOrder = { "birthDoseWithin24Hrs", "birthDoseAfter24Hrs", "secondDoseGiven",
        "thirdDoseGiven" })
public class InfantHBVProphylaxisType {
	
	@XmlElement(name = "BirthDoseWithin24Hrs")
	protected Boolean birthDoseWithin24Hrs;
	
	@XmlElement(name = "BirthDoseAfter24Hrs")
	protected Boolean birthDoseAfter24Hrs;
	
	@XmlElement(name = "SecondDoseGiven")
	protected Boolean secondDoseGiven;
	
	@XmlElement(name = "ThirdDoseGiven")
	protected Boolean thirdDoseGiven;
	
	/**
	 * Gets the value of the birthDoseWithin24Hrs property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isBirthDoseWithin24Hrs() {
		return birthDoseWithin24Hrs;
	}
	
	/**
	 * Sets the value of the birthDoseWithin24Hrs property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setBirthDoseWithin24Hrs(Boolean value) {
		this.birthDoseWithin24Hrs = value;
	}
	
	/**
	 * Gets the value of the birthDoseAfter24Hrs property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isBirthDoseAfter24Hrs() {
		return birthDoseAfter24Hrs;
	}
	
	/**
	 * Sets the value of the birthDoseAfter24Hrs property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setBirthDoseAfter24Hrs(Boolean value) {
		this.birthDoseAfter24Hrs = value;
	}
	
	/**
	 * Gets the value of the secondDoseGiven property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSecondDoseGiven() {
		return secondDoseGiven;
	}
	
	/**
	 * Sets the value of the secondDoseGiven property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSecondDoseGiven(Boolean value) {
		this.secondDoseGiven = value;
	}
	
	/**
	 * Gets the value of the thirdDoseGiven property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isThirdDoseGiven() {
		return thirdDoseGiven;
	}
	
	/**
	 * Sets the value of the thirdDoseGiven property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setThirdDoseGiven(Boolean value) {
		this.thirdDoseGiven = value;
	}
	
}
