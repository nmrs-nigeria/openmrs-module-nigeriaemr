<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<div class="wrapper  white-bg page-heading">

    <h4 style="text-align: center">
        NDR Export
    </h4>
</div>

<!--- NDR AUTHENTICATION FOR API  HANDSHAKE --->
<div id="ndrAuth" class="dialog" style="display: none; padding: 20px; position: absolute; z-index: 999; margin-left: 16.2%; margin-right: 15%;">
    <div style="padding: 20px; position: absolute; z-index: 999; margin-top: -4%; width: 450px; background-color: #e8e8e8; height: 15px; margin-left: -20px;">
        <span id="msg-hdr-gen" style="font-weight: bold"></span>
        <button type="button" class="close" aria-label="Close" style="background: #e8e8e8 !important; float: right; margin-top: -13px; margin-right: -18px;" title="Close" onclick="cancelAuth()">
            <span aria-hidden="true" style="font-size: 20px; font-weight: bold;">&times;</span>
        </button>
    </div>
    <div id="waitDiv">
        <div class="col-md-12 col-xs-12" style="text-align:center; padding-top: 6%; padding-bottom: 3%">
            <div class="col-md-3 col-xs-3 offset-2" id="waitGif" style="display: none">
                <img src="../moduleResources/nigeriaemr/images/Sa7X.gif" alt="Loading Gif"  style="width:40px; margin-top: 35px;">
            </div>
            <h4 id="apiInfo" style="overflow: auto; font-size: 1em !important; font-weight: bold; margin-top: 25px; text-align: left">Please wait, Checking if NDR API credentials already exists...</h4>
            <div id="batchesHeader" style="font-weight: bold !important;text-align: left;">The resulting Data Batches are: </div>
            <br/>
            <div id="batchSpan" style="overflow-y: scroll; height: 100px;max-height: 100px;text-align: left; display: none"></div>
        </div>
        <div style="width: 45%; display: none" id="pushData">
            <input id="btnPushData" style="font-weight: bold; padding-left: 10px; padding-right: 10px;background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px" type="button" value="Push failed Data" onclick="initNDRPush(null)" class="btn btn-primary" />
        </div>
        <br/>
    </div>
    <div style="display: none; margin-top: 25px" id="login">
        <br/>
        <div>
            <label style="color: #000; font-size: 14px">NDR Login Email</label><br/>
            <input autocomplete="off" style="background-color: #E8F0FE; width: 93%; height: 45px; border-radius: 10px; margin-top: 15px; padding-left: 18px; padding-right: 10px" type="email" id="email"><br/>
        </div>
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

<div id="viewBatches" class="dialog" style="display: none; padding: 20px; position: absolute; z-index: 999; margin-left: 16.2%; margin-right: 15%;">
    <div style="padding: 20px; position: absolute; z-index: 999; margin-top: -4%; width: 450px; background-color: #e8e8e8; height: 15px; margin-left: -20px;">
        <button type="button" class="close" aria-label="Close" style="background: #e8e8e8 !important; float: right; margin-top: -13px; margin-right: -18px;" title="Close" onclick="closeViewBatches()">
            <span aria-hidden="true" style="font-size: 20px; font-weight: bold;">&times;</span>
        </button>
        NDR Batch IDs for <b id="batchName"></b>
    </div>
    <br/><br/>
    <div id="batches" style="overflow-y: scroll; height: 250px; max-height: 250px;"></div>
</div>

<div id="gen-wait" class="dialog" style="display: none; padding: 20px; position: absolute; z-index: 999; margin-left: 16.2%; margin-right: 15%;">
    <div>
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

<div id="errorLogs" class="dialog" style="display: none; width: 100% !important; margin-top: 1%;  box-shadow: 1px 1px 1px #999999, -1px -1px 1px #999999 !important;">
    <div style="padding: 15px; background-color: #e8e8e8; height: 15px;"  class="row">
        <div class="col-md-2">
            <label style="font-weight: bold">File Name: </label>
        </div>
        <div class="col-md-8">
           <label id="exportHeadr" style="font-weight: bold;font-size: 18px;"></label>
        </div>
        <div class="col-md-2">
            <button type="button" class="close" aria-label="Close" style="background: #e8e8e8 !important; float: right; margin-top: -10px; margin-right: -1px; padding: 4px 8px !important;" title="Close" onclick="closeLogs()">
                <span aria-hidden="true" style="font-size: 20px; font-weight: bold;">&times;</span>
            </button>
        </div>
    </div>

    <div class="box white-background with-shadow" style="padding: 5px;">
        <div class="box-heading" id="tabContainer">

        </div>
    </div>
