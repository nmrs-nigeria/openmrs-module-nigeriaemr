package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for HIVRiskAssessmentType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVRiskAssessmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EverHadSexualIntercourse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BloodTransfussionInLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnprotectedSexWithCasualPartnerinLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnprotectedSexWithRegularPartnerInLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MoreThan1SexPartnerDuringLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="STIInLast3Months" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SexUnderInfluenceOfDrugsOrAlcohol" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UnprotectedVaginalSex" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVRiskAssessmentType", propOrder = { "everHadSexualIntercourse", "bloodTransfussionInLast3Months",
        "unprotectedSexWithCasualPartnerinLast3Months", "unprotectedSexWithRegularPartnerInLast3Months",
        "moreThan1SexPartnerDuringLast3Months", "stiInLast3Months", "sexUnderInfluenceOfDrugsOrAlcohol",
        "unprotectedVaginalSex" })
public class HIVRiskAssessmentType {
	
	@XmlElement(name = "EverHadSexualIntercourse")
	protected Boolean everHadSexualIntercourse;
	
	@XmlElement(name = "BloodTransfussionInLast3Months")
	protected Boolean bloodTransfussionInLast3Months;
	
	@XmlElement(name = "UnprotectedSexWithCasualPartnerinLast3Months")
	protected Boolean unprotectedSexWithCasualPartnerinLast3Months;
	
	@XmlElement(name = "UnprotectedSexWithRegularPartnerInLast3Months")
	protected Boolean unprotectedSexWithRegularPartnerInLast3Months;
	
	@XmlElement(name = "MoreThan1SexPartnerDuringLast3Months")
	protected Boolean moreThan1SexPartnerDuringLast3Months;
	
	@XmlElement(name = "STIInLast3Months")
	protected Boolean stiInLast3Months;
	
	@XmlElement(name = "SexUnderInfluenceOfDrugsOrAlcohol")
	protected Boolean sexUnderInfluenceOfDrugsOrAlcohol;
	
	@XmlElement(name = "UnprotectedVaginalSex")
	protected Boolean unprotectedVaginalSex;
	
	/**
	 * Gets the value of the everHadSexualIntercourse property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isEverHadSexualIntercourse() {
		return everHadSexualIntercourse;
	}
	
	/**
	 * Sets the value of the everHadSexualIntercourse property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setEverHadSexualIntercourse(Boolean value) {
		this.everHadSexualIntercourse = value;
	}
	
	/**
	 * Gets the value of the bloodTransfussionInLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isBloodTransfussionInLast3Months() {
		return bloodTransfussionInLast3Months;
	}
	
	/**
	 * Sets the value of the bloodTransfussionInLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setBloodTransfussionInLast3Months(Boolean value) {
		this.bloodTransfussionInLast3Months = value;
	}
	
	/**
	 * Gets the value of the unprotectedSexWithCasualPartnerinLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUnprotectedSexWithCasualPartnerinLast3Months() {
		return unprotectedSexWithCasualPartnerinLast3Months;
	}
	
	/**
	 * Sets the value of the unprotectedSexWithCasualPartnerinLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUnprotectedSexWithCasualPartnerinLast3Months(Boolean value) {
		this.unprotectedSexWithCasualPartnerinLast3Months = value;
	}
	
	/**
	 * Gets the value of the unprotectedSexWithRegularPartnerInLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUnprotectedSexWithRegularPartnerInLast3Months() {
		return unprotectedSexWithRegularPartnerInLast3Months;
	}
	
	/**
	 * Sets the value of the unprotectedSexWithRegularPartnerInLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUnprotectedSexWithRegularPartnerInLast3Months(Boolean value) {
		this.unprotectedSexWithRegularPartnerInLast3Months = value;
	}
	
	/**
	 * Gets the value of the moreThan1SexPartnerDuringLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isMoreThan1SexPartnerDuringLast3Months() {
		return moreThan1SexPartnerDuringLast3Months;
	}
	
	/**
	 * Sets the value of the moreThan1SexPartnerDuringLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setMoreThan1SexPartnerDuringLast3Months(Boolean value) {
		this.moreThan1SexPartnerDuringLast3Months = value;
	}
	
	/**
	 * Gets the value of the stiInLast3Months property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSTIInLast3Months() {
		return stiInLast3Months;
	}
	
	/**
	 * Sets the value of the stiInLast3Months property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSTIInLast3Months(Boolean value) {
		this.stiInLast3Months = value;
	}
	
	/**
	 * Gets the value of the sexUnderInfluenceOfDrugsOrAlcohol property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isSexUnderInfluenceOfDrugsOrAlcohol() {
		return sexUnderInfluenceOfDrugsOrAlcohol;
	}
	
	/**
	 * Sets the value of the sexUnderInfluenceOfDrugsOrAlcohol property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setSexUnderInfluenceOfDrugsOrAlcohol(Boolean value) {
		this.sexUnderInfluenceOfDrugsOrAlcohol = value;
	}
	
	/**
	 * Gets the value of the unprotectedVaginalSex property.
	 * 
	 * @return possible object is {@link Boolean }
	 */
	public Boolean isUnprotectedVaginalSex() {
		return unprotectedVaginalSex;
	}
	
	/**
	 * Sets the value of the unprotectedVaginalSex property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 */
	public void setUnprotectedVaginalSex(Boolean value) {
		this.unprotectedVaginalSex = value;
	}
	
}
