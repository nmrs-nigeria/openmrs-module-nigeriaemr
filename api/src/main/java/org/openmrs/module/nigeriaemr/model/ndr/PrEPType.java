package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PrEPType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrEPType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScreeningAndEligibility" type="{}PrepScreeningAndEligibilityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CardEnrollment" type="{}PrepPepCardEnrollmentType" minOccurs="0"/>
 *         &lt;element name="PrepFollowUpVisit" type="{}PrepFollowUpVisitType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PepFollowUpVisit" type="{}PepFollowUpVisitType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Discontinuation" type="{}PrepDiscontinuationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrEPType", propOrder = { "screeningAndEligibility", "cardEnrollment", "prepFollowUpVisit",
        "pepFollowUpVisit", "discontinuation" })
public class PrEPType {
	
	@XmlElement(name = "ScreeningAndEligibility")
	protected List<PrepScreeningAndEligibilityType> screeningAndEligibility;
	
	@XmlElement(name = "CardEnrollment")
	protected PrepPepCardEnrollmentType cardEnrollment;
	
	@XmlElement(name = "PrepFollowUpVisit")
	protected List<PrepFollowUpVisitType> prepFollowUpVisit;
	
	@XmlElement(name = "PepFollowUpVisit")
	protected List<PepFollowUpVisitType> pepFollowUpVisit;
	
	@XmlElement(name = "Discontinuation")
	protected PrepDiscontinuationType discontinuation;
	
	/**
	 * Gets the value of the screeningAndEligibility property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the screeningAndEligibility property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getScreeningAndEligibility().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PrepScreeningAndEligibilityType }
	 */
	public List<PrepScreeningAndEligibilityType> getScreeningAndEligibility() {
		if (screeningAndEligibility == null) {
			screeningAndEligibility = new ArrayList<PrepScreeningAndEligibilityType>();
		}
		return this.screeningAndEligibility;
	}
	
	/**
	 * Gets the value of the cardEnrollment property.
	 * 
	 * @return possible object is {@link PrepPepCardEnrollmentType }
	 */
	public PrepPepCardEnrollmentType getCardEnrollment() {
		return cardEnrollment;
	}
	
	/**
	 * Sets the value of the cardEnrollment property.
	 * 
	 * @param value allowed object is {@link PrepPepCardEnrollmentType }
	 */
	public void setCardEnrollment(PrepPepCardEnrollmentType value) {
		this.cardEnrollment = value;
	}
	
	/**
	 * Gets the value of the prepFollowUpVisit property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the prepFollowUpVisit property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPrepFollowUpVisit().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PrepFollowUpVisitType }
	 */
	public List<PrepFollowUpVisitType> getPrepFollowUpVisit() {
		if (prepFollowUpVisit == null) {
			prepFollowUpVisit = new ArrayList<PrepFollowUpVisitType>();
		}
		return this.prepFollowUpVisit;
	}
	
	/**
	 * Gets the value of the pepFollowUpVisit property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pepFollowUpVisit property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPepFollowUpVisit().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PepFollowUpVisitType }
	 */
	public List<PepFollowUpVisitType> getPepFollowUpVisit() {
		if (pepFollowUpVisit == null) {
			pepFollowUpVisit = new ArrayList<PepFollowUpVisitType>();
		}
		return this.pepFollowUpVisit;
	}
	
	/**
	 * Gets the value of the discontinuation property.
	 * 
	 * @return possible object is {@link PrepDiscontinuationType }
	 */
	public PrepDiscontinuationType getDiscontinuation() {
		return discontinuation;
	}
	
	/**
	 * Sets the value of the discontinuation property.
	 * 
	 * @param value allowed object is {@link PrepDiscontinuationType }
	 */
	public void setDiscontinuation(PrepDiscontinuationType value) {
		this.discontinuation = value;
	}
	
}
