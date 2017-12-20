function textMaxLength(obj,maxLength){
            var max = maxLength - 0;
            var text = obj.value;
            if(text.length > max)
            {
               alert("Content should not exceed "+max+" characters");
               obj.value = text.substring(0,max);
               return false;
            }
            else
            {
                return true;
            } 
        }
function ltrim(str) {
	  return str.replace(/^\s+/g, '');
	}
	function rtrim(str) {
	  return str.replace(/\s+$/g, '');
	}
	function trimStr(str) {
	  return str.replace(/^\s+|\s+$/g, '');
	}
	function printForm()
	{
		window.print();
	}
	

	function formReset()
	{
		var rows = document.getElementById('totalRowsCount').value;
		if(rows>1){
			for(var i=rows-1;i>0;i--){
			
				document.getElementById("itemTable").deleteRow(i);
			}
		}
		document.getElementById('noOfRows').value = 1;
		document.getElementById('totalRowsCount').value = 1;
		document.getElementById('itemTableDiv').style.display='none';
		jQuery("#addRow").val("Add");
		jQuery("#rowBeingModified").val("");
		
		document.requestForm.reset();
	}
	
	function resetSupervisor() {
	    if(jQuery("#supervisorId") !=""){
	    	 document.getElementById('supervisorId').value = "";
	     }
	}
	function resetVendorCode() {
	    if(jQuery("#vendorCode") !=""){
	    	 document.getElementById('vendorCode').value = "";
	     }
	}
	function resetWbsElement() {
	    if(jQuery("#wbsElementId") !=""){
	    	 document.getElementById('wbsElementId').value = "";
	     }
	} 
	function resetCostCenter() {
	    if(jQuery("#costCenterId") !=""){
	    	 document.getElementById('costCenterId').value = "";
	     }
	}
	function resetGlAccountNo() {
	    if(jQuery("#glAccountNoId") !=""){
	    	 document.getElementById('glAccountNoId').value = "";
	     }
	}
