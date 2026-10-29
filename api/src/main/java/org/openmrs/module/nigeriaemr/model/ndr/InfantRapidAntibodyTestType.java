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
 * Java class for InfantRapidAntibodyTestType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantRapidAntibodyTestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgeAtTest_Months" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DateOfTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Result" type="{}PCRRapidTestResultType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfantRapidAntibodyTestType", propOrder = { "ageAtTestMonths", "dateOfTest", "result" })
public class InfantRapidAntibodyTestType {
	
	@XmlElement(name = "AgeAtTest_Months")
	protected BigInteger ageAtTestMonths;
	
	@XmlElement(name = "DateOfTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfTest;
	
	@XmlElement(name = "Result")
	@XmlSchemaType(name = "string")
	protected PCRRapidTestResultType result;
	
	/**
	 * Gets the value of the ageAtTestMonths property.
	 * 
	 * @return possible object is {@link BigInteger }
	 */
	public BigInteger getAgeAtTestMonths() {
		return ageAtTestMonths;
	}
	
	/**
	 * Sets the value of the ageAtTestMonths property.
	 * 
	 * @param value allowed object is {@link BigInteger }
	 */
	public void setAgeAtTestMonths(BigInteger value) {
		this.ageAtTestMonths = value;
	}
	
	/**
	 * Gets the value of the dateOfTest property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfTest() {
		return dateOfTest;
	}
	
	/**
	 * Sets the value of the dateOfTest property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfTest(XMLGregorianCalendar value) {
		this.dateOfTest = value;
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
	
}
