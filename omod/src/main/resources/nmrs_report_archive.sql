-- HTS_TST (Includes HTS_TST_POS)

select
pid3.identifier as ClientCode,
pid1.identifier AS PepfarID,
-- pid2.identifier AS HospID,
pn3.given_name AS FirstName,
pn3.family_name AS FamilyName,
person.gender AS Sex,
psn_atr.value AS PhoneNo,
person.birthdate AS DOB,
TIMESTAMPDIFF(YEAR,person.birthdate,CURDATE()) AS Age,
patient_program.date_enrolled AS EnrollDate
,MAX(IF(target.concept_id=165843, cn1.name, NULL)) AS  `FinalResult`
-- ,MAX(IF(sinner.concept_id=165843, IF(obs.value_coded=703,'POSITIVE','NEGATIVE'), NULL)) AS  `FinalResult`
FROM patient
LEFT JOIN patient_identifier pid1 ON(pid1.patient_id=patient .patient_id AND pid1.identifier_type=4  AND pid1.voided=0)
LEFT JOIN patient_identifier pid2 ON(pid2.patient_id=patient .patient_id AND pid2.identifier_type=5 AND pid2.voided=0)
LEFT JOIN patient_identifier pid3 ON(pid3.patient_id=patient .patient_id AND pid3.identifier_type=8 AND pid2.voided=0)
LEFT JOIN person_name pn3 ON(patient .patient_id=pn3.person_id AND pn3.voided=0)
LEFT JOIN person ON(person.person_id=patient .patient_id)
LEFT JOIN person_attribute psn_atr ON (person.person_id=psn_atr.person_id) 
LEFT JOIN patient_program ON(patient_program.patient_id=person.person_id AND patient_program.voided=0)
LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MAX(obs.obs_datetime) AS last_date FROM obs GROUP BY obs.person_id, obs.concept_id)
target ON (target.person_id=patient.patient_id)
INNER JOIN obs ON(obs.person_id=target.person_id AND obs.concept_id=target.concept_id AND obs.obs_datetime=target.last_date AND obs.concept_id IN(165843))
LEFT JOIN concept_name cn1 ON(obs.value_coded=cn1.concept_id AND cn1.locale='en' AND cn1.locale_preferred=1)
LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MIN(obs.obs_datetime) AS first_date FROM obs GROUP BY obs.person_id, obs.concept_id)
smin ON (smin.person_id=patient.patient_id)
INNER JOIN obs obs2 ON(obs2.person_id=smin.person_id AND obs2.concept_id=smin.concept_id AND obs2.obs_datetime=smin.first_date AND obs2.concept_id IN(165843))
LEFT JOIN concept_name cn2 ON(obs2.value_coded=cn2.concept_id AND cn2.locale='en' AND cn2.locale_preferred=1)
WHERE patient.voided=0 
GROUP BY patient.patient_id



-- TX_CURR

SELECT
patient.patient_id,
pid1.identifier AS PepfarID,
pid2.identifier AS HospID,
pn3.given_name AS FirstName,
pn3.family_name AS FamilyName,
person.gender AS Sex,
psn_atr.value AS PhoneNo,
person.birthdate AS DOB,
TIMESTAMPDIFF(YEAR,person.birthdate,CURDATE()) AS Age
,MAX(IF(target.concept_id=164989, target.last_date, NULL)) AS  `DrugPickUpDate`
,MAX(IF(target.concept_id=165050, cn1.name, NULL)) AS  `PregnancyStatus`
 ,MAX(IF(target.concept_id=165720, cn1.name, NULL)) AS  `TreatmentAgeCategory`
 ,MAX(IF(target.concept_id=165945 , cn1.name, NULL)) AS  `TreatmentType`
 ,MAX(IF(target.concept_id=164181 , cn1.name, NULL)) AS  `VisitType`
 ,MAX(IF(target.concept_id=159599, obs.obs_datetime, NULL)) AS  `ARTStartDate`
 ,MAX(IF(target.concept_id=159599, TIMESTAMPDIFF(YEAR,person.birthdate,obs.obs_datetime), NULL)) AS  `Age at Start of ART(year)`
 ,MAX(IF(target.concept_id=165774 , cn1.name, NULL)) AS  `PickUpReason`
 ,MAX(IF(target.concept_id=165708, cn1.name, NULL)) AS  `LastRegimenLine`
 ,MAX(IF(target.concept_id=165708, target.last_date, NULL)) AS  ` LastRegimenLineDate`
 ,MAX(IF(target.concept_id=164506,cn1.name, IF(target.concept_id=164507,cn1.name, NULL))) AS  `LastFirstLineRegimen`
  ,MAX(IF(target.concept_id=164506,target.last_date, IF(target.concept_id=164507,target.last_date, NULL))) AS  `LastFirstLineRegimenDate`
  ,MAX(IF(target.concept_id=164513,cn1.name, IF(target.concept_id=164514,cn1.name, NULL)))  AS  `LastSecondLineRegimen`
  ,MAX(IF(target.concept_id=164513,target.last_date, IF(target.concept_id=164514,target.last_date, NULL))) AS  `LastSecondLineRegimenDate`
