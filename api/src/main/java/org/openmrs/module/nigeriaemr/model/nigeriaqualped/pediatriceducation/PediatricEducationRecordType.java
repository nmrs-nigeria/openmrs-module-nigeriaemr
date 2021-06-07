package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_Education_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_Education_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MotherReceivedInfantFeedingEducation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Pediatric_Education_RecordType", propOrder = { "patientID", "motherReceivedInfantFeedingEducation",
        "facilityID", "uploaderId", "uploadDt", "webUploadFlag", "reviewPeriodID" })
public class PediatricEducationRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "MotherReceivedInfantFeedingEducation", required = true)
	protected String motherReceivedInfantFeedingEducation;
	
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
	 * Gets the value of the motherReceivedInfantFeedingEducation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherReceivedInfantFeedingEducation() {
		return motherReceivedInfantFeedingEducation;
	}
	
	/**
	 * Sets the value of the motherReceivedInfantFeedingEducation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherReceivedInfantFeedingEducation(String value) {
		this.motherReceivedInfantFeedingEducation = value;
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
