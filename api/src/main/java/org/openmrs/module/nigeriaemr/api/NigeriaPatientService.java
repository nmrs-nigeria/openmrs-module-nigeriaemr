package org.openmrs.module.nigeriaemr.api;

import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.PatientService;
import org.openmrs.PatientIdentifier;

import java.util.Date;
import java.util.List;

public interface NigeriaPatientService extends PatientService {
	
	@Authorized({ "Get Patients Identifier By Identifier Type" })
	String getPatientIdentifier(Integer patientId, Integer identifierType) throws APIException;
}
