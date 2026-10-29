package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InfantARVProphylaxisType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="InfantARVProphylaxisType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NVP"/>
 *     &lt;enumeration value="ZDV"/>
 *     &lt;enumeration value="NVP_and_ZDV"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "InfantARVProphylaxisType")
@XmlEnum
public enum InfantARVProphylaxisType {
	
	NVP("NVP"), ZDV("ZDV"), @XmlEnumValue("NVP_and_ZDV")
	NVP_AND_ZDV("NVP_and_ZDV"), @XmlEnumValue("None")
	NONE("None"), @XmlEnumValue("Other")
	OTHER("Other");
	
	private final String value;
	
	InfantARVProphylaxisType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static InfantARVProphylaxisType fromValue(String v) {
		for (InfantARVProphylaxisType c : InfantARVProphylaxisType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
