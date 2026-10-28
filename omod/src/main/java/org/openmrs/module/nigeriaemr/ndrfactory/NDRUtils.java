package org.openmrs.module.nigeriaemr.ndrfactory;

import org.openmrs.module.nigeriaemr.ndrUtils.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NDRUtils {
	
	//Xerces property that returns the DOM element being validated when an error is reported
	private static final String CURRENT_ELEMENT_NODE = "http://apache.org/xml/properties/dom/current-element-node";
	
	//cap the rows written per patient so a badly broken record does not flood the error CSV
	private static final int MAX_ERRORS_PER_PATIENT = 50;
	
	public static Marshaller createMarshaller(JAXBContext jaxbContext, boolean skipError) throws JAXBException, SAXException {
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		jaxbMarshaller.setSchema(loadSchema());
		
		//Call Validator class to perform the validation
		jaxbMarshaller.setEventHandler(new Validator(skipError));
		return jaxbMarshaller;
		
	}
	
	private static Schema loadSchema() throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		java.net.URL xsdFilePath = Thread.currentThread().getContextClassLoader().getResource("NDR_XSD 1.7.2.0.xsd");
		
		assert xsdFilePath != null;
		
		return sf.newSchema(xsdFilePath);
	}
	
	/**
	 * A single schema violation, located against the visit (the nearest enclosing element that has
	 * a VisitDate child) it belongs to.
	 */
	public static class SchemaError {
		
		private final String visitDate;
		
		private final String visitId;
		
		private final String section;
		
		private final String message;
		
		SchemaError(String visitDate, String visitId, String section, String message) {
			this.visitDate = visitDate;
			this.visitId = visitId;
			this.section = section;
			this.message = message;
		}
		
		public String getVisitDate() {
			return visitDate;
		}
		
		public String getVisitId() {
			return visitId;
		}
		
		public String getSection() {
			return section;
		}
		
		public String getMessage() {
			return message;
		}
	}
	
	/**
	 * The marshaller stops at the first schema violation and reports only a line/column of a file
	 * that is never written. This re-marshals the container to a DOM without a schema, validates
	 * it, and returns every violation with the visit date/id and element path it occurred in.
	 */
	public static List<SchemaError> findSchemaErrors(JAXBContext jaxbContext, Object container) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		Document document = dbf.newDocumentBuilder().newDocument();
		jaxbContext.createMarshaller().marshal(container, document);

		final javax.xml.validation.Validator validator = loadSchema().newValidator();
		//keyed by element so the follow-up errors Xerces raises for one bad value end up on one row
		final Map<Node, List<String>> errorsByElement = new LinkedHashMap<>();
		final List<String> unlocated = new ArrayList<>();
		validator.setErrorHandler(new ErrorHandler() {

			@Override
			public void warning(SAXParseException exception) {
			}

			@Override
			public void error(SAXParseException exception) {
				collect(exception);
			}

			@Override
			public void fatalError(SAXParseException exception) {
				collect(exception);
			}

			private void collect(SAXParseException exception) {
				String message = cleanMessage(exception.getMessage());
				Node element = null;
				try {
					element = (Node) validator.getProperty(CURRENT_ELEMENT_NODE);
				}
				catch (Exception ignored) {
					//property not supported by this validator implementation
				}
				if (element == null) {
					unlocated.add(message);
					return;
				}
				List<String> messages = errorsByElement.get(element);
				if (messages == null) {
					if (errorsByElement.size() >= MAX_ERRORS_PER_PATIENT) {
						return;
					}
					messages = new ArrayList<>();
					errorsByElement.put(element, messages);
				}
				if (!messages.contains(message)) {
					messages.add(message);
				}
			}
		});
		validator.validate(new DOMSource(document));

		List<SchemaError> errors = new ArrayList<>();
		for (Map.Entry<Node, List<String>> entry : errorsByElement.entrySet()) {
			Node element = entry.getKey();
			Element visit = findVisit(element);
			String visitDate = visit != null ? childText(visit, "VisitDate") : "";
			String visitId = visit != null ? firstNonEmpty(childText(visit, "VisitID"), childText(visit, "VisitId")) : "";
			errors.add(new SchemaError(visitDate, visitId, elementPath(element), join(entry.getValue())));
		}
		for (String message : unlocated) {
			errors.add(new SchemaError("", "", "", message));
		}
		return errors;
	}
	
	private static Element findVisit(Node node) {
		for (Node current = node; current != null && current.getNodeType() == Node.ELEMENT_NODE; current = current
		        .getParentNode()) {
			if (childElement((Element) current, "VisitDate") != null) {
				return (Element) current;
			}
		}
		return null;
	}
	
	private static Element childElement(Element parent, String name) {
		for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
			if (child.getNodeType() == Node.ELEMENT_NODE && name.equals(localName(child))) {
				return (Element) child;
			}
		}
		return null;
	}
	
	private static String childText(Element parent, String name) {
		Element child = childElement(parent, name);
		return child != null ? child.getTextContent().trim() : "";
	}
	
	private static String elementPath(Node node) {
		StringBuilder path = new StringBuilder();
		for (Node current = node; current != null && current.getNodeType() == Node.ELEMENT_NODE; current = current
		        .getParentNode()) {
			//skip the Container root, it is the same for every row
			if (current.getParentNode() == null || current.getParentNode().getNodeType() != Node.ELEMENT_NODE) {
				break;
			}
			path.insert(0, path.length() > 0 ? localName(current) + "/" : localName(current));
		}
		return path.toString();
	}
	
	private static String localName(Node node) {
		return node.getLocalName() != null ? node.getLocalName() : node.getNodeName();
	}
	
	//drops the Xerces rule code, e.g. "cvc-pattern-valid: Value ..." -> "Value ..."
	private static String cleanMessage(String message) {
		return message == null ? "" : message.replaceFirst("^cvc-[\\w.-]+:\\s*", "");
	}
	
	private static String firstNonEmpty(String a, String b) {
		return a != null && !a.isEmpty() ? a : b;
	}
	
	private static String join(List<String> messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			if (sb.length() > 0)
				sb.append(" | ");
			sb.append(message);
		}
		return sb.toString();
	}
}
