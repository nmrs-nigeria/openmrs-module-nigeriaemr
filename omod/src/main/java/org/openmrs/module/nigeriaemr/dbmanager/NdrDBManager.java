/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.omodmodels.FacilityLocation;
import org.openmrs.module.nigeriaemr.omodmodels.PatientContactsModel;
import org.openmrs.module.nigeriaemr.omodmodels.PatientLocation;
import org.openmrs.module.nigeriaemr.omodmodels.PatientLocationAggregate;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;

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
		        + " more_information, assign_contact_to_cec, community_tester_name, "
		        + "created_by,code,datim_code,community_tester_guid,trace_status,country,firstname,lastname)"
		        + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),date_createdd)");
		
		pStatement.setString(1, UUID.randomUUID().toString());
		pStatement.setInt(2, model.getIndex_patient_id());
		pStatement.setString(3, model.getRelationship());
		pStatement.setInt(4, model.getAge());
		pStatement.setString(5, model.getSex());
		pStatement.setString(6, model.getPreferred_testing_location());
		pStatement.setString(7, model.getState());
		pStatement.setString(8, model.getLga());
		pStatement.setString(9, model.getTown());
		pStatement.setString(10, model.getVillage());
		pStatement.setString(11, model.getPhysically_abused());
		pStatement.setString(12, model.getForced_sexually());
		pStatement.setString(13, model.getFear_their_partner());
		pStatement.setString(14, model.getNotification_method());
		pStatement.setString(15, model.getMore_information());
		pStatement.setInt(16, model.getAssign_contact_to_cec());
		pStatement.setString(17, model.getCommunity_tester_name());
		pStatement.setString(18, model.getCreated_by());
		pStatement.setString(19, model.getCode());
		pStatement.setString(20, model.getDatim_code());
		pStatement.setString(21, model.getCommunity_tester_guid());
		pStatement.setString(22, model.getTrace_status());
		pStatement.setString(23, model.getCountry());
		pStatement.setString(24, model.getFirstname());
		pStatement.setString(25, model.getLastname());
		
		return pStatement.executeUpdate();
	}
	
	public List<PatientContactsModel> getPatientContactsByIndex(int indexClientId) throws SQLException {
		
		pStatement = conn.prepareStatement("select * from " + ConstantsUtil.PATIENT_CONTACT_TABLE
		        + " where index_patient_id = ? ");
		pStatement.setInt(1, indexClientId);
		ResultSet resultSet = pStatement.executeQuery();
		
		return convertResultsetsToPatientContacts(resultSet);
		
	}
	
	public List<FacilityLocation> getAllFacilityLocation() throws SQLException {
		String sql_txt = "select uuid,location_id,location_name,datimCode,facility_name,date_created,creator,date_modified,modified_by from "
		        + ConstantsUtil.FACILITY_LOCATION_TABLE;
		pStatement = conn.prepareStatement(sql_txt);
		resultSet = pStatement.executeQuery();
		
		return convertFacilityLocationToList(resultSet);
		
	}
	
	public List<PatientLocation> getPatientLocation() throws SQLException {
		
		String sql = "select distinct p.patient_id,pd.location_id from patient p\n"
		        + "inner join patient_identifier pd on p.patient_id = pd.patient_id and pd.location_id is not null \n"
		        + "where p.voided = 0\n" + "group by p.patient_id ";
		
		pStatement = conn.prepareStatement(sql);
		resultSet = pStatement.executeQuery();
		
		return convertPatientLocationToList(resultSet);
		
	}
	
	public int insertFacilityLocation(FacilityLocation facilityLocation) throws SQLException {
		String sql = "insert into " + ConstantsUtil.FACILITY_LOCATION_TABLE
		        + "(uuid,location_id,location_name,datimCode,facility_name,date_created,creator)"
		        + "values(?,?,?,?,?,NOW(),?)";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, UUID.randomUUID().toString());
		pStatement.setInt(2, facilityLocation.getLocation_id());
		pStatement.setString(3, facilityLocation.getLocation_name());
		pStatement.setString(4, facilityLocation.getDatimCode());
		pStatement.setString(5, facilityLocation.getFacility_name());
		pStatement.setString(6, facilityLocation.getCreator());
		
		return pStatement.executeUpdate();
		
	}
	
	public int updateFacilityLocation(FacilityLocation facilityLocation) throws SQLException {
		String sql = "update " + ConstantsUtil.FACILITY_LOCATION_TABLE
		        + " set datimCode = ?,facility_name = ?, modified_by = ?, date_modified = NOW() where location_id = ? ";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, facilityLocation.getDatimCode());
		pStatement.setString(2, facilityLocation.getFacility_name());
		pStatement.setString(3, facilityLocation.getModified_by());
		pStatement.setInt(4, facilityLocation.getLocation_id());
		
		return pStatement.executeUpdate();
		
	}
	
	public void deleteFacilityLocation(String facilityLocationUUID) throws SQLException {
		String sql = "delete from " + ConstantsUtil.FACILITY_LOCATION_TABLE + " where uuid = ? ";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, facilityLocationUUID);
		
		pStatement.executeUpdate();
	}
	
	public List<PatientLocationAggregate> getCurrentPatientLocationAgg() throws SQLException {
		
		String sql = "select count(p.patient_id) as patient_count ,pd.location_id,l.name from patient p\n"
		        + "inner join patient_identifier pd on p.patient_id = pd.patient_id and pd.location_id is not null \n"
		        + "inner join location l on pd.location_id = l.location_id\n" + "where p.voided = 0 \n"
		        + "group by pd.location_id";
		
		pStatement = conn.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		return convertPatientAggregateResultsetToList(resultSet);
		
	}
	
	private List<PatientLocationAggregate> convertPatientAggregateResultsetToList(ResultSet resultSet) throws SQLException {

        List<PatientLocationAggregate> patientLocationAggregates = new ArrayList<>();
        while(resultSet.next()){
        
            PatientLocationAggregate patientLocationAggregate = new PatientLocationAggregate();
            patientLocationAggregate.setLocation_id(resultSet.getInt("location_id"));
            patientLocationAggregate.setName(resultSet.getString("name"));
            patientLocationAggregate.setPatient_count(resultSet.getInt("patient_count"));
            
            patientLocationAggregates.add(patientLocationAggregate);
            
        }
        
        return patientLocationAggregates;
        
    }
	
	private List<FacilityLocation> convertFacilityLocationToList(ResultSet resultSet) throws SQLException {
        List<FacilityLocation> facilityLocations = new ArrayList<>();
        while (resultSet.next()) {
            FacilityLocation facilityLocation = new FacilityLocation();
            facilityLocation.setCreator(resultSet.getString("creator"));
            facilityLocation.setDate_created(resultSet.getDate("date_created"));
            facilityLocation.setDate_modified(resultSet.getDate("date_modified"));
            facilityLocation.setDatimCode(resultSet.getString("datimCode"));
            facilityLocation.setFacility_name(resultSet.getString("facility_name"));
            facilityLocation.setLocation_id(resultSet.getInt("location_id"));
            facilityLocation.setLocation_name(resultSet.getString("location_name"));
            facilityLocation.setModified_by(resultSet.getString("modified_by"));
            facilityLocation.setUuid(resultSet.getString("uuid"));

            facilityLocations.add(facilityLocation);
        }

        return facilityLocations;
    }
	
	private List<PatientLocation> convertPatientLocationToList(ResultSet resultSet) throws SQLException {

        List<PatientLocation> patientLocations = new ArrayList<>();

        while (resultSet.next()) {

            PatientLocation pl = new PatientLocation();
            pl.setLocation_id(resultSet.getInt("location_id"));
            pl.setPatient_id(resultSet.getInt("patient_id"));

            patientLocations.add(pl);

        }

        return patientLocations;

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
            pModel.setCountry(resultset.getString("country"));
            pModel.setFirstname(resultset.getString("firstname"));
            pModel.setLastname(resultset.getString("lastname"));

            response.add(pModel);

        }

        return response;

    }
}
