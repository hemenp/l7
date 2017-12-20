/**
 * Author: Vijayan Chendrayan
 */

var j = jQuery.noConflict();

//reset wbs Element 
function resetWbsElement() {
    if(j("#wbsElementId") !=""){
    	 j("#wbsElementId").val('');
     }
} 
//reset requestor name
function resetRequestor(e) {
	 var code = (e.keyCode ? e.keyCode : e.which);
	if (code!= 13) {
	    if(j("#reqInfo\\.requestorEmployeeId") !=""){
	    	j("#reqInfo\\.requestorEmployeeId").val('');
	     }
	}
}
//reset manager name
function resetManager(e) {
	 var code = (e.keyCode ? e.keyCode : e.which);
	if (code!= 13) {
	    if(j("#reqInfo\\.managerEmployeeId") !=""){
	    	j("#reqInfo\\.managerEmployeeId").val('');
	     }
	}
}
//reset vice president name
function resetVicePresident(e) {
	 var code = (e.keyCode ? e.keyCode : e.which);
	if (code!= 13) {
	    if(j("#reqInfo\\.vpEmployeeId") !=""){
	    	j("#reqInfo\\.vpEmployeeId").val('');
	     }
	}
}
// reset cost center
function resetCostCenter() {
    if(j("#costCenterId") !=""){
    	j("#costCenterId").val('');
     }
    var val = j("#wbsElementText").val();
    costOrWbsDataValidation("wbselement",val);
}

/**
 * File Upload Script
 */

j(function(){ // wait for document to load
	j('#uploadFile').MultiFile({
		STRING: {
		remove: '<img src="/o/pgc-portlet/images/close-icon.gif" height="16" width="16" alt="x"/>'
		}
	});
});

/**
 * methods for adding dates to text area
 */
function appendDisplayEventDate(){
	var val = j("#displayEventDate").val();
	if (val != '') {
		j(".displayDateRow").show();
		if (j("textarea.displayDateRow").val() == '') {
			j("textarea.displayDateRow").val(val);
		} else {
			j("textarea.displayDateRow").val(j("textarea.displayDateRow").val()+","+val);
		}
		j("#displayEventDate").attr("value", '');
	}
}

function appendHcpEventDate(){
	var val = j("#hcpEventDate").val();
	if (val != '') {
		j(".hcpDateRow").show();
		if (j("textarea.hcpDateRow").val() == '') {
			j("textarea.hcpDateRow").val(val);
		} else {
			j("textarea.hcpDateRow").val(j("textarea.hcpDateRow").val()+","+val);
		}
		j("#hcpEventDate").attr("value", '');
	}
}

function appendAdvisoryEventDate(){
	var val = j("#advisoryEventDate").val();
	if (val != '') {
		j(".advisoryDateRow").show();
		if (j("textarea.advisoryDateRow").val() == '') {
			j("textarea.advisoryDateRow").val(val);
		} else {
			j("textarea.advisoryDateRow").val(j("textarea.advisoryDateRow").val()+","+val);
		}
		j("#advisoryEventDate").attr("value", '');
	}
}
function appendServiceDate(){
	var val = j("#serviceDates").val();
	if (val != '') {
		j(".serviceDateRow").show();
		if (j("textarea.serviceDateRow").val() == '') {
			j("textarea.serviceDateRow").val(val);
		} else {
			j("textarea.serviceDateRow").val(j("textarea.serviceDateRow").val()+","+val);
		}
		j("#serviceDates").attr("value", '');
	}
}
function appendCSEventDate(){
	var val = j("#csEventDate").val();
	if (val != '') {
		j(".csDateRow").show();
		if (j("textarea.csDateRow").val() == '') {
			j("textarea.csDateRow").val(val);
		} else {
			j("textarea.csDateRow").val(j("textarea.csDateRow").val()+","+val);
		}
		j("#csEventDate").attr("value", '');
	}
}

function limitTextAreaChars(tarea, maxLen)
{
    var textVal = tarea.value;
    if (textVal.length > 0)
    {
        textVal = textVal.substr(0, maxLen);
    }
    tarea.value = textVal;
}

/**
 * Methods Belonging to Requestor Information Block
 */

