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
@XmlType(name = "HIVRiskAssessmentType", propOrder = { "everHadSexualIntercourse", "bloodTransfussionInLast3Months",
        "unprotectedSexWithCasualPartnerinLast3Months", "unprotectedSexWithRegularPartnerInLast3Months",
        "moreThan1SexPartnerDuringLast3Months", "sTIInLast3Months" })
public class HIVRiskAssessmentType {
	
	@XmlElement(name = "EverHadSexualIntercourse")
	protected Boolean everHadSexualIntercourse;
	
	@XmlElement(name = "BloodTransfussionInLast3Months")
	protected Boolean bloodTransfussionInLast3Months;
	
	@XmlElement(name = "UnprotectedSexWithCasualPartnerinLast3Months")
	protected Boolean unprotectedSexWithCasualPartnerinLast3Months;
	
	@XmlElement(name = "UnprotectedSexWithRegularPartnerInLast3Months")
	protected Boolean unprotectedSexWithRegularPartnerInLast3Months;
	
	@XmlElement(name = "MoreThan1SexPartnerDuringLast3Months")
	protected Boolean moreThan1SexPartnerDuringLast3Months;
	
	@XmlElement(name = "STIInLast3Months")
	protected Boolean sTIInLast3Months;
	
	public Boolean getEverHadSexualIntercourse() {
		return everHadSexualIntercourse;
	}
	
	public void setEverHadSexualIntercourse(Boolean everHadSexualIntercourse) {
		this.everHadSexualIntercourse = everHadSexualIntercourse;
	}
	
	public Boolean getBloodTransfussionInLast3Months() {
		return bloodTransfussionInLast3Months;
	}
	
	public void setBloodTransfussionInLast3Months(Boolean bloodTransfussionInLast3Months) {
		this.bloodTransfussionInLast3Months = bloodTransfussionInLast3Months;
	}
	
	public Boolean getUnprotectedSexWithCasualPartnerinLast3Months() {
		return unprotectedSexWithCasualPartnerinLast3Months;
	}
	
	public void setUnprotectedSexWithCasualPartnerinLast3Months(Boolean unprotectedSexWithCasualPartnerinLast3Months) {
		this.unprotectedSexWithCasualPartnerinLast3Months = unprotectedSexWithCasualPartnerinLast3Months;
	}
	
	public Boolean getUnprotectedSexWithRegularPartnerInLast3Months() {
		return unprotectedSexWithRegularPartnerInLast3Months;
	}
	
	public void setUnprotectedSexWithRegularPartnerInLast3Months(Boolean unprotectedSexWithRegularPartnerInLast3Months) {
		this.unprotectedSexWithRegularPartnerInLast3Months = unprotectedSexWithRegularPartnerInLast3Months;
	}
	
	public Boolean getMoreThan1SexPartnerDuringLast3Months() {
		return moreThan1SexPartnerDuringLast3Months;
	}
	
	public void setMoreThan1SexPartnerDuringLast3Months(Boolean moreThan1SexPartnerDuringLast3Months) {
		this.moreThan1SexPartnerDuringLast3Months = moreThan1SexPartnerDuringLast3Months;
	}
	
	public Boolean getsTIInLast3Months() {
		return sTIInLast3Months;
	}
	
	public void setsTIInLast3Months(Boolean sTIInLast3Months) {
		this.sTIInLast3Months = sTIInLast3Months;
	}
	
	public boolean isEmpty() {
		if (this.bloodTransfussionInLast3Months == null && this.moreThan1SexPartnerDuringLast3Months == null
		        && this.everHadSexualIntercourse == null && this.sTIInLast3Months == null
		        && this.unprotectedSexWithCasualPartnerinLast3Months == null
		        && this.unprotectedSexWithRegularPartnerInLast3Months == null)
			return true;
		else
			return false;
	}
	
}
