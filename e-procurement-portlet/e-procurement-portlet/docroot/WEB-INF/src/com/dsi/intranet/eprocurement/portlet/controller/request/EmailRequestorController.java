/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.controller.request;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.dsi.intranet.eprocurement.service.WorkflowReviewLocalServiceUtil;
import com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowProgressUtil;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.WorkflowReview;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementCommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.StringPool;
import java.util.List;

/**
 * <a href="EmailRequestorController.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project Eprocurement
 * @Author Resmy Mathew
 * @Description Email Requestor class for sending mail to requestor and adding email comments.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */

@Controller("emailRequestorController")
@RequestMapping(value = "VIEW")
public class EmailRequestorController
{
    private static final Log LOGGER = LogFactoryUtil.getLog(EmailRequestorController.class);
    

    @ActionMapping(params = "cmd=saveEmailComment")
    public void saveEmailRequestorComments(ActionRequest request, ActionResponse response) throws Exception
    {

        ClassLoader classLoader = EmailRequestorController.class.getClassLoader();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");
        String requestId = ParamUtil.getString(request, "requestId");
        String comments = ParamUtil.getString(request, "emailComments");
        long purchaseRequestId = 0;
        if (Validator.isNotNull(requestId))
        {
            purchaseRequestId = Long.parseLong(requestId);
        }
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        String fromEmail = ParamUtil.getString(request, "fromEmail");
        String toEmail = ParamUtil.getString(request, "toEmail");
        String fromName = ParamUtil.getString(request, "fromName");
        String toName = ParamUtil.getString(request, "toName");
        String newSubject = ParamUtil.getString(request, "Subject");
        long updatedBy = ParamUtil.getLong(request, "updatedBy");
        String emailComments = ParamUtil.getString(request, "emailComments");
        String viewRequestUrl = StringPool.BLANK;
        String approverComments = StringPool.BLANK;
        int workFlowReviewSize = 0;
        String stage = String.valueOf(themeDisplay.getUserId());
        String newStatus = StringPool.BLANK;
        String nextStage = StringPool.BLANK;
        String isApproverRole = String.valueOf(Boolean.FALSE);
        WorkflowReview workflowReview = null;
        WorkflowRequest eprocuWorkflowRequest = null;
        long classNameId = 0;
        EprocurementRequest eprocuRequest = EprocurementRequestLocalServiceUtil
                .getEprocurementRequest(purchaseRequestId);
        if (Validator.isNotNull(eprocuRequest))
        {
            if (eprocuRequest.getProjectOwnerId() > 0)
            {
                nextStage = String.valueOf(eprocuRequest.getProjectOwnerId());
            } else if (eprocuRequest.getSupervisorId() > 0)
            {
                nextStage = String.valueOf(eprocuRequest.getSupervisorId());
            }
            newStatus = eprocuRequest.getStatus();
        }
        classNameId = EProcurementUtil.getEprocRequestClassNameId();
        try
        {
            eprocuWorkflowRequest = EProcurementUtil.getWFProposalRequest(companyId, groupId,
                    EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST, purchaseRequestId, Boolean.TRUE);

        } catch (Exception e)
        {
            LOGGER.error("No workflow is associated with requestId : " + requestId);
        }

        if (eprocuWorkflowRequest != null) /* get workflow review details */
        {
            List<WorkflowReview> wfReviews = WorkflowReviewLocalServiceUtil.getAllWFReviews(companyId, groupId,
                    classNameId, purchaseRequestId);
            if (Validator.isNotNull(wfReviews))
            {
                workFlowReviewSize = wfReviews.size();
                workFlowReviewSize = workFlowReviewSize - 1;
                if (Validator.isNotNull(workFlowReviewSize))
                {
                    workflowReview = wfReviews.get(workFlowReviewSize);
                }
                if (Validator.isNotNull(workflowReview))
                {
                    WorkflowProgressUtil.addWorkflowReview(workflowReview.getCompanyId(), workflowReview.getGroupId(),
                            purchaseRequestId, workflowReview.getUpdatedToStatus(), stage,
                            workflowReview.getIsApproverRole(), workflowReview.getNextStage(),
                            workflowReview.getApproverComments(), emailComments, updatedBy, eprocuWorkflowRequest);
                }
            }
        } else
        { /* add workflowreview without workflow requestId */
           eprocuWorkflowRequest = new WorkflowRequestImpl();
           WorkflowProgressUtil.addWorkflowReview(companyId, groupId, purchaseRequestId, newStatus, stage,
                    isApproverRole, nextStage, approverComments, emailComments, updatedBy, eprocuWorkflowRequest);
        }

        viewRequestUrl = EProcurementUtil.viewRequestURL(request, themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, purchaseRequestId);

        // Read subject from template
        String subject = StringUtil.read(classLoader, EProcurementConstants.EMAIL_REQUESTOR_SUBJECT_TEMPLATE, true);

        // Read body from template
        String body = StringUtil.read(classLoader, EProcurementConstants.EMAIL_REQUESTOR_BODY_TEMPLATE, true);
        subject = StringUtil.replace(subject, new String[] { "[$requestId]" }, new String[] { requestId });

        body = StringUtil.replace(body,
                new String[] { "[$fromName]", "[$requestId]", "[$comments]", "[$viewRequest]" }, new String[] {
                        fromName, requestId, comments, viewRequestUrl });
        if (Validator.isNotNull(newSubject))
        {
            subject = newSubject;
        }
        try
        {
            EprocurementCommonUtil.sendEmail(fromName, fromEmail, toName, toEmail, subject, body);

        } catch (Exception e)
        {
            LOGGER.error("Error in email Requestor notification" + e.getMessage(), e);
        }

        response.sendRedirect(viewRequestUrl);
    }

    @ActionMapping(params = "cmd=cancelRequestor")
    public void cancelEmailRequestorComments(ActionRequest request, ActionResponse response) throws Exception
    {

        String requestId = ParamUtil.getString(request, "requestId");
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");

        long purchaseRequestId = 0;
        if (Validator.isNotNull(requestId))
        {
            purchaseRequestId = Long.parseLong(requestId);
        }
        String viewRequestUrl = EProcurementUtil.viewRequestURL(request, themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, purchaseRequestId);

        response.sendRedirect(viewRequestUrl);
    }
}
