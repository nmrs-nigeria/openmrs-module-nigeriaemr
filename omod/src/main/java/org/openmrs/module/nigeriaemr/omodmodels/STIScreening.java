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
public class STIScreening implements Serializable {
	
	private Boolean sti_screening_complain_of_urethral_discharge_yes;
	
	private Boolean sti_screening_complain_of_scrotal_swelling_yes;
	
	private Boolean sti_screening_complain_of_genital_sore_yes;
	
	private Boolean hiv_risk_score;
	
	private Boolean clinical_tb_score;
	
	public Boolean getSti_screening_complain_of_urethral_discharge_yes() {
		return sti_screening_complain_of_urethral_discharge_yes;
	}
	
	public void setSti_screening_complain_of_urethral_discharge_yes(Boolean sti_screening_complain_of_urethral_discharge_yes) {
		this.sti_screening_complain_of_urethral_discharge_yes = sti_screening_complain_of_urethral_discharge_yes;
	}
	
	public Boolean getSti_screening_complain_of_scrotal_swelling_yes() {
		return sti_screening_complain_of_scrotal_swelling_yes;
	}
	
	public void setSti_screening_complain_of_scrotal_swelling_yes(Boolean sti_screening_complain_of_scrotal_swelling_yes) {
		this.sti_screening_complain_of_scrotal_swelling_yes = sti_screening_complain_of_scrotal_swelling_yes;
	}
	
	public Boolean getSti_screening_complain_of_genital_sore_yes() {
		return sti_screening_complain_of_genital_sore_yes;
	}
	
	public void setSti_screening_complain_of_genital_sore_yes(Boolean sti_screening_complain_of_genital_sore_yes) {
		this.sti_screening_complain_of_genital_sore_yes = sti_screening_complain_of_genital_sore_yes;
	}
	
	public Boolean getHiv_risk_score() {
		return hiv_risk_score;
	}
	
	public void setHiv_risk_score(Boolean hiv_risk_score) {
		this.hiv_risk_score = hiv_risk_score;
	}
	
	public Boolean getClinical_tb_score() {
		return clinical_tb_score;
	}
	
	public void setClinical_tb_score(Boolean clinical_tb_score) {
		this.clinical_tb_score = clinical_tb_score;
	}
	
}
