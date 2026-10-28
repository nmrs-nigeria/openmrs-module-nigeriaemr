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
 * Java class for ViralHepatitisType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViralHepatitisType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CareEntryPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="RI"/>
 *               &lt;enumeration value="WC"/>
 *               &lt;enumeration value="BT"/>
 *               &lt;enumeration value="OPD"/>
 *               &lt;enumeration value="IPD"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="H"/>
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="OD"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BMI" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BloodPressure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pregnant" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="NA"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Breastfeeding" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *               &lt;enumeration value="NA"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InjectionDrugUse" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HBsAgResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Reactive"/>
 *               &lt;enumeration value="NonReactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateFirstPositiveHBV" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HBsAgQuantification" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="HBeAgResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Reactive"/>
 *               &lt;enumeration value="NonReactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AntiHDVResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Reactive"/>
 *               &lt;enumeration value="NonReactive"/>
 *               &lt;enumeration value="NotDone"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateHBVDNARequested" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateHBVDNASampleCollected" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DateHBVDNAResultReported" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HBVDNAResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVAbResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Reactive"/>
 *               &lt;enumeration value="NonReactive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateFirstPositiveHCV" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVRNAResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HBVTreatmentEligible" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PMTCTEligible" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CoInfectionStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="HBV_HCV"/>
 *               &lt;enumeration value="HBV_HIV"/>
 *               &lt;enumeration value="HCV_HIV"/>
 *               &lt;enumeration value="HBV_HDV"/>
 *               &lt;enumeration value="HBV_HCV_HIV"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherComorbidities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AST" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PlateletCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BilirubinTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="BilirubinDirect" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Albumin" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="APRIScore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FIB4Score" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PTINR" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Urea" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Creatinine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="AFP" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UltrasoundScanResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fibroscan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CTScan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ascites" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Mild"/>
 *               &lt;enumeration value="Moderate"/>
 *               &lt;enumeration value="Massive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EncephalopathyGrade" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Grade0"/>
 *               &lt;enumeration value="Grade1"/>
 *               &lt;enumeration value="Grade2"/>
 *               &lt;enumeration value="Grade3"/>
 *               &lt;enumeration value="Grade4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ChildPughScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LiverBiopsyStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StagingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ClinicalDiagnosis" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NoFibrosis"/>
 *               &lt;enumeration value="Fibrosis"/>
 *               &lt;enumeration value="Cirrhosis"/>
 *               &lt;enumeration value="HCC"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HBVTreatmentExperience" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PastHBVRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewHBVRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateHBVStarted" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HBVAdverseEvents" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HBVSwitchRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HBVSwitchDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HBVSwitchAdverseEvents" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReasonHBVSwitch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateHBVStopped" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVTreatmentExperience" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PastHCVRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVTreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVTreatmentCompletionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVInitialPrescribedDuration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Weeks8"/>
 *               &lt;enumeration value="Weeks12"/>
 *               &lt;enumeration value="Weeks24"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HCVNewRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVNewRegimenPrescribedDuration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Weeks8"/>
 *               &lt;enumeration value="Weeks12"/>
 *               &lt;enumeration value="Weeks24"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HCVNewRegimenStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVNewRegimenCompletionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVAdverseEvent" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SVR12TestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SVR12HCVRNAResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVGenotype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVRetreatmentRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HCVRetreatmentDuration" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Weeks8"/>
 *               &lt;enumeration value="Weeks12"/>
 *               &lt;enumeration value="Weeks24"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HCVRetreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="HCVRetreatmentCompletionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RetreatmentSVR12Date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RetreatmentSVR12Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NextAppointmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Outcome" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="LT"/>
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="U"/>
 *               &lt;enumeration value="NS"/>
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
@XmlType(name = "ViralHepatitisType", propOrder = { "visitID", "visitDate", "careEntryPoint", "weight", "height", "bmi",
        "bloodPressure", "pregnant", "breastfeeding", "injectionDrugUse", "hBsAgResult", "dateFirstPositiveHBV",
        "hBsAgQuantification", "hBeAgResult", "antiHDVResult", "dateHBVDNARequested", "dateHBVDNASampleCollected",
        "dateHBVDNAResultReported", "hbvdnaResult", "hcvAbResult", "dateFirstPositiveHCV", "hcvrnaResult",
        "hbvTreatmentEligible", "pmtctEligible", "coInfectionStatus", "otherComorbidities", "alt", "ast", "plateletCount",
        "bilirubinTotal", "bilirubinDirect", "albumin", "apriScore", "fib4Score", "ptinr", "urea", "creatinine", "afp",
        "ultrasoundScanResult", "fibroscan", "ctScan", "ascites", "encephalopathyGrade", "childPughScore",
        "liverBiopsyStage", "stagingDate", "clinicalDiagnosis", "hbvTreatmentExperience", "pastHBVRegimen", "newHBVRegimen",
        "dateHBVStarted", "hbvAdverseEvents", "hbvSwitchRegimen", "hbvSwitchDate", "hbvSwitchAdverseEvents",
        "reasonHBVSwitch", "dateHBVStopped", "hcvTreatmentExperience", "pastHCVRegimen", "hcvTreatmentStartDate",
        "hcvTreatmentCompletionDate", "hcvInitialPrescribedDuration", "hcvNewRegimen", "hcvNewRegimenPrescribedDuration",
        "hcvNewRegimenStartDate", "hcvNewRegimenCompletionDate", "hcvAdverseEvent", "svr12TestDate", "svr12HCVRNAResult",
        "hcvGenotype", "hcvRetreatmentRegimen", "hcvRetreatmentDuration", "hcvRetreatmentStartDate",
        "hcvRetreatmentCompletionDate", "retreatmentSVR12Date", "retreatmentSVR12Result", "nextAppointmentDate", "outcome" })
