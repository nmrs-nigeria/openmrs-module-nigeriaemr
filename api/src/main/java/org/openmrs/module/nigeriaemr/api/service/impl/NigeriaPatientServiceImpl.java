package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.PatientServiceImpl;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaPatientDAO;
import org.openmrs.module.nigeriaemr.api.service.NigeriaPatientService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class NigeriaPatientServiceImpl extends PatientServiceImpl implements NigeriaPatientService {
	
	private NigeriaPatientDAO dao;
	
	public void setDao(NigeriaPatientDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Patient> getPatientsInIndex(int startIndex, int endIndex) throws APIException {
		return dao.getPatients(startIndex, endIndex, false);
	}
	
	@Override
	public List<Patient> getPatients(List<Integer> patientIds) throws APIException {
		return dao.getPatients(patientIds, false);
	}
}
