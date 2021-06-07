package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.EncounterService;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface NigeriaEncounterService extends EncounterService {
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Encounter> getEncountersByPatient(Patient patient, Date from, Date to) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	Encounter getLastEncounterByPatient(Patient patient, Date from, Date to) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Encounter> getEncountersByEncounterTypeIds(Patient patient, Date fromDate, Date toDate,
	        List<Integer> encounterTypeIds) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	Encounter getLastEncounterByEncounterTypeIds(Patient patient, Date fromDate, Date toDate, List<Integer> encounterTypeIds)
	        throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<Encounter> getEncountersByEncounterIds(List<Integer> encounterIds) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	Encounter getEncounterByEncounterType(Patient patient, int encounterTypeId) throws APIException;
}