function chkShowHideCreatedBy(chkBox)
{

	if (chkBox.checked)
	{
	
		j("#createdDiv").show();
		j("#reqInfo\\.requestorName").removeAttr('readonly');
	}
	else
	{
		j("#reqInfo\\.requestorName").attr('readonly', 'readonly');
	
		j("#createdDiv").hide();
	}
}

function appendWbsText(){
	var val = j("#wbsElementText").val();
	if (val != '') {
		j(".costcenterrow").hide();
		j(".wbsrow").show();
		j("textarea.costcenterrow").attr("value", '');
		j("#costCenterText").attr("value", '');
		if (j("textarea.wbsrow").val() == '') {
			j("textarea.wbsrow").val(val);
		} else {
			j("textarea.wbsrow").val(j("textarea.wbsrow").val()+ ","+val);
		}
		j("#wbsElementText").attr("value", '');
	}
	var wbsrowData = j("textarea.wbsrow").val();
	if(wbsrowData !=''){
	costOrWbsDataValidation("wbselement",wbsrowData);
	}
}

function appendCostText(){
	var val = j("#costCenterText").val();
	if (val != '') {
		j(".wbsrow").hide();
		j(".costcenterrow").show();
		j("textarea.wbsrow").attr("value", '');
		j("#wbsElementText").attr("value", '');
		if (j("textarea.costcenterrow").val() == '') {
			j("textarea.costcenterrow").val(val);
		} else {
			j("textarea.costcenterrow").val(j("textarea.costcenterrow").val()+","+val);
		}
		j("#costCenterText").attr("value", '');
	}
	var costcenterData = j("textarea.costcenterrow").val();
	if(costcenterData !=''){
	costOrWbsDataValidation("costInfo",costcenterData);
	}
}

function appendCharitableCostText(){
	var val = j("#costCenterText").val();
	if (val != '') {
		j(".costcenterrow").show();
		if (j("textarea.costcenterrow").val() == '') {
			j("textarea.costcenterrow").val(val);
		} else {
			j("textarea.costcenterrow").val(j("textarea.costcenterrow").val()+","+val);
		}
		j("#costCenterText").attr("value", '');
	}
	var costcenterData = j("textarea.costcenterrow").val();
	if(costcenterData !=''){
	costOrWbsDataValidation("costInfo",costcenterData);
	}
}



function costOrWbsDataValidation(dataType,dataValue){
	 var costOrWbsurl = j("#costOrWbs").val();
	j.getJSON(costOrWbsurl + '&dataValue='+encodeURIComponent(dataValue)+ '&dataType='+dataType, function(data) {
		if(dataType == "costInfo"){
		j("#costCenterErrorList").val(data.costOrWbsErrorList);
		}
		if(dataType == "wbselement"){
			j("#wbsElementErrorList").val(data.costOrWbsErrorList);
		}
	});
	
}

function changeSettings(name) {
	if (name == "cost") {
		j(".wbsrow").hide();
		j("textarea.wbsrow").attr("value", '');
		j("#wbsElementText").attr("value", '');
		j("#reqInfo\\.wbsElement").removeClass("required");
		j("#reqInfo\\.costCenter").addClass("required");
		j("#wbsElementText").attr('readonly','readonly');
		j("#costCenterText").removeAttr('readonly');
	} else {
		j(".costcenterrow").hide();
		j("textarea.costcenterrow").attr("value", '');
		j("#costCenterText").attr("value", '');
		j("#reqInfo\\.costCenter").removeClass("required");
		j("#reqInfo\\.wbsElement").addClass("required");
		j("#costCenterText").attr('readonly','readonly');
		j("#wbsElementText").removeAttr('readonly');
	}
	j(".invalidFieldDesc").remove();
	j("label").removeClass("validationError");
	j("#costCenterErrorList").val('');
	j("#wbsElementErrorList").val('');
}

/**
 * Methods Belonging to Product Block
 */

function otherProductMaterial(value){
	if (value) 
	{
		j("#productInfo\\.otherMaterial").removeAttr('disabled');
		j("#productInfo\\.otherMaterial").addClass('reqSave');
	} else {
		j("#productInfo\\.otherMaterial").attr('disabled','disabled');
		j("#productInfo\\.otherMaterial").removeClass('reqSave');
		var otherProd = j("#productInfo\\.products8").val();
		if (isNotEmpty(otherProd)) {
			j("#productInfo\\.products8").attr("value", '');
		}
		j("#productInfo\\.otherMaterial").attr("value", '');
	}
}

