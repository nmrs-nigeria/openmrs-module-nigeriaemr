package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantSyphilisProphylaxisType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantSyphilisProphylaxisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateOfInitiation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="AgeAtInitiation_wks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="TypeOfProphylaxis" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="BPG(1dose)"/>
 *               &lt;enumeration value="BPG(3doses)"/>
 *               &lt;enumeration value="ProcainePenicillinG"/>
 *               &lt;enumeration value="AqueousCrystallinePenicillinG"/>
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
@XmlType(name = "InfantSyphilisProphylaxisType", propOrder = { "dateOfInitiation", "ageAtInitiationWks", "typeOfProphylaxis" })
public class InfantSyphilisProphylaxisType {
	
	@XmlElement(name = "DateOfInitiation")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfInitiation;
	
	@XmlElement(name = "AgeAtInitiation_wks")
	protected Integer ageAtInitiationWks;
	
	@XmlElement(name = "TypeOfProphylaxis")
	protected String typeOfProphylaxis;
	
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
	 * @return possible object is {@link Integer }
	 */
	public Integer getAgeAtInitiationWks() {
		return ageAtInitiationWks;
	}
	
	/**
	 * Sets the value of the ageAtInitiationWks property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setAgeAtInitiationWks(Integer value) {
		this.ageAtInitiationWks = value;
	}
	
	/**
	 * Gets the value of the typeOfProphylaxis property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTypeOfProphylaxis() {
		return typeOfProphylaxis;
	}
	
	/**
	 * Sets the value of the typeOfProphylaxis property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTypeOfProphylaxis(String value) {
		this.typeOfProphylaxis = value;
	}
	
}
