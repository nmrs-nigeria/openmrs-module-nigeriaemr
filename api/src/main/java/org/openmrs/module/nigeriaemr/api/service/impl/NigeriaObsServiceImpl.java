package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Person;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.ObsServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaObsDAO;
import org.openmrs.module.nigeriaemr.api.service.NigeriaObsService;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;
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
	
	@Override
	public Obs getLastObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided)
	        throws APIException {
		Obs obs = null;
		try {
			obs = dao.getLastObsByConceptId(person, concept, from, to, includeVoided, false);
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
			    LoggerUtils.LogLevel.live);
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
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
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
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		return obs;
	}
	
	@Override
	public Obs getObsbyValueCoded(Concept concept, Concept valueCoded, List<Integer> obsList) throws APIException {
		Obs obs = null;
		try {
			obs = dao.getObsbyValueCoded(concept, valueCoded, obsList);
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		return obs;
	}
	
	@Override
	public Obs getLastObsByConcept(Concept concept, List<Integer> obsList) throws APIException {
		Obs obs = null;
		try {
			obs = dao.getObsbyValueCoded(concept, null, obsList);
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		return obs;
	}
	
	@Override
	public List<Obs> getObsByConcept(Concept concept, List<Integer> obsList) throws APIException {
		List<Obs> obs = null;
		try {
			obs = dao.getObsByConcept(concept, obsList);
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		return obs;
	}
	
	@Override
	public List<Obs> getObsByConcept(List<Concept> concept, List<Integer> obsList) throws APIException {
		List<Obs> obs = null;
		try {
			obs = dao.getObsByConcept(concept, obsList);
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaObsServiceImpl.class.getName(), e.getMessage(), LoggerUtils.LogFormat.FATAL,
			    LoggerUtils.LogLevel.live);
		}
		return obs;
	}
	
	@Override
	public List<Obs> getObsByVisitDate(Date visitDate, List<Integer> obsIds, boolean includeVoided) throws APIException {
		return dao.getObsByVisitDate(visitDate, obsIds, false);
	}
	
	@Override
	public List<Concept> getConcepts(List<Integer> conceptIds, boolean includeVoided) throws APIException {
		return dao.getConcepts(conceptIds, includeVoided);
	}
	
	@Override
	public List<Integer> getPatientsByObsDate(Date from, Date to, List<String> patientIds, boolean includeVoided)
	        throws APIException {
		return dao.getPatientsByObsDate(from, to, patientIds, includeVoided);
	}
	
	@Override
	public List<Integer> getPatientEncounterIdsByDate(Integer id, Date fromDate, Date toDate) throws APIException {
		return dao.getPatientEncounterIdsByDate(id, fromDate, toDate);
	}
}
