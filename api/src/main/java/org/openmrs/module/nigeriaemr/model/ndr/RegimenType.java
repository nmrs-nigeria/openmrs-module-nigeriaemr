package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for RegimenType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Pregnant" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="Refil" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="RegimenSubstitution" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="RegimenSwitch" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="DSDModelFacility" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Occupational"/>
 *               &lt;enumeration value="NonOccupational"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EAC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="First"/>
 *               &lt;enumeration value="Second"/>
 *               &lt;enumeration value="Third"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PrescribedRegimen" type="{}RegimenCodedSimpleType"/>
 *         &lt;element name="PrescribedRegimenTypeCode" type="{}CodeType"/>
 *         &lt;element name="PrescribedRegimenLineCode" type="{}CodeType" minOccurs="0"/>
 *         &lt;element name="PrescribedRegimenDuration" type="{}CodeType"/>
 *         &lt;element name="PrescribedRegimenDispensedDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DateRegimenStarted" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateRegimenStartedDD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenStartedMM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenStartedYYYY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEnded" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateRegimenEndedDD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEndedMM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateRegimenEndedYYYY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PillBalance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DifferentiatedServiceDelivery" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="DSD1"/>
 *               &lt;enumeration value="DSD2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Dispensing" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FD1"/>
 *               &lt;enumeration value="FD2"/>
 *               &lt;enumeration value="FD3"/>
 *               &lt;enumeration value="FBM2"/>
 *               &lt;enumeration value="FBM3"/>
 *               &lt;enumeration value="FBM4"/>
 *               &lt;enumeration value="FBM5"/>
 *               &lt;enumeration value="FBM6"/>
 *               &lt;enumeration value="FBM7"/>
 *               &lt;enumeration value="FBM8"/>
 *               &lt;enumeration value="DDD01"/>
 *               &lt;enumeration value="DDD02"/>
 *               &lt;enumeration value="DDD03"/>
 *               &lt;enumeration value="DDD04"/>
 *               &lt;enumeration value="DDD05"/>
 *               &lt;enumeration value="DDD06"/>
 *               &lt;enumeration value="DDD07"/>
 *               &lt;enumeration value="CBM2"/>
 *               &lt;enumeration value="CBM3"/>
 *               &lt;enumeration value="CBM4"/>
 *               &lt;enumeration value="CBM6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MultiMonthDispensing" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="MMD1"/>
 *               &lt;enumeration value="MMD2"/>
 *               &lt;enumeration value="MMD3"/>
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
@XmlType(name = "RegimenType", propOrder = { "visitID", "visitDate", "pregnant", "refil", "regimenSubstitution",
        "regimenSwitch", "dsdModelFacility", "eac", "prescribedRegimen", "prescribedRegimenTypeCode",
        "prescribedRegimenLineCode", "prescribedRegimenDuration", "prescribedRegimenDispensedDate", "dateRegimenStarted",
        "dateRegimenStartedDD", "dateRegimenStartedMM", "dateRegimenStartedYYYY", "dateRegimenEnded", "dateRegimenEndedDD",
        "dateRegimenEndedMM", "dateRegimenEndedYYYY", "pillBalance", "differentiatedServiceDelivery", "dispensing",
        "multiMonthDispensing", "nextAppointmentDate" })
