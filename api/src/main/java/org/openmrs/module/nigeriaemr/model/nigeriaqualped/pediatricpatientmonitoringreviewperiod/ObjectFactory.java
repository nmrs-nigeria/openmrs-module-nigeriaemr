package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the
 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod
 * package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation
 * for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {
	
	private final static QName _DataSet_QNAME = new QName("", "Data-set");
	
	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes
	 * for package:
	 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientmonitoringreviewperiod
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType }
	 */
	public PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType createDataSetType() {
		return new PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricPatientMonitoringDuringReviewPeriodRecordType }
	 */
	public PediatricPatientMonitoringDuringReviewPeriodRecordType createPediatricPatientMonitoringDuringReviewPeriodRecordType() {
		return new PediatricPatientMonitoringDuringReviewPeriodRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType> createDataSet(
	        PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType value) {
		return new JAXBElement<PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType>(_DataSet_QNAME,
		        PediatricPatientMonitoringDuringReviewPeriodRecordDataSetType.class, null, value);
	}
	
}
