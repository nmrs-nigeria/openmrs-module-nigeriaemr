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
   

            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="tb_version">
                <thead>
                    <tr>
                        <th style="background-color: #00463f; color: #fff">${ ui.message("Module") }</th>
                        <th style="background-color: #00463f; color: #fff" >${ ui.message("Version") }</th>
                       
                    </tr>
                </thead>
                <tbody id="VersionTableBody">




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
    table = document.getElementById("tb_version");
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
    jq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);

     console.log(obj);
     
     if(obj !="")
    {
        var keys = Object.keys(obj);
        console.log(keys);

         for (var i = 0, len = keys.length; i < len; i++) {

         console.log(keys[i]);  
         console.log(obj[keys[i]]);

            jq('#VersionTableBody').append("<tr><td>"+keys[i]+"</td><td>"+obj[keys[i]]+"</td></tr>");


        }
    
    }
     
    
 
    
    })
    .error(function(xhr, status, err) {
    jq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });
});
</script>