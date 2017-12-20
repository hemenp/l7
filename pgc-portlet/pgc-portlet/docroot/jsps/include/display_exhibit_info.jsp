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
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="DispExhibitBlk">
		<h3 class="acc-title"><liferay-ui:message key="dispExhibitInfoBlk.heading" /></h3>
		<div class="acc-content"  style="display:block" >
			<ol class="request-ul">
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.one" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.two" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.three" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.four" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.five" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.six" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.seven" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.eight" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.nine" /></li>
				<li><liferay-ui:message key="dispExhibitInfoBlk.stmt.ten" /></li>
			</ol>
			<br />		
			<div style="border-bottom:1px solid #ccc; padding-bottom:10px">
				<strong class="bold" >
					<label for="dispExhibitInfo.eventSatisfyCondition">
						<liferay-ui:message key="dispExhibitInfoBlk.stmt.declaration" />
					</label>
					<span class="red_star">*</span>
				</strong>
				<p>
					<form:radiobutton path="dispExhibitInfo.eventSatisfyCondition" value="true" cssClass="required  disEventSatisfyCondition"/>
					<liferay-ui:message key="blk.label.yes" />
					<form:radiobutton path="dispExhibitInfo.eventSatisfyCondition" value="false"/>
					<liferay-ui:message key="blk.label.no" /> 
				</p>
			</div>
			<div class="marginlft margintp"></div>
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
				    <tr>
						<td colspan="2" width="50%" >
							<strong class="bold">
								<liferay-ui:message key="dispExhibitInfoBlk.subheading.fee" />
							</strong></td>
						<td colspan="2" width="50%" ></td>
				    </tr>
					<tr>
						<td class="req_label vtop" >
							<label for="dispExhibitInfo.eventFee">
								<liferay-ui:message key="dispExhibitInfoBlk.label.cost" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
						<b>$</b>&nbsp;<form:input path="dispExhibitInfo.eventFee" rows="5" cssClass="text-field required " maxlength="20" colSpan="3" style="width:128px" onchange="formatCurrency(this);"/>
						</td>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
				    <tr>
						<td class="req_label" colspan="4">
							<strong class="bold">
								<liferay-ui:message key="dispExhibitInfoBlk.subheading.evtOrgagreement" />
							</strong>
						</td>
				    </tr>
				    <tr>
						<td colspan="4">
							<strong class="bold">
								<label for="dispExhibitInfo.eventOrgAgmtDone">
									<liferay-ui:message key="dispExhibitInfoBlk.label.evtOrgagreement" />
								</label>
								<span class="red_star">*</span>
							</strong>
							<p>
			    				<form:radiobutton path="dispExhibitInfo.eventOrgAgmtDone" value="true" cssClass="ques_label required" onclick="onradioCheck(true);"/>
			    				<liferay-ui:message key="blk.label.yes" />
			    				<form:radiobutton path="dispExhibitInfo.eventOrgAgmtDone" value="false" cssClass="ques_label" onclick="onradioCheck(false);"/>
			    				<liferay-ui:message key="blk.label.no" />
							</p>                        
						</td>
					</tr>
					<tr>
						<td colspan="4" >
							<div class="sub-form-heading">
								<strong class="bold">
									<liferay-ui:message key="dispExhibitInfoBlk.subheading.evtType" />
								</strong>
							</div>
							<p>
								<label for="dispExhibitInfo.eventType">
									<liferay-ui:message key="dispExhibitInfoBlk.label.displayExhibit" />
								</label>
								<span class="red_star">*</span>
								<form:radiobutton path="dispExhibitInfo.eventType" value="Display at conference" cssClass="required"/>
								<liferay-ui:message key="dispExhibitInfoBlk.label.conference" />
								<form:radiobutton path="dispExhibitInfo.eventType" value="Display at hospital"/>
								<liferay-ui:message key="dispExhibitInfoBlk.label.hospital" />
							</p>
						</td>
					</tr>
					<tr>
						<td colspan="2" >
							<strong class="bold">
								<liferay-ui:message key="dispExhibitInfoBlk.subheading.evtDetails" />
							</strong>
						</td>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="dispExhibitInfo.eventName">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtName" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
						
						<form:input path="dispExhibitInfo.eventName"  cssClass="text-field required textTip" maxlength="250"/> 
						</td>
						
						<td class="req_label vtop" style="">
							<label for="dispExhibitInfo.eventStartDate">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtStartDate" />
							</label>
							<span class="red_star">*</span>
						</td>
					  	<td class="form-item width150" width="180">
							<form:input path="dispExhibitInfo.eventStartDate" cssClass="text-field  reqStartDate reqSave hasDatepicker" maxlength="10" style="width: 97px;"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="dispExhibitInfo.eventLocation">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtLoc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="dispExhibitInfo.eventLocation"  cssClass="text-field required textTip" maxlength="100"/>
						</td>
						<td class="req_label">
							<label for="dispExhibitInfo.eventDates">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtDate" />
							</label>
						</td>
						<td class="form-item">
							<input type="text" id="displayEventDate" name="displayEventDate" class="text-field" maxlength="10" readonly="readonly" onblur="appendDisplayEventDate();" style="width: 97px;"/>
						</td>
					
					</tr>
					<tr><td class="nopad" ><img src="/o/pgc-portlet/images/spacer.gif" width="190" height="1" alt=" " /></td>
						<td class="nopad"><img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt=" " /></td>
						<td class="nopad" ><img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt=" " /></td>
						<td class="form-item nopad">
							<form:textarea path="dispExhibitInfo.eventDates" cssClass="cmmntbxful displayDateRow reqEventDates" onkeydown="limitText(this,512);" onkeyup="limitText(this,512);" onblur="limitText(this,512);"/>
							<img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt=" " />
	                    </td>
					</tr>
				    <tr>
						<td class="req_label">
							<label for="dispExhibitInfo.eventOrganizer">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtOrganizer" />
							</label>
							<span class="red_star">*</span>
						</td>
						
						<td class="form-item">
							<form:input path="dispExhibitInfo.eventOrganizer"  cssClass="text-field required textTip" maxlength="250"/>
						</td>
						<td class="req_label ">&nbsp;</td>
						<td class="form-item ">&nbsp;</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="dispExhibitInfo.eventDesc">
								<liferay-ui:message key="dispExhibitInfoBlk.label.evtDesc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td colspan="3" class="form-item">
							<form:textarea path="dispExhibitInfo.eventDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="dispExhibitInfo.displayDesc">
								<liferay-ui:message key="dispExhibitInfoBlk.label.dispExbDesc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="dispExhibitInfo.displayDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
				    </tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="dispExhibitInfoBlk.subheading.time" />
							</strong>
						</td>
					</tr>	
					<tr>
						<td colspan="2">
							<liferay-ui:message key="dispExhibitInfoBlk.label.dispTime" />
						</td>
						<td colspan="2" class="nopad">
							<table width="0" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<label for="dispExhibitInfo.eventDispHrs">
											<liferay-ui:message key="dispExhibitInfoBlk.label.dispTime.hours" />
										</label>
								  		<form:input path="dispExhibitInfo.eventDispHrs" cssClass="ques_radio reqNumeric" maxlength="2" style="width: 50px;"/>
								  	</td>
								    <td>
										<label for="dispExhibitInfo.eventDispMins">
											<liferay-ui:message key="dispExhibitInfoBlk.label.dispTime.minutes" />
										</label>
								  		<form:input path="dispExhibitInfo.eventDispMins" cssClass="ques_radio reqNumeric" maxlength="2" style="margin-left: 5px; width: 50px;"/>
								  	</td>
								</tr>
				       		</table>
				       </td>
					</tr>	
					<tr>
						<td>
							<liferay-ui:message key="dispExhibitInfoBlk.label.dispDesc" />
						</td>
						<td colspan="3" class="form-item">
							<form:textarea path="dispExhibitInfo.eventDispDesc" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<strong class="bold" >
								<label for="dispExhibitInfo.eventDispMaterials">
									<liferay-ui:message key="prodInfoBlk.label.note" /> <span class="red_star">*</span>
								</label>
								
							</strong>
							<br/><br/>
							<liferay-ui:message key="dispExhibitInfoBlk.label.allowedMaterials" />
						</td>
						<td colspan="3"  class="form-item nopad">
						    <table cellspacing="0" cellpadding="0" border="0" width="100%">
								<tbody>
									<tr>
										<td>
											<div class="dispchecklist-cont">
												<ul class="dispchecklist">
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.azor" /><sup>&reg;</sup></span>
														<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Azor" cssClass="required-product" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.benicarReg" /><sup>&reg;</sup></span>
														<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Benicar / Benicar HCT" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.effient" /><sup>&reg;</sup></span>
														<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Effient" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.materials.evoxac" /><sup>&reg;</sup></span>
														<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Evoxac" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
													</li>
												    <li class="alt">
												    	<span><liferay-ui:message key="dispExhibitInfoBlk.materials.welchol" /><sup>&reg;</sup></span>
												    	<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Welchol" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
												    </li>
												    <li>
												    	<span><liferay-ui:message key="dispExhibitInfoBlk.materials.tribenzor" /><sup>&reg;</sup></span>
												    	<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Tribenzor" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
												    </li>
												      <li class="alt">
												    	<span><liferay-ui:message key="dispExhibitInfoBlk.materials.zelboraf" /><sup>&reg;</sup></span>
												    	<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="Zelboraf" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
												    </li>
												
												</ul>
											</div>
										</td>
										<td width="12">
											<form:checkbox path="dispExhibitInfo.eventDispMaterials" value="" onclick="otherMaterial(this.checked);" onchange="validateProductAndTherapeuticArea(this.checked, 'Product');"/>
										</td>
										<td class="" style="padding-top:0px">
											<label for="dispExhibitInfo.otherMaterial">
												<liferay-ui:message key="dispExhibitInfoBlk.label.otherMaterials" />
											</label>
											<form:input path="dispExhibitInfo.otherMaterial" cssClass="text-field margintp width100" maxlength="75"  onchange="otherProduct();"/>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				    <tr>
						<td class="req_label vtop">
							<strong class="bold">
								<label for="dispExhibitInfo.therapeuticArea">
									<liferay-ui:message key="dispExhibitInfoBlk.label.therapeuticArea" />
								</label>
							</strong><br><br>
						</td>
						<td class="form-item nopad" colspan="3">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>									
									<tr>
										<td width="320">
											<div class="checklist-cont">
												<ul class="checklist ">
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.cardio" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Cardiovascular" cssClass="required-therapeutic" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.metabolic" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Metabolic/Endocrine" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.oncology" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Oncology" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.infectious" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Infectious diseases" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>
													<li class="alt">
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.allergic" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Immunological allergic diseases" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>
													<li>
														<span><liferay-ui:message key="dispExhibitInfoBlk.therapetic.pain" /></span>
														<form:checkbox path="dispExhibitInfo.therapeuticArea" value="Pain Management" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
													</li>																																							
												</ul>
											</div>
										</td>
										<td width="12">
											<form:checkbox path="dispExhibitInfo.therapeuticArea" value=""  onclick="otherTherapeuticAreaForDispExhibit(this.checked);" onchange="validateProductAndTherapeuticArea(this.checked, 'Therapeutic');"/>
										</td>
										<td style="padding-top:5px" class="">
											<label for="dispExhibitInfo.otherTherapeutic" style="vertical-align: top;">
											<liferay-ui:message key="dispExhibitInfoBlk.therapetic.others" />
											</label>
											<form:input path="dispExhibitInfo.otherTherapeutic" maxlength="75" cssClass="text-field width100 " onchange="otherTherapeuticForDispExhibit();"/>
										</td>										
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				    <tr>
						<td colspan="4" class="btmbrddiv" ></td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="dispExhibitInfoBlk.subheading.attach" />
							</strong>
							<br /><br />
							<liferay-ui:message key="dispExhibitInfoBlk.label.attach" />
						</td>
					</tr>
					<tr>
						<td class="" colspan="4">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td style="padding:0px 0; ">
											<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tbody>
													<tr class="checkboxclickMulti">												  
														<td class="check-width">
															<input type="checkbox" value="dispaly1" class="checkAttachment" name="addAttachments">
														</td>
														<td>
															<label for="dispExhibitInfo_eventBrochure">
																<liferay-ui:message key="dispExhibitInfoBlk.label.brochureAttach" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="dispExhibitInfo_eventBrochure" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.dispExhibitInfo.eventBrochureExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                        <c:forEach items="${appForm.dispExhibitInfo.eventBrochureExistingFile}" var="eventBrochureFile">
					                                                        <c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${eventBrochureFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="dispExhibitInfo_evtBrochure" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventBrochureFile.fileName}');"><c:out value="${eventBrochureFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${eventBrochureFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="dispExhibitInfo_evtBrochure" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventBrochureFile.fileName}');"><c:out value="${eventBrochureFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
							                                                        	<a id="disp_evtbrochure_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<input type="checkbox" value="dispaly2" class="checkAttachment" name="checkbox" disabled="true" />
														</td>
														<td>
															<label for="dispExhibitInfo_eventOrgAgmtFile">
																<liferay-ui:message key="dispExhibitInfoBlk.label.draftAttach" />
															</label>
															<input type="file" name="dispExhibitInfo_eventOrgAgmtFile" class="margintp fileupload multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.dispExhibitInfo.eventOrgAgmtExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                      <c:forEach items="${appForm.dispExhibitInfo.eventOrgAgmtExistingFile}" var="eventOrgAgmtFile">
				                                                      		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${eventOrgAgmtFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="dispExhibitInfo_evtOrgAgmt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventOrgAgmtFile.fileName}');"><c:out value="${eventOrgAgmtFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${eventOrgAgmtFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="dispExhibitInfo_evtOrgAgmt" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventOrgAgmtFile.fileName}');"><c:out value="${eventOrgAgmtFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
							                                                        	<a id="disp_evtOrgAgmt_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="dispExhibitInfo_eventAgenda">
																<liferay-ui:message key="dispExhibitInfoBlk.label.agendaAttach" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="dispExhibitInfo_eventAgenda" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.dispExhibitInfo.eventAgendaExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.dispExhibitInfo.eventAgendaExistingFile}" var="eventAgendaFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${eventAgendaFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="dispExhibitInfo_evtAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventAgendaFile.fileName}');"><c:out value="${eventAgendaFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${eventAgendaFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="dispExhibitInfo_evtAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventAgendaFile.fileName}');"><c:out value="${eventAgendaFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
							                                                        	<a id="disp_evtAgenda_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="dispExhibitInfo_eventW9">
																<liferay-ui:message key="dispExhibitInfoBlk.label.w9Attach" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="dispExhibitInfo_eventW9" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.dispExhibitInfo.eventW9ExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
					                                                 	<c:forEach items="${appForm.dispExhibitInfo.eventW9ExistingFile}" var="eventW9File">
					                                                 		<c:if test="${viewMode == 'view'}">
					                                                 			<tr id='<c:out value="${eventW9File.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="dispExhibitInfo_evtW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventW9File.fileName}');"><c:out value="${eventW9File.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
					                                                 		</c:if>
					                                                 		<c:if test="${saveAction == 'update'}">
							                                                 	<tr id='<c:out value="${eventW9File.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="dispExhibitInfo_evtW9" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${eventW9File.fileName}');"><c:out value="${eventW9File.fileName}" /></a>
							                                                        </td>
							                                                       <td class="colm-2">
							                                                        	<a id="disp_evtW9_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="dispExhibitInfo_contract">
																<liferay-ui:message key="dispExhibitInfoBlk.label.contract" />
															</label>
														<input type="file" name="dispExhibitInfo_contract" class="margintp fileupload  multi"/>
															
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.dispExhibitInfo.contractFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
					                                                 	<c:forEach items="${appForm.dispExhibitInfo.contractFile}" var="contractFile">
					                                                 		<c:if test="${viewMode == 'view'}">
					                                                 			<tr id='<c:out value="${contractFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="dispExhibitInfo_contractview" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${contractFile.fileName}');"><c:out value="${contractFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
					                                                 		</c:if>
					                                                 		<c:if test="${saveAction == 'update'}">
							                                                 	<tr id='<c:out value="${contractFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="dispExhibitInfo_contract" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${contractFile.fileName}');"><c:out value="${contractFile.fileName}" /></a>
							                                                        </td>
							                                                       <td class="colm-2">
							                                                        	<a id="disp_contract_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
												</tbody>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<strong class="bold">
												<liferay-ui:message key="dispExhibitInfoBlk.label.reviewInfo" /><br/>
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
								<img src="/o/pgc-portlet/images/spacer.gif" width="155" height="1" alt="" />
							</td>
							<td style="text-align:right;padding:10px 0;" colspan="3">
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearDisplayExhibitBlock(this);" />
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>
<style>
.ques_label{
padding:5px 0px 0 0 !important;
top:-1px !important;
}
</style>