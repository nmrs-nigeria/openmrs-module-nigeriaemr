<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<div class="row wrapper  white-bg page-heading"  style="">

    <h4 style="text-align: center">
        NDR Export
    </h4>
</div>

<!--- NDR AUTHENTICATION FOR API  HANDSHAKE --->
<div id="ndrAuth" class="dialog" style="display: none; padding: 20px; position: absolute; z-index: 999; margin-left: 16.2%; margin-right: 15%;">
    <div style="padding: 20px; position: absolute; z-index: 999; margin-top: -6%; width: 440px;">
        <button type="button" class="close" aria-label="Close" style="background: #dddddd !important; float: right;" title="Close" onclick="cancelAuth()">
            <span aria-hidden="true" style="font-size: 20px; font-weight: bold;">&times;</span>
        </button>
    </div>
    <div id="waitDiv">
        <div class="col-md-7 col-xs-7 " style="text-align:center; padding-top: 4%; padding-bottom: 3%">
            <div class="col-md-3 col-xs-3 offset-2" id="waitGif" style="display: none">
                <img src="../moduleResources/nigeriaemr/images/Sa7X.gif" alt="Loading Gif"  style="width:40px">
            </div>
            <h4 id="apiInfo" style="overflow: auto; font-size: 1em !important; color: #000 !important; margin-top: 30px;">Please wait, Checking if NDR API credentials already exists...</h4>
        </div>
        <div style="width: 45%; display: none" id="pushData">
            <input id="btnPushData" style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Push failed Data" onclick="initNDRPush()" class="btn btn-primary" />
        </div>
        <br/>
    </div>
    <div style="display: none" id="login">
        <div id="authHeader" style="border-bottom: #6c757d 1px solid; margin-bottom: 12px;">
            <div class="col-md-7 col-xs-7 " style="text-align:left;">
                <h5>Authenticate with the NDR</h5>
            </div>
        </div>
        <br/>
        <div>
            <label style="color: #000; font-size: 14px">NDR Login Email</label><br/>
            <input autocomplete="off" style="background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px; padding-left: 18px; padding-right: 10px" type="email" id="email"><br/>
        </div>
        <br/>
        <div>
            <label style="color: #000; font-size: 14px">NDR Login Password</label><br/>
            <input autocomplete="off" style="font-weight: bold;padding-left: 10px; padding-right: 10px; background-color: #E8F0FE; width: 95%; height: 45px; border-radius: 10px; margin-top: 15px;" id="password" type="password"  /><br/>
        </div>
        <br/>
        <div style="display: flex">
            <div style="width: 50%">
                <input style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 94%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Submit" onclick="authApi()" id="authBtn" class="btn btn-primary" />
            </div>
            <div style="width: 50%;">
                <input style="font-weight: bold; background-color: #E8F0FE; width: 88%; height: 45px; border-radius: 10px; margin-top: 15px; float: right" id="btnCancel" type="button" value="Cancel" onclick="cancelAuth()" class="btn btn-cancel" />
            </div>
        </div>
    </div>
</div>

<div id="gen-wait" class="dialog" style="display: none; padding: 20px; position: absolute; z-index: 999; margin-left: 16.2%; margin-right: 15%;">
    <div class="row">
        <div class="col-md-3 col-xs-3 offset-2" >
            <img src="../moduleResources/nigeriaemr/images/Sa7X.gif" alt="Loading Gif"  style="width:100px">
        </div>
    </div>
    <div>
        <div class="col-md-7 col-xs-7 " style="text-align:center;">
            <h1>Please wait, operation in progress...</h1>
        </div>
    </div>
</div>

<!--- END OF NDR AUTHENTICATION FOR API  HANDSHAKE --->

