<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Jay Patel
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>

<%@ include file="../init.jsp" %>

<script type=text/javascript>
jQuery(document).ready(function(){

});

</script>




<script type="text/javascript">

	var newStatus = '<%= EProcurementConstants.STATUS_NEW %>';
	var levelOneStatus = '<%= EProcurementConstants.STATUS_LEVEL1_APPROVED %>';
	var wfAssignedStatus = '<%= EProcurementConstants.STATUS_WORKFLOW_ASSIGNED %>';
	var inprocessStatus = '<%= EProcurementConstants.STATUS_INPROCESS %>';
	var cancelledStatus = '<%= EProcurementConstants.STATUS_CANCELLED %>';
	var completedStatus = '<%= EProcurementConstants.STATUS_COMPLETED %>';
	var selectString = '<%= EProcurementConstants.PARAM_VALUE_SELECT %>';

	var arrStatus = new Array();
	var i = 0;
	var stageIdStatusMap = {};

	function decideIndex()
	{	
		var curStatus = document.getElementById("currentStatus").value;
		var selectedStatus = document.getElementById("requestStatus").value;
		if(null != curStatus && "" != curStatus)
		{
			var statusValue = '';
			var curStatusIndex ;
			var selectedStatusIndex ;
			for (var statusIndex in arrStatus) {
				statusValue = arrStatus[statusIndex];
				if(statusValue == curStatus){curStatusIndex = statusIndex;}
				else if(statusValue == selectedStatus){selectedStatusIndex = statusIndex;}
			}
			if(null != selectedStatus && "" != selectedStatus)
			{
				if(selectedStatusIndex < curStatusIndex)
				{
					if(!document.getElementById("resetStatus").checked)
					{
						alert("Please check Reset 'Status checkbox' in order to reset the status!");
						return false;
					}
				}
			}
		}
		return true;
	}

	function setSelectedStatus()
	{
		var selectedStatus = document.getElementById("requestStatus").value;
		for(var key in stageIdStatusMap) 
		{
			if(selectedStatus == stageIdStatusMap[key])
			{
				document.getElementById("hidRelativeStatus").value = key;
				break;
			}
		}
		return true;
	}
	
	function submitRequestWorkflowForm() 
	{	
		if(validateRequestWorkflowForm())
		{
			if(decideIndex())
			{
				if(setSelectedStatus())
				{
					if(isWFChanged())
					{
						if(isAdvancedFromLevel1ToWFAssigned())
						{
							document.<portlet:namespace />requestWorkflow.submit();
						}
					}
				}
			}
		}
	}

	function isAdvancedFromLevel1ToWFAssigned()
	{
		var currentStatus = document.getElementById("currentStatus").value;
		var requestStatus = document.getElementById("requestStatus").value;
		var workflowNames = document.getElementById("workflowNames");

		if( (currentStatus == levelOneStatus || requestStatus == levelOneStatus || requestStatus == wfAssignedStatus)
			&& !(requestStatus == inprocessStatus || requestStatus == cancelledStatus || requestStatus == completedStatus) )
		{
			if(workflowNames != null && workflowNames.value != null)
			{
				if(workflowNames.value == selectString && !document.getElementById("resetStatus").checked)
				{
					alert("Advancing from here will make request status as 'WORKFLOW ASSIGNED'.. Please select proper Workflow if you want to Advance!");
					return false;
				}
			}
		}

		return true;
	}

	function isWFChanged()
	{
		var currentWFId = document.getElementById("currentWFId");
		
		if(currentWFId != null && currentWFId.value != null)
		{
			var workflowNames = document.getElementById("workflowNames");
			
			if(workflowNames != null && workflowNames.value != null)
			{
				if(workflowNames.value == selectString)
				{
					alert("Please select proper new Workflow if at all you want to change the Workflow!");
					return false;
				}
				var currentStatus = document.getElementById("currentStatus").value;
				var requestStatus = document.getElementById("requestStatus").value;

				if(workflowNames.value != currentWFId.value)
				{
					if(requestStatus == levelOneStatus || requestStatus == newStatus)
					{
						return true;
					}
					else
					{
						alert("You can not change assigned Workflow without changing request status to '" + newStatus + "' OR '" 
							+ levelOneStatus + "'");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	function validateRequestWorkflowForm() 
	{
		if(validateRequestWorkflowForm())
		{
			var statusNew = newStatus;
			var statusVPApproved = levelOneStatus;	
			var currentStatus = document.<portlet:namespace />requestWorkflow.currentStatus.value;
			var selectedStatus = document.<portlet:namespace />requestWorkflow.requestStatus.value;

			if(currentStatus == statusNew && selectedStatus != statusVPApproved){
				alert("You can't move forward without Level 1 Approval!");
				return false;
			}else{
				return true;
			}	
	 	}
	}

	function validateRequestWorkflowForm()
	{
		var wfAssigned = wfAssignedStatus;
		var vpApproved = levelOneStatus;
		var selectedStatus = document.getElementById("requestStatus").value;
		var wfSelectBox = document.getElementById("workflowNames").value;
		var currentWFId = document.getElementById("currentWFId");
		if(selectedStatus==wfAssigned && wfSelectBox=="--Select--")
		{
			alert('Please select Workflow from Dropdown in order to move forward');
			return false;	
		}
		else{
			return true;
		}
	}
	
	function setExistingWFInSelectBox()
	{
		var wfSelectBox = document.getElementById("workflowNames");
		var currentWFId = document.getElementById("currentWFId");
		if(currentWFId != null)
		{
			var hidCurrentWFId = document.getElementById("currentWFId").value;
			if(null != wfSelectBox)
			{
				var i;
				for(i = 0; i<wfSelectBox.length; i++)
				{
					if(wfSelectBox[i].value == hidCurrentWFId)
					{
					    wfSelectBox[i].selected = true;
					}
				}   
			}
		}
	}

	
</script>
<body>
<portlet:actionURL var="customModifyURL">
	<portlet:param name="eProcAction" value="showRequestWFDetails"/>
	<portlet:param name="cmd" value="updateWorkflow"/>
	<portlet:param name="requestId" value="${requestId}"/>
</portlet:actionURL>

<form method="post" action="${customModifyURL}" name="<portlet:namespace />requestWorkflow" id="<portlet:namespace />requestWorkflow">
	<input type="hidden" id="requestId" name="requestId" value='<c:out value="${requestId}" />' />
	<input type="hidden" id="currentStatus" name="currentStatus" value='<c:out value="${curStatus}" />' />
	<input type="hidden" id="hidRelativeStatus" name="hidRelativeStatus" value="" />
	<input type="hidden" id="disableAdvanceWorkFlow" name="disableAdvanceWorkFlow" value="${disableAdvanceWorkFlow}" />
	
	<c:if test="${curWFId != null}">
		<input type="hidden" id="currentWFId" name="currentWFId" value='<c:out value='${curWFId}' />' />
	</c:if>

	<table border="0" width="100%" style="border: 1px solid rgb(204, 204, 204); margin-bottom: 10px;" class="bgcolor1">
	<tbody>
		<tr>
			<td style="vertical-align: top;" class="form-content">
			<table border="0" width="350" class="bgcolor1">
				<tbody>
					<tr>
						<td class="label form-item"><liferay-ui:message key="req.workflow.current.status"></liferay-ui:message></td>
					    <td style="width: 230px;  position:relative" class="form-item">
					  		
		<div style="padding:0px; width:220px; border:0 solid black; overflow:hidden; position:relative">
				
							<select  style="_font-size:11px !important;" name="requestStatus" id="requestStatus" class="ctrDropDown" onBlur="this.className='ctrDropDown';" onMouseDown="this.className='ctrDropDownClick';" onChange="this.className='ctrDropDown';">
								<c:forEach items='${listStatus}' var='status'>
									<option value="<c:out value='${status}' />" ><c:out value='${status}' /></option>
							    	<script type="text/javascript">
							    		arrStatus[i++] = '<c:out value="${status}" />'; 
							    	</script>									
								</c:forEach>
							</select>
					  </div>
						</td>
					
						<c:if test="${curStatus != null}">
							<script>
								document.getElementById("requestStatus").value = '<c:out value="${curStatus}" />';
							</script>
						</c:if>
					</tr>
					<tr>
						<td width="100" class="label form-item"><liferay-ui:message key="req.workflow.comments"></liferay-ui:message></td>
				        <td class="form-item"><textarea style="width: 220px;" rows="2" name="approverComments" id="approverComments"></textarea></td>
				    </tr>
				    <tr>
				        <td width="100" class="label form-item"><liferay-ui:message key="req.workflow.name"></liferay-ui:message></td>
				        <td class="form-item">
							<select name="workflowNames" id="workflowNames" style="width: 220px; _font-size:11px !important;" >
								<option value="<%= EProcurementConstants.PARAM_VALUE_SELECT %>"><%= EProcurementConstants.PARAM_VALUE_SELECT %></option>
								<c:choose>
									<c:when test='${curStatus eq statusNew && curWFId eq null}' >
									</c:when>
									<c:otherwise>
										<c:forEach items='${wfIdNames}' var='wf'>
											<option value="<c:out value='${wf.key}' />" ><c:out value='${wf.value}' /></option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</select>
							<script type="text/javascript">
								setExistingWFInSelectBox();
							</script>
						</td>
					</tr>
					<tr>
						<td class="label form-item"><liferay-ui:message key="req.workflow.reset.status"></liferay-ui:message></td>
						<td><input type="checkbox" name="resetStatus" id="resetStatus" ></td>
					</tr>
					<tr>
				        <td class="label form-item"></td>
				        <td>
				        	<input type="button" name="Advance WorkFlow" value="Advance WorkFlow" id="advanceWFButton" class="button input-button width150" onclick="return submitRequestWorkflowForm();" />
				          	<!--  <input type="reset" class="button input-button" value="Clear" /> -->
				        </td>
				    </tr>
				</tbody>
			</table>
			</td>
			<% if(request.getAttribute("showWFRouting") != null && request.getAttribute("showWFRouting").equals(Boolean.TRUE)){ %>
		   	<td style="border-left: 1px solid rgb(204, 204, 204);" class="form-content">
		   	<table border="0" class="search-result-table">
				<tbody>
					<tr class="alt">
						<th colspan="4" class="mgr"> <c:out value="${wfRouter.wfDefinitionName}" /> </th>
					</tr>
					<tr>
			           <th class="mgr"><liferay-ui:message key="req.workflow.status"></liferay-ui:message></th>
			           <th class="mgr width150"><liferay-ui:message key="req.workflow.role"></liferay-ui:message></th>
			           <th style="width: 180px;" class="mgr"><liferay-ui:message key="stage.approver.name"></liferay-ui:message></th>
					</tr>
					<c:forEach items="${wfRouter.listStageRouter}" var="stageRouter" varStatus="ctr">
						<tr class="${ctr.index % 2 == 0 ? 'alt' : ''}">
							<td nowrap="nowrap">
								<c:if test="${stageRouter.showCheck}">
									<img border="0" class="rhtmargin5" src="/e-procurement-portlet/images/bullet.png" alt="">
								</c:if>
								<c:out value="${stageRouter.statusMessage}" />
							</td>
			           		<td class="note" ><strong><c:out value="${stageRouter.jobTitle}" /></strong></td>
			           		<td class="note"><c:out value="${stageRouter.fullName}" /></td>	
						</tr>
					</c:forEach>
				</tbody>
		     </table>
		     </td>
		     <% } %>
		</tr>
	</tbody>
	</table>
	
<c:if test="${stageIdStatusMap ne null}">
	<c:forEach items='${stageIdStatusMap}' var='idStatus'>
		<script type="text/javascript">
			stageIdStatusMap['<c:out value="${idStatus.key}"></c:out>'] = '<c:out value="${idStatus.value}"></c:out>';
		</script>
	</c:forEach>
</c:if>

</form>
</body>
<% if(request.getAttribute("listCustomWFReview") != null && ((List)request.getAttribute("listCustomWFReview")).size() > 0) { %>
	<%@include file="workflowComments.jsp" %>
<% } %>
