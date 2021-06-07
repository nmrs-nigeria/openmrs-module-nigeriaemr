package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartadherencerecord;

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
 *         &lt;element name="Pediatric_ART_Adherence_Record" type="{}Pediatric_ART_Adherence_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricARTAdherenceRecord" })
@XmlRootElement(name = "data-set")
public class PediatricARTAdherenceRecordDataSetType {
	
	@XmlElement(name = "Pediatric_ART_Adherence_Record")
	protected List<PediatricARTAdherenceRecordType> pediatricARTAdherenceRecord;
	
	/**
	 * Gets the value of the pediatricARTAdherenceRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricARTAdherenceRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricARTAdherenceRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricARTAdherenceRecordType }
	 */
	public List<PediatricARTAdherenceRecordType> getPediatricARTAdherenceRecord() {
		if (pediatricARTAdherenceRecord == null) {
			pediatricARTAdherenceRecord = new ArrayList<PediatricARTAdherenceRecordType>();
		}
		return this.pediatricARTAdherenceRecord;
	}
	
}
