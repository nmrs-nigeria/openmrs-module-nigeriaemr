<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<!--<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>-->


<div class="row wrapper  white-bg page-heading"  style="">

        <h4 style="text-align: center"> 
                    NDR Export Page
                    
        </h4>
    </div>

<br>


    <div class="container" style="padding-top: 10px;">
         <div style="margin-left: 32%; width: 40%; height: 50%; background-color: #00463f; border-radius: 10px; ">
                        <br/> <br/>
      
                <div>
                        <select style="margin-left: 30px; width: 84%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: -10px; border-radius: 15px 50px;" name="facility_location" id="facility_location" required>
                              <option selected>Select facility location...</option>

                        </select>
               </div><br>

                <div>
                    <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Export" onclick="exportData()" class="btn btn-primary" />
                </div>
        <br/><br/>


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
    jqq = jQuery;
    jqq('#wait').hide();
    var globalTester = "";
    jqq(function() {
       
    jqq('#gen-wait').show();

    jqq.ajax({
        url: "${ ui.actionLink("nigeriaemr", "ndr", "getAllFacilityLocation") }",
    dataType: "json",
    

    }).success(function(data) {
    jqq('#gen-wait').hide();
    console.log(data);
     
    var obj = jq.parseJSON(data);
    globalTester = jq.parseJSON(data);
    var uuID = "";
    var facilityName = "";

     console.log(obj.length);
     console.log(obj);
 

    if(obj !="")
    {
    
        for(var i=0;i<obj.length;i++)
        {
        
            location_id = obj[i].location_id+'';
            facilityName = obj[i].facility_name+'';
            console.log(uuID);
            console.log(facilityName);
                     
            jqq('#facility_location').append("<option value=\""+location_id+"\">"+facilityName+"</option>");

  
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
    
    
   function exportData() 
    {
        
        var location_id = jQuery('#facility_location').val();
                console.log(location_id);
       
                jq = jQuery;
                jq('#gen-wait').show();
                 
                    jq.ajax({
                    url: "${ ui.actionLink("nigeriaemr", "ndr", "generateNDRFileByLocation") }",
                dataType: "json",
                 data: {
                'locationId' : location_id
                }

                }).success(function(filename) {
                 if(filename == "no new patient record found"){
                    jq('#gen-wait').hide();
                    alert("no updated patient record found")
                    }
                    else{
                    window.location = filename;
                    }
                   /* if(filename.startsWith("Files Exported successfully")){
                    //export was successful
                    jq('#gen-wait').hide();
                    alert(filename);
                    }
                    else{
                    //export was partially successful
                    //this may require directing the user to an erro summary page.
                    alert(filename);
                    }*/
                    jq('#gen-wait').hide();



                })
                .error(function(xhr, status, err) {
                jq('#gen-wait').hide();
                alert('There was an error generating all NDR files, check generated files at downloads directory in the application root folder ' + err);

                }); 
        
        
    }
    




</script>