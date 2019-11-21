<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.10/js/select2.min.js"></script>


<div class="row wrapper  white-bg page-heading"  style="">

        <h4 style="text-align: center">
                    
                    NDR Export Page
                    
        </h4>
    </div>

<br>


    <div class="container" style="padding-top: 10px;">
         <h5 style="margin-left: 32%; width: 40%; height: 50%; background-color: #00463f; border-radius: 10px; ">
                        <br/> <br/>
      
                <div>
                        <select style="margin-left: 30px; width: 84%;font-size: 16px; padding: 12px 20px 12px 40px; border: 1px solid #ddd; margin-bottom: -10px; border-radius: 15px 50px;" name="facility_location" id="facility_location" required>
                              <option selected>Select facility location...</option>

                        </select>
               </div><br>

                <div>
                        <input style="background-color: #E8F0FE; margin-left: 52px; width: 70%; height: 45px; border-radius: 25px; margin-top: 15px" type="button" value="Export" class="btn btn-primary" />
                </div>
        <br/><br/>


        </h5>
    </div>