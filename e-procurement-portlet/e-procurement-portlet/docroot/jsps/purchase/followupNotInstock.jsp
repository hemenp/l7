<%--
* Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. 
*
* @Project Intranet
* @Author Jay Patel
* @Description Role Assignment Configuration which contains the Legacy Database configuration details.
* @ChangeLog:
* Name				|	Date			| 	Reason
* --------------------------------------------------------------------------------------------------------------------------
* Veera Reddy		|	May 14, 2012	|	modified to fix the redirect issue in prod - LRPS-244,LRPS-245
*
--%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>


<%
		String requestId = StringPool.BLANK;
		String sucessMessage = StringPool.BLANK;
		String errorMessage =  StringPool.BLANK;
       	long lngRequestId=0;
		if(request.getAttribute("requestIdDashboard") != null && 
				EProcurementUtil.isNotNullNonEmptyString(request.getAttribute("requestIdDashboard").toString()))
		{
			requestId = request.getAttribute("requestIdDashboard").toString();
			lngRequestId = Long.valueOf(requestId);
		}
		String requesterName = (String)renderRequest.getAttribute("requesterName");
		List<Item> eprocItemList = ItemLocalServiceUtil.getItemsByRequestId(lngRequestId);
		int itemTotal = 0;
		if(eprocItemList!=null) { 
		    itemTotal = eprocItemList.size();
		}
		if(request.getAttribute("sucessMessage") != null)
		{
			sucessMessage =(String)request.getAttribute("sucessMessage");
		}
		if(request.getAttribute("errorMessage") != null)
		{
			errorMessage =(String)request.getAttribute("errorMessage");			
		}
%>

<portlet:actionURL var="submitNotInStockRequestURL">
			<portlet:param name="eProcAction" value="submitNotInStockRequest"/>
			<portlet:param name="requestId" value="<%= requestId%>"/>
</portlet:actionURL>

<portlet:actionURL var="completeNotInStockRequestURL">
			<portlet:param name="eProcAction" value="completeNotInStockRequest"/>
			<portlet:param name="requestId" value="<%= requestId%>"/>
</portlet:actionURL>

<portlet:actionURL var="previousRequestURL">
			<portlet:param name="eProcAction" value="previousRequest"/>
</portlet:actionURL>

<portlet:actionURL var="createRequestURL">
			<portlet:param name="eProcAction" value="createRequest"/>
</portlet:actionURL>

<portlet:actionURL var="requestDetailsURL">
			<portlet:param name="eProcAction" value="requestDetails"/>
			<portlet:param name="requestId" value="<%= requestId%>"/>
</portlet:actionURL>

<portlet:renderURL var="requestWFDetails">
			<portlet:param name="cmd" value="showRequestWFDetails"/>
			<portlet:param name="requestId" value="<%= requestId%>"/>
</portlet:renderURL>


<script type="text/javascript">


jQuery(document).ready(function(){

	var rowCount = jQuery('#itemTable tr').length;
	var itemCount = jQuery('#itemTotal').val();
	var idNames;
	var finalString="";
	if(itemCount!=null && itemCount>0)
	{
		var name="#vendorName";
		
	
		for(var i=0; i<itemCount; i++)
		{
			finalString = finalString + name + i;
			finalString = finalString + ",";
		}
		finalString = finalString.substring(0,finalString.length-1);
		
	}
	jQuery(finalString).autocomplete('/e-procurement-portlet/jsps/purchase/getData.jsp?data='+jQuery("#vendor").val()+'&companyId='+jQuery("#companyId").val(), {
	 			 dataType: "xml",
	 	      	  beforeSend: function(x) {
	 	      	        if(x && x.overrideMimeType) {
	 	      	            x.overrideMimeType("text/xml");
	 	      	        }
	 	      	    },
	 	      	  parse: function(xml) {
	 				  var results = [];
	 	    		  jQuery(xml).find('vendor').each(function(){
	 	  				var name = jQuery(this).find('name').text();
	 	  				var vendorcode = jQuery(this).find('vendorcode').text();
	 	  				var email = jQuery(this).find('email').text();
	 	  			
	 	  				results[results.length] = { 'data': { name: name, vendorcode:vendorcode, email: email },
	 		 					'result': name, 'value': name};
	 	  				});
						jQuery(finalString).data("resultData", results);
	 					return results;
	 	  			},


	 				formatItem: function(data) {
	 					return data.name;
	 				},
	 				width: 250
	 			}).result(function(e, data) {	
	 				var id = jQuery(this).attr("id");
					id = id.substring("vendorName".length,id.length);
	 				jQuery("#vendorCode"+id).val(data.vendorcode);
	 			})

});;


function submitNotInStockRequest()
{
	
	if(forceAutoPickList()){
	document.followUpNotInStockForm.action= "<%=submitNotInStockRequestURL%>";
	document.followUpNotInStockForm.method="post";
	document.followUpNotInStockForm.submit();
	}
}

