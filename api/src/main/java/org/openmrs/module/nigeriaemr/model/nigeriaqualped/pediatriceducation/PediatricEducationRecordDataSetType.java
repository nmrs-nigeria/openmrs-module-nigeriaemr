package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation;

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
 *         &lt;element name="Pediatric_Education_Record" type="{}Pediatric_Education_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricEducationRecord" })
@XmlRootElement(name = "data-set")
public class PediatricEducationRecordDataSetType {
	
	@XmlElement(name = "Pediatric_Education_Record")
	protected List<PediatricEducationRecordType> pediatricEducationRecord;
	
	/**
	 * Gets the value of the pediatricEducationRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricEducationRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricEducationRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PediatricEducationRecordType }
	 */
	public List<PediatricEducationRecordType> getPediatricEducationRecord() {
		if (pediatricEducationRecord == null) {
			pediatricEducationRecord = new ArrayList<PediatricEducationRecordType>();
		}
		return this.pediatricEducationRecord;
	}
	
}
