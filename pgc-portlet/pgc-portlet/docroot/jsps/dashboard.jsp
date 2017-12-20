<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Vijayan Chendrayan
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to Pass Object Name while updating the record
--%>
<%@ include file="/jsps/init.jsp" %>


<style type="text/css">
.ie7 #wrapper { position:static;}
</style>

<!-- pgc dashboard js -->
<script  type="text/javascript" src="/o/pgc-portlet/js/pgcdashboard.js"></script>
<script  type="text/javascript" src="/o/pgc-portlet/js/jqModal.js"></script>

<portlet:renderURL var="newPGCFormUrl">
    <portlet:param name="appAction" value="newPGCForm" />
</portlet:renderURL>
<portlet:renderURL var="searchPGCForm">
    <portlet:param name="appAction" value="search" />
</portlet:renderURL>
<liferay-ui:success key="processed-successfully" message="processed-successfully" />

<!-- auto complete js files -->
<link rel="stylesheet" type="text/css" href="/o/pgc-portlet/css/jquery.autocomplete.css" />

<style type="text/css">
.taglib-search-iterator .results-row td.first, .taglib-search-iterator .results-row th.first {
border-left-width: 0;
word-break: break-all;
}
</style>

<script  type="text/javascript" src="/o/pgc-portlet/js/jquery.autocomplete.js"></script>
<script  type="text/javascript" src="/o/pgc-portlet/js/pgc-autocomplete.js"></script>
<%
	PGCRequestSummary pgcSummary = null;
	if (Validator.isNotNull(portletSession.getAttribute("PGCSUMMARY"))) {
		pgcSummary = (PGCRequestSummary) portletSession.getAttribute("PGCSUMMARY");
	} else {
		pgcSummary = new PGCRequestSummary();
	}
	Map<String, String> statusList = DropDownUtil.getStatusList();
	Map<String, String> formTypesSearchList = DropDownUtil.getFormTypesSearch();

	// fix for 3478
	PGCForm pcgform = (PGCForm) request.getAttribute("appForm");
	pcgform.setFormType(null);

%>
<div class="main_heading" id="cntr_contentCentral_two">
    <div class="">PGC Dashboard View</div>
<c:if test="<%= SessionMessages.contains(request,\"processed-successfully\") %>">
	<span class="portlet-msg-success">
	Your request processed successfully.
	</span>
</c:if>
<c:if test="<%= SessionErrors.contains(request,\"process-unsuccess\") %>">
	<liferay-ui:error key="process-unsuccess" message="process-unsuccess" />
</c:if>
</div>
	
