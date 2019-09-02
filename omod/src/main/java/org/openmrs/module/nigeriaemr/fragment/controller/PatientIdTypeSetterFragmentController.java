package org.openmrs.module.nigeriaemr.fragment.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.User;
import org.openmrs.api.PatientService;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.PatientServiceImpl;
import org.openmrs.module.nigeriaemr.omodmodels.AjaxResponseBody;
import org.openmrs.module.nigeriaemr.omodmodels.PatientIdentifierData;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
			ServletInputStream s = request.getInputStream();
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
