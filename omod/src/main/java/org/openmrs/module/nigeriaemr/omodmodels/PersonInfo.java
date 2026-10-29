package org.openmrs.module.nigeriaemr.omodmodels;

public class PersonInfo {
	
	String uuid;
	
	String birthdate;
	
	String primarydatimcode;
	
	String primaryclientid;
	
	String transitid;
	
	String gender;
	
	String secondarydatimcode;
	
	String encounters;
	
	String secfacilityname;
	
	public PersonInfo(String uuid, String birthdate, String primarydatimcode, String primaryclientid, String transitid,
	    String gender, String secondarydatimcode, String encounters, String secfacilityname) {
		this.uuid = uuid;
		this.birthdate = birthdate;
		this.primarydatimcode = primarydatimcode;
		this.primaryclientid = primaryclientid;
		this.transitid = transitid;
		this.gender = gender;
		this.secondarydatimcode = secondarydatimcode;
		this.encounters = encounters;
		this.secfacilityname = secfacilityname;
	}
}