,MAX(IF(target.concept_id=164702,cn1.name, IF(target.concept_id=165703,cn1.name, NULL)))  AS  `LastThirdLineRegimen`
,MAX(IF(target.concept_id=164702,target.last_date, IF(target.concept_id=165703,target.last_date, NULL))) AS  `LastThirdLineRegimenDate`

 ,MAX(IF(target.concept_id= 165470,cn1.name, IF(target.concept_id=165708, IF(TIMESTAMPDIFF(MONTH,target.last_date,CURDATE())>5,"INACTIVE","ACTIVE"), NULL))) AS  `Patient Status` 


FROM patient 

LEFT JOIN patient_identifier pid1 ON(pid1.patient_id=patient .patient_id AND pid1.identifier_type=4  AND pid1.voided=0)
LEFT JOIN patient_identifier pid2 ON(pid2.patient_id=patient .patient_id AND pid2.identifier_type=5 AND pid2.voided=0)
LEFT JOIN person_name pn3 ON(patient .patient_id=pn3.person_id AND pn3.voided=0)
LEFT JOIN person ON(person.person_id=patient .patient_id)
LEFT JOIN person_attribute psn_atr ON (person.person_id=psn_atr.person_id) 

LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MAX(obs.obs_datetime) AS last_date FROM obs GROUP BY obs.person_id, obs.concept_id)
target ON (target.person_id=patient.patient_id)
INNER JOIN obs ON(obs.person_id=target.person_id AND obs.concept_id=target.concept_id AND obs.obs_datetime=target.last_date AND obs.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368,159599))
-- INNER JOIN obs ON(obs.person_id=patient.patient_id  AND obs.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368))
LEFT JOIN concept_name cn1 ON(obs.value_coded=cn1.concept_id AND cn1.locale='en' AND cn1.locale_preferred=1)
LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MIN(obs.obs_datetime) AS first_date FROM obs GROUP BY obs.person_id, obs.concept_id)
smin ON (smin.person_id=patient.patient_id)
INNER JOIN obs obs2 ON(obs2.person_id=smin.person_id AND obs2.concept_id=smin.concept_id AND obs2.obs_datetime=smin.first_date AND obs2.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368,159599))
LEFT JOIN concept_name cn2 ON(obs2.value_coded=cn2.concept_id AND cn2.locale='en' AND cn2.locale_preferred=1)

WHERE patient.voided=0 
GROUP BY patient.patient_id


-- TX_NEW

