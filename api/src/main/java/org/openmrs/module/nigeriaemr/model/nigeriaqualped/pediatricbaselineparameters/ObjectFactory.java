package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters
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
	 * for package: org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricbaselineparameters
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricBaselineParametersRecordDataSetType }
	 */
	public PediatricBaselineParametersRecordDataSetType createDataSetType() {
		return new PediatricBaselineParametersRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricBaselineParametersRecordType }
	 */
	public PediatricBaselineParametersRecordType createPediatricBaselineParametersRecordType() {
		return new PediatricBaselineParametersRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PediatricBaselineParametersRecordDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricBaselineParametersRecordDataSetType> createDataSet(
	        PediatricBaselineParametersRecordDataSetType value) {
		return new JAXBElement<PediatricBaselineParametersRecordDataSetType>(_DataSet_QNAME,
		        PediatricBaselineParametersRecordDataSetType.class, null, value);
	}
	
}
