/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
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
