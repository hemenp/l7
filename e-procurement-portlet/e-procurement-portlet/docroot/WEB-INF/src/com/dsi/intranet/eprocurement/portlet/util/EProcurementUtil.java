package com.dsi.intranet.eprocurement.portlet.util;

import com.dsi.intranet.eprocurement.model.EprocurementLocation;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.model.WorkflowDefinition;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.WorkflowReview;
import com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.model.CustomStageRouter;
import com.dsi.intranet.eprocurement.portlet.model.CustomWFReview;
import com.dsi.intranet.eprocurement.portlet.model.CustomWFRouter;
import com.dsi.intranet.eprocurement.service.EprocurementLocationLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowReviewLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.WindowStateException;

/**
 * @author Jay Patel
 * 
 * Common Utility class for whole E-Procurement Module'
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 * Veera Reddy	Jun 12 2012 Modified to get location based on AppName          
 */

public final class EProcurementUtil
{

	 private static final Log LOGGER = LogFactoryUtil.getLog(EProcurementUtil.class);

	    /**
	     * 
	     * @param url
	     * @param requestParam
	     * @return String This will append Query parameters to URL
	     */
	    
	    private EProcurementUtil()
	    {
	    }
	    
	    public static String appendQueryParams(String url, Map<String, String> requestParam)
	    {
	        String paramURL = url;
	        if ((requestParam != null) && !requestParam.isEmpty())
	        {
	            if (!url.contains(StringPool.QUESTION))
	            {
	                paramURL += StringPool.QUESTION;
	            }
	            Set<String> keySet = requestParam.keySet();
	            if ((keySet != null) && !keySet.isEmpty())
	            {
	                for (String key : keySet)
	                {
	                    paramURL = paramURL.concat(StringPool.AMPERSAND);
	                    paramURL = paramURL.concat(key);
	                    paramURL = paramURL.concat(StringPool.EQUAL);
	                    paramURL = paramURL.concat(requestParam.get(key));
	                }
	            }
	        }
	        return paramURL;
	    }

	    /**
	     * 
	     * @param user
	     * @return {@link String} Used to show StageApprovalStatus in WF screen
	     *         drop-down & WF comments JSP.
	     */
	    public static String constructStageApprovalStatus(User user)
	    {
	        StringBuilder sb = new StringBuilder();

	        if (EProcurementUtil.isNotNullNonEmptyString(user.getJobTitle()))
	        {
	            sb.append(user.getJobTitle());
	            sb.append(StringPool.SPACE);
	        }
	        sb.append(EProcurementConstants.STATUS_APPROVED);
	        sb.append(StringPool.SPACE);
	        sb.append(StringPool.MINUS);
	        sb.append(StringPool.SPACE);
	        sb.append(user.getFullName());

	        return sb.toString();
	    }

	    /**
	     * Convert String into Date format
	     * @param strDate
	     * @return
	     */
	    public static Date convertStringToDate(String strDate)
	    {
	        Date myDate = null;
	        if (strDate.length() > 0)
	        {
	            DateFormat formatter = new SimpleDateFormat(EProcurementConstants.INPUT_DATE_FORMAT);
	            try
	            {
	                myDate = formatter.parse(strDate);
	            } catch (ParseException e)
	            {
	                LOGGER.error("Not able to parse " + strDate + " into date .." + e.getMessage());
	            }
	        }
	        return myDate;
	    }

