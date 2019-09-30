/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.nigeriaemr.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openmrs.module.nigeriaemr.dbmanager.NdrDBManager;
import org.openmrs.module.nigeriaemr.omodmodels.FacilityLocation;
import org.openmrs.module.nigeriaemr.omodmodels.PatientLocation;

/**
 *
 * @author MORRISON.I
 */
public class FacilityLocationService {

    NdrDBManager dbManageer = null;

    public List<FacilityLocation> getAllFacilityLocations() {

        List<FacilityLocation> response = new ArrayList<>();

        try {
            dbManageer = new NdrDBManager();
            dbManageer.openConnection();
            response = dbManageer.getFacilityLocationByLocationId();
            dbManageer.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PatientContacts.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
    
    
    public List<PatientLocation> getAllPatientLocation(){
       
        List<PatientLocation> patientLocations = new ArrayList<>();
        
         try {
            dbManageer = new NdrDBManager();
            dbManageer.openConnection();
            patientLocations = dbManageer.getPatientLocation();
            dbManageer.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PatientContacts.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patientLocations;
    
    }

}
