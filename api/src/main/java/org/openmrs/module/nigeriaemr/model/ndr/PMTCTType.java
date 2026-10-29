package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PMTCTType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PMTCTType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PMTCTRegister" type="{}PMTCTRegisterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MotherInfantPairVisit" type="{}MotherInfantPairVisitType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DeliveryChildrenDetails" type="{}DeliveryChildrenDetailsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InfantCohortRegistration" type="{}InfantCohortRegistrationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTType", propOrder = { "pmtctRegister", "motherInfantPairVisit", "deliveryChildrenDetails",
        "infantCohortRegistration" })
public class PMTCTType {
	
	@XmlElement(name = "PMTCTRegister")
	protected List<PMTCTRegisterType> pmtctRegister;
	
	@XmlElement(name = "MotherInfantPairVisit")
	protected List<MotherInfantPairVisitType> motherInfantPairVisit;
	
	@XmlElement(name = "DeliveryChildrenDetails")
	protected List<DeliveryChildrenDetailsType> deliveryChildrenDetails;
	
	@XmlElement(name = "InfantCohortRegistration")
	protected List<InfantCohortRegistrationType> infantCohortRegistration;
	
	/**
	 * Gets the value of the pmtctRegister property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pmtctRegister property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getPMTCTRegister().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PMTCTRegisterType }
	 */
	
	public List<PMTCTRegisterType> getPMTCTRegister() {
		return pmtctRegister;
	}
	
	public void setPMTCTRegister(List<PMTCTRegisterType> pmtctRegister) {
		this.pmtctRegister = pmtctRegister;
	}
	
	/**
	 * Gets the value of the motherInfantPairVisit property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the motherInfantPairVisit property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getMotherInfantPairVisit().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link MotherInfantPairVisitType }
	 */
	
	public List<MotherInfantPairVisitType> getMotherInfantPairVisit() {
		return motherInfantPairVisit;
	}
	
	public void setMotherInfantPairVisit(List<MotherInfantPairVisitType> motherInfantPairVisit) {
		this.motherInfantPairVisit = motherInfantPairVisit;
	}
	
	/**
	 * Gets the value of the deliveryChildrenDetails property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the deliveryChildrenDetails property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getDeliveryChildrenDetails().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DeliveryChildrenDetailsType }
	 */
	
	public List<DeliveryChildrenDetailsType> getDeliveryChildrenDetails() {
		return deliveryChildrenDetails;
	}
	
	public void setDeliveryChildrenDetails(List<DeliveryChildrenDetailsType> deliveryChildrenDetails) {
		this.deliveryChildrenDetails = deliveryChildrenDetails;
	}
	
	/**
	 * Gets the value of the infantCohortRegistration property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the infantCohortRegistration property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 *    getInfantCohortRegistration().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link InfantCohortRegistrationType }
	 */
	
	public List<InfantCohortRegistrationType> getInfantCohortRegistration() {
		return infantCohortRegistration;
	}
	
	public void setInfantCohortRegistration(List<InfantCohortRegistrationType> infantCohortRegistration) {
		this.infantCohortRegistration = infantCohortRegistration;
	}
	
}
