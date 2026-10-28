package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantHBVVaccinationType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantHBVVaccinationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirstDoseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FirstDoseTiming" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Within24hrs"/>
 *               &lt;enumeration value="After24hrs"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SecondDoseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ThirdDoseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantHBVVaccinationType", propOrder = { "firstDoseDate", "firstDoseTiming", "secondDoseDate",
        "thirdDoseDate" })
public class InfantHBVVaccinationType {
	
	@XmlElement(name = "FirstDoseDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar firstDoseDate;
	
	@XmlElement(name = "FirstDoseTiming")
	protected String firstDoseTiming;
	
	@XmlElement(name = "SecondDoseDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar secondDoseDate;
	
	@XmlElement(name = "ThirdDoseDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar thirdDoseDate;
	
	/**
	 * Gets the value of the firstDoseDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFirstDoseDate() {
		return firstDoseDate;
	}
	
	/**
	 * Sets the value of the firstDoseDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFirstDoseDate(XMLGregorianCalendar value) {
		this.firstDoseDate = value;
	}
	
	/**
	 * Gets the value of the firstDoseTiming property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFirstDoseTiming() {
		return firstDoseTiming;
	}
	
	/**
	 * Sets the value of the firstDoseTiming property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFirstDoseTiming(String value) {
		this.firstDoseTiming = value;
	}
	
	/**
	 * Gets the value of the secondDoseDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getSecondDoseDate() {
		return secondDoseDate;
	}
	
	/**
	 * Sets the value of the secondDoseDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setSecondDoseDate(XMLGregorianCalendar value) {
		this.secondDoseDate = value;
	}
	
	/**
	 * Gets the value of the thirdDoseDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getThirdDoseDate() {
		return thirdDoseDate;
	}
	
	/**
	 * Sets the value of the thirdDoseDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setThirdDoseDate(XMLGregorianCalendar value) {
		this.thirdDoseDate = value;
	}
	
}
