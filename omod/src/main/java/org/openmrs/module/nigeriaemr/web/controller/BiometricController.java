package org.openmrs.module.nigeriaemr.web.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/nigeriaemr/pbs")
public class BiometricController extends MainResourceController {
	
	@RequestMapping(value = "/{patientId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getBiometricByPatientId(@PathVariable("patientId") String patientId, HttpServletResponse response) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		try {
			Patient patient = Context.getPatientService().getPatientByUuid(patientId);
			if (patient == null) {
				patient = Context.getPatientService().getPatient(Integer.parseInt(patientId));
			}
			List<BiometricInfo> biometricInfoList = nigeriaemrService.getBiometricInfoByPatientId(patient.getId());
			if (biometricInfoList != null && biometricInfoList.size() > 0) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return biometricInfoList;
			} else {
				SimpleObject ret = new SimpleObject();
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				ret.put("ErrorMessage", "No Biometric data found");
				ret.put("IsSuccessful", false);
				return ret;
			}
		}
		catch (Exception ex) {
			SimpleObject ret = new SimpleObject();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			ret.put("ErrorMessage", ex.getMessage());
			ret.put("IsSuccessful", false);
			return ret;
		}
	}
	
	@RequestMapping(value = "/{patientId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteBiometricByPatientId(@PathVariable("patientId") String patientId, HttpServletResponse response) {
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		try {
			Patient patient = Context.getPatientService().getPatientByUuid(patientId);
			if (patient == null) {
				patient = Context.getPatientService().getPatient(Integer.parseInt(patientId));
			}
			nigeriaemrService.deleteBiometricInfoByPatientId(patient.getId());
			SimpleObject ret = new SimpleObject();
			response.setStatus(HttpServletResponse.SC_OK);
			ret.put("ErrorMessage", "Successful");
			ret.put("IsSuccessful", true);
			return ret;
		}
		catch (Exception ex) {
			SimpleObject ret = new SimpleObject();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			ret.put("ErrorMessage", ex.getMessage());
			ret.put("IsSuccessful", false);
			return ret;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public SimpleObject getBiometricByPatientId(@RequestBody Map<String, Object> body, HttpServletResponse response) {
		SimpleObject ret = new SimpleObject();
		try {
			List<Object> fingerPrintList = (List<Object>) body.get("FingerPrintList");
			if (fingerPrintList.size() < 6) {
				ret.put("ErrorMessage", "Biometric must contain 6 or more fingers");
				ret.put("IsSuccessful", false);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return ret;
			}
			
			String patientUUID = (String) body.get("PatientUUID");
			if (patientUUID != null) {
				Patient patient = Context.getPatientService().getPatientByUuid(patientUUID);
				if (patient != null) {
					NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
					for (Object obj : fingerPrintList) {
						Map<String, Object> map = (Map<String, Object>) obj;
						BiometricInfo biometricInfo = new BiometricInfo();
						
						if (map.get("DateCreated") != null) {
							biometricInfo.setDateCreated(getDate((String) map.get("DateCreated")));
						}
						if (map.get("FingerPositions") != null) {
							biometricInfo.setFingerPosition((String) map.get("FingerPositions"));
						}
						if (map.get("imageDPI") != null) {
							biometricInfo.setImageDPI((Integer) map.get("imageDPI"));
						}
						if (map.get("ImageHeight") != null) {
							biometricInfo.setImageHeight((Integer) map.get("ImageHeight"));
						}
						if (map.get("Manufacturer") != null) {
							biometricInfo.setManufacturer((String) map.get("Manufacturer"));
						}
						if (map.get("ImageQuality") != null) {
							biometricInfo.setImageQuality((Integer) map.get("ImageQuality"));
						}
						if (map.get("ImageWidth") != null) {
							biometricInfo.setImageWidth((Integer) map.get("ImageWidth"));
						}
						if (map.get("Model") != null) {
							biometricInfo.setModel((String) map.get("Model"));
						}
						if (map.get("Template") != null) {
							biometricInfo.setTemplate((String) map.get("Template"));
						}
						if (map.get("SerialNumber") != null) {
							biometricInfo.setSerialNumber((String) map.get("SerialNumber"));
						}
						biometricInfo.setPatientId(patient.getPatientId());
						nigeriaemrService.saveBiometricInfo(biometricInfo);
					}
				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					ret.put("ErrorMessage", "Invalid patientId supplied");
					ret.put("IsSuccessful", false);
					return ret;
				}
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				ret.put("ErrorMessage", "Invalid patientId supplied");
				ret.put("IsSuccessful", false);
				return ret;
			}
			response.setStatus(HttpServletResponse.SC_OK);
			ret.put("ErrorMessage", "Saved successfully");
			ret.put("IsSuccessful", true);
			return ret;
		}
		catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			ret.put("ErrorMessage", ex.getMessage());
			ret.put("IsSuccessful", false);
			return ret;
		}
	}
	
	private Date getDate(String dateString) {
		try {
			String[] dateSplit = dateString.split("\\.");
			return new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateSplit[0]).getTime());
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
}
