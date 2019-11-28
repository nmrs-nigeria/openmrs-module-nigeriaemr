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
                    <input style="width: 40%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px;" class="heading-text pull-left" type="text" id="nameDeleteSearch" onkeyup="myDeleteFunction()" placeholder="Search..">

                    <br/><br/>
                </h5>

            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="delete_facility_locations">
                <thead>
                    <tr>
                         <th>${ ui.message("Location Name") }</th>
                          <th>${ ui.message("Datim Code") }</th>
                        <th>${ ui.message("Facility Name") }</th>
                        <th>${ ui.message("Action") }</th>

                    </tr>
                </thead>
                <tbody id="DeleteTableBody">




                </tbody>
            </table>

        </div>

    </div>
</div>

<script>
    function myDeleteFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameDeleteSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("delete_facility_locations");
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
    jq(function() {
       
    jq('#gen-wait').show();

    jq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getAllFacilityLocation") }",
    dataType: "json",
  

    }).success(function(data) {
    jq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);

     console.log(obj.length);
     console.log(obj);
    
    if(obj !="")
    {
    
        for(var i=0;i<obj.length;i++)
        {
           facilityID = "\'"+obj[i].uuid+"\'";
            console.log(facilityID);

            deleteButton = '<button type="Reload List" class="btn btn-primary heading-text" style="width: 80%;" onclick="deleteLocation(' + facilityID + ')">'+"Delete"+'</button>';
            jq('#DeleteTableBody').append("<tr><td>"+obj[i].location_name+"</td><td>"+obj[i].datimCode+"</td><td>"+obj[i].facility_name+"</td><td>"+deleteButton+"</td></tr>");

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

    function deleteLocation(facilityID) 
    {
        
          if(facilityID)
           {
                console.log(facilityID);
                
                jq = jQuery;
                    jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "deleteFacilityLocation") }",
                dataType: "json",
                 data: {
                'facilityLocationUUID' : facilityID
                }

                }).success(function(data) {
                jq('#gen-wait').hide();
                alert("Delete operation was successful");



                })
                .error(function(xhr, status, err) {
                jq('#gen-wait').hide();
                alert('An error occured');

                }); 
           }
           else
           {
                alert('Invalid Facility');
           }
        
    }
    
</script>
