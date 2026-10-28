package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantCTXType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantCTXType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateOfInitiation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="AgeAtInitiation_Wks" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantCTXType", propOrder = { "dateOfInitiation", "ageAtInitiationWks" })
public class InfantCTXType {
	
	@XmlElement(name = "DateOfInitiation")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfInitiation;
	
	@XmlElement(name = "AgeAtInitiation_Wks")
	protected BigInteger ageAtInitiationWks;
	
	/**
	 * Gets the value of the dateOfInitiation property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfInitiation() {
		return dateOfInitiation;
	}
	
	/**
	 * Sets the value of the dateOfInitiation property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfInitiation(XMLGregorianCalendar value) {
		this.dateOfInitiation = value;
	}
	
	/**
	 * Gets the value of the ageAtInitiationWks property.
	 * 
	 * @return possible object is {@link BigInteger }
	 */
	public BigInteger getAgeAtInitiationWks() {
		return ageAtInitiationWks;
	}
	
	/**
	 * Sets the value of the ageAtInitiationWks property.
	 * 
	 * @param value allowed object is {@link BigInteger }
	 */
	public void setAgeAtInitiationWks(BigInteger value) {
		this.ageAtInitiationWks = value;
	}
	
}
