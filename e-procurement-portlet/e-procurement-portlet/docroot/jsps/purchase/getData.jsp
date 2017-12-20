
<%@include file="../init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.util.EprocureAutoCompleteUtil"%>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.Set,java.util.TreeSet"%>

<%
	String query = request.getParameter("q");
	if(query!=null && query.trim().length()>2){
    	String xmlObject= EprocureAutoCompleteUtil.getData(request);
    	response.setContentType("text/xml");
    	response.getWriter().println(xmlObject);
	}
%>
