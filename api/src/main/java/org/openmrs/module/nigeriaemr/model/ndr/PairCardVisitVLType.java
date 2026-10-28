package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PairCardVisitVLType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PairCardVisitVLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateSampleCollected" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateResultReceived" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ResultCopiesPerML" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PairCardVisitVLType", propOrder = { "dateSampleCollected", "dateResultReceived", "resultCopiesPerML" })
public class PairCardVisitVLType {
	
	@XmlElement(name = "DateSampleCollected")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateSampleCollected;
	
	@XmlElement(name = "DateResultReceived")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateResultReceived;
	
	@XmlElement(name = "ResultCopiesPerML")
	protected BigDecimal resultCopiesPerML;
	
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
	
	/**
	 * Gets the value of the resultCopiesPerML property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getResultCopiesPerML() {
		return resultCopiesPerML;
	}
	
	/**
	 * Sets the value of the resultCopiesPerML property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setResultCopiesPerML(BigDecimal value) {
		this.resultCopiesPerML = value;
	}
	
}
