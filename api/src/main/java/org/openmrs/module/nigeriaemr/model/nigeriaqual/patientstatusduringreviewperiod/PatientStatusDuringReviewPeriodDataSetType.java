package org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="PatientStatusDuringReviewPeriod_Record" type="{}PatientStatusDuringReviewPeriod_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "patientStatusDuringReviewPeriodRecord" })
@XmlRootElement(name = "data-set")
public class PatientStatusDuringReviewPeriodDataSetType {
	
	@XmlElement(name = "PatientStatusDuringReviewPeriod_Record")
	protected List<PatientStatusDuringReviewPeriodRecordType> patientStatusDuringReviewPeriodRecord;
	
	/**
	 * Gets the value of the patientStatusDuringReviewPeriodRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the patientStatusDuringReviewPeriodRecord
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPatientStatusDuringReviewPeriodRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PatientStatusDuringReviewPeriodRecordType }
	 */
	public List<PatientStatusDuringReviewPeriodRecordType> getPatientStatusDuringReviewPeriodRecord() {
		if (patientStatusDuringReviewPeriodRecord == null) {
			patientStatusDuringReviewPeriodRecord = new ArrayList<PatientStatusDuringReviewPeriodRecordType>();
		}
		return this.patientStatusDuringReviewPeriodRecord;
	}
	
}
