//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 11:46:26 AM WAT 
//

package org.openmrs.module.nigeriaemr.model.ndr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
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
