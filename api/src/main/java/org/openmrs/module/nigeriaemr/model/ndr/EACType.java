package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for EACType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EACType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="AssessmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EACSessionType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FS"/>
 *               &lt;enumeration value="SS"/>
 *               &lt;enumeration value="TS"/>
 *               &lt;enumeration value="OS"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ARVPlan" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="AV1"/>
 *               &lt;enumeration value="AV2"/>
 *               &lt;enumeration value="AV3"/>
 *               &lt;enumeration value="AV4"/>
 *               &lt;enumeration value="AV5"/>
 *               &lt;enumeration value="AV6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SessionNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Session1"/>
 *               &lt;enumeration value="Session2"/>
 *               &lt;enumeration value="Session3"/>
 *               &lt;enumeration value="Session4"/>
 *               &lt;enumeration value="Session5"/>
 *               &lt;enumeration value="Session6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AdherenceLevel" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Good"/>
 *               &lt;enumeration value="Fair"/>
 *               &lt;enumeration value="Poor"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MissedDoses" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="BarrierType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Forgot"/>
 *               &lt;enumeration value="KnowledgeBeliefs"/>
 *               &lt;enumeration value="SideEffects"/>
 *               &lt;enumeration value="PhysicalIllness"/>
 *               &lt;enumeration value="SubstanceUse"/>
 *               &lt;enumeration value="Depression"/>
 *               &lt;enumeration value="PillBurden"/>
 *               &lt;enumeration value="LostRanOutOfDrugs"/>
 *               &lt;enumeration value="Transport"/>
 *               &lt;enumeration value="ChildRefusing"/>
 *               &lt;enumeration value="Scheduling"/>
 *               &lt;enumeration value="FearDisclosureFamilyPartner"/>
 *               &lt;enumeration value="FoodInsecurity"/>
 *               &lt;enumeration value="DrugStockOut"/>
 *               &lt;enumeration value="LongWaitingTime"/>
 *               &lt;enumeration value="Stigma"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InterventionProvided" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Education"/>
 *               &lt;enumeration value="CounselingIndividual"/>
 *               &lt;enumeration value="CounselingGroup"/>
 *               &lt;enumeration value="PeerSupport"/>
 *               &lt;enumeration value="TreatmentBuddy"/>
 *               &lt;enumeration value="ExtendedDrugPickUp"/>
 *               &lt;enumeration value="CommunityARTGroup"/>
 *               &lt;enumeration value="DirectlyObservedTherapy"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InterventionTool" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="PillBox"/>
 *               &lt;enumeration value="Calendar"/>
 *               &lt;enumeration value="IncentiveCalendarPeds"/>
 *               &lt;enumeration value="ARVSwallowingInstruction"/>
 *               &lt;enumeration value="WrittenInstructions"/>
 *               &lt;enumeration value="PhoneCallsSMS"/>
 *               &lt;enumeration value="Alarms"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FollowupDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RepeatVLSampleCollectedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RepeatViralLoadResult" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="RepeatVLResultReceivedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RepeatVLOutcomeCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Undetectable"/>
 *               &lt;enumeration value="SuppressedButDetectable"/>
 *               &lt;enumeration value="Unsuppressed"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VLPlanOutcomeCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="RemainOnCurrentRegimen"/>
 *               &lt;enumeration value="RegimenSwitchedBySwitchCommittee"/>
 *               &lt;enumeration value="ReferToDoctorForFurtherManagement"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VLPlanOutcomeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EACMonitoringOutcomeCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="EACCompleted"/>
 *               &lt;enumeration value="EACStopped"/>
 *               &lt;enumeration value="Dead"/>
 *               &lt;enumeration value="LostToFollowUp"/>
 *               &lt;enumeration value="TransferredOut"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EACType", propOrder = { "visitID", "visitDate", "assessmentDate", "eacSessionType", "arvPlan",
        "sessionNumber", "adherenceLevel", "missedDoses", "barrierType", "interventionProvided", "interventionTool",
        "followupDate", "repeatVLSampleCollectedDate", "repeatViralLoadResult", "repeatVLResultReceivedDate",
        "repeatVLOutcomeCode", "vlPlanOutcomeCode", "vlPlanOutcomeDate", "eacMonitoringOutcomeCode" })