/**
 * Methods Belonging to Corporate Support Block
 */

function otherTherapeuticArea(value){
    if (value) 
    {
                    j("#corporateSupport\\.otherTherapeutic").removeAttr('disabled');
                    j("#corporateSupport\\.otherTherapeutic").addClass('reqSave');
    } else {
                    j("#corporateSupport\\.otherTherapeutic").attr('disabled','disabled');
                    j("#corporateSupport\\.otherTherapeutic").removeClass('reqSave');
                    var otherTA = j("#corporateSupport\\.therapeuticArea7").val();
            		if (isNotEmpty(otherTA)) {
            			j("#corporateSupport\\.therapeuticArea7").attr("value", '');
            		}
                    j("#corporateSupport\\.otherTherapeutic").attr("value", '');
    }
}

/**
 * Methods Belonging to Display Exhibit Block
 */

function otherTherapeuticAreaForDispExhibit(value){
    if (value) 
    {
                    j("#dispExhibitInfo\\.otherTherapeutic").removeAttr('disabled');
                    j("#dispExhibitInfo\\.otherTherapeutic").addClass('reqSave');
    } else {
                    j("#dispExhibitInfo\\.otherTherapeutic").attr('disabled','disabled');
                    j("#dispExhibitInfo\\.otherTherapeutic").removeClass('reqSave');
                    var otherTA = j("#dispExhibitInfo\\.therapeuticArea7").val();
            		if (isNotEmpty(otherTA)) {
            			j("#dispExhibitInfo\\.therapeuticArea7").attr("value", '');
            		}
                    j("#dispExhibitInfo\\.otherTherapeutic").attr("value", '');
    }
}
/**
 * Methods Belonging to Product Information Block
 */

function otherTherapeuticAreaForProdInfo(value){
    if (value) 
    {
                    j("#productInfo\\.otherTherapeutic").removeAttr('disabled');
                    j("#productInfo\\.otherTherapeutic").addClass('reqSave');
    } else {
                    j("#productInfo\\.otherTherapeutic").attr('disabled','disabled');
                    j("#productInfo\\.otherTherapeutic").removeClass('reqSave');
                    var otherTA = j("#productInfo\\.therapeuticArea7").val();
            		if (isNotEmpty(otherTA)) {
            			j("#productInfo\\.therapeuticArea7").attr("value", '');
            		}
                    j("#productInfo\\.otherTherapeutic").attr("value", '');
    }
}

/**
 * Methods Belonging to Dissplay Exhibit Block
 */
// calculation of display fee amount based on check amount in check request information block
function displayFeeAmount(){
	var checkAmount = j("#checkReqInfo\\.totalCheckAmt").val();
	j("#dispExhibitInfo\\.eventFee").val(checkAmount);
}
function onradioCheck(check){
	if (check) {
		j(".checkboxclickradio").addClass("fileshow");
		j("input[type=file]",j(".checkboxclickradio")).addClass("reqmulti");
	} else {
		j(".checkboxclickradio").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("#MultiFile2_wrap_list").text("");
	}
}

function otherMaterial(value){
	if (value) 
	{
		j("#dispExhibitInfo\\.otherMaterial").removeAttr('disabled');
		j("#dispExhibitInfo\\.otherMaterial").addClass('reqSave');
		
	} else {
		j("#dispExhibitInfo\\.otherMaterial").attr('disabled','disabled');
		j("#dispExhibitInfo\\.otherMaterial").removeClass('reqSave');
		var val = j("#dispExhibitInfo\\.otherMaterial").val();
		var otherProd = j("#dispExhibitInfo\\.eventDispMaterials8").val();
		if (isNotEmpty(otherProd)) {
			j("#dispExhibitInfo\\.eventDispMaterials8").attr("value", '');
		}
		j("#dispExhibitInfo\\.otherMaterial").attr("value", '');
	}
	appendAgreeProductList();
}

/**
 * Methods Belonging to Corporate Block
 */
function onradioCorporateCheck(check){
	if (check) {
		j(".checkboxclickradio").addClass("fileshow");
		j("input[type=file]",j(".checkboxclickradio")).addClass("reqmulti");
	} else {
		j(".checkboxclickradio").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("#MultiFile3_wrap_list").text("");
	}
}

