/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

import org.apache.xpath.operations.Bool;

import java.io.Serializable;

/**
 * @author Henry.O
 */

public class PatientIdentifierData implements Serializable {
	
	public Integer patientId;
	
	public String patientIdentifier;
	
	public Integer identifierType;
	
	public Boolean isPreferred;
	
	public Integer getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	
	public Integer getIdentifierType() {
		return identifierType;
	}
	
	public void setIdentifierType(Integer identifierType) {
		this.identifierType = identifierType;
	}
	
	public Boolean getPreferred() {
		return isPreferred;
	}
	
	public void setPreferred(Boolean preferred) {
		isPreferred = preferred;
	}
}
