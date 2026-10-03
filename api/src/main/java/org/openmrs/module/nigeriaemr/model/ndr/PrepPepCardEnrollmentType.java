package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PrepPepCardEnrollmentType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepPepCardEnrollmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HospitalNumber" type="{}StringType"/>
 *         &lt;element name="EnrollmentType">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="PrEP"/>
 *               &lt;enumeration value="PEP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UniqueId" type="{}StringType"/>
 *         &lt;element name="DateEnrolled" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PartnerAncOrUniqueArtNumber" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="Sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MaritalStatus" minOccurs="0">
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
 *         &lt;element name="Occupation" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="EducationLevel" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HivTestingPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfLastHivTest" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HivTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Negative"/>
 *               &lt;enumeration value="Positive"/>
 *               &lt;enumeration value="SuspectedAcuteHIVInfection"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateReferred" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PopulationType" minOccurs="0">
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
 *         &lt;element name="OtherPopulationSpecify" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="DateInitialAdherenceCounseling" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateStarted" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PrepTypeAtStart" minOccurs="0">
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
 *               &lt;enumeration value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BMI" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IsPregnant" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsBreastfeeding" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HistoryOfDrugAllergies" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="HistoryOfDrugDrugInteractions" minOccurs="0">
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
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UrinalysisResult" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="LiverFunctionTestResult" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="ReferredAtInitiation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateReferredAtInitiation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ServiceReferredFor" minOccurs="0">
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
 *         &lt;element name="PepCompletion" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PepFollowUpEntry" type="{}PepFollowUpEntryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepPepCardEnrollmentType", propOrder = { "hospitalNumber", "enrollmentType", "uniqueId", "dateEnrolled",
        "partnerAncOrUniqueArtNumber", "sex", "age", "maritalStatus", "occupation", "educationLevel", "hivTestingPoint",
        "dateOfLastHivTest", "hivTestResult", "dateReferred", "populationType", "otherPopulationSpecify",
        "dateInitialAdherenceCounseling", "dateStarted", "prepTypeAtStart", "prepRegimen", "weight", "height", "bmi",
        "isPregnant", "isBreastfeeding", "historyOfDrugAllergies", "historyOfDrugDrugInteractions", "urinalysisResult",
        "liverFunctionTestResult", "referredAtInitiation", "dateReferredAtInitiation", "serviceReferredFor",
        "pepCompletion", "pepFollowUpEntry" })
public class PrepPepCardEnrollmentType {
	
	@XmlElement(name = "HospitalNumber", required = true)
	protected String hospitalNumber;
	
	@XmlElement(name = "EnrollmentType", required = true)
	protected String enrollmentType;
	
	@XmlElement(name = "UniqueId", required = true)
	protected String uniqueId;
	
