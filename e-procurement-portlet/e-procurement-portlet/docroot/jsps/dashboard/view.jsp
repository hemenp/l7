<%@ include file="../init.jsp" %>

<%@ page import="java.text.Format" %>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import="com.dsi.intranet.eprocurement.portlet.bean.DashboardBean"%>
<portlet:renderURL var="searchRequestURL"><portlet:param name="eProcAction" value="searchRequests"/>
</portlet:renderURL>



<%
List<EprocurementLocation> locations = (List<EprocurementLocation>)request.getAttribute("shipToAddresses");
EprocurementLocation shipToAddress=null;
String successMsg = StringPool.BLANK;
Object obj= request.getAttribute("successMessage");
if(Validator.isNotNull(obj)){
    successMsg = obj.toString();

}

%>


<script type="text/javascript">

var cancelURl;
jQuery(document).ready(function() {
	jQuery("#searchStartDate").focus();
	jQuery(".searchrequests").bind("keypress", function(e) { 
		
  	    if (e.keyCode == 13){
  	    	validation();
  	}
  	    });
});

function validation(){

	if(jQuery("#eprocureUser").val()!="" && jQuery("#userId").val()==""){
			alert("Please select the Requester Name through auto pick list");
			document.getElementById("eprocureUser").focus();
			return false;
		}else{
			if(jQuery("#eprocureUser").val()==""){
				document.getElementById("userId").value="";
				}
			submitRequestDashboardForm();
		}
}
	
function submitRequestDashboardForm() {
	document.<portlet:namespace />requestDashboard.action = '<%= searchRequestURL%>';
	document.<portlet:namespace />requestDashboard.submit();
}

function onCancel(action)
{
	cancelURl = action;
	document.getElementById("approverComments").value="";
	document.getElementById("declineComments").value="";
	jQuery('#dialog').jqm({modal: true});
	jQuery('#dialog').jqmShow();
}
function resetEprocUser(){
	if(jQuery("#userId") !=""){
   	 document.getElementById('userId').value = "";
    }
}
function setComments()
{
	document.getElementById("approverComments").value = document.getElementById("declineComments").value;
	document.<portlet:namespace />requestDashboard.action = cancelURl;
	document.<portlet:namespace />requestDashboard.submit();
}

jQuery(function() {
    jQuery("#searchStartDate").datepicker({
          showOn: 'button',
          buttonImage: '/o/e-procurement-portlet/images/cal-icon.jpg',
          buttonImageOnly: true,
          dateFormat: 'mm/dd/yy',	              
          buttonText: 'select date'     
    });

    jQuery("#searchEndDate").datepicker({
        showOn: 'button',
        buttonImage: '/o/e-procurement-portlet/images/cal-icon.jpg',
        buttonImageOnly: true,
        dateFormat: 'mm/dd/yy',	              
        buttonText: 'select date',
       	minDate: new Date(jQuery('#searchStartDate').val()) 
  });  



    jQuery('#searchStartDate').change(function () {

		jQuery( "#searchEndDate" ).datepicker( "destroy" );
		jQuery( "#searchEndDate" ).val(jQuery('#searchStartDate').val());
		jQuery( "#searchEndDate" ).focus();
		jQuery( "#searchEndDate" ).datepicker({
			showOn: 'button',
         	buttonImage: '/o/e-procurement-portlet/images/cal-icon.jpg',
         	buttonImageOnly: true,
         	dateFormat: 'mm/dd/yy',
         	buttonText: 'select date',
			minDate: new Date(jQuery('#searchStartDate').val())      			
		});	
	});
       
});
</script>

<div id="cntr_contentRight">



<div id="cntr_contentCentral_two" class="main_heading">
<%if(Validator.isNotNull(successMsg)) {%>
<div  class="portlet-msg-success">
 <%=successMsg %>
</div>
<%} %>
<h3><liferay-ui:message key="req.dashboard.pagename"></liferay-ui:message></h3>
</div>

<a class="buttonlink" href="<c:out value='${addRequestLink}'/>" ><liferay-ui:message key="req.dashboard.add.new.request"></liferay-ui:message></a>
<br/><br/>

