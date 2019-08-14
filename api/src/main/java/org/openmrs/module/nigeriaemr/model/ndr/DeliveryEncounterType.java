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
import javax.xml.datatype.XMLGregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Bodyofchrist
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryEncounterType", propOrder = { "dateOfDelivery", "timeOfHIVDiagnosis", "gestationalAgeAtDelivery",
        "hBVStatus", "hCVStatus", "womanOnART", "aRTStartedInLDWard", "rOMDeliveryInterval", "modeOfDelivery", "episiotomy",
        "vaginalTear", "feedingDecision", "maternalOutcome" })
public class DeliveryEncounterType {
	
	@XmlElement(name = "DateOfDelivery")
	protected XMLGregorianCalendar dateOfDelivery;
	
	@XmlElement(name = "TimeOfHIVDiagnosis")
	protected XMLGregorianCalendar timeOfHIVDiagnosis;
	
	@XmlElement(name = "GestationalAgeAtDelivery")
	protected Integer gestationalAgeAtDelivery;
	
	@XmlElement(name = "HBVStatus")
	protected String hBVStatus;
	
	@XmlElement(name = "HCVStatus")
	protected String hCVStatus;
	
	@XmlElement(name = "WomanOnART")
	protected String womanOnART;
	
	@XmlElement(name = "ARTStartedInLDWard")
	protected String aRTStartedInLDWard;
	
	@XmlElement(name = "ROMDeliveryInterval")
	protected String rOMDeliveryInterval;
	
	@XmlElement(name = "ModeOfDelivery")
	protected String modeOfDelivery;
	
	@XmlElement(name = "Episiotomy")
	protected String episiotomy;
	
	@XmlElement(name = "VaginalTear")
	protected String vaginalTear;
	
	@XmlElement(name = "FeedingDecision")
	protected String feedingDecision;
	
	@XmlElement(name = "MaternalOutcome")
	protected String maternalOutcome;
	
	public XMLGregorianCalendar getDateOfDelivery() {
		return dateOfDelivery;
	}
	
	public void setDateOfDelivery(XMLGregorianCalendar dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	
	/*public String getTimeOfHIVDiagnosis() {
		return timeOfHIVDiagnosis;
	}
	
	public void setTimeOfHIVDiagnosis(String timeOfHIVDiagnosis) {
		this.timeOfHIVDiagnosis = timeOfHIVDiagnosis;
	}*/
	
	public XMLGregorianCalendar getTimeOfHIVDiagnosis() {
		return timeOfHIVDiagnosis;
	}
	
	public void setTimeOfHIVDiagnosis(XMLGregorianCalendar timeOfHIVDiagnosis) {
		this.timeOfHIVDiagnosis = timeOfHIVDiagnosis;
	}
	
	public Integer getGestationalAgeAtDelivery() {
		return gestationalAgeAtDelivery;
	}
	
	public void setGestationalAgeAtDelivery(Integer gestationalAgeAtDelivery) {
		this.gestationalAgeAtDelivery = gestationalAgeAtDelivery;
	}
	
	public String gethBVStatus() {
		return hBVStatus;
	}
	
	public void sethBVStatus(String hBVStatus) {
		this.hBVStatus = hBVStatus;
	}
	
	public String gethCVStatus() {
		return hCVStatus;
	}
	
	public void sethCVStatus(String hCVStatus) {
		this.hCVStatus = hCVStatus;
	}
	
	public String getWomanOnART() {
		return womanOnART;
	}
	
	public void setWomanOnART(String womanOnART) {
		this.womanOnART = womanOnART;
	}
	
	public String getaRTStartedInLDWard() {
		return aRTStartedInLDWard;
	}
	
	public void setaRTStartedInLDWard(String aRTStartedInLDWard) {
		this.aRTStartedInLDWard = aRTStartedInLDWard;
	}
	
	public String getrOMDeliveryInterval() {
		return rOMDeliveryInterval;
	}
	
	public void setrOMDeliveryInterval(String rOMDeliveryInterval) {
		this.rOMDeliveryInterval = rOMDeliveryInterval;
	}
	
	public String getModeOfDelivery() {
		return modeOfDelivery;
	}
	
	public void setModeOfDelivery(String modeOfDelivery) {
		this.modeOfDelivery = modeOfDelivery;
	}
	
	public String getEpisiotomy() {
		return episiotomy;
	}
	
	public void setEpisiotomy(String episiotomy) {
		this.episiotomy = episiotomy;
	}
	
	public String getVaginalTear() {
		return vaginalTear;
	}
	
	public void setVaginalTear(String vaginalTear) {
		this.vaginalTear = vaginalTear;
	}
	
	public String getFeedingDecision() {
		return feedingDecision;
	}
	
	public void setFeedingDecision(String feedingDecision) {
		this.feedingDecision = feedingDecision;
	}
	
	public String getMaternalOutcome() {
		return maternalOutcome;
	}
	
	public void setMaternalOutcome(String maternalOutcome) {
		this.maternalOutcome = maternalOutcome;
	}
	
}
