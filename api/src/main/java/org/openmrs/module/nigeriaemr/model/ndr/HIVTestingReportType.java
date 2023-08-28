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
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="Setting">
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
 *         &lt;element name="FirstTimeVisit" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SessionType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReferredFrom" minOccurs="0">
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
 *         &lt;element name="MaritalStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="W"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NoOfOwnChildrenLessThan5Years" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NoOfAllWives" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsIndexClient" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IndexClientId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReTestingForResultVerification" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Y"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PreTestInformation" type="{}PreTestInformationType" minOccurs="0"/>
 *         &lt;element name="HIVTestResult" type="{}HIVTestResultType" minOccurs="0"/>
 *         &lt;element name="PostTestCounselling" type="{}PostTestCounsellingType" minOccurs="0"/>
 *         &lt;element name="SyphilisTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="NR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HBVTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HCVTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompletedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateCompleted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVTestingReportType", propOrder = { "clientCode", "visitDate", "visitID", "setting", "firstTimeVisit",
        "sessionType", "referredFrom", "maritalStatus", "noOfOwnChildrenLessThan5Years", "noOfAllWives", "isIndexClient",
        "indexType", "indexClientId", "reTestingForResultVerification", "preTestInformation", "hivTestResult",
        "postTestCounselling", "syphilisTestResult", "hbvTestResult", "hcvTestResult", "indexNotificationServices",
        "completedBy", "dateCompleted" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class HIVTestingReportType {
	
	@XmlElement(name = "ClientCode", required = true)
	protected String clientCode;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "Setting", required = true)
	protected String setting;
	
	@XmlElement(name = "FirstTimeVisit")
	protected String firstTimeVisit;
	
	@XmlElement(name = "SessionType")
	protected String sessionType;
	
	@XmlElement(name = "ReferredFrom")
	protected String referredFrom;
	
	@XmlElement(name = "MaritalStatus")
	protected String maritalStatus;
	
	@XmlElement(name = "NoOfOwnChildrenLessThan5Years")
	protected Integer noOfOwnChildrenLessThan5Years;
	
	@XmlElement(name = "NoOfAllWives")
	protected Integer noOfAllWives;
	
	@XmlElement(name = "IsIndexClient")
	protected String isIndexClient;
	
	@XmlElement(name = "IndexType")
	protected String indexType;
	
	@XmlElement(name = "IndexClientId")
	protected String indexClientId;
	
	@XmlElement(name = "ReTestingForResultVerification")
	protected String reTestingForResultVerification;
	
	@XmlElement(name = "PreTestInformation")
	protected PreTestInformationType preTestInformation;
	
	@XmlElement(name = "HIVTestResult")
	protected HIVTestResultType hivTestResult;
	
	@XmlElement(name = "PostTestCounselling")
	protected PostTestCounsellingType postTestCounselling;
	
	@XmlElement(name = "SyphilisTestResult")
	protected String syphilisTestResult;
	
	@XmlElement(name = "HBVTestResult")
	protected String hbvTestResult;
	
	@XmlElement(name = "HCVTestResult")
	protected String hcvTestResult;
	
	@XmlElement(name = "IndexNotificationServices")
	protected IndexNotificationServicesType indexNotificationServices;
	
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
	 * Gets the value of the firstTimeVisit property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFirstTimeVisit() {
		return firstTimeVisit;
	}
	
	/**
	 * Sets the value of the firstTimeVisit property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFirstTimeVisit(String value) {
		this.firstTimeVisit = value;
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
	 * Gets the value of the referredFrom property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredFrom() {
		return referredFrom;
	}
	
	/**
	 * Sets the value of the referredFrom property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredFrom(String value) {
		this.referredFrom = value;
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
	 * Gets the value of the noOfOwnChildrenLessThan5Years property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNoOfOwnChildrenLessThan5Years() {
		return noOfOwnChildrenLessThan5Years;
	}
	
	/**
	 * Sets the value of the noOfOwnChildrenLessThan5Years property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setNoOfOwnChildrenLessThan5Years(Integer value) {
		this.noOfOwnChildrenLessThan5Years = value;
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
	 * Gets the value of the isIndexClient property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIsIndexClient() {
		return isIndexClient;
	}
	
	/**
	 * Sets the value of the isIndexClient property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIsIndexClient(String value) {
		this.isIndexClient = value;
	}
	
	/**
	 * Gets the value of the indexType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIndexType() {
		return indexType;
	}
	
	/**
	 * Sets the value of the indexType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIndexType(String value) {
		this.indexType = value;
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
	 * Gets the value of the reTestingForResultVerification property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReTestingForResultVerification() {
		return reTestingForResultVerification;
	}
	
	/**
	 * Sets the value of the reTestingForResultVerification property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReTestingForResultVerification(String value) {
		this.reTestingForResultVerification = value;
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
	 * Gets the value of the hbvTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVTestResult() {
		return hbvTestResult;
	}
	
	/**
	 * Sets the value of the hbvTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVTestResult(String value) {
		this.hbvTestResult = value;
	}
	
	/**
	 * Gets the value of the hcvTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVTestResult() {
		return hcvTestResult;
	}
	
	/**
	 * Sets the value of the hcvTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVTestResult(String value) {
		this.hcvTestResult = value;
	}
	
	/**
	 * Gets the value of the indexNotificationServices property.
	 * 
	 * @return possible object is {@link IndexNotificationServicesType }
	 */
	public IndexNotificationServicesType getIndexNotificationServices() {
		return indexNotificationServices;
	}
	
	/**
	 * Sets the value of the indexNotificationServices property.
	 * 
	 * @param value allowed object is {@link IndexNotificationServicesType }
	 */
	public void setIndexNotificationServices(IndexNotificationServicesType value) {
		this.indexNotificationServices = value;
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
