function emailSubmit(url) {
    if(document.getElementById('emailComments').value==""){
    	alert('Please enter email comments');
    	return false;
    }
	document.emailForm.action=url;
	document.emailForm.method="post";
	document.emailForm.submit();
}
function emailCancel(url){
	document.emailForm.action= url;
	document.emailForm.method="post";
	document.emailForm.submit();
}

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