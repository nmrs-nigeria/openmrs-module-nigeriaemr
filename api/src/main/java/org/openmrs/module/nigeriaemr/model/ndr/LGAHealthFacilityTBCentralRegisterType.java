//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.11.23 at 09:34:14 AM WAT
//

package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for LGAHealthFacilityTBCentralRegisterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LGAHealthFacilityTBCentralRegisterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DateRegistered" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="TypeOfPatient" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="New"/>
 *               &lt;enumeration value="Relapse"/>
 *               &lt;enumeration value="TreatmentAfterDefault"/>
 *               &lt;enumeration value="TreatmentAfterLTFU"/>
 *               &lt;enumeration value="OthersPreviouslyTreated"/>
 *               &lt;enumeration value="UnknownPreviousTB"/>
 *               &lt;enumeration value="TransferredInTB"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LGATBNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ETBMangerUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FacilityWherePatientStartedTreatment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WeightAtTheStartOfTreatment" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="TreatmentRegimen" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Kanamycin"/>
 *               &lt;enumeration value="Capreomycin"/>
 *               &lt;enumeration value="Isoniazid"/>
 *               &lt;enumeration value="Prothionamide"/>
 *               &lt;enumeration value="Moxifloxacin"/>
 *               &lt;enumeration value="Clofazimine"/>
 *               &lt;enumeration value="Ethambutol"/>
 *               &lt;enumeration value="Pyrazinamide"/>
 *               &lt;enumeration value="Linezolid"/>
 *               &lt;enumeration value="Bedaquiline"/>
 *               &lt;enumeration value="Delamanid"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateTreatmentStarted" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ReferredFromCommunity" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="ReferredFromPPMSite" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="IsDOTProvidedByTS" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="SiteOfDisease" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pulmonary"/>
 *               &lt;enumeration value="ExtraPulmonary"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="XpertMTBOrRIF" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="MTBDetected"/>
 *               &lt;enumeration value="MTBNotDetected"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherTest" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Negative"/>
 *               &lt;enumeration value="Positive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Month0SmearResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Month0SmearResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Month2Or3SmearResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Month2Or3SmearResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Month5SmearResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Month5SmearResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Month6SmearResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Month6SmearResultDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="XRayResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NonSuggestive"/>
 *               &lt;enumeration value="Suggestive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BiopsyResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NonSuggestive"/>
 *               &lt;enumeration value="Suggestive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TreatmentOutcome" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Cured"/>
 *               &lt;enumeration value="TreatmentCompleted"/>
 *               &lt;enumeration value="TreatmentFailed"/>
 *               &lt;enumeration value="Died"/>
 *               &lt;enumeration value="LostToFollowUp"/>
 *               &lt;enumeration value="NotEvaluated"/>
 *               &lt;enumeration value="RemovedFromRegister"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OutcomeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PreviouslyKnownHIVStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Positive"/>
 *               &lt;enumeration value="Negative"/>
 *               &lt;enumeration value="Unknown"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TestedForHIV" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LGAHealthFacilityTBCentralRegisterType", propOrder = { "visitID", "visitDate", "dateRegistered",
        "typeOfPatient", "lgatbNumber", "etbMangerUniqueNumber", "facilityWherePatientStartedTreatment",
        "weightAtTheStartOfTreatment", "treatmentRegimen", "dateTreatmentStarted", "referredFromCommunity",
        "referredFromPPMSite", "isDOTProvidedByTS", "siteOfDisease", "xpertMTBOrRIF", "otherTest", "month0SmearResult",
        "month0SmearResultDate", "month2Or3SmearResult", "month2Or3SmearResultDate", "month5SmearResult",
        "month5SmearResultDate", "month6SmearResult", "month6SmearResultDate", "xRayResult", "biopsyResult",
        "treatmentOutcome", "outcomeDate", "previouslyKnownHIVStatus", "testedForHIV", "remarks" })
