/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrUtils;

/**
 * @author MORRISON.I
 */
public class ConstantsUtil {
	
	public static final int PEPFAR_IDENTIFIER_INDEX = 4;
	
	public static final int HOSPITAL_IDENTIFIER_INDEX = 5;
	
	public static final int OTHER_IDENTIFIER_INDEX = 3;
	
	public static final int HTS_IDENTIFIER_INDEX = 8;
	
	public static final int PMTCT_IDENTIFIER_INDEX = 6;
	
	public static final int EXPOSE_INFANT_IDENTIFIER_INDEX = 7;
	
	public static final int PEP_ED_IDENTIFIER_INDEX = 9;
	
	public static final String COMMUNITY_TESTER_TABLE = "community_testers";
	
	public static final String PATIENT_CONTACT_TABLE = "patient_contacts";
	
	public static final String FACILITY_LOCATION_TABLE = "facility_has_location";
	
	public static final int ADMISSION_ENCOUNTER_TYPE = 2;
	
	public static final int ADMISSION_ENCOUNTER_TYPE_V2 = 20;
	
	public static final int PMTCT_ENCOUNTER_TYPE = 29;
	
	public static final int GENERAL_ANTENATAL_CARE_ENCOUNTER_TYPE = 10;
	
	public static final int DELIVERY_REGISTER_ENCOUNTER_TYPE = 16;
	
	public static final int CHILD_FOLLOW_UP = 18;
	
	public static final int PARTNER_REGISTER = 19;
	
	public static final String PMTCT_HTS_REGISTER = "136e629b-78b6-4cdb-b76a-01c598d6a173";
	
	public static final int CHILD_BIRTH_REGISTRATION_ENCOUNTER = 9;
	
	public static final String PMTCT_HTS_FORM_UUID = "1b64c8bc-b289-45f7-943c-122be5de7274";
	
	public static final int MATERNAL_COHORT_TYPE = 45;
	
	public static final int PMTCT_REGISTRATION_ENCOUNTER = 44;
	
	public static final int OTZ_ENCOUNTER_TYPE = 36;
	
	public static final int TB_COMM_FAC_ENCOUNTER_TYPE = 55;
	
	public static final int TB_INDEX_CONTACT_ENCOUNTER_TYPE = 57;
	
	public static final int COVID19_CASE_INVESTIGATION_ENCOUNTER = 40;
	
	public static final int COVID19_CONTACT_ENCOUNTER_TYPE = 42;
	
	public static final int COVID19_CONTACT_INVESTIGATION_ENCOUNTER = 41;
	
	public static final int TB_SCREENING_ENCOUNTER_TYPE = 64;
	
	public static final int PRESUMPTIVE_TB_REGISTER_ENCOUNTER_TYPE = 58;
	
	public static final int DRTB_TREATMENT_ENCOUNTER_TYPE = 61;
	
	public static final int DRTB_DISCHARGE_ENCOUNTER_TYPE = 53;
	
	public static final int RECENCY_ENCOUNTER_TYPE = 39;
	
	public static final int TB_TRACKING_ENCOUNTER_TYPE = 47;
	
	public static final int TB_LAB_REGISTER_ENCOUNTER_TYPE = 62;
	
	public static final int TB_LGA_HEALTH_REGISTER_ENCOUNTER_TYPE = 52;
	
	public static final int MORTALITY_ENCOUNTER_TYPE = 15;
	
	public static final int SPECIMEN_REQUEST_ENCOUNTER_TYPE = 56;
	
	public static final int SPECIMEN_RESULT_ENCOUNTER_TYPE = 51;
	
	public static final int TB_MONITORING_ENCOUNTER_TYPE = 68;
	
	public static final int IPT_MONITORING_ENCOUNTER_TYPE = 23;
	
	public static final int TB_REFERRAL_ENCOUNTER_TYPE = 50;
	
	public static final int TB_TREATMENT_CARD_ENCOUNTER_TYPE = 54;
	
	//Endpoints
	//public static final String BASE_URL = "https://hts.shieldnigeriaproject.com/api";
	
	public static final String BASE_URL = "https://hts.shieldnigeriaproject.com/api/nmrs";
	
	public static final String GET_COMMUNITY_TESTER = "/GetTester";
	
	public static final String GET_ClIENT = "/GetClientReferal";
	
}
