package org.openmrs.module.nigeriaemr.api.impl;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.PatientServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaPatientDAO;
import org.openmrs.module.nigeriaemr.api.NigeriaPatientService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class NigeriaPatientServiceImpl extends PatientServiceImpl implements NigeriaPatientService {
	
	private NigeriaPatientDAO dao;
	
	public void setDao(NigeriaPatientDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String getPatientIdentifier(Integer patientId, Integer identifierType) throws APIException {
		return dao.getPatientIdentifier(patientId, identifierType);
	}
}
