package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMTCTType", propOrder = { "healthFacilityVisitTypes", "maternalCohortType" })
public class PMTCTType {
	
	@XmlElement(name = "HealthFacilityVisits")
	protected List<HealthFacilityVisitsType> healthFacilityVisitTypes;
	
	@XmlElement(name = "MaternalCohort")
	protected MaternalCohortType maternalCohortType;
	
	public List<HealthFacilityVisitsType> getHealthFacilityVisitTypes() {
		return healthFacilityVisitTypes;
	}
	
	public void setHealthFacilityVisitTypes(List<HealthFacilityVisitsType> healthFacilityVisitTypes) {
		this.healthFacilityVisitTypes = healthFacilityVisitTypes;
	}
	
	public MaternalCohortType getMaternalCohortType() {
		return maternalCohortType;
	}
	
	public void setMaternalCohortType(MaternalCohortType maternalCohortType) {
		this.maternalCohortType = maternalCohortType;
	}
	
}
