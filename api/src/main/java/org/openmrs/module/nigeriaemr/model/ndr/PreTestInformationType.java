package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PreTestInformationType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PreTestInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KnowledgeAssessment" type="{}KnowledgeAssessmentType" minOccurs="0"/>
 *         &lt;element name="HIVRiskAssessment" type="{}HIVRiskAssessmentType" minOccurs="0"/>
 *         &lt;element name="ClinicalTBScreening" type="{}ClinicalTBScreeningType" minOccurs="0"/>
 *         &lt;element name="SyndromicSTIScreening" type="{}SyndromicSTIScreeningType" minOccurs="0"/>
 *         &lt;element name="SexPartnerRiskAssessment" type="{}SexPartnerRiskAssessmentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreTestInformationType", propOrder = { "knowledgeAssessment", "hivRiskAssessment", "clinicalTBScreening",
        "syndromicSTIScreening", "sexPartnerRiskAssessment" })
public class PreTestInformationType {
	
	@XmlElement(name = "KnowledgeAssessment")
	protected KnowledgeAssessmentType knowledgeAssessment;
	
	@XmlElement(name = "HIVRiskAssessment")
	protected HIVRiskAssessmentType hivRiskAssessment;
	
	@XmlElement(name = "ClinicalTBScreening")
	protected ClinicalTBScreeningType clinicalTBScreening;
	
	@XmlElement(name = "SyndromicSTIScreening")
	protected SyndromicSTIScreeningType syndromicSTIScreening;
	
	@XmlElement(name = "SexPartnerRiskAssessment")
	protected SexPartnerRiskAssessmentType sexPartnerRiskAssessment;
	
	/**
	 * Gets the value of the knowledgeAssessment property.
	 * 
	 * @return possible object is {@link KnowledgeAssessmentType }
	 */
	public KnowledgeAssessmentType getKnowledgeAssessment() {
		return knowledgeAssessment;
	}
	
	/**
	 * Sets the value of the knowledgeAssessment property.
	 * 
	 * @param value allowed object is {@link KnowledgeAssessmentType }
	 */
	public void setKnowledgeAssessment(KnowledgeAssessmentType value) {
		this.knowledgeAssessment = value;
	}
	
	/**
	 * Gets the value of the hivRiskAssessment property.
	 * 
	 * @return possible object is {@link HIVRiskAssessmentType }
	 */
	public HIVRiskAssessmentType getHIVRiskAssessment() {
		return hivRiskAssessment;
	}
	
	/**
	 * Sets the value of the hivRiskAssessment property.
	 * 
	 * @param value allowed object is {@link HIVRiskAssessmentType }
	 */
	public void setHIVRiskAssessment(HIVRiskAssessmentType value) {
		this.hivRiskAssessment = value;
	}
	
	/**
	 * Gets the value of the clinicalTBScreening property.
	 * 
	 * @return possible object is {@link ClinicalTBScreeningType }
	 */
	public ClinicalTBScreeningType getClinicalTBScreening() {
		return clinicalTBScreening;
	}
	
	/**
	 * Sets the value of the clinicalTBScreening property.
	 * 
	 * @param value allowed object is {@link ClinicalTBScreeningType }
	 */
	public void setClinicalTBScreening(ClinicalTBScreeningType value) {
		this.clinicalTBScreening = value;
	}
	
	/**
	 * Gets the value of the syndromicSTIScreening property.
	 * 
	 * @return possible object is {@link SyndromicSTIScreeningType }
	 */
	public SyndromicSTIScreeningType getSyndromicSTIScreening() {
		return syndromicSTIScreening;
	}
	
	/**
	 * Sets the value of the syndromicSTIScreening property.
	 * 
	 * @param value allowed object is {@link SyndromicSTIScreeningType }
	 */
	public void setSyndromicSTIScreening(SyndromicSTIScreeningType value) {
		this.syndromicSTIScreening = value;
	}
	
	/**
	 * Gets the value of the sexPartnerRiskAssessment property.
	 * 
	 * @return possible object is {@link SexPartnerRiskAssessmentType }
	 */
	public SexPartnerRiskAssessmentType getSexPartnerRiskAssessment() {
		return sexPartnerRiskAssessment;
	}
	
	/**
	 * Sets the value of the sexPartnerRiskAssessment property.
	 * 
	 * @param value allowed object is {@link SexPartnerRiskAssessmentType }
	 */
	public void setSexPartnerRiskAssessment(SexPartnerRiskAssessmentType value) {
		this.sexPartnerRiskAssessment = value;
	}
	
}
