package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FingerType", propOrder = { "Finger", "Type" })
public class FingerType {
	
	@XmlValue
	//@XmlElement(name = "Finger", required = true)
	private String Finger;
	
	@XmlAttribute(name = "Type", required = true)
	//@XmlElement(name = "Type", required = true)
	private String Type;
	
	public String getFinger() {
		return Finger;
	}
	
	public void setFinger(String finger) {
		Finger = finger;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
}
