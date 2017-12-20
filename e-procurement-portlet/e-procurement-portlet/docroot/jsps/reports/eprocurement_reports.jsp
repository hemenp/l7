<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Devaki Subramaniam
 * @description This page is responsible for reports search screen 
 *
--%>

<%@include file="../init.jsp" %>
<%@page import="com.dsi.intranet.eprocurement.portlet.bean.EprocurementReportDataObject"%>

<portlet:resourceURL var="exportToExcel" id="executeExportToExcel" escapeXml="false"/>
<script>

function validation(select){
	var contractId=document.forms['<portlet:namespace />eprocurementReports'].contractId.value.length;
	var eprocureUser=document.forms['<portlet:namespace />eprocurementReports'].eprocureUser.value.length;
	var userId=document.forms['<portlet:namespace />eprocurementReports'].userId.value.length;
	var requestId=document.forms['<portlet:namespace />eprocurementReports'].requestId.value.length;
	var PONumber=document.forms['<portlet:namespace />eprocurementReports'].PONumber.value.length;
	var itemNameDesc=document.forms['<portlet:namespace />eprocurementReports'].itemNameDesc.value.length;
	var searchStartDate=document.forms['<portlet:namespace />eprocurementReports'].searchStartDate.value.length;
	var address=document.forms['<portlet:namespace />eprocurementReports'].address.value;
	var status=document.forms['<portlet:namespace />eprocurementReports'].status.value;
	var vendorName=document.forms['<portlet:namespace />eprocurementReports'].vendorName.value.length;
	//var stageUserId=document.forms['<portlet:namespace />eprocurementReports'].stageUserId.value.length;
	//var stageUser=document.forms['<portlet:namespace />eprocurementReports'].stageUser.value.length;
	if(address!=select || status!=select || contractId>=1|| eprocureUser>=1|| requestId>=1|| PONumber>=1|| itemNameDesc>=1|| searchStartDate>=1|| vendorName>=1){
		if(eprocureUser>=1&& userId<1){
			str="Please select requestor name from auto pick list.";
			alert(str);
		}else{
			submitEprocureReportsForm();
		}
	}
	else{
		str="Please enter atleast one value !";
		alert(str); 
		}
	}

function submitEprocureReportsForm()
{
	document.<portlet:namespace />eprocurementReports.action = '<portlet:renderURL><portlet:param name="myActions" value="searchEprocurementReports"/></portlet:renderURL>';
	document.<portlet:namespace />eprocurementReports.submit();
}

function resetRequestorVal() {
	 var userId=document.getElementById('userId').value.trim();
     if(userId !=""){
    	 document.getElementById('userId').value = "";
     }
}

function resetStageUserVal() {
	 var stageUserId=document.getElementById('stageUserId').value.trim();
    if(stageUserId !=""){
   	 document.getElementById('stageUserId').value = "";
    }
}

$(function() {
    $("#searchStartDate").datepicker({
          showOn: 'button',
          buttonImage: '/e-procurement-portlet/images/cal-icon.jpg',
          buttonImageOnly: true,
          dateFormat: 'mm/dd/yy',	              
          buttonText: 'select date'     
    });

    $("#searchEndDate").datepicker({
        showOn: 'button',
        buttonImage: '/e-procurement-portlet/images/cal-icon.jpg',
        buttonImageOnly: true,
        dateFormat: 'mm/dd/yy',	              
        buttonText: 'select date',
       	minDate: new Date(jQuery('#searchStartDate').val()) 
  });  



    $('#searchStartDate').change(function () {

		jQuery( "#searchEndDate" ).datepicker( "destroy" );
		jQuery( "#searchEndDate" ).val(jQuery('#searchStartDate').val());
		jQuery( "#searchEndDate" ).datepicker({
			showOn: 'button',
         	buttonImage: '/temp-hire-portlet/images/cal-icon.jpg',
         	buttonImageOnly: true,
         	dateFormat: 'mm/dd/yy',
         	buttonText: 'select date',
			minDate: new Date(jQuery('#searchStartDate').val())      			
		});	
	});

    $("form").bind("keypress", function(e) {		
    	if (e.keyCode == 13){
    		validation('<%=EProcurementConstants.PARAM_VALUE_SELECT %>');
		}
    });
});
		
</script>

<div id="cntr_contentCentral_two" class="main_heading">
<h3><liferay-ui:message key="eprocure.reports"/></h3>
</div>

