package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for MotherInfantPairVisitType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MotherInfantPairVisitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Scheduled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GestationalAge_Weeks" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="MotherWeight_kg" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SFHLenght_cm" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MotherCurrentStatus" type="{}PregnancyBreastfeedingStatusType" minOccurs="0"/>
 *         &lt;element name="MotherCurrentARTStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="OnART"/>
 *               &lt;enumeration value="NotOnART"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MotherCurrentARTRegimen" type="{}MotherCurrentARTRegimenType" minOccurs="0"/>
 *         &lt;element name="MotherCurrentHBVStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="PositiveOnTreatment"/>
 *               &lt;enumeration value="PositiveOnProhylaxis"/>
 *               &lt;enumeration value="PositveNotOnTreatment"/>
 *               &lt;enumeration value="Negative"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MotherCurrentHBVDrugName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MotherCurrentSyphilisStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="PositiveOnTreatment"/>
 *               &lt;enumeration value="PositveNotOnTreatment"/>
 *               &lt;enumeration value="Negative"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SyphilisDrugAdministered" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ViralLoad" type="{}PairCardVisitVLType" minOccurs="0"/>
 *         &lt;element name="InfantFeedingPractice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="EBF"/>
 *               &lt;enumeration value="CIF"/>
 *               &lt;enumeration value="MF"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InfantOnCTX" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReferredToTreatment" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="HIVtreatment"/>
 *               &lt;enumeration value="Syphilistreatment"/>
 *               &lt;enumeration value="HBVtreatment"/>
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
@XmlType(name = "MotherInfantPairVisitType", propOrder = { "visitId", "visitDate", "scheduled", "gestationalAgeWeeks",
        "motherWeightKg", "sfhLenghtCm", "motherCurrentStatus", "motherCurrentARTStatus", "motherCurrentARTRegimen",
        "motherCurrentHBVStatus", "motherCurrentHBVDrugName", "motherCurrentSyphilisStatus", "syphilisDrugAdministered",
        "viralLoad", "infantFeedingPractice", "infantOnCTX", "referredToTreatment", "nextAppointmentDate" })
public class MotherInfantPairVisitType {
	
