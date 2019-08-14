package org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters package.
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
	 * for package: org.openmrs.module.nigeriaemr.model.nigeriaqual.baselineparameters
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link BaselineParametersRecordDataSetType }
	 */
	public BaselineParametersRecordDataSetType createDataSetType() {
		return new BaselineParametersRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link BaselineParametersRecordType }
	 */
	public BaselineParametersRecordType createBaselineParametersRecordType() {
		return new BaselineParametersRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BaselineParametersRecordDataSetType }
	 * {@code >}
	 */
	@XmlElementDecl(namespace = "", name = "data-set")
	public JAXBElement<BaselineParametersRecordDataSetType> createDataSet(BaselineParametersRecordDataSetType value) {
		return new JAXBElement<BaselineParametersRecordDataSetType>(_DataSet_QNAME,
		        BaselineParametersRecordDataSetType.class, null, value);
	}
	
}
