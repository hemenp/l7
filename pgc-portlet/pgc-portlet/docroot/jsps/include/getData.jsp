<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Resmy Mathew
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@include file="/jsps/init.jsp" %>
<%
	String query = request.getParameter("q");
	if(query!=null && query.trim().length()>2){
    	String xmlObject= PGCAutoCompleteUtil.getData(request);
       	response.setContentType("text/xml");
    	response.getWriter().println(xmlObject);
	}
%>
