//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.06.20 at 12:35:09 PM WAT
//

package org.openmrs.module.nigeriaemr.model.ndr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TBType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TBType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TBScreeningIPTmonitoring" type="{}TBScreeningIPTmonitoringType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommunityAndFacilityReferral" type="{}TBCommunityAndFacilityReferralType" minOccurs="0"/>
 *         &lt;element name="IndexPatientContactInvestigation" type="{}TBIndexPatientContactInvestigationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InterruptionTracking" type="{}TBInterruptionTrackingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LaboratoryRegister" type="{}TBLaboratoryRegisterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PatientReferral" type="{}TBPatientReferralType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Screening" type="{}TBScreeningType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TreatmentMonitoring" type="{}TBTreatmentMonitoringType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DRTBTreatmentRegister" type="{}DRTBTreatmentRegisterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DRTBInPatientDischargeForm" type="{}DRTBInPatientDischargeFormType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LGAHealthFacilityTBCentralRegister" type="{}LGAHealthFacilityTBCentralRegisterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PresumptiveTBRegister" type="{}PresumptiveTBRegisterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecimenExaminationRequestForm" type="{}SpecimenExaminationRequestFormType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SpecimenExaminationResultForm" type="{}SpecimenExaminationResultFormType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TBType", propOrder = { "tbScreeningIPTmonitoring", "screening", "communityAndFacilityReferral",
        "indexPatientContactInvestigation", "interruptionTracking", "laboratoryRegister", "patientReferral",
        "treatmentMonitoring", "drtbTreatmentRegister", "drtbInPatientDischargeForm", "lgaHealthFacilityTBCentralRegister",
        "presumptiveTBRegister", "specimenExaminationRequestForm", "specimenExaminationResultForm",
/*"tbPatientTreatmentCardForm"*/})
public class TBType {
	
	@XmlElement(name = "TBScreeningIPTmonitoring")
	protected List<TBScreeningIPTmonitoringType> tbScreeningIPTmonitoring;
	
	@XmlElement(name = "Screening")
	protected List<TBScreeningType> screening;
	
	@XmlElement(name = "CommunityAndFacilityReferral")
	protected List<TBCommunityAndFacilityReferralType> communityAndFacilityReferral;
	
	@XmlElement(name = "IndexPatientContactInvestigation")
	protected List<TBIndexPatientContactInvestigationType> indexPatientContactInvestigation;
	
	@XmlElement(name = "InterruptionTracking")
	protected List<TBInterruptionTrackingType> interruptionTracking;
	
	@XmlElement(name = "LaboratoryRegister")
	protected List<TBLaboratoryRegisterType> laboratoryRegister;
	
	@XmlElement(name = "PatientReferral")
	protected List<TBPatientReferralType> patientReferral;
	
	@XmlElement(name = "TreatmentMonitoring")
	protected List<TBTreatmentMonitoringType> treatmentMonitoring;
	
	@XmlElement(name = "DRTBTreatmentRegister")
	protected List<DRTBTreatmentRegisterType> drtbTreatmentRegister;
	
	@XmlElement(name = "DRTBInPatientDischargeForm")
	protected List<DRTBInPatientDischargeFormType> drtbInPatientDischargeForm;
	
	@XmlElement(name = "LGAHealthFacilityTBCentralRegister")
	protected List<LGAHealthFacilityTBCentralRegisterType> lgaHealthFacilityTBCentralRegister;
	
	@XmlElement(name = "PresumptiveTBRegister")
	protected List<PresumptiveTBRegisterType> presumptiveTBRegister;
	
	@XmlElement(name = "SpecimenExaminationRequestForm")
	protected List<SpecimenExaminationRequestFormType> specimenExaminationRequestForm;
	
	@XmlElement(name = "SpecimenExaminationResultForm")
	protected List<SpecimenExaminationResultFormType> specimenExaminationResultForm;
	
	/*@XmlElement(name = "TBPatientTreatmentCardForm")
	protected List<TBPatientTreatmentCardFormType> tbPatientTreatmentCardForm;*/
	
	/**
	 * Gets the value of the tbScreeningIPTmonitoring property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the tbScreeningIPTmonitoring property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getTBScreeningIPTmonitoring().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBScreeningIPTmonitoringType }
	 */
	public List<TBScreeningIPTmonitoringType> getTBScreeningIPTmonitoring() {
		if (tbScreeningIPTmonitoring == null) {
			tbScreeningIPTmonitoring = new ArrayList<TBScreeningIPTmonitoringType>();
		}
		return this.tbScreeningIPTmonitoring;
	}
	
	public void setTBScreeningIPTmonitoringType(List<TBScreeningIPTmonitoringType> tbScreeningIPTmonitoring) {
		this.tbScreeningIPTmonitoring = tbScreeningIPTmonitoring;
	}
	
