<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>
<% ui.includeJavascript("nigeriaemr", "bootstrap-datetimepicker.min.js") %>
<% ui.includeCss("nigeriaemr", "bootstrap.css") %>

<style>
.btn-custom{
    background-color: #00463f !important;
    margin-left: 52px;
    color: #fff;
    width: 70%;
    height: 45px;
    border-radius: 5px;
    margin-top: 25px;
}
.btn-custom2{
    background-color: #00463f !important;
    margin-left: 52px;
    color: #fff;
    width: 70%;
    height: 45px;
    border-radius: 5px;
    margin-top: 18px;
}
.btn-custom:hover {
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
}
.bg-success-ui{padding-left: 100px;}
</style>
<div class="container" >
    <div class="row>
            div class="col-12 col-md">
    <h1 style="text-align: center; font-size:16px; font-weight:bold ">
        NDR Export

    </h1>
</div>
</div>
<div class="row">
    <div class="col-12 col-md">
        <input style="background-color: #E8F0FE; border-radius: 25px; margin-top: 15px; margin-left: 62px" type="checkbox" id="custom" name="custom" value="custom" onclick="checkBoxCheck()">
        <label for="custom" style="color: #000; font-size:12; font-weight:inherit ">Select Custom Filter </label><br>
    </div>
</div>
<div id="custom-fliter" style="display: none">
    <div class="row">
        <div class="col-12 col-md">
            <input class="form-control col-11" style="background-color: #E8F0FE; margin-left: 52px;  height: 45px; border-radius: 5px; margin-top: 15px;"  type="text" value="comma separated patient identifiers or Ids" id="identifiers" onfocus=this.value='' name="identifiers">
        </div>
    </div>

    <div class="row">
        <div class="col-4 col-md">
            <input class=" date custom-inputs form-control col-12" style="background-color: #E8F0FE; margin-left: 52px; height: 45px; border-radius: 5px; margin-top: 15px;"  id="from" type="date"  />

        </div>
        <div class="col-4 col-md">
            <input class="date custom-inputs form-control col-12" style="background-color: #E8F0FE; margin-left: 52px;  height: 45px; border-radius: 5px; margin-top: 15px;"  id="to" type="date" />
        </div>
        <div class="col-4 col-md">
            <input class="btn-custom2 btn" id="btnClear" type="button" value="Clear" onclick="clearData()" />
        </div>
    </div>
</div>
<div class="row">
    <div class="col-10 col-md" style="    padding-top: 30px;
    padding-left: 80px;">
        <div class="progress" style="height: 35px;">
            <div class="progress-bar bg-success bg-success-ui" id="myBar" role="progressbar" style="width: 0%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" >

            </div>
        </div>
    </div>
    <div class="col-4 col-md">
        <input class="btn-custom btn" type="button" value="Export" onclick="exportData()" style="background-color: #00463f !important;" />
    </div>
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
<div id="gen-wait" class="dialog" style="display: none; ">
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
</div>



<script>
    jq = jQuery;
    function checkBoxCheck()
    {
        const checkBox = document.getElementById("custom");
        if (checkBox.checked === true){
            document.getElementById('custom-fliter').style.display =  'inline';
            /*document.getElementById('from').style.display =  'inline';
            document.getElementById('to').style.display =  'inline';
            document.getElementById('btnClear').style.display =  'inline';*/
            jq("#tb_commtester tbody tr").remove();
        }else{
            document.getElementById('custom-fliter').style.display =  'none';
            // document.getElementById('from').style.display =  'none';
            // document.getElementById('to').style.display =  'none';
            // document.getElementById('btnClear').style.display =  'none';
            jq("#tb_commtester tbody tr").remove();
        }
        loadFileListDefault(true);
    }

    function clearData()
    {
        document.getElementById('identifiers').value = ''
        document.getElementById('from').value = ''
        document.getElementById('to').value = ''
    }

    function exportData()
    {
        const checkBox = document.getElementById("custom");
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "generateNDRFile") }"
        if (checkBox.checked === true){
            url = "${ ui.actionLink("nigeriaemr", "ndr", "generateCustomNDRFile") }"
        }


        let identifiers = jq('#identifiers').val();
        const from = jq('#from').val();
        const to = jq('#to').val();

        if(identifiers === "comma separated patient identifiers or Ids") identifiers = ''


        jq('#gen-wait').show();

        jq.ajax({
            url: url,
            dataType: "json",
            data: {
                'identifiers' : identifiers,
                'to' : to,
                'from' : from
            }

        }).success(function(filename) {
            //Old implementation
            if (filename.endsWith(".zip")){
                jq('#gen-wait').hide();
                window.location = filename;
                loadFileList()
            }else{
                alert(filename)
                jq('#gen-wait').hide();
                loadFileList()
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
    jq(function() {
        loadFileList()
    });

    function loadFileList() {
        if(loadFileListDefault(true)){
            refresher
        }
    }
    function loadFileListDefault(showProgressDialog) {
        processing = false
        if (showProgressDialog) jq('#gen-wait').show();
        const checkBox = document.getElementById("custom");
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "getFileList") }"
        if (checkBox.checked === true){
            url = "${ ui.actionLink("nigeriaemr", "ndr", "getManualFileList") }"
        }
        //load all file generated

        jq.getJSON(url).success(function (fileList) {
            jq("#TableBody").empty();
            const fileListObj = jq.parseJSON(fileList);
            for (let i = 0; i < fileListObj.length; i++) {
                var success = (fileListObj[i].status).includes('Completed')
                var Paused = (fileListObj[i].status) === 'Paused'
                if(fileListObj[i].active) {
                    if(success) {
                        if(fileListObj[i].hasError){
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
                }else{
                    processing = true
                    var myBar = document.getElementById("myBar");
                    myBar.style.width = fileListObj[i].progress;
                    myBar.innerText  = fileListObj[i].progress + "    (  "+ fileListObj[i].processed+ " Patients Processed" +" )";
                    console.log(fileListObj[i]);

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
        }).error(function (xhr, status, err) {
            if (showProgressDialog) alert('There was an error loading file list ' + err);
            jq('#gen-wait').hide();
        });
        return processing
    }
    function refreshList(){
        loadFileList();
    }

    const refresher = setInterval(function () {
        loadFileListDefault(false);
    }, 10000);

    function restartErrorFile(id){
        if (confirm("Are you sure you want to restart ? this will rerun failed files?") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                console.log(id);
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
        if (confirm("Are you sure you want to restart ? this will restart the export from the begining") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                console.log(id);
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
        if (confirm("Are you sure you want to resume ?") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                console.log(id);
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

    function deleteFile(id){
        if (confirm("Are you sure you want to delete this file ?") === true) {
            jq('#gen-wait').show();
            if(id)
            {
                //console.log(id);
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
                console.log(id);
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

<script type="text/javascript">
    var viewModel = viewModel || {};
    viewModel.validations = viewModel.validations || [];

    jq(".date").datetimepicker({

        minView: 2,
        autoclose: true,
        pickerPosition: "bottom-left",
        todayHighlight: false,
        format: "yyyy-mm-dd",
        //endDate: "31-08-2020",
        language: "en",
        //linkField: "date1",
        // linkFormat: "yyyy-mm-dd"

    })

</script>
