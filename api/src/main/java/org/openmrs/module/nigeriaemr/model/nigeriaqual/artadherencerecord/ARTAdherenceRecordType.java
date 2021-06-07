package org.openmrs.module.nigeriaemr.model.nigeriaqual.artadherencerecord;

import javax.xml.bind.annotation.*;

/**
 * <p>
 * Java class for ART_Adherence_RecordType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ART_Adherence_RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ARTAdherenceAssessmentPerformedDuringLast3Months">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="Yes"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LastDateOfAssessment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HighestCD4SinceARTinitiation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DateOfHighestCD4Test" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ART_Adherence_RecordType", propOrder = { "patientID", "artAdherenceAssessmentPerformedDuringLast3Months",
        "lastDateOfAssessment", "highestCD4SinceARTinitiation", "dateOfHighestCD4Test", "facilityID" })
public class ARTAdherenceRecordType {
	
	@XmlElement(name = "PatientID", required = true)
	protected String patientID;
	
	@XmlElement(name = "ARTAdherenceAssessmentPerformedDuringLast3Months", required = true)
	protected String artAdherenceAssessmentPerformedDuringLast3Months;
	
	@XmlElement(name = "LastDateOfAssessment", required = true)
	protected String lastDateOfAssessment;
	
	@XmlElement(name = "HighestCD4SinceARTinitiation", required = true)
	protected String highestCD4SinceARTinitiation;
	
	@XmlElement(name = "DateOfHighestCD4Test", required = true)
	protected String dateOfHighestCD4Test;
	
	@XmlElement(name = "FacilityID", required = true)
	protected String facilityID;
	
	/**
	 * Gets the value of the patientID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPatientID() {
		return patientID;
	}
	
	/**
	 * Sets the value of the patientID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPatientID(String value) {
		this.patientID = value;
	}
	
	/**
	 * Gets the value of the artAdherenceAssessmentPerformedDuringLast3Months property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARTAdherenceAssessmentPerformedDuringLast3Months() {
		return artAdherenceAssessmentPerformedDuringLast3Months;
	}
	
	/**
	 * Sets the value of the artAdherenceAssessmentPerformedDuringLast3Months property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARTAdherenceAssessmentPerformedDuringLast3Months(String value) {
		this.artAdherenceAssessmentPerformedDuringLast3Months = value;
	}
	
	/**
	 * Gets the value of the lastDateOfAssessment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLastDateOfAssessment() {
		return lastDateOfAssessment;
	}
	
	/**
	 * Sets the value of the lastDateOfAssessment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLastDateOfAssessment(String value) {
		this.lastDateOfAssessment = value;
	}
	
	/**
	 * Gets the value of the highestCD4SinceARTinitiation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHighestCD4SinceARTinitiation() {
		return highestCD4SinceARTinitiation;
	}
	
	/**
	 * Sets the value of the highestCD4SinceARTinitiation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHighestCD4SinceARTinitiation(String value) {
		this.highestCD4SinceARTinitiation = value;
	}
	
	/**
	 * Gets the value of the dateOfHighestCD4Test property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateOfHighestCD4Test() {
		return dateOfHighestCD4Test;
	}
	
	/**
	 * Sets the value of the dateOfHighestCD4Test property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateOfHighestCD4Test(String value) {
		this.dateOfHighestCD4Test = value;
	}
	
	/**
	 * Gets the value of the facilityID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityID() {
		return facilityID;
	}
	
	/**
	 * Sets the value of the facilityID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityID(String value) {
		this.facilityID = value;
	}
	
}
