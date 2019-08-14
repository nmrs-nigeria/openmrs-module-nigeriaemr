package org.openmrs.module.nigeriaemr.model.nigeriaqual.missedappointmentsandpatienttracking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MissedAppointmentsAndPatientTracking_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MissedAppointmentsAndPatientTracking_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MissedAppointment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AttemptedContact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfAttemptedContact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OutcomeOfTracking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReasonFor_LTFU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CauseOfDeath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_AttemptedContact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_AttemptedContactDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_OutcomeOfTracking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_ReasonForLFTU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_1_CauseOfDeath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_AttemptedContact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_AttemptedContactDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_OutcomeOfTracking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_ReasonForLFTU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_2_CauseOfDeath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_AttemptedContact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_AttemptedContactDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_OutcomeOfTracking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_ReasonForLFTU" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Missed_appointment_3_CauseOfDeath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriodID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MissedAppointmentsAndPatientTracking_RecordType", propOrder = { "patientID", "missedAppointment",
        "attemptedContact", "dateOfAttemptedContact", "outcomeOfTracking", "reasonForLTFU", "causeOfDeath", "facilityID",
        "missedAppointment1", "missedAppointment1Date", "missedAppointment1AttemptedContact",
        "missedAppointment1AttemptedContactDate", "missedAppointment1OutcomeOfTracking", "missedAppointment1ReasonForLFTU",
        "missedAppointment1CauseOfDeath", "missedAppointment2", "missedAppointment2Date",
        "missedAppointment2AttemptedContact", "missedAppointment2AttemptedContactDate",
        "missedAppointment2OutcomeOfTracking", "missedAppointment2ReasonForLFTU", "missedAppointment2CauseOfDeath",
        "missedAppointment3", "missedAppointment3Date", "missedAppointment3AttemptedContact",
        "missedAppointment3AttemptedContactDate", "missedAppointment3OutcomeOfTracking", "missedAppointment3ReasonForLFTU",
        "missedAppointment3CauseOfDeath", "reviewPeriodID", "uploaderId", "uploadDt", "webUploadFlag" })
public class MissedAppointmentsAndPatientTrackingRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "MissedAppointment", required = true)
	protected String missedAppointment;
	
	@XmlElement(name = "AttemptedContact", required = true)
	protected String attemptedContact;
	
	@XmlElement(name = "DateOfAttemptedContact", required = true)
	protected String dateOfAttemptedContact;
	
	@XmlElement(name = "OutcomeOfTracking", required = true)
	protected String outcomeOfTracking;
	
	@XmlElement(name = "ReasonFor_LTFU", required = true)
	protected String reasonForLTFU;
	
	@XmlElement(name = "CauseOfDeath", required = true)
	protected String causeOfDeath;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "Missed_appointment_1", required = true)
	protected String missedAppointment1;
	
	@XmlElement(name = "Missed_appointment_1_Date", required = true)
	protected String missedAppointment1Date;
	
	@XmlElement(name = "Missed_appointment_1_AttemptedContact", required = true)
	protected String missedAppointment1AttemptedContact;
	
	@XmlElement(name = "Missed_appointment_1_AttemptedContactDate", required = true)
	protected String missedAppointment1AttemptedContactDate;
	
	@XmlElement(name = "Missed_appointment_1_OutcomeOfTracking", required = true)
	protected String missedAppointment1OutcomeOfTracking;
	
	@XmlElement(name = "Missed_appointment_1_ReasonForLFTU", required = true)
	protected String missedAppointment1ReasonForLFTU;
	
	@XmlElement(name = "Missed_appointment_1_CauseOfDeath", required = true)
	protected String missedAppointment1CauseOfDeath;
	
	@XmlElement(name = "Missed_appointment_2", required = true)
	protected String missedAppointment2;
	
	@XmlElement(name = "Missed_appointment_2_Date", required = true)
	protected String missedAppointment2Date;
	
	@XmlElement(name = "Missed_appointment_2_AttemptedContact", required = true)
	protected String missedAppointment2AttemptedContact;
	
	@XmlElement(name = "Missed_appointment_2_AttemptedContactDate", required = true)
	protected String missedAppointment2AttemptedContactDate;
	
	@XmlElement(name = "Missed_appointment_2_OutcomeOfTracking", required = true)
	protected String missedAppointment2OutcomeOfTracking;
	
	@XmlElement(name = "Missed_appointment_2_ReasonForLFTU", required = true)
	protected String missedAppointment2ReasonForLFTU;
	
	@XmlElement(name = "Missed_appointment_2_CauseOfDeath", required = true)
	protected String missedAppointment2CauseOfDeath;
	
	@XmlElement(name = "Missed_appointment_3", required = true)
	protected String missedAppointment3;
	
	@XmlElement(name = "Missed_appointment_3_Date", required = true)
	protected String missedAppointment3Date;
	
	@XmlElement(name = "Missed_appointment_3_AttemptedContact", required = true)
	protected String missedAppointment3AttemptedContact;
	
	@XmlElement(name = "Missed_appointment_3_AttemptedContactDate", required = true)
	protected String missedAppointment3AttemptedContactDate;
	
	@XmlElement(name = "Missed_appointment_3_OutcomeOfTracking", required = true)
	protected String missedAppointment3OutcomeOfTracking;
	
	@XmlElement(name = "Missed_appointment_3_ReasonForLFTU", required = true)
	protected String missedAppointment3ReasonForLFTU;
	
	@XmlElement(name = "Missed_appointment_3_CauseOfDeath", required = true)
	protected String missedAppointment3CauseOfDeath;
	
	@XmlElement(name = "ReviewPeriodID", required = true)
	protected String reviewPeriodID;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploadDt", required = true)
	protected String uploadDt;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
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
	 * Gets the value of the missedAppointment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment() {
		return missedAppointment;
	}
	
	/**
	 * Sets the value of the missedAppointment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment(String value) {
		this.missedAppointment = value;
	}
	
	/**
	 * Gets the value of the attemptedContact property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAttemptedContact() {
		return attemptedContact;
	}
	
	/**
	 * Sets the value of the attemptedContact property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAttemptedContact(String value) {
		this.attemptedContact = value;
	}
	
	/**
	 * Gets the value of the dateOfAttemptedContact property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfAttemptedContact() {
		return dateOfAttemptedContact;
	}
	
	/**
	 * Sets the value of the dateOfAttemptedContact property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfAttemptedContact(String value) {
		this.dateOfAttemptedContact = value;
	}
	
	/**
	 * Gets the value of the outcomeOfTracking property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOutcomeOfTracking() {
		return outcomeOfTracking;
	}
	
	/**
	 * Sets the value of the outcomeOfTracking property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOutcomeOfTracking(String value) {
		this.outcomeOfTracking = value;
	}
	
	/**
	 * Gets the value of the reasonForLTFU property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForLTFU() {
		return reasonForLTFU;
	}
	
	/**
	 * Sets the value of the reasonForLTFU property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForLTFU(String value) {
		this.reasonForLTFU = value;
	}
	
	/**
	 * Gets the value of the causeOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	
	/**
	 * Sets the value of the causeOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeath(String value) {
		this.causeOfDeath = value;
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
	 * Gets the value of the missedAppointment1 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1() {
		return missedAppointment1;
	}
	
	/**
	 * Sets the value of the missedAppointment1 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1(String value) {
		this.missedAppointment1 = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1Date property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1Date() {
		return missedAppointment1Date;
	}
	
	/**
	 * Sets the value of the missedAppointment1Date property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1Date(String value) {
		this.missedAppointment1Date = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1AttemptedContact property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1AttemptedContact() {
		return missedAppointment1AttemptedContact;
	}
	
	/**
	 * Sets the value of the missedAppointment1AttemptedContact property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1AttemptedContact(String value) {
		this.missedAppointment1AttemptedContact = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1AttemptedContactDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1AttemptedContactDate() {
		return missedAppointment1AttemptedContactDate;
	}
	
	/**
	 * Sets the value of the missedAppointment1AttemptedContactDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1AttemptedContactDate(String value) {
		this.missedAppointment1AttemptedContactDate = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1OutcomeOfTracking property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1OutcomeOfTracking() {
		return missedAppointment1OutcomeOfTracking;
	}
	
	/**
	 * Sets the value of the missedAppointment1OutcomeOfTracking property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1OutcomeOfTracking(String value) {
		this.missedAppointment1OutcomeOfTracking = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1ReasonForLFTU property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1ReasonForLFTU() {
		return missedAppointment1ReasonForLFTU;
	}
	
	/**
	 * Sets the value of the missedAppointment1ReasonForLFTU property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1ReasonForLFTU(String value) {
		this.missedAppointment1ReasonForLFTU = value;
	}
	
	/**
	 * Gets the value of the missedAppointment1CauseOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment1CauseOfDeath() {
		return missedAppointment1CauseOfDeath;
	}
	
	/**
	 * Sets the value of the missedAppointment1CauseOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment1CauseOfDeath(String value) {
		this.missedAppointment1CauseOfDeath = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2() {
		return missedAppointment2;
	}
	
	/**
	 * Sets the value of the missedAppointment2 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2(String value) {
		this.missedAppointment2 = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2Date property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2Date() {
		return missedAppointment2Date;
	}
	
	/**
	 * Sets the value of the missedAppointment2Date property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2Date(String value) {
		this.missedAppointment2Date = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2AttemptedContact property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2AttemptedContact() {
		return missedAppointment2AttemptedContact;
	}
	
	/**
	 * Sets the value of the missedAppointment2AttemptedContact property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2AttemptedContact(String value) {
		this.missedAppointment2AttemptedContact = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2AttemptedContactDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2AttemptedContactDate() {
		return missedAppointment2AttemptedContactDate;
	}
	
	/**
	 * Sets the value of the missedAppointment2AttemptedContactDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2AttemptedContactDate(String value) {
		this.missedAppointment2AttemptedContactDate = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2OutcomeOfTracking property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2OutcomeOfTracking() {
		return missedAppointment2OutcomeOfTracking;
	}
	
	/**
	 * Sets the value of the missedAppointment2OutcomeOfTracking property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2OutcomeOfTracking(String value) {
		this.missedAppointment2OutcomeOfTracking = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2ReasonForLFTU property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2ReasonForLFTU() {
		return missedAppointment2ReasonForLFTU;
	}
	
	/**
	 * Sets the value of the missedAppointment2ReasonForLFTU property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2ReasonForLFTU(String value) {
		this.missedAppointment2ReasonForLFTU = value;
	}
	
	/**
	 * Gets the value of the missedAppointment2CauseOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment2CauseOfDeath() {
		return missedAppointment2CauseOfDeath;
	}
	
	/**
	 * Sets the value of the missedAppointment2CauseOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment2CauseOfDeath(String value) {
		this.missedAppointment2CauseOfDeath = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3 property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3() {
		return missedAppointment3;
	}
	
	/**
	 * Sets the value of the missedAppointment3 property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3(String value) {
		this.missedAppointment3 = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3Date property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3Date() {
		return missedAppointment3Date;
	}
	
	/**
	 * Sets the value of the missedAppointment3Date property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3Date(String value) {
		this.missedAppointment3Date = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3AttemptedContact property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3AttemptedContact() {
		return missedAppointment3AttemptedContact;
	}
	
	/**
	 * Sets the value of the missedAppointment3AttemptedContact property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3AttemptedContact(String value) {
		this.missedAppointment3AttemptedContact = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3AttemptedContactDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3AttemptedContactDate() {
		return missedAppointment3AttemptedContactDate;
	}
	
	/**
	 * Sets the value of the missedAppointment3AttemptedContactDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3AttemptedContactDate(String value) {
		this.missedAppointment3AttemptedContactDate = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3OutcomeOfTracking property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3OutcomeOfTracking() {
		return missedAppointment3OutcomeOfTracking;
	}
	
	/**
	 * Sets the value of the missedAppointment3OutcomeOfTracking property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3OutcomeOfTracking(String value) {
		this.missedAppointment3OutcomeOfTracking = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3ReasonForLFTU property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3ReasonForLFTU() {
		return missedAppointment3ReasonForLFTU;
	}
	
	/**
	 * Sets the value of the missedAppointment3ReasonForLFTU property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3ReasonForLFTU(String value) {
		this.missedAppointment3ReasonForLFTU = value;
	}
	
	/**
	 * Gets the value of the missedAppointment3CauseOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMissedAppointment3CauseOfDeath() {
		return missedAppointment3CauseOfDeath;
	}
	
	/**
	 * Sets the value of the missedAppointment3CauseOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMissedAppointment3CauseOfDeath(String value) {
		this.missedAppointment3CauseOfDeath = value;
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
	
}
