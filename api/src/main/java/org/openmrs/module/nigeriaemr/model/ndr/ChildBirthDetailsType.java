package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChildBirthDetailsType", propOrder = { "childHospitalNumber", "childEIDNumber", "childDateOfBirth",
        "childSexCode", "childGivenNVPWithin72hrs", "childStatus", "aPGARScore", "birthMUAC", "birthLenght", "birthWeight",
        "headCircumferenceAtBirth", "immunizationReceived", "hBVExposedInfantGivenHepBIg", "nonHBVExposedInfantGivenHBV" })
public class ChildBirthDetailsType {
	
	@XmlElement(name = "ChildHospitalNumber")
	protected String childHospitalNumber;
	
	@XmlElement(name = "ChildEIDNumber")
	protected String childEIDNumber;
	
	@XmlElement(name = "ChildDateOfBirth")
	protected XMLGregorianCalendar childDateOfBirth;
	
	@XmlElement(name = "ChildSexCode")
	protected String childSexCode;
	
	@XmlElement(name = "ChildGivenNVPWithin72hrs")
	protected String childGivenNVPWithin72hrs;
	
	@XmlElement(name = "ChildStatus")
	protected String childStatus;
	
	@XmlElement(name = "APGARScore")
	protected Float aPGARScore;
	
	@XmlElement(name = "BirthMUAC")
	protected Float birthMUAC;
	
	@XmlElement(name = "BirthLenght")
	protected Float birthLenght;
	
	@XmlElement(name = "BirthWeight")
	protected Float birthWeight;
	
	@XmlElement(name = "HeadCircumferenceAtBirth")
	protected Float headCircumferenceAtBirth;
	
	@XmlElement(name = "ImmunizationReceived")
	protected String immunizationReceived;
	
	@XmlElement(name = "HBVExposedInfantGivenHepBIg")
	protected String hBVExposedInfantGivenHepBIg;
	
	@XmlElement(name = "NonHBVExposedInfantGivenHBV")
	protected String nonHBVExposedInfantGivenHBV;
	
	public String getChildHospitalNumber() {
		return childHospitalNumber;
	}
	
	public void setChildHospitalNumber(String childHospitalNumber) {
		this.childHospitalNumber = childHospitalNumber;
	}
	
	public String getChildEIDNumber() {
		return childEIDNumber;
	}
	
	public void setChildEIDNumber(String childEIDNumber) {
		this.childEIDNumber = childEIDNumber;
	}
	
	public XMLGregorianCalendar getChildDateOfBirth() {
		return childDateOfBirth;
	}
	
	public void setChildDateOfBirth(XMLGregorianCalendar childDateOfBirth) {
		this.childDateOfBirth = childDateOfBirth;
	}
	
	public String getChildSexCode() {
		return childSexCode;
	}
	
	public void setChildSexCode(String childSexCode) {
		this.childSexCode = childSexCode;
	}
	
	public String getChildGivenNVPWithin72hrs() {
		return childGivenNVPWithin72hrs;
	}
	
	public void setChildGivenNVPWithin72hrs(String childGivenNVPWithin72hrs) {
		this.childGivenNVPWithin72hrs = childGivenNVPWithin72hrs;
	}
	
	public String getChildStatus() {
		return childStatus;
	}
	
	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}
	
	public Float getaPGARScore() {
		return aPGARScore;
	}
	
	public void setaPGARScore(Float aPGARScore) {
		this.aPGARScore = aPGARScore;
	}
	
	public Float getBirthMUAC() {
		return birthMUAC;
	}
	
	public void setBirthMUAC(Float birthMUAC) {
		this.birthMUAC = birthMUAC;
	}
	
	public Float getBirthLenght() {
		return birthLenght;
	}
	
	public void setBirthLenght(Float birthLenght) {
		this.birthLenght = birthLenght;
	}
	
	public Float getBirthWeight() {
		return birthWeight;
	}
	
	public void setBirthWeight(Float birthWeight) {
		this.birthWeight = birthWeight;
	}
	
	public Float getHeadCircumferenceAtBirth() {
		return headCircumferenceAtBirth;
	}
	
	public void setHeadCircumferenceAtBirth(Float headCircumferenceAtBirth) {
		this.headCircumferenceAtBirth = headCircumferenceAtBirth;
	}
	
	public String getImmunizationReceived() {
		return immunizationReceived;
	}
	
	public void setImmunizationReceived(String immunizationReceived) {
		this.immunizationReceived = immunizationReceived;
	}
	
	public String gethBVExposedInfantGivenHepBIg() {
		return hBVExposedInfantGivenHepBIg;
	}
	
	public void sethBVExposedInfantGivenHepBIg(String hBVExposedInfantGivenHepBIg) {
		this.hBVExposedInfantGivenHepBIg = hBVExposedInfantGivenHepBIg;
	}
	
	public String getNonHBVExposedInfantGivenHBV() {
		return nonHBVExposedInfantGivenHBV;
	}
	
	public void setNonHBVExposedInfantGivenHBV(String nonHBVExposedInfantGivenHBV) {
		this.nonHBVExposedInfantGivenHBV = nonHBVExposedInfantGivenHBV;
	}
	
}
