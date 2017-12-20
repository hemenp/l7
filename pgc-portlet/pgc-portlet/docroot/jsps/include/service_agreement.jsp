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
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="ServiceAgreementBlk">
		<h3 class="acc-title"><liferay-ui:message key="serviceAgreementBlk.heading" /></h3>
		 <div class="acc-content" >
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
					<tr>
                  		<td class="req_label" >
                  			<strong class="bold">
                  				<liferay-ui:message key="serviceAgreementBlk.subtitle.businessNeed" />
                  			</strong>
                 		</td>
                  		<td class="form-item"  style="width:530px;">&nbsp;</td>
	                </tr>
	                <tr>
                  		<td class="req_label vtop">
                  			<label for="serviceAgreement.businessNeed">
                  				<liferay-ui:message key="serviceAgreementBlk.label.businessNeed" />
                  			</label>
                  			<span class="red_star">*</span>
                  		</td>
                  		<td class="form-item" >	
                  			<form:textarea path="serviceAgreement.businessNeed" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                  		</td>
	                </tr>
                    <tr>
                    	<td class="req_label vtop">
                    		<label for="serviceAgreement.isRelatedToProduct">
                   				<liferay-ui:message key="serviceAgreementBlk.label.isRelatedToProd" />
                   			</label>
                   			<span class="red_star">*</span>
                    	</td>
                        <td class="form-item">
                        	<div>
                       			<form:radiobutton path="serviceAgreement.isRelatedToProduct" cssClass="required" class="ques_radio" value="true"/>
								<liferay-ui:message key="serviceAgreementBlk.label.yes" />
								<form:radiobutton path="serviceAgreement.isRelatedToProduct" class="ques_radio" value="false"/>
								<liferay-ui:message key="serviceAgreementBlk.label.no" />
							</div>
						</td>
                  	</tr>
                  	<tr>
	                  	<td class="vtop" colspan="2">
	                  		<p class="margintp">
							<span class="red_star">*</span>
							<liferay-ui:message key="serviceAgreementBlk.label.isRelatedToProd.note" />
							</p>
	                  	</td>
                  	</tr>
                  <!--  new requirements for two fields -->
                  <tr>
                    	<td class="req_label vtop" >
                    		<label for="serviceAgreement.isServiceTime">
                    		<liferay-ui:message key="serviceAgreementBlk.label.isServiceTime" />
                    		</label>
                    		<span class="red_star">*</span>
                    	</td>
                       	<td class="form-item">
                        	<form:radiobutton path="serviceAgreement.isServiceTime" cssClass="ques_radio required" value="true" onClick="validateServiceDateRow(true);"/>
							<liferay-ui:message key="serviceAgreementBlk.label.yes" />
							<form:radiobutton path="serviceAgreement.isServiceTime" cssClass="ques_radio" value="false" onClick="validateServiceDateRow(false);"/>
							<liferay-ui:message key="serviceAgreementBlk.label.no" />	
						</td>
                	</tr>
                	<div id="serviceDateRowDiv">
                		
	                	<tr>
							<td class="req_label">
								<liferay-ui:message key="serviceAgreementBlk.label.serviceDates" />
							</td>
							<td class="form-item">
								<input id="serviceDates" class="text-field" name="serviceDates" class="text-field" maxlength="10" readonly="readonly" onblur="appendServiceDate();" style="width: 97px;"/>
							</td>
						
						</tr>
				
				
					<tr>
						<td class="nopad">&nbsp;</td>
						<td class="form-item nopad">
							<form:textarea path="serviceAgreement.serviceDate" cssClass="cmmntbxful serviceDateRow"  onkeydown="limitText(this,512);" onkeyup="limitText(this,512);" onblur="limitText(this,512);"/>
	                    </td>
	                    
					</tr>
				</div>
	                  	<tr>
							<td class="req_label vtop">
								<liferay-ui:message key="serviceAgreementBlk.label.customerInfo" />
							</td>
							<td class="form-item">&nbsp;</td>
						</tr>
					<tr>
						<td class="req_label vtop">
						 	<liferay-ui:message key="serviceAgreementBlk.label.serviceDesc" />
						 </td>
					 	<td class="form-item">
					 		<form:textarea path="serviceAgreement.serviceProvided" class="cmmntbxful" style="height: 63px;" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
					 	</td>
					</tr>
                    <tr>
                    	<td class="req_label vtop">
                    		<liferay-ui:message key="serviceAgreementBlk.label.attachProposal" /><br>
							<br>
                    		<label for="serviceAgreement.agreementDesc">
                    			<liferay-ui:message key="serviceAgreementBlk.label.agreementDesc" />
                    		</label><span class="red_star">*</span>
                    	</td>
                   		<td class="form-item">
                   			<form:textarea path="serviceAgreement.agreementDesc" class="cmmntbxful required" style="height: 95px;" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                   		</td>
                    </tr>
                   	<tr>
                    	<td class="req_label vtop" >
                    		<label for="serviceAgreement.isComparableService">
                    			<liferay-ui:message key="serviceAgreementBlk.label.isComparableService" />
                    		</label>
                    		<span class="red_star">*</span>
                    	</td>
                       	<td class="form-item">
                        	<form:radiobutton path="serviceAgreement.isComparableService" class="ques_radio" cssClass="required" value="true"/>
							<liferay-ui:message key="serviceAgreementBlk.label.yes" />
							<form:radiobutton path="serviceAgreement.isComparableService" class="ques_radio" value="false"/>
							<liferay-ui:message key="serviceAgreementBlk.label.no" />	
						</td>
                	</tr>
                   	<tr>
                    	<td class="req_label vtop">
                    		<label for="serviceAgreement.isUniqueExperience">
                    			<liferay-ui:message key="serviceAgreementBlk.label.isUniqueExperience" />
                    		</label>
                    		<span class="red_star">*</span>
                    	</td>
                        <td class="form-item">
							<div class="marginbtm">
								<form:radiobutton path="serviceAgreement.isUniqueExperience" class="ques_radio" cssClass="required" value="true" onclick="validateText1(true);"/>
								<liferay-ui:message key="serviceAgreementBlk.label.yes" />
								<form:radiobutton path="serviceAgreement.isUniqueExperience"  class="ques_radio" value="false" onclick="validateText1(false);"/>
								<liferay-ui:message key="serviceAgreementBlk.label.no" />	
							</div>                                              
							<label for="serviceAgreement.uniqueExperienceDesc">
								<liferay-ui:message key="serviceAgreementBlk.label.isUniqueExperience.note" />
							</label>	
							<span class="red_star">*</span>
							<form:textarea path="serviceAgreement.uniqueExperienceDesc" class="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
       				</tr>
       				<tr>
                    	<td class="req_label vtop">
                    		<label for="serviceAgreement.isCustomerDemonstrate">
                    			<liferay-ui:message key="serviceAgreementBlk.label.customerDemonstrate" />
                    		</label>
                    	</td>
                        <td class="form-item">
							<div class="marginbtm">
								<form:radiobutton path="serviceAgreement.isCustomerDemonstrate" class="ques_radio" value="true" onclick="validateText2(true);"/>
								<liferay-ui:message key="serviceAgreementBlk.label.yes" />
								<form:radiobutton path="serviceAgreement.isCustomerDemonstrate" class="ques_radio" value="false" onclick="validateText2(false);"/>
								<liferay-ui:message key="serviceAgreementBlk.label.no" />	
							</div>                                              
							<label for="serviceAgreement.customerDemonstrateDesc">
								<liferay-ui:message key="serviceAgreementBlk.label.isUniqueExperience.note" />
							</label>	
							<span class="red_star">*</span>
							<form:textarea path="serviceAgreement.customerDemonstrateDesc" class="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
       				</tr>
       				<tr>
                        <td class="req_label"><liferay-ui:message key="serviceAgreementBlk.label.qualification" /></td>
                        <td class="form-item">&nbsp;</td>
                    </tr>
                    <tr>
                    	<td class="req_label vtop">
                    		<label for="serviceAgreement.customerQualifications">
	                    		<liferay-ui:message key="serviceAgreementBlk.label.customerQualifications" />
	                    	</label>
	                    	<span class="red_star">*</span>
                    	</td>
                        <td class="form-item">
                     		<form:textarea path="serviceAgreement.customerQualifications" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                        </td>
                   	</tr>
                    <tr>
                        <td class="req_label vtop" >
                        	<label for="serviceAgreement.isProfMedicalSociety">
                        		<liferay-ui:message key="serviceAgreementBlk.label.isProfMedicalSociety" />
                        	</label>
                        	<span class="red_star">*</span>
                        </td>
                        <td class="form-item">
                        	<div class="marginbtm">
								<form:radiobutton path="serviceAgreement.isProfMedicalSociety" class="ques_radio" cssClass="required" value="true" onClick="validateProfMedicalSociety(true)"/>
								<liferay-ui:message key="serviceAgreementBlk.label.yes" />
								<form:radiobutton path="serviceAgreement.isProfMedicalSociety" class="ques_radio" value="false" onClick="validateProfMedicalSociety(false)"/>
								<liferay-ui:message key="serviceAgreementBlk.label.no" />
							</div>
							<label for="serviceAgreement.revOfMedicalSociety">		
						   		<liferay-ui:message key="serviceAgreementBlk.label.revOfMedicalSociety" />
						   	</label>
							<strong>$</strong>
                       		<form:input path="serviceAgreement.revOfMedicalSociety" class="text-field width100" maxlength="20" onchange="formatCurrency(this);"/>
                  		</td>
					</tr>
                    <tr>
                        <td class="req_label vtop">
                        	<label for="serviceAgreement.isPatientAdvocacyOrg">
                        		<liferay-ui:message key="serviceAgreementBlk.label.isPatientAdvocacyOrg" />
                        	</label>
                        	<span class="red_star">*</span>
                        </td>
                        <td class="form-item">
	                        <div class="marginbtm">
								<form:radiobutton path="serviceAgreement.isPatientAdvocacyOrg" class="ques_radio" cssClass="required" value="true" onClick="validatePatientAdvocacyOrg(true)"/>
								<liferay-ui:message key="serviceAgreementBlk.label.yes" />
								<form:radiobutton path="serviceAgreement.isPatientAdvocacyOrg" class="ques_radio" value="false" onClick="validatePatientAdvocacyOrg(false)"/>
								<liferay-ui:message key="serviceAgreementBlk.label.no" />
							</div>
							<label for="serviceAgreement.revOfPatientAdvocacyOrg">
								<liferay-ui:message key="serviceAgreementBlk.label.revOfPatientAdvocacyOrg" />
							</label>
							<strong>$</strong>
							<form:input path="serviceAgreement.revOfPatientAdvocacyOrg" type="text" class="text-field width100" maxlength="20" onchange="formatCurrency(this);"/>
                        </td>
               		</tr>
                   	<tr>
	                    <td class="req_label" >
	                    	<strong class="bold">
	                    		<liferay-ui:message key="serviceAgreementBlk.subtitle.compensation" />
	                    	</strong>
	                    </td>
	                    <td class="form-item">&nbsp;</td>
                   	</tr>
                    <tr>
                        <td class="req_label vtop">
                       	  	<label for="serviceAgreement.customerServicesDesc">
                       	  		<liferay-ui:message key="serviceAgreementBlk.label.customerServicesDesc" />
                       	  		<span class="red_star">*</span>
                       	  	</label>
                        </td>
                        <td class="form-item">
                      		<form:textarea path="serviceAgreement.customerServicesDesc" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                      	</td>
                   	</tr>
                    <tr>
                    	<td colspan="2" class="vtop">
                    		<strong class="bold">
                    			<liferay-ui:message key="serviceAgreementBlk.label.isFairMarketValue.title" />
                    		</strong>
                    	</td>
                   	</tr>
                    <tr>
                    	<td class="req_label vtop">
	                    	<label for="serviceAgreement.isFairMarketValue">
	                    		<liferay-ui:message key="serviceAgreementBlk.label.isFairMarketValue" />
	                   		</label>
                    	</td>
                        <td class="form-item">
							<form:radiobutton path="serviceAgreement.isFairMarketValue" class="ques_radio" value="true"/>
							<liferay-ui:message key="serviceAgreementBlk.label.yes" />
							<form:radiobutton path="serviceAgreement.isFairMarketValue" class="ques_radio" value="false"/>
							<liferay-ui:message key="serviceAgreementBlk.label.no" />
						</td>
               		</tr>
                 	<tr>
                    	<td colspan="2" class="btmbrddiv" ></td>
                   	</tr>
              		<tr>
                    	<td colspan="2">
	                    	<strong class="bold">
	                    		<liferay-ui:message key="serviceAgreementBlk.attachment.title" />
	                    	</strong><br /><br />
	                    	<liferay-ui:message key="serviceAgreementBlk.attachment.subtitle" /><br /><br />
							<strong class="bold">
								<liferay-ui:message key="serviceAgreementBlk.attachment.note1" />
							</strong>
						</td>
               		</tr>
                    <tr>
                    	<td colspan="2" class="">
							<table cellspacing="0" cellpadding="0" border="0">
						 		<tbody>
                                	<tr>
										<td  style="padding:0px 0; width:350px">
									   		<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tr class="checkboxclickMulti">												  
													<td class="check-width">
														<input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly1">
													</td>
												 	<td>
												 		<label for="serviceAgreement_proposal">
												 			<liferay-ui:message key="serviceAgreementBlk.label.proposal" />
												 		</label>
												 		<span class="red_star">*</span>
														<input type="file" name="serviceAgreement_proposal" class="margintp fileupload reqmulti multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.serviceAgreement.proposalExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.serviceAgreement.proposalExistingFile}" var="proposalFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${proposalFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="serviceAgreement_prop" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${proposalFile.fileName}');"><c:out value="${proposalFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${proposalFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="serviceAgreement_prop" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${proposalFile.fileName}');"><c:out value="${proposalFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="service_prop_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
														<label for="serviceAgreement_applicableAgreement">
															<liferay-ui:message key="serviceAgreementBlk.label.applicableAgreement" />
														</label>
													 <input type="file"name="serviceAgreement_applicableAgreement" class="margintp fileupload multi"/>
														<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.serviceAgreement.applicableAgreementExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.serviceAgreement.applicableAgreementExistingFile}" var="applicableAgreementFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${applicableAgreementFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           <a id="serviceAgreement_applicableAgmt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${applicableAgreementFile.fileName}');"><c:out value="${applicableAgreementFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${applicableAgreementFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           <a id="serviceAgreement_applicableAgmt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${applicableAgreementFile.fileName}');"><c:out value="${applicableAgreementFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="service_applicableAgmt_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="serviceAgreement_itemizedBudget">
																<liferay-ui:message key="serviceAgreementBlk.label.itemizedBudget" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="serviceAgreement_itemizedBudget" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.serviceAgreement.itemizedBudgetExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.serviceAgreement.itemizedBudgetExistingFile}" var="itemizedBudgetFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${itemizedBudgetFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="serviceAgreement_itmBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${itemizedBudgetFile.fileName}');"><c:out value="${itemizedBudgetFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${itemizedBudgetFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="serviceAgreement_itmBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${itemizedBudgetFile.fileName}');"><c:out value="${itemizedBudgetFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="service_itmBudget_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
												  		<td class="check-width"><input type="checkbox" name="checkbox" class="checkAttachment" value="dispaly4"></td>
														<td>
															<label for="serviceAgreement_completedW9">
																<liferay-ui:message key="serviceAgreementBlk.label.completedW9" />
															</label>
															<span class="red_star">*</span>
															<input type="file"name="serviceAgreement_completedW9" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.serviceAgreement.completedW9ExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.serviceAgreement.completedW9ExistingFile}" var="completedW9File">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="serviceAgreement_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${completedW9File.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="serviceAgreement_cW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${completedW9File.fileName}');"><c:out value="${completedW9File.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="service_cW9_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
									                                                </td>
						                                                    	</tr>
						                                                    </c:if>
																		</c:forEach>
				                                                    </tbody>
			                                            		</table>
															</c:if>			
														</td>
													</tr>																		
									  		</table>
									    </td>
	 									<td width="" style="padding:0px 0;">&nbsp;</td>
									</tr>
                           			<tr>
						     			<td colspan="2" >
						     				<strong class="bold">
						     					<liferay-ui:message key="serviceAgreementBlk.attachment.note2" /><br/>
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
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearServiceAgreeBlock(this);" />
							</td>
	           			</tr>
	           		</c:if>
        		</tbody>
			</table>
		</div>
	</td>
</tr>