/**
 * Methods Belonging to Service Agreement Block
 */
function validateText1(check){
	if (check){
		j("#serviceAgreement\\.uniqueExperienceDesc").removeAttr('readonly');
		j("#serviceAgreement\\.uniqueExperienceDesc").addClass("required");
	} else {
		j("#serviceAgreement\\.uniqueExperienceDesc").attr('readonly','readonly');
		j("#serviceAgreement\\.uniqueExperienceDesc").removeClass("required");
		j("#serviceAgreement\\.uniqueExperienceDesc").attr("value", '');
	}
}

function validateText2(check){
	if (check){
		j("#serviceAgreement\\.customerDemonstrateDesc").removeAttr('readonly');
		j("#serviceAgreement\\.customerDemonstrateDesc").addClass("required");
	} else {
		j("#serviceAgreement\\.customerDemonstrateDesc").attr('readonly','readonly');
		j("#serviceAgreement\\.customerDemonstrateDesc").removeClass("required");
		j("#serviceAgreement\\.customerDemonstrateDesc").attr("value", '');
	}
}

function editPGCReq()
{
    document.getElementById("editPGCForm").submit();
}

function validatePatientAdvocacyOrg(check) 
{
	if (check) 
	{
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").removeAttr("readonly");
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").addClass("required");
	} 
	else 
	{
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").attr("readonly", "readonly");
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").removeClass("required");
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").attr("value", '');
	}
}

function validateProfMedicalSociety(check)
{
	if (check)
	{
		j("#serviceAgreement\\.revOfMedicalSociety").removeAttr("readonly");
		j("#serviceAgreement\\.revOfMedicalSociety").addClass("required");
	} 
	else 
	{
		j("#serviceAgreement\\.revOfMedicalSociety").attr("readonly", "readonly");
		j("#serviceAgreement\\.revOfMedicalSociety").removeClass("required");
		j("#serviceAgreement\\.revOfMedicalSociety").attr("value", '');
	}
}

function validateCombination(value)
{
	if (value)
	{
		j("#hcpConsultantInfo\\.programCombination").removeAttr("readonly");
		j("#hcpConsultantInfo\\.programCombination").addClass("reqSave");
	}
	else 
	{
		j("#hcpConsultantInfo\\.programCombination").attr("readonly", "readonly");
		j("#hcpConsultantInfo\\.programCombination").removeClass("reqSave");
		j("#hcpConsultantInfo\\.programCombination").attr("value", '');
	}
}

function validateAdvisoryCombination()
{
	var checkVal = j("input:checkbox[name='advisoryBoardInfo.programFormat']").is(":checked");
	if (checkVal)
	{
		j("#advisoryBoardInfo\\.programFormatSpecification").removeAttr("readonly");
		j("#advisoryBoardInfo\\.programFormatSpecification").addClass("reqSave");
	}
	else 
	{
		j("#advisoryBoardInfo\\.programFormatSpecification").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.programFormatSpecification").removeClass("reqSave");
		j("#advisoryBoardInfo\\.programFormatSpecification").attr("value", '');
	}
}

function validateChairPerson()
{
	var checkVal = j("input:checkbox[name='advisoryBoardInfo.chairPerson']").is(":checked");
	if (checkVal)
	{
		j("#advisoryBoardInfo\\.chairPersonCount").removeAttr("readonly");
		j("#advisoryBoardInfo\\.chairPersonTitle").removeAttr("readonly");
		j("#advisoryBoardInfo\\.chairPersonCount").addClass("required");
		j("#advisoryBoardInfo\\.chairPersonTitle").addClass("required");
	}
	else 
	{
		j("#advisoryBoardInfo\\.chairPersonCount").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.chairPersonCount").removeClass("required");
		j("#advisoryBoardInfo\\.chairPersonCount").attr("value", '');
		j("#advisoryBoardInfo\\.chairPersonTitle").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.chairPersonTitle").removeClass("required");
		j("#advisoryBoardInfo\\.chairPersonTitle").attr("value", '');
	}
}

