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
 * Java class for DeliveryChildrenDetailsType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryChildrenDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateOfDelivery" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ModeOfDelivery" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Vaginal"/>
 *               &lt;enumeration value="ElectiveCS"/>
 *               &lt;enumeration value="EmergencyCS"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BirthWeight_kg" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BirthLength_cm" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BirthOutcome" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Dead"/>
 *               &lt;enumeration value="Alive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ChildHospitalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChildEntryPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ANC"/>
 *               &lt;enumeration value="LD"/>
 *               &lt;enumeration value="Postnatal"/>
 *               &lt;enumeration value="Immunization"/>
 *               &lt;enumeration value="OPD"/>
 *               &lt;enumeration value="Inpatient"/>
 *               &lt;enumeration value="Nutrition"/>
 *               &lt;enumeration value="FamilyPlanning"/>
 *               &lt;enumeration value="TransferIn"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HIVProphylaxis" type="{}InfantHIVProphylaxisType" minOccurs="0"/>
 *         &lt;element name="SyphilisProphylaxis" type="{}InfantSyphilisProphylaxisType" minOccurs="0"/>
 *         &lt;element name="CTX" type="{}InfantCTXType" minOccurs="0"/>
 *         &lt;element name="HBVVaccination" type="{}InfantHBVVaccinationType" minOccurs="0"/>
 *         &lt;element name="DNAPCR" type="{}DPCRTestType" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="RapidTestAt18Months" type="{}ConfirmatoryPCRType" minOccurs="0"/>
 *         &lt;element name="OutcomeAt18Months" type="{}InfantOutcomeStatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryChildrenDetailsType", propOrder = { "dateOfDelivery", "modeOfDelivery", "birthWeightKg",
        "birthLengthCm", "birthOutcome", "childHospitalNumber", "childEntryPoint", "sex", "hivProphylaxis",
        "syphilisProphylaxis", "ctx", "hbvVaccination", "dnapcr", "rapidTestAt18Months", "outcomeAt18Months" })
public class DeliveryChildrenDetailsType {
	
	@XmlElement(name = "DateOfDelivery")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfDelivery;
	
	@XmlElement(name = "ModeOfDelivery")
	protected String modeOfDelivery;
	
	@XmlElement(name = "BirthWeight_kg")
	protected BigDecimal birthWeightKg;
	
	@XmlElement(name = "BirthLength_cm")
	protected BigDecimal birthLengthCm;
	
	@XmlElement(name = "BirthOutcome")
	protected String birthOutcome;
	
	@XmlElement(name = "ChildHospitalNumber")
	protected String childHospitalNumber;
	
	@XmlElement(name = "ChildEntryPoint")
	protected String childEntryPoint;
	
	@XmlElement(name = "Sex")
	protected String sex;
	
	@XmlElement(name = "HIVProphylaxis")
	protected InfantHIVProphylaxisType hivProphylaxis;
	
	@XmlElement(name = "SyphilisProphylaxis")
	protected InfantSyphilisProphylaxisType syphilisProphylaxis;
	
	@XmlElement(name = "CTX")
	protected InfantCTXType ctx;
	
	@XmlElement(name = "HBVVaccination")
	protected InfantHBVVaccinationType hbvVaccination;
	
	@XmlElement(name = "DNAPCR")
	protected List<DPCRTestType> dnapcr;
	
	@XmlElement(name = "RapidTestAt18Months")
	protected ConfirmatoryPCRType rapidTestAt18Months;
	
	@XmlElement(name = "OutcomeAt18Months")
	@XmlSchemaType(name = "string")
	protected InfantOutcomeStatusType outcomeAt18Months;
	
