package org.openmrs.module.nigeriaemr.page.controller;

import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.ui.framework.page.PageModel;

public class CustomNdrPageController {
	
	public Object controller(PageModel model) {
		model.addAttribute("lastNDRRunDate", Utils.getLastNDRDateString());
		return null;
	}
}
