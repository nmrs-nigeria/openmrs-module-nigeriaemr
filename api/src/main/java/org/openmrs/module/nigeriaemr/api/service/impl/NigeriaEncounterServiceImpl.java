package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.*;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.EncounterServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaEncounterDAO;
import org.openmrs.module.nigeriaemr.api.service.NigeriaEncounterService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class NigeriaEncounterServiceImpl extends EncounterServiceImpl implements NigeriaEncounterService {
	
	private NigeriaEncounterDAO dao;
	
	public void setDao(NigeriaEncounterDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Encounter> getEncountersByPatient(Patient patient, Date from, Date to) throws APIException {
		List<Encounter> encounters;
		encounters = dao.getEncountersByPatient(patient, from, to);
		if (encounters == null) {
			return new ArrayList<Encounter>();
		}
		return encounters;
	}
}