</div>

<div class="container" id="container" style="padding-top: 10px;">
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
    <div style="margin-left: 32%; width: 40%; height: 50%; display: flex; border-top: 1px #e0e0e0 solid; border-bottom: 1px #e0e0e0 solid; padding-top: 10px; padding-bottom: 10px">
        <div>
            <label for="asXml" style="color: #000; font-weight: bold; cursor: pointer">
                <input style="cursor: pointer" type="radio" id="asXml" name="extOpt" value="Xml" onclick="setExtractionOpt('xml')"/>
                Extract as XML
            </label>
        </div>
        <div style="margin-left: 18%">
            <label for="asJson" style="color: #000; font-weight: bold; cursor: pointer">
                <input style="margin-left: 10px; cursor: pointer" type="radio" id="asJson" value="asJson" name="extOpt" onclick="setExtractionOpt('json')"/>
                Extract as JSON <i style="font-size: 20px;" id="json-hint" class="icon-info-sign" title="Please ensure you have an active internet connection"></i>
            </label>
        </div>
    </div>
    <br/>
    <div id="dvGetLogs">
        <div class="col-md-8" style="width: 65%">
            <label style="font-weight: bold">
                The error logs of some batches sent to the NDR via API are yet to be pulled from the NDR
            </label>
        </div>
        <div class="col-md-4" style="width: 35%">
            <a class="button-13" style="float: right" onclick="getNdrErrorLogs()" class="button-13">
                Get NDR Error Logs
            </a>
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
<style>
.row {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    /*margin-right: -15px;*/
    /*margin-left: -15px;*/
}

div#batches span {
    border-top: 1px solid #e0e0e0;
    width: 100%;
    display: inline-flex;
    padding: 5px !important;
}
.col-md-3
{
    -webkit-box-flex: 0;
    -ms-flex: 0 0 25%;
    flex: 0 0 25%;
    max-width: 25%;
}
.col-md-4 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 33.333333%;
    flex: 0 0 33.333333%;
    max-width: 33.333333%;
}
.col-md-8 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 66.666667%;
    flex: 0 0 66.666667%;
    max-width: 66.666667%;
}
.col-md-2 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 16.666667%;
    flex: 0 0 16.666667%;
    max-width: 16.666667%;
}
#dvGetLogs{
    margin-left: 27%;
    width: 55%;
    height: 50%;
    display: none;
    padding-top: 10px;
    padding-bottom: 10px;
    justify-content: center;
}
.button-13 {
    background-color: #fff;
    border: 1px solid #d5d9d9;
    border-radius: 8px;
    box-shadow: rgb(213 217 217 / 50%) 0 0 0 0;
    color: #0f1111 !important;
    cursor: pointer;
    font-family: "Amazon Ember",sans-serif;
    font-size: 13px;
    text-decoration: none !important;;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
    text-align: center;
    padding: 10px 8px;
    white-space: nowrap;
    font-weight: bold;
}
.button-13:hover {
    background-color: #fff;
    box-shadow: rgb(213 217 217 / 50%) 0 2px 5px 0;
}
.text-danger {
    color: #E85137 !important;
}
.list-group {
    display: flex;
    flex-direction: column;
    padding-left: 0;
    margin-bottom: 0;
}
.list-group-item:first-child {
    border-top-left-radius: 0.25rem;
    border-top-right-radius: 0.25rem;
}
.list-group-item {
    padding: 0.15rem 0.15rem;
    background-color: #fff;
    border: 1px solid rgba(0, 0, 0, 0.125);
}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons that are used to open the tab content */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc !important;
}

/* Style the tab content */
.tabcontent
{
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}

