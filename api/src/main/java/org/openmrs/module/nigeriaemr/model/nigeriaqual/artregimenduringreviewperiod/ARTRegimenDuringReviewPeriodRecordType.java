package org.openmrs.module.nigeriaemr.model.nigeriaqual.artregimenduringreviewperiod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ARTRegimenDuringReviewPeriod_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ARTRegimenDuringReviewPeriod_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientOnARTFirstDayOFReviewPeriod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientOnARTAnytimeDuringReviewPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_1ST_Regimen">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="_1st_Regimen_StartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_1st_Regimen_Change_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_2nd_Regimen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_2nd_Regimen_Start_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_2nd_Regimen_Change_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_3rd_Regimen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_3rd_Regimen_Start_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_3rd_Regimen_Change_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OtherRegimenSpecify" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateofLastDrugPickup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DurationOfMedicationCoverageInMonths">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ARTRegimenDuringReviewPeriod_RecordType", propOrder = { "patientID", "patientOnARTFirstDayOFReviewPeriod",
        "patientOnARTAnytimeDuringReviewPeriod", "_1STRegimen", "_1StRegimenStartDate", "_1StRegimenChangeDate",
        "_2NdRegimen", "_2NdRegimenStartDate", "_2NdRegimenChangeDate", "_3RdRegimen", "_3RdRegimenStartDate",
        "_3RdRegimenChangeDate", "otherRegimenSpecify", "dateofLastDrugPickup", "durationOfMedicationCoverageInMonths",
        "facilityID", "uploaderId", "uploaderDT", "webUploadFlag", "reviewPeriod" })
public class ARTRegimenDuringReviewPeriodRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientOnARTFirstDayOFReviewPeriod", required = true)
	protected String patientOnARTFirstDayOFReviewPeriod;
	
	@XmlElement(name = "PatientOnARTAnytimeDuringReviewPeriod", required = true)
	protected String patientOnARTAnytimeDuringReviewPeriod;
	
	@XmlElement(name = "_1ST_Regimen", required = true)
	protected String _1STRegimen;
	
	@XmlElement(name = "_1st_Regimen_StartDate", required = true)
	protected String _1StRegimenStartDate;
	
	@XmlElement(name = "_1st_Regimen_Change_Date", required = true)
	protected String _1StRegimenChangeDate;
	
	@XmlElement(name = "_2nd_Regimen", required = true)
	protected String _2NdRegimen;
	
	@XmlElement(name = "_2nd_Regimen_Start_Date", required = true)
	protected String _2NdRegimenStartDate;
	
	@XmlElement(name = "_2nd_Regimen_Change_Date", required = true)
	protected String _2NdRegimenChangeDate;
	
	@XmlElement(name = "_3rd_Regimen", required = true)
	protected String _3RdRegimen;
	
	@XmlElement(name = "_3rd_Regimen_Start_Date", required = true)
	protected String _3RdRegimenStartDate;
	
	@XmlElement(name = "_3rd_Regimen_Change_Date", required = true)
	protected String _3RdRegimenChangeDate;
	
	@XmlElement(name = "OtherRegimenSpecify", required = true)
	protected String otherRegimenSpecify;
	
	@XmlElement(name = "DateofLastDrugPickup", required = true)
	protected String dateofLastDrugPickup;
	
	@XmlElement(name = "DurationOfMedicationCoverageInMonths", required = true)
	protected String durationOfMedicationCoverageInMonths;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "UploaderId", required = true)
	protected String uploaderId;
	
	@XmlElement(name = "UploaderDT", required = true)
	protected String uploaderDT;
	
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
	 * Gets the value of the patientOnARTFirstDayOFReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientOnARTFirstDayOFReviewPeriod() {
		return patientOnARTFirstDayOFReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientOnARTFirstDayOFReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientOnARTFirstDayOFReviewPeriod(String value) {
		this.patientOnARTFirstDayOFReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the patientOnARTAnytimeDuringReviewPeriod property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientOnARTAnytimeDuringReviewPeriod() {
		return patientOnARTAnytimeDuringReviewPeriod;
	}
	
	/**
	 * Sets the value of the patientOnARTAnytimeDuringReviewPeriod property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientOnARTAnytimeDuringReviewPeriod(String value) {
		this.patientOnARTAnytimeDuringReviewPeriod = value;
	}
	
	/**
	 * Gets the value of the 1STRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get1STRegimen() {
		return _1STRegimen;
	}
	
	/**
	 * Sets the value of the 1STRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set1STRegimen(String value) {
		this._1STRegimen = value;
	}
	
	/**
	 * Gets the value of the 1StRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get1StRegimenStartDate() {
		return _1StRegimenStartDate;
	}
	
	/**
	 * Sets the value of the 1StRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set1StRegimenStartDate(String value) {
		this._1StRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the 1StRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get1StRegimenChangeDate() {
		return _1StRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the 1StRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set1StRegimenChangeDate(String value) {
		this._1StRegimenChangeDate = value;
	}
	
	/**
	 * Gets the value of the 2NdRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get2NdRegimen() {
		return _2NdRegimen;
	}
	
	/**
	 * Sets the value of the 2NdRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set2NdRegimen(String value) {
		this._2NdRegimen = value;
	}
	
	/**
	 * Gets the value of the 2NdRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get2NdRegimenStartDate() {
		return _2NdRegimenStartDate;
	}
	
	/**
	 * Sets the value of the 2NdRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set2NdRegimenStartDate(String value) {
		this._2NdRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the 2NdRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get2NdRegimenChangeDate() {
		return _2NdRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the 2NdRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set2NdRegimenChangeDate(String value) {
		this._2NdRegimenChangeDate = value;
	}
	
	/**
	 * Gets the value of the 3RdRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get3RdRegimen() {
		return _3RdRegimen;
	}
	
	/**
	 * Sets the value of the 3RdRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set3RdRegimen(String value) {
		this._3RdRegimen = value;
	}
	
	/**
	 * Gets the value of the 3RdRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get3RdRegimenStartDate() {
		return _3RdRegimenStartDate;
	}
	
	/**
	 * Sets the value of the 3RdRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set3RdRegimenStartDate(String value) {
		this._3RdRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the 3RdRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String get3RdRegimenChangeDate() {
		return _3RdRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the 3RdRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void set3RdRegimenChangeDate(String value) {
		this._3RdRegimenChangeDate = value;
	}
	
	/**
	 * Gets the value of the otherRegimenSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherRegimenSpecify() {
		return otherRegimenSpecify;
	}
	
	/**
	 * Sets the value of the otherRegimenSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherRegimenSpecify(String value) {
		this.otherRegimenSpecify = value;
	}
	
	/**
	 * Gets the value of the dateofLastDrugPickup property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateofLastDrugPickup() {
		return dateofLastDrugPickup;
	}
	
	/**
	 * Sets the value of the dateofLastDrugPickup property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateofLastDrugPickup(String value) {
		this.dateofLastDrugPickup = value;
	}
	
	/**
	 * Gets the value of the durationOfMedicationCoverageInMonths property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDurationOfMedicationCoverageInMonths() {
		return durationOfMedicationCoverageInMonths;
	}
	
	/**
	 * Sets the value of the durationOfMedicationCoverageInMonths property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDurationOfMedicationCoverageInMonths(String value) {
		this.durationOfMedicationCoverageInMonths = value;
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
