package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod;

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
 *         &lt;element name="Pediatric_Cotrimoxazole_Record" type="{}Pediatric_Cotrimoxazole_RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Data-setType", propOrder = { "pediatricCotrimoxazoleRecord" })
@XmlRootElement(name = "data-set")
public class PediatricCotrimoxazoleRecordDataSetType {
	
	@XmlElement(name = "Pediatric_Cotrimoxazole_Record")
	protected List<PediatricCotrimoxazoleRecordType> pediatricCotrimoxazoleRecord;
	
	/**
	 * Gets the value of the pediatricCotrimoxazoleRecord property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pediatricCotrimoxazoleRecord property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPediatricCotrimoxazoleRecord().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PediatricCotrimoxazoleRecordType }
	 */
	public List<PediatricCotrimoxazoleRecordType> getPediatricCotrimoxazoleRecord() {
		if (pediatricCotrimoxazoleRecord == null) {
			pediatricCotrimoxazoleRecord = new ArrayList<PediatricCotrimoxazoleRecordType>();
		}
		return this.pediatricCotrimoxazoleRecord;
	}
	
}
