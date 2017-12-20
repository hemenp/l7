<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %> 
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.dsi.intranet.eprocurement.portlet.bean.DashboardBean"%>

<%@ page import="java.util.Map" %>
<%@page import="com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementPermissionUtil"%>

<%@page import="com.dsi.intranet.eprocurement.model.EprocurementRequest"%>
<%@page import="com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	DashboardBean dashboardObj = (DashboardBean)resultRow.getObject();
	EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(dashboardObj.getRequestId());
%>

<portlet:renderURL var="viewCancelURL">
	<portlet:param name="cmd" value="CANCEL"/>
		 <portlet:param name="resourcePrimKey" value="<%= String.valueOf(dashboardObj.getRequestId()) %>" />
</portlet:renderURL>
<%
	// userAttributes = EProcurementPermissionUtil.getUserAttributes(themeDisplay.getCompanyId(), themeDisplay.getUserId(), eprocRequest.getRequestId());
	String viewEditURL = EProcurementUtil.createEditRequestURL(renderRequest, themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT, dashboardObj.getRequestId());
%>

<liferay-ui:icon-menu>
	<c:choose>
		<c:when test="<%= EProcurementPermissionUtil.showCancelRequestLink(themeDisplay.getCompanyId(), themeDisplay.getUserId(), eprocRequest) %>" >
			<liferay-ui:icon image="edit" url="<%= viewEditURL %>" />
			<%

				String jfunction="javascript:onCancel('"+viewCancelURL+"')";
			%>
			<liferay-ui:icon image="edit" url="<%= jfunction %>" message="Cancel" />
		</c:when>
		<c:otherwise>
			<liferay-ui:icon image="edit" url="<%= viewEditURL %>" />
		</c:otherwise>
	</c:choose>
</liferay-ui:icon-menu>

	
