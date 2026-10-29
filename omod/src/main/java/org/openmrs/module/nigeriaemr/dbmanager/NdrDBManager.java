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
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.omodmodels.DBConnection;
import org.openmrs.module.nigeriaemr.omodmodels.FacilityLocation;
import org.openmrs.module.nigeriaemr.omodmodels.PatientContactsModel;
import org.openmrs.module.nigeriaemr.omodmodels.PatientLocation;
import org.openmrs.module.nigeriaemr.omodmodels.PatientLocationAggregate;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;
import org.openmrs.module.nigeriaemr.omodmodels.PersonInfo;

/**
 * @author MORRISON.I
 */
public class NdrDBManager {
	
	Connection conn = null;
	
	PreparedStatement pStatement = null;
	
	private ResultSet resultSet = null;
	
	Gson gson = new Gson();
	
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
	
	public List<FacilityLocation> getFacilityLocationById(int location_id) throws SQLException {
		String sql_txt = "select uuid,location_id,location_name,datimCode,facility_name,date_created,creator,date_modified,modified_by from "
		        + ConstantsUtil.FACILITY_LOCATION_TABLE + " where location_id = " + location_id;
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
	
	public List<Integer> getPatientIdByLocationId(int locationId) throws SQLException {
		
		String sql = "select distinct p.patient_id from patient p "
		        + "inner join patient_identifier pd on p.patient_id = pd.patient_id and pd.location_id is not null \n"
		        + "where p.voided = 0 AND p.location_id  = " + locationId + " group by p.patient_id ";
		
		pStatement = conn.prepareStatement(sql);
		resultSet = pStatement.executeQuery();
		
		return (List<Integer>) resultSet;
		
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
	
	public String getTransitPatientUUIDs() throws SQLException {
		
//		String sql = "SELECT p.uuid FROM person p JOIN obs o ON p.`person_id` = o.`person_id` WHERE p.person_id IN (SELECT patient_id FROM patient_identifier WHERE identifier_type = (SELECT patient_identifier_type_id FROM patient_identifier_type WHERE UUID= '3f3b8580-2c60-4915-a4ad-724bed1fa33a')) AND o.`obs_datetime`  >= '2025-06-23'  GROUP BY p.`uuid`";
//		List<String> getUUIs = new ArrayList<String>();
//		pStatement = conn.prepareStatement(sql);
//		ResultSet resultSet = pStatement.executeQuery();
//
//		while (resultSet.next()) {
//			getUUIs.add(resultSet.getString("uuid"));
//		}

		String pimslastpushdate = getPIMSLastPushDate();

        // Prepare query
        String sql = "SELECT \n" +
                "  p.uuid,\n" +
                "  p.birthdate,p.gender,(SELECT property_value FROM `global_property` WHERE property ='facility_datim_code' LIMIT 1) AS secondarydatimcode, \n" +
                "  (SELECT property_value FROM `global_property` WHERE property ='Facility_Name' LIMIT 1) AS secfacilityname, \n" +
                "  (SELECT pa.value FROM person_attribute pa \n" +
                "   WHERE pa.`person_id` = p.`person_id` AND pa.`person_attribute_type_id` IN\n" +
                "  (SELECT person_attribute_type_id FROM person_attribute_type \n" +
                "  WHERE UUID ='7f9c2d35-4dbf-4d24-9a56-e171e16729b9')) AS primarydatimcode,\n" +
                "  (SELECT pa.value FROM person_attribute pa \n" +
                "   WHERE pa.`person_id` = p.`person_id` AND pa.`person_attribute_type_id` IN\n" +
                "  (SELECT person_attribute_type_id FROM person_attribute_type \n" +
                "  WHERE UUID ='2b15f1ce-2695-4e45-825d-777142b22cd9')) AS primaryclientid,\n" +
                "  (SELECT \n" +
                "    pid.identifier \n" +
                "  FROM\n" +
                "    patient_identifier pid\n" +
                "  WHERE pid.patient_id = p.`person_id` AND identifier_type = \n" +
                "    (SELECT \n" +
                "      patient_identifier_type_id \n" +
                "    FROM\n" +
                "      patient_identifier_type \n" +
                "    WHERE UUID= '3f3b8580-2c60-4915-a4ad-724bed1fa33a')) AS transitid , (SELECT GROUP_CONCAT(CONCAT(en.name,':',DATE(o.obs_datetime)) SEPARATOR \",\") FROM encounter_type en WHERE en.`encounter_type_id` IN (SELECT e.encounter_type FROM encounter e WHERE e.patient_id = o.person_id)) AS encounters\n" +
                "FROM\n" +
                "  person p \n" +
                "  JOIN obs o \n" +
                "    ON p.`person_id` = o.`person_id` \n" +
                "WHERE p.person_id IN \n" +
                "  (SELECT \n" +
                "    patient_id \n" +
                "  FROM\n" +
                "    patient_identifier \n" +
                "  WHERE identifier_type = \n" +
                "    (SELECT \n" +
                "      patient_identifier_type_id \n" +
                "    FROM\n" +
                "      patient_identifier_type \n" +
                "    WHERE UUID= '3f3b8580-2c60-4915-a4ad-724bed1fa33a')) \n" +
                "  AND o.`obs_datetime` >= '"+pimslastpushdate+"' AND o.voided = 0 \n" +
                "GROUP BY p.`uuid`";
        pStatement = conn.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        List<PersonInfo> personList = new ArrayList<>();
        // Print result
        while (result.next()) {

            personList.add(new PersonInfo(result.getString("uuid"),
                    result.getString("birthdate"),
                    result.getString("primarydatimcode"),
                    result.getString("primaryclientid"),
                    result.getString("transitid"),
                    result.getString("gender"),
                    result.getString("secondarydatimcode"),
                    result.getString("encounters"),
                    result.getString("secfacilityname")
                    ));
        }

		return gson.toJson(personList);
		
	}
	
	public String getPIMSToken() throws SQLException {
		
		String token = "";
		String sql = "SELECT property_value FROM global_property WHERE property ='pimstoken' LIMIT 1";
		
		pStatement = conn.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			token = resultSet.getString("property_value");
			
		}
		return token;
		
	}
	
	public String getPatientUUID(String clientid) throws SQLException {
		
		String token = clientid;
		String sql = "SELECT \n" + "  p.uuid \n" + "FROM\n" + "  person p \n" + "WHERE p.`person_id` IN \n" + "  (SELECT \n"
		        + "    patient_id \n" + "  FROM\n" + "    patient_identifier \n" + "  WHERE identifier = ? \n"
		        + "  GROUP BY patient_id)";
		
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, token);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			token = resultSet.getString("uuid");
			
		}
		return token;
		
	}
	
	public String getPIMSLastPushDate() {
		return Context.getAdministrationService().getGlobalProperty("pimslastpushdate");
	}
	
	public String getPIMSLastPullDate() {
		return Context.getAdministrationService().getGlobalProperty("pimslastpulldate");
	}
	
	public String updatePIMSLastPushDate(String pimslastpushdate) throws SQLException {
		String sql = "update global_property"
		        + " set property_value = ? where uuid = '714f3b6b-ddc6-4e28-b382-284fbe54c7dc' ";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, pimslastpushdate);
		return String.valueOf(pStatement.executeUpdate());
		
	}
	
	public String updatePIMSLastPullDate(String pimslastpulldate) throws SQLException {
		String sql = "update global_property"
		        + " set property_value = ? where uuid = '1ab724fd-7a42-4f95-a6fb-f812f208a864' ";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, pimslastpulldate);
		return String.valueOf(pStatement.executeUpdate());
		
	}
	
	public String resolveOBSgroupIssueART(String patientUUID, String encounterType, String encounterDatetime)
	        throws SQLException {
		OffsetDateTime dateTime = OffsetDateTime.parse(encounterDatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateTime.toLocalDate().format(formatter);
		
		// TODO Auto-generated method stub
		String sql = "UPDATE obs AS o1 JOIN ( SELECT o.obs_id FROM obs o JOIN encounter e ON o.encounter_id = e.encounter_id WHERE DATE(e.encounter_datetime) = DATE('"
		        + formattedDate
		        + "') AND e.encounter_type = (SELECT et.encounter_type_id FROM encounter_type et WHERE et.uuid = 'a1fa6aa3-59e1-4833-a28c-bb62f2fb07df') AND o.person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') AND o.concept_id = 162240 LIMIT 1) AS src ON o1.person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') SET o1.obs_group_id = src.obs_id WHERE o1.concept_id IN (167209, 159368, 1443, 160856, 166120, 165724, 165725, 167218, 165723)  AND o1.obs_group_id IS NULL  AND o1.encounter_id = ( SELECT encounter_id FROM encounter WHERE DATE(encounter_datetime) = DATE('"
		        + formattedDate
		        + "') AND patient_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') AND  encounter_type = 13 LIMIT 1) AND DATE(o1.`obs_datetime`) = DATE('"
		        + formattedDate
		        + "')";
		pStatement = conn.prepareStatement(sql);
		return String.valueOf(pStatement.executeUpdate());
	}
	
	public String resolveOBSgroupIssueART162240(String patientUUID, String encounterType, String encounterDatetime)
	        throws SQLException {
		OffsetDateTime dateTime = OffsetDateTime.parse(encounterDatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateTime.toLocalDate().format(formatter);
		
		// TODO Auto-generated method stub
		String sql = "UPDATE obs SET value_coded = NULL WHERE concept_id = 162240 AND person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID + "') AND DATE(`obs_datetime`) = DATE('" + formattedDate + "') AND value_coded IS NOT NULL";
		pStatement = conn.prepareStatement(sql);
		return String.valueOf(pStatement.executeUpdate());
	}
	
	public String resolveOBSgroupIssueOI(String patientUUID, String encounterType, String encounterDatetime)
	        throws SQLException {
		
		OffsetDateTime dateTime = OffsetDateTime.parse(encounterDatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateTime.toLocalDate().format(formatter);
		// TODO Auto-generated method stub
		String sql = "UPDATE obs AS o1 JOIN ( SELECT o.obs_id FROM obs o JOIN encounter e ON o.encounter_id = e.encounter_id WHERE DATE(e.encounter_datetime) = DATE('"
		        + formattedDate
		        + "') AND e.encounter_type = (SELECT et.encounter_type_id FROM encounter_type et WHERE et.uuid = 'a1fa6aa3-59e1-4833-a28c-bb62f2fb07df') AND o.person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') AND o.concept_id = 165726 LIMIT 1) AS src ON o1.person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') SET o1.obs_group_id = src.obs_id WHERE o1.concept_id IN (165727, 65725, 167218, 165723, 159368,160856, 167209, 1443)  AND o1.obs_group_id IS NULL  AND o1.encounter_id = ( SELECT encounter_id FROM encounter WHERE DATE(encounter_datetime) = DATE('"
		        + formattedDate
		        + "') AND patient_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID
		        + "') AND  encounter_type = 13 LIMIT 1) AND DATE(o1.`obs_datetime`) = DATE('"
		        + formattedDate
		        + "')";
		pStatement = conn.prepareStatement(sql);
		return String.valueOf(pStatement.executeUpdate());
	}
	
	public String resolveOBSgroupIssueOI165726(String patientUUID, String encounterType, String encounterDatetime)
	        throws SQLException {
		
		OffsetDateTime dateTime = OffsetDateTime.parse(encounterDatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateTime.toLocalDate().format(formatter);
		// TODO Auto-generated method stub
		String sql = "UPDATE obs SET value_coded = NULL WHERE concept_id = 165726 AND person_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '"
		        + patientUUID + "') AND DATE(`obs_datetime`) = DATE('" + formattedDate + "') AND value_coded IS NOT NULL";
		
		pStatement = conn.prepareStatement(sql);
		return String.valueOf(pStatement.executeUpdate());
	}
	
	public String checkDuplicateEncounterAtSyc(String patientUUID, String encounterType, String encounterDatetime)
	        throws Exception {
		
		OffsetDateTime dateTime = OffsetDateTime.parse(encounterDatetime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = dateTime.toLocalDate().format(formatter);
		String id = "";
		String sql = "SELECT encounter_id FROM encounter WHERE DATE(encounter_datetime) = '" + formattedDate
		        + "' AND patient_id = (SELECT pid.`person_id` FROM person pid WHERE pid.`uuid` = '" + patientUUID
		        + "') AND encounter_type = (SELECT et.encounter_type_id FROM encounter_type et WHERE et.uuid = '"
		        + encounterType + "' ) LIMIT 1";
		
		pStatement = conn.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			id = resultSet.getString("encounter_id");
			
		}
		return id;
		
	}
	
}
