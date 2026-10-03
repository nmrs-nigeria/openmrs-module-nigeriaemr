package org.openmrs.module.nigeriaemr.model.ndr;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PMTCTRegisterType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PMTCTRegisterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="HospitalNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ANCNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PregnancyBreastfeedingStatus" type="{}PregnancyBreastfeedingStatusType" minOccurs="0"/>
 *         &lt;element name="GestationalAgeAtBooking" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="KnownHIVPositive" type="{}KnownHIVPositiveStatusType" minOccurs="0"/>
 *         &lt;element name="HIVEarlyAcute" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Suspected"/>
 *               &lt;enumeration value="NotSuspected"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVEarlyViralLoad" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="TD"/>
 *               &lt;enumeration value="TND"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVTRANC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVTRLD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVTRBF" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVRTANC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVRTLD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVRTBF" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pos"/>
 *               &lt;enumeration value="Neg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfInitiation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TimingOfArtInitiation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="LT36"/>
 *               &lt;enumeration value="GTe36"/>
 *               &lt;enumeration value="LD"/>
 *               &lt;enumeration value="BF"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Syphilis" type="{}RegisterSyphilisType" minOccurs="0"/>
 *         &lt;element name="HepatitisB" type="{}RegisterHBVType" minOccurs="0"/>
 *         &lt;element name="InitiatedOnProphylaxis" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Treatment"/>
 *               &lt;enumeration value="Prophylaxis"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TBScreening" type="{}RegisterTBScreeningType" minOccurs="0"/>
 *         &lt;element name="ViralLoad" type="{}RegisterVLType" minOccurs="0"/>
 *         &lt;element name="PartnerNotification" type="{}PartnerNotificationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTRegisterType", propOrder = { "visitID", "visitDate", "hospitalNo", "ancNumber",
        "pregnancyBreastfeedingStatus", "gestationalAgeAtBooking", "knownHIVPositive", "hivEarlyAcute", "hivEarlyViralLoad",
        "hivtranc", "hivtrld", "hivtrbf", "hivrtanc", "hivrtld", "hivrtbf", "dateOfInitiation", "timingOfArtInitiation",
        "syphilis", "hepatitisB", "initiatedOnProphylaxis", "tbScreening", "viralLoad", "partnerNotification" })
