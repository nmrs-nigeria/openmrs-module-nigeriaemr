package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildFollowupType", propOrder = { "infantARVType", "timingOfARVProphylaxis", "ageAtCTXInitiation",
        "infantOutcomeAt18Months", "dateLinkedToARTClinic", "aRTEnrollmentNumber" })
public class ChildFollowupType {
	
	@XmlElement(name = "InfantARVType", required = true)
	protected String infantARVType;
	
	@XmlElement(name = "TimingOfARVProphylaxis")
	protected String timingOfARVProphylaxis;
	
	@XmlElement(name = "AgeAtCTXInitiation")
	protected Integer ageAtCTXInitiation;
	
	@XmlElement(name = "InfantOutcomeAt18Months")
	protected String infantOutcomeAt18Months;
	
	@XmlElement(name = "DateLinkedToARTClinic")
	protected XMLGregorianCalendar dateLinkedToARTClinic;
	
	@XmlElement(name = "ARTEnrollmentNumber")
	protected String aRTEnrollmentNumber;
	
	public String getInfantARVType() {
		return infantARVType;
	}
	
	public void setInfantARVType(String infantARVType) {
		this.infantARVType = infantARVType;
	}
	
	public String getTimingOfARVProphylaxis() {
		return timingOfARVProphylaxis;
	}
	
	public void setTimingOfARVProphylaxis(String timingOfARVProphylaxis) {
		this.timingOfARVProphylaxis = timingOfARVProphylaxis;
	}
	
	public Integer getAgeAtCTXInitiation() {
		return ageAtCTXInitiation;
	}
	
	public void setAgeAtCTXInitiation(Integer ageAtCTXInitiation) {
		this.ageAtCTXInitiation = ageAtCTXInitiation;
	}
	
	public String getInfantOutcomeAt18Months() {
		return infantOutcomeAt18Months;
	}
	
	public void setInfantOutcomeAt18Months(String infantOutcomeAt18Months) {
		this.infantOutcomeAt18Months = infantOutcomeAt18Months;
	}
	
	public XMLGregorianCalendar getDateLinkedToARTClinic() {
		return dateLinkedToARTClinic;
	}
	
	public void setDateLinkedToARTClinic(XMLGregorianCalendar dateLinkedToARTClinic) {
		this.dateLinkedToARTClinic = dateLinkedToARTClinic;
	}
	
	public String getaRTEnrollmentNumber() {
		return aRTEnrollmentNumber;
	}
	
	public void setaRTEnrollmentNumber(String aRTEnrollmentNumber) {
		this.aRTEnrollmentNumber = aRTEnrollmentNumber;
	}
	
}
