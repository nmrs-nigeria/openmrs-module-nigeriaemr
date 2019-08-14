/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bodyofchrist
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClinicalTBScreeningType", propOrder = { "currentlyCough", "weightLoss", "fever", "nightSweats" })
public class ClinicalTBScreeningType {
	
	@XmlElement(name = "CurrentlyCough")
	protected Boolean currentlyCough;
	
	@XmlElement(name = "WeightLoss")
	protected Boolean weightLoss;
	
	@XmlElement(name = "Fever")
	protected Boolean fever;
	
	@XmlElement(name = "NightSweats")
	protected Boolean nightSweats;
	
	public Boolean getCurrentlyCough() {
		return currentlyCough;
	}
	
	public void setCurrentlyCough(Boolean currentlyCough) {
		this.currentlyCough = currentlyCough;
	}
	
	public Boolean getWeightLoss() {
		return weightLoss;
	}
	
	public void setWeightLoss(Boolean weightLoss) {
		this.weightLoss = weightLoss;
	}
	
	public Boolean getFever() {
		return fever;
	}
	
	public void setFever(Boolean fever) {
		this.fever = fever;
	}
	
	public Boolean getNightSweats() {
		return nightSweats;
	}
	
	public void setNightSweats(Boolean nightSweats) {
		this.nightSweats = nightSweats;
	}
	
}
