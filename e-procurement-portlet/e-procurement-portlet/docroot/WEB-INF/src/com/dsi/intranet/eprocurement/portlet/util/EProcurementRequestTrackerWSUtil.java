/**
 * Copyright © 2010 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.codec.binary.Base64;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.requestapproval.exception.NoSuchRequestApprovalException;
import com.dsi.intranet.requestapproval.model.RequestApproval;
import com.dsi.intranet.requestapproval.service.RequestApprovalLocalServiceUtil;
import com.dsi.intranet.xml.DynamicElement;
import com.dsi.intranet.xml.DynamicElementItem;
import com.dsi.intranet.xml.EProcurementProcessInfo;
import com.dsi.intranet.xml.RequestXML;
import com.dsi.intranet.xml.RequestXMLUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="EProcurementRequestTrackerWSUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project Intranet
 * @author Kalpesh Sangani
 * @Description This class handles all the web services requests coming to the E-Procurement portlet
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             --------------------
 *             --------------------------------------------------------
 */
public final class EProcurementRequestTrackerWSUtil
{
	public static final String APP_NAME = "EPROCUREMENT";
    public static final String APP_NAME_FIELD = "appName";
    public static final String DOUBLE_SLASH = "://";
    public static String HREF_TEMPLATE = "<a href='REQUEST_TRACKER_URL' >REQUEST_TRACKER_URL</a><br>";
    public static final String ITEM_XML_FIELD_COST = "cost";
    public static final String ITEM_XML_FIELD_COST_CENTER = "costCenter";
    public static final String ITEM_XML_FIELD_G1_ACC_NO = "glAccNo";
    public static final String ITEM_XML_FIELD_ITEM_DESCRIPTION = "itemDescription";
    public static final String ITEM_XML_FIELD_ITEM_ID = "itemId";
    public static final String ITEM_XML_FIELD_ITEM_IN_STOCK = "itemInStock";
    public static final String ITEM_XML_FIELD_ITEM_NAME = "itemName";
    public static final String ITEM_XML_FIELD_PURCHASE_ORDER = "purchaseOrder";
    public static final String ITEM_XML_FIELD_QUANTITY = "quantity";
    public static final String ITEM_XML_FIELD_RECEIVE_DATE = "recievedDate";
    public static final String ITEM_XML_FIELD_REQUEST_ID = "requestId";

    public static final String ITEM_XML_FIELD_RETURN_ASSETS = "returnedAssets";
    public static final String ITEM_XML_FIELD_RETURN_DATE = "returnedDate";
    public static final String ITEM_XML_FIELD_VENDOR_CODE = "vendorCode";
    public static final String ITEM_XML_FIELD_WBSELEMENT = "wbsElement";
    private static final Log LOGGER = LogFactoryUtil.getLog(EProcurementRequestTrackerWSUtil.class);
    public static final String REQUEST_ID_FIELD = "requestId";
    public static final String REQUEST_STATUS_APPROVED = "Approved";
    public static final String REQUEST_STATUS_PENDING = "Pending";
    public static final String REQUEST_STATUS_REJECTED = "Rejected";
    public static final String REQUEST_TRACKER_DATE_FORMAT = "MM/dd/yyyy";
    public static final String REQUEST_TRACKER_FRIENDLY_URL = "/request-tracker";
    public static final String REQUEST_TRACKER_PAGE_NAME = "Request Tracker";
    public static final String REQUEST_TRACKER_PAGE_URL_KEY = "request.tracker.page.url";
    public static final String REQUEST_TRACKER_ROLE = "reguest.tracker.role";
    public static final String REQUEST_TRACKER_WAR_NAME = "requesttracker_WAR_requesttrackerportlet";
    public static String TEMPLATE_LINE1 = "<b>Approve/Reject request without VPN from iPhone/iPad/Computer</b><br/><br/>";
    public static final String USER_NAME_FIELD = "approverUserId";
    public static final String XML_FIELD_ADDRESS = "Address";
    public static final String XML_FIELD_ASSET_INFO = "Asset Info";
    public static final String XML_FIELD_CITY = "City";
    public static final String XML_FIELD_CONTRACT_ID = "Contract Id";
    public static final String XML_FIELD_IS_BUDGETED_REQUEST = "Is Budgeted Request";
    public static final String XML_FIELD_IS_RELATED_TO_PROJECT = "Is Related to Project";

