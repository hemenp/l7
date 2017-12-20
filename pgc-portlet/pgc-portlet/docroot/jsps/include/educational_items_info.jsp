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
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="EduItemsValBlk">
		<h3 class="acc-title">
			<liferay-ui:message key="eduItemsInfoBlk.heading" />
		</h3>
       	<div class="acc-content">
        	<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
            	<tbody>
	               	<tr>
                		<td colspan="3">
                			<strong class="bold">
                				<liferay-ui:message key="eduItemsInfoBlk.subtitle" />
                			</strong>
                		</td>
	               	</tr>
               		<tr>
               			<td colspan="3">
               				<strong class="bold">
								<liferay-ui:message key="eduItemsInfoBlk.label.itemToHCP" />
							</strong>
						</td>
              		</tr>
             		<tr>
                		<td colspan="3">
                			<strong class="bold">
                				<liferay-ui:message key="eduItemsInfoBlk.subtitle1" />
                			</strong>
                		</td>
               		</tr>
              		<tr>
                		<td class="req_label" >
               				<liferay-ui:message key="eduItemsInfoBlk.label.numOfHcp&Items.question" />
               				<span class="red_star">*</span>
                 		</td>
                 		<td colspan="2" class="nopad">
							<table width="0" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<label for="eduItemsInfo.numOfHcp">
											<liferay-ui:message key="eduItemsInfoBlk.label.numOfHcp" />
										</label>
										<form:input type="text" path="eduItemsInfo.numOfHcp" class="text-field required reqNumeric" maxlength="3" style="margin-right: 10px;width:50px;" />
									</td>
								    <td>
										<label for="eduItemsInfo.numOfItems">
											<liferay-ui:message key="eduItemsInfoBlk.label.numOfItems" />
										</label>
			                  			<form:input type="text" path="eduItemsInfo.numOfItems" class="text-field required reqNumeric" maxlength="3" style="width:50px;" onBlur="calculateEduTotal();"/>
								  	</td>
								</tr>
				       		</table>
				       </td>
                	</tr>
       	            <tr>
       	            	<td class="req_label">
							<label for="eduItemsInfo.hcpSelectDescription">
								<liferay-ui:message key="eduItemsInfoBlk.label.itemRecDescription" />
							</label>
							<span class="red_star">*</span>
						</td>
                		<td colspan="2" class="form-item">
                			<form:textarea path="eduItemsInfo.hcpSelectDescription" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                		</td>
              		</tr>
              		<tr>
                		<td colspan="3" class="req_label" >
                			<strong class="bold">
                				<liferay-ui:message key="eduItemsInfoBlk.subtitle2" />
                			</strong>
                		</td>
               		</tr>
              		<tr>
              			<td class="req_label">
							<label for="eduItemsInfo.physicianEduValue">
								<liferay-ui:message key="eduItemsInfoBlk.label.itemEduValue" />
							</label>
							<span class="red_star">*</span>
						</td>
                		<td colspan="2" class="form-item">
                			<form:textarea path="eduItemsInfo.physicianEduValue" class="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
                		</td>
              		</tr>
              		<tr>
              			<td class="req_label">
							<label for="eduItemsInfo.itemRetailValue">
								<liferay-ui:message key="eduItemsInfoBlk.label.itemRetailValue" />
							</label>
							<span class="red_star">*</span>
						</td>
                		<td colspan="2">
                			<span class="form-item"><strong>$</strong>
                  				<form:input path="eduItemsInfo.itemRetailValue" type="text" style="margin-right:5px; width:50px" class="text-field required reqNumeric" maxlength="7" onchange="calculateEduTotal();" />
                  			</span>
                  			<span class=" bold">
                  				<liferay-ui:message key="eduItemsInfoBlk.label.itemRetailValue.note" />
                  			</span>
                  		</td>
              		</tr>
              		<tr>
              			<td class="req_label">
							
						</td>
                		<td colspan="2" class="form-item"><strong>$</strong>
	                 		<form:input path="eduItemsInfo.eduItemDescription" type="text" class="text-field" style="margin-right:5px; width:50px;" maxlength="20" onblur="formatCurrency(this);"/>
	                 		<span class=" bold">
	                 		<label for="eduItemsInfo.eduItemDescription">
								<liferay-ui:message key="eduItemsInfoBlk.label.total" />
							</label>
							</span>
	                 	</td> 
              		</tr>
              		<tr>
                		<td colspan="3" class="btmbrddiv" ></td>
              		</tr>
              		<tr>
                		<td colspan="3">
                			<strong class="bold">
                				<liferay-ui:message key="eduItemsInfoBlk.attachment" />
                			</strong><br /><br />
                  			<liferay-ui:message key="eduItemsInfoBlk.attachment.subtitle" /> 
               			</td>
              		</tr>
              		<tr>
                		<td colspan="3" class="">
               				<table cellspacing="0" cellpadding="0" border="0">
                    			<tbody>
                      				<tr>
                        				<td  style="padding:0px 0;">
                       						<table cellspacing="0" cellpadding="0" border="0">
                            					<tbody>
                            						<tr>
														<td  style="padding:0px 0; width:350px">
													   		<table cellspacing="0" cellpadding="0" border="0" width="100%">
																<tr class="checkboxclickMulti">												  
																	<td class="check-width"><input type="checkbox" name="addAttachments" class="checkAttachment" value="dispaly1"></td>
																 	<td>
																 		<label for="eduItemsInfo.itemRetailAttachment">
																			<liferay-ui:message key="eduItemsInfoBlk.label.itemRetailAttachment" />
																		</label>
																		<span class="red_star">*</span>
																		<input type="file" name="eduItemsInfo.itemRetailAttachment" class="margintp fileupload reqmulti multi"/>
																		<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.eduItemsInfo.itemRetailExistingFile) > 0) }">
																		<br/>
																		<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
							                                                <tbody>
						                                                       <c:forEach items="${appForm.eduItemsInfo.itemRetailExistingFile}" var="itemRetailFile">
						                                                       		<c:if test="${viewMode == 'view'}">
									                                                 	<tr id='<c:out value="${itemRetailFile.fileId}" />'>
									                                                        <td width="100%">
									                                                           	<a id="eduItemsInfo_itemRetailAttach" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${itemRetailFile.fileName}');"><c:out value="${itemRetailFile.fileName}" /></a>
									                                                        </td>
								                                                    	</tr>
								                                                    </c:if>
								                                                    <c:if test="${saveAction == 'update'}">
								                                                    	<tr id='<c:out value="${itemRetailFile.fileId}" />'>
									                                                        <td width="85%">
									                                                           	<a id="eduItemsInfo_itemRetailAttach" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${itemRetailFile.fileName}');"><c:out value="${itemRetailFile.fileName}" /></a>
									                                                        </td>
									                                                        <td class="colm-2">
									                                                        	<a id="edu_itemRetailAttach_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
														<td width=""  style="padding:0px 0;">&nbsp;</td>
  													</tr>
			                                	</tbody>
                       						</table>
                       					</td>
                   					</tr>
                   					<tr>
									     <td>
	                                		<strong class="bold">
	                                			<liferay-ui:message key="eduItemsInfoBlk.attachment.note" /><br/>
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
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearEducationalItemsBlock(this);" />
							</td>
	           			</tr>
	           		</c:if>
           		</tbody>
       		</table>
    	</div>
    </td>
</tr>