package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartadherencerecord;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_ART_Adherence_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_ART_Adherence_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ARTAdherenceAssessmentPerformedDuringLast3Months">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NO"/>
 *               &lt;enumeration value="YES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LastDateOfAssessment" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Pediatric_ART_Adherence_RecordType", propOrder = { "patientID",
        "artAdherenceAssessmentPerformedDuringLast3Months", "lastDateOfAssessment", "facilityID", "uploaderId", "uploadDt",
        "webUploadFlag", "reviewPeriodID" })
public class PediatricARTAdherenceRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "ARTAdherenceAssessmentPerformedDuringLast3Months", required = true)
	protected String artAdherenceAssessmentPerformedDuringLast3Months;
	
	@XmlElement(name = "LastDateOfAssessment", required = true)
	protected String lastDateOfAssessment;
	
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
	 * Gets the value of the artAdherenceAssessmentPerformedDuringLast3Months property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARTAdherenceAssessmentPerformedDuringLast3Months() {
		return artAdherenceAssessmentPerformedDuringLast3Months;
	}
	
	/**
	 * Sets the value of the artAdherenceAssessmentPerformedDuringLast3Months property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARTAdherenceAssessmentPerformedDuringLast3Months(String value) {
		this.artAdherenceAssessmentPerformedDuringLast3Months = value;
	}
	
	/**
	 * Gets the value of the lastDateOfAssessment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLastDateOfAssessment() {
		return lastDateOfAssessment;
	}
	
	/**
	 * Sets the value of the lastDateOfAssessment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLastDateOfAssessment(String value) {
		this.lastDateOfAssessment = value;
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
