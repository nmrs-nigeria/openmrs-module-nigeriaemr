package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Person;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.ObsDAO;

import java.util.Date;
import java.util.List;

public interface NigeriaObsDAO extends ObsDAO {
	
	public List<Obs> getObs(List<Integer> obsIds, boolean includeVoided) throws DAOException;
	
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws DAOException;
	
	public Obs getLastObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException;
	
	public List<Obs> getObsByEncounterType(List<Integer> obsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws DAOException;
	
	public Obs getHighestObsByConcept(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException;
}
