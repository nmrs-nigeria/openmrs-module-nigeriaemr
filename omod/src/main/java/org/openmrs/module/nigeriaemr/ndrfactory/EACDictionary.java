package org.openmrs.module.nigeriaemr.ndrfactory;


import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.nigeriaemr.fragment.controller.NdrFragmentController;
import org.openmrs.module.nigeriaemr.model.ndr.*;
import org.openmrs.module.nigeriaemr.model.ndr.EACType;
import org.openmrs.module.nigeriaemr.ndrUtils.ConstantsUtil;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogFormat;
import org.openmrs.module.nigeriaemr.ndrUtils.LoggerUtils.LogLevel;
import org.openmrs.module.nigeriaemr.ndrUtils.Utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.openmrs.module.nigeriaemr.ndrUtils.Utils.extractObs;

public class EACDictionary {

    Utils utils = new Utils();

    public EACDictionary(){loadDictionary();}
    private Map<Integer, String> eacSessionMap = new HashMap<>();
    private Map<Integer, String> arvPlanMap = new HashMap<>();

    public void loadDictionary(){

        //eacSessionType map
        eacSessionMap.put(165643,"FS");
        eacSessionMap.put(165644,"SS");
        eacSessionMap.put(165645,"TS");
        eacSessionMap.put(5622,"OS");

        //arv plan map
        arvPlanMap.put(165357,"AV1");
        arvPlanMap.put(1257,"AV2");
        arvPlanMap.put(165769,"AV3");
        arvPlanMap.put(165768,"AV4");
        arvPlanMap.put(165770,"AV5");
        arvPlanMap.put(162904,"AV6");

    }

    public List<EACType> createEACTypeList(Patient patient, Map<Integer,List<Encounter>> groupedEncounters)throws DatatypeConfigurationException {

        List<EACType> eacTypeList = new ArrayList<EACType>();

        EACType eacType = null;
        List<Obs> obsPerVisit = null;
        List<Encounter> allEACEncounterForPatient = groupedEncounters.get(Utils.EAC_ENCOUNTER_TYPE);
        if(allEACEncounterForPatient != null) {
            for (Encounter enc : allEACEncounterForPatient) {

                Date visitDate = DateUtils.truncate(enc.getEncounterDatetime(), Calendar.DATE);
                obsPerVisit =  new ArrayList<>(enc.getAllObs());

                eacType = createEACType(patient, visitDate, obsPerVisit);
                eacTypeList.add(eacType);
            }
        }
        return eacTypeList;
        
    }

    private EACType createEACType(Patient patient, Date visitDate, List<Obs> obsPerVisit) throws DatatypeConfigurationException{

        String visitID = "";
        EACType eacType = new EACType();
        PatientIdentifier pepfarIdentifier = patient.getPatientIdentifier(Utils.PEPFAR_IDENTIFIER_INDEX);
        String pepfarID = "";
        Obs obs = null;
        int valueCoded = 0;

        String EACSessionType ="";

        DateTime assessmentDate = null;

        Map<Object, List<Obs>> obsListForOneVisit = Utils.groupedByConceptIdsOnly(obsPerVisit);
        pepfarID = pepfarIdentifier.getIdentifier();
        //visitID
         visitID = Utils.getVisitId(pepfarID, visitDate);
         eacType.setVisitID(visitID);

         //Visitdate
        eacType.setVisitDate(utils.getXmlDate(visitDate));

        //Assessment Date
//        obs = Utils.extractObs(0000, obsListForOneVisit);
//        if (obs != null) {
//            assessmentDate = new DateTime(obs.getValueDate());
//            eacType.setAssessmentDate(utils.getXmlDate(assessmentDate.toDate()));
//
//        }

        eacType.setAssessmentDate(utils.getXmlDate(visitDate));

        obs = Utils.extractObs(166097, obsListForOneVisit);
        //Verify that all value coded concepts has been mapped
//        if (obs != null && obs.getValueCoded() != null) {
//            valueCoded = obs.getValueCoded().getConceptId();
//            EACSessionType = getMappedValue(valueCoded);
//            eacType.getEACSessionType(EACSessionType);
//        }




        return eacType;

    }


    public String getMappedValue(int conceptID) {
        if (eacSessionMap.containsKey(conceptID)) {
            return eacSessionMap.get(conceptID);
        }
        return null;
    }


}
