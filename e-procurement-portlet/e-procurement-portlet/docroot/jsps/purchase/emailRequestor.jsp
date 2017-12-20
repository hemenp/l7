<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Resmy Mathew
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
	
	<%@ include file="../init.jsp" %>	
	
</head>

<body>
  	<portlet:actionURL var="emailRequestorURL">
		<portlet:param name="cmd" value="saveEmailComment"/>	 
	</portlet:actionURL>
	<portlet:actionURL var="cancelRequestorURL">
		<portlet:param name="cmd" value="cancelRequestor"/>	 
	</portlet:actionURL>

<%

	String requestId=StringPool.BLANK;
	User requestorUser = (User)request.getAttribute("requestorUser");
	User loggedInUser  = (User)request.getAttribute("loggedinUser");
	String fromEmail = StringPool.BLANK; //loggedinUser email
	String toEmail=StringPool.BLANK; //requestor Email
	String fromName=StringPool.BLANK;
	String toName=StringPool.BLANK;
	long updatedBy =0;
	if(Validator.isNotNull(loggedInUser)){
	    fromEmail = loggedInUser.getEmailAddress();
	    fromName = loggedInUser.getFullName();
	    updatedBy = loggedInUser.getUserId();
	    
	}
	if(Validator.isNotNull(requestorUser)){
	   
	    toEmail = requestorUser.getEmailAddress();
	    toName = requestorUser.getFullName();
	}
	Object obj= request.getAttribute("requestId");
	if(Validator.isNotNull(obj)){
    requestId = obj.toString();

	}
%>
<!-- Menu -->
<form name="emailForm" >

<div id="cntr_contentCentral_two" class="main_heading">
<h3>Compose Email</h3>
</div>
<div class="group-list-content">
<div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">
<table class="round-corners">
<tbody>
<tr>
<td class="tl">&nbsp;</td>
<td>&nbsp;</td>
<td class="tr">&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td colspan="3" style="padding: 0pt 10px;" class="form-content">
<table cellspacing="0" cellpadding="0" border="0" width="100%">
				  <tbody>
                   <tr>
						<td class="label">From</td>
						<td class="form-item"><%=fromEmail %></td>	
						<td><input type="hidden" name="fromName" value="<%= fromName %>" /></td>
						<td><input type="hidden" name="fromEmail" value="<%= fromEmail %>" /></td>
						<input type="hidden" name=updatedBy value="<%= updatedBy %>" />
				  </tr>
				   <tr>
						<td class="label">To</td>
						<td class="form-item"><input type="text" size="35" value="<%=toEmail %>" disabled="disabled" name="To"></td>
						<td><input type="hidden" name="toName" value="<%= toName %>" /></td>
						<td><input type="hidden" name="toEmail" value="<%= toEmail %>" /></td>
				  </tr>
				  
				  <tr>
						<td class="label">Subject</td>
						<td class="form-item"><input maxlength ="30" type="text"  size="35" value="E-Procurement Purchase Request: <%=requestId %>" name="Subject" id="Subject"></td>
						<input type="hidden" name= "requestId" value="<%=requestId%>"/>
				  </tr>
                    <tr>
						<td class="label "  >Comments</td>
						<td class="form-item" ><textarea onkeypress="return textMaxLength(this,'1000')"; onkeyup="return textMaxLength(this,'1000')"; rows="1" cols="1" id="emailComments" name="emailComments" class="text-field" title="" style="padding: 3px; margin-right: 10px; width:  98.5%;"></textarea>
								* These comments will be recorded in the workflow. 
						</td>
				
				  </tr>
				   <tr>
						<td class="heading16">&nbsp;</td>
						<td ><input title="Click to submit" value="Send Email to Requester" name="Ok" class="button input-button" type="button" onClick="emailSubmit('<%=emailRequestorURL%>')">
                       			 <input title="Click to clear request information" value="Cancel" class="button input-button" type="button" onclick="emailCancel('<%=cancelRequestorURL%>')">
                        </td>
				  </tr>
				 
					</tbody>
          </table>

</td>
</tr>
<tr>
<td class="bl"></td>
<td></td>
<td class="br"></td>
</tr>
</tbody>
</table>
<br />
</div>
</div>

<br />
<br />
<br />
</form>

<script type="text/javascript">
jQuery(document).ready(function(){
jQuery(".action-menu").hide();
jQuery("#cntr_contentOneCol .action-button").click(function(){
jQuery(this).next(".action-menu").toggle();
})
jQuery('.sub-menu').hover(
function() {
jQuery(this).addClass('hovrd');
}, function() {
jQuery(this).removeClass('hovrd');
}
);
jQuery(".search-result-table tr:even").addClass("alt");
});
</script>
