package org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ClinicalEvaluationVisitsInReviewPeriod_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClinicalEvaluationVisitsInReviewPeriod_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Visit1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Visit2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Visit3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Visit4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriodID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClinicalEvaluationVisitsInReviewPeriod_RecordType", propOrder = { "patientID", "visit1", "visit2",
        "visit3", "visit4", "facilityID", "uploaderId", "uploadDt", "webUploadFlag", "reviewPeriodID" })
public class ClinicalEvaluationVisitsInReviewPeriodRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "Visit1", required = true)
	protected String visit1;
	
	@XmlElement(name = "Visit2", required = true)
	protected String visit2;
	
	@XmlElement(name = "Visit3", required = true)
	protected String visit3;
	
	@XmlElement(name = "Visit4", required = true)
	protected String visit4;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploadDt", required = true)
	protected String uploadDt;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
	@XmlElement(name = "ReviewPeriodID", required = true)
	protected String reviewPeriodID;
	
	/**
	 * Gets the value of the patientID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientID() {
		return patientID;
	}
	
	/**
	 * Sets the value of the patientID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientID(String value) {
		this.patientID = value;
	}
	
	/**
	 * Gets the value of the visit1 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisit1() {
		return visit1;
	}
	
	/**
	 * Sets the value of the visit1 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisit1(String value) {
		this.visit1 = value;
	}
	
	/**
	 * Gets the value of the visit2 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisit2() {
		return visit2;
	}
	
	/**
	 * Sets the value of the visit2 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisit2(String value) {
		this.visit2 = value;
	}
	
	/**
	 * Gets the value of the visit3 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisit3() {
		return visit3;
	}
	
	/**
	 * Sets the value of the visit3 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisit3(String value) {
		this.visit3 = value;
	}
	
	/**
	 * Gets the value of the visit4 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisit4() {
		return visit4;
	}
	
	/**
	 * Sets the value of the visit4 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisit4(String value) {
		this.visit4 = value;
	}
	
	/**
	 * Gets the value of the facilityID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityID() {
		return facilityID;
	}
	
	/**
	 * Sets the value of the facilityID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityID(String value) {
		this.facilityID = value;
	}
	
	/**
	 * Gets the value of the uploaderId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUploaderId() {
		return uploaderId;
	}
	
	/**
	 * Sets the value of the uploaderId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUploaderId(String value) {
		this.uploaderId = value;
	}
	
	/**
	 * Gets the value of the uploadDt property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUploadDt() {
		return uploadDt;
	}
	
	/**
	 * Sets the value of the uploadDt property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUploadDt(String value) {
		this.uploadDt = value;
	}
	
	/**
	 * Gets the value of the webUploadFlag property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWebUploadFlag() {
		return webUploadFlag;
	}
	
	/**
	 * Sets the value of the webUploadFlag property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWebUploadFlag(String value) {
		this.webUploadFlag = value;
	}
	
	/**
	 * Gets the value of the reviewPeriodID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReviewPeriodID() {
		return reviewPeriodID;
	}
	
	/**
	 * Sets the value of the reviewPeriodID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReviewPeriodID(String value) {
		this.reviewPeriodID = value;
	}
	
}
