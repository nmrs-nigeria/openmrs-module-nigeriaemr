package org.openmrs.module.nigeriaemr.model.nigeriaqual.viralloadtesting;

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
 *         &lt;element name="ViralLoadTesting_Record" type="{}ViralLoadTesting_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "viralLoadTestingRecord" })
@XmlRootElement(name = "data-set")
public class ViralLoadTestingRecordDataSetType {
	
	@XmlElement(name = "ViralLoadTesting_Record")
	protected List<ViralLoadTestingRecordType> viralLoadTestingRecord;
	
	/**
	 * Gets the value of the viralLoadTestingRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the viralLoadTestingRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getViralLoadTestingRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ViralLoadTestingRecordType }
	 */
	public List<ViralLoadTestingRecordType> getViralLoadTestingRecord() {
		if (viralLoadTestingRecord == null) {
			viralLoadTestingRecord = new ArrayList<ViralLoadTestingRecordType>();
		}
		return this.viralLoadTestingRecord;
	}
	
}
