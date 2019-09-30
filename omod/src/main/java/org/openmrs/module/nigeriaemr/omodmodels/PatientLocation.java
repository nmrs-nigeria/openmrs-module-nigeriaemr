/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

/**
 * @author MORRISON.I
 */
public class PatientLocation {
	
	private Integer patient_id;
	
	private Integer location_id;
	
	public Integer getPatient_id() {
		return patient_id;
	}
	
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	
	public Integer getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
}
