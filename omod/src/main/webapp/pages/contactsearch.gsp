<% ui.decorateWith("appui", "standardEmrPage") %>

<%= ui.resourceLinks() %>

<% ui.includeJavascript("nigeriaemr", "scripts/datatables.min.js") %>
<div class="row wrapper  white-bg page-heading"  style="">
    <div class="col-lg-8 offset-lg-2">

        <div class="panel panel-flat">

            <div class="panel-heading" style="padding:10px 20px">
                <h5 >
                  Find Contact with referral Id
                </h5>


            </div>
            
            </div>
            <div class="table-responsive">
                
                   <table cellspacing="0" cellpadding="0">
            <tr>
<!--                <td><div class="col-md-1">
                            <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> Refresh</button>
                        </div></td>-->
            <form>
                <td> 
                            <div class="col-md-11">
                                <div class="input-group">
                                    <input type="text" placeholder="Search by Name and Referral ID" name="search" value="" class="input-sm form-control" style="width: 100%">
                                   
                                </div>
                            </div>
                        </td>

                <td> <span class="input-group-btn">
                                      <button type="submit" class="btn btn-sm btn-primary"> Go!</button>
                                    </span></td>
            </form>
            </tr>
            <br/>

        </table>
       </div>
</br>

 <div class="table-responsive">
                <table class="table table-striped table-bordered  table-hover" id="tb_commtester">
                    <thead>
                    <tr>
                        <th>${ ui.message("username") }</th>
                        <th>${ ui.message("email") }</th>
                        <th>${ ui.message("assign_facilityId") }</th>
                        <th>${ ui.message("facility_name") }</th>
                     
                    </tr>
                    </thead>
                    <tbody>
                    <% if (testers) { %>
                        <% testers.each { %>
                            <tr>
                                <td>${ ui.format(it.username) }</td>
                                <td>${ ui.format(it.email) }</td>
                                <td>${ ui.format(it.assign_facilityId) }</td>
                               <td>${ ui.format(it.facility_name) }</td>
                            </tr>
                        <% } %>
                    <% } else { %>
                        <tr>
                            <td colspan="4">${ ui.message("general.none") }</td>
                        </tr>
                    <% } %>

                    </tbody>
                </table>
              
            </div>

        </div>
    </div>
<script type="text/javascript">
 jQuery(document).ready(function () {
            jQuery('#tb_commtester').DataTable({
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    { extend: 'copy' },
                    { extend: 'csv' },
                    { extend: 'excel', title: 'employee_list' },
                    { extend: 'pdf', title: 'employee_list' },

                    {
                        extend: 'print',
                        customize: function (win) {
                            jQuery(win.document.body).addClass('white-bg');
                            jQuery(win.document.body).css('font-size', '10px');

                            jQuery(win.document.body).find('table')
                               .addClass('compact')
                                .css('font-size', 'inherit');
                        }
                    }
                ]

            });

        });
    

</script>

       
       
        </div>
    </div>

