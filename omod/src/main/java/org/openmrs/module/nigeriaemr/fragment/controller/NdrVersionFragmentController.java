package org.openmrs.module.nigeriaemr.fragment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.Version;
import org.openmrs.ui.framework.SimpleObject;

import javax.servlet.http.HttpServletRequest;

public class NdrVersionFragmentController {
	
	public void controller() {
		
	}
	
	public String getVersionNumber(HttpServletRequest request) {
		Version version = null;
		String response = "";
		try {
			version = Utils.getNmrsVersion();
			ObjectMapper mapper = new ObjectMapper();
			response = mapper.writeValueAsString(version);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public SimpleObject getVersionNumberAsObject(HttpServletRequest request) {
		Version version = null;
		try {
			version = Utils.getNmrsVersion();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return SimpleObject.fromObject(version, null, new String[] {});
	}
}
