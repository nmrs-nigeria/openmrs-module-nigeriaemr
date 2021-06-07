/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.page.controller;

import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;
import org.openmrs.module.nigeriaemr.service.CommunityTesters;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MORRISON.I
 */
public class CommunityTesterPageController {
	
	//create community testers
	public String post(@SpringBean CommunityTesters ctService, @RequestParam("newtester") TesterModel newtester) {
		//CommunityTesters ctService = new CommunityTesters();
		
		if (newtester != null) {
			ctService.createTesters(newtester);
			return "Community Tester created successfully!";
		} else {
			return "Invalid object in request";
		}
	}
	
	//get all community testers
	public void get(@SpringBean CommunityTesters ctService, PageModel pageModel) {
		//ObjectMapper mapper = new ObjectMapper();
		
		try {
			pageModel.put("testers", ctService.getAllCommunityTesters());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//pull community testers from the web.
	public String reloadTester(@SpringBean CommunityTesters ctService) {
		
		try {
			ctService.refreshCommunityTesterList();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "The data was refreshed successfully";
		
	}
	
}
