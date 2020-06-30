package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.Obs;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.ObsServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaObsDAO;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class NigeriaObsServiceImpl extends ObsServiceImpl implements NigeriaObsService {
	
	private NigeriaObsDAO dao;
	
	public void setDao(NigeriaObsDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws APIException {
		return dao.getObsByConceptId(personId, conceptId, encounterIds, includeVoided);
	}
	
	@Override
	public List<Obs> getObsByEncounters(List<Integer> encounterIds, boolean includeVoided) throws APIException {
		return dao.getObsByConceptId(null, null, encounterIds, includeVoided);
	}
	
	@Override
	public List<Obs> getObsByEncounterTypes(List<Integer> ObsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws APIException {
		return dao.getObsByEncounterType(ObsIds, encounterTypeIds, includeVoided);
	}
}
