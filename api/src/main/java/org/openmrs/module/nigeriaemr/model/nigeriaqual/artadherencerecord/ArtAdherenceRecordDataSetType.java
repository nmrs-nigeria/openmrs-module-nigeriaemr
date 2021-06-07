package org.openmrs.module.nigeriaemr.model.nigeriaqual.artadherencerecord;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="ART_Adherence_Record" type="{}ART_Adherence_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "artAdherenceRecord" })
@XmlRootElement(name = "data-set")
public class ArtAdherenceRecordDataSetType {
	
	@XmlElement(name = "ART_Adherence_Record")
	protected List<ARTAdherenceRecordType> artAdherenceRecord;
	
	/**
	 * Gets the value of the artadherencerecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the artadherencerecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getARTAdherenceRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ARTAdherenceRecordType }
	 */
	public List<ARTAdherenceRecordType> getARTAdherenceRecord() {
		if (artAdherenceRecord == null) {
			artAdherenceRecord = new ArrayList<ARTAdherenceRecordType>();
		}
		return this.artAdherenceRecord;
	}
	
}
