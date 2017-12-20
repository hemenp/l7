package com.dsi.intranet.eprocurement.portlet.controller.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowProgressUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author Jay Patel
 * @Description This is the main Controller which is called by Web-Admin,
 *              approver to approve/decline/comments at various stages of WF
 * 
 */

@Controller("requestWorkflowController")
@RequestMapping(value = "VIEW")
public class RequestWorkflowController
{

    private static final Log LOGGER = LogFactoryUtil.getLog(RequestWorkflowController.class);

    /**
     * 
     * Approve and Decline Request ...This method invoked when stage approver/initial supervisor  APPROVE/DECLINE request.
     * @param actionRequest
     * @param actionResponse
     */
    @ActionMapping(params = "eProcAction=approveDeclineRequest")
    public void approveDeclineRequest(ActionRequest actionRequest, ActionResponse actionResponse)
    {   
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        PurchaseRequestController.updateEprocRequest(actionRequest, actionResponse,uploadRequest, false);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long requestId = ParamUtil.getLong(actionRequest, EProcurementConstants.REQUEST_ID);
        String cmd = ParamUtil.getString(actionRequest, "cmd");

        String newStatus = StringPool.BLANK;
        boolean resetStatus = Boolean.FALSE;
        String hidRelativeStatus = ParamUtil.getString(uploadRequest, "hidRelativeStatus");
        String approverComments = ParamUtil.getString(uploadRequest, "approverComments");
        String wfDefinitionId = StringPool.BLANK;
        String successMessage = StringPool.BLANK;

        LOGGER.info("RequestWorkflowController.approveDeclineRequest() with requestId : " + requestId);

        if (requestId > 0)
        {
            try
            {
                EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                WorkflowProgressUtil.updateStatusStageComments(themeDisplay, request, cmd, requestId, newStatus,
                        approverComments, wfDefinitionId, hidRelativeStatus, resetStatus, actionRequest);
                successMessage = "Your request processed successfully";
            } catch (PortalException e)
            {
                LOGGER.error("Error while processing WF & setting status & stage in DB with Approve-Decline button : "
                        + e.getMessage(), e);
            } catch (SystemException e)
            {
                LOGGER.error("Error while processing WF & setting status & stage in DB with Approve-Decline button : "
                        + e.getMessage(), e);
            }
        }
        
       

        try
        {    
            String dashBoardURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
            
            Map<String, String> requestParam = new HashMap<String, String>();
            if(Validator.isNotNull(successMessage)){
                requestParam.put("successMsg", successMessage);
                dashBoardURL = EProcurementUtil.appendQueryParams(dashBoardURL, requestParam);
            }
            actionResponse.sendRedirect(dashBoardURL);
            
        } catch (IOException e)
        {
            LOGGER.error("Error while forwarding to Request Dashboard : " + e.getMessage(), e);
        }
    }

    /**
     * Process Workflow. This method will update workflow status/comments/WF Defination based.
     * 
     * @param renderRequest
     * @param renderResponse
     * 
     */
    public void processWorkflow(PortletRequest renderRequest, PortletResponse renderResponse,
            ThemeDisplay themeDisplay, long requestId, String command)
    {
        LOGGER.info("RequestWorkflowController.processWorkflow() with command : " + command + " & requestId : "
                + requestId);

        /* This is what is selected from drop-down */
        String newStatus = ParamUtil.getString(renderRequest, "requestStatus");

        /*
         * This is what is set as "hidden" based on selected-drop-down value, so
         * if "Approved - User 1" is selected then User1's userId/stage will be
         * set in this field so that nextStage can be set in Request & WF Review
         */
        String hidRelativeStatus = ParamUtil.getString(renderRequest, "hidRelativeStatus");

        /* This will be same as request.getStatus() */
        /*
         * String currentStatus = ParamUtil.getString(renderRequest,
         * "currentStatus");
         */

        boolean resetStatus = ParamUtil.getBoolean(renderRequest, "resetStatus");
        String approverComments = ParamUtil.getString(renderRequest, "approverComments");
        String wfDefinitionId = ParamUtil.getString(renderRequest, "workflowNames");
        String cmd = StringPool.BLANK;

        if ("updateWorkflow".equalsIgnoreCase(command))
        {
            try
            {
                EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                /*
                 * updateNewToVPApproved(request, requestId, themeDisplay,
                 * newStatus, approverComments, wfDefinitionId);
                 */
                WorkflowProgressUtil.updateStatusStageComments(themeDisplay, request, cmd, requestId, newStatus,
                        approverComments, wfDefinitionId, hidRelativeStatus, resetStatus, renderRequest);
            } catch (PortalException e)
            {
                LOGGER.error("Error while processing WF & setting status & stage in DB : " + e.getMessage(), e);
            } catch (SystemException e)
            {
                LOGGER.error("Error while processing WF & setting status & stage in DB : " + e.getMessage(), e);
            }
        }
    }

    
    /**
     * Show Worflow details for WEB ADMIN screen
     * @param actionRequest
     * @param actionResponse
     */
    @ActionMapping(params = "eProcAction=showRequestWFDetails")
    public void showRequestWFDetails(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long requestId = ParamUtil.getLong(actionRequest, EProcurementConstants.REQUEST_ID);
        LOGGER.info("\n RequestWorkflowController.showRequestWFDetails() for RequestId : " + requestId + "\n");

        /*
         * While refreshing the Web-Admin screen, "requestId" will be available
         * from HttpRequest only & NOT PortletRequest
         */
        if (requestId <= 0)
        {
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
                    .getHttpServletRequest(actionRequest));
            requestId = ParamUtil.getLong(httpRequest, EProcurementConstants.REQUEST_ID);
        }

        if (requestId > 0)
        {
            String command = ParamUtil.getString(actionRequest, "cmd");
            if (EProcurementUtil.isNotNullNonEmptyString(command))
            {
                processWorkflow(actionRequest, actionResponse, themeDisplay, requestId, command);
            }
        }

        /**
         * Redirecting to Web-Admin screen from here as "refreshing" the page
         * causes two times execution of last action.
         */
        try
        {
            String url = EProcurementUtil.createSendRedirectURL(themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT,
                    EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            Map<String, String> requestParamMap = new HashMap<String, String>();
            requestParamMap.put("cmd", "showRequestWFDetails");
            requestParamMap.put(EProcurementConstants.REQUEST_ID, String.valueOf(requestId));
            url = EProcurementUtil.appendQueryParams(url, requestParamMap);
            actionResponse.sendRedirect(url);
        } catch (IOException e)
        {
            LOGGER.error("Error while forwarding to RequestDetails-WebAdmin Screen : " + e.getMessage(), e);
        }
    }
}
