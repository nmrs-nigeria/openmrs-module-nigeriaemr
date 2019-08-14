package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation package.
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
	 * for package: org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriceducation
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricEducationRecordDataSetType }
	 */
	public PediatricEducationRecordDataSetType createDataSetType() {
		return new PediatricEducationRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricEducationRecordType }
	 */
	public PediatricEducationRecordType createPediatricEducationRecordType() {
		return new PediatricEducationRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PediatricEducationRecordDataSetType }
	 * {@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricEducationRecordDataSetType> createDataSet(PediatricEducationRecordDataSetType value) {
		return new JAXBElement<PediatricEducationRecordDataSetType>(_DataSet_QNAME,
		        PediatricEducationRecordDataSetType.class, null, value);
	}
	
}