	@XmlElement(name = "VisitId", required = true)
	protected String visitId;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "Scheduled")
	protected Boolean scheduled;
	
	@XmlElement(name = "GestationalAge_Weeks")
	protected BigInteger gestationalAgeWeeks;
	
	@XmlElement(name = "MotherWeight_kg")
	protected BigDecimal motherWeightKg;
	
	@XmlElement(name = "SFHLenght_cm")
	protected BigDecimal sfhLenghtCm;
	
	@XmlElement(name = "MotherCurrentStatus")
	@XmlSchemaType(name = "string")
	protected PregnancyBreastfeedingStatusType motherCurrentStatus;
	
	@XmlElement(name = "MotherCurrentARTStatus")
	protected String motherCurrentARTStatus;
	
	@XmlElement(name = "MotherCurrentARTRegimen")
	protected MotherCurrentARTRegimenType motherCurrentARTRegimen;
	
	@XmlElement(name = "MotherCurrentHBVStatus")
	protected String motherCurrentHBVStatus;
	
	@XmlElement(name = "MotherCurrentHBVDrugName")
	protected String motherCurrentHBVDrugName;
	
	@XmlElement(name = "MotherCurrentSyphilisStatus")
	protected String motherCurrentSyphilisStatus;
	
	@XmlElement(name = "SyphilisDrugAdministered")
	protected String syphilisDrugAdministered;
	
	@XmlElement(name = "ViralLoad")
	protected PairCardVisitVLType viralLoad;
	
	@XmlElement(name = "InfantFeedingPractice")
	protected String infantFeedingPractice;
	
	@XmlElement(name = "InfantOnCTX")
	protected String infantOnCTX;
	
	@XmlElement(name = "ReferredToTreatment")
	protected String referredToTreatment;
	
	@XmlElement(name = "NextAppointmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar nextAppointmentDate;
	
	/**
	 * Gets the value of the visitId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitId() {
		return visitId;
	}
	
	/**
	 * Sets the value of the visitId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitId(String value) {
		this.visitId = value;
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
	 * Gets the value of the scheduled property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isScheduled() {
		return scheduled;
	}
	
	/**
	 * Sets the value of the scheduled property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setScheduled(Boolean value) {
		this.scheduled = value;
	}
	
	/**
	 * Gets the value of the gestationalAgeWeeks property.
	 * 
	 * @return possible object is {@link BigInteger }
	 */
	public BigInteger getGestationalAgeWeeks() {
		return gestationalAgeWeeks;
	}
	
	/**
	 * Sets the value of the gestationalAgeWeeks property.
	 * 
	 * @param value allowed object is {@link BigInteger }
	 */
	public void setGestationalAgeWeeks(BigInteger value) {
		this.gestationalAgeWeeks = value;
	}
	
	/**
	 * Gets the value of the motherWeightKg property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getMotherWeightKg() {
		return motherWeightKg;
	}
	
	/**
	 * Sets the value of the motherWeightKg property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setMotherWeightKg(BigDecimal value) {
		this.motherWeightKg = value;
	}
	
	/**
	 * Gets the value of the sfhLenghtCm property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getSFHLenghtCm() {
		return sfhLenghtCm;
	}
	
	/**
	 * Sets the value of the sfhLenghtCm property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setSFHLenghtCm(BigDecimal value) {
		this.sfhLenghtCm = value;
	}
	
	/**
	 * Gets the value of the motherCurrentStatus property.
	 * 
	 * @return possible object is {@link PregnancyBreastfeedingStatusType }
	 */
	public PregnancyBreastfeedingStatusType getMotherCurrentStatus() {
		return motherCurrentStatus;
	}
	
	/**
	 * Sets the value of the motherCurrentStatus property.
	 * 
	 * @param value allowed object is {@link PregnancyBreastfeedingStatusType }
	 */
	public void setMotherCurrentStatus(PregnancyBreastfeedingStatusType value) {
		this.motherCurrentStatus = value;
	}
	
	/**
	 * Gets the value of the motherCurrentARTStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherCurrentARTStatus() {
		return motherCurrentARTStatus;
	}
	
	/**
	 * Sets the value of the motherCurrentARTStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherCurrentARTStatus(String value) {
		this.motherCurrentARTStatus = value;
	}
	
	/**
	 * Gets the value of the motherCurrentARTRegimen property.
	 * 
	 * @return possible object is {@link MotherCurrentARTRegimenType }
	 */
	public MotherCurrentARTRegimenType getMotherCurrentARTRegimen() {
		return motherCurrentARTRegimen;
	}
	
	/**
	 * Sets the value of the motherCurrentARTRegimen property.
	 * 
	 * @param value allowed object is {@link MotherCurrentARTRegimenType }
	 */
	public void setMotherCurrentARTRegimen(MotherCurrentARTRegimenType value) {
		this.motherCurrentARTRegimen = value;
	}
	
	/**
	 * Gets the value of the motherCurrentHBVStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherCurrentHBVStatus() {
		return motherCurrentHBVStatus;
	}
	
	/**
	 * Sets the value of the motherCurrentHBVStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherCurrentHBVStatus(String value) {
		this.motherCurrentHBVStatus = value;
	}
	
	/**
	 * Gets the value of the motherCurrentHBVDrugName property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherCurrentHBVDrugName() {
		return motherCurrentHBVDrugName;
	}
	
	/**
	 * Sets the value of the motherCurrentHBVDrugName property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherCurrentHBVDrugName(String value) {
		this.motherCurrentHBVDrugName = value;
	}
	
	/**
	 * Gets the value of the motherCurrentSyphilisStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMotherCurrentSyphilisStatus() {
		return motherCurrentSyphilisStatus;
	}
	
	/**
	 * Sets the value of the motherCurrentSyphilisStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMotherCurrentSyphilisStatus(String value) {
		this.motherCurrentSyphilisStatus = value;
	}
	
	/**
	 * Gets the value of the syphilisDrugAdministered property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSyphilisDrugAdministered() {
		return syphilisDrugAdministered;
	}
	
	/**
	 * Sets the value of the syphilisDrugAdministered property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSyphilisDrugAdministered(String value) {
		this.syphilisDrugAdministered = value;
	}
	
	/**
	 * Gets the value of the viralLoad property.
	 * 
	 * @return possible object is {@link PairCardVisitVLType }
	 */
	public PairCardVisitVLType getViralLoad() {
		return viralLoad;
	}
	
	/**
	 * Sets the value of the viralLoad property.
	 * 
	 * @param value allowed object is {@link PairCardVisitVLType }
	 */
	public void setViralLoad(PairCardVisitVLType value) {
		this.viralLoad = value;
	}
	
	/**
	 * Gets the value of the infantFeedingPractice property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInfantFeedingPractice() {
		return infantFeedingPractice;
	}
	
	/**
	 * Sets the value of the infantFeedingPractice property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInfantFeedingPractice(String value) {
		this.infantFeedingPractice = value;
	}
	
	/**
	 * Gets the value of the infantOnCTX property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInfantOnCTX() {
		return infantOnCTX;
	}
	
	/**
	 * Sets the value of the infantOnCTX property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInfantOnCTX(String value) {
		this.infantOnCTX = value;
	}
	
	/**
	 * Gets the value of the referredToTreatment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredToTreatment() {
		return referredToTreatment;
	}
	
	/**
	 * Sets the value of the referredToTreatment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredToTreatment(String value) {
		this.referredToTreatment = value;
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
