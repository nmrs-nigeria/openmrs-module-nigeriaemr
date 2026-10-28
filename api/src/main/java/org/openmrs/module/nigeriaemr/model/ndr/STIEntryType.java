package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for STIEntryType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STIEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="PopulationType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="SerodiscordantCouplesSDC"/>
 *               &lt;enumeration value="SexWorkers"/>
 *               &lt;enumeration value="PartnersOfSexWorkers"/>
 *               &lt;enumeration value="InjectingDrugUsers"/>
 *               &lt;enumeration value="AnalSexRegular"/>
 *               &lt;enumeration value="ExposedAdolescentsYoungPeople"/>
 *               &lt;enumeration value="Transgender"/>
 *               &lt;enumeration value="AtRiskPregnantBreastfeedingWomen"/>
 *               &lt;enumeration value="OtherPopulation"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UrethalDischarge" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="AbnormalVaginalDischarge" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="LowerAbdominalPain" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="GenitalUlcer" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="AnalGenitalWarts" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="PainfulScrotelSwelling" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="InguinalSwellingBuboes" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="SwabCollected" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="SwabResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Reactive"/>
 *               &lt;enumeration value="NonReactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Aetiology" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Syphilis"/>
 *               &lt;enumeration value="Chlamydia"/>
 *               &lt;enumeration value="Gonorrhea"/>
 *               &lt;enumeration value="Trichomoniasis"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Positive"/>
 *               &lt;enumeration value="Negative"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OutcomeOfVisit" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Treated"/>
 *               &lt;enumeration value="NotTreated"/>
 *               &lt;enumeration value="ReferredOut"/>
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
@XmlType(name = "STIEntryType", propOrder = { "registrationDate", "populationType", "urethalDischarge",
        "abnormalVaginalDischarge", "lowerAbdominalPain", "genitalUlcer", "analGenitalWarts", "painfulScrotelSwelling",
        "inguinalSwellingBuboes", "swabCollected", "swabResult", "aetiology", "hivStatus", "outcomeOfVisit" })
public class STIEntryType {
	
	@XmlElement(name = "RegistrationDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar registrationDate;
	
	@XmlElement(name = "PopulationType")
	protected String populationType;
	
	@XmlElement(name = "UrethalDischarge")
	@XmlSchemaType(name = "string")
	protected YNCodeType urethalDischarge;
	
	@XmlElement(name = "AbnormalVaginalDischarge")
	@XmlSchemaType(name = "string")
	protected YNCodeType abnormalVaginalDischarge;
	
	@XmlElement(name = "LowerAbdominalPain")
	@XmlSchemaType(name = "string")
	protected YNCodeType lowerAbdominalPain;
	
	@XmlElement(name = "GenitalUlcer")
	@XmlSchemaType(name = "string")
	protected YNCodeType genitalUlcer;
	
	@XmlElement(name = "AnalGenitalWarts")
	@XmlSchemaType(name = "string")
	protected YNCodeType analGenitalWarts;
	
	@XmlElement(name = "PainfulScrotelSwelling")
	@XmlSchemaType(name = "string")
	protected YNCodeType painfulScrotelSwelling;
	
	@XmlElement(name = "InguinalSwellingBuboes")
	@XmlSchemaType(name = "string")
	protected YNCodeType inguinalSwellingBuboes;
	
	@XmlElement(name = "SwabCollected")
	@XmlSchemaType(name = "string")
	protected YNCodeType swabCollected;
	
	@XmlElement(name = "SwabResult")
	protected String swabResult;
	
	@XmlElement(name = "Aetiology")
	protected String aetiology;
	
	@XmlElement(name = "HIVStatus")
	protected String hivStatus;
	
	@XmlElement(name = "OutcomeOfVisit")
	protected String outcomeOfVisit;
	
	/**
	 * Gets the value of the registrationDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRegistrationDate() {
		return registrationDate;
	}
	
	/**
	 * Sets the value of the registrationDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRegistrationDate(XMLGregorianCalendar value) {
		this.registrationDate = value;
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
	 * Gets the value of the urethalDischarge property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getUrethalDischarge() {
		return urethalDischarge;
	}
	
	/**
	 * Sets the value of the urethalDischarge property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setUrethalDischarge(YNCodeType value) {
		this.urethalDischarge = value;
	}
	
	/**
	 * Gets the value of the abnormalVaginalDischarge property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getAbnormalVaginalDischarge() {
		return abnormalVaginalDischarge;
	}
	
	/**
	 * Sets the value of the abnormalVaginalDischarge property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setAbnormalVaginalDischarge(YNCodeType value) {
		this.abnormalVaginalDischarge = value;
	}
	
	/**
	 * Gets the value of the lowerAbdominalPain property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getLowerAbdominalPain() {
		return lowerAbdominalPain;
	}
	
	/**
	 * Sets the value of the lowerAbdominalPain property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setLowerAbdominalPain(YNCodeType value) {
		this.lowerAbdominalPain = value;
	}
	
	/**
	 * Gets the value of the genitalUlcer property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getGenitalUlcer() {
		return genitalUlcer;
	}
	
	/**
	 * Sets the value of the genitalUlcer property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setGenitalUlcer(YNCodeType value) {
		this.genitalUlcer = value;
	}
	
	/**
	 * Gets the value of the analGenitalWarts property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getAnalGenitalWarts() {
		return analGenitalWarts;
	}
	
	/**
	 * Sets the value of the analGenitalWarts property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setAnalGenitalWarts(YNCodeType value) {
		this.analGenitalWarts = value;
	}
	
	/**
	 * Gets the value of the painfulScrotelSwelling property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getPainfulScrotelSwelling() {
		return painfulScrotelSwelling;
	}
	
	/**
	 * Sets the value of the painfulScrotelSwelling property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setPainfulScrotelSwelling(YNCodeType value) {
		this.painfulScrotelSwelling = value;
	}
	
	/**
	 * Gets the value of the inguinalSwellingBuboes property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getInguinalSwellingBuboes() {
		return inguinalSwellingBuboes;
	}
	
	/**
	 * Sets the value of the inguinalSwellingBuboes property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setInguinalSwellingBuboes(YNCodeType value) {
		this.inguinalSwellingBuboes = value;
	}
	
	/**
	 * Gets the value of the swabCollected property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getSwabCollected() {
		return swabCollected;
	}
	
	/**
	 * Sets the value of the swabCollected property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setSwabCollected(YNCodeType value) {
		this.swabCollected = value;
	}
	
	/**
	 * Gets the value of the swabResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSwabResult() {
		return swabResult;
	}
	
	/**
	 * Sets the value of the swabResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSwabResult(String value) {
		this.swabResult = value;
	}
	
	/**
	 * Gets the value of the aetiology property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAetiology() {
		return aetiology;
	}
	
	/**
	 * Sets the value of the aetiology property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAetiology(String value) {
		this.aetiology = value;
	}
	
	/**
	 * Gets the value of the hivStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVStatus() {
		return hivStatus;
	}
	
	/**
	 * Sets the value of the hivStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVStatus(String value) {
		this.hivStatus = value;
	}
	
	/**
	 * Gets the value of the outcomeOfVisit property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOutcomeOfVisit() {
		return outcomeOfVisit;
	}
	
	/**
	 * Sets the value of the outcomeOfVisit property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOutcomeOfVisit(String value) {
		this.outcomeOfVisit = value;
	}
	
}