<div class="group-list-content">
	<div id="cntr_contentOneCol" style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">
	
	<!-- Fieldset for Search Fields -->
	<fieldset class="fieldset">
	  <legend><liferay-ui:message key="search.for.request"></liferay-ui:message></legend>
	
	  <form method="post" name="<portlet:namespace />requestDashboard" id="<portlet:namespace />requestDashboard">
	  <input type="hidden" id="approverComments" name="approverComments" />
	    <table class="form-content" border="0">
	      <tbody>
	        <tr>
	          <td colspan="4" style="padding: 0px;">
	            <table class="form-content" border="0">
	              <tbody>
	                <tr>
	                	<td width="70"><liferay-ui:message key="req.dashboard.start.date"></liferay-ui:message></td>
	                	<td width="125" class="form-item">
					 		<label><input class="text-field searchrequests" name="searchStartDate" id="searchStartDate" style="margin-right: 10px; width: 70px;" type="text"  readonly="readonly"></label>
					 	</td>
					 	<td width="50"><liferay-ui:message key="req.dashboard.end.date"></liferay-ui:message></td>
	                	<td width="120" class="form-item">
					 		<label><input class="text-field searchrequests" name="searchEndDate" id="searchEndDate" style="margin-right: 10px; width: 70px;" type="text" readonly="readonly"></label>
					 	</td>
					 	<%
			            	if(request.getAttribute("curStartDate") != null && !(StringPool.BLANK).equalsIgnoreCase(request.getAttribute("curStartDate").toString())){
			            %>
			            <script type="text/javascript">
			            	document.getElementById("searchStartDate").value = '<%= request.getAttribute("curStartDate").toString() %>';
			            </script>
			            <%
			            	}
			            %>
			            <%
			            	if(request.getAttribute("curEndDate") != null && !(StringPool.BLANK).equalsIgnoreCase(request.getAttribute("curEndDate").toString())){
			            %>
			            <script type="text/javascript">
			            	document.getElementById("searchEndDate").value = '<%= request.getAttribute("curEndDate").toString() %>';
			            </script>
			            <%
			            	}
			            %>
	                </tr>
	              </tbody>
	            </table>
	          </td>
	        </tr>
	        <tr>
	          <td title="Select request status" width="70"><liferay-ui:message key="req.dashboard.status"></liferay-ui:message></td>
	          <td width="125">
	            <select style="width: 243px; _font-size:11px" name="status" id="status" class="searchrequests">
	            <option value="<%=EProcurementConstants.PARAM_VALUE_SELECT %>"><%=EProcurementConstants.PARAM_VALUE_SELECT %></option>
	            	<c:forEach items='${listStatus}' var='status'>
	            		<option value="<c:out value='${status}' />" ><c:out value='${status}' /></option>
	            	</c:forEach>
	            </select>
	            <%
	            	if(request.getAttribute("curStatus") != null && !(StringPool.BLANK).equalsIgnoreCase(request.getAttribute("curStatus").toString())){
	            %>
	            <script type="text/javascript">
	            	document.getElementById("status").value = '<%= request.getAttribute("curStatus").toString() %>';
	            </script>
	            <%
	            	}
	            %>
	          </td>
	          <td><liferay-ui:message key="req.dashbaord.requester"></liferay-ui:message></td>
	          <td>
	          	<input type="hidden" name="companyId" id="companyId" value="<%= themeDisplay.getCompanyId() %>" />
	          	<input type="hidden" name="data" id="data" value="alluser" />
	          	<input type="hidden" name="userId" id="userId" value= />
        		<input type="hidden" name="jobTitle" id="jobTitle" value="" />
	            <input type="text" style="width: 243px;" name="eprocureUser" id="eprocureUser" class="searchrequests" onkeypress="resetEprocUser()"/>
	            <%
	            	if(request.getAttribute("curRequestor") != null && !(StringPool.BLANK).equalsIgnoreCase(request.getAttribute("curRequestor").toString())){
	            %>
	            <script type="text/javascript">
	            	document.getElementById("eprocureUser").value = '<%= request.getAttribute("curRequestor").toString() %>';
	            </script>
	            <%
	            	}if(request.getAttribute("curUserId") != null && !(StringPool.BLANK).equalsIgnoreCase(request.getAttribute("curUserId").toString())){
	            %>
	            <script type="text/javascript">
	            	document.getElementById("userId").value = '<%= request.getAttribute("curUserId").toString() %>';
	            </script>
	            <%
	            	}
	            %>
	          </td>
	        </tr>
	        <tr>
	          <td width="70"><liferay-ui:message key="req.dashboard.shipto"></liferay-ui:message></td>
	          <td width="100">
	            <select style="width: 243px; _font-size:11px !important;" name="address" id="address" class="searchrequests">
	            	<option value="<%=EProcurementConstants.PARAM_VALUE_SELECT %>"><%=EProcurementConstants.PARAM_VALUE_SELECT %></option>
	            	<% if(Validator.isNotNull(locations)){
	            	    
	            		for (int i = 0; i < locations.size(); i++) {
							shipToAddress = locations.get(i);
	            	    %>
						<option value="<%= shipToAddress.getAddress() %>" /><c:out value="<%= shipToAddress.getAddress() %>" /></option>
					<%}} %>
	            	<option value="<%=EProcurementConstants.SHIP_TO_OTHER_PARAM %>"><%=EProcurementConstants.SHIP_TO_OTHER_PARAM %></option>
	            </select>
	            <%
	            	if(request.getAttribute("curAddress") != null && !("").equalsIgnoreCase(request.getAttribute("curAddress").toString())){
	            %>
	            <script type="text/javascript">
	            	document.getElementById("address").value = '<%= request.getAttribute("curAddress").toString() %>';
	            </script>
	            <%
	            	}
	            %>
			  </td>
	        </tr>
	        <tr>
	          <td width="70"></td>
	          <td colspan="3">
	            <input onclick="validation();"  value="Get Requests" class="button input-button" style="width: 100px;" type="button" /> 
	            <input  onclick="resetValues();" value="Reset" name="Reset" class="button input-button" type="reset" />&nbsp;&nbsp;<liferay-ui:message key="req.dashboard.search.message"></liferay-ui:message></td>
	         
	        </tr>
	        <tr>
	          <td class="help" colspan="4">
	         
	            </td>
	        </tr>
	      </tbody>
	    </table>
	  </form>
	</fieldset>
	
	
	<!-- Search Container for Requests - STARTS -->
	
	<table class="round-corners">
  	<tbody>
	    <tr>
	      <td class="tl">&nbsp;</td>
	      <td>&nbsp;</td>
	      <td class="tr">&nbsp;&nbsp;&nbsp;</td>
	    </tr>
    	<tr>
      		<td class="form-content" style="padding: 0pt 10px;" colspan="3">
              
	
	<c:if test="${!empty requestList}">
	
           <liferay-ui:search-container id="DashboardRequestTempId" emptyResultsMessage="listTypeEmptyResultsMessage" searchContainer='<%=(SearchContainer)request.getAttribute("dashBoardSearchContainer") %>'>
					<liferay-ui:search-container-results>
						<%
							pageContext.setAttribute("results", (ArrayList<DashboardBean>)request.getAttribute("requestList"));
							SearchContainer searchContainerTemp = (SearchContainer)request.getAttribute("dashBoardSearchContainer");
							pageContext.setAttribute("total", searchContainerTemp.getTotal());
							
						%>
					</liferay-ui:search-container-results>		
					<liferay-ui:search-container-row className="com.dsi.intranet.eprocurement.portlet.bean.DashboardBean"
					   keyProperty="requestId" modelVar="dashBoardDO">		   
						  <liferay-ui:search-container-column-jsp name="Request Id" align="center" path="/jsps/dashboard/requestIdLink.jsp" />
					      <liferay-ui:search-container-column-text name="req.dashbaord.requester" property="userFullName" orderable="true" orderableProperty="Requester Name" />
					      <liferay-ui:search-container-column-text name="req.dashboard.request.date" property="createdDate" orderable="true" orderableProperty="Created Date" />
					      <liferay-ui:search-container-column-text name="req.dashboard.status" property="status" orderable="true" orderableProperty="Status" />
					      <liferay-ui:search-container-column-text name="req.dashboard.next.approver" property="nextApprover" orderable="true" orderableProperty="Next Approver" />
					      <liferay-ui:search-container-column-text name="req.dashboard.workflow" property="workFlowName" orderable="true" orderableProperty="Workflow Name" />
					      <liferay-ui:search-container-column-jsp name="Action" align="center" path="/jsps/dashboard/dashboardActions.jsp" />   
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />		
				</liferay-ui:search-container>
	</c:if>
	  </td>
    </tr>
    <tr>
      <td class="bl"></td>
      <td></td>
      <td class="br"></td>
    </tr>
  	</tbody>
	</table>

	<!-- Search Container for Requests - ENDS -->
	
	
	</div>
