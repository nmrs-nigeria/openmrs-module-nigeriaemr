package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters;

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
 *         &lt;element name="Pediatric_BaselineParameters_Record" type="{}Pediatric_BaselineParameters_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricBaselineParametersRecord" })
@XmlRootElement(name = "data-set")
public class PediatricBaselineParametersRecordDataSetType {
	
	@XmlElement(name = "Pediatric_BaselineParameters_Record")
	protected List<PediatricBaselineParametersRecordType> pediatricBaselineParametersRecord;
	
	/**
	 * Gets the value of the pediatricBaselineParametersRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricBaselineParametersRecord
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricBaselineParametersRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricBaselineParametersRecordType }
	 */
	public List<PediatricBaselineParametersRecordType> getPediatricBaselineParametersRecord() {
		if (pediatricBaselineParametersRecord == null) {
			pediatricBaselineParametersRecord = new ArrayList<PediatricBaselineParametersRecordType>();
		}
		return this.pediatricBaselineParametersRecord;
	}
	
}