function validateModerator()
{
	var checkVal = j("input:checkbox[name='advisoryBoardInfo.moderator']").is(":checked");
	if (checkVal)
	{
		j("#advisoryBoardInfo\\.moderatorCount").removeAttr("readonly");
		j("#advisoryBoardInfo\\.moderatorTitle").removeAttr("readonly");
		j("#advisoryBoardInfo\\.moderatorCount").addClass("required");
		j("#advisoryBoardInfo\\.moderatorTitle").addClass("required");
	}
	else 
	{
		j("#advisoryBoardInfo\\.moderatorCount").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.moderatorCount").removeClass("required");
		j("#advisoryBoardInfo\\.moderatorCount").attr("value", '');
		j("#advisoryBoardInfo\\.moderatorTitle").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.moderatorTitle").removeClass("required");
		j("#advisoryBoardInfo\\.moderatorTitle").attr("value", '');
	}
}
function validateRequestorSubmRow(check)
{
	if (check) 
	{
		j("#requestorReferenceNumber").show();
		j("#requestorReason").hide();
	} 
	else 
	{
		j("#requestorReferenceNumber").hide();
		j("#requestorReason").show();
	}
}
function validateGeneralReqCustRow(check)
{
	if (check) 
	{
		j("#generalReqCustRow").show();
		j("#requestInfo\\.custInvolved").addClass("required");
	} 
	else 
	{
		j("#generalReqCustRow").hide();
		j("#requestInfo\\.custInvolved").removeClass("required");
		j("#requestInfo\\.custInvolved").val('');
	}
}
function validateGeneralReqQuesRow(check)
{
	if (check) 
	{
		j("#generalReqQuesRow").show();
		j("#requestInfo\\.purposeInfo").addClass("required");
	} 
	else 
	{
		j("#generalReqQuesRow").hide();
		j("#requestInfo\\.purposeInfo").removeClass("required");
		j("#requestInfo\\.purposeInfo").val('');
	}
}
function validateHcpDateRow(check)
{
	if (check) 
	{
		j("#hcpServiceDateRow").show();
		j("textarea.hcpDateRow").addClass("required");
	} 
	else 
	{
		j("#hcpServiceDateRow").hide();
		j("textarea.hcpDateRow").attr("value", '');
		j("textarea.hcpDateRow").removeClass("required");
		j(".hcpDateRow").hide();
	}
}
function validateServiceDateRow(check)
{
	if (check) 
	{
		j("#serviceDateRowDiv").show();
		j("textarea.serviceDateRow").addClass("required");
	} 
	else 
	{
		j("#serviceDateRowDiv").hide();
		j("textarea.serviceDateRow").attr("value", '');
		j("textarea.serviceDateRow").removeClass("required");
		j(".serviceDateRow").hide();
	}
}

function validateAttendees1(checked){
	if (checked){
		j("#advisoryBoardInfo\\.mdsAttendeesCount").removeAttr('readonly');
		j("#advisoryBoardInfo\\.mdsAttendeesCount").addClass("required");
	} else {
		j("#advisoryBoardInfo\\.mdsAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.mdsAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.mdsAttendeesCount").val('');
		attendeeTotal();
	}
}

function validateAttendees2(checked){
	if (checked){
		j("#advisoryBoardInfo\\.paAttendeesCount").removeAttr('readonly');
		j("#advisoryBoardInfo\\.paAttendeesCount").addClass("required");
	} else {
		j("#advisoryBoardInfo\\.paAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.paAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.paAttendeesCount").val('');
		attendeeTotal();
	}
}

function validateAttendees3(checked){
	if (checked){
		j("#advisoryBoardInfo\\.nursesAttendeesCount").removeAttr('readonly');
		j("#advisoryBoardInfo\\.nursesAttendeesCount").addClass("required");
	} else {
		j("#advisoryBoardInfo\\.nursesAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.nursesAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.nursesAttendeesCount").val('');
		attendeeTotal();
	}
}

function validateAttendees4(checked){
	if (checked){
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").removeAttr('readonly');
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").addClass("required");
	} else {
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").val('');
		attendeeTotal();
	}
}

function validateAttendees5(checked){
	if (checked){
		j("#advisoryBoardInfo\\.otherAttendeesCount").removeAttr('readonly');
		j("#advisoryBoardInfo\\.otherAttendeesCount").addClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesName").removeAttr('readonly');
		j("#advisoryBoardInfo\\.otherAttendeesName").addClass("required");
	} else {
		j("#advisoryBoardInfo\\.otherAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesCount").val('');
		j("#advisoryBoardInfo\\.otherAttendeesName").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesName").removeClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesName").val('');
		attendeeTotal();
		
	}
}

