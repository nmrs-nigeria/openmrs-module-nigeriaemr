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
 * Java class for VLMeasurementType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VLMeasurementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ResultCopiesPerML" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VLMeasurementType", propOrder = { "resultDate", "resultCopiesPerML" })
public class VLMeasurementType {
	
	@XmlElement(name = "ResultDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar resultDate;
	
	@XmlElement(name = "ResultCopiesPerML", required = true)
	protected BigDecimal resultCopiesPerML;
	
	/**
	 * Gets the value of the resultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getResultDate() {
		return resultDate;
	}
	
	/**
	 * Sets the value of the resultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setResultDate(XMLGregorianCalendar value) {
		this.resultDate = value;
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
