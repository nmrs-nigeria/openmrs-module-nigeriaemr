package org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the
 * org.openmrs.module.nigeriaemr.model.nigeriaqualped.pediatricartregimensincestartingtreatment
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
	 * for package: org.openmrs.module.nigeriaemr.model.nigeriaqualped.
	 * pediatricartregimensincestartingtreatment
	 */
	public ObjectFactory() {
	}
	
	/**
	 * Create an instance of {@link PediatricARTRegimenSinceStartingTreatmentRecordDataSetType }
	 */
	public PediatricARTRegimenSinceStartingTreatmentRecordDataSetType createDataSetType() {
		return new PediatricARTRegimenSinceStartingTreatmentRecordDataSetType();
	}
	
	/**
	 * Create an instance of {@link PediatricARTRegimenSinceStartingTreatmentRecordType }
	 */
	public PediatricARTRegimenSinceStartingTreatmentRecordType createPediatricARTRegimenSinceStartingTreatmentRecordType() {
		return new PediatricARTRegimenSinceStartingTreatmentRecordType();
	}
	
	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link PediatricARTRegimenSinceStartingTreatmentRecordType }{@code >}
	 */
	@XmlElementDecl(namespace = "", name = "Data-set")
	public JAXBElement<PediatricARTRegimenSinceStartingTreatmentRecordDataSetType> createDataSet(
	        PediatricARTRegimenSinceStartingTreatmentRecordDataSetType value) {
		return new JAXBElement<PediatricARTRegimenSinceStartingTreatmentRecordDataSetType>(_DataSet_QNAME,
		        PediatricARTRegimenSinceStartingTreatmentRecordDataSetType.class, null, value);
	}
	
}
