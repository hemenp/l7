<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 22 2012		|	Modified to add validation onblur for the all textArea fields
 *
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="POMembershipBlk">
		<h3 class="acc-title">
			<liferay-ui:message key="poMembershipInfoBlk.heading" />
		</h3>
       	<div class="acc-content">
   			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
                   	<tr>
						<td colspan="2" width="50%" class="nopad"></td>
						<td colspan="2" width="50%" class="nopad"></td>
				    </tr>
					<tr>
						<td class="req_label">
							<label for="pOMemInfo.orgName">
								<liferay-ui:message key="poMembershipInfoBlk.label.orgName" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="pOMemInfo.orgName" cssClass="text-field required textTip" maxlength="250"/>
						</td>
						<td class="req_label" style=""></td>
						<td class="form-item"></td>
			 		</tr>
			    	<tr>
			    		<td class="req_label">
							<label for="pOMemInfo.orgWebSiteAddress">
								<liferay-ui:message key="poMembershipInfoBlk.label.orgWebSiteAddress" />
							</label>
						</td>
						<td colspan="3" class="form-item">
							<form:input path="pOMemInfo.orgWebSiteAddress" maxlength="300"  cssClass="text-field textTip"/>
						</td>
		        	</tr>
			   		<tr>
			   			<td class="req_label">
							<label for="pOMemInfo.membershipBusinessNeeds">
								<liferay-ui:message key="poMembershipInfoBlk.label.membershipBusinessNeeds" />
							</label>
							<span class="red_star">*</span>
						</td>
				    	<td colspan="3" class="form-item">
				    		<form:textarea path="pOMemInfo.membershipBusinessNeeds" cssClass="text-field cmmntbxful required" style="height:50px" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
				    	</td>
			   		</tr>
                          <tr>
                          	<td class="req_label">
							<label for="pOMemInfo.membershipBenifits">
								<liferay-ui:message key="poMembershipInfoBlk.label.membershipBenifits" />
							</label>
							<span class="red_star">*</span>
						</td>
				   		<td colspan="3" class="form-item">
				   			<form:textarea path="pOMemInfo.membershipBenifits" cssClass="text-field cmmntbxful required" style="height:50px" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
				   		</td>
			    	</tr>
					<tr>
						<td class="req_label"><liferay-ui:message key="poMembershipInfoBlk.label.membershipY/M" /></td>
						<td colspan="3" class=" nopad">
							<table width="0" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<label for="pOMemInfo.membershipYears">
											<liferay-ui:message key="poMembershipInfoBlk.label.membershipYears" />
										</label>
								  		<form:input path="pOMemInfo.membershipYears" cssClass="text-field reqNumeric" maxlength="2" style="margin-right: 10px;width:50px;" />
								  	</td>
								    <td>
										<label for="pOMemInfo.membershipMonths">
											<liferay-ui:message key="poMembershipInfoBlk.label.membershipMonths" />
										</label>
								  		<form:select path="pOMemInfo.membershipMonths" style="width:50px">
								  		 <form:options items= "${monthValues}" />
								  		 </form:select>
								  	</td>
								</tr>
				       		</table>
				       </td>
					</tr>
					<tr>
						<td colspan="4"><strong class="bold"><liferay-ui:message key="poMembershipInfoBlk.note1" /></strong></td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="pOMemInfo.membershipFee">
								<liferay-ui:message key="poMembershipInfoBlk.label.membershipFee" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<strong>$</strong> 
							<form:input path="pOMemInfo.membershipFee" cssClass="text-field required feeTextField" maxlength="20" onchange="formatCurrency(this);"/>
					    </td>
						<td colspan="2" class="form-item">
					    </td>
					</tr>
				    <tr>
				  		<td colspan="4" class="btmbrddiv" >&nbsp;</td>
				    </tr>
					<tr>
				  		<td colspan="4">
				  			<strong class="bold"><liferay-ui:message key="poMembershipInfoBlk.subtopic" /></strong><br /><br />
							<liferay-ui:message key="poMembershipInfoBlk.attachment.description" />
						</td>
	    			</tr>
					<tr>
				  		<td colspan="4" class="nopad">
				  			<table width="100%" cellspacing="0" cellpadding="0" border="0">
						 		<tbody>
                                     <tr>
									 	<td style="padding:0px 0;width:350px;">
									   		<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tbody>
													<tr class="checkboxclickMulti">
														<td class="check-width">
															<input type="checkbox" name="checkbox" class="addAttachments" value="dispaly1">
														</td>
														<td>
															<label for="pOMemInfo.membershipBroucher">
																<liferay-ui:message key="poMembershipInfoBlk.label.membershipBroucher" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="pOMemInfo.membershipBroucher" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.pOMemInfo.membershipBroucherExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.pOMemInfo.membershipBroucherExistingFile}" var="membershipBroucherFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${membershipBroucherFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="pOMemInfo_memBroucher" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${membershipBroucherFile.fileName}');"><c:out value="${membershipBroucherFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${membershipBroucherFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="pOMemInfo_memBroucher" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${membershipBroucherFile.fileName}');"><c:out value="${membershipBroucherFile.fileName}" /></a>
							                                                        </td>
							                                                       	<td class="colm-2">
										                                            	<a id="po_memBroucher_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
									                                                </td>
						                                                    	</tr>
						                                                    </c:if>
																		</c:forEach>
				                                                    </tbody>
			                                            		</table>
															</c:if>
														</td>
													</tr>
													<tr class="checkboxclickMulti">
														<td class="check-width">
															<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly2">
														</td>
														<td>
															<label for="pOMemInfo.completedW9">
																<liferay-ui:message key="poMembershipInfoBlk.label.completedW9" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="pOMemInfo.completedW9" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.pOMemInfo.completedW9ExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.pOMemInfo.completedW9ExistingFile}" var="completedW9File">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="pOMemInfo_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="pOMemInfo_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="po_cW9_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
							 		<tr>
									     <td colspan="2" >
	                                		<strong class="bold">
	                                			<liferay-ui:message key="poMembershipInfoBlk.note" /><br/>
	                                			<liferay-ui:message key="attachment.allowed.types" />
	                                		</strong>
	                                	</td>
							 		</tr>
						    	</tbody>
							</table>
						</td>
				    </tr>
				    <c:if test="${OBJECTID == '' || OBJECTID == null}">
						<tr>
					  		<td class="req_label">
					  			<img src="/o/pgc-portlet/images/spacer.gif" width="175" height="1" alt="" />
					  		</td>
						  	<td style="text-align:right;padding:10px 0;" colspan="3">
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearPoMemberShipBlock(this);" />
							</td>
					    </tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>