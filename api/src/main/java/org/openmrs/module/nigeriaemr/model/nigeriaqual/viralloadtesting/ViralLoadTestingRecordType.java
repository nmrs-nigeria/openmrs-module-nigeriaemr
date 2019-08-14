package org.openmrs.module.nigeriaemr.model.nigeriaqual.viralloadtesting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ViralLoadTesting_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViralLoadTesting_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HasPatientReceivedVLTesting" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VLTestDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Result_Copies_Per_ml" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ViralLoadTesting_RecordType", propOrder = { "patientID", "hasPatientReceivedVLTesting", "vlTestDate",
        "resultCopiesPerMl", "facilityID", "uploaderId", "uploadDt", "webUploadFlag", "reviewPeriodID" })
public class ViralLoadTestingRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "HasPatientReceivedVLTesting", required = true)
	protected String hasPatientReceivedVLTesting;
	
	@XmlElement(name = "VLTestDate", required = true)
	protected String vlTestDate;
	
	@XmlElement(name = "Result_Copies_Per_ml", required = true)
	protected String resultCopiesPerMl;
	
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
	 * Gets the value of the hasPatientReceivedVLTesting property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHasPatientReceivedVLTesting() {
		return hasPatientReceivedVLTesting;
	}
	
	/**
	 * Sets the value of the hasPatientReceivedVLTesting property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHasPatientReceivedVLTesting(String value) {
		this.hasPatientReceivedVLTesting = value;
	}
	
	/**
	 * Gets the value of the vlTestDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVLTestDate() {
		return vlTestDate;
	}
	
	/**
	 * Sets the value of the vlTestDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVLTestDate(String value) {
		this.vlTestDate = value;
	}
	
	/**
	 * Gets the value of the resultCopiesPerMl property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getResultCopiesPerMl() {
		return resultCopiesPerMl;
	}
	
	/**
	 * Sets the value of the resultCopiesPerMl property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setResultCopiesPerMl(String value) {
		this.resultCopiesPerMl = value;
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
