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
 * Java class for PrepScreeningAndEligibilityType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepScreeningAndEligibilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UniqueClientId" type="{}StringType"/>
 *         &lt;element name="DateOfVisit" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ReferredFrom" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Self"/>
 *               &lt;enumeration value="Counselor"/>
 *               &lt;enumeration value="Peer"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReferredFromOtherSpecify" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="Setting" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="CT"/>
 *               &lt;enumeration value="TB"/>
 *               &lt;enumeration value="STI"/>
 *               &lt;enumeration value="FP"/>
 *               &lt;enumeration value="OPD"/>
 *               &lt;enumeration value="Ward"/>
 *               &lt;enumeration value="Outreach"/>
 *               &lt;enumeration value="StandaloneHTS"/>
 *               &lt;enumeration value="Other"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SettingOtherSpecify" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VisitType" minOccurs="0">
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
 *         &lt;element name="PopulationType" minOccurs="0">
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
 *         &lt;element name="Occupation" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="EducationLevel" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="MaritalStatus" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="NumberOfOwnChildrenUnder5" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TypeOfSession" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Individual"/>
 *               &lt;enumeration value="Couple"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SexPartners" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Male"/>
 *               &lt;enumeration value="Female"/>
 *               &lt;enumeration value="Both"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PregnancyStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="BF"/>
 *               &lt;enumeration value="NP"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PartnerIsHivPositive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerInjectsDrugs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerHasSexWithMen" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerIsTransgender" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PartnerHasMultiplePartnersWithoutCondoms" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnprotectedVaginalSexWithCasualPartner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnprotectedAnalSex" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SharedNeedlesOrInjectingMaterials" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MoreThanOneSexPartner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PaidOrBeenPaidForSex" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesCocaine" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesHeroin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesMarijuana" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesAmphetamine" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesCodeineSyrup" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesOtherDrugs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OtherDrugsSpecify" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="RouteInject" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RouteSniff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RouteSnort" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RouteSmoke" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UsesDrugsForSexualEnhancement" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HadSexWithoutCondomUnkHivStatLast72Hours" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SharedInjectionEquipmentUnkHivStatLast72Hours" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HadColdFluSymptomsLast2Weeks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HadUnprotectedSexOrSharedMaterialsLast28Days" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FemaleVaginalDischargeOrBurning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FemaleLowerAbdominalPain" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaleUrethralDischargeOrBurning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaleScrotumSwellingAndPain" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GenitalSores" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SwollenInguinalLymphNodes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AnalPainOnStooling" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AnalItching" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AnalDischarge" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastHivTestTimeframe" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="LessThan1Month"/>
 *               &lt;enumeration value="1To3Months"/>
 *               &lt;enumeration value="4To6Months"/>
 *               &lt;enumeration value="MoreThan6Months"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RecommendedForHivRetest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TestedInOtherClinicalSettings" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HivTestResult" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="Negative"/>
 *               &lt;enumeration value="Positive"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReportsOngoingHivRiskBehaviors" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReportsSpecificHivExposureLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AcuteHivInfectionRetestRecommended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HivNegative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HivRiskScoreAtLeastOne" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NoSignsOfAcuteHivInfection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NoIndicationForPep" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HasNoProteinuria" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NoHistoryOfLiverAbnormalities" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NoHistoryOfDrugDrugInteractionsForInjectable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NoHistoryOfDrugHypersensitivity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PrepOffered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="WillingToCommencePrEP" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReceivedPrepForFirstTimeThisYear" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ClientReferredToOtherServices" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReferralServiceSpecify" type="{}StringType" minOccurs="0"/>
 *         &lt;element name="DeclineNoNeedForPrep" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineDoesNotWishDailyMedication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineConcernAboutSideEffects" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineConcernAboutStigmatization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineConcernAboutClinicFollowupTime" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineConcernAboutSafetyOfMedication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineConcernAboutEffectiveness" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeclineOtherReasonSpecify" type="{}StringType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepScreeningAndEligibilityType", propOrder = { "uniqueClientId", "dateOfVisit", "referredFrom",
        "referredFromOtherSpecify", "setting", "settingOtherSpecify", "age", "sex", "visitType", "populationType",
        "occupation", "educationLevel", "maritalStatus", "numberOfOwnChildrenUnder5", "weight", "typeOfSession",
        "sexPartners", "pregnancyStatus", "partnerIsHivPositive", "partnerInjectsDrugs", "partnerHasSexWithMen",
        "partnerIsTransgender", "partnerHasMultiplePartnersWithoutCondoms", "unprotectedVaginalSexWithCasualPartner",
        "unprotectedAnalSex", "sharedNeedlesOrInjectingMaterials", "moreThanOneSexPartner", "paidOrBeenPaidForSex",
        "usesCocaine", "usesHeroin", "usesMarijuana", "usesAmphetamine", "usesCodeineSyrup", "usesOtherDrugs",
        "otherDrugsSpecify", "routeInject", "routeSniff", "routeSnort", "routeSmoke", "usesDrugsForSexualEnhancement",
        "hadSexWithoutCondomUnkHivStatLast72Hours", "sharedInjectionEquipmentUnkHivStatLast72Hours",
        "hadColdFluSymptomsLast2Weeks", "hadUnprotectedSexOrSharedMaterialsLast28Days", "femaleVaginalDischargeOrBurning",
        "femaleLowerAbdominalPain", "maleUrethralDischargeOrBurning", "maleScrotumSwellingAndPain", "genitalSores",
        "swollenInguinalLymphNodes", "analPainOnStooling", "analItching", "analDischarge", "lastHivTestTimeframe",
        "recommendedForHivRetest", "testedInOtherClinicalSettings", "hivTestResult", "reportsOngoingHivRiskBehaviors",
        "reportsSpecificHivExposureLast3Months", "acuteHivInfectionRetestRecommended", "hivNegative",
        "hivRiskScoreAtLeastOne", "noSignsOfAcuteHivInfection", "noIndicationForPep", "hasNoProteinuria",
        "noHistoryOfLiverAbnormalities", "noHistoryOfDrugDrugInteractionsForInjectable", "noHistoryOfDrugHypersensitivity",
        "prepOffered", "willingToCommencePrEP", "receivedPrepForFirstTimeThisYear", "clientReferredToOtherServices",
        "referralServiceSpecify", "declineNoNeedForPrep", "declineDoesNotWishDailyMedication",
        "declineConcernAboutSideEffects", "declineConcernAboutStigmatization", "declineConcernAboutClinicFollowupTime",
        "declineConcernAboutSafetyOfMedication", "declineConcernAboutEffectiveness", "declineOtherReasonSpecify" })
