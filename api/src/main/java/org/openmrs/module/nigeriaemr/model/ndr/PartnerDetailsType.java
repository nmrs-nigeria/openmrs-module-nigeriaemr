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
@XmlType(name = "PartnerDetailsType", propOrder = { "partnerAge", "partnerPreTestCounseled", "partnerPostTestCounseled",
        "partnerAcceptsHIVTest", "partnerHIVTestResult", "partnerHBVStatus", "partnerHCVStatus", "partnerSyphilisStatus",
        "partnerReferredTo" })
public class PartnerDetailsType {
	
	@XmlElement(name = "PartnerAge", required = true)
	protected Integer partnerAge;
	
	@XmlElement(name = "PartnerPreTestCounseled")
	protected String partnerPreTestCounseled;
	
	@XmlElement(name = "PartnerPostTestCounseled")
	protected String partnerPostTestCounseled;
	
	@XmlElement(name = "PartnerAcceptsHIVTest")
	protected String partnerAcceptsHIVTest;
	
	@XmlElement(name = "PartnerHIVTestResult")
	protected String partnerHIVTestResult;
	
	@XmlElement(name = "PartnerHBVStatus")
	protected String partnerHBVStatus;
	
	@XmlElement(name = "PartnerHCVStatus")
	protected String partnerHCVStatus;
	
	@XmlElement(name = "PartnerSyphilisStatus")
	protected String partnerSyphilisStatus;
	
	@XmlElement(name = "PartnerReferredTo")
	protected String partnerReferredTo;
	
	public Integer getPartnerAge() {
		return partnerAge;
	}
	
	public void setPartnerAge(Integer partnerAge) {
		this.partnerAge = partnerAge;
	}
	
	public String getPartnerPreTestCounseled() {
		return partnerPreTestCounseled;
	}
	
	public void setPartnerPreTestCounseled(String partnerPreTestCounseled) {
		this.partnerPreTestCounseled = partnerPreTestCounseled;
	}
	
	public String getPartnerPostTestCounseled() {
		return partnerPostTestCounseled;
	}
	
	public void setPartnerPostTestCounseled(String partnerPostTestCounseled) {
		this.partnerPostTestCounseled = partnerPostTestCounseled;
	}
	
	public String getPartnerAcceptsHIVTest() {
		return partnerAcceptsHIVTest;
	}
	
	public void setPartnerAcceptsHIVTest(String partnerAcceptsHIVTest) {
		this.partnerAcceptsHIVTest = partnerAcceptsHIVTest;
	}
	
	public String getPartnerHIVTestResult() {
		return partnerHIVTestResult;
	}
	
	public void setPartnerHIVTestResult(String partnerHIVTestResult) {
		this.partnerHIVTestResult = partnerHIVTestResult;
	}
	
	public String getPartnerHBVStatus() {
		return partnerHBVStatus;
	}
	
	public void setPartnerHBVStatus(String partnerHBVStatus) {
		this.partnerHBVStatus = partnerHBVStatus;
	}
	
	public String getPartnerHCVStatus() {
		return partnerHCVStatus;
	}
	
	public void setPartnerHCVStatus(String partnerHCVStatus) {
		this.partnerHCVStatus = partnerHCVStatus;
	}
	
	public String getPartnerSyphilisStatus() {
		return partnerSyphilisStatus;
	}
	
	public void setPartnerSyphilisStatus(String partnerSyphilisStatus) {
		this.partnerSyphilisStatus = partnerSyphilisStatus;
	}
	
	public String getPartnerReferredTo() {
		return partnerReferredTo;
	}
	
	public void setPartnerReferredTo(String partnerReferredTo) {
		this.partnerReferredTo = partnerReferredTo;
	}
	
}
