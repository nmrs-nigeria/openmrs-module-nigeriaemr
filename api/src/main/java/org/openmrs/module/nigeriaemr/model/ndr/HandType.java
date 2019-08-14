package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HandType", propOrder = { "Finger" })
public class HandType {
	
	@XmlElement(name = "Finger", required = true)
	private List<FingerType> Finger;
	
	public List<FingerType> getFinger() {
		return Finger;
	}
	
	public void setFinger(List<FingerType> finger) {
		Finger = finger;
	}
}
