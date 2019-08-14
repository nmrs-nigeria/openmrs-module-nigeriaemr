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
                    <input style="width: 40%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px;" class="heading-text pull-left" type="text" id="nameSearch" onkeyup="myFunction()" placeholder="Search..">

                    <button id="${ id }_button_contact" type="Reload List" class="btn btn-primary heading-text pull-right">Refresh Contact List</button>
                    <br/><br/>
                </h5>

            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered  table-hover" id="tb_commtester">
                <thead>
                    <tr>
                        <th>${ ui.message("First Name") }</th>
                        <th>${ ui.message("Last Name") }</th>
                        <th>${ ui.message("Gender") }</th>
                        <th>${ ui.message("State") }</th>

                    </tr>
                </thead>
                <tbody>




                </tbody>
            </table>

        </div>

    </div>
</div>

<script>
    function myFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("nameSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("tb_commtester");
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
        jq('#${ id }_button_tester').click(function() {
    jq('#gen-wait').show();

    jq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getIndexContacts") }",
    dataType: "json",
    data: {
    'indexClientId': '10'
    }
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
    });

</script>
