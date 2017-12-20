/**
 * Author: Vijayan Chendrayan
 */

var j = jQuery.noConflict();

/**
 * This method belonging to clearing the inputs for the whole form.
 */	

function formClearButtonClicked()
{
	var checkForClick = confirm('Are you sure to clear the form data');
	if (checkForClick) {
		var requestorName = j("#reqInfo\\.requestorName").val();
		var deptTerritory = j("#reqInfo\\.deptTerritory").val();
		var email = j("#reqInfo\\.email").val();
		var managerName = j("#reqInfo\\.managerName").val();
		var managerEmail = j("#reqInfo\\.managerEmail").val();
		var dateCompleted = j("#reqInfo\\.dateCompleted").val();
		j("#corporateSupport\\.subType1").attr('checked', false); 
		j("#corporateSupport\\.subType2").attr('checked', false);
        j("#corpSubTypeId1").css('display','none');
		j("#corpSubTypeId2").css('display','none');
		
	    var formData = j(".group-list-content");
	    clearInputs(formData);
	    setDefaultSetup();
	    
	    j("#reqInfo\\.requestorName").val(requestorName);
	    j("#reqInfo\\.deptTerritory").val(deptTerritory);
	    j("#reqInfo\\.email").val(email);
	    j("#reqInfo\\.managerName").val(managerName);
	    j("#reqInfo\\.managerEmail").val(managerEmail);
	    j("#reqInfo\\.dateCompleted").val(dateCompleted);
	    
		
	}
}

function setDefaultSetup() {
	j(".MultiFile-label").remove();
    j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
    j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
    j("#reqInfo\\.wbsElement").removeClass("required");
	j("#reqInfo\\.costCenter").removeClass("required");
	j("#productInfo\\.otherMaterial").removeClass('required-product');
	j("#dispExhibitInfo\\.otherMaterial").removeClass('reqSave');
	j("#corporateSupport\\.otherTherapeutic").removeClass('reqSave');
	j("#serviceAgreement\\.uniqueExperienceDesc").removeClass("required");
	j("#serviceAgreement\\.customerDemonstrateDesc").removeClass("required");
	j(".displayDateRow").hide();
	j(".hcpDateRow").hide();
	j(".advisoryDateRow").hide();
	j(".csDateRow").hide();
	j(".wbsrow").hide();
	j(".costcenterrow").hide();
	j("#wbsElementText").attr('readonly','readonly');
	j("#costCenterText").attr('readonly','readonly');
	j("#productInfo\\.otherMaterial").attr('disabled','disabled');
    j("#dispExhibitInfo\\.otherMaterial").attr('disabled','disabled');
    j("#corporateSupport\\.otherTherapeutic").attr('disabled','disabled');
    j(".invalidFieldDesc").remove();
    j("label").removeClass("validationError");
    j("tr").removeClass("fileshow");
	j("#advisoryBoardInfo\\.mdsAttendeesCount").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.mdsAttendeesCount").removeClass("required");
	j("#advisoryBoardInfo\\.paAttendeesCount").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.paAttendeesCount").removeClass("required");
	j("#advisoryBoardInfo\\.nursesAttendeesCount").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.nursesAttendeesCount").removeClass("required");
	j("#advisoryBoardInfo\\.pharmaAttendeesCount").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.pharmaAttendeesCount").removeClass("required");
	j("#advisoryBoardInfo\\.otherAttendeesCount").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.otherAttendeesCount").removeClass("required");
	j("#advisoryBoardInfo\\.otherAttendeesName").attr('readonly','readonly');
	j("#advisoryBoardInfo\\.otherAttendeesName").removeClass("required");
	j("#advisoryBoardInfo\\.chairPersonCount").attr("readonly", "readonly");
	j("#advisoryBoardInfo\\.chairPersonCount").removeClass("required");
	j("#advisoryBoardInfo\\.chairPersonTitle").attr("readonly", "readonly");
	j("#advisoryBoardInfo\\.chairPersonTitle").removeClass("required");
	j("#advisoryBoardInfo\\.moderatorCount").attr("readonly", "readonly");
	j("#advisoryBoardInfo\\.moderatorCount").removeClass("required");
	j("#advisoryBoardInfo\\.moderatorTitle").attr("readonly", "readonly");
	j("#advisoryBoardInfo\\.moderatorTitle").removeClass("required");
	j("#reqInfo\\.managerName").removeClass("required");
	j("#reqInfo\\.managerEmail").removeClass("required");
	j("#reqInfo\\.vpName").removeClass("required");
	j("#reqInfo\\.vpEmail").removeClass("required");
	j(".creatbyIpRow").hide();
}

/**
 * Methods Belonging to Clear the Block contents
 */
function clearCheckBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Check Request Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		displayFeeAmount();
	}
}

function clearContractInfoBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Contract Info Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
	}
}

function clearCorporateSupportBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Corporate Support Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		j("#corporateSupport\\.subType1").attr('checked', false); 
		j("#corporateSupport\\.subType2").attr('checked', false);
        j("#corpSubTypeId1").css('display','none');
		j("#corpSubTypeId2").css('display','none');
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j(".csDateRow").hide();
		j("tr").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
	}
	j("#corporateSupport\\.otherTherapeutic").removeClass('required');
	j("#corporateSupport\\.otherTherapeutic").attr('disabled','disabled');
}

function clearHcpConsultantBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for HCP Consultant Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j(".hcpDateRow").hide();
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("tr").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
		j("#hcpConsultantInfo\\.programCombination").removeClass("reqSave");
		j("#hcpConsultantInfo\\.programCombination").attr("readonly","readonly");
	}
}

function clearPoMemberShipBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for PO Membership Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j("tr").removeClass("fileshow");
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
	}
}

function clearProductBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Poduct Info Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j("#productInfo\\.otherMaterial").removeClass('required-product');
		j("#productInfo\\.otherMaterial").removeClass('reqSave');
		j("#productInfo\\.otherMaterial").attr('disabled','disabled');
	}
}

function clearEducationalItemsBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Educational Items Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("tr").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
	}
}

function clearServiceAgreeBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Service Agreement Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("#serviceAgreement\\.uniqueExperienceDesc").removeClass("required");
		j("#serviceAgreement\\.customerDemonstrateDesc").removeClass("required");
		j("tr").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
		j("#serviceAgreement\\.uniqueExperienceDesc").attr('readonly','readonly');
		j("#serviceAgreement\\.customerDemonstrateDesc").attr('readonly','readonly');
	}
}

function clearRequestorBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Requestor Block');
	if (checkForClick) {
		//var buttonBlk = j(clearButton).parents(".acc-content");
		//clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		//j("#reqInfo\\.wbsElement").removeClass("required");
		//j("#reqInfo\\.costCenter").removeClass("required");
		//j(".wbsrow").hide();
		//j(".costcenterrow").hide();
		//j("#wbsElementText").attr('readonly','readonly');
		//j("#costCenterText").attr('readonly','readonly');
		//j("#reqInfo\\.managerName").removeClass("required");
		//j("#reqInfo\\.managerEmail").removeClass("required");
		//j("#reqInfo\\.vpName").removeClass("required");
		//j("#reqInfo\\.vpEmail").removeClass("required");
		//j("#createdDiv").hide();
		//jQuery("#reqInfo\\.requestorName").removeAttr('readonly');
		
		///////////
		
		j("#createdByCheckBox").attr('checked', false); 
		j("#costCenterRadio").attr('checked', false); 
		j("#costCenterId").val('');
		j("#costCenterText").val('');
		j("#wbsElementRadio").attr('checked', false); 
		j("#wbsElementId").val('');
		j("#wbsElementText").val('');
		j("#wbsElementText").attr('readonly','readonly');
		j("#costCenterText").attr('readonly','readonly');
		j("textarea.wbsrow").val('');
		j("textarea.costcenterrow").val('');
		j(".wbsrow").hide();
		j(".costcenterrow").hide();
		
		
		j(".reqPhoneNumber").val('');
		j("#reqInfo\\.mApprovalReq1").attr('checked', false); 
		j(".vpApprovalReqCheck").attr('checked', false); 
		j("#reqInfo\\.vpName").val('');
		j("#reqInfo\\.vpEmail").val('');
		
		j("#reqInfo\\.requestorName").attr('readonly', 'readonly');
		j("#createdDiv").hide();
		j("#costCenterErrorList").val('');
		j("#wbsElementErrorList").val('');
		//j("#wbsElementText").attr('readonly','readonly');
		//j("#costCenterText").attr('readonly','readonly');
		
		//j("#reqInfo\\.requestorName").attr('readonly', 'readonly');
		//j("#createdDiv").hide();
	}
}

function clearDisplayExhibitBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Display Exhibit Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".MultiFile-label").remove();
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j("#dispExhibitInfo\\.otherMaterial").removeClass('required');
		j("#dispExhibitInfo\\.otherMaterial").attr('disabled','disabled');
		j(".displayDateRow").hide();
	    j("tr").removeClass("fileshow");
	    j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
	    displayFeeAmount();
	}
}

function clearAdvisoryBoardBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Advisory Board Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
		j(".MultiFile-label").remove();
		j("input[type=file]",j(".checkboxclickradio")).removeClass("reqmulti");
		j(".advisoryDateRow").hide();
		j("tr").removeClass("fileshow");
		j("input[type=file]",j(".checkboxclickValid")).removeClass("reqmulti");
		j("#advisoryBoardInfo\\.mdsAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.mdsAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.paAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.paAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.nursesAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.nursesAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesCount").removeClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesName").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesName").removeClass("required");
		j("#advisoryBoardInfo\\.chairPersonCount").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.chairPersonCount").removeClass("required");
		j("#advisoryBoardInfo\\.chairPersonTitle").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.chairPersonTitle").removeClass("required");
		j("#advisoryBoardInfo\\.moderatorCount").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.moderatorCount").removeClass("required");
		j("#advisoryBoardInfo\\.moderatorTitle").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.moderatorTitle").removeClass("required");
		j("#advisoryBoardInfo\\.programFormatSpecification").attr("readonly", "readonly");
		j("#advisoryBoardInfo\\.programFormatSpecification").removeClass("reqSave");
	}
}

function clearModificationBlock(clearButton){
	var checkForClick = confirm('Are you sure to clear the data for Modification Block');
	if (checkForClick) {
		var buttonBlk = j(clearButton).parents(".acc-content");
		clearInputs(buttonBlk);
		j(".invalidFieldDesc").remove();
		j("label").removeClass("validationError");
	}
}