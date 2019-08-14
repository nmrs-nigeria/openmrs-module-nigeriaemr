package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatrictuberculosis;

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
 *         &lt;element name="Pediatric_Tuberculosis_Record" type="{}Pediatric_Tuberculosis_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricTuberculosisRecord" })
@XmlRootElement(name = "data-set")
public class PediatricTuberculosisRecordDataSetType {
	
	@XmlElement(name = "Pediatric_Tuberculosis_Record")
	protected List<PediatricTuberculosisRecordType> pediatricTuberculosisRecord;
	
	/**
	 * Gets the value of the pediatricTuberculosisRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricTuberculosisRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricTuberculosisRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricTuberculosisRecordType }
	 */
	public List<PediatricTuberculosisRecordType> getPediatricTuberculosisRecord() {
		if (pediatricTuberculosisRecord == null) {
			pediatricTuberculosisRecord = new ArrayList<PediatricTuberculosisRecordType>();
		}
		return this.pediatricTuberculosisRecord;
	}
	
}
