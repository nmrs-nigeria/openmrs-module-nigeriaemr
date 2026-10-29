package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PCRRapidTestResultType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="PCRRapidTestResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Positive"/>
 *     &lt;enumeration value="Negative"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PCRRapidTestResultType")
@XmlEnum
public enum PCRRapidTestResultType {
	
	@XmlEnumValue("Positive")
	POSITIVE("Positive"), @XmlEnumValue("Negative")
	NEGATIVE("Negative");
	
	private final String value;
	
	PCRRapidTestResultType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static PCRRapidTestResultType fromValue(String v) {
		for (PCRRapidTestResultType c : PCRRapidTestResultType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
