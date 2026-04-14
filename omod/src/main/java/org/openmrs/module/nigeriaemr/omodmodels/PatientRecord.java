package org.openmrs.module.nigeriaemr.omodmodels;

import java.util.List;

public class PatientRecord {
	
	private String primaryDatimCode;
	
	private String secondaryDatimCode;
	
	private String clientIdentifier;
	
	private String primarySex;
	
	private String primaryDOB;
	
	private String secondaryTransitId;
	
	private String consent;
	
	private List<String> encounterDetails;
	
	// Getters and Setters
	
	public String getPrimaryDatimCode() {
		return primaryDatimCode;
	}
	
	public void setPrimaryDatimCode(String primaryDatimCode) {
		this.primaryDatimCode = primaryDatimCode;
	}
	
	public String getSecondaryDatimCode() {
		return secondaryDatimCode;
	}
	
	public void setSecondaryDatimCode(String secondaryDatimCode) {
		this.secondaryDatimCode = secondaryDatimCode;
	}
	
	public String getClientIdentifier() {
		return clientIdentifier;
	}
	
	public void setClientIdentifier(String clientIdentifier) {
		this.clientIdentifier = clientIdentifier;
	}
	
	public String getPrimarySex() {
		return primarySex;
	}
	
	public void setPrimarySex(String primarySex) {
		this.primarySex = primarySex;
	}
	
	public String getPrimaryDOB() {
		return primaryDOB;
	}
	
	public void setPrimaryDOB(String primaryDOB) {
		this.primaryDOB = primaryDOB;
	}
	
	public String getSecondaryTransitId() {
		return secondaryTransitId;
	}
	
	public void setSecondaryTransitId(String secondaryTransitId) {
		this.secondaryTransitId = secondaryTransitId;
	}
	
	public String getConsent() {
		return consent;
	}
	
	public void setConsent(String consent) {
		this.consent = consent;
	}
	
	public List<String> getEncounterDetails() {
		return encounterDetails;
	}
	
	public void setEncounterDetails(List<String> encounterDetails) {
		this.encounterDetails = encounterDetails;
	}
}