	@XmlElement(name = "DateEnrolled", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateEnrolled;
	
	@XmlElement(name = "PartnerAncOrUniqueArtNumber")
	protected String partnerAncOrUniqueArtNumber;
	
	@XmlElement(name = "Sex")
	protected String sex;
	
	@XmlElement(name = "Age")
	protected Integer age;
	
	@XmlElement(name = "MaritalStatus")
	protected String maritalStatus;
	
	@XmlElement(name = "Occupation")
	protected String occupation;
	
	@XmlElement(name = "EducationLevel")
	protected String educationLevel;
	
	@XmlElement(name = "HivTestingPoint")
	protected String hivTestingPoint;
	
	@XmlElement(name = "DateOfLastHivTest")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfLastHivTest;
	
	@XmlElement(name = "HivTestResult")
	protected String hivTestResult;
	
	@XmlElement(name = "DateReferred")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateReferred;
	
	@XmlElement(name = "PopulationType")
	protected String populationType;
	
	@XmlElement(name = "OtherPopulationSpecify")
	protected String otherPopulationSpecify;
	
	@XmlElement(name = "DateInitialAdherenceCounseling")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateInitialAdherenceCounseling;
	
	@XmlElement(name = "DateStarted")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateStarted;
	
	@XmlElement(name = "PrepTypeAtStart")
	protected String prepTypeAtStart;
	
	@XmlElement(name = "PrepRegimen")
	protected String prepRegimen;
	
	@XmlElement(name = "Weight")
	protected BigDecimal weight;
	
	@XmlElement(name = "Height")
	protected BigDecimal height;
	
	@XmlElement(name = "BMI")
	protected BigDecimal bmi;
	
	@XmlElement(name = "IsPregnant")
	protected Boolean isPregnant;
	
	@XmlElement(name = "IsBreastfeeding")
	protected Boolean isBreastfeeding;
	
	@XmlElement(name = "HistoryOfDrugAllergies")
	protected String historyOfDrugAllergies;
	
	@XmlElement(name = "HistoryOfDrugDrugInteractions")
	protected String historyOfDrugDrugInteractions;
	
	@XmlElement(name = "UrinalysisResult")
	protected String urinalysisResult;
	
	@XmlElement(name = "LiverFunctionTestResult")
	protected String liverFunctionTestResult;
	
	@XmlElement(name = "ReferredAtInitiation")
	protected String referredAtInitiation;
	
	@XmlElement(name = "DateReferredAtInitiation")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateReferredAtInitiation;
	
	@XmlElement(name = "ServiceReferredFor")
	protected String serviceReferredFor;
	
	@XmlElement(name = "PepCompletion")
	protected String pepCompletion;
	
	@XmlElement(name = "PepFollowUpEntry")
	protected List<PepFollowUpEntryType> pepFollowUpEntry;
	
	/**
	 * Gets the value of the hospitalNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	
	/**
	 * Sets the value of the hospitalNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHospitalNumber(String value) {
		this.hospitalNumber = value;
	}
	
	/**
	 * Gets the value of the enrollmentType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEnrollmentType() {
		return enrollmentType;
	}
	
	/**
	 * Sets the value of the enrollmentType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEnrollmentType(String value) {
		this.enrollmentType = value;
	}
	
	/**
	 * Gets the value of the uniqueId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * Sets the value of the uniqueId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUniqueId(String value) {
		this.uniqueId = value;
	}
	
	/**
	 * Gets the value of the dateEnrolled property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateEnrolled() {
		return dateEnrolled;
	}
	
	/**
	 * Sets the value of the dateEnrolled property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateEnrolled(XMLGregorianCalendar value) {
		this.dateEnrolled = value;
	}
	
	/**
	 * Gets the value of the partnerAncOrUniqueArtNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPartnerAncOrUniqueArtNumber() {
		return partnerAncOrUniqueArtNumber;
	}
	
	/**
	 * Sets the value of the partnerAncOrUniqueArtNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPartnerAncOrUniqueArtNumber(String value) {
		this.partnerAncOrUniqueArtNumber = value;
	}
	
	/**
	 * Gets the value of the sex property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Sets the value of the sex property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSex(String value) {
		this.sex = value;
	}
	
	/**
	 * Gets the value of the age property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * Sets the value of the age property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setAge(Integer value) {
		this.age = value;
	}
	
	/**
	 * Gets the value of the maritalStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	/**
	 * Sets the value of the maritalStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMaritalStatus(String value) {
		this.maritalStatus = value;
	}
	
	/**
	 * Gets the value of the occupation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOccupation() {
		return occupation;
	}
	
	/**
	 * Sets the value of the occupation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOccupation(String value) {
		this.occupation = value;
	}
	
	/**
	 * Gets the value of the educationLevel property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEducationLevel() {
		return educationLevel;
	}
	
	/**
	 * Sets the value of the educationLevel property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEducationLevel(String value) {
		this.educationLevel = value;
	}
	
	/**
	 * Gets the value of the hivTestingPoint property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHivTestingPoint() {
		return hivTestingPoint;
	}
	
	/**
	 * Sets the value of the hivTestingPoint property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHivTestingPoint(String value) {
		this.hivTestingPoint = value;
	}
	
	/**
	 * Gets the value of the dateOfLastHivTest property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfLastHivTest() {
		return dateOfLastHivTest;
	}
	
	/**
	 * Sets the value of the dateOfLastHivTest property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfLastHivTest(XMLGregorianCalendar value) {
		this.dateOfLastHivTest = value;
	}
	
	/**
	 * Gets the value of the hivTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHivTestResult() {
		return hivTestResult;
	}
	
	/**
	 * Sets the value of the hivTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHivTestResult(String value) {
		this.hivTestResult = value;
	}
	
	/**
	 * Gets the value of the dateReferred property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateReferred() {
		return dateReferred;
	}
	
	/**
	 * Sets the value of the dateReferred property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateReferred(XMLGregorianCalendar value) {
		this.dateReferred = value;
	}
	
	/**
	 * Gets the value of the populationType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPopulationType() {
		return populationType;
	}
	
	/**
	 * Sets the value of the populationType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPopulationType(String value) {
		this.populationType = value;
	}
	
	/**
	 * Gets the value of the otherPopulationSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherPopulationSpecify() {
		return otherPopulationSpecify;
	}
	
	/**
	 * Sets the value of the otherPopulationSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherPopulationSpecify(String value) {
		this.otherPopulationSpecify = value;
	}
	
	/**
	 * Gets the value of the dateInitialAdherenceCounseling property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateInitialAdherenceCounseling() {
		return dateInitialAdherenceCounseling;
	}
	
	/**
	 * Sets the value of the dateInitialAdherenceCounseling property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateInitialAdherenceCounseling(XMLGregorianCalendar value) {
		this.dateInitialAdherenceCounseling = value;
	}
	
	/**
	 * Gets the value of the dateStarted property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateStarted() {
		return dateStarted;
	}
	
	/**
	 * Sets the value of the dateStarted property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateStarted(XMLGregorianCalendar value) {
		this.dateStarted = value;
	}
	
	/**
	 * Gets the value of the prepTypeAtStart property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrepTypeAtStart() {
		return prepTypeAtStart;
	}
	
	/**
	 * Sets the value of the prepTypeAtStart property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrepTypeAtStart(String value) {
		this.prepTypeAtStart = value;
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
	 * Gets the value of the height property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getHeight() {
		return height;
	}
	
	/**
	 * Sets the value of the height property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setHeight(BigDecimal value) {
		this.height = value;
	}
	
	/**
	 * Gets the value of the bmi property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBMI() {
		return bmi;
	}
	
	/**
	 * Sets the value of the bmi property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBMI(BigDecimal value) {
		this.bmi = value;
	}
	
	/**
	 * Gets the value of the isPregnant property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isIsPregnant() {
		return isPregnant;
	}
	
	/**
	 * Sets the value of the isPregnant property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setIsPregnant(Boolean value) {
		this.isPregnant = value;
	}
	
	/**
	 * Gets the value of the isBreastfeeding property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isIsBreastfeeding() {
		return isBreastfeeding;
	}
	
	/**
	 * Sets the value of the isBreastfeeding property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setIsBreastfeeding(Boolean value) {
		this.isBreastfeeding = value;
	}
	
	/**
	 * Gets the value of the historyOfDrugAllergies property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHistoryOfDrugAllergies() {
		return historyOfDrugAllergies;
	}
	
	/**
	 * Sets the value of the historyOfDrugAllergies property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHistoryOfDrugAllergies(String value) {
		this.historyOfDrugAllergies = value;
	}
	
	/**
	 * Gets the value of the historyOfDrugDrugInteractions property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHistoryOfDrugDrugInteractions() {
		return historyOfDrugDrugInteractions;
	}
	
	/**
	 * Sets the value of the historyOfDrugDrugInteractions property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHistoryOfDrugDrugInteractions(String value) {
		this.historyOfDrugDrugInteractions = value;
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
	 * Gets the value of the referredAtInitiation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredAtInitiation() {
		return referredAtInitiation;
	}
	
	/**
	 * Sets the value of the referredAtInitiation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredAtInitiation(String value) {
		this.referredAtInitiation = value;
	}
	
	/**
	 * Gets the value of the dateReferredAtInitiation property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateReferredAtInitiation() {
		return dateReferredAtInitiation;
	}
	
	/**
	 * Sets the value of the dateReferredAtInitiation property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateReferredAtInitiation(XMLGregorianCalendar value) {
		this.dateReferredAtInitiation = value;
	}
	
	/**
	 * Gets the value of the serviceReferredFor property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getServiceReferredFor() {
		return serviceReferredFor;
	}
	
	/**
	 * Sets the value of the serviceReferredFor property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setServiceReferredFor(String value) {
		this.serviceReferredFor = value;
	}
	
	/**
	 * Gets the value of the pepCompletion property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPepCompletion() {
		return pepCompletion;
	}
	
	/**
	 * Sets the value of the pepCompletion property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPepCompletion(String value) {
		this.pepCompletion = value;
	}
	
	/**
	 * Gets the value of the pepFollowUpEntry property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the pepFollowUpEntry property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getPepFollowUpEntry().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link PepFollowUpEntryType }
	 */
	public List<PepFollowUpEntryType> getPepFollowUpEntry() {
		if (pepFollowUpEntry == null) {
			pepFollowUpEntry = new ArrayList<PepFollowUpEntryType>();
		}
		return this.pepFollowUpEntry;
	}
	
}