<div class="container" style="padding-top: 10px;">
    <div style="margin-left: 28%; width: 50%; height: 50%; background-color: #00463f; border-radius: 10px; " id="customDiv">
        <br/> <br/>
        <div style="padding-left: 38px">
            <label for="custom" style="font-weight: bold; color: white; cursor: pointer;">
                <input style="background-color: #E8F0FE; border-radius: 10px; margin-top: 15px; cursor: pointer" type="checkbox" id="custom" name="custom" value="custom" onclick="checkBoxCheck()">
                Custom
            </label>
            <br id="br1">
            <input style="background-color: #E8F0FE; width: 85%; height: 45px; border-radius: 10px; margin-top: 15px; padding-left: 18px; padding-right: 10px; display: none" type="text" value="comma separated patient identifiers or Ids" id="identifiers" onfocus=this.value='' name="identifiers"><br id="br2">
            <br/>
            <label for="customStart" id="labelCustomStart" style="font-weight: bold; cursor: pointer;color: white; width: 70%; height: 45px; margin-bottom: 15px; margin-top: 15px; display: none">
                <input  style="cursor: pointer;background-color: #E8F0FE; border-radius: 10px; margin-top: 15px; margin-bottom: 15px; display: none" type="checkbox" id="customStart" name="customStart" value="customStart" onclick="checkBoxStartCheck()">
                Export from Inception
            </label>
            <br/>
            <br id="br3"/>
            <div style="display: flex;">
                <div>
                    <label id="lblfrom" for="from" style="font-weight: bold; color: white; display:none;">Start Date</label><br id="br4">
                    <input style="font-weight: bold;padding-left: 10px; padding-right: 10px; background-color: #E8F0FE; margin-bottom: 15px; width: 85%; height: 45px; border-radius: 10px; margin-top: 15px; display:none" id="from" type="date"  /><br id="br5">
                </div>
                <div style="margin-left: 30px;" id="endR">
                    <label id="lblto" for="to" style="font-weight: bold; color: white;  display:none;">End Date</label><br id="br6">
                    <input disabled="disabled" style="font-weight: bold;padding-left: 10px; padding-right: 10px; background-color: #E8F0FE; width: 87%; height: 45px; border-radius: 10px; margin-top: 15px; display:none" id="to" type="date"  /><br id="br7">
                </div>
            </div>
            <br/>
            <div style="display: flex;">
                <div style="width: 45%">
                    <input style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Export" onclick="exportData()" id="exportData" class="btn btn-primary" />
                </div>
                <div style="width: 48%; margin-left: 5%">
                    <input style="font-weight: bold; background-color: #E8F0FE; width: 88%; height: 45px; border-radius: 10px; margin-top: 15px; display: none" id="btnClear" type="button" value="Clear" onclick="clearData()" class="btn btn-primary" />
                </div>
            </div>
        </div>
        <br/>
        <br/>
    </div>
    <br/>
    <div style="margin-left: 32%; width: 40%; height: 50%; display: flex; border-top: 1px #e0e0e0 solid; border-bottom: 1px #e0e0e0 solid; padding-top: 10px; padding-bottom: 10px" class="row">
        <div class="col-md-3">
            <label for="asXml" style="color: #000; font-weight: bold; cursor: pointer">
                <input style="cursor: pointer" type="radio" id="asXml" name="extOpt" value="Xml" onclick="setExtractionOpt('xml')"/>
                Extract as XML
            </label>
        </div>
        <div class="col-md-3" style="margin-left: 18%">
            <label for="asJson" style="color: #000; font-weight: bold; cursor: pointer">
                <input style="margin-left: 10px; cursor: pointer" type="radio" id="asJson" value="asJson" name="extOpt" onclick="setExtractionOpt('json')"/>
                Extract as JSON <i style="font-size: 20px;" id="json-hint" class="icon-info-sign" title="Please ensure you have an active internet connection"></i>
            </label>
        </div>
    </div>
    <br/>
    <div class="table-responsive">
        <table class="table table-striped table-bordered  table-hover" id="tb_commtester">
            <thead>
            <tr>
                <th>${ ui.message("Created By") }</th>
                <th>${ ui.message("File Name") }</th>
                <th>${ ui.message("Date Started") }</th>
                <th>${ ui.message("Date Completed") }</th>
                <th>${ ui.message("Total No. of Patients") }</th>
                <th>${ ui.message("status") }</th>
                <th>${ ui.message("Actions") }</th>
            </tr>
            </thead>
            <tbody id="TableBody">

            </tbody>
        </table>
    </div>
    <script src="../moduleResources/nigeriaemr/scripts/sockjs.min.js"></script>
    <script src="../moduleResources/nigeriaemr/scripts/stomp.min.js"></script>
</div>