public class PrepScreeningAndEligibilityType {
	
	@XmlElement(name = "UniqueClientId", required = true)
	protected String uniqueClientId;
	
	@XmlElement(name = "DateOfVisit", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfVisit;
	
	@XmlElement(name = "ReferredFrom")
	protected String referredFrom;
	
	@XmlElement(name = "ReferredFromOtherSpecify")
	protected String referredFromOtherSpecify;
	
	@XmlElement(name = "Setting")
	protected String setting;
	
	@XmlElement(name = "SettingOtherSpecify")
	protected String settingOtherSpecify;
	
	@XmlElement(name = "Age")
	protected Integer age;
	
	@XmlElement(name = "Sex")
	protected String sex;
	
	@XmlElement(name = "VisitType")
	protected String visitType;
	
	@XmlElement(name = "PopulationType")
	protected String populationType;
	
	@XmlElement(name = "Occupation")
	protected String occupation;
	
	@XmlElement(name = "EducationLevel")
	protected String educationLevel;
	
	@XmlElement(name = "MaritalStatus")
	protected String maritalStatus;
	
	@XmlElement(name = "NumberOfOwnChildrenUnder5")
	protected Integer numberOfOwnChildrenUnder5;
	
	@XmlElement(name = "Weight")
	protected BigDecimal weight;
	
	@XmlElement(name = "TypeOfSession")
	protected String typeOfSession;
	
	@XmlElement(name = "SexPartners")
	protected String sexPartners;
	
	@XmlElement(name = "PregnancyStatus")
	protected String pregnancyStatus;
	
	@XmlElement(name = "PartnerIsHivPositive")
	protected Boolean partnerIsHivPositive;
	
	@XmlElement(name = "PartnerInjectsDrugs")
	protected Boolean partnerInjectsDrugs;
	
	@XmlElement(name = "PartnerHasSexWithMen")
	protected Boolean partnerHasSexWithMen;
	
	@XmlElement(name = "PartnerIsTransgender")
	protected Boolean partnerIsTransgender;
	
	@XmlElement(name = "PartnerHasMultiplePartnersWithoutCondoms")
	protected Boolean partnerHasMultiplePartnersWithoutCondoms;
	
	@XmlElement(name = "UnprotectedVaginalSexWithCasualPartner")
	protected Boolean unprotectedVaginalSexWithCasualPartner;
	
	@XmlElement(name = "UnprotectedAnalSex")
	protected Boolean unprotectedAnalSex;
	
	@XmlElement(name = "SharedNeedlesOrInjectingMaterials")
	protected Boolean sharedNeedlesOrInjectingMaterials;
	
	@XmlElement(name = "MoreThanOneSexPartner")
	protected Boolean moreThanOneSexPartner;
	
	@XmlElement(name = "PaidOrBeenPaidForSex")
	protected Boolean paidOrBeenPaidForSex;
	
	@XmlElement(name = "UsesCocaine")
	protected Boolean usesCocaine;
	
	@XmlElement(name = "UsesHeroin")
	protected Boolean usesHeroin;
	
	@XmlElement(name = "UsesMarijuana")
	protected Boolean usesMarijuana;
	
	@XmlElement(name = "UsesAmphetamine")
	protected Boolean usesAmphetamine;
	
	@XmlElement(name = "UsesCodeineSyrup")
	protected Boolean usesCodeineSyrup;
	
	@XmlElement(name = "UsesOtherDrugs")
	protected Boolean usesOtherDrugs;
	
	@XmlElement(name = "OtherDrugsSpecify")
	protected String otherDrugsSpecify;
	
	@XmlElement(name = "RouteInject")
	protected Boolean routeInject;
	
	@XmlElement(name = "RouteSniff")
	protected Boolean routeSniff;
	
	@XmlElement(name = "RouteSnort")
	protected Boolean routeSnort;
	
	@XmlElement(name = "RouteSmoke")
	protected Boolean routeSmoke;
	
	@XmlElement(name = "UsesDrugsForSexualEnhancement")
	protected Boolean usesDrugsForSexualEnhancement;
	
	@XmlElement(name = "HadSexWithoutCondomUnkHivStatLast72Hours")
	protected Boolean hadSexWithoutCondomUnkHivStatLast72Hours;
	
	@XmlElement(name = "SharedInjectionEquipmentUnkHivStatLast72Hours")
	protected Boolean sharedInjectionEquipmentUnkHivStatLast72Hours;
	
	@XmlElement(name = "HadColdFluSymptomsLast2Weeks")
	protected Boolean hadColdFluSymptomsLast2Weeks;
	
	@XmlElement(name = "HadUnprotectedSexOrSharedMaterialsLast28Days")
	protected Boolean hadUnprotectedSexOrSharedMaterialsLast28Days;
	
	@XmlElement(name = "FemaleVaginalDischargeOrBurning")
	protected Boolean femaleVaginalDischargeOrBurning;
	
	@XmlElement(name = "FemaleLowerAbdominalPain")
	protected Boolean femaleLowerAbdominalPain;
	
	@XmlElement(name = "MaleUrethralDischargeOrBurning")
	protected Boolean maleUrethralDischargeOrBurning;
	
	@XmlElement(name = "MaleScrotumSwellingAndPain")
	protected Boolean maleScrotumSwellingAndPain;
	
	@XmlElement(name = "GenitalSores")
	protected Boolean genitalSores;
	
	@XmlElement(name = "SwollenInguinalLymphNodes")
	protected Boolean swollenInguinalLymphNodes;
	
	@XmlElement(name = "AnalPainOnStooling")
	protected Boolean analPainOnStooling;
	
	@XmlElement(name = "AnalItching")
	protected Boolean analItching;
	
	@XmlElement(name = "AnalDischarge")
	protected Boolean analDischarge;
	
	@XmlElement(name = "LastHivTestTimeframe")
	protected String lastHivTestTimeframe;
	
	@XmlElement(name = "RecommendedForHivRetest")
	protected Boolean recommendedForHivRetest;
	
	@XmlElement(name = "TestedInOtherClinicalSettings")
	protected Boolean testedInOtherClinicalSettings;
	
	@XmlElement(name = "HivTestResult")
	protected String hivTestResult;
	
	@XmlElement(name = "ReportsOngoingHivRiskBehaviors")
	protected Boolean reportsOngoingHivRiskBehaviors;
	
	@XmlElement(name = "ReportsSpecificHivExposureLast3Months")
	protected Boolean reportsSpecificHivExposureLast3Months;
	
	@XmlElement(name = "AcuteHivInfectionRetestRecommended")
	protected Boolean acuteHivInfectionRetestRecommended;
	
	@XmlElement(name = "HivNegative")
	protected Boolean hivNegative;
	
	@XmlElement(name = "HivRiskScoreAtLeastOne")
	protected Boolean hivRiskScoreAtLeastOne;
	
	@XmlElement(name = "NoSignsOfAcuteHivInfection")
	protected Boolean noSignsOfAcuteHivInfection;
	
	@XmlElement(name = "NoIndicationForPep")
	protected Boolean noIndicationForPep;
	
	@XmlElement(name = "HasNoProteinuria")
	protected Boolean hasNoProteinuria;
	
	@XmlElement(name = "NoHistoryOfLiverAbnormalities")
	protected Boolean noHistoryOfLiverAbnormalities;
	
	@XmlElement(name = "NoHistoryOfDrugDrugInteractionsForInjectable")
	protected Boolean noHistoryOfDrugDrugInteractionsForInjectable;
	
	@XmlElement(name = "NoHistoryOfDrugHypersensitivity")
	protected Boolean noHistoryOfDrugHypersensitivity;
	
	@XmlElement(name = "PrepOffered")
	protected Boolean prepOffered;
	
	@XmlElement(name = "WillingToCommencePrEP")
	protected Boolean willingToCommencePrEP;
	
	@XmlElement(name = "ReceivedPrepForFirstTimeThisYear")
	protected Boolean receivedPrepForFirstTimeThisYear;
	
	@XmlElement(name = "ClientReferredToOtherServices")
	protected Boolean clientReferredToOtherServices;
	
	@XmlElement(name = "ReferralServiceSpecify")
	protected String referralServiceSpecify;
	
	@XmlElement(name = "DeclineNoNeedForPrep")
	protected Boolean declineNoNeedForPrep;
	
	@XmlElement(name = "DeclineDoesNotWishDailyMedication")
	protected Boolean declineDoesNotWishDailyMedication;
	
	@XmlElement(name = "DeclineConcernAboutSideEffects")
	protected Boolean declineConcernAboutSideEffects;
	
	@XmlElement(name = "DeclineConcernAboutStigmatization")
	protected Boolean declineConcernAboutStigmatization;
	
	@XmlElement(name = "DeclineConcernAboutClinicFollowupTime")
	protected Boolean declineConcernAboutClinicFollowupTime;
	
	@XmlElement(name = "DeclineConcernAboutSafetyOfMedication")
	protected Boolean declineConcernAboutSafetyOfMedication;
	
	@XmlElement(name = "DeclineConcernAboutEffectiveness")
	protected Boolean declineConcernAboutEffectiveness;
	
	@XmlElement(name = "DeclineOtherReasonSpecify")
	protected String declineOtherReasonSpecify;
	
	/**
	 * Gets the value of the uniqueClientId property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getUniqueClientId() {
		return uniqueClientId;
	}
	
	/**
	 * Sets the value of the uniqueClientId property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setUniqueClientId(String value) {
		this.uniqueClientId = value;
	}
	
	/**
	 * Gets the value of the dateOfVisit property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getDateOfVisit() {
		return dateOfVisit;
	}
	
	/**
	 * Sets the value of the dateOfVisit property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 */
	public void setDateOfVisit(XMLGregorianCalendar value) {
		this.dateOfVisit = value;
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
	 * Gets the value of the referredFromOtherSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferredFromOtherSpecify() {
		return referredFromOtherSpecify;
	}
	
	/**
	 * Sets the value of the referredFromOtherSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferredFromOtherSpecify(String value) {
		this.referredFromOtherSpecify = value;
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
	 * Gets the value of the settingOtherSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSettingOtherSpecify() {
		return settingOtherSpecify;
	}
	
	/**
	 * Sets the value of the settingOtherSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSettingOtherSpecify(String value) {
		this.settingOtherSpecify = value;
	}
	
	/**
	 * Gets the value of the age property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * Sets the value of the age property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setAge(Integer value) {
		this.age = value;
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
	 * Gets the value of the visitType property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getVisitType() {
		return visitType;
	}
	
	/**
	 * Sets the value of the visitType property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setVisitType(String value) {
		this.visitType = value;
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
	 * Gets the value of the occupation property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOccupation() {
		return occupation;
	}
	
	/**
	 * Sets the value of the occupation property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOccupation(String value) {
		this.occupation = value;
	}
	
	/**
	 * Gets the value of the educationLevel property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getEducationLevel() {
		return educationLevel;
	}
	
	/**
	 * Sets the value of the educationLevel property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setEducationLevel(String value) {
		this.educationLevel = value;
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
	 * Gets the value of the numberOfOwnChildrenUnder5 property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getNumberOfOwnChildrenUnder5() {
		return numberOfOwnChildrenUnder5;
	}
	
	/**
	 * Sets the value of the numberOfOwnChildrenUnder5 property.
	 * 
	 * @param value allowed object is {@link Integer }
	 */
	public void setNumberOfOwnChildrenUnder5(Integer value) {
		this.numberOfOwnChildrenUnder5 = value;
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
	 * Gets the value of the typeOfSession property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getTypeOfSession() {
		return typeOfSession;
	}
	
	/**
	 * Sets the value of the typeOfSession property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setTypeOfSession(String value) {
		this.typeOfSession = value;
	}
	
	/**
	 * Gets the value of the sexPartners property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getSexPartners() {
		return sexPartners;
	}
	
	/**
	 * Sets the value of the sexPartners property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setSexPartners(String value) {
		this.sexPartners = value;
	}
	
	/**
	 * Gets the value of the pregnancyStatus property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getPregnancyStatus() {
		return pregnancyStatus;
	}
	
	/**
	 * Sets the value of the pregnancyStatus property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setPregnancyStatus(String value) {
		this.pregnancyStatus = value;
	}
	
	/**
	 * Gets the value of the partnerIsHivPositive property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerIsHivPositive() {
		return partnerIsHivPositive;
	}
	
	/**
	 * Sets the value of the partnerIsHivPositive property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerIsHivPositive(Boolean value) {
		this.partnerIsHivPositive = value;
	}
	
	/**
	 * Gets the value of the partnerInjectsDrugs property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerInjectsDrugs() {
		return partnerInjectsDrugs;
	}
	
	/**
	 * Sets the value of the partnerInjectsDrugs property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerInjectsDrugs(Boolean value) {
		this.partnerInjectsDrugs = value;
	}
	
	/**
	 * Gets the value of the partnerHasSexWithMen property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerHasSexWithMen() {
		return partnerHasSexWithMen;
	}
	
	/**
	 * Sets the value of the partnerHasSexWithMen property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerHasSexWithMen(Boolean value) {
		this.partnerHasSexWithMen = value;
	}
	
	/**
	 * Gets the value of the partnerIsTransgender property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerIsTransgender() {
		return partnerIsTransgender;
	}
	
	/**
	 * Sets the value of the partnerIsTransgender property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerIsTransgender(Boolean value) {
		this.partnerIsTransgender = value;
	}
	
	/**
	 * Gets the value of the partnerHasMultiplePartnersWithoutCondoms property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPartnerHasMultiplePartnersWithoutCondoms() {
		return partnerHasMultiplePartnersWithoutCondoms;
	}
	
	/**
	 * Sets the value of the partnerHasMultiplePartnersWithoutCondoms property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPartnerHasMultiplePartnersWithoutCondoms(Boolean value) {
		this.partnerHasMultiplePartnersWithoutCondoms = value;
	}
	
	/**
	 * Gets the value of the unprotectedVaginalSexWithCasualPartner property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUnprotectedVaginalSexWithCasualPartner() {
		return unprotectedVaginalSexWithCasualPartner;
	}
	
	/**
	 * Sets the value of the unprotectedVaginalSexWithCasualPartner property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUnprotectedVaginalSexWithCasualPartner(Boolean value) {
		this.unprotectedVaginalSexWithCasualPartner = value;
	}
	
	/**
	 * Gets the value of the unprotectedAnalSex property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUnprotectedAnalSex() {
		return unprotectedAnalSex;
	}
	
	/**
	 * Sets the value of the unprotectedAnalSex property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUnprotectedAnalSex(Boolean value) {
		this.unprotectedAnalSex = value;
	}
	
	/**
	 * Gets the value of the sharedNeedlesOrInjectingMaterials property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSharedNeedlesOrInjectingMaterials() {
		return sharedNeedlesOrInjectingMaterials;
	}
	
	/**
	 * Sets the value of the sharedNeedlesOrInjectingMaterials property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSharedNeedlesOrInjectingMaterials(Boolean value) {
		this.sharedNeedlesOrInjectingMaterials = value;
	}
	
	/**
	 * Gets the value of the moreThanOneSexPartner property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isMoreThanOneSexPartner() {
		return moreThanOneSexPartner;
	}
	
	/**
	 * Sets the value of the moreThanOneSexPartner property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setMoreThanOneSexPartner(Boolean value) {
		this.moreThanOneSexPartner = value;
	}
	
	/**
	 * Gets the value of the paidOrBeenPaidForSex property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPaidOrBeenPaidForSex() {
		return paidOrBeenPaidForSex;
	}
	
	/**
	 * Sets the value of the paidOrBeenPaidForSex property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPaidOrBeenPaidForSex(Boolean value) {
		this.paidOrBeenPaidForSex = value;
	}
	
	/**
	 * Gets the value of the usesCocaine property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesCocaine() {
		return usesCocaine;
	}
	
	/**
	 * Sets the value of the usesCocaine property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesCocaine(Boolean value) {
		this.usesCocaine = value;
	}
	
	/**
	 * Gets the value of the usesHeroin property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesHeroin() {
		return usesHeroin;
	}
	
	/**
	 * Sets the value of the usesHeroin property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesHeroin(Boolean value) {
		this.usesHeroin = value;
	}
	
	/**
	 * Gets the value of the usesMarijuana property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesMarijuana() {
		return usesMarijuana;
	}
	
	/**
	 * Sets the value of the usesMarijuana property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesMarijuana(Boolean value) {
		this.usesMarijuana = value;
	}
	
	/**
	 * Gets the value of the usesAmphetamine property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesAmphetamine() {
		return usesAmphetamine;
	}
	
	/**
	 * Sets the value of the usesAmphetamine property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesAmphetamine(Boolean value) {
		this.usesAmphetamine = value;
	}
	
	/**
	 * Gets the value of the usesCodeineSyrup property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesCodeineSyrup() {
		return usesCodeineSyrup;
	}
	
	/**
	 * Sets the value of the usesCodeineSyrup property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesCodeineSyrup(Boolean value) {
		this.usesCodeineSyrup = value;
	}
	
	/**
	 * Gets the value of the usesOtherDrugs property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesOtherDrugs() {
		return usesOtherDrugs;
	}
	
	/**
	 * Sets the value of the usesOtherDrugs property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesOtherDrugs(Boolean value) {
		this.usesOtherDrugs = value;
	}
	
	/**
	 * Gets the value of the otherDrugsSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getOtherDrugsSpecify() {
		return otherDrugsSpecify;
	}
	
	/**
	 * Sets the value of the otherDrugsSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setOtherDrugsSpecify(String value) {
		this.otherDrugsSpecify = value;
	}
	
	/**
	 * Gets the value of the routeInject property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isRouteInject() {
		return routeInject;
	}
	
	/**
	 * Sets the value of the routeInject property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setRouteInject(Boolean value) {
		this.routeInject = value;
	}
	
	/**
	 * Gets the value of the routeSniff property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isRouteSniff() {
		return routeSniff;
	}
	
	/**
	 * Sets the value of the routeSniff property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setRouteSniff(Boolean value) {
		this.routeSniff = value;
	}
	
	/**
	 * Gets the value of the routeSnort property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isRouteSnort() {
		return routeSnort;
	}
	
	/**
	 * Sets the value of the routeSnort property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setRouteSnort(Boolean value) {
		this.routeSnort = value;
	}
	
	/**
	 * Gets the value of the routeSmoke property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isRouteSmoke() {
		return routeSmoke;
	}
	
	/**
	 * Sets the value of the routeSmoke property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setRouteSmoke(Boolean value) {
		this.routeSmoke = value;
	}
	
	/**
	 * Gets the value of the usesDrugsForSexualEnhancement property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUsesDrugsForSexualEnhancement() {
		return usesDrugsForSexualEnhancement;
	}
	
	/**
	 * Sets the value of the usesDrugsForSexualEnhancement property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUsesDrugsForSexualEnhancement(Boolean value) {
		this.usesDrugsForSexualEnhancement = value;
	}
	
	/**
	 * Gets the value of the hadSexWithoutCondomUnkHivStatLast72Hours property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHadSexWithoutCondomUnkHivStatLast72Hours() {
		return hadSexWithoutCondomUnkHivStatLast72Hours;
	}
	
	/**
	 * Sets the value of the hadSexWithoutCondomUnkHivStatLast72Hours property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHadSexWithoutCondomUnkHivStatLast72Hours(Boolean value) {
		this.hadSexWithoutCondomUnkHivStatLast72Hours = value;
	}
	
	/**
	 * Gets the value of the sharedInjectionEquipmentUnkHivStatLast72Hours property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSharedInjectionEquipmentUnkHivStatLast72Hours() {
		return sharedInjectionEquipmentUnkHivStatLast72Hours;
	}
	
	/**
	 * Sets the value of the sharedInjectionEquipmentUnkHivStatLast72Hours property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSharedInjectionEquipmentUnkHivStatLast72Hours(Boolean value) {
		this.sharedInjectionEquipmentUnkHivStatLast72Hours = value;
	}
	
	/**
	 * Gets the value of the hadColdFluSymptomsLast2Weeks property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHadColdFluSymptomsLast2Weeks() {
		return hadColdFluSymptomsLast2Weeks;
	}
	
	/**
	 * Sets the value of the hadColdFluSymptomsLast2Weeks property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHadColdFluSymptomsLast2Weeks(Boolean value) {
		this.hadColdFluSymptomsLast2Weeks = value;
	}
	
	/**
	 * Gets the value of the hadUnprotectedSexOrSharedMaterialsLast28Days property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHadUnprotectedSexOrSharedMaterialsLast28Days() {
		return hadUnprotectedSexOrSharedMaterialsLast28Days;
	}
	
	/**
	 * Sets the value of the hadUnprotectedSexOrSharedMaterialsLast28Days property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHadUnprotectedSexOrSharedMaterialsLast28Days(Boolean value) {
		this.hadUnprotectedSexOrSharedMaterialsLast28Days = value;
	}
	
	/**
	 * Gets the value of the femaleVaginalDischargeOrBurning property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isFemaleVaginalDischargeOrBurning() {
		return femaleVaginalDischargeOrBurning;
	}
	
	/**
	 * Sets the value of the femaleVaginalDischargeOrBurning property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setFemaleVaginalDischargeOrBurning(Boolean value) {
		this.femaleVaginalDischargeOrBurning = value;
	}
	
	/**
	 * Gets the value of the femaleLowerAbdominalPain property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isFemaleLowerAbdominalPain() {
		return femaleLowerAbdominalPain;
	}
	
	/**
	 * Sets the value of the femaleLowerAbdominalPain property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setFemaleLowerAbdominalPain(Boolean value) {
		this.femaleLowerAbdominalPain = value;
	}
	
	/**
	 * Gets the value of the maleUrethralDischargeOrBurning property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isMaleUrethralDischargeOrBurning() {
		return maleUrethralDischargeOrBurning;
	}
	
	/**
	 * Sets the value of the maleUrethralDischargeOrBurning property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setMaleUrethralDischargeOrBurning(Boolean value) {
		this.maleUrethralDischargeOrBurning = value;
	}
	
	/**
	 * Gets the value of the maleScrotumSwellingAndPain property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isMaleScrotumSwellingAndPain() {
		return maleScrotumSwellingAndPain;
	}
	
	/**
	 * Sets the value of the maleScrotumSwellingAndPain property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setMaleScrotumSwellingAndPain(Boolean value) {
		this.maleScrotumSwellingAndPain = value;
	}
	
	/**
	 * Gets the value of the genitalSores property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isGenitalSores() {
		return genitalSores;
	}
	
	/**
	 * Sets the value of the genitalSores property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setGenitalSores(Boolean value) {
		this.genitalSores = value;
	}
	
	/**
	 * Gets the value of the swollenInguinalLymphNodes property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSwollenInguinalLymphNodes() {
		return swollenInguinalLymphNodes;
	}
	
	/**
	 * Sets the value of the swollenInguinalLymphNodes property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSwollenInguinalLymphNodes(Boolean value) {
		this.swollenInguinalLymphNodes = value;
	}
	
	/**
	 * Gets the value of the analPainOnStooling property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isAnalPainOnStooling() {
		return analPainOnStooling;
	}
	
	/**
	 * Sets the value of the analPainOnStooling property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setAnalPainOnStooling(Boolean value) {
		this.analPainOnStooling = value;
	}
	
	/**
	 * Gets the value of the analItching property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isAnalItching() {
		return analItching;
	}
	
	/**
	 * Sets the value of the analItching property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setAnalItching(Boolean value) {
		this.analItching = value;
	}
	
	/**
	 * Gets the value of the analDischarge property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isAnalDischarge() {
		return analDischarge;
	}
	
	/**
	 * Sets the value of the analDischarge property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setAnalDischarge(Boolean value) {
		this.analDischarge = value;
	}
	
	/**
	 * Gets the value of the lastHivTestTimeframe property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getLastHivTestTimeframe() {
		return lastHivTestTimeframe;
	}
	
	/**
	 * Sets the value of the lastHivTestTimeframe property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setLastHivTestTimeframe(String value) {
		this.lastHivTestTimeframe = value;
	}
	
	/**
	 * Gets the value of the recommendedForHivRetest property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isRecommendedForHivRetest() {
		return recommendedForHivRetest;
	}
	
	/**
	 * Sets the value of the recommendedForHivRetest property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setRecommendedForHivRetest(Boolean value) {
		this.recommendedForHivRetest = value;
	}
	
	/**
	 * Gets the value of the testedInOtherClinicalSettings property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isTestedInOtherClinicalSettings() {
		return testedInOtherClinicalSettings;
	}
	
	/**
	 * Sets the value of the testedInOtherClinicalSettings property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setTestedInOtherClinicalSettings(Boolean value) {
		this.testedInOtherClinicalSettings = value;
	}
	
	/**
	 * Gets the value of the hivTestResult property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getHivTestResult() {
		return hivTestResult;
	}
	
	/**
	 * Sets the value of the hivTestResult property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setHivTestResult(String value) {
		this.hivTestResult = value;
	}
	
	/**
	 * Gets the value of the reportsOngoingHivRiskBehaviors property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isReportsOngoingHivRiskBehaviors() {
		return reportsOngoingHivRiskBehaviors;
	}
	
	/**
	 * Sets the value of the reportsOngoingHivRiskBehaviors property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setReportsOngoingHivRiskBehaviors(Boolean value) {
		this.reportsOngoingHivRiskBehaviors = value;
	}
	
	/**
	 * Gets the value of the reportsSpecificHivExposureLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isReportsSpecificHivExposureLast3Months() {
		return reportsSpecificHivExposureLast3Months;
	}
	
	/**
	 * Sets the value of the reportsSpecificHivExposureLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setReportsSpecificHivExposureLast3Months(Boolean value) {
		this.reportsSpecificHivExposureLast3Months = value;
	}
	
	/**
	 * Gets the value of the acuteHivInfectionRetestRecommended property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isAcuteHivInfectionRetestRecommended() {
		return acuteHivInfectionRetestRecommended;
	}
	
	/**
	 * Sets the value of the acuteHivInfectionRetestRecommended property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setAcuteHivInfectionRetestRecommended(Boolean value) {
		this.acuteHivInfectionRetestRecommended = value;
	}
	
	/**
	 * Gets the value of the hivNegative property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHivNegative() {
		return hivNegative;
	}
	
	/**
	 * Sets the value of the hivNegative property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHivNegative(Boolean value) {
		this.hivNegative = value;
	}
	
	/**
	 * Gets the value of the hivRiskScoreAtLeastOne property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHivRiskScoreAtLeastOne() {
		return hivRiskScoreAtLeastOne;
	}
	
	/**
	 * Sets the value of the hivRiskScoreAtLeastOne property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHivRiskScoreAtLeastOne(Boolean value) {
		this.hivRiskScoreAtLeastOne = value;
	}
	
	/**
	 * Gets the value of the noSignsOfAcuteHivInfection property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNoSignsOfAcuteHivInfection() {
		return noSignsOfAcuteHivInfection;
	}
	
	/**
	 * Sets the value of the noSignsOfAcuteHivInfection property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNoSignsOfAcuteHivInfection(Boolean value) {
		this.noSignsOfAcuteHivInfection = value;
	}
	
	/**
	 * Gets the value of the noIndicationForPep property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNoIndicationForPep() {
		return noIndicationForPep;
	}
	
	/**
	 * Sets the value of the noIndicationForPep property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNoIndicationForPep(Boolean value) {
		this.noIndicationForPep = value;
	}
	
	/**
	 * Gets the value of the hasNoProteinuria property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isHasNoProteinuria() {
		return hasNoProteinuria;
	}
	
	/**
	 * Sets the value of the hasNoProteinuria property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setHasNoProteinuria(Boolean value) {
		this.hasNoProteinuria = value;
	}
	
	/**
	 * Gets the value of the noHistoryOfLiverAbnormalities property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNoHistoryOfLiverAbnormalities() {
		return noHistoryOfLiverAbnormalities;
	}
	
	/**
	 * Sets the value of the noHistoryOfLiverAbnormalities property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNoHistoryOfLiverAbnormalities(Boolean value) {
		this.noHistoryOfLiverAbnormalities = value;
	}
	
	/**
	 * Gets the value of the noHistoryOfDrugDrugInteractionsForInjectable property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNoHistoryOfDrugDrugInteractionsForInjectable() {
		return noHistoryOfDrugDrugInteractionsForInjectable;
	}
	
	/**
	 * Sets the value of the noHistoryOfDrugDrugInteractionsForInjectable property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNoHistoryOfDrugDrugInteractionsForInjectable(Boolean value) {
		this.noHistoryOfDrugDrugInteractionsForInjectable = value;
	}
	
	/**
	 * Gets the value of the noHistoryOfDrugHypersensitivity property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isNoHistoryOfDrugHypersensitivity() {
		return noHistoryOfDrugHypersensitivity;
	}
	
	/**
	 * Sets the value of the noHistoryOfDrugHypersensitivity property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setNoHistoryOfDrugHypersensitivity(Boolean value) {
		this.noHistoryOfDrugHypersensitivity = value;
	}
	
	/**
	 * Gets the value of the prepOffered property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isPrepOffered() {
		return prepOffered;
	}
	
	/**
	 * Sets the value of the prepOffered property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setPrepOffered(Boolean value) {
		this.prepOffered = value;
	}
	
	/**
	 * Gets the value of the willingToCommencePrEP property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isWillingToCommencePrEP() {
		return willingToCommencePrEP;
	}
	
	/**
	 * Sets the value of the willingToCommencePrEP property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setWillingToCommencePrEP(Boolean value) {
		this.willingToCommencePrEP = value;
	}
	
	/**
	 * Gets the value of the receivedPrepForFirstTimeThisYear property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isReceivedPrepForFirstTimeThisYear() {
		return receivedPrepForFirstTimeThisYear;
	}
	
	/**
	 * Sets the value of the receivedPrepForFirstTimeThisYear property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setReceivedPrepForFirstTimeThisYear(Boolean value) {
		this.receivedPrepForFirstTimeThisYear = value;
	}
	
	/**
	 * Gets the value of the clientReferredToOtherServices property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isClientReferredToOtherServices() {
		return clientReferredToOtherServices;
	}
	
	/**
	 * Sets the value of the clientReferredToOtherServices property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setClientReferredToOtherServices(Boolean value) {
		this.clientReferredToOtherServices = value;
	}
	
	/**
	 * Gets the value of the referralServiceSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getReferralServiceSpecify() {
		return referralServiceSpecify;
	}
	
	/**
	 * Sets the value of the referralServiceSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setReferralServiceSpecify(String value) {
		this.referralServiceSpecify = value;
	}
	
	/**
	 * Gets the value of the declineNoNeedForPrep property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineNoNeedForPrep() {
		return declineNoNeedForPrep;
	}
	
	/**
	 * Sets the value of the declineNoNeedForPrep property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineNoNeedForPrep(Boolean value) {
		this.declineNoNeedForPrep = value;
	}
	
	/**
	 * Gets the value of the declineDoesNotWishDailyMedication property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineDoesNotWishDailyMedication() {
		return declineDoesNotWishDailyMedication;
	}
	
	/**
	 * Sets the value of the declineDoesNotWishDailyMedication property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineDoesNotWishDailyMedication(Boolean value) {
		this.declineDoesNotWishDailyMedication = value;
	}
	
	/**
	 * Gets the value of the declineConcernAboutSideEffects property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineConcernAboutSideEffects() {
		return declineConcernAboutSideEffects;
	}
	
	/**
	 * Sets the value of the declineConcernAboutSideEffects property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineConcernAboutSideEffects(Boolean value) {
		this.declineConcernAboutSideEffects = value;
	}
	
	/**
	 * Gets the value of the declineConcernAboutStigmatization property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineConcernAboutStigmatization() {
		return declineConcernAboutStigmatization;
	}
	
	/**
	 * Sets the value of the declineConcernAboutStigmatization property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineConcernAboutStigmatization(Boolean value) {
		this.declineConcernAboutStigmatization = value;
	}
	
	/**
	 * Gets the value of the declineConcernAboutClinicFollowupTime property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineConcernAboutClinicFollowupTime() {
		return declineConcernAboutClinicFollowupTime;
	}
	
	/**
	 * Sets the value of the declineConcernAboutClinicFollowupTime property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineConcernAboutClinicFollowupTime(Boolean value) {
		this.declineConcernAboutClinicFollowupTime = value;
	}
	
	/**
	 * Gets the value of the declineConcernAboutSafetyOfMedication property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineConcernAboutSafetyOfMedication() {
		return declineConcernAboutSafetyOfMedication;
	}
	
	/**
	 * Sets the value of the declineConcernAboutSafetyOfMedication property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineConcernAboutSafetyOfMedication(Boolean value) {
		this.declineConcernAboutSafetyOfMedication = value;
	}
	
	/**
	 * Gets the value of the declineConcernAboutEffectiveness property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isDeclineConcernAboutEffectiveness() {
		return declineConcernAboutEffectiveness;
	}
	
	/**
	 * Sets the value of the declineConcernAboutEffectiveness property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setDeclineConcernAboutEffectiveness(Boolean value) {
		this.declineConcernAboutEffectiveness = value;
	}
	
	/**
	 * Gets the value of the declineOtherReasonSpecify property.
	 * 
	 * @return possible object is {@link String }
	 */
	public String getDeclineOtherReasonSpecify() {
		return declineOtherReasonSpecify;
	}
	
	/**
	 * Sets the value of the declineOtherReasonSpecify property.
	 * 
	 * @param value allowed object is {@link String }
	 */
	public void setDeclineOtherReasonSpecify(String value) {
		this.declineOtherReasonSpecify = value;
	}
	
}
