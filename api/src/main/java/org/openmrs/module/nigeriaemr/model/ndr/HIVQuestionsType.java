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
 * Java class for HIVQuestionsType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVQuestionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BiometricCaptured" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="CareEntryPoint" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="OPD"/>
 *               &lt;enumeration value="Inpatients"/>
 *               &lt;enumeration value="HTS"/>
 *               &lt;enumeration value="TBDOTS"/>
 *               &lt;enumeration value="ANC_PMTCT"/>
 *               &lt;enumeration value="TransferIn"/>
 *               &lt;enumeration value="Community"/>
 *               &lt;enumeration value="STI"/>
 *               &lt;enumeration value="HCT"/>
 *               &lt;enumeration value="CBO"/>
 *               &lt;enumeration value="Private"/>
 *               &lt;enumeration value="TB"/>
 *               &lt;enumeration value="Ward"/>
 *               &lt;enumeration value="Casualty"/>
 *               &lt;enumeration value="IDU"/>
 *               &lt;enumeration value="SexWorkersOutreach"/>
 *               &lt;enumeration value="CurrentClinicPatient"/>
 *               &lt;enumeration value="SelfReferral"/>
 *               &lt;enumeration value="PreARTTransferIn"/>
 *               &lt;enumeration value="Others"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstConfirmedHIVTestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FirstHIVTestMode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="HIVAb"/>
 *               &lt;enumeration value="HIVPCR"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WhereFirstHIVTest" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="PriorArt" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="EarlierARV"/>
 *               &lt;enumeration value="TransferIn"/>
 *               &lt;enumeration value="PREP"/>
 *               &lt;enumeration value="PEP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="KPTypology" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FSW"/>
 *               &lt;enumeration value="MSM"/>
 *               &lt;enumeration value="PWID"/>
 *               &lt;enumeration value="TG"/>
 *               &lt;enumeration value="Prisoners"/>
 *               &lt;enumeration value="OtherKP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MedicallyEligibleDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonMedicallyEligible" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InitialAdherenceCounselingCompletedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PatientTransferredIn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TransferredInDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TransferredInFrom" type="{}FacilityType" minOccurs="0"/>
 *         &lt;element name="TransferredInFromPatId" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstARTRegimen" type="{}RegimenCodedSimpleType" minOccurs="0"/>
 *         &lt;element name="ARTStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="WHOClinicalStageARTStart" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value="I"/>
 *               &lt;enumeration value="II"/>
 *               &lt;enumeration value="III"/>
 *               &lt;enumeration value="IV"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WeightAtARTStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HeightAtARTStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BMIMUACAtARTStart" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PregnancyBFStatusAtStart" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Pregnant"/>
 *               &lt;enumeration value="Breastfeeding"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ChildHeightAtARTStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FunctionalStatusStartART" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="W"/>
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="B"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CD4AtStartOfART" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="CD4LFA" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="LessThan200"/>
 *               &lt;enumeration value="GTEqual200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PatientTransferredOut" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TransferredOutStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransferredOutDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FacilityReferredTo" type="{}FacilityType" minOccurs="0"/>
 *         &lt;element name="PatientHasDied" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StatusAtDeath" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeathDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SourceOfDeathInformation" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="CauseOfDeathHIVRelated" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Y"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="U"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CauseOfDeath" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="HIVRelated"/>
 *               &lt;enumeration value="TB"/>
 *               &lt;enumeration value="RoadAccident"/>
 *               &lt;enumeration value="Malaria"/>
 *               &lt;enumeration value="COPD"/>
 *               &lt;enumeration value="Hypertension"/>
 *               &lt;enumeration value="Diabetes"/>
 *               &lt;enumeration value="Others"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DrugAllergies" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="EnrolledInHIVCareDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="InitialTBStatus" minOccurs="0">
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
 *         &lt;element name="TPTMedication" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="SixH"/>
 *               &lt;enumeration value="ThreeHP"/>
 *               &lt;enumeration value="ThreeHR"/>
 *               &lt;enumeration value="OneHP"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TPTDose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TBTreatmentStartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TPTCompletionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="StoppedTreatment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DateStoppedTreatment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForStoppedTreatment" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SubstitutionWithin" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Firstline"/>
 *               &lt;enumeration value="Secondline"/>
 *               &lt;enumeration value="Thirdline"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RegimenSubstitutionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForSubstitution" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Toxicity_SideEffect"/>
 *               &lt;enumeration value="DuetoNewTB"/>
 *               &lt;enumeration value="NewDrugAvailable"/>
 *               &lt;enumeration value="Stockout"/>
 *               &lt;enumeration value="ClinicalTreatmentFailure"/>
 *               &lt;enumeration value="Pregnancy"/>
 *               &lt;enumeration value="RiskofPregnancy"/>
 *               &lt;enumeration value="ImmunologicFailure"/>
 *               &lt;enumeration value="VirologicFailure"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherReasonForSubstitution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewRegimenAfterSubstitution" type="{}RegimenCodedSimpleType" minOccurs="0"/>
 *         &lt;element name="SwitchTo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Firstline"/>
 *               &lt;enumeration value="Secondline"/>
 *               &lt;enumeration value="Thirdline"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RegimenSwitchDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ReasonForSwitch" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Toxicity_SideEffect"/>
 *               &lt;enumeration value="DuetoNewTB"/>
 *               &lt;enumeration value="NewDrugAvailable"/>
 *               &lt;enumeration value="Stockout"/>
 *               &lt;enumeration value="ClinicalTreatmentFailure"/>
 *               &lt;enumeration value="Pregnancy"/>
 *               &lt;enumeration value="RiskofPregnancy"/>
 *               &lt;enumeration value="ImmunologicFailure"/>
 *               &lt;enumeration value="VirologicFailure"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OtherReasonForSwitch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewRegimenAfterSwitch" type="{}RegimenCodedSimpleType" minOccurs="0"/>
 *         &lt;element name="DRGenotypingDone" type="{}YNCodeType" minOccurs="0"/>
 *         &lt;element name="GenotypingSampleDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="GenotypingReceivedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DRResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="WildType"/>
 *               &lt;enumeration value="ResistantDetected"/>
 *               &lt;enumeration value="NoResistantDetected"/>
 *               &lt;enumeration value="PartialResistant"/>
 *               &lt;enumeration value="Indeterminate"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IfDRResistant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVQuestionsType", propOrder = { "biometricCaptured", "careEntryPoint", "firstConfirmedHIVTestDate",
        "firstHIVTestMode", "whereFirstHIVTest", "priorArt", "kpTypology", "medicallyEligibleDate",
        "reasonMedicallyEligible", "initialAdherenceCounselingCompletedDate", "patientTransferredIn", "transferredInDate",
        "transferredInFrom", "transferredInFromPatId", "firstARTRegimen", "artStartDate", "whoClinicalStageARTStart",
        "weightAtARTStart", "heightAtARTStart", "bmimuacAtARTStart", "pregnancyBFStatusAtStart", "childHeightAtARTStart",
        "functionalStatusStartART", "cd4AtStartOfART", "cd4LFA", "patientTransferredOut", "transferredOutStatus",
        "transferredOutDate", "facilityReferredTo", "patientHasDied", "statusAtDeath", "deathDate",
        "sourceOfDeathInformation", "causeOfDeathHIVRelated", "causeOfDeath", "drugAllergies", "enrolledInHIVCareDate",
        "initialTBStatus", "tptMedication", "tptDose", "tbTreatmentStartDate", "tptCompletionDate", "stoppedTreatment",
        "dateStoppedTreatment", "reasonForStoppedTreatment", "substitutionWithin", "regimenSubstitutionDate",
        "reasonForSubstitution", "otherReasonForSubstitution", "newRegimenAfterSubstitution", "switchTo",
        "regimenSwitchDate", "reasonForSwitch", "otherReasonForSwitch", "newRegimenAfterSwitch", "drGenotypingDone",
        "genotypingSampleDate", "genotypingReceivedDate", "drResult", "ifDRResistant" })
