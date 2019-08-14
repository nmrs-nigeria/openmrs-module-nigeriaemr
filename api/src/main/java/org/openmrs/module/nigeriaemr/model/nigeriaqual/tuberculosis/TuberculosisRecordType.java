package org.openmrs.module.nigeriaemr.model.nigeriaqual.tuberculosis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Tuberculosis_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tuberculosis_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientOnTBTreatmentAtStartOfReviewPeriod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientClinicallyScreenForTBDuringReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TBClinicalScreeningCriteria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BasedOnScreeningWasPatientedSuspectedToHaveTB">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientHaveCRXPerformedDuringReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientReferredToDOTsClinic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientDiagnosedOfTBInReviewPeriod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TBDiagnosis_Date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="18/11/2016"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientStartTBTreatment">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="12/08/2016"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TB_TreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriodID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TBScreeningCriteria_CurrentCough" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TBScreeningCriteria_ContactHistoryWithTBCase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TBScreeningCriteria_PoorWeightGain" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Tuberculosis_RecordType", propOrder = { "patientID", "patientOnTBTreatmentAtStartOfReviewPeriod",
        "patientClinicallyScreenForTBDuringReviewPeriod", "tbClinicalScreeningCriteria",
        "basedOnScreeningWasPatientedSuspectedToHaveTB", "patientHaveCRXPerformedDuringReviewPeriod",
        "patientReferredToDOTsClinic", "patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture",
        "patientDiagnosedOfTBInReviewPeriod", "tbDiagnosisDate", "patientStartTBTreatment", "tbTreatmentStartDate",
        "facilityID", "reviewPeriodID", "tbScreeningCriteriaCurrentCough", "tbScreeningCriteriaContactHistoryWithTBCase",
        "tbScreeningCriteriaPoorWeightGain", "uploaderId", "uploadDt", "webUploadFlag" })
