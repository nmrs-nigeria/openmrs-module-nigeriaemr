package org.openmrs.module.nigeriaemr.api.dao;

import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.PatientDAO;
import org.openmrs.PatientIdentifier;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientDAO extends PatientDAO {
	
	public String getPatientIdentifier(Integer patientId, Integer identifierType) throws DAOException;
}
