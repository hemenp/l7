<%-- Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved. --%>
<%--
 * @project PGC
 * @author Resmy Mathew
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------
 *
--%>
<%@ include file="/jsps/include/init_block.jsp" %>


<tr id="budgetInfor" style="display: none">
    <td class="form-content" style="padding: 0 10px;" colspan="3" id="BudgetInfoBlk">
       <h3 class="acc-title"><liferay-ui:message key="budgetInfoBlk.heading"/></h3>
       <div class="acc-content">
      		<strong class="bold">
        	<c:if test="${appForm.formType == 'DispExhibit'}">
        		<%= PortletProps.get("budget-display-exhibit-cost") %><br/>
        		<%= PortletProps.get("budget-display-exhibit-WBS") %>
        		<form:hidden path="budgetInfo.displayExhibitBudget"/>
        	</c:if>
        	<c:if test="${appForm.formType == 'POMembership'}">
        		<%= PortletProps.get("budget-professional-organization") %>
        		<form:hidden path="budgetInfo.poMemberBudget"/>
             </c:if>
            </strong>
        </div>
    </td>
</tr>