<script>
    let lastNDRRunDate = '${lastNDRRunDate}'
    console.log(lastNDRRunDate)
    let extractionOpt = 'xml';
    let exportTriggered = false;
    let apiPushDone = false;
    let totalJSONFiles = 0;
    let totalPushed = 0;
    let isOnline = false;
    let processingFile = 0;
    let processing = false;
    jq = jQuery;

    jq(document).ready(function ()
    {
        const rdo =  document.getElementById("asXml");
        rdo.checked = true;
        checkPendingJsonFiles();
    });

    checkBoxCheck();
    function checkBoxCheck()
    {
        const checkBox = document.getElementById("custom");
        if (checkBox.checked === true){
            document.getElementById('identifiers').style.display =  'inline';
            document.getElementById('from').style.display =  'inline';
            document.getElementById('to').style.display =  'inline';
            document.getElementById('to').value  =  lastNDRRunDate;
            document.getElementById('btnClear').style.display =  'inline';
            document.getElementById('customStart').style.display =  'inline';
            checkBoxStartCheck()
            document.getElementById('labelCustomStart').style.display =  'inline';
            document.getElementById('lblfrom').style.display =  'inline';
            document.getElementById('lblto').style.display =  'inline';
            document.getElementById('br1').style.display =  'inline';
            document.getElementById('br2').style.display =  'inline';
            document.getElementById('br3').style.display =  'inline';
            document.getElementById('br4').style.display =  'inline';
            document.getElementById('br5').style.display =  'inline';
            document.getElementById('br6').style.display =  'inline';
            document.getElementById('br7').style.display =  'inline';
            jq("#tb_commtester tbody tr").remove();
        }else{
            document.getElementById('identifiers').style.display =  'none';
            document.getElementById('from').style.display =  'none';
            document.getElementById('to').style.display =  'none';
            document.getElementById('btnClear').style.display =  'none';
            document.getElementById('customStart').style.display =  'none';
            document.getElementById('labelCustomStart').style.display =  'none';
            document.getElementById('lblfrom').style.display =  'none';
            document.getElementById('lblto').style.display =  'none';
            document.getElementById('br1').style.display =  'none';
            document.getElementById('br2').style.display =  'none';
            document.getElementById('br3').style.display =  'none';
            document.getElementById('br4').style.display =  'none';
            document.getElementById('br5').style.display =  'none';
            document.getElementById('br6').style.display =  'none';
            document.getElementById('br7').style.display =  'none';
            jq("#tb_commtester tbody tr").remove();
        }
        loadFileListDefault(true);
    }

    function setExtractionOpt(opt)
    {
        extractionOpt = opt;
        if(opt === 'json')
        {
            let url = "${ ui.actionLink("nigeriaemr", "ndr", "checkAuth") }";
            disableControls();

            let ndrAuth = jq('#ndrAuth');
            let waitDiv = jq('#waitDiv');
            let apiInfo = jq('#apiInfo');
            let login = jq('#login');

            apiInfo.html('Please wait, Checking if NDR API credentials already exists...');
            waitDiv.show();
            ndrAuth.show();

            jq.ajax({
                url: url,
                dataType: "json"
            }).success(function(res)
            {
                console.log(res);
                if (res.code > 0 && (res.token !== null && res.token.length > 0))
                {
                    apiInfo.html('Please wait, Checking if NDR API credentials already exists...');
                    ndrAuth.hide();
                    waitDiv.show();
                    login.hide();
                    enableControls();
                }
                else{
                    alert(res.message);
                    waitDiv.hide();
                    login.show();
                }
            })
                .error(function(xhr, status, err)
                {
                    extractionOpt = 'xml';
                    const rdo =  document.getElementById("asXml");
                    rdo.checked = true;
                    alert(err);
                    ndrAuth.hide();
                });
        }
    }

    function authApi()
    {
        let email = jq('#email').val();
        let password = jq('#password').val();
        let ndrAuth = jq('#ndrAuth');
        let waitDiv = jq('#waitDiv');
        let apiInfo = jq('#apiInfo');
        let login = jq('#login');

        let authBtn = jq('#authBtn');
        let btnCancel = jq('#btnCancel');

        // let waitGif = jq('#waitGif');

        if(email === null || email.length < 1)
        {
            alert('Please provide your NDR log in Email');
            return;
        }
        if(password === null || password.length < 1)
        {
            alert('Please provide your NDR log in Password');
            return;
        }

        authBtn.attr('value', 'Please wait...').css('font-style', 'italic').prop('disabled', true);
        btnCancel.attr('enabled', 'false');

        let url = "${ ui.actionLink("nigeriaemr", "ndr", "auth") }";
        jq.ajax({
            url: url,
            dataType: "json",
            data: {
                'email' : email,
                'password': password
            }
        }).success(function(res)
        {
            if (res !== undefined && res !== null  && res.token !== undefined && res.token !== null && res.token.length > 0)
            {
                alert("Authentication with NDR successful!");
                apiInfo.html('Please wait, Checking if NDR API credentials already exists...');
                ndrAuth.hide();
                waitDiv.show();
                // waitGif.show();
                login.hide();
                jq('#email').val('');
                jq('#password').val('');
                enableControls();
            }
            else{
                alert(res.message);
                waitDiv.hide();
                // waitGif.hide();
            }

            authBtn.attr('value', 'Submit').css('font-style', 'normal').prop('disabled', false);
            btnCancel.attr('enabled', 'true');
        })
            .error(function(xhr, status, err)
            {
                alert("Authentication with NDR failed. Please ensure your credentials are correct. " + err);
                authBtn.attr('value', 'Submit').css('font-style', 'normal').attr('enabled', 'true');
                btnCancel.attr('enabled', 'true');
                waitDiv.hide();
                // waitGif.hide();
            });
    }

    function cancelAuth()
    {
        extractionOpt = 'xml';
        document.getElementById("asXml").checked = true;
        enableControls();
        jq('#ndrAuth').hide();
        jq('#email').val('');
        jq('#password').val('');
        jq('#apiInfo').html('Please wait, Checking if NDR API credentials already exists...');
        jq('#login').hide();
        jq('#waitDiv').show();
        // jq('#waitGif').hide();
    }

    function enableControls()
    {
        // jq('#customDiv').show();
        jq('#exportData').attr('enabled', 'true');
        jq('#btnClear').attr('enabled', 'true');
    }
    function disableControls()
    {
        // jq('#customDiv').hide();
        jq('#exportData').attr('enabled', 'false');
        jq('#btnClear').attr('enabled', 'false');
    }

    function checkBoxStartCheck()
    {
        const checkBox = document.getElementById("customStart");
        if (checkBox.checked === true){
            document.getElementById('from').value =  '';
            document.getElementById('from').style.display =  'none';
            document.getElementById('lblfrom').style.display =  'none';
            document.getElementById('br4').style.display =  'none';
            document.getElementById('br5').style.display =  'none';
            document.getElementById('endR').style.marginLeft =  '';
        }else{
            document.getElementById('lblfrom').style.display =  'inline';
            document.getElementById('from').style.display =  'inline';
            document.getElementById('br4').style.display =  'inline';
            document.getElementById('br5').style.display =  'inline';
            document.getElementById('endR').style.marginLeft =  '30px';
        }
    }

    function clearData()
    {
        document.getElementById('identifiers').value = ''
        document.getElementById('from').value = ''
        // document.getElementById('to').value = ''
    }

    function exportData()
    {
        exportTriggered = true;
        apiPushDone = false;
        processingFile = 0;
        processing = true;

        const checkBox = document.getElementById("custom");
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "generateNDRFile") }"
        if (checkBox.checked === true){
            url = "${ ui.actionLink("nigeriaemr", "ndr", "generateCustomNDRFile") }"
        }

        let identifiers = jq('#identifiers').val();
        const from = (jq('#from').val() == "")? "1990-01-01" : jq('#from').val();
        // const to = jq('#to').val();

        if(identifiers === "comma separated patient identifiers or Ids")
            identifiers = '';

        jq('#gen-wait').show();

        jq.ajax({
            url: url,
            dataType: "json",
            data: {
                'identifiers' : identifiers,
                // 'to' : to,
                'from' : from,
                'opt': extractionOpt
            }

        }).success(function(filename)
        {
            //Old implementation
            if (filename.endsWith(".zip")){
                jq('#gen-wait').hide();
                window.location = filename;
                loadFileList();
                checkUp();
            }else{
                alert(filename)
                jq('#gen-wait').hide();
                loadFileList();
                checkUp();
            }
            jq('#gen-wait').hide();
        })
            .error(function(xhr, status, err) {
                console.log(status);
                if(status === 'timeout'){
                    alert("the export will take a while, the list will be updated when it's done");
                    loadFileList();
                }else {
                    alert('There was an error generating all NDR files, check generated files at downloads directory in the application root folder ' + err);
                    loadFileList();
                }//popupDialog.close();
                jq('#gen-wait').hide();

            });

    }

    jq = jQuery;
    jq('#wait').hide();
    jq(function()
    {
        loadFileList();
    });

    function loadFileList()
    {
        if(loadFileListDefault(true))
        {
            refresher
        }
        // loadFileListDefault(true);
    }

    function loadFileListDefault(showProgressDialog)
    {
        if (showProgressDialog) jq('#gen-wait').show();
        const checkBox = document.getElementById("custom");
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getFileList") }"
        if (checkBox.checked === true){
            url = "${ ui.actionLink("nigeriaemr", "ndr", "getManualFileList") }"
        }
        //load all file generated

        jq.getJSON(url).success(function (fileList)
        {
            jq("#TableBody").empty();
            const fileListObj = jq.parseJSON(fileList);

            //check to see if there is a processing file
            //This check is very important for data push directly to the NDR via API
            let processingFiles = fileListObj.filter(function(p)
            {
                return !p.active || p.status === "Processing";
            });

            if(processingFiles.length > 0)
            {
                processingFile = processingFiles.length;
                processing = true;
            }
            else
            {
                processing = false;
            }

            for (let i = 0; i < fileListObj.length; i++)
            {
                let success = (fileListObj[i].status).includes('Completed');
                let Paused = (fileListObj[i].status) === 'Paused';
                if(fileListObj[i].active)
                {
                    if(success)
                    {
                        if(fileListObj[i].hasError)
                        {
                            jq('#TableBody')
                                .append("<tr>" +
                                    "<td>" + fileListObj[i].owner + "</td>" +
                                    "<td>" + fileListObj[i].name + "</td>" +
                                    "<td>" + fileListObj[i].dateStarted + "</td>" +
                                    "<td>" + fileListObj[i].dateEnded + "</td>" +
                                    "<td>" + fileListObj[i].total + "</td>" +
                                    "<td>" + fileListObj[i].status + "</td>" +
                                    "<td>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-download edit-action\" title=\"download valid files\" onclick=\"downloadFile('" + fileListObj[i].path + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-download-alt edit-action\" title=\"download error files\" onclick=\"downloadFile('" + fileListObj[i].errorPath + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-cloud-download edit-action\" title=\"download error file list\" onclick=\"downloadFile('" + fileListObj[i].errorList + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-remove edit-action\" title=\"delete file\" onclick=\"deleteFile('" + fileListObj[i].number + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-refresh edit-action\" title=\"rerun Failed Files\" onclick=\"restartErrorFile('" + fileListObj[i].number + "')\"></i>" +
                                    "</td>" +
                                    "</tr>");
                        }else {
                            jq('#TableBody')
                                .append("<tr>" +
                                    "<td>" + fileListObj[i].owner + "</td>" +
                                    "<td>" + fileListObj[i].name + "</td>" +
                                    "<td>" + fileListObj[i].dateStarted + "</td>" +
                                    "<td>" + fileListObj[i].dateEnded + "</td>" +
                                    "<td>" + fileListObj[i].total + "</td>" +
                                    "<td>" + fileListObj[i].status + "</td>" +
                                    "<td>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-download edit-action\" title=\"download file\" onclick=\"downloadFile('" + fileListObj[i].path + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-remove edit-action\" title=\"delete file\" onclick=\"deleteFile('" + fileListObj[i].number + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-refresh edit-action\" title=\"rerun Files\" onclick=\"restartFile('" + fileListObj[i].number + "')\"></i>" +
                                    "</td>" +
                                    "</tr>");
                        }
                    }else{
                        if(Paused) {
                            jq('#TableBody')
                                .append("<tr>" +
                                    "<td>" + fileListObj[i].owner + "</td>" +
                                    "<td>" + fileListObj[i].name + "</td>" +
                                    "<td>" + fileListObj[i].dateStarted + "</td>" +
                                    "<td>" + fileListObj[i].dateEnded + "</td>" +
                                    "<td>" + fileListObj[i].total + "</td>" +
                                    "<td>" + fileListObj[i].status + "</td>" +
                                    "<td>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-play edit-action\" title=\"resume\" onclick=\"resumeFile('" + fileListObj[i].number + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-remove edit-action\" title=\"delete file\" onclick=\"deleteFile('" + fileListObj[i].number + "')\"></i>" +
                                    "</td>" +
                                    "</tr>");
                        }else {
                            jq('#TableBody')
                                .append("<tr>" +
                                    "<td>" + fileListObj[i].owner + "</td>" +
                                    "<td>" + fileListObj[i].name + "</td>" +
                                    "<td>" + fileListObj[i].dateStarted + "</td>" +
                                    "<td>" + fileListObj[i].dateEnded + "</td>" +
                                    "<td>" + fileListObj[i].total + "</td>" +
                                    "<td>" + fileListObj[i].status + "</td>" +
                                    "<td>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-refresh edit-action\" title=\"restart\" onclick=\"restartFile('" + fileListObj[i].number + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-download-alt edit-action\" title=\"download error files\" onclick=\"downloadFile('" + fileListObj[i].errorPath + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-cloud-download edit-action\" title=\"download error file list\" onclick=\"downloadFile('" + fileListObj[i].errorList + "')\"></i>" +
                                    "<i style=\"font-size: 20px;\" class=\"icon-remove edit-action\" title=\"delete file\" onclick=\"deleteFile('" + fileListObj[i].number + "')\"></i>" +
                                    "</td>" +
                                    "</tr>");
                        }
                    }
                }else
                {
                    jq('#TableBody')
                        .append("<tr style=\"opacity:0.6;filter: alpha(opacity = 60)\">" +
                            "<td>" + fileListObj[i].owner + "</td>" +
                            "<td>" + fileListObj[i].name + "</td>" +
                            "<td>" + fileListObj[i].dateStarted + "</td>" +
                            "<td>" + fileListObj[i].dateEnded + "</td>" +
                            "<td>" + fileListObj[i].total + "</td>" +
                            "<td>" + fileListObj[i].status + "</td>" +
                            "<td>" +
                            "<img id=\"loadingImg"+i+"\" src=\"../moduleResources/nigeriaemr/images/Sa7X.gif\" alt=\"Loading Gif\"  style=\"width:25px\"> <p>"+fileListObj[i].progress+"</p>" +
                            "<i style=\"font-size: 20px;\" class=\"icon-refresh edit-action\" title=\"restart\" onclick=\"refreshList()\"></i>" +
                            "<i style=\"font-size: 20px;\" class=\"icon-pause edit-action\" title=\"pause\" onclick=\"pauseFile('" + fileListObj[i].number + "')\"></i>" +
                            "</td>" +
                            "</tr>");
                }
            }
            jq('#gen-wait').hide();

        }).error(function (xhr, status, err)
        {
            if (showProgressDialog) alert('There was an error loading file list ' + err);
            jq('#gen-wait').hide();
        });
        return processing
    }

    //This function is very important in determining whe extraction competes
    //so that Data push to the NDR can commence if JSON option was selected
    function checkUp()
    {
        const checkPending = setInterval(function()
        {
            if(processingFile > 0 && exportTriggered && extractionOpt === 'json')
            {
                if(!apiPushDone && !processing)
                {
                    processingFile = 0;
                    apiPushDone = true;
                    exportTriggered = false;
                    initNDRPush(checkPending);
                }
            }

        }, 5000);
    }

    //Check for internet connectivity by pinging the NDR API Endpoint
    //to ensure data push is not initiated when offline
    const checkOnlineStatus = async () =>
    {
        try
        {
            const ping = await fetch("http://ndrstaging.phis3project.org.ng:8087/v1/utils/ping");
            // const ping = await fetch("https://localhost:44351/v1/utils/ping");
            return ping.status >= 200 && ping.status < 300; // either true or false
        }
        catch (err)
        {
            alert("You do not have an active internet connection");
            return false;
        }
    };

    async function checkPendingJsonFiles()
    {
        totalJSONFiles = 0;
        totalPushed = 0;
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getTotalFiles") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            if (res !== undefined && res !== null && res > 0)
            {
                totalJSONFiles = res;
                let message = "<br/><span>Found some files yet to be pushed to the NDR.</span>" +
                    "<br/><span>Total Patient (s) To be pushed: </span><span style=\"font-weight: bold;\">" +  totalJSONFiles + "</span>" +
                    "<br/><span>Total Patient(s) pushed: </span><span style=\"font-weight: bold;\" id='totalPushed'>" + totalPushed + "</span></span>";

                jq('#ndrAuth').show();
                jq('#btnPushData').prop('disabled', false);
                jq('#waitDiv').show();
                jq('#apiInfo').html(message);
                jq('#btnPushData').val('Push Data');
                jq('#pushData').show();
            }
        })
            .error(function(xhr, status, err)
            {
                //handle error
            });
    }

    async function initNDRPush(checkPending)
    {
        totalJSONFiles = 0;
        totalPushed = 0;
        isOnline = await checkOnlineStatus();
        clearInterval(checkPending);
        if(!isOnline)
        {
            alert("You do not have an active internet connectivity");
            extractionOpt = 'xml';
            const rdo =  document.getElementById("asXml");
            return;
        }

        let ndrAuth = jq('#ndrAuth');
        let apiInfo = jq('#apiInfo')
        let waitGif = jq('#waitGif');
        let pushData = jq('#pushData');
        let btnPushData = jq('#btnPushData');
        btnPushData.val('Please wait...');
        btnPushData.prop('disabled', true);
        jq('#apiInfo').html('Evaluating data to be pushed to the NDR. Please wait...');
        jq('#login').hide();
        jq('#waitDiv').show();
        waitGif.show();
        ndrAuth.show();

        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getTotalFiles") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            apiPushDone = true;
            if (res !== undefined && res !== null && res > 0)
            {
                totalJSONFiles = res;
                let message = "<span>Total Extracted Valid Patient Data: </span><span style=\"font-weight: bold;\">" +  totalJSONFiles + "/span>" +
                    "<br/><span>Total Patient Data pushed: </span><span style=\"font-weight: bold;\" id='totalPushed'>" + totalPushed + "</span></span>"
                apiInfo.html(message);
                pushD();
            }
            else
            {
                let message = "<br/><span>There are no patient data to be pushed to the NDR</span>";
                apiInfo.html(message);
                waitGif.css('display', 'none');
                apiInfo.html("There no valid JSON data to be pushed to the NDR");
            }
        })
            .error(function(xhr, status, err)
            {
                apiPushDone = true;
                waitGif.css('display', 'none');
                apiInfo.html("An error was encountered " + err);
                btnPushData.val('Push Data');
                btnPushData.prop('disabled', false);
                pushData.show();
            });
    }

    async function pushD()
    {
        let apiInfo = jq('#apiInfo')
        let waitGif = jq('#waitGif');
        let pushData = jq('#pushData');
        let btnPushData = jq('#btnPushData');
        isOnline = await checkOnlineStatus();
        if(!isOnline)
        {
            alert("You do not have an active internet connectivity");
            if (totalPushed < totalJSONFiles)
            {
                let message = "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                btnPushData.val('Push Data');
                pushData.show();
                waitGif.css('display', 'none');
                apiInfo.append(message);
                btnPushData.prop('disabled', false);
            }
            return;
        }
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "pushBatchData") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            if (res !== undefined && res !== null && res.code > 0)
            {
                let message = "";

                if (res.totalPushed > 0)
                {
                    totalPushed += res.totalPushed;
                    jq('#totalPushed').html(totalPushed);

                    if (totalPushed == totalJSONFiles)
                    {
                        message = "<br/><br/><span>All Patient data has been successfully pushed to the NDR.</span>";
                        waitGif.css('display', 'none');
                        apiInfo.append(message);
                        btnPushData.prop('disabled', false);
                        pushData.hide();
                    }
                    else
                    {
                        if (totalPushed > totalJSONFiles)
                        {
                            message = "<br/><br/><span>All Patient data has been successfully pushed to the NDR.</span>";
                            waitGif.css('display', 'none');
                            apiInfo.append(message);
                            btnPushData.prop('disabled', false);
                            pushData.hide();
                        }
                        else{
                            //continue the pushing data to the NDR
                            pushD();
                        }
                    }
                }
                else
                {
                    waitGif.css('display', 'none');
                    btnPushData.prop('disabled', false);

                    if (totalPushed == totalJSONFiles)
                    {
                        message = "<br/><br/><span>All Patient data has been successfully pushed to the NDR.</span>";
                        pushData.hide();
                    }
                    else
                    {
                        if (totalPushed < totalJSONFiles)
                        {
                            message = "<br/><span style=" + "font-size: 0.96em !important;" + ">Some Patients data were not successfully pushed to the NDR.</span>" +
                                "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                            btnPushData.val('Push remaining Data');
                            pushData.show();
                        }
                    }
                    apiInfo.append(message);
                }
            }
            else
            {
                waitGif.css('display', 'none');
                btnPushData.prop('disabled', false);
                let message = "";
                if (totalPushed == totalJSONFiles)
                {
                    message = "<br/><br/><span>All Patient data has been successfully pushed to the NDR.</span>";
                    apiInfo.append(message);
                    pushData.hide();
                }
                else
                {
                    if(totalPushed < 1)
                    {
                        message = (res.message !== null && res.message.length > 0)? "<br/><span style=" + "font-size: 0.96em !important;" + ">" + res.message + "</span>": "<br/><span>An unknown error was encountered. Patients' data could not be pushed to the NDR.</span>";
                        message += "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                        btnPushData.val('Push Data');
                    }
                    else
                    {
                        message = "<br/><span style=" + "font-size: 0.96em !important;" + ">Some Patients data were not successfully pushed to the NDR.</span>" +
                            "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                        btnPushData.val('Push remaining Data');
                    }
                    apiInfo.append(message);
                    pushData.show();
                }
            }
        })
            .error(function(xhr, status, err)
            {
                apiPushDone = true;
                let message = "";
                waitGif.css('display', 'none');
                if(totalPushed < 1)
                {
                    message = (err !== null && err.length > 0)? "<br/><span style=" + "font-size: 0.96em !important;" + ">" + err + "</span>": "<br/><span>An unknown error was encountered. Patients' data could not be pushed to the NDR.</span>";
                    message += "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                    btnPushData.val('Push Data');
                }
                else
                {
                    message = "<br/><span style=" + "font-size: 0.96em !important;" + ">Some Patients data were not successfully pushed to the NDR.</span>" +
                        "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                    btnPushData.val('Push remaining Data');
                }
                apiInfo.append(message);
                pushData.show();
            });
    }

    function refreshList()
    {
        loadFileList();
    }

    const refresher = setInterval(function ()
    {
        loadFileListDefault(false);
    }, 10000);

    function restartErrorFile(id){
        if (confirm("Are you sure you want to restart ? this will rerun failed files?") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "restartFile") }",
                    dataType: "json",
                    data: {
                        'id' : id,
                        'action' : 'failed'
                    }

                }).success(function(data) {
                    jq('#gen-wait').hide();
                    if(data){
                        alert('restart');
                        loadFileList()
                    }else{
                        alert('There was an error restarting');
                        loadFileList()
                    }

                })
                    .error(function(xhr, status, err) {
                        jq('#gen-wait').hide();
                        alert('There was an error restarting');
                        loadFileList()
                    });
            }
        }
    }

    function restartFile(id){
        if (confirm("Are you sure you want to restart ? this will delete your previous file and restart the export from the beginning") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "restartFile") }",
                    dataType: "json",
                    data: {
                        'id' : id,
                        'action' : 'none'
                    }

                }).success(function(data) {
                    jq('#gen-wait').hide();
                    if(data){
                        alert('restart');
                        loadFileList()
                    }else{
                        alert('There was an error restarting');
                        loadFileList()
                    }

                })
                    .error(function(xhr, status, err) {
                        jq('#gen-wait').hide();
                        alert('There was an error restarting');
                        loadFileList()
                    });
            }
        }
    }

    function resumeFile(id){
        if (confirm("Are you sure you want to resume ?") === true)
        {
            exportTriggered = true;
            apiPushDone = false;
            processing = true;

            jq('#gen-wait').show();
            if(id)
            {
                jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "resumeFile") }",
                    dataType: "json",
                    data: {
                        'id' : id
                    }

                }).success(function(data) {
                    jq('#gen-wait').hide();
                    if(data){
                        alert('resumed');
                        loadFileList();
                        checkUp();
                    }else{
                        alert('There was an error restarting');
                        loadFileList()
                    }

                })
                    .error(function(xhr, status, err) {
                        jq('#gen-wait').hide();
                        alert('There was an error restarting');
                        loadFileList()
                    });
            }
        }
    }

    function deleteFile(id){
        if (confirm("Are you sure you want to delete this file ?") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "deleteFile") }",
                    dataType: "json",
                    data: {
                        'id' : id
                    }

                }).success(function(data) {
                    jq('#gen-wait').hide();
                    if(data){
                        alert('file deleted');
                        loadFileList()
                    }else{
                        alert('There was an error deleting file');
                        loadFileList()
                    }

                })
                    .error(function(xhr, status, err) {
                        jq('#gen-wait').hide();
                        alert('There was an error deleting file');
                        loadFileList()
                    });
            }
        }
    }

    function pauseFile(id){
        if (confirm("Are you sure you want to pause the process ?") === true) {
            jq('#gen-wait').show();
            if(id)
            {;
                jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "pauseFile") }",
                    dataType: "json",
                    data: {
                        'id' : id
                    }

                }).success(function(data) {
                    jq('#gen-wait').hide();
                    if(data){
                        alert('paused');
                        loadFileList()
                    }else{
                        alert('There was an error pausing the process');
                        loadFileList()
                    }

                })
                    .error(function(xhr, status, err) {
                        jq('#gen-wait').hide();
                        alert('There was an error stopping the process');
                        loadFileList()
                    });
            }
        }
    }

    function downloadFile(file){
        window.location = file
    }
</script>