package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PCRAgeAtTestType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="PCRAgeAtTestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AtBirth_LTE72Hrs"/>
 *     &lt;enumeration value="GT72Hrs_LT2Months"/>
 *     &lt;enumeration value="TwoTo12Months"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PCRAgeAtTestType")
@XmlEnum
public enum PCRAgeAtTestType {
	
	@XmlEnumValue("AtBirth_LTE72Hrs")
	AT_BIRTH_LTE_72_HRS("AtBirth_LTE72Hrs"), @XmlEnumValue("GT72Hrs_LT2Months")
	GT_72_HRS_LT_2_MONTHS("GT72Hrs_LT2Months"), @XmlEnumValue("TwoTo12Months")
	TWO_TO_12_MONTHS("TwoTo12Months");
	
	private final String value;
	
	PCRAgeAtTestType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static PCRAgeAtTestType fromValue(String v) {
		for (PCRAgeAtTestType c : PCRAgeAtTestType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
