/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.controller.request;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowProgressUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowRequestLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author Jitendra Rajput
 * 
 * This controller is used to classify request as "in-stock/not-in-stock". 
 */

@Controller("classifyItemController")
@RequestMapping(value = "VIEW")
public class ClassifyItemController
{

    private static final Log LOGGER = LogFactoryUtil.getLog(ClassifyItemController.class);

  

    /**
     *  
     *  Set the request status as complete.
     * 
     * @param request
     * @param response
     */
    @ActionMapping(params = "eProcAction=completeNotInStockRequest")
    public void completeNotInStockRequest(ActionRequest request, ActionResponse response)
    {
        String strRequestId = request.getParameter(EProcurementConstants.REQUEST_ID);
        List<Item> eprocItemList = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long requestId = 0;
        if (Validator.isNotNull(strRequestId))
        {
        	requestId = Long.valueOf(strRequestId);
            eprocItemList = ItemLocalServiceUtil.getItemsByRequestId(requestId);
            updateRequestStatus(request, response, EProcurementConstants.STATUS_COMPLETED);
            String receiveDate = StringPool.BLANK;
            String returnDate = StringPool.BLANK;
            String assetInfo = StringPool.BLANK;
            String returnAssets = StringPool.BLANK;
            String vendorName = StringPool.BLANK;
            String purchaseOrder = StringPool.BLANK;
            String itemClassification = StringPool.BLANK;
            Date receiveDt;
            Date returnDt;
            Item item;

            if (eprocItemList != null && eprocItemList.size() > 0)
            {

                for (int i = 0; i < eprocItemList.size(); i++)
                {
                    receiveDate = request.getParameter("receivedDate" + i);
                    returnDate = request.getParameter("returnDate" + i);
                    assetInfo = request.getParameter("assetInfo" + i);
                    returnAssets = request.getParameter("returnedAssets" + i);
                    vendorName = request.getParameter("vendorCode" + i);
                    purchaseOrder = request.getParameter("purchaseOrder" + i);
                    itemClassification = request.getParameter("itemClassification" + i);

                    receiveDt = EProcurementUtil.convertStringToDate(receiveDate);
                    returnDt = EProcurementUtil.convertStringToDate(returnDate);

                    item = eprocItemList.get(i);
                    item.setRecievedDate(receiveDt);
                    item.setReturnedDate(returnDt);
                    item.setAssetInfo(assetInfo);
                    item.setReturnedAssets(returnAssets);
                    item.setVendorCode(vendorName);
                    item.setPurchaseOrder(purchaseOrder);

                    if (itemClassification != null
                            && EProcurementConstants.ITEM_IN_STOCK.equalsIgnoreCase(itemClassification))
                    {
                        item.setItemInStock(Boolean.TRUE);
                        
                    } else if (itemClassification != null
                            && EProcurementConstants.ITEM_NOT_IN_STOCK.equalsIgnoreCase(itemClassification))
                    {
                        item.setItemInStock(Boolean.FALSE);
                    }

                    /**
                     * Update Audit field
                     */
                    item.setModifiedDate(new Date());
                    item.setModifiedBy(themeDisplay.getUserId());
                    try
                    {
                        ItemLocalServiceUtil.updateItem(item);
                    } catch (SystemException e)
                    {
                        LOGGER.error("Failed to update Item ..." + e.getMessage());
                    }

                }
            }

        }
        String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
        try
        {
            response.sendRedirect(redirectURL);
        } catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Configure URL for the Create Request Link
     * @param actionRequest
     * @param actionResponse
     */
    @ActionMapping(params = "eProcAction=createRequest")
    public void createRequestURL(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
        try
        {
            actionResponse.sendRedirect(redirectURL);
        } catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }

    }

