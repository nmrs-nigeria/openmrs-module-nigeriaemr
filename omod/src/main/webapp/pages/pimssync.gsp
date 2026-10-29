<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-4 offset-lg-2">
        <input style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Push data" onclick="getTransitPatientUUID()" id="pushData" class="btn btn-primary" />

    </div>
    <div class="col-lg-4 offset-lg-2">
        <input style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Pull data" onclick="pullDataFromPIMS()" id="pullData" class="btn btn-primary" />

    </div>



</div>

<div class="pushDataDiv">
    <h3>Push Encounter Details</h3>
    <hr/>
    <table id="resultsTable" border="1">
        <thead>
        <tr>
            <th>Principal Datim Code</th>
            <th>Transit Datim Code</th>
            <th>Transit Facility</th>
            <th>Sex</th>
            <th>Client Identifier Number</th>
            <th>Date of Birth</th>
            <th>Transit ID</th>
            <th>Encounters</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody id="resultsBody">
        </tbody>
    </table>
</div>

<div id="resultTableDiv" class="resultTableDiv">
<div style="text-align: center;"><span class="pull-spinner"></span></div>
</div>
<pre id="statusSync"></pre>

<div id="internet-alert">
    🔌 You are offline. Please check your connection.
    <button class="close-btn" onclick="hideOfflineAlert()">×</button>
</div>

<div id="general-error-alert">
    ❌ Error, please check your internet connection or contact system admin.
</div>

<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <p><span id="modalContent"></span></p>
    </div>
</div>

<!-- Add a loading spinner -->
<style>
.spinner {
    border: 2px solid #f3f3f3;
    border-top: 2px solid #3498db;
    border-radius: 50%;
    width: 14px;
    height: 14px;
    animation: spin 1s linear infinite;
    display: inline-block;
}

.pull-spinner {
    border: 5px solid #f3f3f3;
    border-top: 5px solid #3498db;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    animation: spin 1s linear infinite;
    display: none;
}

@keyframes spin {
    0% { transform: rotate(0deg);}
    100% { transform: rotate(360deg);}
}

.status-completed {
    color: green;
    font-weight: bold;
}
.pushDataDiv{
    margin-top: 20px;

}
.resultTableDiv{
    margin-top: 20px;
}

#internet-alert {
    display: none;
    position: fixed;
    top: 20px;
    right: 20px;
    background-color: #ff4f4f;
    color: white;
    padding: 15px 20px;
    border-radius: 12px;
    font-family: sans-serif;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    animation: slideDown 0.3s ease-out;
}

#internet-alert .close-btn {
    margin-left: 15px;
    font-weight: bold;
    cursor: pointer;
    background: none;
    border: none;
    color: white;
    font-size: 18px;
}

#general-error-alert {
    display: none;
    position: fixed;
    top: 20px;
    right: 20px;
    background-color: #ff4f4f;
    color: white;
    padding: 15px 20px;
    border-radius: 12px;
    font-family: sans-serif;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    z-index: 1000;
    animation: slideDown 0.3s ease-out;
}

@keyframes slideDown {
    from { opacity: 0; transform: translateY(-20px); }
    to { opacity: 1; transform: translateY(0); }
}
</style>
<style>
/* Modal backdrop */
.modal {
    display: none; /* Hidden by default */
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100% !important;
    height: 100%;
    overflow: auto;
    background-color: rgba(0,0,0,0.5); /* Dark background */
}

/* Modal content box */
.modal-content {
    background-color: #fff;
    margin: 15% auto;
    padding: 20px;
    border-radius: 8px;
    width: 70% !important;
    box-shadow: 0 0 15px rgba(0,0,0,0.3);
    position: relative;
}

/* Close button */
.close {
    color: #aaa;
    position: absolute;
    top: 10px;
    right: 15px;
    font-size: 24px;
    font-weight: bold;
    cursor: pointer;
}

.close:hover {
    color: red;
}

