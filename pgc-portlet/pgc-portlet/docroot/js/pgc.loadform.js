/**
 * Author: Vijayan Chendrayan
 */

var j = jQuery.noConflict();

j(document).ready(function()
{
	j("#hcpConsultantInfo\\.eventStartDate").attr('readonly', 'readonly');
	j("#dispExhibitInfo\\.eventStartDate").attr('readonly', 'readonly');
	j("#corporateSupport\\.eventStartDate").attr('readonly', 'readonly');
	j("#advisoryBoardInfo\\.eventStartDate").attr('readonly', 'readonly');
	j("#advisoryBoardInfo\\.totalAttendees").attr('readonly', 'readonly');
	j("#eduItemsInfo\\.eduItemDescription").attr('readonly', 'readonly');
	j("#advisoryBoardInfo\\.chairPersonTotalHrs").attr('readonly', 'readonly');
	j("#advisoryBoardInfo\\.moderatorTotalHrs").attr('readonly', 'readonly');
	j("#advisoryBoardInfo\\.attendeesTotalHrs").attr('readonly', 'readonly');
	
	j(".acc-content").hide();
    j(".acc-title:first").addClass("active").next().show();
	j(".acc-title").click(function() {
        j(this).toggleClass("active");
        j(this).next().toggle();
    });
   	
	j("#print").click(function(){
		j(".acc-content").show();
		window.print();
		return false;
	});
	if( (j("#reqInfo\\.requestorEmployeeId")!="")&& (j("#reqInfo\\.createdUserEmployeeId")!="")){
		
		 if (j("#reqInfo\\.requestorEmployeeId").val() != j("#reqInfo\\.createdUserEmployeeId").val()){
			 j("#createdByCheckBox").attr("checked", true);
		 } else {
			 j("#createdByCheckBox").attr("checked", false);
		 }
	}
	var checkVal = j("input:checkbox[name='createdByCheckBox']").is(":checked");
	if (checkVal){
		jQuery("#reqInfo\\.requestorName").removeAttr('readonly');
		j("#createdDiv").show();
	} else {
		jQuery("#reqInfo\\.requestorName").attr('readonly', 'readonly');
		j("#createdDiv").hide();
	}
	// contract specilist drop down for other in contract information 
	if(j("#contractInfo\\.contractSpecialist").val()=="Other"){
		j("#contractInfo\\.otherContract").addClass('reqSave');
		j("#contractShow").show();
	} else {
		j("#contractInfo\\.otherContract").removeClass('reqSave');
		j("#contractInfo\\.otherContract").attr("value", '');
		j("#contractShow").hide();
	}
	//  specilist drop down for other in advisory board
	if(j("#advisoryBoardInfo\\.contractSpecialistName").val()=="Other"){
		j("#advisoryBoardInfo\\.otherContract").addClass('reqSave');
		j("#advContractShow").show();
	} else {
		j("#advisoryBoardInfo\\.otherContract").removeClass('reqSave');
		j("#advisoryBoardInfo\\.otherContract").attr("value", '');
		j("#advContractShow").hide();
	}
	var wbsrow = j("textarea.wbsrow").val();
	var costcenter = j("textarea.costcenterrow").val();
	if (costcenter != '') 
	{
		j("#reqInfo\\.costCenter").addClass("required");
		j("#costCenterRadio").attr("checked", true);
		j(".wbsrow").hide();
		j("#wbsElementText").attr("readonly", "readonly");
		j("textarea.costcenterrow").val(j("textarea.costcenterrow").val());
	} 
	else if (wbsrow != '') 
	{
		j("#reqInfo\\.wbsElement").addClass("required");
		j("#wbsElementRadio").attr("checked", true);
		j(".costcenterrow").hide();
		j("#costCenterText").attr("readonly", "readonly");
		j("textarea.wbsrow").val(j("textarea.wbsrow").val());
	} 
	else 
	{
		j("#wbsElementText").attr("readonly","readonly");
		j("#costCenterText").attr("readonly","readonly");
	   	j(".wbsrow").hide();
	   	j(".costcenterrow").hide();
	}
	
	var otherMaterial = j("#dispExhibitInfo\\.otherMaterial").val();
	if (otherMaterial != '') 
	{
 		j("#dispExhibitInfo\\.otherMaterial").addClass("reqSave");
 		j("input:checkbox[name='dispExhibitInfo.eventDispMaterials']").each(function(){
 			if (this.value == '') {
 				j(this).attr("checked", true);
 				j(this).attr("value", otherMaterial);
 			}
 		});
	}
	else 
	{
		j("#dispExhibitInfo\\.otherMaterial").attr("value", '');
 		j("input:checkbox[name='dispExhibitInfo.eventDispMaterials']").each(function(){
 			if (j(this).attr("checked")){
 				jQuery("#dispExhibitInfo\\.otherMaterial").removeAttr('disabled');
 			}else{
 				jQuery("#dispExhibitInfo\\.otherMaterial").attr('disabled', 'disabled');
 			}
 		});
	}
	var otherProductMaterial = j("#productInfo\\.otherMaterial").val();
	if (otherProductMaterial != '') 
	{
		j("#productInfo\\.otherMaterial").addClass("required-product");
		j("input:checkbox[name='productInfo.products']").each(function(){
 			if (this.value == '') {
 				j(this).attr("checked", true);
 				j(this).attr("value", otherProductMaterial);
 			}
 		});
	} 
	else 
	{
		j("#productInfo\\.otherMaterial").attr("value", '');
		j("input:checkbox[name='productInfo.products']").each(function(){
 			if (j(this).attr("checked")){
 				jQuery("#productInfo\\.otherMaterial").removeAttr('disabled');
 			}else{
 				jQuery("#productInfo\\.otherMaterial").attr('disabled', 'disabled');
 			}
 		});
	}
	
	/* enable or disable other textbox based on checkbox click  for therapeutic area */
	var otherTherapeuticAreaVal = j("#productInfo\\.otherTherapeutic").val();
	if (otherTherapeuticAreaVal != '') 
	{
		j("#productInfo\\.otherTherapeutic").addClass("required-therapeutic");
		j("input:checkbox[name='productInfo.therapeuticArea']").each(function(){
 			if (this.value == '') {
 				j(this).attr("checked", true);
 				j(this).attr("value", otherTherapeuticAreaVal);
 			}
 		});
	} 
	else 
	{
		j("#productInfo\\.otherTherapeutic").attr("value", '');
		j("input:checkbox[name='productInfo.therapeuticArea']").each(function(){
 			if (j(this).attr("checked")){
 				jQuery("#productInfo\\.otherTherapeutic").removeAttr('disabled');
 			}else{
 				jQuery("#productInfo\\.otherTherapeutic").attr('disabled', 'disabled');
 			}
 		});
	}
	
	/* enable or disable other textbox based on checkbox click  for therapeutic area */
	var otherTherapeuticAreaVal = j("#corporateSupport\\.otherTherapeutic").val();
	if (otherTherapeuticAreaVal != '') 
	{
		j("#corporateSupport\\.otherTherapeutic").addClass("reqSave");
		j("input:checkbox[name='corporateSupport.therapeuticArea']").each(function(){
 			if (this.value == '') {
 				j(this).attr("checked", true);
 				j(this).attr("value", otherTherapeuticAreaVal);
 			}
 		});
	} 
	else 
	{
		j("#corporateSupport\\.otherTherapeutic").attr("value", '');
		j("input:checkbox[name='corporateSupport.therapeuticArea']").each(function(){
 			if (j(this).attr("checked")){
 				jQuery("#corporateSupport\\.otherTherapeutic").removeAttr('disabled');
 			}else{
 				jQuery("#corporateSupport\\.otherTherapeutic").attr('disabled', 'disabled');
 			}
 		});
	}
	
	var displayDateRow = j("textarea.displayDateRow").val();
	if (displayDateRow != '') 
	{
		j("textarea.displayDateRow").val(j("textarea.displayDateRow").val());
	} 
	else 
	{
		j(".displayDateRow").hide();
	}
	
	var hcpDateRow = j("textarea.hcpDateRow").val();
	if (hcpDateRow != '') 
	{
		j("textarea.hcpDateRow").addClass("required");
		j("textarea.hcpDateRow").val(j("textarea.hcpDateRow").val());
	} 
	else 
	{
		j(".hcpDateRow").hide();
		j("#hcpServiceDateRow").hide();
	}
	var serviceDateRow = j("textarea.serviceDateRow").val();
	if (serviceDateRow != '') 
	{
		j("textarea.serviceDateRow").addClass("required");
		j("textarea.serviceDateRow").val(j("textarea.serviceDateRow").val());
	} 
	else 
	{
		j(".serviceDateRow").hide();
		j("#serviceDateRowDiv").hide();
	}
	var advisoryDateRow = j("textarea.advisoryDateRow").val();
	if (advisoryDateRow != '') 
	{
		j("textarea.advisoryDateRow").val(j("textarea.advisoryDateRow").val());
	} 
	else
	{
		j(".advisoryDateRow").hide();
	}
	
	var csDateRow = j("textarea.csDateRow").val();
	if (csDateRow != '') 
	{
		j("textarea.csDateRow").val(j("textarea.csDateRow").val());
	} 
	else 
	{
		j(".csDateRow").hide();
	}
	var uniqueExperience = j("#serviceAgreement\\.uniqueExperienceDesc").val();
	if (uniqueExperience != '')
	{
		j("#serviceAgreement\\.uniqueExperienceDesc").addClass("required");
	} 
	else 
	{
		j("#serviceAgreement\\.uniqueExperienceDesc").attr("readonly","readonly");
	}
	var customerDemonstrate = j("#serviceAgreement\\.customerDemonstrateDesc").val();
	if (customerDemonstrate != '')
	{
		j("#serviceAgreement\\.customerDemonstrateDesc").addClass("required");
	}
	else 
	{
		j("#serviceAgreement\\.customerDemonstrateDesc").attr("readonly","readonly");
	}
	var patientAdvocacyOrg = j("#serviceAgreement\\.revOfPatientAdvocacyOrg").val();
	if (patientAdvocacyOrg == '' || patientAdvocacyOrg == '0.0')
	{
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").attr("readonly","readonly");
	} 
	else 
	{
		j("#serviceAgreement\\.revOfPatientAdvocacyOrg").addClass("required");
	}
	var profMedicalSociety = j("#serviceAgreement\\.revOfMedicalSociety").val();
	if (profMedicalSociety == '' || profMedicalSociety == '0.0')
	{
		j("#serviceAgreement\\.revOfMedicalSociety").attr("readonly","readonly");
	} 
	else 
	{
		j("#serviceAgreement\\.revOfMedicalSociety").addClass("required");
	}
	var programFormat = j("#hcpConsultantInfo\\.programCombination").val();
	if (programFormat != '')
	{
		j("#hcpConsultantInfo\\.programCombination").addClass("reqSave");
	} 
	else 
	{
		j("#hcpConsultantInfo\\.programCombination").attr("readonly","readonly");
	}
	var advisoryBoardTitle = j("#advisoryBoardInfo\\.programFormatSpecification").val();
	if (advisoryBoardTitle != '')
	{
		j("#advisoryBoardInfo\\.programFormatSpecification").addClass("reqSave");
	} 
	else 
	{
		j("#advisoryBoardInfo\\.programFormatSpecification").attr("readonly","readonly");
	}
	var chairPersonCount = j("#advisoryBoardInfo\\.chairPersonCount").val();
	var chairPersonTitle = j("#advisoryBoardInfo\\.chairPersonTitle").val();
	if (chairPersonCount != '' || chairPersonTitle != '')
	{
		j("#advisoryBoardInfo\\.chairPersonTitle").addClass("required");
		j("#advisoryBoardInfo\\.chairPersonCount").addClass("required");
	} 
	else 
	{
		j("#advisoryBoardInfo\\.chairPersonCount").attr("readonly","readonly");
		j("#advisoryBoardInfo\\.chairPersonTitle").attr("readonly","readonly");
	}
	var moderatorCount = j("#advisoryBoardInfo\\.moderatorCount").val();
	var moderatorTitle = j("#advisoryBoardInfo\\.moderatorTitle").val();
	if (moderatorCount != '' || moderatorTitle != '')
	{
		j("#advisoryBoardInfo\\.moderatorTitle").addClass("required");
		j("#advisoryBoardInfo\\.moderatorCount").addClass("required");
	} 
	else 
	{
		j("#advisoryBoardInfo\\.moderatorCount").attr("readonly","readonly");
		j("#advisoryBoardInfo\\.moderatorTitle").attr("readonly","readonly");
	}
	
    j(".checkboxclickValid input[type=checkbox]").click(function(){
		if (j(this).attr("checked"))
		{
			j(this).parents(".checkboxclickValid").addClass("fileshow");
			j("input[type=file]",j(j(this).parent().parent())).addClass("reqmulti");
		}
		else
		{
			j(this).parents(".checkboxclickValid").removeClass("fileshow");
			j("input[type=file]",j(j(this).parent().parent())).removeClass("reqmulti");
			var checkvalue = (this.value).substring(7);
			var divId = "#MultiFile" + checkvalue + "_wrap_list";
			j(divId).text("");
		}
	});
  
    j(".checkboxclickMulti input[type=checkbox]").click(function(){
		if (j(this).attr("checked"))
		{
			j(this).parents(".checkboxclickMulti").addClass("fileshow");
		}
		else
		{
			j(this).parents(".checkboxclickMulti").removeClass("fileshow");
		}
	});
       
    if (j("#advisoryBoardInfo\\.mdsAttendeesCount").val() != '') {
		j("#advisoryBoardInfo\\.mdsAttendeesCount").addClass("required");
		j("input:checkbox[name='attendees']").each(function(){
			if (this.value == 'mds') {
				j(this).attr("checked", true);
			}
		});
	} else {
		j("#advisoryBoardInfo\\.mdsAttendeesCount").attr('readonly','readonly');
	}
	if (j("#advisoryBoardInfo\\.paAttendeesCount").val() != '') {
		j("#advisoryBoardInfo\\.paAttendeesCount").addClass("required");
		j("input:checkbox[name='attendees']").each(function(){
			if(this.value == 'pas'){
				j(this).attr("checked", true);
			}
		});
			
	} else {
		j("#advisoryBoardInfo\\.paAttendeesCount").attr('readonly','readonly');
	}
	if (j("#advisoryBoardInfo\\.nursesAttendeesCount").val() != '') {
		j("#advisoryBoardInfo\\.nursesAttendeesCount").addClass("required");
		j("input:checkbox[name='attendees']").each(function(){
			if(this.value == 'nurses'){
				j(this).attr("checked", true);
			}
		});
			
	} else {
		j("#advisoryBoardInfo\\.nursesAttendeesCount").attr('readonly','readonly');
	}
	if (j("#advisoryBoardInfo\\.pharmaAttendeesCount").val() != '') {
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").addClass("required");
		j("input:checkbox[name='attendees']").each(function(){
			if(this.value == 'pharma'){
				j(this).attr("checked", true);
			}
		});
			
	} else {
		j("#advisoryBoardInfo\\.pharmaAttendeesCount").attr('readonly','readonly');
	}
	if (j("#advisoryBoardInfo\\.otherAttendeesCount").val() != '') {
		j("#advisoryBoardInfo\\.otherAttendeesCount").addClass("required");
		j("#advisoryBoardInfo\\.otherAttendeesName").addClass("required");
		j("input:checkbox[name='attendees']").each(function(){
			if(this.value == 'others'){
				j(this).attr("checked", true);
			}
		});
			
	} else {
		j("#advisoryBoardInfo\\.otherAttendeesCount").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesName").attr('readonly','readonly');
		j("#advisoryBoardInfo\\.otherAttendeesName").val('');
	}
	
	/* Hides text area on basis of selected value of radio button of General Request Form */
	if (j("#isCustInvolved").is(':checked') == true ){
		j("#generalReqCustRow").show();
	} else {
		j("#generalReqCustRow").hide();
	}
	
	if (j("#isHCPInfoProvided").is(':checked') == true ){
		j("#generalReqQuesRow").show();
	} else {
		j("#generalReqQuesRow").hide();
	}
	
	/* Hides label on basis of selected value of radio button of Requestor In formation */
	if (j("#isSubmIncludeAEP").is(':checked') == true ){
		j("#requestorReferenceNumber").show();
		j("#requestorReason").hide();
	} else {
		j("#requestorReferenceNumber").hide();
		j("#requestorReason").show();
	}
	
	/* hiding event date textarea and calling datepick */
    
  j("#displayEventDate").datepick({
    	pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
   
    	
    j("#hcpEventDate").datepick({
    	pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">',
        onSelect: function(dateText){appendHcpEventDate();}
	});

    j("#advisoryEventDate").datepick({
    	pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});

    j("#csEventDate").datepick({
    	pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
    
    j("#modInfo\\.modEffectiveDate").datepick({
    	pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
    
	/*j("#dispExhibitInfo\\.eventDates").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0,
        dateFormat: 'mm/dd/yyyy', 
        showTrigger: '<img src="/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#advisoryBoardInfo\\.programDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	*/
	j("#dispExhibitInfo\\.eventStartDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#hcpConsultantInfo\\.eventStartDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0,
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#hcpConsultantInfo\\.eventEndDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0,
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#corporateSupport\\.eventStartDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#advisoryBoardInfo\\.eventStartDate").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	j("#serviceDates").datepick({
		pickerClass: 'noPrevNext',
        minDate: 0, 
        dateFormat: 'mm/dd/yyyy',
        showTrigger: '<img src="/o/pgc-portlet/images/cal-icon.jpg" alt="Popup" class="trigger">'
	});
	
	appendAgreeProductList();
	
	j(".dispchecklist input[type=checkbox]").click(function(){
		appendAgreeProductList();
	});
	
	j(".textTip").mouseover(function(){
		var textValue = this.value;
		var finalText = "";
		var textLength = textValue.length;
	    if (textValue != "" && textLength > 17) {
	    	if (textLength > 50) {
		    	var size = Math.floor(textLength/50);
		    	var currentCount = 0;
				for(var i = 1; i <= size ; i++) {
					if(i == 1){
						finalText = textValue.substring(currentCount, Math.floor(currentCount + 50));
					} else {
						finalText = finalText + "<br/>" + textValue.substring(currentCount, Math.floor(currentCount + 50));
					}
					currentCount = Math.floor(currentCount + 50);
		   		}
				if (textLength > currentCount) {
					finalText = finalText + "<br/>" + textValue.substring(currentCount, textLength);
				}
	    	} else {
	    		finalText = textValue;
	    	}
	    	var textContent = "<span class='contentTip'>"+ finalText +"</span>";
			j(this).parent().prepend(textContent);
		}
	}).mouseout(function(){
		j(".contentTip").remove();
	}).click(function(){
		j(".contentTip").remove();
	});
	
	j(".phoneTip").mouseover(function(){
		var textValue = "Phone Numbers Formats:<br />xxxxxxxxxx <br /> xxx-xxx-xxxx <br /> xxx,xxx,xxxx <br />xxx xxx xxxx <br/>Note: Where x is number between 0 to 9.";
		var textContent = "<span class='contentHelp'>"+ textValue +"</span>";
		j(this).parent().prepend(textContent);
	}).mouseout(function(){
		j(".contentHelp").remove();
	});
	
	j(".autoPickListTip").mouseover(function(){
		var textValue = "Please start typing the first/last <br/>name and select appropriate name <br />from the suggested pick list";
		var textContent = "<span class='contentHelp'>"+ textValue +"</span>";
		j(this).parent().prepend(textContent);
	}).mouseout(function(){
		j(".contentHelp").remove();
	});
});