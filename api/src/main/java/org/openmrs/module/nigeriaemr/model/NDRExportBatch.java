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
	
	@Column(name = "date_ended")
	private Date dateEnded;
	
	@Column(name = "date_updated")
	private Date dateUpdated;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "error_path")
	private String errorPath;
	
	@Column(name = "error_list")
	private String errorList;
	
	@Column(name = "last_export_date")
	private Date lastExportDate;
	
	@Column(name = "context_path")
	private String contextPath;
	
	@Column(name = "report_folder")
	private String reportFolder;
	
	@Column(name = "voided")
	private boolean voided;
	
	@Column(name = "automatic")
	private boolean automatic;
	
	@Column(name = "ndr_batch_ids")
	private String ndrBatchIds;
	
	@Column(name = "errorLogsPulled")
	private String errorLogsPulled;
	
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
		if (patientsProcessed == null)
			return 0;
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
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
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
	
	public Date getDateEnded() {
		return dateEnded;
	}
	
	public void setDateEnded(Date dateEnded) {
		this.dateEnded = dateEnded;
	}
	
	public boolean isVoided() {
		return voided;
	}
	
	public void setVoided(boolean voided) {
		this.voided = voided;
	}
	
	public String getErrorPath() {
		return errorPath;
	}
	
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}
	
	public String getErrorList() {
		return errorList;
	}
	
	public void setErrorList(String errorList) {
		this.errorList = errorList;
	}
	
	public boolean isAutomatic() {
		return automatic;
	}
	
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	
	public String getNdrBatchIds() {
		return ndrBatchIds;
	}
	
	public void setNdrBatchIds(String ndrBatchIds) {
		this.ndrBatchIds = ndrBatchIds;
	}
	
	public String getErrorLogsPulled() {
		return errorLogsPulled;
	}
	
	public void setErrorLogsPulled(String errorLogsPulled) {
		this.errorLogsPulled = errorLogsPulled;
	}
	
	@Override
	public String toString() {
		return "NDRExportBatch [id=" + id + ", owner=" + owner + ", patientsProcessed=" + patientsProcessed + ", patients="
		        + patients + ", dateStarted=" + dateStarted + ", dateCreated=" + dateCreated + ", dateEnded=" + dateEnded
		        + ", dateUpdated=" + dateUpdated + ", status=" + status + ", name=" + name + ", path=" + path
		        + ", errorPath=" + errorPath + ", errorList=" + errorList + ", lastExportDate=" + lastExportDate
		        + ", contextPath=" + contextPath + ", reportFolder=" + reportFolder + ", voided=" + voided + ", automatic="
		        + automatic + ", ndrBatchIds=" + ndrBatchIds + ", errorLogsPulled=" + errorLogsPulled + "]";
	}
	
}
