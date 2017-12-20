<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to Pass Object Name while updating the record
 * Kruti Doshi		|	Sep 12 2014		|	Added new form's condition and omitted "Home Office use only" from some forms. 
 * Kruti Doshi		|	Sep 15 2014		|	Modified as per new enhancement list given by client.
--%>
<%@ include file="/jsps/init.jsp"%>
<!-- pgc form js -->
<script type="text/javascript" src="/o/pgc-portlet/js/pgc.loadform.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/pgc.validateform.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/pgc.clearform.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/pgcmain.js"></script>

<!-- auto complete js files -->
<link rel="stylesheet" type="text/css" 	href="/o/pgc-portlet/css/jquery.autocomplete.css" />
<script type="text/javascript" 	src="/o/pgc-portlet/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/pgc-autocomplete.js"></script>

<link rel="stylesheet" type="text/css" media="print" href="/o/pgc-portlet/css/print.css" />

<!-- file upload scripts  -->
<script type="text/javascript" src="/o/pgc-portlet/js/jquery.form.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/jquery.MetaData.js"></script>
<script type="text/javascript" src="/o/pgc-portlet/js/jquery.MultiFile.js"></script>

<c:if test="<%= SessionErrors.contains(request,\"process-unsuccess\") %>">
 <span class="portlet-msg-unsuccess">
	Couldn't process the request. Please try again.
 </span>
</c:if>


<portlet:actionURL var="saveNewUrl">
	<portlet:param name="appAction" value="saveNewPGCForm" />
