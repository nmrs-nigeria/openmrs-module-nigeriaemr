<%
    def id = config.id
%>
<%= ui.resourceLinks() %>


<a id="${ id }_button"  class="button app big" style="font-size:12px;min-height: 10px;" href="customNdr.page">
    <i class="icon-download"></i>
    <br/>
    <p>Generate NDR Files</p>
</a>

<a id="${ id }_button_loc_export"  class="button app big" style="font-size:12px;min-height: 10px;" href="ndrexport.page">
    <i class="icon-lock"></i>
    <br/>
    <p>NDR Export By Location</p>
</a>

<a id="${ id }_button_manage_location"  class="button app big" style="font-size:12px;min-height: 10px;" href="FacilityLocation.page">
    <i class="icon-file-alt"></i>
    <br/>
    <p>Manage Facility Location</p>
</a>

<a id="${ id }_button_manage_location"  class="button app big" style="font-size:12px;min-height: 10px;" href="GetVersion.page">
    <i class="icon-eye-open"></i>
    <br/>
    <p>Version Info</p>
</a>