function ShowEmailRequester(url)
{

	   document.requestForm.action= url;
	   document.requestForm.submit();
	 	   
}
function ValidateForm(url){
	var columnDelimeter  = "^^^";
	var rowDelimeter = "~~~";
	var str = "";
	var zipCode = document.getElementById("zip").value;
	zipCode = trimStr(zipCode);
	
	if(jQuery("#shipTo").val()=="select"){
		alert("Please enter shipping information");
		document.getElementById("shipTo").focus();
		return false;
	}
	if(document.getElementById("shipTo").value=="Other"){
		if (document.getElementById("address").value=="" || document.getElementById("city").value=="" || document.getElementById("state").value=="" || document.getElementById("zip").value=="")
		{
			alert("The shipping information is incomplete. Please complete the information and submit the request again");
			document.getElementById("address").focus();
			return false;
		}
	if (!isNumeric(zipCode) || (zipCode.length < 5))	
		{
			alert("The Zipcode has to be numeric and five digits");
			document.getElementById("zip").focus();
			return false;
		}
			
/*	if (!isState(document.getElementById("state").value))	
		{
			return false;
		}*/
	}
	
	if(jQuery("#budgetedRequest").val()==0){
		alert('Budgeted Request must me set to either Yes, No or Not Sure'); 
		document.getElementById("budgetedRequest").focus();
		return false;
	}
	if(jQuery("#relatedProject").val()==0){
		alert('Request related to a Project must be set to either Yes, No or Not Sure');
		document.getElementById("relatedProject").focus();
		return false;
	} else if(jQuery("#relatedProject").val()=="Yes"){
		document.getElementById('supervisorName').value="";
		document.getElementById('supervisorId').value="";
		if(jQuery("#projectName").val()==""){
			alert('Please enter Project Name');
			document.getElementById("projectName").focus();
			return false;
		}
		if(jQuery("#projectManagerId").val()=="select"){
			alert('Please select Project Manager Name');
			return false;
		}
	} else if(jQuery("#relatedProject").val()!="Yes"){
		document.getElementById('projectManagerId').value="";
	}
	if ( (jQuery("#relatedProject").val()=="No") || (jQuery("#relatedProject").val()=="Not Sure") ) {
	if(jQuery("#supervisorName").val()==""){
		alert("Please enter Supervisor Name");
		document.getElementById("supervisorName").focus();
		return false;
	}
	}
	if(jQuery("#supervisorName").val()!=""){
		if(jQuery("#supervisorId").val()==""){
			alert("Please select the Supervisor through auto pick list");
			document.getElementById("supervisorName").focus();
			return false;
		}
	}
	
		if(jQuery("#noOfRows").val() == 1)
		{
		alert("Please add atleast one Item using Add button before submitting request.");
		document.getElementById('itemName').focus();
		return false;
		}  
	
	if (jQuery("#reason").val()=="")
	{
		alert("The reason for the request is mandatory");
		document.getElementById("reason").focus();
		return false;
	}
	if(jQuery("#vendorName").val()!=""){
		if(jQuery("#vendorCode").val()==""){
			alert("Please select the Vendor Name through auto pick list");
			document.getElementById("vendorName").focus();
			return false;
		}
	}
	
	
if ((jQuery("#saveAction").val()=="ADD")|| (jQuery("#saveAction").val()=="UPDATE")){
		
		var rowNo=document.getElementById('rowCount').value;
		if(jQuery("#itemNo").val()>0){
		if(jQuery("#newRows").val()>1){
			for(var row=rowNo; row <parseInt(document.getElementById('noOfRows').value);row++)
			{
				
				for(var col=0; col < 8; col++)
				{
					
					str = str + document.getElementById('itemTable').rows[row].cells[col].innerHTML;
					
					str = str + columnDelimeter;
			
				}
				str = str + rowDelimeter;
									
			}
		}
		} else {
			
			for(var row=1; row < parseInt(document.getElementById('noOfRows').value);row++)
			{
				
				for(var col=0; col < 8; col++)
				{
					
					str = str + document.getElementById('itemTable').rows[row].cells[col].innerHTML;
					
					str = str + columnDelimeter;
			
				}
				str = str + rowDelimeter;
				
			}
		}
	}
	
	
		jQuery("#itemRequestString").val(str);
		jQuery('#fileTags').find('input[type="file"]').each(
		    	function() {
			        var id = jQuery(this).attr('id');
			        jQuery(this).attr('name',id);
		    	});
		// Check vendor_email
		var emailID=document.getElementById("vendorEmail");
		 emailID = trimAll(emailID.value);
		if (echeck(emailID)==false)
		{
		
		return false ;
		}
	
	if(jQuery("#saveAction").val()=="ADD" && url!='')
		{
		 document.requestForm.action=url;
		 document.getElementById('noOfRows').value = document.getElementById('noOfRows').value - 1;
		 document.requestForm.submit();
	
	} else if(jQuery("#saveAction").val()=="UPDATE" && url!=''){
		document.requestForm.action= url;
		document.getElementById('noOfRows').value = document.getElementById('noOfRows').value - 1;
		document.requestForm.submit();
		
	}
	return true;
}

function trimAll(sString)
{
while (sString.substring(0,1) == ' ')
{
sString = sString.substring(1, sString.length);
}
while (sString.substring(sString.length-1, sString.length) == ' ')
{
sString = sString.substring(0,sString.length-1);
}
return sString;
} 
function echeck(str) {

	var at="@"
	var dot="."
	var lat=str.indexOf(at)
	var lstr=str.length
	var ldot=str.indexOf(dot)
	if (str==""){return true;}
	
	if (str =="") {return true;}
	if (str.indexOf(at)==-1){
	   alert("Invalid E-mail ID")
	   return false
	}

	if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
	   alert("Invalid E-mail ID")
	   return false
	}

	if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
	    alert("Invalid E-mail ID")
	    return false
	}

	 if (str.indexOf(at,(lat+1))!=-1){
	    alert("Invalid E-mail ID")
	    return false
	 }

	 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
	    alert("Invalid E-mail ID")
	    return false
	 }

	 if (str.indexOf(dot,(lat+2))==-1){
	    alert("Invalid E-mail ID")
	    return false
	 }
	
	 if (str.indexOf(" ")!=-1){
	    alert("Invalid E-mail ID")
	    return false
	 }
	
		 return true					
}
function isNumeric(val) {return (parseFloat(val,10)==(val*1));}
function isState(dateStr) {
	var statePat = /^[a-zA-Z]{2}$/;
	var matchArray = dateStr.search(statePat); // is the state ok?
	
	if (matchArray !=0) {
		alert("Please enter a valid 2 letter state code");
		return false;
	}
	return true;
}


