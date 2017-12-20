package com.dsi.intranet.eprocurement.portlet.controller.dashboard;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.portlet.bean.DashboardBean;

import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.DashBoardComparatorUtil;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementCommonUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementEmailUtility;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowProgressUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * 
 * @author Jay Patel
 * 
 * This is the controller which shows Eprocurement requests based on logged-in user's role & permission.
 * 
 * Also this controller provides service to search Eprocurement requests based on various search criteria.
 * 
 */

@Controller("requestDashboardController")
@RequestMapping(value = "VIEW")
public class RequestDashboardController
{

    /**
     * 
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortalException
     * 
     * This method will display request in user's dashboard based on role and permission
     */
    @RenderMapping
    public String showRequests(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException
    {

        LOGGER.debug("\n\n RequestDashboardController.showRequests() based on Permission ### - Default View \n\n ");
        
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
                .getHttpServletRequest(renderRequest));
        String successMessage = httpRequest.getParameter("successMsg");
        
        try
        {

            String cancel = renderRequest.getParameter("cmd");
            String reqid = renderRequest.getParameter("resourcePrimKey");
            
            if (EProcurementUtil.isNotNullNonEmptyString(cancel) && cancel.equalsIgnoreCase("CANCEL")
                    && EProcurementUtil.isNotNullNonEmptyString(reqid))
            {
                /**
                 *  When request is cancelled by requester & Web admin from Dashboard
                 */
                long requestID = Long.parseLong(reqid);
                String approverComments = renderRequest.getParameter("approverComments");
                String stage = String.valueOf(themeDisplay.getUserId());
                String isApproverRole = String.valueOf(Boolean.FALSE);
                String cancelStatus = EProcurementConstants.STATUS_CANCELLED;
                setStatusAsCancel(requestID);
                
                /**
                 * Add in WF Review
                 */
               WorkflowProgressUtil.addWFReview(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), requestID, cancelStatus, stage, isApproverRole, StringPool.BLANK, approverComments,
                        themeDisplay.getUserId(), null);
               EprocurementEmailUtility.sendNotificationForCanceledRequest(renderRequest, themeDisplay, requestID, approverComments);
               successMessage = "Your request processed successfully";
            }

            EProcurementUtil.setAllStatus(renderRequest);
            renderRequest.setAttribute("shipToAddresses", EprocurementCommonUtil.getLocations());
            renderRequest.setAttribute("addRequestLink", EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS));
            renderRequest.setAttribute("successMessage", successMessage);
            
