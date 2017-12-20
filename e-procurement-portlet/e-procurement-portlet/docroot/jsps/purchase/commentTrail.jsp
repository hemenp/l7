<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project E-procurement
 * @author Jitendra Rajput
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>


				<table border="0" class="search-result-table">
					<tbody>
						<tr class="alt">
                      		<th colspan="5 class="common_header_other"> Table of request entries: </th>
						</tr>
						<tr>
                      		<th width="100" class="common_header_other"><liferay-ui:message key="wf.cmnts.date.time"></liferay-ui:message></th>
                      		<th width="100" class="common_header_other"><liferay-ui:message key="wf.cmnts.status"></liferay-ui:message></th>
                      		<!--  <th width="100" class="common_header_other">Role</th> -->
                      		<th width="100" class="common_header_other width150"><liferay-ui:message key="wf.cmnts.approver"></liferay-ui:message></th>
                      		<th width="200" class="common_header_other"><liferay-ui:message key="wf.approver.comments"></liferay-ui:message></th>
                      		<th width="150" class="common_header_other"><liferay-ui:message key="wf.email.cmnts"></liferay-ui:message></th>
						</tr>
						<c:forEach items="${listCustomWFReview}" var="wfReview" varStatus="ctr">
							<tr class="${ctr.index % 2 == 0 ? 'bgcolor1 alt' : 'bgcolor2'}">
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedDate}" /></td>
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedToStatus}" /></td>
	                      		<!--  <td class="cr_table_detail">&nbsp;</td> -->
	                      		<td class="cr_table_detail"><c:out value="${wfReview.updatedByName}" /></td>
	                      		<td class="cr_table_detail"><c:out value="${wfReview.approverComments}" /></td>
	                      		<td width="250" class="cr_table_detail"><c:out value="${wfReview.emailComments}" /></td>
	                    	</tr>
						</c:forEach>
					</tbody>
				</table>
			
			</td>
		</tr>
		<tr>
			<td class="bl"></td>
			<td></td>
			<td class="br"></td>
		</tr>
	</tbody>
</table>