function validateManager(checked){
	if (checked) {
		j("#reqInfo\\.managerName").addClass("required");
		j("#reqInfo\\.managerEmail").addClass("required");
	} else {
		j("#reqInfo\\.managerName").removeClass("required");
		j("#reqInfo\\.managerEmail").removeClass("required");
	}
}

function validateVP(checked){
	if (checked) {
		j("#reqInfo\\.vpName").addClass("required");
		j("#reqInfo\\.vpEmail").addClass("required");
	} else {
		j("#reqInfo\\.vpName").removeClass("required");
		j("#reqInfo\\.vpEmail").removeClass("required");
	}
}

function  calculateEduTotal(){
	var itemRetailVal = j("#eduItemsInfo\\.itemRetailValue").val();
	var numOfItem = j("#eduItemsInfo\\.numOfItems").val();
	if (isNumeric(itemRetailVal) && isNumeric(numOfItem)) {
		if (itemRetailVal > 100) {
			j("#eduItemsInfo\\.eduItemDescription").val('');
			return false;
		} else {
			j("#eduItemsInfo\\.eduItemDescription").val(numOfItem * itemRetailVal);
			return true;
		}
	} else {
		j("#eduItemsInfo\\.eduItemDescription").val('');
	}
}

function attendeeTotal()
{
	var paAttendeesCount = j("#advisoryBoardInfo\\.paAttendeesCount").val();
    var mdsAttendeesCount = j("#advisoryBoardInfo\\.mdsAttendeesCount").val();
	var nursesAttendeesCount = j("#advisoryBoardInfo\\.nursesAttendeesCount").val();
	var pharmaAttendeesCount = j("#advisoryBoardInfo\\.pharmaAttendeesCount").val();
	var otherAttendeesCount = j("#advisoryBoardInfo\\.otherAttendeesCount").val();
	
	var attendeeTotal=Total(paAttendeesCount, mdsAttendeesCount, nursesAttendeesCount, pharmaAttendeesCount, otherAttendeesCount);
	j("#advisoryBoardInfo\\.totalAttendees").val(attendeeTotal);
}

function Total(paAttendeesCount, mdsAttendeesCount, nursesAttendeesCount, pharmaAttendeesCount, otherAttendeesCount) 
{
    var sum = 0;
    for (var i = 0, j = arguments.length; i < j; i++) {
    	if (isNumeric(arguments[i])) {
    		sum += parseFloat(arguments[i]);
        }
    }
   return sum;
}

function validateProductAndTherapeuticArea(checked, selectedField){
	if (selectedField == "Product") {
		j("input:checkbox[name='productInfo.therapeuticArea']").each(function(){
			j(this).attr('checked', false); 				
		});
		j("#productInfo\\.otherTherapeutic").attr('value','');
		j("#productInfo\\.otherTherapeutic").removeClass('reqSave');
	} else {
		j("input:checkbox[name='productInfo.products']").each(function(){
			j(this).attr('checked', false); 				
		});	
		j("#productInfo\\.otherMaterial").attr('value','');
		j("#productInfo\\.otherMaterial").removeClass('reqSave');
	}	
}

function otherProduct(){
	var otherProductMaterial = j("#dispExhibitInfo\\.otherMaterial").val();
	j("#dispExhibitInfo\\.eventDispMaterials8").attr("value", otherProductMaterial);
	appendAgreeProductList();
}

function otherProductValue(){
	var otherProduct = j("#productInfo\\.otherMaterial").val();
	j("#productInfo\\.products8").attr("value", otherProduct);
}

function otherTherapeutic(){
    var otherTherapeutic = jQuery("#corporateSupport\\.otherTherapeutic").val();
    jQuery("#corporateSupport\\.therapeuticArea7").attr("value", otherTherapeutic);
}

function otherTherapeuticForDispExhibit(){
    var otherTherapeutic = jQuery("#dispExhibitInfo\\.otherTherapeutic").val();
    jQuery("#dispExhibitInfo\\.therapeuticArea7").attr("value", otherTherapeutic);
}

function otherTherapeuticForProdInfo(){
    var otherTherapeutic = jQuery("#productInfo\\.otherTherapeutic").val();
    jQuery("#productInfo\\.therapeuticArea7").attr("value", otherTherapeutic);
}