<div class="group-list-content">
	<h3 class="create-title">Create PGC Request(s)</h3>
   	<div style="float: none; margin: 0pt auto; padding: 9px; width: auto;border:1px solid #ccc;border-top:0px;" id="cntr_contentOneCol">
	   <form:form commandName="appForm" action="${newPGCFormUrl}" onsubmit="return checkNewReqType(this);">
	   		<input type="hidden" name="requestorSearch" id="requestorSearch" value="requestor" />
			<input type="hidden" name="companyId" id="companyId" value="<%= themeDisplay.getCompanyId() %>" />
	        <form:select path="formType" cssStyle="padding: 3px 6px; font-size: 13px;" size="1">
	     		<form:option value="" label="Select a Form" selected='selected'/>
	           <%-- TODO remove hardcoded title value after demo --%>
	           <c:forEach items="${filteredFormTypes}" var="formType">
	           		<c:if test="${not empty formTitles}">
	           			<form:option value="${formType.key}" title="${formTitles[formType.key]}" label="${formType.value}"/>
	           		</c:if>
				</c:forEach>
	       </form:select>
	       <input type="submit" class="input-button" id="" value="Create New Request" />
	       <div class="jqmWindow" id="dialog_new">
				<span id="titleon"></span>
				<a class="jqmClose" href="#">Close</a>
			</div>
		</form:form>
	</div>
  	<div class="searchForm">
	   <form name="searchPGCForm" action="<%= searchPGCForm %>" id="searchPGCForm" method="post">
		   <p style="padding-bottom:12px;">
		   		<h3 class="search-title">Search here for PGC Request(s)</h3>
				<div id="searchBlock" style="border:1px solid #ccc; margin-bottom:10px; padding:4px; border-top:0px;">
					<table class="form-content" border="0">
						<tr>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.reqsListHead.requestTitleName" />
							</td>
							<td class="form-item" style="vertical-align: middle;">
								<input type="text" value="<%= pgcSummary.getRequestTitle() %>" name="requestTitle" class="text-field" style="margin-right: 10px; width:136px;" />
							</td>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.label.formType" />
							</td>
							<td class="form-item" colspan="3" style="vertical-align: middle;">
								<select name="formTypeValue" id="formTypeValue" class="text-field" style="width: 290px;">
									<option value="">All Forms</option>
									<%
										for (Map.Entry<String, String> formList : formTypesSearchList.entrySet()) {
									%>
										<option value="<%= formList.getKey() %>" <% if (pgcSummary.getFormType().equalsIgnoreCase(formList.getKey())) {%> selected="selected" <% } %> ><%= formList.getValue() %></option>
									<% } %>
								</select>
							</td>
						</tr>
						<tr>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.reqsListHead.requestor" />
							</td>
							<td class="form-item" style="vertical-align: middle;">
								<input type="text" value="<%= pgcSummary.getRequestor() %>" name="requestor" id="requestor" class="text-field" style="margin-right: 10px; width: 136px;" autocomplete="on" />
							</td>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.reqsListHead.status" />
							</td>
							<td class="form-item" colspan="3" style="vertical-align: middle;">
								<select name="status" id="status" class="text-field" style="width:290px;">
									<option value="">Select</option>
									<%
										for (Map.Entry<String, String> stat : statusList.entrySet()) {
									%>
										<option value="<%= stat.getValue() %>" <% if (pgcSummary.getStatus().equalsIgnoreCase(stat.getValue())) { %>selected = "selected" <% } %>><%= stat.getKey() %></option>
									<% } %>
								</select>
							</td>
						</tr>
						<tr>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.label.dateType" />
							</td>
							<td class="form-item" style="vertical-align: middle;">
								<select name="dateType" id="dateType" class="text-field" style="width: 145px;">
									<option value="meetingDate" <% if (pgcSummary.getDateType().equalsIgnoreCase("meetingDate")) { %>selected = "selected" <% } %>>PGC Meeting Date</option>
									<option value="eventDate" <% if (pgcSummary.getDateType().equalsIgnoreCase("eventDate")) { %>selected = "selected" <% } %>>Event Date</option>
								</select>
							</td>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.label.startDate" />
							</td>
							<td class="form-item" style="vertical-align: middle;">
								<input type="text"  value="<%= pgcSummary.getStartDate() %>" name="startDate" style="margin-right: 2px; width:78px;"  class="text-field" maxlength="10" id="startDate" readonly="readonly"/>
							</td>
							<td style="vertical-align: middle;">
								<liferay-ui:message key="dashboard.label.endDate" />
							</td>
							<td class="form-item" style="vertical-align: middle;">
								<input type="text"  value="<%= pgcSummary.getEndDate() %>" name="endDate" style="margin-right: 2px; width:78px;"  class="text-field" size="12" maxlength="10" id="endDate" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="form-item" colspan="5">
								<input type="submit" id="submit_button" class="button input-button" value="Search" />
								<input type="button" class="button input-button" onclick="clearSearchForm(document.forms['searchPGCForm']);" value="Clear" />
							</td>
						</tr>
					</table>
				</div>
			</p>
		</form>
	</div>
	
   <table class="round-corners">
       <tr>
           <td class="tl">&nbsp;</td>
           <td>&nbsp;</td>
           <td class="tr">&nbsp;&nbsp;&nbsp;</td>
       </tr>
       <tr>
			<td class="form-content" style="padding: 0pt 10px;" colspan="3">
		    	<liferay-ui:search-container searchContainer='<%=(SearchContainer)request.getAttribute("dashBoardSearchContainer") %>'>
				<liferay-ui:search-container-results>
					<%
						pageContext.setAttribute("results", (ArrayList<PGCRequestSummary>)renderRequest.getAttribute("results"));
						pageContext.setAttribute("total", searchContainer.getTotal());
						
					%>
				</liferay-ui:search-container-results>		
				<liferay-ui:search-container-row className="com.dsi.intranet.pgc.portlet.model.PGCRequestSummary"
					   keyProperty="requestTitle" modelVar="dashBoardDO">
					<div style="display: none;">
					</div>
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.requestTitleName" property="requestTitle" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.formType" property="formTypeName" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.requestor" property="requestor" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.checkAmount" property="checkAmount" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.meetingDate" property="meetingDate" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.eventDate" property="eventDate" />
					<liferay-ui:search-container-column-text name="dashboard.reqsListHead.status" property="status" />
					<liferay-ui:search-container-column-text name="Actions">
						<div id="tab-action" style="width:90px;">
							<liferay-ui:icon-menu showExpanded="false" showWhenSingleIcon="true">
								<portlet:renderURL var="viewPGCFormUrl">
									  	<portlet:param name="appAction" value="editPGCForm" />
										<portlet:param name="requestId" value="${dashBoardDO.requestId}" />
										<portlet:param name="objectId" value="${dashBoardDO.objectId}" />
										<portlet:param name="typeName" value="${dashBoardDO.formType}" />	
										<portlet:param name="mode" value="viewMode" />													
									</portlet:renderURL>
								<liferay-ui:icon image="view" message="view" url="<%=viewPGCFormUrl %>" />
								<%-- DSI:START::Veera Reddy:: To pass the object name while editing the record --%>
								<c:if test="<%= PGCCommonUtil.isStatusEdit(dashBoardDO.getStatus(), dashBoardDO.getFormType()) %>">
									<portlet:renderURL var="editPGCFormUrl">
									  	<portlet:param name="appAction" value="editPGCForm" />
										<portlet:param name="requestId" value="${dashBoardDO.requestId}" />
										<portlet:param name="objectId" value="${dashBoardDO.objectId}" />
										<portlet:param name="typeName" value="${dashBoardDO.formType}" />
										<portlet:param name="objectName" value="${dashBoardDO.requestTitle}" />
										<portlet:param name="mode" value="editMode" />		
									</portlet:renderURL>
									<liferay-ui:icon image="edit" message="Edit" url="<%= editPGCFormUrl %>" />
									<%-- DSI:END::Veera Reddy:: To pass the object name while editing the record --%>
								</c:if>
							</liferay-ui:icon-menu>
						</div>
					</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />	
				</liferay-ui:search-container>
			</td>
       </tr>
       <tr>
			<td class="bl"></td>
			<td></td>
			<td class="br"></td>
		</tr>
   </table>
</div>
