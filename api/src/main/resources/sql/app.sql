REPLACE INTO `appframework_user_app`
(`app_id`,
`json`)
VALUES
('nigeriaemr',
'{\r\n    \"id\": \"nigeriaemr\",\r\n    \"description\": \"OpenMRS System Administration and Other Users\",\r\n  \"extensions\": [\r\n        {\r\n            \"id\": \"nigeriaemr\",\r\n            \"extensionPointId\": \"org.openmrs.referenceapplication.homepageLink\",\r\n            \"type\": \"link\",\r\n            \"label\": \"NMRS Export\",\r\n            \"url\": \"nigeriaemr/customreport.page\",\r\n            \"icon\": \"icon-upload-alt\",\r\n            \"requiredPrivilege\": \"Nigeriaemr Privilege\"\r\n        }\r\n    ]\r\n}'
);