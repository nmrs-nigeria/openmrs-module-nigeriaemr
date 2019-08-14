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
@XmlType(name = "PostTestCounsellingType", propOrder = { "testedForHIVBeforeWithinThisYear",
        "hIVRequestAndResultFormSignedByTester", "hIVRequestAndResultFormFilledWithCTIForm", "clientRecievedHIVTestResult",
        "postTestCounsellingDone", "riskReductionPlanDeveloped", "postTestDisclosurePlanDeveloped",
        "willBringPartnerForHIVTesting", "willBringOwnChildrenForHIVTesting",
        "providedWithInformationOnFPandDualContraception", "clientOrPartnerUseFPMethodsOtherThanCondoms",
        "clientOrPartnerUseCondomsAsOneFPMethods", "correctCondomUseDemonstrated", "condomsProvidedToClient",
        "clientReferredToOtherServices" })
public class PostTestCounsellingType {
	
	@XmlElement(name = "TestedForHIVBeforeWithinThisYear", required = true)
	protected String testedForHIVBeforeWithinThisYear;
	
	@XmlElement(name = "HIVRequestAndResultFormSignedByTester")
	protected Boolean hIVRequestAndResultFormSignedByTester;
	
	@XmlElement(name = "HIVRequestAndResultFormFilledWithCTIForm")
	protected Boolean hIVRequestAndResultFormFilledWithCTIForm;
	
	@XmlElement(name = "ClientRecievedHIVTestResult")
	protected Boolean clientRecievedHIVTestResult;
	
	@XmlElement(name = "PostTestCounsellingDone")
	protected Boolean postTestCounsellingDone;
	
	@XmlElement(name = "RiskReductionPlanDeveloped")
	protected Boolean riskReductionPlanDeveloped;
	
	@XmlElement(name = "PostTestDisclosurePlanDeveloped")
	protected Boolean postTestDisclosurePlanDeveloped;
	
	@XmlElement(name = "WillBringPartnerForHIVTesting", required = true)
	protected Boolean willBringPartnerForHIVTesting;
	
	@XmlElement(name = "WillBringOwnChildrenForHIVTesting")
	protected Boolean willBringOwnChildrenForHIVTesting;
	
	@XmlElement(name = "ProvidedWithInformationOnFPandDualContraception")
	protected Boolean providedWithInformationOnFPandDualContraception;
	
	@XmlElement(name = "ClientOrPartnerUseFPMethodsOtherThanCondoms")
	protected Boolean clientOrPartnerUseFPMethodsOtherThanCondoms;
	
	@XmlElement(name = "ClientOrPartnerUseCondomsAsOneFPMethods")
	protected Boolean clientOrPartnerUseCondomsAsOneFPMethods;
	
	@XmlElement(name = "CorrectCondomUseDemonstrated")
	protected Boolean correctCondomUseDemonstrated;
	
	@XmlElement(name = "CondomsProvidedToClient")
	protected Boolean condomsProvidedToClient;
	
	@XmlElement(name = "ClientReferredToOtherServices", required = true)
	protected Boolean clientReferredToOtherServices;
	
	public String getTestedForHIVBeforeWithinThisYear() {
		return testedForHIVBeforeWithinThisYear;
	}
	
	public void setTestedForHIVBeforeWithinThisYear(String testedForHIVBeforeWithinThisYear) {
		this.testedForHIVBeforeWithinThisYear = testedForHIVBeforeWithinThisYear;
	}
	
	public Boolean gethIVRequestAndResultFormSignedByTester() {
		return hIVRequestAndResultFormSignedByTester;
	}
	
	public void sethIVRequestAndResultFormSignedByTester(Boolean hIVRequestAndResultFormSignedByTester) {
		this.hIVRequestAndResultFormSignedByTester = hIVRequestAndResultFormSignedByTester;
	}
	
	public Boolean gethIVRequestAndResultFormFilledWithCTIForm() {
		return hIVRequestAndResultFormFilledWithCTIForm;
	}
	
	public void sethIVRequestAndResultFormFilledWithCTIForm(Boolean hIVRequestAndResultFormFilledWithCTIForm) {
		this.hIVRequestAndResultFormFilledWithCTIForm = hIVRequestAndResultFormFilledWithCTIForm;
	}
	
