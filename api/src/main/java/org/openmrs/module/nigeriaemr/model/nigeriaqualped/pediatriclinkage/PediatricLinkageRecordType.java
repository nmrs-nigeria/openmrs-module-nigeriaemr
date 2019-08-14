package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriclinkage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_Linkage_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_Linkage_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientReceivedNutritionalAssessmentInReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientQualifyForNutritionSupporot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DidPatientReceivedNutritionSupport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChildImmunizationStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServicesReceivedByPatient" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WaterguardReceived" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InsecticideTreatedNetsReceived" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NotIndicated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NoneReceived" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriodID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pediatric_Linkage_RecordType", propOrder = { "patientID",
        "patientReceivedNutritionalAssessmentInReviewPeriod", "patientQualifyForNutritionSupporot",
        "didPatientReceivedNutritionSupport", "childImmunizationStatus", "facilityID", "uploaderId", "uploadDt",
        "servicesReceivedByPatient", "webUploadFlag", "waterguardReceived", "insecticideTreatedNetsReceived",
        "notIndicated", "noneReceived", "reviewPeriodID" })
public class PediatricLinkageRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientReceivedNutritionalAssessmentInReviewPeriod", required = true)
	protected String patientReceivedNutritionalAssessmentInReviewPeriod;
	
	@XmlElement(name = "PatientQualifyForNutritionSupporot", required = true)
	protected String patientQualifyForNutritionSupporot;
	
	@XmlElement(name = "DidPatientReceivedNutritionSupport", required = true)
	protected String didPatientReceivedNutritionSupport;
	
	@XmlElement(name = "ChildImmunizationStatus", required = true)
	protected String childImmunizationStatus;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploadDt", required = true)
	protected String uploadDt;
	
	@XmlElement(name = "ServicesReceivedByPatient", required = true)
	protected String servicesReceivedByPatient;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
	@XmlElement(name = "WaterguardReceived", required = true)
	protected String waterguardReceived;
	
	@XmlElement(name = "InsecticideTreatedNetsReceived", required = true)
	protected String insecticideTreatedNetsReceived;
	
	@XmlElement(name = "NotIndicated", required = true)
	protected String notIndicated;
	
	@XmlElement(name = "NoneReceived", required = true)
	protected String noneReceived;
	
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
	 * Gets the value of the patientReceivedNutritionalAssessmentInReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientReceivedNutritionalAssessmentInReviewPeriod() {
		return patientReceivedNutritionalAssessmentInReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientReceivedNutritionalAssessmentInReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientReceivedNutritionalAssessmentInReviewPeriod(String value) {
		this.patientReceivedNutritionalAssessmentInReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the patientQualifyForNutritionSupporot property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientQualifyForNutritionSupporot() {
		return patientQualifyForNutritionSupporot;
	}
	
	/**
	 * Sets the value of the patientQualifyForNutritionSupporot property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientQualifyForNutritionSupporot(String value) {
		this.patientQualifyForNutritionSupporot = value;
	}
	
	/**
	 * Gets the value of the didPatientReceivedNutritionSupport property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDidPatientReceivedNutritionSupport() {
		return didPatientReceivedNutritionSupport;
	}
	
	/**
	 * Sets the value of the didPatientReceivedNutritionSupport property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDidPatientReceivedNutritionSupport(String value) {
		this.didPatientReceivedNutritionSupport = value;
	}
	
	/**
	 * Gets the value of the childImmunizationStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildImmunizationStatus() {
		return childImmunizationStatus;
	}
	
	/**
	 * Sets the value of the childImmunizationStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildImmunizationStatus(String value) {
		this.childImmunizationStatus = value;
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
	 * Gets the value of the servicesReceivedByPatient property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getServicesReceivedByPatient() {
		return servicesReceivedByPatient;
	}
	
	/**
	 * Sets the value of the servicesReceivedByPatient property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setServicesReceivedByPatient(String value) {
		this.servicesReceivedByPatient = value;
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
	 * Gets the value of the waterguardReceived property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWaterguardReceived() {
		return waterguardReceived;
	}
	
	/**
	 * Sets the value of the waterguardReceived property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWaterguardReceived(String value) {
		this.waterguardReceived = value;
	}
	
	/**
	 * Gets the value of the insecticideTreatedNetsReceived property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInsecticideTreatedNetsReceived() {
		return insecticideTreatedNetsReceived;
	}
	
	/**
	 * Sets the value of the insecticideTreatedNetsReceived property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInsecticideTreatedNetsReceived(String value) {
		this.insecticideTreatedNetsReceived = value;
	}
	
	/**
	 * Gets the value of the notIndicated property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNotIndicated() {
		return notIndicated;
	}
	
	/**
	 * Sets the value of the notIndicated property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNotIndicated(String value) {
		this.notIndicated = value;
	}
	
	/**
	 * Gets the value of the noneReceived property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNoneReceived() {
		return noneReceived;
	}
	
	/**
	 * Sets the value of the noneReceived property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNoneReceived(String value) {
		this.noneReceived = value;
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