SELECT
patient.patient_id,
pid1.identifier AS PepfarID,
pid2.identifier AS HospID,
pn3.given_name AS FirstName,
pn3.family_name AS FamilyName,
person.gender AS Sex,
psn_atr.value AS PhoneNo,
person.birthdate AS DOB,
TIMESTAMPDIFF(YEAR,person.birthdate,CURDATE()) AS Age
,MAX(IF(target.concept_id=164989, target.last_date, NULL)) AS  `DrugPickUpDate`
,MAX(IF(target.concept_id=165050, cn1.name, NULL)) AS  `PregnancyStatus`
 ,MAX(IF(target.concept_id=165720, cn1.name, NULL)) AS  `TreatmentAgeCategory`
 ,MAX(IF(target.concept_id=165945 , cn1.name, NULL)) AS  `TreatmentType`
 ,MAX(IF(target.concept_id=164181 , cn1.name, NULL)) AS  `VisitType`
  ,MAX(IF(target.concept_id=159599, obs.obs_datetime, NULL)) AS  `ARTStartDate`
 ,MAX(IF(target.concept_id=159599, TIMESTAMPDIFF(YEAR,person.birthdate,obs.obs_datetime), NULL)) AS  `Age at Start of ART(year)`
 ,MAX(IF(target.concept_id=165774 , cn1.name, NULL)) AS  `PickUpReason`
 ,MAX(IF(target.concept_id=165708, cn1.name, NULL)) AS  `LastRegimenLine`
 ,MAX(IF(target.concept_id=165708, target.last_date, NULL)) AS  ` LastRegimenLineDate`
 ,MAX(IF(target.concept_id=164506,cn1.name, IF(target.concept_id=164507,cn1.name, NULL))) AS  `LastFirstLineRegimen`
  ,MAX(IF(target.concept_id=164506,target.last_date, IF(target.concept_id=164507,target.last_date, NULL))) AS  `LastFirstLineRegimenDate`
  ,MAX(IF(target.concept_id=164513,cn1.name, IF(target.concept_id=164514,cn1.name, NULL)))  AS  `LastSecondLineRegimen`
  ,MAX(IF(target.concept_id=164513,target.last_date, IF(target.concept_id=164514,target.last_date, NULL))) AS  `LastSecondLineRegimenDate`
,MAX(IF(target.concept_id=164702,cn1.name, IF(target.concept_id=165703,cn1.name, NULL)))  AS  `LastThirdLineRegimen`
,MAX(IF(target.concept_id=164702,target.last_date, IF(target.concept_id=165703,target.last_date, NULL))) AS  `LastThirdLineRegimenDate`
 


FROM patient 

LEFT JOIN patient_identifier pid1 ON(pid1.patient_id=patient .patient_id AND pid1.identifier_type=4  AND pid1.voided=0)
LEFT JOIN patient_identifier pid2 ON(pid2.patient_id=patient .patient_id AND pid2.identifier_type=5 AND pid2.voided=0)
LEFT JOIN person_name pn3 ON(patient .patient_id=pn3.person_id AND pn3.voided=0)
LEFT JOIN person ON(person.person_id=patient .patient_id)
LEFT JOIN person_attribute psn_atr ON (person.person_id=psn_atr.person_id) 

LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MAX(obs.obs_datetime) AS last_date FROM obs where obs.value_coded not in (165662,165772,165665) GROUP BY obs.person_id, obs.concept_id)
target ON (target.person_id=patient.patient_id)
INNER JOIN obs ON(obs.person_id=target.person_id AND obs.concept_id=target.concept_id AND obs.obs_datetime=target.last_date AND obs.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368,159599) and obs.value_coded not in (165662,165772,165665))
-- INNER JOIN obs ON(obs.person_id=patient.patient_id  AND obs.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368))
LEFT JOIN concept_name cn1 ON(obs.value_coded=cn1.concept_id AND cn1.locale='en' AND cn1.locale_preferred=1)
LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MIN(obs.obs_datetime) AS first_date FROM obs GROUP BY obs.person_id, obs.concept_id)
smin ON (smin.person_id=patient.patient_id)
INNER JOIN obs obs2 ON(obs2.person_id=smin.person_id AND obs2.concept_id=smin.concept_id AND obs2.obs_datetime=smin.first_date AND obs2.concept_id IN(164989,165050,165720,165945,164181,165774,165708,164506,164507,164513,164514,164702,1645703,165470,159368,159599) and obs.value_coded not in (165662,165772,165665))
LEFT JOIN concept_name cn2 ON(obs2.value_coded=cn2.concept_id AND cn2.locale='en' AND cn2.locale_preferred=1)

WHERE patient.voided=0 
GROUP BY patient.patient_id
having `PickUpReason` is not null


-- ELIGIBLE VL

