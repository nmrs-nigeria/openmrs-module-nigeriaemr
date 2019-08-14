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

/**
 * @author Bodyofchrist
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyndromicSTIScreeningType", propOrder = { "vaginalDischargeOrBurningWhenUrinating",
        "lowerAbdominalPainsWithOrWithoutVaginalDischarge", "urethralDischargeOrBurningWhenUrinating",
        "scrotalSwellingAndPain", "genitalSoreOrSwollenInguinalLymphNodes" })
public class SyndromicSTIScreeningType {
	
	@XmlElement(name = "VaginalDischargeOrBurningWhenUrinating", required = true)
	protected Boolean vaginalDischargeOrBurningWhenUrinating;
	
	@XmlElement(name = "LowerAbdominalPainsWithOrWithoutVaginalDischarge")
	protected Boolean lowerAbdominalPainsWithOrWithoutVaginalDischarge;
	
	@XmlElement(name = "UrethralDischargeOrBurningWhenUrinating")
	protected Boolean urethralDischargeOrBurningWhenUrinating;
	
	@XmlElement(name = "ScrotalSwellingAndPain")
	protected Boolean scrotalSwellingAndPain;
	
	@XmlElement(name = "GenitalSoreOrSwollenInguinalLymphNodes")
	protected Boolean genitalSoreOrSwollenInguinalLymphNodes;
	
	public Boolean getVaginalDischargeOrBurningWhenUrinating() {
		return vaginalDischargeOrBurningWhenUrinating;
	}
	
	public void setVaginalDischargeOrBurningWhenUrinating(Boolean vaginalDischargeOrBurningWhenUrinating) {
		this.vaginalDischargeOrBurningWhenUrinating = vaginalDischargeOrBurningWhenUrinating;
	}
	
	public Boolean getLowerAbdominalPainsWithOrWithoutVaginalDischarge() {
		return lowerAbdominalPainsWithOrWithoutVaginalDischarge;
	}
	
	public void setLowerAbdominalPainsWithOrWithoutVaginalDischarge(Boolean lowerAbdominalPainsWithOrWithoutVaginalDischarge) {
		this.lowerAbdominalPainsWithOrWithoutVaginalDischarge = lowerAbdominalPainsWithOrWithoutVaginalDischarge;
	}
	
	public Boolean getUrethralDischargeOrBurningWhenUrinating() {
		return urethralDischargeOrBurningWhenUrinating;
	}
	
	public void setUrethralDischargeOrBurningWhenUrinating(Boolean urethralDischargeOrBurningWhenUrinating) {
		this.urethralDischargeOrBurningWhenUrinating = urethralDischargeOrBurningWhenUrinating;
	}
	
	public Boolean getScrotalSwellingAndPain() {
		return scrotalSwellingAndPain;
	}
	
	public void setScrotalSwellingAndPain(Boolean scrotalSwellingAndPain) {
		this.scrotalSwellingAndPain = scrotalSwellingAndPain;
	}
	
	public Boolean getGenitalSoreOrSwollenInguinalLymphNodes() {
		return genitalSoreOrSwollenInguinalLymphNodes;
	}
	
	public void setGenitalSoreOrSwollenInguinalLymphNodes(Boolean genitalSoreOrSwollenInguinalLymphNodes) {
		this.genitalSoreOrSwollenInguinalLymphNodes = genitalSoreOrSwollenInguinalLymphNodes;
	}
	
}
