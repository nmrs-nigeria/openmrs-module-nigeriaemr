package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.PatientService;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientService extends PatientService {
	
	@Authorized({ "Get All Patient within an index" })
	List<Patient> getPatientsInIndex(int startIndex, int endIndex) throws APIException;
	
	@Authorized()
	List<Integer> getPatientIdsInIndex(int startIndex, int endIndex) throws APIException;
	
	@Authorized({ "Get Patients" })
	List<Patient> getPatients(List<Integer> patientIds) throws APIException;
	
	@Authorized({ "Get Patients By Encounter Date" })
	List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate) throws APIException;
	
	@Authorized({ "Get Patients By Encounter Date" })
	List<Integer> getPatientIdsByEncounterDate(Date fromDate, Date toDate) throws APIException;
	
	@Authorized()
	List<Patient> getPatientsByEncounterDate(int startIndex, int endIndex, Date lastEncounterDate) throws APIException;
	
}