public class PMTCTRegisterType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "HospitalNo")
	protected String hospitalNo;
	
	@XmlElement(name = "ANCNumber")
	protected String ancNumber;
	
	@XmlElement(name = "PregnancyBreastfeedingStatus")
	@XmlSchemaType(name = "string")
	protected PregnancyBreastfeedingStatusType pregnancyBreastfeedingStatus;
	
	@XmlElement(name = "GestationalAgeAtBooking")
	protected BigInteger gestationalAgeAtBooking;
	
	@XmlElement(name = "KnownHIVPositive")
	@XmlSchemaType(name = "string")
	protected KnownHIVPositiveStatusType knownHIVPositive;
	
	@XmlElement(name = "HIVEarlyAcute")
	protected String hivEarlyAcute;
	
	@XmlElement(name = "HIVEarlyViralLoad")
	protected String hivEarlyViralLoad;
	
	@XmlElement(name = "HIVTRANC")
	protected String hivtranc;
	
	@XmlElement(name = "HIVTRLD")
	protected String hivtrld;
	
	@XmlElement(name = "HIVTRBF")
	protected String hivtrbf;
	
	@XmlElement(name = "HIVRTANC")
	protected String hivrtanc;
	
	@XmlElement(name = "HIVRTLD")
	protected String hivrtld;
	
	@XmlElement(name = "HIVRTBF")
	protected String hivrtbf;
	
	@XmlElement(name = "DateOfInitiation")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfInitiation;
	
	@XmlElement(name = "TimingOfArtInitiation")
	protected String timingOfArtInitiation;
	
	@XmlElement(name = "Syphilis")
	protected RegisterSyphilisType syphilis;
	
	@XmlElement(name = "HepatitisB")
	protected RegisterHBVType hepatitisB;
	
	@XmlElement(name = "InitiatedOnProphylaxis")
	protected String initiatedOnProphylaxis;
	
	@XmlElement(name = "TBScreening")
	protected RegisterTBScreeningType tbScreening;
	
	@XmlElement(name = "ViralLoad")
	protected RegisterVLType viralLoad;
	
	@XmlElement(name = "PartnerNotification")
	protected PartnerNotificationType partnerNotification;
	
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
	 * Gets the value of the hospitalNo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHospitalNo() {
		return hospitalNo;
	}
	
	/**
	 * Sets the value of the hospitalNo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHospitalNo(String value) {
		this.hospitalNo = value;
	}
	
	/**
	 * Gets the value of the ancNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getANCNumber() {
		return ancNumber;
	}
	
	/**
	 * Sets the value of the ancNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setANCNumber(String value) {
		this.ancNumber = value;
	}
	
	/**
	 * Gets the value of the pregnancyBreastfeedingStatus property.
	 * 
	 * @return possible object is {@link PregnancyBreastfeedingStatusType }
	 */
	public PregnancyBreastfeedingStatusType getPregnancyBreastfeedingStatus() {
		return pregnancyBreastfeedingStatus;
	}
	
	/**
	 * Sets the value of the pregnancyBreastfeedingStatus property.
	 * 
	 * @param value allowed object is {@link PregnancyBreastfeedingStatusType }
	 */
	public void setPregnancyBreastfeedingStatus(PregnancyBreastfeedingStatusType value) {
		this.pregnancyBreastfeedingStatus = value;
	}
	
	/**
	 * Gets the value of the gestationalAgeAtBooking property.
	 * 
	 * @return possible object is {@link BigInteger }
	 */
	public BigInteger getGestationalAgeAtBooking() {
		return gestationalAgeAtBooking;
	}
	
	/**
	 * Sets the value of the gestationalAgeAtBooking property.
	 * 
	 * @param value allowed object is {@link BigInteger }
	 */
	public void setGestationalAgeAtBooking(BigInteger value) {
		this.gestationalAgeAtBooking = value;
	}
	
	/**
	 * Gets the value of the knownHIVPositive property.
	 * 
	 * @return possible object is {@link KnownHIVPositiveStatusType }
	 */
	public KnownHIVPositiveStatusType getKnownHIVPositive() {
		return knownHIVPositive;
	}
	
	/**
	 * Sets the value of the knownHIVPositive property.
	 * 
	 * @param value allowed object is {@link KnownHIVPositiveStatusType }
	 */
	public void setKnownHIVPositive(KnownHIVPositiveStatusType value) {
		this.knownHIVPositive = value;
	}
	
	/**
	 * Gets the value of the hivEarlyAcute property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVEarlyAcute() {
		return hivEarlyAcute;
	}
	
	/**
	 * Sets the value of the hivEarlyAcute property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVEarlyAcute(String value) {
		this.hivEarlyAcute = value;
	}
	
	/**
	 * Gets the value of the hivEarlyViralLoad property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVEarlyViralLoad() {
		return hivEarlyViralLoad;
	}
	
	/**
	 * Sets the value of the hivEarlyViralLoad property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVEarlyViralLoad(String value) {
		this.hivEarlyViralLoad = value;
	}
	
	/**
	 * Gets the value of the hivtranc property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVTRANC() {
		return hivtranc;
	}
	
	/**
	 * Sets the value of the hivtranc property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVTRANC(String value) {
		this.hivtranc = value;
	}
	
	/**
	 * Gets the value of the hivtrld property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVTRLD() {
		return hivtrld;
	}
	
	/**
	 * Sets the value of the hivtrld property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVTRLD(String value) {
		this.hivtrld = value;
	}
	
	/**
	 * Gets the value of the hivtrbf property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVTRBF() {
		return hivtrbf;
	}
	
	/**
	 * Sets the value of the hivtrbf property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVTRBF(String value) {
		this.hivtrbf = value;
	}
	
	/**
	 * Gets the value of the hivrtanc property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVRTANC() {
		return hivrtanc;
	}
	
	/**
	 * Sets the value of the hivrtanc property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVRTANC(String value) {
		this.hivrtanc = value;
	}
	
	/**
	 * Gets the value of the hivrtld property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVRTLD() {
		return hivrtld;
	}
	
	/**
	 * Sets the value of the hivrtld property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVRTLD(String value) {
		this.hivrtld = value;
	}
	
	/**
	 * Gets the value of the hivrtbf property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHIVRTBF() {
		return hivrtbf;
	}
	
	/**
	 * Sets the value of the hivrtbf property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHIVRTBF(String value) {
		this.hivrtbf = value;
	}
	
	/**
	 * Gets the value of the dateOfInitiation property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfInitiation() {
		return dateOfInitiation;
	}
	
	/**
	 * Sets the value of the dateOfInitiation property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfInitiation(XMLGregorianCalendar value) {
		this.dateOfInitiation = value;
	}
	
	/**
	 * Gets the value of the timingOfArtInitiation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTimingOfArtInitiation() {
		return timingOfArtInitiation;
	}
	
	/**
	 * Sets the value of the timingOfArtInitiation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTimingOfArtInitiation(String value) {
		this.timingOfArtInitiation = value;
	}
	
	/**
	 * Gets the value of the syphilis property.
	 * 
	 * @return possible object is {@link RegisterSyphilisType }
	 */
	public RegisterSyphilisType getSyphilis() {
		return syphilis;
	}
	
	/**
	 * Sets the value of the syphilis property.
	 * 
	 * @param value allowed object is {@link RegisterSyphilisType }
	 */
	public void setSyphilis(RegisterSyphilisType value) {
		this.syphilis = value;
	}
	
	/**
	 * Gets the value of the hepatitisB property.
	 * 
	 * @return possible object is {@link RegisterHBVType }
	 */
	public RegisterHBVType getHepatitisB() {
		return hepatitisB;
	}
	
	/**
	 * Sets the value of the hepatitisB property.
	 * 
	 * @param value allowed object is {@link RegisterHBVType }
	 */
	public void setHepatitisB(RegisterHBVType value) {
		this.hepatitisB = value;
	}
	
	/**
	 * Gets the value of the initiatedOnProphylaxis property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInitiatedOnProphylaxis() {
		return initiatedOnProphylaxis;
	}
	
	/**
	 * Sets the value of the initiatedOnProphylaxis property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInitiatedOnProphylaxis(String value) {
		this.initiatedOnProphylaxis = value;
	}
	
	/**
	 * Gets the value of the tbScreening property.
	 * 
	 * @return possible object is {@link RegisterTBScreeningType }
	 */
	public RegisterTBScreeningType getTBScreening() {
		return tbScreening;
	}
	
	/**
	 * Sets the value of the tbScreening property.
	 * 
	 * @param value allowed object is {@link RegisterTBScreeningType }
	 */
	public void setTBScreening(RegisterTBScreeningType value) {
		this.tbScreening = value;
	}
	
	/**
	 * Gets the value of the viralLoad property.
	 * 
	 * @return possible object is {@link RegisterVLType }
	 */
	public RegisterVLType getViralLoad() {
		return viralLoad;
	}
	
	/**
	 * Sets the value of the viralLoad property.
	 * 
	 * @param value allowed object is {@link RegisterVLType }
	 */
	public void setViralLoad(RegisterVLType value) {
		this.viralLoad = value;
	}
	
	/**
	 * Gets the value of the partnerNotification property.
	 * 
	 * @return possible object is {@link PartnerNotificationType }
	 */
	public PartnerNotificationType getPartnerNotification() {
		return partnerNotification;
	}
	
	/**
	 * Sets the value of the partnerNotification property.
	 * 
	 * @param value allowed object is {@link PartnerNotificationType }
	 */
	public void setPartnerNotification(PartnerNotificationType value) {
		this.partnerNotification = value;
	}
	
}
