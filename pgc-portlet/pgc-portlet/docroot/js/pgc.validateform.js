/**
 * Author: Vijayan Chendrayan
 */

var j = jQuery.noConflict();

/**
 * Validation functions
 */
function isDefined(obj)
{
    return (typeof obj != 'undefined');
}

function isNotNull(obj)
{
    return isDefined(obj) && obj != null;
}

function isEmpty(str)
{
	str = trim(str);
    return str == '';
}

function isNotEmpty(str)
{
	str = trim(str);
    return str.length > 0;
}
function isDecimal(val) 
{
	return (parseFloat(val,10)==(val*1));
}   
function isNumeric(str)
{
	str = trim(str);
	if (str == 0) {
		return false;
	}
	var RE = /^[0-9]*[0-9]$/;
    return (RE.test(str));
}

function isAlpha(str)
{
	str = trim(str);
	var RE = /^[a-zA-Z\s#,:-]*$/;
	return (RE.test(str));
}

function isAlphaNumeric(str)
{
	str = trim(str);
	var RE = /^[a-zA-Z0-9\s#,:-]*$/;
	return (RE.test(str));
}

function isPhoneNumber(str)
{
	str = trim(str);
	var RE = /(^\(?([0-9]{3})+\)?[\s]{1}?([0-9]{3})+[\s]{1}?([0-9]{4})$)|(^\(?([0-9]{3})+\)?[-]{1}?([0-9]{3})+[-]{1}?([0-9]{4}))$|(^\(?([0-9]{3})+\)?[\,]{1}?([0-9]{3})+[\,]{1}?([0-9]{4})$)|((^[0-9]{10}?)$)/;
	return (RE.test(str));
}

function isSSNId(str)
{
	str = trim(str);
	var RE = /^\(?(\d{3})\)?[-]{1}?(\d{2})[-]{1}?(\d{4})$/;
	return (RE.test(str));
}

function isZipCode(str)
{
	str = trim(str);
	var RE = /^[0-9]{5}$/;
	return (RE.test(str));
}

function isDollarNum(str)
{
	str = trim(str);
	var RE=/^[0-9]*([\.][0-9]{1,2})?$/;
	return (RE.test(str));
}

function isEmailAddress(emailAddress){
	emailAddress = trim(emailAddress);
	var reg = /^(([a-zA-Z0-9]+)(\_?\-?))*([a-zA-Z0-9]+(\.?))*[a-zA-Z0-9]+\@dsi.com$/;
	return reg.test(emailAddress);
}

function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    } 
    
}

function requestInfoLimitText(limitField,limitNum,type){
	
	limitText(limitField, limitNum);
	costOrWbsDataValidation(type,limitField.value);
}
/**
 * This method belonging to common validation for all the blocks
 */	

