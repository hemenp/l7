<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Vijayan Chendrayan
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Oct 23 2012		|	Modified to add validation on save.
 * Kruti Doshi		|	Sep 15 2014		|	Modified as per new enhancement list given by client.
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="ContractInfoBlk">
		<h3 class="acc-title">
      		<liferay-ui:message key="contractInfoBlk.heading"/>
      	</h3>
		<div class="acc-content">
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%;">
				<tbody>
					<tr>
						<td class="req_label">
							<c:choose>
							<c:when test="${appForm.formType== 'HCPConsultant'}">
								<label for="contractInfo.customerName">
									<liferay-ui:message key="contractInfoBlk.label.consultantName" />
								</label>
							</c:when>
							<c:otherwise>
								<label for="contractInfo.customerName">
									<liferay-ui:message key="contractInfoBlk.label.customerName" />
								</label>
							</c:otherwise>
							</c:choose>							
							<span class="red_star">*</span>
						</td>
						<%-- DSI:START::Veera Reddy:: To add mandatory validation --%>
						<td class="form-item">
							<form:input path="contractInfo.customerName" cssClass="text-field textTip reqSave" maxlength="100"/>
						</td>
						<%-- DSI:END::Veera Reddy:: To add mandatory validation --%>
						<td class="req_label"></td>
						<td class="form-item"></td>
					</tr>
					<tr>
						<td class="req_label">
							<c:choose>
							<c:when test="${appForm.formType== 'CSAgreement'}">
								<label for="contractInfo.contractAddress.addressLine1">
									<liferay-ui:message key="contractInfoBlk.label.busAddressLine1" />
								</label>
							</c:when>
							<c:otherwise>
								<label for="contractInfo.contractAddress.addressLine1">
									<liferay-ui:message key="contractInfoBlk.label.addressLine1" />
								</label>
							</c:otherwise>
							</c:choose>							
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="contractInfo.contractAddress.addressLine1" cssClass="text-field required textTip" maxlength="250"/>
						</td>
						<td class="req_label">
							<c:choose>
							<c:when test="${appForm.formType== 'CSAgreement'}">
								<label for="contractInfo.contractAddress.addressLine2">
									<liferay-ui:message key="contractInfoBlk.label.busAddressLine2" />
								</label>
							</c:when>
							<c:otherwise>
								<label for="contractInfo.contractAddress.addressLine2">
									<liferay-ui:message key="contractInfoBlk.label.addressLine2" />
								</label>
							</c:otherwise>
							</c:choose>							
						</td>
						<td class="form-item">
							<form:input path="contractInfo.contractAddress.addressLine2" cssClass="text-field textTip" maxlength="250"/>
						</td>
					</tr>
					<tr>
						<td class="req_label" style="">
							<label for="contractInfo.contractAddress.city">
								<liferay-ui:message key="contractInfoBlk.label.city" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="contractInfo.contractAddress.city" cssClass="text-field required textTip" maxlength="250"/>
						</td>
						<td class="req_label">
							<label for="contractInfo.contractAddress.state">
								<liferay-ui:message key="contractInfoBlk.label.state" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:select path="contractInfo.contractAddress.state" cssClass="text-field required" style="width:133px;">
				                <form:option value="" label="Select State"/>
				                <form:options items= "${usStates}" />
				            </form:select>
						</td>
					</tr>
					<tr>
						<td class="req_label" style="">
							<label for="contractInfo.contractAddress.zipExtra">
								<label for="contractInfo.contractAddress.zip">
									<liferay-ui:message key="contractInfoBlk.label.zip" />
								</label>
								<span class="red_star">*</span>
							</label>
							
						</td>
						<td class="form-item vmid">
								<form:input path="contractInfo.contractAddress.zip" cssClass="text-field required reqZipCode" maxlength="5" style="width:57px;"/>
								-
						      	<form:input path="contractInfo.contractAddress.zipExtra" cssClass="text-field reqNumeric" maxlength="4" style="width:50px;" />
						</td>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
					<tr>
						<td class="req_label">
						<label for="contractInfo.payeeTaxIdSSN">
								<liferay-ui:message key="contractInfoBlk.label.payeeTaxIdSSN" />
						</label>						
						<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
						<c:choose>
						<c:when test="${appForm.formType== 'CSAgreement'}">						
							<form:input path="contractInfo.payeeTaxIdSSN" cssClass="text-field required" maxlength="11"/>
							&nbsp;<span class="font11"><liferay-ui:message key="checkReqInfoBlk.label.payeeTaxIdSSNNote" /></span>						
						</c:when>
						<c:otherwise>
							<form:input path="contractInfo.payeeTaxIdSSN" cssClass="text-field required" maxlength="11"/>
						</c:otherwise>
						</c:choose>
						</td>
					<tr>
						<td class="req_label" style="">
							<label for="contractInfo.contractSpecialist">
								<liferay-ui:message key="contractInfoBlk.label.contractSpecialist" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:select path="contractInfo.contractSpecialist" maxlength = "75" cssClass="text-field required" style="width:133px;margin-top:7px;" onchange="otherContract();">
					             <form:option value="" label="Select Specialist"/>
					             <form:options items= "${contractSpecialists}" />
					        </form:select>
						</td>
					</tr>
					<tr id="contractShow" style="display: none">
						<td class="req_label" style="">
							<label for="contractInfo.otherContract">
								<liferay-ui:message key="contractInfoBlk.label.contractOther" />
							</label>
						</td>
						<td class="form-item" colspan="3">
							<form:input path="contractInfo.otherContract"  cssClass="text-field" maxlength="75" value=""/>
						</td>
						
					</tr>
					<c:if test="${OBJECTID == '' || OBJECTID == null}">
						<tr>
							<td style="text-align: right; padding: 10px 0;" colspan="4">
	                    		<input type="button" value="<liferay-ui:message key="clearbutton.label" />" class="button input-button" onclick="javascript:clearContractInfoBlock(this);" />
							</td>
	  					</tr>
	  				</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>
<script type="text/javascript">
function otherContract(){
	if(j("#contractInfo\\.contractSpecialist").val()=="Other"){
		j("#contractInfo\\.otherContract").addClass('reqSave');
		j("#contractShow").show();
	} else {
		j("#contractInfo\\.otherContract").removeClass('reqSave');
		j("#contractInfo\\.otherContract").attr("value", '');
		j("#contractShow").hide();
	}
  
}
</script>