<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for add workflow screen 
 *
--%>
<%@include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.dsi.intranet.eprocurement.portlet.util.WorkflowPortletUtil"%>


<portlet:renderURL var="showWorkflowScreen"></portlet:renderURL>

<portlet:renderURL var="createNewWorkflowURL">
	<portlet:param name="myActions" value="showNewWorkflowScreen"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="createWorkflowURL">
	<portlet:param name="myActions" value="saveNewWorkflow"/>
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
</portlet:actionURL>
<%
	String userAgent = request.getHeader("User-Agent");
	boolean isIpadBrowser = userAgent!=null && userAgent.toLowerCase().indexOf("ipad")!=-1;
%>
    <form name="workflowFm" id="workflowFm" method="post">
	<div id="cntr_contentCentral_two" class="main_heading">
		<c:if test="${not empty param.error}">
		    <span class="portlet-msg-error">		
			<c:out value="${param.error}"/>
			</span>	
		</c:if>
		<span class="portlet-msg-error" id="errMsg" style="display: none;"></span>
        <h3><liferay-ui:message key="wf.add"/></h3>
      </div>
      <div style="float:right; padding-right:11px"><a href="<%=showWorkflowScreen %>" class="newlink-button"><< <liferay-ui:message key="wf.back"/></a></div>
      <div class="group-list-content">
        <div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">
        	<input type="hidden" name="companyId" id="companyId" value="<%=themeDisplay.getCompanyId() %>" />
        	<input type="hidden" name="data" id="data" value="workflow" />
        	<input type="hidden" name="userId" id="userId" value="" />
        	<input type="hidden" name="jobTitle" id="jobTitle" value="" />
        	<input type="hidden" name="approverIds" id="approverIds" value="" />
        	<input type="hidden" name="redirectURL" id="redirectURL" value="<%=showWorkflowScreen %>"/>
        	<input type="hidden" name="redirectToEditPage" id="redirectToEditPage" value="<%=createNewWorkflowURL %>"/>
          <table class="round-corners">
            <tbody>
              <tr>
                <td class="tl">&nbsp;</td>
                <td>&nbsp;</td>
                <td class="tr">&nbsp;&nbsp;&nbsp;</td>
              </tr>
              <tr>
                <td colspan="3" style="padding: 0pt 10px;" class="form-content">
                <table class="" border="0" cellpadding="0" cellspacing="0" width="450">
                            <tbody>
                              <tr>
                                <td class="label" style="padding-left:0px;  width:40% "  ><liferay-ui:message key="wf.name"/><span class="red_star">*</span></td>
                                <td  style="width:60%" ><input type="text" name="workflowName" id="workflowName" value="<c:out value='${param.workflowName}'/>" class="text-field"  style="width: 169px" maxlength="60"/></td>
                                <td  >&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="label" style="padding-left:0px;  width:40% "  ><liferay-ui:message key="wf.select.users"/><span class="red_star">*</span></td>
                                <td  style="width:60%" ><input type="text" name="eprocureUser" id="eprocureUser" class="text-field" style="width: 169px" onKeyPress="resetUserVal()"/>
                                </td>
                                <td  >&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="label" style="padding-left:0px;  width:40% "  >&nbsp;</td>
                                <td  style="width:60%" >
                                  <input value='<liferay-ui:message key="wf.add.user"/>' class="button input-button-add width100 rhtmargin" type="button" onclick="addEprocureUsers()" />
                                  <input value='<liferay-ui:message key="wf.remove.user"/>' class="button input-button-remove width125" type="button" onclick="removeSelectedUsers()"/>
                                 </td>
                                <td >&nbsp;</td>
                              </tr>
                              <tr>
                                <td  style="padding-left:0px;  width:40% "  >&nbsp;</td>
                                <td class="form-item topalign">
                                <c:if test="${not empty param.workflowStages}">
                                <c:set var="workflowStages" value="${param.workflowStages}"/>
                                <%
                                	String workflowStages = (String)pageContext.getAttribute("workflowStages");
	                                List<Long> approversIdList = WorkflowPortletUtil.getApproverIdList(workflowStages);
	                                LinkedHashMap<Long, String> approverIdNameMap = WorkflowPortletUtil
	                                        .getApproversNameMap(approversIdList);
	                                pageContext.setAttribute("approverIdNameMap", approverIdNameMap);
                                %>
                                </c:if>
                                <select name="selectedUsers" id="selectedUsers" size="10" style="font-size: 11px; width: 282px; vertical-align: top;">
                                	<c:forEach var="approverIdNameMap" items="${approverIdNameMap}">
	                                	<option value="${approverIdNameMap.key}">${approverIdNameMap.value}</option>
							  		</c:forEach>
                                </select>
                                <% if(isIpadBrowser) 
					   			{ %>
									<ul id="selectedUsersIpadDiv"></ul>
								<% } %>
                                  <input value='<liferay-ui:message key="wf.create"/>' class="button input-button topmargin" type="button" style="margin-top:10px; height:26px;" onclick="submitWorkflowPage('<%=createWorkflowURL%>');"/>
                                </td>
                                <% if(!isIpadBrowser) 
					   			{ %>
                                <td class="form-item">
	                                <a href="javascript:Liferay.Util.reorder(document.getElementById('selectedUsers'), 1);">
	                                	<img src="/o/e-procurement-portlet/images/misc_23.png" />
	                                </a>
		                          	<br />
		                          	<a href="javascript:Liferay.Util.reorder(document.getElementById('selectedUsers'), 0);">
		                          		<img src="/o/e-procurement-portlet/images/misc_25.png" class="topmargin" />
		                          	</a>
	                          	</td>
								<% } %>
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
            </tbody>
          </table>
          <br />
        </div>
      </div>
      </form>
