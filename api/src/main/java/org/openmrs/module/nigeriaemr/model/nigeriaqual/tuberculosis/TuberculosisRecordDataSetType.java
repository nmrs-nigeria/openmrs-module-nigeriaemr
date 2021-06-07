package org.openmrs.module.nigeriaemr.model.nigeriaqual.tuberculosis;

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
 *         &lt;element name="Tuberculosis_Record" type="{}Tuberculosis_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "tuberculosisRecord" })
@XmlRootElement(name = "data-set")
public class TuberculosisRecordDataSetType {
	
	@XmlElement(name = "Tuberculosis_Record")
	protected List<TuberculosisRecordType> tuberculosisRecord;
	
	/**
	 * Gets the value of the tuberculosisRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the tuberculosisRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getTuberculosisRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TuberculosisRecordType }
	 */
	public List<TuberculosisRecordType> getTuberculosisRecord() {
		if (tuberculosisRecord == null) {
			tuberculosisRecord = new ArrayList<TuberculosisRecordType>();
		}
		return this.tuberculosisRecord;
	}
	
}
