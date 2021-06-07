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
public class ClientScore implements Serializable {
	
	private String hiv_risk_score;
	
	private String clinical_tb_score;
	
	private String sti_score;
	
	public String getHiv_risk_score() {
		return hiv_risk_score;
	}
	
	public void setHiv_risk_score(String hiv_risk_score) {
		this.hiv_risk_score = hiv_risk_score;
	}
	
	public String getClinical_tb_score() {
		return clinical_tb_score;
	}
	
	public void setClinical_tb_score(String clinical_tb_score) {
		this.clinical_tb_score = clinical_tb_score;
	}
	
	public String getSti_score() {
		return sti_score;
	}
	
	public void setSti_score(String sti_score) {
		this.sti_score = sti_score;
	}
	
}