public class ViralHepatitisType {
	
	@XmlElement(name = "VisitID", required = true)
	protected String visitID;
	
	@XmlElement(name = "VisitDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar visitDate;
	
	@XmlElement(name = "CareEntryPoint")
	protected String careEntryPoint;
	
	@XmlElement(name = "Weight")
	protected BigDecimal weight;
	
	@XmlElement(name = "Height")
	protected BigDecimal height;
	
	@XmlElement(name = "BMI")
	protected BigDecimal bmi;
	
	@XmlElement(name = "BloodPressure")
	protected String bloodPressure;
	
	@XmlElement(name = "Pregnant")
	protected String pregnant;
	
	@XmlElement(name = "Breastfeeding")
	protected String breastfeeding;
	
	@XmlElement(name = "InjectionDrugUse")
	protected String injectionDrugUse;
	
	@XmlElement(name = "HBsAgResult")
	protected String hBsAgResult;
	
	@XmlElement(name = "DateFirstPositiveHBV")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateFirstPositiveHBV;
	
	@XmlElement(name = "HBsAgQuantification")
	protected BigDecimal hBsAgQuantification;
	
	@XmlElement(name = "HBeAgResult")
	protected String hBeAgResult;
	
	@XmlElement(name = "AntiHDVResult")
	protected String antiHDVResult;
	
	@XmlElement(name = "DateHBVDNARequested")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateHBVDNARequested;
	
	@XmlElement(name = "DateHBVDNASampleCollected")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateHBVDNASampleCollected;
	
	@XmlElement(name = "DateHBVDNAResultReported")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateHBVDNAResultReported;
	
	@XmlElement(name = "HBVDNAResult")
	protected String hbvdnaResult;
	
	@XmlElement(name = "HCVAbResult")
	protected String hcvAbResult;
	
	@XmlElement(name = "DateFirstPositiveHCV")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateFirstPositiveHCV;
	
	@XmlElement(name = "HCVRNAResult")
	protected String hcvrnaResult;
	
	@XmlElement(name = "HBVTreatmentEligible")
	protected String hbvTreatmentEligible;
	
	@XmlElement(name = "PMTCTEligible")
	protected String pmtctEligible;
	
	@XmlElement(name = "CoInfectionStatus")
	protected String coInfectionStatus;
	
	@XmlElement(name = "OtherComorbidities")
	protected String otherComorbidities;
	
	@XmlElement(name = "ALT")
	protected BigDecimal alt;
	
	@XmlElement(name = "AST")
	protected BigDecimal ast;
	
	@XmlElement(name = "PlateletCount")
	protected BigDecimal plateletCount;
	
	@XmlElement(name = "BilirubinTotal")
	protected BigDecimal bilirubinTotal;
	
	@XmlElement(name = "BilirubinDirect")
	protected BigDecimal bilirubinDirect;
	
	@XmlElement(name = "Albumin")
	protected BigDecimal albumin;
	
	@XmlElement(name = "APRIScore")
	protected BigDecimal apriScore;
	
	@XmlElement(name = "FIB4Score")
	protected BigDecimal fib4Score;
	
	@XmlElement(name = "PTINR")
	protected BigDecimal ptinr;
	
	@XmlElement(name = "Urea")
	protected BigDecimal urea;
	
	@XmlElement(name = "Creatinine")
	protected BigDecimal creatinine;
	
	@XmlElement(name = "AFP")
	protected BigDecimal afp;
	
	@XmlElement(name = "UltrasoundScanResult")
	protected String ultrasoundScanResult;
	
	@XmlElement(name = "Fibroscan")
	protected String fibroscan;
	
	@XmlElement(name = "CTScan")
	protected String ctScan;
	
	@XmlElement(name = "Ascites")
	protected String ascites;
	
	@XmlElement(name = "EncephalopathyGrade")
	protected String encephalopathyGrade;
	
	@XmlElement(name = "ChildPughScore")
	protected String childPughScore;
	
	@XmlElement(name = "LiverBiopsyStage")
	protected String liverBiopsyStage;
	
	@XmlElement(name = "StagingDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar stagingDate;
	
	@XmlElement(name = "ClinicalDiagnosis")
	protected String clinicalDiagnosis;
	
	@XmlElement(name = "HBVTreatmentExperience")
	protected String hbvTreatmentExperience;
	
	@XmlElement(name = "PastHBVRegimen")
	protected String pastHBVRegimen;
	
	@XmlElement(name = "NewHBVRegimen")
	protected String newHBVRegimen;
	
	@XmlElement(name = "DateHBVStarted")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateHBVStarted;
	
	@XmlElement(name = "HBVAdverseEvents")
	protected String hbvAdverseEvents;
	
	@XmlElement(name = "HBVSwitchRegimen")
	protected String hbvSwitchRegimen;
	
	@XmlElement(name = "HBVSwitchDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hbvSwitchDate;
	
	@XmlElement(name = "HBVSwitchAdverseEvents")
	protected String hbvSwitchAdverseEvents;
	
	@XmlElement(name = "ReasonHBVSwitch")
	protected String reasonHBVSwitch;
	
	@XmlElement(name = "DateHBVStopped")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateHBVStopped;
	
	@XmlElement(name = "HCVTreatmentExperience")
	protected String hcvTreatmentExperience;
	
	@XmlElement(name = "PastHCVRegimen")
	protected String pastHCVRegimen;
	
	@XmlElement(name = "HCVTreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvTreatmentStartDate;
	
	@XmlElement(name = "HCVTreatmentCompletionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvTreatmentCompletionDate;
	
	@XmlElement(name = "HCVInitialPrescribedDuration")
	protected String hcvInitialPrescribedDuration;
	
	@XmlElement(name = "HCVNewRegimen")
	protected String hcvNewRegimen;
	
	@XmlElement(name = "HCVNewRegimenPrescribedDuration")
	protected String hcvNewRegimenPrescribedDuration;
	
	@XmlElement(name = "HCVNewRegimenStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvNewRegimenStartDate;
	
	@XmlElement(name = "HCVNewRegimenCompletionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvNewRegimenCompletionDate;
	
	@XmlElement(name = "HCVAdverseEvent")
	protected String hcvAdverseEvent;
	
	@XmlElement(name = "SVR12TestDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar svr12TestDate;
	
	@XmlElement(name = "SVR12HCVRNAResult")
	protected String svr12HCVRNAResult;
	
	@XmlElement(name = "HCVGenotype")
	protected String hcvGenotype;
	
	@XmlElement(name = "HCVRetreatmentRegimen")
	protected String hcvRetreatmentRegimen;
	
	@XmlElement(name = "HCVRetreatmentDuration")
	protected String hcvRetreatmentDuration;
	
	@XmlElement(name = "HCVRetreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvRetreatmentStartDate;
	
	@XmlElement(name = "HCVRetreatmentCompletionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar hcvRetreatmentCompletionDate;
	
	@XmlElement(name = "RetreatmentSVR12Date")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar retreatmentSVR12Date;
	
	@XmlElement(name = "RetreatmentSVR12Result")
	protected String retreatmentSVR12Result;
	
	@XmlElement(name = "NextAppointmentDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar nextAppointmentDate;
	
	@XmlElement(name = "Outcome")
	protected String outcome;
	
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
	 * Gets the value of the careEntryPoint property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCareEntryPoint() {
		return careEntryPoint;
	}
	
	/**
	 * Sets the value of the careEntryPoint property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCareEntryPoint(String value) {
		this.careEntryPoint = value;
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
	 * Gets the value of the pregnant property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPregnant() {
		return pregnant;
	}
	
	/**
	 * Sets the value of the pregnant property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPregnant(String value) {
		this.pregnant = value;
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
	 * Gets the value of the injectionDrugUse property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInjectionDrugUse() {
		return injectionDrugUse;
	}
	
	/**
	 * Sets the value of the injectionDrugUse property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInjectionDrugUse(String value) {
		this.injectionDrugUse = value;
	}
	
	/**
	 * Gets the value of the hBsAgResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBsAgResult() {
		return hBsAgResult;
	}
	
	/**
	 * Sets the value of the hBsAgResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBsAgResult(String value) {
		this.hBsAgResult = value;
	}
	
	/**
	 * Gets the value of the dateFirstPositiveHBV property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateFirstPositiveHBV() {
		return dateFirstPositiveHBV;
	}
	
	/**
	 * Sets the value of the dateFirstPositiveHBV property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateFirstPositiveHBV(XMLGregorianCalendar value) {
		this.dateFirstPositiveHBV = value;
	}
	
	/**
	 * Gets the value of the hBsAgQuantification property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getHBsAgQuantification() {
		return hBsAgQuantification;
	}
	
	/**
	 * Sets the value of the hBsAgQuantification property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setHBsAgQuantification(BigDecimal value) {
		this.hBsAgQuantification = value;
	}
	
	/**
	 * Gets the value of the hBeAgResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBeAgResult() {
		return hBeAgResult;
	}
	
	/**
	 * Sets the value of the hBeAgResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBeAgResult(String value) {
		this.hBeAgResult = value;
	}
	
	/**
	 * Gets the value of the antiHDVResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAntiHDVResult() {
		return antiHDVResult;
	}
	
	/**
	 * Sets the value of the antiHDVResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAntiHDVResult(String value) {
		this.antiHDVResult = value;
	}
	
	/**
	 * Gets the value of the dateHBVDNARequested property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateHBVDNARequested() {
		return dateHBVDNARequested;
	}
	
	/**
	 * Sets the value of the dateHBVDNARequested property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateHBVDNARequested(XMLGregorianCalendar value) {
		this.dateHBVDNARequested = value;
	}
	
	/**
	 * Gets the value of the dateHBVDNASampleCollected property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateHBVDNASampleCollected() {
		return dateHBVDNASampleCollected;
	}
	
	/**
	 * Sets the value of the dateHBVDNASampleCollected property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateHBVDNASampleCollected(XMLGregorianCalendar value) {
		this.dateHBVDNASampleCollected = value;
	}
	
	/**
	 * Gets the value of the dateHBVDNAResultReported property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateHBVDNAResultReported() {
		return dateHBVDNAResultReported;
	}
	
	/**
	 * Sets the value of the dateHBVDNAResultReported property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateHBVDNAResultReported(XMLGregorianCalendar value) {
		this.dateHBVDNAResultReported = value;
	}
	
	/**
	 * Gets the value of the hbvdnaResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVDNAResult() {
		return hbvdnaResult;
	}
	
	/**
	 * Sets the value of the hbvdnaResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVDNAResult(String value) {
		this.hbvdnaResult = value;
	}
	
	/**
	 * Gets the value of the hcvAbResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVAbResult() {
		return hcvAbResult;
	}
	
	/**
	 * Sets the value of the hcvAbResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVAbResult(String value) {
		this.hcvAbResult = value;
	}
	
	/**
	 * Gets the value of the dateFirstPositiveHCV property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateFirstPositiveHCV() {
		return dateFirstPositiveHCV;
	}
	
	/**
	 * Sets the value of the dateFirstPositiveHCV property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateFirstPositiveHCV(XMLGregorianCalendar value) {
		this.dateFirstPositiveHCV = value;
	}
	
	/**
	 * Gets the value of the hcvrnaResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVRNAResult() {
		return hcvrnaResult;
	}
	
	/**
	 * Sets the value of the hcvrnaResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVRNAResult(String value) {
		this.hcvrnaResult = value;
	}
	
	/**
	 * Gets the value of the hbvTreatmentEligible property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVTreatmentEligible() {
		return hbvTreatmentEligible;
	}
	
	/**
	 * Sets the value of the hbvTreatmentEligible property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVTreatmentEligible(String value) {
		this.hbvTreatmentEligible = value;
	}
	
	/**
	 * Gets the value of the pmtctEligible property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPMTCTEligible() {
		return pmtctEligible;
	}
	
	/**
	 * Sets the value of the pmtctEligible property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPMTCTEligible(String value) {
		this.pmtctEligible = value;
	}
	
	/**
	 * Gets the value of the coInfectionStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCoInfectionStatus() {
		return coInfectionStatus;
	}
	
	/**
	 * Sets the value of the coInfectionStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCoInfectionStatus(String value) {
		this.coInfectionStatus = value;
	}
	
	/**
	 * Gets the value of the otherComorbidities property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherComorbidities() {
		return otherComorbidities;
	}
	
	/**
	 * Sets the value of the otherComorbidities property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherComorbidities(String value) {
		this.otherComorbidities = value;
	}
	
	/**
	 * Gets the value of the alt property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getALT() {
		return alt;
	}
	
	/**
	 * Sets the value of the alt property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setALT(BigDecimal value) {
		this.alt = value;
	}
	
	/**
	 * Gets the value of the ast property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getAST() {
		return ast;
	}
	
	/**
	 * Sets the value of the ast property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setAST(BigDecimal value) {
		this.ast = value;
	}
	
	/**
	 * Gets the value of the plateletCount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getPlateletCount() {
		return plateletCount;
	}
	
	/**
	 * Sets the value of the plateletCount property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setPlateletCount(BigDecimal value) {
		this.plateletCount = value;
	}
	
	/**
	 * Gets the value of the bilirubinTotal property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBilirubinTotal() {
		return bilirubinTotal;
	}
	
	/**
	 * Sets the value of the bilirubinTotal property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBilirubinTotal(BigDecimal value) {
		this.bilirubinTotal = value;
	}
	
	/**
	 * Gets the value of the bilirubinDirect property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBilirubinDirect() {
		return bilirubinDirect;
	}
	
	/**
	 * Sets the value of the bilirubinDirect property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBilirubinDirect(BigDecimal value) {
		this.bilirubinDirect = value;
	}
	
	/**
	 * Gets the value of the albumin property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getAlbumin() {
		return albumin;
	}
	
	/**
	 * Sets the value of the albumin property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setAlbumin(BigDecimal value) {
		this.albumin = value;
	}
	
	/**
	 * Gets the value of the apriScore property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getAPRIScore() {
		return apriScore;
	}
	
	/**
	 * Sets the value of the apriScore property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setAPRIScore(BigDecimal value) {
		this.apriScore = value;
	}
	
	/**
	 * Gets the value of the fib4Score property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getFIB4Score() {
		return fib4Score;
	}
	
	/**
	 * Sets the value of the fib4Score property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setFIB4Score(BigDecimal value) {
		this.fib4Score = value;
	}
	
	/**
	 * Gets the value of the ptinr property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getPTINR() {
		return ptinr;
	}
	
	/**
	 * Sets the value of the ptinr property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setPTINR(BigDecimal value) {
		this.ptinr = value;
	}
	
	/**
	 * Gets the value of the urea property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getUrea() {
		return urea;
	}
	
	/**
	 * Sets the value of the urea property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setUrea(BigDecimal value) {
		this.urea = value;
	}
	
	/**
	 * Gets the value of the creatinine property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getCreatinine() {
		return creatinine;
	}
	
	/**
	 * Sets the value of the creatinine property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setCreatinine(BigDecimal value) {
		this.creatinine = value;
	}
	
	/**
	 * Gets the value of the afp property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getAFP() {
		return afp;
	}
	
	/**
	 * Sets the value of the afp property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setAFP(BigDecimal value) {
		this.afp = value;
	}
	
	/**
	 * Gets the value of the ultrasoundScanResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUltrasoundScanResult() {
		return ultrasoundScanResult;
	}
	
	/**
	 * Sets the value of the ultrasoundScanResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUltrasoundScanResult(String value) {
		this.ultrasoundScanResult = value;
	}
	
	/**
	 * Gets the value of the fibroscan property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFibroscan() {
		return fibroscan;
	}
	
	/**
	 * Sets the value of the fibroscan property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFibroscan(String value) {
		this.fibroscan = value;
	}
	
	/**
	 * Gets the value of the ctScan property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCTScan() {
		return ctScan;
	}
	
	/**
	 * Sets the value of the ctScan property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCTScan(String value) {
		this.ctScan = value;
	}
	
	/**
	 * Gets the value of the ascites property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getAscites() {
		return ascites;
	}
	
	/**
	 * Sets the value of the ascites property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setAscites(String value) {
		this.ascites = value;
	}
	
	/**
	 * Gets the value of the encephalopathyGrade property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEncephalopathyGrade() {
		return encephalopathyGrade;
	}
	
	/**
	 * Sets the value of the encephalopathyGrade property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEncephalopathyGrade(String value) {
		this.encephalopathyGrade = value;
	}
	
	/**
	 * Gets the value of the childPughScore property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getChildPughScore() {
		return childPughScore;
	}
	
	/**
	 * Sets the value of the childPughScore property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setChildPughScore(String value) {
		this.childPughScore = value;
	}
	
	/**
	 * Gets the value of the liverBiopsyStage property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLiverBiopsyStage() {
		return liverBiopsyStage;
	}
	
	/**
	 * Sets the value of the liverBiopsyStage property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLiverBiopsyStage(String value) {
		this.liverBiopsyStage = value;
	}
	
	/**
	 * Gets the value of the stagingDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getStagingDate() {
		return stagingDate;
	}
	
	/**
	 * Sets the value of the stagingDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setStagingDate(XMLGregorianCalendar value) {
		this.stagingDate = value;
	}
	
	/**
	 * Gets the value of the clinicalDiagnosis property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getClinicalDiagnosis() {
		return clinicalDiagnosis;
	}
	
	/**
	 * Sets the value of the clinicalDiagnosis property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setClinicalDiagnosis(String value) {
		this.clinicalDiagnosis = value;
	}
	
	/**
	 * Gets the value of the hbvTreatmentExperience property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVTreatmentExperience() {
		return hbvTreatmentExperience;
	}
	
	/**
	 * Sets the value of the hbvTreatmentExperience property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVTreatmentExperience(String value) {
		this.hbvTreatmentExperience = value;
	}
	
	/**
	 * Gets the value of the pastHBVRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPastHBVRegimen() {
		return pastHBVRegimen;
	}
	
	/**
	 * Sets the value of the pastHBVRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPastHBVRegimen(String value) {
		this.pastHBVRegimen = value;
	}
	
	/**
	 * Gets the value of the newHBVRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getNewHBVRegimen() {
		return newHBVRegimen;
	}
	
	/**
	 * Sets the value of the newHBVRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setNewHBVRegimen(String value) {
		this.newHBVRegimen = value;
	}
	
	/**
	 * Gets the value of the dateHBVStarted property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateHBVStarted() {
		return dateHBVStarted;
	}
	
	/**
	 * Sets the value of the dateHBVStarted property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateHBVStarted(XMLGregorianCalendar value) {
		this.dateHBVStarted = value;
	}
	
	/**
	 * Gets the value of the hbvAdverseEvents property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVAdverseEvents() {
		return hbvAdverseEvents;
	}
	
	/**
	 * Sets the value of the hbvAdverseEvents property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVAdverseEvents(String value) {
		this.hbvAdverseEvents = value;
	}
	
	/**
	 * Gets the value of the hbvSwitchRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVSwitchRegimen() {
		return hbvSwitchRegimen;
	}
	
	/**
	 * Sets the value of the hbvSwitchRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVSwitchRegimen(String value) {
		this.hbvSwitchRegimen = value;
	}
	
	/**
	 * Gets the value of the hbvSwitchDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHBVSwitchDate() {
		return hbvSwitchDate;
	}
	
	/**
	 * Sets the value of the hbvSwitchDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHBVSwitchDate(XMLGregorianCalendar value) {
		this.hbvSwitchDate = value;
	}
	
	/**
	 * Gets the value of the hbvSwitchAdverseEvents property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHBVSwitchAdverseEvents() {
		return hbvSwitchAdverseEvents;
	}
	
	/**
	 * Sets the value of the hbvSwitchAdverseEvents property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHBVSwitchAdverseEvents(String value) {
		this.hbvSwitchAdverseEvents = value;
	}
	
	/**
	 * Gets the value of the reasonHBVSwitch property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonHBVSwitch() {
		return reasonHBVSwitch;
	}
	
	/**
	 * Sets the value of the reasonHBVSwitch property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonHBVSwitch(String value) {
		this.reasonHBVSwitch = value;
	}
	
	/**
	 * Gets the value of the dateHBVStopped property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateHBVStopped() {
		return dateHBVStopped;
	}
	
	/**
	 * Sets the value of the dateHBVStopped property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateHBVStopped(XMLGregorianCalendar value) {
		this.dateHBVStopped = value;
	}
	
	/**
	 * Gets the value of the hcvTreatmentExperience property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVTreatmentExperience() {
		return hcvTreatmentExperience;
	}
	
	/**
	 * Sets the value of the hcvTreatmentExperience property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVTreatmentExperience(String value) {
		this.hcvTreatmentExperience = value;
	}
	
	/**
	 * Gets the value of the pastHCVRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPastHCVRegimen() {
		return pastHCVRegimen;
	}
	
	/**
	 * Sets the value of the pastHCVRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPastHCVRegimen(String value) {
		this.pastHCVRegimen = value;
	}
	
	/**
	 * Gets the value of the hcvTreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVTreatmentStartDate() {
		return hcvTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the hcvTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVTreatmentStartDate(XMLGregorianCalendar value) {
		this.hcvTreatmentStartDate = value;
	}
	
	/**
	 * Gets the value of the hcvTreatmentCompletionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVTreatmentCompletionDate() {
		return hcvTreatmentCompletionDate;
	}
	
	/**
	 * Sets the value of the hcvTreatmentCompletionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVTreatmentCompletionDate(XMLGregorianCalendar value) {
		this.hcvTreatmentCompletionDate = value;
	}
	
	/**
	 * Gets the value of the hcvInitialPrescribedDuration property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVInitialPrescribedDuration() {
		return hcvInitialPrescribedDuration;
	}
	
	/**
	 * Sets the value of the hcvInitialPrescribedDuration property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVInitialPrescribedDuration(String value) {
		this.hcvInitialPrescribedDuration = value;
	}
	
	/**
	 * Gets the value of the hcvNewRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVNewRegimen() {
		return hcvNewRegimen;
	}
	
	/**
	 * Sets the value of the hcvNewRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVNewRegimen(String value) {
		this.hcvNewRegimen = value;
	}
	
	/**
	 * Gets the value of the hcvNewRegimenPrescribedDuration property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVNewRegimenPrescribedDuration() {
		return hcvNewRegimenPrescribedDuration;
	}
	
	/**
	 * Sets the value of the hcvNewRegimenPrescribedDuration property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVNewRegimenPrescribedDuration(String value) {
		this.hcvNewRegimenPrescribedDuration = value;
	}
	
	/**
	 * Gets the value of the hcvNewRegimenStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVNewRegimenStartDate() {
		return hcvNewRegimenStartDate;
	}
	
	/**
	 * Sets the value of the hcvNewRegimenStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVNewRegimenStartDate(XMLGregorianCalendar value) {
		this.hcvNewRegimenStartDate = value;
	}
	
	/**
	 * Gets the value of the hcvNewRegimenCompletionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVNewRegimenCompletionDate() {
		return hcvNewRegimenCompletionDate;
	}
	
	/**
	 * Sets the value of the hcvNewRegimenCompletionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVNewRegimenCompletionDate(XMLGregorianCalendar value) {
		this.hcvNewRegimenCompletionDate = value;
	}
	
	/**
	 * Gets the value of the hcvAdverseEvent property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVAdverseEvent() {
		return hcvAdverseEvent;
	}
	
	/**
	 * Sets the value of the hcvAdverseEvent property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVAdverseEvent(String value) {
		this.hcvAdverseEvent = value;
	}
	
	/**
	 * Gets the value of the svr12TestDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getSVR12TestDate() {
		return svr12TestDate;
	}
	
	/**
	 * Sets the value of the svr12TestDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setSVR12TestDate(XMLGregorianCalendar value) {
		this.svr12TestDate = value;
	}
	
	/**
	 * Gets the value of the svr12HCVRNAResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSVR12HCVRNAResult() {
		return svr12HCVRNAResult;
	}
	
	/**
	 * Sets the value of the svr12HCVRNAResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSVR12HCVRNAResult(String value) {
		this.svr12HCVRNAResult = value;
	}
	
	/**
	 * Gets the value of the hcvGenotype property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVGenotype() {
		return hcvGenotype;
	}
	
	/**
	 * Sets the value of the hcvGenotype property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVGenotype(String value) {
		this.hcvGenotype = value;
	}
	
	/**
	 * Gets the value of the hcvRetreatmentRegimen property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVRetreatmentRegimen() {
		return hcvRetreatmentRegimen;
	}
	
	/**
	 * Sets the value of the hcvRetreatmentRegimen property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVRetreatmentRegimen(String value) {
		this.hcvRetreatmentRegimen = value;
	}
	
	/**
	 * Gets the value of the hcvRetreatmentDuration property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHCVRetreatmentDuration() {
		return hcvRetreatmentDuration;
	}
	
	/**
	 * Sets the value of the hcvRetreatmentDuration property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHCVRetreatmentDuration(String value) {
		this.hcvRetreatmentDuration = value;
	}
	
	/**
	 * Gets the value of the hcvRetreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVRetreatmentStartDate() {
		return hcvRetreatmentStartDate;
	}
	
	/**
	 * Sets the value of the hcvRetreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVRetreatmentStartDate(XMLGregorianCalendar value) {
		this.hcvRetreatmentStartDate = value;
	}
	
	/**
	 * Gets the value of the hcvRetreatmentCompletionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getHCVRetreatmentCompletionDate() {
		return hcvRetreatmentCompletionDate;
	}
	
	/**
	 * Sets the value of the hcvRetreatmentCompletionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setHCVRetreatmentCompletionDate(XMLGregorianCalendar value) {
		this.hcvRetreatmentCompletionDate = value;
	}
	
	/**
	 * Gets the value of the retreatmentSVR12Date property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRetreatmentSVR12Date() {
		return retreatmentSVR12Date;
	}
	
	/**
	 * Sets the value of the retreatmentSVR12Date property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRetreatmentSVR12Date(XMLGregorianCalendar value) {
		this.retreatmentSVR12Date = value;
	}
	
	/**
	 * Gets the value of the retreatmentSVR12Result property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getRetreatmentSVR12Result() {
		return retreatmentSVR12Result;
	}
	
	/**
	 * Sets the value of the retreatmentSVR12Result property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setRetreatmentSVR12Result(String value) {
		this.retreatmentSVR12Result = value;
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
	
	/**
	 * Gets the value of the outcome property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOutcome() {
		return outcome;
	}
	
	/**
	 * Sets the value of the outcome property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOutcome(String value) {
		this.outcome = value;
	}
	
}
