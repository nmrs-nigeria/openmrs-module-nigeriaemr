package org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PatientStatusDuringReviewPeriod_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientStatusDuringReviewPeriod_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Start new treatment"/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="Continue current tre"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfStatusChange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReasonForStatusChange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Transferred_Out">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Death" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Discontinued_Care">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Transferred_Out_Date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="24/08/2016"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Death_Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Discontinued_Care_Date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="24/08/2016"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Discontinued_Care_Reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Discontinued_Care_Reason_Other" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientStatusDuringReviewPeriod_RecordType", propOrder = { "patientID", "status", "dateOfStatusChange",
        "reasonForStatusChange", "facilityID", "transferredOut", "death", "discontinuedCare", "transferredOutDate",
        "deathDate", "discontinuedCareDate", "discontinuedCareReason", "discontinuedCareReasonOther" })
public class PatientStatusDuringReviewPeriodRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "Status", required = true)
	protected String status;
	
	@XmlElement(name = "DateOfStatusChange", required = true)
	protected String dateOfStatusChange;
	
	@XmlElement(name = "ReasonForStatusChange", required = true)
	protected String reasonForStatusChange;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	@XmlElement(name = "Transferred_Out", required = true)
	protected String transferredOut;
	
	@XmlElement(name = "Death", required = true)
	protected String death;
	
	@XmlElement(name = "Discontinued_Care", required = true)
	protected String discontinuedCare;
	
	@XmlElement(name = "Transferred_Out_Date", required = true)
	protected String transferredOutDate;
	
	@XmlElement(name = "Death_Date", required = true)
	protected String deathDate;
	
	@XmlElement(name = "Discontinued_Care_Date", required = true)
	protected String discontinuedCareDate;
	
	@XmlElement(name = "Discontinued_Care_Reason", required = true)
	protected String discontinuedCareReason;
	
	@XmlElement(name = "Discontinued_Care_Reason_Other", required = true)
	protected String discontinuedCareReasonOther;
	
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
	 * Gets the value of the status property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the value of the status property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStatus(String value) {
		this.status = value;
	}
	
	/**
	 * Gets the value of the dateOfStatusChange property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfStatusChange() {
		return dateOfStatusChange;
	}
	
	/**
	 * Sets the value of the dateOfStatusChange property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfStatusChange(String value) {
		this.dateOfStatusChange = value;
	}
	
	/**
	 * Gets the value of the reasonForStatusChange property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForStatusChange() {
		return reasonForStatusChange;
	}
	
	/**
	 * Sets the value of the reasonForStatusChange property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForStatusChange(String value) {
		this.reasonForStatusChange = value;
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
	 * Gets the value of the transferredOut property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredOut() {
		return transferredOut;
	}
	
	/**
	 * Sets the value of the transferredOut property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredOut(String value) {
		this.transferredOut = value;
	}
	
	/**
	 * Gets the value of the death property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDeath() {
		return death;
	}
	
	/**
	 * Sets the value of the death property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDeath(String value) {
		this.death = value;
	}
	
	/**
	 * Gets the value of the discontinuedCare property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDiscontinuedCare() {
		return discontinuedCare;
	}
	
	/**
	 * Sets the value of the discontinuedCare property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDiscontinuedCare(String value) {
		this.discontinuedCare = value;
	}
	
	/**
	 * Gets the value of the transferredOutDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredOutDate() {
		return transferredOutDate;
	}
	
	/**
	 * Sets the value of the transferredOutDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredOutDate(String value) {
		this.transferredOutDate = value;
	}
	
	/**
	 * Gets the value of the deathDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDeathDate() {
		return deathDate;
	}
	
	/**
	 * Sets the value of the deathDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDeathDate(String value) {
		this.deathDate = value;
	}
	
	/**
	 * Gets the value of the discontinuedCareDate property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDiscontinuedCareDate() {
		return discontinuedCareDate;
	}
	
	/**
	 * Sets the value of the discontinuedCareDate property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDiscontinuedCareDate(String value) {
		this.discontinuedCareDate = value;
	}
	
	/**
	 * Gets the value of the discontinuedCareReason property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDiscontinuedCareReason() {
		return discontinuedCareReason;
	}
	
	/**
	 * Sets the value of the discontinuedCareReason property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDiscontinuedCareReason(String value) {
		this.discontinuedCareReason = value;
	}
	
	/**
	 * Gets the value of the discontinuedCareReasonOther property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDiscontinuedCareReasonOther() {
		return discontinuedCareReasonOther;
	}
	
	/**
	 * Sets the value of the discontinuedCareReasonOther property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDiscontinuedCareReasonOther(String value) {
		this.discontinuedCareReasonOther = value;
	}
	
}
