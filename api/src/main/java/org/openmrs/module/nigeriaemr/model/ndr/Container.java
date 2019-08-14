package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{}MessageHeaderType"/>
 *         &lt;choice>
 *           &lt;element name="IndividualReport" type="{}IndividualReportType"/>
 *           &lt;element name="Validation" type="{}StringType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "messageHeader", "individualReport", "validation" })
@XmlRootElement(name = "Container")
public class Container {
	
	@XmlElement(name = "MessageHeader", required = true)
	protected MessageHeaderType messageHeader;
	
	@XmlElement(name = "IndividualReport")
	protected IndividualReportType individualReport;
	
	@XmlElement(name = "Validation")
	protected String validation;
	
	/**
	 * Gets the value of the messageHeader property.
	 * 
	 * @return possible object is {@link MessageHeaderType }
	 */
	public MessageHeaderType getMessageHeader() {
		return messageHeader;
	}
	
	/**
	 * Sets the value of the messageHeader property.
	 * 
	 * @param value allowed object is {@link MessageHeaderType }
	 */
	public void setMessageHeader(MessageHeaderType value) {
		this.messageHeader = value;
	}
	
	/**
	 * Gets the value of the individualReport property.
	 * 
	 * @return possible object is {@link IndividualReportType }
	 */
	public IndividualReportType getIndividualReport() {
		return individualReport;
	}
	
	/**
	 * Sets the value of the individualReport property.
	 * 
	 * @param value allowed object is {@link IndividualReportType }
	 */
	public void setIndividualReport(IndividualReportType value) {
		this.individualReport = value;
	}
	
	public String getValidation() {
		return validation;
	}
	
	public void setValidation(String validation) {
		this.validation = validation;
	}
}
