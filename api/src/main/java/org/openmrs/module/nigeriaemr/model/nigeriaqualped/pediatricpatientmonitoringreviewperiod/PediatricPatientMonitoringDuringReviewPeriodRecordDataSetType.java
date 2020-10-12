package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * <p>
 * Java class for Data-setType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Data-setType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pediatric_PatientMonitoringDuringReviewPeriod_Record" type="{}Pediatric_PatientMonitoringDuringReviewPeriod_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricPatientMonitoringDuringReviewPeriodRecord" })
@XmlRootElement(name = "data-set")
public class PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType {
	
	@XmlElement(name = "Pediatric_PatientMonitoringDuringReviewPeriod_Record")
	protected List<PediatricPatientMonitoringDuringReviewPeriodRecordType> pediatricPatientMonitoringDuringReviewPeriodRecord;
	
	/**
	 * Gets the value of the pediatricPatientMonitoringDuringReviewPeriodRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the
	 * pediatricPatientMonitoringDuringReviewPeriodRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricPatientMonitoringDuringReviewPeriodRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricPatientMonitoringDuringReviewPeriodRecordType }
	 */
	public List<PediatricPatientMonitoringDuringReviewPeriodRecordType> getPediatricPatientMonitoringDuringReviewPeriodRecord() {
		if (pediatricPatientMonitoringDuringReviewPeriodRecord == null) {
			pediatricPatientMonitoringDuringReviewPeriodRecord = new ArrayList<PediatricPatientMonitoringDuringReviewPeriodRecordType>();
		}
		return this.pediatricPatientMonitoringDuringReviewPeriodRecord;
	}
	
}
