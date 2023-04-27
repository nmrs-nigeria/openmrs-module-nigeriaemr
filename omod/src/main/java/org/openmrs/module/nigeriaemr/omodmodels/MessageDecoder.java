package org.openmrs.module.nigeriaemr.omodmodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

public class MessageDecoder implements Decoder.Text<Realtime> {
	
	@Override
	public Realtime decode(String s) throws DecodeException {
		Realtime message;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			message = mapper.readValue(s, Realtime.class);
			System.out.println("Received Message: " + message.totalBatches);
			return message;
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			return new Realtime();
		}
		catch (IOException e) {
			e.printStackTrace();
			return new Realtime();
		}
	}
	
	@Override
	public boolean willDecode(String s) {
		return (s != null);
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
