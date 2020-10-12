package org.openmrs.module.nigeriaemr.model.nigeriaqual.missedappointmentsandpatienttracking;

import javax.xml.bind.annotation.*;

/**
 * <p>
 * Java class for data-setType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="data-setType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MissedAppointmentsAndPatientTracking_Record" type="{}MissedAppointmentsAndPatientTracking_RecordType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "missedAppointmentsAndPatientTrackingRecord" })
@XmlRootElement(name = "data-set")
public class MissedAppointmentsAndPatientTrackingRecordDataSetType {
	
	@XmlElement(name = "MissedAppointmentsAndPatientTracking_Record", required = true)
	protected MissedAppointmentsAndPatientTrackingRecordType missedAppointmentsAndPatientTrackingRecord;
	
	/**
	 * Gets the value of the missedAppointmentsAndPatientTrackingRecord property.
	 * 
	 * @return possible object is {@link MissedAppointmentsAndPatientTrackingRecordType }
	 */
	public MissedAppointmentsAndPatientTrackingRecordType getMissedAppointmentsAndPatientTrackingRecord() {
		return missedAppointmentsAndPatientTrackingRecord;
	}
	
	/**
	 * Sets the value of the missedAppointmentsAndPatientTrackingRecord property.
	 * 
	 * @param value allowed object is {@link MissedAppointmentsAndPatientTrackingRecordType }
	 */
	public void setMissedAppointmentsAndPatientTrackingRecord(MissedAppointmentsAndPatientTrackingRecordType value) {
		this.missedAppointmentsAndPatientTrackingRecord = value;
	}
	
}
