package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Have you had sex with an HIV positive partner who falls in any category below? (last 3 months)
 * <p>
 * Java class for SexPartnerRiskAssessmentType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SexPartnerRiskAssessmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PartnerNewlyDiagnosedOnARTLessThan3To6Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerPregnantReceivingARVForPMTCT" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerAdolescent10To19KnownHIVInfected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerKnownPositiveNotRegularlyOnDrugs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerKnownPositiveRecentlyReturnedAfterLTFU" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SexPartnerRiskAssessmentType", propOrder = { "partnerNewlyDiagnosedOnARTLessThan3To6Months",
        "partnerPregnantReceivingARVForPMTCT", "partnerAdolescent10To19KnownHIVInfected",
        "partnerKnownPositiveNotRegularlyOnDrugs", "partnerKnownPositiveRecentlyReturnedAfterLTFU" })
public class SexPartnerRiskAssessmentType {
	
	@XmlElement(name = "PartnerNewlyDiagnosedOnARTLessThan3To6Months")
	protected Boolean partnerNewlyDiagnosedOnARTLessThan3To6Months;
	
	@XmlElement(name = "PartnerPregnantReceivingARVForPMTCT")
	protected Boolean partnerPregnantReceivingARVForPMTCT;
	
	@XmlElement(name = "PartnerAdolescent10To19KnownHIVInfected")
	protected Boolean partnerAdolescent10To19KnownHIVInfected;
	
	@XmlElement(name = "PartnerKnownPositiveNotRegularlyOnDrugs")
	protected Boolean partnerKnownPositiveNotRegularlyOnDrugs;
	
	@XmlElement(name = "PartnerKnownPositiveRecentlyReturnedAfterLTFU")
	protected Boolean partnerKnownPositiveRecentlyReturnedAfterLTFU;
	
	/**
	 * Gets the value of the partnerNewlyDiagnosedOnARTLessThan3To6Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerNewlyDiagnosedOnARTLessThan3To6Months() {
		return partnerNewlyDiagnosedOnARTLessThan3To6Months;
	}
	
	/**
	 * Sets the value of the partnerNewlyDiagnosedOnARTLessThan3To6Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerNewlyDiagnosedOnARTLessThan3To6Months(Boolean value) {
		this.partnerNewlyDiagnosedOnARTLessThan3To6Months = value;
	}
	
	/**
	 * Gets the value of the partnerPregnantReceivingARVForPMTCT property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerPregnantReceivingARVForPMTCT() {
		return partnerPregnantReceivingARVForPMTCT;
	}
	
	/**
	 * Sets the value of the partnerPregnantReceivingARVForPMTCT property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerPregnantReceivingARVForPMTCT(Boolean value) {
		this.partnerPregnantReceivingARVForPMTCT = value;
	}
	
	/**
	 * Gets the value of the partnerAdolescent10To19KnownHIVInfected property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerAdolescent10To19KnownHIVInfected() {
		return partnerAdolescent10To19KnownHIVInfected;
	}
	
	/**
	 * Sets the value of the partnerAdolescent10To19KnownHIVInfected property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerAdolescent10To19KnownHIVInfected(Boolean value) {
		this.partnerAdolescent10To19KnownHIVInfected = value;
	}
	
	/**
	 * Gets the value of the partnerKnownPositiveNotRegularlyOnDrugs property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerKnownPositiveNotRegularlyOnDrugs() {
		return partnerKnownPositiveNotRegularlyOnDrugs;
	}
	
	/**
	 * Sets the value of the partnerKnownPositiveNotRegularlyOnDrugs property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerKnownPositiveNotRegularlyOnDrugs(Boolean value) {
		this.partnerKnownPositiveNotRegularlyOnDrugs = value;
	}
	
	/**
	 * Gets the value of the partnerKnownPositiveRecentlyReturnedAfterLTFU property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerKnownPositiveRecentlyReturnedAfterLTFU() {
		return partnerKnownPositiveRecentlyReturnedAfterLTFU;
	}
	
	/**
	 * Sets the value of the partnerKnownPositiveRecentlyReturnedAfterLTFU property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerKnownPositiveRecentlyReturnedAfterLTFU(Boolean value) {
		this.partnerKnownPositiveRecentlyReturnedAfterLTFU = value;
	}
	
}
