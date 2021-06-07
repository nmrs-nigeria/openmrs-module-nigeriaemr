/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

import java.util.Date;

/**
 * @author MORRISON.I
 */
public class PatientContactsModel {
	
	private int id;
	
	private String uuid;
	
	private int index_patient_id;
	
	private String firstname;
	
	private String lastname;
	
	private String code;
	
	private String datim_code;
	
	private String relationship;
	
	private int age;
	
	private String sex;
	
	private String preferred_testing_location;
	
	private String state;
	
	private String lga;
	
	private String town;
	
	private String village;
	
	private String physically_abused;
	
	private String forced_sexually;
	
	private String fear_their_partner;
	
	private String notification_method;
	
	private String more_information;
	
	private int assign_contact_to_cec;
	
	private String community_tester_name;
	
	private String community_tester_guid;
	
	private String country;
	
	private Date date_created;
	
	private String created_by;
	
	private Date date_modified;
	
	private String modified_by;
	
	private String trace_status;
	
	public String getTrace_status() {
		return trace_status;
	}
	
	public void setTrace_status(String trace_status) {
		this.trace_status = trace_status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public int getIndex_patient_id() {
		return index_patient_id;
	}
	
	public void setIndex_patient_id(int index_patient_id) {
		this.index_patient_id = index_patient_id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPreferred_testing_location() {
		return preferred_testing_location;
	}
	
	public void setPreferred_testing_location(String preferred_testing_location) {
		this.preferred_testing_location = preferred_testing_location;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLga() {
		return lga;
	}
	
	public void setLga(String lga) {
		this.lga = lga;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getVillage() {
		return village;
	}
	
	public void setVillage(String village) {
		this.village = village;
	}
	
	public String getPhysically_abused() {
		return physically_abused;
	}
	
	public void setPhysically_abused(String physically_abused) {
		this.physically_abused = physically_abused;
	}
	
	public String getForced_sexually() {
		return forced_sexually;
	}
	
	public void setForced_sexually(String forced_sexually) {
		this.forced_sexually = forced_sexually;
	}
	
	public String getFear_their_partner() {
		return fear_their_partner;
	}
	
	public void setFear_their_partner(String fear_their_partner) {
		this.fear_their_partner = fear_their_partner;
	}
	
	public String getNotification_method() {
		return notification_method;
	}
	
	public void setNotification_method(String notification_method) {
		this.notification_method = notification_method;
	}
	
	public String getMore_information() {
		return more_information;
	}
	
	public void setMore_information(String more_information) {
		this.more_information = more_information;
	}
	
	public int getAssign_contact_to_cec() {
		return assign_contact_to_cec;
	}
	
	public void setAssign_contact_to_cec(int assign_contact_to_cec) {
		this.assign_contact_to_cec = assign_contact_to_cec;
	}
	
	public String getCommunity_tester_name() {
		return community_tester_name;
	}
	
	public void setCommunity_tester_name(String community_tester_name) {
		this.community_tester_name = community_tester_name;
	}
	
	public Date getDate_created() {
		return date_created;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public String getCreated_by() {
		return created_by;
	}
	
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	public Date getDate_modified() {
		return date_modified;
	}
	
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	
	public String getModified_by() {
		return modified_by;
	}
	
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDatim_code() {
		return datim_code;
	}
	
	public void setDatim_code(String datim_code) {
		this.datim_code = datim_code;
	}
	
	public String getCommunity_tester_guid() {
		return community_tester_guid;
	}
	
	public void setCommunity_tester_guid(String community_tester_guid) {
		this.community_tester_guid = community_tester_guid;
	}
	
}
