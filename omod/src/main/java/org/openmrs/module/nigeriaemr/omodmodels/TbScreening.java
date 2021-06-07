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
public class TbScreening implements Serializable {
	
	private Boolean tb_screening_current_cough_no;
	
	private Boolean tb_screening_weight_loss_yes;
	
	private Boolean tb_screening_fever_no;
	
	private Boolean tb_screening_night_sweats_yes;
	
	public Boolean getTb_screening_current_cough_no() {
		return tb_screening_current_cough_no;
	}
	
	public void setTb_screening_current_cough_no(Boolean tb_screening_current_cough_no) {
		this.tb_screening_current_cough_no = tb_screening_current_cough_no;
	}
	
	public Boolean getTb_screening_weight_loss_yes() {
		return tb_screening_weight_loss_yes;
	}
	
	public void setTb_screening_weight_loss_yes(Boolean tb_screening_weight_loss_yes) {
		this.tb_screening_weight_loss_yes = tb_screening_weight_loss_yes;
	}
	
	public Boolean getTb_screening_fever_no() {
		return tb_screening_fever_no;
	}
	
	public void setTb_screening_fever_no(Boolean tb_screening_fever_no) {
		this.tb_screening_fever_no = tb_screening_fever_no;
	}
	
	public Boolean getTb_screening_night_sweats_yes() {
		return tb_screening_night_sweats_yes;
	}
	
	public void setTb_screening_night_sweats_yes(Boolean tb_screening_night_sweats_yes) {
		this.tb_screening_night_sweats_yes = tb_screening_night_sweats_yes;
	}
	
}
