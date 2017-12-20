<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Jay Patel
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>

<%
	if(Validator.isNotNull(eprocuRequest))
	{
		boolean showApproveDeclineButton = EProcurementPermissionUtil.showApproveDeclineButton(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), eprocuRequest.getRequestId(), themeDisplay.getUserId());
		if(showApproveDeclineButton)
		{
%>	

	<input type="hidden" id="requestStatus" name="requestStatus" />
	<input type="hidden" id="approverComments" name="approverComments" />
	<input type="hidden" id="workflowNames" name="workflowNames" />
	<input type="button" title="Click to Approve the request" id="id1" class="button input-button" value="Approve" name="approve" onclick="submitApproveDeclineForm();" />	
	<input type="button" title="Click to Decline the request" class="button input-button" value="Decline" name="Dontapprove" onclick="showCommentDialogue();" />
		
	<div id="dialog" class="jqmWindow jqmID1" style="z-index: 3000;">
		<div class="jqmtitlebar">
		<h3>Add Comments</h3>
			<a class="jqmClose" href="#"><img class="closebutton" alt="" src="/o/e-procurement-portlet/images/close-icon.gif"></a>
		</div>
		<hr>
		<div class="commentbox">
  			<textarea id="declineComments" name="declineComments"  style="padding: 3px; width: 390px; position: relative;" title="Enter appropriate comments" rows="5" cols="26" class="text-field"></textarea>
			<input type="button" style="margin-top: 10px; float: right;  margin-right: 3px;" class="button input-button" name="Ok" id="Submit" value="Submit" title="Submit" onclick="setComments();" />
		</div>      
	</div>
<portlet:actionURL var="declineRequestURL">
					<portlet:param name="eProcAction" value="approveDeclineRequest" />
					<portlet:param name="requestId" value="<%= String.valueOf(eprocuRequest.getRequestId()) %>" />
					<portlet:param name="cmd" value="<%= EProcurementConstants.ACTION_DECLINE %>" />
					<portlet:param name="action" value="UPDATE" />
</portlet:actionURL>
<portlet:actionURL var="approveRequestURL">
					<portlet:param name="eProcAction" value="approveDeclineRequest" />
					<portlet:param name="requestId" value="<%= String.valueOf(eprocuRequest.getRequestId()) %>" />
					<portlet:param name="action" value="UPDATE" />
				</portlet:actionURL>
<script type="text/javascript">
jQuery(document).ready(function(){
	
jQuery('#dialog').jqm({modal: true});

});
	function showCommentDialogue(){

		var url="";
		if(ValidateForm(url)){
				document.getElementById("declineComments").value='';
				document.getElementById("approverComments").value='';
				jQuery('#dialog').jqmShow();
		}else{
				jQuery('#dialog').jqmHide();
		}
	}
	
	function setComments()
	{	
		if(document.getElementById("declineComments").value=='')
		{		
				
				alert('Please specify reason to for decline');
				return false;
		}
		else{
			document.getElementById("approverComments").value = document.getElementById("declineComments").value;
			document.requestForm.action = '<%=declineRequestURL%>';
			document.requestForm.submit();


		}
	}
	
	function submitApproveDeclineForm()
	{
		var url="";
		if(ValidateForm(url))
		{
			document.requestForm.action = '<%=approveRequestURL%>';
			document.requestForm.submit();
		}
	}

</script>
		
<%
		}
	}
%>

