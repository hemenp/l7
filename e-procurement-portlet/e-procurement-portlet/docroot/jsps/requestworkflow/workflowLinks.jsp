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
	if(EProcurementUtil.isWebAdmin(themeDisplay.getCompanyId(), themeDisplay.getUserId()))
	{
		String strRequestId = "";
		if(request.getAttribute("requestIdDashboard") != null && 
				EProcurementUtil.isNotNullNonEmptyString(request.getAttribute("requestIdDashboard").toString()))
		{
			strRequestId = request.getAttribute("requestIdDashboard").toString();
			EprocurementRequest eProcrequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(new Long(strRequestId));
			String requestStatus = eProcrequest.getStatus();
%>


<%@page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>


<a href='<portlet:renderURL>
			<portlet:param name="cmd" value="showRequestWFDetails"/>
			<portlet:param name="requestId" value="<%= strRequestId%>"/>
		</portlet:renderURL>' >View WorkFlow</a>
		
&nbsp;


<%
		if(requestStatus!=null)		    
		{
%>
| &nbsp;
<a href='<portlet:renderURL>
			<portlet:param name="eProcAction" value="showFollowUpNotInStockDetails"/>
			<portlet:param name="requestId" value="<%= strRequestId%>"/>
		</portlet:renderURL>' >FollowUp In-stock/Not In-stock</a>


<%
	}
		}
	}
%>