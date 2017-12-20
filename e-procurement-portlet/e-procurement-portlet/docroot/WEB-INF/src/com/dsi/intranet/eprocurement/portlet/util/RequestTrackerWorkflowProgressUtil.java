/**
 * Copyright © 2010 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.WorkflowDefinition;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.WorkflowReview;
import com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl;
import com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowReviewLocalServiceUtil;
import com.dsi.intranet.xml.EProcurementProcessInfo;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * <a href="RequestTrackerWorkflowProgressUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project Intranet
 * @author Kalpesh Sangani
 * @Description This class replica class of WorkflowProgressUtil and basically this call invoked by web service call from request tracker portlet
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             --------------------
 *             --------------------------------------------------------
 */

public final class RequestTrackerWorkflowProgressUtil
{
	private RequestTrackerWorkflowProgressUtil()
	{
		
	}
	
    private static final Log LOGGER = LogFactoryUtil.getLog(RequestTrackerWorkflowProgressUtil.class);

    private static final List<String> LIST_POSSIBLE_STATUS = new ArrayList<String>();
    private static final String REQUESTIDMAILVAR = "[$requestId]";
    private static final String REQUESTNAMEMAILVAR = "[$requestorName]";
    private static final String VIEWREQUESTMAILVAR = "[$viewRequest]";
    