SELECT
pid1.identifier AS PepfarID,
pid2.identifier AS HospID,
pn3.given_name AS FirstName,
pn3.family_name AS FamilyName,
person.gender AS Male,
psn_atr.value AS PhoneNo,
person.birthdate AS DOB,
TIMESTAMPDIFF(YEAR,person.birthdate,CURDATE()) AS Age,
patient_program.date_enrolled AS EnrollDate
,MAX(IF(target.concept_id=165050, cn1.name, NULL)) AS  `PregnancyStatus`
,MAX(IF(target.concept_id=159599, obs.obs_datetime, NULL)) AS  `ARTStartDate`
,MAX(IF(target.concept_id=164989, target.last_date, NULL)) AS  `LastDrugPickUpDate`
/* ,MAX(IF(target.concept_id=7778430, obs.value_text, NULL)) as  `PhoneNo`*/
,MAX(IF(target.concept_id=165050, cn1.name, NULL)) AS  `LastPMTCTLink`
,MAX(IF(target.concept_id=165050, target.last_date, NULL)) AS  `LastPMTCTLinkDate`
,MAX(IF(target.concept_id=856,obs.value_numeric, NULL)) AS  `LastViralLoad`
,MAX(IF(target.concept_id=856,target.last_date, NULL)) AS  `LastViralLoadDate`
,MAX(IF(target.concept_id=165470,cn1.name,if(target.concept_id=164989,IF(TIMESTAMPDIFF(MONTH,target.last_date,CURDATE())<6,"NOT ELIGIBLE","ELIGIBLE"),NULL) )) AS  `ViralLoad Eligibility`
,MAX(IF(target.concept_id=165708, cn1.name, NULL)) AS  ` LastRegimenLine`
,MAX(IF(target.concept_id=165708, target.last_date, NULL)) AS  ` LastRegimenLineDate`
,MAX(IF(target.concept_id=164506,cn1.name, IF(target.concept_id=164507,cn1.name, NULL))) AS  `LastFirstLineRegimen`
,MAX(IF(target.concept_id=164506,target.last_date, IF(target.concept_id=164507,target.last_date, NULL))) AS  `LastFirstLineRegimenDate`
,MAX(IF(target.concept_id=164513,cn1.name, IF(target.concept_id=164514,cn1.name, NULL)))  AS  `LastSecondLineRegimen`
,MAX(IF(target.concept_id=164513,target.last_date, IF(target.concept_id=164514,target.last_date, NULL))) AS  `LastSecondLineRegimenDate`
,MAX(IF(target.concept_id=164702,cn1.name, IF(target.concept_id=165703,cn1.name, NULL)))  AS  `LastThirdLineRegimen`
,MAX(IF(target.concept_id=164702,target.last_date, IF(target.concept_id=165703,target.last_date, NULL))) AS  `LastThirdLineRegimenDate`
-- ,MAX(IF(target.concept_id= 165470,cn1.name, NULL)) AS  `LastPatientOutcome`
-- ,MAX(IF(target.concept_id= 165470,target.last_date, NULL)) AS  `LastPatientOutcomeDate`
FROM patient
LEFT JOIN patient_identifier pid1 ON(pid1.patient_id=patient .patient_id AND pid1.identifier_type=4 AND pid1.voided=0)
LEFT JOIN patient_identifier pid2 ON(pid2.patient_id=patient .patient_id AND pid2.identifier_type=5 AND pid2.voided=0)
LEFT JOIN person_name pn3 ON(patient .patient_id=pn3.person_id AND pn3.voided=0)
LEFT JOIN person ON(person.person_id=patient .patient_id)
LEFT JOIN person_attribute psn_atr ON (person.person_id=psn_atr.person_id) 
LEFT JOIN patient_program ON(patient_program.patient_id=person.person_id AND patient_program.voided=0)
LEFT JOIN
(
SELECT obs.person_id, obs.concept_id, MAX(obs.obs_datetime) AS last_date FROM obs GROUP BY obs.person_id, obs.concept_id)
target ON (target.person_id=patient.patient_id)
INNER JOIN obs ON(obs.person_id=target.person_id AND obs.concept_id=target.concept_id AND obs.obs_datetime=target.last_date AND obs.concept_id IN(159599,165050,856,165708,164506,164507,164513,164514,165702,165703,165470,164989))
LEFT JOIN concept_name cn1 ON(obs.value_coded=cn1.concept_id AND cn1.locale='en' AND cn1.locale_preferred=1)
WHERE patient.voided=0
GROUP BY patient.patient_id