</portlet:actionURL>
<portlet:renderURL var="dashBoardURL" />
<form:form commandName="appForm" action="${saveNewUrl}"
	enctype="multipart/form-data">
	<c:choose>
		<c:when test="${appForm.formType == 'DispExhibit'}">
			<div id="cntr_contentCentral_two" class="main_heading"
				style="font-size: 12px;">
				<div class="fleft">Field and Home Office Use</div>
				<div class="fright">
					<input type="button" class="button input-button" value="&#60;&#60; GoTo Dashboard" onclick="location.href='${dashBoardURL}'" />
					&nbsp;&nbsp;&nbsp; 
						<input type="button" value="Print this form" class="button input-button" id="print">
				</div>
				<br />
				<br />
			</div>

			<table border="0" class="aggreval-block">
				<tbody>
					<tr class="">
						<td style="border-bottom: 1px dotted #ccc" colspan="5"><strong
							class="bold">For Internal Use Only</strong>
						</td>
					</tr>
					<tr>
						<td>Purpose</td>
						<td>: P2</td>
						<form:hidden path="checkReqInfo.purpose" value="Marketing" />
						<form:hidden path="checkReqInfo.purposeCode" value="P2" />
						<td>&nbsp;</td>
						<td>Nature </td>
						<td>: N33 (Displays and Exhibits)</td>
						<form:hidden path="checkReqInfo.nature" value="Marketing" />
						<form:hidden path="checkReqInfo.natureCode" value="N33 (Displays and Exhibits)" />
					</tr>
					<tr>
						<td>Recipient type</td>
						<td>: Organization (T1)</td>
						<form:hidden path="checkReqInfo.recipientType" value="Organization" />
						<form:hidden path="checkReqInfo.recipientCode" value="T1" />
						<td>&nbsp;</td>
						<td>Payment Form</td>
						<td>: Cash (V1)</td>
						<form:hidden path="checkReqInfo.paymentForm" value="Cash" />
						<form:hidden path="checkReqInfo.paymentCode" value="V1" />
					</tr>
					<tr>
						<td>Product</td>
						<td><span>: <span id="agreeProductList"></span>
						</span>
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>	
						<form:hidden path="checkReqInfo.product" value="" />
					</tr>

				</tbody>
			</table>
		</c:when>
		<c:when
			test="${appForm.formType == 'POMembership'}">
			<div id="cntr_contentCentral_two" class="main_heading"
				style="font-size: 12px;">
				<div class="fleft">Field and Home Office Use</div>
				<div class="fright">
					<input type="button" class="button input-button"
						value="&#60;&#60; GoTo Dashboard"
						onclick="location.href='${dashBoardURL}'" />&nbsp;&nbsp;&nbsp; <input
						type="button" style="margin-right: 8px" value="Print this form"
						class="button input-button" id="print">
				</div>
				<br />
				<br />
			</div>
			<table border="0" class="aggreval-block">
				<tbody>
					<tr class="">
						<td style="border-bottom: 1px dotted #ccc" colspan="5"><strong
							class="bold">For Internal Use Only</strong>
						</td>
					</tr>
					<tr>
						<td>Purpose</td>
						<td>: P2</td>
						<form:hidden path="checkReqInfo.purpose" value="Other" />
						<form:hidden path="checkReqInfo.purposeCode" value="P2" />
						<td>&nbsp;</td>
						<td>Nature </td>
						<td>: N7 (Membership Dues)</td>
						<form:hidden path="checkReqInfo.nature" value="Grant" />
						<form:hidden path="checkReqInfo.natureCode" value="N7 (Membership Dues)" />
					</tr>
					<tr>
						<td>Recipient type</td>
						<td>: Organization (T1)</td>
						<form:hidden path="checkReqInfo.recipientType" value="Organization" />
						<form:hidden path="checkReqInfo.recipientCode" value="T1" />
						<td>&nbsp;</td>
						<td>Payment Form</td>
						<td>: Cash (V1)</td>
						<form:hidden path="checkReqInfo.paymentForm" value="Cash" />
						<form:hidden path="checkReqInfo.paymentCode" value="V1" />
					</tr>
					<tr>
						<td>Product</td>
						<td>: No Product</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>	
						<form:hidden path="checkReqInfo.product" value="No Product" />
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when
			test="${appForm.formType == 'CorporateSupport'}">
			<div id="cntr_contentCentral_two" class="main_heading"
				style="font-size: 12px;">				
				<div class="fright">
					<input type="button" class="button input-button"
						value="&#60;&#60; GoTo Dashboard"
						onclick="location.href='${dashBoardURL}'" />&nbsp;&nbsp;&nbsp; <input
						type="button" style="margin-right: 8px" value="Print this form"
						class="button input-button" id="print">
				</div>
				<br />
				<br />
			</div>
			<div class="clear"></div>
			<br>
			
			<div id="corporateSupportSubTypeId" class="aggCheck">
				<strong class="bold" >
					<label for="corporateSupport.subType">
						<liferay-ui:message key="coporateSupportblk.stmt.declaration" />
					</label>
					<span class="red_star">*</span>
				</strong>
				<p>
					<form:radiobutton path="corporateSupport.subType" value="Sponsorship"  cssClass="required" onclick="aggregateCode('Sponsorship')"/>
					<liferay-ui:message key="coporateSupportblk.label.sponsorship" />
					<form:radiobutton path="corporateSupport.subType" value="Non-CME Grant (includes Fellowships)" onclick="aggregateCode('Non-CME Grant')"/>
					<liferay-ui:message key="coporateSupportblk.label.noncmegrant" /> 
				</p>
			</div>
			<div class="aggTable">
			<table border="0" class="aggreval-block">
				<tbody>
					<tr class="">
						<td style="border-bottom: 1px dotted #ccc" colspan="5"><strong
							class="bold">For Internal Use Only</strong>
						</td>
					</tr>
					<%-- <c:if test="${appForm.corporateSupport.subType == 'Sponsorship'}"> --%>
					<tr id="corpSubTypeId1">
						<td>Purpose</td>
						<td>: P2</td>
						<form:hidden path="checkReqInfo.purpose" value="Other" />
						<form:hidden path="checkReqInfo.purposeCode" value="P2" />
						<td>&nbsp;</td>
						<td>Nature </td>
						<td>: N31 (Sponsorships)</td>
						<form:hidden path="checkReqInfo.nature" value="Grant" />
						<form:hidden path="checkReqInfo.natureCode" value="N31 (Sponsorships)" />
					</tr>
					<%-- </c:if>
					<c:if test="${appForm.corporateSupport.subType == 'Non-CME Grant (includes Fellowships)'}"> --%>
					<tr id="corpSubTypeId2">
						<td>Purpose</td>
						<td>: P1</td>
						<form:hidden path="checkReqInfo.purpose" value="Other" />
						<form:hidden path="checkReqInfo.purposeCode" value="P1" />
						<td>&nbsp;</td>
						<td>Nature </td>
						<td>: N51 (Grants- Non CME)</td>
						<form:hidden path="checkReqInfo.nature" value="Grant" />
						<form:hidden path="checkReqInfo.natureCode" value="N51 (Grants- Non CME)" />
					</tr>
					<%-- </c:if> --%>
					<tr>
						<td>Recipient type</td>
						<td>: Organization (T1)</td>
						<form:hidden path="checkReqInfo.recipientType" value="Organization" />
						<form:hidden path="checkReqInfo.recipientCode" value="T1" />
						<td>&nbsp;</td>
						<td>Payment Form</td>
						<td>: Cash (V1)</td>
						<form:hidden path="checkReqInfo.paymentForm" value="Cash" />
						<form:hidden path="checkReqInfo.paymentCode" value="V1" />
					</tr>
					<tr>
						<td>Product</td>
						<td>: No Product</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>						
						<form:hidden path="checkReqInfo.product" value="No Product" />
					</tr>
				</tbody>
			</table>
			</div>
		</c:when>
		<c:otherwise>
			<div id="cntr_contentCentral_two" class="main_heading">				
				<div class="fright">
					<input type="button" class="button input-button" value="&#60;&#60; GoTo Dashboard" 	onclick="location.href='${dashBoardURL}'" />
					&nbsp;&nbsp;&nbsp; 
					<input 	type="button" style="margin-right: 8px" value="Print this form" class="button input-button" id="print">
				</div>
				<br />
				<br />
			</div>
		</c:otherwise>
	</c:choose>
	<div class="group-list-content">
		<div id="cntr_contentOneCol"
			style="float: none; margin: 0pt auto; padding: 0; width: auto;">
			<c:forEach items="${formTitles}" var="formTitle">
				<c:set var="formTypeName">${appForm.formType}</c:set>
				<c:set var="formDisplayName">${formTypes}</c:set>
				<c:if test="${formTypeName == formTitle.key}">
					<c:if test="${not empty formTypes}">
						<p class="form-content" style="padding: 0px; color: #333333;">
					<div  style="font-family: arial; font-size:9pt; font-weight:bold"><c:out value="${formTypes[formTypeName]}" />
					:<c:out value="${appForm.requestId}"/>
					</div>
					<c:out value="${formTitle.value}" />
				</p>
					</c:if>
				</c:if>
			</c:forEach>
			<form:hidden path="formType" />
			<form:hidden path="formId" />
			<form:hidden path="formStatus"  />
			<form:hidden path="formStatusNotes" />
			<input type="hidden" name="saveAction"
				value="<%= request.getAttribute("saveAction") %>" /> <input
				type="hidden" name="objectId" value="${OBJECTID}" />
				<%-- DSI:START::Veera Reddy:: To pass the object name while editing the record --%>
				<input type="hidden" name="objectName" value="${OBJECTNAME}" />
				<%-- DSI:END::Veera Reddy:: To pass the object name while editing the record --%>
			<table class="round-corners">
			
				<c:set var="showReadOnlyCrDate" value="true" scope="request" />
				<c:if test="${appForm.formStatus == 'Approved'}">
					<jsp:include page="/jsps/include/modification_info.jsp"></jsp:include>
				</c:if>
				<jsp:include page="/jsps/include/requestor_info.jsp"></jsp:include>
				<c:choose>
					<c:when test="${appForm.formType == 'DispExhibit'}">
						<jsp:include page="/jsps/include/check_request_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/budget_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/display_exhibit_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType == 'POMembership'}">
						<jsp:include page="/jsps/include/check_request_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/budget_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/po_membership_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType == 'EduItemsVal'}">
						<jsp:include page="/jsps/include/check_request_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/educational_items_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType == 'CSAgreement'}">
						<jsp:include page="/jsps/include/contract_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/service_agreement.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType == 'HCPConsultant'}">
						<jsp:include page="/jsps/include/contract_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/hcp_consultant_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType == 'AdvBoard'}">
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/advisory_board_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType== 'CorporateSupport'}">
						<jsp:include page="/jsps/include/check_request_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/corporate_support_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType== 'CharitableDonation'}">
						<jsp:include page="/jsps/include/check_request_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/charitable_donation_info.jsp"></jsp:include>
					</c:when>
					<c:when test="${appForm.formType== 'GenRequest'}">
						<jsp:include page="/jsps/include/product_info.jsp"></jsp:include>
						<jsp:include page="/jsps/include/general_request_info.jsp"></jsp:include>
					</c:when>
				</c:choose>
				<c:if test="${viewMode != 'view'}">
					<tr>
						<td colspan="3" style="text-align: center; padding-top: 10px;">
							<input type="hidden" id="action" name="action" value="save" /> <c:choose>
								<c:when
									test="${(appForm.formType == 'HCPConsultant' || appForm.formType == 'CSAgreement') && appForm.formStatus == 'Approved Contract Pending'}">
									<input type="button" class="button input-button" value="Submit"
										onclick="validateAndSubmitForm(document.forms['appForm'], true, true);" />&nbsp;&nbsp;&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<c:if
										test="${appForm.formStatus == 'Draft' || appForm.formStatus == ''}">
										<input type="button" value="Save" class="button input-button"
											id="submit_button"
											onclick="validateAndSubmitForm(document.forms['appForm'], false, false);" />&nbsp;&nbsp;&nbsp;&nbsp;
									</c:if>
									<input type="button" class="button input-button" value="Submit"
										onclick="validateAndSubmitForm(document.forms['appForm'], true, false);" />&nbsp;&nbsp;&nbsp;&nbsp;
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${OBJECTID == '' || OBJECTID == null}">
									<input type="button" class="button input-button" value="Clear"
										onclick="formClearButtonClicked();" />
								</c:when>
								<c:otherwise>
									<input type="button" class="button input-button" value="Cancel"
										onclick="location.href='${dashBoardURL}'" />
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:if>
				<tr>
					<td class="bl"></td>
					<td></td>
					<td class="br"></td>
				</tr>
			</table>
		</div>
	</div>
