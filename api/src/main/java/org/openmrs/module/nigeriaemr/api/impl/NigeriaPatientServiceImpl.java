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
	public List<Patient> getPatientsInIndex(int startIndex, int endIndex) throws APIException {
		return dao.getPatients(startIndex, endIndex, false);
	}
	
	@Override
	public List<Integer> getPatientIdsInIndex(int startIndex, int endIndex) throws APIException {
		return dao.getPatientIds(startIndex, endIndex, false);
	}
	
	@Override
	public String getPatientIdentifier(Integer patientId, Integer identifierType) throws APIException {
		return dao.getPatientIdentifier(patientId, identifierType, false);
	}
	
	@Override
	public List<Patient> getPatientsByEncounterDate(int startIndex, int endIndex, Date lastEncounterDate)
	        throws APIException {
		return dao.getPatientsByEncounterDate(startIndex, endIndex, lastEncounterDate, false);
	}
	
	@Override
	public List<Patient> getPatients(List<Integer> patientIds) throws APIException {
		return dao.getPatients(patientIds, false);
	}
	
	@Override
	public List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate) throws APIException {
		return dao.getPatientsByEncounterDate(fromDate, toDate, false);
	}
	
	@Override
	public List<Integer> getPatientIdsByEncounterDate(Date fromDate, Date toDate) throws APIException {
		return dao.getPatientIdsByEncounterDate(fromDate, toDate, false);
	}
}
