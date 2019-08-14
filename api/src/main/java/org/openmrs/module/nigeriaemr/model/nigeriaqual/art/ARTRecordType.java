package org.openmrs.module.nigeriaemr.model.nigeriaqual.art;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ART_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ART_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientEverStartedOnART" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ART_Start_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TreatmentPrepCompletedBeforeStartOfART" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ART_RecordType", propOrder = { "patientID", "patientEverStartedOnART", "artStartDate",
        "treatmentPrepCompletedBeforeStartOfART", "facilityID", "uploaderId", "uploadDt", "webUploadFlag", "reviewPeriodID" })
public class ARTRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientEverStartedOnART", required = true)
	protected String patientEverStartedOnART;
	
	@XmlElement(name = "ART_Start_Date", required = true)
	protected String artStartDate;
	
	@XmlElement(name = "TreatmentPrepCompletedBeforeStartOfART", required = true)
	protected String treatmentPrepCompletedBeforeStartOfART;
	
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
	 * Gets the value of the patientEverStartedOnART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientEverStartedOnART() {
		return patientEverStartedOnART;
	}
	
	/**
	 * Sets the value of the patientEverStartedOnART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientEverStartedOnART(String value) {
		this.patientEverStartedOnART = value;
	}
	
	/**
	 * Gets the value of the artStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARTStartDate() {
		return artStartDate;
	}
	
	/**
	 * Sets the value of the artStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARTStartDate(String value) {
		this.artStartDate = value;
	}
	
	/**
	 * Gets the value of the treatmentPrepCompletedBeforeStartOfART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTreatmentPrepCompletedBeforeStartOfART() {
		return treatmentPrepCompletedBeforeStartOfART;
	}
	
	/**
	 * Sets the value of the treatmentPrepCompletedBeforeStartOfART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTreatmentPrepCompletedBeforeStartOfART(String value) {
		this.treatmentPrepCompletedBeforeStartOfART = value;
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
