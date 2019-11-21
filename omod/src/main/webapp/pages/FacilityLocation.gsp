<style>
    /* Style the tab */
    .tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
    }

    /* Style the buttons that are used to open the tab content */
    .tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
    background-color: #ddd;
    }

    /* Create an active/current tablink class */
    .tab button.active {
    background-color: #ccc;
    }

    /* Style the tab content */
    .tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
    animation: fadeEffect 1s; /* Fading effect takes 1 second */
    }

    /*.input-w label, .input-w input {
    float: none; !* if you had floats before? otherwise inline-block will behave differently *!
    display: inline-block;
    vertical-align: middle;
    }*/

    /* Go from zero to full opacity */
    @keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
    }
    
    .select_content{
    
    margin-left: 20px; 
    width: 100%;
    height: 100%
    font-size: 16px; 
    padding: 12px 20px 12px 40px; 
    border: 1px solid #ddd; 
    margin-bottom: 0px; 
    border-radius: 15px 50px;
    
    }
</style>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>

<!-- Tab links -->
<div class="tab">
        
    <button class="tablinks" onclick="openTab(event, 'Create_Facility_Location')" id="defaultOpen">Create Facility Location</button>

    <button class="tablinks" onclick="openTab(event, 'Edit_Facility_Location')">Edit Facility Location</button>
    
    <button class="tablinks" onclick="openTab(event, 'Delete_Facility_Location')">Delete Facility Location</button>


</div>

<!-- Tab content -->
<div id="Create_Facility_Location" class="tabcontent">

  <!--  <% ui.decorateWith("appui", "standardEmrPage") %>

    <%= ui.resourceLinks() %>

    <% ui.includeJavascript("patientindextracing", "lga.js") %>


 <script>

        var globalPatientID = "";
        function getUrlVars()
        {
            let vars = [], hash;
            let hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            console.log(hashes);
            for(let i = 0; i < hashes.length; i++)
            {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            console.log(vars);
            return vars;
        }


        let patientId;
        patientId = getUrlVars()["patientId"];
        globalPatientID = getUrlVars()["patientId"];
       
        
      
    

    </script>



-->

    <style>

        table, tr, td {
        border: none;
        }

    </style>

   
    <div class="row wrapper  white-bg page-heading"  style="">

        <h4 style="text-align: center">
                    
                    Create Facility Location 
                    
        </h4>
    </div>

<br>


    <div class="container" style="padding-top: 10px;">
         <h5 style="margin-left: 32%; width: 40%; height: 90%; background-color: #00463f; border-radius: 10px; ">
                        <br/> <br/>
      
                <div>
                        <label style="font-size: 16px; padding: 12px 20px 12px 40px; margin-bottom: 12px; color: #fff; margin-top: 20px" for="location">Location</label>
                        <select style="margin-left: 20px; width: 84%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: -10px; border-radius: 15px 50px;" name="locations" id="locations" required>
                              <option selected>Select location...</option>

                        </select>
               </div><br>

               <div>
                        <label style="font-size: 16px; padding: 12px 20px 12px 40px; margin-bottom: 12px; color: #fff; margin-top: 20px" for="datimcode">Datimcode</label>
                        <input style="margin-left: 20px; width: 70%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px; border-radius: 15px 50px;" class="form-control heading-text pull-left" type="text" id="datimcode" name="datimcode" placeholder="Enter datimcode"></td>

                </div><br>
                
                <div>
                        <label style="font-size: 16px; padding: 12px 20px 12px 40px; margin-bottom: 12px; color: #fff; margin-top: 20px" for="facility_name">Facility Name</label>
                        <input style="margin-left: 20px; width: 70%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: 12px; border-radius: 15px 50px;" type="text" class="form-control" id="facility_name" name="facility_name" placeholder="Enter facility name"></td>

                </div><br>

                <div>
                        <input style="background-color: #E8F0FE; margin-left: 45px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Add facility location" class="btn btn-primary" />
                </div>
        <br/><br/>


        </h5>
    </div>



</div>




<div id="Contacts_Listing" class="tabcontent">
    ${ ui.includeFragment("nigeriaemr", "EditFacilityLocation") }

</div>

<div id="Contacts_Listing" class="tabcontent">
    ${ ui.includeFragment("nigeriaemr", "DeleteFacilityLocation") }

</div>




</div>

<script>
    
    jQuery(document).ready(function() {
    jQuery('.select_content').select2();
});
</script>


<script>

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();

    function openTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
    }

</script>


<script>
    jqq = jQuery;
    jqq('#wait').hide();
    var globalTester = "";
    jqq(function() {
       
    jqq('#gen-wait').show();

    jqq.ajax({
        url: "${ ui.actionLink("patientindextracing", "ndr", "getAllLocation") }",
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
          
            
            jqq('#locations').append("<option value=\""+testerID+"\">"+testerName+"</option>");

  
      }
    
    }
    
    })
    .error(function(xhr, status, err) {
    jqq('#gen-wait').hide();
    alert('An error occured');

    }); 

    });

</script>