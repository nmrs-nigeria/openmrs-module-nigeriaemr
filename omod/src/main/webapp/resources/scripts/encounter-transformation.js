// Simulated loading of JSON files
const uuidMapping = {
    "b970bed0-dc6c-4334-a9a4-c0488b0f8c76": {
        "label": "Treatment type",
        "values":{
            "0df2d48c-9713-4b89-853d-93507f0d7e21": "Non-ART",
            "7724ab9d-75ed-4abb-8a3f-7dc5974dad12": "Non-Occup PPEP",
            "09f8cb22-ed52-4d3d-910d-7bf6ec7c90d0": "Occup PEP",
            "6beb2084-7908-4737-9b9b-7b1bc2ee4278": "PMTCT",
            "5f21852c-a440-40b9-b265-0e0ef417306e": "PrEP",
            "9b49eb5e-9ca9-4494-a2ff-f1d62b6feecc":"ART",
            "fa2f68b3-a9f2-4a00-82f4-901a477d72a8":"HEI"
        }
    },
    "164181AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": {
        "label":"Visit Type",
        "values":{
            "164180AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Initial Vissit",
            "160530AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Follow-up Visit"
        }
    },
    "86c6437e-a03c-4d31-a0b0-d6dda17c419b": {
        "label":"Pregnancy Status",
        "values":{
            "61a85f36-1426-4bc5-97df-46c8ca9ea9aa": "Pregnant",
            "f036a5d3-435f-4f10-bb47-1deab6556255": "Breastfeeding",
            "3bb7b175-ba9b-4c75-b01c-f315856ee044": "Not Pregnant"
        }
    },
    "5d16ec0d-6e7b-4c64-82b5-cd1f1bc97416": {
        "label":"Pick Up Reason",
        "values":{
            "20402168-1b1d-4b87-af0c-b5244377931f": "New",
            "0bba8191-cc88-43d9-bcdf-65a7d1a3e013": "Refil",
            "94633cf0-72ed-40b6-9444-df4059dab5aa": "Subtitution",
            "01d08eb7-e6c8-4455-8546-ad03e8d1fe37": "Switch"
        }
    },
    "ba9feb87-5bcb-40ca-911c-06467fd8632c": {
        "label":"DSD Status",
        "values":{
            "56b10951-308d-406d-a4c6-a3638276ae30": "Devolved",
            "97b81125-e421-4e59-ab87-79c3de3b0cff": "Not Devolved"
        }
    },
    "ac14e589-f635-4d7a-b99e-d9cf2b37842d": "Dispensing Modality",
    "60882cd1-1f42-485b-8afb-cd988282251e": "Facility Dispensing,",
    "01fe63b3-b308-4065-aa42-69d3fc57f3dc": "Community Dispensin",
    "03d6c319-3ed2-441f-bec4-9ebbedbcf9e4": "Fast Track",
    "aed4fa7a-ca54-4118-aa20-dfd08a84d9f2": "Facility ART group HCW led",
    "05f958a6-5be7-4498-a9e5-42a199045b91": "Facility ART group Support Group",
    "b307b21d-10b0-4a84-b478-4a31feb434a8": "Decentralisation (Hub and Spoke)",
    "747a4b88-aca6-435f-9dec-199f6b3299b6": "After Hours",
    "2abe65c9-0cc1-4a91-9e28-1a42aa496ed3": "Weekend and Public Holidays",
    "a050fe91-4e1b-4537-9dde-ecc86ea1d275": "Child/Teen/Adolescents Club (Peer Managed)",
    "a28e17c6-7db9-43cc-afa9-2e4c91841e3f": "Mother infant pair/Mentor Mother led",
    "343e3b47-f601-44ae-b944-8a838484dc71": "Community Pharmacy",
    "15805972-a0ab-40a4-8dca-52df6a104f5d": "Community ART Group (HCW-led)",
    "19f92419-1c34-4842-ae4d-58a35922fb2c": "Community ART Refill Group (PLHIV-led)",
    "0bac9e27-da33-4642-bf6e-6a1303560552": "Adolescent Community ART/ peer-led groups",
    "51757611-d9cc-4c0f-b384-36bf0f7229da": "One Stop Shop (OSS)",
    "90774ce1-d1b0-4a39-a8da-7f3f9cf5d7f4": "Home/Courier Delivery",
    "0613f7e8-6d43-42ae-9200-aa781f6d014b": "Multi-Month Dispensing (MMD)",
    "add6ab10-b7eb-4e30-89cd-96356c668d44": "MMD<3",
    "54a58fb0-ea48-4d0f-809e-d88f6b12b957": "mmd3-5",
    "c72823c5-4ff4-4baf-a4a7-0775b73f58be": "MMD>=6",
    "c5e4804d-b666-4d0d-a5ae-644edd5fb7d3": "Number of missed doses per month",
    "a7fd5027-9c09-4245-9d57-9acbc77c207b": "4-8 doeses",
    "4e5be66a-c424-4d83-9f10-a15934d64e61": "Greater than 9 doeses",
    "69c725d5-f9da-4686-b3b8-62eedf18860f": "Less than 3 doeses",
    "510c6717-382a-47d3-a3ca-2dee33606178": "Adherence counselling offered",
    "1065AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Yes",
    "1066AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "No",
    "718864d2-dd9b-4210-80fe-21e6f8dcbb14": {
        "label":"Treatment Age category",
        "values":{
            "a291af62-d00e-4ace-a672-f6f965b325fe": "Adult",
            "1528AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Children"
        }
    },
    "91bf2c14-1677-4c7f-be1b-99a2b64231b4": {
        "label":"Current Regimen Line",
        "values":{
            "164507AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Child First Line",
            "164514AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Child Second Line",
            "032e80e0-ed50-4e88-8ce3-7a2dfa40d0ae": "Child 3rd Line ARV Regimens",
            "164506AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Adult First Line",
            "164513AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Adult Second Line",
            "73fbac92-4663-43c1-ad89-5fe0bc2e52c7": "Adult First Line"
        }
    },
    "817AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-AZT",
    "162563AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-EFV",
    "162199AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-NVP",
    "160124AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-EFV",
    "1652AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-NVP",
    "160104AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-EFV",
    "792AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-NVP",
    "792AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "DDI-3TC-NVP",
    "20700584-431c-41c4-ba5e-da853b9ce75b": "TDF-3TC-AZT",
    "164505AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-EFV",
    "162565AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-NVP",
    "104565AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-FTC-EFV",
    "164854AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-FTC-NVP",
    "162200AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-LPV/r",
    "162559AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-DDI-LPV/r",
    "83a49dd7-0513-43d7-980a-c0fe2430d7ec": "ABC-DDI-SQV/r",
    "d3339b29-cc77-4237-a0fe-565fc7638261": "AZT-3TC-IDV/r",
    "162561AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-LPV/r",
    "8f4b9e94-2750-4273-b12d-63be48b71ec2": "AZT-3TC-SQV/r",
    "162560AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-LPV/r",
    "164512AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-ATV/r",
    "000a88e6-1332-4a2e-8dd7-0373c8ae94a3": "TDF-3TC-IDV/r",
    "162201AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-LPV/r",
    "876d8c22-4fdf-4a11-a442-1aeef8454d2d": "TDF-3TC-SQV/r",
    "4b24d78c-032c-4ed9-aaef-323a4c80184a": "TDF-AZT-3TC-ATV/r",
    "1d2e90c1-f1c3-4651-ad41-6f59a55f267d": "TDF-DDI-IDV/r",
    "d3e272fb-8663-417b-ac70-f85e552d037f": "TDF-FTC-ATV/r",
    "7349930d-b70a-43b5-9763-8911141823e9": "TDF-FTC-LPV/r",
    "6ad611f5-c8db-44d6-812c-abd09fd02036": "TDF-FTC-SQV/r",
    "c8109095-fa8e-41cb-846a-95270c7eb9df": "AZT-TDF-3TC-LPV/r",
    "f03c42a1-d4ce-430e-a4d3-b5ef32aed0ba": "AZT-TDF-FTC-LPV/r",
    "7dd0850c-3352-444c-9eea-b6ee4f88a98f": "TDF-3TC-DTG-DRV-RTV",
    "3b30f189-2375-4945-9c9c-de7828f680ca": "TDF-AZT-3TC-IDV/r",
    "e3d770f5-8a9a-4251-a61d-a770431658a4": "TDF-AZT-3TC-SQV/r",
    "199062e9-f9c0-468d-a2a1-723b0e35d7d0": "TDF-AZT-FTC-IDV/r",
    "164505AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-EFV",
    "162565AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-NVP",
    "164854AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-FTC-NVP",
    "162563AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-EFV",
    "162200AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-LPV/r",
    "162199AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-NVP",
    "160124AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-EFV",
    "1652AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-NVP",
    "160104AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-EFV",
    "792AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-NVP",
    "dbf8a287-3c82-440b-bfc3-a4b9432f9183": "Co-trimoxazole",
    "da318ab9-efce-47a9-a975-468a718d4ef6": "200mg",
    "27f5a185-9791-45b2-89e8-89df69fdac71": "100mg",
    "409fccb1-a7de-412f-9ee6-1e96d4b0b65a": "150mg",
    "14c41615-9c0e-4254-b4b1-770956d390e9": "ABC-3TC-DTG",
    "b8947da3-017d-42b6-bc7d-652fe35a3b36": "ABC-3TC-TDF",
    "1f9ad8f3-1033-45eb-8c5c-8f65fe280984": "ABC-FTC-DTG",
    "a0d32ee4-8a68-4d4d-8cf8-23e18c44e62d": "ABC-FTC-EFV",
    "e0df55a1-3713-4fb2-ae11-0b98f9ec032f": "ABC-FTC-NVP",
    "0340aeb6-94fe-4f73-b4b8-c38b7ab7c649": "AZT-3TC-DTG",
    "8b63955a-5cdc-45ad-93f5-e0811ba7c8ba": "AZT-TDF-NVP",
    "280d2e52-c78e-47dc-b54f-51f51d2fd7f8": "D4T-3TC-ABC",
    "07233748-dfb2-45e4-ab70-92c2c2d76fd2": "DDI-3TC-EFV",
    "8a343013-0216-44e0-aefe-53909ffd5631": "TDF-3TC-DTG",
    "d20de0fd-8c89-423b-be81-dd357e65c206": "TDF-FTC-DTG",
    "9053af8f-a75a-44c4-b6e8-f76723ddfc90": "ABC-3TC-ATV/r",
    "164511AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-ATV/r",
    "544eb66b-9f33-48a1-90c5-90db406fb03d": "AZT-3TC-DRV/r",
    "ec2367d8-dff2-4ea0-bf7c-4876e55ab2a7": "D4T-3TC-IDV/r",
    "89c9f2c9-9f8b-4368-a25c-43503e008b49": "DDI-3TC-IND/r",
    "f2b45d84-dbd8-4a0e-90e8-8955018d142f": "TDF-3TC-DRV/r",
    "a3c11081-b8a1-4205-b139-43155c747dc5": "ABC-3TC-AZT-ATV/r",
    "e655f5ad-4061-40f5-acb3-5c3e454295b2": "ABC-3TC-AZT-EFV",
    "60a7d398-b1a7-4d8f-a313-915a7f52ac95": "ABC-3TC-AZT-LPV/r",
    "186150ce-ed5b-49b5-a82b-b2b46eaa0698": "ABC-3TC-DTG-ATV/r",
    "7f1322de-705a-4738-8977-a038e8e8b9a6": "ABC-3TC-DTG-DRV-RTV",
    "a3925efb-a83d-401b-8799-30258d4b6c6d": "ABC-3TC-LPV-ATV/r",
    "1eb4b11a-0e28-49cf-b4cd-d926a3e5d4cc": "ABC-3TC-RAL",
    "8fd12a41-9972-4d56-8c08-dcceee1d4445": "AZT-3TC-LPV-ATV/r",
    "90501f51-f341-478e-9f29-c6bebbed8418": "AZT-3TC-LPV-SQV/r",
    "7f815ed1-c406-4365-a122-9882b2de5176": "AZT-3TC-RAL",
    "d9569a02-92db-4ae5-bd4d-bafb7f0f8f5b": "AZT-RAL-ATV/r",
    "581ca5b3-b044-4f1a-b608-563e68154534": "TDF-3TC-DTG-LPV/r",
    "84fffdb4-3f0d-4baa-87ae-1debb8cc4a1d": "TDF-3TC-RAL",
    "9f5b2c52-87fb-4c26-9c5a-8656a52b3b3c": "TDF-FTC-AZT-ATV/r",
    "b1f53478-3680-4006-82b3-83fb08eb215f": "TDF-FTC-LPV-ATV/r",
    "f0772a15-d0d9-4039-a3f4-af0c5d15ed0c": "TDF-FTC-EFV400",
    "ff885937-9b61-477c-a50a-beb2f66cb3d5": "ABC-FTC-EFV400",
    "7fb25099-b9f0-4a56-b426-54af91006e09": "ABC-3TC-EFV400",
    "e211ec23-879a-4b6e-8273-90aaac207fa2": "DDI-3TC-LPV/r",
    "fa4dda1a-c260-42d3-920f-64fb8d7d4a12": "DRV/r + 2 NRTIs + 2 NNRTI",
    "739b5068-4451-4eaa-8a71-25655b9b87b4": "DRV/r +2NRTIs",
    "b941eb8a-5fe0-43e2-aa9f-ece8e505a0a7": "DRV/r+RAL + 1-2NRTIs",
    "e8afbb20-f696-4a6d-af40-36fef51dadbd": "DRV/r-2NRTIs + NNRTI",
    "d7827ccd-85a4-4e8e-91d6-bca3d0c5e895": "DRV/r-DTG + 1-2 NRTIs",
    "44262769-197b-4936-b092-07fceaf9f0d1": "DTG+2 NRTIs",
    "cb77ca6b-9000-4664-9818-10fc6ec6a733": "RAL(or DTG) + 2 NRTIs",
    "21ea74ee-f6fa-4c55-be36-6337a8f4086c": {
        "label":"Strength",
        "values":{
            "7c844c65-b960-4ac7-8642-69b618db3602": "400/50mg",
            "3620ba59-4313-45b4-897f-764f0609512c": "25mg",
            "a5bb8a09-4f0c-4186-98d8-4c066e220806": "10mg/ml",
            "162401AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Kit",
            "5a35ae10-1a00-4df2-83fd-3dba0465df0a": "80mg",
            "81246203-b486-4ec7-babf-05ad0669c51b": "1920mg",
            "0cd9c98e-7f52-48b9-a987-404ec90cc5fe": "300/300/50mg",
            "cd94a1ed-2812-4170-8bc7-90abded1beab":"150mg/75mg"
        }
    },
    "4919b76b-81e6-41c7-a5b5-cb383ff4b2fa": {
        "label":"Frequency",
        "values":{
            "160862AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "OD",
            "160858AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "BD",
            "6f973a60-16a5-49bc-9278-300a9e998646": "2BD",
            "160870AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "QDS",
            "a0c98b53-f014-4cb0-a41e-8503c608ef57": "3ce/week"
        }
    },
    "159368AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Duration Prescribed (days)",
    "160856AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Qty Prescribed",
    "640de6fb-a670-43e6-8e6c-c3d33582e1a8": "Medication Duration Dispensed",
    "1443AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Qty Dispensed",
    "76488AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Fluconazole",
    "1679AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Isoniazid,",
    "7f6eb353-05d1-47f3-89af-4c7b903192b8": "Isoniazid/Rifampentine (3HP)",
    "5087AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Isoniazid/Rifampicin (3HR)",
    "80945AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Nystatin",
    "9f687650-e9cf-43ae-bded-c1e957bf25a2": "400mg",
    "548c793b-5b36-41cd-b675-f26da070fbcb": "Drug Unit",
    "162263AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Ml",
    "162380AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Tube",
    "162427AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Lotion",
    "1513AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Tablet",
    "1608AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Capsule",
    "3e6d3fbc-a059-4b9d-8427-202e612fb15e": "Drugs",
    "1675AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "RHZE/RH",
    "83352AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Rifabutin",
    "c844c65-b960-4ac7-8642-69b618db3602": "400/50mg",
    "86c6437e-a03c-4d31-a0b0-d6dda17c419b": "Pregnancy or Breastfeeding status",
    "61a85f36-1426-4bc5-97df-46c8ca9ea9aa": "Pregnant",
    "f036a5d3-435f-4f10-bb47-1deab6556255": "Breastfeeding",
    "3bb7b175-ba9b-4c75-b01c-f315856ee044": "Not Pregnant",
    "d063984d-622c-470a-bb08-61fa833a1be2": "Did child receive prophylaxis",
    "1065AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Yes",
    "1066AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "No",
    "5089AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Weight (kg)",
    "5090AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Height (cm)",
    "5088AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Temp ©",
    "152162AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Blood Pressure (mmHg)",
    "5085AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "SYSTOLIC",
    "5086AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "DIASTOLIC",
    "1342AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Body Mass Index (BMI)",
    "f887befe-01dd-43f5-bb3e-b1f83db1836e": "MUAC",
    "44cab759-360c-4aa8-be1b-285cf364b0b2": "MUAC Over",
    "8a160f90-ad58-43de-9e6e-65faf63bd699": "MUAC Under",
    "dcd7075c-3163-4797-9516-1b9f4b0fa387": "MUAC Normal",
    "5271AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Is Patient on Family Planning",
    "c2f53f04-5446-44b5-855a-86aba0a8ed9c": "Functional Status",
    "62752AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Bedridden, ",
    "159468AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "working",
    "160026AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Patient Ambulatory",
    "5356AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "WHO Clinical stage",
    "1204AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "1",
    "1205AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "2",
    "1206AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "3",
    "1207AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "4",
    "1659AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TB Status",
    "1660AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "No Sign",
    "142177AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Presumtive TB",
    "d0e563c-51f2-43ca-9a12-ed4907575870": "TPT",
    "1661AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Confirmed TB",
    "1662AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": " TB Treatment",
    "b2285aff-47e0-492d-afa9-8870b56dbcad": "Cryptococcal Screening Status",
    "598a33c4-59f9-49be-a484-0fbe80d45de6": "Screened for Cryptococcus Ag",
    "0bede992-d163-4336-81ae-0611a3988719": "Cr Ag negative",
    "e3db45ad-45f9-4c47-af3f-f9e72602ccd2": "Cr Ag Positive",
    "1e614b98-69b3-47e1-8ab0-8039ee5c9689": "Cr Ag Positive commenced on pre-emptive therapy",
    "df6b079e-7cfe-464a-b349-5e45298698b7": "Diagnosed with Cryptococcal meningitis",
    "068fd8e5-6d04-4477-b00a-062b58c0890f": "Commenced treatment for cryptococcal meningitis",
    "0af2c82d-0fd1-4812-affd-1b33416576c0": "Complete treatment for cryptococcal meningitis",
    "9d4e42f9-ab18-41c9-a328-28df41da8513": "Not screened",
    "a3fd446c-1f9f-4775-9503-5a254ac6e6fe": "Cervical Cancer Screening Status",
    "ac7df040-595e-449d-920e-9f920602df68": "Not ordered",
    "6b6438b2-09f3-4c12-8dbe-5b761e52db74": "ordered yet to screen",
    "0e034024-d14f-4e4a-b22f-2f6c85d2d793": "screened negative",
    "02dac20a-4dbf-4bdd-9af0-2e6da4448b58": " screened positive yet to treat",
    "2b7c9bfe-a27e-4e5e-a245-3fd79b68c7ed": "screened positive  and treated",
    "c2537bff-28cf-4f61-90db-49ab0d3f3210": "screened positive and referred",
    "6059c410-a084-424d-ac93-17f0b7819288": "screened positive and declined treatment",
    "40c087ff-d4a9-4a8b-968f-ac62b3601cc2": "suspicious for cancer",
    "cc031843-f797-48a0-af0f-6703576831cd": "othere findings (specify)",
    "117543AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Herpes Zoster",
    "114100AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Pneumonia",
    "119566AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Demensia ",
    "5334AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Oral/Vaginal",
    "133473AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Nausea and Vomiting",
    "139084AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Headache",
    "5226AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Weakness",
    "9059d3d6-1482-41e1-a5a4-1deb6523528f": "PV Bleeding / Discharge",
    "1dbbce81-ab01-4c4d-9c07-135ce7fe0d02": "Fat changes",
    "121629AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Anaemia",
    "36a661d3-f489-426b-b2d6-33944ed23637": "Drainage of liquor",
    "125886AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Stevens-Johnson Syndrome",
    "138291AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Hyperglycemia",
    "512AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Rash",
    "7b2fbb6f-40a1-42df-b70a-67ee97d03fa4": "Others Side Effects (specify)",
    "ba9feb87-5bcb-40ca-911c-06467fd8632c": "DSD Status",
    "56b10951-308d-406d-a4c6-a3638276ae30": "Devolved",
    "97b81125-e421-4e59-ab87-79c3de3b0cff": "Not Devolved",
    "ac14e589-f635-4d7a-b99e-d9cf2b37842d": "Dispensing Modality",
    "60882cd1-1f42-485b-8afb-cd988282251e": "Facility Dispensing",
    "01fe63b3-b308-4065-aa42-69d3fc57f3dc": "Community Dispensing",
    "03d6c319-3ed2-441f-bec4-9ebbedbcf9e4": "Fast Track",
    "aed4fa7a-ca54-4118-aa20-dfd08a84d9f2": "Facility ART group HCW led",
    "05f958a6-5be7-4498-a9e5-42a199045b91": "Facility ART group Support Group",
    "b307b21d-10b0-4a84-b478-4a31feb434a8": "Decentralisation (Hub and Spoke)",
    "747a4b88-aca6-435f-9dec-199f6b3299b6": "After Hours",
    "2abe65c9-0cc1-4a91-9e28-1a42aa496ed3": "Weekend and Public Holidays",
    "a050fe91-4e1b-4537-9dde-ecc86ea1d275": "Mother infant pair/Mentor Mother led",
    "343e3b47-f601-44ae-b944-8a838484dc71": "Community Pharmacy",
    "15805972-a0ab-40a4-8dca-52df6a104f5d": "Community ART",
    "19f92419-1c34-4842-ae4d-58a35922fb2c": "Community ART Refil Group (PLHIV-Led)",
    "0bac9e27-da33-4642-bf6e-6a1303560552": "Adolescent Community ART/peer-led groups",
    "51757611-d9cc-4c0f-b384-36bf0f7229da": "One Stop Shop (OSS)",
    "90774ce1-d1b0-4a39-a8da-7f3f9cf5d7f4": "Home/Courier Delivery ",
    "8d5e5ecc-8b08-4ae9-b104-51024b95eb3a": "DSD Start Date",
    "ef004b7d-87a3-412a-954e-1db7c7c862a9": "ARV Medication Plan",
    "56d6bfe6-8545-4a77-9b67-89597dccade3": "Commence ART",
    "1257AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Continue Regimen",
    "48926c61-4a4d-4dbc-8470-c12a7260421f": "Subtitute regimen",
    "e9ec5bf9-37ce-4221-a79f-1f431d13f33b": "switch regimen",
    "ad106904-30cd-427d-828e-a90006dc62e7": "stop regimen",
    "162904AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "restart medication",
    "164506AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Adult First Line",
    "817AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-AZT",
    "abd38689-c337-4bfe-a3d2-c4bbe1c6828d": "ABC-3TC-DDI",
    "14c41615-9c0e-4254-b4b1-770956d390e9": "ABC-3TC-DTG",
    "162563AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-EFV",
    "162199AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-NVP",
    "b8947da3-017d-42b6-bc7d-652fe35a3b36": "ABC-3TC-TDF",
    "1f9ad8f3-1033-45eb-8c5c-8f65fe280984": "ABC-FTC-DTG",
    "a0d32ee4-8a68-4d4d-8cf8-23e18c44e62d": "ABC-FTC-EFV",
    "e0df55a1-3713-4fb2-ae11-0b98f9ec032f": "ABC-FTC-NVP",
    "0340aeb6-94fe-4f73-b4b8-c38b7ab7c649": "AZT-3TC-DTG",
    "160124AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-EFV",
    "1652AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-NVP",
    "8b63955a-5cdc-45ad-93f5-e0811ba7c8ba": "AZT-TDF-NVP",
    "280d2e52-c78e-47dc-b54f-51f51d2fd7f8": "D4T-3TC-ABC",
    "160104AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-EFV",
    "792AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-NVP",
    "07233748-dfb2-45e4-ab70-92c2c2d76fd2": "DDI-3TC-EFV",
    "20700584-431c-41c4-ba5e-da853b9ce75b": "TDF-3TC-AZT",
    "8a343013-0216-44e0-aefe-53909ffd5631": "TDF-3TC-DTG",
    "164505AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-EFV",
    "162565AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-NVP",
    "d20de0fd-8c89-423b-be81-dd357e65c206": "TDF-FTC-DTG",
    "104565AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-FTC-EFV",
    "164854AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-FTC-NVP",
    "164513AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Adult Second Line",
    "9053af8f-a75a-44c4-b6e8-f76723ddfc90": "ABC-3TC-ATV/r",
    "162200AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-3TC-LPV/r",
    "162559AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ABC-DDI-LPV/r",
    "83a49dd7-0513-43d7-980a-c0fe2430d7ec": "ABC-DDI-SQV/r",
    "164511AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-ATV/r",
    "544eb66b-9f33-48a1-90c5-90db406fb03d": "AZT-3TC-DRV/r",
    "d3339b29-cc77-4237-a0fe-565fc7638261": "AZT-3TC-IDV/r",
    "162561AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AZT-3TC-LPV/r",
    "8f4b9e94-2750-4273-b12d-63be48b71ec2": "AZT-3TC-SQV/r",
    "ec2367d8-dff2-4ea0-bf7c-4876e55ab2a7": "D4T-3TC-IDV/r",
    "162560AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "D4T-3TC-LPV/r",
    "89c9f2c9-9f8b-4368-a25c-43503e008b49": "DDI-3TC-IND/r",
    "164512AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-ATV/r",
    "f2b45d84-dbd8-4a0e-90e8-8955018d142f": "TDF-3TC-DRV/r",
    "000a88e6-1332-4a2e-8dd7-0373c8ae94a3": "TDF-3TC-IDV/r",
    "162201AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TDF-3TC-LPV/r",
    "876d8c22-4fdf-4a11-a442-1aeef8454d2d": "TDF-3TC-SQV/r",
    "4b24d78c-032c-4ed9-aaef-323a4c80184a": "TDF-AZT-3TC-ATV/r",
    "1d2e90c1-f1c3-4651-ad41-6f59a55f267d": "TDF-DDI-IDV/r",
    "d3e272fb-8663-417b-ac70-f85e552d037f": "TDF-FTC-ATV/r",
    "7349930d-b70a-43b5-9763-8911141823e9": "TDF-FTC-LPV/r",
    "6ad611f5-c8db-44d6-812c-abd09fd02036": "TDF-FTC-SQV/r",
    "73fbac92-4663-43c1-ad89-5fe0bc2e52c7": "Adult third Line",
    "a3c11081-b8a1-4205-b139-43155c747dc5": "ABC-3TC-AZT-ATV/r",
    "e655f5ad-4061-40f5-acb3-5c3e454295b2": " ABC-3TC-AZT-EFV",
    "60a7d398-b1a7-4d8f-a313-915a7f52ac95": "ABC-3TC-AZT-LPV/r",
    "186150ce-ed5b-49b5-a82b-b2b46eaa0698": "ABC-3TC-DTG-ATV/r",
    "7f1322de-705a-4738-8977-a038e8e8b9a6": "ABC-3TC-DTG-DRV-RTV",
    "a3925efb-a83d-401b-8799-30258d4b6c6d": "ABC-3TC-LPV-ATV/r",
    "1eb4b11a-0e28-49cf-b4cd-d926a3e5d4cc": "ABC-3TC-RAL",
    "8fd12a41-9972-4d56-8c08-dcceee1d4445": "AZT-3TC-LPV-ATV/r",
    "90501f51-f341-478e-9f29-c6bebbed8418": "AZT-3TC-LPV-SQV/r",
    "7f815ed1-c406-4365-a122-9882b2de5176": "AZT-3TC-RAL",
    "d9569a02-92db-4ae5-bd4d-bafb7f0f8f5b": "AZT-RAL-ATV/r",
    "c8109095-fa8e-41cb-846a-95270c7eb9df": "AZT-TDF-3TC-LPV/r",
    "f03c42a1-d4ce-430e-a4d3-b5ef32aed0ba": "AZT-TDF-FTC-LPV/r",
    "7dd0850c-3352-444c-9eea-b6ee4f88a98f": "TDF-3TC-DTG-DRV-RTV",
    "581ca5b3-b044-4f1a-b608-563e68154534": "TDF-3TC-DTG-LPV/r",
    "84fffdb4-3f0d-4baa-87ae-1debb8cc4a1d": "TDF-3TC-RAL",
    "3b30f189-2375-4945-9c9c-de7828f680ca": "TDF-AZT-3TC-IDV/r",
    "e3d770f5-8a9a-4251-a61d-a770431658a4": "TDF-AZT-3TC-SQV/r",
    "199062e9-f9c0-468d-a2a1-723b0e35d7d0": "TDF-AZT-FTC-IDV/r",
    "9f5b2c52-87fb-4c26-9c5a-8656a52b3b3c": "TDF-FTC-AZT-ATV/r",
    "b1f53478-3680-4006-82b3-83fb08eb215f": "TDF-FTC-LPV-ATV/r",
    "f0772a15-d0d9-4039-a3f4-af0c5d15ed0c": "TDF-FTC-EFV400",
    "ff885937-9b61-477c-a50a-beb2f66cb3d5": "ABC-FTC-EFV400",
    "7fb25099-b9f0-4a56-b426-54af91006e09": "ABC-3TC-EFV400",
    "164514AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Child Second Line",
    "e211ec23-879a-4b6e-8273-90aaac207fa2": "DDI-3TC-LPV/r",
    "032e80e0-ed50-4e88-8ce3-7a2dfa40d0ae": "Child 3rd Line ARV Regimens",
    "fa4dda1a-c260-42d3-920f-64fb8d7d4a12": "DRV/r + 2 NRTIs + 2 NNRTI",
    "739b5068-4451-4eaa-8a71-25655b9b87b4": "DRV/r +2NRTIs",
    "b941eb8a-5fe0-43e2-aa9f-ece8e505a0a7": "DRV/r+RAL + 1-2NRTIs",
    "e8afbb20-f696-4a6d-af40-36fef51dadbd": "DRV/r-2NRTIs + NNRTI",
    "d7827ccd-85a4-4e8e-91d6-bca3d0c5e895": "DRV/r-DTG + 1-2 NRTIs",
    "44262769-197b-4936-b092-07fceaf9f0d1": "DTG+2 NRTIs",
    "cb77ca6b-9000-4664-9818-10fc6ec6a733": "RAL(or DTG) + 2 NRTIs",
    "dbf8a287-3c82-440b-bfc3-a4b9432f9183": "Co-trimoxazole",
    "76488AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Fluconazole",
    "76489AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Flucytosine (100mg/Kg in 4 divided doses)",
    "1679AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Isoniazid",
    "7f6eb353-05d1-47f3-89af-4c7b903192b8": " Isoniazid/Rifampentine (3HP)",
    "5087AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Isoniazid/Rifampicin (3HR)",
    "80945AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Nystatin",
    "71187AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Liposomal Amphotericin B (3mg/Kg IV dly)",
    "92d268d2-13e8-404a-b7fb-c1d7bd460d9e": "G (Good) >= 95%",
    "0f073ee-371a-4550-8a52-f3c342cf410e": "F (Fair) 85-98%",
    "dad3327c-79d1-4ba4-ab5a-a2a26a83d437": " P (Poor) <85% ",
    "161653AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TPT Adherence",
    "fc317cd6-e033-43fc-9f36-d1a5ebe296f5": "ARV Adherence",
    "163101AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Other Drugs Prescribed",
    "1675AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "RHZE/RH",
    "83352AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Rifabutin",
    "657AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "CD4",
    "856AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Viral Load",
    "156176AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Esophageal Thrush",
    "19cbe784-36d4-43fc-8b8c-a5b508901427": "HB/PCV",
    "678AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "WBC + Diff",
    "654AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "ALT",
    "653AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "AST",
    "1319AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Total lymphocytes count (TLC)",
    "790AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Creatinine",
    "1010AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Lipid Profile",
    "77427AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "HBsAg",
    "734b7bad-1224-42ef-b92e-d5e60c70b8ba": "HCV",
    "299AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "VDRL",
    "302AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Urinalysis",
    "307AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Sputum AFB",
    "12AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Chest Xray",
    "9e4247bc-d168-46b1-a478-5c89c5ec8c0e": "Others",
    "1272AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Consult Hospitalise Refer Link",
    "5488AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Adherence Counseling",
    "e5556848-d9a9-4152-a3cd-07d5505fa3d5": "Intensive Adherence Counseling",
    "5576AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "PMTCT Services",
    "160546AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "STI Services",
    "5487AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "TB Services",
    "5486AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "OVC Program",
    "5096AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Next Appointment Date",
    "f16ab53d-25f4-4e3b-b5e3-8adf650308cd": "Lab Registration Number",
    "a80fd390-3c6d-4aab-b16e-e3a98c39cc5e": "Indication for AHD",
    "162080AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Baseline (6 Months after ART initiation)",
    "162082AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Cnfirmation (3-6 Month after intensed adherence counselling)",
    "e5c936a7-66b0-4aa8-ba46-c3cf99f287e7": "CD4+ cell count (cells/mm3)",
    "90d7951d-c0a7-4b9f-b893-ab9b83afb142": "CD4 LFA",
    "b62ff565-55a3-472a-9d11-c1f5dfe95a00": "<200",
    "f3720c6d-828a-42db-95e0-a5e3f3fdadcb": ">=200",
    "012533ad-95bb-4ead-85fc-c903b4332b17": "Time CD4 LFA sample collected",
    "f9a9acd9-50ba-420d-8a2e-433cf8b167dc": "Polymorphs (%)",
    "1338AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Lymphocytes (%)",
    "1339AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Monocytes (%)",
    "1024AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Eosinophil (%)",
    "1025AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Basophils (/mm3)",
    "52a243ab-54da-4550-84af-b9f0218a4495": "PCV/Hb (%)",
    "2cc098bf-9ac1-4bf3-97a6-8a88f2e5028f": "Positive, Negative ",
    "b78db60b-e7b6-4c1d-99ea-c72d62500005": "ALT/SGPT (U/I)",
    "0b917e57-4719-4cc1-a20f-fc4e825919f3": "AST/SGOT (U/L)",
    "61a81c2d-a14a-449e-80a5-721aebd3d0a8": "Alk. Phosphate (U/l)",
    "a52c1104-6244-4a08-bfda-f0adbabd04b3": "Fasting Glucose (mmol/l)",
    "f6324e1f-2a38-4803-a1f2-69025f6964c2": "LDL (mmol/L)",
    "160053AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Glucose",
    "921d5e09-ef3f-4b0f-a061-7955d854b7fa": "Cytology/Pap Smear:",
    "45AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Pregnancy",
    "703AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Positive",
    "664AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Negative",
    "7af102e2-5884-4acf-8667-b0b26cc3ca0c": "TB LF LAM",
    "51c81b0d-5fce-4533-a97b-c7097bcc7958": "WBC",
    "ff3ce6b0-a1ae-45d4-ab4b-52a55eadd1a9": "Time CD4 LFA result received",
    "1341AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Basophils (%)",
    "623b17b1-01f0-4b21-831b-5d562228a353": "PCV/Hb (g/dl)",
    "159430AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "HBsAG",
    "164364AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Creatinine (mmol/l)",
    "dd5bea86-e7f4-434d-bba1-5712e456d01f": "ALT/SGPT (mmol/L)",
    "655AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Total Bilirubin (mmol/l)",
    "fddf8b85-2ce7-43c2-86f7-de6ceb53ae11": "K+ (mmol/L)",
    "1006AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Total Cholesterol (mmol/l)",
    "92102c3d-213d-41f5-b2c5-b4d2912a9089": "HDL (mmol/L)",
    "78efdba1-2598-4c0c-b94b-e69d45f6d0a7": "Protein",
    "1009AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Triglyceride",
    "32AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Malaria smear",
    "be3cae1b-ad61-4c30-acd0-75a3b4c2546e": "Serology for CrAg Result",
    "e34c45c7-d06d-49ab-b92e-0b11cb8d9df2": "CSF for CrAg",
    "f7f2b7a2-9365-4e1f-93ab-ea4ba5b76bc1": "Specify exact clinical indication for requested tests:",
    "1000AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Whole blood",
    "1002AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Plasma",
    "397afc02-f2d6-4436-895a-7ade17e76d6e": "DBS",
    "a7ed790e-f9cc-4273-b0bf-647affc73c2a": "Plasma Separation Card (PSC)",
    "884f0b28-4287-42ad-b537-af1e11c35cbb": "Indication for Viral Load",
    "161236AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Routine (Every 12 months)",
    "162081AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Repaet Teston",
    "163523AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Clinical Failure",
    "160566AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Immunological Failure",
    "6cb50e40-ddf7-4a62-9340-392ef7de1109": "PMTCT 32-36 weeks gestation",
    "856AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Sample collection date",
    "dc776767-01dd-4742-b87a-b68d32a60f14": "Date result was sent from PCR Lab",
    "c7d3fb2c-8f1c-4209-b8e2-cf862e3f862c": "Assay Date",
    "9afa14a2-a17d-4f1d-a440-f6ff366bd6fc": "Date sample sent to PCR Lab",
    "67cb366-0c42-428d-a6ca-dc86900b3cf2": "Date sample received at PCR Lab",
    "36e2d500-0e1b-479c-bb02-c2dec6f53965": "Date result was received at the facility",
    "43d4c591-9976-4fc2-a2f0-14b8159624f2": "Result Date",
    "e4cf058e-8c7f-4913-bbae-1adece74f9fa": "Approval Date",
    "81e71015-5c53-4dec-97c6-8f0b0a00c051": "Alphanumeric Viral Load Result",
    "341b01b6-8858-4afc-ac78-7090b9307808": "<20",
    "ef932eb8-16ee-41ec-bcda-215d75d91809": "<29",
    "11346d03-015f-4cdd-a1a5-1f920bb16ed9": "<30",
    "75743ab8-4189-424e-a18a-38978bd49252": "<40",
    "e73e6a1c-8161-40be-88ba-ca14182d91da": "<400",
    "2a5a7fed-b0d4-4736-b541-463c795f0c75": "<80",
    "02518676-2b57-46dd-b2a1-bbf9f523f07a": ">10,000000",
    "06ab11bb-97d9-40f5-ba0b-a9547cc025ad": "Aborted",
    "ce596291-2a3a-4a3b-8ab5-3c35d343d381": "Double entry",
    "fa74a055-a622-4e0e-a462-c672e45b1262": "Duplicate",
    "c0cb71b6-d752-4d7b-b2e3-209138f5e5cd": "Failed",
    "c99b3c37-c64d-468c-aa70-763f9e2d0c52": "Failed twice",
    "85efaa33-e5ba-4a6b-a340-58b3f7ccc20a": "Incomplete number",
    "6b724cad-6939-4486-8e41-c1f86d250aa9": "Incorrect Entry",
    "163611AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA": "Invalid",
    "dbf837e2-9f05-4010-a581-d2dfddcbbc44": " Target Not Detected",
    "24332632-cb52-4427-a83a-75828939465a": "Wrong Entry",
    "0166cf96-67b8-416c-af1d-c31a48f9ee71": "Numeric Value",
    "9af2cf8e-6d16-4c62-8a4d-56cc4594c1d2": "HIVDR Study ID.",
    "42777e97-6fd6-494d-b44d-33cf907522fc": "Date of sample Sent to genotyping laboratory",
    "c8d0c960-5c6a-4d71-85ad-05a22e0aa22e": "Date of sample Arrival at genotyping laboratory",
    "e8a79abb-dda0-4113-aa0d-3b61e320895c": "Date of genotyping testing",
    "4a74b59c-d1d1-4d02-b19d-e97045e93ba7": "Resistance Mutations Detected",
    "ce7aceb1-f2be-4060-b408-b774a2f1bdf8": "M41L",
    "405ae35c-c218-471d-aa7a-bfc2b6ce3674": "K65R",
    "4cb12e89-1f91-43b0-b9b4-11a68d7e03f8": "D67N",
    "929a1048-f536-4312-9c7e-04cae75bdee4": "T69D",
    "ed7cb951-56a8-435d-9505-a83dc9af6ecc": "K70R",
    "34f8a5a4-03a5-4ff8-a468-d11179ab0293": "K70E",
    "b7ecbe72-8288-436d-84c1-6a192669d0fd": "L74V",
    "71d97eb7-644c-46fe-8898-d8bfcf0c3728": "L74I",
    "d9cad082-45db-4ffe-a7da-67453e75f66d": "F77L",
    "8fdd2656-4198-4e07-8449-fbeaec79dbd9": "Y115F",
    "4fee76c7-3afb-4e8e-9970-e01ae4bb2214": "F116Y",
    "ddd6fe23-0f01-47f2-afac-8bd5c2a0eb78": "Q151M",
    "18c82cff-cd04-427b-8c83-cee200cae1f5": "M184V",
    "80c59eb0-0ab0-44f4-bbca-201e97c44354": "M184I",
    "ba9eefa6-5961-41df-bc03-f28d2bfaa3f8": "L210W",
    "29e26cd4-206c-4075-93ca-66cf7ebd2693": "T215Y",
    "53e0ea61-bf3d-416e-93bd-436d6b0b38e6": "T215F",
    "da7e0a02-1b6f-4053-be7c-3a5b077f6c4d": "T215I",
    "f8364e1f-eca5-49d3-87eb-5c598763807e": "T215S",
    "05e7466a-2787-4805-9664-ee4878f0ed1a": "T215C",
    "dcdbd98b-7c6b-4345-97f7-2542e59948df": "T215E",
    "2edd973a-ab16-4b55-b584-63a5195cc9ed": "K219Q",
    "d45af691-5355-4598-b4c1-2a33c8a5bd4a": "K219E",
    "d2e1658c-ce4e-484c-8601-58d0b3cef297": "K219N",
    "5bfb38fa-78f5-4ca1-b074-a12280c90f1e": "K219R",
    "24188fb0-da86-4bf4-bcb0-ecd2f37a192e": "L100I",
    "50f13ddd-26e4-4962-907d-30cd5b1bf33d": "K101E",
    "84d3b914-018a-4da5-adc4-00c3bf0fc595": "K101P",
    "b9cd3fac-e57a-49fa-94ca-b372acd6d802": "K103N",
    "8670e843-e68f-4e63-9be9-517c36074658": "K103S",
    "920ce500-7e47-4230-bbb9-9a441b34a0e5": "V106M",
    "0bfdf240-c633-449c-9def-f46ad12e07c8": "V106A",
    "4e9f4838-c4e0-4e78-a1bd-3c86edf598c0": "Y181C",
    "5675e8d6-daa4-42c1-a1b8-f5d1a0a1e961": "Y181V",
    "54bbe243-93b3-43bf-8dee-9c0e9426598e": "Y188L",
    "554e8ad9-fc65-4066-b0d6-d123c0a3ac05": "Y188H",
    "5706678a-0f60-4205-8589-4501b4521b54": "Y188C",
    "1fca5517-0ceb-4bde-82ec-705bf2d13f2b": "G190A",
    "e8a0587b8-027f-4323-860b-9a4881436dbd": "G190S",
    "e8207949-1a39-4efc-8ac0-46b229cb0ce9": "G190E",
    "91394914-be6a-4386-9603-52ad7d9e1948": "P225H",
    "99aa1984-28b8-451d-8e9b-10f060cc6bda": "M230L",
    "f7b4bc57-21d5-4151-a501-abf50e861d14": "L24I",
    "28da8ba9-d392-4758-b08e-7dfaa97d2b46": "M46I",
    "20b9dc1f-8250-41ce-9b6e-a8b5045f3364": "M46L",
    "ecf36d20-ff23-4c12-85ec-21342def78da": "I50V",
    "9337db34-24cf-4b25-8e2e-4a7504e34c91": "I50L",
    "f37e7d7a-4190-42a4-9aea-bf08d1b28269": "F53L",
    "8c718dd2-2d45-414e-babc-8888c5d45a8a": "I54V",
    "e37a0f86-b0ba-4eda-ab03-a94f66d8b994": "I54L",
    "85f3077b-365a-4231-8b69-d52aab0b7548": "G73S",
    "eac1c372-c129-46e5-bf98-66240748006d": "L76V",
    "82f95292-b7ed-4ef2-b75c-2af71acc9b21": "V82A",
    "2b4a7ddd-3554-4e20-aa70-2a2eb09f957c": "V82F",
    "2a8ed600-b5f5-4981-8709-4b01fa2c5ed0": "V82S",
    "d97dc62b-18bb-4dc0-b957-22510f13eb7c": "V82M",
    "0568657d-2abf-4b43-b498-1416d5f73216": "N83D",
    "e5bac37f-0d57-4546-8d68-211b9c81fbcf": "I84V",
    "cf99a452-9bd5-424d-aeb2-6c216bbbcdd3": "L90M",
    "a87a0f99-5219-40c9-bfd7-966a340357e5": "Class(es) of ARVs Affected",
    "d3d850a0-1ae8-43cd-ad5f-d2d6cac8059b": "NNRTI",
    "e4b5f81b-6fa4-476b-a6eb-2c50ce0833ce": "NRTI",
    "de750aa6-3fbf-46bb-8f2c-3baddfb8dc1c": "NNRTI and NRTI",
    "960ea500-b309-4072-b09e-5b9826fc3138": "PI",
    "945caf8b-2208-4382-8449-cf8b20a64de5": "NNRTI, NRTI and PI ",
    "94b72d22-ac20-4781-ba24-aee35162c6b4": "Reported By",
    "6e77fbe0-4a94-4d6e-a5d0-b8b715ebf86d": "Checked By",
    "2552b7df-30b8-4789-8165-46461cd4b015": "Date Ordered",
    "4dc1e17b-ce5e-48a4-bf1d-46bab9f3b4a4": "Date Reported",
    "74171955-59a0-499a-940e-9818dbbe9091": "Date checked"
};