            /**
             * By-default return all the requests based on Logged-in user's
             * permission
             */
            PortletURL renderURL = renderResponse.createRenderURL();
            renderURL.setParameter("eProcAction", "searchRequests");
            SearchContainer dashBoardSearchContainer = new SearchContainer(renderRequest, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, EProcurementConstants.REQUEST_DASHBOARD_DEFAULT_DELTA,
                    renderURL, null, StringPool.BLANK);
            
            
            List<Object> eprocReqList = EProcurementUtil.getEprocurementRequests(themeDisplay,dashBoardSearchContainer, themeDisplay.getUserId());
            //renderRequest.setAttribute("requestList", eprocReqList);
            List<DashboardBean> dashBoardBeanList = getDashboardBeanList(eprocReqList, themeDisplay);
            renderRequest.setAttribute("dashBoardSearchContainer", dashBoardSearchContainer);
            renderRequest.setAttribute("requestList", dashBoardBeanList);

        } catch (SystemException e)
        {
            LOGGER.error("Error while showing the dafault view with all the requests : " + e.getMessage(), e);
        }

        return "dashboard/view";
    }

    
    /**
     * 
     * @param renderRequest
     * @param renderResponse
     * @return
     * 
     * Serach request based on user interest.
     */
    @RenderMapping(params = "eProcAction=searchRequests")
    public String searchRequests(RenderRequest renderRequest, RenderResponse renderResponse)
    {

        LOGGER.debug("\n\n RequestDashboardController.searchRequests()### - Search View \n\n");
        
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try
        {
            EProcurementUtil.setAllStatus(renderRequest);
            renderRequest.setAttribute("shipToAddresses", EprocurementCommonUtil.getLocations());
            renderRequest.setAttribute("addRequestLink", EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS));
            
            /**
             * Search based on parameters passed from Search Form
             */
            Map<String, String> paramMap = new HashMap<String, String>();
            PortletURL renderURL = renderResponse.createRenderURL();
            populateMapAndURL(renderRequest, paramMap, renderURL);

            SearchContainer dashBoardSearchContainer = new SearchContainer(renderRequest, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, EProcurementConstants.REQUEST_DASHBOARD_DEFAULT_DELTA,
                    renderURL, null, StringPool.BLANK);

            
            List<Object> eprocReqList = EProcurementUtil.getEprocRequests(themeDisplay,dashBoardSearchContainer, paramMap, themeDisplay.getUserId());
            //renderRequest.setAttribute("requestList", eprocReqList);
            List<DashboardBean> dashBoardBeanList = getDashboardBeanList(eprocReqList, themeDisplay);
            sortDashBoardList(renderRequest, dashBoardBeanList,dashBoardSearchContainer);
            dashBoardBeanList = ListUtil.subList(dashBoardBeanList, dashBoardSearchContainer.getStart(),
                    dashBoardSearchContainer.getEnd());
            renderRequest.setAttribute("dashBoardSearchContainer", dashBoardSearchContainer);
            renderRequest.setAttribute("requestList", dashBoardBeanList);

        } catch (SystemException e)
        {
            LOGGER.error("Error while RequestDashboardController.searchRequests() : " + e.getMessage(), e);
        } catch (PortalException e)
        {
            LOGGER.error("Error while RequestDashboardController.searchRequests() : " + e.getMessage(), e);
        }

        return "dashboard/view";
    }

    /**
     *  Set Request Status As Cancel
     * @param requestId
     * @throws PortalException
     */
    public void setStatusAsCancel(long requestId) throws PortalException
    {

        try
        {
            EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
           /**
            * Request will be in web admin's plate
            */
            eprocRequest.setNextStage(StringPool.BLANK);
            eprocRequest.setStatus(EProcurementConstants.STATUS_CANCELLED);
            EprocurementRequestLocalServiceUtil.updateEprocurementRequest(eprocRequest);
        } catch (SystemException e)
        {
            LOGGER.error("Error while RequestDashboardController.setStatusAsCancel() : " + e.getMessage(), e);
        }

    }

    /**
     * 
     * @param renderRequest
     * @param paramMap
     * @param renderURL
     * 
     * This method populates search criteria parameter Map which is passed to service in order to fetch the results 
     */
    public void populateMapAndURL(RenderRequest renderRequest, Map<String, String> paramMap, PortletURL renderURL)
    {
        String status = renderRequest.getParameter(EProcurementConstants.PARAM_STATUS);
        String address = renderRequest.getParameter(EProcurementConstants.PARAM_ADDRESS);
        String userId = renderRequest.getParameter(EProcurementConstants.PARAM_USERID);
        String startDate = renderRequest.getParameter(EProcurementConstants.PARAM_START_DATE);
        String endDate = renderRequest.getParameter(EProcurementConstants.PARAM_END_DATE);
        LOGGER.debug("Status : " + status + "\n Address : " + address + "\n UserId : " + userId + "\n StartDate : "
                + startDate + "\n EndDate : " + endDate);

        renderURL.setParameter("eProcAction", "searchRequests");

        /**
         * Set in parameters map to search in Database and also set in Request
         * to show again in JSP after search is done.
         */
        if (EProcurementUtil.isNotNullNonEmptyString(status))
        {
            status = StringUtil.trim(status);
            if (!status.equalsIgnoreCase(EProcurementConstants.PARAM_VALUE_SELECT))
            {
                paramMap.put(EProcurementConstants.PARAM_STATUS, status);
                renderRequest.setAttribute("curStatus", status);
                renderURL.setParameter(EProcurementConstants.PARAM_STATUS, status);
            }
        }

        if (EProcurementUtil.isNotNullNonEmptyString(address))
        {
            address = StringUtil.trim(address);
            if (!address.equalsIgnoreCase(EProcurementConstants.PARAM_VALUE_SELECT))
            {
                paramMap.put(EProcurementConstants.PARAM_ADDRESS, address);
                renderRequest.setAttribute("curAddress", address);
                renderURL.setParameter(EProcurementConstants.PARAM_ADDRESS, address);
            }
        }

        if (EProcurementUtil.isNotNullNonEmptyString(userId))
        {
            /* Here userId is Requestor */
            userId = StringUtil.trim(userId);
            try
            {
                User requestor = UserLocalServiceUtil.getUser(Long.valueOf(userId));
                paramMap.put(EProcurementConstants.PARAM_USERID, userId);
                renderRequest.setAttribute("curUserId", userId);
                renderRequest.setAttribute("curRequestor", requestor.getFullName());
                renderURL.setParameter(EProcurementConstants.PARAM_USERID, userId);
            } catch (NumberFormatException e)
            {
                LOGGER.error("Error while retrieving Requestor : " + e.getMessage(), e);
            } catch (PortalException e)
            {
                LOGGER.error("Error while retrieving Requestor : " + e.getMessage(), e);
            } catch (SystemException e)
            {
                LOGGER.error("Error while retrieving Requestor : " + e.getMessage(), e);
            }
        }

        if (EProcurementUtil.isNotNullNonEmptyString(startDate) && EProcurementUtil.isNotNullNonEmptyString(endDate))
        {
            startDate = StringUtil.trim(startDate);
            paramMap.put(EProcurementConstants.PARAM_START_DATE, startDate);
            renderRequest.setAttribute("curStartDate", startDate);
            renderURL.setParameter(EProcurementConstants.PARAM_START_DATE, startDate);

            endDate = StringUtil.trim(endDate);
            paramMap.put(EProcurementConstants.PARAM_END_DATE, endDate);
            renderRequest.setAttribute("curEndDate", endDate);
            renderURL.setParameter(EProcurementConstants.PARAM_END_DATE, endDate);
        }
    }
    
    private List<DashboardBean> getDashboardBeanList(List<Object> eprocRequestsList,ThemeDisplay themeDisplay)
    {
        List<DashboardBean> dashBoardBeanList = new ArrayList<DashboardBean>();
        DashboardBean dashBoardBean = null;
        for (Object obj : eprocRequestsList)
        {
            dashBoardBean = setDashBoardBean((EprocurementRequest) obj,themeDisplay);
            dashBoardBeanList.add(dashBoardBean);
        }
        return dashBoardBeanList;
    }

    private DashboardBean setDashBoardBean(EprocurementRequest eprocRequest,ThemeDisplay themeDisplay)
    {
        DashboardBean dashBoardBean = null;
        Format formatter;
        formatter = new SimpleDateFormat("MM/dd/yy");
        if (eprocRequest != null)
        {
            String userFullName = EProcurementUtil.getUserFullName(eprocRequest.getRequestorId());
            String createdDate = formatter.format(eprocRequest.getCreatedDate());
            String status = eprocRequest.getStatus();
            String nextApprover = EProcurementUtil.showNextApprover(eprocRequest.getRequestId());
            String workFlowName = EProcurementUtil.getWorkflowName(themeDisplay, EProcurementUtil
                    .getClassNameId(EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST),
                    eprocRequest.getRequestId(), Boolean.TRUE);
            dashBoardBean = new DashboardBean();
            dashBoardBean.setRequestId(eprocRequest.getRequestId());
            dashBoardBean.setUserFullName(userFullName);
            dashBoardBean.setStatus(status);
            dashBoardBean.setCreatedDate(createdDate);
            dashBoardBean.setNextApprover(nextApprover);
            dashBoardBean.setWorkFlowName(workFlowName);
        }
        return dashBoardBean;
    }
    
    /**
     * 
     * Method to sort request list
     * @param portletRequest
     * @param dashBoardList
     * @param dashboardSearchContainer
     */
    private static void sortDashBoardList(PortletRequest portletRequest, List<DashboardBean> dashBoardList,SearchContainer dashboardSearchContainer)
    {
        try
        {
            LOGGER.debug("sortDashBoardList()..");
            PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

            String orderByCol = ParamUtil.getString(portletRequest, EProcurementConstants.ORDER_BY_COLUMN);
            String orderByType = ParamUtil.getString(portletRequest, EProcurementConstants.ORDER_BY_TYPE);

            if (Validator.isNull(orderByCol) && Validator.isNull(orderByType))
            {
                portalPrefs.setValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE, EProcurementConstants.ORDER_BY_COLUMN,
                        "Status");
                portalPrefs.setValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE, EProcurementConstants.ORDER_BY_TYPE,
                        "asc");
            }

            if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType))
            {
                portalPrefs.setValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE, "request-order-by-col", orderByCol);
                portalPrefs.setValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE, "request-order-by-type",orderByType);
                
            }
            if (Validator.isNotNull(orderByType))
            {
                orderByCol = portalPrefs.getValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE,"request-order-by-col",
                        EProcurementConstants.ORDER_BY_COLUMN);
                orderByType = portalPrefs.getValue(EProcurementConstants.EPROCUREMENT_NAME_SPACE,"request-order-by-type",
                        EProcurementConstants.ORDER_BY_TYPE);
            }

            if (Validator.isNotNull(orderByCol))
            {
                OrderByComparator comparator = DashBoardComparatorUtil.getDashBoardComparator(orderByCol,orderByType);
                Collections.sort(dashBoardList, comparator);
                dashboardSearchContainer.setOrderByCol(orderByCol);
                dashboardSearchContainer.setOrderByType(orderByType);
                dashboardSearchContainer.setOrderByComparator(comparator);
            }
          
            

        } catch (SystemException e)
        {
            LOGGER.error("Error in retrieving portlet preference:" + e.getMessage(), e);
        }
    }

    private static final Log LOGGER = LogFactoryUtil.getLog(RequestDashboardController.class);
}