.w3-btn, .w3-btn:link, .w3-btn:visited
{
    color: #FFFFFF;
    background-color: #4CAF50;
}
.w3-btn, .ws-btn
{
    background-color: #f5f5f5 !important;
    border-radius: 5px;
    font-size: 17px;
    font-family: 'Source Sans Pro', sans-serif;
    padding: 6px 18px;
}
.w3-margin-bottom
{
    margin-bottom: 16px!important;
}
.w3-btn, .w3-button
{
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -khtml-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}
.w3-btn, .w3-button
{
    border: thin solid #000;
    text-decoration: none !important;
    display: inline-block;
    padding: 8px 6px;
    vertical-align: middle;
    overflow: hidden;
    text-decoration: none;
    color: #000 !important;
    background-color: inherit;
    text-align: center;
    cursor: pointer;
    white-space: nowrap;
}

.invalid-files {
    font-weight: normal;
    color: #e64a19 !important;
    height: 150px;
    max-height: 150px;
    overflow-y: scroll;
    overflow-wrap: anywhere;
    border-bottom: 1px solid #e0e0e0;
    padding-bottom: 10px;
    text-align: left;
}
.msg-div{
    color: #000 !important;
    text-align: left;
    border-bottom: 1px solid #e0e0e0;
    margin-bottom: 5px;
}
</style>

