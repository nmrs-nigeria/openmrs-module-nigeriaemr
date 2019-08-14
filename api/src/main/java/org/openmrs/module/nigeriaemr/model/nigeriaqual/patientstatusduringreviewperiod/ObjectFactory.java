package org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod
 * package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation
 * for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {
	
	private final static QName _DataSet_QNAME = new QName("", "data-set");
	
	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes
	 * for package: org.openmrs.module.nigeriaemr.model.nigeriaqual.patientstatusduringreviewperiod
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PatientStatusDuringReviewPeriodDataSetType }
	 */
	public PatientStatusDuringReviewPeriodDataSetType createDataSetType() {
		return new PatientStatusDuringReviewPeriodDataSetType();
	}
	
	/**
	 * Create an instance of {@link PatientStatusDuringReviewPeriodRecordType }
	 */
	public PatientStatusDuringReviewPeriodRecordType createPatientStatusDuringReviewPeriodRecordType() {
		return new PatientStatusDuringReviewPeriodRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PatientStatusDuringReviewPeriodDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "data-set")
	public JAXBElement<PatientStatusDuringReviewPeriodDataSetType> createDataSet(
	        PatientStatusDuringReviewPeriodDataSetType value) {
		return new JAXBElement<PatientStatusDuringReviewPeriodDataSetType>(_DataSet_QNAME,
		        PatientStatusDuringReviewPeriodDataSetType.class, null, value);
	}
	
}
