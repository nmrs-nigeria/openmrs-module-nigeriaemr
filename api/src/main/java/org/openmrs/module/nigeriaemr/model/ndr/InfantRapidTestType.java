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
@XmlType(name = "InfantRapidTestType", propOrder = { "ageAtTest", "dateOfTest", "rapidTestResult" })
public class InfantRapidTestType {
	
	@XmlElement(name = "AgeAtTest")
	protected Integer ageAtTest;
	
	@XmlElement(name = "DateOfTest")
	protected XMLGregorianCalendar dateOfTest;
	
	@XmlElement(name = "RapidTestResult")
	protected String rapidTestResult;
	
	public Integer getAgeAtTest() {
		return ageAtTest;
	}
	
	public void setAgeAtTest(Integer ageAtTest) {
		this.ageAtTest = ageAtTest;
	}
	
	public XMLGregorianCalendar getDateOfTest() {
		return dateOfTest;
	}
	
	public void setDateOfTest(XMLGregorianCalendar dateOfTest) {
		this.dateOfTest = dateOfTest;
	}
	
	public String getRapidTestResult() {
		return rapidTestResult;
	}
	
	public void setRapidTestResult(String rapidTestResult) {
		this.rapidTestResult = rapidTestResult;
	}
	
}
