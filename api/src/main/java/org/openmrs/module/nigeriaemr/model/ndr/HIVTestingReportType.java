package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for HIVTestingReportType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVTestingReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Setting">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="C"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Modality">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="O"/>
 *               &lt;enumeration value="S"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherModality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Sex">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MaritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfAllWives" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NoOfOwnChildrenLessThan15Years" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StateOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LGAOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SessionType">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVSTResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NR"/>
 *               &lt;enumeration value="R"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexClientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelationshipToIndex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="L"/>
 *               &lt;enumeration value="B"/>
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ClientIsPregnant" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Breastfeeding" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DurationOfBreastfeeding" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="LT6"/>
 *               &lt;enumeration value="GTE6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PreTestInformation" type="{}PreTestInformationType" minOccurs="0"/>
 *         &lt;element name="HIVTestResult" type="{}HIVTestResultType" minOccurs="0"/>
 *         &lt;element name="SyphilisTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NR"/>
 *               &lt;enumeration value="R"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RecencyTestingResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="L"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexContactTesting" type="{}IndexContactTestingType" minOccurs="0"/>
 *         &lt;element name="PostTestCounselling" type="{}PostTestCounsellingType" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompletedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateCompleted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVTestingReportType", propOrder = { "clientCode", "visitID", "visitDate", "setting", "modality",
        "otherModality", "clientAge", "sex", "maritalStatus", "noOfAllWives", "noOfOwnChildrenLessThan15Years",
        "stateOfResidence", "lgaOfResidence", "sessionType", "hivstResult", "indexClientId", "relationshipToIndex",
        "clientIsPregnant", "breastfeeding", "durationOfBreastfeeding", "preTestInformation", "hivTestResult",
        "syphilisTestResult", "recencyTestingResult", "indexContactTesting", "postTestCounselling", "comments",
        "completedBy", "dateCompleted" })
public class HIVTestingReportType {
	
