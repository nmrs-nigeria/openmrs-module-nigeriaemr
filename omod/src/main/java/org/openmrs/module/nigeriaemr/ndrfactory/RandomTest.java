/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrfactory;

import org.joda.time.DateTime;
import org.openmrs.Obs;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author MORRISON.I
 */
public class RandomTest {
	
	public DateTime retrieveMedicationDuration(Date visitDate, List<Integer> obsList) {
		DateTime stopDateTime = null;
		DateTime startDateTime = null;
		int durationDays = 0;
		Obs obs = null;

		Obs obsGroup = Utils.extractObs(Utils.ARV_DRUGS_GROUPING_CONCEPT_SET, obsList);
		if (obsGroup != null) {
			List<Integer> targetObsList = obsGroup.getGroupMembers().stream().map(Obs::getObsId).collect(Collectors.toList());
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
		
		//         Runtime runtime =   Runtime.getRuntime();
		//            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		//            Map<String,String> allProps = runtimeMXBean.getSystemProperties();
		//
		//            long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
		//        .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
		//
		//            File[] roots = File.listRoots();
		//            File eachRoot = Arrays.asList(roots).get(0);
		//
		//            System.out.println(runtime.availableProcessors());
		//            System.out.println(runtime.freeMemory());
		//            System.out.println(runtime.totalMemory());
		//            System.out.println(runtime.maxMemory());
		//            System.out.println(allProps.get("java.version"));
		//            System.out.println(allProps.get("java.home"));
		//            System.out.println(allProps.get("java.vendor"));
		//            System.out.println(allProps.get("os.name"));
		//            System.out.println(allProps.get("sun.arch.data.model")); //JVM bit size
		//            System.out.println(memorySize); //returns actual + 1 gig
		//            System.out.println(eachRoot.getTotalSpace());
		//            System.out.println(System.getProperty("sun.arch.data.model"));
		//
		//            allProps.entrySet().forEach(a ->{
		//                System.out.println(a);
		//            });
		
		//		DateTime stopDateTime = null;
		//		DateTime startDateTime = null;
		//		int durationDays = (int) 60.0;
		//		int finaldurationInDays = 0;
		//		
		//		//  durationDays = (int) obs.getValueNumeric().doubleValue();
		//		//  startDateTime = new DateTime(visitDate);
		//		Date tempDate = new Date();
		//		
		//		startDateTime = new DateTime(tempDate);
		//		stopDateTime = startDateTime.plusDays(durationDays);
		//		
		//		//   stopDateTime = retrieveMedicationDuration(visitDate, obsListForAVisit);
		//		startDateTime = new DateTime();
		//		finaldurationInDays = Utils.getDateDiffInDays(startDateTime.toDate(), stopDateTime.toDate());
		//		System.out.println(finaldurationInDays);
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		System.out.println("");
		
	}
}
