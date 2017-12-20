/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.dsi.common.service.exception.WebServiceCallException;
import com.dsi.intranet.pgc.exception.PGCPersistenceException;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumServiceUtil;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;
import com.dsi.intranet.pgc.portlet.model.AdvisoryBoardInformation;
import com.dsi.intranet.pgc.portlet.model.ContractInformation;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.RequestorInformation;
import com.dsi.intranet.pgc.portlet.service.PGCService;
import com.dsi.intranet.pgc.portlet.util.DropDownUtil;
import com.dsi.intranet.pgc.portlet.util.LongNumberEditor;
import com.dsi.intranet.pgc.portlet.util.PGCCommonUtil;
import com.dsi.intranet.pgc.portlet.util.PGCFormTypeEditor;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * <a href="PGCRequestFormController.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to Pass Object Name while updating the record
 */
@Controller(value = "pgcRequestFormController")
@RequestMapping(value = "VIEW")
@SessionAttributes({ "appForm" })
public class PGCRequestFormController extends PGCAbstractControllerBase
{
    private static final String APP_FORM = "appForm";

	private static final Log LOGGER = LogFactoryUtil.getLog(PGCRequestFormController.class);

    @Autowired
    @Qualifier("defaultImpl")
    private PGCService pgcService;

    @ActionMapping(params = "appAction=deleteAttachment")
    public void deleteAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException,
            SystemException, IOException
    {
        String documentId = ParamUtil.getString(actionRequest, "documentId");
        if (Validator.isNotNull(documentId))
        {
            DocumentumServiceUtil.deleteAttachment(documentId);
        }
    }

    @ModelAttribute(APP_FORM)
    public PGCForm getCommandObject()
    {
        return new PGCForm();
    }