public class EACType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "AssessmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar assessmentDate;
	
	@XmlElement(name = "EACSessionType")
	protected String eacSessionType;
	
	@XmlElement(name = "ARVPlan")
	protected String arvPlan;
	
	@XmlElement(name = "SessionNumber")
	protected String sessionNumber;
	
	@XmlElement(name = "AdherenceLevel")
	protected String adherenceLevel;
	
	@XmlElement(name = "MissedDoses")
	@XmlSchemaType(name = "string")
	protected YNCodeType missedDoses;
	
	@XmlElement(name = "BarrierType")
	protected String barrierType;
	
	@XmlElement(name = "InterventionProvided")
	protected String interventionProvided;
	
	@XmlElement(name = "InterventionTool")
	protected String interventionTool;
	
	@XmlElement(name = "FollowupDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar followupDate;
	
	@XmlElement(name = "RepeatVLSampleCollectedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar repeatVLSampleCollectedDate;
	
	@XmlElement(name = "RepeatViralLoadResult")
	protected BigDecimal repeatViralLoadResult;
	
	@XmlElement(name = "RepeatVLResultReceivedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar repeatVLResultReceivedDate;
	
	@XmlElement(name = "RepeatVLOutcomeCode")
	protected String repeatVLOutcomeCode;
	
	@XmlElement(name = "VLPlanOutcomeCode")
	protected String vlPlanOutcomeCode;
	
	@XmlElement(name = "VLPlanOutcomeDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar vlPlanOutcomeDate;
	
	@XmlElement(name = "EACMonitoringOutcomeCode")
	protected String eacMonitoringOutcomeCode;
	
	/**
	 * Gets the value of the visitID property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitID() {
		return visitID;
	}
	
	/**
	 * Sets the value of the visitID property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitID(String value) {
		this.visitID = value;
	}
	
	/**
	 * Gets the value of the visitDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getVisitDate() {
		return visitDate;
	}
	
	/**
	 * Sets the value of the visitDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setVisitDate(XMLGregorianCalendar value) {
		this.visitDate = value;
	}
	
	/**
	 * Gets the value of the assessmentDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getAssessmentDate() {
		return assessmentDate;
	}
	
	/**
	 * Sets the value of the assessmentDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setAssessmentDate(XMLGregorianCalendar value) {
		this.assessmentDate = value;
	}
	
	/**
	 * Gets the value of the eacSessionType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEACSessionType() {
		return eacSessionType;
	}
	
	/**
	 * Sets the value of the eacSessionType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEACSessionType(String value) {
		this.eacSessionType = value;
	}
	
	/**
	 * Gets the value of the arvPlan property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getARVPlan() {
		return arvPlan;
	}
	
	/**
	 * Sets the value of the arvPlan property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setARVPlan(String value) {
		this.arvPlan = value;
	}
	
	/**
	 * Gets the value of the sessionNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSessionNumber() {
		return sessionNumber;
	}
	
	/**
	 * Sets the value of the sessionNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSessionNumber(String value) {
		this.sessionNumber = value;
	}
	
	/**
	 * Gets the value of the adherenceLevel property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAdherenceLevel() {
		return adherenceLevel;
	}
	
	/**
	 * Sets the value of the adherenceLevel property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAdherenceLevel(String value) {
		this.adherenceLevel = value;
	}
	
	/**
	 * Gets the value of the missedDoses property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getMissedDoses() {
		return missedDoses;
	}
	
	/**
	 * Sets the value of the missedDoses property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setMissedDoses(YNCodeType value) {
		this.missedDoses = value;
	}
	
	/**
	 * Gets the value of the barrierType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBarrierType() {
		return barrierType;
	}
	
	/**
	 * Sets the value of the barrierType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBarrierType(String value) {
		this.barrierType = value;
	}
	
	/**
	 * Gets the value of the interventionProvided property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInterventionProvided() {
		return interventionProvided;
	}
	
	/**
	 * Sets the value of the interventionProvided property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInterventionProvided(String value) {
		this.interventionProvided = value;
	}
	
	/**
	 * Gets the value of the interventionTool property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInterventionTool() {
		return interventionTool;
	}
	
	/**
	 * Sets the value of the interventionTool property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInterventionTool(String value) {
		this.interventionTool = value;
	}
	
	/**
	 * Gets the value of the followupDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFollowupDate() {
		return followupDate;
	}
	
	/**
	 * Sets the value of the followupDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFollowupDate(XMLGregorianCalendar value) {
		this.followupDate = value;
	}
	
	/**
	 * Gets the value of the repeatVLSampleCollectedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRepeatVLSampleCollectedDate() {
		return repeatVLSampleCollectedDate;
	}
	
	/**
	 * Sets the value of the repeatVLSampleCollectedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRepeatVLSampleCollectedDate(XMLGregorianCalendar value) {
		this.repeatVLSampleCollectedDate = value;
	}
	
	/**
	 * Gets the value of the repeatViralLoadResult property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getRepeatViralLoadResult() {
		return repeatViralLoadResult;
	}
	
	/**
	 * Sets the value of the repeatViralLoadResult property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setRepeatViralLoadResult(BigDecimal value) {
		this.repeatViralLoadResult = value;
	}
	
	/**
	 * Gets the value of the repeatVLResultReceivedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRepeatVLResultReceivedDate() {
		return repeatVLResultReceivedDate;
	}
	
	/**
	 * Sets the value of the repeatVLResultReceivedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRepeatVLResultReceivedDate(XMLGregorianCalendar value) {
		this.repeatVLResultReceivedDate = value;
	}
	
	/**
	 * Gets the value of the repeatVLOutcomeCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRepeatVLOutcomeCode() {
		return repeatVLOutcomeCode;
	}
	
	/**
	 * Sets the value of the repeatVLOutcomeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRepeatVLOutcomeCode(String value) {
		this.repeatVLOutcomeCode = value;
	}
	
	/**
	 * Gets the value of the vlPlanOutcomeCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVLPlanOutcomeCode() {
		return vlPlanOutcomeCode;
	}
	
	/**
	 * Sets the value of the vlPlanOutcomeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVLPlanOutcomeCode(String value) {
		this.vlPlanOutcomeCode = value;
	}
	
	/**
	 * Gets the value of the vlPlanOutcomeDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getVLPlanOutcomeDate() {
		return vlPlanOutcomeDate;
	}
	
	/**
	 * Sets the value of the vlPlanOutcomeDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setVLPlanOutcomeDate(XMLGregorianCalendar value) {
		this.vlPlanOutcomeDate = value;
	}
	
	/**
	 * Gets the value of the eacMonitoringOutcomeCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEACMonitoringOutcomeCode() {
		return eacMonitoringOutcomeCode;
	}
	
	/**
	 * Sets the value of the eacMonitoringOutcomeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEACMonitoringOutcomeCode(String value) {
		this.eacMonitoringOutcomeCode = value;
	}
	
}
