package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InfantARVProphylaxisTimingType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="InfantARVProphylaxisTimingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="InFacilityWithin72Hrs"/>
 *     &lt;enumeration value="InFacilityAfter72Hrs"/>
 *     &lt;enumeration value="DeliveredOutsideFacilityWithin72Hrs"/>
 *     &lt;enumeration value="DeliveredFacilityAfter72Hrs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "InfantARVProphylaxisTimingType")
@XmlEnum
public enum InfantARVProphylaxisTimingType {
	
	@XmlEnumValue("InFacilityWithin72Hrs")
	IN_FACILITY_WITHIN_72_HRS("InFacilityWithin72Hrs"), @XmlEnumValue("InFacilityAfter72Hrs")
	IN_FACILITY_AFTER_72_HRS("InFacilityAfter72Hrs"), @XmlEnumValue("DeliveredOutsideFacilityWithin72Hrs")
	DELIVERED_OUTSIDE_FACILITY_WITHIN_72_HRS("DeliveredOutsideFacilityWithin72Hrs"), @XmlEnumValue("DeliveredFacilityAfter72Hrs")
	DELIVERED_FACILITY_AFTER_72_HRS("DeliveredFacilityAfter72Hrs");
	
	private final String value;
	
	InfantARVProphylaxisTimingType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static InfantARVProphylaxisTimingType fromValue(String v) {
		for (InfantARVProphylaxisTimingType c : InfantARVProphylaxisTimingType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
