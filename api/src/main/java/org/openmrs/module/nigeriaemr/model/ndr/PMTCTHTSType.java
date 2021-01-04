package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTHTSType", propOrder = { "visitID", "visitDate", "pmtctEntryPoint", "previouslyKnownHIVPositive",
        "acceptedHIVTesting", "hivTestResult", "receivedHIVTestResult", "hivRetesting", "testedForHepB", "hepBTestResult",
        "testedForHepC", "hepCTestResult", "hivhbvCoInfected", "hivhcvCoInfected", "agreedToPartnerNotification",
        "clinicalTBScreening" })
public class PMTCTHTSType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "PMTCTEntryPoint")
	protected String pmtctEntryPoint;
	
	@XmlElement(name = "PreviouslyKnownHIVPositive")
	protected boolean previouslyKnownHIVPositive;
	
	@XmlElement(name = "AcceptedHIVTesting")
	protected Boolean acceptedHIVTesting;
	
	@XmlElement(name = "HIVTestResult")
	protected String hivTestResult;
	
	@XmlElement(name = "ReceivedHIVTestResult")
	protected Boolean receivedHIVTestResult;
	
	@XmlElement(name = "HIVRetesting")
	protected String hivRetesting;
	
	@XmlElement(name = "TestedForHepB")
	protected Boolean testedForHepB;
	
	@XmlElement(name = "HepBTestResult")
	protected String hepBTestResult;
	
	@XmlElement(name = "TestedForHepC")
	protected Boolean testedForHepC;
	
	@XmlElement(name = "HepCTestResult")
	protected String hepCTestResult;
	
	@XmlElement(name = "HIVHBVCoInfected")
	protected Boolean hivhbvCoInfected;
	
	@XmlElement(name = "HIVHCVCoInfected")
	protected Boolean hivhcvCoInfected;
	
	@XmlElement(name = "AgreedToPartnerNotification")
	protected Boolean agreedToPartnerNotification;
	
	@XmlElement(name = "ClinicalTBScreening")
	protected PMTCTClinicalTBScreeningType clinicalTBScreening;
	
	public String getVisitID() {
		return visitID;
	}
	
	public void setVisitID(String value) {
		this.visitID = value;
	}
	
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	public void setVisitDate(XMLGregorianCalendar value) {
		this.visitDate = value;
	}
	
	public String getPMTCTEntryPoint() {
		return pmtctEntryPoint;
	}
	
	public void setPMTCTEntryPoint(String value) {
		this.pmtctEntryPoint = value;
	}
	
	public boolean isPreviouslyKnownHIVPositive() {
		return previouslyKnownHIVPositive;
	}
	
	public void setPreviouslyKnownHIVPositive(boolean value) {
		this.previouslyKnownHIVPositive = value;
	}
	
	public Boolean isAcceptedHIVTesting() {
		return acceptedHIVTesting;
	}
	
	public void setAcceptedHIVTesting(Boolean value) {
		this.acceptedHIVTesting = value;
	}
	
	public String getHIVTestResult() {
		return hivTestResult;
	}
	
	public void setHIVTestResult(String value) {
		this.hivTestResult = value;
	}
	
	public Boolean isReceivedHIVTestResult() {
		return receivedHIVTestResult;
	}
	
	public void setReceivedHIVTestResult(Boolean value) {
		this.receivedHIVTestResult = value;
	}
	
	public String getHIVRetesting() {
		return hivRetesting;
	}
	
	public void setHIVRetesting(String value) {
		this.hivRetesting = value;
	}
	
	public Boolean isTestedForHepB() {
		return testedForHepB;
	}
	
	public void setTestedForHepB(Boolean value) {
		this.testedForHepB = value;
	}
	
	public String getHepBTestResult() {
		return hepBTestResult;
	}
	
	public void setHepBTestResult(String value) {
		this.hepBTestResult = value;
	}
	
	public Boolean isTestedForHepC() {
		return testedForHepC;
	}
	
	public void setTestedForHepC(Boolean value) {
		this.testedForHepC = value;
	}
	
	public String getHepCTestResult() {
		return hepCTestResult;
	}
	
	public void setHepCTestResult(String value) {
		this.hepCTestResult = value;
	}
	
	public Boolean isHIVHBVCoInfected() {
		return hivhbvCoInfected;
	}
	
	public void setHIVHBVCoInfected(Boolean value) {
		this.hivhbvCoInfected = value;
	}
	
	public Boolean isHIVHCVCoInfected() {
		return hivhcvCoInfected;
	}
	
	public void setHIVHCVCoInfected(Boolean value) {
		this.hivhcvCoInfected = value;
	}
	
	public Boolean isAgreedToPartnerNotification() {
		return agreedToPartnerNotification;
	}
	
	public void setAgreedToPartnerNotification(Boolean value) {
		this.agreedToPartnerNotification = value;
	}
	
	public PMTCTClinicalTBScreeningType getClinicalTBScreening() {
		return clinicalTBScreening;
	}
	
	public void setClinicalTBScreening(PMTCTClinicalTBScreeningType value) {
		this.clinicalTBScreening = value;
	}
	
}
