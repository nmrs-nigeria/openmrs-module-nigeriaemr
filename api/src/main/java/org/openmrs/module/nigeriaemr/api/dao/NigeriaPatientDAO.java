package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.PatientDAO;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientDAO extends PatientDAO {
	
	public List<Patient> getPatients(Integer startId, Integer endId, boolean includeVoided) throws DAOException;

	public List<Integer> getPatientIds(Integer startId, Integer endId, boolean includeVoided) throws DAOException;
	
	public List<Patient> getPatients(List<Integer> patientIds, boolean includeVoided) throws DAOException;
	
	public List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException;

	public List<Integer> getPatientIdsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException;

	public List<Patient> getPatientsByEncounterDate(int startIndex, int endIndex, Date lastEncounterDate, boolean includeVoided) throws DAOException;
}
