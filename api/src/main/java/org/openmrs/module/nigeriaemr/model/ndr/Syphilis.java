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

/**
 * @author Bodyofchrist
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Syphilis", propOrder = { "testedForSyphilis", "syphilisTestResult", "treatedForSyphilis", "syphilisResult",
        "referredSyphilisPositiveClient" })
public class Syphilis {
	
	@XmlElement(name = "TestedForSyphilis", required = true)
	protected String testedForSyphilis;
	
	@XmlElement(name = "SyphilisTestResult", required = true)
	protected String syphilisTestResult;
	
	@XmlElement(name = "TreatedForSyphilis", required = true)
	protected String treatedForSyphilis;
	
	@XmlElement(name = "SyphilisResult", required = true)
	protected String syphilisResult;
	
	@XmlElement(name = "ReferredSyphilisPositiveClient", required = true)
	protected String referredSyphilisPositiveClient;
	
	public String getTestedForSyphilis() {
		return testedForSyphilis;
	}
	
	public void setTestedForSyphilis(String testedForSyphilis) {
		this.testedForSyphilis = testedForSyphilis;
	}
	
	public String getSyphilisTestResult() {
		return syphilisTestResult;
	}
	
	public void setSyphilisTestResult(String syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	}
	
	public String getTreatedForSyphilis() {
		return treatedForSyphilis;
	}
	
	public void setTreatedForSyphilis(String treatedForSyphilis) {
		this.treatedForSyphilis = treatedForSyphilis;
	}
	
	public String getSyphilisResult() {
		return syphilisResult;
	}
	
	public void setSyphilisResult(String syphilisResult) {
		this.syphilisResult = syphilisResult;
	}
	
	public String getReferredSyphilisPositiveClient() {
		return referredSyphilisPositiveClient;
	}
	
	public void setReferredSyphilisPositiveClient(String referredSyphilisPositiveClient) {
		this.referredSyphilisPositiveClient = referredSyphilisPositiveClient;
	}
	
}