    @Override
    @InitBinder(APP_FORM)
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Long.class, new LongNumberEditor());
        binder.registerCustomEditor(PGCFormType.class, new PGCFormTypeEditor());

    }

    @ResourceMapping(value = "populateData")
    public void populateData(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        try
        {
        	RequestorInformation  reqInfo = PGCCommonUtil.getRequestorDetails(httpRequest, "yes");
	        String costCenter = Validator.isNotNull(reqInfo.getCostCenter()) ? reqInfo.getCostCenter() : StringPool.BLANK;
	        String deptTerritory = Validator.isNotNull(reqInfo.getDeptTerritory()) ? reqInfo.getDeptTerritory()
	                : StringPool.BLANK;
	        String businessPhone = Validator.isNotNull(reqInfo.getBusinessPhone()) ? reqInfo.getBusinessPhone()
	                : StringPool.BLANK;
	        String managerName = Validator.isNotNull(reqInfo.getManagerName()) ? reqInfo.getManagerName()
	                : StringPool.BLANK;
	        String managerEmail = Validator.isNotNull(reqInfo.getManagerEmail()) ? reqInfo.getManagerEmail()
	                : StringPool.BLANK;
	        String managerEmployeeId = Validator.isNotNull(reqInfo.getManagerEmployeeId()) ? reqInfo.getManagerEmployeeId()
	                : StringPool.BLANK;
	        String name = Validator.isNotNull(reqInfo.getRequestorName()) ? reqInfo.getRequestorName() : StringPool.BLANK;
	        String email = Validator.isNotNull(reqInfo.getEmail()) ? reqInfo.getEmail() : StringPool.BLANK;
	        String requestorEmployeeId = Validator.isNotNull(reqInfo.getRequestorEmployeeId()) ? reqInfo
	                .getRequestorEmployeeId() : StringPool.BLANK;
	
	        JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
	        jsonFeed.put("costCenter", costCenter);
	        jsonFeed.put("deptTerritory", deptTerritory);
	        jsonFeed.put("businessPhone", businessPhone);
	        jsonFeed.put("managerName", managerName);
	        jsonFeed.put("managerEmail", managerEmail);
	        jsonFeed.put("managerEmployeeId", managerEmployeeId);
	        jsonFeed.put("name", name);
	        jsonFeed.put("email", email);
	        jsonFeed.put("requestorEmployeeId", requestorEmployeeId);
	
	        resourceResponse.setContentType("application/json");
	        resourceResponse.setCharacterEncoding("UTF-8");
	        resourceResponse.getWriter().write(jsonFeed.toString());
	        LOGGER.error("APP_FORM is " + APP_FORM);
        } catch (Exception e)
        {
            LOGGER.error("Error in getting Requestor Details" + e.getMessage(), e);
        }
    }

    /**
      * This method is to save form to documentum
      * @param actionRequest
      * @param actionResponse
      * @param action
      * @param model attribute
      * @return pgc dash board page
      */
    @ActionMapping(params = "appAction=saveNewPGCForm")
    public void saveForm(@ModelAttribute(APP_FORM) PGCForm appForm, BindingResult bindingResult,
            ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus)
    {
        String action = actionRequest.getParameter("saveAction");
        String objectId = actionRequest.getParameter("objectId");
        String status = actionRequest.getParameter("action");
        String formStatus = actionRequest.getParameter("formStatus");
         //DSI:START::Veera Reddy:: To pass the object name while editing the record 
        String objectName = actionRequest.getParameter("objectName");
         //DSI:END::Veera Reddy:: To pass the object name while editing the record 
       // String contractSpecialist = actionRequest.getParameter("contractInfo.contractSpecialist");
        String contractOther = actionRequest.getParameter("contractInfo.otherContract");
       // String advContractSpecialist = actionRequest.getParameter("advisoryBoardInfo.contractSpecialistName");
        String advOtherContract = actionRequest.getParameter("advisoryBoardInfo.otherContract");
        ContractInformation contractInfo = appForm.getContractInfo();
        AdvisoryBoardInformation advBoard = appForm.getAdvisoryBoardInfo();
        if (Validator.isNotNull(contractOther))
        {
            contractInfo.setContractSpecialist(contractOther);
        }
        if (Validator.isNotNull(advOtherContract))
        {
            advBoard.setContractSpecialistName(advOtherContract);
        }

        if (Validator.isNotNull(objectId))
        {
            appForm.setObjectId(objectId);
        }
         //DSI:START::Veera Reddy:: To pass the object name while editing the record 
        if (Validator.isNotNull(objectName))
        {
            appForm.setObjectName(objectName);
        }
         //DSI:END::Veera Reddy:: To pass the object name while editing the record 
        if ((Validator.isNull(formStatus) || formStatus.equalsIgnoreCase("Draft")) && Validator.isNotNull(status))
        {
            if (status.equalsIgnoreCase("save"))
            {
                appForm.setFormStatus("Draft");
            } else if (status.equalsIgnoreCase("submit"))
            {
                appForm.setFormStatus("Submitted");
            }
        }
        boolean success = false;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("THEME_DISPLAY");
        if (Validator.isNotNull(action))
        {
            try
            {
                pgcService.saveForm(appForm);
                SessionMessages.add(actionRequest, "processed-successfully");
                success = true;
            } catch (PGCPersistenceException e)
            {
                success = false;
                SessionErrors.add(actionRequest, "process-unsuccess");
                LOGGER.error("Error in Save Request" + e.getMessage(), e);
              
            }
            catch (Exception e)
            {
                success = false;
                SessionErrors.add(actionRequest, "process-unsuccess");
                LOGGER.error("Error in Save Request" + e.getMessage(), e);
              
            }

            Map<String, String> requestParam = new HashMap<String, String>();
            try
            {
                if (success)
                {
                    String dashBoardURL = PGCCommonUtil.createSendRedirectURL(themeDisplay,
                            PGCCommonConstants.IS_PRIVATE_LAYOUT, PGCCommonConstants.FRIENDLY_URL_PGC_DASHBOARD);
                    StringBuilder url = PGCCommonUtil.appendQueryParams(dashBoardURL, requestParam);
                    dashBoardURL = new String(url); 
                    actionResponse.sendRedirect(dashBoardURL);
                } else
                {
                    actionResponse.setRenderParameter("appAction", "newPGCForm");
                }
            } catch (IOException io)
            {
                LOGGER.error("Error in creating dashBoardURL" + io.getMessage(), io);
            }

        }
    }

    @ResourceMapping(value = "viewDocument")
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
        String documentId = ParamUtil.getString(resourceRequest, "documentId");
        String fileName = ParamUtil.getString(resourceRequest, "fileName");
        byte[] fileContent = null;
        OutputStream outputStream = null;
        if (Validator.isNotNull(documentId) && Validator.isNotNull(fileName))
        {
            try
            {
                fileContent = DocumentumServiceUtil.getPGCDocument(documentId);
            } catch (WebServiceCallException e)
            {
                LOGGER.error("Error whle retrieving file from documentum" + e.getMessage(), e);
            }
            String responseType = PGCCommonUtil.getResponseContentType(fileName);
            if (Validator.isNotNull(responseType))
            {
                resourceResponse.setContentType(responseType);
            }
            resourceResponse.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");
            outputStream = resourceResponse.getPortletOutputStream();
            if (Validator.isNotNull(fileContent))
            {
                outputStream.write(fileContent);
            }
        }
    }

    /**
     * This method is to show PGC form selected by the user with the details entered
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @return pgc form in edit mode
     */
    @RenderMapping(params = "appAction=editPGCForm")
    public String showExistingPGCForm(@ModelAttribute(APP_FORM) PGCForm appForm, RenderRequest request,
            RenderResponse response)
    {
        String objectId = ParamUtil.getString(request, "objectId");
        String requestId = ParamUtil.getString(request, "requestId");
        String typeName = ParamUtil.getString(request, "typeName");
        String mode = ParamUtil.getString(request, "mode");
         //DSI:START::Veera Reddy:: To pass the object name while editing the record 
        String objectName = ParamUtil.getString(request, "objectName");
         //DSI:END::Veera Reddy:: To pass the object name while editing the record 
        PGCCommonUtil.setBlockValuesToNull(appForm, true);
        if (Validator.isNotNull(typeName) && Validator.isNotNull(requestId))
        {
            Map<String, String> formTypes = DropDownUtil.getFormTypesSearchList();
            PGCFormType pgcFormType = PGCFormType.valueOf(formTypes.get(typeName));
            appForm.setFormType(pgcFormType);
            appForm.setRequestId(requestId);
            try
            {
                pgcService.populateFormData(appForm, typeName);
                ContractInformation contractInfo = appForm.getContractInfo();
                AdvisoryBoardInformation advBoard = appForm.getAdvisoryBoardInfo();
                String contractSpecialist = contractInfo.getContractSpecialist();
                String advContractSpecialist = advBoard.getContractSpecialistName();
                if (Validator.isNotNull(contractSpecialist))
                {
                    String[] contracts = DropDownUtil.getContractSpecialists();
                    String other = "Other";
                    List<String> contractsList = Arrays.asList(contracts);
                    for(int i=1; i<=contractsList.size();i++)
                    {
                        boolean notOther = contractsList.contains(contractSpecialist);

                        if (!notOther)
                        {
                            contractInfo.setOtherContract(contractSpecialist);
                            contractInfo.setContractSpecialist(other);

                        }
                    }

                }
                // for adv board
                if (Validator.isNotNull(advContractSpecialist))
                {

                    String[] contracts = DropDownUtil.getContractSpecialists();
                    String other = "Other";
                    List<String> contractsList = Arrays.asList(contracts);
                    for(int i=1; i<=contractsList.size();i++)
                    {
                        boolean notOther = contractsList.contains(advContractSpecialist);
                        if (!notOther)
                        {
                            advBoard.setOtherContract(advContractSpecialist);
                            advBoard.setContractSpecialistName(other);
                        }
                    }

                }

            } catch (Exception e)
            {
                LOGGER.error("Error in populating the data" + e.getMessage(), e);
            }
            request.setAttribute("requestId", requestId);
            request.setAttribute("typeName", typeName);
        }
        if (Validator.isNotNull(mode) && mode.equalsIgnoreCase("editMode"))
        {
            request.setAttribute("saveAction", "update");
        } else
        {
            request.setAttribute("viewMode", "view");
        }
        
        if (Validator.isNotNull(objectId))
        {
            request.setAttribute("OBJECTID", objectId);
        }
         //DSI:START::Veera Reddy:: To pass the object name while editing the record 
        if (Validator.isNotNull(objectName))
        {
            request.setAttribute("OBJECTNAME", objectName);
        }
         //DSI:END::Veera Reddy:: To pass the object name while editing the record 
        return "pgc_request_form";
    }

    /**
     * This method is to show PGC form selected by the user
     * @param renderRequest
     * @param renderResponse
     * @param action
     * @return pgc form
     */
    @RenderMapping(params = "appAction=newPGCForm")
    public String showNewPGCForm(@ModelAttribute(APP_FORM) PGCForm appForm, RenderRequest request,
            RenderResponse response)
    {
        try
        {
            RequestorInformation reqInfo = null;
            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
            reqInfo = PGCCommonUtil.getRequestorDetails(httpRequest, "no");
            appForm.setReqInfo(reqInfo);
            PGCCommonUtil.setBlockValuesToNull(appForm, false);

            if (appForm.getFormType() == PGCFormType.DispExhibit || appForm.getFormType() == PGCFormType.POMembership)
            {
                PGCCommonUtil.getBudgetValue(appForm);
            }

        } catch (SystemException se)
        {
            LOGGER.error("Error in getting logged in Requestor Information " + se.getMessage(), se);
        } catch (PortalException pe)
        {
            LOGGER.error("Error in getting logged in Requestor Information " + pe.getMessage(), pe);
        }
        request.setAttribute("saveAction", "create");
        return "pgc_request_form";
    }
    
    /**
     * This method is to validate the costcenter and wbselements entered by the user
     * @param renderRequest
     * @param renderResponse
     */
    @ResourceMapping(value = "costOrWbs")
    public void costOrWbs(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
    	
    	 HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
         String costOrWbsErrorList = "";
         String dataType = httpRequest.getParameter("dataType");
         String  dataValue = httpRequest.getParameter("dataValue");
    	 
    	 if (dataType.equalsIgnoreCase("wbselement"))
         {
    		 costOrWbsErrorList = PGCCommonUtil.wbselementValidation(dataValue);
          }else if (dataType.equalsIgnoreCase("costInfo"))
          {
        	  costOrWbsErrorList = PGCCommonUtil.costCenterValidation(dataValue);
           }
    	 
    	 JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
	        jsonFeed.put("costOrWbsErrorList", costOrWbsErrorList);
	        
	        resourceResponse.setContentType("application/json");
	        resourceResponse.setCharacterEncoding("UTF-8");
	        resourceResponse.getWriter().write(jsonFeed.toString());
    }
}