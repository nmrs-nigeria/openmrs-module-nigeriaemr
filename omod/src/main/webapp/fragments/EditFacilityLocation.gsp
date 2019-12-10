<%
def id = config.id
%>
<%= ui.resourceLinks() %>


<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-8 offset-lg-2">

        <div class="panel panel-flat">

            <div class="panel-heading" style="padding:10px 20px">


                <h5>
                    <br/>
                    <input style="width: 40%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px;" class="heading-text pull-left" type="text" id="nameEditSearch" onkeyup="myEditFunction()" placeholder="Search..">

                    <br/><br/>
                </h5>

            </div>

        </div>
        
          <div class="container" id="edit_form" name="edit_form" style="padding-top: 10px; display: none">
         <h5 style="margin-left: 2%; width: 40%; height: 90%; background-color: #00463f; border-radius: 10px; ">
                        <br/> <br/>
      
               

               <div>
                        <label style="font-size: 16px; padding: 12px 20px 12px 40px; margin-bottom: 12px; color: #fff; margin-top: 20px" for="datimcode">Datimcode</label>
                        <input style="margin-left: 20px; width: 70%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px; border-radius: 15px 50px;" class="form-control heading-text pull-left" type="text" id="editDatimcode" name="editDatimcode" placeholder="Enter datimcode"></td>

                </div><br>
                
                <div>
                        <label style="font-size: 16px; padding: 12px 20px 12px 40px; margin-bottom: 12px; color: #fff; margin-top: 20px" for="facility_name">Facility Name</label>
                        <input style="margin-left: 20px; width: 70%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px; border-radius: 15px 50px;" type="text" class="form-control" id="edit_facility_name" name="edit_facility_name" placeholder="Enter facility name"></td>
                        <input type="text" id="uuid" disabled="true"  name="uuid" style="border: none; display: none;"/>
                        <input type="text" id="location_id" disabled="true"  name="uuid" style="border: none; display: none;"/>
                        <input type="text" id="location_name" disabled="true"  name="uuid" style="border: none; display: none;"/>

                </div><br>

                <div>
                    <input style="background-color: #E8F0FE; margin-left: 45px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Update facility location" class="btn btn-primary" onclick="updateFacilityLocation()" />
                </div>
        <br/><br/>


        </h5><br>
    </div>
        
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="edit_facility_locations">
                <thead>
                    <tr>
                         <th>${ ui.message("Location Name") }</th>
                        <th>${ ui.message("Datim Code") }</th>
                        <th>${ ui.message("Facility Name") }</th>
                       
                        <th>${ ui.message("Action") }</th>

                    </tr>
                </thead>
                <tbody id="EditTableBody">




                </tbody>
            </table>

        </div>

    </div>
</div>

<script>
    function myEditFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameEditSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("edit_facility_locations");
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
 
    jq = jQuery;
    jq('#wait').hide();
    var globalLocations = "";

    jq(function() {
       
    jq('#gen-wait').show();

    jq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getAllFacilityLocation") }",
    dataType: "json",
  
    

    }).success(function(data) {
    jq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);
    globalLocations = jq.parseJSON(data);

     console.log(obj.length);
     console.log(obj);
     
    
    if(obj !="")
    {
    
        for(var i=0;i<obj.length;i++)
        {
            facilityID = "\'"+obj[i].uuid+"\'";
            console.log(facilityID);
            editButton = '<button type="Reload List" class="btn btn-primary heading-text" style="width: 80%;" onclick="editLocation(' + facilityID + ')">'+"Edit"+'</button>';
            jq('#EditTableBody').append("<tr><td>"+obj[i].location_name+"</td><td>"+obj[i].datimCode+"</td><td>"+obj[i].facility_name+"</td><td>"+editButton+"</td></tr>");

        }
    
    }
    
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });

</script>





<script type="text/javascript">

    function editLocation(facilityID) 
    {
        if(facilityID)
           {
                console.log(facilityID);
                    
                console.log(globalLocations);

                var result = jQuery.grep(globalLocations, function(e){ return e.uuid == facilityID; });

                console.log(result); 

                jQuery('#edit_form').hide(500);

                jQuery('#editDatimcode').val(result[0].datimCode);
                jQuery('#edit_facility_name').val(result[0].facility_name);
                jQuery('#uuid').val(result[0].uuid);
                 jQuery('#location_id').val(result[0].location_id);
                  jQuery('#location_name').val(result[0].location_name);
                
                
                jQuery('#edit_form').show(500);
           }
           else
           {
                alert('Invalid Facility');
           }
    }
    
</script>


<script>
    function updateFacilityLocation(){
        
        var uuid = jQuery('#uuid').val();
        var editDatimcode = jQuery('#editDatimcode').val();
        var edit_facility_name = jQuery('#edit_facility_name').val();
        var location_id = jQuery('#location_id').val();
        var location_name = jQuery('#location_name').val();
            
        console.log(uuid);
        console.log(editDatimcode);
        console.log(edit_facility_name);
        
      
        var date_created = " ";
        var creator = " ";
        var date_modified = " ";
        var modified_by = " ";
        
        var combined = JSON.stringify({location_id: location_id,location_name: location_name, 
        datimCode: editDatimcode, facility_name: edit_facility_name, 
        uuid: uuid, date_created: date_created, 
        creator: creator, date_modified: date_modified, modified_by: modified_by});
        
        console.log(combined);
        
        jq = jQuery;
        jq('#wait').hide();
        
        jq(function() {
       
    jq('#gen-wait').show();

    jq.ajax({
         url: "${ ui.actionLink("nigeriaemr", "ndr", "editFacilityLocation") }",
    dataType: "json",
    data: {
    'facilityLocationString' : combined
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