package org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the
 * org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod package.
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
	 * for package:
	 * org.openmrs.module.nigeriaemr.model.nigeriaqual.clinicalevaluationvisitsinreviewperiod
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType }
	 */
	public ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType createDataSetType() {
		return new ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link ClinicalEvaluationVisitsInReviewPeriodRecordType }
	 */
	public ClinicalEvaluationVisitsInReviewPeriodRecordType createClinicalEvaluationVisitsInReviewPeriodRecordType() {
		return new ClinicalEvaluationVisitsInReviewPeriodRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "data-set")
	public JAXBElement<ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType> createDataSet(
	        ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType value) {
		return new JAXBElement<ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType>(_DataSet_QNAME,
		        ClinicalEvaluationVisitsInReviewPeriodRecordDataSetType.class, null, value);
	}
	
}
