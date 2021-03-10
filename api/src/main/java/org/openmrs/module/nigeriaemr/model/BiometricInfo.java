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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.sql.Date;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */
//Uncomment 2 lines below if you want to make the Item class persistable, see also NigeriaemrDaoTest and liquibase.xml
@Entity(name = "nigeriaemr.BiometricInfo")
@Table(name = "biometricinfo")
public class BiometricInfo {
	
	@Id
	@Column(name = "biometricInfo_Id")
	private Integer biometricInfoId;
	
	@Column(name = "patient_Id")
	private Integer patientId;
	
	@Column(name = "template")
	private String template;
	
	@Column(name = "new_template")
	private Blob newTemplate;
	
	@Column(name = "imageWidth")
	private Integer imageWidth;
	
	@Column(name = "imageHeight")
	private Integer imageHeight;
	
	@Column(name = "imageDPI")
	private Integer imageDPI;
	
	@Column(name = "imageQuality")
	private Integer imageQuality;
	
	@Column(name = "fingerPosition")
	private String fingerPosition;
	
	@Column(name = "serialNumber")
	private String serialNumber;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "creator")
	private Integer creator;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	public Integer getBiometricInfoId() {
		return biometricInfoId;
	}
	
	public void setBiometricInfoId(Integer biometricInfoId) {
		this.biometricInfoId = biometricInfoId;
	}
	
	public Integer getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public String getTemplate() {
		if (getNewTemplate() != null) {
			Blob blob = getNewTemplate();
			try {
				byte[] blobData = blob.getBytes(1, (int) blob.length());
				setNewTemplate(null);
				return new String(blobData);
			}
			catch (Exception ex) {}
		}
		return template;
	}
	
	public void setTemplate(String template) {
		this.template = template;
	}
	
	public Integer getImageWidth() {
		return imageWidth;
	}
	
	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	public Integer getImageHeight() {
		return imageHeight;
	}
	
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	public Integer getImageDPI() {
		return imageDPI;
	}
	
	public void setImageDPI(Integer imageDPI) {
		this.imageDPI = imageDPI;
	}
	
	public Integer getImageQuality() {
		return imageQuality;
	}
	
	public void setImageQuality(Integer imageQuality) {
		this.imageQuality = imageQuality;
	}
	
	public String getFingerPosition() {
		return fingerPosition;
	}
	
	public void setFingerPosition(String fingerPosition) {
		this.fingerPosition = fingerPosition;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Integer getCreator() {
		return creator;
	}
	
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Blob getNewTemplate() {
		return newTemplate;
	}
	
	public void setNewTemplate(Blob newTemplate) {
		this.newTemplate = newTemplate;
	}
}
