<%
def id = config.id
%>
<%= ui.resourceLinks() %>

<script>
    jq = jQuery;
    jq('#wait').hide();
    /*var popupDialog = emr.setupConfirmationDialog({
    selector: '#wait'
    });*/
    jq(function() {
        jq('#${ id }_button').click(function() {
    //popupDialog.show();
    jq('#wait').show();
            jq.getJSON('${ ui.actionLink("generateNDRFile") }')
    .success(function(filename) {
    //Old implementation
    if(filename == "no new patient record found"){
    jq('#wait').hide();
    alert("no updated patient record found")
    }
    else{
    window.location = filename;
    }
   /* if(filename.startsWith("Files Exported successfully")){
    //export was successful
    alert(filename);
    }
    else{
    //export was partially successful
    //this may require directing the user to an erro summary page.
    alert(filename);
    }*/
    jq('#wait').hide();
    })
    .error(function(xhr, status, err) {
    alert('There was an error generating all NDR files, check generated files at downloads directory in the application root folder ' + err);
    //popupDialog.close();
    jq('#wait').hide();
    })
    });
    });


    jq(function() {
        jq('#${ id }_button_tester').click(function() {
    jq('#gen-wait').show();

            jq.getJSON('${ ui.actionLink("reloadTester") }')
    .success(function(data) {
    jq('#gen-wait').hide();
    alert(data);
    console.log(data);
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert(data);

    })
    });
    });

</script>

<a id="${ id }_button"  class="button app big" style="font-size:12px;min-height: 10px;">
    <i class="icon-download"></i>
    <br/>
    <p>Generate NDR</p>
</a>

<a id="${ id }_button_tester"  class="button app big" style="font-size:12px;min-height: 10px;">
    <i class="icon-download"></i>
    <br/>
    <p>Refresh Community Testers</p>
</a>

