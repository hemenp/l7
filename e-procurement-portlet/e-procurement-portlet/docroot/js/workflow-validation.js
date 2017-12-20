function changeSelectedUserDivForIpad(){
	var isIpadBrowser =  navigator.userAgent.toLowerCase().indexOf("ipad") !=-1 ; 
	if(isIpadBrowser)
	{
		jQuery("#selectedUsersIpadDiv").empty();
		jQuery("#selectedUsers option").each(function(){ 
			jQuery("#selectedUsersIpadDiv").append("<li>"+jQuery(this).text()+"</li>");
		});	
	}
}

function removeSelectedUsers(){
	var selectedUsers=document.getElementById('selectedUsers');
	for (i=0; i<selectedUsers.options.length; i++) {
		if (selectedUsers.options[i].selected) {
			selectedUsers.remove(i);
			i--;
	    }
	}
	changeSelectedUserDivForIpad();
}

function resetUserVal() {
    var userId=document.getElementById('userId').value.trim();
     if(userId !=""){
    	 document.getElementById('userId').value = "";
    	 document.getElementById('jobTitle').value = "";
     }
}

function addEprocureUsers(){
	document.getElementById('errMsg').style.display="none";
	var userName=document.getElementById('eprocureUser').value.trim();
	var userId=document.getElementById('userId').value.trim();
	var jobTitle=document.getElementById('jobTitle').value.trim();
	var name=jobTitle+" - "+userName;
	var value=userId;
	if(userName==""||jobTitle==""||userId==""){
		document.getElementById('errMsg').innerHTML = "Please select an user from picklist."
			document.getElementById('errMsg').style.display="block";
		return;
	}
	
   	if(userName.indexOf("(")!=-1 && userName.indexOf(")")!=-1){
	   	name=userName.substring(0,userName.indexOf("("));
	   	value=userName.substring(userName.indexOf("(")+1,userName.indexOf(")"));
   	}
	var add=true;
	var targetList=document.getElementById('selectedUsers');
   	for (j=0; j<targetList.options.length; j++) {
	    if(name == targetList.options[j].text){
		   	add=false;
	    }
   	}
   	if(add){
	   	targetList.options.add(new Option(name,value));
   	}
   	changeSelectedUserDivForIpad();
}

function validateAddWorkflowPage(){
	var workflowName = document.getElementById('workflowName').value;
    var approverList = document.getElementById('selectedUsers');
    var approverLength = approverList.options.length;
    var submit = true;
    if (workflowName == null || workflowName == "") {
            document.getElementById('errMsg').innerHTML = "Please enter Workflow Name."
            submit = false;
    } else if (approverLength == 0) {
            document.getElementById('errMsg').innerHTML = "Please add atleast one user to select box.";
            submit = false;
    } else if (approverLength > 0){
            var approverIds = "";
            for (j=0; j<approverLength; j++) {
                    if(j==0){
                            approverIds = approverIds + approverList.options[j].value;
                    }else{
                            approverIds = approverIds + "," +approverList.options[j].value;
                    }
            }
            document.getElementById('approverIds').value=approverIds;
    }
    return submit;
}
function submitWorkflowPage(url) {
	var submit = true;
	submit = validateAddWorkflowPage();
	var elem = document.getElementById('errMsg');
	if (submit) {
		elem.style.display = "none";
		submitForm(document.workflowFm, url, 0);
	} else {
		elem.style.display = "block";
	}
}

jQuery(document).ready(function(){
	changeSelectedUserDivForIpad();
});