    /**
     * Configure URL for Previous Request Link
     * @param actionRequest
     * @param actionResponse
     */
    @ActionMapping(params = "eProcAction=previousRequest")
    public void previousRequestURL(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
        try
        {
            actionResponse.sendRedirect(redirectURL);
        } catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }

    }

    /**
     * Configure URL for View Request Details link
     * @param actionRequest
     * @param actionResponse
     */
    @ActionMapping(params = "eProcAction=requestDetails")
    public void requestDetailsURL(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String strRequestId = actionRequest.getParameter(EProcurementConstants.REQUEST_ID);
        long requestId = 0;
        if (Validator.isNotNull(strRequestId))
        {
            requestId = Long.valueOf(strRequestId);
        }
        String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
        String editRequestURL = EProcurementUtil.createEditRequestURL(redirectURL, requestId);
        try
        {
            actionResponse.sendRedirect(editRequestURL);
        } catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }

    }

    
    /**
     * Show FollowUp Instock/Not-In-Stock Page
     * @param renderRequest
     * @param renderResponse
     * @return
     */

    @RenderMapping(params = "eProcAction=showFollowUpNotInStockDetails")
    public String showFollowUpNotInStockDetails(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        String strRequestId = renderRequest.getParameter(EProcurementConstants.REQUEST_ID);
        if (Validator.isNotNull(strRequestId))
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            renderRequest.setAttribute("requestIdDashboard", strRequestId);
           
            try
            {   long requestId = Long.valueOf(strRequestId);
                EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                long userId = eprocRequest.getRequestorId();
                User user = UserLocalServiceUtil.getUser(userId);
                String requesterName = user.getFirstName() + StringPool.SPACE + user.getLastName();
                renderRequest.setAttribute("requesterName", requesterName);
                renderRequest.setAttribute("requestStatus", eprocRequest.getStatus());
                renderRequest.setAttribute("listCustomWFReview", EProcurementUtil.showAllWFReview(renderRequest,
                        themeDisplay, requestId));
				//BEGIN::Veera Reddy:: modified to fix the redirect issue in prod - LRPS-244,LRPS-245
                String sucessMessage=renderRequest.getParameter(EProcurementConstants.SUCCESS_MESSAGE)!=null ? (String)renderRequest.getParameter(EProcurementConstants.SUCCESS_MESSAGE):StringPool.BLANK ;
                String errorMessage=renderRequest.getParameter(EProcurementConstants.ERROR_MESSAGE)!=null ? (String)renderRequest.getParameter(EProcurementConstants.ERROR_MESSAGE):StringPool.BLANK;
                renderRequest.setAttribute(EProcurementConstants.SUCCESS_MESSAGE, sucessMessage);
                renderRequest.setAttribute(EProcurementConstants.ERROR_MESSAGE, errorMessage);
				//END::Veera Reddy:: modified to fix the redirect issue in prod - LRPS-244,LRPS-245
                
            } catch (PortalException e)
            {
                LOGGER.error("Error whilw retriveing requester details .." + e.getMessage());
            } catch (SystemException e)
            {
                LOGGER.error("Error while retriveing requester details .." + e.getMessage());
            }
            
        }
        return "purchase/followupNotInstock";
    }

    
    /**
     * 
     * Set Request Status AS INProcess
     * @param request
     * @param response
     */
    @ActionMapping(params = "eProcAction=submitNotInStockRequest")
    public void submitNotInStockRequest(ActionRequest request, ActionResponse response)
    {
        String strRequestId = request.getParameter(EProcurementConstants.REQUEST_ID);
        List<Item> eprocItemList = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long requestId = 0;
        if (Validator.isNotNull(strRequestId))
        {
        	requestId = Long.valueOf(strRequestId);
            eprocItemList = ItemLocalServiceUtil.getItemsByRequestId(requestId);
            updateRequestStatus(request, response, EProcurementConstants.STATUS_INPROCESS);
            String strReciviedDate = StringPool.BLANK;
            String strReturnDate = StringPool.BLANK;
            String strAssetInfo = StringPool.BLANK;
            String strReturnAssets = StringPool.BLANK;
            String strVendorName = StringPool.BLANK;
            String strPurchaseOrder = StringPool.BLANK;
            String strItemClassification = StringPool.BLANK;
            Date reciviedDate;
            Date returnDate;
            Item item;

            if (eprocItemList != null && eprocItemList.size() > 0)
            {

                for (int i = 0; i < eprocItemList.size(); i++)
                {
                    strReciviedDate = request.getParameter("receivedDate" + i);
                    strReturnDate = request.getParameter("returnDate" + i);
                    strAssetInfo = request.getParameter("assetInfo" + i);
                    strReturnAssets = request.getParameter("returnedAssets" + i);
                    strVendorName = request.getParameter("vendorCode" + i);
                    strPurchaseOrder = request.getParameter("purchaseOrder" + i);
                    strItemClassification = request.getParameter("itemClassification" + i);

                    reciviedDate = EProcurementUtil.convertStringToDate(strReciviedDate);
                    returnDate = EProcurementUtil.convertStringToDate(strReturnDate);

                   
                    
                    item = eprocItemList.get(i);
                    item.setRecievedDate(reciviedDate);
                    item.setReturnedDate(returnDate);
                    item.setAssetInfo(strAssetInfo);
                    item.setReturnedAssets(strReturnAssets);
                    item.setVendorCode(strVendorName);
                    item.setPurchaseOrder(strPurchaseOrder);

                    if (strItemClassification != null
                            && EProcurementConstants.ITEM_IN_STOCK.equalsIgnoreCase(strItemClassification))
                    {
                        item.setItemInStock(Boolean.TRUE);
                        
                    } else if (strItemClassification != null
                            && EProcurementConstants.ITEM_NOT_IN_STOCK.equalsIgnoreCase(strItemClassification))
                    {
                        item.setItemInStock(Boolean.FALSE);
                    }

                    /**
                     * Update Audit field
                     */
                    item.setModifiedDate(new Date());
                    item.setModifiedBy(themeDisplay.getUserId());
                     //BEGIN::Veera Reddy:: modified to fix the redirect issue in prod - LRPS-244,LRPS-245
                    try
                    {
                        ItemLocalServiceUtil.updateItem(item);
                        response.setRenderParameter(EProcurementConstants.SUCCESS_MESSAGE, EProcurementConstants.FOLLOW_UP_STOCK_SUCESS_MESSAGE);
                    } catch (SystemException e)
                    {
                    	response.setRenderParameter(EProcurementConstants.ERROR_MESSAGE, EProcurementConstants.FOLLOW_UP_STOCK_ERROR_MESSAGE);
                        LOGGER.error("Failed to update Item ..." + e.getMessage());
                    }

                }
            }

        }
        response.setRenderParameter(EProcurementConstants.REQUEST_ID, strRequestId);
        response.setRenderParameter("eProcAction", "showFollowUpNotInStockDetails");
         //END::Veera Reddy:: modified to fix the redirect issue in prod - LRPS-244,LRPS-245
    }

    /**
     * Generic method to update status
     * @param renderRequest
     * @param renderResponse
     */
    public void updateRequestStatus(ActionRequest request, ActionResponse response, String newStatus)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        long groupId = themeDisplay.getScopeGroupId();
        String followUpComments = request.getParameter("followUpComments");
        String strRequestId = request.getParameter(EProcurementConstants.REQUEST_ID);
        long requestId = 0;
        if (Validator.isNotNull(strRequestId))
        {
            requestId = Long.valueOf(strRequestId);
        }

        try
        {

            /**
             * Update EprocurementRequest
             */
            String nextStage = StringPool.BLANK;
            EprocurementRequest ePrpcurementReq = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
            ePrpcurementReq.setStatus(newStatus);
            ePrpcurementReq.setNextStage(nextStage);
            ePrpcurementReq.setModifiedBy(themeDisplay.getUserId());
            ePrpcurementReq.setModifiedDate(new Date());
            EprocurementRequestLocalServiceUtil.updateEprocurementRequest(ePrpcurementReq);

            /**
             * Get WorkFlowRequest
             */

            long classNameId = EProcurementUtil.getEprocRequestClassNameId();
            WorkflowRequest currentWorkFlowReq = null;
            try
            {
                currentWorkFlowReq = WorkflowRequestLocalServiceUtil.getWorkflowRequestByClassPK(companyId,
                        groupId, classNameId, requestId, true);
            } catch (NoSuchWorkflowRequestException e)
            {
                LOGGER.error("Failed to retrive e-procurement workflow request details  " + e.getMessage());
            }

            /**
             * Add workflow comments
             * 
             */

            String isApproverRole = String.valueOf(Boolean.FALSE);
            String stage = String.valueOf(themeDisplay.getUserId());
          

            WorkflowProgressUtil.addWFReview(companyId, groupId, requestId, newStatus, stage, isApproverRole,
                    nextStage, followUpComments, themeDisplay.getUserId(), currentWorkFlowReq);

        } catch (SystemException e)
        {
            LOGGER.error("Failed to retrive e-procurement details " + e.getMessage());
        } catch (PortalException e)
        {
           LOGGER.error("Failed to store eprocurement details .." + e.getMessage());
        }
    }

}
