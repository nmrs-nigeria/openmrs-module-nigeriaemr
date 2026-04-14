package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.context.AppContextModel;
import org.openmrs.module.nigeriaemr.dbmanager.*;
import org.openmrs.module.nigeriaemr.ndrUtils.CleanPayLoadJson;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.DataSnycResponse;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.openmrs.module.referenceapplication.ReferenceApplicationConstants;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.appui.UiSessionContext;
import org.springframework.web.bind.annotation.RequestParam;

public class PimsFragmentController {
	
	Gson gson = new Gson();
	
	NdrDBManager ndr = new NdrDBManager();
	
	protected final Log log = LogFactory.getLog(getClass());
	
	Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	
	public Object controller(PageModel model, @SpringBean("appFrameworkService") AppFrameworkService appFrameworkService,
	        UiSessionContext sessionContext) {
		
		AppContextModel contextModel = sessionContext.generateAppContextModel();
		
		model.addAttribute("extensions", appFrameworkService.getExtensionsForCurrentUser(
		    ReferenceApplicationConstants.HOME_PAGE_EXTENSION_POINT_ID, contextModel));
		model.addAttribute("authenticatedUser", Context.getAuthenticatedUser());
		
		return null;
	}
	
	public String getTransitPatientUUIDs(HttpServletRequest request) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.getTransitPatientUUIDs();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return p;
	}
	
	/*****
	 * PUSH DATA TO THE PIMS API END POINT
	 ******/
	
	public String pushDataToPIMS(@RequestParam(value = "payload") String payload, @RequestParam(value = "token") String token) {
		
		//System.out.println("Payload-------------------------- " + payload);
		DataSnycResponse fpr = null;
		
		try {
			fpr = pushData(payload, token);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return gs.toJson(fpr.getMessage());
	}
	
	public DataSnycResponse pushData(String pr, String token) throws Exception {
		token = "Bearer " + token;
		Unirest unirest = new Unirest();
		//configure UniRest to use Gson Object mapper
		configureUnirest(unirest);
		System.out.println("token: " + token);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		//String data = gs.toJson(pr);
		
		//System.out.println("data: " + data);
		
		//System.out.println("pr: " + pr);
		
		HttpResponse<String> response = unirest.post("https://pimssandbox.phis3project.org.ng/api/Transactions/quest")
		        .header("Authorization", token).header("Content-Type", "application/json").body(pr).asString();
		
		System.out.println("response " + response.getStatus());
		
		if (response != null && response.getStatus() == 200) {
			System.out.println(response.getBody());
			return new DataSnycResponse(response.getStatus(), response.getBody(), true);
		}
		
		if (response != null && response.getStatus() == 401) {
			System.out.println(response.getBody());
			return new DataSnycResponse(response.getStatus(),
			        "{\"code\":5,\"message\":\"Unauthorized-Access\",\"enrollments\":[]}", true);
		}
		
		System.out.println("REQUEST FAILED");
		System.out.println(response.getBody());
		return new DataSnycResponse(response.getStatus(), "{\"code\":5,\"message\":\"REQUEST FAILED: " + response.getBody()
		        + " STATUS CODE: " + response.getStatus() + "\",\"enrollments\":[]}", false);
		
	}
	
	private void configureUnirest(Unirest unirest) {
		unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
			
			private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			
			@Override
			public <T> T readValue(String value, Class<T> valueType) {
				return gson.fromJson(value, valueType);
			}
			
			@Override
			public String writeValue(Object value) {
				return gson.toJson(value);
			}
		});
	}
	
	public String getFaciiityID(HttpServletRequest request) {
		String p = "";
		try {
			p = Utils.getFacilityDATIMId();
		}
		catch (Exception e) {}
		return gson.toJson(p);
	}
	
	public String getFacilityName(HttpServletRequest request) {
		String p = "";
		try {
			p = Utils.getFacilityName();
		}
		catch (Exception e) {}
		return gson.toJson(p);
	}
	
	/*****
	 * PULL DATA FROM THE PIMS API END POINT
	 ******/
	
	public String pullDataFromPIMS(@RequestParam(value = "primaryDatimeCode") String primaryDatimeCode,
	        @RequestParam(value = "startDate") String startDate, @RequestParam(value = "page") String page,
	        @RequestParam(value = "size") String size) {
		
		System.out
		        .println("Insde pull data --------------------------------------------------------------------------------");
		DataSnycResponse fpr = null;
		
		try {
			fpr = pullData(primaryDatimeCode, startDate, page, size);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return gs.toJson(fpr.getMessage());
	}
	
	public DataSnycResponse pullData(String primaryDatimeCode, String startDate, String page, String size) throws Exception {
		Unirest unirest = new Unirest();
		
		// Configure UniRest to use Gson ObjectMapper
		configureUnirest(unirest);
		//System.out.println("token: " + token);
		
		// Build the URL with query parameters
		String url = "https://pimssandbox.phis3project.org.ng/api/Transactions/getTransactions";
		String fullUrl = url + "?primaryDatimeCode=" + URLEncoder.encode(primaryDatimeCode, "UTF-8") + "&startDate="
		        + URLEncoder.encode(startDate, "UTF-8") + "&page=" + page + "&size=" + size;
		
		// Make the GET request
		HttpResponse<String> response = unirest.get(fullUrl).header("Accept", "application/json").asString();
		
		System.out.println("response " + response.getStatus());
		
		if (response != null && response.getStatus() == 200) {
			//System.out.println(response.getBody());
			String originalPayload = response.getBody();
			
			//System.out.println(originalPayload);
			
			String cleanPayload = CleanPayLoadJson.getCleanJSON(originalPayload);
			
			String cleaned = cleanPayload.replaceAll("\\\\r\\\\n", "") // Remove literal \r\n
			        .replaceAll("[\\r\\n]", "") // Remove actual newlines
			        .replaceAll("\\\\", ""); // Remove all backslashes
			
			return new DataSnycResponse(response.getStatus(), cleanPayload, true);
		}
		
		if (response != null && response.getStatus() == 401) {
			System.out.println(response.getBody());
			return new DataSnycResponse(response.getStatus(), "{\"code\":5,\"message\":\"Unauthorized-Access\",\"\":[]}",
			        true);
		}
		
		System.out.println("REQUEST FAILED");
		System.out.println(response.getBody());
		
		return new DataSnycResponse(response.getStatus(), "{\"code\":5,\"message\":\"REQUEST FAILED: " + response.getBody()
		        + " STATUS CODE: " + response.getStatus() + "\",\"\":[]}", false);
	}
	
	public String getTokenPIMS(HttpServletRequest request) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.getPIMSToken();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return p;
	}
	
	public String getPatientUUID(@RequestParam(value = "clientid") String clientid) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.getPatientUUID(clientid);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
	public String updatePIMSLastPushDate(@RequestParam(value = "lastpushdate") String lastpushdate) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.updatePIMSLastPushDate(lastpushdate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
	public String updatePIMSLastPullDate(@RequestParam(value = "lastpulldate") String lastpulldate) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.updatePIMSLastPullDate(lastpulldate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
	public String getPIMSLastPullDate(HttpServletRequest request) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.getPIMSLastPullDate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return p;
	}
	
	public String resolveOBSgroupIssueART(@RequestParam(value = "patientUUID") String patientUUID,
	        @RequestParam(value = "encounterType") String encounterType,
	        @RequestParam(value = "encounterDatetime") String encounterDatetime) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.resolveOBSgroupIssueART(patientUUID, encounterType, encounterDatetime);
			ndr.resolveOBSgroupIssueART162240(patientUUID, encounterType, encounterDatetime);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
	public String resolveOBSgroupIssueOI(@RequestParam(value = "patientUUID") String patientUUID,
	        @RequestParam(value = "encounterType") String encounterType,
	        @RequestParam(value = "encounterDatetime") String encounterDatetime) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.resolveOBSgroupIssueOI(patientUUID, encounterType, encounterDatetime);
			ndr.resolveOBSgroupIssueOI165726(patientUUID, encounterType, encounterDatetime);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
	public String checkDuplicateEncounterAtSyc(@RequestParam(value = "patientUUID") String patientUUID,
	        @RequestParam(value = "encounterType") String encounterType,
	        @RequestParam(value = "encounterDatetime") String encounterDatetime) {
		String p = "";
		try {
			ndr.openConnection();
			p = ndr.checkDuplicateEncounterAtSyc(patientUUID, encounterType, encounterDatetime);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ndr.closeConnection();
		}
		return gson.toJson(p);
	}
	
}
