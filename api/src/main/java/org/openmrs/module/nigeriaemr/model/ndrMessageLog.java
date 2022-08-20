package org.openmrs.module.nigeriaemr.model;

import org.openmrs.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "nigeriaemr.NdrMessageLog")
@Table(name = "ndr_message_logs")
public class ndrMessageLog {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "exportId")
	private Integer exportId;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "batchNumber")
	private String batchNumber;
	
	@Column(name = "patientIdentifier")
	private String patientIdentifier;
	
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "dateCreated")
	private Date dateCreated;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getBatchNumber() {
		return batchNumber;
	}
	
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	public Integer getExportId() {
		return exportId;
	}
	
	public void setExportId(Integer exportId) {
		this.exportId = exportId;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
