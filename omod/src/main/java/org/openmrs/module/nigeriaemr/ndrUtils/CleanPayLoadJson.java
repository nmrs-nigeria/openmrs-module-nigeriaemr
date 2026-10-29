package org.openmrs.module.nigeriaemr.ndrUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public class CleanPayLoadJson {
	
	public static String getCleanJSON(String jsonbody) throws Exception {
		String rawJson = jsonbody; // your raw JSON string
		String cleanJson;
		ObjectMapper mapper = new ObjectMapper();
		
		List<JsonNode> rootList = mapper.readValue(rawJson, new TypeReference<List<JsonNode>>() {});
		
		for (JsonNode rootItem : rootList) {
			JsonNode encounters = rootItem.get("encounters");
			if (encounters != null && encounters.isArray()) {
				for (JsonNode encounter : encounters) {
					JsonNode payloadNode = encounter.get("payload");
					if (payloadNode != null && payloadNode.isTextual()) {
						try {
							// ✅ Parse string payload as JSON
							JsonNode parsedPayload = mapper.readTree(payloadNode.asText());
							((ObjectNode) encounter).set("payload", parsedPayload);
						}
						catch (Exception e) {
							System.err.println("Failed to parse payload string: " + payloadNode.asText());
						}
					}
				}
			}
		}
		
		// Convert back to string
		cleanJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootList);
		return cleanJson;
	}
}
