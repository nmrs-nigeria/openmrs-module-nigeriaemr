<%
def id = config.id
%>
<%= ui.resourceLinks() %>
<style>
    
.warning{
background-color: #f4da07;
width: 80%;
text-align: center;
}    

.success{
background-color: #5cb85c;
color: #fff;
width: 80%;
text-align: center;
} 
    
    
</style>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>

<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-8 offset-lg-2">

        <div class="panel panel-flat">

            <div class="panel-heading" style="padding:10px 20px">

            

                <h5>
                    <br/>
                    <input style="width: 40%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px;" class="heading-text pull-left" type="text" id="nameSearchAssign" onkeyup="myFunctionAssign()" placeholder="Search..">

                    <br/><br/>
                </h5>
         <form method="post">       
            <div id="assignment_community_tester" class="form-control" style="display: none">

                <fieldset>
                    <legend>
                        Choose Community Tester
                    </legend>
                    <div >
                        
                        <input type="text" id="user_name" disabled="true"  name="user_name" style="border: none"/>
                        
                        <select id="testers" name="testers_list" class="form-control js-example-basic-single" style="width: 60%">
                           
                            
                            <option selected>Choose...</option>
                            
                        </select>

                        <input type="text" id="community_tester_name_input" name="community_tester_name" disabled="true" style="display: none"/>
                        
                        <input type="text" id="user_id" disabled="true"  name="user_id" style="border: none; display: none;"/>

                    </div>
                </fieldset>
                
                 <br>
            <div> <br>
                <input type="button" value="Assign/Re-assign contact" class="btn btn-primary" onclick="processAssignment()" />
            </div>
            <br>
            </div>
           
        </form>

            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="tb_assignment">
                <thead>
                    <tr>
                        <th>${ ui.message("First Name") }</th>
                        <th>${ ui.message("Last Name") }</th>
                       
                        <th>${ ui.message("Assigned To") }</th>
                        <th>${ ui.message("Actions") }</th>
                    </tr>
                </thead>
                <tbody id="AssignTableBody">




                </tbody>
            </table>

        </div>

    </div>
</div>



<script>
    function myFunctionAssign() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameSearchAssign");
    filter = input.value.toUpperCase();
    table = document.getElementById("tb_assignment");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td");

    for (var j = 0; j < td.length; j++) {
    cell = tr[i].getElementsByTagName("td")[j];
    if (cell) {
        if (cell.innerHTML.toUpperCase().indexOf(filter) > -1) {
    tr[i].style.display = "";
    break;
    }
    else {
    tr[i].style.display = "none";
    }
    }
    } 

    }
    }
</script>

<script>


    var global = "";
    jq = jQuery;
    jq('#wait').hide();
    jq(function() {
       
    jq('#gen-wait').show();

    jq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getVersionNumber") }",
    dataType: "json",
    

    }).success(function(data) {
    jq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);

     console.log(obj.length);
     console.log(obj);
 
    
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });

</script>

<script type="text/javascript">

    function showAssignmentTester(userid){
    
    console.log(userid);
    
    console.log(global);
    
    var result = jQuery.grep(global, function(e){ return e.id == userid; });
    
    console.log(result[0].firstname);
    
    var name = result[0].firstname + " " + result[0].lastname;
    
    jQuery('#assignment_community_tester').hide(500);
    
    jQuery('#user_id').val(userid);
    
    jQuery('#user_name').val("Assign/Re-assign "+name+" to:"); 

    jQuery('#assignment_community_tester').show(500);

    
    
    }

</script>

<script>
    
    jQuery(document).ready(function() {
    
    var global = "";
    jq = jQuery;
    jq('#wait').hide();
    jq(function() {
       
    jq('#gen-wait').show();

    jq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getVersionNumber") }",
    dataType: "json",
    

    }).success(function(data) {
    jqq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);
    globalTester = jq.parseJSON(data);
    var testerID = "";
    var testeName = "";

     console.log(obj.length);
     console.log(obj);
 
    
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });
});
</script>


<script>
    jqq = jQuery;
    jqq('#wait').hide();
    var globalTester = "";
    jqq(function() {
       
    jqq('#gen-wait').show();

    jqq.ajax({
        url: "${ ui.actionLink("patientindextracing", "ndr", "getAllTesters") }",
    dataType: "json",
    

    }).success(function(data) {
    jqq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);
    globalTester = jq.parseJSON(data);
    var testerID = "";
    var testeName = "";

     console.log(obj.length);
     console.log(obj);
 

    if(obj !="")
    {
    
        for(var i=0;i<obj.length;i++)
        {
        
            testerID = obj[i].id+'';
            testerName = obj[i].username+' ('+obj[i].facility_name+')';
            console.log(testerName);
            console.log(testerID);
          
            
            jqq('#testers').append("<option value=\""+testerID+"\">"+testerName+"</option>");

  
      }
    
    }
    
    })
    .error(function(xhr, status, err) {
    jqq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });

</script>


<script>
    function processAssignment(){
        
        var contactId = jQuery('#user_id').val();
        var tester = jQuery('#testers').val();
        
        var result = jQuery.grep(globalTester, function(e){ return e.id == tester; });
    
        console.log(result[0]);
        console.log(tester);
        console.log(contactId);
        
        var jsonResult =  JSON.stringify(result[0]);

        console.log(jsonResult);

        jq = jQuery;
        jq('#wait').hide();
        
        jqq(function() {
       
    jqq('#gen-wait').show();

    jqq.ajax({
         url: "${ ui.actionLink("patientindextracing", "ndr", "reassignContact") }",
    dataType: "json",
    data: {
    'contactId': contactId,
    'tester' : jsonResult
    }
    

    }).success(function(data) {
    jqq('#gen-wait').hide();
    console.log(data);
      
    alert(data);
    
    })
    .error(function(xhr, status, err) {
    jqq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });
    
    }
    
    

</script>