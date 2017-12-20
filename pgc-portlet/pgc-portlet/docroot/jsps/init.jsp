<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Set,java.util.TreeSet" %>

<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@page import="com.liferay.util.portlet.PortletProps"%>

<%@page import="com.dsi.intranet.pgc.portlet.util.DropDownUtil"%>
<%@page import="com.dsi.intranet.pgc.portlet.util.PGCCommonUtil"%>
<%@page import="com.dsi.intranet.pgc.portlet.model.PGCRequestSummary"%>
<%@page import="com.dsi.intranet.pgc.portlet.util.PGCAutoCompleteUtil"%>
<%@page import ="com.dsi.intranet.pgc.portlet.model.PGCForm" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<link rel="stylesheet" type="text/css" href="/o/pgc-portlet/css/jquery.datepick.css" />
<link rel="stylesheet" type="text/css" href="/o/pgc-portlet/css/pgcPortlet.css" />

<script type="text/javascript" src="/o/pgc-portlet/js/jquery.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/datepicker.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/pgc.js"></script>

<%
	String ctxPath = request.getContextPath();
	
	if (ctxPath != null && ctxPath.length() == 1) {
		ctxPath = "";
	}
%>