function forceAutoPickList()
{
	var itemCount = jQuery('#itemTotal').val();
	var flag = true;
	if(itemCount!=null && itemCount>0)
	{
		var vendorCode ="#vendorCode";
		var vendorName="#vendorName";
		for(var i=0; i<itemCount; i++)
		{
			if(jQuery(vendorName+i).val()!='' && jQuery(vendorCode+i).val()=="" )
			{
				alert('Please select vendor name through auto pick list');
				jQuery(vendorName+i).focus();
				flag = false;
				break;
			}
		}
	}
	return flag;
}



function completeNotInStockRequest()
{
	if(forceAutoPickList()){
	document.followUpNotInStockForm.action= "<%=completeNotInStockRequestURL%>";
	document.followUpNotInStockForm.method="post";
	document.followUpNotInStockForm.submit();
	}
}

function navigationLink(pageToRedirect)
{
	if(pageToRedirect=='Create Request')
	{
		// alert('Create Request');
		document.followUpNotInStockForm.action= "<%=createRequestURL%>";
		document.followUpNotInStockForm.method="post";
		document.followUpNotInStockForm.submit();
			
	}else if(pageToRedirect=='Previous Request')
	{
		// alert('Previous Request');
		document.followUpNotInStockForm.action= "<%=previousRequestURL%>";
		document.followUpNotInStockForm.method="post";
		document.followUpNotInStockForm.submit();
			
	}else if(pageToRedirect=='Request Details')
	{
		// alert('Request Detail');
		document.followUpNotInStockForm.action= "<%=requestDetailsURL%>";
		document.followUpNotInStockForm.method="post";
		document.followUpNotInStockForm.submit();
	}else if(pageToRedirect=='Workflow Details')
	{
		document.followUpNotInStockForm.action= "<%=requestWFDetails%>";
		document.followUpNotInStockForm.method="post";
		document.followUpNotInStockForm.submit();
	}
	 
}

function onDateChange(startDate , EndDate)
{
	jQuery(EndDate).datepicker( "destroy" );
	jQuery(EndDate).val(jQuery(startDate).val());
	jQuery(EndDate).datepicker({
		
		minDate: new Date(jQuery(startDate).val())      			
	});	
}

function resetVendorCode(vendorCode)
{
	    if(jQuery("#"+vendorCode) !=""){
	    	 document.getElementById(vendorCode).value = "";
	     }
}



</script>

<form name="followUpNotInStockForm">
<input type="hidden" value="<%=itemTotal %>" id="itemTotal">
<input type="hidden" name="vendor" id="vendor" value="vendor" />
	<input type="hidden" name="companyId" id="companyId" value="<%=themeDisplay.getCompanyId() %>" />
	

<div id="cntr_contentCentral_two" class="main_heading">
<h3><liferay-ui:message key="folloup.link.name"></liferay-ui:message></h3>
</div>
<div class="group-list-content" id="mainDiv">
	<div class="main_heading">
       <% if (Validator.isNotNull(sucessMessage)) {%>
		<div  class="portlet-msg-success">
 			<%= sucessMessage %>
		</div>
	<% } %>
	 <% if (Validator.isNotNull(errorMessage)) {
		 %>
	 	<span  class="portlet-msg-error">
		<%=errorMessage %>
		</span>
	<% } %>
	</div>
<div id="cntr_contentOneCol"
	style="margin: 0pt auto; padding: 0pt; float: none; width: auto;">


