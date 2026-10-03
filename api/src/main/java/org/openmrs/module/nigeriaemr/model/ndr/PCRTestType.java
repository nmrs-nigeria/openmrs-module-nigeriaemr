package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PCRTestType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PCRTestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgeAtTest" type="{}PCRAgeAtTestType" minOccurs="0"/>
 *         &lt;element name="DateSampleCollected" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Result" type="{}PCRRapidTestResultType" minOccurs="0"/>
 *         &lt;element name="DateResultReceived" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PCRTestType", propOrder = { "ageAtTest", "dateSampleCollected", "result", "dateResultReceived" })
public class PCRTestType {
	
	@XmlElement(name = "AgeAtTest")
	@XmlSchemaType(name = "string")
	protected PCRAgeAtTestType ageAtTest;
	
	@XmlElement(name = "DateSampleCollected")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateSampleCollected;
	
	@XmlElement(name = "Result")
	@XmlSchemaType(name = "string")
	protected PCRRapidTestResultType result;
	
	@XmlElement(name = "DateResultReceived")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateResultReceived;
	
	/**
	 * Gets the value of the ageAtTest property.
	 * 
	 * @return possible object is {@link PCRAgeAtTestType }
	 */
	public PCRAgeAtTestType getAgeAtTest() {
		return ageAtTest;
	}
	
	/**
	 * Sets the value of the ageAtTest property.
	 * 
	 * @param value allowed object is {@link PCRAgeAtTestType }
	 */
	public void setAgeAtTest(PCRAgeAtTestType value) {
		this.ageAtTest = value;
	}
	
	/**
	 * Gets the value of the dateSampleCollected property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateSampleCollected() {
		return dateSampleCollected;
	}
	
	/**
	 * Sets the value of the dateSampleCollected property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateSampleCollected(XMLGregorianCalendar value) {
		this.dateSampleCollected = value;
	}
	
	/**
	 * Gets the value of the result property.
	 * 
	 * @return possible object is {@link PCRRapidTestResultType }
	 */
	public PCRRapidTestResultType getResult() {
		return result;
	}
	
	/**
	 * Sets the value of the result property.
	 * 
	 * @param value allowed object is {@link PCRRapidTestResultType }
	 */
	public void setResult(PCRRapidTestResultType value) {
		this.result = value;
	}
	
	/**
	 * Gets the value of the dateResultReceived property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateResultReceived() {
		return dateResultReceived;
	}
	
	/**
	 * Sets the value of the dateResultReceived property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateResultReceived(XMLGregorianCalendar value) {
		this.dateResultReceived = value;
	}
	
}