public class RegimenType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "Pregnant")
	@XmlSchemaType(name = "string")
	protected YNCodeType pregnant;
	
	@XmlElement(name = "Refil")
	@XmlSchemaType(name = "string")
	protected YNCodeType refil;
	
	@XmlElement(name = "RegimenSubstitution")
	@XmlSchemaType(name = "string")
	protected YNCodeType regimenSubstitution;
	
	@XmlElement(name = "RegimenSwitch")
	@XmlSchemaType(name = "string")
	protected YNCodeType regimenSwitch;
	
	@XmlElement(name = "DSDModelFacility")
	protected String dsdModelFacility;
	
	@XmlElement(name = "EAC")
	protected String eac;
	
	@XmlElement(name = "PrescribedRegimen", required = true)
	protected RegimenCodedSimpleType prescribedRegimen;
	
	@XmlElement(name = "PrescribedRegimenTypeCode", required = true)
	protected String prescribedRegimenTypeCode;
	
	@XmlElement(name = "PrescribedRegimenLineCode")
	protected String prescribedRegimenLineCode;
	
	@XmlElement(name = "PrescribedRegimenDuration", required = true)
	protected String prescribedRegimenDuration;
	
	@XmlElement(name = "PrescribedRegimenDispensedDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar prescribedRegimenDispensedDate;
	
	@XmlElement(name = "DateRegimenStarted")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateRegimenStarted;
	
	@XmlElement(name = "DateRegimenStartedDD")
	protected String dateRegimenStartedDD;
	
	@XmlElement(name = "DateRegimenStartedMM")
	protected String dateRegimenStartedMM;
	
	@XmlElement(name = "DateRegimenStartedYYYY")
	protected String dateRegimenStartedYYYY;
	
	@XmlElement(name = "DateRegimenEnded")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateRegimenEnded;
	
	@XmlElement(name = "DateRegimenEndedDD")
	protected String dateRegimenEndedDD;
	
	@XmlElement(name = "DateRegimenEndedMM")
	protected String dateRegimenEndedMM;
	
	@XmlElement(name = "DateRegimenEndedYYYY")
	protected String dateRegimenEndedYYYY;
	
	@XmlElement(name = "PillBalance")
	protected Integer pillBalance;
	
	@XmlElement(name = "DifferentiatedServiceDelivery")
	protected String differentiatedServiceDelivery;
	
	@XmlElement(name = "Dispensing")
	protected String dispensing;
	
	@XmlElement(name = "MultiMonthDispensing")
	protected String multiMonthDispensing;
	
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
	 * Gets the value of the pregnant property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getPregnant() {
		return pregnant;
	}
	
	/**
	 * Sets the value of the pregnant property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setPregnant(YNCodeType value) {
		this.pregnant = value;
	}
	
	/**
	 * Gets the value of the refil property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getRefil() {
		return refil;
	}
	
	/**
	 * Sets the value of the refil property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setRefil(YNCodeType value) {
		this.refil = value;
	}
	
	/**
	 * Gets the value of the regimenSubstitution property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getRegimenSubstitution() {
		return regimenSubstitution;
	}
	
	/**
	 * Sets the value of the regimenSubstitution property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setRegimenSubstitution(YNCodeType value) {
		this.regimenSubstitution = value;
	}
	
	/**
	 * Gets the value of the regimenSwitch property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getRegimenSwitch() {
		return regimenSwitch;
	}
	
	/**
	 * Sets the value of the regimenSwitch property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setRegimenSwitch(YNCodeType value) {
		this.regimenSwitch = value;
	}
	
	/**
	 * Gets the value of the dsdModelFacility property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDSDModelFacility() {
		return dsdModelFacility;
	}
	
	/**
	 * Sets the value of the dsdModelFacility property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDSDModelFacility(String value) {
		this.dsdModelFacility = value;
	}
	
	/**
	 * Gets the value of the eac property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEAC() {
		return eac;
	}
	
	/**
	 * Sets the value of the eac property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEAC(String value) {
		this.eac = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimen property.
	 * 
	 * @return possible object is {@link RegimenCodedSimpleType }
	 */
	public RegimenCodedSimpleType getPrescribedRegimen() {
		return prescribedRegimen;
	}
	
	/**
	 * Sets the value of the prescribedRegimen property.
	 * 
	 * @param value allowed object is {@link RegimenCodedSimpleType }
	 */
	public void setPrescribedRegimen(RegimenCodedSimpleType value) {
		this.prescribedRegimen = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenTypeCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenTypeCode() {
		return prescribedRegimenTypeCode;
	}
	
	/**
	 * Sets the value of the prescribedRegimenTypeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenTypeCode(String value) {
		this.prescribedRegimenTypeCode = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenLineCode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenLineCode() {
		return prescribedRegimenLineCode;
	}
	
	/**
	 * Sets the value of the prescribedRegimenLineCode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenLineCode(String value) {
		this.prescribedRegimenLineCode = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenDuration property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPrescribedRegimenDuration() {
		return prescribedRegimenDuration;
	}
	
	/**
	 * Sets the value of the prescribedRegimenDuration property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPrescribedRegimenDuration(String value) {
		this.prescribedRegimenDuration = value;
	}
	
	/**
	 * Gets the value of the prescribedRegimenDispensedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getPrescribedRegimenDispensedDate() {
		return prescribedRegimenDispensedDate;
	}
	
	/**
	 * Sets the value of the prescribedRegimenDispensedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setPrescribedRegimenDispensedDate(XMLGregorianCalendar value) {
		this.prescribedRegimenDispensedDate = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStarted property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateRegimenStarted() {
		return dateRegimenStarted;
	}
	
	/**
	 * Sets the value of the dateRegimenStarted property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateRegimenStarted(XMLGregorianCalendar value) {
		this.dateRegimenStarted = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedDD property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedDD() {
		return dateRegimenStartedDD;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedDD property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedDD(String value) {
		this.dateRegimenStartedDD = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedMM property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedMM() {
		return dateRegimenStartedMM;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedMM property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedMM(String value) {
		this.dateRegimenStartedMM = value;
	}
	
	/**
	 * Gets the value of the dateRegimenStartedYYYY property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenStartedYYYY() {
		return dateRegimenStartedYYYY;
	}
	
	/**
	 * Sets the value of the dateRegimenStartedYYYY property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenStartedYYYY(String value) {
		this.dateRegimenStartedYYYY = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEnded property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateRegimenEnded() {
		return dateRegimenEnded;
	}
	
	/**
	 * Sets the value of the dateRegimenEnded property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateRegimenEnded(XMLGregorianCalendar value) {
		this.dateRegimenEnded = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedDD property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedDD() {
		return dateRegimenEndedDD;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedDD property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedDD(String value) {
		this.dateRegimenEndedDD = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedMM property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedMM() {
		return dateRegimenEndedMM;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedMM property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedMM(String value) {
		this.dateRegimenEndedMM = value;
	}
	
	/**
	 * Gets the value of the dateRegimenEndedYYYY property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDateRegimenEndedYYYY() {
		return dateRegimenEndedYYYY;
	}
	
	/**
	 * Sets the value of the dateRegimenEndedYYYY property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDateRegimenEndedYYYY(String value) {
		this.dateRegimenEndedYYYY = value;
	}
	
	/**
	 * Gets the value of the pillBalance property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getPillBalance() {
		return pillBalance;
	}
	
	/**
	 * Sets the value of the pillBalance property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setPillBalance(Integer value) {
		this.pillBalance = value;
	}
	
	/**
	 * Gets the value of the differentiatedServiceDelivery property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDifferentiatedServiceDelivery() {
		return differentiatedServiceDelivery;
	}
	
	/**
	 * Sets the value of the differentiatedServiceDelivery property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDifferentiatedServiceDelivery(String value) {
		this.differentiatedServiceDelivery = value;
	}
	
	/**
	 * Gets the value of the dispensing property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDispensing() {
		return dispensing;
	}
	
	/**
	 * Sets the value of the dispensing property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDispensing(String value) {
		this.dispensing = value;
	}
	
	/**
	 * Gets the value of the multiMonthDispensing property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getMultiMonthDispensing() {
		return multiMonthDispensing;
	}
	
	/**
	 * Sets the value of the multiMonthDispensing property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setMultiMonthDispensing(String value) {
		this.multiMonthDispensing = value;
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
