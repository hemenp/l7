<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import ="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@page import ="com.dsi.intranet.eprocurement.model.EprocurementLocation" %>
<%@ page import="com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil" %>
<%@ page import="com.dsi.intranet.eprocurement.model.EprocurementRequest" %>
<%@ page import ="com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil" %>
<%@ page import ="com.dsi.intranet.eprocurement.model.Item" %>
<%@ page import ="com.dsi.intranet.eprocurement.model.EprocurementRequest" %>
<%@ page import="com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil" %>
<%@ page import="com.dsi.intranet.eprocurement.portlet.util.EprocurementCommonUtil" %>
<%@ page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementPermissionUtil" %>
<!--  import for upload -->
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.taglib.portlet.NamespaceTag"%>

<%
	String defaultRequestColumns = "RequestId,Requestor,RequestDate,Status,WorkFlow,Action";
	String[] arrayRequestColumns = defaultRequestColumns.split(",");
	
	int defaultRequestDashboardDelta = 10;
%>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ui.datepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jqModal.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/eprocure-autopick.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath()%>/js/emailRequestor-validation.js"></script>
<script  type="text/javascript" src="<%=request.getContextPath()%>/js/request-validation.js?ver=2"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.MetaData.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.MultiFile.js"></script>

<link href="<%=request.getContextPath()%>/css/datepicker-custom.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />	
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jqModal.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/edir_style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/form-page.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/news.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/edir_style.css" />

