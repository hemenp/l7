package com.dsi.intranet.eprocurement.portlet.util;

import java.util.ArrayList;
import java.util.List;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;

import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author Jay Patel
 *
 * This class is used to show various buttons, links etc. based on userid, roles etc. parameters.   
 * 
 */
public final class EProcurementPermissionUtil
{
	 private static final Log LOGGER = LogFactoryUtil.getLog(EProcurementPermissionUtil.class);
	    public static final String ATTRIBUTE_PROJECT_OWNER = "ATTRIBUTE_PROJECT_OWNER";
	    public static final String ATTRIBUTE_REQUESTOR = "ATTRIBUTE_REQUESTOR";
	    public static final String ATTRIBUTE_STAGE_APPROVER = "ATTRIBUTE_STAGE_APPROVER";
	    public static final String ATTRIBUTE_SUPERVISOR = "ATTRIBUTE_SUPERVISOR";
	    public static final String ATTRIBUTE_USER = "ATTRIBUTE_USER";

	    public static final String ATTRIBUTE_WEB_ADMIN = "ATTRIBUTE_WEB_ADMIN";

	    public static final List<String> DO_NOT_SHOW_ROUTING_STATUSES = new ArrayList<String>();

	    static
	    {
	        DO_NOT_SHOW_ROUTING_STATUSES.add(EProcurementConstants.STATUS_NEW);
	        DO_NOT_SHOW_ROUTING_STATUSES.add(EProcurementConstants.STATUS_LEVEL1_APPROVED);
	        DO_NOT_SHOW_ROUTING_STATUSES.add(EProcurementConstants.STATUS_INPROCESS);
	    }
	    
	    private EProcurementPermissionUtil()
	    {
	    }

	    /**
	     * 
	     * @param companyId
	     * @param userId
	     * @param requestId
	     * @return List<String>
	     * 
	     * This method is used to return all the attributes assigned to any user for particular Eprocurement Request
	     *   
	     */
	    public static List<String> getUserAttributes(long companyId, long userId, long requestId)
	    {
	        List<String> userAttributes = new ArrayList<String>();

	        try
	        {
	            if (EProcurementUtil.isWebAdmin(companyId, userId))
	            {
	                userAttributes.add(ATTRIBUTE_WEB_ADMIN);
	            }

	            EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);

	            if (userId == request.getSupervisorId())
	            {
	                userAttributes.add(ATTRIBUTE_SUPERVISOR);
	            }
	            if (userId == request.getProjectOwnerId())
	            {
	                userAttributes.add(ATTRIBUTE_PROJECT_OWNER);
	            }
	            if (EProcurementUtil.isNotNullNonEmptyString(request.getNextStage())
	                    && (userId == (Long.valueOf(request.getNextStage()).longValue())))
	            {
	                userAttributes.add(ATTRIBUTE_STAGE_APPROVER);
	            }
	            if (userId == request.getRequestorId())
	            {
	                userAttributes.add(ATTRIBUTE_REQUESTOR);
	            }

	        } catch (PortalException e)
	        {
	            LOGGER.error("Error while setting User Attributes for userId : " + userId + " & requestId : " + requestId, e);
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while setting User Attributes for userId : " + userId + " & requestId : " + requestId, e);
	        }

	        return userAttributes;
	    }

	    /**
	     * 
	     * @param companyId
	     * @param requestId
	     * @param userId
	     * @return {@link Boolean}
	     * 
	     * Following method will be called to show "Approve" & "Decline" button from "Edit Request" screen,
	     * These buttons will be shown to "Web-Admin" & user who is current stage approver for this request 
	     */
	    public static boolean showApproveDeclineButton(long companyId, long groupId, long requestId, long userId)
	    {
	        boolean showApproveDeclineButton = Boolean.FALSE;

	        // if (WF is assigned) OR (Pending for "VP APPROVED") then only show
	        // "Approve" & "Decline" button
	        // OR simply when "nextStage" matches logged-in userId then show
	        // "Approve" & "Decline" button

	        // showApproveDeclineButton = EProcurementUtil.isWebAdmin(companyId,
	        // userId);
	        if (!showApproveDeclineButton)
	        {
	            try
	            {
	                EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
	                if (request != null)
	                {
	                    String nextStage = request.getNextStage();
	                    if (EProcurementUtil.isNotNullNonEmptyString(nextStage))
	                    {
	                        long nextStageUserId = Long.valueOf(nextStage);
	                        if (userId == nextStageUserId)
	                        {
	                            showApproveDeclineButton = Boolean.TRUE;
	                        }
	                    }
	                }
	            } catch (Exception e)
	            {
	                LOGGER.error("EProcurementUtil.showApproveDeclineButton() : " + e.getMessage());
	            }
	        }
	        return showApproveDeclineButton;
	    }

	    /**
	     * 
	     * @param companyId
	     * @param userId
	     * @param request
	     * @return {@link Boolean}
	     * 
	     * Used to show "Action->Cancel" link in Request Dashboard
	     */
	    public static boolean showCancelRequestLink(long companyId, long userId, EprocurementRequest request)
	    {
	        boolean showEditLink = Boolean.FALSE;

	        /* Get User attributes for current User & Request */
	        List<String> userAttributes = getUserAttributes(companyId, userId, request.getRequestId());

	        /*
	         * if "requestor" then if only request status is "NEW", then only show
	         * "CANCEL" link
	         */
	        if (userAttributes.contains(ATTRIBUTE_REQUESTOR) || userAttributes.contains(ATTRIBUTE_WEB_ADMIN))
	        {
	            if (EProcurementConstants.STATUS_NEW.equalsIgnoreCase(request.getStatus()))
	            {
	                showEditLink = Boolean.TRUE;
	            }
	        }
	        return showEditLink;
	    }

	    /**
	         * 
	         * @param companyId
	         * @param userId
	         * @param request
	         * @return {@link Boolean}
	         * 
	         * Used to show "SubmitRequestChange button" link in edit request screen
	         */
	    public static boolean showRequestChangeButton(long companyId, long groupId,long userId, EprocurementRequest request)
	    {
	        boolean showRequestChangeButton = Boolean.FALSE;
	          

	        /* Get User attributes for current User & Request */
	        List<String> userAttributes = getUserAttributes(companyId,userId, request.getRequestId());
	        /*
	         * for web admin if status is not completed then only he can edit a
	         * request
	         */
	        if (userAttributes.contains(ATTRIBUTE_WEB_ADMIN))
	        {
	            
	                showRequestChangeButton = Boolean.TRUE;
	            
	        } else if (userAttributes.contains(ATTRIBUTE_REQUESTOR))
	        { /*
	           * if "requestor" then if only request status is "NEW", then only
	           * requestor can edit
	           */

	            if (EProcurementConstants.STATUS_NEW.equalsIgnoreCase(request.getStatus()))
	            {
	                showRequestChangeButton = Boolean.TRUE;
	            }
	        } else
	        { 
	            // changes done for approver .ie if approver has to approve the request then only we showRequestChange button will get displayed.
	            if(showApproveDeclineButton(companyId,groupId, request.getRequestId(),userId)){
	            /* shown to intial approvers and to all stage approvers */
	                showRequestChangeButton = Boolean.TRUE;
	            }
	        }

	        return showRequestChangeButton;
	    }
}
