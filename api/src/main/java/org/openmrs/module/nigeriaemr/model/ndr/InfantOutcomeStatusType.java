package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InfantOutcomeStatusType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="InfantOutcomeStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HIVPositiveLinkedtoART"/>
 *     &lt;enumeration value="HIVPositiveNotLinkedToART"/>
 *     &lt;enumeration value="HIVNeg"/>
 *     &lt;enumeration value="StillBreastfeeding"/>
 *     &lt;enumeration value="TransferredOut"/>
 *     &lt;enumeration value="LostToFollowUp"/>
 *     &lt;enumeration value="Dead"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "InfantOutcomeStatusType")
@XmlEnum
public enum InfantOutcomeStatusType {
	
	@XmlEnumValue("HIVPositiveLinkedtoART")
	HIV_POSITIVE_LINKEDTO_ART("HIVPositiveLinkedtoART"), @XmlEnumValue("HIVPositiveNotLinkedToART")
	HIV_POSITIVE_NOT_LINKED_TO_ART("HIVPositiveNotLinkedToART"), @XmlEnumValue("HIVNeg")
	HIV_NEG("HIVNeg"), @XmlEnumValue("StillBreastfeeding")
	STILL_BREASTFEEDING("StillBreastfeeding"), @XmlEnumValue("TransferredOut")
	TRANSFERRED_OUT("TransferredOut"), @XmlEnumValue("LostToFollowUp")
	LOST_TO_FOLLOW_UP("LostToFollowUp"), @XmlEnumValue("Dead")
	DEAD("Dead");
	
	private final String value;
	
	InfantOutcomeStatusType(String v) {
		value = v;
	}
	
	public String value() {
		return value;
	}
	
	public static InfantOutcomeStatusType fromValue(String v) {
		for (InfantOutcomeStatusType c : InfantOutcomeStatusType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
	
}
