/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openmrs.module.nigeriaemr.dbmanager.NdrDBManager;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.GeneralMapper;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.omodmodels.CommunityTestersPayload;
import org.openmrs.module.nigeriaemr.omodmodels.PatientContactsModel;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;

/**
 * @author MORRISON.I
 */
public class CommunityTesters {
	
	NdrDBManager dbManageer = null;
	
	public void createTesters(TesterModel cTesterModel) {
		
		if (cTesterModel != null) {
			try {
				dbManageer = new NdrDBManager();
				dbManageer.openConnection();
				cTesterModel.setCreated_by("Admin");
				dbManageer.createCommunityTester(cTesterModel);
				dbManageer.closeConnection();
			}
			catch (SQLException ex) {
				LoggerUtils.write(CommunityTesters.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
				    LoggerUtils.LogLevel.live);
			}
		}
	}
	
	public void createBulkTesters(List<TesterModel> cTesterModels, boolean deleteExisting) throws SQLException {
		
		dbManageer = new NdrDBManager();
		dbManageer.openConnection();
		if (deleteExisting) {
			dbManageer.deleteAllCommunityTesters();
		}
		for (TesterModel a : cTesterModels) {
			a.setCreated_by("Admin");
			dbManageer.createCommunityTester(a);
		}
		;
		dbManageer.closeConnection();
		
	}
	
	public List<TesterModel> getAllCommunityTesters() {
        List<TesterModel> response = new ArrayList<>();
        try {
            dbManageer = new NdrDBManager();
            dbManageer.openConnection();
            response = dbManageer.getCommunityTesters();
            dbManageer.closeConnection();
            return response;
        } catch (SQLException ex) {
            LoggerUtils.write(CommunityTesters.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL, LoggerUtils.LogLevel.live);
        }
        //return empty list
        return response;
    }
	
	public List<PatientContactsModel> getAssignedContacts(int testerId) {
		return null;
	}
	
	private List<CommunityTestersPayload> loadTestersFromWeb(String facilityId) throws UnirestException {
		//move this to proper location
		Unirest.setObjectMapper(GeneralMapper.getCustomObjectMapper());
		
		HttpResponse<CommunityTestersPayload[]> payloads = Unirest
		        .get(ConstantsUtil.BASE_URL + ConstantsUtil.GET_COMMUNITY_TESTER).header("accept", "application/json")
		        .queryString("datimCode", facilityId).asObject(CommunityTestersPayload[].class);
		
		if (payloads != null) {
			return Arrays.asList(payloads.getBody());
		}
		
		return Collections.emptyList();
	}
	
	public void refreshCommunityTesterList() throws UnirestException, SQLException {
		
		String duummyFacility = "mgic";
		//Utils.getFacilityDATIMId()
		
		List<CommunityTestersPayload> payload = loadTestersFromWeb(duummyFacility);
		if (!payload.isEmpty()) {
			
			//delete existing and insert.
			createBulkTesters(GeneralMapper.mapPayloadToCommunityTestersList(payload), true);
		}
		
	}
	
}