const pharmacyuuid = "a1fa6aa3-59e1-4833-a28c-bb62f2fb07df";
const carecarduuid =    "0b8d256c-e5df-4801-9653-b6ae5b6e906b";
const laboratoryuuid   = "7ccf3847-7bc3-42e5-8b7e-4125712660ea";


function getConceptLabel(conceptUUID) {
    const entry = uuidMapping[conceptUUID];
    if (!entry) return conceptUUID; // fallback
    if (typeof entry === 'object' && entry.label) return entry.label;
    return entry; // string mapping
}

function getValueLabel(conceptUUID, value) {
    const conceptEntry = uuidMapping[conceptUUID];

    if (typeof conceptEntry === 'object' && conceptEntry.values) {
        // coded value (UUID)
        return conceptEntry.values[value] || value;
    }

    // fallback: try value as its own UUID
    return uuidMapping[value] || value;
}

function flattenObs(obsArray, flatMap = {}) {
    obsArray.forEach(obs => {
        if (!obs.concept || (!obs.value && !obs.groupMembers)) return;

    const conceptUUID = obs.concept.uuid;

    if (obs.groupMembers && Array.isArray(obs.groupMembers)) {
        flattenObs(obs.groupMembers, flatMap);
    } else {
        let rawValue = obs.value;
        let valueUUID = (rawValue && typeof rawValue === 'object' && rawValue.uuid) ? rawValue.uuid : rawValue;
        flatMap[conceptUUID] = valueUUID; // last one wins
    }
});
    return flatMap;
}

