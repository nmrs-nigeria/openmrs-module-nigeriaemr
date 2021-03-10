package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.PatientDAO;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientDAO extends PatientDAO {
	
	List<Patient> getPatients(Integer startId, Integer endId, boolean includeVoided) throws DAOException;
	
	List<Integer> getPatientIds(Integer startId, Integer endId, boolean includeVoided) throws DAOException;
	
	List<Patient> getPatients(List<Integer> patientIds, boolean includeVoided) throws DAOException;
	
	List<Integer> getPatientsFromStringIds(List<String> patientIds, Date fromDate, Date toDate, boolean includeVoided)
	        throws DAOException;
	
	List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException;
	
	List<Integer> getPatientIdsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException;
	
	List<Integer> getPatientIdsByIdentifiers(List<String> identifiers, Date fromDate, Date toDate) throws DAOException;
	
	List<Patient> getPatientsByEncounterDate(int startIndex, int endIndex, Date lastEncounterDate, boolean includeVoided)
	        throws DAOException;
	
	String getPatientIdentifier(Patient patient, PatientIdentifierType patientIdentifierType) throws DAOException;
	
	String getPatientIdentifierByPatientsId(Integer patientId, Integer identifierType) throws DAOException;
	
	List<Integer> getPatientIdsByIdentifiersByType(String identifier, Integer identifierType) throws DAOException;
}