function documentURL(documentId, elementId, url, fileName){
	var docURL = url+"&documentId="+documentId+"&fileName="+fileName;
	document.getElementById(elementId).setAttribute("href",docURL);
}

function deleteURL(documentId, elementId, url){
	var deleteFile = confirm("Are you sure you want to delete this?")
	if (deleteFile){
		var deleteURL = url+"&documentId="+documentId;
		j.ajax({
			  type: "POST",  
			  url: deleteURL,
			  form: {
	       id: 'appForm'
	   	}
		});	
		var row = document.getElementById(documentId);
		row.parentNode.removeChild(row); 
	}
}

function appendAgreeProductList(){
	var agreeProductList = "";
	j("input:checkbox[name='dispExhibitInfo.eventDispMaterials']").each(function(){
		if (this.checked && this.value != "") {
			if (agreeProductList == "") {
				agreeProductList = this.value;
			} else {
				agreeProductList = "Multi-Product";
			}
		}
	});
	if (agreeProductList == "") {
		agreeProductList = "None";
	}
	j("#agreeProductList").html(agreeProductList);
	j("#checkReqInfo\\.product").val(agreeProductList);
}

function chairPersonTotalHrs(){
    var chairPersonPreparationHrs = j("#advisoryBoardInfo\\.chairPersonPreparationHrs").val();
    var chairPersonParticipateHrs = j("#advisoryBoardInfo\\.chairPersonParticipateHrs").val();
    var chairPersonPostWorkHrs = j("#advisoryBoardInfo\\.chairPersonPostWorkHrs").val();
    
    if (!isEmpty(chairPersonPreparationHrs) || !isEmpty(chairPersonParticipateHrs) || !isEmpty(chairPersonPostWorkHrs))
    {
    	if (isNumeric(chairPersonPreparationHrs) && isNumeric(chairPersonParticipateHrs) && isNumeric(chairPersonPostWorkHrs))
 	    {
    		 var chairPersonTotalHrs = parseFloat(chairPersonPreparationHrs) + parseFloat(chairPersonParticipateHrs) + parseFloat(chairPersonPostWorkHrs);
    		 j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonTotalHrs);
 	    } else if(isNumeric(chairPersonPreparationHrs) && isNumeric(chairPersonParticipateHrs)){
 	    	var chairPersonTotalHrs = parseFloat(chairPersonPreparationHrs) + parseFloat(chairPersonParticipateHrs);
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonTotalHrs);
 	    } else if(isNumeric(chairPersonParticipateHrs) && isNumeric(chairPersonPostWorkHrs)){
 	    	var chairPersonTotalHrs = parseFloat(chairPersonParticipateHrs) + parseFloat(chairPersonPostWorkHrs);
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonTotalHrs);
 	    } else if(isNumeric(chairPersonPreparationHrs) && isNumeric(chairPersonPostWorkHrs)){
 	    	var chairPersonTotalHrs = parseFloat(chairPersonPreparationHrs) + parseFloat(chairPersonPostWorkHrs);
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonTotalHrs);
 	    } else if(isNumeric(chairPersonPreparationHrs)){
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonPreparationHrs);
 	    } else if(isNumeric(chairPersonParticipateHrs)){
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonParticipateHrs);
 	    } else if(isNumeric(chairPersonPostWorkHrs)){
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val(chairPersonPostWorkHrs);
 	    }  else {
 	    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val("");
 	    }
    } else {
    	j("#advisoryBoardInfo\\.chairPersonTotalHrs").val("");
    }
}

