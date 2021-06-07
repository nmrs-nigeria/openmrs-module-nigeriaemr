package org.openmrs.module.nigeriaemr.model.nigeriaqual.hepatitisb;

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
 *         &lt;element name="HepatitisB_Record" type="{}HepatitisB_RecordType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data-setType", propOrder = { "hepatitisBRecord" })
@XmlRootElement(name = "data-set")
public class HepatitisBRecordDataSetType {
	
	@XmlElement(name = "HepatitisB_Record", required = true)
	protected HepatitisBRecordType hepatitisBRecord;
	
	/**
	 * Gets the value of the hepatitisBRecord property.
	 * 
	 * @return possible object is {@link HepatitisBRecordType }
	 */
	public HepatitisBRecordType getHepatitisBRecord() {
		return hepatitisBRecord;
	}
	
	/**
	 * Sets the value of the hepatitisBRecord property.
	 * 
	 * @param value allowed object is {@link HepatitisBRecordType }
	 */
	public void setHepatitisBRecord(HepatitisBRecordType value) {
		this.hepatitisBRecord = value;
	}
	
}
