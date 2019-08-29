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
@XmlType(name = "KnowledgeAssessmentType", propOrder = { "previouslyTestedHIVNegative",
        "clientInformedAboutHIVTransmissionRoutes", "clientPregnant", "clientInformedOfHIVTransmissionRiskFactors",
        "clientInformedAboutPreventingHIV", "clientInformedAboutPossibleTestResults", "informedConsentForHIVTestingGiven" })
public class KnowledgeAssessmentType {
	
	@XmlElement(name = "PreviouslyTestedHIVNegative")
	protected Boolean previouslyTestedHIVNegative;
	
	@XmlElement(name = "ClientInformedAboutHIVTransmissionRoutes")
	protected Boolean clientInformedAboutHIVTransmissionRoutes;
	
	@XmlElement(name = "ClientPregnant")
	protected Boolean clientPregnant;
	
	@XmlElement(name = "ClientInformedOfHIVTransmissionRiskFactors")
	protected Boolean clientInformedOfHIVTransmissionRiskFactors;
	
	@XmlElement(name = "ClientInformedAboutPreventingHIV")
	protected Boolean clientInformedAboutPreventingHIV;
	
	@XmlElement(name = "ClientInformedAboutPossibleTestResults")
	protected Boolean clientInformedAboutPossibleTestResults;
	
	@XmlElement(name = "InformedConsentForHIVTestingGiven")
	protected Boolean informedConsentForHIVTestingGiven;
	
	public Boolean getPreviouslyTestedHIVNegative() {
		return previouslyTestedHIVNegative;
	}
	
	public void setPreviouslyTestedHIVNegative(Boolean previouslyTestedHIVNegative) {
		this.previouslyTestedHIVNegative = previouslyTestedHIVNegative;
	}
	
	public Boolean getClientInformedAboutHIVTransmissionRoutes() {
		return clientInformedAboutHIVTransmissionRoutes;
	}
	
	public void setClientInformedAboutHIVTransmissionRoutes(Boolean clientInformedAboutHIVTransmissionRoutes) {
		this.clientInformedAboutHIVTransmissionRoutes = clientInformedAboutHIVTransmissionRoutes;
	}
	
	public Boolean getClientPregnant() {
		return clientPregnant;
	}
	
	public void setClientPregnant(Boolean clientPregnant) {
		this.clientPregnant = clientPregnant;
	}
	
	public Boolean getClientInformedOfHIVTransmissionRiskFactors() {
		return clientInformedOfHIVTransmissionRiskFactors;
	}
	
	public void setClientInformedOfHIVTransmissionRiskFactors(Boolean clientInformedOfHIVTransmissionRiskFactors) {
		this.clientInformedOfHIVTransmissionRiskFactors = clientInformedOfHIVTransmissionRiskFactors;
	}
	
	public Boolean getClientInformedAboutPreventingHIV() {
		return clientInformedAboutPreventingHIV;
	}
	
	public void setClientInformedAboutPreventingHIV(Boolean clientInformedAboutPreventingHIV) {
		this.clientInformedAboutPreventingHIV = clientInformedAboutPreventingHIV;
	}
	
	public Boolean getClientInformedAboutPossibleTestResults() {
		return clientInformedAboutPossibleTestResults;
	}
	
	public void setClientInformedAboutPossibleTestResults(Boolean clientInformedAboutPossibleTestResults) {
		this.clientInformedAboutPossibleTestResults = clientInformedAboutPossibleTestResults;
	}
	
	public Boolean getInformedConsentForHIVTestingGiven() {
		return informedConsentForHIVTestingGiven;
	}
	
	public void setInformedConsentForHIVTestingGiven(Boolean informedConsentForHIVTestingGiven) {
		this.informedConsentForHIVTestingGiven = informedConsentForHIVTestingGiven;
	}
	
	public boolean isEmpty() {
		if (this.previouslyTestedHIVNegative == null && this.clientInformedAboutHIVTransmissionRoutes == null
		        && this.clientPregnant == null && this.clientInformedOfHIVTransmissionRiskFactors == null
		        && this.clientInformedAboutPreventingHIV == null && this.clientInformedAboutPossibleTestResults == null
		        && this.informedConsentForHIVTestingGiven == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
