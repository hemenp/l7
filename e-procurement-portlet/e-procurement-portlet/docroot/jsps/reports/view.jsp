<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for reports view screen
 *
--%>
<%@include file="../init.jsp" %>

<portlet:renderURL var="showEprocureReportsURL">
	<portlet:param name="myActions" value="showEprocurementReports"></portlet:param>	
</portlet:renderURL>
	<div id="cntr_contentCentral_two" class="main_heading">
    	<h3><liferay-ui:message key="eprocure.reports.menu"/></h3>
    </div>
    <div class="group-list-content">
	   	<div id="cntr_contentOneCol" style="float: none;   margin: 0pt auto;   padding:0;  width: auto;">
			<table class="round-corners">
			    <tr>
				    <td class="tl">&nbsp;</td>
				    <td>&nbsp;</td>
				    <td class="tr">&nbsp;&nbsp;&nbsp;</td>
			    </tr>
				<tr>
					<td colspan="3" style="padding:0 10px" >
						<table class="search-result-table" cellpadding="0" cellspacing="0" >
							<tbody>
								<tr>
									<th align="Center" style="width:80px; text-align:center;">
									<strong><liferay-ui:message key="eprocure.menu.number"/></strong>
									</th>
									<th>
										<strong><liferay-ui:message key="eprocure.reports.title"/></strong>
									</th>
								</tr>
								<tr class="bgcolor2">
									<td align="Center"><liferay-ui:message key="eprocure.phase"/></td>
									<td><a href='<%= showEprocureReportsURL %>' style="text-decoration: none;"><liferay-ui:message key="eprocure.reports"/></a></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td class="bl"></td>
					<td></td>
					<td class="br"></td>
				</tr>
			</table>
			<br />
		</div>
	</div>