public class HIVQuestionsType {
	
	@XmlElement(name = "BiometricCaptured")
	@XmlSchemaType(name = "string")
	protected YNCodeType biometricCaptured;
	
	@XmlElement(name = "CareEntryPoint")
	protected String careEntryPoint;
	
	@XmlElement(name = "FirstConfirmedHIVTestDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar firstConfirmedHIVTestDate;
	
	@XmlElement(name = "FirstHIVTestMode")
	protected String firstHIVTestMode;
	
	@XmlElement(name = "WhereFirstHIVTest")
	protected String whereFirstHIVTest;
	
	@XmlElement(name = "PriorArt")
	protected String priorArt;
	
	@XmlElement(name = "KPTypology")
	protected String kpTypology;
	
	@XmlElement(name = "MedicallyEligibleDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar medicallyEligibleDate;
	
	@XmlElement(name = "ReasonMedicallyEligible")
	protected String reasonMedicallyEligible;
	
	@XmlElement(name = "InitialAdherenceCounselingCompletedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar initialAdherenceCounselingCompletedDate;
	
	@XmlElement(name = "PatientTransferredIn")
	protected Boolean patientTransferredIn;
	
	@XmlElement(name = "TransferredInDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar transferredInDate;
	
	@XmlElement(name = "TransferredInFrom")
	protected FacilityType transferredInFrom;
	
	@XmlElement(name = "TransferredInFromPatId")
	protected String transferredInFromPatId;
	
	@XmlElement(name = "FirstARTRegimen")
	protected RegimenCodedSimpleType firstARTRegimen;
	
	@XmlElement(name = "ARTStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar artStartDate;
	
	@XmlElement(name = "WHOClinicalStageARTStart")
	protected String whoClinicalStageARTStart;
	
	@XmlElement(name = "WeightAtARTStart")
	protected Integer weightAtARTStart;
	
	@XmlElement(name = "HeightAtARTStart")
	protected Integer heightAtARTStart;
	
	@XmlElement(name = "BMIMUACAtARTStart")
	protected BigDecimal bmimuacAtARTStart;
	
	@XmlElement(name = "PregnancyBFStatusAtStart")
	protected String pregnancyBFStatusAtStart;
	
	@XmlElement(name = "ChildHeightAtARTStart")
	protected Integer childHeightAtARTStart;
	
	@XmlElement(name = "FunctionalStatusStartART")
	protected String functionalStatusStartART;
	
	@XmlElement(name = "CD4AtStartOfART")
	protected String cd4AtStartOfART;
	
	@XmlElement(name = "CD4LFA")
	protected String cd4LFA;
	
	@XmlElement(name = "PatientTransferredOut")
	protected Boolean patientTransferredOut;
	
	@XmlElement(name = "TransferredOutStatus")
	protected String transferredOutStatus;
	
	@XmlElement(name = "TransferredOutDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar transferredOutDate;
	
	@XmlElement(name = "FacilityReferredTo")
	protected FacilityType facilityReferredTo;
	
	@XmlElement(name = "PatientHasDied")
	protected Boolean patientHasDied;
	
	@XmlElement(name = "StatusAtDeath")
	protected String statusAtDeath;
	
	@XmlElement(name = "DeathDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar deathDate;
	
	@XmlElement(name = "SourceOfDeathInformation")
	protected String sourceOfDeathInformation;
	
	@XmlElement(name = "CauseOfDeathHIVRelated")
	protected String causeOfDeathHIVRelated;
	
	@XmlElement(name = "CauseOfDeath")
	protected String causeOfDeath;
	
	@XmlElement(name = "DrugAllergies")
	protected String drugAllergies;
	
	@XmlElement(name = "EnrolledInHIVCareDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar enrolledInHIVCareDate;
	
	@XmlElement(name = "InitialTBStatus")
	protected String initialTBStatus;
	
	@XmlElement(name = "TPTMedication")
	protected String tptMedication;
	
	@XmlElement(name = "TPTDose")
	protected String tptDose;
	
	@XmlElement(name = "TBTreatmentStartDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar tbTreatmentStartDate;
	
	@XmlElement(name = "TPTCompletionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar tptCompletionDate;
	
	@XmlElement(name = "StoppedTreatment")
	protected Boolean stoppedTreatment;
	
	@XmlElement(name = "DateStoppedTreatment")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateStoppedTreatment;
	
	@XmlElement(name = "ReasonForStoppedTreatment")
	protected String reasonForStoppedTreatment;
	
	@XmlElement(name = "SubstitutionWithin")
	protected String substitutionWithin;
	
	@XmlElement(name = "RegimenSubstitutionDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar regimenSubstitutionDate;
	
	@XmlElement(name = "ReasonForSubstitution")
	protected String reasonForSubstitution;
	
	@XmlElement(name = "OtherReasonForSubstitution")
	protected String otherReasonForSubstitution;
	
	@XmlElement(name = "NewRegimenAfterSubstitution")
	protected RegimenCodedSimpleType newRegimenAfterSubstitution;
	
	@XmlElement(name = "SwitchTo")
	protected String switchTo;
	
	@XmlElement(name = "RegimenSwitchDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar regimenSwitchDate;
	
	@XmlElement(name = "ReasonForSwitch")
	protected String reasonForSwitch;
	
	@XmlElement(name = "OtherReasonForSwitch")
	protected String otherReasonForSwitch;
	
	@XmlElement(name = "NewRegimenAfterSwitch")
	protected RegimenCodedSimpleType newRegimenAfterSwitch;
	
	@XmlElement(name = "DRGenotypingDone")
	@XmlSchemaType(name = "string")
	protected YNCodeType drGenotypingDone;
	
	@XmlElement(name = "GenotypingSampleDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar genotypingSampleDate;
	
	@XmlElement(name = "GenotypingReceivedDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar genotypingReceivedDate;
	
	@XmlElement(name = "DRResult")
	protected String drResult;
	
	@XmlElement(name = "IfDRResistant")
	protected String ifDRResistant;
	
	/**
	 * Gets the value of the biometricCaptured property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getBiometricCaptured() {
		return biometricCaptured;
	}
	
	/**
	 * Sets the value of the biometricCaptured property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setBiometricCaptured(YNCodeType value) {
		this.biometricCaptured = value;
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
	 * Gets the value of the firstConfirmedHIVTestDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getFirstConfirmedHIVTestDate() {
		return firstConfirmedHIVTestDate;
	}
	
	/**
	 * Sets the value of the firstConfirmedHIVTestDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setFirstConfirmedHIVTestDate(XMLGregorianCalendar value) {
		this.firstConfirmedHIVTestDate = value;
	}
	
	/**
	 * Gets the value of the firstHIVTestMode property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFirstHIVTestMode() {
		return firstHIVTestMode;
	}
	
	/**
	 * Sets the value of the firstHIVTestMode property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFirstHIVTestMode(String value) {
		this.firstHIVTestMode = value;
	}
	
	/**
	 * Gets the value of the whereFirstHIVTest property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWhereFirstHIVTest() {
		return whereFirstHIVTest;
	}
	
	/**
	 * Sets the value of the whereFirstHIVTest property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWhereFirstHIVTest(String value) {
		this.whereFirstHIVTest = value;
	}
	
	/**
	 * Gets the value of the priorArt property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPriorArt() {
		return priorArt;
	}
	
	/**
	 * Sets the value of the priorArt property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPriorArt(String value) {
		this.priorArt = value;
	}
	
	/**
	 * Gets the value of the kpTypology property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getKPTypology() {
		return kpTypology;
	}
	
	/**
	 * Sets the value of the kpTypology property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setKPTypology(String value) {
		this.kpTypology = value;
	}
	
	/**
	 * Gets the value of the medicallyEligibleDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getMedicallyEligibleDate() {
		return medicallyEligibleDate;
	}
	
	/**
	 * Sets the value of the medicallyEligibleDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setMedicallyEligibleDate(XMLGregorianCalendar value) {
		this.medicallyEligibleDate = value;
	}
	
	/**
	 * Gets the value of the reasonMedicallyEligible property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonMedicallyEligible() {
		return reasonMedicallyEligible;
	}
	
	/**
	 * Sets the value of the reasonMedicallyEligible property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonMedicallyEligible(String value) {
		this.reasonMedicallyEligible = value;
	}
	
	/**
	 * Gets the value of the initialAdherenceCounselingCompletedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getInitialAdherenceCounselingCompletedDate() {
		return initialAdherenceCounselingCompletedDate;
	}
	
	/**
	 * Sets the value of the initialAdherenceCounselingCompletedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setInitialAdherenceCounselingCompletedDate(XMLGregorianCalendar value) {
		this.initialAdherenceCounselingCompletedDate = value;
	}
	
	/**
	 * Gets the value of the patientTransferredIn property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientTransferredIn() {
		return patientTransferredIn;
	}
	
	/**
	 * Sets the value of the patientTransferredIn property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientTransferredIn(Boolean value) {
		this.patientTransferredIn = value;
	}
	
	/**
	 * Gets the value of the transferredInDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTransferredInDate() {
		return transferredInDate;
	}
	
	/**
	 * Sets the value of the transferredInDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTransferredInDate(XMLGregorianCalendar value) {
		this.transferredInDate = value;
	}
	
	/**
	 * Gets the value of the transferredInFrom property.
	 * 
	 * @return possible object is {@link FacilityType }
	 */
	public FacilityType getTransferredInFrom() {
		return transferredInFrom;
	}
	
	/**
	 * Sets the value of the transferredInFrom property.
	 * 
	 * @param value allowed object is {@link FacilityType }
	 */
	public void setTransferredInFrom(FacilityType value) {
		this.transferredInFrom = value;
	}
	
	/**
	 * Gets the value of the transferredInFromPatId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredInFromPatId() {
		return transferredInFromPatId;
	}
	
	/**
	 * Sets the value of the transferredInFromPatId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredInFromPatId(String value) {
		this.transferredInFromPatId = value;
	}
	
	/**
	 * Gets the value of the firstARTRegimen property.
	 * 
	 * @return possible object is {@link RegimenCodedSimpleType }
	 */
	public RegimenCodedSimpleType getFirstARTRegimen() {
		return firstARTRegimen;
	}
	
	/**
	 * Sets the value of the firstARTRegimen property.
	 * 
	 * @param value allowed object is {@link RegimenCodedSimpleType }
	 */
	public void setFirstARTRegimen(RegimenCodedSimpleType value) {
		this.firstARTRegimen = value;
	}
	
	/**
	 * Gets the value of the artStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getARTStartDate() {
		return artStartDate;
	}
	
	/**
	 * Sets the value of the artStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setARTStartDate(XMLGregorianCalendar value) {
		this.artStartDate = value;
	}
	
	/**
	 * Gets the value of the whoClinicalStageARTStart property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getWHOClinicalStageARTStart() {
		return whoClinicalStageARTStart;
	}
	
	/**
	 * Sets the value of the whoClinicalStageARTStart property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setWHOClinicalStageARTStart(String value) {
		this.whoClinicalStageARTStart = value;
	}
	
	/**
	 * Gets the value of the weightAtARTStart property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getWeightAtARTStart() {
		return weightAtARTStart;
	}
	
	/**
	 * Sets the value of the weightAtARTStart property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setWeightAtARTStart(Integer value) {
		this.weightAtARTStart = value;
	}
	
	/**
	 * Gets the value of the heightAtARTStart property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getHeightAtARTStart() {
		return heightAtARTStart;
	}
	
	/**
	 * Sets the value of the heightAtARTStart property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setHeightAtARTStart(Integer value) {
		this.heightAtARTStart = value;
	}
	
	/**
	 * Gets the value of the bmimuacAtARTStart property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 */
	public BigDecimal getBMIMUACAtARTStart() {
		return bmimuacAtARTStart;
	}
	
	/**
	 * Sets the value of the bmimuacAtARTStart property.
	 * 
	 * @param value allowed object is {@link BigDecimal }
	 */
	public void setBMIMUACAtARTStart(BigDecimal value) {
		this.bmimuacAtARTStart = value;
	}
	
	/**
	 * Gets the value of the pregnancyBFStatusAtStart property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPregnancyBFStatusAtStart() {
		return pregnancyBFStatusAtStart;
	}
	
	/**
	 * Sets the value of the pregnancyBFStatusAtStart property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPregnancyBFStatusAtStart(String value) {
		this.pregnancyBFStatusAtStart = value;
	}
	
	/**
	 * Gets the value of the childHeightAtARTStart property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getChildHeightAtARTStart() {
		return childHeightAtARTStart;
	}
	
	/**
	 * Sets the value of the childHeightAtARTStart property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setChildHeightAtARTStart(Integer value) {
		this.childHeightAtARTStart = value;
	}
	
	/**
	 * Gets the value of the functionalStatusStartART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getFunctionalStatusStartART() {
		return functionalStatusStartART;
	}
	
	/**
	 * Sets the value of the functionalStatusStartART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setFunctionalStatusStartART(String value) {
		this.functionalStatusStartART = value;
	}
	
	/**
	 * Gets the value of the cd4AtStartOfART property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4AtStartOfART() {
		return cd4AtStartOfART;
	}
	
	/**
	 * Sets the value of the cd4AtStartOfART property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4AtStartOfART(String value) {
		this.cd4AtStartOfART = value;
	}
	
	/**
	 * Gets the value of the cd4LFA property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCD4LFA() {
		return cd4LFA;
	}
	
	/**
	 * Sets the value of the cd4LFA property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCD4LFA(String value) {
		this.cd4LFA = value;
	}
	
	/**
	 * Gets the value of the patientTransferredOut property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientTransferredOut() {
		return patientTransferredOut;
	}
	
	/**
	 * Sets the value of the patientTransferredOut property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientTransferredOut(Boolean value) {
		this.patientTransferredOut = value;
	}
	
	/**
	 * Gets the value of the transferredOutStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTransferredOutStatus() {
		return transferredOutStatus;
	}
	
	/**
	 * Sets the value of the transferredOutStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTransferredOutStatus(String value) {
		this.transferredOutStatus = value;
	}
	
	/**
	 * Gets the value of the transferredOutDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTransferredOutDate() {
		return transferredOutDate;
	}
	
	/**
	 * Sets the value of the transferredOutDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTransferredOutDate(XMLGregorianCalendar value) {
		this.transferredOutDate = value;
	}
	
	/**
	 * Gets the value of the facilityReferredTo property.
	 * 
	 * @return possible object is {@link FacilityType }
	 */
	public FacilityType getFacilityReferredTo() {
		return facilityReferredTo;
	}
	
	/**
	 * Sets the value of the facilityReferredTo property.
	 * 
	 * @param value allowed object is {@link FacilityType }
	 */
	public void setFacilityReferredTo(FacilityType value) {
		this.facilityReferredTo = value;
	}
	
	/**
	 * Gets the value of the patientHasDied property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPatientHasDied() {
		return patientHasDied;
	}
	
	/**
	 * Sets the value of the patientHasDied property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPatientHasDied(Boolean value) {
		this.patientHasDied = value;
	}
	
	/**
	 * Gets the value of the statusAtDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getStatusAtDeath() {
		return statusAtDeath;
	}
	
	/**
	 * Sets the value of the statusAtDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setStatusAtDeath(String value) {
		this.statusAtDeath = value;
	}
	
	/**
	 * Gets the value of the deathDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDeathDate() {
		return deathDate;
	}
	
	/**
	 * Sets the value of the deathDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDeathDate(XMLGregorianCalendar value) {
		this.deathDate = value;
	}
	
	/**
	 * Gets the value of the sourceOfDeathInformation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSourceOfDeathInformation() {
		return sourceOfDeathInformation;
	}
	
	/**
	 * Sets the value of the sourceOfDeathInformation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSourceOfDeathInformation(String value) {
		this.sourceOfDeathInformation = value;
	}
	
	/**
	 * Gets the value of the causeOfDeathHIVRelated property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeathHIVRelated() {
		return causeOfDeathHIVRelated;
	}
	
	/**
	 * Sets the value of the causeOfDeathHIVRelated property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeathHIVRelated(String value) {
		this.causeOfDeathHIVRelated = value;
	}
	
	/**
	 * Gets the value of the causeOfDeath property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	
	/**
	 * Sets the value of the causeOfDeath property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setCauseOfDeath(String value) {
		this.causeOfDeath = value;
	}
	
	/**
	 * Gets the value of the drugAllergies property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDrugAllergies() {
		return drugAllergies;
	}
	
	/**
	 * Sets the value of the drugAllergies property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDrugAllergies(String value) {
		this.drugAllergies = value;
	}
	
	/**
	 * Gets the value of the enrolledInHIVCareDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getEnrolledInHIVCareDate() {
		return enrolledInHIVCareDate;
	}
	
	/**
	 * Sets the value of the enrolledInHIVCareDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setEnrolledInHIVCareDate(XMLGregorianCalendar value) {
		this.enrolledInHIVCareDate = value;
	}
	
	/**
	 * Gets the value of the initialTBStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getInitialTBStatus() {
		return initialTBStatus;
	}
	
	/**
	 * Sets the value of the initialTBStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setInitialTBStatus(String value) {
		this.initialTBStatus = value;
	}
	
	/**
	 * Gets the value of the tptMedication property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTPTMedication() {
		return tptMedication;
	}
	
	/**
	 * Sets the value of the tptMedication property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTPTMedication(String value) {
		this.tptMedication = value;
	}
	
	/**
	 * Gets the value of the tptDose property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTPTDose() {
		return tptDose;
	}
	
	/**
	 * Sets the value of the tptDose property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTPTDose(String value) {
		this.tptDose = value;
	}
	
	/**
	 * Gets the value of the tbTreatmentStartDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTBTreatmentStartDate() {
		return tbTreatmentStartDate;
	}
	
	/**
	 * Sets the value of the tbTreatmentStartDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTBTreatmentStartDate(XMLGregorianCalendar value) {
		this.tbTreatmentStartDate = value;
	}
	
	/**
	 * Gets the value of the tptCompletionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getTPTCompletionDate() {
		return tptCompletionDate;
	}
	
	/**
	 * Sets the value of the tptCompletionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setTPTCompletionDate(XMLGregorianCalendar value) {
		this.tptCompletionDate = value;
	}
	
	/**
	 * Gets the value of the stoppedTreatment property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isStoppedTreatment() {
		return stoppedTreatment;
	}
	
	/**
	 * Sets the value of the stoppedTreatment property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setStoppedTreatment(Boolean value) {
		this.stoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the dateStoppedTreatment property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateStoppedTreatment() {
		return dateStoppedTreatment;
	}
	
	/**
	 * Sets the value of the dateStoppedTreatment property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateStoppedTreatment(XMLGregorianCalendar value) {
		this.dateStoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the reasonForStoppedTreatment property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForStoppedTreatment() {
		return reasonForStoppedTreatment;
	}
	
	/**
	 * Sets the value of the reasonForStoppedTreatment property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForStoppedTreatment(String value) {
		this.reasonForStoppedTreatment = value;
	}
	
	/**
	 * Gets the value of the substitutionWithin property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSubstitutionWithin() {
		return substitutionWithin;
	}
	
	/**
	 * Sets the value of the substitutionWithin property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSubstitutionWithin(String value) {
		this.substitutionWithin = value;
	}
	
	/**
	 * Gets the value of the regimenSubstitutionDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRegimenSubstitutionDate() {
		return regimenSubstitutionDate;
	}
	
	/**
	 * Sets the value of the regimenSubstitutionDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRegimenSubstitutionDate(XMLGregorianCalendar value) {
		this.regimenSubstitutionDate = value;
	}
	
	/**
	 * Gets the value of the reasonForSubstitution property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForSubstitution() {
		return reasonForSubstitution;
	}
	
	/**
	 * Sets the value of the reasonForSubstitution property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForSubstitution(String value) {
		this.reasonForSubstitution = value;
	}
	
	/**
	 * Gets the value of the otherReasonForSubstitution property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherReasonForSubstitution() {
		return otherReasonForSubstitution;
	}
	
	/**
	 * Sets the value of the otherReasonForSubstitution property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherReasonForSubstitution(String value) {
		this.otherReasonForSubstitution = value;
	}
	
	/**
	 * Gets the value of the newRegimenAfterSubstitution property.
	 * 
	 * @return possible object is {@link RegimenCodedSimpleType }
	 */
	public RegimenCodedSimpleType getNewRegimenAfterSubstitution() {
		return newRegimenAfterSubstitution;
	}
	
	/**
	 * Sets the value of the newRegimenAfterSubstitution property.
	 * 
	 * @param value allowed object is {@link RegimenCodedSimpleType }
	 */
	public void setNewRegimenAfterSubstitution(RegimenCodedSimpleType value) {
		this.newRegimenAfterSubstitution = value;
	}
	
	/**
	 * Gets the value of the switchTo property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSwitchTo() {
		return switchTo;
	}
	
	/**
	 * Sets the value of the switchTo property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSwitchTo(String value) {
		this.switchTo = value;
	}
	
	/**
	 * Gets the value of the regimenSwitchDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getRegimenSwitchDate() {
		return regimenSwitchDate;
	}
	
	/**
	 * Sets the value of the regimenSwitchDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setRegimenSwitchDate(XMLGregorianCalendar value) {
		this.regimenSwitchDate = value;
	}
	
	/**
	 * Gets the value of the reasonForSwitch property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReasonForSwitch() {
		return reasonForSwitch;
	}
	
	/**
	 * Sets the value of the reasonForSwitch property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReasonForSwitch(String value) {
		this.reasonForSwitch = value;
	}
	
	/**
	 * Gets the value of the otherReasonForSwitch property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherReasonForSwitch() {
		return otherReasonForSwitch;
	}
	
	/**
	 * Sets the value of the otherReasonForSwitch property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherReasonForSwitch(String value) {
		this.otherReasonForSwitch = value;
	}
	
	/**
	 * Gets the value of the newRegimenAfterSwitch property.
	 * 
	 * @return possible object is {@link RegimenCodedSimpleType }
	 */
	public RegimenCodedSimpleType getNewRegimenAfterSwitch() {
		return newRegimenAfterSwitch;
	}
	
	/**
	 * Sets the value of the newRegimenAfterSwitch property.
	 * 
	 * @param value allowed object is {@link RegimenCodedSimpleType }
	 */
	public void setNewRegimenAfterSwitch(RegimenCodedSimpleType value) {
		this.newRegimenAfterSwitch = value;
	}
	
	/**
	 * Gets the value of the drGenotypingDone property.
	 * 
	 * @return possible object is {@link YNCodeType }
	 */
	public YNCodeType getDRGenotypingDone() {
		return drGenotypingDone;
	}
	
	/**
	 * Sets the value of the drGenotypingDone property.
	 * 
	 * @param value allowed object is {@link YNCodeType }
	 */
	public void setDRGenotypingDone(YNCodeType value) {
		this.drGenotypingDone = value;
	}
	
	/**
	 * Gets the value of the genotypingSampleDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getGenotypingSampleDate() {
		return genotypingSampleDate;
	}
	
	/**
	 * Sets the value of the genotypingSampleDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setGenotypingSampleDate(XMLGregorianCalendar value) {
		this.genotypingSampleDate = value;
	}
	
	/**
	 * Gets the value of the genotypingReceivedDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getGenotypingReceivedDate() {
		return genotypingReceivedDate;
	}
	
	/**
	 * Sets the value of the genotypingReceivedDate property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setGenotypingReceivedDate(XMLGregorianCalendar value) {
		this.genotypingReceivedDate = value;
	}
	
	/**
	 * Gets the value of the drResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDRResult() {
		return drResult;
	}
	
	/**
	 * Sets the value of the drResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDRResult(String value) {
		this.drResult = value;
	}
	
	/**
	 * Gets the value of the ifDRResistant property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getIfDRResistant() {
		return ifDRResistant;
	}
	
	/**
	 * Sets the value of the ifDRResistant property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setIfDRResistant(String value) {
		this.ifDRResistant = value;
	}
	
}
