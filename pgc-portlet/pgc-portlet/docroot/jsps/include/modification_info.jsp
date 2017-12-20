<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Vijayan Chendrayan
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@ include file="/jsps/include/init_block.jsp" %>
<tr>
	<td class="form-content" style="padding: 0 10px;" colspan="3" id="ModInfoBlk">
	    <h3 class="acc-title"><liferay-ui:message key="modInfoBlk.heading" /></h3>
	    <div class="acc-content" style="display: block;">
	  		<table cellspacing="0" cellpadding="0" border="0" style="width:100%">
				<tbody>
					<tr>
						<td class="req_label">
							<label for="modInfo.modificationDesc">
								<liferay-ui:message key="modInfoBlk.label.modificationDesc" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="modInfo.modificationDesc" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
				    </tr>
             		<tr>
						<td class="req_label">
							<label for="modInfo.businessNeed">
								<liferay-ui:message key="modInfoBlk.label.businessNeed" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item" colspan="3">
							<form:textarea path="modInfo.businessNeed" cssClass="cmmntbxful required" onkeydown="limitText(this,1000);" onkeyup="limitText(this,1000);" onblur="limitText(this,1000);"/>
						</td>
				    </tr>
				    <tr>
				    	<td class="req_label" colspan="4">
				    		<liferay-ui:message key="modInfoBlk.label.dateLabel" />
				    	</td>
				    </tr>
					<tr>
						<td class="req_label">
							<label for="modInfo.modEffectiveDate">
								<liferay-ui:message key="modInfoBlk.label.date" />
							</label>
							<span class="red_star">*</span>
						</td>
						<td class="form-item">
							<form:input path="modInfo.modEffectiveDate" cssClass="text-field required" readonly="readonly" maxlength="10"/>
						</td>
						<td class="form-item font12" colspan="2"></td>
					</tr>
					<c:if test="${OBJECTID == '' || OBJECTID == null}">
						<tr>
							<td style="text-align: right; padding: 10px 0;" colspan="4">
								<input type="button" value='<liferay-ui:message key="clearbutton.label"/>' class="button input-button" onclick="javascript:clearModificationBlock(this);" />
	                        </td>
		  				</tr>
		  			</c:if>
				</tbody>
			</table>
		</div>
	</td>
</tr>