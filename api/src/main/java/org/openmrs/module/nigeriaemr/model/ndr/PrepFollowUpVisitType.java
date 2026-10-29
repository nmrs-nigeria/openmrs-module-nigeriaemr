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
 * Java class for PrepFollowUpVisitType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepFollowUpVisitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="VisitType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DurationOnPrepMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PregnancyStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="BF"/>
 *               &lt;enumeration value="NP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BloodPressure" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="HtsResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NotedSideEffects" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SyndromicSTIScreening" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RiskReductionServices" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Adherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReasonForPoorFairAdherence" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PrepType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PrepRegimen" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MonthsOfRefill" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="OtherDrugsPrescribed" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="DateOfUrinalysis" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="UrinalysisResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfHepatitisTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HepatitisTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfSyphilisTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SyphilisTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfLiverFunctionTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LiverFunctionTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *               &lt;enumeration value="12"/>
 *               &lt;enumeration value="13"/>
 *               &lt;enumeration value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfOtherTests" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="OtherTestsResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="6"/>
 *               &lt;enumeration value="7"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="9"/>
 *               &lt;enumeration value="10"/>
 *               &lt;enumeration value="11"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SuspectedAcuteInfection" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EarlyHivDetectionViralLoadResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="TargetDetected"/>
 *               &lt;enumeration value="TargetNotDetected"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NextAppointmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepFollowUpVisitType", propOrder = { "visitID", "visitDate", "visitType", "durationOnPrepMonths",
        "pregnancyStatus", "weight", "bloodPressure", "htsResult", "notedSideEffects", "syndromicSTIScreening",
        "riskReductionServices", "adherence", "reasonForPoorFairAdherence", "prepType", "prepRegimen", "monthsOfRefill",
        "otherDrugsPrescribed", "dateOfUrinalysis", "urinalysisResult", "dateOfHepatitisTest", "hepatitisTestResult",
        "dateOfSyphilisTest", "syphilisTestResult", "dateOfLiverFunctionTest", "liverFunctionTestResult",
        "dateOfOtherTests", "otherTestsResult", "suspectedAcuteInfection", "earlyHivDetectionViralLoadResult",
        "nextAppointmentDate" })
