package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_BaselineParameters_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_BaselineParameters_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CD4_Count" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CD4_Count_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WHO_Clinical_Stage">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WHO_Clinical_State_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CD4_Not_Recorded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight_Not_Recorded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WHO_Clinical_Stage_Not_Recorded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientEverStartedOnART" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ART_Start_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Pediatric_BaselineParameters_RecordType", propOrder = { "patientID", "cd4Count", "cd4CountDate", "weight",
        "weightDate", "whoClinicalStage", "whoClinicalStateDate", "cd4NotRecorded", "weightNotRecorded",
        "whoClinicalStageNotRecorded", "patientEverStartedOnART", "artStartDate", "uploaderId", "uploadDt", "webUploadFlag",
        "reviewPeriodID" })
public class PediatricBaselineParametersRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "CD4_Count", required = true)
	protected String cd4Count;
	
	@XmlElement(name = "CD4_Count_Date", required = true)
	protected String cd4CountDate;
	
	@XmlElement(name = "Weight", required = true)
	protected String weight;
	
	@XmlElement(name = "Weight_Date", required = true)
	protected String weightDate;
	
	@XmlElement(name = "WHO_Clinical_Stage", required = true)
	protected String whoClinicalStage;
	
	@XmlElement(name = "WHO_Clinical_State_Date", required = true)
	protected String whoClinicalStateDate;
	
	@XmlElement(name = "CD4_Not_Recorded", required = true)
	protected String cd4NotRecorded;
	
	@XmlElement(name = "Weight_Not_Recorded", required = true)
	protected String weightNotRecorded;
	
	@XmlElement(name = "WHO_Clinical_Stage_Not_Recorded", required = true)
	protected String whoClinicalStageNotRecorded;
	
	@XmlElement(name = "PatientEverStartedOnART", required = true)
	protected String patientEverStartedOnART;
	
	@XmlElement(name = "ART_Start_Date", required = true)
	protected String artStartDate;
	
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
	 * Gets the value of the cd4Count property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4Count() {
		return cd4Count;
	}
	
	/**
	 * Sets the value of the cd4Count property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4Count(String value) {
		this.cd4Count = value;
	}
	
	/**
	 * Gets the value of the cd4CountDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4CountDate() {
		return cd4CountDate;
	}
	
	/**
	 * Sets the value of the cd4CountDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4CountDate(String value) {
		this.cd4CountDate = value;
	}
	
	/**
	 * Gets the value of the weight property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWeight() {
		return weight;
	}
	
	/**
	 * Sets the value of the weight property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWeight(String value) {
		this.weight = value;
	}
	
	/**
	 * Gets the value of the weightDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWeightDate() {
		return weightDate;
	}
	
	/**
	 * Sets the value of the weightDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWeightDate(String value) {
		this.weightDate = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStage property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStage() {
		return whoClinicalStage;
	}
	
	/**
	 * Sets the value of the whoClinicalStage property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStage(String value) {
		this.whoClinicalStage = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStateDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStateDate() {
		return whoClinicalStateDate;
	}
	
	/**
	 * Sets the value of the whoClinicalStateDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStateDate(String value) {
		this.whoClinicalStateDate = value;
	}
	
	/**
	 * Gets the value of the cd4NotRecorded property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4NotRecorded() {
		return cd4NotRecorded;
	}
	
	/**
	 * Sets the value of the cd4NotRecorded property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4NotRecorded(String value) {
		this.cd4NotRecorded = value;
	}
	
	/**
	 * Gets the value of the weightNotRecorded property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWeightNotRecorded() {
		return weightNotRecorded;
	}
	
	/**
	 * Sets the value of the weightNotRecorded property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWeightNotRecorded(String value) {
		this.weightNotRecorded = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStageNotRecorded property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStageNotRecorded() {
		return whoClinicalStageNotRecorded;
	}
	
	/**
	 * Sets the value of the whoClinicalStageNotRecorded property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStageNotRecorded(String value) {
		this.whoClinicalStageNotRecorded = value;
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
