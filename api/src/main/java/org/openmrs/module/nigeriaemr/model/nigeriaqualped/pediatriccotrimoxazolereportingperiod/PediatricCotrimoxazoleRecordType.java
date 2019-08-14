package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_Cotrimoxazole_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_Cotrimoxazole_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientCurrentlyOnCotrimoxazoleProphylaxis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfFirstPrescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AgeOfFirstPrescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UnitOfAgeMeasure">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="YEARS"/>
 *               &lt;enumeration value="MONTHS"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
@XmlType(name = "Pediatric_Cotrimoxazole_RecordType", propOrder = { "patientID",
        "patientCurrentlyOnCotrimoxazoleProphylaxis", "dateOfFirstPrescription", "ageOfFirstPrescription",
        "unitOfAgeMeasure", "facilityID", "uploaderId", "uploadDt", "webUploadFlag", "reviewPeriodID" })
public class PediatricCotrimoxazoleRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientCurrentlyOnCotrimoxazoleProphylaxis", required = true)
	protected String patientCurrentlyOnCotrimoxazoleProphylaxis;
	
	@XmlElement(name = "DateOfFirstPrescription", required = true)
	protected String dateOfFirstPrescription;
	
	@XmlElement(name = "AgeOfFirstPrescription", required = true)
	protected String ageOfFirstPrescription;
	
	@XmlElement(name = "UnitOfAgeMeasure", required = true)
	protected String unitOfAgeMeasure;
	
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
	 * Gets the value of the patientCurrentlyOnCotrimoxazoleProphylaxis property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientCurrentlyOnCotrimoxazoleProphylaxis() {
		return patientCurrentlyOnCotrimoxazoleProphylaxis;
	}
	
	/**
	 * Sets the value of the patientCurrentlyOnCotrimoxazoleProphylaxis property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientCurrentlyOnCotrimoxazoleProphylaxis(String value) {
		this.patientCurrentlyOnCotrimoxazoleProphylaxis = value;
	}
	
	/**
	 * Gets the value of the dateOfFirstPrescription property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfFirstPrescription() {
		return dateOfFirstPrescription;
	}
	
	/**
	 * Sets the value of the dateOfFirstPrescription property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfFirstPrescription(String value) {
		this.dateOfFirstPrescription = value;
	}
	
	/**
	 * Gets the value of the ageOfFirstPrescription property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAgeOfFirstPrescription() {
		return ageOfFirstPrescription;
	}
	
	/**
	 * Sets the value of the ageOfFirstPrescription property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAgeOfFirstPrescription(String value) {
		this.ageOfFirstPrescription = value;
	}
	
	/**
	 * Gets the value of the unitOfAgeMeasure property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUnitOfAgeMeasure() {
		return unitOfAgeMeasure;
	}
	
	/**
	 * Sets the value of the unitOfAgeMeasure property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUnitOfAgeMeasure(String value) {
		this.unitOfAgeMeasure = value;
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