/* Button */
.btn-mymodal {
    padding: 10px 20px;
    background-color: #0066cc;
    color: black;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.btn-mymodal:hover {
    background-color: #9fcdff;
}
</style>
<script src="${ui.resourceLink("nigeriaemr","./scripts/encounter-transformation.js")}"></script>

<script>

    function showErrorAlert() {
        const alertBox = document.getElementById("general-error-alert");
        alertBox.style.display = "block";
        setTimeout(() => {
            alertBox.style.display = "none";
    }, 5000); // Auto-hide after 5 seconds
    }

    function showOfflineAlert() {
        const alertBox = document.getElementById("internet-alert");
        alertBox.style.display = "block";
    }

    function hideOfflineAlert() {
        const alertBox = document.getElementById("internet-alert");
        alertBox.style.display = "none";
    }

    async function checkInternetViaFetch() {
        try {
            const controller = new AbortController();
            const timeoutId = setTimeout(() => controller.abort(), 5000); // 5s timeout

            const response = await fetch("https://google.com", {
                method: "HEAD",
                mode: "no-cors", // avoid CORS errors
                signal: controller.signal,
            });

            clearTimeout(timeoutId);
            // If fetch succeeds, we assume internet is working
            console.log("Internet is working.");
            hideOfflineAlert();


        } catch (error) {
            console.warn("Internet connection check failed:", error);
            showOfflineAlert();
        }
    }

    // Check on load and periodically every 30 seconds
    window.addEventListener("load", checkInternetViaFetch);
    setInterval(checkInternetViaFetch, 30000);

</script>
<script>
const encounter = {
    "a1fa6aa3-59e1-4833-a28c-bb62f2fb07df":"Pharmacy",
    "0b8d256c-e5df-4801-9653-b6ae5b6e906b":"Care Card",
    "7ccf3847-7bc3-42e5-8b7e-4125712660ea":"Laboratory"
}


jQuery(document).ready(function() {
//     getTokenCode().then(tokenid => {
//         token1 = tokenid.replace(/"/g, '');
// }).catch(err => {
//         console.error("Error fetching token:", err);
// });
    pendingPushData();

});

function pendingPushData() {
    jQuery(function() {
        jQuery.ajax({
            type:"GET",
            url: "${ ui.actionLink("nigeriaemr", "pims", "getTransitPatientUUIDs") }",
            dataType: "json",
            success: function (response) {
                var objparam1 = JSON.parse(response);
                // Clear existing table rows
                jQuery('#resultsBody').empty();
                objparam1.forEach(id => {
                    jQuery('#resultsBody').append(`
            <tr id="row-\${id.primarydatimcode}">
                <td>\${id.primarydatimcode}</td>
                <td>\${id.secondarydatimcode}</td>
                <td>\${id.secfacilityname}</td>
                <td>\${id.gender}</td>
                <td>\${id.primaryclientid}</td>
                <td>\${id.birthdate}</td>
                <td>\${id.transitid}</td>
                <td>\${id.encounters}</td>
                <td id="status-\${id.primaryclientid}"><span class="spinner"></span> Pending</td>
            </tr>
        `);
            });

            },
            error: function (error){

            }
        });
    });

}
function getTokenCode() {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getTokenPIMS') }",
        dataType: "json",
        success: function (response) {
            resolve(response); // ✅ Return response
        },
        error: function (error) {
            console.error("Failed to fetch token:", error);
            reject(error);
        }
    });
});
}



</script>

