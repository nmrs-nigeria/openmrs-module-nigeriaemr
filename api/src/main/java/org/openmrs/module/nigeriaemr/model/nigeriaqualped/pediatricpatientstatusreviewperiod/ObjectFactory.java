package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the
 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod package.
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
	 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricpatientstatusreviewperiod
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricPatientStatusRecordDataSetType }
	 */
	public PediatricPatientStatusRecordDataSetType createDataSetType() {
		return new PediatricPatientStatusRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricPatientStatusRecordType }
	 */
	public PediatricPatientStatusRecordType createPediatricPatientStatusRecordType() {
		return new PediatricPatientStatusRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PediatricPatientStatusRecordDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricPatientStatusRecordDataSetType> createDataSet(PediatricPatientStatusRecordDataSetType value) {
		return new JAXBElement<PediatricPatientStatusRecordDataSetType>(_DataSet_QNAME,
		        PediatricPatientStatusRecordDataSetType.class, null, value);
	}
	
}
