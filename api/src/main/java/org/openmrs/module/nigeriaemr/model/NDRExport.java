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
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also NigeriaemrDaoTest and liquibase.xml
@Entity(name = "nigeriaemr.NDRExport")
@Table(name = "nigeriaemr_ndr_export")
public class NDRExport implements Serializable {
	
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
	
	@Column(name = "last_date")
	private Date lastDate;
	
	@Column(name = "date_updated")
	private Date dateUpdated;
	
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
	
	@Column(name = "patients")
	private String patientsList;
	
	@Column(name = "error_patients")
	private String errorPatientsList;
	
	@Column(name = "batch_id")
	private Integer batchId;
	
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
	
	public Date getLastDate() {
		return lastDate;
	}
	
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	
	public String getPatientsList() {
		return patientsList;
	}
	
	public void setPatientsList(String patientsList) {
		this.patientsList = patientsList;
	}
	
	public Integer getBatchId() {
		return batchId;
	}
	
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public String getErrorPatientsList() {
		return errorPatientsList;
	}
	
	public void setErrorPatientsList(String errorPatientsList) {
		this.errorPatientsList = errorPatientsList;
	}
	
	@Override
	public String toString() {
		return "NDRExport [id=" + id + ", owner=" + owner + ", name=" + name + ", patientsProcessed=" + patientsProcessed
		        + ", patients=" + patients + ", dateStarted=" + dateStarted + ", lastDate=" + lastDate + ", dateUpdated="
		        + dateUpdated + ", dateEnded=" + dateEnded + ", path=" + path + ", status=" + status + ", voided=" + voided
		        + ", contextPath=" + contextPath + ", reportFolder=" + reportFolder + ", patientsList=" + patientsList
		        + ", errorPatientsList=" + errorPatientsList + ", batchId=" + batchId + "]";
	}
	
}