<script>
var obj;
var facility_datim_code;
    function getTransitPatientUUID() {
        jQuery(function() {
            jQuery.ajax({
                type:"GET",
                url: "${ ui.actionLink("nigeriaemr", "pims", "getTransitPatientUUIDs") }",
                dataType: "json",
                success: function (response) {
                    console.log("getTransitPatientUUIDs "+response);
                    getTokenCode().then(tokenid => {
                     var token1 = tokenid.replace(/"/g, '');
                    pushData(response,token1);
                }).catch(err => {
                        console.error("Error fetching token:", err);
                });

                },
                error: function (error){

                }
            });
        });
    }




async function pushData(objparam, token1) {
    var objparam1 = JSON.parse(objparam);
    var finalPayload = [];
   

    console.log("token 1" +token1);

    // Clear existing table rows
   // jQuery('#resultsBody').empty();
    jQuery('.pushDataDiv').css('display', 'block');
    jQuery('.resultTableDiv').css('display', 'none');
    jQuery('.pull-spinner').css('display', 'none');



    // Convert each AJAX call to a Promise
    const requests = objparam1.map(async function(id) {
         var PimsClientEncountersload = [];
        const pharmacyorderform = await getPatientPharmacy(id.uuid, id.secondarydatimcode);
        const carecard = await getPatientCareCard(id.uuid, id.secondarydatimcode);
        const laboratory = await getPatientLaboratory(id.uuid, id.secondarydatimcode);

        //  const parsedPharmacy = JSON.parse(pharmacyorderform);
        // const parsedCarecard = JSON.parse(carecard);
        //  const parsedLab = JSON.parse(laboratory);

        if (pharmacyorderform && Object.keys(pharmacyorderform).length > 0) {
            PimsClientEncountersload.push(pharmacyorderform);
        }
        if (carecard && Object.keys(carecard).length > 0) {
            PimsClientEncountersload.push(carecard);
        }
        if (laboratory && Object.keys(laboratory).length > 0) {
            PimsClientEncountersload.push(laboratory);
        }


        const apiUrl = '/openmrs/ws/rest/v1/encounter?patient=' + id.uuid + '&v=custom:(patient:(uuid),encounterType:(uuid),encounterDatetime,form:(uuid),obs:(value:(uuid),concept:(uuid),obsGroup,valueCodedName,obsDatetime,groupMembers:(concept:(uuid),voided,value:(uuid),obsGroup:(uuid))))&voided=false';

        return new Promise((resolve, reject) => {
            jQuery.ajax({
            url: apiUrl,
            method: 'GET',
            contentType: 'application/json',
            success: function(response) {
                const payload = {
                    PrimaryDatimCode: id.primarydatimcode,
                    SecondaryDatimCode: id.secondarydatimcode,
                    ClientIdentifier: id.primaryclientid,
                    PrimarySex: id.gender,
                    PrimaryDOB: id.birthdate,
                    SecondaryTransitId: id.transitid,
                    Consent: 'Yes',
                    PimsClientEncounters: PimsClientEncountersload
                };
                finalPayload.push(payload);
                resolve(); // Done with this patient
            },
            error: function(xhr, status, error) {
                console.error('Failed to get encounters for', id, error);
                reject(error); // Can skip resolve() or resolve with fallback
            }
        });
    });
    });

    // Wait for all AJAX requests to finish
    Promise.all(requests)
        .then(() => {
        console.log("All payloads collected:", finalPayload);

    var data = JSON.stringify(finalPayload);
   
    return new Promise((resolve, reject) => {
		jQuery.ajax({
			type:"POST",
			url: "${ ui.actionLink("nigeriaemr", "pims", "pushDataToPIMS") }",
			dataType: "json",
			data:{
				'payload': data,
				'token': token1
			},
			success: function (response) {
				console.log("pushToPIMS "+JSON.parse(response));
				resolve(response);  // ✅ resolve only after success
				
			},
			error: function (xhr, status, error){
				console.error("Error:", status, error);
				console.error("Response text:", xhr.responseText);
				showErrorAlert();
				reject(error); // ✅ reject on failure
			}
		});
	
	});
   
})
.then((response) => {
        // ✅ This block runs ONLY after everything is done (all requests + POST success)
        finalPayload.forEach(item => {
            const code = item.ClientIdentifier;
            console.log("Update ID: " + code);
             jQuery(`#status-\${code}`).html('<span class="status-completed">Completed</span>');     
        });

        updatePIMSLastPushDate(); // ✅ last step
         //jQuery('#resultsBody').empty();
        // jQuery('#pushData').prop('disabled', true);
         jQuery('#pushData').css('display', 'none');

    })
	.catch(error => {
        console.error("At least one request failed:", error);
});
}



function getFacilityDatimCode() {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getFaciiityID') }",
        dataType: "json",
        success: function (response) {
            console.log("Datimocode:", response);
            resolve(response); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to fetch datim code:", error);
            reject(error);
        }
    });
});
}

