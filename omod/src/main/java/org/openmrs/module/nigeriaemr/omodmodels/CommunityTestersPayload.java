/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

/**
 * @author MORRISON.I
 */
public class CommunityTestersPayload {
	
	public String Username;
	
	private String community_tester_guid;
	
	public String Email;
	
	public String PhoneNumber;
	
	public String AssignedFacilityId;
	
	public String FacilityName;
	
	public String FacilityCode;
	
	public String State;
	
	public String Lga;
	
	public String LgaCode;
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String Username) {
		this.Username = Username;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}
	
	public String getAssignFacilityID() {
		return AssignedFacilityId;
	}
	
	public void setAssignFacilityID(String AssignFacilityID) {
		this.AssignedFacilityId = AssignFacilityID;
	}
	
	public String getFacilityName() {
		return FacilityName;
	}
	
	public void setFacilityName(String FacilityName) {
		this.FacilityName = FacilityName;
	}
	
	public String getFacilityCode() {
		return FacilityCode;
	}
	
	public void setFacilityCode(String FacilityCode) {
		this.FacilityCode = FacilityCode;
	}
	
	public String getState() {
		return State;
	}
	
	public void setState(String State) {
		this.State = State;
	}
	
	public String getLga() {
		return Lga;
	}
	
	public void setLga(String Lga) {
		this.Lga = Lga;
	}
	
	public String getLgaCode() {
		return LgaCode;
	}
	
	public void setLgaCode(String LgaCode) {
		this.LgaCode = LgaCode;
	}
	
	public String getCommunity_tester_guid() {
		return community_tester_guid;
	}
	
	public void setCommunity_tester_guid(String community_tester_guid) {
		this.community_tester_guid = community_tester_guid;
	}
	
	public String getAssignedFacilityId() {
		return AssignedFacilityId;
	}
	
	public void setAssignedFacilityId(String AssignedFacilityId) {
		this.AssignedFacilityId = AssignedFacilityId;
	}
	
}
