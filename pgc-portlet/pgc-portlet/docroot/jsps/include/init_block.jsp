<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>

<%@include file="/jsps/init.jsp" %>
<%@page import="javax.portlet.WindowState"%>

<portlet:resourceURL var="viewFile" id="viewDocument" escapeXml="false">
	<portlet:param name="appAction" value=""/>
</portlet:resourceURL>

<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="deleteFile">
	<portlet:param name="appAction" value="deleteAttachment" />
	<portlet:param name="objectId" value="${OBJECTID}" />
	<portlet:param name="requestId" value="${requestId}" />
	<portlet:param name="typeName" value="${typeName}" />
</portlet:actionURL>