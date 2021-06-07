package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the
 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod package.
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
	 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatriccotrimoxazolereportingperiod
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricCotrimoxazoleRecordDataSetType }
	 */
	public PediatricCotrimoxazoleRecordDataSetType createDataSetType() {
		return new PediatricCotrimoxazoleRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricCotrimoxazoleRecordType }
	 */
	public PediatricCotrimoxazoleRecordType createPediatricCotrimoxazoleRecordType() {
		return new PediatricCotrimoxazoleRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PediatricCotrimoxazoleRecordDataSetType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricCotrimoxazoleRecordDataSetType> createDataSet(PediatricCotrimoxazoleRecordDataSetType value) {
		return new JAXBElement<PediatricCotrimoxazoleRecordDataSetType>(_DataSet_QNAME,
		        PediatricCotrimoxazoleRecordDataSetType.class, null, value);
	}
	
}
