package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for IndexContactTestingType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexContactTestingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ARTClinic" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexClientIDType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="HTS"/>
 *               &lt;enumeration value="ART"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexClientID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexClientLGA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndexClientState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCategory">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="ND"/>
 *               &lt;enumeration value="VU"/>
 *               &lt;enumeration value="RTT"/>
 *               &lt;enumeration value="OT"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OfferedIndexTestingServices">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AcceptedIndexTestingServices">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexContact" type="{}IndexContactType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexContactTestingType", propOrder = { "artClinic", "indexClientIDType", "indexClientID",
        "indexClientLGA", "indexClientState", "clientCategory", "offeredIndexTestingServices",
        "acceptedIndexTestingServices", "indexContact" })
public class IndexContactTestingType {
	
	@XmlElement(name = "ARTClinic")
	protected String artClinic;
	
	@XmlElement(name = "IndexClientIDType")
	protected String indexClientIDType;
	
	@XmlElement(name = "IndexClientID")
	protected String indexClientID;
	
	@XmlElement(name = "IndexClientLGA")
	protected String indexClientLGA;
	
	@XmlElement(name = "IndexClientState")
	protected String indexClientState;
	
	@XmlElement(name = "ClientCategory", required = true)
	protected String clientCategory;
	
	@XmlElement(name = "OfferedIndexTestingServices", required = true)
	protected String offeredIndexTestingServices;
	
	@XmlElement(name = "AcceptedIndexTestingServices", required = true)
	protected String acceptedIndexTestingServices;
	
	@XmlElement(name = "IndexContact")
	protected List<IndexContactType> indexContact;
	
	/**
	 * Gets the value of the artClinic property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARTClinic() {
		return artClinic;
	}
	
	/**
	 * Sets the value of the artClinic property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARTClinic(String value) {
		this.artClinic = value;
	}
	
	/**
	 * Gets the value of the indexClientIDType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexClientIDType() {
		return indexClientIDType;
	}
	
	/**
	 * Sets the value of the indexClientIDType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexClientIDType(String value) {
		this.indexClientIDType = value;
	}
	
	/**
	 * Gets the value of the indexClientID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexClientID() {
		return indexClientID;
	}
	
	/**
	 * Sets the value of the indexClientID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexClientID(String value) {
		this.indexClientID = value;
	}
	
	/**
	 * Gets the value of the indexClientLGA property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexClientLGA() {
		return indexClientLGA;
	}
	
	/**
	 * Sets the value of the indexClientLGA property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexClientLGA(String value) {
		this.indexClientLGA = value;
	}
	
	/**
	 * Gets the value of the indexClientState property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexClientState() {
		return indexClientState;
	}
	
	/**
	 * Sets the value of the indexClientState property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexClientState(String value) {
		this.indexClientState = value;
	}
	
	/**
	 * Gets the value of the clientCategory property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClientCategory() {
		return clientCategory;
	}
	
	/**
	 * Sets the value of the clientCategory property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClientCategory(String value) {
		this.clientCategory = value;
	}
	
	/**
	 * Gets the value of the offeredIndexTestingServices property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOfferedIndexTestingServices() {
		return offeredIndexTestingServices;
	}
	
	/**
	 * Sets the value of the offeredIndexTestingServices property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOfferedIndexTestingServices(String value) {
		this.offeredIndexTestingServices = value;
	}
	
	/**
	 * Gets the value of the acceptedIndexTestingServices property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAcceptedIndexTestingServices() {
		return acceptedIndexTestingServices;
	}
	
	/**
	 * Sets the value of the acceptedIndexTestingServices property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAcceptedIndexTestingServices(String value) {
		this.acceptedIndexTestingServices = value;
	}
	
	/**
	 * Gets the value of the indexContact property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the indexContact property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getIndexContact().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link IndexContactType }
	 */
	public List<IndexContactType> getIndexContact() {
		if (indexContact == null) {
			indexContact = new ArrayList<IndexContactType>();
		}
		return this.indexContact;
	}
	
}