function pullDataFromPIMS() {
    getFacilityDatimCode().then(facilityCode => {
      facilityCode =  facilityCode.replace(/"/g, '');
    pullData(facilityCode); // use the result
}).catch(err => {
        console.error("Error fetching facility code", err);
});
}

var globalPulledData = [];

async function pullData(facilityid) {
    jQuery('.pushDataDiv').css('display', 'none');
    jQuery('.resultTableDiv').css('display', 'block');
    jQuery('.pull-spinner').css('display', 'inline-block');

    var lastpulldate = await getPIMSLastPullDate();
    var primaryfacility = await getFacilityName();

    jQuery(function () {
        var primaryDatimCode = facilityid;
        var startDate = lastpulldate;
        var page = '1';
        var size = '10';

        jQuery.ajax({
            type: "POST",
            url: "${ ui.actionLink('nigeriaemr', 'pims', 'pullDataFromPIMS') }",
            dataType: "json",
            data: {
                'primaryDatimeCode': primaryDatimCode,
                'startDate': startDate,
                'page': page,
                'size': size
            },
            success: function (response) {

                console.log("parsed "+ JSON.parse(response));

                var dataArray1 = JSON.parse(response);
                var dataArray = JSON.parse(dataArray1);

                globalPulledData = dataArray;
                console.log("TYPE:", typeof dataArray); // Should be "object"
                console.log("IS ARRAY:", Array.isArray(dataArray)); // Should be true

                // const html = processData(globalPulledData, "FCT01402422");
                // openModal(html);


                    let tableHtml = `<h3>Pull Encounter Details</h3> <hr/>
                    <table border="1" cellpadding="5" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Principal Datim Code</th>
                                 <th>Principal Facility</th>
                                <th>Transit Datim Code</th>
                                <th>Client Identifier</th>
                                <th>Sex</th>
                                <th>DOB</th>
                                <th>Transit ID</th>
                                 <th>Encounters</th>
                                <th>Consent</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>`;

              /*  dataArray.forEach(en => {
                    en.pimsClientEncounters.forEach(encounter => {
                    var dataArr1 = JSON.parse(encounter.encounterPayload);
                var dataArr2 = JSON.stringify(dataArr1);
                var dataArr3 = [];
                dataArr3.push(JSON.parse(dataArr2));
                dataArr3.forEach(result => {
                    allEncounters.push(result.encounterType.uuid);
                    var a =  new Date(result.encounterDatetime).toISOString().split("T")[0]
                    allEncounters.push(a);

            });
            });

            });*/

               // var pharmacyTransform = processData(dataArray);
               // console.log("pharmacyTransform----------- "+processData(dataArray));

                //console.log("allEncounters -----"+ allEncounters);
                //var allEn =  getEncounterLabelsDate(allEncounters);
                //console.log("allEn -----"+ allEn);

                dataArray.forEach(item => {
                        var allEn = '';
                        var allEncounters = [];
                     item.pimsClientEncounters.forEach(encounter => {
                    var dataArr1 = JSON.parse(encounter.encounterPayload);
                var dataArr2 = JSON.stringify(dataArr1);
                var dataArr3 = [];
                dataArr3.push(JSON.parse(dataArr2));
                dataArr3.forEach(result => {
                   
                    allEncounters.push(result.encounterType.uuid);
                    var a =  new Date(result.encounterDatetime).toISOString().split("T")[0]
                    allEncounters.push(a);

                console.log("allEncounters -----"+ allEncounters);
                 allEn =  getEncounterLabelsDate(allEncounters);
                console.log("allEn -----"+ allEn);
           

            });
            });


                 tableHtml += `
                        <tr>
                            <td>\${item.primaryDatimCode}</td>
                            <td>\${primaryfacility}</td>
                            <td>\${item.secondaryDatimCode}</td>
                            <td>\${item.clientIdentifier}</td>
                            <td>\${item.primarySex}</td>
                            <td>\${item.primaryDob}</td>
                            <td>\${item.secondaryTransitId}</td>
                            <td>\${allEn}</td>
                            <td>\${item.consent}</td>
                            <td><button class="btn-mymodal" data-client-id="\${item.clientIdentifier}"> View</button></td>
                        </tr>`;
                        
                });

                    tableHtml += `</tbody></table>  `;
                    if(dataArray.length > 0) {
                        tableHtml += `<button style="font-weight: bold; color: #004085 !important; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" class="btn btn-info" onclick="processAndPushAll()">Start Sync</button>`;
                    }else {
                        tableHtml +=`No New Data to pull`;
                    }
                    // Inject into div with id resultTableDiv
                    jQuery("#resultTableDiv").html(tableHtml);

            },
            error: function (error) {
                console.log("Error from PIMS Server ", error);
                jQuery("#resultTableDiv").html("<p style='color:red;'>Error loading data.</p>");
                showErrorAlert();
            }
        });
    });
}


/*********
 *
 * Algorithmn for syncing data to the EMR
 *
 */


async function getFacilityDatimCodeForSavingRecord() {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getFaciiityID') }",
        dataType: "json",
        success: function (response) {
            console.log("Datimocode:", response);
            resolve(response); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to fetch datim code:", error);
            reject(error);
        }
    });
});
}