public class PrepFollowUpVisitType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "VisitType")
	protected String visitType;
	
	@XmlElement(name = "DurationOnPrepMonths")
	protected Integer durationOnPrepMonths;
	
	@XmlElement(name = "PregnancyStatus")
	protected String pregnancyStatus;
	
	@XmlElement(name = "Weight")
	protected BigDecimal weight;
	
	@XmlElement(name = "BloodPressure")
	protected String bloodPressure;
	
	@XmlElement(name = "HtsResult")
	protected String htsResult;
	
	@XmlElement(name = "NotedSideEffects")
	protected String notedSideEffects;
	
	@XmlElement(name = "SyndromicSTIScreening")
	protected String syndromicSTIScreening;
	
	@XmlElement(name = "RiskReductionServices")
	protected String riskReductionServices;
	
	@XmlElement(name = "Adherence")
	protected String adherence;
	
	@XmlElement(name = "ReasonForPoorFairAdherence")
	protected String reasonForPoorFairAdherence;
	
	@XmlElement(name = "PrepType")
	protected String prepType;
	
	@XmlElement(name = "PrepRegimen")
	protected String prepRegimen;
	
	@XmlElement(name = "MonthsOfRefill")
	protected Integer monthsOfRefill;
	
	@XmlElement(name = "OtherDrugsPrescribed")
	protected String otherDrugsPrescribed;
	
	@XmlElement(name = "DateOfUrinalysis")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfUrinalysis;
	
	@XmlElement(name = "UrinalysisResult")
	protected String urinalysisResult;
	
	@XmlElement(name = "DateOfHepatitisTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfHepatitisTest;
	
	@XmlElement(name = "HepatitisTestResult")
	protected String hepatitisTestResult;
	
	@XmlElement(name = "DateOfSyphilisTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfSyphilisTest;
	
	@XmlElement(name = "SyphilisTestResult")
	protected String syphilisTestResult;
	
	@XmlElement(name = "DateOfLiverFunctionTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfLiverFunctionTest;
	
	@XmlElement(name = "LiverFunctionTestResult")
	protected String liverFunctionTestResult;
	
	@XmlElement(name = "DateOfOtherTests")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfOtherTests;
	
	@XmlElement(name = "OtherTestsResult")
	protected String otherTestsResult;
	
	@XmlElement(name = "SuspectedAcuteInfection")
	protected String suspectedAcuteInfection;
	
	@XmlElement(name = "EarlyHivDetectionViralLoadResult")
	protected String earlyHivDetectionViralLoadResult;
	
	@XmlElement(name = "NextAppointmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar nextAppointmentDate;
	
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
	 * Gets the value of the visitType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitType() {
		return visitType;
	}
	
	/**
	 * Sets the value of the visitType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitType(String value) {
		this.visitType = value;
	}
	
	/**
	 * Gets the value of the durationOnPrepMonths property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getDurationOnPrepMonths() {
		return durationOnPrepMonths;
	}
	
	/**
	 * Sets the value of the durationOnPrepMonths property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setDurationOnPrepMonths(Integer value) {
		this.durationOnPrepMonths = value;
	}
	
	/**
	 * Gets the value of the pregnancyStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPregnancyStatus() {
		return pregnancyStatus;
	}
	
	/**
	 * Sets the value of the pregnancyStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPregnancyStatus(String value) {
		this.pregnancyStatus = value;
	}
	
	/**
	 * Gets the value of the weight property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getWeight() {
		return weight;
	}
	
	/**
	 * Sets the value of the weight property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setWeight(BigDecimal value) {
		this.weight = value;
	}
	
	/**
	 * Gets the value of the bloodPressure property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	/**
	 * Sets the value of the bloodPressure property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBloodPressure(String value) {
		this.bloodPressure = value;
	}
	
	/**
	 * Gets the value of the htsResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHtsResult() {
		return htsResult;
	}
	
	/**
	 * Sets the value of the htsResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHtsResult(String value) {
		this.htsResult = value;
	}
	
	/**
	 * Gets the value of the notedSideEffects property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNotedSideEffects() {
		return notedSideEffects;
	}
	
	/**
	 * Sets the value of the notedSideEffects property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNotedSideEffects(String value) {
		this.notedSideEffects = value;
	}
	
	/**
	 * Gets the value of the syndromicSTIScreening property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSyndromicSTIScreening() {
		return syndromicSTIScreening;
	}
	
	/**
	 * Sets the value of the syndromicSTIScreening property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSyndromicSTIScreening(String value) {
		this.syndromicSTIScreening = value;
	}
	
	/**
	 * Gets the value of the riskReductionServices property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRiskReductionServices() {
		return riskReductionServices;
	}
	
	/**
	 * Sets the value of the riskReductionServices property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRiskReductionServices(String value) {
		this.riskReductionServices = value;
	}
	
	/**
	 * Gets the value of the adherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAdherence() {
		return adherence;
	}
	
	/**
	 * Sets the value of the adherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAdherence(String value) {
		this.adherence = value;
	}
	
	/**
	 * Gets the value of the reasonForPoorFairAdherence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForPoorFairAdherence() {
		return reasonForPoorFairAdherence;
	}
	
	/**
	 * Sets the value of the reasonForPoorFairAdherence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForPoorFairAdherence(String value) {
		this.reasonForPoorFairAdherence = value;
	}
	
	/**
	 * Gets the value of the prepType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrepType() {
		return prepType;
	}
	
	/**
	 * Sets the value of the prepType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrepType(String value) {
		this.prepType = value;
	}
	
	/**
	 * Gets the value of the prepRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrepRegimen() {
		return prepRegimen;
	}
	
	/**
	 * Sets the value of the prepRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrepRegimen(String value) {
		this.prepRegimen = value;
	}
	
	/**
	 * Gets the value of the monthsOfRefill property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getMonthsOfRefill() {
		return monthsOfRefill;
	}
	
	/**
	 * Sets the value of the monthsOfRefill property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setMonthsOfRefill(Integer value) {
		this.monthsOfRefill = value;
	}
	
	/**
	 * Gets the value of the otherDrugsPrescribed property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherDrugsPrescribed() {
		return otherDrugsPrescribed;
	}
	
	/**
	 * Sets the value of the otherDrugsPrescribed property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherDrugsPrescribed(String value) {
		this.otherDrugsPrescribed = value;
	}
	
	/**
	 * Gets the value of the dateOfUrinalysis property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfUrinalysis() {
		return dateOfUrinalysis;
	}
	
	/**
	 * Sets the value of the dateOfUrinalysis property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfUrinalysis(XMLGregorianCalendar value) {
		this.dateOfUrinalysis = value;
	}
	
	/**
	 * Gets the value of the urinalysisResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUrinalysisResult() {
		return urinalysisResult;
	}
	
	/**
	 * Sets the value of the urinalysisResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUrinalysisResult(String value) {
		this.urinalysisResult = value;
	}
	
	/**
	 * Gets the value of the dateOfHepatitisTest property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfHepatitisTest() {
		return dateOfHepatitisTest;
	}
	
	/**
	 * Sets the value of the dateOfHepatitisTest property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfHepatitisTest(XMLGregorianCalendar value) {
		this.dateOfHepatitisTest = value;
	}
	
	/**
	 * Gets the value of the hepatitisTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHepatitisTestResult() {
		return hepatitisTestResult;
	}
	
	/**
	 * Sets the value of the hepatitisTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHepatitisTestResult(String value) {
		this.hepatitisTestResult = value;
	}
	
	/**
	 * Gets the value of the dateOfSyphilisTest property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfSyphilisTest() {
		return dateOfSyphilisTest;
	}
	
	/**
	 * Sets the value of the dateOfSyphilisTest property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfSyphilisTest(XMLGregorianCalendar value) {
		this.dateOfSyphilisTest = value;
	}
	
	/**
	 * Gets the value of the syphilisTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSyphilisTestResult() {
		return syphilisTestResult;
	}
	
	/**
	 * Sets the value of the syphilisTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSyphilisTestResult(String value) {
		this.syphilisTestResult = value;
	}
	
	/**
	 * Gets the value of the dateOfLiverFunctionTest property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfLiverFunctionTest() {
		return dateOfLiverFunctionTest;
	}
	
	/**
	 * Sets the value of the dateOfLiverFunctionTest property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfLiverFunctionTest(XMLGregorianCalendar value) {
		this.dateOfLiverFunctionTest = value;
	}
	
	/**
	 * Gets the value of the liverFunctionTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLiverFunctionTestResult() {
		return liverFunctionTestResult;
	}
	
	/**
	 * Sets the value of the liverFunctionTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLiverFunctionTestResult(String value) {
		this.liverFunctionTestResult = value;
	}
	
	/**
	 * Gets the value of the dateOfOtherTests property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfOtherTests() {
		return dateOfOtherTests;
	}
	
	/**
	 * Sets the value of the dateOfOtherTests property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfOtherTests(XMLGregorianCalendar value) {
		this.dateOfOtherTests = value;
	}
	
	/**
	 * Gets the value of the otherTestsResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherTestsResult() {
		return otherTestsResult;
	}
	
	/**
	 * Sets the value of the otherTestsResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherTestsResult(String value) {
		this.otherTestsResult = value;
	}
	
	/**
	 * Gets the value of the suspectedAcuteInfection property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSuspectedAcuteInfection() {
		return suspectedAcuteInfection;
	}
	
	/**
	 * Sets the value of the suspectedAcuteInfection property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSuspectedAcuteInfection(String value) {
		this.suspectedAcuteInfection = value;
	}
	
	/**
	 * Gets the value of the earlyHivDetectionViralLoadResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEarlyHivDetectionViralLoadResult() {
		return earlyHivDetectionViralLoadResult;
	}
	
	/**
	 * Sets the value of the earlyHivDetectionViralLoadResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEarlyHivDetectionViralLoadResult(String value) {
		this.earlyHivDetectionViralLoadResult = value;
	}
	
	/**
	 * Gets the value of the nextAppointmentDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getNextAppointmentDate() {
		return nextAppointmentDate;
	}
	
	/**
	 * Sets the value of the nextAppointmentDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setNextAppointmentDate(XMLGregorianCalendar value) {
		this.nextAppointmentDate = value;
	}
	
}