function moderatorTotalHrs(){
	var moderatorPreparationHrs = j("#advisoryBoardInfo\\.moderatorPreparationHrs").val();
	var moderatorParticipateHrs = j("#advisoryBoardInfo\\.moderatorParticipateHrs").val();
	var moderatorPostWorkHrs = j("#advisoryBoardInfo\\.moderatorPostWorkHrs").val();
	
    if (!isEmpty(moderatorPreparationHrs) || !isEmpty(moderatorParticipateHrs) || !isEmpty(moderatorPostWorkHrs))
    {
    	if (isNumeric(moderatorPreparationHrs) && isNumeric(moderatorParticipateHrs)  && isNumeric(moderatorPostWorkHrs))
 	    {
    		 var moderatorTotalHrs = parseFloat(moderatorPreparationHrs) + parseFloat(moderatorParticipateHrs) + parseFloat(moderatorPostWorkHrs);
    		 j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorTotalHrs);
 	    } else if(isNumeric(moderatorPreparationHrs) && isNumeric(moderatorParticipateHrs)){
 	    	var moderatorTotalHrs = parseFloat(moderatorPreparationHrs) + parseFloat(moderatorParticipateHrs);
 	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorTotalHrs);
 	    } else if(isNumeric(moderatorPreparationHrs) && isNumeric(moderatorPostWorkHrs)){
 	    	var moderatorTotalHrs = parseFloat(moderatorPreparationHrs) + parseFloat(moderatorPostWorkHrs);
 	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorTotalHrs);
 	    } else if(isNumeric(moderatorParticipateHrs) && isNumeric(moderatorPostWorkHrs)){
 	    	var moderatorTotalHrs = parseFloat(moderatorParticipateHrs) + parseFloat(moderatorPostWorkHrs);
 	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorTotalHrs);
 	    } else if(isNumeric(moderatorPreparationHrs)){
	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorPreparationHrs);
	    } else if(isNumeric(moderatorParticipateHrs)){
	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorParticipateHrs);
 	    } else if(isNumeric(moderatorPostWorkHrs)){
	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val(moderatorPostWorkHrs);
 	    } else {
 	    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val("");
 	    }
    } else {
    	j("#advisoryBoardInfo\\.moderatorTotalHrs").val("");
    }
}

function attendeesTotalHrs(){
	var attendeesPreparationHrs = j("#advisoryBoardInfo\\.attendeesPreparationHrs").val();
	var attendeesParticipateHrs = j("#advisoryBoardInfo\\.attendeesParticipateHrs").val();
	var attendeesPostWorkHrs = j("#advisoryBoardInfo\\.attendeesPostWorkHrs").val();
	
    if (!isEmpty(attendeesPreparationHrs) || !isEmpty(attendeesParticipateHrs)|| !isEmpty(attendeesPostWorkHrs))
    {
    	if (isNumeric(attendeesPreparationHrs) && isNumeric(attendeesParticipateHrs) && isNumeric(attendeesPostWorkHrs))
 	    {
    		 var attendeesTotalHrs = parseFloat(attendeesPreparationHrs) + parseFloat(attendeesParticipateHrs) + parseFloat(attendeesPostWorkHrs);
    		 j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesTotalHrs);
 	    } else if (isNumeric(attendeesPreparationHrs) && isNumeric(attendeesParticipateHrs)){
	   		 var attendeesTotalHrs = parseFloat(attendeesPreparationHrs) + parseFloat(attendeesParticipateHrs);
	   		 j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesTotalHrs);
	    } else if (isNumeric(attendeesPreparationHrs) && isNumeric(attendeesPostWorkHrs)){
	   		 var attendeesTotalHrs = parseFloat(attendeesPreparationHrs) + parseFloat(attendeesPostWorkHrs);
	   		 j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesTotalHrs);
	    } else if (isNumeric(attendeesParticipateHrs) && isNumeric(attendeesPostWorkHrs)){
	   		 var attendeesTotalHrs = parseFloat(attendeesParticipateHrs) + parseFloat(attendeesPostWorkHrs);
	   		 j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesTotalHrs);
	    } else if(isNumeric(attendeesPreparationHrs)){
	    	j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesPreparationHrs);
	    } else if(isNumeric(attendeesParticipateHrs)){
	    	j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesParticipateHrs);
 	    } else if(isNumeric(attendeesPostWorkHrs)){
	    	j("#advisoryBoardInfo\\.attendeesTotalHrs").val(attendeesPostWorkHrs);
 	    } else {
 	    	j("#advisoryBoardInfo\\.attendeesTotalHrs").val("");
 	    }
    } else {
    	j("#advisoryBoardInfo\\.attendeesTotalHrs").val("");
    }
}

function aggregateCode(check){
	if (check == 'Sponsorship') {
		
		j("#corpSubTypeId1").css('display','table-row');
		
		j("#corpSubTypeId2").css('display','none');
	}else {
		j("#corpSubTypeId2").css('display','table-row');
		
		j("#corpSubTypeId1").css('display','none');
			
	}
}