<script>
    let lastNDRRunDate = '${lastNDRRunDate}'
    let extractionOpt = 'xml';
    let exportTriggered = false;
    let apiPushDone = false;
    let totalJSONFiles = 0;
    let emptyFiles = '';
    let totalPushed = 0;
    let isOnline = false;
    let processingFile = 0;
    let processing = false;
    let credentialsProvided = false;
    let batches = [];
    let batchExport = 0;
    jq = jQuery;

    jq(document).ready(function ()
    {
        const rdo =  document.getElementById("asXml");
        rdo.checked = true;
        checkPendingJsonFiles();
    });

    function openTab(obj)
    {
        let batchId = jq(obj).attr('id').replace('_btn', '');
        // Declare all variables
        let i, tabcontent, tablinks;

        // Get all elements with class="tabcontent" and hide them
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++)
        {
            jq(tabcontent[i]).css('display', 'none');
        }

        // Get all elements with class="tablinks" and remove the class "active"
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++)
        {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        // Show the current tab, and add an "active" class to the button that opened the tab
        jq('#' + batchId).css('display', 'block');
        jq(obj).addClass('active')
    }

    function openLogs()
    {
        jq('#container').hide();
        jq('#errorLogs').show();
    }
    function closeLogs()
    {
        jq('#errorLogs').hide();
        jq('#container').show();
    }

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
        jq('#btnPushData').hide();
        if(opt === 'json')
        {
            let url = "${ ui.actionLink("nigeriaemr", "ndr", "checkAuth") }";
            disableControls();

            let ndrAuth = jq('#ndrAuth');
            let waitDiv = jq('#waitDiv');
            let apiInfo = jq('#apiInfo');
            let login = jq('#login');
            jq('#batchSpan').hide().html('');

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
                    apiInfo.html('');
                    ndrAuth.hide();
                    waitDiv.show();
                    login.hide();
                    enableControls();
                }
                else
                {
                    if (res.credentialsProvided !== null && res.credentialsProvided === true)
                    {
                        credentialsProvided = true;
                        jq('#msg-hdr-gen').html('Authenticate with the NDR');
                        apiInfo.html('<span>Your previous NDR Authentication has expired.</span> <br/><span style=\"font-style: italic\">Please WAIT for fresh Authentication with the NDR...</span>');
                        ndrAuth.show();
                        waitDiv.show();
                        login.hide();
                        authApi();
                    }
                    else
                    {
                        alert(res.message);
                        waitDiv.hide();
                        jq('#msg-hdr-gen').html('Authenticate with the NDR');
                        login.show();
                    }
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
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "auth") }";
        if (credentialsProvided === false)
        {
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
        }
        else
        {
            url = "${ ui.actionLink("nigeriaemr", "ndr", "reAuth") }";
        }
        authBtn.attr('value', 'Please wait...').css('font-style', 'italic').prop('disabled', true);
        btnCancel.attr('enabled', 'false');


        jq.ajax({
            url: url,
            dataType: "json",
            data: {
                'email' : (email === null || email.length < 1)? '' : email,
                'password': (password === null || password.length < 1)? '' : password
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
                console.log(status);
                console.log(err);
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
                            let logSnip = '';
                            let batchView = '';
                            if(fileListObj[i].ndrBatchIds !== undefined && fileListObj[i].ndrBatchIds !== null && fileListObj[i].ndrBatchIds.length > 0)
                            {
                                batchView = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-eye-open batchXView edit-action edit-action\" title=\"View NDR Batch Ids\" onclick=\"viewBatchIds(event, '" + fileListObj[i].ndrBatchIds + "', '" + fileListObj[i].name +"')\"></i>";

                                if(fileListObj[i].errorLogsPulled !== undefined && fileListObj[i].errorLogsPulled !== null && fileListObj[i].errorLogsPulled === 'yes')
                                {
                                    logSnip = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-list-alt edit-action edit-action\" title=\"View NDR Error Logs\" onclick=\"viewErrorLogs('" + fileListObj[i].number + "','" + fileListObj[i].name +"')\"></i>";
                                }
                            }

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
                                    batchView +
                                    logSnip +
                                    "</td>" +
                                    "</tr>");
                        }
                        else
                        {
                            let logSnip = '';
                            let batchView = '';
                            if(fileListObj[i].ndrBatchIds !== undefined && fileListObj[i].ndrBatchIds !== null && fileListObj[i].ndrBatchIds.length > 0)
                            {
                                batchView = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-eye-open batchXView edit-action edit-action\" title=\"View NDR Batch Ids\" onclick=\"viewBatchIds(event, '" + fileListObj[i].ndrBatchIds + "', '" + fileListObj[i].name +"')\"></i>";

                                if(fileListObj[i].errorLogsPulled !== undefined && fileListObj[i].errorLogsPulled !== null && fileListObj[i].errorLogsPulled === 'yes')
                                {
                                    logSnip = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-list-alt edit-action edit-action\" title=\"View NDR Error Logs\" onclick=\"viewErrorLogs('" + fileListObj[i].number + "','" + fileListObj[i].name +"')\"></i>";
                                }
                            }
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
                                    batchView +
                                    logSnip +
                                    "</td>" +
                                    "</tr>");
                        }
                    }
                    else
                    {
                        if(Paused)
                        {
                            let logSnip = '';
                            let batchView = '';
                            if(fileListObj[i].ndrBatchIds !== undefined && fileListObj[i].ndrBatchIds !== null && fileListObj[i].ndrBatchIds.length > 0)
                            {
                                batchView = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-eye-open batchXView edit-action edit-action\" title=\"View NDR Batch Ids\" onclick=\"viewBatchIds(event, '" + fileListObj[i].ndrBatchIds + "', '" + fileListObj[i].name +"')\"></i>";

                                if(fileListObj[i].errorLogsPulled !== undefined && fileListObj[i].errorLogsPulled !== null && fileListObj[i].errorLogsPulled === 'yes')
                                {
                                    logSnip = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-list-alt edit-action edit-action\" title=\"View NDR Error Logs\" onclick=\"viewErrorLogs('" + fileListObj[i].number + "','" + fileListObj[i].name +"')\"></i>";
                                }
                            }
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
                                    batchView +
                                    logSnip +
                                    "</td>" +
                                    "</tr>");
                        }
                        else
                        {
                            let logSnip = '';
                            let batchView = '';
                            if(fileListObj[i].ndrBatchIds !== undefined && fileListObj[i].ndrBatchIds !== null && fileListObj[i].ndrBatchIds.length > 0)
                            {
                                batchView = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-eye-open batchXView edit-action edit-action\" title=\"View NDR Batch Ids\" onclick=\"viewBatchIds(event, '" + fileListObj[i].ndrBatchIds + "', '" + fileListObj[i].name +"')\"></i>";

                                if(fileListObj[i].errorLogsPulled !== undefined && fileListObj[i].errorLogsPulled !== null && fileListObj[i].errorLogsPulled === 'yes')
                                {
                                    logSnip = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-list-alt edit-action edit-action\" title=\"View NDR Error Logs\" onclick=\"viewErrorLogs('" + fileListObj[i].number + "','" + fileListObj[i].name +"')\"></i>";
                                }
                            }
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
                                    batchView +
                                    logSnip +
                                    "</td>" +
                                    "</tr>");
                        }
                    }
                }else
                {
                    if(exportTriggered === true && extractionOpt === 'json' && batchExport < 1)
                    {
                        batchExport = fileListObj[i].number;
                    }
                    let logSnip = '';
                    let batchView = '';
                    if(fileListObj[i].ndrBatchIds !== undefined && fileListObj[i].ndrBatchIds !== null && fileListObj[i].ndrBatchIds.length > 0)
                    {
                        batchView = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-eye-open batchXView edit-action edit-action\" title=\"View NDR Batch Ids\" onclick=\"viewBatchIds(event, '" + fileListObj[i].ndrBatchIds + "', '" + fileListObj[i].name +"')\"></i>";

                        if(fileListObj[i].errorLogsPulled !== undefined && fileListObj[i].errorLogsPulled !== null && fileListObj[i].errorLogsPulled === 'yes')
                        {
                            logSnip = "<i style=\"font-size: 20px; cursor: pointer\" class=\"icon-list-alt edit-action edit-action\" title=\"View NDR Error Logs\" onclick=\"viewErrorLogs('" + fileListObj[i].number + "','" + fileListObj[i].name +"')\"></i>";
                        }
                    }
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
                            "<i style=\"font-size: 20px;\" class=\"icon-pause edit-action\" title=\"pause\" onclick=\"pauseFile('" + fileListObj[i].number + "')\"></i>" + logSnip +
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

    //This function is very important in determining when extraction competes
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
            const ping = await fetch("https://emr-ndrpush.phis3project.org.ng/v1/utils/ping");
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
        let apiInfo = jq('#apiInfo');
        apiInfo.css('color', '#000 !important');
        jq('#batchesHeader').hide();
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getTotalFiles") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            checkPendingNdrErrorLogs();
            if (res !== undefined && res !== null && res.length > 0)
            {
                let tt = res.split(';');
                batchExport = parseInt(tt[0]);
                totalJSONFiles = parseInt(tt[1]);
                emptyFiles = tt[2];
                let emptyFileString = "None";
                if(emptyFiles !== undefined && emptyFiles !== null && emptyFiles.length > 0)
                {
                    let rpl = emptyFiles.replaceAll(",", "</span><br/><span>");
                    emptyFileString = "<div class=\"invalid-files\"><span>" + rpl + "</span></div>";
                }

                if (batchExport > 0 && totalJSONFiles > 0)
                {
                    jq('#msg-hdr-gen').html('NDR Data Push');
                    let message = //"<div class=\"msg-div\">Found some files yet to be pushed to the NDR.</div>" +
                        "<div class=\"msg-div\">Total Data yet to be pushed: <span style=\"font-weight: bold;color: #388e3c\">" +  totalJSONFiles + "</span></div>" +
                        "<div class=\"msg-div\">Invalid Data files: </div>" +  emptyFileString +
                        "<br/><div class=\"msg-div\">Total Patient Data pushed: <span style=\"font-weight: bold;\" id='totalPushed'>" + totalPushed + "</span></div>";

                    jq('#ndrAuth').show();
                    jq('#btnPushData').prop('disabled', false);
                    jq('#waitDiv').show();
                    apiInfo.html(message);
                    jq('#btnPushData').val('Push Data');
                    jq('#pushData').show();
                }
            }
        })
        .error(function(xhr, status, err)
        {
            checkPendingNdrErrorLogs();
            //handle error
        });
    }

    async function checkPendingNdrErrorLogs()
    {
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "checkApiExportsWithPendingNdrErrorLogs") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            if(res !== undefined && res !== null && res > 0)
            {
                jq('#dvGetLogs').css('display', 'flex');
            }
            else
            {
                jq('#dvGetLogs').hide();
            }
        })
        .error(function(xhr, status, err)
        {
            jq('#dvGetLogs').hide();
        });
    }

    async function getNdrErrorLogs()
    {
        isOnline = await checkOnlineStatus();
        if(!isOnline)
        {
            alert("You do not have an active internet connectivity");
            extractionOpt = 'xml';
            // const rdo =  document.getElementById("asXml");
            return;
        }
        jq('#gen-wait').show();
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getLogs") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            jq('#gen-wait').hide();
            if(res !== undefined && res !== null && res > 0)
            {
                jq('#dvGetLogs').hide();
                alert("Some Error Logs were successfully pulled from the NDR. You can view them by clicking the 'View NDR Error Logs' under 'Actions'");
            }
            else
            {
                alert('No error logs could be pulled from the NDR yet');
            }
        })
        .error(function(xhr, status, err)
        {
            alert(err);
        });
    }

    async function initNDRPush(checkPending)
    {
        totalJSONFiles = 0;
        totalPushed = 0;
        batches = [];
        let batchSpan = jq('#batchSpan');
        batchSpan.html('');
        batchSpan.hide();
        jq('#batchesHeader').hide();
        isOnline = await checkOnlineStatus();
        if(!isOnline)
        {
            alert("You do not have an active internet connectivity");
            extractionOpt = 'xml';
            // const rdo =  document.getElementById("asXml");
            return;
        }

        if(checkPending!== null)
            clearInterval(checkPending);

        let ndrAuth = jq('#ndrAuth');
        let apiInfo = jq('#apiInfo')
        let waitGif = jq('#waitGif');
        let pushData = jq('#pushData');
        let btnPushData = jq('#btnPushData');
        btnPushData.val('Please wait...');
        btnPushData.prop('disabled', true);
        apiInfo.css('color', '#000 !important').html('Evaluating data to be pushed to the NDR. Please wait...');
        jq('#login').hide();
        jq('#waitDiv').show();
        waitGif.show();
        ndrAuth.show();
        jq('#msg-hdr-gen').html('NDR Data Push');
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getTotalFiles") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            apiPushDone = true;
            if (res !== undefined && res !== null && res.length > 0)
            {
                let tt = res.split(';');
                batchExport = parseInt(tt[0]);
                totalJSONFiles = parseInt(tt[1]);
                emptyFiles = tt[2];
                let emptyFileString = "None";
                if(emptyFiles !== undefined && emptyFiles !== null && emptyFiles.length > 0)
                {
                    let rpl = emptyFiles.replaceAll(",", "</span><br/><span>");
                    emptyFileString = "<div class=\"invalid-files\"><span>" + rpl + "</span></div>";
                }

                // let message = "<span>Total Extracted Valid Patient Data: </span><span style=\"font-weight: bold;\">" +  totalJSONFiles + "</span>" +
                //     "<br/><span style=\"color: #000 !important;\">Invalid Data files: </span>" + emptyFileString +
                //     "<br/><span>Total Patient Data pushed: </span><span style=\"font-weight: bold;\" id='totalPushed'>" + totalPushed + "</span></span>"

                let message =
                    "<div class=\"msg-div\">Total Extracted Valid Patient Data: <span style=\"font-weight: bold;color: #388e3c\">" +  totalJSONFiles + "</span></div>" +
                    "<div class=\"msg-div\">Invalid Data files: </div>" +  emptyFileString +
                    "<br/><div class=\"msg-div\">Total Patient Data pushed: <span style=\"font-weight: bold;\" id='totalPushed'>" + totalPushed + "</span></div>";

                apiInfo.css('color', '#000 !important').html(message);
                pushD();
            }
            else
            {
                let message = "<br/><span>There are no patient data to be pushed to the NDR</span>";
                apiInfo.html(message);
                waitGif.css('display', 'none');
                apiInfo.css('color', '#000 !important').html("There no valid JSON data to be pushed to the NDR");
            }
        })
            .error(function(xhr, status, err)
            {
                apiPushDone = true;
                waitGif.css('display', 'none');
                apiInfo.css('color', '#000 !important').html("An error was encountered " + err);
                btnPushData.val('Push Data');
                btnPushData.prop('disabled', false);
                // pushData.show();
                pushData.css('display', 'block');
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
                // pushData.show();
                pushData.css('display', 'block');
                waitGif.css('display', 'none');
                apiInfo.css('color', '#000 !important').append(message);
                btnPushData.prop('disabled', false);
                compileBatches();
            }
            return;
        }
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "pushBatchData") }";
        jq.ajax({
            url: url,
            dataType: "json"
        }).success(function(res)
        {
            console.log(res);
            if (res !== undefined && res !== null && res.code > 0)
            {
                let message = "";
                if(res.batchNumber !== null && res.batchNumber.length > 0)
                {
                    batches.push(res.batchNumber);
                }
                if (res.totalPushed > 0)
                {
                    totalPushed += res.totalPushed;
                    jq('#totalPushed').html(totalPushed);
                    if (totalPushed == totalJSONFiles)
                    {
                        message = "<br/><br/><span style=\"color: green !important;\">All Patient data has been successfully pushed to the NDR.</span>";
                        waitGif.css('display', 'none');
                        apiInfo.append(message);
                        btnPushData.prop('disabled', false);
                        pushData.hide();
                        compileBatches();
                    }
                    else
                    {
                        if (totalPushed > totalJSONFiles)
                        {
                            message = "<br/><br/><span style=\"color: green !important;\">All Patient data have been successfully pushed to the NDR.</span>";
                            waitGif.css('display', 'none');
                            apiInfo.append(message);
                            btnPushData.prop('disabled', false);
                            pushData.hide();
                            compileBatches();
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
                        message = "<br/><br/><span style=\"color: green !important;\">All Patient data has been successfully pushed to the NDR.</span>";
                        pushData.hide();
                        apiInfo.append(message);
                        compileBatches();
                    }
                    else
                    {
                        if (totalPushed < totalJSONFiles)
                        {
                            message = "<br/><span style=\"font-size: 0.96em !important;\">Some Patients data were not successfully pushed to the NDR.</span>" +
                                "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                            btnPushData.val('Push remaining Data');
                            // pushData.show();
                            pushData.css('display', 'block');
                            compileBatches();
                            apiInfo.css('color', '#000 !important').append(message);
                        }
                    }
                }
            }
            else
            {
                waitGif.css('display', 'none');
                btnPushData.prop('disabled', false);
                let message = "";
                if (totalPushed == totalJSONFiles)
                {
                    message = "<br/><br/><span style=\"color: green !important;\">All Patient data has been successfully pushed to the NDR.</span>";
                    apiInfo.append(message);
                    pushData.hide();
                    apiInfo.append(message);
                    compileBatches();
                }
                else
                {
                    if(totalPushed < 1)
                    {
                        message = (res.message !== null && res.message.length > 0)? "<br/><span style=\"font-size: 0.96em !important;\">" + res.message + "</span>": "<br/><span>An unknown error was encountered. Patients' data could not be pushed to the NDR.</span>";
                        message += "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                        btnPushData.val('Push Data');
                    }
                    else
                    {
                        message = "<br/><span style=" + "font-size: 0.96em !important;" + ">Some Patients data were not successfully pushed to the NDR.</span>" +
                            "<br/><span style=" + "font-size: 0.96em !important;" + "> You might consider initiating the data push again by clicking the button bellow.</span>";
                        btnPushData.val('Push remaining Data');
                    }
                    apiInfo.css('color', '#000 !important').append(message);
                    // pushData.show();
                    pushData.css('display', 'block');
                    compileBatches();
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
                apiInfo.css('color', '#000 !important').append(message);
                //pushData.show();
                pushData.css('display', 'block');
            });
    }

    function compileBatches()
    {
        let batchHeader = jq('#batchesHeader');
        let batchSpan = jq('#batchSpan');
        if(batches.length > 0)
        {
            let batchStr = "";
            batches.forEach(function (b, i)
            {
                batchStr += "<span>" + b + "</span><br/>";
            });
            batchSpan.append(batchStr);
            batchHeader.show();
            batchSpan.show();
            if(batchExport > 0)
            {
                let batchIds = batches.join(",");
                let url = "${ ui.actionLink("nigeriaemr", "ndr", "saveNDRBatchIds") }";
                jq.ajax({
                    url: url,
                    dataType: "json",
                    data: {
                        "batchIds": batchIds,
                        "exportId": batchExport
                    }
                }).success(function()
                {
                    console.log('Batch Ids saved');
                })
                .error(function(xhr, status, err)
                {
                    console.log(err);
                });
            }
        }
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
            {
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

    function viewErrorLogs(id, expName)
    {
        if(id)
        {
            jq('#gen-wait').show();
            jq.ajax({
                url: "${ ui.actionLink("nigeriaemr", "ndr", "viewErrorLogs") }",
                dataType: "json",
                data: {
                    'id' : id
                }
            }).success(function(data)
            {
                if(data)
                {
                    let errGrp = groupArrayByKey(data, 'batchNumber');
                    let tts = Object.keys(errGrp);
                    let tbl = '';
                    let tabs = '<div class="tab col-md-12" style="margin-top: 1%;" id="tabs">';
                    tts.forEach(function(u, i)
                    {
                        //<h3 style="font-weight: bold;">'+ u +'</h3>'
                        let t = errGrp[u];
                        tabs += '<button id="'+ u +'_btn" class="tablinks" onclick="openTab(this)" style="background: none;border-radius: 0px;">'+ u +'</button>';
                       tbl += '<div id="'+ u +'" class="tabcontent"><h5 style="font-weight: bold;">NDR Error Messages</h5>' +
                           '<table class="table table-bordered table-striped table-hover"><thead><tr><th>S/No.</th><th>Filename</th><th>Patient ID</th>' +
                           '<th>Error Messages</th></tr></thead><tbody>';
                        let tr = '';
                        t.forEach(function(o, j)
                        {
                            let idntifier = 'N/A';
                            if(o.patientIdentifier)
                            {
                                idntifier = o.patientIdentifier;
                            }
                            tr += '<tr style="font-size: 15px;"> <td>' + (j + 1) +'</td><td>' + o.fileName + '</td><td>'
                                + idntifier + '</td><td><label>' + o.message + '</label></td></tr>';
                        });

                        tbl += tr + '</tbody></table></div>';
                    });

                    tabs +=  '</div>';
                    let altt = tabs + tbl;
                    jq('#tabContainer').html(altt);
                    jq('#gen-wait').hide();
                    jq('#' + tts[0]).css('display', 'block');
                    jq('#' + tts[0] + '_btn').addClass('active')
                    jq('#exportHeadr').html(expName);
                    openLogs();
                }
                else
                {
                    jq('#gen-wait').hide();
                    alert('An error was encountered while trying to retrieve NDR Error logs');
                }
            })
            .error(function(xhr, status, err)
            {
                jq('#gen-wait').hide();
                console.log(err);
                alert('There was an error fetching the error logs. Please try again later');
            });
        }
    }

    function viewBatchIds(e, ndrBatchIds, bN)
    {
        console.log(e);
        let rect = e.target.getBoundingClientRect(); // get some poition, scale,... properties of the item
        let mousePos = {};
        // mousePos.x = e.clientX - rect.left; // get the mouse position relative to the element
        // mousePos.y = e.clientY - rect.top;

        mousePos.x = e.clientX - (rect.left/2); // get the mouse position relative to the element
        mousePos.y = e.clientY - (rect.top/2);

        let viewBatches = jq('#viewBatches');
        let batches = jq('#batches');
        let batchName = jq('#batchName')
        if(ndrBatchIds)
        {
            let ids = ndrBatchIds.split(',');
            if(ids.length > 0)
            {
                let batchStr = "";
                ids.forEach(function (b, i)
                {
                    batchStr += "<span>" + b + "</span><br/>";
                });
                batches.append(batchStr);
                batchName.html(bN);
                viewBatches.show();
                viewBatches.css('left', mousePos.x + "px");
                viewBatches.css('top', mousePos.y + "px");
            }
        }
    }

    function closeViewBatches()
    {
        jq('#viewBatches').hide();
        jq('#batches').html('');
    }

    function groupArrayByKey(array, key)
    {
        return array.reduce((hash, obj) =>
        {
            if(obj[key] === undefined) return hash;
            return Object.assign(hash, { [obj[key]]:( hash[obj[key]] || [] ).concat(obj)})
        }, {});
    }
</script>