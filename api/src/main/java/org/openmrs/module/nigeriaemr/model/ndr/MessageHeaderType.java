package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for MessageHeaderType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageStatusCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="INITIAL"/>
 *               &lt;enumeration value="UPDATED"/>
 *               &lt;enumeration value="REDACTED"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MessageCreationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MessageSchemaVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MessageUniqueID" type="{}StringType"/>
 *         &lt;element name="MessageSendingOrganization" type="{}FacilityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeaderType", propOrder = { "messageStatusCode", "messageCreationDateTime", "messageSchemaVersion",
        "messageUniqueID", "messageSendingOrganization" })
public class MessageHeaderType {
	
	@XmlElement(name = "MessageStatusCode", required = true)
	protected String messageStatusCode;
	
	@XmlElement(name = "MessageCreationDateTime", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar messageCreationDateTime;
	
	@XmlElement(name = "MessageSchemaVersion", required = true)
	protected String messageSchemaVersion;
	
	@XmlElement(name = "MessageUniqueID", required = true)
	protected String messageUniqueID;
	
	@XmlElement(name = "MessageSendingOrganization", required = true)
	protected FacilityType messageSendingOrganization;
	
	/**
	 * Gets the value of the messageStatusCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMessageStatusCode() {
		return messageStatusCode;
	}
	
	/**
	 * Sets the value of the messageStatusCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMessageStatusCode(String value) {
		this.messageStatusCode = value;
	}
	
	/**
	 * Gets the value of the messageCreationDateTime property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMessageCreationDateTime() {
		return messageCreationDateTime;
	}
	
	/**
	 * Sets the value of the messageCreationDateTime property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMessageCreationDateTime(XMLGregorianCalendar value) {
		this.messageCreationDateTime = value;
	}
	
	/**
	 * Gets the value of the messageSchemaVersion property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMessageSchemaVersion() {
		return messageSchemaVersion;
	}
	
	/**
	 * Sets the value of the messageSchemaVersion property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMessageSchemaVersion(String value) {
		this.messageSchemaVersion = value;
	}
	
	/**
	 * Gets the value of the messageUniqueID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMessageUniqueID() {
		return messageUniqueID;
	}
	
	/**
	 * Sets the value of the messageUniqueID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMessageUniqueID(String value) {
		this.messageUniqueID = value;
	}
	
	/**
	 * Gets the value of the messageSendingOrganization property.
	 * 
	 * @return possible object is {@link FacilityType }
	 */
	public FacilityType getMessageSendingOrganization() {
		return messageSendingOrganization;
	}
	
	/**
	 * Sets the value of the messageSendingOrganization property.
	 * 
	 * @param value allowed object is {@link FacilityType }
	 */
	public void setMessageSendingOrganization(FacilityType value) {
		this.messageSendingOrganization = value;
	}
	
}
