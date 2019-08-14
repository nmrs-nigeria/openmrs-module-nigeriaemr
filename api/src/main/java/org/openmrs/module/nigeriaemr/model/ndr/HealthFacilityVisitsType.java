/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Bodyofchrist
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HealthFacilityVisitsType", propOrder = { "visitDate", "visitStatus", "cotrimoxazole", "weight",
        "breastFeeding" })
public class HealthFacilityVisitsType {
	
	@XmlElement(name = "VisitDate", required = true)
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "VisitStatus")
	protected String visitStatus;
	
	@XmlElement(name = "Cotrimoxazole")
	protected String cotrimoxazole;
	
	@XmlElement(name = "Weight")
	protected Float weight;
	
	@XmlElement(name = "BreastFeeding")
	protected String breastFeeding;
	
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	public void setVisitDate(XMLGregorianCalendar visitDate) {
		this.visitDate = visitDate;
	}
	
	public String getVisitStatus() {
		return visitStatus;
	}
	
	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}
	
	public String getCotrimoxazole() {
		return cotrimoxazole;
	}
	
	public void setCotrimoxazole(String cotrimoxazole) {
		this.cotrimoxazole = cotrimoxazole;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	public String getBreastFeeding() {
		return breastFeeding;
	}
	
	public void setBreastFeeding(String breastFeeding) {
		this.breastFeeding = breastFeeding;
	}
	
}
