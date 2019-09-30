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
public class FacilityLocation {
	
	private Integer id;
	
	private String uuid;
	
	private Integer location_id;
	
	private String datimCode;
	
	private String facility_name;
	
	private Date date_created;
	
	private String creator;
	
	private Date date_modified;
	
	private String modified_by;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Integer getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	public String getDatimCode() {
		return datimCode;
	}
	
	public void setDatimCode(String datimCode) {
		this.datimCode = datimCode;
	}
	
	public String getFacility_name() {
		return facility_name;
	}
	
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	
	public Date getDate_created() {
		return date_created;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
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
