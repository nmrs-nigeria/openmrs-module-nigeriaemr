/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.util;

import org.openmrs.api.context.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author MORRISON.I
 */
public class LoggerUtils {
	
	public static final String EXPORT_PATH = "export_logs";
	
	public static final String NMRS_LOGGER_PROPERTY = "nmrs_logger";
	
	public static final String GLOBAL_PROPERTY_TABLENAME = "global_property";
	
	//debug and live
	public static final String DEFAULT_LOGGER_GLOBAL_PROP_VALUE = "debug";
	
	public static final String DEFAULT_LOGGER_GLOBAL_PROP_DESCRIPTION = "This property is used for control the nigeria emr logger level, the value can be debug or live";
	
	public static final String PATIENT_LIMIT_PROPERTY = "patient_id_limit";
	
	public static final String DEFAULT_PATIENT_LIMIT_VALUE = "1,10";
	
	public static final String DEFAULT_PATIENT_LIMIT_GLOBAL_PROP_DESCRIPTION = "This property is used to control the number of patient to be export by the nmrs-ndr extraction tool";
	
	public static FileHandler getHandler() {
		
		try {
			
			String folder = Paths.get(System.getProperty("user.home"), "NMRS_LOGS").toString(); //request.getRealPath(request.getContextPath()) + "\\reports";
			
			File dir = new File(folder);
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			Path completePath = Paths.get(folder, "logs_" + dateString + ".log");
			if (!Files.exists(completePath)) {
				File ff = new File(completePath.toString());
			}
			
			FileHandler handler = new FileHandler(completePath.toString());
			
			//logger.addHandler(handler);
			SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
			
			return handler;
		}
		catch (Exception ex) {
			Logger.getLogger(LoggerUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
		
	}
	
	private static void log(String className, String logText, LogFormat formater, LogLevel level) throws IOException {
		
		//   Path folder = Paths.get(System.getProperty("user.home"), "NMRS_LOGS");
		String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		Path completePath = Paths.get(getExportPath(), "logs_" + dateString + ".log");
		
		if (!Files.exists(completePath)) {
			Files.createFile(completePath);
		}
		try {
			
			BufferedWriter bWriter = Files.newBufferedWriter(completePath, Charset.forName("UTF-8"),
			    StandardOpenOption.APPEND);
			bWriter.write(((LogFormat) formater).name() + ":" + className + ":" + new Date().toString() + " :" + logText
			        + "\r\n");
			bWriter.flush();
			bWriter.close();
		}
		catch (IOException ex) {
			Logger.getLogger(LoggerUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void write(String className, String logText, LogFormat formater, LogLevel level) {
		
		try {
			//if it's live
			log(className, logText, formater, level);
			
		}
		catch (Exception ex) {
			Logger.getLogger(LoggerUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
	public static void clearLogFile() {
		
		try {
			//	String folder = Paths.get(System.getProperty("user.home"), "NMRS_LOGS").toString();
			File dir = new File(getExportPath());
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			String dateString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			Path completePath = Paths.get(getExportPath(), "logs_" + dateString + ".log");
			
			Files.deleteIfExists(completePath);
			
			if (!completePath.toFile().exists()) {
				Files.createFile(completePath);
			}
			
		}
		catch (IOException ex) {
			Logger.getLogger(LoggerUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static String getExportPath() {
		return Paths.get(System.getProperty("user.home"), "NMRS_LOGS").toString();
	}
	
	public enum LogFormat {
		WARNING, FATAL, INFO, DEBUG
	}
	
	public enum LogLevel {
		debug, live
	}
	
	public static String getIPShortName() {
		return Context.getAdministrationService().getGlobalProperty("nigeriaemr_logger_config");
	}
	
	public static String getCurrentInstanceLogLevel() {
		return Context.getAdministrationService().getGlobalProperty(NMRS_LOGGER_PROPERTY);
	}
}
