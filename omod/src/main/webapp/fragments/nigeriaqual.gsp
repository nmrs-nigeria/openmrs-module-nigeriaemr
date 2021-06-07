<%
    def id = config.id
%>
<%=ui.resourceLinks()%>

<script>
    jq = jQuery;

    jq(function () {

        var popupDialog = emr.setupConfirmationDialog({
            selector: '#divPopup',
            actions: {
                cancel: function () {
                    cannotLoginController.close();
                }
            }
        });

        jq('#main_button').click(function(){
            popupDialog.show();
        });

        jq('#${ id }_button').click(function () {

            let startDatePeriod = jq('#startDate-field').val();
            let endDatePeriod = jq('#endDate-field').val();

            if( !startDatePeriod || !endDatePeriod){
                alert("Please supply valid values for start and End date ");
                return;
            }
            if(Date.parse(endDatePeriod) < Date.parse(startDatePeriod)){
                alert("Start date must be before the end date");
                return;
            }


            jq.getJSON('${ ui.actionLink("getNigeriaQualReport") }',
                {
                    'start': startDatePeriod,
                    'end': endDatePeriod,
                })
                .success(function (filename) {
                    if(filename === "no new patient record found"){
                        alert("no updated patient record found")
                    }
                    else{
                        window.location = filename;
                    }
                })
                .error(function (xhr, status, err) {
                    alert('AJAX error ' + err);
                })
        });


    });
</script>



<a id="main_button" href="javascript:void(0)" class="button app big" style="font-size:12px;min-height: 10px;">
    <i class="icon-file-alt"></i>
    <br/>

    <p>Generate Nigeria Qual Adult Report</p>
</a>


<div id="divPopup" class="dialog" style="display: none">
    <div class="dialog-header">
        <i class="icon-check-in"></i>

        <h3>Generate Nigeria Qual Report</h3>
    </div>

    <div class="dialog-content form">
        <p>
            <label for="startDate" class="required">
                Start Date
            </label>
            <span id="startDate">
                <label for="startDate-display">

                </label>
                <span id="startDate-wrapper" class="date">
                    <input type="text" id="startDate-display" value="" placeholder="Enter date" size="null"
                           readonly/>
                    <span class="add-on"><i class="icon-calendar small"></i></span>
                </span>
                <input type="hidden" id="startDate-field" name="startDate"
                       value="" placeholder="Enter date"/>
                <span id="fr7082" class="field-error" style="display: none">

                </span>
            </span>
            <script type="text/javascript">
                var viewModel = viewModel || {};
                viewModel.validations = viewModel.validations || [];

                jq("#startDate-wrapper").datetimepicker({
                    minView: 2,
                    autoclose: true,
                    pickerPosition: "bottom-left",
                    todayHighlight: true,
                    format: "dd M yyyy",
                    // endDate: "03-05-2018",
                    language: "en_GB",
                    linkField: "startDate-field",
                    linkFormat: "yyyy-mm-dd"
                })
            </script>
        </p>

        <p>
            <label for="endDate" class="required">
                End Date
            </label>
            <span id="endDate">
                <label for="endDate-display">

                </label>
                <span id="endDate-wrapper" class="date">
                    <input type="text" id="endDate-display" value="" size="null" placeholder="Enter date"
                           readonly/>
                    <span class="add-on"><i class="icon-calendar small"></i></span>
                </span>
                <input type="hidden" id="endDate-field" name="endDate"
                       value="" placeholder="Enter date"/>
                <span id="fr951" class="field-error" style="display: none">

                </span>
            </span>
            <script type="text/javascript">
                var viewModel = viewModel || {};
                viewModel.validations = viewModel.validations || [];

                jq("#endDate-wrapper").datetimepicker({
                    minView: 2,
                    autoclose: true,
                    pickerPosition: "bottom-left",
                    todayHighlight: true,
                    format: "dd M yyyy",
                    // endDate: "03-05-2018",
                    language: "en_GB",
                    linkField: "endDate-field",
                    linkFormat: "yyyy-mm-dd"                })
            </script>
        </p>

        <a href="#" class="confirm button" id="${id}_button" download>Ok
            <i class="icon-spinner icon-spin icon-2x"
               style="display: none; margin-left: 10px;">

            </i>
        </a>
    </div>
</div>


