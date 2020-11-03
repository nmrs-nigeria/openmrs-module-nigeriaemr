package org.openmrs.module.nigeriaemr.page.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.stereotype.Controller;

/**
 * Spring MVC controller that takes over /index.htm and processes requests to show the home page so
 * users don't see the legacy OpenMRS UI
 */
@Controller
public class BiometricformPageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * @should limit which apps are shown on the homepage based on location
	 */
	public Object controller(PageModel model) {
		
		String url = Utils.getBiometricServerBaseURL();
		if (url == null || url.isEmpty())
			url = "http://localhost:2018/api/FingerPrint";
		model.addAttribute("biometricUrl", url);
		model.addAttribute("authenticatedUser", Context.getAuthenticatedUser());
		if (Context.getAuthenticatedUser() != null) {
			model.addAttribute("authenticatedUserId", Context.getAuthenticatedUser().getId());
		}
		return null;
	}
	
}
