package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTClinicalTBScreeningType", propOrder = { "currentlyCough", "weightLoss", "fever", "nightSweats",
        "contactWithTBPositivePatient" })
public class PMTCTClinicalTBScreeningType {
	
	@XmlElement(name = "CurrentlyCough")
	protected boolean currentlyCough;
	
	@XmlElement(name = "WeightLoss")
	protected boolean weightLoss;
	
	@XmlElement(name = "Fever")
	protected boolean fever;
	
	@XmlElement(name = "NightSweats")
	protected boolean nightSweats;
	
	@XmlElement(name = "ContactWithTBPositivePatient")
	protected boolean contactWithTBPositivePatient;
	
	public boolean isCurrentlyCough() {
		return currentlyCough;
	}
	
	public void setCurrentlyCough(boolean value) {
		this.currentlyCough = value;
	}
	
	public boolean isWeightLoss() {
		return weightLoss;
	}
	
	public void setWeightLoss(boolean value) {
		this.weightLoss = value;
	}
	
	public boolean isFever() {
		return fever;
	}
	
	public void setFever(boolean value) {
		this.fever = value;
	}
	
	public boolean isNightSweats() {
		return nightSweats;
	}
	
	public void setNightSweats(boolean value) {
		this.nightSweats = value;
	}
	
	public boolean isContactWithTBPositivePatient() {
		return contactWithTBPositivePatient;
	}
	
	public void setContactWithTBPositivePatient(boolean value) {
		this.contactWithTBPositivePatient = value;
	}
	
}
