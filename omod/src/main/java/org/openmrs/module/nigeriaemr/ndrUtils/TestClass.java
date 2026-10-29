/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrUtils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author The Brights
 */
public class TestClass {
	
	public static void main(String[] arg) {
		Date date = new Date();
		DateTime dateTime = new DateTime();
		int month = dateTime.getMonthOfYear();
		int year = dateTime.getYear();
		int day = dateTime.getDayOfMonth();
		String monthStr = StringUtils.leftPad(String.valueOf(month), 2, "0");
		String dayStr = StringUtils.leftPad(String.valueOf(day), 2, "0");
		String yrsStr = StringUtils.leftPad(String.valueOf(year), 2, "0");
		System.out.println(yrsStr + monthStr + dayStr);
	}
}
