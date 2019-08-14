/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.omodmodels;

import java.io.Serializable;

/**
 * @author MORRISON.I
 */
public class RiskAssessment implements Serializable {
	
	private Boolean risk_assessment_ever_had_sexual_intercourse_yes;
	
	private Boolean risk_assessment_blood_transfussion_in_last_3_month_no;
	
	private Boolean risk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes;
	
	private Boolean risk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no;
	
	private Boolean risk_assessment_sti_in_last_3_months_yes;
	
	private Boolean risk_assessment_more_than_1_sex_partner_in_last_3_months_no;
	
	public Boolean getRisk_assessment_ever_had_sexual_intercourse_yes() {
		return risk_assessment_ever_had_sexual_intercourse_yes;
	}
	
	public void setRisk_assessment_ever_had_sexual_intercourse_yes(Boolean risk_assessment_ever_had_sexual_intercourse_yes) {
		this.risk_assessment_ever_had_sexual_intercourse_yes = risk_assessment_ever_had_sexual_intercourse_yes;
	}
	
	public Boolean getRisk_assessment_blood_transfussion_in_last_3_month_no() {
		return risk_assessment_blood_transfussion_in_last_3_month_no;
	}
	
	public void setRisk_assessment_blood_transfussion_in_last_3_month_no(
	        Boolean risk_assessment_blood_transfussion_in_last_3_month_no) {
		this.risk_assessment_blood_transfussion_in_last_3_month_no = risk_assessment_blood_transfussion_in_last_3_month_no;
	}
	
	public Boolean getRisk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes() {
		return risk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes;
	}
	
	public void setRisk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes(
	        Boolean risk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes) {
		this.risk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes = risk_assessment_unprotected_sex_with_casual_partner_in_last_3_months_yes;
	}
	
	public Boolean getRisk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no() {
		return risk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no;
	}
	
	public void setRisk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no(
	        Boolean risk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no) {
		this.risk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no = risk_assessment_unprotected_sex_with_regular_partner_in_last_3_months_no;
	}
	
	public Boolean getRisk_assessment_sti_in_last_3_months_yes() {
		return risk_assessment_sti_in_last_3_months_yes;
	}
	
	public void setRisk_assessment_sti_in_last_3_months_yes(Boolean risk_assessment_sti_in_last_3_months_yes) {
		this.risk_assessment_sti_in_last_3_months_yes = risk_assessment_sti_in_last_3_months_yes;
	}
	
	public Boolean getRisk_assessment_more_than_1_sex_partner_in_last_3_months_no() {
		return risk_assessment_more_than_1_sex_partner_in_last_3_months_no;
	}
	
	public void setRisk_assessment_more_than_1_sex_partner_in_last_3_months_no(
	        Boolean risk_assessment_more_than_1_sex_partner_in_last_3_months_no) {
		this.risk_assessment_more_than_1_sex_partner_in_last_3_months_no = risk_assessment_more_than_1_sex_partner_in_last_3_months_no;
	}
	
}
