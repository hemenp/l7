<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for workflow actions link 
 *
--%>
<%@include file="../init.jsp" %>
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
WorkflowDataObject workflowDataObject = (WorkflowDataObject)row.getObject();

%>


<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.dsi.intranet.eprocurement.model.WorkflowDefinition"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.bean.WorkflowDataObject"%>

<liferay-ui:icon-menu>

		<portlet:renderURL var="showEditWorkflowScreen">
			<portlet:param name="myActions" value="showEditWorkflowScreen"/>
			<portlet:param name="workflowDefinitionId" value="<%=String.valueOf(workflowDataObject.getWorkflowDefinitionID()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=showEditWorkflowScreen.toString() %>" />

		<portlet:renderURL var="deleteWorkflowURL">
			<portlet:param name="myActions" value="deleteWorkflow"/>
			<portlet:param name="workflowDefinitionId" value="<%=String.valueOf(workflowDataObject.getWorkflowDefinitionID()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="delete" url="<%=deleteWorkflowURL.toString() %>" />
</liferay-ui:icon-menu>