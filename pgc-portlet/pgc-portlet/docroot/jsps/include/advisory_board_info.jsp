<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Devaki Subramaniam
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to add mandatory validation for the advisoryBoardTitle
 * Veera Reddy		|	Aug 22 2012		|	Modified to add validation onblur for the all textArea fields
 * Veera Reddy		|	Oct 23 2012		|	Modified to add validation on save.
 * Kruti Doshi		|	Sep 16 2014		|	Modified to add new fields for post works hrs of chairperson, attendee & moderator 
 *					|					|	and also added new attachments for pre-work materials & postwork materials. 
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="AdvBoardBlk">
		<h3 class="acc-title"><liferay-ui:message key="advBoardInfoBlk.heading" /></h3>
		<div class="acc-content" style="display: block;">
			<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
					<tr>
						<td class="req_label">
							<liferay-ui:message key="advBoardInfoBlk.label.contractSpecName" />
						</td>
						<td class="form-item">
						<span class="req_label">
							<form:select path="advisoryBoardInfo.contractSpecialistName" style="width:133px;" onchange="otherContract();">
					             <form:option value="" label="Select Specialist"/>
					             <form:options items= "${contractSpecialists}" />
					        </form:select>
						</span>
						</td>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
					
					<tr id="advContractShow" style="display: none">
						<td class="req_label">
							Other
						</td>
						<td class="form-item">
						<span class="req_label">
							<form:input path="advisoryBoardInfo.otherContract" cssClass="text-field" maxlength="50" value="" onchange="otherContract();"/>
						</span>
						</td>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
					<tr>
					<%-- DSI:START::Veera Reddy:: To add mandatory validation --%>
						<td class="req_label" style="width:200px ;">
							<label for="advisoryBoardInfo.advisoryBoardTitle">
								<liferay-ui:message key="advBoardInfoBlk.label.title" />
							</label>
							<span class="red_star">*</span>
						</td>						
						<td class="form-item">
							<form:input path="advisoryBoardInfo.advisoryBoardTitle" cssClass="text-field textTip reqSave" maxlength="250"/>
						</td>
						<%-- DSI:END::Veera Reddy:: To add mandatory validation --%>
						<td class="req_label">&nbsp;</td>
						<td class="form-item">&nbsp;</td>
					</tr>
					 <tr>
				        <td class="req_label">
				        	<label for="advisoryBoardInfo.eventStartDate">
								<liferay-ui:message key="common.label.eventStartDate"/>
							</label>
				        	<span class="red_star">*</span>
				        </td>
				        <td colspan="3" class="form-item">
				        	<form:input path="advisoryBoardInfo.eventStartDate" cssClass="text-field required reqStartDate"  maxlength="10" style="width: 97px;"/>
				        </td>
				      </tr>
					<tr>
						<td class="req_label">
							<label for="advisoryBoardInfo.programDate">
								<liferay-ui:message key="advBoardInfoBlk.label.date" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<input id="advisoryEventDate" class="text-field" name="advisoryEventDate" class="text-field" maxlength="10" readonly="readonly" onblur="appendAdvisoryEventDate();" style="width: 97px;"/>
						</td>
						<td class="req_label"></td>
						<td class="form-item"></td>
					</tr>
					<tr>
						<td class="nopad">&nbsp;</td>
						<td class="form-item nopad">
							<form:textarea path="advisoryBoardInfo.programDate" cssClass="cmmntbxful advisoryDateRow reqEventDates"  onkeydown="limitText(this,250);" onkeyup="limitText(this,250);" onblur="limitText(this,250);"/>
	                    </td>
	                    <td class="nopad" colspan="2"></td>
					</tr>
					<tr>
						<td class="" colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.formatLoc" />
							</strong>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<liferay-ui:message key="advBoardInfoBlk.label.format" />
						</td>
						<td colspan="3" class="form-item nopad">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td style="padding:0px 0;">
											<table cellspacing="0" cellpadding="0" border="0">
												<tbody>
													<tr>												  
														<td>
															<form:checkbox path="advisoryBoardInfo.programFormat" value="Live program"/>
														</td>
														<td>
															<liferay-ui:message key="advBoardInfoBlk.format.live" />
														</td>
													</tr>
													<tr>												  
														<td>
															<form:checkbox path="advisoryBoardInfo.programFormat" value="Web-based"/>
														</td>
														<td>
															<liferay-ui:message key="advBoardInfoBlk.format.web" />
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
															<form:checkbox path="advisoryBoardInfo.programFormat" value="Audio conference"/>
														</td>
														<td>
															<liferay-ui:message key="advBoardInfoBlk.format.audio" />
														</td>
													</tr>
													<tr>												  
														<td>
															<form:checkbox path="advisoryBoardInfo.programFormat" value="Combination (specify)" onClick="validateAdvisoryCombination();"/>
														</td>
														<td>
															<label for="advisoryBoardInfo.programFormatSpecification">
																<liferay-ui:message key="advBoardInfoBlk.format.combined" />
															</label>
															<form:input path="advisoryBoardInfo.programFormatSpecification" cssClass="text-field vmid" maxlength="250"/>
														</td>
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
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.meetignLoc" />
							</strong>
						</td>
					</tr>
					<tr>
						<td style="" class="req_label">
							<label for="advisoryBoardInfo.meetingName">
								<liferay-ui:message key="advBoardInfoBlk.label.hotelName" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.meetingName" cssClass="text-field required textTip" maxlength="250"/>
						</td>
						<td class="req_label req_lable_area" style="width:170px;">
							<label for="advisoryBoardInfo.meetingLocation.addressLine1">
								<liferay-ui:message key="advBoardInfoBlk.label.address1" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.meetingLocation.addressLine1" cssClass="text-field required textTip" maxlength="250"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<liferay-ui:message key="advBoardInfoBlk.label.address2" />
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.meetingLocation.addressLine2" cssClass="text-field textTip" maxlength="250"/>
						</td>
						<td class="req_label">
							<label for="advisoryBoardInfo.meetingLocation.city">
								<liferay-ui:message key="advBoardInfoBlk.label.city" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.meetingLocation.city" cssClass="text-field required textTip" maxlength="250"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="advisoryBoardInfo.meetingLocation.state">
								<liferay-ui:message key="advBoardInfoBlk.label.state" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:select path="advisoryBoardInfo.meetingLocation.state" cssClass="required" style="width:135px;">
						        <form:option value="" label="Select State"/>
						        <form:options items= "${usStates}" />
						    </form:select>
						</td>
						<td class="req_label">
							<label for="advisoryBoardInfo.meetingLocation.zip">
								<liferay-ui:message key="advBoardInfoBlk.label.zip" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.meetingLocation.zip" cssClass="text-field required reqZipCode" maxlength="5" style="width:57px"/>
							-
			 				<label for="advisoryBoardInfo.meetingLocation.zipExtra">
    							<form:input path="advisoryBoardInfo.meetingLocation.zipExtra" cssClass="text-field reqNumeric" maxlength="4" style="width:50px;"/>
    						</label>
						</td>
					</tr>
					<tr>
						<td class="req_label">
							<label for="advisoryBoardInfo.representativeName">
								<liferay-ui:message key="advBoardInfoBlk.label.tmrName" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.representativeName" maxlength="250" cssClass="text-field required" />
						</td>
						<td class="req_label">
							<label for="advisoryBoardInfo.representativePhone">
								<liferay-ui:message key="advBoardInfoBlk.label.phone" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="advisoryBoardInfo.representativePhone" maxlength="12" style="width:106px;" cssClass="text-field required reqPhoneNumber"/>
							<img src="<%= ctxPath %>/images/information.png" class="phoneTip" />
						</td>
					</tr>
					<tr>
						<td class="req_label" colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.businessNeed" />
							</strong>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.businessNeedDesc">
								<liferay-ui:message key="advBoardInfoBlk.businessNeed.desc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.businessNeedDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
							<liferay-ui:message key="advBoardInfoBlk.label.attach" />
						</td>
					</tr>
					<%-- <tr>
						<td class="req_label" colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.businessObj" />
							</strong>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.businessObjDesc">
								<liferay-ui:message key="advBoardInfoBlk.businessObj.desc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.businessObjDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
							<liferay-ui:message key="advBoardInfoBlk.label.attach" />
						</td>
					</tr> --%>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.dsiDesc">
								<liferay-ui:message key="advBoardInfoBlk.dsi.desc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.dsiDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
							<liferay-ui:message key="advBoardInfoBlk.label.attach" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold"><liferay-ui:message key="advBoardInfoBlk.subtitle.required" /></strong>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.chairPersonMod" /><span class="red_star">*</span>
							</strong>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop" colspan="4">
							<liferay-ui:message key="advBoardInfoBlk.label.check" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<table width="672" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="vmid">
											<form:checkbox path="advisoryBoardInfo.chairPerson" cssClass="required" value="chairperson" onClick="validateChairPerson();"/>
										</td>
										<td width="121" class="vmid">
											<label for="advisoryBoardInfo.chairPerson">
												<liferay-ui:message key="advBoardInfoBlk.subtitle.chairPerson" />
											</label>
										</td>
										<td width="86" class="vmid">
											<label for="advisoryBoardInfo.chairPersonCount">
												<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
											</label>
										</td>
										<td width="64">
											<form:input path="advisoryBoardInfo.chairPersonCount" cssClass="text-field width50 reqNumeric" maxlength="15"/>
										</td>
										<td width="148" class="vmid">
											<label for="advisoryBoardInfo.chairPersonTitle">
												<liferay-ui:message key="advBoardInfoBlk.label.degree" />
											</label>
										</td>
										<td width="193">
											<form:input path="advisoryBoardInfo.chairPersonTitle" maxlength="250" cssClass="text-field width200 textTip"/>
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<form:checkbox path="advisoryBoardInfo.moderator" cssClass="required" value="moderator" onClick="validateModerator();"/>
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.moderator">
												<liferay-ui:message key="advBoardInfoBlk.subtitle.moderator" />
											</label>
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.moderatorCount">
												<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
											</label>
										</td>
										<td>
											<form:input path="advisoryBoardInfo.moderatorCount" cssClass="text-field width50 reqNumeric textTip" maxlength="15"/>
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.moderatorTitle">
												<liferay-ui:message key="advBoardInfoBlk.label.degree" />
											</label>
										</td>
										<td>
											<form:input path="advisoryBoardInfo.moderatorTitle" maxlength="250" cssClass="text-field width200"/>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<label for="attendees">
								<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.attendees" />
								<span class="red_star">*</span>
								</strong>
							</label>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.label.checkHowMany" />
							<strong class="bold">
						</td>
					</tr>
					<tr>
						<td class="form-item" colspan="4">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="vmid">
											<input type="checkbox" id="attendees" name="attendees" class="required" value="mds" onClick="validateAttendees1(this.checked);">
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.mdsAttendeesCount">
												<liferay-ui:message key="advBoardInfoBlk.label.mds" />
											</label>
										</td>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
										</td>
										<td>
											<form:input path="advisoryBoardInfo.mdsAttendeesCount" cssClass="text-field width50 reqNumeric" maxlength="15" onChange="attendeeTotal();" />
										</td>
										<td class="vmid">
											<input type="checkbox" id="attendees" name="attendees" value="pas" onClick="validateAttendees2(this.checked);">
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.paAttendeesCount">
												<liferay-ui:message key="advBoardInfoBlk.label.pas" />
											</label>
										</td>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
										</td>
										<td>
											<form:input path="advisoryBoardInfo.paAttendeesCount" cssClass="text-field width50 reqNumeric" maxlength="15" onChange="attendeeTotal();"/>
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<input type="checkbox" id="attendees" name="attendees" value="nurses" onClick="validateAttendees3(this.checked);">
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.nursesAttendeesCount">
												<liferay-ui:message key="advBoardInfoBlk.label.nurses" />
											</label>
										</td>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
										</td>
										<td>
											<form:input path="advisoryBoardInfo.nursesAttendeesCount" cssClass="text-field width50 reqNumeric" maxlength="15" onChange="attendeeTotal();"/>
										</td>
										
										<td class="vmid">
											<input type="checkbox" id="attendees" name="attendees" value="pharma" onClick="validateAttendees4(this.checked);">
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.pharmaAttendeesCount">
												<liferay-ui:message key="advBoardInfoBlk.label.pharma" />
											</label>
										</td>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
										</td>
										<td>
											<form:input path="advisoryBoardInfo.pharmaAttendeesCount" cssClass="text-field width50 reqNumeric" maxlength="15" onChange="attendeeTotal();"/>
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<input type="checkbox" id="attendees" name="attendees"  value="others" onClick="validateAttendees5(this.checked);">
										</td>
										<td class="vmid">
											<label for="advisoryBoardInfo.otherAttendeesCount">
												<liferay-ui:message key="advBoardInfoBlk.label.others" />
											</label>
										</td>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.howMany" />
										</td>
										<td>
											<form:input path="advisoryBoardInfo.otherAttendeesCount" maxlength = "15" cssClass="text-field width50 reqNumeric" onChange="attendeeTotal();" />
										</td>
										<td class="vmid"></td>
										<td>
											<label for="advisoryBoardInfo.otherAttendeesName">
												<liferay-ui:message key="advBoardInfoBlk.label.otherNames" />
											</label>
										</td>
										<td colspan="2">
											<form:input path="advisoryBoardInfo.otherAttendeesName" maxlength = "75" cssClass="text-field width200 textTip" style="margin-left:2px;margin-right:1px;"/>
										</td>
									</tr>
									<tr>
										<td class="vmid" colspan="2"></td>
										<td class="vmid">
											<label for="advisoryBoardInfo.totalAttendees">
												<liferay-ui:message key="advBoardInfoBlk.label.total" />
											</label>
										</td>
										<td><form:input path="advisoryBoardInfo.totalAttendees" maxlength ="15" cssClass="text-field required reqNumeric width50" /></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.chairPerson" /> <span class="red_star">*</span>
							</strong><br />
							<liferay-ui:message key="advBoardInfoBlk.label.servicesDesc" />
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.chairPersonServiceDesc" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">&nbsp;</td>
						<td class="form-item nopad" colspan="3">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td width="300" style="width: 300px;" class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.preparationHrs" />
										</td>
										<td class="vmid" style="width:110px;">
											<form:input path="advisoryBoardInfo.chairPersonPreparationHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="chairPersonTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.participateHrs" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.chairPersonParticipateHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="chairPersonTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.postWork" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.chairPersonPostWorkHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="chairPersonTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.totalHrs" />
										</td>
										<td width="100" class="vmid">
											<form:input path="advisoryBoardInfo.chairPersonTotalHrs" cssClass="text-field width50 reqNumeric" maxlength="3"/> Hours
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.moderator" /> <span class="red_star">*</span>
							</strong><br>
							<liferay-ui:message key="advBoardInfoBlk.label.servicesDesc" />
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.moderatorServiceDesc" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">&nbsp;</td>
						<td class="form-item nopad" colspan="3">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td width="300" style="width: 300px;" class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.preparationHrs" />
										</td>
										<td class="vmid" style="width:110px;">
											<form:input path="advisoryBoardInfo.moderatorPreparationHrs" cssClass="width50 reqNumeric" maxlength="3" onChange="moderatorTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.participateHrs" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.moderatorParticipateHrs" cssClass="width50 reqNumeric" maxlength="3" onChange="moderatorTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.postWork" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.moderatorPostWorkHrs" cssClass="width50 reqNumeric" maxlength="3" onChange="moderatorTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.totalHrs" />
										</td>
										<td width="100" class="vmid">
											<form:input path="advisoryBoardInfo.moderatorTotalHrs" cssClass="text-field width50 reqNumeric" maxlength="3"/> Hours
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.subtitle.attendees" /> <span class="red_star">*</span>
							</strong><br />
							<liferay-ui:message key="advBoardInfoBlk.label.servicesDesc" />
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.attendeesServiceDesc" cssClass="cmmntbxful" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label">&nbsp;</td>
						<td class="form-item nopad" colspan="3">
							<table cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td width="300" style="width: 300px;" class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.preparationHrs" />
										</td>
										<td width="100" class="vmid" style="width:110px;">
											<form:input path="advisoryBoardInfo.attendeesPreparationHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="attendeesTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.participateHrs" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.attendeesParticipateHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="attendeesTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.postWork" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.attendeesPostWorkHrs" cssClass="text-field width50 reqNumeric" maxlength="3" onChange="attendeesTotalHrs();"/> Hours
										</td>
									</tr>
									<tr>
										<td class="vmid">
											<liferay-ui:message key="advBoardInfoBlk.label.totalHrs" />
										</td>
										<td class="vmid">
											<form:input path="advisoryBoardInfo.attendeesTotalHrs" cssClass="text-field width50 reqNumeric" maxlength="3"/> Hours
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td class="vtop" colspan="4">
							<liferay-ui:message key="advBoardInfoBlk.label.qualificationDesc" />
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.chairPersonQualification">
								<liferay-ui:message key="advBoardInfoBlk.label.chairPerson" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.chairPersonQualification" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);" />
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.moderatorQualification">
								<liferay-ui:message key="advBoardInfoBlk.label.moderator" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.moderatorQualification" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.attendeesQualification">
								<liferay-ui:message key="advBoardInfoBlk.label.attendees" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.attendeesQualification" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.label.directions" />
							</strong> 
							<liferay-ui:message key="advBoardInfoBlk.label.directionsDesc" />
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.dsiEmployeeCount">
								<liferay-ui:message key="advBoardInfoBlk.label.dsiEmp" />
							</label>
						</td>
						<td class="form-item" colspan="3">
							<form:input path="advisoryBoardInfo.dsiEmployeeCount" cssClass="text-field width50 required reqNumeric" maxlength="3"/>
						</td>
					</tr>
					<tr>
						<td class="req_label vtop">
							<label for="advisoryBoardInfo.dsiEmployeeRole">
								<liferay-ui:message key="advBoardInfoBlk.label.dsiEmpRole" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="advisoryBoardInfo.dsiEmployeeRole" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
					</tr>
					<tr>
						<td class="btmbrddiv" colspan="4"></td>
					</tr>
					<tr>
						<td colspan="4">
							<p>
								<strong class="bold">
									<liferay-ui:message key="advBoardInfoBlk.label.compensation" />
								</strong>
								<liferay-ui:message key="advBoardInfoBlk.label.compensationDesc" />
							</p>
							<p>
								<strong class="bold">
									<liferay-ui:message key="advBoardInfoBlk.label.meals" />
								</strong>
								<liferay-ui:message key="advBoardInfoBlk.label.mealsDesc" />
							</p> 
							<p>
								<strong class="bold">
									<liferay-ui:message key="advBoardInfoBlk.label.travel" />
								</strong>
								<liferay-ui:message key="advBoardInfoBlk.label.travelDesc" />
							</p>
						</td>
					 </tr>
					<tr>
						<td class="btmbrddiv" colspan="4"></td>
					</tr>
					<tr>
						<td colspan="4">
							<strong class="bold">
								<liferay-ui:message key="advBoardInfoBlk.label.checkAttach" />
							</strong><br /><br />
							<liferay-ui:message key="advBoardInfoBlk.label.confirmAttach" />
						</td>
					</tr>
					<tr>
						<td class="" colspan="4">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td style="padding:0px 0; width:350px">
											<table cellspacing="0" cellpadding="0" border="0" width="100%">
												<tbody>
													<tr class="checkboxclickMulti">												  
														<td class="check-width">
															<input type="checkbox" value="dispaly1" class="checkAttachment" name="addAttachments">
														</td>
														<td>
															<label for="advisoryBoardInfo_detailAgenda">
																<liferay-ui:message key="advBoardInfoBlk.label.detailAgenda" />
															</label>
															<span class="red_star">*</span>
														 	<input type="file" name="advisoryBoardInfo_detailAgenda" class="margintp fileupload reqmulti multi"/>
														 	<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.detailAgendaExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.detailAgendaExistingFile}" var="detailAgendaFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${detailAgendaFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_dtAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${detailAgendaFile.fileName}');"><c:out value="${detailAgendaFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${detailAgendaFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_dtAgenda" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${detailAgendaFile.fileName}');"><c:out value="${detailAgendaFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
										                                            	<a id="adv_dtAgenda_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<input type="checkbox" value="dispaly2" class="checkAttachment" name="checkbox">
														</td>
														<td>
															<label for="advisoryBoardInfo_programBudget">
																<liferay-ui:message key="advBoardInfoBlk.label.prgBudget" />
															</label>
															<span class="red_star">*</span>
															<input type="file" name="advisoryBoardInfo_programBudget" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.programBudgetExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.programBudgetExistingFile}" var="programBudgetFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${programBudgetFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_prgBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programBudgetFile.fileName}');"><c:out value="${programBudgetFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${programBudgetFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_prgBudget" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${programBudgetFile.fileName}');"><c:out value="${programBudgetFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="adv_prgBudget_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<input type="checkbox" value="dispaly3" class="checkAttachment" name="checkbox">
														</td>
														<td>
															<label for="advisoryBoardInfo_addressedQuestions">
																<liferay-ui:message key="advBoardInfoBlk.label.questions" />
															</label>
															<span class="red_star">*</span><br />
															<input type="file" name="advisoryBoardInfo_addressedQuestions" class="margintp fileupload reqmulti multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.addressedQuestionsExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.addressedQuestionsExistingFile}" var="addressedQuestionsFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${addressedQuestionsFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_addressedQues" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${addressedQuestionsFile.fileName}');"><c:out value="${addressedQuestionsFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${addressedQuestionsFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_addressedQues" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${addressedQuestionsFile.fileName}');"><c:out value="${addressedQuestionsFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="adv_addressedQues_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="advisoryBoardInfo.preworkMaterialsList">
																<liferay-ui:message key="advBoardInfoBlk.label.preWorkMaterial" />
															</label>
															<input type="file" name="advisoryBoardInfo.preworkMaterialsList" class="margintp fileupload multi"/>	
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.preworkMaterialsListExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.preworkMaterialsListExistingFile}" var="materialsListFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_preWorkMaterial" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${materialsListFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_preWorkMaterial" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
										                                            	<a id="adv_attendee_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="advisoryBoardInfo.postworkMaterialsList">
																<liferay-ui:message key="advBoardInfoBlk.label.postWorkMaterial" />
															</label>
															<input type="file" name="advisoryBoardInfo.postworkMaterialsList" class="margintp fileupload multi"/>	
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.postworkMaterialsListExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.postworkMaterialsListExistingFile}" var="materialsListFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${materialsListFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_postWorkMaterial" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${materialsListFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_postWorkMaterial" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${materialsListFile.fileName}');"><c:out value="${materialsListFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
										                                            	<a id="adv_attendee_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<label for="advisoryBoardInfo_attendeesList">
																<liferay-ui:message key="advBoardInfoBlk.label.attendeesList" />
															</label>
															<input type="file" name="advisoryBoardInfo_attendeesList" class="margintp fileupload multi"/>	
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.attendeesListExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.attendeesListExistingFile}" var="attendeesListFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${attendeesListFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_attendee" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${attendeesListFile.fileName}');"><c:out value="${attendeesListFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${attendeesListFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_attendee" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${attendeesListFile.fileName}');"><c:out value="${attendeesListFile.fileName}" /></a>
							                                                        </td>
							                                                         <td class="colm-2">
										                                            	<a id="adv_attendee_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
															<input type="checkbox" value="dispaly5" class="checkAttachment" name="checkbox">
														</td>
														<td>
															<label for="advisoryBoardInfo_cvCopy">
																<liferay-ui:message key="advBoardInfoBlk.label.cvCopy" />
															</label>
															<input type="file" name="advisoryBoardInfo_cvCopy" class="margintp fileupload multi"/>
															<c:if test="${((saveAction == 'update') || (viewMode == 'view')) && (fn:length(appForm.advisoryBoardInfo.cvCopyExistingFile) > 0) }">
																<br/>
																<table style="border-bottom: 0pt none;" class="taglib-search-iterator btmmargin" border="0" cellpadding="0" cellspacing="0">
					                                                <tbody>
				                                                       <c:forEach items="${appForm.advisoryBoardInfo.cvCopyExistingFile}" var="cvCopyFile">
				                                                       		<c:if test="${viewMode == 'view'}">
							                                                 	<tr id='<c:out value="${cvCopyFile.fileId}" />'>
							                                                        <td width="100%">
							                                                           	<a id="advisoryBoardInfo_cv" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${cvCopyFile.fileName}');"><c:out value="${cvCopyFile.fileName}" /></a>
							                                                        </td>
						                                                    	</tr>
						                                                    </c:if>
						                                                    <c:if test="${saveAction == 'update'}">
						                                                    	<tr id='<c:out value="${cvCopyFile.fileId}" />'>
							                                                        <td width="85%">
							                                                           	<a id="advisoryBoardInfo_cv" class="doc-link" onClick="documentURL(this.parentNode.parentNode.id, this.id,'<%= viewFile %>','${cvCopyFile.fileName}');"><c:out value="${cvCopyFile.fileName}" /></a>
							                                                        </td>
							                                                        <td class="colm-2">
										                                            	<a id="adv_cv_del" class="doc-link" onClick="deleteURL(this.parentNode.parentNode.id, this.id,'<%= deleteFile %>');">&nbsp;&nbsp;Delete</a>
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
										<td style="padding:0px 0;">
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<strong class="bold">
												<liferay-ui:message key="advBoardInfoBlk.label.cvNote" /><br />
												<liferay-ui:message key="advBoardInfoBlk.label.attachNote" /><br/>
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
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearAdvisoryBoardBlock(this);" />
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
	if(j("#advisoryBoardInfo\\.contractSpecialistName").val()=="Other"){
		j("#advisoryBoardInfo\\.otherContract").addClass('reqSave');
		j("#advContractShow").show();
	} else {
		j("#advisoryBoardInfo\\.otherContract").removeClass('reqSave');
		j("#advisoryBoardInfo\\.otherContract").attr("value", '');
		j("#advContractShow").hide();
	}
  
}
</script>