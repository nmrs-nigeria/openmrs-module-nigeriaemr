package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for KnownHIVPositiveStatusType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="KnownHIVPositiveStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OnART"/>
 *     &lt;enumeration value="NotOnART"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "KnownHIVPositiveStatusType")
@XmlEnum
public enum KnownHIVPositiveStatusType {
	
	@XmlEnumValue("OnART")
	ON_ART("OnART"), @XmlEnumValue("NotOnART")
	NOT_ON_ART("NotOnART");
	
	private final String value;
	
	KnownHIVPositiveStatusType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static KnownHIVPositiveStatusType fromValue(String v) {
		for (KnownHIVPositiveStatusType c : KnownHIVPositiveStatusType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
