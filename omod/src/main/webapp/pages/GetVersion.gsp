<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>


<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-8 offset-lg-2">

        <div class="panel panel-flat">

            <div class="panel-heading" style="padding:10px 20px">


               ${ ui.includeFragment("nigeriaemr", "getVersion") }

            </div>

        </div>
        

    </div>
</div>