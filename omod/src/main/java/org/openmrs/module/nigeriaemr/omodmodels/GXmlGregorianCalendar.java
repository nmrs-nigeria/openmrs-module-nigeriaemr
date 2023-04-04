package org.openmrs.module.nigeriaemr.omodmodels;

import com.google.gson.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;

public class GXmlGregorianCalendar {
	
	public static class Serializer implements JsonSerializer<XMLGregorianCalendar> {
		
		@Override
		public JsonElement serialize(XMLGregorianCalendar xmlGregorianCalendar, Type type,
		        JsonSerializationContext jsonSerializationContext) {
			return new JsonPrimitive(xmlGregorianCalendar.toXMLFormat());
		}
	}
	
	public static class Deserializer implements JsonDeserializer<XMLGregorianCalendar> {
		
		@Override
		public XMLGregorianCalendar deserialize(JsonElement jsonElement, Type type,
		        JsonDeserializationContext jsonDeserializationContext) {
			try {
				return DatatypeFactory.newInstance().newXMLGregorianCalendar(jsonElement.getAsString());
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
