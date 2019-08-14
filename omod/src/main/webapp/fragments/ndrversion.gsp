<%
    def id = config.id
%>
<%= ui.resourceLinks() %>

<script>
        jq = jQuery;
//jq('#version_display').hide();
jq(function() {
    jq('#${ id }_version_button').click(function() {
        jq('#version_display').show(250);
        jq.getJSON('${ ui.actionLink("getVersionNumberAsObject") }')
        .success(function(version) {
            jq("#version_number_display").empty();
            for (i = 0; i < version.length; i++) {
                jq("#version_number_display").append("<tr />");
                jq(jq("#version_number_display tr")[i]).append("<td>" + version[i] + "</td>");
            }
           // jq('#version_display').hide(350);
            console.log(version);
        })
        .error(function(xhr, status, err) {

            alert('Version file not found ' + err);
            console.log(err);
            console.log(status);
            console.log(xhr);
            //jq('#version_display').hide(350);
        });
    });

    jq('#modal_close_button').click(function(){
        jq('#version_display').hide(350);
    });
});
</script>

<a id="${ id }_version_button" class="button app big" style="font-size:12px;min-height: 10px;">
<i class="icon-sitemap"></i>
        <br/>
        <p>NMRS Version</p>
</a>