<table class="round-corners" border="0">
	<tbody>
		<tr>
			<td class="tl">&nbsp;</td>
			<td>&nbsp;</td>
			<td class="tr">&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" style="padding: 0pt 10px;" class="form-content">





			<table cellspacing="0" cellpadding="0" border="0" width="100%" id="itemTable">
				<tbody>
					<tr>
						<td class="label"><liferay-ui:message key="followup.requesterName"></liferay-ui:message></td>
						<td class="form-item heading16"><a href="#"><%=requesterName %></a></td>

					</tr>


				<%if(eprocItemList!=null && eprocItemList.size()>0) {
				    Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
					for(int i=0; i<eprocItemList.size(); i++){
					
					Item item = eprocItemList.get(i);	
					EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(item.getRequestId());
					
				%>
				
				
					<tr>
						<td></td>
						<td>
						<table  style="border-bottom: 0pt none; width: 100%"
							class="search-result-table btmmargin" border="0" cellpadding="0"
							cellspacing="0">
							<tbody>
								<tr>
									<th class="width100"><liferay-ui:message key="followup.item"></liferay-ui:message></th>
									<th class="width100"><liferay-ui:message key="followup.po.number"></liferay-ui:message></th>
									<th><liferay-ui:message key="followup.vendor"></liferay-ui:message></th>
									<th><liferay-ui:message key="followup.classification"></liferay-ui:message></th>
								</tr>

								<tr>
									<td class="width100"><input type="text"
										disabled="disabled" value="<%= item.getItemName() %>" style="width: 100px;"
										name="Item2" /></td>
									<td class="width100"><input type="text" value="<%= item.getPurchaseOrder()==null  || (StringPool.BLANK).equals(item.getPurchaseOrder()) ? eprocRequest.getPurchaseOrder():item.getPurchaseOrder() %>"
										style="width: 100px;" name="<%="purchaseOrder"+i %>" id="<%="purchaseOrder"+i %>" /></td>
									<td class="colm-2">
									<input class="width150"  type="text" name="<%="vendorName"+i %>" id="<%="vendorName"+i %>" onKeyPress="resetVendorCode('<%="vendorCode"+i %>')";  value="<%= item.getVendorCode()==null  || StringPool.BLANK.equals(item.getVendorCode()) ? EprocurementCommonUtil.getVendorName(themeDisplay.getCompanyId(),eprocRequest.getVendorCode()):EprocurementCommonUtil.getVendorName(themeDisplay.getCompanyId(),item.getVendorCode()) %>"></input>
									<input type="hidden" name="<%="vendorCode"+i %>" id="<%="vendorCode"+i %>" value="<%= item.getVendorCode()==null  || StringPool.BLANK.equals(item.getVendorCode()) ? eprocRequest.getVendorCode():item.getVendorCode() %>"/>
									</td>
									<td class="colm-2">
									<select name="<%="itemClassification"+i %>" style="width:150px; _font-size:11px !important;">
										<%if(item.getItemInStock()){ %>
										<option selected="selected"><%=EProcurementConstants.ITEM_IN_STOCK %></option>
										<option><%=EProcurementConstants.ITEM_NOT_IN_STOCK %></option>
										<%}else { %>
										<option><%=EProcurementConstants.ITEM_IN_STOCK %></option>
										<option selected="selected"><%=EProcurementConstants.ITEM_NOT_IN_STOCK %></option>
										<%} %>
									</select>
									</td>
								</tr>
						
								<tr>
									<th class="width100"><liferay-ui:message key="followup.received.date"></liferay-ui:message></th>
									<th class="width100"><liferay-ui:message key="followup.returned.date"></liferay-ui:message></th>
									<th><liferay-ui:message key="followup.asset.info"></liferay-ui:message></th>
									<th><liferay-ui:message key="followup.returned.assets"></liferay-ui:message></th>
								</tr>

								<tr>
									<td class=" "><input type="text" value="<%=item.getRecievedDate() != null ? dateFormat.format(item.getRecievedDate()) : "" %>"
										style="width: 100px;" name="<%="receivedDate"+i %>"
										title="Date item was received" class="datePicker" id="<%="receivedDate"+i %>" onchange="onDateChange('<%="#receivedDate"+i %>','<%="#returnDate"+i %>')"></td>
									<td class="colm-2"><input type="text" value="<%=item.getReturnedDate() != null ? dateFormat.format(item.getReturnedDate()) : "" %>"
										style="width: 100px;" name="<%="returnDate"+i %>"
										title="Date item was received" class="datePicker" id="<%="returnDate"+i %>"></td>
									<td class="colm-2 "><input type="text" value="<%= item.getAssetInfo() %>"
										class="width150" name="<%="assetInfo"+i %>" id="<%="assetInfo"+i %>"></td>
									<td><input type="text"  class="width150" value="<%= item.getReturnedAssets() %>"
										name="<%="returnedAssets"+i %>" id="<%="returnedAssets"+i %>"></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					
					<%}} %>
					<tr>
						<td class="label ">Comments</td>
						<td class="form-item">
						<textarea class="text-field" style="padding: 3px; margin-right: 10px; width: 98.5%;" name="followUpComments"></textarea>

						</td>

					</tr>
					<tr>
						<td class="heading16">&nbsp;</td>
						<td><input title="Click to submit completed request"
							value="Submit" name="Ok" class="button input-button"
							type="button" onclick="submitNotInStockRequest()"> 
							
							<input
							title="Click to clear request information" value="Clear"
							class="button input-button" type="reset"> 
							
							<input value="Complete Request" class="button input-button" type="button" onclick="completeNotInStockRequest()"></td>
					</tr>
					
				

				</tbody>
			</table>

			<br />


			<a href="#" onclick="navigationLink('Previous Request')"><liferay-ui:message key="followup.previous.request"></liferay-ui:message></a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href="#" onclick="navigationLink('Create Request')"><liferay-ui:message key="followup.create.request"></liferay-ui:message></a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href="#" onclick="navigationLink('Request Details')"><liferay-ui:message key="followup.request.details"></liferay-ui:message></a>&nbsp;&nbsp;| 
			&nbsp;&nbsp;<a href="#" onclick="navigationLink('Workflow Details')""><liferay-ui:message key="followup.workflow"></liferay-ui:message></a>




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

<% if(request.getAttribute("listCustomWFReview") != null && ((List)request.getAttribute("listCustomWFReview")).size() > 0) { %>
								<%@include file="commentTrail.jsp" %>
						<% } %>
</div>
</div>

</form>


<script type="text/javascript">
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

jQuery(function() {
    jQuery(".datePicker").datepicker({
  });

    
});


</script>