	public Boolean getClientRecievedHIVTestResult() {
		return clientRecievedHIVTestResult;
	}
	
	public void setClientRecievedHIVTestResult(Boolean clientRecievedHIVTestResult) {
		this.clientRecievedHIVTestResult = clientRecievedHIVTestResult;
	}
	
	public Boolean getPostTestCounsellingDone() {
		return postTestCounsellingDone;
	}
	
	public void setPostTestCounsellingDone(Boolean postTestCounsellingDone) {
		this.postTestCounsellingDone = postTestCounsellingDone;
	}
	
	public Boolean getRiskReductionPlanDeveloped() {
		return riskReductionPlanDeveloped;
	}
	
	public void setRiskReductionPlanDeveloped(Boolean riskReductionPlanDeveloped) {
		this.riskReductionPlanDeveloped = riskReductionPlanDeveloped;
	}
	
	public Boolean getPostTestDisclosurePlanDeveloped() {
		return postTestDisclosurePlanDeveloped;
	}
	
	public void setPostTestDisclosurePlanDeveloped(Boolean postTestDisclosurePlanDeveloped) {
		this.postTestDisclosurePlanDeveloped = postTestDisclosurePlanDeveloped;
	}
	
	public Boolean getWillBringPartnerForHIVTesting() {
		return willBringPartnerForHIVTesting;
	}
	
	public void setWillBringPartnerForHIVTesting(Boolean willBringPartnerForHIVTesting) {
		this.willBringPartnerForHIVTesting = willBringPartnerForHIVTesting;
	}
	
	public Boolean getWillBringOwnChildrenForHIVTesting() {
		return willBringOwnChildrenForHIVTesting;
	}
	
	public void setWillBringOwnChildrenForHIVTesting(Boolean willBringOwnChildrenForHIVTesting) {
		this.willBringOwnChildrenForHIVTesting = willBringOwnChildrenForHIVTesting;
	}
	
	public Boolean getProvidedWithInformationOnFPandDualContraception() {
		return providedWithInformationOnFPandDualContraception;
	}
	
	public void setProvidedWithInformationOnFPandDualContraception(Boolean providedWithInformationOnFPandDualContraception) {
		this.providedWithInformationOnFPandDualContraception = providedWithInformationOnFPandDualContraception;
	}
	
	public Boolean getClientOrPartnerUseFPMethodsOtherThanCondoms() {
		return clientOrPartnerUseFPMethodsOtherThanCondoms;
	}
	
	public void setClientOrPartnerUseFPMethodsOtherThanCondoms(Boolean clientOrPartnerUseFPMethodsOtherThanCondoms) {
		this.clientOrPartnerUseFPMethodsOtherThanCondoms = clientOrPartnerUseFPMethodsOtherThanCondoms;
	}
	
	public Boolean getClientOrPartnerUseCondomsAsOneFPMethods() {
		return clientOrPartnerUseCondomsAsOneFPMethods;
	}
	
	public void setClientOrPartnerUseCondomsAsOneFPMethods(Boolean clientOrPartnerUseCondomsAsOneFPMethods) {
		this.clientOrPartnerUseCondomsAsOneFPMethods = clientOrPartnerUseCondomsAsOneFPMethods;
	}
	
	public Boolean getCorrectCondomUseDemonstrated() {
		return correctCondomUseDemonstrated;
	}
	
	public void setCorrectCondomUseDemonstrated(Boolean correctCondomUseDemonstrated) {
		this.correctCondomUseDemonstrated = correctCondomUseDemonstrated;
	}
	
	public Boolean getCondomsProvidedToClient() {
		return condomsProvidedToClient;
	}
	
	public void setCondomsProvidedToClient(Boolean condomsProvidedToClient) {
		this.condomsProvidedToClient = condomsProvidedToClient;
	}
	
	public Boolean getClientReferredToOtherServices() {
		return clientReferredToOtherServices;
	}
	
	public void setClientReferredToOtherServices(Boolean clientReferredToOtherServices) {
		this.clientReferredToOtherServices = clientReferredToOtherServices;
	}
	
}
