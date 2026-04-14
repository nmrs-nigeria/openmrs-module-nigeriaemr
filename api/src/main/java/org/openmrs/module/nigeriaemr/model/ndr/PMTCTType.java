package org.openmrs.module.nigeriaemr.model.ndr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTType", propOrder = { "immunizationTypes", "deliveryEncounterTypes", "antenatalRegistrationTypes",
        "childBirthDetailsTypes", "childFollowupTypes", "infantPCRTestingTypes", "healthFacilityVisitTypes",
        "partnerDetailsTypes", "InfantRapidTestTypes", "maternalCohortTypes", "pmtctHTSTYPES" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class PMTCTType {
	
	@XmlElement(name = "Immunization")
	protected List<ImmunizationType> immunizationTypes;
	
	@XmlElement(name = "DeliveryEncounter")
	protected List<DeliveryEncounterType> deliveryEncounterTypes;
	
	@XmlElement(name = "AntenatalRegistration")
	protected List<AntenatalRegistrationType> antenatalRegistrationTypes;
	
	@XmlElement(name = "ChildBirthDetails")
	protected List<ChildBirthDetailsType> childBirthDetailsTypes;
	
	@XmlElement(name = "ChildFollowup")
	protected List<ChildFollowupType> childFollowupTypes;
	
	@XmlElement(name = "InfantPCRTesting")
	protected List<InfantPCRTestingType> infantPCRTestingTypes;
	
	@XmlElement(name = "HealthFacilityVisits")
	protected List<HealthFacilityVisitsType> healthFacilityVisitTypes;
	
	@XmlElement(name = "PartnerDetails")
	protected List<PartnerDetailsType> partnerDetailsTypes;
	
	@XmlElement(name = "InfantRapidTest")
	protected List<InfantRapidTestType> InfantRapidTestTypes;
	
	@XmlElement(name = "MaternalCohort")
	protected List<MaternalCohortType> maternalCohortTypes;
	
	@XmlElement(name = "PMTCTHTS")
	protected List<PMTCTHTSType> pmtctHTSTYPES;
	
	public List<ImmunizationType> getImmunizationTypes() {
		return immunizationTypes;
	}
	
	public void setImmunizationTypes(List<ImmunizationType> immunizationTypes) {
		this.immunizationTypes = immunizationTypes;
	}
	
	public List<DeliveryEncounterType> getDeliveryEncounterTypes() {
		return deliveryEncounterTypes;
	}
	
	public void setDeliveryEncounterTypes(List<DeliveryEncounterType> deliveryEncounterTypes) {
		this.deliveryEncounterTypes = deliveryEncounterTypes;
	}
	
	public List<AntenatalRegistrationType> getAntenatalRegistrationTypes() {
		return antenatalRegistrationTypes;
	}
	
	public void setAntenatalRegistrationTypes(List<AntenatalRegistrationType> antenatalRegistrationTypes) {
		this.antenatalRegistrationTypes = antenatalRegistrationTypes;
	}
	
	public List<ChildBirthDetailsType> getChildBirthDetailsTypes() {
		return childBirthDetailsTypes;
	}
	
	public void setChildBirthDetailsTypes(List<ChildBirthDetailsType> childBirthDetailsTypes) {
		this.childBirthDetailsTypes = childBirthDetailsTypes;
	}
	
	public List<ChildFollowupType> getChildFollowupTypes() {
		return childFollowupTypes;
	}
	
	public void setChildFollowupTypes(List<ChildFollowupType> childFollowupTypes) {
		this.childFollowupTypes = childFollowupTypes;
	}
	
	public List<InfantPCRTestingType> getInfantPCRTestingTypes() {
		return infantPCRTestingTypes;
	}
	
	public void setInfantPCRTestingTypes(List<InfantPCRTestingType> infantPCRTestingTypes) {
		this.infantPCRTestingTypes = infantPCRTestingTypes;
	}
	
	public List<HealthFacilityVisitsType> getHealthFacilityVisitTypes() {
		return healthFacilityVisitTypes;
	}
	
	public void setHealthFacilityVisitTypes(List<HealthFacilityVisitsType> healthFacilityVisitTypes) {
		this.healthFacilityVisitTypes = healthFacilityVisitTypes;
	}
	
	public List<PartnerDetailsType> getPartnerDetailsTypes() {
		return partnerDetailsTypes;
	}
	
	public void setPartnerDetailsTypes(List<PartnerDetailsType> partnerDetailsTypes) {
		this.partnerDetailsTypes = partnerDetailsTypes;
	}
	
	public List<InfantRapidTestType> getInfantRapidTestTypes() {
		return InfantRapidTestTypes;
	}
	
	public void setInfantRapidTestTypes(List<InfantRapidTestType> infantRapidTestTypes) {
		InfantRapidTestTypes = infantRapidTestTypes;
	}
	
	public List<MaternalCohortType> getMaternalCohortTypes() {
		return maternalCohortTypes;
	}
	
	public void setMaternalCohortTypes(List<MaternalCohortType> maternalCohortTypes) {
		this.maternalCohortTypes = maternalCohortTypes;
	}
	
	public List<PMTCTHTSType> getPmtctHTSTYPES() {
		return pmtctHTSTYPES;
	}
	
	public void setPmtctHTSTYPES(List<PMTCTHTSType> pmtctHTSTYPES) {
		this.pmtctHTSTYPES = pmtctHTSTYPES;
	}
}