	@XmlElement(name = "ClientCode", required = true)
	protected String clientCode;
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "Setting", required = true)
	protected String setting;
	
	@XmlElement(name = "Modality", required = true)
	protected String modality;
	
	@XmlElement(name = "OtherModality")
	protected String otherModality;
	
	@XmlElement(name = "ClientAge")
	protected int clientAge;
	
	@XmlElement(name = "Sex", required = true)
	protected String sex;
	
	@XmlElement(name = "MaritalStatus")
	protected String maritalStatus;
	
	@XmlElement(name = "NoOfAllWives")
	protected Integer noOfAllWives;
	
	@XmlElement(name = "NoOfOwnChildrenLessThan15Years")
	protected Integer noOfOwnChildrenLessThan15Years;
	
	@XmlElement(name = "StateOfResidence")
	protected String stateOfResidence;
	
	@XmlElement(name = "LGAOfResidence")
	protected String lgaOfResidence;
	
	@XmlElement(name = "SessionType", required = true)
	protected String sessionType;
	
	@XmlElement(name = "HIVSTResult")
	protected String hivstResult;
	
	@XmlElement(name = "IndexClientId")
	protected String indexClientId;
	
	@XmlElement(name = "RelationshipToIndex")
	protected String relationshipToIndex;
	
	@XmlElement(name = "ClientIsPregnant")
	protected String clientIsPregnant;
	
	@XmlElement(name = "Breastfeeding")
	protected String breastfeeding;
	
	@XmlElement(name = "DurationOfBreastfeeding")
	protected String durationOfBreastfeeding;
	
	@XmlElement(name = "PreTestInformation")
	protected PreTestInformationType preTestInformation;
	
	@XmlElement(name = "HIVTestResult")
	protected HIVTestResultType hivTestResult;
	
	@XmlElement(name = "SyphilisTestResult")
	protected String syphilisTestResult;
	
	@XmlElement(name = "RecencyTestingResult")
	protected String recencyTestingResult;
	
	@XmlElement(name = "IndexContactTesting")
	protected IndexContactTestingType indexContactTesting;
	
	@XmlElement(name = "PostTestCounselling")
	protected PostTestCounsellingType postTestCounselling;
	
	@XmlElement(name = "Comments")
	protected String comments;
	
	@XmlElement(name = "CompletedBy")
	protected String completedBy;
	
	@XmlElement(name = "DateCompleted")
	protected String dateCompleted;
	
	/**
	 * Gets the value of the clientCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClientCode() {
		return clientCode;
	}
	
	/**
	 * Sets the value of the clientCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClientCode(String value) {
		this.clientCode = value;
	}
	
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
	 * Gets the value of the setting property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSetting() {
		return setting;
	}
	
	/**
	 * Sets the value of the setting property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSetting(String value) {
		this.setting = value;
	}
	
	/**
	 * Gets the value of the modality property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getModality() {
		return modality;
	}
	
	/**
	 * Sets the value of the modality property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setModality(String value) {
		this.modality = value;
	}
	
	/**
	 * Gets the value of the otherModality property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherModality() {
		return otherModality;
	}
	
	/**
	 * Sets the value of the otherModality property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherModality(String value) {
		this.otherModality = value;
	}
	
	/**
	 * Gets the value of the clientAge property.
	 */
	public int getClientAge() {
		return clientAge;
	}
	
	/**
	 * Sets the value of the clientAge property.
	 */
	public void setClientAge(int value) {
		this.clientAge = value;
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
	 * Gets the value of the noOfAllWives property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNoOfAllWives() {
		return noOfAllWives;
	}
	
	/**
	 * Sets the value of the noOfAllWives property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setNoOfAllWives(Integer value) {
		this.noOfAllWives = value;
	}
	
	/**
	 * Gets the value of the noOfOwnChildrenLessThan15Years property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNoOfOwnChildrenLessThan15Years() {
		return noOfOwnChildrenLessThan15Years;
	}
	
	/**
	 * Sets the value of the noOfOwnChildrenLessThan15Years property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setNoOfOwnChildrenLessThan15Years(Integer value) {
		this.noOfOwnChildrenLessThan15Years = value;
	}
	
	/**
	 * Gets the value of the stateOfResidence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStateOfResidence() {
		return stateOfResidence;
	}
	
	/**
	 * Sets the value of the stateOfResidence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStateOfResidence(String value) {
		this.stateOfResidence = value;
	}
	
	/**
	 * Gets the value of the lgaOfResidence property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLGAOfResidence() {
		return lgaOfResidence;
	}
	
	/**
	 * Sets the value of the lgaOfResidence property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLGAOfResidence(String value) {
		this.lgaOfResidence = value;
	}
	
	/**
	 * Gets the value of the sessionType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSessionType() {
		return sessionType;
	}
	
	/**
	 * Sets the value of the sessionType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSessionType(String value) {
		this.sessionType = value;
	}
	
	/**
	 * Gets the value of the hivstResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVSTResult() {
		return hivstResult;
	}
	
	/**
	 * Sets the value of the hivstResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVSTResult(String value) {
		this.hivstResult = value;
	}
	
	/**
	 * Gets the value of the indexClientId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexClientId() {
		return indexClientId;
	}
	
	/**
	 * Sets the value of the indexClientId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexClientId(String value) {
		this.indexClientId = value;
	}
	
	/**
	 * Gets the value of the relationshipToIndex property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRelationshipToIndex() {
		return relationshipToIndex;
	}
	
	/**
	 * Sets the value of the relationshipToIndex property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRelationshipToIndex(String value) {
		this.relationshipToIndex = value;
	}
	
	/**
	 * Gets the value of the clientIsPregnant property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClientIsPregnant() {
		return clientIsPregnant;
	}
	
	/**
	 * Sets the value of the clientIsPregnant property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClientIsPregnant(String value) {
		this.clientIsPregnant = value;
	}
	
	/**
	 * Gets the value of the breastfeeding property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBreastfeeding() {
		return breastfeeding;
	}
	
	/**
	 * Sets the value of the breastfeeding property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBreastfeeding(String value) {
		this.breastfeeding = value;
	}
	
	/**
	 * Gets the value of the durationOfBreastfeeding property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDurationOfBreastfeeding() {
		return durationOfBreastfeeding;
	}
	
	/**
	 * Sets the value of the durationOfBreastfeeding property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDurationOfBreastfeeding(String value) {
		this.durationOfBreastfeeding = value;
	}
	
	/**
	 * Gets the value of the preTestInformation property.
	 * 
	 * @return possible object is {@link PreTestInformationType }
	 */
	public PreTestInformationType getPreTestInformation() {
		return preTestInformation;
	}
	
	/**
	 * Sets the value of the preTestInformation property.
	 * 
	 * @param value allowed object is {@link PreTestInformationType }
	 */
	public void setPreTestInformation(PreTestInformationType value) {
		this.preTestInformation = value;
	}
	
	/**
	 * Gets the value of the hivTestResult property.
	 * 
	 * @return possible object is {@link HIVTestResultType }
	 */
	public HIVTestResultType getHIVTestResult() {
		return hivTestResult;
	}
	
	/**
	 * Sets the value of the hivTestResult property.
	 * 
	 * @param value allowed object is {@link HIVTestResultType }
	 */
	public void setHIVTestResult(HIVTestResultType value) {
		this.hivTestResult = value;
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
	 * Gets the value of the recencyTestingResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRecencyTestingResult() {
		return recencyTestingResult;
	}
	
	/**
	 * Sets the value of the recencyTestingResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRecencyTestingResult(String value) {
		this.recencyTestingResult = value;
	}
	
	/**
	 * Gets the value of the indexContactTesting property.
	 * 
	 * @return possible object is {@link IndexContactTestingType }
	 */
	public IndexContactTestingType getIndexContactTesting() {
		return indexContactTesting;
	}
	
	/**
	 * Sets the value of the indexContactTesting property.
	 * 
	 * @param value allowed object is {@link IndexContactTestingType }
	 */
	public void setIndexContactTesting(IndexContactTestingType value) {
		this.indexContactTesting = value;
	}
	
	/**
	 * Gets the value of the postTestCounselling property.
	 * 
	 * @return possible object is {@link PostTestCounsellingType }
	 */
	public PostTestCounsellingType getPostTestCounselling() {
		return postTestCounselling;
	}
	
	/**
	 * Sets the value of the postTestCounselling property.
	 * 
	 * @param value allowed object is {@link PostTestCounsellingType }
	 */
	public void setPostTestCounselling(PostTestCounsellingType value) {
		this.postTestCounselling = value;
	}
	
	/**
	 * Gets the value of the comments property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * Sets the value of the comments property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setComments(String value) {
		this.comments = value;
	}
	
	/**
	 * Gets the value of the completedBy property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCompletedBy() {
		return completedBy;
	}
	
	/**
	 * Sets the value of the completedBy property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCompletedBy(String value) {
		this.completedBy = value;
	}
	
	/**
	 * Gets the value of the dateCompleted property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateCompleted() {
		return dateCompleted;
	}
	
	/**
	 * Sets the value of the dateCompleted property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateCompleted(String value) {
		this.dateCompleted = value;
	}
	
}