async function getFacilityName() {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getFacilityName') }",
        dataType: "json",
        success: function (response) {
            console.log("getFacilityName:", response);
            var res = response.replace(/"/g, '');
            resolve(res); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to fetch facility name :", error);
            reject(error);
        }
    });
});
}

async function getPIMSLastPullDate() {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getPIMSLastPullDate') }",
        dataType: "json",
        success: function (response) {
            console.log("getPIMSLastPullDate :", response);
            var res = response.replace(/"/g, '');
            resolve(res); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to fetch datim code:", error);
            reject(error);
        }
    });
});
}

// 🔄 Pull records from remote PIMS
async function fetchRemoteRecords() {

   const facilityid = await getFacilityDatimCodeForSavingRecord();
   const lastpulldate = await getPIMSLastPullDate();

   console.log("fetchRemoteRecords "+ facilityid);
    var primaryDatimCode = facilityid;
    var startDate = lastpulldate;
    var page = '1';
    var size = '10';

    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "POST",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'pullDataFromPIMS') }",
        dataType: "json",
        data: {
            'primaryDatimeCode': primaryDatimCode,
            'startDate': startDate,
            'page': page,
            'size': size
        },
        success: resolve,
        error: reject
    });
});
}

// 🔍 Resolve patient UUID from primaryDatimCode and clientIdentifier
async function getPatientUUID(clientIdentifier) {
    console.log("clientIdentifier "+ clientIdentifier);
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'getPatientUUID') }",
        dataType: "json",
        data: {
            'clientid': clientIdentifier
        },
        success: (res) => {
        console.log("Response from getPatientUUID:", res);
        var resposne = res.replace(/"/g, '');
        resolve(resposne); // Will be undefined if not returned correctly
        },
        error: () => resolve("UNKNOWN-UUID") // fallback for now
});
});
}

// 🚀 Push transformed record to local EMR
async function pushToLocalEmr(payload) {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: 'POST',
        url: '/openmrs/ws/rest/v1/encounter',
        contentType: 'application/json',
        data: JSON.stringify(payload),
        success: resolve,
        error: reject
    });
});
}


async function resolveOBSgroupIssueART(patientUUID, encounterType, encounterDatetime) {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'resolveOBSgroupIssueART') }",
       dataType: "json",
        data: {
            'patientUUID': patientUUID,
            'encounterType': encounterType,
            'encounterDatetime': encounterDatetime
        },
        success: function (response) {
            console.log("resolveOBSgroupIssueART ", response);
            resolve(response); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to resovle resolveOBSgroupIssueART:", error);
            reject(error);
        }
    });
});
}

async function resolveOBSgroupIssueOI(patientUUID, encounterType, encounterDatetime) {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'resolveOBSgroupIssueOI') }",
       dataType: "json",
        data: {
            'patientUUID': patientUUID,
            'encounterType': encounterType,
            'encounterDatetime': encounterDatetime
        },
        success: function (response) {
            console.log("resolveOBSgroupIssueOI ", response);
            resolve(response); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to resovle resolveOBSgroupIssueOI:", error);
            reject(error);
        }
    });
});
}


