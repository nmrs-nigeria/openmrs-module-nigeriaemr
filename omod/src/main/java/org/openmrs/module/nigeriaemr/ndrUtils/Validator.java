package org.openmrs.module.nigeriaemr.ndrUtils;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class Validator implements ValidationEventHandler {
	
	//private FileManager mgr;
	
	public Validator() {
		//mgr=new FileManager();
		/* try {
		     //mgr.createCSVWriter("errorslog.csv");
		 } catch (IOException ex) {
		     ex.printStackTrace();
		 }
		 //String[] headers={"SEVERITY","MESSAGE","LINKED EXCEPTION","LINE NO","COLUMN NO","OFFSET","OBJECT","NODE","URL"};
		 //mgr.writeHeader(headers);*/
	}
	
	@Override
	public boolean handleEvent(ValidationEvent event) {
		System.out.println("\nEVENT");
		System.out.println("SEVERITY:  " + event.getSeverity());
		System.out.println("MESSAGE:  " + event.getMessage());
		System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
		System.out.println("LOCATOR");
		System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
		System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
		System.out.println("    OFFSET:  " + event.getLocator().getOffset());
		System.out.println("    OBJECT:  " + event.getLocator().getObject());
		System.out.println("    NODE:  " + event.getLocator().getNode());
		System.out.println("    URL:  " + event.getLocator().getURL());
		
		/*String[] errors=new String[9];
		errors[0]=String.valueOf(event.getSeverity());
		errors[1]=event.getMessage();
		errors[2]=event.getLinkedException().getMessage();
		errors[3]=String.valueOf(event.getLocator().getLineNumber());
		errors[4]=String.valueOf(event.getLocator().getColumnNumber());
		errors[5]=String.valueOf(event.getLocator().getOffset());
		errors[6]=String.valueOf(event.getLocator().getObject());
		errors[7]=String.valueOf(event.getLocator().getNode());
		errors[8]=String.valueOf(event.getLocator().getURL());
		mgr.writeHeader(errors);*/
		
		return true;
	}
	
	public void project(ValidationEvent event) throws Throwable {
		
		throw event.getLinkedException();
	}
	
}
