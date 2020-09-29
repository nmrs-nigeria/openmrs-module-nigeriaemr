<%
    def id = config.id
%>
<%= ui.resourceLinks() %>

<script>
    jq = jQuery;
    jq('#wait').hide();


    jq(function() {
        jq('#${ id }_button').click(function () {
            //popupDialog.show();
            jq('#wait').show();
            jq.ajax('${ ui.actionLink("generateNDRFile") }',
                {
                    dataType: 'json', // type of response data
                    timeout: 30000,     // timeout milliseconds
                    success: function (filename) {
                        //Old implementation
                        if (filename.endsWith(".zip")){
                            jq('#wait').hide();
                            window.location = filename;
                            loadFileList()
                        }else{
                            alert(filename)
                            jq('#wait').hide();
                            loadFileList()
                        }
                        jq('#wait').hide();
                    },
                    error: function (xhr, status, err) {
                        console.log(status);
                        if(status === 'timeout'){
                            alert("the export will take a while, the list will be updated when it's done");
                            loadFileList();
                        }else {
                            alert('There was an error generating all NDR files, check generated files at downloads directory in the application root folder ' + err);
                            loadFileList();
                        }//popupDialog.close();
                        jq('#wait').hide();
                    }
                });
        });
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
        //load all file generated
        jq.getJSON('${ ui.actionLink("getFileList") }').success(function (fileList) {
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
                                    "<td><a title='download valid files' onclick=\"downloadFile('" + fileListObj[i].path + "')\" class=\"button\"><i class=\"icon-download\"></i></a> <p/>" +
                                    "<a title='download error files' onclick=\"downloadFile('" + fileListObj[i].errorPath + "')\" class=\"button\"><i class=\"icon-download-alt\"></i></a>" +
                                    "<a title='download error list' onclick=\"downloadFile('" + fileListObj[i].errorList + "')\" class=\"button\"><i class=\"fa-file-download\"></i></a>" +
                                    "<a title='delete file' onclick=\"deleteFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-remove\"></i></a>" +
                                    "<a title='restart' onclick=\"restartFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-refresh \"></i></a></td></td>" +
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
                                    "<td><a title='download file' onclick=\"downloadFile('" + fileListObj[i].path + "')\" class=\"button\"><i class=\"icon-download\"></i></a> <p/>" +
                                    "<a title='delete file' onclick=\"deleteFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-remove\"></i></a></td>" +
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
                                    "<td><a title='resume' onclick=\"resumeFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-play\"></i></a> <p/>" +
                                    "<a title='delete file' onclick=\"deleteFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-remove\"></i></a></td>" +
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
                                    "<td><a title='delete file' onclick=\"deleteFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-remove\"></i></a>" +
                                    "<a title='restart' onclick=\"restartFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-refresh \"></i></a></td>" +
                                    "</tr>");
                        }
                    }
                }else{
                    processing = true

                    jq('#TableBody')
                        .append("<tr style=\"opacity:0.6;filter: alpha(opacity = 60)\">" +
                            "<td>" + fileListObj[i].owner + "</td>" +
                            "<td>" + fileListObj[i].name + "</td>" +
                            "<td>" + fileListObj[i].dateStarted + "</td>" +
                            "<td>" + fileListObj[i].dateEnded + "</td>" +
                            "<td>" + fileListObj[i].total + "</td>" +
                            "<td>" + fileListObj[i].status + "</td>" +
                            "<td><img id=\"loadingImg"+i+"\" src=\"../moduleResources/nigeriaemr/images/Sa7X.gif\" alt=\"Loading Gif\"  style=\"width:25px\"> <p>"+fileListObj[i].progress+"</p>" +
                            "<a title='refresh' onclick=\"refreshList()\" class=\"button\"><i class=\"icon-refresh \"></i></a>" +
                            "<a title='pause' onclick=\"pauseFile('" + fileListObj[i].number + "')\" class=\"button\"><i class=\"icon-pause \"></i></a></td>" +
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
                        'id' : id
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
                console.log(id);
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

<a id="${ id }_button"  class="button app big" style="font-size:12px;min-height: 10px;">
    <i class="icon-download"></i>
    <br/>
    <p>Generate NDR</p>
</a>

<a id="${ id }_button_loc_export"  class="button app big" style="font-size:12px;min-height: 10px;" href="ndrexport.page">
    <i class="icon-lock"></i>
    <br/>
    <p>NDR Export By Location</p>
</a>

<a id="${ id }_button_manage_location"  class="button app big" style="font-size:12px;min-height: 10px;" href="FacilityLocation.page">
    <i class="icon-file-alt"></i>
    <br/>
    <p>Manage Facility Location</p>
</a>

<a id="${ id }_button_manage_location"  class="button app big" style="font-size:12px;min-height: 10px;" href="GetVersion.page">
    <i class="icon-eye-open"></i>
    <br/>
    <p>Version Info</p>
</a>

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