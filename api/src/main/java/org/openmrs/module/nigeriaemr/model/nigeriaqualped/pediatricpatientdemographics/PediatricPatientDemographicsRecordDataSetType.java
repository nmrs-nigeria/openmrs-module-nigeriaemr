package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientdemographics;

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
 *         &lt;element name="Pediatric_PatientDemographics_Record" type="{}Pediatric_PatientDemographics_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricPatientDemographicsRecord" })
@XmlRootElement(name = "data-set")
public class PediatricPatientDemographicsRecordDataSetType {
	
	@XmlElement(name = "Pediatric_PatientDemographics_Record")
	protected List<PediatricPatientDemographicsRecordType> pediatricPatientDemographicsRecord;
	
	/**
	 * Gets the value of the pediatricPatientDemographicsRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricPatientDemographicsRecord
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricPatientDemographicsRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricPatientDemographicsRecordType }
	 */
	public List<PediatricPatientDemographicsRecordType> getPediatricPatientDemographicsRecord() {
		if (pediatricPatientDemographicsRecord == null) {
			pediatricPatientDemographicsRecord = new ArrayList<PediatricPatientDemographicsRecordType>();
		}
		return this.pediatricPatientDemographicsRecord;
	}
	
}