public class TuberculosisRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientOnTBTreatmentAtStartOfReviewPeriod", required = true)
	protected String patientOnTBTreatmentAtStartOfReviewPeriod;
	
	@XmlElement(name = "PatientClinicallyScreenForTBDuringReviewPeriod", required = true)
	protected String patientClinicallyScreenForTBDuringReviewPeriod;
	
	@XmlElement(name = "TBClinicalScreeningCriteria", required = true)
	protected String tbClinicalScreeningCriteria;
	
	@XmlElement(name = "BasedOnScreeningWasPatientedSuspectedToHaveTB", required = true)
	protected String basedOnScreeningWasPatientedSuspectedToHaveTB;
	
	@XmlElement(name = "PatientHaveCRXPerformedDuringReviewPeriod", required = true)
	protected String patientHaveCRXPerformedDuringReviewPeriod;
	
	@XmlElement(name = "PatientReferredToDOTsClinic", required = true)
	protected String patientReferredToDOTsClinic;
	
	@XmlElement(name = "PatientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture", required = true)
	protected String patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture;
	
	@XmlElement(name = "PatientDiagnosedOfTBInReviewPeriod", required = true)
	protected String patientDiagnosedOfTBInReviewPeriod;
	
	@XmlElement(name = "TBDiagnosis_Date", required = true)
	protected String tbDiagnosisDate;
	
	@XmlElement(name = "PatientStartTBTreatment", required = true)
	protected String patientStartTBTreatment;
	
	@XmlElement(name = "TB_TreatmentStartDate", required = true)
	protected String tbTreatmentStartDate;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "ReviewPeriodID", required = true)
	protected String reviewPeriodID;
	
	@XmlElement(name = "TBScreeningCriteria_CurrentCough", required = true)
	protected String tbScreeningCriteriaCurrentCough;
	
	@XmlElement(name = "TBScreeningCriteria_ContactHistoryWithTBCase", required = true)
	protected String tbScreeningCriteriaContactHistoryWithTBCase;
	
	@XmlElement(name = "TBScreeningCriteria_PoorWeightGain", required = true)
	protected String tbScreeningCriteriaPoorWeightGain;
	
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
	 * Gets the value of the patientOnTBTreatmentAtStartOfReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientOnTBTreatmentAtStartOfReviewPeriod() {
		return patientOnTBTreatmentAtStartOfReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientOnTBTreatmentAtStartOfReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientOnTBTreatmentAtStartOfReviewPeriod(String value) {
		this.patientOnTBTreatmentAtStartOfReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the patientClinicallyScreenForTBDuringReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientClinicallyScreenForTBDuringReviewPeriod() {
		return patientClinicallyScreenForTBDuringReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientClinicallyScreenForTBDuringReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientClinicallyScreenForTBDuringReviewPeriod(String value) {
		this.patientClinicallyScreenForTBDuringReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the tbClinicalScreeningCriteria property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBClinicalScreeningCriteria() {
		return tbClinicalScreeningCriteria;
	}
	
	/**
	 * Sets the value of the tbClinicalScreeningCriteria property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBClinicalScreeningCriteria(String value) {
		this.tbClinicalScreeningCriteria = value;
	}
	
	/**
	 * Gets the value of the basedOnScreeningWasPatientedSuspectedToHaveTB property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBasedOnScreeningWasPatientedSuspectedToHaveTB() {
		return basedOnScreeningWasPatientedSuspectedToHaveTB;
	}
	
	/**
	 * Sets the value of the basedOnScreeningWasPatientedSuspectedToHaveTB property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBasedOnScreeningWasPatientedSuspectedToHaveTB(String value) {
		this.basedOnScreeningWasPatientedSuspectedToHaveTB = value;
	}
	
	/**
	 * Gets the value of the patientHaveCRXPerformedDuringReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientHaveCRXPerformedDuringReviewPeriod() {
		return patientHaveCRXPerformedDuringReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientHaveCRXPerformedDuringReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientHaveCRXPerformedDuringReviewPeriod(String value) {
		this.patientHaveCRXPerformedDuringReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the patientReferredToDOTsClinic property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientReferredToDOTsClinic() {
		return patientReferredToDOTsClinic;
	}
	
	/**
	 * Sets the value of the patientReferredToDOTsClinic property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientReferredToDOTsClinic(String value) {
		this.patientReferredToDOTsClinic = value;
	}
	
	/**
	 * Gets the value of the patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture
	 * property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture() {
		return patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture;
	}
	
	/**
	 * Sets the value of the patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture
	 * property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture(String value) {
		this.patientBeenEvaluatedInReviewPeriodForTBUsingSputumSmearOrCulture = value;
	}
	
	/**
	 * Gets the value of the patientDiagnosedOfTBInReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientDiagnosedOfTBInReviewPeriod() {
		return patientDiagnosedOfTBInReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientDiagnosedOfTBInReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientDiagnosedOfTBInReviewPeriod(String value) {
		this.patientDiagnosedOfTBInReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the tbDiagnosisDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBDiagnosisDate() {
		return tbDiagnosisDate;
	}
	
	/**
	 * Sets the value of the tbDiagnosisDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBDiagnosisDate(String value) {
		this.tbDiagnosisDate = value;
	}
	
	/**
	 * Gets the value of the patientStartTBTreatment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientStartTBTreatment() {
		return patientStartTBTreatment;
	}
	
	/**
	 * Sets the value of the patientStartTBTreatment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientStartTBTreatment(String value) {
		this.patientStartTBTreatment = value;
	}
	
	/**
	 * Gets the value of the tbTreatmentStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBTreatmentStartDate() {
		return tbTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the tbTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBTreatmentStartDate(String value) {
		this.tbTreatmentStartDate = value;
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
	 * Gets the value of the tbScreeningCriteriaCurrentCough property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBScreeningCriteriaCurrentCough() {
		return tbScreeningCriteriaCurrentCough;
	}
	
	/**
	 * Sets the value of the tbScreeningCriteriaCurrentCough property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBScreeningCriteriaCurrentCough(String value) {
		this.tbScreeningCriteriaCurrentCough = value;
	}
	
	/**
	 * Gets the value of the tbScreeningCriteriaContactHistoryWithTBCase property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBScreeningCriteriaContactHistoryWithTBCase() {
		return tbScreeningCriteriaContactHistoryWithTBCase;
	}
	
	/**
	 * Sets the value of the tbScreeningCriteriaContactHistoryWithTBCase property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBScreeningCriteriaContactHistoryWithTBCase(String value) {
		this.tbScreeningCriteriaContactHistoryWithTBCase = value;
	}
	
	/**
	 * Gets the value of the tbScreeningCriteriaPoorWeightGain property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTBScreeningCriteriaPoorWeightGain() {
		return tbScreeningCriteriaPoorWeightGain;
	}
	
	/**
	 * Sets the value of the tbScreeningCriteriaPoorWeightGain property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTBScreeningCriteriaPoorWeightGain(String value) {
		this.tbScreeningCriteriaPoorWeightGain = value;
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
