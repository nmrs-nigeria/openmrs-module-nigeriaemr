package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Pediatric_ARTRegimenSinceStartingTreatment_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pediatric_ARTRegimenSinceStartingTreatment_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PatientOnARTAnytimeDuringReviewPeriod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="C1stRegminen">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="-1"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="C1stRegimenStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C1stRegimenChangeDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C2ndRegimen">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="-1"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="C2ndRegimenStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C2ndRegimenChangeDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C3rdRegimen">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="C3rdRegimenStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C3rdRegimenChangeDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OtherRegimenSpecify" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Pediatric_ARTRegimenSinceStartingTreatment_RecordType", propOrder = { "patientID",
        "patientOnARTAnytimeDuringReviewPeriod", "c1StRegminen", "c1StRegimenStartDate", "c1StRegimenChangeDate",
        "c2NdRegimen", "c2NdRegimenStartDate", "c2NdRegimenChangeDate", "c3RdRegimen", "c3RdRegimenStartDate",
        "c3RdRegimenChangeDate", "otherRegimenSpecify", "facilityID", "uploaderId", "uploadDt", "webUploadFlag",
        "reviewPeriodID" })
public class PediatricARTRegimenSinceStartingTreatmentRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "PatientOnARTAnytimeDuringReviewPeriod", required = true)
	protected String patientOnARTAnytimeDuringReviewPeriod;
	
	@XmlElement(name = "C1stRegminen", required = true)
	protected String c1StRegminen;
	
	@XmlElement(name = "C1stRegimenStartDate", required = true)
	protected String c1StRegimenStartDate;
	
	@XmlElement(name = "C1stRegimenChangeDate", required = true)
	protected String c1StRegimenChangeDate;
	
	@XmlElement(name = "C2ndRegimen", required = true)
	protected String c2NdRegimen;
	
	@XmlElement(name = "C2ndRegimenStartDate", required = true)
	protected String c2NdRegimenStartDate;
	
	@XmlElement(name = "C2ndRegimenChangeDate", required = true)
	protected String c2NdRegimenChangeDate;
	
	@XmlElement(name = "C3rdRegimen", required = true)
	protected String c3RdRegimen;
	
	@XmlElement(name = "C3rdRegimenStartDate", required = true)
	protected String c3RdRegimenStartDate;
	
	@XmlElement(name = "C3rdRegimenChangeDate", required = true)
	protected String c3RdRegimenChangeDate;
	
	@XmlElement(name = "OtherRegimenSpecify", required = true)
	protected String otherRegimenSpecify;
	
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
	 * Gets the value of the c1StRegminen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC1StRegminen() {
		return c1StRegminen;
	}
	
	/**
	 * Sets the value of the c1StRegminen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC1StRegminen(String value) {
		this.c1StRegminen = value;
	}
	
	/**
	 * Gets the value of the c1StRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC1StRegimenStartDate() {
		return c1StRegimenStartDate;
	}
	
	/**
	 * Sets the value of the c1StRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC1StRegimenStartDate(String value) {
		this.c1StRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the c1StRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC1StRegimenChangeDate() {
		return c1StRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the c1StRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC1StRegimenChangeDate(String value) {
		this.c1StRegimenChangeDate = value;
	}
	
	/**
	 * Gets the value of the c2NdRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC2NdRegimen() {
		return c2NdRegimen;
	}
	
	/**
	 * Sets the value of the c2NdRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC2NdRegimen(String value) {
		this.c2NdRegimen = value;
	}
	
	/**
	 * Gets the value of the c2NdRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC2NdRegimenStartDate() {
		return c2NdRegimenStartDate;
	}
	
	/**
	 * Sets the value of the c2NdRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC2NdRegimenStartDate(String value) {
		this.c2NdRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the c2NdRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC2NdRegimenChangeDate() {
		return c2NdRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the c2NdRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC2NdRegimenChangeDate(String value) {
		this.c2NdRegimenChangeDate = value;
	}
	
	/**
	 * Gets the value of the c3RdRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC3RdRegimen() {
		return c3RdRegimen;
	}
	
	/**
	 * Sets the value of the c3RdRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC3RdRegimen(String value) {
		this.c3RdRegimen = value;
	}
	
	/**
	 * Gets the value of the c3RdRegimenStartDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC3RdRegimenStartDate() {
		return c3RdRegimenStartDate;
	}
	
	/**
	 * Sets the value of the c3RdRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC3RdRegimenStartDate(String value) {
		this.c3RdRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the c3RdRegimenChangeDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getC3RdRegimenChangeDate() {
		return c3RdRegimenChangeDate;
	}
	
	/**
	 * Sets the value of the c3RdRegimenChangeDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setC3RdRegimenChangeDate(String value) {
		this.c3RdRegimenChangeDate = value;
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
