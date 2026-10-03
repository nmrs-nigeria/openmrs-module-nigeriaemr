package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PrepDiscontinuationType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepDiscontinuationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Interruption" type="{}PrepInterruptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DateClientReferredOut" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FacilityReferredTo" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="DateClientDied" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SourceOfDeathInformation" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="CauseOfDeath" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="DiscontinuedPrepPepReason" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DiscontinuedPrepPepDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ArtLinkDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepDiscontinuationType", propOrder = { "interruption", "dateClientReferredOut", "facilityReferredTo",
        "dateClientDied", "sourceOfDeathInformation", "causeOfDeath", "discontinuedPrepPepReason",
        "discontinuedPrepPepDate", "artLinkDate" })
public class PrepDiscontinuationType {
	
	@XmlElement(name = "Interruption")
	protected List<PrepInterruptionType> interruption;
	
	@XmlElement(name = "DateClientReferredOut")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateClientReferredOut;
	
	@XmlElement(name = "FacilityReferredTo")
	protected String facilityReferredTo;
	
	@XmlElement(name = "DateClientDied")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateClientDied;
	
	@XmlElement(name = "SourceOfDeathInformation")
	protected String sourceOfDeathInformation;
	
	@XmlElement(name = "CauseOfDeath")
	protected String causeOfDeath;
	
	@XmlElement(name = "DiscontinuedPrepPepReason")
	protected String discontinuedPrepPepReason;
	
	@XmlElement(name = "DiscontinuedPrepPepDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar discontinuedPrepPepDate;
	
	@XmlElement(name = "ArtLinkDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar artLinkDate;
	
	/**
	 * Gets the value of the interruption property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the interruption property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getInterruption().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PrepInterruptionType }
	 */
	public List<PrepInterruptionType> getInterruption() {
		if (interruption == null) {
			interruption = new ArrayList<PrepInterruptionType>();
		}
		return this.interruption;
	}
	
	/**
	 * Gets the value of the dateClientReferredOut property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateClientReferredOut() {
		return dateClientReferredOut;
	}
	
	/**
	 * Sets the value of the dateClientReferredOut property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateClientReferredOut(XMLGregorianCalendar value) {
		this.dateClientReferredOut = value;
	}
	
	/**
	 * Gets the value of the facilityReferredTo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityReferredTo() {
		return facilityReferredTo;
	}
	
	/**
	 * Sets the value of the facilityReferredTo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityReferredTo(String value) {
		this.facilityReferredTo = value;
	}
	
	/**
	 * Gets the value of the dateClientDied property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateClientDied() {
		return dateClientDied;
	}
	
	/**
	 * Sets the value of the dateClientDied property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateClientDied(XMLGregorianCalendar value) {
		this.dateClientDied = value;
	}
	
	/**
	 * Gets the value of the sourceOfDeathInformation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSourceOfDeathInformation() {
		return sourceOfDeathInformation;
	}
	
	/**
	 * Sets the value of the sourceOfDeathInformation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSourceOfDeathInformation(String value) {
		this.sourceOfDeathInformation = value;
	}
	
	/**
	 * Gets the value of the causeOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	
	/**
	 * Sets the value of the causeOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeath(String value) {
		this.causeOfDeath = value;
	}
	
	/**
	 * Gets the value of the discontinuedPrepPepReason property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDiscontinuedPrepPepReason() {
		return discontinuedPrepPepReason;
	}
	
	/**
	 * Sets the value of the discontinuedPrepPepReason property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDiscontinuedPrepPepReason(String value) {
		this.discontinuedPrepPepReason = value;
	}
	
	/**
	 * Gets the value of the discontinuedPrepPepDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDiscontinuedPrepPepDate() {
		return discontinuedPrepPepDate;
	}
	
	/**
	 * Sets the value of the discontinuedPrepPepDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDiscontinuedPrepPepDate(XMLGregorianCalendar value) {
		this.discontinuedPrepPepDate = value;
	}
	
	/**
	 * Gets the value of the artLinkDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getArtLinkDate() {
		return artLinkDate;
	}
	
	/**
	 * Sets the value of the artLinkDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setArtLinkDate(XMLGregorianCalendar value) {
		this.artLinkDate = value;
	}
	
}
