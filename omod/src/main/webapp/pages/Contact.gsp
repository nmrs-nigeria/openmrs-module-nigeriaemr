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

/* Go from zero to full opacity */
@keyframes fadeEffect {
  from {opacity: 0;}
  to {opacity: 1;}
</style>

<!-- Tab links -->
<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'Create_Contacts')"  id="defaultOpen">Create Contacts</button>
  <button class="tablinks" onclick="openTab(event, 'Contacts_Listing')">Contacts Listing</button>
</div>

<!-- Tab content -->
<div id="Create_Contacts" class="tabcontent">

  <% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<% ui.includeJavascript("nigeriaemr", "lga.js") %>

<style>

    table, tr, td {
    border: none;
    }

</style>
<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-8 offset-lg-2">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Attach contact to CEC</a>
            <div class="collapse navbar-collapse" id="navbarColor02">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"  >
                        <a class="nav-link"href="#">Home <span class="sr-only">(current)</span></a>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit" style="margin-right: 5px">Add new Contact</button>
                    <button class="btn btn-secondary my-2 my-sm-0" type="submit">Add community tester</button>
                </form>
            </div>
        </nav>


    </div>
</div>




<div class="container" style="padding-top: 10px;">
    <form>
        <fieldset>
            <div>
                <legend> Index Client Patient Id</legend>
                <input type="text" name="index_patient_id" value="7" disabled="true" />
            </div>

            <legend> Relationship</legend>
            <div class="form-row">

                <label class="radio-inline" style="padding-right: 70px"><input type="radio" name="relationship">Sexual Partner</label>
                <label class="radio-inline" style="padding-right: 70px"><input type="radio" name="relationship">Biological Children</label>
                <label class="radio-inline" style="padding-right: 70px"><input type="radio" name="relationship">PWID</label>
                <label class="radio-inline" style="padding-right: 70px"><input type="radio" name="relationship" checked>Siblings</label>
                <label class="radio-inline" style="padding-right: 70px"><input type="radio" name="relationship">Biological Mother</label>

            </div>
        </fieldset>



        <table cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <label for="age">Age</label><input type="text" class="form-control" name="age" id="age" placeholder="Age"></td>

                <td><label for="sex">Sex</label>
                    <select id="sex" name="sex" class="form-control">
                        <option selected>Choose...</option>
                        <option>Male</option>
                        <option>Female</option>
                    </select> </td>

                <td><label for="preferred_testing_location">Contacts preffered testing location</label>
                    <select id="preferred_testing_location" name="preferred_testing_location" class="form-control">
                        <option selected>Choose...</option>
                        <option>Facility</option>
                        <option>Community level</option>
                        <option>Other location</option>
                    </select> </td>
            </tr>
            <br/>


            <tr>
                <td>
                    <label for="state">State</label>
                    <select id="state" name="state" class="form-control">
                        <option value="" selected="selected" >- Select -</option>
							  <option value='Abia'>Abia</option>
							  <option value='Adamawa'>Adamawa</option>
							  <option value='AkwaIbom'>AkwaIbom</option>
							  <option value='Anambra'>Anambra</option>
							  <option value='Bauchi'>Bauchi</option>
							  <option value='Bayelsa'>Bayelsa</option>
							  <option value='Benue'>Benue</option>
							  <option value='Borno'>Borno</option>
							  <option value='Cross River'>Cross River</option>
							  <option value='Delta'>Delta</option>
							  <option value='Ebonyi'>Ebonyi</option>
							  <option value='Edo'>Edo</option>
							  <option value='Ekiti'>Ekiti</option>
							  <option value='Enugu'>Enugu</option>
							  <option value='FCT'>FCT</option>
							  <option value='Gombe'>Gombe</option>
							  <option value='Imo'>Imo</option>
							  <option value='Jigawa'>Jigawa</option>
							  <option value='Kaduna'>Kaduna</option>
							  <option value='Kano'>Kano</option>
							  <option value='Katsina'>Katsina</option>
							  <option value='Kebbi'>Kebbi</option>
							  <option value='Kogi'>Kogi</option>
							  <option value='Kwara'>Kwara</option>
							  <option value='Lagos'>Lagos</option>
							  <option value='Nasarawa'>Nasarawa</option>
							  <option value='Niger'>Niger</option>
							  <option value='Ogun'>Ogun</option>
							  <option value='Ondo'>Ondo</option>
							  <option value='Osun'>Osun</option>
							  <option value='Oyo'>Oyo</option>
							  <option value='Plateau'>Plateau</option>
							  <option value='Rivers'>Rivers</option>
							  <option value='Sokoto'>Sokoto</option>
							  <option value='Taraba'>Taraba</option>
							  <option value='Yobe'>Yobe</option>
							  <option value='Zamfara'>Zamafara</option>
                    </select></td>

                <td><label for="lga">LGA</label>
                    <select name="lga" id="lga" class="form-control" required>
                      <option selected>Choose...</option>

                    </select></td>

                <td><label for="town">Town</label>
                    <input type="text" class="form-control" id="town" name="town" > </td>
            </tr>


            <tr>
                <td>
                    <label for="village">Village</label>
                    <input type="text" class="form-control" id="village" placeholder="village of origin"></td>

            </tr>
        </table>

        <fieldset>
            <legend>Relationship situations</legend>

        <div class="form-group">
            <div class="checkbox">
                <label><input type="checkbox" name="physically_abused" value=""><span class="" style="padding-left: 10px">Physical abuse (hit, kicked, slapped or phisically hurt) within the last year</span></label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" name="forced_sexually" value=""><span class="" style="padding-left: 10px">Forced sexual activities within the last year</span></label>
            </div>
            <div class="checkbox">
                <label><input type="checkbox" value="" name="fear_their_partner" ><span class="" style="padding-left: 10px">Fear their partner</span></label>
            </div>

        </div>
        </fieldset>



        <fieldset>
            <legend>
                Notification method
            </legend>
            <div class="form-group">

                <div class="radio">
                    <label><input type="radio" name="notification_method" ><span class="" style="padding-left: 10px">Cleint referral</span></label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="notification_method"><span class="" style="padding-left: 10px">provider referral</span></label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="notification_method"><span class="" style="padding-left: 10px">Contact referral</span></label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="notification_method"><span class="" style="padding-left: 10px">Dual referral</span></label>
                </div>
            </div>
        </fieldset>

        <fieldset>
            <legend>More Information</legend>
            <textarea rows="2"  cols="100"  name="more_information" ></textarea>
        </fieldset>

        <fieldset>
            <legend>
                Assign to Community Tester
            </legend>
            <div class="form-group">

                <div class="radio">
                    <label><input type="radio" name="assign_contact_to_cec"><span class="form-control" style="padding-left: 10px" onclick="showTester()"  >Yes</span></label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="assign_contact_to_cec"><span class="form-control" style="padding-left: 10px"  onchange="hideTester()" >No</span></label>
                </div>

            </div>

        </fieldset>


        <button type="submit" class="btn btn-primary">Add contact</button>
/<br>
        <fieldset id="tester-section">
            <div  style="display: none">
                <label for="community_tester_name">Pick Community Tester</label>
                <select id="community_tester_name" name="community_tester_name" class="form-control">
                    <option selected>Choose...</option>
                    <option>Facility</option>
                    <option>Community level</option>
                </select>
            </div>
        </fieldset>
    </form>
</div>



</div>

<div id="Contacts_Listing" class="tabcontent">


${ ui.includeFragment("nigeriaemr", "contactlist") }

</div>

<script type="text/javascript">

    function showTester(){
        jQuery('#tester-section').show(500)

    }

    function hideTester(){
        jQuery('#tester-section').hide(500)

    }


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