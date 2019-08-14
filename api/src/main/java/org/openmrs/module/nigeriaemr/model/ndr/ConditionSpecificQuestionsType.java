package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ConditionSpecificQuestionsType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionSpecificQuestionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="HIVQuestions" type="{}HIVQuestionsType" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionSpecificQuestionsType", propOrder = { "hivQuestions" })
public class ConditionSpecificQuestionsType {
	
	@XmlElement(name = "HIVQuestions")
	protected HIVQuestionsType hivQuestions;
	
	/**
	 * Gets the value of the hivQuestions property.
	 * 
	 * @return possible object is {@link HIVQuestionsType }
	 */
	public HIVQuestionsType getHIVQuestions() {
		return hivQuestions;
	}
	
	/**
	 * Sets the value of the hivQuestions property.
	 * 
	 * @param value allowed object is {@link HIVQuestionsType }
	 */
	public void setHIVQuestions(HIVQuestionsType value) {
		this.hivQuestions = value;
	}
	
}
