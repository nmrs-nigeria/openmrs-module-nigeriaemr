package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Obs;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.ObsService;
import java.util.List;

public interface NigeriaObsService extends ObsService {
	
	@Authorized({ "Get Obs by conceptID" })
	List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws APIException;
	
	@Authorized({ "Get Obs by encounters" })
	List<Obs> getObsByEncounters(List<Integer> encounterIds, boolean includeVoided) throws APIException;
	
	@Authorized({ "Get Obs by encounterTypes" })
	List<Obs> getObsByEncounterTypes(List<Integer> ObsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws APIException;
	
}
