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
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="CharityDonationBlk">
		<h3 class="acc-title"><liferay-ui:message key="charityDonationInfoBlk.heading" /></h3>
		<div class="acc-content" style="display: block;">
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
					<%-- <tr>
						<td class="req_label">
							<label for="donationInfo.recipientName">
								<liferay-ui:message key="charityDonationInfoBlk.label.recipientName" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="donationInfo.recipientName" maxlength="100" cssClass="text-field reqSave" />
						</td>						
					</tr>
					<tr>
						<td colspan="2" class="red_star">
							<strong class="bold">
								<liferay-ui:message key="charityDonationInfoBlk.label.note" /><br />								
							</strong>
						</td>												
					</tr>
					<tr>
						<td class="req_label">
							<label for="donationInfo.donationPurpose">
								<liferay-ui:message key="charityDonationInfoBlk.label.purpose" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="donationInfo.donationPurpose" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>							
						</td>						
					</tr>
					<tr>
						<td class="req_label">
							<label for="donationInfo.donationAmount">
								<liferay-ui:message key="charityDonationInfoBlk.label.donationAmount" />
							</label>
							<span class="red_star">*</span>
						</td>
						
						<td class="form-item">							
							<form:input path="donationInfo.donationAmount" cssClass="text-field required" style="width:115px;" maxlength="10" onchange="formatCurrency(this);"/>
						</td>						
					</tr>
					<tr>
						<td class="btmbrddiv" colspan="4"></td>
					</tr> --%>
					<tr>
						<td class="req_label" colspan="3">
							<strong class="bold">
								<liferay-ui:message key="charityDonationInfoBlk.subheading.attach" />
							</strong>
							<br /><br />
							<liferay-ui:message key="charityDonationInfoBlk.label.attachmentDescription" />
						</td>												
					</tr>							
					<tr>
						<td class="" colspan="4">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<%-- <tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_w9FormList">
												<liferay-ui:message key="charityDonationInfoBlk.label.completedW9" />
											</label>
											<input type="file" name="donationInfo_w9FormList" class="margintp fileupload multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.w9FormListExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                        <tbody>
			                                           <c:forEach items="${appForm.donationInfo.w9FormListExistingFile}" var="materialsListFile">
			                                              <c:if test="${viewMode == 'view'}">
			                                               	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                     <td width="100%">
			                                                        	<a id="donationInfo_w9Form" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                     </td>
			                                                </tr>
			                                               </c:if>
			                                               <c:if test="${saveAction == 'update'}">
			                                                 <tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                    <td width="85%">
			                                                       	<a id="donationInfo_w9Form" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                    </td>
			                                                    <td class="colm-2">
				                                            		<a id="donationInfo_w9Form_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
			                                                	</td>
			                                                 </tr>
			                                               </c:if>
														</c:forEach>
			                                      </tbody>
			                                   </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_otherDocumentsList">
												<liferay-ui:message key="charityDonationInfoBlk.label.other" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="donationInfo_otherDocumentsList" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.otherDocumentsExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                         <tbody>
			                                             <c:forEach items="${appForm.donationInfo.otherDocumentsExistingFile}" var="materialsListFile">
			                                                 <c:if test="${viewMode == 'view'}">
			                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="100%">
			                                                           	<a id="donationInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                   	</tr>
			                                                 </c:if>
			                                                 <c:if test="${saveAction == 'update'}">
			                                                   	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="85%">
			                                                           	<a id="donationInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                         <td class="colm-2">
						                                            	<a id="donationInfo_otherDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
					                                                </td>
			                                                   	</tr>
			                                                </c:if>
														</c:forEach>
			                                         </tbody>
			                                     </table>
											</c:if>																
										</td>
									</tr> --%>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_cyberGrantsList">
												<liferay-ui:message key="charityDonationInfoBlk.label.cyber" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="donationInfo_cyberGrantsList" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.cyberGrantsExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                         <tbody>
			                                             <c:forEach items="${appForm.donationInfo.cyberGrantsExistingFile}" var="materialsListFile">
			                                                 <c:if test="${viewMode == 'view'}">
			                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="100%">
			                                                           	<a id="donationInfo_cyberDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                   	</tr>
			                                                 </c:if>
			                                                 <c:if test="${saveAction == 'update'}">
			                                                   	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="85%">
			                                                           	<a id="donationInfo_cyberDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                         <td class="colm-2">
						                                            	<a id="donationInfo_cyberDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
					                                                </td>
			                                                   	</tr>
			                                                </c:if>
														</c:forEach>
			                                         </tbody>
			                                     </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_proposedAgendaList">
												<liferay-ui:message key="charityDonationInfoBlk.label.agenda" />
											</label>
											<input type="file" name="donationInfo_proposedAgendaList" class="margintp fileupload multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.proposedAgendaExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                        <tbody>
			                                           <c:forEach items="${appForm.donationInfo.proposedAgendaExistingFile}" var="materialsListFile">
			                                              <c:if test="${viewMode == 'view'}">
			                                               	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                     <td width="100%">
			                                                        	<a id="donationInfo_agendaDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                     </td>
			                                                </tr>
			                                               </c:if>
			                                               <c:if test="${saveAction == 'update'}">
			                                                 <tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                    <td width="85%">
			                                                       	<a id="donationInfo_agendaDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                    </td>
			                                                    <td class="colm-2">
				                                            		<a id="donationInfo_agendaDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
			                                                	</td>
			                                                 </tr>
			                                               </c:if>
														</c:forEach>
			                                      </tbody>
			                                   </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_requestLetterList">
												<liferay-ui:message key="charityDonationInfoBlk.label.requestletter" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="donationInfo_requestLetterList" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.requestLetterExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                         <tbody>
			                                             <c:forEach items="${appForm.donationInfo.requestLetterExistingFile}" var="materialsListFile">
			                                                 <c:if test="${viewMode == 'view'}">
			                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="100%">
			                                                           	<a id="donationInfo_requestDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                   	</tr>
			                                                 </c:if>
			                                                 <c:if test="${saveAction == 'update'}">
			                                                   	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="85%">
			                                                           	<a id="donationInfo_requestDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                         <td class="colm-2">
						                                            	<a id="donationInfo_requestDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
					                                                </td>
			                                                   	</tr>
			                                                </c:if>
														</c:forEach>
			                                         </tbody>
			                                     </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_budgetList">
												<liferay-ui:message key="charityDonationInfoBlk.label.budget" />
											</label>
											<input type="file" name="donationInfo_budgetList" class="margintp fileupload multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.budgetExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                        <tbody>
			                                           <c:forEach items="${appForm.donationInfo.budgetExistingFile}" var="materialsListFile">
			                                              <c:if test="${viewMode == 'view'}">
			                                               	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                     <td width="100%">
			                                                        	<a id="donationInfo_budgetDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                     </td>
			                                                </tr>
			                                               </c:if>
			                                               <c:if test="${saveAction == 'update'}">
			                                                 <tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                    <td width="85%">
			                                                       	<a id="donationInfo_budgetDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                    </td>
			                                                    <td class="colm-2">
				                                            		<a id="donationInfo_budgetDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
			                                                	</td>
			                                                 </tr>
			                                               </c:if>
														</c:forEach>
			                                      </tbody>
			                                   </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_w9FormList">
												<liferay-ui:message key="charityDonationInfoBlk.label.completedW9" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="donationInfo_w9FormList" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.w9FormListExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                        <tbody>
			                                           <c:forEach items="${appForm.donationInfo.w9FormListExistingFile}" var="materialsListFile">
			                                              <c:if test="${viewMode == 'view'}">
			                                               	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                     <td width="100%">
			                                                        	<a id="donationInfo_w9Form" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                     </td>
			                                                </tr>
			                                               </c:if>
			                                               <c:if test="${saveAction == 'update'}">
			                                                 <tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                    <td width="85%">
			                                                       	<a id="donationInfo_w9Form" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                    </td>
			                                                    <td class="colm-2">
				                                            		<a id="donationInfo_w9Form_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
			                                                	</td>
			                                                 </tr>
			                                               </c:if>
														</c:forEach>
			                                      </tbody>
			                                   </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_current990List">
												<liferay-ui:message key="charityDonationInfoBlk.label.current990" />
											</label>
											<span class="red_star">*</span>
											<input type="file" name="donationInfo_current990List" class="margintp fileupload reqmulti multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.current990ExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                        <tbody>
			                                           <c:forEach items="${appForm.donationInfo.current990ExistingFile}" var="materialsListFile">
			                                              <c:if test="${viewMode == 'view'}">
			                                               	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                     <td width="100%">
			                                                        	<a id="donationInfo_current990" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                     </td>
			                                                </tr>
			                                               </c:if>
			                                               <c:if test="${saveAction == 'update'}">
			                                                 <tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                    <td width="85%">
			                                                       	<a id="donationInfo_current990" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                    </td>
			                                                    <td class="colm-2">
				                                            		<a id="donationInfo_current990_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
			                                                	</td>
			                                                 </tr>
			                                               </c:if>
														</c:forEach>
			                                      </tbody>
			                                   </table>
											</c:if>																
										</td>
									</tr>
									<tr class="checkboxclickValid">														  
										<td class="check-width">
											<input type="checkbox" value="dispaly4" class="checkAttachment" name="checkbox">
										</td>
										<td>
											<label for="donationInfo_otherDocumentsList">
												<liferay-ui:message key="charityDonationInfoBlk.label.other" />
											</label>
											<input type="file" name="donationInfo_otherDocumentsList" class="margintp fileupload multi"/>	
											<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.donationInfo.otherDocumentsExistingFile) > 0) }">
												<br/>
												<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
			                                         <tbody>
			                                             <c:forEach items="${appForm.donationInfo.otherDocumentsExistingFile}" var="materialsListFile">
			                                                 <c:if test="${viewMode == 'view'}">
			                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="100%">
			                                                           	<a id="donationInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                   	</tr>
			                                                 </c:if>
			                                                 <c:if test="${saveAction == 'update'}">
			                                                   	<tr id='<c:out value="${materialsListFile.fileId}" />'>
			                                                        <td width="85%">
			                                                           	<a id="donationInfo_otherDocs" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
			                                                        </td>
			                                                         <td class="colm-2">
						                                            	<a id="donationInfo_otherDocs_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
						<td class="req_label" colspan="3">
							<liferay-ui:message key="charityDonationInfoBlk.label.attachmentNote" /><br>
							<liferay-ui:message key="charityDonationInfoBlk.label.attachmentNote.ext" />
						</td>												
					</tr>					
				</tbody>
			</table>
		</div>
	</td>
</tr>
<script type="text/javascript">

</script>