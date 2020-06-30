package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Obs;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.ObsDAO;

import java.util.List;

public interface NigeriaObsDAO extends ObsDAO {
	
	public List<Obs> getObs(List<Integer> obsIds, boolean includeVoided) throws DAOException;
	
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws DAOException;
	
	public List<Obs> getObsByEncounterType(List<Integer> obsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws DAOException;
}
