package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.EncounterService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface NigeriaEncounterService extends EncounterService {
	
	@Authorized({ "Get Encounters By Patient Id From the last run date" })
	List<Encounter> getEncountersByPatient(Patient patient, Date from, Date to) throws APIException;
	
}
