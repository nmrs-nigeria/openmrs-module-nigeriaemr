package org.openmrs.module.nigeriaemr.omodmodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Realtime> {
	
	@Override
	public String encode(Realtime message) throws EncodeException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			String json = mapper.writeValueAsString(message);
			System.out.println("ResultingJSONstring = " + json);
			return json;
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@Override
	public void init(EndpointConfig endpointConfig) {
		// Custom initialization logic
	}
	
	@Override
	public void destroy() {
		// Close resources
	}
}
