package org.openmrs.module.nigeriaemr.model.ndr;

/*
* <p>Java class for FingerPrintsType complex type.</p>
* The following schema fragment specifies the expected content contained within this class.
* */

import org.joda.time.DateTime;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FingerPrintsType", propOrder = { "present", "dateCaptured", "rightHand", "leftHand" })
public class FingerPrintsType {
	
	@XmlAttribute
	//@XmlElement(name = "present", required = true)
	private boolean present;
	
	@XmlElement(name = "dateCaptured", required = true)
	private Date dateCaptured;
	
	@XmlElement(name = "rightHand", required = true)
	private HandType rightHand;
	
	@XmlElement(name = "leftHand", required = true)
	private HandType leftHand;
	
	public boolean isPresent() {
		return present;
	}
	
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public Date getDateCaptured() {
		return dateCaptured;
	}
	
	public void setDateCaptured(Date dateCaptured) {
		this.dateCaptured = dateCaptured;
	}
	
	public HandType getRightHand() {
		return rightHand;
	}
	
	public void setRightHand(HandType rightHand) {
		this.rightHand = rightHand;
	}
	
	public HandType getLeftHand() {
		return leftHand;
	}
	
	public void setLeftHand(HandType leftHand) {
		this.leftHand = leftHand;
	}
}
