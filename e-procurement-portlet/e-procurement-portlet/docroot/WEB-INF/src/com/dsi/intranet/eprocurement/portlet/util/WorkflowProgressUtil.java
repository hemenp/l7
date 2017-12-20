package com.dsi.intranet.eprocurement.portlet.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
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
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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
 * 
 * @author Jay Patel
 * 
 * @Discription: This class is used to update/add various attributes such as
 *               status, stage, comments, date etc. in entities Request, WF
 *               Request & WF Review at various stages of WF.
 * 
 */
public final class WorkflowProgressUtil
{
	private static final Log _log = LogFactoryUtil.getLog(WorkflowProgressUtil.class);

    private static final List<String> LIST_POSSIBLE_STATUS = new ArrayList<String>();

    static
    {
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_NEW);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_LEVEL1_APPROVED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_CANCELLED);
        LIST_POSSIBLE_STATUS.add(EProcurementConstants.STATUS_COMPLETED);
    }
    
    private WorkflowProgressUtil()
    {
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
            String isApproverRole, String nextStage, String approverComments, String emailComments,long updatorUserId,
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
        if(Validator.isNotNull(emailComments)){
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

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_NEW)){
            nextForwardStatus = EProcurementConstants.STATUS_LEVEL1_APPROVED;}

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_LEVEL1_APPROVED)){
            nextForwardStatus = EProcurementConstants.STATUS_WORKFLOW_ASSIGNED;}

        if (currentStatus.equalsIgnoreCase(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED)){
            nextForwardStatus = EProcurementConstants.STATUS_APPROVED;}

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
                    _log.error("Error while getting user in getForwardStatus() : " + e.getMessage());
                } catch (SystemException e)
                {
                    _log.error("Error while getting user in getForwardStatus() : " + e.getMessage());
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

                    _log.debug("nextStageId..." + nextStageId + "lastStageId.." + lastStageId + "request.getStage() "
                            + request.getStage());
                    if (nextStageId == lastStageId)
                    {
                        isWFOver = Boolean.TRUE;
                        _log.debug("Found the next approver....");
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
                            _log.debug("workflow is jumped to final approver");
                        }
                    }
                }
            }

        } catch (Exception e)
        {
            _log.error("Error in WorkflowProgressUtil.isWorkflowOver() : " + e.getMessage());
        }
        return isWFOver;
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
                        .getNextStage(),request));
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
            if(EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(request.getStatus()))
            {
                renderRequest.setAttribute("disableAdvanceWorkFlow","true");
            }
        } catch (PortalException e)
        {
            _log.error("Error while getting status & WF details for requestId : " + requestId, e);
        } catch (SystemException e)
        {
            _log.error("Error while getting status & WF details for requestId : " + requestId, e);
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
            String isApproverRole, String nextStage,ThemeDisplay themeDisplay) throws SystemException
    {
        /* Status will be the new status passed from JSP */
        request.setStatus(newStatus);

        /* Stage will be the updator/logged-in userId */
        request.setStage(stage);

        request.setIsApproverRole(isApproverRole);

        request.setNextStage(nextStage);  
		EProcurementRequestTrackerWSUtil.addEntryInRequestTracker(request, themeDisplay);
        return EprocurementRequestLocalServiceUtil.updateEprocurementRequest(request);
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
    public static void updateStatusStageComments(ThemeDisplay themeDisplay, EprocurementRequest request, String cmd,
            long requestId, String newStatus, String approverComments, String wfDefinitionId, String hidRelativeStatus,
            boolean resetStatus, PortletRequest actionRequest) throws PortalException, SystemException
    {
        String oldRequestStatus = request.getStatus();
        String originalNewStatus = newStatus;
        String oldNextStage = request.getNextStage();
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
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
                    EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST, requestId, Boolean.TRUE);
            if (currentWFRequest != null)
            {
                wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(currentWFRequest
                        .getWorkflowDefinitionId());
            }
        } catch (Exception e)
        {
            _log.error("No workflow is associated with requestId : " + requestId);
        }

        /**
         * "newStatus" is not IMP as forward & backward status is decided based
         * on "currentStatus", also when control comes from "Approve" &
         * "Decline" button, "newStatus" will not be there.
         */
        if (Validator.isNotNull(themeDisplay.getUserId()) && themeDisplay.getUserId() > 0
                && Validator.isNotNull(webAdminRole))
        {
            String stage = String.valueOf(themeDisplay.getUserId());
            String nextStage = StringPool.BLANK;

            /**
             * if "reset" & "Decline" are not clicked, then nextStatus is
             * fetched from below method
             */
            if (EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(cmd))
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
                } 
                else
                {
                    if (EProcurementUtil.isNotNullNonEmptyString(originalNewStatus))
                    {
                        /**
                         * If this condition is true then it means that other
                         * than "Current Status", some next status is chosen
                         * from status drop-down, then this newStatus should be
                         * set in Request & WFReview
                         */
                        _log.debug("originalNewStatus.." +originalNewStatus);
                    } 
                    else
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
            if(currentWFRequest != null && wfDefinition != null 
            		&& (EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                    && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId))
                    && EProcurementUtil.isNumber(wfDefinitionId) )
            {
            	long newWfDefinitionId = Long.valueOf(wfDefinitionId);
            	
            	/*If old & new WF definition is not same then assign new WF to Request & make Old WF-Request mapping as "ACTIVE=false"*/
            	
            	if(wfDefinition.getWorkflowDefinitionId() != newWfDefinitionId)
            	{
            		_log.info("New WF is being assigned to the Request, so need to make Old WF-Request record as inactive");
            		
            		inActivateWFRequest(currentWFRequest);
            		
            		currentWFRequest = addUpdateWFRequest(companyId, groupId, requestId, wfDefinitionId, themeDisplay.getUserId());
            		
            		/*change the status to "WORKFLOW ASSIGNED" eventhough "NEW" OR "Level1 Approved" status is selected as NEW WF is being assigned now*/
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
          // Introduced new flag to stop double emails on first time WF assigned
            boolean emailNotification = true;
            if (currentWFRequest == null
                    && (EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                            && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId) && Long
                            .valueOf(wfDefinitionId) > 0))
            {
                currentWFRequest = addUpdateWFRequest(companyId, groupId, requestId, wfDefinitionId, themeDisplay
                        .getUserId());
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
                    if(Validator.isNotNull(nextStage))
                    {
                        long stageApproverId = Long.valueOf(nextStage);
                        EprocurementEmailUtility.notifyStageApprover(actionRequest, themeDisplay, requestId, stageApproverId,false);
                        emailNotification = false;
                    }
                }
            }
            
            /**
             * Below condition will be true if the status is reset to "workflow assigned""
             */
            if (emailNotification && EProcurementConstants.STATUS_WORKFLOW_ASSIGNED.equalsIgnoreCase(newStatus)
                    && (EProcurementUtil.isNotNullNonEmptyString(wfDefinitionId)
                            && !EProcurementConstants.PARAM_VALUE_SELECT.equalsIgnoreCase(wfDefinitionId) && Long
                            .valueOf(wfDefinitionId) > 0))
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
                    if(Validator.isNotNull(nextStage))
                    {
                        long stageApproverId = Long.valueOf(nextStage);
                        EprocurementEmailUtility.notifyStageApprover(actionRequest, themeDisplay, requestId, stageApproverId,false);
                    }
                    
                }
            }

            /**
             * If following condition is true, then it means that WF is assigned
             * & request is at any stage between 2nd & END & not in 1st Stage
             **/
            if (!resetStatus && currentWFRequest != null && !oldRequestStatus.equalsIgnoreCase(EProcurementConstants.STATUS_LEVEL1_APPROVED)
                    && EProcurementUtil.isNotNullNonEmptyString(request.getNextStage()) && wfDefinition != null)
            {
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    if (EProcurementUtil.isNumber(hidRelativeStatus)
                            && EProcurementUtil.isNotNullNonEmptyString(hidRelativeStatus)
                            && !request.getStatus().equalsIgnoreCase(originalNewStatus)
                            && !hidRelativeStatus.equalsIgnoreCase(originalNewStatus))
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
                        nextStage = EProcurementUtil.getNextStage(listStageUserIds, hidRelativeStatus);
                    } else
                    {
                        /* else default nextStage */
                        nextStage = EProcurementUtil.getNextStage(listStageUserIds, request.getNextStage());
                    }
                    /**
                     * Notify stage approver about request
                     */
                    if(Validator.isNotNull(nextStage))
                    {
                        long stageApproverId = Long.valueOf(nextStage);
                        EprocurementEmailUtility.notifyStageApprover(actionRequest, themeDisplay, requestId, stageApproverId,false);
                    }
                    
                }
            }

            /**
             * If "resetStatus" == true && "hidRelativeStatus" is number then
             * only set "nextStage" based on stageIds of assigned WF, else leave
             * nextStage as "", so that Web-Admin only can see that request.
             */
            if (resetStatus && EProcurementUtil.isNumber(hidRelativeStatus) && currentWFRequest != null
                    && wfDefinition != null)
            {
                listStageUserIds = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
                if (listStageUserIds != null && !listStageUserIds.isEmpty())
                {
                    nextStage = EProcurementUtil.getNextStage(listStageUserIds, hidRelativeStatus);
                    /**
                     * Notify stage approver about request
                     */
                    if(Validator.isNotNull(nextStage))
                    {
                        long stageApproverId = Long.valueOf(nextStage);
                        EprocurementEmailUtility.notifyStageApprover(actionRequest, themeDisplay, requestId, stageApproverId,false);
                    }
                }
            }

            /*
             * If "Decline" button is clicked, then no need to add nextStage
             * userId, as the request will now be "CANCELLED"
             */
            if (EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(cmd))
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
                        notifyInitialApprover(request.getProjectOwnerId(),requestId,themeDisplay,request.getRequestorId(),false);
                    }
                } else
                {
                    if (request.getSupervisorId() > 0)
                    {
                        nextStage = String.valueOf(request.getSupervisorId());
                        notifyInitialApprover(request.getSupervisorId(),requestId,themeDisplay,request.getRequestorId(),false);
                    }
                }
            }
            
            if(EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(originalNewStatus) || EProcurementConstants.STATUS_INPROCESS.equalsIgnoreCase(originalNewStatus) || EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(originalNewStatus))
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
            request = updateRequest(request, newStatus, stage, isApproverRole, nextStage,themeDisplay);

            /**
             * Add in WF Review
             */
            addWFReview(companyId, groupId, requestId, newStatus, stage, isApproverRole, nextStage, approverComments,
                    themeDisplay.getUserId(), currentWFRequest);

            /**
             * Send email
             */
            if (!EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(cmd) && oldRequestStatus != null
                    && oldRequestStatus.equals(EProcurementConstants.STATUS_NEW))
            {
                /**
                 * If this condition is true means current status is new and the
                 * request is approved by initial approver
                 */

                String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
                try
                {
                    EprocurementEmailUtility.sendEmailByInitialApprover(fromEmailAddress, actionRequest,
                            themeDisplay, request);
                } catch (Exception e)
                {
                    _log.error("Error while sending email to to requester..." + e.getMessage());
                }
            }

            if (!EProcurementConstants.ACTION_DECLINE.equalsIgnoreCase(cmd) && oldRequestStatus != null && !resetStatus
                    && !EProcurementConstants.STATUS_COMPLETED.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_INPROCESS.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(originalNewStatus)
                    && !EProcurementConstants.STATUS_LEVEL1_APPROVED.equalsIgnoreCase(request.getStatus()))
            {

                /**
                 * If the Request is approved by last stage approver then notify requester about final approval
                 */
              
                
                if (isWorkflowOver(currentWFRequest, request, wfDefinition, hidRelativeStatus, oldNextStage))
                {
                    EprocurementEmailUtility.sendFinalApprovalEmail(actionRequest, themeDisplay, request);

                }

            }
            
            /**
             * Send email if the request is cancelled by web admin(from WF Screen) or Initial Approver/Stage Approver
             */
            if(EProcurementConstants.STATUS_CANCELLED.equalsIgnoreCase(request.getStatus()))
            {
                EprocurementEmailUtility.sendNotificationForCanceledRequest(actionRequest, themeDisplay, request.getRequestId(), approverComments);
            }

        }

    }

    /**
     * Notify Requester if request is reset to new
     * @param projectOwnerId
     */
    public static void notifyInitialApprover(long nextApproverUserId,long requestId,ThemeDisplay themeDisplay,long requestorId ,boolean isReminder)
    {
        _log.info("notifyInitialApprover()..");
       
        String subject = StringPool.BLANK;
        String body = StringPool.BLANK;
        String viewRequestUrl = StringPool.BLANK;
        String nextApproverName = StringPool.BLANK;
        String fromAdmin = EProcurementConstants.EPROC_EMAIL_FROM_NAME;
        String fromAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
        String nextApproverEmailAddress = StringPool.BLANK;
        ClassLoader classLoader = WorkflowProgressUtil.class.getClassLoader();
        String fromName = StringPool.BLANK;
        fromName = EProcurementUtil.getUserName(requestorId);
        nextApproverName = EProcurementUtil.getUserName(nextApproverUserId);
        nextApproverEmailAddress = EProcurementUtil.getUserEmailAddress(nextApproverUserId);
        _log.info("Email sent to .." + nextApproverEmailAddress);
        
        /*
         * Modified to append REMINDER Text in the email subject.
         */
        if (isReminder)
        {
            subject = EProcurementConstants.REMINDER_MSG;
            subject = subject.concat(StringPool.SPACE);
            subject = subject.concat(EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT);
        } else
        {

            subject = EProcurementConstants.EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT;
        }
        subject = subject.concat(String.valueOf(requestId));
        /**
         * DSI : Modified to fix request Tracker URL issue while sending reminder emails
         */
        EprocurementRequest eprocuRequest = getEprocurementRequest(requestId);
        _log.info("Request Tracker URL--" + EProcurementRequestTrackerWSUtil.getRequestTrackerHref(eprocuRequest));
        try
        {
           
            body = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_BODY_TEMPLATE, true);
            String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, requestId);
            body = StringUtil.replace(body, new String[] { "[$requestorName]", "[$viewRequest]", "[$REQUEST_TRACKER_URL]"  }, new String[] {
                    fromName, viewRequestUrl,EProcurementRequestTrackerWSUtil.getRequestTrackerHref(eprocuRequest)  });
            
           EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, nextApproverName, nextApproverEmailAddress,
                    subject, body);
        } catch (IOException e)
        {
            _log.error("Failed to read email template..." + e.getMessage());
        } catch (Exception e)
        {
            _log.error("Problem while sending email to initial approver.." + e.getMessage());
        }
    }
    
    public static EprocurementRequest getEprocurementRequest(long requestId)
    {

        EprocurementRequest eproRequest = null;
        try
        {
            eproRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
        } catch (PortalException e)
        {
            _log.error(e.getMessage());
        } catch (SystemException e)
        {
            _log.error(e.getMessage());
        }
        return eproRequest;
    }
}
