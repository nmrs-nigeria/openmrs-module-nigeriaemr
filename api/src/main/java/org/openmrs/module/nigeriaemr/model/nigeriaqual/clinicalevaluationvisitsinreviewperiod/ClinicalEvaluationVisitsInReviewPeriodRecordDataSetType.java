package org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod;

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
 *         &lt;element name="ClinicalEvaluationVisitsInReviewPeriod_Record" type="{}ClinicalEvaluationVisitsInReviewPeriod_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "clinicalEvaluationVisitsInReviewPeriodRecord" })
@XmlRootElement(name = "data-set")
public class ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType {
	
	@XmlElement(name = "ClinicalEvaluationVisitsInReviewPeriod_Record")
	protected List<ClinicalEvaluationVisitsInReviewPeriodRecordType> clinicalEvaluationVisitsInReviewPeriodRecord;
	
	/**
	 * Gets the value of the clinicalEvaluationVisitsInReviewPeriodRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the
	 * clinicalEvaluationVisitsInReviewPeriodRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getClinicalEvaluationVisitsInReviewPeriodRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ClinicalEvaluationVisitsInReviewPeriodRecordType }
	 */
	public List<ClinicalEvaluationVisitsInReviewPeriodRecordType> getClinicalEvaluationVisitsInReviewPeriodRecord() {
		if (clinicalEvaluationVisitsInReviewPeriodRecord == null) {
			clinicalEvaluationVisitsInReviewPeriodRecord = new ArrayList<ClinicalEvaluationVisitsInReviewPeriodRecordType>();
		}
		return this.clinicalEvaluationVisitsInReviewPeriodRecord;
	}
	
}