</form:form>
<c:if test="${viewMode == 'view'}">
	<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery(':input').each(function() {
				switch (this.type) {
				case 'password':
				case 'select-multiple':
				case 'select-one':
				case 'textarea':
				case 'checkbox':
				case 'radio':
					jQuery(this).attr('disabled', 'disabled');
					break;
				case 'text':
					jQuery(this).attr('readonly', 'readonly');
					break;
				}
			});
		});
	</script>
</c:if>
<c:if
	test="${viewMode != 'view' && appForm.formStatus == 'PGC Approved-Agreement Pending'}">
	<c:if
		test="${(appForm.formType == 'DispExhibit' || appForm.formType == 'CorporateSupport')}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery(':input').each(function() {
					switch (this.type) {
					case 'password':
					case 'select-multiple':
					case 'select-one':
					case 'textarea':
					case 'checkbox':
					case 'text':
					case 'radio':
						jQuery(this).attr('disabled', 'disabled');
					}
				});
			});
		</script>
	</c:if>
	<c:if test="${appForm.formType == 'DispExhibit'}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery("input:checkbox[name='checkbox']").each(function() {
					if (this.value == 'contract') {
						jQuery(this).removeAttr('disabled');
					}
				});
			});
		</script>
	</c:if>
	<c:if test="${appForm.formType == 'CorporateSupport'}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery("input:checkbox[name='checkbox']").each(function() {
					if (this.value == 'contract') {
						jQuery(this).removeAttr('disabled');
					}
				});
			});
		</script>
	</c:if>
</c:if>
<c:if test="${appForm.corporateSupport.subType == 'Sponsorship'}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery("#corpSubTypeId1").css('display','table-row');
			});
			</script>
</c:if>
<c:if test="${appForm.corporateSupport.subType == 'Non-CME Grant (includes Fellowships)'}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery("#corpSubTypeId2").css('display','table-row');
			});
			</script>
</c:if>
<style>
.aggCheck{
	float:left;
	margin:10px 30px;
}
.aggTable{
	float:right;
}
#corpSubTypeId1{
display:none;
}
#corpSubTypeId2{
display:none;
}
</style>