<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>


<div class="row wrapper  white-bg page-heading"  style="">

        <h4 style="text-align: center"> 
                    NDR Export
                    
        </h4>
</div>

    <div class="container" style="padding-top: 10px;">
         <div style="margin-left: 32%; width: 40%; height: 50%; background-color: #00463f; border-radius: 10px; ">
                        <br/> <br/>
                <div>
                    <input style="background-color: #E8F0FE; border-radius: 25px; margin-top: 15px" type="checkbox" id="custom" name="custom" value="custom" onclick="checkBoxCheck()">
                    <label for="custom" style="color: white;">Custom</label><br id="br1">
                    <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px; display: none" type="text" value="comma separated patient identifiers or Ids" id="identifiers" onfocus=this.value='' name="identifiers"><br id="br2">
                    <input  style="background-color: #E8F0FE; margin-left: 52px; border-radius: 25px; margin-top: 15px; margin-bottom: 15px; display: none" type="checkbox" id="customStart" name="customStart" value="customStart" onclick="checkBoxStartCheck()">
                    <label for="customStart" id="labelCustomStart" style=" color: white; width: 70%; height: 45px; margin-bottom: 15px; margin-top: 15px; display: none">Initial</label><br id="br3">
                    <label id="lblfrom" for="from" style="color: white; margin-left: 50px; display:none;">Start Date</label><br id="br4">
                    <input style="background-color: #E8F0FE; margin-left: 52px;margin-bottom: 15px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px; display:none" id="from" type="date"  /><br id="br5">
                    <label id="lblto" for="to" style="color: white; margin-left: 50px; display:none;">End Date</label><br id="br6">
                    <input disabled="disabled" style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px; display:none" id="to" type="date"  /><br id="br7">
                    <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Export" onclick="exportData()" class="btn btn-primary" />
                    <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px; display: none" id="btnClear" type="button" value="Clear" onclick="clearData()" class="btn btn-primary" />
                </div>
        <br/><br/>


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
    let lastNDRRunDate = '${lastNDRRunDate}'
    console.log(lastNDRRunDate)

    jq = jQuery;
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

    function checkBoxStartCheck()
    {
        const checkBox = document.getElementById("customStart");
        if (checkBox.checked === true){
            document.getElementById('from').value =  '';
            document.getElementById('from').style.display =  'none';
            document.getElementById('lblfrom').style.display =  'none';
            document.getElementById('br4').style.display =  'none';
            document.getElementById('br5').style.display =  'none';
        }else{
            document.getElementById('lblfrom').style.display =  'inline';
            document.getElementById('from').style.display =  'inline';
            document.getElementById('br4').style.display =  'inline';
            document.getElementById('br5').style.display =  'inline';
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
        const checkBox = document.getElementById("custom");
        let url = "${ ui.actionLink("nigeriaemr", "ndr", "generateNDRFile") }"
        if (checkBox.checked === true){
            url = "${ ui.actionLink("nigeriaemr", "ndr", "generateCustomNDRFile") }"
        }


        let identifiers = jq('#identifiers').val();
        const from = (jq('#from').val() == "")? "1990-01-01" : jq('#from').val();
        // const to = jq('#to').val();

        if(identifiers === "comma separated patient identifiers or Ids") identifiers = ''
       

                jq('#gen-wait').show();
                 
                    jq.ajax({
                    url: url,
                dataType: "json",
                 data: {
                        'identifiers' : identifiers,
                     // 'to' : to,
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
       if (confirm("Are you sure you want to restart ? this will delete your previous file and restart the export from the beginning") === true) {
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