async function checkDuplicateEncounterAtSyc(patientUUID, encounterType, encounterDatetime) {
    return new Promise((resolve, reject) => {
        jQuery.ajax({
        type: "GET",
        url: "${ ui.actionLink('nigeriaemr', 'pims', 'checkDuplicateEncounterAtSyc') }",
       dataType: "json",
        data: {
            'patientUUID': patientUUID,
            'encounterType': encounterType,
            'encounterDatetime': encounterDatetime
        },
        success: function (response) {
            console.log("checkDuplicateEncounterAtSyc ", response);
             var res = response.replace(/"/g, '');
            resolve(res); // ✅ Return response here
        },
        error: function (error) {
            console.error("Failed to resovle checkDuplicateEncounterAtSyc:", error);
            reject(error);
        }
    });
});
}

async function syncData() {
   // const statusDiv = document.getElementById('statusSync');
    const transformed = [];
  //  statusDiv.textContent = "Saving records...";
    const DEFAULT_NULL_REPLACEMENT_UUID = "162240AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

   // try {
   //      const remoteRecords = await fetchRemoteRecords();
   //
   //      var dataArray1 = JSON.parse(remoteRecords);
   //      var dataArray = JSON.parse(dataArray1);

        // Loop through all encounters and flatten
        for (const entry of globalPulledData) {
            console.log("record.clientIdentifier ------"+ entry.clientIdentifier);

            var patientIdentifier = entry.clientIdentifier;

        const patientUUID = await getPatientUUID(patientIdentifier);

        console.log("patientUUID " +patientUUID);

            entry.pimsClientEncounters.forEach(encounter => {
            var dataArray2 = JSON.parse(encounter.encounterPayload);
            console.log("dataArray2 " +dataArray2);
            var dataArray3 = JSON.stringify(dataArray2);
            var dataArray4 = [];
            dataArray4.push(JSON.parse(dataArray3));
            console.log("dataArray4 " +dataArray4);
           // const payloadResults = encounter.encounterPayload;

            dataArray4.forEach(result => {
            var transformedEntry = {
                patient: patientUUID,  //result.patient.uuid
                encounterType: result.encounterType.uuid,
                encounterDatetime: result.encounterDatetime,
                location: null, // location is null in the example
                form: result.form.uuid,
                orders: [],
                obs: []
            };



        result.obs.forEach(o => {
            // Determine value
            let value;
        if (o.value === null) {
            value = DEFAULT_NULL_REPLACEMENT_UUID;
        } else if (typeof o.value === 'object' && o.value !== null) {
            value = o.value.uuid;
        } else {
            value = o.value;
        }

            transformedEntry.obs.push({
            concept: o.concept.uuid,
            obsDatetime: o.obsDatetime,
            value: value
        });

        // If there are groupMembers, flatten them too
        if (Array.isArray(o.groupMembers)) {
            o.groupMembers.forEach(g => {
                transformedEntry.obs.push({
                concept: g.concept.uuid,
                obsDatetime: o.obsDatetime, // use parent's obsDatetime
                value: typeof g.value === 'object' && g.value !== null ? g.value.uuid : g.value
                //obsGroup: g.obsGroup?.uuid || ''
            });
        });
        }
    });

        transformed.push(transformedEntry);
    });
    });
    };

        var e = JSON.stringify(transformed);

        console.log("transformed------"+ e);

    // } catch (err) {
    //     statusDiv.textContent += "Error fetching remote records: "+err.statusText || err+"";
    // }

    return e;
}

</script>

<script>
  async function processAndPushAll() {
        const outputElement = document.getElementById("statusSync");
        try {
            const transformedData = await syncData();
            outputElement.innerHTML = "Saving data...";

            var parsed = JSON.parse(transformedData);
            for (let i = 0; i < parsed.length; i++) {
                console.log("parsed.length------"+parsed.length);
                const payload = parsed[i];
                var a = i + 1;
                var b = parsed.length;
                outputElement.innerHTML += "<br/>Saving record "+a+" of "+b+"";
                var checkduplicatesync = await checkDuplicateEncounterAtSyc(payload.patient, payload.encounterType, payload.encounterDatetime);
                if(checkduplicatesync == ""){
                await pushToLocalEmr(payload);
                
                console.log("Patient UUIDssssssss"+payload.patient);
                console.log("Encounter Type"+payload.encounterType);
                console.log("Encounter DateTime"+payload.encounterDatetime);
                console.log("Form"+payload.form);
                await resolveOBSgroupIssueART(payload.patient, payload.encounterType, payload.encounterDatetime);
                await resolveOBSgroupIssueOI(payload.patient, payload.encounterType, payload.encounterDatetime);
                outputElement.innerHTML += "<br/>Successfully Saved record "+a+" of "+b+"";
                }else{
                    outputElement.innerHTML += "<br/>Record already exists "+a+" of "+b+"";
                }
         

            }



            outputElement.innerHTML += "<br/>All records saved successfully!";
            updatePIMSLastPullDate();
        } catch (err) {
            console.error(err);
        }
    }
</script>
<script>
    function getCurrentDateTime() {
        const now = new Date();

        const year = now.getFullYear();
        const month = String(now.getMonth() + 1).padStart(2, '0'); // Months are zero-based
        const day = String(now.getDate()).padStart(2, '0');

        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        const seconds = String(now.getSeconds()).padStart(2, '0');

        return `\${year}-\${month}-\${day} \${hours}:\${minutes}:\${seconds}`;
    }


    function updatePIMSLastPushDate() {
            jQuery.ajax({
            type: "POST",
            url: "${ ui.actionLink('nigeriaemr', 'pims', 'updatePIMSLastPushDate') }",
            dataType: "json",
            data: {
                'lastpushdate': getCurrentDateTime()
            },
            success: function (response) {
                console.log("updatePIMSLastPushDate :", response);
            },
            error: function (error) {
                console.error("Failed to fetch updatePIMSLastPushDate :", error);
            }
        });

    }

    function updatePIMSLastPullDate() {
        jQuery.ajax({
            type: "POST",
            url: "${ ui.actionLink('nigeriaemr', 'pims', 'updatePIMSLastPullDate') }",
            dataType: "json",
            data: {
                'lastpulldate': getCurrentDateTime()
            },
            success: function (response) {
                console.log("updatePIMSLastPullDate :", response);
            },
            error: function (error) {
                console.error("Failed to fetch updatePIMSLastPullDate :", error);
            }
        });

    }

    async function getPatientPharmacy(patientuuid, secondarydatimcode) {
        var emptyres =[];
        const apiUrl = '/openmrs/ws/rest/v1/encounter?patient='+patientuuid+'&encounterType=a1fa6aa3-59e1-4833-a28c-bb62f2fb07df&v=custom:(patient:(uuid),encounterType:(uuid),encounterDatetime,form:(uuid),obs:(value:(uuid),concept:(uuid),obsGroup,valueCodedName,obsDatetime,groupMembers:(concept:(uuid),voided,value:(uuid),obsGroup:(uuid))))';
        return new Promise((resolve, reject) => {
            jQuery.ajax({
            type: "GET",
            url: apiUrl,
            contentType: 'application/json',
            success: function(response) {
                if (!response || !Array.isArray(response.results) || response.results.length === 0) {
                   // throw new Error("Invalid or empty response");
                    resolve(emptyres);
                }else {
                    const encounter = response.results[0];
                    const rawDate = encounter.encounterDatetime;
                    const visitDate = new Date(rawDate).toISOString().split("T")[0];
                    const transformedPayload = {
                        VisitDate: visitDate,
                        SecondaryDatimCode: secondarydatimcode, // Static as per your request
                        EncounterType: "Pharmacy",        // Static as per your request
                        EncounterPayload: encounter       // The full encounter object as-is
                    };

                    console.log("Pharmacy Transformed Payload:", transformedPayload);
                    resolve(transformedPayload);
                }
            },
            error: function(xhr, status, error) {
                console.error("Error Pharmacy Transformed Payload:", status, error);
                reject(error);
            }
        });
    });
    }

    async function getPatientCareCard(patientuuid, secondarydatimcode) {
        var emptyres =[];
        const apiUrl = '/openmrs/ws/rest/v1/encounter?patient='+patientuuid+'&encounterType=0b8d256c-e5df-4801-9653-b6ae5b6e906b&v=custom:(patient:(uuid),encounterType:(uuid),encounterDatetime,form:(uuid),obs:(value:(uuid),concept:(uuid),obsGroup,valueCodedName,obsDatetime,groupMembers:(concept:(uuid),voided,value:(uuid),obsGroup:(uuid))))';
        return new Promise((resolve, reject) => {
            jQuery.ajax({
            type: "GET",
            url: apiUrl,
            contentType: 'application/json',
            success: function(response) {
                if (!response || !Array.isArray(response.results) || response.results.length === 0) {
                   // throw new Error("Invalid or empty response");
                    resolve(emptyres);
                }else {
                    const encounter = response.results[0];
                    const rawDate = encounter.encounterDatetime;
                    const visitDate = new Date(rawDate).toISOString().split("T")[0];
                    const transformedPayload = {
                        VisitDate: visitDate,
                        SecondaryDatimCode: secondarydatimcode, // Static as per your request
                        EncounterType: "CareCard",        // Static as per your request
                        EncounterPayload: encounter       // The full encounter object as-is
                    };

                    console.log("Care card Transformed Payload:", transformedPayload);
                    resolve(transformedPayload);
                }
            },
            error: function(xhr, status, error) {
                console.error("Error Care card Transformed Payload:", status, error);
                reject(error);
            }
        });
    });
    }

    async function getPatientLaboratory(patientuuid, secondarydatimcode) {
        var emptyres =[];
        const apiUrl = '/openmrs/ws/rest/v1/encounter?patient='+patientuuid+'&encounterType=7ccf3847-7bc3-42e5-8b7e-4125712660ea&v=custom:(patient:(uuid),encounterType:(uuid),encounterDatetime,form:(uuid),obs:(value:(uuid),concept:(uuid),obsGroup,valueCodedName,obsDatetime,groupMembers:(concept:(uuid),voided,value:(uuid),obsGroup:(uuid))))';
        return new Promise((resolve, reject) => {
            jQuery.ajax({
            type: "GET",
            url: apiUrl,
            contentType: 'application/json',
            success: function(response) {
                if (!response || !Array.isArray(response.results) || response.results.length === 0) {
                   // throw new Error("Invalid or empty response");
                    resolve(emptyres);
                }else {
                    const encounter = response.results[0];
                    const rawDate = encounter.encounterDatetime;
                    const visitDate = new Date(rawDate).toISOString().split("T")[0];
                    const transformedPayload = {
                        VisitDate: visitDate,
                        SecondaryDatimCode: secondarydatimcode, // Static as per your request
                        EncounterType: "Lab",        // Static as per your request
                        EncounterPayload: encounter       // The full encounter object as-is
                    };

                    console.log("Laboratory Transformed Payload:", transformedPayload);
                    resolve(transformedPayload);
                }
            },
            error: function(xhr, status, error) {
                console.error("Error Laboratory Transformed Payload:", status, error);
                reject(error);
            }
        });
    });
    }
    function getEncounterLabelsDate(input) {
        const encounters = {
            "a1fa6aa3-59e1-4833-a28c-bb62f2fb07df": "Pharmacy",
            "0b8d256c-e5df-4801-9653-b6ae5b6e906b": "Care Card",
            "7ccf3847-7bc3-42e5-8b7e-4125712660ea": "Laboratory"
        };

        var a = JSON.stringify(input)
        for (const uuid in encounters) {
            const label = encounters[uuid];
            const regex = new RegExp(uuid, 'g'); // global replace
            a = a.replace(regex, label+":");
        }

        return a.replace(/[",[\\]]/g, ' ');

    }

</script>
<script>
    document.addEventListener('click', function (e) {
        if (e.target && e.target.classList.contains('btn-mymodal')) {

            const clientId = e.target.getAttribute('data-client-id');
            const html = processData(globalPulledData, clientId);
            openModal(html);
        }
    });
    function openModal(viewrecords) {
        document.getElementById("modalContent").innerHTML = viewrecords;
        document.getElementById('myModal').style.display = 'block';
    }

    function closeModal() {
        document.getElementById('myModal').style.display = 'none';
    }

    // Optional: click outside to close
    window.onclick = function(event) {
        const modal = document.getElementById('myModal');
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    };
</script>