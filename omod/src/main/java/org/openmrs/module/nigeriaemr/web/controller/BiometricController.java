package org.openmrs.module.nigeriaemr.web.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/nigeriaemr")
public class BiometricController extends BaseRestController {
	
	@RequestMapping(value = "/pbs/{patientId}", method = RequestMethod.GET)
	public HttpServletResponse getBiometricByPatientId(@PathVariable("patientId") String patientId,
	        HttpServletRequest request, HttpServletResponse response) {
		SimpleObject ret = new SimpleObject();
		NigeriaemrService nigeriaemrService = Context.getService(NigeriaemrService.class);
		
		List<BiometricInfo> biometricInfoList = nigeriaemrService.getBiometricInfoByPatientId(Integer.parseInt(patientId));
		ret.put("drugRoutes", biometricInfoList);
		response.setStatus(HttpServletResponse.SC_OK);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public SimpleObject getBiometricByPatientId(@RequestBody Map<String, Object> body, HttpServletRequest request,
	        HttpServletResponse response) {
		SimpleObject ret = new SimpleObject();
		List<Object> fingerPrintList = (List<Object>) body.get("FingerPrintList");
		if (fingerPrintList.size() < 6) {
			ret.put("ErrorMessage", "Biometric must contain 6 or more fingers");
			ret.put("success", false);
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
			}
		}
		response.setStatus(HttpServletResponse.SC_CREATED);
		ret.put("message", "Saved");
		ret.put("success", true);
		return ret;
	}
	
	private Date getDate(String dateString) {
		try {
			String[] dateSplit = dateString.split("\\.");
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateSplit[0]);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
}