	/**
	 * Gets the value of the communityAndFacilityReferral property.
	 * 
	 * @return possible object is {@link TBCommunityAndFacilityReferralType }
	 */
	public List<TBCommunityAndFacilityReferralType> communityAndFacilityReferral() {
		return communityAndFacilityReferral;
	}
	
	/**
	 * Sets the value of the communityAndFacilityReferral property.
	 * 
	 * @param communityAndFacilityReferral allowed object is
	 *            {@link TBCommunityAndFacilityReferralType }
	 */
	public void setCommunityAndFacilityReferral(List<TBCommunityAndFacilityReferralType> communityAndFacilityReferral) {
		this.communityAndFacilityReferral = communityAndFacilityReferral;
	}
	
	/**
	 * Gets the value of the indexPatientContactInvestigation property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the indexPatientContactInvestigation property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getIndexPatientContactInvestigation().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link TBIndexPatientContactInvestigationType }
	 */
	/*public List<TBIndexPatientContactInvestigationType> getIndexPatientContactInvestigation() {
		if (indexPatientContactInvestigation == null) {
			indexPatientContactInvestigation = new ArrayList<TBIndexPatientContactInvestigationType>();
		}
		return this.indexPatientContactInvestigation;
	}*/
	
	public List<TBIndexPatientContactInvestigationType> indexPatientContactInvestigation() {
		return indexPatientContactInvestigation;
	}
	
	public void setIndexPatientContactInvestigation(
	        List<TBIndexPatientContactInvestigationType> indexPatientContactInvestigation) {
		this.indexPatientContactInvestigation = indexPatientContactInvestigation;
	}
	
	/**
	 * Gets the value of the interruptionTracking property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the interruptionTracking property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getInterruptionTracking().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBInterruptionTrackingType }
	 */
	public List<TBInterruptionTrackingType> getInterruptionTracking() {
		if (interruptionTracking == null) {
			interruptionTracking = new ArrayList<TBInterruptionTrackingType>();
		}
		return this.interruptionTracking;
	}
	
	public void setInterruptionTracking(List<TBInterruptionTrackingType> interruptionTracking) {
		this.interruptionTracking = interruptionTracking;
	}
	
	/**
	 * Gets the value of the laboratoryRegister property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the laboratoryRegister property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getLaboratoryRegister().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBLaboratoryRegisterType }
	 */
	public List<TBLaboratoryRegisterType> getLaboratoryRegister() {
		if (laboratoryRegister == null) {
			laboratoryRegister = new ArrayList<TBLaboratoryRegisterType>();
		}
		return this.laboratoryRegister;
	}
	
	public void setLaboratoryRegister(List<TBLaboratoryRegisterType> laboratoryRegister) {
		this.laboratoryRegister = laboratoryRegister;
	}
	
	/**
	 * Gets the value of the patientReferral property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the patientReferral property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPatientReferral().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBPatientReferralType }
	 */
	public List<TBPatientReferralType> getPatientReferral() {
		if (patientReferral == null) {
			patientReferral = new ArrayList<TBPatientReferralType>();
		}
		return this.patientReferral;
	}
	
	public void setPatientReferralType(List<TBPatientReferralType> patientReferral) {
		this.patientReferral = patientReferral;
	}
	
	/**
	 * Gets the value of the screening property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the screening property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getScreening().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBScreeningType }
	 */
	/*public List<TBScreeningType> getScreening() {
		if (screening == null) {
			screening = new ArrayList<TBScreeningType>();
		}
		return this.screening;
	}

	public void setScreening(List<TBScreeningType> screening) {
		this.screening = screening;
	}*/
	
	public List<TBScreeningType> screening() {
		return screening;
	}
	
	public void setScreening(List<TBScreeningType> screening) {
		this.screening = screening;
	}
	
	/**
	 * Gets the value of the treatmentMonitoring property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the treatmentMonitoring property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getTreatmentMonitoring().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TBTreatmentMonitoringType }
	 */
	public List<TBTreatmentMonitoringType> getTreatmentMonitoring() {
		if (treatmentMonitoring == null) {
			treatmentMonitoring = new ArrayList<TBTreatmentMonitoringType>();
		}
		return this.treatmentMonitoring;
	}
	
	public void setTreatmentMonitoring(List<TBTreatmentMonitoringType> treatmentMonitoring) {
		this.treatmentMonitoring = treatmentMonitoring;
	}
	
