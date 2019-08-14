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
public class KnowledgeAssesement implements Serializable {
	
	private Boolean knowledge_assessment_previously_tested_negative_yes;
	
	private Boolean knowledge_assessment_informed_about_transmission_routes_no;
	
	private Boolean knowledge_assessment_informed_about_risk_factors_yes;
	
	private Boolean knowledge_assessment_informed_on_preventing_transmission_method_no;
	
	private Boolean knowledge_assessment_informed_about_possible_test_results_yes;
	
	private Boolean knowledge_assessment_informed_consent_for_testing_given_no;
	
	public Boolean getKnowledge_assessment_previously_tested_negative_yes() {
		return knowledge_assessment_previously_tested_negative_yes;
	}
	
	public void setKnowledge_assessment_previously_tested_negative_yes(
	        Boolean knowledge_assessment_previously_tested_negative_yes) {
		this.knowledge_assessment_previously_tested_negative_yes = knowledge_assessment_previously_tested_negative_yes;
	}
	
	public Boolean getKnowledge_assessment_informed_about_transmission_routes_no() {
		return knowledge_assessment_informed_about_transmission_routes_no;
	}
	
	public void setKnowledge_assessment_informed_about_transmission_routes_no(
	        Boolean knowledge_assessment_informed_about_transmission_routes_no) {
		this.knowledge_assessment_informed_about_transmission_routes_no = knowledge_assessment_informed_about_transmission_routes_no;
	}
	
	public Boolean getKnowledge_assessment_informed_about_risk_factors_yes() {
		return knowledge_assessment_informed_about_risk_factors_yes;
	}
	
	public void setKnowledge_assessment_informed_about_risk_factors_yes(
	        Boolean knowledge_assessment_informed_about_risk_factors_yes) {
		this.knowledge_assessment_informed_about_risk_factors_yes = knowledge_assessment_informed_about_risk_factors_yes;
	}
	
	public Boolean getKnowledge_assessment_informed_on_preventing_transmission_method_no() {
		return knowledge_assessment_informed_on_preventing_transmission_method_no;
	}
	
	public void setKnowledge_assessment_informed_on_preventing_transmission_method_no(
	        Boolean knowledge_assessment_informed_on_preventing_transmission_method_no) {
		this.knowledge_assessment_informed_on_preventing_transmission_method_no = knowledge_assessment_informed_on_preventing_transmission_method_no;
	}
	
	public Boolean getKnowledge_assessment_informed_about_possible_test_results_yes() {
		return knowledge_assessment_informed_about_possible_test_results_yes;
	}
	
	public void setKnowledge_assessment_informed_about_possible_test_results_yes(
	        Boolean knowledge_assessment_informed_about_possible_test_results_yes) {
		this.knowledge_assessment_informed_about_possible_test_results_yes = knowledge_assessment_informed_about_possible_test_results_yes;
	}
	
	public Boolean getKnowledge_assessment_informed_consent_for_testing_given_no() {
		return knowledge_assessment_informed_consent_for_testing_given_no;
	}
	
	public void setKnowledge_assessment_informed_consent_for_testing_given_no(
	        Boolean knowledge_assessment_informed_consent_for_testing_given_no) {
		this.knowledge_assessment_informed_consent_for_testing_given_no = knowledge_assessment_informed_consent_for_testing_given_no;
	}
	
}
