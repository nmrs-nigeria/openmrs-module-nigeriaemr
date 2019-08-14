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
@XmlType(name = "InfantPCRTestingType", propOrder = { "ageAtTest", "dateSampleCollected", "dateSampleSent",
        "dateResultReceivedAtFacility", "dateCaregiverGivenResult", "pCRTestResult" })
public class InfantPCRTestingType {
	
	@XmlElement(name = "AgeAtTest", required = true)
	protected String ageAtTest;
	
	@XmlElement(name = "DateSampleCollected")
	protected XMLGregorianCalendar dateSampleCollected;
	
	@XmlElement(name = "DateSampleSent")
	protected XMLGregorianCalendar dateSampleSent;
	
	@XmlElement(name = "DateResultReceivedAtFacility")
	protected XMLGregorianCalendar dateResultReceivedAtFacility;
	
	@XmlElement(name = "DateCaregiverGivenResult")
	protected XMLGregorianCalendar dateCaregiverGivenResult;
	
	@XmlElement(name = "PCRTestResult")
	protected String pCRTestResult;
	
	public String getAgeAtTest() {
		return ageAtTest;
	}
	
	public void setAgeAtTest(String ageAtTest) {
		this.ageAtTest = ageAtTest;
	}
	
	public XMLGregorianCalendar getDateSampleCollected() {
		return dateSampleCollected;
	}
	
	public void setDateSampleCollected(XMLGregorianCalendar dateSampleCollected) {
		this.dateSampleCollected = dateSampleCollected;
	}
	
	public XMLGregorianCalendar getDateSampleSent() {
		return dateSampleSent;
	}
	
	public void setDateSampleSent(XMLGregorianCalendar dateSampleSent) {
		this.dateSampleSent = dateSampleSent;
	}
	
	public XMLGregorianCalendar getDateResultReceivedAtFacility() {
		return dateResultReceivedAtFacility;
	}
	
	public void setDateResultReceivedAtFacility(XMLGregorianCalendar dateResultReceivedAtFacility) {
		this.dateResultReceivedAtFacility = dateResultReceivedAtFacility;
	}
	
	public XMLGregorianCalendar getDateCaregiverGivenResult() {
		return dateCaregiverGivenResult;
	}
	
	public void setDateCaregiverGivenResult(XMLGregorianCalendar dateCaregiverGivenResult) {
		this.dateCaregiverGivenResult = dateCaregiverGivenResult;
	}
	
	public String getpCRTestResult() {
		return pCRTestResult;
	}
	
	public void setpCRTestResult(String pCRTestResult) {
		this.pCRTestResult = pCRTestResult;
	}
	
}
