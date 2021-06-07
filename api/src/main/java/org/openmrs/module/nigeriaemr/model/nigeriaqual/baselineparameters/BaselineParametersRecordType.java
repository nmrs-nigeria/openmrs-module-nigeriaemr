package org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for BaselineParameters_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaselineParameters_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CD4_Count" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CD4_Count_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Weight_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WHO_Clinical_Stage">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WHO_Clinical_State_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploaderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webUploadFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaselineParameters_RecordType", propOrder = { "cd4Count", "cd4CountDate", "weight", "weightDate",
        "whoClinicalStage", "whoClinicalStateDate", "patientID", "facilityID", "uploaderId", "uploadDT", "webUploadFlag",
        "reviewPeriod" })
public class BaselineParametersRecordType {
	
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
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploadDT", required = true)
	protected String uploadDT;
	
	@XmlElement(required = true)
	protected String webUploadFlag;
	
	@XmlElement(name = "ReviewPeriod", required = true)
	protected String reviewPeriod;
	
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
	 * Gets the value of the uploadDT property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUploadDT() {
		return uploadDT;
	}
	
	/**
	 * Sets the value of the uploadDT property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUploadDT(String value) {
		this.uploadDT = value;
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
