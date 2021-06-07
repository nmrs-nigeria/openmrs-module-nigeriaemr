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
public class TesterModel {
	
	private int id;
	
	private String username;
	
	private String facility_name;
	
	private String assign_facilityId;
	
	private String community_tester_guid;
	
	private String facility_code;
	
	private String state;
	
	private String lga;
	
	private String lga_code;
	
	private String phone_number;
	
	private String email;
	
	private Date date_created;
	
	private String created_by;
	
	private Date date_modified;
	
	private String modified_by;
	
	public String getCommunity_tester_guid() {
		return community_tester_guid;
	}
	
	public void setCommunity_tester_guid(String community_tester_guid) {
		this.community_tester_guid = community_tester_guid;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFacility_name() {
		return facility_name;
	}
	
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	
	public String getAssign_facilityId() {
		return assign_facilityId;
	}
	
	public void setAssign_facilityId(String assign_facilityId) {
		this.assign_facilityId = assign_facilityId;
	}
	
	public String getFacility_code() {
		return facility_code;
	}
	
	public void setFacility_code(String facility_code) {
		this.facility_code = facility_code;
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
	
	public String getLga_code() {
		return lga_code;
	}
	
	public void setLga_code(String lga_code) {
		this.lga_code = lga_code;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
}