	    public static void createDummyRequests(ThemeDisplay themeDisplay)
	    {

	        try
	        {
	            User requestor = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), "dinesh");
	            User projectOwner = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), "jay");
	            User supervisor = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(), "tina");

	            EprocurementRequest request = null;
	            LOGGER.info("Start inserting dummy records...");
	            for (int i = 0; i < EProcurementConstants.NUMBER_12; i++)
	            {
	                request = new EprocurementRequestImpl();

	                request.setRequestorId(requestor.getUserId());
	                request.setCreatedBy(requestor.getUserId());
	                request.setCreatedDate(new Date());
	                request.setStatus(EProcurementConstants.STATUS_LEVEL1_APPROVED);
	                request.setProjectOwnerId(projectOwner.getUserId());
	                request.setSupervisorId(supervisor.getUserId());

	                request.setCity("Edison");
	                request.setCompanyId(themeDisplay.getCompanyId());
	                request.setGroupId(themeDisplay.getScopeGroupId());

	                long requestId = CounterLocalServiceUtil
	                        .increment(EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST);
	                request.setRequestId(requestId);
	                EprocurementRequestLocalServiceUtil.addEprocurementRequest(request);
	            }
	            LOGGER.info("Done inserting dummy records...");

	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while inserting record.." + e.getMessage());
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error While gettign user details .." + e.getMessage());
	        }
	    }

	    /**
	     * 
	     * @param actionRequest
	     * @param themeDisplay
	     * @param isPrivateURL
	     * @param requestId
	     * @return String This method is used to create URL to request-details
	     *         portlet along with requestId
	     */
	    public static String createEditRequestURL(ActionRequest actionRequest, ThemeDisplay themeDisplay,
	            boolean isPrivateURL, long requestId)
	    {
	        String url = StringPool.BLANK;
	        try
	        {
	            Layout requestDetailsLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
	                    isPrivateURL, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
	            if (requestDetailsLayout != null)
	            {
	                LiferayPortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil
	                        .getHttpServletRequest(actionRequest), EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS,
	                        requestDetailsLayout.getPlid(), PortletRequest.RENDER_PHASE);
	                portletURL.setWindowState(LiferayWindowState.NORMAL);
	                portletURL.setPortletMode(PortletMode.VIEW);
	                portletURL.setParameter(EProcurementConstants.REDIRECT, themeDisplay.getURLCurrent());
	                url = portletURL.toString() + EProcurementConstants.PARAM_ACTION_SHOW_REQUEST
	                        + EProcurementConstants.PARAM_ACTION_NAME_SHOW_REQUEST + EProcurementConstants.PARAM_REQUEST_ID
	                        + requestId;
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error(e.getMessage(), e);
	        } catch (WindowStateException e)
	        {
	            LOGGER.error("Error in creating Eprocurement-Request-Details PortletURL : " + e.getMessage(), e);
	        } catch (PortletModeException e)
	        {
	            LOGGER.error("Error in creating Eprocurement-Request PortletURL : " + e.getMessage(), e);
	        } catch (PortalException e)
	        {
	            LOGGER.error(e.getMessage(), e);
	        }
	        return url;
	    }

	    /**
	     * 
	     * @param renderRequest
	     * @param themeDisplay
	     * @param isPrivateURL
	     * @param requestId
	     * @return String This method is used to create URL to request-details
	     *         portlet along with requestId
	     */
	    public static String createEditRequestURL(RenderRequest renderRequest, ThemeDisplay themeDisplay,
	            boolean isPrivateURL, long requestId)
	    {
	        String url = StringPool.BLANK;
	        try
	        {
	            Layout requestDetailsLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
	                    isPrivateURL, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
	            if (requestDetailsLayout != null)
	            {
	                LiferayPortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil
	                        .getHttpServletRequest(renderRequest), EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS,
	                        requestDetailsLayout.getPlid(), PortletRequest.RENDER_PHASE);
	                portletURL.setWindowState(LiferayWindowState.NORMAL);
	                portletURL.setPortletMode(PortletMode.VIEW);
	                portletURL.setParameter(EProcurementConstants.REDIRECT, themeDisplay.getURLCurrent());
	                url = portletURL.toString() + EProcurementConstants.PARAM_ACTION_SHOW_REQUEST
	                        + EProcurementConstants.PARAM_ACTION_NAME_SHOW_REQUEST + EProcurementConstants.PARAM_REQUEST_ID
	                        + requestId;
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error creating Eprocurement-Request-Details PortletURL : " + e.getMessage(), e);
	        } catch (WindowStateException e)
	        {
	            LOGGER.error("Error while setting window state : " + e.getMessage(), e);
	        } catch (PortletModeException e)
	        {
	            LOGGER.error("Error while changing Portlat Mode  : " + e.getMessage(), e);
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error creating Eprocurement-Request-Details PortletURL : " + e.getMessage(), e);
	        }
	        return url;
	    }

	    public static String createEditRequestURL(String url, long requestId)
	    {
	        String requestDetailsPageURL = url;
	        Map<String, String> requestParam = new HashMap<String, String>();
	        requestParam.put("eProcAction", "showSavedRequest");
	        requestParam.put("requestId", String.valueOf(requestId));
	        requestDetailsPageURL = EProcurementUtil.appendQueryParams(requestDetailsPageURL, requestParam);
	        return requestDetailsPageURL;
	    }

	    /**
	     * 
	     * @param renderRequest
	     * @param themeDisplay
	     * @param isPrivateURL
	     * @return {@link String} This method is used to create URL to
	     *         "Request-Dashboard" portlet on resp. page.
	     */
	    public static String createRequestDashboardURL(RenderRequest renderRequest, ThemeDisplay themeDisplay,
	            boolean isPrivateURL)
	    {
	        String url = StringPool.BLANK;

	        try
	        {
	            Layout dashboardLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
	                    isPrivateURL, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
	            if (dashboardLayout != null)
	            {
	                LiferayPortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil
	                        .getHttpServletRequest(renderRequest), EProcurementConstants.PORTLET_NAME_REQUEST_DASHBOARD,
	                        dashboardLayout.getPlid(), PortletRequest.RENDER_PHASE);
	                portletURL.setWindowState(LiferayWindowState.NORMAL);
	                portletURL.setPortletMode(PortletMode.VIEW);
	                portletURL.setParameter(EProcurementConstants.REDIRECT, themeDisplay.getURLCurrent());
	                url = portletURL.toString();
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while creating createRequestDashboardURL method : " + e.getMessage(), e);
	        } catch (WindowStateException e)
	        {
	            LOGGER.error("Error while creating createRequestDashboardURL method : " + e.getMessage(), e);
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error while creating createRequestDashboardURL method : " + e.getMessage(), e);
	        } catch (PortletModeException e)
	        {
	            LOGGER.error("problem while changing portlet mode ..." + e.getMessage());
	        }

	        return url;
	    }

	    /**
	     * 
	     * @param themeDisplay
	     * @param isPrivateLayout
	     * @param friendlyURL
	     * @return {@link String} This method is used to create Full URL based on
	     *         FriendlyURL & other parameters
	     */
	    public static String createSendRedirectURL(ThemeDisplay themeDisplay, boolean isPrivateLayout, String friendlyURL)
	    {
	        StringBuilder sb = new StringBuilder();

	        sb.append(themeDisplay.getPortalURL());
	        if (isPrivateLayout)
	        {
	            sb.append(PortalUtil.getPathFriendlyURLPrivateGroup());
	        } else
	        {
	            sb.append(PortalUtil.getPathFriendlyURLPublic());
	        }

	        sb.append(themeDisplay.getScopeGroup().getFriendlyURL());
	        sb.append(StringPool.FORWARD_SLASH);
	        sb.append(friendlyURL);

	        return sb.toString();
	    }

	    /**
	     * Create Tool Tip
	     * @param requestId
	     * @return
	     */
	    public static String createToolTip(long requestId)
	    {

	        StringBuffer strToolTip = new StringBuffer();
	        try
	        {
	            List<Item> itemList = ItemLocalServiceUtil.getItemsByRequestId(requestId);
	            EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
	            if ((itemList != null) && (itemList.size() > 0))
	            {
	                for (int i = 0; i < itemList.size(); i++)
	                {
	                    Item item = itemList.get(i);
	                    strToolTip.append(item.getItemName());
	                    strToolTip.append(StringPool.SPACE);
	                    strToolTip.append(StringPool.COLON);
	                    strToolTip.append(StringPool.SPACE);
	                    strToolTip.append(item.getItemDescription());
	                    if (i != itemList.size() - 1)
	                    {
	                        strToolTip.append(StringPool.SPACE);
	                        strToolTip.append(StringPool.COMMA);
	                        strToolTip.append(StringPool.SPACE);
	                    }
	                }
	                strToolTip.append(StringPool.SPACE);
	                strToolTip.append(StringPool.SEMICOLON);
	                strToolTip.append(StringPool.SPACE);
	                strToolTip.append(eprocRequest.getReason());

	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error("Failed to find item details " + e.getMessage());
	        } catch (PortalException e)
	        {
	            LOGGER.error("Failed to find request details " + e.getMessage());
	        }

	        return strToolTip.toString();
	    }

	    public static Criterion createUserCriterion(long userId)
	    {
	        /*
	         * Criterion criterion = RestrictionsFactoryUtil.eq("projectOwnerId",
	         * userId); criterion = RestrictionsFactoryUtil.or(criterion,
	         * RestrictionsFactoryUtil.eq("supervisorId", userId));
	         */
	        Criterion criterion = RestrictionsFactoryUtil.eq("requestorId", userId);
	        // criterion = RestrictionsFactoryUtil.or(criterion,
	        // RestrictionsFactoryUtil.eq("supervisorId", userId));
	        criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("createdBy", userId));
	        criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("nextStage", String
	                .valueOf(userId)));

	        return criterion;
	    }

	    /**
	     * @param renderRequest
	     * @retun List<String> Set All the status
	     */
	    public static List<String> getAllEprocurementStatus()
	    {
	        List<String> listStatus = new ArrayList<String>();
	        for (int i = 0; i < EProcurementConstants.ARRAY_STATUS.length; i++)
	        {
	            listStatus.add(EProcurementConstants.ARRAY_STATUS[i]);
	        }
	        return listStatus;
	    }

	    /**
	     * @param renderRequest
	     * @return List<String> Set allowed status for "NEW" request in WF screen,
	     *         for "NEW" request only "VP APPROVED" status is next mandatory
	     *         status.
	     */
	    public static List<String> getAllowedStatusForNewRequest()
	    {
	        List<String> listStatus = new ArrayList<String>();
	        listStatus.add(EProcurementConstants.STATUS_NEW);
	        listStatus.add(EProcurementConstants.STATUS_LEVEL1_APPROVED);
	        return listStatus;
	    }

	    /**
	     * 
	     * @param themeDisplay
	     * @param classNameId
	     * @param classPK
	     * @param isActive
	     * @return List<String>
	     * @throws SystemException
	     */
	    public static Map<Long, String> getAllWorkflows(long companyId, boolean isActive) throws SystemException
	    {
	        // List<String> wfNames = new ArrayList<String>();
	        Map<Long, String> mapWFIdName = new HashMap<Long, String>();
	        List<WorkflowDefinition> listWFDefinitions = WorkflowDefinitionLocalServiceUtil.getActiveWorkflowDefinitions(
	                companyId, Boolean.TRUE);
	        if (Validator.isNotNull(listWFDefinitions))
	        {
	            for (WorkflowDefinition wfDefinition : listWFDefinitions)
	            {
	                mapWFIdName.put(wfDefinition.getWorkflowDefinitionId(), wfDefinition.getWorkflowName());
	            }
	        }
	        return mapWFIdName;
	    }

	    /**
	     * 
	     * @param companyId
	     * @param groupId
	     * @param className
	     * @param requestId
	     * @param isActive
	     * @return Map<Long, String>
	     */
	    public static Map<Long, String> getAssignedWFNameIdMap(long companyId, long groupId, String className,
	            long requestId, boolean isActive)
	    {
	        Map<Long, String> wfIdName = null; // try to return null
	        WorkflowDefinition wfDefinition = getAssignedWorkflow(companyId, groupId, className, requestId, isActive);
	        if (wfDefinition != null)
	        {
	            wfIdName = new HashMap<Long, String>();
	            wfIdName.put(wfDefinition.getWorkflowDefinitionId(), wfDefinition.getWorkflowName());
	        }
	        return wfIdName;
	    }

	    public static WorkflowDefinition getAssignedWorkflow(long companyId, long groupId, String className,
	            long requestId, boolean isActive)
	    {
	        WorkflowDefinition wfDefinition = null;
	        // WF Request = WF Proposal
	        try
	        {
	            WorkflowRequest wfRequest = getWFProposalRequest(companyId, groupId, className, requestId, isActive);
	            if (wfRequest != null)
	            {
	                wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(wfRequest
	                        .getWorkflowDefinitionId());
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error("Problem while retrieving WorkflowDefinition for requestId : " + requestId);
	        } catch (PortalException e)
	        {
	            LOGGER.error("Problem while retrieving WorkflowDefinition for requestId : " + requestId);
	        }

	        return wfDefinition;
	    }

	    /**
	     * 
	     * @param className
	     * @return long
	     */
	    public static long getClassNameId(String className)
	    {
	        return ClassNameLocalServiceUtil.getClassNameId(className);
	    }

	    /**
	     * @return List<String> This method is used to retrieve all the Configured
	     *         Addresses from Portlet.properties to show in "Ship To" drop-down.
	     */
	    public static List<String> getConfiguredShipmentAddresses()
	    {
	        List<String> addressList = new ArrayList<String>();

	        ResourceBundle addressess = ResourceBundle.getBundle("portlet");
	        Enumeration addressKeys = addressess.getKeys();

	        String key = StringPool.BLANK;
	        String address = StringPool.BLANK;
	        while (addressKeys.hasMoreElements())
	        {
	            key = (String) addressKeys.nextElement();
	            address = addressess.getString(key);
	            if (EProcurementUtil.isNotNullNonEmptyString(address))
	            {
	                addressList.add(address);
	            }
	        }

	        return addressList;
	    }

	    /**
	     * 
	     * @return long
	     */
	    public static long getEprocRequestClassNameId()
	    {
	        return getClassNameId(EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST);
	    }

	    /**
	     * 
	     * @param themeDisplay
	     * @param searchContainer
	     * @param criteriaMap
	     * @return
	     * @throws SystemException
	     */
	    public static List<Object> getEprocRequests(ThemeDisplay themeDisplay, SearchContainer searchContainer,
	            Map<String, String> paramMap, long userId) throws SystemException
	    {
	        LOGGER.debug("INside getEprocRequests()....for filetering");
	        List<Object> requestList = null;

	        /* Create Dynamic Query to fetch EprocurementRequest */
	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EprocurementRequest.class);

	        /* Create Junction to add Search Parameters */
	        Criterion criterion = null;

	        if (paramMap.containsKey(EProcurementConstants.PARAM_STATUS))
	        {
	            criterion = RestrictionsFactoryUtil.eq(EProcurementConstants.PARAM_STATUS, paramMap
	                    .get(EProcurementConstants.PARAM_STATUS));
	        }

	        if (paramMap.containsKey(EProcurementConstants.PARAM_USERID))
	        {
	            if (criterion != null)
	            {
	                criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("requestorId", Long
	                        .valueOf(paramMap.get(EProcurementConstants.PARAM_USERID))));
	            } else
	            {
	                criterion = RestrictionsFactoryUtil.eq("requestorId", Long.valueOf(paramMap
	                        .get(EProcurementConstants.PARAM_USERID)));
	            }
	        }

	        if (paramMap.containsKey(EProcurementConstants.PARAM_ADDRESS))
	        {
	            if (criterion != null)
	            {
	                if (paramMap.get(EProcurementConstants.PARAM_ADDRESS).equalsIgnoreCase(
	                        EProcurementConstants.SHIP_TO_OTHER_PARAM))
	                {
	                    LOGGER.info("Other Option Selected..");
	                    criterion = RestrictionsFactoryUtil
	                            .and(criterion, RestrictionsFactoryUtil.eq("shipToOther", "YES"));

	                } else
	                {
	                    criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq(
	                            EProcurementConstants.PARAM_ADDRESS, paramMap.get(EProcurementConstants.PARAM_ADDRESS)));
	                }
	            } else
	            {
	                if (paramMap.get(EProcurementConstants.PARAM_ADDRESS).equalsIgnoreCase(
	                        EProcurementConstants.SHIP_TO_OTHER_PARAM))
	                {
	                    LOGGER.info("Other Option Selected..");
	                    criterion = RestrictionsFactoryUtil.eq(EProcurementConstants.SHIP_TO_OTHER_COL,
	                            EProcurementConstants.SHIP_TO_OTHER_VALUE);
	                } else
	                {
	                    criterion = RestrictionsFactoryUtil.eq(EProcurementConstants.PARAM_ADDRESS, paramMap
	                            .get(EProcurementConstants.PARAM_ADDRESS));
	                }
	            }
	        }

	        if (paramMap.containsKey(EProcurementConstants.PARAM_START_DATE)
	                && paramMap.containsKey(EProcurementConstants.PARAM_END_DATE))
	        {
	            // SimpleDateFormat startDate = new SimpleDateFormat("mm/dd/yyyy");
	            Date startDate = new java.util.Date(paramMap.get(EProcurementConstants.PARAM_START_DATE));
	            Date endDate = new java.util.Date(paramMap.get(EProcurementConstants.PARAM_END_DATE));

	            if (endDate != null)
	            {
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(endDate);
	                cal.set(Calendar.HOUR, EProcurementConstants.NUMBER_23);
	                cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
	                endDate = cal.getTime();

	            }
	            if (criterion != null)
	            {
	                criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.and(criterion,
	                        RestrictionsFactoryUtil.between(EProcurementConstants.CREATED_DATE, startDate, endDate)));
	            } else
	            {
	                criterion = RestrictionsFactoryUtil.between(EProcurementConstants.CREATED_DATE, startDate, endDate);
	            }
	        }

	        /*
	         * If logged-in user is not "Web-Admin", then filter requests on which
	         * he has not permission on
	         */
	        if (!isWebAdmin(themeDisplay.getCompanyId(), userId))
	        {
	            if (criterion != null)
	            {
	                criterion = RestrictionsFactoryUtil.and(criterion, createUserCriterion(userId));
	            } else
	            {
	                /**
	                 * Condition will be true if normal user directly clicks on getRequest button in dashboard without any filter
	                 */
	                criterion = createUserCriterion(userId);
	                dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_CANCELLED));
	                dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_COMPLETED));
	            }
	        } else
	        {
	            if (criterion == null)
	            {
	                /**
	                 *  1) It will be null if web admin click on any of the header 
	                 *  2) Condition will be true if web-admin directly click on gerRequest button in dashboard without any filter
	                 */
	                dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_CANCELLED));
	                dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_COMPLETED));
	            }
	        }

	        if (criterion != null)
	        {
	            dynamicQuery.add(criterion);
	        }

	        // Create default order on "modifiedDate", "createdDate" & "requestId"
	        Order defaultOrder = OrderFactoryUtil.desc(EProcurementConstants.CREATED_DATE);
	        Order secondOrder = OrderFactoryUtil.desc("requestId");

	        // Add Orders to DynamicQuery
	        dynamicQuery.addOrder(defaultOrder);
	        dynamicQuery.addOrder(secondOrder);

	        /* Set Total in Search Container FIRST */
	        searchContainer.setTotal(EprocurementRequestLocalServiceUtil.dynamicQuery(dynamicQuery).size());

	        /* Return results List */
	        requestList = EprocurementRequestLocalServiceUtil.dynamicQuery(dynamicQuery);

	        return requestList;
	    }

	    /**
	     * 
	     * @param searchContainer
	     * @return
	     * @throws SystemException
	     *             This method returns all the eprocurement requests based on
	     *             search container index, without checking permission of
	     *             logged-in user
	     * 
	     */
	    public static List<EprocurementRequest> getEprocurementRequests(SearchContainer searchContainer)
	            throws SystemException
	    {
	        List<EprocurementRequest> requestList = null;

	        requestList = EprocurementRequestLocalServiceUtil.getEprocurementRequests(searchContainer.getStart(),
	                searchContainer.getEnd());
	        searchContainer.setTotal(EprocurementRequestLocalServiceUtil.getEprocurementRequestsCount());

	        return requestList;
	    }

	    /**
	     * 
	     * @param searchContainer
	     * @param userId
	     * @return
	     * @throws SystemException
	     *             This method is used to retrieve all the EprocurementRequest
	     *             on which logged-in user has permission. Permission is checked
	     *             based on following logic: (logged-in-userId = projectOwnerId)
	     *             OR (logged-in-userId = supervisorId) OR (logged-in-userId =
	     *             requestorId) OR (logged-in-userId = createdBy) OR
	     *             (logged-in-userId = nextStage-string) But if logged-in User
	     *             is having "Web-Admin" role than show him ALL the requests.
	     */
	    public static List<Object> getEprocurementRequests(ThemeDisplay themeDisplay, SearchContainer searchContainer,
	            long userId) throws SystemException
	    {
	        LOGGER.debug("Inside getEprocurementRequests() default view for all..");
	        List<Object> requestList = null;

	        DynamicQuery dynamicQuery = EprocurementRequestLocalServiceUtil.dynamicQuery();

	        if (!isWebAdmin(themeDisplay.getCompanyId(), userId))
	        {
	            dynamicQuery.add(createUserCriterion(userId));

	        }
	        /**
	         * Do not display completed and cancelled request in default view
	         */
	        dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_CANCELLED));
	        dynamicQuery.add(PropertyFactoryUtil.forName(EProcurementConstants.PARAM_STATUS).ne(EProcurementConstants.STATUS_COMPLETED));

	        /* Create default order on "modifiedDate", "createdDate" & "requestId" */
	        Order defaultOrder = OrderFactoryUtil.desc(EProcurementConstants.CREATED_DATE);
	        Order secondOrder = OrderFactoryUtil.desc("requestId");

	        /* Add Orders to DynamicQuery */
	        dynamicQuery.addOrder(defaultOrder);
	        dynamicQuery.addOrder(secondOrder);

	        searchContainer.setTotal(EprocurementRequestLocalServiceUtil.dynamicQuery(dynamicQuery).size());
	        requestList = EprocurementRequestLocalServiceUtil.dynamicQuery(dynamicQuery, searchContainer.getStart(),
	                searchContainer.getEnd());

	        return requestList;
	    }

	    /**
	     * 
	     * @param searchContainer
	     * @return
	     * @throws SystemException
	     *             This method returns all the eprocurement requests based on
	     *             search criteria such as status,city,requestor etc.
	     * 
	     */
	    public static List<EprocurementRequest> getEprocurementRequests(ThemeDisplay themeDisplay,
	            SearchContainer searchContainer, Map<String, String> criteriaMap) throws SystemException
	    {

	        List<EprocurementRequest> requestList = new ArrayList<EprocurementRequest>();

	        if (criteriaMap.containsKey(EProcurementConstants.PARAM_STATUS))
	        {
	            requestList = EprocurementRequestLocalServiceUtil.findByStatus(themeDisplay.getCompanyId(), themeDisplay
	                    .getScopeGroupId(), criteriaMap.get(EProcurementConstants.PARAM_STATUS),
	                    searchContainer.getStart(), searchContainer.getEnd());
	            searchContainer.setTotal(EprocurementRequestLocalServiceUtil.countByStatus(themeDisplay.getCompanyId(),
	                    themeDisplay.getScopeGroupId(), criteriaMap.get(EProcurementConstants.PARAM_STATUS)));
	        }

	        if (criteriaMap.containsKey(EProcurementConstants.PARAM_STATUS)
	                && criteriaMap.containsKey(EProcurementConstants.PARAM_CITY))
	        {
	            requestList = EprocurementRequestLocalServiceUtil.findByStatusAndCity(themeDisplay.getCompanyId(),
	                    themeDisplay.getScopeGroupId(), criteriaMap.get(EProcurementConstants.PARAM_STATUS), criteriaMap
	                            .get(EProcurementConstants.PARAM_CITY), searchContainer.getStart(), searchContainer
	                            .getEnd());
	            searchContainer.setTotal(EprocurementRequestLocalServiceUtil.countByStatusAndCity(themeDisplay
	                    .getCompanyId(), themeDisplay.getScopeGroupId(), criteriaMap
	                    .get(EProcurementConstants.PARAM_STATUS), criteriaMap.get(EProcurementConstants.PARAM_CITY)));
	        }

	        return requestList;
	    }

	    /**
	     * 
	     * @param companyId
	     * @return long
	     * @throws SystemException
	     * @throws PortalException
	     */
	    public static Role getEprocWebAdminRole(long companyId) throws PortalException, SystemException
	    {
	        return RoleLocalServiceUtil.getRole(companyId, EProcurementConstants.EPROCUREMENT_ROLE_WEB_ADMIN);
	    }

	    /**
	     * 
	     * @param listStageUserIds
	     * @param currentNextStage
	     * @return String
	     * 
	     *         This method gives nextStageUserId based currentNextStageUserId &
	     *         stagesUserIdList
	     */
	    public static String getNextStage(List<Long> listStageUserIds, String currentNextStage)
	    {
	        String nextStage = StringPool.BLANK;
	        if (Validator.isNotNull(listStageUserIds) && !listStageUserIds.isEmpty() && EProcurementUtil.isNotNullNonEmptyString(currentNextStage))
	        {
	                for (int i = 0; i < listStageUserIds.size(); i++)
	                {
	                    if (listStageUserIds.get(i) > 0)
	                    {
	                        if (currentNextStage.equalsIgnoreCase(String.valueOf(listStageUserIds.get(i))))
	                        {
	                            if ((i + 1) < listStageUserIds.size())
	                            {
	                                nextStage = String.valueOf(listStageUserIds.get((i + 1)));
	                            }
	                        }
	                    }
	                }
	        }
	        return nextStage;
	    }

	    /**
	     * 
	     * @return {@link List}
	     * 
	     * Gets Locations from TempHire module
	     */
	    public static List<EprocurementLocation> getEprocureLocations()
	    {   
	        List<EprocurementLocation> locationList = new ArrayList<EprocurementLocation>();
	        List<EprocurementLocation>  eprocureLocationList= null;
	        try
	        {
	        	eprocureLocationList = EprocurementLocationLocalServiceUtil.getEprocurementLocations(0, EprocurementLocationLocalServiceUtil.getEprocurementLocationsCount());
	        	for(EprocurementLocation location:eprocureLocationList){
	        		if(Validator.isNull(location.getAppName()) || (location.getAppName()!= null && EProcurementConstants.EPROCUREMENT_LOCATION_APPNAME.equalsIgnoreCase(location.getAppName()))){
	        			locationList.add(location);
	        		}
	        	}
	        } catch (Exception e)
	        {
	            LOGGER.error("Error while retrieving locations from the database:" + e.getMessage(), e);
	        }
	        return locationList;
	    }

	    /**
	     * Get user email address based on User ID
	     * @param nextApproverUserId
	     * @return {@link String}
	     */
	    public static String getUserEmailAddress(long nextApproverUserId)
	    {
	        String userEmailAddress = StringPool.BLANK;
	        try
	        {
	            User user = UserLocalServiceUtil.getUserById(nextApproverUserId);
	            userEmailAddress = user.getEmailAddress();
	        } catch (PortalException e)
	        {
	            LOGGER.error("Failed to find user details..." + e.getMessage());
	        } catch (SystemException e)
	        {
	            LOGGER.error("User not exist...." + e.getMessage());
	        }
	        return userEmailAddress;
	    }

	    /**
	     * 
	     * @param userId
	     * @return
	     */
	    public static String getUserFullName(long userId)
	    {
	        String fullName = StringPool.BLANK;
	        try
	        {
	            fullName = UserLocalServiceUtil.getUser(userId).getFullName();
	        } catch (PortalException e)
	        {
	            LOGGER.debug("Error while retriving User with userId :: " + userId, e);
	        } catch (SystemException e)
	        {
	            LOGGER.debug("Error while retriving User with userId :: " + userId, e);
	        }
	        return fullName;
	    }

	    /**
	     * Get Requester Full Name
	     * @param requestorId
	     * @return
	     */
	    public static String getUserName(long requestorId)
	    {
	        String fullName = StringPool.BLANK;
	        try
	        {
	            User user = UserLocalServiceUtil.getUserById(requestorId);
	            fullName = user.getFirstName() + StringPool.SPACE + user.getLastName();
	        } catch (PortalException e)
	        {
	            LOGGER.error("Failed to find user details..." + e.getMessage());
	        } catch (SystemException e)
	        {
	            LOGGER.error("User not exist...." + e.getMessage());
	        }
	        return fullName;
	    }

	    /**
	     * 
	     * @param wfDefinition
	     * @return Map<String, String> This method is used to return Map status &
	     *         stage map
	     * 
	     */
	    public static Map<String, String> getWFAssignedRequestMap(WorkflowDefinition wfDefinition)
	    {
	        Map<String, String> stageIdStatusMap = new HashMap<String, String>();
	        stageIdStatusMap.put(EProcurementConstants.STATUS_NEW, EProcurementConstants.STATUS_NEW);
	        stageIdStatusMap
	                .put(EProcurementConstants.STATUS_LEVEL1_APPROVED, EProcurementConstants.STATUS_LEVEL1_APPROVED);
	        stageIdStatusMap.put(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED,
	                EProcurementConstants.STATUS_WORKFLOW_ASSIGNED);
	        stageIdStatusMap = getWFAssignedStageIdStatusMap(wfDefinition, stageIdStatusMap);
	        stageIdStatusMap.put(EProcurementConstants.STATUS_INPROCESS, EProcurementConstants.STATUS_INPROCESS);
	        stageIdStatusMap.put(EProcurementConstants.STATUS_CANCELLED, EProcurementConstants.STATUS_CANCELLED);
	        stageIdStatusMap.put(EProcurementConstants.STATUS_COMPLETED, EProcurementConstants.STATUS_COMPLETED);
	        return stageIdStatusMap;
	    }

	    /**
	     * 
	     * @return List<String>
	     * 
	     *         This method is used to set status of request to which WF is
	     *         assigned, these status are then shown in drop-down in JSP This
	     *         method should be changed to handle the scenario when different
	     *         Status is selected WF-Request screen & not just NEXT/PREVIOUS
	     *         status...2 ways for this: 1. "~" can be added in every status
	     *         drop-down VALUE 2. only stage/userId added as status drop-down
	     *         VALUE, for display can create JSP method which displays full
	     *         status as e.g. "Program Manager APPROVED - Anantha Kancherla" 3.
	     *         Eventually if solution-2 is opted then rather than using String
	     *         List HashMap of status key-value can be used. 4. ELSE complete
	     *         different solution can be to add new column in Eproc-Request
	     *         table
	     */
	    public static List<String> getWFAssignedRequestStatus(WorkflowDefinition wfDefinition)
	    {
	        List<String> listStatus = new ArrayList<String>();
	        listStatus.add(EProcurementConstants.STATUS_NEW);
	        listStatus.add(EProcurementConstants.STATUS_LEVEL1_APPROVED);
	        /**
	         * @ToDo - Not sure whether "WORKFLOW ASSIGNED" status should be show
	         *       for WF assigned request or not.
	         */
	        listStatus.add(EProcurementConstants.STATUS_WORKFLOW_ASSIGNED);

	        List<Long> listUserId = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
	        if ((listUserId != null) && !listUserId.isEmpty())
	        {
	            User user = null;
	            String status = StringPool.BLANK;
	            for (Long userId : listUserId)
	            {
	                try
	                {
	                    user = UserLocalServiceUtil.getUser(userId);
	                    status = EProcurementUtil.constructStageApprovalStatus(user);
	                    // listStatus.add(String.valueOf(userId));
	                    listStatus.add(status);
	                } catch (SystemException e)
	                {
	                    LOGGER.error(e.getMessage(),e);
	                } catch (PortalException e)
	                {
	                    LOGGER.error(e.getMessage(),e);
	                }
	            }
	        }

	        listStatus.add(EProcurementConstants.STATUS_INPROCESS);
	        listStatus.add(EProcurementConstants.STATUS_CANCELLED);
	        listStatus.add(EProcurementConstants.STATUS_COMPLETED);

	        return listStatus;
	    }

	    /**
	     * 
	     * @param wfDefinition
	     * @return Map<String, String> This method is used to return Map that
	     *         contains stage/userId as key & status corresponding to that as
	     *         value.
	     * 
	     */
	    public static Map<String, String> getWFAssignedStageIdStatusMap(WorkflowDefinition wfDefinition,
	            Map<String, String> stageIdStatusMap)
	    {
	        List<Long> listUserId = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
	        if ((listUserId != null) && !listUserId.isEmpty())
	        {
	            User user = null;
	            String status = StringPool.BLANK;
	            for (Long userId : listUserId)
	            {
	                try
	                {
	                    user = UserLocalServiceUtil.getUser(userId);
	                    status = EProcurementUtil.constructStageApprovalStatus(user);
	                    stageIdStatusMap.put(String.valueOf(userId), status);
	                } catch (PortalException e)
	                {
	                    LOGGER.error("Error while retrieving user with userId : " + userId);
	                } catch (SystemException e)
	                {
	                    LOGGER.error("Error while retrieving user with userId : " + userId);
	                }
	            }
	        }
	        return stageIdStatusMap;
	    }

	    public static WorkflowDefinition getWFDefinitionFromIdNameMap(Map<Long, String> wfIdNameMap)
	    {
	        WorkflowDefinition wfDefinition = null;
	        if (wfIdNameMap != null)
	        {
	            Set<Long> wfDefIdSet = wfIdNameMap.keySet();
	            long wfDefId = 0;
	            if ((wfDefIdSet != null) && (wfDefIdSet.size() > 0))
	            {
	                Iterator<Long> itr = wfDefIdSet.iterator();
	                while (itr.hasNext())
	                {
	                    wfDefId = itr.next();
	                    if (wfDefId > 0)
	                    {
	                        try
	                        {
	                            wfDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(wfDefId);
	                        } catch (PortalException e)
	                        {
	                            LOGGER.error("No WFDefinition found for wfDefId : " + wfDefId);
	                        } catch (SystemException e)
	                        {
	                            LOGGER.error("No WFDefinition found for wfDefId : " + wfDefId);
	                        }
	                    }
	                }
	            }
	        }
	        return wfDefinition;
	    }

	    public static WorkflowRequest getWFProposalRequest(long companyId, long groupId, String className, long requestId,
	            boolean isActive) throws SystemException, PortalException
	    {
	        return WorkflowRequestLocalServiceUtil.getWorkflowRequestByClassPK(companyId, groupId, EProcurementUtil
	                .getClassNameId(className), requestId, isActive);
	    }

	    /**
	     * 
	     * @param themeDisplay
	     * @param classNameId
	     * @param classPK
	     * @param isActive
	     * @return String
	     */
	    public static String getWorkflowName(ThemeDisplay themeDisplay, long classNameId, long classPK, boolean isActive)
	    {
	        String workflowName = StringPool.BLANK;

	        try
	        {
	            WorkflowRequest workflowRequestMapping = WorkflowRequestLocalServiceUtil.getWorkflowRequestByClassPK(
	                    themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), classNameId, classPK, isActive);
	            workflowName = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(
	                    workflowRequestMapping.getWorkflowDefinitionId()).getWorkflowName();
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error while retrieving Workflow Name for requestId : " + classPK + " & message : "
	                    + e.getMessage());
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while retrieving Workflow Name for requestId : " + classPK + " & message : "
	                    + e.getMessage());
	        }

	        return workflowName;
	    }

	    /**
	     * 
	     * @param param
	     * @return
	     */
	    public static boolean isNotNullNonEmptyString(String param)
	    {
	        if ((param != null) && !(StringPool.BLANK).equalsIgnoreCase(param.trim()))
	        {
	            return Boolean.TRUE;
	        } else
	        {
	            return Boolean.FALSE;
	        }
	    }

	    public static boolean isNumber(String status)
	    {
	        boolean isNumber = Boolean.FALSE;
	        if (Validator.isNumber(status))
	        {
	            isNumber = Boolean.TRUE;
	        }

	        return isNumber;
	    }

	    /**
	     * 
	     * @param companyId
	     * @param userId
	     * @return boolean
	     */
	    public static boolean isWebAdmin(long companyId, long userId)
	    {
	        boolean isWebAdmin = Boolean.FALSE;

	        try
	        {
	            Role eprocWebAdminRole = RoleLocalServiceUtil.getRole(companyId,
	                    EProcurementConstants.EPROCUREMENT_ROLE_WEB_ADMIN);
	            if (eprocWebAdminRole != null)
	            {
	                isWebAdmin = RoleLocalServiceUtil.hasUserRole(userId, eprocWebAdminRole.getRoleId());
	            }
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error while checking Eprocurement-WebAdmin role for userId : " + userId + " : "
	                    + e.getMessage(), e);
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while checking Eprocurement-WebAdmin role for userId : " + userId + " : "
	                    + e.getMessage(), e);
	        }

	        return isWebAdmin;
	    }

	    /**
	     * @param renderRequest
	     * @return Set allowed status for "NEW" request in WF screen, for "NEW"
	     *         request only "VP APPROVED" status is next mandatory status.
	     */
	    public static void setAllowedStatusForNewRequest(RenderRequest renderRequest)
	    {
	        renderRequest.setAttribute("listStatus", getAllowedStatusForNewRequest());
	    }

	    /**
	     * 
	     * @param renderRequest
	     */
	    public static void setAllowedStatusForWFAssignedRequest(RenderRequest renderRequest, WorkflowDefinition wfDefinition)
	    {
	        renderRequest.setAttribute("listStatus", getWFAssignedRequestStatus(wfDefinition));
	    }

	    /**
	     * @param renderRequest
	     *            Set All the status
	     */
	    public static void setAllStatus(RenderRequest renderRequest)
	    {
	        renderRequest.setAttribute("listStatus", getAllEprocurementStatus());
	    }

	    /**
	     * 
	     * @param wfIdNameMap
	     * @return List<CustomStageRouter>
	     * 
	     *         This method return custom POJO which is used on JSP to display
	     *         various information on progress of WF stage such as Mark sign,
	     *         Job Title, Full Name
	     * 
	     */
	    public static CustomWFRouter setStageRouterInfo(WorkflowDefinition wfDefinition, String nextStage,
	            EprocurementRequest eprocRequest)
	    {
	        CustomWFRouter wfRouter = new CustomWFRouter();

	        List<CustomStageRouter> listStageRouter = new ArrayList<CustomStageRouter>();

	        long nextStageUserId = 0;
	        if (EProcurementUtil.isNotNullNonEmptyString(nextStage))
	        {
	            nextStageUserId = Long.valueOf(nextStage);
	        }

	        if (wfDefinition != null)
	        {
	            wfRouter.setWfDefinitionId(wfDefinition.getWorkflowDefinitionId());
	            wfRouter.setWfDefinitionName(wfDefinition.getWorkflowName());

	            List<Long> listUserId = WorkflowPortletUtil.getApproverIdList(wfDefinition.getStages());
	            if ((listUserId != null) && !listUserId.isEmpty())
	            {
	                CustomStageRouter stageRouter = null;
	                User user = null;
	                String statusMessage = EProcurementConstants.MSG_PENDING_APPROVAL;
	                boolean showCheck = Boolean.FALSE;
	                for (long userId : listUserId)
	                {
	                    stageRouter = new CustomStageRouter();
	                    try
	                    {
	                        user = UserLocalServiceUtil.getUser(userId);

	                        // if "nextStage" of Request & stageUserId of List
	                        // matches then show "check" image against it & show
	                        // statusMessage as "Pending for Approval"

	                        if (!EProcurementConstants.STATUS_NEW.equals(eprocRequest.getStatus())
	                                && !EProcurementConstants.STATUS_LEVEL1_APPROVED.equals(eprocRequest.getStatus()))
	                        {

	                            if ((nextStageUserId > 0) && (nextStageUserId == userId))
	                            {
	                                showCheck = Boolean.TRUE;
	                            }

	                            // Following logic tries to set
	                            // "Submitted & Approved"
	                            // message for all the stages which are completed
	                            if ((nextStageUserId > 0) && (userId > 0))
	                            {
	                                try
	                                {
	                                    int currentStatusIndex = listUserId.indexOf(nextStageUserId);
	                                    int counterIndex = listUserId.indexOf(userId);
	                                    if (counterIndex < currentStatusIndex)
	                                    {
	                                        statusMessage = EProcurementConstants.MSG_SUBMITTED_APPROVED;
	                                    }
	                                } catch (Exception e)
	                                {
	                                    LOGGER.error("Error while checking index for current stage : " + e.getMessage());
	                                }
	                            }

	                            if ((nextStageUserId == 0)
	                                    && (EProcurementConstants.STATUS_LEVEL1_APPROVED != eprocRequest.getStatus())
	                                    && (EProcurementConstants.STATUS_NEW != eprocRequest.getStatus()))
	                            {
	                                /**
	                                 * If this condition satisfies means next approver is web admin
	                                 * Request approved by all the stage approvers ..so it should show all status for all stage approver as "Submitted and approved"
	                                 */
	                                statusMessage = EProcurementConstants.MSG_SUBMITTED_APPROVED;

	                            }
	                        }
	                        stageRouter.setShowCheck(showCheck);
	                        stageRouter.setStatusMessage(statusMessage);
	                        stageRouter.setJobTitle(user.getJobTitle());
	                        stageRouter.setFullName(user.getFullName());
	                    } catch (PortalException e)
	                    {
	                        LOGGER.error("No such user with userId :" + userId + " while setting stageRouterInfo");
	                    } catch (SystemException e)
	                    {
	                        LOGGER.error("No such user with userId :" + userId + " while setting stageRouterInfo");
	                    }
	                    listStageRouter.add(stageRouter);
	                    statusMessage = EProcurementConstants.MSG_PENDING_APPROVAL;
	                    showCheck = Boolean.FALSE;
	                }
	            }
	        }
	        wfRouter.setListStageRouter(listStageRouter);

	        return wfRouter;
	    }

	    /**
	     * 
	     * @param renderRequest
	     * @param renderResponse
	     * @param themeDisplay
	     * @param requestId
	     * @param command
	     * @return List<CustomWFReview> This method is used to show all the
	     *         status,stage,date-time,updator name, comments etc. in JSP
	     */
	    public static List<CustomWFReview> showAllWFReview(RenderRequest renderRequest, ThemeDisplay themeDisplay,
	            long requestId)
	    {
	        List<CustomWFReview> listCustomWFReview = new ArrayList<CustomWFReview>();
	        try
	        {
	            List<WorkflowReview> listWfReview = WorkflowReviewLocalServiceUtil.getAllWFReviews(themeDisplay
	                    .getCompanyId(), themeDisplay.getScopeGroupId(), EProcurementUtil.getEprocRequestClassNameId(),
	                    requestId);
	            if (listWfReview != null)
	            {
	                CustomWFReview customWFReview = null;
	                User updator = null;
	                for (WorkflowReview wfReview : listWfReview)
	                {
	                    customWFReview = new CustomWFReview();
	                    customWFReview.setApproverComments(wfReview.getApproverComments());
	                    customWFReview.setEmailComments(wfReview.getEmailComments());
	                    customWFReview.setUpdatedBy(wfReview.getUpdatedBy());
	                    updator = UserLocalServiceUtil.getUser(wfReview.getUpdatedBy());
	                    customWFReview.setUpdatedByName(updator.getFullName());
	                    customWFReview.setUpdatedDate(wfReview.getUpdatedDate());
	                    customWFReview.setUpdatedToStatus(wfReview.getUpdatedToStatus());
	                    listCustomWFReview.add(customWFReview);
	                }
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.debug("Error while retrieving all the WFReviews for requestId : " + requestId + " & error is : "
	                    + e.getMessage());
	        } catch (PortalException e)
	        {
	            LOGGER.debug("Error while retrieving all the WFReviews for requestId : " + requestId + " & error is : "
	                    + e.getMessage());
	        }
	        return listCustomWFReview;
	    }

	    /**
	     * 
	     * @param requestId
	     * @return {@link String} Based on nextStage of any given request, this
	     *         method returns "nextApprover" as "Web-Admin" or any user's
	     *         full-name.
	     */
	    public static String showNextApprover(long requestId)
	    {
	        String userName = "Web-Admin";
	        try
	        {
	            EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
	            if (request != null)
	            {
	                String nextStage = request.getNextStage();
	                if (EProcurementUtil.isNotNullNonEmptyString(nextStage) && EProcurementUtil.isNumber(nextStage))
	                {
	                    User user = UserLocalServiceUtil.getUser(Long.valueOf(nextStage));
	                    if (user != null)
	                    {
	                        userName = user.getFullName();
	                    }
	                }
	            }
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error while getting nextApprover for requestId :  " + requestId);
	        } catch (NumberFormatException e)
	        {
	            LOGGER.error("Error while getting nextApprover for requestId :showNextApprover() " + requestId);
	        } catch (SystemException e)
	        {
	            LOGGER.error("Problem while getting nextApprover for requestId : showNextApprover" + requestId);
	        }

	        return userName;
	    }

	    /**
	     * 
	     * @param renderRequest
	     * @param themeDisplay
	     * @param isPrivateURL
	     * @param requestId
	     * @return {@link String}
	     * Creates URL for Request Details page
	     */
	    public static String viewRequestURL(ActionRequest renderRequest, ThemeDisplay themeDisplay, boolean isPrivateURL,
	            long requestId)
	    {
	        String url = StringPool.BLANK;
	        try
	        {
	            Layout requestDetailsLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
	                    isPrivateURL, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
	            if (requestDetailsLayout != null)
	            {
	                LiferayPortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil
	                        .getHttpServletRequest(renderRequest), EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS,
	                        requestDetailsLayout.getPlid(), PortletRequest.RENDER_PHASE);
	                portletURL.setWindowState(LiferayWindowState.NORMAL);
	                portletURL.setPortletMode(PortletMode.VIEW);
	                portletURL.setParameter(EProcurementConstants.REDIRECT, themeDisplay.getURLCurrent());
	                url = portletURL.toString() + EProcurementConstants.PARAM_ACTION_SHOW_REQUEST
	                        + EProcurementConstants.PARAM_ACTION_NAME_SHOW_REQUEST + EProcurementConstants.PARAM_REQUEST_ID
	                        + requestId;
	            }
	        } catch (SystemException e)
	        {
	            LOGGER.error("Error while creating PortletURL :viewRequestURL() " + e.getMessage(), e);
	        } catch (PortalException e)
	        {
	            LOGGER.error("Error in creating PortletURL : viewRequestURL()" + e.getMessage(), e);
	        } catch (WindowStateException e)
	        {
	            LOGGER.error("Error while creating Eprocurement-Request-Details PortletURL : " + e.getMessage(), e);
	        } catch (PortletModeException e)
	        {
	            LOGGER.error("Error while creating Eprocurement-Request-Details PortletURL : " + e.getMessage(), e);
	        }
	        return url;
	    }
	    
	    /**
	     * Checks if user has role
	     * 
	     * @param userId
	     * @param companyId
	     * @param roleName
	     * @param inherited
	     * @return
	     */
	    public static boolean hasUserRole(long userId, long companyId, String roleName, boolean inherited)
	    {
	        boolean hasUserRole = false;
	        try
	        {
	            hasUserRole = RoleLocalServiceUtil.hasUserRole(userId, companyId, roleName, false);
	        } catch (PortalException e)
	        {
	            LOGGER.error(e.getMessage(), e);

	        } catch (SystemException e)
	        {
	            LOGGER.error(e.getMessage(), e);
	        }
	        return hasUserRole;

	    }
	    
	    public static void setPermissions_5(FileEntry fileEntry, ThemeDisplay themeDisplay) throws SystemException,
	            PortalException
	    {
	        Resource resource = null;
	       /* try
	        {
	            resource = ResourceLocalServiceUtil.getResource(fileEntry.getCompanyId(), PortletKeys.DOCUMENT_LIBRARY,
	                    ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()));
	        } catch (NoSuchResourceException nsre)
	        {
	            ResourceLocalServiceUtil.addResources(fileEntry.getCompanyId(), themeDisplay.getScopeGroupId(), 0,
	                    PortletKeys.DOCUMENT_LIBRARY, fileEntry.getFileEntryId(), true, true, true);
	            resource = ResourceLocalServiceUtil.getResource(fileEntry.getCompanyId(), DLFileEntry.class.getName(),
	                    ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()));
	        }

	        Role userRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.USER);
	        if (Validator.isNotNull(userRole))
	        {

	            String[] actionIds = EProcurementConstants.DL_USER_FILE_PERMISSION;
	            PermissionLocalServiceUtil.setRolePermissions(userRole.getRoleId(), actionIds, resource.getResourceId());
	        }*/
	    }
	    
	    public static void setPermissions_6(FileEntry fileEntry, ThemeDisplay themeDisplay)
	    {
	        Role userRole = null;
	        ResourcePermission resourcePermission = null;
	        ResourceAction resourceAction = getViewResourceAction_6();
	        try
	        {
	            userRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.USER);
	            resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(themeDisplay.getCompanyId(),
	                    DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry
	                            .getPrimaryKey()), userRole.getRoleId());
	            if (Validator.isNotNull(resourceAction)
	                    && !ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission, resourceAction))
	            {
	                resourcePermission.setActionIds(resourcePermission.getActionIds() + resourceAction.getBitwiseValue());
	                ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
	            }

	        } catch (NoSuchResourcePermissionException e)
	        {

	            try
	            {
	                resourcePermission = ResourcePermissionLocalServiceUtil
	                        .createResourcePermission(CounterLocalServiceUtil.increment());
	                resourcePermission.setCompanyId(themeDisplay.getCompanyId());
	                resourcePermission.setName(DLFileEntry.class.getName());
	                resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
	                resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
	                if (userRole != null)
	                {
	                    resourcePermission.setRoleId(userRole.getRoleId());
	                }
	                resourcePermission.setOwnerId(0);
	                if (Validator.isNotNull(resourceAction))
	                {
	                    resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
	                }
	                ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
	            } catch (SystemException se)
	            {
	                if (LOGGER.isDebugEnabled())
	                {
	                    LOGGER.error(se.getMessage(), se);
	                }
	            }
	        } catch (PortalException e)
	        {
	            if (LOGGER.isDebugEnabled())
	            {
	                LOGGER.error(e.getMessage(), e);
	            }
	        } catch (SystemException e)
	        {
	            if (LOGGER.isDebugEnabled())
	            {
	                LOGGER.error(e.getMessage(), e);
	            }
	        }
	    }

	    public static ResourceAction getViewResourceAction_6()
	    {

	        ResourceAction resourceAction = null;
	        try
	        {
	            resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFileEntry.class.getName(),
	                    ActionKeys.VIEW);
	        } catch (PortalException e)
	        {
	            LOGGER.error(e.getMessage());
	        }
	        return resourceAction;
	    }
}
