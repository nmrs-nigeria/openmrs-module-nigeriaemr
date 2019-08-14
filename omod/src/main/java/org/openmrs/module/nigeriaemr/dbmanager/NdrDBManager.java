/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.dbmanager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.getXmlDateTime;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.omodmodels.PatientContactsModel;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;
import org.openmrs.util.OpenmrsUtil;

/**
 * @author MORRISON.I
 */
public class NdrDBManager {
	
	Connection conn = null;
	
	PreparedStatement pStatement = null;
	
	private ResultSet resultSet = null;
	
	public NdrDBManager() {
		
	}
	
	public void openConnection() throws SQLException {
		DBConnection openmrsConn = Utils.getNmrsConnectionDetails();
		
		conn = DriverManager.getConnection(openmrsConn.getUrl(), openmrsConn.getUsername(), openmrsConn.getPassword());
	}
	
	public void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pStatement != null) {
				pStatement.close();
			}
		}
		catch (Exception ex) {
			
		}
	}
	
	public int createCommunityTester(TesterModel model) throws SQLException {
		pStatement = conn.prepareStatement("insert into " + ConstantsUtil.COMMUNITY_TESTER_TABLE
		        + "(username, email, phone_number, assign_facilityId, facility_name, facility_code, state, lga, "
		        + "lga_code, date_created, created_by,community_tester_guid)Values(?,?,?,?,?,?,?,?,?,NOW(),?,?)");
		pStatement.setString(1, model.getUsername());
		pStatement.setString(2, model.getEmail());
		pStatement.setString(3, model.getPhone_number());
		pStatement.setString(4, model.getAssign_facilityId());
		pStatement.setString(5, model.getFacility_name());
		pStatement.setString(6, model.getFacility_code());
		pStatement.setString(7, model.getState());
		pStatement.setString(8, model.getLga());
		pStatement.setString(9, model.getLga_code());
		// pStatement.setDate(10, (Date) model.getDate_created());
		pStatement.setString(10, model.getCreated_by());
		pStatement.setString(11, model.getCommunity_tester_guid());
		
		return pStatement.executeUpdate();
	}
	
	public List<TesterModel> getCommunityTesters() throws SQLException {
		
		pStatement = conn.prepareStatement("select * from " + ConstantsUtil.COMMUNITY_TESTER_TABLE);
		resultSet = pStatement.executeQuery();
		
		return convertResultsetToCommunityTesters(resultSet);
		
	}
	
	public void deleteAllCommunityTesters() throws SQLException {
		pStatement = conn.prepareStatement("DELETE FROM community_testers");
		pStatement.execute();
	}
	
	private List<TesterModel> convertResultsetToCommunityTesters(ResultSet resultSet) throws SQLException {
		List<TesterModel> testers = new ArrayList<TesterModel>();
		
		while (resultSet.next()) {
			TesterModel model = new TesterModel();
			
			model.setAssign_facilityId(resultSet.getString("assign_facilityId"));
			model.setCreated_by(resultSet.getString("created_by"));
			model.setDate_created(resultSet.getDate("date_created"));
			model.setDate_modified(resultSet.getDate("date_modified"));
			model.setEmail(resultSet.getString("email"));
			model.setFacility_code(resultSet.getString("facility_code"));
			model.setFacility_name(resultSet.getString("facility_name"));
			model.setId(resultSet.getInt("id"));
			model.setLga(resultSet.getString("lga"));
			model.setLga_code(resultSet.getString("lga_code"));
			model.setModified_by(resultSet.getString("modified_by"));
			model.setPhone_number(resultSet.getString("phone_number"));
			model.setState(resultSet.getString("state"));
			model.setUsername(resultSet.getString("username"));
			model.setCommunity_tester_guid(resultSet.getString("community_tester_guid"));
			
			testers.add(model);
		}
		
		return testers;
		
	}
	
	public int createPatientContacts(PatientContactsModel model) throws SQLException {
		
		pStatement = conn.prepareStatement("insert into " + ConstantsUtil.PATIENT_CONTACT_TABLE
		        + "(uuid, index_patient_id, relationship, age, sex, " + "preferred_testing_location, state, lga, town, "
		        + "village, physically_abused, forced_sexually, fear_their_partner, notification_method,"
		        + " more_information, assign_contact_to_cec, community_tester_name, date_created, "
		        + "created_by,code,datim_code,community_tester_guid,trace_status)"
		        + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?,?,?,?)");
		
		pStatement.setString(1, UUID.randomUUID().toString());
		pStatement.setInt(2, model.getIndex_patient_id());
		pStatement.setInt(3, model.getAge());
		pStatement.setString(4, model.getSex());
		pStatement.setString(5, model.getPreferred_testing_location());
		pStatement.setString(6, model.getState());
		pStatement.setString(7, model.getLga());
		pStatement.setString(8, model.getTown());
		pStatement.setString(9, model.getVillage());
		pStatement.setString(10, model.getPhysically_abused());
		pStatement.setString(11, model.getForced_sexually());
		pStatement.setString(12, model.getFear_their_partner());
		pStatement.setString(13, model.getNotification_method());
		pStatement.setString(14, model.getMore_information());
		pStatement.setInt(15, model.getAssign_contact_to_cec());
		pStatement.setString(16, model.getCommunity_tester_name());
		pStatement.setString(17, model.getCreated_by());
		pStatement.setString(18, model.getCode());
		pStatement.setString(19, model.getDatim_code());
		pStatement.setString(20, model.getCommunity_tester_guid());
		pStatement.setString(21, model.getTrace_status());
		
		return pStatement.executeUpdate();
	}
	
	public List<PatientContactsModel> getPatientContactsByIndex(int indexClientId) throws SQLException {
		
		pStatement = conn.prepareStatement("select * from " + ConstantsUtil.PATIENT_CONTACT_TABLE
		        + " where index_patient_id = ? ");
		ResultSet resultSet = pStatement.executeQuery();
		
		return convertResultsetsToPatientContacts(resultSet);
		
	}
	
	private List<PatientContactsModel> convertResultsetsToPatientContacts(ResultSet resultset) throws SQLException {
        
        List<PatientContactsModel> response = new ArrayList<>();
        
        while (resultset.next()) {
            
            PatientContactsModel pModel = new PatientContactsModel();
            pModel.setAge(resultset.getInt("age"));
            pModel.setAssign_contact_to_cec(resultset.getInt("assign_contact_to_cec"));
            pModel.setCommunity_tester_name(resultset.getString("community_tester_name"));
            pModel.setCountry(resultset.getString("country"));
            pModel.setCreated_by(resultset.getString("created_by"));
            pModel.setDate_created(resultset.getDate("date_created"));
            pModel.setDate_modified(resultset.getDate("date_modified"));
            pModel.setFear_their_partner(resultset.getString("fear_their_partner"));
            pModel.setForced_sexually(resultset.getString("forced_sexually"));
            pModel.setId(resultset.getInt("id"));
            pModel.setIndex_patient_id(resultset.getInt("index_patient_id"));
            pModel.setLga(resultset.getString("lga"));
            pModel.setModified_by(resultset.getString("modified_by"));
            pModel.setMore_information(resultset.getString("more_information"));
            pModel.setNotification_method(resultset.getString("notification_method"));
            pModel.setPhysically_abused(resultset.getString("physically_abused"));
            pModel.setPreferred_testing_location(resultset.getString("preferred_testing_location"));
            pModel.setRelationship(resultset.getString("relationship"));
            pModel.setSex(resultset.getString("sex"));
            pModel.setState(resultset.getString("state"));
            pModel.setTown(resultset.getString("town"));
            pModel.setUuid(resultset.getString("uuid"));
            pModel.setVillage(resultset.getString("village"));
            pModel.setCode(resultset.getString("code"));
            pModel.setDatim_code(resultset.getString("datim_code"));
            pModel.setCommunity_tester_guid(resultset.getString("community_tester_guid"));
            pModel.setTrace_status(resultset.getString("trace_status"));
            
            response.add(pModel);
            
        }
        
        return response;
        
    }
}
