/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

/**
 * @author MORRISON.I
 */
public class PatientLocationAggregate {
	
	private Integer patient_count;
	
	private Integer location_id;
	
	private String name;
	
	public Integer getPatient_count() {
		return patient_count;
	}
	
	public void setPatient_count(Integer patient_count) {
		this.patient_count = patient_count;
	}
	
	public Integer getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
