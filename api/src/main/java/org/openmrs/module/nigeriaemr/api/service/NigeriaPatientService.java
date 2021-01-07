package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.PatientService;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientService extends PatientService {
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Patient> getPatientsInIndex(int startIndex, int endIndex) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Integer> getPatientIdsInIndex(int startIndex, int endIndex) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Patient> getPatients(List<Integer> patientIds) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Integer> getPatientsFromStringIds(List<String> patientIds, Date fromDate, Date toDate) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Integer> getPatientIdsByEncounterDate(Date fromDate, Date toDate) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Patient> getPatientsByEncounterDate(int startIndex, int endIndex, Date lastEncounterDate) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	String getPatientIdentifier(Patient patient, PatientIdentifierType patientIdentifierType) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Integer> getPatientIdsByIdentifiers(List<String> identifiers, Date fromDate, Date toDate) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	String getPatientIdentifierByPatientsId(Integer patientId, Integer identifierType) throws APIException;
	
}