function processData(nmrsData,clientid) {
    console.log("Imnside like");
    let htmlSections = [];

    nmrsData.forEach(client => {
        const clientId = client.clientIdentifier || 'Unknown';
    console.log("Inside processDate---" +clientId);
    const encounters = client.pimsClientEncounters || [];

    encounters.forEach(enc => {
        const results = JSON.parse(enc.encounterPayload) || [];
    var dataArr1 = JSON.stringify(results);
    var dataArr2 = [];
    dataArr2.push(JSON.parse(dataArr1));

    const htmlForClient =dataArr2.map(res => {

    console.log("UUIDSSSSSSSSSSS"+ res.encounterType.uuid );
        const obsMap = flattenObs(res.obs || []);
    const orderedConcepts = Object.keys(uuidMapping);

    var a =  new Date(res.encounterDatetime).toISOString().split("T")[0]
    let html = `<div class="section"><h2>Client: ${clientId} </h2>`;
    html +=`<h3>Pharmacy | Encounter: ${a || 'N/A'}</h3>`;
    html += `<table style="width: 100%;"><thead><tr><th>Concept</th><th>Value</th></tr></thead><tbody>`;

    orderedConcepts.forEach(uuid => {
        if (obsMap[uuid] !== undefined) {
        const label = getConceptLabel(uuid);
        const value = getValueLabel(uuid, obsMap[uuid]);
        html += `<tr><td>${label}</td><td>${value}</td></tr>`;
    }
});

    if(res.encounterType.uuid === pharmacyuuid && clientid === clientId){
        html += `</tbody></table></div>`;

        return html;
    }

    return "";


});

    const htmlForClient2 =dataArr2.map(res => {

        console.log("UUIDSSSSSSSSSSS"+ res.encounterType.uuid );
    const obsMap = flattenObs(res.obs || []);
    const orderedConcepts = Object.keys(uuidMapping);

    var a =  new Date(res.encounterDatetime).toISOString().split("T")[0]
    let html = `<h3>Care Card | Encounter: ${a || 'N/A'}</h3>`;
    html += `<table style="width: 100%;"><thead><tr><th>Concept</th><th>Value</th></tr></thead><tbody>`;

    orderedConcepts.forEach(uuid => {
        if (obsMap[uuid] !== undefined) {
        const label = getConceptLabel(uuid);
        const value = getValueLabel(uuid, obsMap[uuid]);
        html += `<tr><td>${label}</td><td>${value}</td></tr>`;
    }
});

    if(res.encounterType.uuid === carecarduuid && clientid === clientId){
        html += `</tbody></table></div>`;

        return html;
    }

    return "";


});


    const htmlForClient3 =dataArr2.map(res => {

        console.log("UUIDSSSSSSSSSSS"+ res.encounterType.uuid );
    const obsMap = flattenObs(res.obs || []);
    const orderedConcepts = Object.keys(uuidMapping);

    var a =  new Date(res.encounterDatetime).toISOString().split("T")[0]
    let html = `<h3>Laboratory | Encounter: ${a || 'N/A'}</h3>`;
    html += `<table style="width: 100%;"><thead><tr><th>Concept</th><th>Value</th></tr></thead><tbody>`;

    orderedConcepts.forEach(uuid => {
        if (obsMap[uuid] !== undefined) {
        const label = getConceptLabel(uuid);
        const value = getValueLabel(uuid, obsMap[uuid]);
        html += `<tr><td>${label}</td><td>${value}</td></tr>`;
    }
});

    if(res.encounterType.uuid === laboratoryuuid && clientid === clientId){
        html += `</tbody></table></div>`;

        return html;
    }

    return "";


});

    htmlSections.push(...htmlForClient.filter(Boolean));
    htmlSections.push(...htmlForClient2.filter(Boolean));
    htmlSections.push(...htmlForClient3.filter(Boolean));

});
});

    return htmlSections.join('');
}



