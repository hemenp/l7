<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %> 
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.util.Map,java.util.Iterator" %>
<%@ page import="com.dsi.intranet.eprocurement.portlet.bean.DashboardBean"%>

<%@ page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil"%>
<%@ page import="com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
	ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	DashboardBean dashboardObj = (DashboardBean)resultRow.getObject();
	String viewEditURL = EProcurementUtil.createEditRequestURL(renderRequest, themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT, dashboardObj.getRequestId());
	String strToolTip = EProcurementUtil.createToolTip(dashboardObj.getRequestId());
	%>
	<a href="<%=viewEditURL%>" title="<%= strToolTip %>"><%=dashboardObj.getRequestId()%></a> 
