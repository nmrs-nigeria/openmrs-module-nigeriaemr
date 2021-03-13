package org.openmrs.module.nigeriaemr.page.controller;

import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.ui.framework.page.PageModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomNdrPageController {
	
	public Object controller(PageModel model) {
		String lastNDRRunDate = Utils.getLastNDRDateString();
		if (lastNDRRunDate != null && !lastNDRRunDate.isEmpty()) {
			String[] dateOnly = lastNDRRunDate.trim().split(" ");
			if (dateOnly.length > 0) {
				model.addAttribute("lastNDRRunDate", dateOnly[0]);
			}
		}
		return null;
	}
}
