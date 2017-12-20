<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Resmy Mathew
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 22 2012		|	Modified to add validation onblur for the all textArea fields
 * Kruti Doshi		|	Sep 16 2014		|	Modified to add conditions on the basis of form to display different labels.
--%>
<%@ include file="/jsps/include/init_block.jsp" %>

<portlet:resourceURL var="popData" id="populateData" escapeXml="false">
	<portlet:param name="appAction" value=""/>
</portlet:resourceURL>

<portlet:resourceURL var="costOrWbsUrl" id="costOrWbs" escapeXml="false">
	<portlet:param name="appAction" value=""/>
</portlet:resourceURL>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="RequestorInfoBlk">
  		<h3 class="acc-title"><liferay-ui:message key="reqInfoBlk.heading" /></h3>
		<div class="acc-content">
            <table cellspacing="0" cellpadding="0" border="0" style="width: 100%;">
            	<tbody>
            	   <tr>
	            		<td class="nopad" ><img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt=" " /></td>
	            		<td class="nopad"></td>
	            		<td class="nopad" ><img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt=" " /></td>
	            		<td class="nopad"></td>
	            	</tr>
	            	<tr>
	            		<td colspan="4">
	            			<!--  hidden fields for autocomplete -->
			            	<input type="hidden" name="companyId" id="companyId" value="<%= themeDisplay.getCompanyId() %>" />
			            	<input type="hidden" name="costInfo" id="costInfo" value="costInfo" />
			            	<input type="hidden" name="wbs" id="wbs" value="wbselement" />
			            	<input type="hidden" name="requestor" id="requestor" value="requestor" />
			            	<input type="hidden" name="vicepresident" id="vicepresident" value="vicepresident" />
			            	<input type="hidden" name="manager" id="manager" value="manager" />
			            	<input type="hidden" name="costOrWbs" id="costOrWbs" value="<%=costOrWbsUrl.toString()%>" />
			            	<input type="hidden" name="wbsElementErrorList" id="wbsElementErrorList" value="" />
			            	<input type="hidden" name="costCenterErrorList" id="costCenterErrorList" value="" />
	            		</td>
	            	</tr>
	                <tr>
	                    <td class="req_label">
	                    	<label for="reqInfo.requestorName">
	                    		<liferay-ui:message key="reqInfoBlk.label.reqname" />
	                    	</label>
	                    	<span class="red_star">*</span> 
	                    </td>
	                    <td class="form-item">
	                    	<form:input path="reqInfo.requestorName" cssClass="text-field required reqAutoPickList textTip" maxlength="250" style="width:106px;" onkeypress="resetRequestor(event);" />
	                    	<img src="<%= ctxPath %>/images/information.png" class="autoPickListTip" />
	                    	<c:if test="${appForm.formType != 'CharitableDonation'}">
	                    	<form:hidden path="reqInfo.requestorId"  value=""  onchange="populateRequest();" />
	                    	</c:if>
	                    	<c:if test="${appForm.formType == 'CharitableDonation'}">
	                    	<form:hidden path="reqInfo.requestorId"  value=""  onchange="populateCCRequest();" />
	                    	</c:if>
	                    	<form:hidden path="reqInfo.requestorEmployeeId" value="" />
	                    	<form:hidden path="reqInfo.createdUserEmployeeId" value=""/>
	                    </td>
	                    <td colspan="2">
	                    	<input type="checkbox" id="createdByCheckBox" name="createdByCheckBox" onclick="chkShowHideCreatedBy(this);" />&nbsp;
	                    	<span class="font11 bold"><b>Are you filing the request on behalf of requestor?</b></span>
	                    </td>
	                </tr>
	                 <tr id="createdDiv" style="display: none"> 
	                   <td class="req_label"><liferay-ui:message key="reqInfoBlk.label.createdby" /></td>
	                   <td class="form-item"><c:out value="${appForm.reqInfo.createdBy}" /></td>
	                   <td class="nopad" colspan="2"><form:hidden path="reqInfo.createdBy"/></td>
	                </tr>
	               
					<tr>
						<c:if test="${appForm.formType != 'CharitableDonation'}">
						<td class="req_label">
							<input type="radio" id="costCenterRadio" name="costwbs" vak="test2"  onClick="changeSettings('cost');" class="required reqcostCenterRadio"/>
							<label for="costwbs" vak="test2">
								<!-- <label for="reqInfo.costCenter"> -->
									<liferay-ui:message key="reqInfoBlk.label.costCenter" />
								<!-- </label> -->
							</label>
						</td>
						<td class="form-item">
							<input id="costCenterText" class="text-field" name="costCenterText" style="width: 106px;" maxlength="250" autocomplete="on" onblur="costOrWbsDataValidation('costInfo',this.value)"  />
							<input type="hidden" name="costCenterId" id="costCenterId" value="" />
							<a style="text-decoration:none;" href="javascript:void(0);" onClick="appendCostText();" class="costcenter"><img src="<%= ctxPath %>/images/plus.png"/></a>
						</td>
						<td class="req_label"> 
							<input type="radio" id="wbsElementRadio" name="costwbs" vak="test1" onClick="changeSettings('wbs');" class="reqwbsElementRadio"/>
							<label for="costwbs" vak="test1">
								<liferay-ui:message key="reqInfoBlk.label.wbsElement" />
							</label>
						</td>
						<td class="form-item">
							<input name="wbsElementText" class="text-field" id="wbsElementText" style="width: 106px;" maxlength="250" onchange="resetCostCenter()"; autocomplete="on" onblur="costOrWbsDataValidation('wbselement',this.value)"/>
							<input type="hidden" id="wbsElementId" name="wbsElementId"  value="" />
							<a style="text-decoration:none;" href="javascript:void(0);" onClick="appendWbsText();" class="wbs"><img src="<%= ctxPath %>/images/plus.png"/></a>
						</td>
						</c:if>
						<c:if test="${appForm.formType == 'CharitableDonation'}">
						<td class="req_label">
							<!-- <input type="radio" id="costCenterRadio" name="costwbs" vak="test2"  onClick="changeSettings('cost');" class="reqcostCenterRadio"/> -->
							<label for="costwbs" vak="test2">
								<!-- <label for="reqInfo.costCenter"> -->
									<liferay-ui:message key="reqInfoBlk.label.costCenter" />
								<!-- </label> -->
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<input id="costCenterText" vak="test2" class="text-field reqcostCenterText" name="costCenterText" style="width: 106px;" maxlength="250" autocomplete="on" onfocus="enableCostCenter()" onblur="costOrWbsDataValidation('costInfo',this.value)"  />
							<input type="hidden" name="costCenterId" id="costCenterId" value="" />
							<a style="text-decoration:none;" href="javascript:void(0);" onClick="appendCharitableCostText();" class="costcenter"><img src="<%= ctxPath %>/images/plus.png"/></a>
						</td>
						<td colspan="2"></td>
						</c:if>
					</tr>
					<tr>
					<td colspan="4" style="padding:5px"> 
					<label style="float:left;padding:0 0px 0 5px">
						<c:if test="${appForm.formType != 'CharitableDonation'}">
							<liferay-ui:message key="reqInfoBlk.label.costcenterNote" />
						</c:if>
						<c:if test="${appForm.formType == 'CharitableDonation'}">
							<liferay-ui:message key="reqInfoBlk.label.costcenterNoteOnly" />
						</c:if>
					</label>
					</td>
					</tr>
					<tr>
						<td class="nopad" ></td>
						<td class="form-item nopad">
							<form:textarea path="reqInfo.costCenter" cssClass="cmmntbxful costcenterrow" onkeydown="limitText(this,250);" onkeyup="requestInfoLimitText(this,250,'costInfo');" onblur="requestInfoLimitText(this,250,'costInfo');" onchange="costOrWbsDataValidation('costInfo',this.value)"/>
	                    </td>
	                    <td class="nopad"></td>
	                    <c:choose>
						<c:when test="${appForm.formType != 'CharitableDonation'}">
						<td class="form-item nopad">
							<form:textarea path="reqInfo.wbsElement" cssClass="cmmntbxful wbsrow" onkeydown="limitText(this,250);" onkeyup="requestInfoLimitText(this,250,'wbselement');" onblur="requestInfoLimitText(this,250,'wbselement');" onchange="costOrWbsDataValidation('wbselement',this.value)"/>
						</td>
						</c:when>
						<c:otherwise>
						<td class="nopad"></td>
						</c:otherwise>
						</c:choose>
					</tr>
	                <tr>
	                    <td class="req_label">
	                    	<label for="reqInfo.deptTerritory">
	                    		<liferay-ui:message key="reqInfoBlk.label.deptTerritory" />
	                    	</label>
	                    	<span class="red_star">*</span>
	                    </td>
	                    <td class="form-item">
	                    	<form:input path="reqInfo.deptTerritory" cssClass="text-field required textTip" maxlength="250" style="margin-right:20px;"/>
	                    </td>
	                    <td class="req_label">
	                    	<label for="reqInfo.email">
	                   			<liferay-ui:message key="reqInfoBlk.label.email" />
	                   		</label>
	                   	</td>
	                    <td>
	                    	<form:input path="reqInfo.email" cssClass="text-field required reqEmailAddress textTip" maxlength="250" readOnly="true" style="margin-right:20px;"/>
	                  
	                    </td>
	               	</tr>
	                <tr>
	                    <td class="req_label">
	                    	<label for="reqInfo.businessPhone">
	                    		<liferay-ui:message key="reqInfoBlk.label.bPhone" />
	                    	</label>
	                    	<span class="red_star">*</span>
	                    </td>
	                    <td class="form-item">
	                    	<form:input path="reqInfo.businessPhone" cssClass="text-field required reqPhoneNumber" style="width:106px;" maxlength="12"/>
							<img src="<%= ctxPath %>/images/information.png" class="phoneTip" />
	                    </td>
	                    <td class="req_label">
	                    	<label for="reqInfo.dateCompleted">
	                    		<liferay-ui:message key="reqInfoBlk.label.dateCompleted" />
	                    	</label>
	                     </td>
	                    <td class="form-item" style="vertical-align:middle;">
	                    	<form:input path="reqInfo.dateCompleted" cssClass="text-field dateIp" cssStyle="border:none;background:none;" maxlength="250"/>
	                    </td>
	                </tr>
	               <c:if test="${appForm.formType != 'AdvBoard' && appForm.formType != 'HCPConsultant'}">
		                <tr>
		                    <td class="req_label">
		                    	<label for="reqInfo.managerName">
		                    		<liferay-ui:message key="reqInfoBlk.label.managerName" />
		                   		</label>
		                   		<span class="red_star">*</span>
		                   	</td>
		                    <td class="form-item">
		                    	<form:input path="reqInfo.managerName" cssClass="text-field required reqAutoPickList textTip" maxlength="250" onkeypress="resetManager(event);" style="width:106px;"/>
		                    	<img src="<%= ctxPath %>/images/information.png" class="autoPickListTip" />
		                    </td>
		                    <td class="req_label">
		                    	<label for="reqInfo.managerEmail">
		                    		<liferay-ui:message key="reqInfoBlk.label.managerEmail" />
		                    	</label>
		                    </td>
		                    <td>
		                    	<form:input path="reqInfo.managerEmail" cssClass="text-field required reqEmailAddress textTip" maxlength="250" readOnly="true"/>
		                    	<form:hidden path="reqInfo.managerEmployeeId" />
		                 
		                    </td>
		                </tr>
	                </c:if>
	               	<c:if test="${appForm.formType == 'AdvBoard'}">
	               		<tr>
	               			<td class="req_label">
	               				<label for="advisoryBoardInfo.isSubmIncludeAEP">
									<liferay-ui:message key="checkReqInfoBlk.label.submissionQues" />
								</label>	
							</td>
							<td class="form-item">
	                        	<div class="marginbtm">
									<form:radiobutton id="isSubmIncludeAEP" path="advisoryBoardInfo.isSubmIncludeAEP" value="true" cssClass="ques_radio required"  onClick="validateRequestorSubmRow(true);"/>
									<liferay-ui:message key="blk.label.yes" />
									<form:radiobutton path="advisoryBoardInfo.isSubmIncludeAEP" value="false" cssClass="ques_radio" onClick="validateRequestorSubmRow(false);"/>
									<liferay-ui:message key="blk.label.no" />
								</div>
							</td>
						</tr>
						<tr>							
							<td class="req_label">
								<div id="requestorReferenceNumber">
								<label for="advisoryBoardInfo.aepExplaination">
									<liferay-ui:message key="checkReqInfoBlk.label.referenceNumber" />	
								</label>							
								</div>
								<div id="requestorReason">
								<label for="advisoryBoardInfo.aepExplaination">
									<liferay-ui:message key="checkReqInfoBlk.label.reason" />
								</label>
								</div>
								<span class="red_star">*</span>
							</td>							 
							<td class="form-item" colspan="3">
									<form:textarea path="advisoryBoardInfo.aepExplaination" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
							</td>
						</tr>
					</c:if>
					<c:if test="${appForm.formType == 'HCPConsultant'}">
	               		<tr>
	               			<td class="req_label">
	               				<label for="hcpConsultantInfo.isSubmIncludeAEP">
									<liferay-ui:message key="checkReqInfoBlk.label.submissionQues" />
								</label>
							</td>
							<td class="form-item">
	                        	<div class="marginbtm">
									<form:radiobutton id="isSubmIncludeAEP" path="hcpConsultantInfo.isSubmIncludeAEP" value="true" cssClass="ques_radio required"  onClick="validateRequestorSubmRow(true);"/>
									<liferay-ui:message key="blk.label.yes" />
									<form:radiobutton path="hcpConsultantInfo.isSubmIncludeAEP" value="false" cssClass="ques_radio" onClick="validateRequestorSubmRow(false);"/>
									<liferay-ui:message key="blk.label.no" />
								</div>
							</td>
						</tr>
						<tr>							
							<td class="req_label">
								<div id="requestorReferenceNumber">
								<label for="hcpConsultantInfo.aepExplaination">
									<liferay-ui:message key="checkReqInfoBlk.label.referenceNumber" />
								</label>								
								</div>
								<div id="requestorReason">
									<label for="hcpConsultantInfo.aepExplaination">
										<liferay-ui:message key="checkReqInfoBlk.label.reason" />
									</label>
								</div>
								<span class="red_star">*</span>
							</td>							 
							<td class="form-item" colspan="3">
									<form:textarea path="hcpConsultantInfo.aepExplaination" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
							</td>
						</tr>
					</c:if>
	               	<c:if test="${appForm.formType == 'AdvBoard' || appForm.formType == 'HCPConsultant'}">												
 	                	<tr>
		                    <td class="req_label">
		                    	<label for="reqInfo.vpName">
		                    		<liferay-ui:message key="reqInfoBlk.label.vpName"  />
		                    	</label>
		                    	<span class="red_star">*</span>
		                    </td>
		                    <td class="form-item">
		                    	<form:input path="reqInfo.vpName" cssClass="text-field required reqAutoPickList textTip" maxlength="250" onkeypress="resetVicePresident(event);" style="width:106px;"/>
		                    	<img src="<%= ctxPath %>/images/information.png" class="autoPickListTip" />
		                    	<form:hidden path="reqInfo.vpEmployeeId" />
		                    </td>
		                    <td class="req_label">
		                    	<label for="reqInfo.vpEmail">
		                    		<liferay-ui:message key="reqInfoBlk.label.vpEmail" />
		                    	</label>
		                    </td>
		                    <td>
		                    	<form:input path="reqInfo.vpEmail" cssClass="text-field required reqEmailAddress textTip" maxlength="250" readOnly="true"/>
		                    </td>
	           	 		</tr>
	           		</c:if>
	             	<tr>
	             		<td colspan="4">
	             		    <c:if test="${appForm.formType != 'AdvBoard' && appForm.formType != 'HCPConsultant'}">
		             			<form:checkbox path="reqInfo.mApprovalReq" cssClass="required" style="float:left;"/>
								<label for="reqInfo.mApprovalReq" style="float:left;padding:0 40px 0 5px">
									<liferay-ui:message key="reqInfoBlk.label.mApprovalReq" />
									<span class="red_star">*</span>
								</label>
								
							</c:if>
	                 		<c:if test="${appForm.formType == 'AdvBoard' || appForm.formType == 'HCPConsultant'}">
								<form:checkbox path="reqInfo.vpApprovalReq" cssClass="required vpApprovalReqCheck" style="float:left"/>
								<label for="reqInfo.vpApprovalReq" style="float:left;padding:0 0px 0 5px">
									<liferay-ui:message key="reqInfoBlk.label.vpApprovalReq" />
								<span class="red_star">*</span>
								</label>
							</c:if>
						</td>
			  		</tr> 
	          	  	<tr>
				    	<td colspan="4" style="padding:5px">
		    				<label>
		    					<c:if test="${appForm.formType != 'AdvBoard' && appForm.formType != 'CharitableDonation' && appForm.formType != 'HCPConsultant'}">
		    						<liferay-ui:message key="reqInfoBlk.label.approvalNote" />
		    					</c:if>
	                 			<c:if test="${appForm.formType == 'CharitableDonation'}">
		    						<liferay-ui:message key="reqInfoBlk.label.approvalNoteForDonation" />
		    					</c:if>
		    					<c:if test="${appForm.formType == 'HCPConsultant'}">
		    						<liferay-ui:message key="reqInfoBlk.label.approvalNoteDirector" />
		    					</c:if>
		    				</label>
		    			</td>
		    		</tr>
		    		<c:if test="${OBJECTID == '' || OBJECTID == null}">
		                <tr>
		                    <td style="text-align: right; padding: 10px 0;" colspan="4">
		                        <input type="button" value="<liferay-ui:message key="clearbutton.label" />" class="button input-button" onclick="javascript:clearRequestorBlock(this);" />
		                    </td>
		                </tr>
	               </c:if>
	      		</tbody>
            </table>
        </div>
    </td>
