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
    <td class="form-content" style="padding: 0 10px;" colspan="3" id="HCPConsultantBlk">
        <h3 class="acc-title">
        	<liferay-ui:message key="hcpConsultantInfoBlk.heading" />
        </h3>
        <div class="acc-content">
        	<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
        		<tbody>
                	<tr>
                    	<td class="twocallft">
                   			<label for="hcpConsultantInfo.serviceDetail">
                   				<span class="bold"><liferay-ui:message key="hcpConsultantInfoBlk.subheading.consultantInfo" /></span>
                   			</label>
                    		<br /><br />
							<liferay-ui:message key="hcpConsultantInfoBlk.label.serviceDetail" /> <span class="red_star">*</span>
						</td>
                        <td class="form-item">
                        	<form:textarea path="hcpConsultantInfo.serviceDetail" cssClass="cmmntbxful required" style="height: 100px;" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
					</tr>
					<tr>
                    	<td class="twocallft">
                   			<label for="hcpConsultantInfo.totalBrkdownHrs">
                   				<span class="bold"><liferay-ui:message key="hcpConsultantInfoBlk.label.totalHours" /> <span class="red_star">*</span></span>
                   			</label>                    		
						</td>
                        <td class="form-item">
							<form:textarea path="hcpConsultantInfo.totalBrkdownHrs" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);" />
						</td>
					</tr>
                    <tr>
                    	<td class="twocallft">
                   			<label for="hcpConsultantInfo.qualificationDesc">
                   				<span class="bold"><liferay-ui:message key="hcpConsultantInfoBlk.subheading.qualification" /></span>
                   			</label>
                    		<br /><br />
                        	<liferay-ui:message key="hcpConsultantInfoBlk.label.qualificationDesc" /> <span class="red_star">*</span>
                        </td>
                      	<td class="form-item">
                      		<form:textarea path="hcpConsultantInfo.qualificationDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                      	</td>
                    </tr>
                    <tr>
                        <td class="twocallft">
                        	<span class="bold">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.subheading.businessNeed" />
                        	</span><br /><br />
                    		<label for="hcpConsultantInfo.businessNeedDesc">
                    			<liferay-ui:message key="hcpConsultantInfoBlk.label.businessNeedDesc" />
                    		</label>
                    		<span class="red_star">*</span>
                    	</td>
                        <td class="form-item">
                        	<form:textarea path="hcpConsultantInfo.businessNeedDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
                   	</tr>
                    <tr>
                        <td class="twocallft">
                        	<label for="hcpConsultantInfo.businessNeed">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.businessNeed" />
                        	</label>
                        </td>
                        <td class="form-item">
                        	<form:textarea path="hcpConsultantInfo.businessNeed" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="twocallft">
                        	<label for="hcpConsultantInfo.companyAgreement">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.companyAgree" /></label>
                        	<span class="red_star">*</span>
                        </td>
                        <td class="form-item">
                        	<form:textarea path="hcpConsultantInfo.companyAgreement" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
                    </tr>
                    <!-- tr>
                        <td class="twocallft">
                        	<label for="hcpConsultantInfo.hcpsQualification">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.hcpQualification" />
                        	</label>
                        	<span class="red_star">*(required for hcps)</span>
                        </td>
                        <td class="form-item">
                        	<form:textarea path="hcpConsultantInfo.hcpsQualification" cssClass="cmmntbxful required" onkeydown="limitText(this,250);" onkeyup="limitText(this,250);" onblur="limitText(this,250);"/>
                        </td>
                    </tr> -->
                    <tr>
                        <td class="twocallft">
                        	<span class="bold">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.subheading.serviceDate" />
                        	</span>
                        </td>
                        <td class="req_label">&nbsp;</td>
                    </tr>
                    <tr>
						<td class="req_label" width="107">
							<label for="hcpConsultantInfo.eventStartDate">
								<liferay-ui:message key="hcpConsultantInfoBlk.subheading.startDate"/>
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:input path="hcpConsultantInfo.eventStartDate" cssClass="text-field required reqStartDate"  size="14" maxlength="10" />
						</td>
					</tr>
					 <tr>
						<td class="req_label" width="107">
							<label for="hcpConsultantInfo.eventEndDate">
								<liferay-ui:message key="hcpConsultantInfoBlk.subheading.endDate"/>
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:input path="hcpConsultantInfo.eventEndDate" cssClass="text-field required reqStartDate"  size="14" maxlength="10" />
						</td>
					</tr>
                    <tr>
                        <td class="twocallft vtop">
                        	<label for="hcpConsultantInfo.servicePeriod">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.serviceDateQues" />
                        	</label>
                        	<span class="red_star">*</span>
                       	</td>
                        <td class="twocalrht vtop">
                        	<div class="marginbtm">
								<form:radiobutton path="hcpConsultantInfo.servicePeriod" value="true" cssClass="ques_radio required" onClick="validateHcpDateRow(true);"/>
								<liferay-ui:message key="blk.label.yes" />
								<form:radiobutton path="hcpConsultantInfo.servicePeriod" value="false" cssClass="ques_radio" onClick="validateHcpDateRow(false);"/>
								<liferay-ui:message key="blk.label.no" />
							</div>
							<div id="hcpServiceDateRow">
								<table width="375" border="0">
						  			<tr>
								    	<td width="107">
								    		<label for="hcpConsultantInfo.serviceDates">
								    			<liferay-ui:message key="hcpConsultantInfoBlk.label.serviceDates" />
								    		</label>
								    		(You may select more than one date)
								    	</td>
								    	<td width="264">
								    		<input id="hcpEventDate" name="hcpEventDate" class="text-field" size="14" maxlength="10" readonly="readonly" />
											<br />
										</td>
								  	</tr>
								  	<tr>
							    		<td></td>
							    		<td><form:textarea path="hcpConsultantInfo.serviceDates" cssClass="cmmntbxful hcpDateRow reqEventDates" onkeydown="limitText(this,250);" onkeyup="limitText(this,250);" onblur="limitText(this,250);"/></td>
								 	 </tr>
								</table>
							</div>
				 		</td>
					</tr>
                    <tr>
                      	<td class="btmbrddiv" colspan="2"></td>
                    </tr>
                    <tr>
      					<td colspan="2">
      						<p>
      							<strong class="bold">
      								<liferay-ui:message key="hcpConsultantInfoBlk.subheading.compensation" />
      							</strong>
      							<liferay-ui:message key="hcpConsultantInfoBlk.label.compensationNote" />
      						</p>
                        	<p>
                        		<strong class="bold">
                        			<liferay-ui:message key="hcpConsultantInfoBlk.subheading.meals" />
                        		</strong>
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.mealsNote" />
                        	</p> 
							<p>
								<strong class="bold">
									<liferay-ui:message key="hcpConsultantInfoBlk.subheading.travel" />
								</strong> 
								<liferay-ui:message key="hcpConsultantInfoBlk.label.travelNote" />
							</p>
						</td>
                    </tr>
                    <tr>
                        <td class="btmbrddiv nopad" colspan="2"></td>
                    </tr>
                    <tr>
                        <td class="twocallft">
                        	<span class="bold">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.subheading.prgFormat" />
                        	</span>
                        </td>
                        <td class="req_label">&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="twocallft">
                        	<label for="hcpConsultantInfo.programFormat">
                        		<liferay-ui:message key="hcpConsultantInfoBlk.label.format" />
                        	</label>
                        </td>
                        <td class="form-item">
                        	<table cellspacing="0" cellpadding="0" border="0">
						 		<tbody>
						 			<tr>
								 		<td  style="padding:0px 0;">
									   		<table cellspacing="0" cellpadding="0" border="0">
												<tbody>
													<tr>												  
														<td>
															<form:checkbox path="hcpConsultantInfo.programFormat" value="Face-to-face"/>
														</td>
														<td>
															<liferay-ui:message key="hcpConsultantInfoBlk.format.faceToFace" />
														</td>
													</tr>
													<tr>												  
														<td>
															<form:checkbox path="hcpConsultantInfo.programFormat" value="Live program"/>
														</td>
														<td>
															<liferay-ui:message key="hcpConsultantInfoBlk.format.live" />
														</td>
													</tr>
												</tbody>
											</table>
									 	</td>
								 	 	<td style="padding:0px 0;">
								   		<table cellspacing="0" cellpadding="0" border="0">
											<tbody>
												<tr>												  
													<td>
														<form:checkbox path="hcpConsultantInfo.programFormat" value="Audio conference"/>
													</td>
													<td>
														<liferay-ui:message key="hcpConsultantInfoBlk.format.audio" />
													</td>
												</tr>
												<tr>												  
														<td>
															<form:checkbox path="hcpConsultantInfo.programFormat" value="Web-based"/>
														</td>
														<td>
															<liferay-ui:message key="hcpConsultantInfoBlk.format.web" />
														</td>
												</tr>	
											</tbody>
										</table>
									</td>
									<td  style="padding:0px 0;">
								   		<table cellspacing="0" cellpadding="0" border="0">
											<tbody>
												<tr>												  
													<td>
														<form:checkbox path="hcpConsultantInfo.programFormat" value="N/A"/>
													</td>
													<td>
														<liferay-ui:message key="hcpConsultantInfoBlk.format.na" />&nbsp;
													</td>
												</tr>
												<tr>												  
													<td colspan="2"> </td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>												  
									<td class="nopad" colspan="3">
										<table cellspacing="0" cellpadding="0" border="0">
											<tbody>
												<tr>												  
													<td>
														<form:checkbox path="hcpConsultantInfo.programFormat" value="Combination (specify)" onClick="validateCombination(this.checked);"/>
													</td>
													<td>
														<label for="hcpConsultantInfo.programCombination">
															<liferay-ui:message key="hcpConsultantInfoBlk.format.combined" />
														</label>
													</td>
													<td colspan="2">
														<form:input path="hcpConsultantInfo.programCombination" cssClass="text-field width250" maxlength="512"/>
													</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
                <tr>
                	<td class="twocallft"><span class="bold"><liferay-ui:message key="hcpConsultantInfoBlk.subheading.location" /></span></td>
                    <td class="req_label">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2" class="nopad">
                    	<table cellspacing="0" cellpadding="0" border="0" class="margintp" style="width:100%;">
                    		<tbody>
	                      		<tr>
		                        	<td class="req_label">
		                        		<label for="hcpConsultantInfo.meetingName">
		                        			<liferay-ui:message key="blk.label.name" />
		                        		</label>
		                        		<span class="red_star">*</span>
		                        	</td>
		                        	<td class="form-item">
		                        		<form:input path="hcpConsultantInfo.meetingName" cssClass="text-field required textTip" maxlength="512"/>
		                        	</td>
		                        	<td class="req_label">
		                        		<label for="hcpConsultantInfo.meetingLocation.addressLine1">
		                        			<liferay-ui:message key="blk.label.address1" />
		                        		</label>
		                        		<span class="red_star">*</span>
		                        	</td>
		                        	<td class="form-item">
		                        		<form:input path="hcpConsultantInfo.meetingLocation.addressLine1" cssClass="text-field required textTip" maxlength="250"/>
		                        	</td>
		                     	 </tr>
		                      	<tr>
		                        	<td class="req_label">
		                        		<liferay-ui:message key="blk.label.address2" />
		                        	</td>
		                        	<td class="form-item">
		                        		<form:input path="hcpConsultantInfo.meetingLocation.addressLine2" cssClass="text-field textTip" maxlength="250"/>
		                        	</td>
		                        	<td class="req_label">
		                        		<label for="hcpConsultantInfo.meetingLocation.city">
		                        			<liferay-ui:message key="blk.label.city" />
		                        		</label>
		                        		<span class="red_star">*</span>
		                        	</td>
		                        	<td class="form-item">
		                        		<form:input path="hcpConsultantInfo.meetingLocation.city" cssClass="text-field required textTip" maxlength="250"/>
		                        	</td>
		                      	</tr>
		                      	<tr>
		                        	<td class="req_label">
		                        		<label for="hcpConsultantInfo.meetingLocation.state">
		                        			<liferay-ui:message key="blk.label.state" />
		                        		</label>
		                        		<span class="red_star">*</span>
		                        	</td>
		                        	<td class="form-item">
		                        		<form:select path="hcpConsultantInfo.meetingLocation.state" cssClass="text-field required" style="width:135px;">
									        <form:option value="" label="Select State"/>
									        <form:options items= "${usStates}" />
									    </form:select>
		                          	</td>
		                        	<td class="req_label">
		                        		<label for="hcpConsultantInfo.meetingLocation.zip">
		                        			<liferay-ui:message key="blk.label.zip" />
		                        		</label>
	                        			<span class="red_star">*</span>
	                        		</td>
		                        	<td class="form-item">
		                        		<form:input path="hcpConsultantInfo.meetingLocation.zip" cssClass="text-field required reqZipCode" style="width:57px" maxlength="5"/>
		                        		-
						 				<label for="hcpConsultantInfo.meetingLocation.zipExtra">
			     							<form:input path="hcpConsultantInfo.meetingLocation.zipExtra" cssClass="text-field reqNumeric" maxlength="4" style="width:50px;"/>
			     						</label>
		                        	</td>
		                     	 </tr>
							</tbody>
           				</table>
					</td>
				</tr>
		        <tr>
                	<td class="btmbrddiv" colspan="2"></td>
                </tr>
                <tr>
  					<td colspan="4">
  						<strong class="bold">
  							<liferay-ui:message key="hcpConsultantInfoBlk.subheading.attach" />
  						</strong><br /><br />
						<liferay-ui:message key="hcpConsultantInfoBlk.label.confirmAttach" />
					</td>
 				</tr>
				<tr>
			  		<td colspan="4">
			  			<table cellspacing="0" cellpadding="0" border="0">
				 			<tbody>
                            	<tr>
							 		<td style="padding:0px 0; width:350px">
						   				<table cellspacing="0" cellpadding="0" border="0" width="100%">
							   				<tbody>
								   				<tr class="checkboxclickMulti">												  
													<td class="check-width">
														<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly1">
													</td>
												 	<td>
												 		<label for="hcpConsultantInfo.materials">
												 			<liferay-ui:message key="hcpConsultantInfoBlk.label.materialAttach" />
												 		</label>
														<input type="file" name="hcpConsultantInfo.materials" class="margintp fileupload multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.hcpConsultantInfo.materialsExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.hcpConsultantInfo.materialsExistingFile}" var="materialsFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${materialsFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="hcpConsultantInfo_material" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsFile.fileName}');"><c:out value="${materialsFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${materialsFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="hcpConsultantInfo_material" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsFile.fileName}');"><c:out value="${materialsFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="hcp_material_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
														<label for="hcpConsultantInfo.budget">
															<liferay-ui:message key="hcpConsultantInfoBlk.label.budgetAttach" />
														</label>
														<span class="red_star">*</span><br />
														<input type="file" name="hcpConsultantInfo.budget" class="margintp fileupload reqmulti multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.hcpConsultantInfo.budgetExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.hcpConsultantInfo.budgetExistingFile}" var="budgetFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${budgetFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="hcpConsultantInfo_bgt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${budgetFile.fileName}');"><c:out value="${budgetFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${budgetFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="hcpConsultantInfo_bgt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${budgetFile.fileName}');"><c:out value="${budgetFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="hcp_bgt_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
														<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly3">
													</td>
													<td>
														<label for="hcpConsultantInfo.w9Completed">
															<liferay-ui:message key="hcpConsultantInfoBlk.label.w9Attach" />
														</label>
														<input type="file" name="hcpConsultantInfo.w9Completed" class="margintp fileupload multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.hcpConsultantInfo.w9CompletedExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.hcpConsultantInfo.w9CompletedExistingFile}" var="w9CompletedFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${w9CompletedFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="hcpConsultantInfo_w9C" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${w9CompletedFile.fileName}');"><c:out value="${w9CompletedFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${w9CompletedFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="hcpConsultantInfo_w9C" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${w9CompletedFile.fileName}');"><c:out value="${w9CompletedFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="hcp_w9C_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
												  		<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly4">
													</td>
													<td>
														<label for="hcpConsultantInfo.cvCopy">
															<liferay-ui:message key="hcpConsultantInfoBlk.label.cvCopy" />
														<input type="file" name="hcpConsultantInfo.cvCopy" class="margintp fileupload multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.hcpConsultantInfo.cvCopyExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.hcpConsultantInfo.cvCopyExistingFile}" var="cvCopyFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${cvCopyFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="hcpConsultantInfo_cv" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${cvCopyFile.fileName}');"><c:out value="${cvCopyFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${cvCopyFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="hcpConsultantInfo_cv" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${cvCopyFile.fileName}');"><c:out value="${cvCopyFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="hcp_cv_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
									<td style="padding:0px 0;">&nbsp;
							   		</td>
							 	</tr>
					  		</tbody>
					  	</table>
					  </td>
					</tr>
                    <tr>
                  		<td class="" colspan="2">
                  			<table cellspacing="0" cellpadding="0" border="0">
	                    		<tbody>
	                         		<tr>
	                                	<td>
	                                		<strong class="bold">
	                                			<liferay-ui:message key="hcpConsultantInfoBlk.subheading.note" /><br/>
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
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearHcpConsultantBlock(this);" />
							</td>
	           			</tr>
	           		</c:if>
				</tbody>
			</table>
        </div>
    </td>
</tr>