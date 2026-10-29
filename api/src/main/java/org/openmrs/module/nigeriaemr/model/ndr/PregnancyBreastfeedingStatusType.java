package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PregnancyBreastfeedingStatusType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="PregnancyBreastfeedingStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="BF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PregnancyBreastfeedingStatusType")
@XmlEnum
public enum PregnancyBreastfeedingStatusType {
	
	P, BF;
	
	public String value() {
		return name();
	}
	
	public static PregnancyBreastfeedingStatusType fromValue(String v) {
		return valueOf(v);
	}
	
}
