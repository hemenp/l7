<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Kruti Doshi
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="GeneralRequestBlk">
		<h3 class="acc-title"><liferay-ui:message key="generalRequestInfoBlk.heading" /></h3>
		<div class="acc-content" style="display: block;">
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
					<tr>
						<td class="twocallft" >
							<label for="requestInfo.projectName">
								<liferay-ui:message key="generalRequestInfoBlk.label.name" /> <span class="red_star">*</span>
							</label>
						</td>
						<td class="form-item"  colspan="2">
							<form:textarea path="requestInfo.projectName" cssClass="cmmntbxful required" onkeydown="limitText(this,250);" onkeyup="limitText(this,250);" onblur="limitText(this,250);"/>							
						</td>												
					</tr>
					<tr>
						<td class="twocallft">
							<label for="requestInfo.isCustInvolved">
								<liferay-ui:message key="generalRequestInfoBlk.label.isCustomerInvolved" /> <span class="red_star">*</span>
							</label>
						</td>
						<td class="form-item">
                        	<div class="marginbtm">
								<form:radiobutton id="isCustInvolved" path="requestInfo.isCustInvolved" value="true" cssClass="ques_radio required" onClick="validateGeneralReqCustRow(true);"/>
								<liferay-ui:message key="blk.label.yes" />
								<form:radiobutton path="requestInfo.isCustInvolved" value="false" cssClass="ques_radio" onClick="validateGeneralReqCustRow(false);"/>
								<liferay-ui:message key="blk.label.no" />
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="twocalrht vtop" colspan="3">
							<div id="generalReqCustRow">
								<table width="100%" border="0">
						  			<tr>
								    	<td class="req_label">
								    		<label for="requestInfo.custInvolved">
								    			<liferay-ui:message key="generalRequestInfoBlk.label.howCustomerInvolved" />
								    		</label>
								    		<span class="red_star">*</span>
								    	</td>
								    </tr>
								    <tr>
										<td class="form-item" colspan="3">
											<form:textarea path="requestInfo.custInvolved" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
										</td>
								  	</tr>								  	
								</table>
							</div>
				 		</td>												
					</tr>
								
					<tr>
						<td class="twocallft">
							<label for="requestInfo.businessNeed">
								<liferay-ui:message key="generalRequestInfoBlk.label.businessNeed" /> <span class="red_star">*</span>
							</label>
						</td>
						<td class="form-item" colspan="2">
							<form:textarea path="requestInfo.businessNeed" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
						</td>												
					</tr>
					<tr>
						<td class="twocallft">
							<label for="requestInfo.isHCPInfoProvided">
								<liferay-ui:message key="generalRequestInfoBlk.label.informationQues" /> <span class="red_star">*</span>
							</label>
						</td>
						<td class="form-item">
                        	<div class="marginbtm">
								<form:radiobutton id="isHCPInfoProvided" path="requestInfo.isHCPInfoProvided" value="true" cssClass="ques_radio required" onClick="validateGeneralReqQuesRow(true);"/>
								<liferay-ui:message key="blk.label.yes" />
								<form:radiobutton path="requestInfo.isHCPInfoProvided" value="false" cssClass="ques_radio" onClick="validateGeneralReqQuesRow(false);"/>
								<liferay-ui:message key="blk.label.no" />
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="twocalrht vtop" colspan="3">
							<div id="generalReqQuesRow">
								<table width="100%" border="0">
						  			<tr>
								    	<td class="req_label">
								    		<label for="requestInfo.purposeInfo">
								    			<liferay-ui:message key="generalRequestInfoBlk.label.information" /> <span class="red_star">*</span>
								    		</label>
								    		<span class="red_star">*</span>
								    	</td>
								    </tr>
								    <tr>
										<td class="form-item" colspan="3">
											<form:textarea path="requestInfo.purposeInfo" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
										</td>
								  	</tr>								  	
								</table>
							</div>
				 		</td>												
					</tr>
					<tr>
						<td class="twocallft">
							<label for="requestInfo.itemDescription">
								<liferay-ui:message key="generalRequestInfoBlk.label.description" /> <span class="red_star">*</span>
							</label>	
						</td>
						<td class="form-item" colspan="2">
							<form:textarea path="requestInfo.itemDescription" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
						</td>												
					</tr>
					<tr>
						<td class="twocallft">
							<label for="requestInfo.promotionalActivity">
								<liferay-ui:message key="generalRequestInfoBlk.label.promotionalActivity" /> <span class="red_star">*</span>
							</label>	
						</td>
						<td class="form-item">
                        	<div class="marginbtm">
								<form:radiobutton path="requestInfo.promotionalActivity" value="true" cssClass="ques_radio required" />
								<liferay-ui:message key="blk.label.yes" />
								<form:radiobutton path="requestInfo.promotionalActivity" value="false" cssClass="ques_radio" />
								<liferay-ui:message key="blk.label.no" />
							</div>
						</td>												
					</tr>
					<tr>
						<td class="btmbrddiv" colspan="4"></td>
					</tr>
					<tr>
						<td class="req_label" colspan="3">
							<strong class="bold">
								<liferay-ui:message key="generalRequestInfoBlk.subheading.attach" />
							</strong>
							<br /><br />
							<liferay-ui:message key="generalRequestInfoBlk.label.attachmentDescription" />
						</td>												
					</tr>
					<tr>
						<td class="" colspan="4">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>									
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="requestInfo_otherDocumentsList">
												<liferay-ui:message key="generalRequestInfoBlk.label.other" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="requestInfo_otherDocumentsList" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.requestInfo.otherDocumentsExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                         <tbody>
			                                             <c:forEach items="${appForm.requestInfo.otherDocumentsExistingFile}" var="materialsListFile">
			                                                 <c:if test="${viewMode == 'view'}">
			                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="100%">
			                                                           	<a id="requestInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                   	</tr>
			                                                 </c:if>
			                                                 <c:if test="${saveAction == 'update'}">
			                                                   	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="85%">
			                                                           	<a id="requestInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                         <td class="colm-2">
						                                            	<a id="requestInfo_otherDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
					                                                </td>
			                                                   	</tr>
			                                                </c:if>
														</c:forEach>
			                                         </tbody>
			                                     </table>
											</c:if>																
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>														
				</tbody>
			</table>
		</div>
	</td>
</tr>
<script type="text/javascript">

</script>