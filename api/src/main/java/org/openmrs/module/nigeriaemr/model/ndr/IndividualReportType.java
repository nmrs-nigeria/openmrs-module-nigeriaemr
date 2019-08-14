package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for IndividualReportType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientDemographics" type="{}PatientDemographicsType"/>
 *         &lt;element name="Condition" type="{}ConditionType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualReportType", propOrder = { "patientDemographics", "condition" })
public class IndividualReportType {
	
	@XmlElement(name = "PatientDemographics", required = true)
	protected PatientDemographicsType patientDemographics;
	
	@XmlElement(name = "Condition", required = true)
	protected List<ConditionType> condition;
	
	/**
	 * Gets the value of the patientDemographics property.
	 * 
	 * @return possible object is {@link PatientDemographicsType }
	 */
	public PatientDemographicsType getPatientDemographics() {
		return patientDemographics;
	}
	
	/**
	 * Sets the value of the patientDemographics property.
	 * 
	 * @param value allowed object is {@link PatientDemographicsType }
	 */
	public void setPatientDemographics(PatientDemographicsType value) {
		this.patientDemographics = value;
	}
	
	/**
	 * Gets the value of the condition property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the condition property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getCondition().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ConditionType }
	 */
	public List<ConditionType> getCondition() {
		if (condition == null) {
			condition = new ArrayList<ConditionType>();
		}
		return this.condition;
	}
	
}
