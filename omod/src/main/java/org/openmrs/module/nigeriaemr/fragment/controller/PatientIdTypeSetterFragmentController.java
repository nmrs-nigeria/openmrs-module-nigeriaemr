package org.openmrs.module.nigeriaemr.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.omodmodels.AjaxResponseBody;
import org.openmrs.module.nigeriaemr.omodmodels.PatientIdentifierData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PatientIdTypeSetterFragmentController {
	
	public @ResponseBody
	AjaxResponseBody setPidType(@RequestParam(value = "patientId") int patientId,
	        @RequestParam(value = "identifierType") int identifierType,
	        @RequestParam(value = "isPreferred") boolean isPreferred,
	        @RequestParam(value = "patientIdentifier") String patientIdentifier) {
		PatientService pService = Context.getPatientService();
		AjaxResponseBody result = new AjaxResponseBody();
		try {
			
			if (patientId < 1) {
				result.message = "The request payload is empty;";
				result.code = -1;
				return result;
			}
			
			Patient patient = pService.getPatient(patientId);
			if (patient != null) {
				PatientIdentifier pId = patient.getPatientIdentifier(identifierType);
				pId.setPreferred(isPreferred);
				result.message = "Patient information was successfully updated";
				result.code = 5;
				pService.savePatient(patient);
				return result;
			} else {
				result.message = "Patient information could not be found";
				result.code = -1;
				return result;
			}
		}
		catch (Exception e) {
			result.message = e.getMessage();
			result.code = -1;
			return result;
		}
	}
	
	public @ResponseBody
	AjaxResponseBody getIdentifier(@RequestParam(value = "patientId") int patientId,
	        @RequestParam(value = "identifierType") int identifierType) {
		PatientService pService = Context.getPatientService();
		AjaxResponseBody res = new AjaxResponseBody();
		try {
			if (patientId < 1) {
				res.message = "Patient Id is invalid";
				res.code = -1;
				return res;
			}
			
			Patient patient = pService.getPatient(patientId);
			if (patient != null) {
				res.code = 5;
				PatientIdentifier identifier = patient.getPatientIdentifier(identifierType);
				res.preferred = identifier.isPreferred();
				res.identifier = identifier.getIdentifier();
				return res;
			} else {
				res.message = "An error was encountered";
				res.code = -1;
				return res;
			}
		}
		catch (Exception e) {
			res.message = "Patient Id is invalid";
			res.code = -1;
			return res;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	AjaxResponseBody setPid(@RequestParam PatientIdentifierData pdata, HttpServletRequest request) {
		PatientService pService = Context.getPatientService();
		AjaxResponseBody result = new AjaxResponseBody();
		try {
			if (pdata == null) {
				result.message = "The request payload is empty;";
				result.code = -1;
				return result;
			}
			Patient patient = pService.getPatient(pdata.patientId);
			if (patient != null) {
				PatientIdentifier pId = patient.getPatientIdentifier(pdata.identifierType);
				pId.setPreferred(pdata.isPreferred);
				result.message = "Patient information was successfully updated";
				result.code = 5;
				pService.savePatient(patient);
				return result;
			} else {
				result.message = "Patient information could not be found";
				result.code = -1;
				return result;
			}
		}
		catch (Exception e) {
			result.message = e.getMessage();
			result.code = -1;
			return result;
		}
	}
}
