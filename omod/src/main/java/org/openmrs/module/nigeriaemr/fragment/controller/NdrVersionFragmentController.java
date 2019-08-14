package org.openmrs.module.nigeriaemr.fragment.controller;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.Version;
import org.openmrs.ui.framework.SimpleObject;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NdrVersionFragmentController {
	
	public void controller() {
		
	}
	
	public String getVersionNumber(HttpServletRequest request) {
		Version version = null;
		try {
			version = Utils.getNmrsVersion();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		return gson.toJson(version);
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
