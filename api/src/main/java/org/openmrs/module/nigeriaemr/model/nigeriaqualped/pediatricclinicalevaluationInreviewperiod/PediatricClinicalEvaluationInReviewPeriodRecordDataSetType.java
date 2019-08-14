package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricclinicalevaluationInreviewperiod;

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
 *         &lt;element name="Pediatric_ClinicalEvaluationInReviewPeriod_Record" type="{}Pediatric_ClinicalEvaluationInReviewPeriod_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricClinicalEvaluationInReviewPeriodRecord" })
@XmlRootElement(name = "data-set")
public class PediatricClinicalEvaluationInReviewPeriodRecordDataSetType {
	
	@XmlElement(name = "Pediatric_ClinicalEvaluationInReviewPeriod_Record")
	protected List<PediatricClinicalEvaluationInReviewPeriodRecordType> pediatricClinicalEvaluationInReviewPeriodRecord;
	
	/**
	 * Gets the value of the pediatricClinicalEvaluationInReviewPeriodRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the
	 * pediatricClinicalEvaluationInReviewPeriodRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricClinicalEvaluationInReviewPeriodRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricClinicalEvaluationInReviewPeriodRecordType }
	 */
	public List<PediatricClinicalEvaluationInReviewPeriodRecordType> getPediatricClinicalEvaluationInReviewPeriodRecord() {
		if (pediatricClinicalEvaluationInReviewPeriodRecord == null) {
			pediatricClinicalEvaluationInReviewPeriodRecord = new ArrayList<PediatricClinicalEvaluationInReviewPeriodRecordType>();
		}
		return this.pediatricClinicalEvaluationInReviewPeriodRecord;
	}
	
}
