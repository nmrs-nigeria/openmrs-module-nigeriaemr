
<div class="row" id="id-type-div">
    <div class="col-sm-5" id="sel-id-type">
        <p>
            <select id="patient-Id-Types">

            </select>
        </p>
    </div>
    <div class="col-sm-4">
        <p>
            <input type="text" id="id-field"/>
        </p>
    </div>
    <div class="col-sm-3">
        <label>
           <p>
               <input type="radio" id="rd-preferred"/>
           </p> Set as preferred Id</label>
    </div>
    <div class="col-sm-2">
        <button id="btn-remove">remove</button>
    </div>
</div>

<script>

    jq = jQuery;

    jq(function()
    {
        var pp = jq(location).attr('pathname').split('/');
        var path = pp[1];
        jq.ajax({
            type: "GET",
            contentType: "application/json",
            url: path + '/ws/rest/v1/patientidentifiertype',
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data)
            {
                console.log("SUCCESS : ", data);

            },
            error: function (e)
            {
                console.log("ERROR : ", e);
                jq("#btn-search").prop("disabled", false);

            }
        });

    });



    //variable to cache the id of the checkbox of the selected preferred patientIdentifier
    var prefIdentifierElementId = null;
    var numberOfClonedElements = 0;
    var currentSelectedIdentifier = "";
    var idTypeLocationRequired = {};
    var currentIdentifierCount = 1;

    idTypeLocationRequired[6] = false;

    idTypeLocationRequired[7] = false;

    idTypeLocationRequired[8] = false;

    idTypeLocationRequired[5] = false;

    idTypeLocationRequired[2] = false;

    idTypeLocationRequired[3] = false;

    idTypeLocationRequired[1] = false;

    idTypeLocationRequired[9] = true;

    idTypeLocationRequired[4] = false;


    function addIdentifier(initialIdentifierSize) {
        var index = initialIdentifierSize+numberOfClonedElements;
        var tbody = document.getElementById('identifiersTbody');
        var row = document.getElementById('newIdentifierRow');
        var newrow = row.cloneNode(true);

        newrow.style.display = "";
        newrow.id = 'identifiers[' + index + ']';
        tbody.appendChild(newrow);
        var inputs = newrow.getElementsByTagName("input");
        var selects = newrow.getElementsByTagName("select");
        for (var i in selects) {
            var select = selects[i];
            if (select && selects[i].name == "identifierType") {
                select.name = 'identifiers[' + index + '].identifierType';
                select.id = 'identifiers[' + index + '].identifierType';
                $j(select).change(function(){
                    toggleLocationBoxAndIndentifierTypeWarning(this.options[this.selectedIndex].value,'identifiers'+ index +'_location',index);
                });
                $j(select).focus(function(){
                    storeSelectedIdentifierType(this.options[this.selectedIndex].text);
                });
            }
            else if (select && selects[i].name == "location") {
                select.name = 'identifiers[' + index + '].location';
                select.id = 'identifiers'+ index +'_location';
            }
        }
        $j(newrow).find('.locationNotApplicableClass').attr('id', 'identifiers'+ index +'_location_NA')
        $j(newrow).find('#identifierTypeWarning').attr('id', 'identifierTypeWarning'+ index);

        for (var x = 0; x < inputs.length; x++) {
            var input = inputs[x];
            if (input && input.name == 'identifier' && input.type == 'text') {
                input.name = 'identifiers[' + index + '].identifier';
            }
            else if (input && input.name == 'preferred' && input.type == 'radio') {
                input.name = 'identifiers[' + index + '].preferred';
                input.id = 'identifiers[' + index + '].preferred';
            }
            else if (input && input.name == 'newIdentifier.voided' && input.type == 'checkbox') {
                //set the attributes of the corresponding hidden checkbox for voiding/unvoiding new identifiers
                input.name = 'identifiers[' + index + '].voided';
                input.id = 'identifiers[' + index + '].isVoided';
            }else if (input && input.name == 'closeButton' && input.type == 'button') {
                //set the onclick event for this identifier's remove button,
                //so that we check the corresponding hidden checkbox to mark a removed identifier
                $j(input).click(function(){
                    removeRow(this, 'identifiers[' + index + '].isVoided', index);
                });
            }
        }

        currentIdentifierCount++;
        if(currentIdentifierCount > 1){
            $j("#identifiersTbody > tr:visible > td:last-child > input.closeButton").show();
        }

        numberOfClonedElements++;
    }

    function updateAge() {
        var birthdateBox = document.getElementById('birthdate');
        var ageBox = document.getElementById('age');
        try {
            var birthdate = parseSimpleDate(birthdateBox.value, 'dd/mm/yyyy');
            var age = getAge(birthdate);
            if (age > 0)
                ageBox.innerHTML = "(" + age + ' yrs)';
            else if (age == 1)
                ageBox.innerHTML = '(1 yr)';
            else if (age == 0)
                ageBox.innerHTML = '( < 1 yr)';
            else
                ageBox.innerHTML = '( ? )';
            ageBox.style.display = "";
        } catch (err) {
            ageBox.innerHTML = "";
            ageBox.style.display = "none";
        }
    }

    function updateEstimated() {
        var input = document.getElementById("birthdateEstimatedInput");
        if (input) {
            input.checked = false;
            input.parentNode.className = "";
        }
        else
            input.parentNode.className = "listItemChecked";
    }

    // age function borrowed from http://anotherdan.com/2006/02/simple-javascript-age-function/
    function getAge(d, now) {
        var age = -1;
        if (typeof(now) == 'undefined') now = new Date();
        while (now >= d) {
            age++;
            d.setFullYear(d.getFullYear() + 1);
        }
        return age;
    }

    function removeRow(btn, checkBoxId, index) {
        refreshDuplicateIdentifierTypeWarningsAtRemove(index);
        var parent = btn.parentNode;
        while (parent.tagName.toLowerCase() != "tr")
            parent = parent.parentNode;

        parent.style.display = "none";
        if(checkBoxId && document.getElementById(checkBoxId)){
            document.getElementById(checkBoxId).checked = true;
            document.getElementById(checkBoxId).value = true;
        }

        currentIdentifierCount --;
        var identifiersId = 'identifiers['+index+']';
        $j(document.getElementById(identifiersId)).remove();
    }

    function removeHiddenRows() {

        var rows = document.getElementsByTagName("TR");
        var i = 0;
        while (i < rows.length) {
            //donot remove the hidden row used as a prototype for new ones
            if (rows[i].id.startsWith('newIdentifierRow')) {
                rows[i].parentNode.removeChild(rows[i]);
            }
            else {
                i = i + 1;
            }
        }
    }

    /**
     * Unchecks the current preferred patientIdentifier and checks the newly selected one
     * whenever a user clicks the radio buttons for the patientidentifiers.
     * @param radioElement the id of the radioButton for the selected identifier checkbox
     */
    function updatePreferred(radioElement){
        if(prefIdentifierElementId && document.getElementById(prefIdentifierElementId))
            document.getElementById(prefIdentifierElementId).checked = false;

        radioElement.checked = true;
        setPrefIdentifierElementId(radioElement.id);
    }

    /**
     * Caches the id of the checkbox of the selected preferred patientIdentifier
     *
     * @param elementId the id of the radioButton for the selected identifier checkbox
     */
    function setPrefIdentifierElementId(elementId){
        prefIdentifierElementId = elementId;
    }

    /**
     * Utility function that checks if a given string starts with a specified string
     *
     * @param radioElement the radioButton for the selected identifier checkbox
     */
    String.prototype.startsWith = function(prefix) {
        return this.indexOf(prefix) === 0;
    }

    function voidedBoxClicked(chk) {
        //do nothing
    }

    function preferredBoxClick(obj) {
        //do nothing
    }

    function showOrHideDuplicateIdentifierTypeWarnings(index) {
        var equalCount=0;
        var identifierTypeWarningDivId="identifierTypeWarning"+index;
        var identifierTypeId;
        if(index==0) {
            identifierTypeId = 'identifiers' + index + '.identifierType';
        } else {
            identifierTypeId = 'identifiers[' + index + '].identifierType';
        }
        var jQueryObj = $j(document.getElementById(identifierTypeId));
        var identifierTypeName = jQueryObj.children("option").filter(":selected").text().trim();
        $j('.patientIdentifierTypeColumn select > option:selected').each(function () {
            if($j(this).text().trim()==identifierTypeName && identifierTypeName!='') {
                equalCount++;
            }
        });
        if(equalCount>1) {
            $j('#'+identifierTypeWarningDivId).show();
        } else {
            $j('#'+identifierTypeWarningDivId).hide();
        }
    }

    function refreshDuplicateIdentifierTypeWarningsAtChange(index) {
        var rootNode;
        var identifierTypeId;
        if(index==0) {
            identifierTypeId = 'identifiers' + index + '.identifierType';
        } else {
            identifierTypeId = 'identifiers[' + index + '].identifierType';
        }
        var jQueryObj = $j(document.getElementById(identifierTypeId));
        var identifierTypeName = jQueryObj.children("option").filter(":selected").text().trim();
        var duplicateCountForCurrentType = 0;
        var duplicateCountForPreviousType = 0;
        $j('.patientIdentifierTypeColumn select > option:selected').each(function () {
            if ($j(this).text().trim() == identifierTypeName && identifierTypeName!='') {
                if (this.parentNode.id.trim() != identifierTypeId) {
                    rootNode = $j(this.parentNode.parentNode.parentNode);
                    $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").show();
                    duplicateCountForCurrentType++;
                    if (duplicateCountForCurrentType < 2) {
                        $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").hide();
                    }
                }
            } else if ($j(this).text().trim() == currentSelectedIdentifier.trim()) {
                rootNode = $j(this.parentNode.parentNode.parentNode);
                $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").show();
                duplicateCountForPreviousType++;
                if (duplicateCountForPreviousType < 2 || currentSelectedIdentifier=='') {
                    $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").hide();
                }
            }
        });
        currentSelectedIdentifier = "";
    }

    function refreshDuplicateIdentifierTypeWarningsAtRemove(index) {
        var rootNode;
        var identifierTypeId;
        if(index==0) {
            identifierTypeId = 'identifiers' + index + '.identifierType';
        } else {
            identifierTypeId = 'identifiers[' + index + '].identifierType';
        }
        var jQueryObj = $j(document.getElementById(identifierTypeId));
        var identifierTypeName = jQueryObj.children("option").filter(":selected").text().trim();
        var duplicateCountForCurrentType = 0;
        $j('.patientIdentifierTypeColumn select > option:selected').each(function () {
            if ($j(this).text().trim() == identifierTypeName && identifierTypeName!='') {
                if (this.parentNode.id.trim() != identifierTypeId) {
                    rootNode = $j(this.parentNode.parentNode.parentNode);
                    $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").show();
                    duplicateCountForCurrentType++;
                    if (duplicateCountForCurrentType < 2) {
                        $j(rootNode).find('.duplicateIdentifierTypeWarning').find("div").hide();
                    }
                }
            }
        });
    }

    function storeSelectedIdentifierType(selectedIdentifierType) {
        currentSelectedIdentifier = selectedIdentifierType;
    }

    function toggleLocationBoxAndIndentifierTypeWarning(identifierType, location, index) {
        showOrHideDuplicateIdentifierTypeWarnings(index);
        refreshDuplicateIdentifierTypeWarningsAtChange(index, identifierType);
        toggleLocationBox(identifierType,location);
    }

    function toggleLocationBox(identifierType,location) {
        if (identifierType == '') {
            $j('#'+location + '_NA').hide();
            $j('#'+location).hide();
        }
        else if (idTypeLocationRequired[identifierType]) {
            $j('#'+location + '_NA').hide();
            $j('#'+location).show();
        }
        else {
            $j('#'+location).hide();
            $j('#'+location + '_NA').show();
        }
    }

</script>
