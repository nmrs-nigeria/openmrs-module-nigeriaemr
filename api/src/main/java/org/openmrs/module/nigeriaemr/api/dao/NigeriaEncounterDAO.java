package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.EncounterDAO;

import java.util.Date;
import java.util.List;

public interface NigeriaEncounterDAO extends EncounterDAO {
	
	List<Encounter> getEncountersByPatient(Patient patient, Date fromDate, Date toDate) throws DAOException;
	
	List<Encounter> getEncountersByEncounterDate(Date fromDate, Date toDate) throws DAOException;
	
	Encounter getLastEncounterByPatient(Patient patient, Date fromDate, Date toDate) throws DAOException;
	
	List<Encounter> getEncountersByEncounterTypeIds(Patient patient, Date fromDate, Date toDate,
	        List<Integer> encounterTypeIds, boolean asc, int size) throws DAOException;
	
	List<Encounter> getEncountersByEncounterIds(List<Integer> encounterIds) throws DAOException;
	
	Encounter getEncounterByEncounterType(Patient patient, int encounterTypeId) throws DAOException;
}
