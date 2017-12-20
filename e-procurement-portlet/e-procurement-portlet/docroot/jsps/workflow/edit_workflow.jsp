<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for edit workflow screen 
 *
--%>
<%@include file="../init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<portlet:renderURL var="showWorkflowScreen"></portlet:renderURL>

<portlet:actionURL var="updateWorkflowURL">
	<portlet:param name="myActions" value="saveNewWorkflow"/>
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
</portlet:actionURL>
<%
	String userAgent = request.getHeader("User-Agent");
	boolean isIpadBrowser = userAgent!=null && userAgent.toLowerCase().indexOf("ipad")!=-1;
%>
    <form name="workflowFm" id="workflowFm" method="post">
	<div id="cntr_contentCentral_two" class="main_heading">
	  <div class="portlet-msg-error" id="errMsg" style="display: none;"></div>
        <h3><liferay-ui:message key="wf.edit"/></h3>
      </div>
      <div style="float:right; padding-right:11px"><a href="<%=showWorkflowScreen %>" class="newlink-button"><< <liferay-ui:message key="wf.back"/></a></div>
      <div class="group-list-content">
        <div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">
        	<input type="hidden" name="companyId" id="companyId" value="<%=themeDisplay.getCompanyId() %>" />
        	<input type="hidden" name="data" id="data" value="workflow" />
        	<input type="hidden" name="workflowDefinitionId" value="<c:out value='${workflowDefinitionId}' />" />
        	<input type="hidden" name="userId" id="userId" value="" />
        	<input type="hidden" name="jobTitle" id="jobTitle" value="" />
        	<input type="hidden" name="approverIds" id="approverIds" value="" />
        	<input type="hidden" name="redirectURL" id="redirectURL" value="<%=showWorkflowScreen %>"/>
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
                                <td class="label" style="padding-left:0px;  width:40% " ><liferay-ui:message key="wf.name"/><span class="red_star">*</span></td>
                                <td  style="width:60%" ><input type="text" name="workflowName" id="workflowName" value="<c:out value='${workflowName}' />" class="text-field" maxlength="60" style="width: 169px" /></td>
                                <td  >&nbsp;</td>
                              </tr>
                              <tr>
                                <td class="label" style="padding-left:0px;  width:40% "  ><liferay-ui:message key="wf.select.users"/><span class="red_star">*</span></td>
                                <td  style="width:60%" ><input type="text" name="eprocureUser" id="eprocureUser" class="text-field" style="width: 169px" onKeyPress="resetUserVal()"/></td>
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
                                <select name="selectedUsers" id="selectedUsers" size="10" style="font-size: 11px; width: 282px; vertical-align: top;">
	                                <c:forEach var="approverIdNameMap" items="${approverIdNameMap}">
	                                	<option value="${approverIdNameMap.key}">${approverIdNameMap.value}</option>
							  		</c:forEach>
                                </select>
                                 <% if(isIpadBrowser) 
					   			{ %>
									<ul id="selectedUsersIpadDiv"></ul>
								<% } %>
                                  <input value='<liferay-ui:message key="wf.update"/>' class="button input-button topmargin" type="button" style="margin-top:10px; height:26px;" onclick="submitWorkflowPage('<%=updateWorkflowURL%>');"/>
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