    public static final String XML_FIELD_ITEAM_STOCK = "Item In Stock";
    public static final String XML_FIELD_NOTE = "Notes";
    public static final String XML_FIELD_PROJECT_NAME = "Project Name";
    public static final String XML_FIELD_PROJECT_OWNER_ID = "Project Owner Name";
    public static final String XML_FIELD_PURCHASE_ORDER = "Purchase Order";
    public static final String XML_FIELD_REASON = "Reason";
    public static final String XML_FIELD_RECIEVED_DATE = "Recieved Date";
    public static final String XML_FIELD_REQUEST_ID = "Request Id";
    public static final String XML_FIELD_RETURN_DATE = "Returned Date";
    public static final String XML_FIELD_RETURNED_ASSETS = "Returned Assets";
    public static final String XML_FIELD_SHIP_TO_OTHER = "Ship To Other";
    public static final String XML_FIELD_STATE = "State";
    public static final String XML_FIELD_TOTAL_COST = "Total Cost";
    public static final String XML_FIELD_USER_NAME = "User Name";
    public static final String XML_FIELD_VENDOR_CODE = "Vendor Code";

    public static final String XML_FIELD_VENDOR_EMAIL = "Vendor Email";
    public static final String XML_HIDDEN_FIELD_DASHBOARD_URL = "HIDDEN_DASHBOARD_URL";
    public static final String XML_HIDDEN_FIELD_VIEW_REQUEST_URL = "HIDDEN_VIEW_REQUEST_URL";

    private EProcurementRequestTrackerWSUtil()
    {
    }
    
    public static void addEntryInRequestTracker(EprocurementRequest eprocuRequest, ThemeDisplay themeDisplay)
    {

        if (Validator.isNotNull(eprocuRequest))
        {

            updateRequestApproval(eprocuRequest.getRequestId(), eprocuRequest.getStatus(),
                    StringPool.BLANK);
        }

    }

   /* public static void addRequestTrackerRecord(String appName, String requestId, String requestXML, String status,
            String comment, URL wsURL)
    {
        try
        {
                LOGGER.info("addRequestTrackerRecord service called ");
                RequestTrackerServiceSoapServiceStub stub = new RequestTrackerServiceSoapServiceStub(wsURL.toString());
                AddRequestTrackerDocument document = AddRequestTrackerDocument.Factory.newInstance();
                AddRequestTrackerDocument.AddRequestTracker inputs = document.addNewAddRequestTracker();
                inputs.setAppName(appName);
                inputs.setRequestId(requestId);
                inputs.setRequestXML(requestXML);
                inputs.setStatus(status);
                inputs.setComments(null);
                stub.addRequestTracker(document);
                
                RequestTrackerServiceUtil.
            //RequestTrackerServiceSoapServiceLocator locatorUser = new RequestTrackerServiceSoapServiceLocator();
            //RequestTrackerServiceSoap serviceUser = locatorUser.getPortlet_RequestTracker_RequestTrackerService(wsURL);
            //serviceUser.addRequestTracker(appName, requestId, requestXML, status, null);
            LOGGER.info("Record is added successfull via web service ");
        }catch (RemoteException e) {
                LOGGER.error("Exception occurred while invking web service", e);
                }catch (Exception e){
            LOGGER.error("Exception occurred while invking web service", e);
        }
    }*/
    
  

