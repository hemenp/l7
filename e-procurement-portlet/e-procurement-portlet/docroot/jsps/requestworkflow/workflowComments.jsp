<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Jay Patel
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>


<%@page import="com.dsi.intranet.eprocurement.model.EprocurementRequest"%>
<%@page import="com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil"%><table class="round-corners">
	<tbody>
		<tr>
			<td class="tl">&nbsp;</td>
			<td>&nbsp;</td>
			<td class="tr">&nbsp;&nbsp;&nbsp;</td>
        </tr>
		<tr>
			<td class="form-content" style="padding: 0pt 10px;" colspan="3">
				<table border="0" class="search-result-table">
					<tbody>
						<tr width="60%" class="alt">
                      		<th colspan="7" class="common_header_other"> Table of request entries: <a href="<c:out value="${editRequestURL}" />"><liferay-ui:message key="wf.cmnts.req.details"></liferay-ui:message></a></th>
						</tr>
						<tr>
                      		<th width="100" class="common_header_other"><liferay-ui:message key="wf.cmnts.date.time"></liferay-ui:message></th>
                      		<th width="100" class="common_header_other"><liferay-ui:message key="wf.cmnts.status"></liferay-ui:message></th>
                      		<!--  <th width="100" class="common_header_other">Role</th> -->
                      		<th width="100" class="common_header_other width150"><liferay-ui:message key="wf.cmnts.approver"></liferay-ui:message></th>
                      		<th width="200" class="common_header_other"><liferay-ui:message key="wf.approver.comments"></liferay-ui:message></th>
                      		<th width="150" class="common_header_other"><liferay-ui:message key="wf.email.cmnts"></liferay-ui:message></th>
						</tr>
						<c:forEach items="${listCustomWFReview}" var="wfReview" varStatus="ctr">
							<tr class="${ctr.index % 2 == 0 ? 'bgcolor1 alt' : 'bgcolor2'}">
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedDate}" /></td>
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedToStatus}" /></td>
	                      		<!--  <td class="cr_table_detail">&nbsp;</td> -->
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedByName}" /></td>
	                      		<td class="cr_table_detail"><c:out value="${wfReview.approverComments}" /></td>
	                      		<td width="250" class="cr_table_detail"><c:out value="${wfReview.emailComments}" /></td>
	                    	</tr>
						</c:forEach>
					</tbody>
				</table>
                <br>
                <a href="<c:out value="${editRequestURL}" />"><liferay-ui:message key="wf.cmnts.req.details"></liferay-ui:message></a>
                &nbsp;&nbsp;
               
				<% 
				
				if(request.getAttribute("requestId")!= null)
				{
						String strRequestId = request.getAttribute("requestId").toString();
						EprocurementRequest eProcrequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(new Long(strRequestId));
						String requestStatus = eProcrequest.getStatus();
					if(requestStatus!=null)		    
					{
				%>
				|&nbsp;&nbsp;
				<a href='<portlet:renderURL>
					<portlet:param name="eProcAction" value="showFollowUpNotInStockDetails"/>
					<portlet:param name="requestId" value="${requestId}"/>
				</portlet:renderURL>' ><liferay-ui:message key="folloup.link.name"></liferay-ui:message></a>
				<%
					}
				}
				
				%>
			</td>
		</tr>
		<tr>
			<td class="bl"></td>
			<td></td>
			<td class="br"></td>
		</tr>
	</tbody>
</table>