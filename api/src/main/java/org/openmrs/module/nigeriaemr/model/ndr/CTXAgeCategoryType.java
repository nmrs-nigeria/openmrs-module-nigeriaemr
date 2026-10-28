package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CTXAgeCategoryType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="CTXAgeCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LT2Months"/>
 *     &lt;enumeration value="GTe2Months"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CTXAgeCategoryType")
@XmlEnum
public enum CTXAgeCategoryType {
	
	@XmlEnumValue("LT2Months")
	LT_2_MONTHS("LT2Months"), @XmlEnumValue("GTe2Months")
	G_TE_2_MONTHS("GTe2Months");
	
	private final String value;
	
	CTXAgeCategoryType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static CTXAgeCategoryType fromValue(String v) {
		for (CTXAgeCategoryType c : CTXAgeCategoryType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
