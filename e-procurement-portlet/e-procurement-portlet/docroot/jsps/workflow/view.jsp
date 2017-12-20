<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for Workflow DashBoard screen 
 *
--%>

<%@include file="../init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.bean.WorkflowDataObject"%>

<portlet:renderURL var="createNewWorkflowURL">
	<portlet:param name="myActions" value="showNewWorkflowScreen"></portlet:param>
</portlet:renderURL>
		<div id="cntr_contentCentral_two" class="main_heading">
			<c:forEach var="error" items="${errors}">
				<span class="portlet-msg-error">		
				<c:out value="${error}"/>
				</span>	
			</c:forEach> 
			<c:if test="${not empty param.success}">
			    <span class="portlet-msg-success">
					<c:out value="${param.success}"/>
				</span>	
			</c:if>
			<c:if test="${not empty success}">
			    <span class="portlet-msg-success">
					<c:out value="${success}"/>
				</span>	
			</c:if>
	        <h3><liferay-ui:message key="wf.heading"/></h3>
	    </div>
      	<div class="group-list-content">
   		<div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">

		<div style="padding-bottom:12px; float: left;">
			<a href='<%= createNewWorkflowURL %>' class="newlink-button"><liferay-ui:message key="wf.add"/></a>
		</div>

	  	<table class="round-corners">
          <tr>
            <td class="tl">&nbsp;</td>
            <td>&nbsp;</td>
            <td class="tr">&nbsp;&nbsp;&nbsp;</td>
          </tr>
		  <tr>
            <td colspan="3" style="padding:0 10px" >
            	<div>
					<liferay-ui:search-paginator searchContainer='<%=(SearchContainer)renderRequest.getAttribute("workflowSearchContainer")%>'/>
				</div>	
				<table cellspacing="0" cellpadding="0" border="0" class="search-result-table trselectCls" style="width: 100%">
					<thead>
						<tr class="bgcolor3">
							<th width="125" class="mgr header width100"><liferay-ui:message key="wf.name"/></th>
							<th  class="mgr header" ><liferay-ui:message key="wf.approvers"/></th>
							<th class="header width70"><liferay-ui:message key="req.dashboard.action"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="workflowDataObject" items="${workflowDataObjectList}">
							<tr class="bgcolor1">
								<td class="note">
									<c:out value="${workflowDataObject.workflowName}" />
								</td>
								<td class="note"> 
									<c:out value="${workflowDataObject.approvers}" />.
								</td>	
								<td class="note">
									<liferay-ui:icon-menu>
											<portlet:renderURL var="showEditWorkflowScreen">
												<portlet:param name="myActions" value="showEditWorkflowScreen"/>
												<portlet:param name="workflowDefinitionId" value="${workflowDataObject.workflowDefinitionID}" />
											</portlet:renderURL>
									
											<liferay-ui:icon image="edit" url="<%=showEditWorkflowScreen.toString() %>" />
									
											<portlet:renderURL var="deleteWorkflowURL">
												<portlet:param name="myActions" value="deleteWorkflow"/>
												<portlet:param name="workflowDefinitionId" value="${workflowDataObject.workflowDefinitionID}" />
											</portlet:renderURL>
											
											<liferay-ui:icon-delete url="<%=deleteWorkflowURL.toString() %>" />
									</liferay-ui:icon-menu>
								</td>
							</tr>
						</c:forEach>
					</tbody>		
				</table>
				<div>
					<liferay-ui:search-paginator searchContainer='<%=(SearchContainer)renderRequest.getAttribute("workflowSearchContainer")%>'/>
				</div>	
			</td>
          </tr>
          <tr>
            <td class="bl"></td>
            <td></td>
            <td class="br"></td>
          </tr>
        </table>
		<br />
		<br />
		</div>
      </div>
