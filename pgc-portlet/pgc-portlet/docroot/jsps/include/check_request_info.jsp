<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Vijayan Chendrayan
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 22 2012		|	Modified to add validation onblur for the all textArea fields
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="CheckReqBlk">
    	<h3 class="acc-title">
    		<liferay-ui:message key="checkReqInfoBlk.heading"/>
    	</h3>
        <div class="acc-content">
        	<strong class="bold12">
        		<liferay-ui:message key="checkReqInfoBlk.note" />
        	</strong>
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%;">
				<tbody>
					<tr>
						<td colspan="4" >
							<strong class="question"><liferay-ui:message key="checkReqInfoBlk.subtopic.payableTo" /></strong>
						</td>
					</tr>		
					<tr>
						<td class="req_label">
							<label for="checkReqInfo.payeeName">
								<liferay-ui:message key="checkReqInfoBlk.label.payee" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="checkReqInfo.payeeName" cssClass="text-field  reqSave textTip" maxlength="250" />
						</td>
						<td class="req_label"></td>
						<td class="form-item"></td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="checkReqInfo.checkAddress.addressLine1">
								<liferay-ui:message key="checkReqInfoBlk.label.addressLine1" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="checkReqInfo.checkAddress.addressLine1" cssClass="text-field required textTip" maxlength="250"/>
						</td>
						
						<td class="req_label"><liferay-ui:message key="checkReqInfoBlk.label.addressLine2" /></td>
						<td class="form-item">
							<form:input path="checkReqInfo.checkAddress.addressLine2" cssClass="text-field textTip" maxlength="250"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="checkReqInfo.checkAddress.city">
								<liferay-ui:message key="checkReqInfoBlk.label.city" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="checkReqInfo.checkAddress.city" maxlength="250" cssClass="text-field required textTip"/>
						</td>
						
						<td class="req_label">
							<label for="checkReqInfo.checkAddress.state">
								<liferay-ui:message key="checkReqInfoBlk.label.state" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:select path="checkReqInfo.checkAddress.state" cssClass="text-field required" style="width:133px">
				                <form:option value="" label="Select State"/>
				                <form:options items= "${usStates}" />
				            </form:select>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="checkReqInfo.checkAddress.zip">
								<liferay-ui:message key="checkReqInfoBlk.label.zip" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item vmid">
							<form:input path="checkReqInfo.checkAddress.zip" cssClass="text-field required reqZipCode" maxlength="5" style="width:57px"/>
			 				-
			 				<label for="checkReqInfo.checkAddress.zipExtra">
     							<form:input path="checkReqInfo.checkAddress.zipExtra" cssClass="text-field reqNumeric" maxlength="4" style="width:50px;"/>
     						</label>
         				</td>
						<td class="req_label" style="">
							<label for="checkReqInfo.totalCheckAmt">
								<liferay-ui:message key="checkReqInfoBlk.label.totalCheckAmt" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<strong class="question">$ </strong>
							<form:input path="checkReqInfo.totalCheckAmt" cssClass="text-field required" style="width:115px;" maxlength="20" onchange="formatCurrency(this);" onBlur="displayFeeAmount();"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
						<c:choose>
						<c:when test="${appForm.formType== 'CorporateSupport' || appForm.formType == 'EduItemsVal' || appForm.formType == 'POMembership' || appForm.formType == 'DispExhibit' || appForm.formType == 'CharitableDonation'}">
						<label for="checkReqInfo.payeeTaxIdSSN">
								<liferay-ui:message key="checkReqInfoBlk.label.payeeTaxId" />
							</label>
						</c:when>
						<c:otherwise>
							<label for="checkReqInfo.payeeTaxIdSSN">
								<liferay-ui:message key="checkReqInfoBlk.label.payeeTaxIdSSN" />
							</label>
						</c:otherwise>
						</c:choose>
							<span class="red_star">*</span>
						</td>
						<td colspan="3" class="form-item">
							<form:input path="checkReqInfo.payeeTaxIdSSN" cssClass="text-field required " maxlength="11"/>
							<span class="font11"><liferay-ui:message key="checkReqInfoBlk.label.payeeTaxIdSSNNote" /></span>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="checkReqInfo.splInstructions">
								<liferay-ui:message key="checkReqInfoBlk.label.splInstructions" />
							</label>
						</td>
						
						<td colspan="3" class="form-item">
							<form:textarea path="checkReqInfo.splInstructions" cssClass="cmmntbxful" onkeydown="limitText(this,512);" onkeyup="limitText(this,512);" onblur="limitText(this,512);"/>
						</td>
					</tr>
					<c:if test="${OBJECTID == '' || OBJECTID == null}">
						<tr>
							<td style="text-align: right; padding: 10px 0;" colspan="4">
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearCheckBlock(this);" />
	                        </td>
		  				</tr>
		  			</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>