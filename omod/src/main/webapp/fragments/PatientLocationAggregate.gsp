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
                    <input style="width: 40%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px;" class="heading-text pull-left" type="text" id="patientLocationSearch" onkeyup="myPatientFunction()" placeholder="Search..">

                    <br/><br/>
                </h5>

            </div>

        </div>
       
        
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="Patient_Location_Aggregate">
                <thead>
                    <tr>
                        <th>${ ui.message("Location Name") }</th>
                        <th>${ ui.message("Patient Count") }</th>
                 
                    </tr>
                </thead>
                <tbody id="Patient_Location_AggregateTableBody">




                </tbody>
            </table>

        </div>

    </div>
</div>

<script>
    function myPatientFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("patientLocationSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("Patient_Location_Aggregate");
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
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getPatientLocationAggregate") }",
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
            jq('#Patient_Location_AggregateTableBody').append("<tr><td>"+obj[i].name+"</td><td>"+obj[i].patient_count+"</td></tr>");

        }
    
    }
    
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });

</script>

