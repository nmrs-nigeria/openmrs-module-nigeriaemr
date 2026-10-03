package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantARTEnrollmentType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantARTEnrollmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateLinkedToARTClinic" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ARTEnrollmentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantARTEnrollmentType", propOrder = { "dateLinkedToARTClinic", "artEnrollmentNumber" })
public class InfantARTEnrollmentType {
	
	@XmlElement(name = "DateLinkedToARTClinic")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateLinkedToARTClinic;
	
	@XmlElement(name = "ARTEnrollmentNumber")
	protected String artEnrollmentNumber;
	
	/**
	 * Gets the value of the dateLinkedToARTClinic property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateLinkedToARTClinic() {
		return dateLinkedToARTClinic;
	}
	
	/**
	 * Sets the value of the dateLinkedToARTClinic property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateLinkedToARTClinic(XMLGregorianCalendar value) {
		this.dateLinkedToARTClinic = value;
	}
	
	/**
	 * Gets the value of the artEnrollmentNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARTEnrollmentNumber() {
		return artEnrollmentNumber;
	}
	
	/**
	 * Sets the value of the artEnrollmentNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARTEnrollmentNumber(String value) {
		this.artEnrollmentNumber = value;
	}
	
}