<div class="group-list-content">
<div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">

	<table class="round-corners" border="0">
		<tbody>
			<tr>
				<td class="tl">&nbsp;</td>
				<td>&nbsp;</td>
				<td class="tr">&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3" style="padding: 0pt 10px;">
					<form name="<portlet:namespace />eprocurementReports" method="post">
						<input type="hidden" name="companyId" id="companyId" value="<%=themeDisplay.getCompanyId() %>" />
						<input type="hidden" name="userId" id="userId" value="" />	
						<input type="hidden" name="data" id="data" value="alluser" />
						<input type="hidden" name="vendor" id="vendor" value="vendor" />
						<input type="hidden" name="vendorEmail" id="vendorEmail" value="" />
						<input type="hidden" name="vendorCode" id="vendorCode" value="" />
						<input type="hidden" name="stageUserId" id="stageUserId" value="" />
						<input type="hidden" name="stagedata" id="stagedata" value="webadmin" />
			        							
						<%
			            	if(request.getAttribute("curUserId") != null && !("").equalsIgnoreCase(request.getAttribute("curUserId").toString())){
			            %>
			            <script type="text/javascript">
			            	document.getElementById("userId").value = '<%= request.getAttribute("curUserId").toString() %>';
			            </script>
			            <%} %>
			            
			            <%
			            	if(request.getAttribute("curStageUserId") != null && !("").equalsIgnoreCase(request.getAttribute("curStageUserId").toString())){
			            %>
			            <script type="text/javascript">
			            	document.getElementById("stageUserId").value = '<%= request.getAttribute("curStageUserId").toString() %>';
			            </script>
			            <%} %>
						<table class="form-content" border="0" width="100%">
							<tbody>
								<tr>
									<td class="label"><liferay-ui:message key="eprocure.reports.requestor.name"/></td>
									<td  width="125" class="form-item">
									<input type="text" name="eprocureUser" id="eprocureUser" style="width: 155px;" onkeyup="resetRequestorVal();"/>
									</td>
									<td class="label"><liferay-ui:message key="eprocure.reports.contract.id"/></td>
									<td width="125"><input style="width: 155px;" name="contractId" id="contractId" type="text" value=""/></td>
									<%
						            	if(request.getAttribute("curRequestorName") != null && !("").equalsIgnoreCase(request.getAttribute("curRequestorName").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("eprocureUser").value = '<%= request.getAttribute("curRequestorName").toString() %>';
						            </script>
						            <%} if(request.getAttribute("curContractId") != null && !("").equalsIgnoreCase(request.getAttribute("curContractId").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("contractId").value = '<%= request.getAttribute("curContractId").toString() %>';
						            </script>
						            <%} %>
								</tr>
								<tr>
									<td width="125" class="label"><liferay-ui:message key="eprocure.reports.request.id"/></td>
									<td width="125"> <input style="width: 155px;" name="requestId" id="requestId" type="text" value=""/></td>
									<td width="125" class="label"><liferay-ui:message key="eprocure.reports.po.number"/></td>
									<td width="125"> <input style="width: 155px;" name="PONumber" id="PONumber" type="text" value=""/></td>
									<%
						            	if(request.getAttribute("curRequestId") != null && !("").equalsIgnoreCase(request.getAttribute("curRequestId").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("requestId").value = '<%= request.getAttribute("curRequestId").toString() %>';
						            </script>
						            <%} if(request.getAttribute("curPONumber") != null && !("").equalsIgnoreCase(request.getAttribute("curPONumber").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("PONumber").value = '<%= request.getAttribute("curPONumber").toString() %>';
						            </script>
						            <%} %>
								</tr>
								<tr>
									<td width="125" class="label"><liferay-ui:message key="eprocure.reports.vendor"/></td>
									<td width="125">
										<input type="text" name="vendorName" id="vendorName" value="" style="width: 155px;" />
									</td>
									<td align="left" class="label" style="vertical-align:top"><liferay-ui:message key="eprocure.reports.shipto.location"/></td>
									<td width="125">
							            <select name="address" id="address" style="width: 160px; _font-size:11px !important;">
							            	<option value="<%=EProcurementConstants.PARAM_VALUE_SELECT %>"><%=EProcurementConstants.PARAM_VALUE_SELECT %></option>
							            	<c:forEach items="${shipToAddresses}" var="address">
												<option value="<c:out value="${address.address}" />"><c:out value="${address.address}" /></option>
							            	</c:forEach>
							            	<option value="<%=EProcurementConstants.SHIP_TO_OTHER_PARAM %>"><%=EProcurementConstants.SHIP_TO_OTHER_PARAM %></option>
							            </select>
									</td>
									<%
						            	if(request.getAttribute("curVendorName") != null && !("").equalsIgnoreCase(request.getAttribute("curVendorName").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("vendorName").value = "<%= request.getAttribute("curVendorName").toString() %>";
						            </script>
						            <%} if(request.getAttribute("curAddress") != null && !("").equalsIgnoreCase(request.getAttribute("curAddress").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("address").value = '<%= request.getAttribute("curAddress").toString() %>';
						            </script>
						            <%} %>
								</tr>
								<tr> 
									<td align="left" class="label"><liferay-ui:message key="req.dashboard.status"/></td>
									<td align="left" width="125"> 
										<select id="status" style="width: 160px; _font-size:11px !important;" name="status" id="status" >
							            <option value="<%=EProcurementConstants.PARAM_VALUE_SELECT %>"><%=EProcurementConstants.PARAM_VALUE_SELECT %></option>
							            	<c:forEach items='${listStatus}' var='status'>
							            		<option value="<c:out value='${status}' />" ><c:out value='${status}' /></option>
							            	</c:forEach>
							            </select>
							            <%
							            	if(request.getAttribute("curStatus") != null && !("").equalsIgnoreCase(request.getAttribute("curStatus").toString())){
							            %>
							            <script type="text/javascript">
							            	document.getElementById("status").value = '<%= request.getAttribute("curStatus").toString() %>';
							            </script>
							            <%
							            	}
							            %>
									</td> 
									<td style="padding:0px;position:absolute;" id="lastWorkflowUser" colspan="2">
										<table>
											<tbody>
										  		<tr>
										  			<td width="125" align="left" style="width:163px;" class="label"><liferay-ui:message key="req.dashboard.last.workflow.assigner"/></td>
										    		<td width="125" align="right"><input type="text" name="stageUser" id="stageUser" style="width: 155px;" onkeyup="resetStageUserVal();"/></td>
										    	</tr>
										  </tbody>
										</table>
									</td>
									<%-- <td align="left" colspan="2" id="lastWorkflowUser" class="label">
									<liferay-ui:message key="req.dashboard.last.workflow.assigner"/>
									<input type="text" name="stageUser" id="stageUser" style="width: 155px;" onkeyup="resetStageUserVal();"/>
									</td>  --%>
									<%
						            	if(request.getAttribute("curStageUserName") != null && !("").equalsIgnoreCase(request.getAttribute("curStageUserName").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("stageUser").value = '<%= request.getAttribute("curStageUserName").toString() %>';
						            </script>
						            <%}%>
									<!-- <td align="left">&nbsp;</td>  -->
								</tr>
								<tr>
									<td colspan="2" class="label" align="left" style="width: 450px;"><liferay-ui:message key="eprocure.reports.item"/></td>
									<td align="left"> <input name="itemNameDesc" id="itemNameDesc" style="width: 155px;" type="text" value=""/> </td>
									<td align="left" >&nbsp;</td>
									<%
						            	if(request.getAttribute("curItemNameDesc") != null && !("").equalsIgnoreCase(request.getAttribute("curItemNameDesc").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("itemNameDesc").value = '<%= request.getAttribute("curItemNameDesc").toString() %>';
						            </script>
						            <%}%>
								</tr>
								<tr>
									<td class="label"><liferay-ui:message key="eprocure.reports.date.from"/></td>
									<td> 
										<label><input class="text-field" name="searchStartDate" id="searchStartDate" style="margin-right: 10px; width: 70px;" type="text"  readonly="readonly"></label>
									</td>
									<%
						            	if(request.getAttribute("curStartDate") != null && !("").equalsIgnoreCase(request.getAttribute("curStartDate").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("searchStartDate").value = '<%= request.getAttribute("curStartDate").toString() %>';
						            </script>
						            <%
						            	}
						            %>
									<td colspan="2"> <liferay-ui:message key="eprocure.reports.date.to"/>&nbsp;&nbsp; 
										<label><input class="text-field" name="searchEndDate" id="searchEndDate" style="margin-right: 10px; width: 70px;" type="text" readonly="readonly"></label> 
									</td>
									<%
						            	if(request.getAttribute("curEndDate") != null && !("").equalsIgnoreCase(request.getAttribute("curEndDate").toString())){
						            %>
						            <script type="text/javascript">
						            	document.getElementById("searchEndDate").value = '<%= request.getAttribute("curEndDate").toString() %>';
						            </script>
						            <%
						            	}
						            %>
								</tr>
								<tr>
									<td align="left"> </td>
									<td colspan="3" align="left"><liferay-ui:message key="eprocure.reports.search.msg"/></td>
								</tr>
								<tr>
									<td></td>
									<td colspan="3">
										<input style="margin-right: 10px;" value='<liferay-ui:message key="eprocure.generate.report"/>' class="button input-button" name="RepGen" type="button" onclick="validation('<%=EProcurementConstants.PARAM_VALUE_SELECT %>');"/>
										 <c:choose>
										    <c:when test="${!empty reportsDataObjectList}">
										      <input style="margin-right: 10px;" type="button" value='<liferay-ui:message key="eprocure.reports.export"/>' class="button input-button" name="exportToExcel" onClick="exportAction();" />
										    </c:when>
										    <c:otherwise>
										      <input style="margin-right: 10px;" type="button" value='<liferay-ui:message key="eprocure.reports.export"/>' class="button input-button" name="exportToExcel" onClick="validateExportAction();" />
										    </c:otherwise>
										 </c:choose>
										<input style="margin-right: 10px;" value='<liferay-ui:message key="eprocure.reset"/>' class="button input-button" type="reset" onClick="clearFields();"/>
									</td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</form>
					<div style="height:20px; border-top:1px dotted #ccc"></div>
				
					<div>
				         <liferay-ui:search-paginator searchContainer='<%=(SearchContainer)renderRequest.getAttribute("reportsSearchContainer")%>'/>
				    </div>
				<table style="border-bottom: 0pt none;" class="search-result-table trselectCls" border="0" cellpadding="0" cellspacing="0">
				      <tbody>
				        <tr class="bgcolor3">
				          <th class="mgr"><liferay-ui:message key="eprocure.reports.request.id"/></th>
				          <th class="mgr"><liferay-ui:message key="req.dashbaord.requester"/></th>
				          <th class="mgr"><liferay-ui:message key="followup.vendor"/></th>
				          <th class="mgr"><liferay-ui:message key="followup.po.number"/></th>
				          <th class="mgr"><liferay-ui:message key="req.workflow.current.status"/></th>
				          <th class="mgr width70" align="center" ><liferay-ui:message key="eprocure.reports.request.status"/></th>
				        </tr>
						<c:if test="${!empty reportsDataObjectList}">
					        <c:forEach var="reportsDataObject" items="${reportsDataObjectList}">
					        <tr class="bgcolor1">
					          <td><a href="${reportsDataObject.requestURL}" title="<c:out value='${reportsDataObject.toolTip}' />"><c:out value="${reportsDataObject.requestId}" /></a></td>
					          <td><c:out value="${reportsDataObject.requestor}" /></td>
					          <td><c:out value="${reportsDataObject.vendor}" /></td>
					          <td><c:out value="${reportsDataObject.poNumber}" /></td>
					          <td align="center"><c:out value="${reportsDataObject.currentStatus}" /></td>
					          <td align="center">
						          <c:if test="${reportsDataObject.openOrClosed=='Open'}">
						          	<span  style="font-weight:bold; color: #0C0"><c:out value="${reportsDataObject.openOrClosed}" /></span>
						          </c:if>
						          <c:if test="${reportsDataObject.openOrClosed=='Closed'}">
						          	<span style="font-weight: bold; color: rgb(153, 153, 153);"><c:out value="${reportsDataObject.openOrClosed}" /></span>
						          </c:if>
					          </td>
					        </tr>
					        </c:forEach>
				        </c:if>
				        
				      </tbody>
				    </table>
				<div>
					<liferay-ui:search-paginator searchContainer='<%=(SearchContainer)renderRequest.getAttribute("reportsSearchContainer")%>'/>
				</div>
				</td>
			</tr>
		<tr>
		<td class="bl"></td>
		<td></td>
		<td class="br"></td>
		</tr>
		</tbody>
	</table>
</div>
</div>
<br />
<script> 
function exportAction()
{
	document.<portlet:namespace />eprocurementReports.action="<%=exportToExcel%>";
    document.<portlet:namespace />eprocurementReports.submit(); 
}

function validateExportAction()
{
	alert("There are no results to export to excel file.");
}

function clearFields(){
	document.getElementById('eprocureUser').value = "";
	document.getElementById('userId').value = "";
	document.getElementById('contractId').value = "";
	document.getElementById('requestId').value="";
	document.getElementById('PONumber').value="";
	document.getElementById('vendorName').value="";
	document.getElementById('address').value="";
	document.getElementById('itemNameDesc').value="";
	document.getElementById('status').value="";
	document.getElementById('stageUser').value = "";
	document.getElementById('stageUserId').value = "";
	jQuery("#lastWorkflowUser").hide();
	document.getElementById('searchStartDate').value="";
	document.getElementById('searchEndDate').value="";
}
jQuery(document).ready(function(){
	if(document.getElementById("status").value=="COMPLETED") {
		jQuery("#lastWorkflowUser").show();
			
	} else {
		jQuery("#lastWorkflowUser").hide();
	}
	jQuery("#status").change(function(){ 
	    if(document.getElementById("status").value=="COMPLETED") {
	    	jQuery("#lastWorkflowUser").show();
	    } else {
	    	jQuery("#lastWorkflowUser").hide();
	    	document.getElementById('stageUser').value = "";
	    	document.getElementById('stageUserId').value = "";
	    }
    });
});
</script>
