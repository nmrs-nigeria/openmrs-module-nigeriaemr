package org.openmrs.module.nigeriaemr.model;

import org.openmrs.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "nigeriaemr.NDRExportBatch")
@Table(name = "nigeriaemr_ndr_batch_export")
public class NDRExportBatch {
	
	@Id
	@GeneratedValue
	@Column(name = "nigeriaemr_ndr_batch_export_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Column(name = "total_number_of_patients_processed")
	private Integer patientsProcessed;
	
	@Column(name = "total_number_of_patients")
	private Integer patients;
	
	@Column(name = "date_started")
	private Date dateStarted;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "date_updated")
	private Date dateUpdated;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "last_export_date")
	private Date lastExportDate;
	
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
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getLastExportDate() {
		return lastExportDate;
	}
	
	public void setLastExportDate(Date lastExportDate) {
		this.lastExportDate = lastExportDate;
	}
}