	/**
	 * Gets the value of the dateOfDelivery property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfDelivery() {
		return dateOfDelivery;
	}
	
	/**
	 * Sets the value of the dateOfDelivery property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfDelivery(XMLGregorianCalendar value) {
		this.dateOfDelivery = value;
	}
	
	/**
	 * Gets the value of the modeOfDelivery property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getModeOfDelivery() {
		return modeOfDelivery;
	}
	
	/**
	 * Sets the value of the modeOfDelivery property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setModeOfDelivery(String value) {
		this.modeOfDelivery = value;
	}
	
	/**
	 * Gets the value of the birthWeightKg property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBirthWeightKg() {
		return birthWeightKg;
	}
	
	/**
	 * Sets the value of the birthWeightKg property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBirthWeightKg(BigDecimal value) {
		this.birthWeightKg = value;
	}
	
	/**
	 * Gets the value of the birthLengthCm property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBirthLengthCm() {
		return birthLengthCm;
	}
	
	/**
	 * Sets the value of the birthLengthCm property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBirthLengthCm(BigDecimal value) {
		this.birthLengthCm = value;
	}
	
	/**
	 * Gets the value of the birthOutcome property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getBirthOutcome() {
		return birthOutcome;
	}
	
	/**
	 * Sets the value of the birthOutcome property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setBirthOutcome(String value) {
		this.birthOutcome = value;
	}
	
	/**
	 * Gets the value of the childHospitalNumber property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildHospitalNumber() {
		return childHospitalNumber;
	}
	
	/**
	 * Sets the value of the childHospitalNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildHospitalNumber(String value) {
		this.childHospitalNumber = value;
	}
	
	/**
	 * Gets the value of the childEntryPoint property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildEntryPoint() {
		return childEntryPoint;
	}
	
	/**
	 * Sets the value of the childEntryPoint property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildEntryPoint(String value) {
		this.childEntryPoint = value;
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
	 * Gets the value of the hivProphylaxis property.
	 * 
	 * @return possible object is {@link InfantHIVProphylaxisType }
	 */
	public InfantHIVProphylaxisType getHIVProphylaxis() {
		return hivProphylaxis;
	}
	
	/**
	 * Sets the value of the hivProphylaxis property.
	 * 
	 * @param value allowed object is {@link InfantHIVProphylaxisType }
	 */
	public void setHIVProphylaxis(InfantHIVProphylaxisType value) {
		this.hivProphylaxis = value;
	}
	
	/**
	 * Gets the value of the syphilisProphylaxis property.
	 * 
	 * @return possible object is {@link InfantSyphilisProphylaxisType }
	 */
	public InfantSyphilisProphylaxisType getSyphilisProphylaxis() {
		return syphilisProphylaxis;
	}
	
	/**
	 * Sets the value of the syphilisProphylaxis property.
	 * 
	 * @param value allowed object is {@link InfantSyphilisProphylaxisType }
	 */
	public void setSyphilisProphylaxis(InfantSyphilisProphylaxisType value) {
		this.syphilisProphylaxis = value;
	}
	
	/**
	 * Gets the value of the ctx property.
	 * 
	 * @return possible object is {@link InfantCTXType }
	 */
	public InfantCTXType getCTX() {
		return ctx;
	}
	
	/**
	 * Sets the value of the ctx property.
	 * 
	 * @param value allowed object is {@link InfantCTXType }
	 */
	public void setCTX(InfantCTXType value) {
		this.ctx = value;
	}
	
	/**
	 * Gets the value of the hbvVaccination property.
	 * 
	 * @return possible object is {@link InfantHBVVaccinationType }
	 */
	public InfantHBVVaccinationType getHBVVaccination() {
		return hbvVaccination;
	}
	
	/**
	 * Sets the value of the hbvVaccination property.
	 * 
	 * @param value allowed object is {@link InfantHBVVaccinationType }
	 */
	public void setHBVVaccination(InfantHBVVaccinationType value) {
		this.hbvVaccination = value;
	}
	
	/**
	 * Gets the value of the dnapcr property.
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the dnapcr property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
     *    getDNAPCR().add(newItem);
     * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DPCRTestType }
	 */
	public List<DPCRTestType> getDNAPCR() {
		if (dnapcr == null) {
			dnapcr = new ArrayList<DPCRTestType>();
		}
		return this.dnapcr;
	}
	
	/**
	 * Gets the value of the rapidTestAt18Months property.
	 * 
	 * @return possible object is {@link ConfirmatoryPCRType }
	 */
	public ConfirmatoryPCRType getRapidTestAt18Months() {
		return rapidTestAt18Months;
	}
	
	/**
	 * Sets the value of the rapidTestAt18Months property.
	 * 
	 * @param value allowed object is {@link ConfirmatoryPCRType }
	 */
	public void setRapidTestAt18Months(ConfirmatoryPCRType value) {
		this.rapidTestAt18Months = value;
	}
	
	/**
	 * Gets the value of the outcomeAt18Months property.
	 * 
	 * @return possible object is {@link InfantOutcomeStatusType }
	 */
	public InfantOutcomeStatusType getOutcomeAt18Months() {
		return outcomeAt18Months;
	}
	
	/**
	 * Sets the value of the outcomeAt18Months property.
	 * 
	 * @param value allowed object is {@link InfantOutcomeStatusType }
	 */
	public void setOutcomeAt18Months(InfantOutcomeStatusType value) {
		this.outcomeAt18Months = value;
	}
	
}
