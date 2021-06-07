package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Person;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.ObsDAO;

import java.util.Date;
import java.util.List;

public interface NigeriaObsDAO extends ObsDAO {
	
	List<Obs> getObs(List<Integer> obsIds, boolean includeVoided) throws DAOException;
	
	List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws DAOException;
	
	Obs getLastObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException;
	
	List<Obs> getObsByEncounterType(List<Integer> obsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws DAOException;
	
	Obs getHighestObsByConcept(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException;
	
	List<Obs> getObsByVisitDate(Date visitDate, List<Integer> obsIds, boolean includeVoided) throws DAOException;
	
	Obs getObsbyValueCoded(Concept concept, Concept valueCoded, List<Integer> obsList) throws DAOException;
	
	List<Obs> getObsByConcept(Concept concept, List<Integer> obsList) throws DAOException;
	
	List<Obs> getObsByConcept(List<Concept> concept, List<Integer> obsList) throws DAOException;
	
	List<Concept> getConcepts(List<Integer> conceptIds, boolean includeVoided) throws DAOException;
	
	List<Integer> getPatientsByObsDate(Date from, Date to, List<String> patientIds, boolean includeVoided)
	        throws DAOException;
	
	List<Integer> getPatientEncounterIdsByDate(Integer id, Date fromDate, Date toDate) throws DAOException;
}
