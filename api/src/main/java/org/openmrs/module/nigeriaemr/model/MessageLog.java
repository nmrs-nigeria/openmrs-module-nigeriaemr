package org.openmrs.module.nigeriaemr.model;

import java.util.Date;

public class MessageLog {
	
	public long id;
	
	public String message;
	
	public String patientIdentifier;
	
	public String fileName;
	
	public Date dateCreated = null;
}
