/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.model.ndr.CommonQuestionsType;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HIVQuestionTypeDictionary {
	
	/*
	    -HospitalNumber
	    -DiagnosisFacility
	    -DateOfFirstReport
	    -DateOfLastReport
	    -DiagnosisDate
	    -PatientDieFromThisIllness
	    -PatientPregnancyStatusCode
	    -EstimatedDeliveryDate
	    -PatientAge
	*/
	public CommonQuestionsType createCommonQuestionType(Patient pts, List<Encounter> encList, List<Obs> obsList) {
		//Lets do validation checks before constructing these objects
		CommonQuestionsType commonQuestionType = null;
		Obs obs = null;
		//Adult Initial Clinical Evaluation 22, Pediatric Initial Clinical Evaluation 20 , HIV Enrollment 23
		Integer[] encounterTypeIDsArray = { Utils.Adult_Ped_Initial_Encounter_Type_Id,
		        Utils.HIV_Enrollment_Encounter_Type_Id };
		List<Integer> encounterTypeIDList = new ArrayList<Integer>();
		encounterTypeIDList.addAll(Arrays.asList(encounterTypeIDsArray));
		List<Obs> obsCommonQuestionsList = new ArrayList<Obs>();
		String hospID = "";
		for (Encounter enc : encList) {
			if (encounterTypeIDList.contains(enc.getEncounterType().getEncounterTypeId())) {
				obsCommonQuestionsList.addAll(enc.getAllObs());
			}
		}
		
		PatientIdentifier hospPatientIdentifier = pts.getPatientIdentifier(Utils.HOSPITAL_IDENTIFIER_INDEX);
		if (hospPatientIdentifier != null) {
			hospID = hospPatientIdentifier.getIdentifier();
		}
		if (!encList.isEmpty()) {
			commonQuestionType = new CommonQuestionsType();
			commonQuestionType.setHospitalNumber(hospID); // HospitalNumber
			// commonQuestionType.setDateOfFirstReport(Utils.getF);
			
		}
		
		return commonQuestionType;
		
	}
}
