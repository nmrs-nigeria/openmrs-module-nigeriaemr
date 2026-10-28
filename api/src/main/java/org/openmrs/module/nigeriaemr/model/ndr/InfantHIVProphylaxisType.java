package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantHIVProphylaxisType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantHIVProphylaxisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateOfInitiation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="AgeAtInitiation_wks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="TypeOfProphylaxis" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NVP"/>
 *               &lt;enumeration value="AZT"/>
 *               &lt;enumeration value="NVP+AZT"/>
 *               &lt;enumeration value="AZT+3TC+NVP"/>
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherSpecify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfCompletion" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantHIVProphylaxisType", propOrder = { "dateOfInitiation", "ageAtInitiationWks", "typeOfProphylaxis",
        "otherSpecify", "dateOfCompletion" })
public class InfantHIVProphylaxisType {
	
	@XmlElement(name = "DateOfInitiation")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfInitiation;
	
	@XmlElement(name = "AgeAtInitiation_wks")
	protected Integer ageAtInitiationWks;
	
	@XmlElement(name = "TypeOfProphylaxis")
	protected String typeOfProphylaxis;
	
	@XmlElement(name = "OtherSpecify")
	protected String otherSpecify;
	
	@XmlElement(name = "DateOfCompletion")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfCompletion;
	
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
	
	/**
	 * Gets the value of the otherSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherSpecify() {
		return otherSpecify;
	}
	
	/**
	 * Sets the value of the otherSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherSpecify(String value) {
		this.otherSpecify = value;
	}
	
	/**
	 * Gets the value of the dateOfCompletion property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfCompletion() {
		return dateOfCompletion;
	}
	
	/**
	 * Sets the value of the dateOfCompletion property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfCompletion(XMLGregorianCalendar value) {
		this.dateOfCompletion = value;
	}
	
}
