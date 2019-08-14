package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriclinkage;

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
 *         &lt;element name="Pediatric_Linkage_Record" type="{}Pediatric_Linkage_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricLinkageRecord" })
@XmlRootElement(name = "data-set")
public class PediatricLinkageRecordDataSetType {
	
	@XmlElement(name = "Pediatric_Linkage_Record")
	protected List<PediatricLinkageRecordType> pediatricLinkageRecord;
	
	/**
	 * Gets the value of the pediatricLinkageRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricLinkageRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricLinkageRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PediatricLinkageRecordType }
	 */
	public List<PediatricLinkageRecordType> getPediatricLinkageRecord() {
		if (pediatricLinkageRecord == null) {
			pediatricLinkageRecord = new ArrayList<PediatricLinkageRecordType>();
		}
		return this.pediatricLinkageRecord;
	}
	
}
