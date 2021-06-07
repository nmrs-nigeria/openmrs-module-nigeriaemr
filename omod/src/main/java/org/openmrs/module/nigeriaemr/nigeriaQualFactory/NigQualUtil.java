package org.openmrs.module.nigeriaemr.nigeriaQualFactory;

import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.ndrUtils.CustomErrorHandler;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;
import org.openmrs.module.nigeriaemr.ndrUtils.Validator;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class NigQualUtil {
	
	public static List<Patient> generatePaediatricPatientListing() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,-15);

	 List<Patient> patients =  Context.getPatientService().getAllPatients().stream()
				.filter(x-> x.getBirthdate().after(cal.getTime())
						&& Utils.getHIVEnrollmentObs(x) !=null)
				.collect(Collectors.toList());



	 return patients;
	}
	
	public static List<Patient>generateAdultPatientListing() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,-15);

		List<Patient> patients =  Context.getPatientService().getAllPatients().stream()
				.filter(x-> x.getBirthdate().before(cal.getTime()))
				.collect(Collectors.toList());

		return patients;
	}
	
	private static Marshaller createMarshaller(JAXBContext jaxbContext, String xsd) throws JAXBException, SAXException {
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		java.net.URL xsdFilePath = Thread.currentThread().getContextClassLoader().getResource(xsd);
		assert xsdFilePath != null;
		
		Schema schema = sf.newSchema(xsdFilePath);
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		jaxbMarshaller.setSchema(schema);
		
		//Call Validator class to perform the validation
		jaxbMarshaller.setEventHandler(new Validator());
		return jaxbMarshaller;
	}
	
	public static void createXMLFile(Object data, String xmlFile, String xsdContextPath, String xsdFileName)
	        throws IOException, SAXException, JAXBException {
		
		Boolean b;
		File aXMLFile = new File(xmlFile);
		if (aXMLFile.exists()) {
			b = aXMLFile.delete();
			System.out.println("previous file : " + xmlFile + "was deleted successful : " + b);
		}
		b = aXMLFile.createNewFile();
		
		System.out.println("creating file : " + xmlFile + "was successful : " + b);
		CustomErrorHandler errorHandler = new CustomErrorHandler();
		JAXBContext jaxbContext = JAXBContext.newInstance(xsdContextPath);
		
		Marshaller jaxbMarshaller = createMarshaller(jaxbContext, xsdFileName);
		
		javax.xml.validation.Validator validator = jaxbMarshaller.getSchema().newValidator();
		jaxbMarshaller.marshal(data, aXMLFile);
		validator.setErrorHandler(errorHandler);
		validator.validate(new StreamSource(aXMLFile));
	}
	
	public static String getWHOStageNumber(Obs whoObs) {
		String whoStage = "";
		if (whoObs != null) {
			switch (whoObs.getValueCoded().getConceptId()) {
				case 1204:
					whoStage = "1";
					break;
				case 1220:
					whoStage = "1";
					break;
				case 1205:
					whoStage = "2";
					break;
				case 1221:
					whoStage = "2";
					break;
				case 1206:
					whoStage = "3";
					break;
				case 1222:
					whoStage = "3";
					break;
				case 1207:
					whoStage = "4";
					break;
				case 1223:
					whoStage = "4";
					break;
			}
		}
		return whoStage;
	}
	
	public int getSampleSize(int patientLoad) {
		int size = 0;
		if (patientLoad <= 20) {
			size = patientLoad;
		} else if (patientLoad <= 30) {
			size = 26;
		} else if (patientLoad <= 40) {
			size = 32;
		} else if (patientLoad <= 50) {
			size = 38;
		} else if (patientLoad <= 60) {
			size = 43;
		} else if (patientLoad <= 70) {
			size = 48;
		} else if (patientLoad <= 80) {
			size = 53;
		} else if (patientLoad <= 90) {
			size = 57;
		} else if (patientLoad <= 100) {
			size = 61;
		} else if (patientLoad > 101 && patientLoad <= 119) {
			size = 67;
		} else if (patientLoad >= 120 && patientLoad <= 139) {
			size = 73;
		} else if (patientLoad >= 140 && patientLoad <= 159) {
			size = 78;
		} else if (patientLoad >= 160 && patientLoad <= 179) {
			size = 82;
		} else if (patientLoad >= 180 && patientLoad <= 199) {
			size = 86;
		} else if (patientLoad >= 200 && patientLoad <= 249) {
			size = 94;
		} else if (patientLoad >= 250 && patientLoad <= 299) {
			size = 101;
		} else if (patientLoad >= 300 && patientLoad <= 349) {
			size = 106;
		} else if (patientLoad >= 350 && patientLoad <= 399) {
			size = 110;
		} else if (patientLoad >= 400 && patientLoad <= 449) {
			size = 113;
		} else if (patientLoad >= 450 && patientLoad <= 499) {
			size = 116;
		} else if (patientLoad >= 500 && patientLoad <= 749) {
			size = 127;
		} else if (patientLoad >= 750 && patientLoad <= 999) {
			size = 131;
		} else if (patientLoad >= 1000 && patientLoad <= 4999) {
			size = 146;
		} else if (patientLoad >= 5000) {
			size = 150;
		} else {
			size = (int) Math.round(patientLoad * 0.7);
		}
		return size;
	}
}