</div>


<div id="dialog" class="jqmWindow jqmID1" style="z-index: 3000; display: none;">
		<div class="jqmtitlebar">
		<h3><liferay-ui:message key="req.dashboard.add.comment"></liferay-ui:message></h3>
			<a class="jqmClose" href="#"><img class="closebutton" alt="" src="/o/e-procurement-portlet/images/close-icon.gif"></a>
		</div>
		<hr>
		<div class="commentbox">
  			<textarea id="declineComments" name="declineComments" style="padding: 3px; width: 390px; position: relative;" title="Enter appropriate comments" rows="5" cols="26" class="text-field"></textarea>
			<input type="button" style="margin-top: 10px;" class="button input-button jqmClose" name="Ok" id="Submit" value="Submit" title="Submit" onclick="setComments();" />
		</div>      
	</div>

<script type="text/javascript">

function resetValues(){
	jQuery("#<portlet:namespace />requestDashboard")[0].reset();
}

jQuery(document).ready(function(){

                        jQuery(".action-menu").hide();
                        jQuery("#cntr_contentOneCol .action-button").click(function(){
                                jQuery(this).next(".action-menu").toggle();
                        
                
                        })
                        

                        jQuery('.sub-menu').hover(
                   function() {
                       jQuery(this).addClass('hovrd');
              }, function() {
                    jQuery(this).removeClass('hovrd');
              }
           );
          	jQuery(".search-result-table tr:even").addClass("alt");

          	
});
</script>

</div>

	
<style type="text/css">
.taglib-search-iterator{border-right:1px solid #CCC;border-top:1px solid #CCC;width:100%;}
.results-header th{background-color:#EAEAEA;color:#333;font-weight:bold;}
.results-header td,.results-header th{border-bottom:1px solid #CCC;border-left:1px solid #CCC;padding:6px;}
.ui-autocomplete-even,.results-row td{border-bottom:1px solid #CCC;border-left:1px solid #CCC;padding:6px; background-color: #F4F4F4;}
.ui-autocomplete-odd, .results-row.alt td{background-color:#F9F9F9; }
.results-header th a, .results-header td a {color: #333333;}
div.results-grid{padding:0;}
.form-content td.form-item {white-space: nowrap;}
</style>
