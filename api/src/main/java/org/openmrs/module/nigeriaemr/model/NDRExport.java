/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also NigeriaemrDaoTest and liquibase.xml
@Entity(name = "nigeriaemr.NDRExport")
@Table(name = "nigeriaemr_ndr_export")
public class NDRExport {
	
	@Id
	@GeneratedValue
	@Column(name = "nigeriaemr_ndr_export_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "total_number_of_patients_processed")
	private Integer patientsProcessed;
	
	@Column(name = "total_number_of_patients")
	private Integer patients;
	
	@Column(name = "date_started")
	private Date dateStarted;
	
	@Column(name = "date_ended")
	private Date dateEnded;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "voided")
	private boolean voided;
	
	@Column(name = "context_path")
	private String contextPath;
	
	@Column(name = "report_folder")
	private String reportFolder;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public Integer getPatientsProcessed() {
		return patientsProcessed;
	}
	
	public void setPatientsProcessed(Integer patientsProcessed) {
		this.patientsProcessed = patientsProcessed;
	}
	
	public Integer getPatients() {
		return patients;
	}
	
	public void setPatients(Integer patients) {
		this.patients = patients;
	}
	
	public Date getDateStarted() {
		return dateStarted;
	}
	
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	public Date getDateEnded() {
		return dateEnded;
	}
	
	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isVoided() {
		return voided;
	}
	
	public void setVoided(boolean voided) {
		this.voided = voided;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContextPath() {
		return contextPath;
	}
	
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public String getReportFolder() {
		return reportFolder;
	}
	
	public void setReportFolder(String reportFolder) {
		this.reportFolder = reportFolder;
	}
}
