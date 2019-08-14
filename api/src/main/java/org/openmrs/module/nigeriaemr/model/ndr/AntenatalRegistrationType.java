package org.openmrs.module.nigeriaemr.model.ndr;

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
@XmlType(name = "AntenatalRegistrationType", propOrder = { "dateOfVisit", "lastMenstralPeriod",
        "gestationalAgeAtANCRegistration", "gravida", "parity", "sourceOfReferral", "expectedDateOfDelivery", "syphilis" })
public class AntenatalRegistrationType {
	
	@XmlElement(name = "DateOfVisit", required = true)
	protected XMLGregorianCalendar dateOfVisit;
	
	@XmlElement(name = "LastMenstralPeriod")
	protected XMLGregorianCalendar lastMenstralPeriod;
	
	@XmlElement(name = "GestationalAgeAtANCRegistration")
	protected Integer gestationalAgeAtANCRegistration;
	
	@XmlElement(name = "Gravida")
	protected Integer gravida;
	
	@XmlElement(name = "Parity")
	protected Integer parity;
	
	@XmlElement(name = "SourceOfReferral")
	protected String sourceOfReferral;
	
	@XmlElement(name = "ExpectedDateOfDelivery")
	protected XMLGregorianCalendar expectedDateOfDelivery;
	
	@XmlElement(name = "Syphilis", required = true)
	protected Syphilis syphilis;
	
	public XMLGregorianCalendar getDateOfVisit() {
		return dateOfVisit;
	}
	
	public void setDateOfVisit(XMLGregorianCalendar dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	
	public XMLGregorianCalendar getLastMenstralPeriod() {
		return lastMenstralPeriod;
	}
	
	public void setLastMenstralPeriod(XMLGregorianCalendar lastMenstralPeriod) {
		this.lastMenstralPeriod = lastMenstralPeriod;
	}
	
	public Integer getGestationalAgeAtANCRegistration() {
		return gestationalAgeAtANCRegistration;
	}
	
	public void setGestationalAgeAtANCRegistration(Integer gestationalAgeAtANCRegistration) {
		this.gestationalAgeAtANCRegistration = gestationalAgeAtANCRegistration;
	}
	
	public Integer getGravida() {
		return gravida;
	}
	
	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}
	
	public Integer getParity() {
		return parity;
	}
	
	public void setParity(Integer parity) {
		this.parity = parity;
	}
	
	public String getSourceOfReferral() {
		return sourceOfReferral;
	}
	
	public void setSourceOfReferral(String sourceOfReferral) {
		this.sourceOfReferral = sourceOfReferral;
	}
	
	public XMLGregorianCalendar getExpectedDateOfDelivery() {
		return expectedDateOfDelivery;
	}
	
	public void setExpectedDateOfDelivery(XMLGregorianCalendar expectedDateOfDelivery) {
		this.expectedDateOfDelivery = expectedDateOfDelivery;
	}
	
	public Syphilis getSyphilis() {
		return syphilis;
	}
	
	public void setSyphilis(Syphilis syphilis) {
		this.syphilis = syphilis;
	}
}
