package org.openmrs.module.nigeriaemr.model.nigeriaqual.patientdemographics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PatientDemographics_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientDemographics_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClinicalVisit3MonthsPriorToReview" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaritalStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Married"/>
 *               &lt;enumeration value="Single"/>
 *               &lt;enumeration value="Widowed"/>
 *               &lt;enumeration value="Separated"/>
 *               &lt;enumeration value="Divorced"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HosiptalNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RNL_SerialNO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Gender">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Female"/>
 *               &lt;enumeration value="male"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateofBirth" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HospitalAdmissionDuringReview" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Occupation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Employed"/>
 *               &lt;enumeration value="Unemployed"/>
 *               &lt;enumeration value="Student"/>
 *               &lt;enumeration value="Retired"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Education">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Primary"/>
 *               &lt;enumeration value="Senior Secondary"/>
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Post Secondary"/>
 *               &lt;enumeration value="Junior Secondary"/>
 *               &lt;enumeration value="Quranic"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WardVillageTown_OfResidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LGA_OfResidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="State_OfResidence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="State_OfOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tribe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateEnrolled" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecordCompletionPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientDemographics_RecordType", propOrder = { "lastname", "firstname",
        "clinicalVisit3MonthsPriorToReview", "maritalStatus", "hosiptalNo", "rnlSerialNO", "gender", "dateofBirth", "age",
        "hospitalAdmissionDuringReview", "occupation", "education", "wardVillageTownOfResidence", "lgaOfResidence",
        "stateOfResidence", "stateOfOrigin", "tribe", "facilityID", "patientID", "dateEnrolled", "recordCompletionPosition",
        "uploaderId", "uploaderDT", "webUploadFlag", "reviewPeriod" })
public class PatientDemographicsRecordType {
	
	@XmlElement(name = "Lastname", required = true)
	protected String lastname;
	
	@XmlElement(name = "Firstname", required = true)
	protected String firstname;
	
	@XmlElement(name = "ClinicalVisit3MonthsPriorToReview", required = true)
	protected String clinicalVisit3MonthsPriorToReview;
	
	@XmlElement(name = "MaritalStatus", required = true)
	protected String maritalStatus;
	
	@XmlElement(name = "HosiptalNo", required = true)
	protected String hosiptalNo;
	
	@XmlElement(name = "RNL_SerialNO", required = true)
	protected String rnlSerialNO;
	
	@XmlElement(name = "Gender", required = true)
	protected String gender;
	
	@XmlElement(name = "DateofBirth", required = true)
	protected String dateofBirth;
	
	@XmlElement(name = "AGE", required = true)
	protected String age;
	
	@XmlElement(name = "HospitalAdmissionDuringReview", required = true)
	protected String hospitalAdmissionDuringReview;
	
	@XmlElement(name = "Occupation", required = true)
	protected String occupation;
	
	@XmlElement(name = "Education", required = true)
	protected String education;
	
	@XmlElement(name = "WardVillageTown_OfResidence", required = true)
	protected String wardVillageTownOfResidence;
	
	@XmlElement(name = "LGA_OfResidence", required = true)
	protected String lgaOfResidence;
	
	@XmlElement(name = "State_OfResidence", required = true)
	protected String stateOfResidence;
	
	@XmlElement(name = "State_OfOrigin", required = true)
	protected String stateOfOrigin;
	
	@XmlElement(name = "Tribe", required = true)
	protected String tribe;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "DateEnrolled", required = true)
	protected String dateEnrolled;
	
	@XmlElement(name = "RecordCompletionPosition", required = true)
	protected String recordCompletionPosition;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploaderDT", required = true)
	protected String uploaderDT;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
	@XmlElement(name = "ReviewPeriod", required = true)
	protected String reviewPeriod;
	
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
	 * Gets the value of the clinicalVisit6MonthsPriorToReview property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClinicalVisit6MonthsPriorToReview() {
		return clinicalVisit3MonthsPriorToReview;
	}
	
	/**
	 * Sets the value of the clinicalVisit6MonthsPriorToReview property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClinicalVisit3MonthsPriorToReview(String value) {
		this.clinicalVisit3MonthsPriorToReview = value;
	}
	
	/**
	 * Gets the value of the maritalStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	/**
	 * Sets the value of the maritalStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMaritalStatus(String value) {
		this.maritalStatus = value;
	}
	
	/**
	 * Gets the value of the hosiptalNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHosiptalNo() {
		return hosiptalNo;
	}
	
	/**
	 * Sets the value of the hosiptalNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHosiptalNo(String value) {
		this.hosiptalNo = value;
	}
	
	/**
	 * Gets the value of the rnlSerialNO property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRNLSerialNO() {
		return rnlSerialNO;
	}
	
	/**
	 * Sets the value of the rnlSerialNO property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRNLSerialNO(String value) {
		this.rnlSerialNO = value;
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
	 * Gets the value of the dateofBirth property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateofBirth() {
		return dateofBirth;
	}
	
	/**
	 * Sets the value of the dateofBirth property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateofBirth(String value) {
		this.dateofBirth = value;
	}
	
	/**
	 * Gets the value of the age property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAGE() {
		return age;
	}
	
	/**
	 * Sets the value of the age property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAGE(String value) {
		this.age = value;
	}
	
	/**
	 * Gets the value of the hospitalAdmissionDuringReview property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHospitalAdmissionDuringReview() {
		return hospitalAdmissionDuringReview;
	}
	
	/**
	 * Sets the value of the hospitalAdmissionDuringReview property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHospitalAdmissionDuringReview(String value) {
		this.hospitalAdmissionDuringReview = value;
	}
	
	/**
	 * Gets the value of the occupation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOccupation() {
		return occupation;
	}
	
	/**
	 * Sets the value of the occupation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOccupation(String value) {
		this.occupation = value;
	}
	
	/**
	 * Gets the value of the education property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEducation() {
		return education;
	}
	
	/**
	 * Sets the value of the education property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEducation(String value) {
		this.education = value;
	}
	
	/**
	 * Gets the value of the wardVillageTownOfResidence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWardVillageTownOfResidence() {
		return wardVillageTownOfResidence;
	}
	
	/**
	 * Sets the value of the wardVillageTownOfResidence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWardVillageTownOfResidence(String value) {
		this.wardVillageTownOfResidence = value;
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
	 * Gets the value of the dateEnrolled property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateEnrolled() {
		return dateEnrolled;
	}
	
	/**
	 * Sets the value of the dateEnrolled property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateEnrolled(String value) {
		this.dateEnrolled = value;
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
	 * Gets the value of the uploaderDT property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUploaderDT() {
		return uploaderDT;
	}
	
	/**
	 * Sets the value of the uploaderDT property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUploaderDT(String value) {
		this.uploaderDT = value;
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