function validateBlock(blockName, submit, formName)
{
	var blockId = "#" + blockName;
    var jBlock = j(blockId);
    var blkValid = true;
    // Validate all required
    var emptyRequiredFields = '';
   
    //Removing Validations Class
    j('.invalidFieldDesc').remove();
    j("label").removeClass("validationError");
    
    //Appending the values to the textarea for costcentre/wbselement
    if(formName != "CharitableDonation"){
    	appendWbsText();
        appendCostText();
    }else{
    	appendCharitableCostText();
    }
    
    
    if (submit) {
	    jBlock.find(".required").each(function()
	    {
	        var val = this.value;
	        if (this.type == 'radio')
	        {
	        	var radioVal = j("input:radio[name='"+this.name+"']").is(":checked");
	        	if (!radioVal) {
	        		jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        		j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please check the radio button.</div>');
	                blkValid = false;
	               
	        	}
	        } else if (this.type == 'checkbox')
	        {
	        	var checkboxVal = j("input:checkbox[name='"+this.name+"']").is(":checked");
	        	if (!checkboxVal) {
	        		jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        		j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please check the checkbox.</div>');
	                blkValid = false;
	        	}
	        } else
	        {
	        	if (isEmpty(val)) {
		        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
		        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should not be blank.</div>');
		            blkValid = false;
	        	}
	        }
	    });
	    
	    /*jBlock.find(".reqcostCenterText").each(function()
	    		
	        	{
		    var costCenterText = j("#costCenterText").val();
			var costcenterrow = j("#reqInfo\\.costCenter").val();
			var costCenterValue = j("#costCenterErrorList").val();
		    	if(costCenterText == "" && costcenterrow =="" && costCenterValue ==""){
		    		var divId = this.id;
					//console.info($("#"+divId).attr('vak'));
					var vak =$("#"+divId).attr('vak');
					jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
					j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should not be blank.</div>');
			        blkValid = false;
		        }
				if(costCenterValue !=""){
					var divId = this.id;
					//console.info($("#"+divId).attr('vak'));
					var vak =$("#"+divId).attr('vak');
					jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
					j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>entered costcenter values are incorrect '+costCenterValue+'.</div>');
			        blkValid = false;
				}
	        	});
	       */ 	
	    
	    if ((blockName == "ProdInfoBlk" || blockName == "DispExhibitBlk") && formName != "CharitableDonation"){
		    var product = false;
		    var therapeutic = false;
		    var productFieldName = '';
		    var therapeuticFieldName = '';
		    jBlock.find(".required-product").each(function()
		    {		
		    	if (this.type == 'checkbox')
		        {
		        	product = j("input:checkbox[name='"+this.name+"']").is(":checked");
		        	productFieldName = this.name;
		        }
		    });
		    jBlock.find(".required-therapeutic").each(function()
		    {
		    	if (this.type == 'checkbox')
		        {
		    		therapeutic = j("input:checkbox[name='"+this.name+"']").is(":checked");
		    		therapeuticFieldName = this.name;
		        }
		    	        
		    });
		    if ( !product && !therapeutic ) {
		    	jBlock.find("label[for='" + productFieldName + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + productFieldName + "']").parent()).append('<div class="invalidFieldDesc"><br/>Either Product or Therapeutic Area is mandatory.</div>');
	        	jBlock.find("label[for='" + therapeuticFieldName + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + therapeuticFieldName + "']").parent()).append('<div class="invalidFieldDesc"><br/>Either Product or Therapeutic Area is mandatory.</div>');
		    	blkValid = false;
		    }
	    }  
	    
	    if (blockName == "ProdInfoBlk" && formName == "CharitableDonation"){
		    var therapeutic = false;
		    var therapeuticFieldName = '';
		    jBlock.find(".required-therapeutic").each(function()
		    {
		    	if (this.type == 'checkbox')
		        {
		    		therapeutic = j("input:checkbox[name='"+this.name+"']").is(":checked");
		    		therapeuticFieldName = this.name;
		        }
		    	        
		    });
		    if (!therapeutic ) {
	        	jBlock.find("label[for='" + therapeuticFieldName + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + therapeuticFieldName + "']").parent()).append('<div class="invalidFieldDesc"><br/>Therapeutic Area is mandatory.</div>');
		    	blkValid = false;
		    }
	    }  
    }
    
    jBlock.find(".reqSave").each(function()
    {
        var val = this.value;
        if (isEmpty(val)) {
        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should not be blank.</div>');
            blkValid = false;
    	}
    });
    	  
  
    jBlock.find(".reqAlpha").each(function()
    {
        var val = this.value;
        if (isNotEmpty(val))
        {
        	if (!isAlpha(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should be alpha.</div>');
	            blkValid = false;
	        }
        }
    });
    
    jBlock.find(".reqPhoneNumber").each(function()
    {
        var val = this.value;
        if (isNotEmpty(val))
        {
        	if (!isPhoneNumber(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please enter valid phoneNumber.</div>');
	            blkValid = false;
	        }
        }
    });
    
    jBlock.find(".reqZipCode").each(function()
    {
        var val = this.value;
        if (isNotEmpty(val))
        {
        	if (!isZipCode(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should contain 5 digits.</div>');
	            blkValid = false;
	        }
        }
    });
    
    jBlock.find(".reqSSNId").each(function()
    {
        var val = this.value;
        if (isNotEmpty(val))
        {
        	if (!isSSNId(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please enter valid SSN ID.</div>');
	            blkValid = false;
	        }
        }
    });
    
    jBlock.find(".reqDollarNum").each(function()
    {
        var val = this.value;
        if (isNotEmpty(val))
        {
        	if (!isDecimal(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please enter only Numeric value.</div>');
	            blkValid = false;
	        }
        	if(isDecimal(val)) {
        	if (!isDollarNum(val))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please enter only two digits after dot(.)</div>');
	            blkValid = false;
	        }
        	}
        }
    });
    
    jBlock.find(".reqNumeric").each(function()
	{
	    var numeric = this.value;
	    if (numeric == 0) {
	    	numeric = '';
        }
	    if (isNotEmpty(numeric))
        {
	    	if (!isNumeric(numeric))
		    {
		    	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
		    	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should be numeric.</div>');
		        blkValid = false;
		    }
        }
	});
    
    jBlock.find(".reqAlphaNumeric").each(function()
	{
	    var alphaNumeric = this.value;
	    if (isNotEmpty(alphaNumeric))
        {
	    	if (!isAlphaNumeric(alphaNumeric))
		    {
		    	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
		    	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should be alphaNumeric.</div>');
		        blkValid = false;
		    }
        }
	});
    /* srinu */
    jBlock.find(".disEventSatisfyCondition").each(function()
    		{
    		  //  var yesSatisfy = this.value;
    		   var yesSatisfy= j('#dispExhibitInfo\\.eventSatisfyCondition1').is(':checked'); 
    		    var limitAmount = 3000.00;
    		    var checkAmount = j("#dispExhibitInfo\\.eventFee").val();
    		    var finval = checkAmount.replace(',','');
    		    if (yesSatisfy)
    	        {
    		    	if (finval > limitAmount) 
    			    {
    			    	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
    			    	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>If the amount is greater than $3000 you cannot select Yes for "Display/Exhibit Information".</div>');
    			        blkValid = false;
    			    }
    	        }
    		});
    /* end */
    jBlock.find(".reqcostCenterRadio").each(function()
        	{
    	var costCenterText = j("#costCenterText").val();
    	var costcenterrow = j("#reqInfo\\.costCenter").val();
    	var costCenterValue = j("#costCenterErrorList").val();
    	var radioCheked= j('.reqcostCenterRadio').is(':checked'); 
	    	if(radioCheked && costCenterText == "" && costcenterrow =="" && costCenterValue ==""){
	    		var divId = this.id;
				//console.info($("#"+divId).attr('vak'));
				var vak =$("#"+divId).attr('vak');
				jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
				j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should not be blank.</div>');
		        blkValid = false;
	        }
    		if(costCenterValue !=""){
    			var divId = this.id;
    			//console.info($("#"+divId).attr('vak'));
    			var vak =$("#"+divId).attr('vak');
    			jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
    			j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>entered costcenter values are incorrect '+costCenterValue+'.</div>');
		        blkValid = false;
    		}
    	
        	});
    
    
    jBlock.find(".reqwbsElementRadio").each(function()
        	{
    	var wbsElementText = j("#wbsElementText").val();
    	var wbsElementrow = j("#reqInfo\\.wbsElement").val();
    	var wbsElementrValue = j("#wbsElementErrorList").val();
    	var radioCheked= j('.reqwbsElementRadio').is(':checked');
	    	if(radioCheked && wbsElementText == "" && wbsElementrow =="" && wbsElementrValue =="" ){
	    		var divId = this.id;
				//console.info($("#"+divId).attr('vak'));
				var vak =$("#"+divId).attr('vak');
				jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
				j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>Field should not be blank.</div>');
		        blkValid = false;
	        }
    		if(wbsElementrValue !=""){
    			var divId = this.id;
    			var vak =$("#"+divId).attr('vak');
    			jBlock.find("label[vak='" +vak+ "']").addClass("validationError");
    			j(jBlock.find("label[vak='" +vak+ "']").parent()).append('<div class="invalidFieldDesc"><br/>entered wbselement values are incorrect '+wbsElementrValue+'.</div>');
    			blkValid = false;
    		}
    	
        	});
    
    
    jBlock.find(".reqEventDates").each(function()
	{
	    var eventDates = this.value;
	    var startDate = j(".reqStartDate").val();
	    var error = 0;
	    if (isNotEmpty(eventDates) && isNotEmpty(startDate)  )
        {
	    	var eventDate = eventDates.split(",");
	    	for(var i=0; i<eventDate.length; i++){
	    		if (Date.parse(eventDate[i]) < Date.parse(startDate)) {
	    			error = 1;
	    			break;
				}
	    	}
	    	if (error == 1)
		    {
		    	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
		    	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Event dates should not be less than Start Date.</div>');
		        blkValid = false;
		    }
        }
	});
    
	var attachmentId = "";
    jBlock.find(".reqmulti").each(function()
	{
    	 var parentId = this.parentNode.id;
    	 var listId = "#" + parentId + "_list";
    	 if (attachmentId != listId) {
    		 var jList = j(listId);
    		 var attachUpdate = j(this).parent().parent();
        	 var attachmentText = j(attachUpdate).find(".taglib-search-iterator").text();
	   	     if (isEmpty(jList.text()) && submit && isEmpty(attachmentText)) {
	   	    	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	   	    	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please attach files.</div>');
	            blkValid = false;
	   	     } else {
	   	    	var errorCount = 0;
   	    		jList.find(".MultiFile-title").each(function()
   	    		{
   	    			var re = /.doc|.docx|.odt|.ott|.sxw|.stw|.pdf|.xls|.ppt|.xlsb|.csv|.txt|.xlsx|.pptx|.vsd|.bmp|.jpg|.jpeg|.gif|.pix|.png/i;
   	    			if (!re.test(this.title))
   	   	 	        {
   	    				errorCount++;
   	   	 	        }
   	    		});
   				if (errorCount > 0)
   	 	        {
   	 	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
   	 	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please attach valid files.</div>');
   	 	            blkValid = false;
   	 	        }
	   	     }
	   	     attachmentId = listId;
    	 }
	});
    
    jBlock.find(".reqEmailAddress").each(function()
    {
        var email = this.value;
        if (isNotEmpty(email))
        {
        	if (!isEmailAddress(email))
	        {
	        	jBlock.find("label[for='" + this.name + "']").addClass("validationError");
	        	j(jBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Not valid emailAddress.</div>');
	            blkValid = false;
	        }
        }
    });
    if (blockName == "CorporateSupportBlk"){
    var corpBlockId = "#corporateSupportSubTypeId";
    var CorpjBlock = j(corpBlockId);
    CorpjBlock.find(".required").each(function()
    	    {
	    	 if (this.type == 'radio')
		        {
		        	var radioVal = j("input:radio[name='"+this.name+"']").is(":checked");
		        	if (!radioVal) {
		        		CorpjBlock.find("label[for='" + this.name + "']").addClass("validationError");
		        		j(CorpjBlock.find("label[for='" + this.name + "']").parent()).append('<div class="invalidFieldDesc"><br/>Please check the radio button.</div>');
		                blkValid = false;
		        	}
		        }
    	    });
}
    if (blockName == "RequestorInfoBlk") {
    	jBlock.find(".reqAutoPickList").each(function()
		{
    		if(this.value != ''){
				 switch(this.name) {
				 	case 'reqInfo.requestorName':
				 		if(j('#reqInfo\\.requestorEmployeeId').val()=="") {
					 		jBlock.find("label[for='reqInfo.requestorName']").addClass("validationError");
					    	j(jBlock.find("label[for='reqInfo.requestorName']").parent()).append('<div class="invalidFieldDesc"><br/>Please select requestor name through auto pick list.</div>');
					    	blkValid = false;
				 		}
					    break;
				 	case 'reqInfo.managerName':
				 		if(j('#reqInfo\\.managerEmployeeId').val()=="") {
					 		jBlock.find("label[for='reqInfo.managerName']").addClass("validationError");
					    	j(jBlock.find("label[for='reqInfo.managerName']").parent()).append('<div class="invalidFieldDesc"><br/>Please select manager name through auto pick list.</div>');
					    	blkValid = false;
				 		}
				        break;
				 	case 'reqInfo.vpName':
						if(j('#reqInfo\\.vpEmployeeId').val()=="") {
					 		jBlock.find("label[for='reqInfo.vpName']").addClass("validationError");
		    		    	j(jBlock.find("label[for='reqInfo.vpName']").parent()).append('<div class="invalidFieldDesc"><br/>Please select vice president name through auto pick list.</div>');
		    		    	blkValid = false;
						}
	    		    	break;
				 }
    		}
		});
    }
    if (blockName == "EduItemsValBlk") {
    	var itemRetailVal = j("#eduItemsInfo\\.itemRetailValue").val();
    	if (isNumeric(itemRetailVal)) {
	    	if (itemRetailVal > 100) {
	    		jBlock.find("label[for='eduItemsInfo.itemRetailValue']").addClass("validationError");
	        	j(jBlock.find("label[for='eduItemsInfo.itemRetailValue']").parent()).append('<div class="invalidFieldDesc"><br/>Value should not be more than hundred.</div>');
	            blkValid = false;
	    	}
    	}
    }
    
    if (!blkValid)
    {
    	j(".acc-title").removeClass("active");
    	j(".acc-content").hide();
    	if (blockName == "RequestorInfoBlk") {
            alert("Validation Error in Requestor Information Block");
    	} else if (blockName == "ModInfoBlk") {
    		alert("Validation Error in Modification Block");
    	} else if (blockName == "CheckReqBlk") {
    		alert("Validation Error in Check Request Block");
    	} else if (blockName == "DispExhibitBlk") {
    		alert("Validation Error in Display Exhibit Block");
    	} else if (blockName == "POMembershipBlk") {
    		alert("Validation Error in Professional Organization Membership Information Block");
    	} else if (blockName == "EduItemsValBlk") {
    		alert("Validation Error in Educational Items of Value Information Block");
    	} else if (blockName == "ContractInfoBlk") {
    		alert("Validation Error in Contract Information Block");
    	} else if (blockName == "HCPConsultantBlk") {
    		alert("Validation Error in HCP Consultant Information");
    	} else if (blockName == "ServiceAgreementBlk") {
    		alert("Validation Error in Service Agreement with Customers Block");
    	} else if (blockName == "AdvBoardBlk") {
    		alert("Validation Error in Advisory Board Program Information Block");
    	} else if (blockName == "BudgetProdInfoBlk") {
    		alert("Validation Error in Budget Information Block");
    	} else if (blockName == "CorporateSupportBlk") {
    		alert("Validation Error in Corporate Support 3rd party Professional organization Block");
    	} else if (blockName == "ProdInfoBlk" && formName != "CharitableDonation") {
    		alert("Validation Error in Product Information Block");
    	}else if (blockName == "ProdInfoBlk" && formName == "CharitableDonation") {
    		alert("Validation Error in Therapeutic Area Block");
    	}else if (blockName == "CharityDonationBlk") {
    		alert("Validation Error in Charity Donation Block");
    	} else if (blockName == "GeneralRequestBlk") {
    		alert("Validation Error in General Request Block");
    	}
    	jBlock.find(".acc-title").addClass("active");
    	jBlock.find(".acc-content").show();
    	jBlock.find("input:visible:first").focus();
    }
    return blkValid;
}
// formatting dollar value
function formatCurrency(number) 
{
	var num = number.value;
	num = num.toString().replace(/\$|\,/g, '');
	if (isNaN(num)) num = "0";
	sign = (num == (num = Math.abs(num)));
	num = Math.floor(num * 100 + 0.50000000001);
	cents = num % 100;
	num = Math.floor(num / 100).toString();
	if (cents < 10) cents = "0" + cents;
	for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
	num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
	var dollarValue = (((sign) ? '' : '-') + num + '.' + cents);
	number.value = dollarValue;
}

/**
 * This method belonging to form submission after validate
 */	
function validateAndSubmitForm(form, submit, partialEdit)
{
  var formNames = {'DispExhibit': ['CheckReqBlk', 'DispExhibitBlk', 'DispExhibitBlk'],
                            'POMembership': ['CheckReqBlk', 'BudgetInfoBlk', 'POMembershipBlk'],
                            'EduItemsVal' : ['CheckReqBlk', 'ProdInfoBlk', 'EduItemsValBlk'],
                            'CSAgreement' : ['ContractInfoBlk', 'ProdInfoBlk', 'ServiceAgreementBlk'],
                            'HCPConsultant' : ['ContractInfoBlk', 'ProdInfoBlk', 'HCPConsultantBlk'],
                            'AdvBoard' : ['ProdInfoBlk', 'AdvBoardBlk'],
    						'CorporateSupport' : ['CheckReqBlk', 'CorporateSupportBlk'],
    						'CharitableDonation' : ['CheckReqBlk', 'ProdInfoBlk', 'CharityDonationBlk'],
    						'GenRequest' : ['ProdInfoBlk','GeneralRequestBlk']};
  
  var formName = form.formType.value; 
  var validForm = validateBlock("RequestorInfoBlk", submit, formName);

  if (validForm)
    {
    	validForm = validateBlock("ModInfoBlk", submit, formName);
    }
    
    
    var blockNames = formNames[form.formType.value];
    
    if (validForm)
    {
        for (var x = 0 ; x < blockNames.length ; x++)
        {
            var blockName = blockNames[x];
            validForm = validateBlock(blockName, submit, formName);
            if (!validForm)
            {
                break;
            }
        }
    }
	
    if (validForm)
    {
	   if (submit) {
		   j("#action").val("submit");
	   } else {
		   j("#action").val("save");
	   }
	   if (partialEdit) {
		   enableAll();
	   }
	   disableAll();
	   j(".acc-title").removeClass("active");
   	   j(".acc-content").hide();
	   j("#appForm").submit();
    }
}

/**
 * for trailing spaces
 */
function trim(s) {		
	s = s.replace(/(^\s*)|(\s*$)/gi,"");		
	s = s.replace(/\n /,"\n");		
	return s;
}

function disableAll(){
	j(':input').each(function()
	{
		switch(this.type) {
		    case 'password':
		    case 'select-multiple':
		    case 'select-one':
		    case 'text':
		    case 'textarea':
		    case 'checkbox':
		    case 'radio':
		    	j(this).attr('readonly','readonly');
		    	break;
		    case 'button':
			case 'submit':
				j(this).attr('disabled','disabled');
				break;
		}
    });
}

function enableAll(){
	j(':input').each(function()
	{
		switch(this.type) {
		    case 'password':
		    case 'select-multiple':
		    case 'select-one':
		    case 'text':
		    case 'textarea':
		    case 'checkbox':
		    case 'radio':
		    	j(this).removeAttr('disabled');
		}
    });
}