	/**
	 * Gets the value of the drtbTreatmentRegister property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the drtbTreatmentRegister property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getDRTBTreatmentRegister().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DRTBTreatmentRegisterType }
	 */
	public List<DRTBTreatmentRegisterType> getDRTBTreatmentRegister() {
		if (drtbTreatmentRegister == null) {
			drtbTreatmentRegister = new ArrayList<DRTBTreatmentRegisterType>();
		}
		return this.drtbTreatmentRegister;
	}
	
	public void setDRTBTreatmentRegister(List<DRTBTreatmentRegisterType> drtbTreatmentRegister) {
		this.drtbTreatmentRegister = drtbTreatmentRegister;
	}
	
	/**
	 * Gets the value of the drtbInPatientDischargeForm property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the drtbInPatientDischargeForm property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getDRTBInPatientDischargeForm().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DRTBInPatientDischargeFormType }
	 */
	public List<DRTBInPatientDischargeFormType> getDRTBInPatientDischargeForm() {
		if (drtbInPatientDischargeForm == null) {
			drtbInPatientDischargeForm = new ArrayList<DRTBInPatientDischargeFormType>();
		}
		return this.drtbInPatientDischargeForm;
	}
	
	public void setDRTBInPatientDischargeForm(List<DRTBInPatientDischargeFormType> drtbInPatientDischargeForm) {
		this.drtbInPatientDischargeForm = drtbInPatientDischargeForm;
	}
	
	/**
	 * Gets the value of the lgaHealthFacilityTBCentralRegister property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the lgaHealthFacilityTBCentralRegister
	 * property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getLGAHealthFacilityTBCentralRegister().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link LGAHealthFacilityTBCentralRegisterType }
	 */
	public List<LGAHealthFacilityTBCentralRegisterType> getLGAHealthFacilityTBCentralRegister() {
		if (lgaHealthFacilityTBCentralRegister == null) {
			lgaHealthFacilityTBCentralRegister = new ArrayList<LGAHealthFacilityTBCentralRegisterType>();
		}
		return this.lgaHealthFacilityTBCentralRegister;
	}
	
	public void setLGAHealthFacilityTBCentralRegister(
	        List<LGAHealthFacilityTBCentralRegisterType> lgaHealthFacilityTBCentralRegister) {
		this.lgaHealthFacilityTBCentralRegister = lgaHealthFacilityTBCentralRegister;
	}
	
	/**
	 * Gets the value of the presumptiveTBRegister property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the presumptiveTBRegister property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPresumptiveTBRegister().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PresumptiveTBRegisterType }
	 */
	public List<PresumptiveTBRegisterType> getPresumptiveTBRegister() {
		if (presumptiveTBRegister == null) {
			presumptiveTBRegister = new ArrayList<PresumptiveTBRegisterType>();
		}
		return this.presumptiveTBRegister;
	}
	
	public void setPresumptiveTBRegister(List<PresumptiveTBRegisterType> presumptiveTBRegister) {
		this.presumptiveTBRegister = presumptiveTBRegister;
	}
	
	/**
	 * Gets the value of the specimenExaminationRequestForm property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the specimenExaminationRequestForm property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getSpecimenExaminationRequestForm().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SpecimenExaminationRequestFormType }
	 */
	public List<SpecimenExaminationRequestFormType> getSpecimenExaminationRequestForm() {
		if (specimenExaminationRequestForm == null) {
			specimenExaminationRequestForm = new ArrayList<SpecimenExaminationRequestFormType>();
		}
		return this.specimenExaminationRequestForm;
	}
	
	public void setSpecimenExaminationRequestForm(List<SpecimenExaminationRequestFormType> specimenExaminationRequestForm) {
		this.specimenExaminationRequestForm = specimenExaminationRequestForm;
	}
	
	/**
	 * Gets the value of the specimenExaminationResultForm property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the specimenExaminationResultForm property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getSpecimenExaminationResultForm().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SpecimenExaminationResultFormType }
	 */
	
	public List<SpecimenExaminationResultFormType> getSpecimenExaminationResultForm() {
		return specimenExaminationResultForm;
	}
	
	public void setSpecimenExaminationResultForm(List<SpecimenExaminationResultFormType> specimenExaminationResultForm) {
		this.specimenExaminationResultForm = specimenExaminationResultForm;
	}
	
	/*public List<TBPatientTreatmentCardFormType> getTBPatientTreatmentCardForm() {
	    if (tbPatientTreatmentCardForm == null) {
	        tbPatientTreatmentCardForm = new ArrayList<TBPatientTreatmentCardFormType>();
	    }
	    return this.tbPatientTreatmentCardForm;
	}

	public void setTBPatientTreatmentCardForm(List<TBPatientTreatmentCardFormType> tbPatientTreatmentCardForm) {
	    this.tbPatientTreatmentCardForm = tbPatientTreatmentCardForm;
	}*/
	
}