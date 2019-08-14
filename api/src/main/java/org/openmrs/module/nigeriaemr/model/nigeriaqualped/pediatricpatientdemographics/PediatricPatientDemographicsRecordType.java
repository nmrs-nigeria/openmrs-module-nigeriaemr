package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientdemographics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_PatientDemographics_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_PatientDemographics_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HospitalNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Gender">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="MALE"/>
 *               &lt;enumeration value="FEMALE"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UnitOfAgeMeasure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateEnrolledInCare" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClinicalVisit6MonthsPriorToReviewPeriod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NO"/>
 *               &lt;enumeration value="YES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeliveryLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PrimaryCareGiver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StateOfResidence">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NASARAWA"/>
 *               &lt;enumeration value="FCT"/>
 *               &lt;enumeration value="ENUGU"/>
 *               &lt;enumeration value="NIGER"/>
 *               &lt;enumeration value="PLATEAU"/>
 *               &lt;enumeration value="KWOI"/>
 *               &lt;enumeration value="KADUNA"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LGAOfResidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StateOfOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tribe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfLastVisit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AdmissionDuringReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RNL_SerialNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CareGiverOccupation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecordCompletionPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pediatric_PatientDemographics_RecordType", propOrder = { "patientID", "lastname", "firstname",
        "hospitalNo", "gender", "dateOfBirth", "age", "unitOfAgeMeasure", "dateEnrolledInCare",
        "clinicalVisit6MonthsPriorToReviewPeriod", "deliveryLocation", "primaryCareGiver", "stateOfResidence",
        "lgaOfResidence", "stateOfOrigin", "tribe", "dateOfLastVisit", "admissionDuringReviewPeriod", "rnlSerialNo",
        "careGiverOccupation", "facilityID", "recordCompletionPosition", "uploaderId", "uploadDt", "webUploadFlag",
        "reviewPeriod" })
public class PediatricPatientDemographicsRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "Lastname", required = true)
	protected String lastname;
	
	@XmlElement(name = "Firstname", required = true)
	protected String firstname;
	
	@XmlElement(name = "HospitalNo", required = true)
	protected String hospitalNo;
	
	@XmlElement(name = "Gender", required = true)
	protected String gender;
	
	@XmlElement(name = "DateOfBirth", required = true)
	protected String dateOfBirth;
	
	@XmlElement(name = "Age", required = true)
	protected String age;
	
	@XmlElement(name = "UnitOfAgeMeasure", required = true)
	protected String unitOfAgeMeasure;
	
	@XmlElement(name = "DateEnrolledInCare", required = true)
	protected String dateEnrolledInCare;
	
	@XmlElement(name = "ClinicalVisit6MonthsPriorToReviewPeriod", required = true)
	protected String clinicalVisit6MonthsPriorToReviewPeriod;
	
	@XmlElement(name = "DeliveryLocation", required = true)
	protected String deliveryLocation;
	
	@XmlElement(name = "PrimaryCareGiver", required = true)
	protected String primaryCareGiver;
	
	@XmlElement(name = "StateOfResidence", required = true)
	protected String stateOfResidence;
	
	@XmlElement(name = "LGAOfResidence", required = true)
	protected String lgaOfResidence;
	
	@XmlElement(name = "StateOfOrigin", required = true)
	protected String stateOfOrigin;
	
	@XmlElement(name = "Tribe", required = true)
	protected String tribe;
	
	@XmlElement(name = "DateOfLastVisit", required = true)
	protected String dateOfLastVisit;
	
	@XmlElement(name = "AdmissionDuringReviewPeriod", required = true)
	protected String admissionDuringReviewPeriod;
	
	@XmlElement(name = "RNL_SerialNo", required = true)
	protected String rnlSerialNo;
	
	@XmlElement(name = "CareGiverOccupation", required = true)
	protected String careGiverOccupation;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "RecordCompletionPosition", required = true)
	protected String recordCompletionPosition;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploadDt", required = true)
	protected String uploadDt;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
	@XmlElement(name = "ReviewPeriod", required = true)
	protected String reviewPeriod;
	
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
	 * Gets the value of the lastname property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the value of the lastname property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLastname(String value) {
		this.lastname = value;
	}
	
	/**
	 * Gets the value of the firstname property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the value of the firstname property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFirstname(String value) {
		this.firstname = value;
	}
	
	/**
	 * Gets the value of the hospitalNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}
	
	/**
	 * Sets the value of the hospitalNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHospitalNo(String value) {
		this.hospitalNo = value;
	}
	
	/**
	 * Gets the value of the gender property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the value of the gender property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setGender(String value) {
		this.gender = value;
	}
	
	/**
	 * Gets the value of the dateOfBirth property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets the value of the dateOfBirth property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfBirth(String value) {
		this.dateOfBirth = value;
	}
	
	/**
	 * Gets the value of the age property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAge() {
		return age;
	}
	
	/**
	 * Sets the value of the age property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAge(String value) {
		this.age = value;
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
	 * Gets the value of the dateEnrolledInCare property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateEnrolledInCare() {
		return dateEnrolledInCare;
	}
	
	/**
	 * Sets the value of the dateEnrolledInCare property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateEnrolledInCare(String value) {
		this.dateEnrolledInCare = value;
	}
	
	/**
	 * Gets the value of the clinicalVisit6MonthsPriorToReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClinicalVisit6MonthsPriorToReviewPeriod() {
		return clinicalVisit6MonthsPriorToReviewPeriod;
	}
	
	/**
	 * Sets the value of the clinicalVisit6MonthsPriorToReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClinicalVisit6MonthsPriorToReviewPeriod(String value) {
		this.clinicalVisit6MonthsPriorToReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the deliveryLocation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	
	/**
	 * Sets the value of the deliveryLocation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDeliveryLocation(String value) {
		this.deliveryLocation = value;
	}
	
	/**
	 * Gets the value of the primaryCareGiver property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrimaryCareGiver() {
		return primaryCareGiver;
	}
	
	/**
	 * Sets the value of the primaryCareGiver property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrimaryCareGiver(String value) {
		this.primaryCareGiver = value;
	}
	
	/**
	 * Gets the value of the stateOfResidence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStateOfResidence() {
		return stateOfResidence;
	}
	
	/**
	 * Sets the value of the stateOfResidence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStateOfResidence(String value) {
		this.stateOfResidence = value;
	}
	
	/**
	 * Gets the value of the lgaOfResidence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLGAOfResidence() {
		return lgaOfResidence;
	}
	
	/**
	 * Sets the value of the lgaOfResidence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLGAOfResidence(String value) {
		this.lgaOfResidence = value;
	}
	
	/**
	 * Gets the value of the stateOfOrigin property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStateOfOrigin() {
		return stateOfOrigin;
	}
	
	/**
	 * Sets the value of the stateOfOrigin property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStateOfOrigin(String value) {
		this.stateOfOrigin = value;
	}
	
	/**
	 * Gets the value of the tribe property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTribe() {
		return tribe;
	}
	
	/**
	 * Sets the value of the tribe property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTribe(String value) {
		this.tribe = value;
	}
	
	/**
	 * Gets the value of the dateOfLastVisit property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfLastVisit() {
		return dateOfLastVisit;
	}
	
	/**
	 * Sets the value of the dateOfLastVisit property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfLastVisit(String value) {
		this.dateOfLastVisit = value;
	}
	
	/**
	 * Gets the value of the admissionDuringReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAdmissionDuringReviewPeriod() {
		return admissionDuringReviewPeriod;
	}
	
	/**
	 * Sets the value of the admissionDuringReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAdmissionDuringReviewPeriod(String value) {
		this.admissionDuringReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the rnlSerialNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRNLSerialNo() {
		return rnlSerialNo;
	}
	
	/**
	 * Sets the value of the rnlSerialNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRNLSerialNo(String value) {
		this.rnlSerialNo = value;
	}
	
	/**
	 * Gets the value of the careGiverOccupation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCareGiverOccupation() {
		return careGiverOccupation;
	}
	
	/**
	 * Sets the value of the careGiverOccupation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCareGiverOccupation(String value) {
		this.careGiverOccupation = value;
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
	 * Gets the value of the recordCompletionPosition property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRecordCompletionPosition() {
		return recordCompletionPosition;
	}
	
	/**
	 * Sets the value of the recordCompletionPosition property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRecordCompletionPosition(String value) {
		this.recordCompletionPosition = value;
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
	 * Gets the value of the reviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReviewPeriod() {
		return reviewPeriod;
	}
	
	/**
	 * Sets the value of the reviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReviewPeriod(String value) {
		this.reviewPeriod = value;
	}
	
}
