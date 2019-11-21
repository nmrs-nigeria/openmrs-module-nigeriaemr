/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.openmrs.Obs;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

/**
 * @author MORRISON.I
 */
public class RandomTest {
	
	public DateTime retrieveMedicationDuration(Date visitDate, List<Obs> obsList) {
		DateTime stopDateTime = null;
		DateTime startDateTime = null;
		int durationDays = 0;
		Obs obs = null;
		List<Obs> targetObsList = new ArrayList<Obs>();
		
		Obs obsGroup = Utils.extractObs(Utils.ARV_DRUGS_GROUPING_CONCEPT_SET, obsList);
		if (obsGroup != null) {
			targetObsList.addAll(obsGroup.getGroupMembers());
			obs = Utils.extractObs(Utils.MEDICATION_DURATION_CONCEPT, targetObsList);
			if (obs != null) {
				durationDays = (int) obs.getValueNumeric().doubleValue();
				startDateTime = new DateTime(visitDate);
				stopDateTime = startDateTime.plusDays(durationDays);
			}
		}
		
		/*if (stopDateTime == null) {
		    obs = Utils.extractObs(Utils.NEXT_APPOINTMENT_DATE_CONCEPT, obsList);
		    if (obs != null) {
		        stopDateTime = new DateTime(obs.getValueDate());
		    }
		}*/
		return stopDateTime;
	}
	
	public static void main(String args[]) {
		
		DateTime stopDateTime = null;
		DateTime startDateTime = null;
		int durationDays = (int) 60.0;
		int finaldurationInDays = 0;
		
		//  durationDays = (int) obs.getValueNumeric().doubleValue();
		//  startDateTime = new DateTime(visitDate);
		Date tempDate = new Date();
		
		startDateTime = new DateTime(tempDate);
		stopDateTime = startDateTime.plusDays(durationDays);
		
		//   stopDateTime = retrieveMedicationDuration(visitDate, obsListForAVisit);
		startDateTime = new DateTime();
		finaldurationInDays = Utils.getDateDiffInDays(startDateTime.toDate(), stopDateTime.toDate());
		System.out.println(finaldurationInDays);
		
	}
	
}
