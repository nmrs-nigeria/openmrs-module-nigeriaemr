package org.openmrs.module.nigeriaemr.ndrUtils;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class Validator implements ValidationEventHandler {
	
	//private FileManager mgr;
	boolean skipError;
	
	public Validator(boolean skipError) {
		this.skipError = skipError;
	}
	
	public Validator() {
		this.skipError = true;
	}
	
	@Override
	public boolean handleEvent(ValidationEvent event) {
		return skipError;
	}
	
	public void project(ValidationEvent event) throws Throwable {
		throw event.getLinkedException();
	}
	
}
