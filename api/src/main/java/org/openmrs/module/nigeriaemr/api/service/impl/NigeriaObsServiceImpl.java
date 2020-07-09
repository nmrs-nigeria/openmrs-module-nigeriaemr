package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Person;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.ObsServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaObsDAO;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class NigeriaObsServiceImpl extends ObsServiceImpl implements NigeriaObsService {
	
	private NigeriaObsDAO dao;
	
	public void setDao(NigeriaObsDAO dao) {
		this.dao = dao;
	}
	
	@Override
	@Cacheable(value = "obs")
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws APIException {
		return dao.getObsByConceptId(personId, conceptId, encounterIds, includeVoided);
	}
	
	@Override
	@Cacheable(value = "obs")
	public List<Obs> getObsByEncounters(List<Integer> encounterIds, boolean includeVoided) throws APIException {
		return dao.getObsByConceptId(null, null, encounterIds, includeVoided);
	}
	
	@Override
	@Cacheable(value = "obs")
	public List<Obs> getObsByEncounterTypes(List<Integer> ObsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws APIException {
		return dao.getObsByEncounterType(ObsIds, encounterTypeIds, includeVoided);
	}
	
	@Override
	public Obs getLastObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided)
	        throws APIException {
		Obs obs = null;
		try {
			obs = dao.getLastObsByConceptId(person, concept, from, to, includeVoided, false);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obs;
	}
	
	@Override
	public Obs getFirstObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided)
	        throws APIException {
		Obs obs = null;
		try {
			obs = dao.getLastObsByConceptId(person, concept, from, to, includeVoided, true);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obs;
	}
	
	@Override
	public Obs getHighestObsByConcept(Person person, Concept concept, Date from, Date to, boolean includeVoided)
	        throws APIException {
		Obs obs = null;
		try {
			obs = dao.getHighestObsByConcept(person, concept, from, to, false, false);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obs;
	}
}
