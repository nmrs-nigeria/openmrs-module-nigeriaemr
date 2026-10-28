package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PrepInterruptionType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepInterruptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterruptionReason">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="D"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InterruptionDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="WhyCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="DateOfRestart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepInterruptionType", propOrder = { "interruptionReason", "interruptionDate", "whyCode", "dateOfRestart" })
public class PrepInterruptionType {
	
	@XmlElement(name = "InterruptionReason", required = true)
	protected String interruptionReason;
	
	@XmlElement(name = "InterruptionDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar interruptionDate;
	
	@XmlElement(name = "WhyCode")
	protected String whyCode;
	
	@XmlElement(name = "DateOfRestart")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfRestart;
	
	/**
	 * Gets the value of the interruptionReason property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInterruptionReason() {
		return interruptionReason;
	}
	
	/**
	 * Sets the value of the interruptionReason property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInterruptionReason(String value) {
		this.interruptionReason = value;
	}
	
	/**
	 * Gets the value of the interruptionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getInterruptionDate() {
		return interruptionDate;
	}
	
	/**
	 * Sets the value of the interruptionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setInterruptionDate(XMLGregorianCalendar value) {
		this.interruptionDate = value;
	}
	
	/**
	 * Gets the value of the whyCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhyCode() {
		return whyCode;
	}
	
	/**
	 * Sets the value of the whyCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhyCode(String value) {
		this.whyCode = value;
	}
	
	/**
	 * Gets the value of the dateOfRestart property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfRestart() {
		return dateOfRestart;
	}
	
	/**
	 * Sets the value of the dateOfRestart property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfRestart(XMLGregorianCalendar value) {
		this.dateOfRestart = value;
	}
	
}