public class LGAHealthFacilityTBCentralRegisterType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "DateRegistered", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateRegistered;
	
	@XmlElement(name = "TypeOfPatient")
	protected String typeOfPatient;
	
	@XmlElement(name = "LGATBNumber")
	protected String lgatbNumber;
	
	@XmlElement(name = "ETBMangerUniqueNumber")
	protected String etbMangerUniqueNumber;
	
	@XmlElement(name = "FacilityWherePatientStartedTreatment")
	protected String facilityWherePatientStartedTreatment;
	
	@XmlElement(name = "WeightAtTheStartOfTreatment")
	protected float weightAtTheStartOfTreatment;
	
	@XmlElement(name = "TreatmentRegimen")
	protected String treatmentRegimen;
	
	@XmlElement(name = "DateTreatmentStarted", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateTreatmentStarted;
	
	@XmlElement(name = "ReferredFromCommunity")
	@XmlSchemaType(name = "string")
	protected YNCodeType referredFromCommunity;
	
	@XmlElement(name = "ReferredFromPPMSite")
	@XmlSchemaType(name = "string")
	protected YNCodeType referredFromPPMSite;
	
	@XmlElement(name = "IsDOTProvidedByTS")
	@XmlSchemaType(name = "string")
	protected YNCodeType isDOTProvidedByTS;
	
	@XmlElement(name = "SiteOfDisease")
	protected String siteOfDisease;
	
	@XmlElement(name = "XpertMTBOrRIF")
	protected String xpertMTBOrRIF;
	
	@XmlElement(name = "OtherTest")
	protected String otherTest;
	
	@XmlElement(name = "Month0SmearResult")
	protected String month0SmearResult;
	
	@XmlElement(name = "Month0SmearResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar month0SmearResultDate;
	
	@XmlElement(name = "Month2Or3SmearResult")
	protected String month2Or3SmearResult;
	
	@XmlElement(name = "Month2Or3SmearResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar month2Or3SmearResultDate;
	
	@XmlElement(name = "Month5SmearResult")
	protected String month5SmearResult;
	
	@XmlElement(name = "Month5SmearResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar month5SmearResultDate;
	
	@XmlElement(name = "Month6SmearResult")
	protected String month6SmearResult;
	
	@XmlElement(name = "Month6SmearResultDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar month6SmearResultDate;
	
	@XmlElement(name = "XRayResult")
	protected String xRayResult;
	
	@XmlElement(name = "BiopsyResult")
	protected String biopsyResult;
	
	@XmlElement(name = "TreatmentOutcome")
	protected String treatmentOutcome;
	
	@XmlElement(name = "OutcomeDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar outcomeDate;
	
	@XmlElement(name = "PreviouslyKnownHIVStatus")
	protected String previouslyKnownHIVStatus;
	
	@XmlElement(name = "TestedForHIV")
	@XmlSchemaType(name = "string")
	protected YNCodeType testedForHIV;
	
	@XmlElement(name = "Remarks")
	protected String remarks;
	
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
	 * Gets the value of the dateRegistered property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateRegistered() {
		return dateRegistered;
	}
	
	/**
	 * Sets the value of the dateRegistered property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateRegistered(XMLGregorianCalendar value) {
		this.dateRegistered = value;
	}
	
	/**
	 * Gets the value of the typeOfPatient property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTypeOfPatient() {
		return typeOfPatient;
	}
	
	/**
	 * Sets the value of the typeOfPatient property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTypeOfPatient(String value) {
		this.typeOfPatient = value;
	}
	
	/**
	 * Gets the value of the lgatbNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLGATBNumber() {
		return lgatbNumber;
	}
	
	/**
	 * Sets the value of the lgatbNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLGATBNumber(String value) {
		this.lgatbNumber = value;
	}
	
	/**
	 * Gets the value of the etbMangerUniqueNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getETBMangerUniqueNumber() {
		return etbMangerUniqueNumber;
	}
	
	/**
	 * Sets the value of the etbMangerUniqueNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setETBMangerUniqueNumber(String value) {
		this.etbMangerUniqueNumber = value;
	}
	
	/**
	 * Gets the value of the facilityWherePatientStartedTreatment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFacilityWherePatientStartedTreatment() {
		return facilityWherePatientStartedTreatment;
	}
	
	/**
	 * Sets the value of the facilityWherePatientStartedTreatment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFacilityWherePatientStartedTreatment(String value) {
		this.facilityWherePatientStartedTreatment = value;
	}
	
	/**
	 * Gets the value of the weightAtTheStartOfTreatment property.
	 */
	public float getWeightAtTheStartOfTreatment() {
		return weightAtTheStartOfTreatment;
	}
	
	/**
	 * Sets the value of the weightAtTheStartOfTreatment property.
	 */
	public void setWeightAtTheStartOfTreatment(float value) {
		this.weightAtTheStartOfTreatment = value;
	}
	
	/**
	 * Gets the value of the treatmentRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTreatmentRegimen() {
		return treatmentRegimen;
	}
	
	/**
	 * Sets the value of the treatmentRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTreatmentRegimen(String value) {
		this.treatmentRegimen = value;
	}
	
	/**
	 * Gets the value of the dateTreatmentStarted property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateTreatmentStarted() {
		return dateTreatmentStarted;
	}
	
	/**
	 * Sets the value of the dateTreatmentStarted property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateTreatmentStarted(XMLGregorianCalendar value) {
		this.dateTreatmentStarted = value;
	}
	
	/**
	 * Gets the value of the referredFromCommunity property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getReferredFromCommunity() {
		return referredFromCommunity;
	}
	
	/**
	 * Sets the value of the referredFromCommunity property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setReferredFromCommunity(YNCodeType value) {
		this.referredFromCommunity = value;
	}
	
	/**
	 * Gets the value of the referredFromPPMSite property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getReferredFromPPMSite() {
		return referredFromPPMSite;
	}
	
	/**
	 * Sets the value of the referredFromPPMSite property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setReferredFromPPMSite(YNCodeType value) {
		this.referredFromPPMSite = value;
	}
	
	/**
	 * Gets the value of the isDOTProvidedByTS property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getIsDOTProvidedByTS() {
		return isDOTProvidedByTS;
	}
	
	/**
	 * Sets the value of the isDOTProvidedByTS property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setIsDOTProvidedByTS(YNCodeType value) {
		this.isDOTProvidedByTS = value;
	}
	
	/**
	 * Gets the value of the siteOfDisease property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSiteOfDisease() {
		return siteOfDisease;
	}
	
	/**
	 * Sets the value of the siteOfDisease property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSiteOfDisease(String value) {
		this.siteOfDisease = value;
	}
	
	/**
	 * Gets the value of the xpertMTBOrRIF property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getXpertMTBOrRIF() {
		return xpertMTBOrRIF;
	}
	
	/**
	 * Sets the value of the xpertMTBOrRIF property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setXpertMTBOrRIF(String value) {
		this.xpertMTBOrRIF = value;
	}
	
	/**
	 * Gets the value of the otherTest property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherTest() {
		return otherTest;
	}
	
	/**
	 * Sets the value of the otherTest property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherTest(String value) {
		this.otherTest = value;
	}
	
	/**
	 * Gets the value of the month0SmearResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth0SmearResult() {
		return month0SmearResult;
	}
	
	/**
	 * Sets the value of the month0SmearResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth0SmearResult(String value) {
		this.month0SmearResult = value;
	}
	
	/**
	 * Gets the value of the month0SmearResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMonth0SmearResultDate() {
		return month0SmearResultDate;
	}
	
	/**
	 * Sets the value of the month0SmearResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMonth0SmearResultDate(XMLGregorianCalendar value) {
		this.month0SmearResultDate = value;
	}
	
	/**
	 * Gets the value of the month2Or3SmearResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth2Or3SmearResult() {
		return month2Or3SmearResult;
	}
	
	/**
	 * Sets the value of the month2Or3SmearResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth2Or3SmearResult(String value) {
		this.month2Or3SmearResult = value;
	}
	
	/**
	 * Gets the value of the month2Or3SmearResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMonth2Or3SmearResultDate() {
		return month2Or3SmearResultDate;
	}
	
	/**
	 * Sets the value of the month2Or3SmearResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMonth2Or3SmearResultDate(XMLGregorianCalendar value) {
		this.month2Or3SmearResultDate = value;
	}
	
	/**
	 * Gets the value of the month5SmearResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth5SmearResult() {
		return month5SmearResult;
	}
	
	/**
	 * Sets the value of the month5SmearResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth5SmearResult(String value) {
		this.month5SmearResult = value;
	}
	
	/**
	 * Gets the value of the month5SmearResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMonth5SmearResultDate() {
		return month5SmearResultDate;
	}
	
	/**
	 * Sets the value of the month5SmearResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMonth5SmearResultDate(XMLGregorianCalendar value) {
		this.month5SmearResultDate = value;
	}
	
	/**
	 * Gets the value of the month6SmearResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMonth6SmearResult() {
		return month6SmearResult;
	}
	
	/**
	 * Sets the value of the month6SmearResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMonth6SmearResult(String value) {
		this.month6SmearResult = value;
	}
	
	/**
	 * Gets the value of the month6SmearResultDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMonth6SmearResultDate() {
		return month6SmearResultDate;
	}
	
	/**
	 * Sets the value of the month6SmearResultDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMonth6SmearResultDate(XMLGregorianCalendar value) {
		this.month6SmearResultDate = value;
	}
	
	/**
	 * Gets the value of the xRayResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getXRayResult() {
		return xRayResult;
	}
	
	/**
	 * Sets the value of the xRayResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setXRayResult(String value) {
		this.xRayResult = value;
	}
	
	/**
	 * Gets the value of the biopsyResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBiopsyResult() {
		return biopsyResult;
	}
	
	/**
	 * Sets the value of the biopsyResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBiopsyResult(String value) {
		this.biopsyResult = value;
	}
	
	/**
	 * Gets the value of the treatmentOutcome property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTreatmentOutcome() {
		return treatmentOutcome;
	}
	
	/**
	 * Sets the value of the treatmentOutcome property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTreatmentOutcome(String value) {
		this.treatmentOutcome = value;
	}
	
	/**
	 * Gets the value of the outcomeDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getOutcomeDate() {
		return outcomeDate;
	}
	
	/**
	 * Sets the value of the outcomeDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setOutcomeDate(XMLGregorianCalendar value) {
		this.outcomeDate = value;
	}
	
	/**
	 * Gets the value of the previouslyKnownHIVStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPreviouslyKnownHIVStatus() {
		return previouslyKnownHIVStatus;
	}
	
	/**
	 * Sets the value of the previouslyKnownHIVStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPreviouslyKnownHIVStatus(String value) {
		this.previouslyKnownHIVStatus = value;
	}
	
	/**
	 * Gets the value of the testedForHIV property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getTestedForHIV() {
		return testedForHIV;
	}
	
	/**
	 * Sets the value of the testedForHIV property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setTestedForHIV(YNCodeType value) {
		this.testedForHIV = value;
	}
	
	/**
	 * Gets the value of the remarks property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * Sets the value of the remarks property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRemarks(String value) {
		this.remarks = value;
	}
	
}