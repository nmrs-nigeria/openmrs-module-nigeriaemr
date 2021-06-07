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
public class PostTestCouncel implements Serializable {
	
	private String PostTestedBefore;
	
	private Boolean request_and_result_form_signed_by_testers_yes;
	
	private Boolean request_and_result_form_filled_with_ct_intake_form_yes;
	
	private Boolean client_received_hiv_result_no;
	
	private Boolean post_test_councelling_done_no;
	
	private Boolean client_or_partner_use_fp_methods_yes;
	
	private Boolean client_or_partner_use_condom_as_one_fp_method_no;
	
	private Boolean risk_reduction_plan_developed_yes;
	
	private Boolean post_test_disclosure_plan_developed_yes;
	
	private Boolean will_bring_partners_for_testing_no;
	
	private Boolean will_bring_own_children_less_than_5_years_old_for_testing_yes;
	
	private Boolean provided_with_information_on_fp_and_dual_contraception_no;
	
	private Boolean correct_condom_use_demonstrated_yes;
	
	private Boolean condoms_provided_yes;
	
	private Boolean client_referred_to_other_services_yes;
	
	public Boolean getRequest_and_result_form_signed_by_testers_yes() {
		return request_and_result_form_signed_by_testers_yes;
	}
	
	public void setRequest_and_result_form_signed_by_testers_yes(Boolean request_and_result_form_signed_by_testers_yes) {
		this.request_and_result_form_signed_by_testers_yes = request_and_result_form_signed_by_testers_yes;
	}
	
	public Boolean getRequest_and_result_form_filled_with_ct_intake_form_yes() {
		return request_and_result_form_filled_with_ct_intake_form_yes;
	}
	
	public void setRequest_and_result_form_filled_with_ct_intake_form_yes(
	        Boolean request_and_result_form_filled_with_ct_intake_form_yes) {
		this.request_and_result_form_filled_with_ct_intake_form_yes = request_and_result_form_filled_with_ct_intake_form_yes;
	}
	
	public Boolean getClient_received_hiv_result_no() {
		return client_received_hiv_result_no;
	}
	
	public void setClient_received_hiv_result_no(Boolean client_received_hiv_result_no) {
		this.client_received_hiv_result_no = client_received_hiv_result_no;
	}
	
	public Boolean getPost_test_councelling_done_no() {
		return post_test_councelling_done_no;
	}
	
	public void setPost_test_councelling_done_no(Boolean post_test_councelling_done_no) {
		this.post_test_councelling_done_no = post_test_councelling_done_no;
	}
	
	public Boolean getRisk_reduction_plan_developed_yes() {
		return risk_reduction_plan_developed_yes;
	}
	
	public void setRisk_reduction_plan_developed_yes(Boolean risk_reduction_plan_developed_yes) {
		this.risk_reduction_plan_developed_yes = risk_reduction_plan_developed_yes;
	}
	
	public Boolean getPost_test_disclosure_plan_developed_yes() {
		return post_test_disclosure_plan_developed_yes;
	}
	
	public void setPost_test_disclosure_plan_developed_yes(Boolean post_test_disclosure_plan_developed_yes) {
		this.post_test_disclosure_plan_developed_yes = post_test_disclosure_plan_developed_yes;
	}
	
	public Boolean getWill_bring_partners_for_testing_no() {
		return will_bring_partners_for_testing_no;
	}
	
	public void setWill_bring_partners_for_testing_no(Boolean will_bring_partners_for_testing_no) {
		this.will_bring_partners_for_testing_no = will_bring_partners_for_testing_no;
	}
	
	public Boolean getWill_bring_own_children_less_than_5_years_old_for_testing_yes() {
		return will_bring_own_children_less_than_5_years_old_for_testing_yes;
	}
	
	public void setWill_bring_own_children_less_than_5_years_old_for_testing_yes(
	        Boolean will_bring_own_children_less_than_5_years_old_for_testing_yes) {
		this.will_bring_own_children_less_than_5_years_old_for_testing_yes = will_bring_own_children_less_than_5_years_old_for_testing_yes;
	}
	
	public Boolean getProvided_with_information_on_fp_and_dual_contraception_no() {
		return provided_with_information_on_fp_and_dual_contraception_no;
	}
	
	public void setProvided_with_information_on_fp_and_dual_contraception_no(
	        Boolean provided_with_information_on_fp_and_dual_contraception_no) {
		this.provided_with_information_on_fp_and_dual_contraception_no = provided_with_information_on_fp_and_dual_contraception_no;
	}
	
	public Boolean getClient_or_partner_use_fp_methods_yes() {
		return client_or_partner_use_fp_methods_yes;
	}
	
	public void setClient_or_partner_use_fp_methods_yes(Boolean client_or_partner_use_fp_methods_yes) {
		this.client_or_partner_use_fp_methods_yes = client_or_partner_use_fp_methods_yes;
	}
	
	public Boolean getClient_or_partner_use_condom_as_one_fp_method_no() {
		return client_or_partner_use_condom_as_one_fp_method_no;
	}
	
	public void setClient_or_partner_use_condom_as_one_fp_method_no(Boolean client_or_partner_use_condom_as_one_fp_method_no) {
		this.client_or_partner_use_condom_as_one_fp_method_no = client_or_partner_use_condom_as_one_fp_method_no;
	}
	
	public Boolean getCorrect_condom_use_demonstrated_yes() {
		return correct_condom_use_demonstrated_yes;
	}
	
	public void setCorrect_condom_use_demonstrated_yes(Boolean correct_condom_use_demonstrated_yes) {
		this.correct_condom_use_demonstrated_yes = correct_condom_use_demonstrated_yes;
	}
	
	public Boolean getCondoms_provided_yes() {
		return condoms_provided_yes;
	}
	
	public void setCondoms_provided_yes(Boolean condoms_provided_yes) {
		this.condoms_provided_yes = condoms_provided_yes;
	}
	
	public String getPostTestedBefore() {
		return PostTestedBefore;
	}
	
	public void setPostTestedBefore(String PostTestedBefore) {
		this.PostTestedBefore = PostTestedBefore;
	}
	
	public Boolean getClient_referred_to_other_services_yes() {
		return client_referred_to_other_services_yes;
	}
	
	public void setClient_referred_to_other_services_yes(Boolean client_referred_to_other_services_yes) {
		this.client_referred_to_other_services_yes = client_referred_to_other_services_yes;
	}
	
}