    static
    {
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_NEW);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_LEVEL1_APPROVED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_CANCELLED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_COMPLETED);
    }

    /**
     * 
     * @param companyId
     * @param groupId
     * @param requestId
     * @param wfDefinitionId
     * @param updatorUserId
     * @return WorkflowRequest
     * @throws SystemException
     * 
     * Adds mapping of Request Id & Workflow Definition Id in WorkflowRequest table.
     */
    public static WorkflowRequest addUpdateWFRequest(long companyId, long groupId, long requestId,
            String wfDefinitionId, long updatorUserId) throws SystemException
    {
        WorkflowRequest wfRequest = new WorkflowRequestImpl();
        wfRequest.setClassNameId(EProcurementUtil.getEprocRequestClassNameId());
        wfRequest.setClassPK(requestId);
        wfRequest.setCompanyId(companyId);
        wfRequest.setCreatedBy(updatorUserId);
        wfRequest.setCreatedDate(new Date());
        wfRequest.setGroupId(groupId);
        wfRequest.setIsActive(Boolean.TRUE);
        wfRequest.setWorkflowDefinitionId(Long.valueOf(wfDefinitionId));
        long workflowRequestId = CounterLocalServiceUtil.increment(EProcurementConstants.CLASS_NAME_WF_REQUEST, 2);
        wfRequest.setWorkflowRequestId(workflowRequestId);
        wfRequest = WorkflowRequestLocalServiceUtil.addWorkflowRequest(wfRequest);

        return wfRequest;
    }

    /**
     * 
     * @param companyId
     * @param groupId
     * @param requestId
     * @param newStatus
     * @param stage
     * @param isApproverRole
     * @param nextStage
     * @param approverComments
     * @param updatorUserId
     * @param currentWfRequest
     * @throws SystemException
     * 
     * Adds Audit Trail to WorkflowReview table with approver & email comments 
     */
    public static void addWFReview(long companyId, long groupId, long requestId, String newStatus, String stage,
            String isApproverRole, String nextStage, String approverComments, long updatorUserId,
            WorkflowRequest currentWfRequest) throws SystemException
    {
        WorkflowReview wfReview = new WorkflowReviewImpl();

        wfReview.setClassNameId(EProcurementUtil.getEprocRequestClassNameId());
        wfReview.setClassPK(requestId);

        wfReview.setCompanyId(companyId);
        wfReview.setGroupId(groupId);

        wfReview.setIsApproverRole(String.valueOf(isApproverRole));
        wfReview.setNextStage(nextStage);

        if (EProcurementUtil.isNotNullNonEmptyString(approverComments))
        {
            wfReview.setApproverComments(approverComments);
        }

        wfReview.setUpdatedBy(updatorUserId);
        wfReview.setUpdatedDate(new Date());
        wfReview.setUpdatedToStatus(newStatus);

        /* If currentWfRequest is not null, then add WFRequestId */
        if (currentWfRequest != null)
        {
            wfReview.setWorkflowRequestId(currentWfRequest.getWorkflowRequestId());
        }

        long workflowReviewId = CounterLocalServiceUtil.increment(EProcurementConstants.CLASS_NAME_WF_REVIEW, 2);
        wfReview.setWorkflowReviewId(workflowReviewId);

        WorkflowReviewLocalServiceUtil.addWorkflowReview(wfReview);
    }

    public static void addWorkflowReview(long companyId, long groupId, long requestId, String newStatus, String stage,
            String isApproverRole, String nextStage, String approverComments, String emailComments, long updatorUserId,
            WorkflowRequest currentWfRequest) throws SystemException
    {
        WorkflowReview wfReview = new WorkflowReviewImpl();

        wfReview.setClassNameId(EProcurementUtil.getEprocRequestClassNameId());
        wfReview.setClassPK(requestId);

        wfReview.setCompanyId(companyId);
        wfReview.setGroupId(groupId);

        wfReview.setIsApproverRole(String.valueOf(isApproverRole));
        wfReview.setNextStage(nextStage);

        if (EProcurementUtil.isNotNullNonEmptyString(approverComments))
        {
            wfReview.setApproverComments(approverComments);
        }
        if (Validator.isNotNull(emailComments))
        {
            wfReview.setEmailComments(emailComments);
        }
        wfReview.setUpdatedBy(updatorUserId);
        wfReview.setUpdatedDate(new Date());
        wfReview.setUpdatedToStatus(newStatus);

        /* If currentWfRequest is not null, then add WFRequestId */
        if (currentWfRequest != null)
        {
            wfReview.setWorkflowRequestId(currentWfRequest.getWorkflowRequestId());
        }

        long workflowReviewId = CounterLocalServiceUtil.increment(EProcurementConstants.CLASS_NAME_WF_REVIEW, 2);
        wfReview.setWorkflowReviewId(workflowReviewId);

        WorkflowReviewLocalServiceUtil.addWorkflowReview(wfReview);
    }

    /**
     * 
     * @param currentStatus
     * @param userIdStage
     * @return String 
     *  
     * Returns new status based on current status when "Advance Workflow" button is clicked.  
     */
    private static String getForwardStatus(String currentStatus, String userIdStage)
    {
        /* By-dafault last status will be new next status, if nothing is found */
        String nextForwardStatus = currentStatus;

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_NEW))
        {
            nextForwardStatus = EProcurementConstants.STATUS_LEVEL1_APPROVED;
        }

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_LEVEL1_APPROVED))
        {
            nextForwardStatus = EProcurementConstants.STATUS_WORKFLOW_ASSIGNED;
        }

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED))
        {
            nextForwardStatus = EProcurementConstants.STATUS_APPROVED;
        }

        /**
         * if stage approver is approving then rather than setting "APPROVED",
         * set status as "Program Manager APPROVED - Anantha" i.e.
         * "Job Title APPROVED - User Fullname"
         */
        if (nextForwardStatus.contains(EProcurementConstants.STATUS_APPROVED)
                && !nextForwardStatus.equalsIgnoreCase(EProcurementConstants.STATUS_LEVEL1_APPROVED)
                && EProcurementUtil.isNotNullNonEmptyString(userIdStage))
        {
            long userId = Long.valueOf(userIdStage);
            if (userId > 0)
            {
                User user = null;
                try
                {
                    user = UserLocalServiceUtil.getUser(userId);
                } catch (PortalException e)
                {
                    LOGGER.error("Error while getting user in getForwardStatus() : " + e.getMessage());
                } catch (SystemException e)
                {
                    LOGGER.error("Error while getting user in getForwardStatus() : " + e.getMessage());
                }
                if (user != null)
                {
                    nextForwardStatus = EProcurementUtil.constructStageApprovalStatus(user);
                }
            }
        }

        return nextForwardStatus;
    }

    /**
     * 
     * @param currentWFRequest
     * @throws SystemException
     * 
     * Make WorkflowDefinition-Request mapping inactive when new WF has been assigned to the same Request.
     */
    public static void inActivateWFRequest(WorkflowRequest currentWFRequest) throws SystemException
    {
        currentWFRequest.setIsActive(Boolean.FALSE);
        WorkflowRequestLocalServiceUtil.updateWorkflowRequest(currentWFRequest);
    }

    /**
     * 
     * @param currentWFRequest
     * @param request
     * @param wfDefinition
     * @return {@link Boolean} This finds out whether WF is over ot not for
     *         given request.
     */
    public static boolean isWorkflowOver(WorkflowRequest currentWFRequest, EprocurementRequest request,
            WorkflowDefinition wfDefinition, String hidRelativeStatus, String oldNextStage)
    {
        boolean isWFOver = Boolean.FALSE;
        long lastStageId = 0;
        try
        {
            if (currentWFRequest != null && wfDefinition != null
                    && EProcurementUtil.isNotNullNonEmptyString(oldNextStage))
            {
                List<Long> listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    long nextStageId = Long.valueOf(oldNextStage);
                    lastStageId = listStageUserIds.get((listStageUserIds.size() - 1));

                    LOGGER.debug("nextStageId..." + nextStageId + "lastStageId.." + lastStageId + "request.getStage() "
                            + request.getStage());
                    if (nextStageId == lastStageId)
                    {
                        isWFOver = Boolean.TRUE;
                        LOGGER.debug("Found the next approver....");
                    }
                }

                if (!isWFOver)
                {
                    if (EProcurementUtil.isNotNullNonEmptyString(hidRelativeStatus)
                            && EProcurementUtil.isNumber(hidRelativeStatus))
                    {
                        long hidRelativeId = Long.valueOf(hidRelativeStatus);
                        if (hidRelativeId == lastStageId)
                        {
                            isWFOver = Boolean.TRUE;
                            LOGGER.debug("workflow is jumped to final approver");
                        }
                    }
                }
            }

        } catch (Exception e)
        {
            LOGGER.error("Error in RequestTrackerWorkflowProgressUtil.isWorkflowOver() : " + e.getMessage());
        }
        return isWFOver;
    }

    /**
     * Notify Requester if request is reset to new
     * @param projectOwnerId
     */
    private static void notifyInitialApprover(EProcurementProcessInfo eprocurementProcessInfo, long nextApproverUserId)
    {
        LOGGER.info("Request is rest to new .....notifyInitialApprover()..");
        String purchaseRequestId = String.valueOf(eprocurementProcessInfo.getRequestId());
        String subject = StringPool.BLANK;
        String body = StringPool.BLANK;
        String viewRequestUrl = StringPool.BLANK;
        String nextApproverName = StringPool.BLANK;
        String fromAdmin = EProcurementConstants.EPROC_EMAIL_FROM_NAME;
        String fromAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
        String nextApproverEmailAddress = StringPool.BLANK;
        ClassLoader classLoader = RequestTrackerWorkflowProgressUtil.class.getClassLoader();
        String fromName = StringPool.BLANK;
        fromName = EProcurementUtil.getUserName(eprocurementProcessInfo.getRequestorId());
        nextApproverName = EProcurementUtil.getUserName(nextApproverUserId);
        nextApproverEmailAddress = EProcurementUtil.getUserEmailAddress(nextApproverUserId);
        try
        {
            subject = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_SUBJECT_TEMPLATE, true);
            body = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_BODY_TEMPLATE, true);
            subject = StringUtil.replace(subject, new String[] { REQUESTIDMAILVAR}, new String[] { purchaseRequestId });
            viewRequestUrl = eprocurementProcessInfo.getViewRequestUrl();
            body = StringUtil.replace(body, new String[] { REQUESTNAMEMAILVAR, VIEWREQUESTMAILVAR }, new String[] {
                    fromName, viewRequestUrl });

            EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, nextApproverName, nextApproverEmailAddress,
                    subject, body);
        } catch (IOException e)
        {
            LOGGER.error("Failed to read email template..." + e.getMessage());
        } catch (Exception e)
        {
            LOGGER.error("Problem while sending email to initial approver.." + e.getMessage());
        }
    }

    /**
     * Notify requester about request.
     * i.e if request is approved by 1st stage approver then 
     * update next stage approver that request in his/her plate
     * @param actionRequest
     * @param themeDisplay
     * @param requestId
     * @param stageApproverID
     */
    public static void notifyStageApprover(EProcurementProcessInfo eProcurementProcessInfo, String nextStage)
    {
        try
        {
            LOGGER.info("RequestTrackerWorkflowProgressUtil.notifyStageApprover called==============nextStage is :- "
                    + nextStage);
            EprocurementRequest request = EprocurementRequestLocalServiceUtil
                    .getEprocurementRequest(eProcurementProcessInfo.getRequestId());
            request.setNextStage(nextStage);
            long stageApproverID = Long.valueOf(request.getNextStage());
            String body = StringPool.BLANK;
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;

            String toName = EProcurementUtil.getUserName(stageApproverID);
            String toEmailAddress = EProcurementUtil.getUserEmailAddress(stageApproverID);
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(request.getRequestId()));
            String viewRequestUrl = eProcurementProcessInfo.getViewRequestUrl();

            try
            {

                body = StringUtil.read(classLoader,
                        EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_BODY_TEMPLATE, true);
                body = StringUtil.replace(body, new String[] { REQUESTIDMAILVAR, VIEWREQUESTMAILVAR,
                        "[$REQUEST_TRACKER_URL]" }, new String[] { String.valueOf(request.getRequestId()),
                        viewRequestUrl, EProcurementRequestTrackerWSUtil.getRequestTrackerHref(request) });
            } catch (IOException e)
            {
                LOGGER.error("Failed to load email template.." + e.getMessage());
            }

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.debug("Mail sent to stage approver to notify about request ...");
            }
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("failed to notify stage approver.." + e.getMessage());
        } catch (AddressException e)
        {
            LOGGER.error("problem occured while sending an email to stage approver.." + e.getMessage());
        } catch (PortalException e)
        {
            LOGGER.error("problem occured while sending an email to stage approver.." + e.getMessage());
        } catch (SystemException e)
        {
            LOGGER.error("problem occured while sending an email to stage approver.." + e.getMessage());
        }
    }

    /**
     * 
     * @param renderRequest
     * @param renderResponse
     * @param requestId
     * 
     * Based on requestId get all the information such as current status, assigned WF routing, review/email comments etc.
     */
    public static void populateWebAdminScreenData(RenderRequest renderRequest, RenderResponse renderResponse,
            long requestId)
    {
        try
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);

            /* Get Selected WF Name if it is already applied to current request */
            WorkflowDefinition wfDefinition = EProcurementUtil.getAssignedWorkflow(themeDisplay.getCompanyId(),
                    themeDisplay.getScopeGroupId(), EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST, requestId,
                    Boolean.TRUE);

            /*
             * Set all the Request Status & Current Status as well in
             * renderRequest
             */
            if (EProcurementConstants.STATUS_NEW.equalsIgnoreCase(request.getStatus()))
            {
                EProcurementUtil.setAllowedStatusForNewRequest(renderRequest);
            } else
            {
                if (wfDefinition != null)
                {
                    EProcurementUtil.setAllowedStatusForWFAssignedRequest(renderRequest, wfDefinition);
                    renderRequest.setAttribute("stageIdStatusMap", EProcurementUtil
                            .getWFAssignedRequestMap(wfDefinition));
                } else
                {
                    EProcurementUtil.setAllStatus(renderRequest);
                }
            }

            renderRequest.setAttribute("curStatus", request.getStatus());

            /* Set All the WF Names to show in drop-down */
            renderRequest.setAttribute("wfIdNames", EProcurementUtil.getAllWorkflows(themeDisplay.getCompanyId(),
                    Boolean.TRUE));

            /*
             * Decide to show RHS WF Router or not based on "showWFRouting"
             * attribute
             */
            if (wfDefinition != null)
            {
                // renderRequest.setAttribute("curWFIdName", wfIdNameMap);
                renderRequest.setAttribute("showWFRouting", Boolean.TRUE);
                renderRequest.setAttribute("curWFId", wfDefinition.getWorkflowDefinitionId());
                renderRequest.setAttribute("curWFName", wfDefinition.getWorkflowName());
                renderRequest.setAttribute("wfRouter", EProcurementUtil.setStageRouterInfo(wfDefinition, request
                        .getNextStage(), request));
            } else
            {
                renderRequest.setAttribute("showWFRouting", Boolean.FALSE);
            }

            /* Show all WFReview comments, status & Time */
            renderRequest.setAttribute("listCustomWFReview", EProcurementUtil.showAllWFReview(renderRequest,
                    themeDisplay, requestId));
            renderRequest.setAttribute("editRequestURL", EProcurementUtil.createEditRequestURL(EProcurementUtil
                    .createSendRedirectURL(themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT,
                            EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS), requestId));
            renderRequest.setAttribute("requestId", requestId);
            renderRequest.setAttribute("statusNew", EProcurementConstants.STATUS_NEW);
            if (EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(request.getStatus()))
            {
                renderRequest.setAttribute("disableAdvanceWorkFlow", "true");
            }
        } catch (PortalException e)
        {
            LOGGER.error("Error while getting status & WF details for requestId : " + requestId, e);
        } catch (SystemException e)
        {
            LOGGER.error("Error while getting status & WF details for requestId : " + requestId, e);
        }
    }

    /**
     * Send email to requester when request approved by Intitial Approver
     * @param fromAddress
     * @param actionRequest
     * @param themeDisplay
     * @param eprocRequest
     * @throws Exception
     */
    public static void sendEmailByInitialApprover(EProcurementProcessInfo eprocurementProcessInfo, String fromAddress)
    {

        LOGGER.info("Inside sendEmailByInitialApprover()..");
        String toAddress = StringPool.BLANK;
        String toName = StringPool.BLANK;
        long requestId;
        ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
        String emailSubject = EProcurementConstants.EPROC_INTIAL_APPROVED_EMAIL_SUBJECT;
        String body = StringPool.BLANK;
        try
        {
            body = StringUtil.read(classLoader, EProcurementConstants.EPROC_INTIAL_APPROVED_EMAIL_BODY_TEMPLATE, true);
        } catch (IOException e)
        {
            LOGGER.error("Problem while reading template.." + e.getMessage());
        }

        try
        {
            if (eprocurementProcessInfo.getRequestId() > 0)
            {
                long userId = eprocurementProcessInfo.getRequestorId();
                requestId = eprocurementProcessInfo.getRequestId();
                User user = UserLocalServiceUtil.getUser(userId);
                toName = user.getFirstName() + StringPool.BLANK + user.getLastName();
                toAddress = user.getEmailAddress();
                emailSubject = emailSubject.concat(String.valueOf(requestId));

                String viewRequestUrl = eprocurementProcessInfo.getViewRequestUrl();

                body = StringUtil.replace(body, new String[] { REQUESTIDMAILVAR, VIEWREQUESTMAILVAR }, new String[] {
                        String.valueOf(requestId), viewRequestUrl });

            }

            InternetAddress from = new InternetAddress(fromAddress);
            InternetAddress to = new InternetAddress(toAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester as request is approved by initial approver...");
            }
        } 
        catch (PortalException e) {
        	LOGGER.error("Problem while sending email..." + e.getMessage());
		} catch (SystemException e) {
			LOGGER.error("Problem while sending email..." + e.getMessage());
		} catch (AddressException e) {
			LOGGER.error("Problem while sending email..." + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Problem while sending email..." + e.getMessage());
		}

    }

    /**
     * Send email to requester on completion of all stage approval
     * @param actionRequest
     * @param themeDisplay
     * @param eprocRequest
     */
    public static void sendFinalApprovalEmail(EProcurementProcessInfo eprocurementProcessInfo)
    {
        try
        {
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
            long requestorId = eprocurementProcessInfo.getRequestorId();
            long requestId = eprocurementProcessInfo.getRequestId();
            User user;
            user = UserLocalServiceUtil.getUser(requestorId);
            String toName = user.getFirstName() + StringPool.BLANK + user.getLastName();
            String toEmailAddress = user.getEmailAddress();
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_FINAL_APPROVED_EMAIL_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(eprocurementProcessInfo.getRequestId()));
            String body = StringUtil.read(classLoader, EProcurementConstants.EPROC_FIN_APPROVED_EMAIL_BODY_TEMPLATE,
                    true);

            String viewRequestUrl = eprocurementProcessInfo.getViewRequestUrl();

            body = StringUtil.replace(body, new String[] { REQUESTIDMAILVAR, VIEWREQUESTMAILVAR }, new String[] {
                    String.valueOf(requestId), viewRequestUrl });

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester for final approval of request ...");
            }

        } catch (Exception e)
        {
            LOGGER.error("Error occured while sending email ..." + e.getMessage());
        }

    }

    /**
     * If the request status is set to cancelled then notify requester about the same
     * @param actionRequest
     * @param themeDisplay
     * @param requestId
     * @param comments
     */
    public static void sendNotificationForCanceledRequest(EProcurementProcessInfo eprocurementProcessInfo)
    {

        try
        {
            String body = StringPool.BLANK;
            String fromName = StringPool.BLANK;
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
            // EprocurementRequest eprocRequest =
            // EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
            long requestorId = eprocurementProcessInfo.getRequestorId();

            String toName = EProcurementUtil.getUserName(requestorId);
            String toEmailAddress = EProcurementUtil.getUserEmailAddress(requestorId);
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_CANCELLED_REQUEST_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(eprocurementProcessInfo.getRequestId()));
            String viewRequestUrl = eprocurementProcessInfo.getViewRequestUrl();
            fromName = UserLocalServiceUtil.getUser(eprocurementProcessInfo.getApproverId()).getFullName();
            String comments = StringPool.BLANK;
            if (StringPool.BLANK.equals(eprocurementProcessInfo.getApproverComments()))
            {
                comments = EProcurementConstants.NOT_AVAILABLE;
            }

            try
            {
                body = StringUtil.read(classLoader, EProcurementConstants.EPROC_CANCELLED_REQUEST_BODY_TEMPLATE, true);
                body = StringUtil.replace(body, new String[] { REQUESTIDMAILVAR, "[$fromName]", "[$comments]",
                        VIEWREQUESTMAILVAR }, new String[] { String.valueOf(eprocurementProcessInfo.getRequestId()),
                        fromName, comments, viewRequestUrl });
            } catch (IOException e)
            {
                LOGGER.error("Failed to load email template.." + e.getMessage());
            }

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toEmailAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester to notify about cancelled/declined request ...");
            }
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Problem occured while sending email on cancel.." + e.getMessage());
        } catch (AddressException e)
        {
            LOGGER.error("email not send on cancel.." + e.getMessage());
        } catch (PortalException e)
        {
            LOGGER.error("Failed to find eprocurement request details .." + e.getMessage());
        } catch (SystemException e)
        {
            LOGGER.error("Failed to find eprocurement request details .." + e.getMessage());
        }

    }

    /**
     * 
     * @param request
     * @param newStatus
     * @param stage
     * @param isApproverRole
     * @param nextStage
     * @return EprocurementRequest
     * @throws SystemException
     * 
     * Update Request POJO with new Status & Next Approver
     */
    public static EprocurementRequest updateRequest(EprocurementRequest request, String newStatus, String stage,
            String isApproverRole, String nextStage) throws SystemException
    {
        /* Status will be the new status passed from JSP */
        request.setStatus(newStatus);

        /* Stage will be the updator/logged-in userId */
        request.setStage(stage);

        request.setIsApproverRole(isApproverRole);

        request.setNextStage(nextStage);
        return EprocurementRequestLocalServiceUtil.updateEprocurementRequest(request);
    }

    /**
     * 
     * @param themeDisplay
     * @param request
     * @param cmd
     * @param requestId
     * @param newStatus
     * @param approverComments
     * @param wfDefinitionId
     * @param hidRelativeStatus
     * @param resetStatus
     * @param actionRequest
     * @throws PortalException
     * @throws SystemException
     * 
     * This is the main method which decides next New-Status & Next-Approver as WF is progressed.
     * Entry point for two flows :
     * 1. When "Approve" or "Decline" button is clicked by "Level-1" OR "Stage" approver.
     * 2. When any action taken from "Web-Admin" screen.
     * 
     */
    public static void updateStatusStageComments(EProcurementProcessInfo eprocurementProcessInfo,
            EprocurementRequest request, String newStatus, String wfDefinitionId, boolean resetStatus)
            throws PortalException, SystemException
    {
        String oldRequestStatus = request.getStatus();
        String originalNewStatus = newStatus;
        String oldNextStage = request.getNextStage();
        long companyId = eprocurementProcessInfo.getCompanyId();
        long groupId = eprocurementProcessInfo.getGroupId();
        List<Long> listStageUserIds = null;

        Role webAdminRole = EProcurementUtil.getEprocWebAdminRole(companyId);

        /**
         *  Find whether WF is already assigned to this request or not 
         */
        WorkflowRequest currentWFRequest = null;
        WorkflowDefinition wfDefinition = null;
        try
        {
            currentWFRequest = EProcurementUtil.getWFProposalRequest(companyId, groupId,
                    EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST, eprocurementProcessInfo.getRequestId(),
                    Boolean.TRUE);
            if (currentWFRequest != null)
            {
                wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(currentWFRequest
                        .getWorkflowDefinitionId());
            }
        } catch (Exception e)
        {
            LOGGER.error("No workflow is associated with requestId : " + eprocurementProcessInfo.getRequestId());
        }

        /**
         * "newStatus" is not IMP as forward & backward status is decided based
         * on "currentStatus", also when control comes from "Approve" &
         * "Decline" button, "newStatus" will not be there.
         */
        if (Validator.isNotNull(eprocurementProcessInfo.getUserId()) && eprocurementProcessInfo.getUserId() > 0
                && Validator.isNotNull(webAdminRole))
        {
            String stage = String.valueOf(request.getStage());
            String nextStage = StringPool.BLANK;

            /**
             * if "reset" & "Decline" are not clicked, then nextStatus is
             * fetched from below method
             */
            if (EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(eprocurementProcessInfo.getCmd()))
            {
                newStatus = EProcurementConstants.STATUS_CANCELLED;
            } else
            {
                /**
                 * If following condition is true, then it means that user has
                 * not selected any new status, so new status is decided based
                 * on getForwardStatus & getResetStatus method
                 */
                if (request.getStatus().equalsIgnoreCase(newStatus))
                {
                    if (!resetStatus)
                    {
                        newStatus = getForwardStatus(request.getStatus(), request.getNextStage());
                    }
                } else
                {
                    if (EProcurementUtil.isNotNullNonEmptyString(originalNewStatus))
                    {
                        /**
                         * If this condition is true then it means that other
                         * than "Current Status", some next status is chosen
                         * from status drop-down, then this newStatus should be
                         * set in Request & WFReview
                         */
                        LOGGER.debug("originalNewStatus.." + originalNewStatus);
                    } else
                    {
                        newStatus = getForwardStatus(request.getStatus(), request.getNextStage());
                    }
                }
            }
            String isApproverRole = String.valueOf(Boolean.FALSE);

            /**
             * But if different WF Definition is chosen from JSP compared to the already assigned WF 
             * then need to handle this scenario here. 
             */
            if (currentWFRequest != null && wfDefinition != null
                    && EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                    && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId)
                    && EProcurementUtil.isNumber(wfDefinitionId))
            {
                long newWfDefinitionId = Long.valueOf(wfDefinitionId);

                /*
                 * If old & new WF definition is not same then assign new WF to
                 * Request & make Old WF-Request mapping as "ACTIVE=false"
                 */

                if (wfDefinition.getWorkflowDefinitionId() != newWfDefinitionId)
                {
                    LOGGER
                            .info("New WF is being assigned to the Request, so need to make Old WF-Request record as inactive");

                    inActivateWFRequest(currentWFRequest);

                    currentWFRequest = addUpdateWFRequest(companyId, groupId, eprocurementProcessInfo.getRequestId(),
                            wfDefinitionId, eprocurementProcessInfo.getUserId());

                    /*
                     * change the status to "WORKFLOW ASSIGNED" eventhough "NEW"
                     * OR "Level1 Approved" status is selected as NEW WF is
                     * being assigned now
                     */
                    newStatus = EProcurementConstants.STATUS_WORKFLOW_ASSIGNED;
                }
            }

            /**
             * If "currentWFRequest" == null (i.e. no WF is assigned to this
             * Request) && definitionId is passed from JSP then it means WF is
             * being added for the 1st time, so assign WFDefinition to Request &
             * add entry in WFRequest
             * 
             */
            // Introduced new flag to stop double emails on first time WF
            // assigned
            boolean emailNotification = true;
            if (currentWFRequest == null && EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                    && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId)
                    && Long.valueOf(wfDefinitionId) > 0)
            {
                currentWFRequest = addUpdateWFRequest(companyId, groupId, eprocurementProcessInfo.getRequestId(),
                        wfDefinitionId, eprocurementProcessInfo.getUserId());
                wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(currentWFRequest
                        .getWorkflowDefinitionId());
                /*
                 * Since WF is being assigned for the 1st time, then set
                 * "nextStage" as 1st stage from Stages XML
                 */
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    nextStage = String.valueOf(listStageUserIds.get(0));
                    if (Validator.isNotNull(nextStage))
                    {
                        notifyStageApprover(eprocurementProcessInfo, nextStage);
                        emailNotification = false;
                    }
                }
            }

            /**
             * Below condition will be true if the status is reset to "workflow assigned""
             */
            if (emailNotification && EProcurementConstants.STATUS_WORKFLOW_ASSIGNED.equalsIgnoreCase(newStatus)
                    && EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                    && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId)
                    && Long.valueOf(wfDefinitionId) > 0)
            {
                wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(currentWFRequest
                        .getWorkflowDefinitionId());
                /*
                 * Since WF is being assigned for the 1st time, then set
                 * "nextStage" as 1st stage from Stages XML
                 */
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    nextStage = String.valueOf(listStageUserIds.get(0));
                    if (Validator.isNotNull(nextStage))
                    {
                        notifyStageApprover(eprocurementProcessInfo, nextStage);
                    }

                }
            }

            /**
             * If following condition is true, then it means that WF is assigned
             * & request is at any stage between 2nd & END & not in 1st Stage
             **/
            if (!resetStatus && currentWFRequest != null
                    && !oldRequestStatus.equalsIgnoreCase(EProcurementConstants.STATUS_LEVEL1_APPROVED)
                    && EProcurementUtil.isNotNullNonEmptyString(request.getNextStage()) && wfDefinition != null)
            {
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    if (EProcurementUtil.isNumber(eprocurementProcessInfo.getHidRelativeStatus())
                            && EProcurementUtil.isNotNullNonEmptyString(eprocurementProcessInfo.getHidRelativeStatus())
                            && !request.getStatus().equalsIgnoreCase(originalNewStatus)
                            && !eprocurementProcessInfo.getHidRelativeStatus().equalsIgnoreCase(originalNewStatus))
                    {
                        /*
                         * If this condition is true, then it means that any
                         * stage related status is selected from drop-down like
                         * "Prog Manager - Approved - User1", then choose
                         * "nextStage" based on based on this hidden
                         * "selectedStatus" as this status will have
                         * stage/userId, ..in this case it would be userId of
                         * User-1 (Status Jump)
                         */
                        nextStage = EProcurementUtil.getNextStage(listStageUserIds, eprocurementProcessInfo
                                .getHidRelativeStatus());
                    } else
                    {
                        /* else default nextStage */
                        nextStage = EProcurementUtil.getNextStage(listStageUserIds, request.getNextStage());
                    }
                    /**
                     * Notify stage approver about request
                     */
                    if (Validator.isNotNull(nextStage))
                    {
                        notifyStageApprover(eprocurementProcessInfo, nextStage);
                    }

                }
            }

            /**
             * If "resetStatus" == true && "hidRelativeStatus" is number then
             * only set "nextStage" based on stageIds of assigned WF, else leave
             * nextStage as "", so that Web-Admin only can see that request.
             */
            if (resetStatus && EProcurementUtil.isNumber(eprocurementProcessInfo.getHidRelativeStatus())
                    && currentWFRequest != null && wfDefinition != null)
            {
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    nextStage = EProcurementUtil.getNextStage(listStageUserIds, eprocurementProcessInfo
                            .getHidRelativeStatus());
                    /**
                     * Notify stage approver about request
                     */
                    if (Validator.isNotNull(nextStage))
                    {
                        notifyStageApprover(eprocurementProcessInfo, nextStage);
                    }
                }
            }

            /*
             * If "Decline" button is clicked, then no need to add nextStage
             * userId, as the request will now be "CANCELLED"
             */
            if (EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(eprocurementProcessInfo.getCmd()))
            {
                nextStage = StringPool.BLANK;
            }

            // Move this to bottom

            /**
             * Below condition will be true if the request status is reset to NEW
             * IN this case we need to notify Initial Approver about the status change.
             */
            if (resetStatus && EProcurementConstants.STATUS_NEW.equalsIgnoreCase(originalNewStatus))
            {
                if (EProcurementConstants.YES.equalsIgnoreCase(request.getIsRelatedtoProject()))
                {
                    if (request.getProjectOwnerId() > 0)
                    {
                        nextStage = String.valueOf(request.getProjectOwnerId());
                        notifyInitialApprover(eprocurementProcessInfo, request.getProjectOwnerId());
                    }
                } else
                {
                    if (request.getSupervisorId() > 0)
                    {
                        nextStage = String.valueOf(request.getSupervisorId());
                        notifyInitialApprover(eprocurementProcessInfo, request.getSupervisorId());
                    }
                }
            }

            if (EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(originalNewStatus)
                    || EProcurementConstants.STATUS_INPROCESS.equalsIgnoreCase(originalNewStatus)
                    || EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(originalNewStatus))
            {
                /**
                 * If this condition is true it means web admin is trying to set status as completed and trying to skip stage approvers
                 * so in that case set next stage as web admin.
                 */
                nextStage = StringPool.BLANK;
            }

            /**
             * Update Eproc Request
             */
            request = updateRequest(request, newStatus, stage, isApproverRole, nextStage);

            /**
             * Add in WF Review
             */
            addWFReview(companyId, groupId, eprocurementProcessInfo.getRequestId(), newStatus, stage, isApproverRole,
                    nextStage, eprocurementProcessInfo.getApproverComments(), eprocurementProcessInfo.getUserId(),
                    currentWFRequest);

            /**
             * Send email
             */
            if (!EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(eprocurementProcessInfo.getCmd())
                    && oldRequestStatus != null && oldRequestStatus.equals(EProcurementConstants.STATUS_NEW))
            {
                /**
                 * If this condition is true means current status is new and the
                 * request is approved by initial approver
                 */

                String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
                try
                {
                    sendEmailByInitialApprover(eprocurementProcessInfo, fromEmailAddress);
                } catch (Exception e)
                {
                    LOGGER.error("Error while sending email to to requester..." + e.getMessage());
                }
            }

            if (!EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(eprocurementProcessInfo.getCmd())
                    && oldRequestStatus != null && !resetStatus
                    && !EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_INPROCESS.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_LEVEL1_APPROVED.equalsIgnoreCase(request.getStatus()))
            {

                /**
                 * If the Request is approved by last stage approver then notify requester about final approval
                 */

                if (isWorkflowOver(currentWFRequest, request, wfDefinition, eprocurementProcessInfo
                        .getHidRelativeStatus(), oldNextStage))
                {
                    sendFinalApprovalEmail(eprocurementProcessInfo);

                }

            }

            /**
             * Send email if the request is cancelled by web admin(from WF Screen) or Initial Approver/Stage Approver
             */
            if (EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(request.getStatus()))
            {
                sendNotificationForCanceledRequest(eprocurementProcessInfo);
            }

        }

    }
}
