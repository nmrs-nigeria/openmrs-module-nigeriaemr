package org.openmrs.module.nigeriaemr.ndrUtils;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class CustomErrorHandler implements ErrorHandler {
	
	private File file;
	
	//private FileManager mgr;
	public CustomErrorHandler() {
		/*
		//mgr=new FileManager();
		//String[] headers={"ErrorFileName","ErrorLine","ErrorPosition","ErrorMessages"};
		try {
		    //mgr.createCSVWriter("errorlog.csv");
		    //mgr.writeCSVHeaders(headers);

		} catch (IOException ex) {
		    ex.printStackTrace();
		}*/
	}
	
	@Override
	public void warning(SAXParseException exception) throws SAXException {
		handleMessage("Warning", exception);
	}
	
	@Override
	public void error(SAXParseException exception) throws SAXException {
		handleMessage("Error", exception);
	}
	
	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		handleMessage("Fatal", exception);
	}
	
	private void handleMessage(String level, SAXParseException exception) throws SAXParseException, SAXException {
		//int lineNumber = exception.getLineNumber();
		//int columnNumber = exception.getColumnNumber();
		//String message = exception.getMessage();
		//String url=exception.
		//throw new SAXException("[" + level + "] line nr: " + lineNumber + " column nr: " + columnNumber + " message: " + message);
		//SAXException ex=exception;
		//throw ex;
		String[] errorArr = new String[4];
		errorArr[0] = exception.getSystemId();
		errorArr[1] = String.valueOf(exception.getLineNumber());
		errorArr[2] = String.valueOf(exception.getColumnNumber());
		errorArr[3] = exception.getMessage();
		System.out.println("ID: " + errorArr[0] + " Line no: " + errorArr[1] + " Column No: " + errorArr[2] + " Message: "
		        + errorArr[3]);
		//mgr.writeHeader(errorArr);
		
	}
	
	public void closeMgr() throws IOException {
		// mgr.closeCSVWriter();
	}
	
}
