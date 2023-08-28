/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.ndrUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonName;
import org.openmrs.module.nigeriaemr.omodmodels.Client;
import org.openmrs.module.nigeriaemr.omodmodels.CommunityTestersPayload;
import org.openmrs.module.nigeriaemr.omodmodels.TesterModel;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MORRISON.I
 */
public class GeneralMapper {
	
	public static TesterModel mapPayloadToCommunityTesters(CommunityTestersPayload payload) {
		
		TesterModel testers = new TesterModel();
		testers.setAssign_facilityId(payload.AssignedFacilityId);
		testers.setEmail(payload.getEmail());
		testers.setFacility_code(payload.getFacilityCode());
		testers.setFacility_name(payload.getFacilityName());
		testers.setLga(payload.getLga());
		testers.setLga_code(payload.getLgaCode());
		testers.setPhone_number(payload.getPhoneNumber());
		testers.setState(payload.getState());
		testers.setUsername(payload.getUsername());
		
		return testers;
		
	}
	
	public static List<TesterModel> mapPayloadToCommunityTestersList(List<CommunityTestersPayload> payloads) {
        List<TesterModel> response = new ArrayList<>();
        payloads.stream().forEach(a -> {
            response.add(mapPayloadToCommunityTesters(a));
        });
        return response;
    }
	
	public static ObjectMapper getCustomObjectMapper() {
		return new ObjectMapper() {
			
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			
			public String writeValue(Object value) {
				try {
					return mapper.writeValueAsString(value);
				}
				catch (JsonProcessingException ex) {
					Logger.getLogger(GeneralMapper.class.getName()).log(Level.SEVERE, null, ex);
				}
				return null;
			}
			
			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return mapper.readValue(value, valueType);
				}
				catch (IOException ex) {
					Logger.getLogger(GeneralMapper.class.getName()).log(Level.SEVERE, null, ex);
				}
				return null;
			}
		};
	}
	
	public static Person ClientToPerson(Client client){
            Person p = new Person();
            PersonAddress pd = new PersonAddress();
            pd.setCityVillage(client.getClientVillage());
            //client has no country
            pd.setCountry("Nigeria");
            pd.setCountyDistrict(client.getClientLga());
            pd.setStateProvince(client.getClientState());
            pd.setPreferred(Boolean.TRUE);
            pd.setUuid(UUID.randomUUID().toString());
          //  pd.setPerson(p);
            
            Set<PersonAddress> addr = new HashSet<>();
            addr.add(pd);
            
            Set<PersonName> pNameSet = new HashSet<>();
            PersonName pName = new PersonName();
            pName.setGivenName(client.getFirstName());
            pName.setFamilyName(client.getSurname());
            pName.setUuid(UUID.randomUUID().toString());
            pNameSet.add(pName);
            
            
            p.setNames(pNameSet);
            p.setAddresses(addr);
            p.setBirthdateEstimated(true);
            p.setBirthdateFromAge(Integer.parseInt(client.getAge()), new Date());
            p.setGender(client.getSex());
            p.setUuid(UUID.randomUUID().toString());
            
            
            //TODO
            
            return p;
            
        }
}
