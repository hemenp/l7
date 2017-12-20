package com.dsi.intranet.eprocurement.portlet.controller.request;

import com.dsi.intranet.common.services.api.IntranetCommonService;
import com.dsi.intranet.eprocurement.model.EprocurementLocation;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.model.RequestAttachment;
import com.dsi.intranet.eprocurement.model.WorkflowDefinition;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl;
import com.dsi.intranet.eprocurement.model.impl.ItemImpl;
import com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementRequestTrackerWSUtil;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementCommonUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementEmailUtility;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowProgressUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.RequestAttachmentLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.exception.DuplicateFileException;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("purchaseRequestController")
@RequestMapping(value = "VIEW")
public class PurchaseRequestController
{

    private static final Log _log = LogFactoryUtil.getLog(PurchaseRequestController.class);
    

    /**
     * This method is to save the items and a request
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @return dash board page
     */
   @ActionMapping(params = "eProcAction=saveRequest")
   public void createPurchaseRequest(ActionRequest actionRequest, ActionResponse actionResponse)
           throws SystemException, PortalException, IOException
   {

       ClassLoader classLoader = PurchaseRequestController.class.getClassLoader();
       UploadPortletRequest request = PortalUtil.getUploadPortletRequest(actionRequest);
       String status = EProcurementConstants.STATUS_NEW;
       ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
       java.util.Date currentDate = new java.util.Date();
       String cmd = ParamUtil.getString(request, "action");
       long userId = ParamUtil.getLong(request, EProcurementConstants.REQUESTOR_ID);
       String fromAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
       String fromAdmin = EProcurementConstants.EPROC_EMAIL_FROM_NAME;
       String projectOwnerEmail = StringPool.BLANK;
       String supervisorEmail = StringPool.BLANK;
       String projectOwnerName = StringPool.BLANK;
       String supervisorName = StringPool.BLANK;
       String fromName = ParamUtil.getString(request, "requestorName");
       long projectOwnerId = ParamUtil.getLong(request, "projectManagerId");
       long supervisorId = ParamUtil.getLong(request, "supervisorId");
       User projectOwner = null;
       long requestId = 0;
       String contractId = StringPool.BLANK;
       String purchaseOrder = StringPool.BLANK;
       String shipTo = ParamUtil.getString(request, "shipTo");
       String shipToOther = "No";
       String address = StringPool.BLANK;
       String city = StringPool.BLANK;
       String state = StringPool.BLANK;
       String zip = StringPool.BLANK;
       String viewRequestUrl = StringPool.BLANK;
       String subject = StringPool.BLANK;
       String body = StringPool.BLANK;
       
       boolean hasProjectSpendRole = EProcurementUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), EProcurementConstants.EPROCUREMENT_ROLE_PROJECT_SPEND, false);
       String spendDepartmentValue = StringPool.BLANK;
       String spendYearValue = StringPool.BLANK;
       if(hasProjectSpendRole){
     		 spendDepartmentValue = ParamUtil.getString(request, "spendDepartment");
     		 spendYearValue = ParamUtil.getString(request, "spendYear");
        }
       
       try
       {
           // Read subject from template
           subject = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_SUBJECT_TEMPLATE, true);

           // Read body from template
           body = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_BODY_TEMPLATE, true);
       } catch (IOException io)
       {
           _log.error("Error in reading email templates" + io.getMessage(), io);
       }
       if (shipTo.equalsIgnoreCase(EProcurementConstants.SHIP_TO_OTHER_PARAM))
       {
           shipToOther = EProcurementConstants.SHIP_TO_OTHER_VALUE;
           address = ParamUtil.getString(request, "address");
           city = ParamUtil.getString(request, "city");
           state = ParamUtil.getString(request, "state");
           zip = ParamUtil.getString(request, "zip");

       }
       String budgetedRequest = ParamUtil.getString(request, "budgetedRequest");
       String projectName = ParamUtil.getString(request, "projectName");
       String relatedProject = ParamUtil.getString(request, "relatedProject");
       String cost = ParamUtil.getString(request, "totalCost");
       String originalCost = ParamUtil.getString(request, "totalOriginalCost");
       double totalCost = Double.parseDouble(cost);
       double originalTotalCost = Double.parseDouble(originalCost);
       String reason = ParamUtil.getString(request, "reason");
       String notes = ParamUtil.getString(request, "notes");
       String vendorCode = ParamUtil.getString(request, "vendorCode");
       String vendorEmail = ParamUtil.getString(request, "vendorEmail");
       contractId = ParamUtil.getString(request, "contractId");
       purchaseOrder = ParamUtil.getString(request, "purchaseOrder");
       String requestString = ParamUtil.getString(request, "itemRequestString");
       String dashBoardUrl = EProcurementUtil.createSendRedirectURL(themeDisplay,
               EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
       String purchaseRequestUrl = EProcurementUtil.createSendRedirectURL(themeDisplay,
               EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);

       String successMessage = StringPool.BLANK;
       String errorMessage = StringPool.BLANK;
       if (relatedProject.equalsIgnoreCase("Yes"))
       {
           if (Validator.isNotNull(projectOwnerId))
           {
               projectOwner = UserLocalServiceUtil.getUserById(projectOwnerId);
           }
           if (Validator.isNotNull(projectOwner))
           {
               projectOwnerEmail = projectOwner.getEmailAddress();
               projectOwnerName = projectOwner.getFullName();
           }
       } else
       {
           supervisorEmail = ParamUtil.getString(request, "supervisorEmail");
           supervisorName = ParamUtil.getString(request, "supervisorName");
       }
       Item item = null;
       item = new ItemImpl();
       String[] rows = StringUtil.split(requestString, "~~~"); // items
       EprocurementRequest eprocuRequest = null;
       eprocuRequest = new EprocurementRequestImpl();
       eprocuRequest.setRequestorId(userId);
       if (shipTo.equalsIgnoreCase(EProcurementConstants.SHIP_TO_OTHER_PARAM))
       {
           eprocuRequest.setAddress(address);
           eprocuRequest.setCity(city);
           eprocuRequest.setState(state);
           eprocuRequest.setZip(zip);
       } else
       {
           eprocuRequest.setAddress(shipTo);
       }
       eprocuRequest.setShipToOther(shipToOther);
       eprocuRequest.setSpendDepartment(spendDepartmentValue);
       eprocuRequest.setSpendYear(spendYearValue);
       eprocuRequest.setIsBudgetedRequest(budgetedRequest);
       eprocuRequest.setProjectName(projectName);
       eprocuRequest.setIsRelatedtoProject(relatedProject);
       if (Validator.isNotNull(projectOwnerId))
       {
           eprocuRequest.setProjectOwnerId(projectOwnerId);
       }
       eprocuRequest.setTotalCost(totalCost);
       eprocuRequest.setOriginalCost(originalTotalCost);
       eprocuRequest.setReason(reason);
       eprocuRequest.setNotes(notes);
       eprocuRequest.setVendorCode(vendorCode);
       eprocuRequest.setVendorEmail(vendorEmail);
       eprocuRequest.setContractId(contractId);
       eprocuRequest.setPurchaseOrder(purchaseOrder);
       if (Validator.isNotNull(supervisorId))
       {
           eprocuRequest.setSupervisorId(supervisorId);
       }
       eprocuRequest.setModifiedBy(userId);
       eprocuRequest.setModifiedDate(currentDate);

       // create new purchase request
       if (cmd.equalsIgnoreCase("ADD"))
       {
           try
           {
               requestId = CounterLocalServiceUtil.increment(EprocurementRequest.class.getName());
               eprocuRequest.setItemInStock(false);
               eprocuRequest.setRecievedDate(null);
               eprocuRequest.setReturnedDate(null);
               eprocuRequest.setAssetInfo(StringPool.BLANK);
               eprocuRequest.setReturnedAssets(StringPool.BLANK);
               eprocuRequest.setStage(StringPool.BLANK);
               if (Validator.isNotNull(projectOwnerName))
               {
                   eprocuRequest.setNextStage(String.valueOf(projectOwnerId));
               } else if (Validator.isNotNull(supervisorName))
               {
                   eprocuRequest.setNextStage(String.valueOf(supervisorId));
               }
               eprocuRequest.setStatus(status);
               eprocuRequest.setRequestId(requestId);
               eprocuRequest.setCreatedBy(userId);
               eprocuRequest.setCreatedDate(currentDate);
               eprocuRequest.setModifiedBy(userId);
               eprocuRequest.setModifiedDate(currentDate);
               eprocuRequest.setCompanyId(themeDisplay.getCompanyId());
               eprocuRequest.setGroupId(themeDisplay.getScopeGroupId());

               // multiple file upload
               File tempFile;
               Map<String, File> fileMap = new LinkedHashMap<String, File>();
               Enumeration<String> paramEnum = request.getParameterNames();
               while (paramEnum.hasMoreElements())
               {
                   String parameter = paramEnum.nextElement();
                   if (parameter.startsWith("uploadFile"))
                   {

                       tempFile = request.getFile(parameter);
                       try
                       {
                           tempFile = renameFileName(tempFile, request, parameter);

                       } catch (Exception e)
                       {
                           _log.error("error in renaming file " + e.getMessage(), e);
                       }

                       if (tempFile != null)
                       {
                           fileMap.put(parameter, tempFile);
                       }
                   }
               }
               if (Validator.isNotNull(fileMap))
               {
                   for (Map.Entry<String, File> entry : fileMap.entrySet())
                   {
                       try
                       {
                           singleFileUpload(actionRequest, actionResponse, requestId, entry.getValue());
                       } catch (PortalException e)
                       {
                           _log.error("error in adding attachment " + e.getMessage(), e);
                       } catch (SystemException e)
                       {
                           _log.error("error in file attachment " + e.getMessage(), e);
                       }

                   }
               }

               EprocurementRequestLocalServiceUtil.addEprocurementRequest(eprocuRequest, rows);

               // insert code for item
               for (String row : rows)
               {
                   String[] columns = StringUtil.split(row, "^^^");
                   item = itemObjFromRequest(requestId, columns);
                   item.setCreatedBy(userId);
                   item.setCreatedDate(currentDate);
                   item.setModifiedBy(userId);
                   item.setModifiedDate(currentDate);
                   item.setCompanyId(themeDisplay.getCompanyId());
                   item.setGroupId(themeDisplay.getScopeGroupId());
                   if (Validator.isNotNull(item))
                   {
                       try
                       {
                           ItemLocalServiceUtil.addItem(item);
					   } catch (SystemException e)
                       {
                           _log.error("Error while adding items : " + e.getMessage(), e);
                       }
                   } // end of adding items
               } // end of for loop

               // sending email notification to project owner and supervisor

               EProcurementRequestTrackerWSUtil.addEntryInRequestTracker(eprocuRequest, themeDisplay);

               viewRequestUrl = EProcurementUtil.viewRequestURL(actionRequest, themeDisplay,
                       EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
              
               String purchaseRequestId = String.valueOf(requestId);
               subject = StringUtil.replace(subject, new String[] { EProcurementConstants.REQUESTID_VAR },
                       new String[] { purchaseRequestId });

                body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTNAME_VAR, EProcurementConstants.VIEWREQUEST_VAR,
                        "[$REQUEST_TRACKER_URL]" }, new String[] { fromName, viewRequestUrl,
                        EProcurementRequestTrackerWSUtil.getRequestTrackerHref(eprocuRequest) });
               if (Validator.isNotNull(supervisorName))
               {
                   try
                   {
                       EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, supervisorName, supervisorEmail,
                               subject, body);
                   } catch (Exception e)
                   {
                       _log.error("Error in emailnotification" + e.getMessage(), e);
                   }
               }
               if (Validator.isNotNull(projectOwnerName))
               {
                   try
                   {
                       EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, projectOwnerName, projectOwnerEmail,
                               subject, body);
                   } catch (Exception e)
                   {
                       _log.error("Error in emailnotification" + e.getMessage(), e);
                   }
                   // end of email notification
               }
               successMessage = "Purchase Request has been created successfully";

           } catch (PortalException e)
           {
               errorMessage = "Error while creating purchase request";
               _log.error("Error while adding request : " + e.getMessage(), e);
           } catch (SystemException e)
           {
               errorMessage = "Error while creating purchase request";
               _log.error("Error while adding request : " + e.getMessage(), e);
           }
       }

       Map<String, String> requestParam = new HashMap<String, String>();
       if (Validator.isNotNull(successMessage))
       {
           requestParam.put("successMsg", successMessage);
           dashBoardUrl = EProcurementUtil.appendQueryParams(dashBoardUrl, requestParam);
           actionResponse.sendRedirect(dashBoardUrl);
       }
       if (Validator.isNotNull(errorMessage))
       {
           requestParam.put("errorMsg", errorMessage);
           purchaseRequestUrl = EProcurementUtil.appendQueryParams(purchaseRequestUrl, requestParam);
           actionResponse.sendRedirect(purchaseRequestUrl);
       }
   }


    /**
     * This method is to edit a Request
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @throws IOException 
     * @throws SystemException 
     */
    @ActionMapping(params = "eProcAction=editRequest")
    public void editRequest(ActionRequest actionRequest, ActionResponse actionResponse)  
    {
        UploadPortletRequest request = PortalUtil.getUploadPortletRequest(actionRequest);
        String showEmailRequester = ParamUtil.getString(request,"showEmailRequester");
        
        if("TRUE".equals(showEmailRequester)){
            updateEprocRequest(actionRequest ,actionResponse,request, false);
            actionResponse.setRenderParameter("showEmailRequester", "true");
            actionResponse.setRenderParameter(EProcurementConstants.REQUEST_ID, ParamUtil.getString(request, EProcurementConstants.REQUEST_ID));
            actionResponse.setRenderParameter(EProcurementConstants.REQUESTOR_ID,ParamUtil.getString(request, EProcurementConstants.REQUESTOR_ID));

        }else{
            
            updateEprocRequest(actionRequest ,actionResponse,request, true);
        }

    }
    
    
    
    
    public static void updateEprocRequest(ActionRequest actionRequest , ActionResponse actionResponse ,UploadPortletRequest request, boolean showEmailReqFlag){
        
        ClassLoader classLoader = PurchaseRequestController.class.getClassLoader();
        String contractId = StringPool.BLANK;
        String purchaseOrder = StringPool.BLANK;
        String fromAddress = EProcurementConstants.EPROC_EMAIL_FROM_ADDRESS;
        String fromAdmin = EProcurementConstants.EPROC_EMAIL_FROM_NAME;
        String projectOwnerEmail = StringPool.BLANK;
        String supervisorEmail = StringPool.BLANK;
        long previousSupervisorId = 0;
        String status = EProcurementConstants.STATUS_NEW;
        User user = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("THEME_DISPLAY");
        java.util.Date currentDate = new java.util.Date();
        long requestId = 0;
        String cmd = ParamUtil.getString(request, "action");
        long userId = ParamUtil.getLong(request, EProcurementConstants.REQUESTOR_ID);
        long projectOwnerId = ParamUtil.getLong(request, "projectManagerId");
        long supervisorId = ParamUtil.getLong(request, "supervisorId");
        long previousProjectOwnerId = 0;
        User projectOwner = null;
        String projectOwnerName = StringPool.BLANK;
        String supervisorName = StringPool.BLANK;
        String successMessage = StringPool.BLANK;
        String errorMessage = StringPool.BLANK;
        String shipTo = ParamUtil.getString(request, "shipTo");
        String shipToOther = "No";
        String address = StringPool.BLANK;
        String city = StringPool.BLANK;
        String state = StringPool.BLANK;
        String zip = StringPool.BLANK;
        String viewRequestUrl = StringPool.BLANK;
        String subject = StringPool.BLANK;
        String body = StringPool.BLANK;
        String fromName = ParamUtil.getString(request, "requestorName");
        try
        {
            // Read subject from template
            subject = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_SUBJECT_TEMPLATE, true);

            // Read body from template
            body = StringUtil.read(classLoader, EProcurementConstants.EMAIL_NOTIFICATION_BODY_TEMPLATE, true);
        } catch (IOException io)
        {
            _log.error("Error in reading email templates" + io.getMessage(), io);
        }
        
        boolean hasProjectSpendRole = EProcurementUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), EProcurementConstants.EPROCUREMENT_ROLE_PROJECT_SPEND, false);
        String spendDepartmentValue = StringPool.BLANK;
        String spendYearValue = StringPool.BLANK;
        if(hasProjectSpendRole){
        	spendDepartmentValue = ParamUtil.getString(request, "spendDepartment");
    		spendYearValue = ParamUtil.getString(request, "spendYear");
        }
        
        if (shipTo.equalsIgnoreCase(EProcurementConstants.SHIP_TO_OTHER_PARAM))
        {
            shipToOther = EProcurementConstants.SHIP_TO_OTHER_VALUE;
            address = ParamUtil.getString(request, "address");
            city = ParamUtil.getString(request, "city");
            state = ParamUtil.getString(request, "state");
            zip = ParamUtil.getString(request, "zip");

        }
        String budgetedRequest = ParamUtil.getString(request, "budgetedRequest");
        String projectName = ParamUtil.getString(request, "projectName");
        String relatedProject = ParamUtil.getString(request, "relatedProject");
        String cost = ParamUtil.getString(request, "totalCost");
        double totalCost = Double.parseDouble(cost);
        String orgCost = ParamUtil.getString(request, "totalOriginalCost");
        double orgTotalCost = Double.parseDouble(orgCost);
        String reason = ParamUtil.getString(request, "reason");
        String notes = ParamUtil.getString(request, "notes");
        String vendorCode = ParamUtil.getString(request, "vendorCode");
        String vendorEmail = ParamUtil.getString(request, "vendorEmail");
        contractId = ParamUtil.getString(request, "contractId");
        purchaseOrder = ParamUtil.getString(request, "purchaseOrder");
        String requestString = ParamUtil.getString(request, "itemRequestString");
        String deletedItemIds = ParamUtil.getString(request, "deletedItems");
        String edittedItemIds = ParamUtil.getString(request, "edittedItems");
        String editItemValues = ParamUtil.getString(request, "editItemValues");
        String dashBoardUrl = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DASHBOARD);
        String purchaseRequestUrl = EProcurementUtil.createSendRedirectURL(themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, EProcurementConstants.FRIENDLY_URL_REQUEST_DETAILS);
        if (relatedProject.equalsIgnoreCase("Yes"))
        {
            if (Validator.isNotNull(projectOwnerId))
            {
                try
                {
                    projectOwner = UserLocalServiceUtil.getUserById(projectOwnerId);
                } catch (PortalException pe)
                {
                    _log.error("Error while projectOwner " + pe.getMessage(), pe);
                } catch (SystemException e)
                {
                    _log.error(e.getMessage(),e);
                }
            }
            if (Validator.isNotNull(projectOwner))
            {
                projectOwnerEmail = projectOwner.getEmailAddress();
                projectOwnerName = projectOwner.getFullName();
            }
        } else
        {
            supervisorEmail = ParamUtil.getString(request, "supervisorEmail");
            supervisorName = ParamUtil.getString(request, "supervisorName");
        }

        Item item = null;
        item = new ItemImpl();
        String[] rows = StringUtil.split(requestString, "~~~"); // items

        if (cmd.equalsIgnoreCase("UPDATE")) // updating a request
        {
            requestId = ParamUtil.getLong(request, EProcurementConstants.REQUEST_ID);
            EprocurementRequest eprocuUpdate = null;
            // insert code for item
            for (String row : rows)
            {
                String[] columns = StringUtil.split(row, "^^^");
                try
                {
                    item = itemObjFromRequest(requestId, columns);
                } catch (PortalException pe)
                {
                    _log.error("Error while getting Item from column values " + pe.getMessage(), pe);
                } catch (SystemException se)
                {
                    _log.error("Error while getting Item from column values " + se.getMessage(), se);
                }
                item.setCreatedBy(userId);
                item.setCreatedDate(currentDate);
                item.setModifiedBy(userId);
                item.setModifiedDate(currentDate);
                item.setCompanyId(themeDisplay.getCompanyId());
                item.setGroupId(themeDisplay.getScopeGroupId());
                item.setItemInStock(false);
                item.setVendorCode(vendorCode);
                item.setPurchaseOrder(purchaseOrder);
                item.setRecievedDate(null);
                item.setReturnedDate(null);
                item.setAssetInfo(StringPool.BLANK);
                item.setReturnedAssets(StringPool.BLANK);
                if (Validator.isNotNull(item))
                {
                    try
                    {
                        ItemLocalServiceUtil.addItem(item);
                    } catch (SystemException e)
                    {
                        _log.error("Error while adding items : " + e.getMessage(), e);
                    }
                }
            } // end of adding items
            
            //Delete items
            if (Validator.isNotNull(deletedItemIds))
            {
                try
                {
                    deleteItems(deletedItemIds);
                } catch (PortalException e)
                {
                    _log.error("Error while deleting Item from a request" + e.getMessage(), e);
                } catch (SystemException e)
                {
                    _log.error(e.getMessage(),e);
                }
            }
            
            //Update items
            if (Validator.isNotNull(edittedItemIds) && Validator.isNotNull(editItemValues))
            {
                String[] itemRows = StringUtil.split(editItemValues, "~~~");
                for (String row : itemRows)
                {
                    String[] itemColumns = StringUtil.split(row, "^^^");
                    long itemId = Long.parseLong(itemColumns[8]);
                    try{
                        item = ItemLocalServiceUtil.getItem(itemId);
                    }catch(Exception e){
                        continue;
                    }
                    try
                    {
                        editItems(requestId, itemColumns, userId);
                    } catch (PortalException e)
                    {
                        _log.error("Error while updating Item for a request" + e.getMessage(), e);
                    } catch (SystemException e)
                    {
                        _log.error(e.getMessage(),e);
                    }
                }
            }
            
            File tempFile;
            Map<String, File> fileMap = new LinkedHashMap<String, File>();
            Enumeration<String> paramEnum = request.getParameterNames();
            while (paramEnum.hasMoreElements())
            {
                String parameter = paramEnum.nextElement();
                if (parameter.startsWith("uploadFile"))
                {
                    tempFile = request.getFile(parameter);
                    try
                    {
                        tempFile = renameFileName(tempFile, request, parameter);
                    } catch (Exception e)
                    {
                        _log.error("Error while renaming details for a request" + e.getMessage(), e);
                    }

                    if (tempFile != null)
                    {
                        fileMap.put(parameter, tempFile);
                    }
                }
            }
            if (Validator.isNotNull(fileMap))
            {
                for (Map.Entry<String, File> entry : fileMap.entrySet())
                {
                    try
                    {
                        singleFileUpload(actionRequest, actionResponse, requestId, entry.getValue());
                    } catch (PortalException e)
                    {
                        _log.error("error in adding attachment " + e.getMessage(), e);
                    } catch (SystemException e)
                    {
                        _log.error("error in file attachment " + e.getMessage(), e);
                    }

                }
            }
            try
            {
                eprocuUpdate = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                previousSupervisorId = eprocuUpdate.getSupervisorId();
                previousProjectOwnerId = eprocuUpdate.getProjectOwnerId();

            } catch (SystemException e)
            {
                _log.error("Error while getting request details for a request" + e.getMessage(), e);
            } catch (PortalException e)
            {
                _log.error("Error while getting request details for a request" + e.getMessage(), e);
            }

            eprocuUpdate.setModifiedBy(userId);
            eprocuUpdate.setModifiedDate(currentDate);
            eprocuUpdate.setCompanyId(eprocuUpdate.getCompanyId());
            eprocuUpdate.setGroupId(eprocuUpdate.getGroupId());
            eprocuUpdate.setCreatedBy(eprocuUpdate.getCreatedBy());
            eprocuUpdate.setCreatedDate(eprocuUpdate.getCreatedDate());
            eprocuUpdate.setStatus(eprocuUpdate.getStatus());
            if(status.equalsIgnoreCase(eprocuUpdate.getStatus())){
            if (Validator.isNotNull(projectOwnerName))
            {
                eprocuUpdate.setNextStage(String.valueOf(projectOwnerId));
            } else if (Validator.isNotNull(supervisorName))
            {
                eprocuUpdate.setNextStage(String.valueOf(supervisorId));
            }
            } else {
                eprocuUpdate.setNextStage(eprocuUpdate.getNextStage());
            }
            eprocuUpdate.setRequestorId(userId);
            if (shipTo.equalsIgnoreCase(EProcurementConstants.SHIP_TO_OTHER_PARAM))
            {
                eprocuUpdate.setAddress(address);
                eprocuUpdate.setCity(city);
                eprocuUpdate.setState(state);
                eprocuUpdate.setZip(zip);
            } else
            {
                eprocuUpdate.setAddress(shipTo);
            }
            eprocuUpdate.setShipToOther(shipToOther);
            eprocuUpdate.setSpendDepartment(spendDepartmentValue);
            eprocuUpdate.setSpendYear(spendYearValue);
            eprocuUpdate.setIsBudgetedRequest(budgetedRequest);
            eprocuUpdate.setProjectName(projectName);
            eprocuUpdate.setIsRelatedtoProject(relatedProject);
            if (Validator.isNotNull(projectOwnerId))
            {
                eprocuUpdate.setProjectOwnerId(projectOwnerId);
            }
            eprocuUpdate.setTotalCost(totalCost);
            eprocuUpdate.setOriginalCost(orgTotalCost);
            eprocuUpdate.setReason(reason);
            eprocuUpdate.setNotes(notes);
            eprocuUpdate.setVendorCode(vendorCode);
            eprocuUpdate.setVendorEmail(vendorEmail);
            eprocuUpdate.setContractId(contractId);
            eprocuUpdate.setPurchaseOrder(purchaseOrder);
            if (Validator.isNotNull(supervisorId))
            {
                eprocuUpdate.setSupervisorId(supervisorId);
            }

            try
            {
                EprocurementRequestLocalServiceUtil.updateEprocurementRequest(eprocuUpdate);
				EProcurementRequestTrackerWSUtil.addEntryInRequestTracker(eprocuUpdate, themeDisplay);
                successMessage = "Purchase Request has been updated successfully";

            } catch (Exception e)
            {
                errorMessage = "Error while updating purchase request";
                _log.error("Error while updating request : " + e.getMessage(), e);
            }
            
            if (Validator.isNotNull(supervisorName))
            {
                if (supervisorId != previousSupervisorId)
                {

                    // sending email notification to supervisor
                    viewRequestUrl = EProcurementUtil.viewRequestURL(actionRequest, themeDisplay,
                            EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
                    String purchaseRequestId = String.valueOf(requestId);

                    subject = StringUtil.replace(subject, new String[] {EProcurementConstants.REQUESTID_VAR},
                            new String[] { purchaseRequestId });
                    // Read body from template
                    String newbody = StringPool.BLANK;
                    try
                    {
                        newbody = StringUtil.read(classLoader,
                                EProcurementConstants.CHANGE_REQUEST_FOR_PREV_APPROVER_BODY_TEMPLATE, true);
                    } catch (IOException e1)
                    {
                        _log.error(e1.getMessage(),e1);
                    }
                    
                    /*
                     * DSI Start : Modified to fix Request Tracker URL issue on change supervisor scenario
                     */
                    body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTNAME_VAR, EProcurementConstants.VIEWREQUEST_VAR ,"[$REQUEST_TRACKER_URL]"},
                            new String[] { fromName, viewRequestUrl,EProcurementRequestTrackerWSUtil.getRequestTrackerHref(eprocuUpdate) });

                    /*
                     * DSI End 
                     */
                    newbody = StringUtil.replace(newbody, new String[] { EProcurementConstants.REQUESTNAME_VAR },
                            new String[] { fromName });
                    // sending mail to new approver
                    try
                    {
                        EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, supervisorName, supervisorEmail,
                                subject, body);
                    } catch (Exception e)
                    {
                        _log.error("Error in edit request emailnotification" + e.getMessage(), e);
                    }
                    // mail to previous Supervisor
                    if(Validator.isNotNull(previousSupervisorId)) {
                    try
                    {
                       
                        user = UserLocalServiceUtil.getUserById(previousSupervisorId);
                        String previousSupervisor = user.getFullName();
                        String previousEmail = user.getEmailAddress();
                        EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, previousSupervisor, previousEmail,
                                subject, newbody);
                      

                    } catch (Exception e)
                    {
                        _log.error("Error in edit request emailnotificationto previous supervisor" + e.getMessage(), e);
                    }
                    }
                    /* if someone changes project owner to supervisor */
                    if (Validator.isNotNull(previousProjectOwnerId))
                    {
                        // mail to previous Project Owner
                        try
                        {
                            user = UserLocalServiceUtil.getUserById(previousProjectOwnerId);
                            String previousProjectOwner = user.getFullName();
                            String previousProjectOwnerEmail = user.getEmailAddress();
                            EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, previousProjectOwner,
                                    previousProjectOwnerEmail, subject, newbody);

                        } catch (Exception e)
                        {
                            _log.error(
                                    "Error in edit request emailnotificationto previous project owner" + e.getMessage(),
                                    e);
                        }
                    }

                }
            }
            if (Validator.isNotNull(projectOwnerName))
            {
                if (projectOwnerId != previousProjectOwnerId)
                {

                    // sending email notification to supervisor
                    viewRequestUrl = EProcurementUtil.viewRequestURL(actionRequest, themeDisplay,
                            EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
                    String purchaseRequestId = String.valueOf(requestId);

                    subject = StringUtil.replace(subject, new String[] { EProcurementConstants.REQUESTID_VAR },
                            new String[] { purchaseRequestId });
                    // Read body from template
                    String newbody = null;
                    try
                    {
                        newbody = StringUtil.read(classLoader,
                                EProcurementConstants.CHANGE_REQUEST_FOR_PREV_APPROVER_BODY_TEMPLATE, true);
                    } catch (IOException e1)
                    {
                        _log.error(e1.getMessage(),e1);
                    }
                    
                    /*
                     * DSI Start : Modified to fix Request Tracker URL issue on change supervisor scenario
                     */
                    body = StringUtil.replace(body, new String[] { EProcurementConstants.REQUESTNAME_VAR, EProcurementConstants.VIEWREQUEST_VAR,"[$REQUEST_TRACKER_URL]" },
                            new String[] { fromName, viewRequestUrl,EProcurementRequestTrackerWSUtil.getRequestTrackerHref(eprocuUpdate) });
                    /*
                     * DSI End 
                     */
                    
                    newbody = StringUtil.replace(newbody, new String[] { EProcurementConstants.REQUESTNAME_VAR, EProcurementConstants.VIEWREQUEST_VAR },
                            new String[] { fromName, viewRequestUrl });
                    // sending mail to new approver
                    try
                    {
                        EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, projectOwnerName, projectOwnerEmail,
                                subject, body);
                    } catch (Exception e)
                    {
                        _log.error("Error in edit request emailnotification" + e.getMessage(), e);
                    }
                    // mail to previous Project Owner
                    try
                    {
                        user = UserLocalServiceUtil.getUserById(previousProjectOwnerId);
                        String previousProjectOwner = user.getFullName();
                        String previousProjectOwnerEmail = user.getEmailAddress();
                        EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, previousProjectOwner,
                                previousProjectOwnerEmail, subject, newbody);

                    } catch (Exception e)
                    {
                        _log.error("Error in edit request emailnotificationto previous project owner" + e.getMessage(),
                                e);
                    }/* if someone changes supervisor to project owner */
                    if (Validator.isNotNull(previousSupervisorId))
                    {
                        // mail to previous Supervisor
                        try
                        {
                            user = UserLocalServiceUtil.getUserById(previousSupervisorId);
                            String previousSupervisor = user.getFullName();
                            String previousEmail = user.getEmailAddress();
                            EprocurementCommonUtil.sendEmail(fromAdmin, fromAddress, previousSupervisor, previousEmail,
                                    subject, newbody);

                        } catch (Exception e)
                        {
                            _log.error(
                                    "Error in edit request emailnotificationto previous supervisor" + e.getMessage(), e);
                        }
                    }

                }
            }
        }

       
        Map<String, String> requestParam = new HashMap<String, String>();
        if (Validator.isNotNull(successMessage) && showEmailReqFlag)
        {
            requestParam.put("successMsg", successMessage);
            if(EProcurementUtil.isWebAdmin(themeDisplay.getCompanyId(), themeDisplay.getUserId())){
                
                dashBoardUrl = EProcurementUtil.createEditRequestURL(actionRequest, themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
                dashBoardUrl = EProcurementUtil.appendQueryParams(dashBoardUrl, requestParam);
            }else{
                dashBoardUrl = EProcurementUtil.appendQueryParams(dashBoardUrl, requestParam);
            }
            
            try
            {
                actionResponse.sendRedirect(dashBoardUrl);
            } catch (IOException e)
            {
               _log.error(e.getMessage(),e);
            }
        }
        if (Validator.isNotNull(errorMessage) && showEmailReqFlag)
        {
            requestParam.put("errorMsg", errorMessage);
            purchaseRequestUrl = EProcurementUtil.appendQueryParams(purchaseRequestUrl, requestParam);
            try
            {
                actionResponse.sendRedirect(purchaseRequestUrl);
            } catch (IOException e)
            {
               _log.error(e.getMessage(),e);
            }
            
        }
        
    }

    /**
     * This method is to rename the file to Orginal file Name
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @return Fille 
     */
    private static File renameFileName(File sourceFile, UploadPortletRequest uploadRequest, String paramName) throws Exception
    {
        File destination = null;
        String path = sourceFile.getPath();
        path = path.substring(0, path.lastIndexOf(StringPool.BACK_SLASH) + 1);
        String fileNm = uploadRequest.getFileName(paramName);
        if (Validator.isNotNull(fileNm))
        {

            path = path.concat(fileNm);
            destination = new File(path);
            FileUtil.copyFile(sourceFile, destination);
            FileUtil.delete(sourceFile);
        }
        return destination;
    }

    /**
     * This method is to edit the items
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @return edit request
     */
    @ActionMapping(params = "eProcAction=editItem")
    public void editItem(ActionRequest request, ActionResponse response) throws SystemException, PortalException
    {
        NumberFormat numberFormat = new DecimalFormat("0.00");
        
        long requestId = ParamUtil.getLong(request, EProcurementConstants.REQUEST_ID);
        long itemId = ParamUtil.getLong(request, "itemId");
        double totalCost = 0;
        double totalOriginalCost = 0;
        String itemName = ParamUtil.getString(request, "itemName");
        String itemDescription = ParamUtil.getString(request, "itemDescription");
        String wbsElement = ParamUtil.getString(request, "wbsElement");
        String costCenter = ParamUtil.getString(request, "costCenter");
        String glAcNo = ParamUtil.getString(request, "glAccNo");
        long quantity = Long.parseLong(ParamUtil.getString(request, "quantity"));
        double cost = Double.parseDouble(ParamUtil.getString(request, "cost"));
        double originalCost = Double.parseDouble(ParamUtil.getString(request, "originalCost"));
        long dbQuantity = 0;
        double dbCost = 0;
        double dbOrgCost = 0;
        double totalDbValue = 0;
        if (Validator.isNotNull(itemId))
        {
            try
            {
                Item item = ItemLocalServiceUtil.getItem(itemId);
                dbQuantity = item.getQuantity();
                dbCost = item.getCost();
                dbOrgCost = item.getOriginalCost();
                item.setItemId(itemId);
                item.setRequestId(requestId);
                item.setItemName(itemName);
                item.setItemDescription(itemDescription);
                item.setQuantity(quantity);
                item.setCost(cost);
                item.setOriginalCost(originalCost);
                item.setWbselement(wbsElement);
                item.setGlAccNo(glAcNo);
                item.setCostCenter(costCenter);
                ItemLocalServiceUtil.updateItem(item);

            } catch (SystemException e)
            {
                _log.error("Error while editing items : " + e.getMessage(), e);
            }

        }
        if (Validator.isNotNull(requestId))
        {
            try
            {
                double totalValue = 0;
                EprocurementRequest eprocuUpdate = EprocurementRequestLocalServiceUtil
                        .getEprocurementRequest(requestId);
                totalCost = eprocuUpdate.getTotalCost();
                totalDbValue = dbQuantity * dbCost;
                totalValue= Double.valueOf(numberFormat.format(totalDbValue));
                totalCost = totalCost - totalDbValue;
                totalCost= Double.valueOf(numberFormat.format(totalCost));
                totalCost = totalCost + totalValue;
                totalCost=Double.valueOf(numberFormat.format(totalCost));
                eprocuUpdate.setTotalCost(totalCost);
                
                totalCost = eprocuUpdate.getOriginalCost();
                totalDbValue = dbQuantity * dbOrgCost ;
                totalValue= Double.valueOf(numberFormat.format(totalDbValue));
                totalCost = totalCost - totalDbValue;
                totalCost= Double.valueOf(numberFormat.format(totalCost));
                totalCost = totalCost + totalValue;
                totalCost=Double.valueOf(numberFormat.format(totalCost));
                eprocuUpdate.setOriginalCost(totalCost);
                
                EprocurementRequestLocalServiceUtil.updateEprocurementRequest(eprocuUpdate);
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                EProcurementRequestTrackerWSUtil.addEntryInRequestTracker(eprocuUpdate, themeDisplay);
            } catch (SystemException e)
            {
                _log.error("Error while updating total cost in update Item: " + e.getMessage(), e);
            } catch (PortalException e)
            {
                _log.error("Error while updating total cost in update Item: " + e.getMessage(), e);
            }
        }

    }

    /**
     * This method is to delete the items for a request
     * @param actionRequest
     * @param actionResponse
     * @param action
     * @return edit request
     */
    @ActionMapping(params = "eProcAction=deleteItem")
    public void deleteItem(ActionRequest request, ActionResponse response) throws SystemException, PortalException
    {
        // delete item code
        NumberFormat numberFormat = new DecimalFormat("0.00");
        long requestId = ParamUtil.getLong(request, EProcurementConstants.REQUEST_ID);
        long itemId = ParamUtil.getLong(request, "itemId");
        double totalCost = 0;
        double cost = 0;
        double orgCost = 0;
        long quantity = 0;
        double totalValue = 0;
        if (Validator.isNotNull(itemId))
        {
            try
            {
                Item item = ItemLocalServiceUtil.getItem(itemId);
                quantity = item.getQuantity();
                cost = item.getCost();
                orgCost = item.getOriginalCost();
                ItemLocalServiceUtil.deleteItem(itemId);

            } catch (SystemException e)
            {
                _log.error("Error while deleting item:" + e.getMessage(), e);
            }

        }
        if (Validator.isNotNull(requestId))
        {
            try
            {
                EprocurementRequest eprocuUpdate = EprocurementRequestLocalServiceUtil
                        .getEprocurementRequest(requestId);
                totalCost = eprocuUpdate.getTotalCost();
                totalValue = quantity * cost;
                totalValue= Double.valueOf(numberFormat.format(totalValue));
                totalCost = totalCost - totalValue;
                totalCost = Double.valueOf(numberFormat.format(totalCost));
                eprocuUpdate.setTotalCost(totalCost);
                
                totalCost = eprocuUpdate.getOriginalCost();
                totalValue = quantity * orgCost;
                totalValue= Double.valueOf(numberFormat.format(totalValue));
                totalCost = totalCost - totalValue;
                totalCost = Double.valueOf(numberFormat.format(totalCost));
                eprocuUpdate.setOriginalCost(totalCost);
                
                
                
                EprocurementRequestLocalServiceUtil.updateEprocurementRequest(eprocuUpdate);
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                EProcurementRequestTrackerWSUtil.addEntryInRequestTracker(eprocuUpdate, themeDisplay);
            } catch (SystemException e)
            {
                _log.error("Error while updating cost in delete Item:" + e.getMessage(), e);
            } catch (PortalException e)
            {
                _log.error("Error while updating cost in delete Item:" + e.getMessage(), e);
            }
        }

    }

    /**
     * This method is to delete the attachment in a request
     * @param actionRequest
     * @param actionResponse
     * @param action
     * @return edit request
     */
    @ActionMapping(params = "eProcAction=deleteAttachment")
    public void deleteAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException, IOException
    {
        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
        if (cmd.equals(Constants.DELETE))
        {
            deleteFileEntry(actionRequest, actionResponse);

        }
    }

    /**
     * This method is to delete files 
     * @param actionRequest
     * @param actionResponse
     * @param action
     * @return edit request
     */
    protected void deleteFileEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException, IOException
    {

        long folderId = ParamUtil.getLong(actionRequest, "folderId");
        String name = ParamUtil.getString(actionRequest, "name");
        long fileEntryId = ParamUtil.getLong(actionRequest, "fileEnrtyId");
        long requestId = 0;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if (Validator.isNotNull(fileEntryId))
        {
            RequestAttachment requestFile = RequestAttachmentLocalServiceUtil
                    .getRequestAttachmentsByFileEntryId(fileEntryId);
            long attachmentId = requestFile.getRequestAttachmentId();
            requestId = requestFile.getRequestId();
            try
            {
                RequestAttachmentLocalServiceUtil.deleteRequestAttachment(attachmentId);
                DLFileEntryServiceUtil.deleteFileEntry(themeDisplay.getScopeGroupId(),folderId, name);
            } catch (SystemException e)
            {
                _log.error("Error in deleting file attachment from mapping table" + e.getMessage(), e);
            } catch (PortalException e)
            {
                _log.error("Error in deleting file attachment from mapping table" + e.getMessage(), e);
            }

        }
       
        String redirectURL = EProcurementUtil.createEditRequestURL(actionRequest, themeDisplay,
                EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
        actionResponse.sendRedirect(redirectURL);

    }

    /**
     * This method is to form Item object from the request parameters
     * @param actionRequest
     * @param actionResponse
     * @param action
     * @return Item
     */
    private static Item itemObjFromRequest(long requestId, String[] requestColumns) throws PortalException, SystemException
    {

        Item item = null;
        item = new ItemImpl();
        String itemName = requestColumns[0];
        String itemDesc = requestColumns[1];
        long quantity = Long.parseLong(requestColumns[2]);
        double cost = Double.parseDouble(requestColumns[3]);
        double originalCost = Double.parseDouble(requestColumns[4]);
        String glAcNo = requestColumns[5];
        String wbsElement = requestColumns[6];
        String costCenter = requestColumns[7];
        long itemId = CounterLocalServiceUtil.increment(Item.class.getName());
        item.setItemId(itemId);
        item.setRequestId(requestId);
        item.setItemName(itemName);
        item.setItemDescription(itemDesc);
        item.setQuantity(quantity);
        item.setCost(cost);
        item.setOriginalCost(originalCost);
        item.setWbselement(wbsElement);
        item.setGlAccNo(glAcNo);
        item.setCostCenter(costCenter);

        return item;
    }

    /**
     * This method is to show Email Requester page
     * @param actionRequest
     * @param actionResponse
     * @param action
     * @return email requester page
     */
    public String showEmailRequestor(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        String jstlView = StringPool.BLANK;
        String renderRequestId = ParamUtil.getString(renderRequest, EProcurementConstants.REQUEST_ID);
        String requestorId = ParamUtil.getString(renderRequest, EProcurementConstants.REQUESTOR_ID);
        String remoteUserId = renderRequest.getRemoteUser();
        long doUserId = 0;
        User requestorUser = null;
        User loggedinUser = null;
        if (Validator.isNotNull(remoteUserId))
        {
            doUserId = Long.parseLong(remoteUserId);
        }
        try
        {
            loggedinUser = UserLocalServiceUtil.getUserById(doUserId);
            if (Validator.isNotNull(renderRequestId))
            {
                long userId = Long.parseLong(requestorId);
                requestorUser = UserLocalServiceUtil.getUserById(userId);
            }

        } catch (PortalException pe)
        {
            _log.error("error in email requestor" + pe.getMessage(), pe);
        } catch (SystemException sp)
        {
            _log.error("error in email requestor" + sp.getMessage(), sp);
        }
        renderRequest.setAttribute(EProcurementConstants.REQUEST_ID, renderRequestId);
        renderRequest.setAttribute("requestorUser", requestorUser);

        renderRequest.setAttribute("loggedinUser", loggedinUser);

        jstlView = "purchase/emailRequestor";

        return jstlView;
    }

    /**
     * This is the default view method
     * it will be called from either create request link or from dashboard page
     * @param renderRequest
     * @param renderResponse
     * @return create page
     */
    @RenderMapping
    public String showPurchaseRequest(RenderRequest renderRequest, RenderResponse renderResponse)
            throws com.liferay.portal.kernel.exception.PortalException, com.liferay.portal.kernel.exception.SystemException, NoSuchFolderException
    {
        String page="purchase/purchaseRequest";
        String showEmailRequestor = ParamUtil.getString(renderRequest, "showEmailRequester");
        if (Validator.isNotNull(showEmailRequestor) && "true".equals(showEmailRequestor))
        {
            showEmailRequestor(renderRequest, renderResponse);
            page = "purchase/emailRequestor";   
        }else{
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
                    .getHttpServletRequest(renderRequest));
            // folderId
            long folderId = 0;
           try
            {
                folderId = EprocurementCommonUtil.getFolderId(renderRequest);
            } catch (NoSuchFolderException ne)
            {
                folderId = 0;
                _log.error("fodler doesn't exist with name" + EProcurementConstants.EPROCURE_FOLDER_NAME + ne.getMessage(),
                        ne);
            }
    
            renderRequest.setAttribute("folderId", folderId);
            // end of folderId code
            // code for temphire locations
            List<EprocurementLocation> locations = EprocurementCommonUtil.getLocations();
            if (Validator.isNotNull(locations))
            {
                renderRequest.setAttribute("locations", locations);
            }
            // end of code for temphire locations
            // getting supervisorobject Details
            try
            {  
                User supervisorObj = EprocurementCommonUtil.getSupervisorObject(renderRequest);
                List userGroup = EprocurementCommonUtil.getGroupByName(renderRequest);
    
                if (Validator.isNotNull(userGroup))
                {
                    renderRequest.setAttribute("userGroup", userGroup);
    
                }
                if (Validator.isNotNull(supervisorObj))
                {
                    renderRequest.setAttribute("supervisorUser", supervisorObj);
    
                }
            } catch (SystemException es)
            {
                _log.error("error in getting supervisor details" + es.getMessage(), es);
            } catch (PortalException ep)
            {
                _log.error("error in getting supervisor details" + ep.getMessage(), ep);
            }
            // end of supervisorObject
    
            /**
             * If "eProcAction" == "showRequestWFDetails" && requestId != null then show Web-Admin Screen
             */
            String jstlView = showWebAdminWorkflowScreen(httpRequest, renderRequest, renderResponse);
            if (EProcurementUtil.isNotNullNonEmptyString(jstlView))
            {
                return jstlView;
            }
            
            //show or hide project spend section based on role
            boolean hasProjectSpendRole = EProcurementUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), EProcurementConstants.EPROCUREMENT_ROLE_PROJECT_SPEND, false);
            renderRequest.setAttribute("hasProjectSpendRole", hasProjectSpendRole);
    
            /**
             * @show edit request page
             */
            if (EProcurementConstants.PARAM_ACTION_NAME_SHOW_REQUEST.equalsIgnoreCase(httpRequest
                    .getParameter("eProcAction"))
                    && EProcurementUtil.isNotNullNonEmptyString(httpRequest.getParameter(EProcurementConstants.REQUEST_ID)))
            {
                renderRequest.setAttribute("requestIdDashboard", httpRequest.getParameter(EProcurementConstants.REQUEST_ID));
                String requId = httpRequest.getParameter(EProcurementConstants.REQUEST_ID);
                EprocurementRequest eprocuRequest = null;
                String vendorName=StringPool.BLANK;
                long requestId = Long.parseLong(requId);
                if (Validator.isNotNull(requestId))
                {
                    try
                    {
                        eprocuRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
                        renderRequest.setAttribute("eprocuRequest", eprocuRequest);
                                     
                    } catch (Exception e)
                    {
                        _log.error("Error in getting EprocurementRequest" + e.getMessage(), e);
                    }
                    try
                    {
                      
                        vendorName = EprocurementCommonUtil.getVendorName(themeDisplay.getCompanyId(),eprocuRequest.getVendorCode());
                        renderRequest.setAttribute("vendorName",vendorName);
                        
                    } catch (Exception e)
                    {
                        _log.error("Error in getting Vendor Name" + e.getMessage(), e);
                    }
                    if (Validator.isNotNull(eprocuRequest))
                    {
                        try
                        {
    
                            List<Item> items = ItemLocalServiceUtil.getItemsByRequestId(requestId);
                            renderRequest.setAttribute("items", items);
                            // get attachments
                            RequestAttachment requestFile = null;
                            List<RequestAttachment> requestAttachment = RequestAttachmentLocalServiceUtil
                                    .getRequestAttachmentsByRequestId(requestId);
                            List fileEntryIds = new ArrayList();
                            List fileEntries = new ArrayList();
                            // getting FileEntry Ids from mapping table data
                            if (Validator.isNotNull(requestAttachment))
                            {
                                for (int i = 0; i < requestAttachment.size(); i++)
                                {
                                    requestFile = requestAttachment.get(i);
                                    fileEntryIds.add(requestFile.getFileEntryId());
    
                                }
                            }
                            long fileId = 0;
                            // getting DlFile entries from DlFileEntry table
                            if (Validator.isNotNull(fileEntryIds))
                            {
                                for (int j = 0; j < fileEntryIds.size(); j++)
                                {
                                    fileId = (Long) fileEntryIds.get(j);
                                    DLFileEntry dlfFile = DLFileEntryLocalServiceUtil.getFileEntry(fileId);
                                    fileEntries.add(dlfFile);
    
                                }
                            }
                            renderRequest.setAttribute("fileEntries", fileEntries);
                            // end code of getting attachments
                        } catch (Exception ex)
                        {
                            _log.error("Error in getting file attachments" + ex.getMessage(), ex);
                        }
                    }
                }
                // adding request parameter when purchase request is viewed from
                // reports page
                if (EProcurementUtil.isNotNullNonEmptyString(httpRequest.getParameter("reports")))
                {
                    renderRequest.setAttribute("reports", httpRequest.getParameter("reports"));
                }
            }
        }
        return page;
    }

    /**
     * 
     * @param httpRequest
     * @param renderRequest
     * @param renderResponse
     * @return String JSTL-View
     * If either in PortletRequest or in HttpRequest, if ("cmd" == "showRequestWFDetails") & (requestId != "") then show Web-Admin screen
     */
    private String showWebAdminWorkflowScreen(HttpServletRequest httpRequest, RenderRequest renderRequest,
            RenderResponse renderResponse)
    {
        String jstlView = StringPool.BLANK;
        String renderCommand = ParamUtil.getString(renderRequest, "cmd");
        String renderRequestId = ParamUtil.getString(renderRequest, EProcurementConstants.REQUEST_ID);
        if ("showRequestWFDetails".equalsIgnoreCase(httpRequest.getParameter("cmd"))
                && EProcurementUtil.isNotNullNonEmptyString(httpRequest.getParameter(EProcurementConstants.REQUEST_ID)))
        {
            String reqId = httpRequest.getParameter(EProcurementConstants.REQUEST_ID);
            WorkflowProgressUtil.populateWebAdminScreenData(renderRequest, renderResponse, Long.valueOf(reqId));
            jstlView = "requestworkflow/requestWorkflowDetails";
        } else if ("showRequestWFDetails".equalsIgnoreCase(renderCommand)
                && EProcurementUtil.isNotNullNonEmptyString(renderRequestId))
        {
            WorkflowProgressUtil.populateWebAdminScreenData(renderRequest, renderResponse,
                    Long.valueOf(renderRequestId));
            jstlView = "requestworkflow/requestWorkflowDetails";
        }
        return jstlView;
    }

    /**
     * This method is to add attachments 
     * @param actionRequest
     * @param actionResponse
     * @param action
     */
    public static void singleFileUpload(ActionRequest actionRequest, ActionResponse actionResponse, long requestId, File file)
            throws PortalException, SystemException, FileSizeException, DuplicateFileException
    {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        FileEntry fileEntry = null;
        String fileName = file.getName();
        String title = requestId + StringPool.DASH + fileName;
        try
        {
            DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,
                    EProcurementConstants.EPROCURE_FOLDER_NAME);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
                    actionRequest);
          /*  fileEntry = DLFileEntryServiceUtil.addFileEntry(dlFolder.getFolderId(), file.getName(), title,
                    StringPool.BLANK, null, file, serviceContext);*/
            long repositoryId = dlFolder.getRepositoryId();
            
        	String contentType = MimeTypesUtil.getContentType(file.getName());
        	fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, dlFolder.getFolderId(), file.getName(), contentType,
            		title, StringPool.BLANK, null, file, serviceContext);
        	
        	getIntranetCommonService().setResourcePermissions(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
					RoleConstants.USER, DLFileEntry.class.getName(), String.valueOf(fileEntry.getPrimaryKey()), 
					EProcurementConstants.DL_USER_FILE_PERMISSION);
        	 
        } catch (SystemException e)
        {
            _log.error("Error while adding file : " + e.getMessage(), e);
        } catch (FileSizeException e)
        {
            _log.error("Error while adding file : " + e.getMessage(), e);
        } catch (DuplicateFileException e)
        {
            _log.error("Error while adding file : " + e.getMessage(), e);
        }
        if (Validator.isNotNull(fileEntry))
        {
            RequestAttachment requestFile = new RequestAttachmentImpl();
            try
            {
                long attachmentId = CounterLocalServiceUtil.increment(RequestAttachment.class.getName());
                requestFile.setRequestAttachmentId(attachmentId);
                requestFile.setFileEntryId(fileEntry.getFileEntryId());
                requestFile.setRequestId(requestId);
                RequestAttachmentLocalServiceUtil.addRequestAttachment(requestFile);
            } catch (SystemException e)
            {
                _log.error("Error while adding file : " + e.getMessage(), e);
            }

        }

    }
    
    /**
     * method to edit items
     * @param requestId
     * @param col
     * @throws SystemException
     * @throws PortalException
     */
    public static void editItems(long requestId, String[] col, long userId) throws SystemException, PortalException
    {
        try
        {
            String itemName = col[0];
            String itemDesc = col[1];
            long quantity = Long.parseLong(col[2]);
            double cost = Double.parseDouble(col[3]);
            double originalCost = Double.parseDouble(col[4]);
            String glAcNo = col[5];
            String wbsElement = col[6];
            String costCenter = col[7];
            long itemId = Long.parseLong(col[8]);
            
            Item item = ItemLocalServiceUtil.getItem(itemId);

            item.setItemId(itemId);
            item.setRequestId(requestId);
            item.setItemName(itemName);
            item.setItemDescription(itemDesc);
            item.setQuantity(quantity);
            item.setCost(cost);
            item.setOriginalCost(originalCost);
            item.setGlAccNo(glAcNo);
            item.setWbselement(wbsElement);
            item.setCostCenter(costCenter);
            item.setModifiedBy(userId);
            item.setModifiedDate(new Date());
            ItemLocalServiceUtil.updateItem(item);

        } catch (SystemException e)
        {
            _log.error("Error while editing items : " + e.getMessage(), e);
        }

    }

    /**
     * method to delete items
     * @param itemsId
     * @throws SystemException
     * @throws PortalException
     */
    public static void deleteItems(String itemsId) throws SystemException, PortalException
    {
        String[] itemIds = itemsId.split(",");
        // delete item code
        long itemId = 0;
        for (String id : itemIds)
        {
            itemId = Long.parseLong(id);
            if (Validator.isNotNull(itemId))
            {
                try
                {
                    ItemLocalServiceUtil.deleteItem(itemId);

                } catch (SystemException e)
                {
                    _log.error("Error while deleting item:" + e.getMessage(), e);
                }

            }
        }
    }
    
    @ActionMapping(params = "eProcAction=sendReminder")
    public void sendReminder(ActionRequest actionRequest, ActionResponse actionResponse){
        
        ThemeDisplay  themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long requestId = ParamUtil.getLong(actionRequest, EProcurementConstants.REQUEST_ID);
        EprocurementRequest request = null;
        if (requestId <= 0)
        {
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
                    .getHttpServletRequest(actionRequest));
            requestId = ParamUtil.getLong(httpRequest, EProcurementConstants.REQUEST_ID);
        }
        _log.info("Request Id.." + requestId);
        try
        {
             request = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
            
        } catch (PortalException e)
        {
            _log.error(e.getMessage(),e);
        } catch (SystemException e)
        {
            _log.error(e.getMessage(),e);
        }
       
        if(Validator.isNotNull(request)){
            
            String requestStatus = request.getStatus();
            
            /**
             * Notify Initial Approver If request Status NEW
             */
            if (EProcurementConstants.STATUS_NEW.equalsIgnoreCase(requestStatus))
            {
                if (EProcurementConstants.YES.equalsIgnoreCase(request.getIsRelatedtoProject()))
                {
                    if (request.getProjectOwnerId() > 0)
                    {
                       /** 
                        * Last parameter is (true) to indicate  that this is a reminder email.
                        */
                       WorkflowProgressUtil.notifyInitialApprover(request.getProjectOwnerId(),requestId,themeDisplay,request.getRequestorId(),true);
                    }
                } else
                {
                    if (request.getSupervisorId() > 0)
                    {   
                        /** 
                         * Last parameter is (true) to indicate  that this is a reminder email.
                         */
                        WorkflowProgressUtil.notifyInitialApprover(request.getSupervisorId(),requestId,themeDisplay,request.getRequestorId(),true);
                    }
                }
            }
            /**
             * END
             */
            
            /**
             * Notify Stage Approver If WF is assigned
             */
            
            /**
             *  Find whether WF is already assigned to this request or not 
             */
            WorkflowRequest currentWFRequest = null;
            WorkflowDefinition wfDefinition = null;
            try
            {
                currentWFRequest = EProcurementUtil.getWFProposalRequest(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
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
            
            String nextStage = request.getNextStage();
            /*
             * If next stage is blank then request is in web admin's plate ..no email will be sent out in this case.
             */
            if(Validator.isNotNull(wfDefinition) && Validator.isNotNull(nextStage) && !EProcurementConstants.STATUS_NEW.equals(requestStatus)){
                
                long stageApproverId = Long.valueOf(nextStage);
                /** 
                 * Last parameter is (true) to indicate  that this is a reminder email.
                 */
                EprocurementEmailUtility.notifyStageApprover(actionRequest, themeDisplay, requestId, stageApproverId,true);
            }
        }
        
      
        try
        {   
            String url = EProcurementUtil.createEditRequestURL(actionRequest, themeDisplay, EProcurementConstants.IS_PRIVATE_LAYOUT, requestId);
            actionResponse.sendRedirect(url);
        } catch (IOException e)
        {
            _log.error("Error while forwarding to RequestDetails-WebAdmin Screen : " + e.getMessage(), e);
        }
        
    }
    
    private static IntranetCommonService getIntranetCommonService() {
		return intranetCommonService;
	}
	private static volatile IntranetCommonService intranetCommonService;
    
}

