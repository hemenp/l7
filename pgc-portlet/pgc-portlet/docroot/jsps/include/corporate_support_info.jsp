<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 22 2012		|	Modified to add validation onblur for the all textArea fields
 * Kruti Doshi		|	Sep 15 2014		|	Modified as per new enhancement list given by client.
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="CorporateSupportBlk">
		<h3 class="acc-title">
			<liferay-ui:message key="coporateSupportblk.heading" />
		</h3>
		<div class="acc-content" >
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
                	<tr>
						<td class="req_label vtop" >
							<label for="corporateSupport.therapeuticArea">
								<liferay-ui:message key="coporateSupportblk.label.therapeuticArea" />
							</label>
							<span class="red_star">*</span>
						</td>
			     		<td class="form-item" width="320">
							<div class="checklist-cont">
								<ul class="checklist ">
									<li class="alt">
										<span><liferay-ui:message key="coporateSupportblk.therapetic.cardio" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Cardiovascular" cssClass="required"/>
									</li>
									<li>
										<span><liferay-ui:message key="coporateSupportblk.therapetic.metabolic" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Metabolic/Endocrine"/>
									</li>
									<li class="alt">
										<span><liferay-ui:message key="coporateSupportblk.therapetic.oncology" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Oncology"/>
									</li>
									<li>
										<span><liferay-ui:message key="coporateSupportblk.therapetic.infectious" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Infectious diseases"/>
									</li>
									<li class="alt">
										<span><liferay-ui:message key="coporateSupportblk.therapetic.allergic" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Immunological allergic diseases"/>
									</li>
									<li>
										<span><liferay-ui:message key="coporateSupportblk.therapetic.pain" /></span>
										<form:checkbox path="corporateSupport.therapeuticArea" value="Pain Management"/>
									</li>									
								</ul>
							</div>
              			</td>
              			<td width="12">
							<form:checkbox path="corporateSupport.therapeuticArea" value=""  onclick="otherTherapeuticArea(this.checked);"/>
						</td>
						<td style="padding-top:5px" class="">
							<label for="corporateSupport.otherTherapeutic" style="vertical-align: top;">
							<liferay-ui:message key="coporateSupportblk.therapetic.others" />
							</label>
							<form:input path="corporateSupport.otherTherapeutic" maxlength="75" cssClass="text-field width100 " onchange="otherTherapeutic();"/>
						</td>
              		</tr>
				   	<tr>
						<td class="req_label">
							<label for="corporateSupport.amountRequested">
								<liferay-ui:message key="coporateSupportblk.label.amountRequested"/>
							</label>
							<span class="red_star">*</span>
						</td>
						<td colspan="3" class="form-item">
							<strong>$</strong>
							<form:input path="corporateSupport.amountRequested" cssClass="text-field required" style="width:116px;" maxlength="20" onchange="formatCurrency(this);"/>
					    </td>
					</tr>
					<tr>
				  		<td class="req_label">
			  				<label for="corporateSupport.profOrgName">
			  					<liferay-ui:message key="coporateSupportblk.label.profOrgName"/>
			  				</label>
			  				<span class="red_star">*</span>
			  			</td>
					  	<td colspan="3" class="form-item">
					  		<form:input path="corporateSupport.profOrgName" maxlength ="250" cssClass="text-field required textTip" />
					  	</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="corporateSupport.eventName">
								<liferay-ui:message key="coporateSupportblk.label.eventName"/>
							</label>
							<span class="red_star">*</span>
						</td>
						<td colspan="3" class="form-item">
				 			<form:input path="corporateSupport.eventName" maxlength ="250" cssClass="text-field required textTip" />
						</td>
					</tr>
					 <tr>
					        <td class="req_label">
					        	<label for="corporateSupport.eventStartDate">
									<liferay-ui:message key="common.label.eventStartDate"/>
								</label>
					        	<span class="red_star">*</span>
					        </td>
					        <td colspan="3" class="form-item">
					        	<form:input path="corporateSupport.eventStartDate" cssClass="text-field reqStartDate reqSave hasDatepicker"  style="width: 97px;" maxlength="10" />
				          	</td>
				      </tr>
					<tr>
						<td class="req_label">
							<label for="corporateSupport.eventDates">
								<liferay-ui:message key="coporateSupportblk.label.eventDate"/>
							</label>
						</td>
						<td colspan="3" class="form-item">
							<input id="csEventDate" class="text-field" name="csEventDate" style="width: 97px;" maxlength="10" readonly="readonly" onblur="appendCSEventDate();"/>
						</td>
					</tr>
					<tr>
						<td class="nopad"></td>
						<td class="form-item nopad" colspan="3">
							<form:textarea path="corporateSupport.eventDates" cssClass="cmmntbxful csDateRow reqEventDates" onkeydown="limitText(this,250);" onkeyup="limitText(this,250);" onblur="limitText(this,250);"/>
	                    </td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="corporateSupport.eventLocation">
								<liferay-ui:message key="coporateSupportblk.label.eventLocation"/>
							</label>
							<span class="red_star">*</span>
						</td>
						<td colspan="3" class="form-item">
			 				<form:input path="corporateSupport.eventLocation" maxlength="250" cssClass="text-field required textTip" />
						</td>
					</tr>
				  	<tr>
				    	<td class="req_label vtop">
				    		<strong class="bold">
				    			<liferay-ui:message key="coporateSupportblk.label.eventPurpose"/>
				    		</strong><br />
							<label for="corporateSupport.eventPurpose">
								<liferay-ui:message key="coporateSupportblk.label.eventPurposeDescription"/>
							</label>
							<span class="red_star">*</span>
						</td>
					    <td colspan="3" class="form-item">
					    	<form:textarea path="corporateSupport.eventPurpose" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
					</tr>
			     	<tr>
				    	<td colspan="4">
				    		<strong class="bold">
								<label for="corporateSupport.isEventDedicatedInTime">
									<liferay-ui:message key="coporateSupportblk.label.isEventDedicatedInTime"/>
								</label>
								<span class="red_star">*</span>
							</strong>
							<p>
								<form:radiobutton path="corporateSupport.isEventDedicatedInTime" value="true" cssClass="ques_radio required" />
								<liferay-ui:message key="coporateSupportblk.label.yes"/>
								<form:radiobutton path="corporateSupport.isEventDedicatedInTime" value="false" cssClass="ques_radio"/>
								<liferay-ui:message key="coporateSupportblk.label.no"/>
  							</p>
						</td>
			      	</tr>
                    <tr>
						<td colspan="4">
							<strong class="bold">
								<label for="corporateSupport.isEventPurposePresented">
									<liferay-ui:message key="coporateSupportblk.label.isEventPurposePresented"/>
								</label>
								<span class="red_star">*</span>
							</strong>
							<p>
						    	<form:radiobutton path="corporateSupport.isEventPurposePresented" value="true" cssClass="ques_radio required" />
					    		<liferay-ui:message key="coporateSupportblk.label.yes"/>
						    	<form:radiobutton path="corporateSupport.isEventPurposePresented" value="false" cssClass="ques_radio"/>
							    <liferay-ui:message key="coporateSupportblk.label.no"/>
						    </p>
						</td>
					</tr>
                   	<tr>
		    			<td colspan="4" >
		    				<div style="padding-bottom:10px">
		    					<strong class="bold">
									<label for="corporateSupport.contentResponsibility">
										<liferay-ui:message key="coporateSupportblk.label.contentResponsibility"/>
									</label>
									<span class="red_star">*</span>
							    </strong>
							    <p>
							    	<form:radiobutton path="corporateSupport.contentResponsibility" value="true" cssClass="ques_radio required" />
							    	<liferay-ui:message key="coporateSupportblk.label.yes"/>
							    	<form:radiobutton path="corporateSupport.contentResponsibility" value="false" cssClass="ques_radio"/>
							    	<liferay-ui:message key="coporateSupportblk.label.no"/>
							    </p>
							</div>
						</td>
			      	</tr>
                	<tr>
						<td colspan="4">
							<div style="padding-bottom:10px">
								<strong class="bold">
									<label for="corporateSupport.isEventSupport">
										<liferay-ui:message key="coporateSupportblk.label.isEventSupport"/>
									</label>
									<span class="red_star">*</span>
								</strong>
								<p>
								    <form:radiobutton path="corporateSupport.isEventSupport" value="true" cssClass="ques_radio required" />
							    	<liferay-ui:message key="coporateSupportblk.label.yes"/>
									<form:radiobutton path="corporateSupport.isEventSupport" value="false" cssClass="ques_radio"/>
									<liferay-ui:message key="coporateSupportblk.label.no"/>
    							</p>
							</div>
						</td>
			      	</tr>
			     	<tr>
						<td colspan="1" class="req_label" >
							<label for="corporateSupport.totalAnnualRevenue">
								<liferay-ui:message key="coporateSupportblk.label.totalAnnualRevenue"/>
							</label>
							<span class="red_star">*</span>										   
						</td>
						<td colspan="2" class="form-item">
							<strong>$</strong>
							<form:input path="corporateSupport.totalAnnualRevenue"  maxlength="20" cssClass="text-field required"  onchange="formatCurrency(this);" />
						</td>
					</tr>
			 		<tr>
						<td class="req_label vtop">
				    		<strong class="bold">
				    			<liferay-ui:message key="coporateSupportblk.label.agreement"/>
				    		</strong><br />
				    	</td>
						<td class="form-item" colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td class="form-item" colspan="4">
							<div class="marginbtm">
								<strong>
									<label for="corporateSupport.proposedAgreement">
										<liferay-ui:message key="coporateSupportblk.label.agreementQuestion"/>
									</label>
								</strong><span class="red_star">*</span>
								<p>
									<form:radiobutton path="corporateSupport.proposedAgreement" value="true" cssClass="ques_radio required" onclick="onradioCorporateCheck(true);"/>
									<liferay-ui:message key="coporateSupportblk.label.yes"/>
									<form:radiobutton path="corporateSupport.proposedAgreement" value="false" cssClass="ques_radio" onclick="onradioCorporateCheck(false);"/>
									<liferay-ui:message key="coporateSupportblk.label.no"/>
								</p>
							</div>
							<liferay-ui:message key="coporateSupportblk.label.agreementNote"/>
						</td>
					</tr>
					<tr>
				  		<td colspan="4" class="btmbrddiv" ></td>
				    </tr>
					<tr>
				  		<td colspan="4">
				  			<strong class="bold">
				  				<liferay-ui:message key="coporateSupportblk.label.attachments"/>
				  			</strong><br /><br />
							<liferay-ui:message key="coporateSupportblk.label.attachmentDescription"/>
						</td>
				    </tr>
					<tr>
				  		<td colspan="4" class="">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
							 			<td style="padding:0px 0;">
									   		<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tr class="checkboxclickMulti">												  
													<td class="check-width">
														<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly1">
													</td>
													<td>
														<label for="corporateSupport_programAgenda">
															<liferay-ui:message key="coporateSupportblk.label.programAgenda"/>
														</label>
														<span class="red_star">*</span>
														<input type="file" name="corporateSupport_programAgenda"  class="margintp fileupload reqmulti multi" />
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.programAgendaExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.corporateSupport.programAgendaExistingFile}" var="programAgendaFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${programAgendaFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_prgAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programAgendaFile.fileName}');"><c:out value="${programAgendaFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${programAgendaFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_prgAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programAgendaFile.fileName}');"><c:out value="${programAgendaFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="cs_prgAgenda_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="corporateSupport_requestLetter">
																<liferay-ui:message key="coporateSupportblk.label.requestLetter"/>
															</label>
															<span class="red_star">*</span>
															<input type="file" name="corporateSupport_requestLetter" class="margintp fileupload reqmulti multi" />
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.requestLetterExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.corporateSupport.requestLetterExistingFile}" var="requestLetterFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${requestLetterFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_rqLetter" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${requestLetterFile.fileName}');"><c:out value="${requestLetterFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${requestLetterFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_rqLetter" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${requestLetterFile.fileName}');"><c:out value="${requestLetterFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="cs_rqLetter_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
									                                                </td>
						                                                    	</tr>
						                                                    </c:if>
																		</c:forEach>
				                                                    </tbody>
			                                            		</table>
															</c:if>
														</td>
												</tr>
												<tr class="checkboxclickradio">														  
															<td class="check-width">
																<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly3" disabled="true">
															</td>
															<td>
																<label for="corporateSupport_profOrgAgreement">
																	<liferay-ui:message key="coporateSupportblk.label.profOrgAgreement"/>
																</label>
																<input type="file" name="corporateSupport_profOrgAgreement" class="margintp fileupload multi" />
																<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.profOrgAgreementExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.corporateSupport.profOrgAgreementExistingFile}" var="profOrgAgreementFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${profOrgAgreementFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_poAgreement" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${profOrgAgreementFile.fileName}');"><c:out value="${profOrgAgreementFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                 		<tr id='<c:out value="${profOrgAgreementFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_poAgreement" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${profOrgAgreementFile.fileName}');"><c:out value="${profOrgAgreementFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="cs_poAgreement_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
														<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly4">
													</td>
													<td>
														<label for="corporateSupport_programBudget">
															<liferay-ui:message key="coporateSupportblk.label.programBudget"/>
														</label>
														<span class="red_star">*</span>
														<input type="file" name="corporateSupport_programBudget" class="margintp fileupload reqmulti multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.programBudgetExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.corporateSupport.programBudgetExistingFile}" var="programBudgetFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${programBudgetFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_prgBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programBudgetFile.fileName}');"><c:out value="${programBudgetFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${programBudgetFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_prgBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programBudgetFile.fileName}');"><c:out value="${programBudgetFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="cs_prgBudget_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly5">
														</td>
														<td>
															<label for="corporateSupport_completedW9">
																<liferay-ui:message key="coporateSupportblk.label.completedW9"/>
															</label>
															<span class="red_star">*</span>
															<input type="file" name="corporateSupport_completedW9" class="margintp fileupload reqmulti multi" />
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.completedW9ExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.corporateSupport.completedW9ExistingFile}" var="completedW9File">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="cs_cW9_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
									                                                </td>
						                                                    	</tr>
						                                                    </c:if>
																		</c:forEach>
				                                                    </tbody>
			                                            		</table>
															</c:if>
														</td>
													</tr>
													<c:if test ="${appForm.formStatus == 'PGC Approved-Agreement Pending'}">
													<tr class="checkboxclickMulti">														  
														<td class="check-width">
															<input type="checkbox" name="checkbox" class="checkAttachment" value="contract">
														</td>
														<td>
															<label for="corporateSupport_contract">
																<liferay-ui:message key="coporateSupportblk.label.contract"/>
															</label>
														<input type="file" name="corporateSupport_contract" class="margintp fileupload  multi"/>
															
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.corporateSupport.contractFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
					                                                 	<c:forEach items="${appForm.corporateSupport.contractFile}" var="contractFile">
					                                                 		<c:if test="${viewMode == 'view'}">
					                                                 			<tr id='<c:out value="${contractFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="corporateSupport_contractview" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${contractFile.fileName}');"><c:out value="${contractFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
					                                                 		</c:if>
					                                                 		<c:if test="${saveAction == 'update'}">
							                                                 	<tr id='<c:out value="${contractFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="corporateSupport_contract" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${contractFile.fileName}');"><c:out value="${contractFile.fileName}" /></a>
							                                                        </td>
							                                                       <td class="colm-2">
							                                                        	<a id="corporateSupport_contract_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                  
							                                                
						                                                 
																		</c:forEach>
				                                                    </tbody>
			                                            		</table>
															</c:if>
														</td>
													</tr>
													</c:if>
												</table>
										 	</td>
									 	</tr>
									 	<tr>
								     		<td>
								     			<strong class="bold">
								     				<liferay-ui:message key="coporateSupportblk.label.note"/><br/>
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
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearCorporateSupportBlock(this);" />
							</td>
	           			</tr>
	           		</c:if>
				</tbody>
		 	</table>
		</div>
	</td>
</tr>