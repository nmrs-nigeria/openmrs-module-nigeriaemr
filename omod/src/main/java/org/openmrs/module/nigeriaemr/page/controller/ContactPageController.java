/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.page.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.UUID;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.PatientContactsModel;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;
import org.openmrs.module.nigeriaemr.service.CommunityTesters;
import org.openmrs.module.nigeriaemr.service.PatientContacts;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MORRISON.I
 */
public class ContactPageController {
	
	public String post(@SpringBean PatientContacts pcService, @RequestParam("index_patient_id") String index_patient_id,
	        @RequestParam("relationship") String relationship, @RequestParam("age") String age,
	        @RequestParam("sex") String sex, @RequestParam("preferred_testing_location") String preferred_testing_location,
	        @RequestParam("state") String state, @RequestParam("lga") String lga, @RequestParam("town") String town,
	        @RequestParam("village") String village, @RequestParam("physically_abused") String physically_abused,
	        @RequestParam("forced_sexually") String forced_sexually,
	        @RequestParam("fear_their_partner") String fear_their_partner,
	        @RequestParam("notification_method") String notification_method,
	        @RequestParam("more_information") String more_information,
	        @RequestParam("assign_contact_to_cec") String assign_contact_to_cec,
	        @RequestParam("community_tester_guid") String community_tester_guid,
	        @RequestParam("community_tester_name") String community_tester_name,
	        @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
		
		String responseMsg = "";
		try {
			
			PatientContactsModel newcontact = new PatientContactsModel();
			newcontact.setAge(Integer.parseInt(age));
			newcontact.setAssign_contact_to_cec(resolveYesNo(assign_contact_to_cec));
			if (assign_contact_to_cec.equals("Yes")) {
				newcontact.setCommunity_tester_name(community_tester_name);
				newcontact.setCommunity_tester_guid(community_tester_guid);
			}
			
			newcontact.setCountry("Nigeria");
			newcontact.setDate_created(new Date());
			newcontact.setFear_their_partner(fear_their_partner);
			newcontact.setForced_sexually(forced_sexually);
			newcontact.setIndex_patient_id(Integer.parseInt(index_patient_id));
			newcontact.setLga(lga);
			newcontact.setMore_information(more_information);
			newcontact.setNotification_method(notification_method);
			newcontact.setPhysically_abused(physically_abused);
			newcontact.setPreferred_testing_location(preferred_testing_location);
			newcontact.setRelationship(relationship);
			newcontact.setSex(sex);
			newcontact.setState(state);
			newcontact.setTown(town);
			newcontact.setUuid(UUID.randomUUID().toString());
			newcontact.setVillage(village);
			newcontact.setTrace_status("pending");
			newcontact.setDatim_code(Utils.getFacilityDATIMId());
			newcontact.setCreated_by(Context.getUserContext().getAuthenticatedUser().getUsername());
			newcontact.setCode(Context.getPatientService().getPatient(Integer.parseInt(index_patient_id))
			        .getPatientIdentifier(8).getIdentifier());
			newcontact.setFirstname(firstname);
			newcontact.setLastname(lastname);
			
			pcService.createContacts(newcontact);
			
			responseMsg = "Patient created successfully!";
		}
		catch (Exception ex) {
			ex.printStackTrace();
			responseMsg = "Error occurred, try again";
		}
		return responseMsg;
	}
	
	public String getIndexClientContacts(@SpringBean PatientContacts pcService,
	        @RequestParam("indexClientId") int indexClientId) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(pcService.getAllPatientContactsByIndexId(indexClientId));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private int resolveYesNo(String strValue) {
		if (strValue.equals("Yes")) {
			return 1;
		}
		return 0;
	}
	
	public void get(@SpringBean PatientContacts pcService, @SpringBean CommunityTesters ctService, PageModel pageModel) {
		try {
			
			pageModel.put("testers", ctService.getAllCommunityTesters());
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
