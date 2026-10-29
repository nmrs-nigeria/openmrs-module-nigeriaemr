package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for HIVTestResultType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HIVTestResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TestResult" type="{}TestResultType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIVTestResultType", propOrder = { "testResult" })
public class HIVTestResultType {
	
	@XmlElement(name = "TestResult")
	protected TestResultType testResult;
	
	/**
	 * Gets the value of the testResult property.
	 * 
	 * @return possible object is {@link TestResultType }
	 */
	public TestResultType getTestResult() {
		return testResult;
	}
	
	/**
	 * Sets the value of the testResult property.
	 * 
	 * @param value allowed object is {@link TestResultType }
	 */
	public void setTestResult(TestResultType value) {
		this.testResult = value;
	}
	
}