    public static void approveDeclineRequest(EProcurementProcessInfo eprocurementProcessInfo)
    {
        long requestId = eprocurementProcessInfo.getRequestId();
        String cmd = eprocurementProcessInfo.getCmd();

        String newStatus = StringPool.BLANK;
        boolean resetStatus = Boolean.FALSE;
        String wfDefinitionId = StringPool.BLANK;
        String successMessage = StringPool.BLANK;

        LOGGER.info("RequestWorkflowController.approveDeclineRequest() with requestId : " + requestId
                + " User Id is :- " + eprocurementProcessInfo.getUserId() + " Approver Id is :- "
                + eprocurementProcessInfo.getApproverId() + " Approver commentsis :- "
                + eprocurementProcessInfo.getApproverComments() + " cmd is :- " + cmd);

        if (requestId > 0)
        {
            try
            {
                EprocurementRequest request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                RequestTrackerWorkflowProgressUtil.updateStatusStageComments(eprocurementProcessInfo, request,
                        newStatus, wfDefinitionId, resetStatus);
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
        
        Map<String, String> requestParam = new HashMap<String, String>();
        if (Validator.isNotNull(successMessage))
        {
            requestParam.put("successMsg", successMessage);
        }
        
        /**
         * Sonar Code Refractor
        
        try
        {
            String dashBoardURL = eprocurementProcessInfo.getDashBoardURL();

            Map<String, String> requestParam = new HashMap<String, String>();
            if (Validator.isNotNull(successMessage))
            {
                requestParam.put("successMsg", successMessage);
                if(Validator.isNotNull(dashBoardURL))
                {
                        dashBoardURL = EProcurementUtil.appendQueryParams(dashBoardURL, requestParam);
                }
            }

        } catch (Exception e)
        {
            LOGGER.error("Error while forwarding to Request Dashboard : " + e.getMessage(), e);
        }
         */
    }

    public static String createBeanToXML(EprocurementRequest eprocuRequest, ThemeDisplay themeDisplay)
    {

        List<DynamicElement> dynamicElementList = new ArrayList<DynamicElement>();
        List<com.dsi.intranet.xml.Item> dynamicItemList = new ArrayList<com.dsi.intranet.xml.Item>();

        try
        {
            if (eprocuRequest.getRequestorId() > 0)
            {
                User user = UserLocalServiceUtil.getUser(eprocuRequest.getRequestorId());
                dynamicElementList.add(new DynamicElement(XML_FIELD_USER_NAME, user.getFullName()));
            }
            dynamicElementList.add(new DynamicElement(XML_FIELD_ADDRESS, eprocuRequest.getAddress()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_ASSET_INFO, eprocuRequest.getAssetInfo()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_CITY, eprocuRequest.getCity()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_CONTRACT_ID, eprocuRequest.getContractId()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_IS_BUDGETED_REQUEST, eprocuRequest
                    .getIsBudgetedRequest()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_IS_RELATED_TO_PROJECT, eprocuRequest
                    .getIsRelatedtoProject()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_ITEAM_STOCK, getBooleanInFormate(eprocuRequest
                    .getItemInStock())));
            dynamicElementList.add(new DynamicElement(XML_FIELD_NOTE, eprocuRequest.getNotes()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_PROJECT_NAME, eprocuRequest.getProjectName()));
            if (eprocuRequest.getProjectOwnerId() > 0)
            {
                User ownerUser = UserLocalServiceUtil.getUser(eprocuRequest.getProjectOwnerId());
                dynamicElementList.add(new DynamicElement(XML_FIELD_PROJECT_OWNER_ID, ownerUser.getFullName()));
            }
            dynamicElementList.add(new DynamicElement(XML_FIELD_PURCHASE_ORDER, eprocuRequest.getPurchaseOrder()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_REASON, eprocuRequest.getReason()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_RECIEVED_DATE, getDateInFormate(eprocuRequest
                    .getRecievedDate())));
            dynamicElementList.add(new DynamicElement(XML_FIELD_RETURN_DATE, getDateInFormate(eprocuRequest
                    .getReturnedDate())));
            dynamicElementList.add(new DynamicElement(XML_FIELD_RETURNED_ASSETS, eprocuRequest.getReturnedAssets()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_STATE, eprocuRequest.getState()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_TOTAL_COST, eprocuRequest.getTotalCost() + StringPool.BLANK));
            dynamicElementList.add(new DynamicElement(XML_FIELD_VENDOR_CODE, eprocuRequest.getVendorCode()));
            dynamicElementList.add(new DynamicElement(XML_FIELD_VENDOR_EMAIL, eprocuRequest.getVendorEmail()));
            loadEprocurementHiddenUserInfo(themeDisplay, eprocuRequest, dynamicElementList);
            List<Item> itemList = ItemLocalServiceUtil.getItemsByRequestId(eprocuRequest.getRequestId());
            for (Item item : itemList)
            {
                List<DynamicElementItem> dynamicElementItemList1 = new ArrayList<DynamicElementItem>();
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_COST, item.getCost() + StringPool.BLANK));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_COST_CENTER, item.getCostCenter()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_G1_ACC_NO, item.getGlAccNo()));

                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_ITEM_DESCRIPTION, item
                        .getItemDescription()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_ITEM_ID, item.getItemId() + StringPool.BLANK));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_ITEM_IN_STOCK, item.getItemInStock()
                        + StringPool.BLANK));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_ITEM_NAME, item.getItemName()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_PURCHASE_ORDER, item
                        .getPurchaseOrder()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_QUANTITY, item.getQuantity() + StringPool.BLANK));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_RECEIVE_DATE, getDateInFormate(item
                        .getRecievedDate())));
                dynamicElementItemList1
                        .add(new DynamicElementItem(ITEM_XML_FIELD_REQUEST_ID, item.getRequestId() + StringPool.BLANK));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_RETURN_ASSETS, item
                        .getReturnedAssets()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_RETURN_DATE, getDateInFormate(item
                        .getRecievedDate())));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_VENDOR_CODE, item.getVendorCode()));
                dynamicElementItemList1.add(new DynamicElementItem(ITEM_XML_FIELD_WBSELEMENT, item.getWbselement()));

                com.dsi.intranet.xml.Item xmlItem = new com.dsi.intranet.xml.Item(dynamicElementItemList1);
                dynamicItemList.add(xmlItem);
            }

        } catch (Exception e)
        {
            LOGGER.error("Exception occurred while making bean to xml", e);
        }

        RequestXML requestXML = new RequestXML(dynamicElementList, dynamicItemList);
        return RequestXMLUtil.getBeanToXML(requestXML);
    }

    public static String getBooleanInFormate(boolean value)
    {
        return value == false ? "No" : "Yes";
    }

    public static String getDateInFormate(Date date)
    {
        String reqDate = StringPool.BLANK;
        if (date == null)
        {
            return reqDate;
        }
        try
        {
            Format formatter = new SimpleDateFormat(REQUEST_TRACKER_DATE_FORMAT);
            reqDate = formatter.format(date);
        } catch (Exception e)
        {
            LOGGER.error("Exception occurred while parshing date to string", e);
        }
        return reqDate;
    }

    public static String getReqTrackerPageURL(EprocurementRequest eprocurementRequest)
    {
        long requestId = eprocurementRequest.getRequestId();
        long supervisorId = eprocurementRequest.getSupervisorId();
        long managerId = eprocurementRequest.getProjectOwnerId();
        String pageURL = PortletProps.get(REQUEST_TRACKER_PAGE_URL_KEY);
        StringBuilder url = new StringBuilder(pageURL);
        try
        {
            if (Validator.isNotNull(APP_NAME))
            {
                url.append(StringPool.QUESTION);
                url.append(APP_NAME_FIELD);
                url.append(StringPool.EQUAL);
                url.append(URLEncoder.encode(new String(Base64.encodeBase64(APP_NAME.getBytes(StringPool.UTF8))),
                        StringPool.UTF8));
            }
            if (Validator.isNotNull(requestId))
            {
                url.append(StringPool.AMPERSAND);
                url.append(REQUEST_ID_FIELD);
                url.append(StringPool.EQUAL);
                url.append(URLEncoder.encode(
                        new String(Base64.encodeBase64((requestId + StringPool.BLANK).getBytes(StringPool.UTF8))), StringPool.UTF8));
            }
            if (supervisorId > 0 || managerId > 0 || Validator.isNotNull(eprocurementRequest.getNextStage()))
            {
                String nextStage = eprocurementRequest.getNextStage();
                if (Validator.isNull(nextStage))
                {
                    supervisorId = supervisorId > 0 ? supervisorId : managerId;
                    nextStage = String.valueOf(supervisorId);
                }
                url.append(StringPool.AMPERSAND);
                url.append(USER_NAME_FIELD);
                url.append(StringPool.EQUAL);
                url.append(URLEncoder.encode(new String(Base64.encodeBase64(nextStage.getBytes(StringPool.UTF8))),
                        StringPool.UTF8));
            }
        } catch (UnsupportedEncodingException usee)
        {
            LOGGER.error("Exception occurred while making page url", usee);
        }
        LOGGER.info("E Procurement mail url :- " + url.toString());
        return url.toString();
    }

    public static String getRequestTrackerHref(EprocurementRequest eprocurementRequest)
    {
        StringBuilder hrefBuilder = new StringBuilder();
        String eProcumenentRequestMailLink = getReqTrackerPageURL(eprocurementRequest);
        boolean isUserGroupUser = isApproverUserHasValidRole(eprocurementRequest);
        if (!isUserGroupUser)
        {
            return hrefBuilder.toString();
        }
       
        if (Validator.isNull(eProcumenentRequestMailLink))
        {
            return hrefBuilder.toString();
        }
        hrefBuilder.append(TEMPLATE_LINE1);
        hrefBuilder.append(HREF_TEMPLATE.replaceAll("REQUEST_TRACKER_URL", eProcumenentRequestMailLink));
        LOGGER.error("Request Tracker Link--" + hrefBuilder.toString());
        return hrefBuilder.toString();
    }

    public static boolean isApproverUserHasValidRole(EprocurementRequest eprocurementRequest)
    {
        long userId = 0;
        long supervisorId = eprocurementRequest.getSupervisorId();
        long managerId = eprocurementRequest.getProjectOwnerId();
        if (supervisorId > 0 || managerId > 0)
        {
            userId = supervisorId > 0 ? supervisorId : managerId;
        }
        String requestTrackerRoleName = PortletProps.get(REQUEST_TRACKER_ROLE);
        try
        {
            User user = UserLocalServiceUtil.getUser(userId);
            List<Role> userRoles = user.getRoles();
            if (userRoles != null)
            {
                for (Role role : userRoles)
                {
                    if (Validator.equals(requestTrackerRoleName, role.getName()))
                    {
                        return true;
                    }
                }
            }
        } catch (SystemException se)
        {
            LOGGER.info("Doesn't have - " + se.getMessage());
        } catch (PortalException se)
        {
            LOGGER.info("Doesn't have - " + se.getMessage());
        }
        return false;

    }

    public static EProcurementProcessInfo loadEProcurementData(EProcurementProcessInfo eprocurementProcessInfo)
    {
        try
        {
            EprocurementRequest eprocRequest = EprocurementRequestLocalServiceUtil
                    .getEprocurementRequest(eprocurementProcessInfo.getRequestId());
            long supervisorId = eprocRequest.getSupervisorId() > 0 ? eprocRequest.getSupervisorId() : eprocRequest
                    .getProjectOwnerId();
            eprocurementProcessInfo.setCompanyId(eprocRequest.getCompanyId());
            eprocurementProcessInfo.setGroupId(eprocRequest.getGroupId());
            eprocurementProcessInfo.setRequestorId(eprocRequest.getRequestorId());
            eprocurementProcessInfo.setApproverId(supervisorId);
            eprocurementProcessInfo.setUserId(supervisorId);
        } catch (PortalException e)
        {
            LOGGER.error("Exception occurred while creating obj EprocurementProcessInfo", e);
        } catch (SystemException e)
        {
            LOGGER.error("Exception occurred while creating obj EprocurementProcessInfo", e);
        }
        return eprocurementProcessInfo;

    }

    public static EProcurementProcessInfo loadEprocurementHiddenUserInfo(ThemeDisplay themeDisplay,
            EprocurementRequest eprocuRequest, List<DynamicElement> dynamicElementList)
    {

        try
        {
            String redirectURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
            String dashBoardURL = EProcurementUtil.createSendRedirectURL(themeDisplay,
                    EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
            String viewRequestUrl = EProcurementUtil.createEditRequestURL(redirectURL, eprocuRequest.getRequestId());
            dynamicElementList.add(new DynamicElement(XML_HIDDEN_FIELD_DASHBOARD_URL, dashBoardURL));
            dynamicElementList.add(new DynamicElement(XML_HIDDEN_FIELD_VIEW_REQUEST_URL, viewRequestUrl));

        } catch (Exception e)
        {
            LOGGER.error("Exception occurred while creating obj EprocurementProcessInfo", e);
        }

        return null;

    }

    public static void sendEmailByInitialApprover(String viewRequestUrl, EprocurementRequest eprocRequest)
    {

        LOGGER.info("Inside sendEmailByInitialApprover()..");
        String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
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
            if (eprocRequest != null)
            {
                long userId = eprocRequest.getRequestorId();
                requestId = eprocRequest.getRequestId();
                User user = UserLocalServiceUtil.getUser(userId);
                toName = user.getFirstName() + StringPool.BLANK + user.getLastName();
                toAddress = user.getEmailAddress();
                emailSubject = emailSubject.concat(String.valueOf(requestId));

                body = StringUtil.replace(body, new String[] { "[$requestId]", "[$viewRequest]" }, new String[] {
                        String.valueOf(requestId), viewRequestUrl });

            }

            InternetAddress from = new InternetAddress(fromEmailAddress);
            InternetAddress to = new InternetAddress(toAddress, toName);
            MailMessage message = new MailMessage(from, to, emailSubject, body, true);
            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
                LOGGER.info("Mail sent to requester as request is approved by initial approver...");
            }
        } catch (Exception e)
        {
            LOGGER.error("Problem while sending email..." + e.getMessage());
        }

    }

    public static void sendNotificationForCanceledRequest(String viewRequestUrl, EprocurementRequest eprocRequest,
            long approverId, String comments)
    {

        try
        {
            String body = StringPool.BLANK;
            String fromName = StringPool.BLANK;
            String fromEmailAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
            long requestorId = eprocRequest.getRequestorId();

            String toName = EProcurementUtil.getUserName(requestorId);
            String toEmailAddress = EProcurementUtil.getUserEmailAddress(requestorId);
            ClassLoader classLoader = EprocurementEmailUtility.class.getClassLoader();
            String emailSubject = EProcurementConstants.EPROC_CANCELLED_REQUEST_SUBJECT;
            emailSubject = emailSubject.concat(String.valueOf(eprocRequest.getRequestId()));

            fromName = UserLocalServiceUtil.getUser(approverId).getFullName();
            if (StringPool.BLANK.equals(comments))
            {
                comments = EProcurementConstants.NOT_AVAILABLE;
            }

            try
            {
                body = StringUtil.read(classLoader, EProcurementConstants.EPROC_CANCELLED_REQUEST_BODY_TEMPLATE, true);
                body = StringUtil.replace(body, new String[] { "[$requestId]", "[$fromName]", "[$comments]",
                        "[$viewRequest]" }, new String[] { String.valueOf(eprocRequest.getRequestId()), fromName,
                        comments, viewRequestUrl });
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
     * Method to construct Request Tracker URL for Stage Approvers
     * 
     * @param eprocurementRequest
     * @param stageApproverId
     * @return
     */
    public static String getRequestTrackerHrefForStageApprover(EprocurementRequest eprocurementRequest,long stageApproverId)
    {
        StringBuilder hrefBuilder = new StringBuilder();
        String eProcumenentRequestMailLink = getReqTrackerPageURL(eprocurementRequest);
        boolean isUserGroupUser = isStageApproverHasValidRole(eprocurementRequest,stageApproverId);
        if (!isUserGroupUser)
        {
            return hrefBuilder.toString();
        }
       
        if (Validator.isNull(eProcumenentRequestMailLink))
        {
            return hrefBuilder.toString();
        }
        hrefBuilder.append(TEMPLATE_LINE1);
        hrefBuilder.append(HREF_TEMPLATE.replaceAll("REQUEST_TRACKER_URL", eProcumenentRequestMailLink));
        return hrefBuilder.toString();
    }


    
    /**
     * Method to check role for Stage Approver
     * @param eprocurementRequest
     * @param stageApproverId
     * @return
     */
    public static boolean isStageApproverHasValidRole(EprocurementRequest eprocurementRequest, long stageApproverId)
    {
        boolean hasValidRole = false;
        String requestTrackerRoleName = PortletProps.get(REQUEST_TRACKER_ROLE);
        try
        {
            hasValidRole = RoleLocalServiceUtil.hasUserRole(stageApproverId, eprocurementRequest.getCompanyId(), requestTrackerRoleName, false);
        } catch (SystemException se)
        {
            LOGGER.info("Doesn't have - " + se.getMessage());
        } catch (PortalException se)
        {
            LOGGER.info("Doesn't have - " + se.getMessage());
        }
        return hasValidRole;

    }
    
 public static void updateRequestApproval(long eproRequestRequestId , String status , String comment){
        
        String requestId = String.valueOf(eproRequestRequestId);
        RequestApproval requestApproval = getRequestApproval(requestId);
        if(Validator.isNotNull(requestApproval)){
            
            requestApproval.setAppName(APP_NAME);
            requestApproval.setRequestId(requestId);
            requestApproval.setStatus(status);
            requestApproval.setComments(comment);
            try
            {
                RequestApprovalLocalServiceUtil.updateRequestApproval(requestApproval);
            } catch (SystemException e)
            {
               LOGGER.error(e.getMessage());
            }
            
        }else{
            createRequestApproval(requestId, status, comment);
        }
        
    }
 
    public static RequestApproval getRequestApproval(String eproRequestRequestId)
    {

        RequestApproval requestApproval = null;
        try
        {
            requestApproval = RequestApprovalLocalServiceUtil.findByAppNameAndRequestId(APP_NAME, eproRequestRequestId);
        } catch (NoSuchRequestApprovalException e)
        {
            LOGGER.error(e.getMessage());
        } catch (SystemException e)
        {
            LOGGER.error(e.getMessage());
        }
        return requestApproval;

    }
    
    public static void createRequestApproval(String eprocRequestId , String status , String comment){
        try
        {
            long requestApprovalId = CounterLocalServiceUtil.increment(RequestApproval.class.getName());
            RequestApproval requestApproval = RequestApprovalLocalServiceUtil.createRequestApproval(requestApprovalId);
            requestApproval.setAppName(APP_NAME);
            requestApproval.setRequestId(String.valueOf(eprocRequestId));
            requestApproval.setStatus(status);
            requestApproval.setComments(comment);
            RequestApprovalLocalServiceUtil.addRequestApproval(requestApproval);
        } catch (SystemException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