</tr>
<script type="text/javascript">


	function populateRequest()
	{
		var requestorId = j("#reqInfo\\.requestorId").val();
		var url = "<%= popData %>";
		j.getJSON(url + '&requestorId='+requestorId, function(data) {
			j("#reqInfo\\.requestorName").val(data.name);
			j("#reqInfo\\.email").val(data.email);
			j("#reqInfo\\.requestorEmployeeId").val(data.requestorEmployeeId);
			if (data.costCenter == '') {
				j("#costCenterRadio").attr("checked", true);
				j(".wbsrow").hide();
				j(".costcenterrow").hide();
				j("textarea.wbsrow").attr("value", '');
				j("#wbsElementText").attr("value", '');
				j("textarea.costcenterrow").attr("value", '');
				j("#costCenterText").attr("value", '');
				j("#wbsElementText").attr("readonly", "readonly");
				j("#costCenterText").removeAttr('readonly');
				j("#reqInfo\\.wbsElement").removeClass("required");
				j("#reqInfo\\.costCenter").addClass("required");
			} else {
				j("#reqInfo\\.costCenter").addClass("required");
				j("#reqInfo\\.wbsElement").removeClass("required");
				j("#costCenterRadio").attr("checked", true);
				j(".wbsrow").hide();
				j(".costcenterrow").show();
				j("#wbsElementText").attr("readonly", "readonly");
				j("textarea.wbsrow").attr("value", '');
				j("#wbsElementText").attr("value", '');
				j("textarea.costcenterrow").val(data.costCenter);
			}
			j("#reqInfo\\.deptTerritory").val(data.deptTerritory);
			j("#reqInfo\\.businessPhone").val(data.businessPhone);
			j("#reqInfo\\.managerName").val(data.managerName);
			j("#reqInfo\\.managerEmail").val(data.managerEmail);
			//Removing Validations Class
		    j('.invalidFieldDesc').remove();
		    j("label").removeClass("validationError");
		});
	} 
	
	function populateCCRequest()
	{
		var requestorId = j("#reqInfo\\.requestorId").val();
		var url = "<%= popData %>";
		j.getJSON(url + '&requestorId='+requestorId, function(data) {
			j("#reqInfo\\.requestorName").val(data.name);
			j("#reqInfo\\.email").val(data.email);
			j("#reqInfo\\.requestorEmployeeId").val(data.requestorEmployeeId);
			
			alert("data.costCenter->"+data.costCenter);
			if (data.costCenter == '') {
				j(".costcenterrow").hide();
				j("textarea.costcenterrow").attr("value", '');
				j("#costCenterText").attr("value", '');
				j("#costCenterText").removeAttr('readonly');
			}
			
			j("#reqInfo\\.deptTerritory").val(data.deptTerritory);
			j("#reqInfo\\.businessPhone").val(data.businessPhone);
			j("#reqInfo\\.managerName").val(data.managerName);
			j("#reqInfo\\.managerEmail").val(data.managerEmail);
			//Removing Validations Class
		    j('.invalidFieldDesc').remove();
		    j("label").removeClass("validationError");
		});
	} 
	
	function enableCostCenter(){
		j("#costCenterText").removeAttr('readonly');
	}
	
</script>