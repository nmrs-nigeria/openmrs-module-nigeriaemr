package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaternalCohortType", propOrder = { "visitID", "visitDate", "viralLoadPeriod", "sampleCollectionDate",
        "viralLoadResult", "pmtctEntryPoint", "gestationalAgeAtSampleCollection", "gestationalAge", "timingOfArtInitiation",
        "tbStatus", "gravida", "artStartDate", "dateOfDelivery", "familyPlanningCounselling", "familyPlanningMethod" })
public class MaternalCohortType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "ViralLoadPeriod")
	protected String viralLoadPeriod;
	
	@XmlElement(name = "SampleCollectionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar sampleCollectionDate;
	
	@XmlElement(name = "ViralLoadResult")
	protected Double viralLoadResult;
	
	@XmlElement(name = "PMTCTEntryPoint")
	protected String pmtctEntryPoint;
	
	@XmlElement(name = "GestationalAgeAtSampleCollection")
	protected Integer gestationalAgeAtSampleCollection;
	
	@XmlElement(name = "GestationalAge")
	protected Integer gestationalAge;
	
	@XmlElement(name = "TimingOfArtInitiation")
	protected String timingOfArtInitiation;
	
	@XmlElement(name = "TBStatus")
	protected Integer tbStatus;
	
	@XmlElement(name = "Gravida")
	protected Integer gravida;
	
	@XmlElement(name = "ARTStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar artStartDate;
	
	@XmlElement(name = "DateOfDelivery")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfDelivery;
	
	@XmlElement(name = "FamilyPlanningCounselling")
	protected String familyPlanningCounselling;
	
	@XmlElement(name = "FamilyPlanningMethod")
	protected String familyPlanningMethod;
	
	public String getVisitID() {
		return visitID;
	}
	
	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
	
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	public void setVisitDate(XMLGregorianCalendar visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getViralLoadPeriod() {
		return viralLoadPeriod;
	}
	
	public void setViralLoadPeriod(String viralLoadPeriod) {
		this.viralLoadPeriod = viralLoadPeriod;
	}
	
	public XMLGregorianCalendar getSampleCollectionDate() {
		return sampleCollectionDate;
	}
	
	public void setSampleCollectionDate(XMLGregorianCalendar sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}
	
	public Double getViralLoadResult() {
		return viralLoadResult;
	}
	
	public void setViralLoadResult(Double viralLoadResult) {
		this.viralLoadResult = viralLoadResult;
	}
	
	public String getPmtctEntryPoint() {
		return pmtctEntryPoint;
	}
	
	public void setPmtctEntryPoint(String pmtctEntryPoint) {
		this.pmtctEntryPoint = pmtctEntryPoint;
	}
	
	public Integer getGestationalAgeAtSampleCollection() {
		return gestationalAgeAtSampleCollection;
	}
	
	public void setGestationalAgeAtSampleCollection(Integer gestationalAgeAtSampleCollection) {
		this.gestationalAgeAtSampleCollection = gestationalAgeAtSampleCollection;
	}
	
	public Integer getGestationalAge() {
		return gestationalAge;
	}
	
	public void setGestationalAge(Integer gestationalAge) {
		this.gestationalAge = gestationalAge;
	}
	
	public String getTimingOfArtInitiation() {
		return timingOfArtInitiation;
	}
	
	public void setTimingOfArtInitiation(String timingOfArtInitiation) {
		this.timingOfArtInitiation = timingOfArtInitiation;
	}
	
	public Integer getTbStatus() {
		return tbStatus;
	}
	
	public void setTbStatus(Integer tbStatus) {
		this.tbStatus = tbStatus;
	}
	
	public Integer getGravida() {
		return gravida;
	}
	
	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}
	
	public XMLGregorianCalendar getArtStartDate() {
		return artStartDate;
	}
	
	public void setArtStartDate(XMLGregorianCalendar artStartDate) {
		this.artStartDate = artStartDate;
	}
	
	public XMLGregorianCalendar getDateOfDelivery() {
		return dateOfDelivery;
	}
	
	public void setDateOfDelivery(XMLGregorianCalendar dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	
	public String getFamilyPlanningCounselling() {
		return familyPlanningCounselling;
	}
	
	public void setFamilyPlanningCounselling(String familyPlanningCounselling) {
		this.familyPlanningCounselling = familyPlanningCounselling;
	}
	
	public String getFamilyPlanningMethod() {
		return familyPlanningMethod;
	}
	
	public void setFamilyPlanningMethod(String familyPlanningMethod) {
		this.familyPlanningMethod = familyPlanningMethod;
	}
}
