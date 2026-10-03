package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for InfantRapidTestType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfantRapidTestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="AgeAtTest" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DateOfTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RapidTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *               &lt;enumeration value="Indet"/>
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
@XmlType(name = "InfantRapidTestType", propOrder = { "visitID", "visitDate", "ageAtTest", "dateOfTest", "rapidTestResult" })
public class InfantRapidTestType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "AgeAtTest")
	protected Integer ageAtTest;
	
	@XmlElement(name = "DateOfTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfTest;
	
	@XmlElement(name = "RapidTestResult")
	protected String rapidTestResult;
	
	/**
	 * Gets the value of the visitID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitID() {
		return visitID;
	}
	
	/**
	 * Sets the value of the visitID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitID(String value) {
		this.visitID = value;
	}
	
	/**
	 * Gets the value of the visitDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets the value of the visitDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setVisitDate(XMLGregorianCalendar value) {
		this.visitDate = value;
	}
	
	/**
	 * Gets the value of the ageAtTest property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getAgeAtTest() {
		return ageAtTest;
	}
	
	/**
	 * Sets the value of the ageAtTest property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setAgeAtTest(Integer value) {
		this.ageAtTest = value;
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
	 * Gets the value of the rapidTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRapidTestResult() {
		return rapidTestResult;
	}
	
	/**
	 * Sets the value of the rapidTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRapidTestResult(String value) {
		this.rapidTestResult = value;
	}
	
}
