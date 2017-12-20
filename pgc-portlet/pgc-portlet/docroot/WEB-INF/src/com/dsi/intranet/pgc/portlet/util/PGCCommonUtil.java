/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumDateConverter;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;
import com.dsi.intranet.pgc.portlet.model.AdvisoryBoardInformation;
import com.dsi.intranet.pgc.portlet.model.BudgetInformation;
import com.dsi.intranet.pgc.portlet.model.CharitableDonationInformation;
import com.dsi.intranet.pgc.portlet.model.CheckRequestInformation;
import com.dsi.intranet.pgc.portlet.model.ContractInformation;
import com.dsi.intranet.pgc.portlet.model.CorporateSupportInformation;
import com.dsi.intranet.pgc.portlet.model.DisplayExhibitInformation;
import com.dsi.intranet.pgc.portlet.model.EducationalItemsInformation;
import com.dsi.intranet.pgc.portlet.model.GeneralRequestInformation;
import com.dsi.intranet.pgc.portlet.model.HCPConsultant;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;
import com.dsi.intranet.pgc.portlet.model.POMembershipInformation;
import com.dsi.intranet.pgc.portlet.model.ProductInformation;
import com.dsi.intranet.pgc.portlet.model.RequestorInformation;
import com.dsi.intranet.pgc.portlet.model.ServiceAgreement;
//import com.dsi.intranet.portal.util.IntranetCommonUtil;
import com.dsi.intranet.rfc.model.CostCenter;
import com.dsi.intranet.rfc.model.EmployeeDataDump;
import com.dsi.intranet.rfc.model.WBSElements;
import com.dsi.intranet.rfc.service.CostCenterLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalServiceUtil;
import com.dsi.intranet.rfc.service.WBSElementsLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * <a href="PGCCommonUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project PGC
 * @Author Resmy Mathew
 * @Description Common Utility class for pgc.
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to provide different logic for employee based on sub area code       
 * Veera Reddy		|	Aug 22 2012		|	Modified To create out going request xmls        
 */

public final class PGCCommonUtil
{
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(PGCCommonUtil.class);
    
private PGCCommonUtil(){}
    /**
     * 
     * @param url
     * @param requestParam
     * @return String This will append Query parameters to URL
     */
    public static StringBuilder appendQueryParams(String url, Map<String, String> requestParam)
    {
        StringBuilder paramURL = new StringBuilder(url);
        if (requestParam != null && !requestParam.isEmpty())
        {
            if (!url.contains(StringPool.QUESTION))
            {
                paramURL = paramURL.append(StringPool.QUESTION);
            }
            Set<String> keySet = requestParam.keySet();
            if (keySet != null && !keySet.isEmpty())
            {
                for (String key : keySet)
                {
                    paramURL = paramURL.append(StringPool.AMPERSAND);
                    paramURL = paramURL.append(key);
                    paramURL = paramURL.append(StringPool.EQUAL);
                    paramURL = paramURL.append(requestParam.get(key));
                }
            }
        }
        return paramURL;
    }
    /**
     * 
     * @param date
     * @return {Date Meeting Date} This method is used to convert PGC Meeting date
     */
    public static String convertMeetingDate(String dateTime)
    {
        SimpleDateFormat sdfDest = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat meetingFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = StringPool.BLANK;
        try
        {
            strDate = dateTime.substring(0, 10);
            strDate = sdfDest.format(meetingFormat.parse(strDate));
        } catch (ParseException pe)
        {
            return dateTime;
        }
        try
        {
        sdfDest.format(DocumentumDateConverter.parse(dateTime));
           
        } catch (Exception e)
        {
            return dateTime;
        }
        return strDate;
    }
    /**
     * 
     * @param date
     * @return {Date Event Date} This method is used to convert event date
     */
    public static String convertTimetoString(String dateTime)
    {
        SimpleDateFormat sdfDest = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = StringPool.BLANK;
        try
        {
            strDate = sdfDest.format(DocumentumDateConverter.parse(dateTime));
        } catch (Exception e)
        {
            return dateTime;
        }
        return strDate;
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
     * This method sets the form type name
     * @param formType
     * @return string
     */
    public static String FormTypeConvertion(String formType)
    {
        Map<String, String> formTypesSearchList = DropDownUtil.getFormTypesSearch();
        String formTypeName = StringPool.BLANK;
        for (Map.Entry<String, String> formList : formTypesSearchList.entrySet())
        {

            boolean formTypeCheck = formList.getKey().contains(formType);
            if (formTypeCheck)
            {
                formTypeName = formList.getValue();
                break;
            }
        }
        return formTypeName;
    }

    /**
     * This method sets the budget information bean
     * @param renderRequest
     * @return boolean
     */
    public static void getBudgetValue(PGCForm form)
    {
        BudgetInformation budgetInfo = new BudgetInformation();
        if (form.getFormType() == PGCFormType.DispExhibit)
        {
            budgetInfo.setDisplayExhibitBudget(PGCCommonConstants.DISPLAY_EXHIBIT_COST);
        } else if (form.getFormType() == PGCFormType.POMembership)
        {
            budgetInfo.setPoMemberBudget(PGCCommonConstants.PO_MEMBER_GLACC);
        }
        form.setBudgetInfo(budgetInfo);
    }

    /**
     * Get value of Expando Arrtibute  
     * 
     * @param user
     * @return
     */
    public static RequestorInformation getCustomAttributes(User user, RequestorInformation reqInfo)
    {
        RequestorInformation reqInformation = reqInfo;
        ExpandoBridge expandoBridge = user.getExpandoBridge();
        String department = StringPool.BLANK;
        String employeeId = StringPool.BLANK;
        String territoryCode = StringPool.BLANK;

        String costCenter = StringPool.BLANK;
        employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);
        territoryCode = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_TERRORITY_CODE);
        int employeeType = PGCCommonUtil.getEmployeeType(user);
        // checking whether requestor is from Sales force
        if (employeeType == 1)
        {
            department = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_TERRORITY);
            costCenter = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_COST_CENTER);
        } else if (employeeType == 2)
        {
            department = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_DEPARTMENT);
        }
        reqInformation.setCostCenter(costCenter);
        reqInformation.setDeptTerritory(department);
        reqInformation.setRequestorEmployeeId(employeeId);
        reqInformation.setTerritoryCode(territoryCode);
        return reqInformation;
    }

    /**
     * Get value of Expando Arrtibute Cost Center
     * 
     * @param user
     * @return
     */
    public static String getExpandoCostCenter(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);

        return employeeId != null ? employeeId : StringPool.BLANK;
    }

    /**
     * Get value of Expando Arrtibute Department
     * 
     * @param user
     * @return
     */
    public static String getExpandoDepartment(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);

        return employeeId != null ? employeeId : StringPool.BLANK;
    }

    /**
     * Get value of Expando Arrtibute Employee Id
     * 
     * @param user
     * @return
     */
    public static String getExpandoEmployeeId(User user)
    {
        String employeeId = "10080059";	//StringPool.BLANK;
        /*
        try
        {
            ExpandoBridge expandoBridge = user.getExpandoBridge();
            employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);

        } catch (Exception e)
        {
            LOGGER.error("Error in getting employeeId" + e.getMessage(), e);
        }
        return employeeId != null ? employeeId : StringPool.BLANK;*/
        return employeeId;
    }

    /**
     * Get value of Expando Arrtibute Supervisor Id
     * 
     * @param user
     * @return
     */
    public static String getExpandoSupervisorId(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String supervisorId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_MANAGER_ID);

        return supervisorId != null ? supervisorId : StringPool.BLANK;
    }

    /**
     * Get value of Expando Arrtibute Terrority 
     * 
     * @param user
     * @return
     */
    public static String getExpandoTerrority(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);

        return employeeId != null ? employeeId : StringPool.BLANK;
    }

    /**
     * Get value of Expando Arrtibute Terrority Code
     * 
     * @param user
     * @return
     */
    public static String getExpandoTerrorityCode(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String terrorityCode = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_TERRORITY_CODE);

        return terrorityCode != null ? terrorityCode : StringPool.BLANK;
    }

    /**
     * This method will return Employee Full Name from the employee ID.
     * @param themeDisplay 
     * 
     * @param employeeId
     * @return
     */
    public static User getManagerUserDataByExpandoSupervisorId(String supervisorId, ThemeDisplay themeDisplay)
    {
        User user = null;
        User managerUser = null;
        String employeeId = StringPool.BLANK;

        long empId = 0;

        long supervisorEmployeeId = Long.parseLong(supervisorId);
        try
        {
            List<ExpandoValue> expandoValues = ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),User.class.getName(),
                    ExpandoTableConstants.DEFAULT_TABLE_NAME, PGCCommonConstants.EXPANDO_MANAGER_ID, -1, -1);

            for (ExpandoValue expandoValue : expandoValues)
            {
                if (expandoValue.getClassPK() != 0)
                {
                    try
                    {
                        long userId = expandoValue.getClassPK();
                        user = UserLocalServiceUtil.getUserById(userId);

                        if (user != null)
                        {
                            employeeId = getExpandoEmployeeId(user);

                            if (Validator.isNotNull(employeeId))
                            {
                                empId = Long.parseLong(employeeId);
                                if (supervisorEmployeeId == empId)
                                {

                                    managerUser = user;

                                    break;
                                }
                            }

                        }
                    } catch (Exception e)
                    {
                        LOGGER.error("PGC:Error while getting user for the expando value:" + e.getMessage(), e);
                    }
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("PGC:Error while getting user for the expando value:" + e.getMessage(), e);
        }
        return managerUser;
    }

    /**
     * Get logged in Requestor Information
     * @param Request
     * @return RequestorInformation
     */
    public static RequestorInformation getRequestorDetails(HttpServletRequest request, String populate)
            throws SystemException, PortalException
    {

        String supervisorId = StringPool.BLANK;
        String creatorEmployeeId = StringPool.BLANK;
        User userManagerObj = null;
        java.util.Date dateSubmitted = new java.util.Date();
        long requestorId = ParamUtil.getLong(request, "requestorId");
        RequestorInformation reqInfo = new RequestorInformation();
        User user = null;
        if (populate.equalsIgnoreCase("yes"))
        {
				user = UserLocalServiceUtil.getUserById(requestorId);
        } else
        {
            user = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
            creatorEmployeeId = getExpandoEmployeeId(user);
            reqInfo.setCreatedUserEmployeeId(creatorEmployeeId);
        }

        try
        {
           PGCCommonUtil.setExpandoPermissions(user.getCompanyId());
        } catch (PortalException pe)
        {
            LOGGER.error("Error in setting expandopermission" + pe.getMessage(), pe);
        }
        if (Validator.isNotNull(user))
        {
            supervisorId = getExpandoSupervisorId(user);

        }

        if (Validator.isNotNull(supervisorId))
        {
            try
            {
                userManagerObj = getManagerUserDataByExpandoSupervisorId(supervisorId,((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)));
            } catch (Exception e)
            {
                LOGGER.error("PGC:Error while getting manager user for the expando value:" + e.getMessage(), e);
            }

        }

        reqInfo.setRequestorName(user.getFullName());
        reqInfo.setCreatedBy(user.getFullName());

        reqInfo.setRequestorId(user.getUserId());
        reqInfo.setEmail(user.getEmailAddress());
        reqInfo.setDateCompleted(dateSubmitted);
        if (Validator.isNotNull(userManagerObj))
        {
            reqInfo.setManagerName(userManagerObj.getFullName());
            reqInfo.setManagerEmail(userManagerObj.getEmailAddress());
            reqInfo.setManagerEmployeeId(getExpandoEmployeeId(userManagerObj));

        }
        List<Phone> phones = new ArrayList<Phone>();
        
        String phoneNo = "";
        try
        {
            phones = PhoneLocalServiceUtil.getPhones(user.getCompanyId(), Contact.class.getName(), user.getContactId());

        } catch (SystemException se)
        {
            LOGGER.error("Error in getting Business Phone Number" + se.getMessage(), se);
        }

        for (Phone phone : phones)
        {
            String phoneType = phone.getType().getName();

            if ("Business".equals(phoneType))
            {
                phoneNo = phone.getNumber();
            }
        }
        reqInfo.setBusinessPhone(phoneNo);
        reqInfo = getCustomAttributes(user, reqInfo);
        return reqInfo;
    }

    public static String getResponseContentType(String fileName)
    {
        String responseType = StringPool.BLANK;
        if (fileName.indexOf("doc") > -1)
        {
            responseType = "application/vnd.ms-word";
        }
        if (fileName.indexOf("rtf") > -1)
        {
            responseType = "application/rtf";
        } else if (fileName.indexOf("xls") > -1)
        {
            responseType = "application/vnd.ms-excel";
        } else if (fileName.indexOf("ppt") > -1)
        {
            responseType = "application/ppt";
        } else if (fileName.indexOf("xml") > -1)
        {
            responseType = "text/xml";
        } else if (fileName.indexOf("html") > -1)
        {
            responseType = "text/html";
        } else if (fileName.indexOf("htm") > -1)
        {
            responseType = "text/htm";
        } else if (fileName.indexOf("txt") > -1 || fileName.indexOf("log") > -1)
        {
            responseType = "text/plain";
        } else if (fileName.indexOf("pdf") > -1)
        {
            responseType = "application/pdf";
        } else if (fileName.indexOf("gif") > -1)
        {
            responseType = "image/gif";
        } else if (fileName.indexOf("png") > -1)
        {
            responseType = "image/png";
        } else if (fileName.indexOf("jpg") > -1)
        {
            responseType = "image/jpg";
        } else if (fileName.indexOf("jpeg") > -1)
        {
            responseType = "image/JPEG";
        } else if (fileName.indexOf("jpe") > -1)
        {
            responseType = "image/JPEG";
        } else if (fileName.indexOf("bmp") > -1)
        {
            responseType = "image/bmp";
        } else if (fileName.indexOf("jpeg") > -1)
        {
            responseType = "image/JPEG";
        } else if (fileName.indexOf("tiff") > -1)
        {
            responseType = "image/tiff";
        } else if (fileName.indexOf("tif") > -1)
        {
            responseType = "image/tiff";
        } else if (fileName.indexOf("html") > -1)
        {
            responseType = "text/html";
        } else
        {
            responseType = "application/octet-stream";
        }
        return responseType;
    }

    /**
     * This method will return Employee Full Name from the employee ID.
     * 
     * @param employeeId
     * @return
     */
    public static User getUserDataByExpandoEmployeeId(String employeeId,ThemeDisplay themeDisplay) throws Exception
    {
        User requestorUser = null;
        try
        {       
            List<ExpandoValue> expandoValues = ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),User.class.getName(),
                    ExpandoTableConstants.DEFAULT_TABLE_NAME, PGCCommonConstants.EXPANDO_EMPLOYEE_ID, -1, -1);

            if (expandoValues != null)
            {
                for (ExpandoValue expandoValue : expandoValues)
                {
                    if (expandoValue.getClassPK() != 0)
                    {
                        try
                        {
                            if (employeeId.equals(expandoValue.getData()))
                            {
                                long userId = expandoValue.getClassPK();
                                requestorUser = UserLocalServiceUtil.getUserById(userId);
                            }
                        } catch (Exception e)
                        {
                            LOGGER.error("PGC:Error while getting user for the expando eomployeeId:" + e.getMessage(), e);
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("PGC:Error while getting user for the expando employeeId:" + e.getMessage(), e);
        }
        return requestorUser;
    }

    /**
     * This method checks wthether logged in user is a dsi eomplyee or not
     * @param renderRequest
     * @return boolean
     */
    public static boolean IsDSIEmployee(User user)
    {
        boolean dsiemployee = false;

        String employeeId = getExpandoEmployeeId(user);
        if (Validator.isNotNull(employeeId))
        {
            dsiemployee = true;
        }
        return dsiemployee;

    }
    
    
    /**
     * This method checks whether logged in user is from Field sales employee or not
     * @param renderRequest
     * @return boolean
     */
    public static int getEmployeeType(User user)
    {
        int employee = 0;
        EmployeeDataDump empDataDemp = null;

        try
        {
        	
            empDataDemp = EmployeeDataDumpLocalServiceUtil.getEmployeeDataDump("10080059");
            LOGGER.info("empDataDump is "+empDataDemp);
        } catch (PortalException e)
        {
            LOGGER.error("Portal Exception", e);
        } catch (SystemException e)
        {
            LOGGER.error("System Exception", e);
        }
        
        
        if (Validator.isNotNull(empDataDemp))
        {
        	 //DSI:START::Veera Reddy:: To provide different logic for employee based on sub area code 
            String[] employeeSubAreaCodesGrp1 = PortletProps.getArray("employee_personnel_sub_area_code_group1");
            String[] employeeSubAreaCodesGrp2 = PortletProps.getArray("employee_personnel_sub_area_code_group2");
            for (int i = 0; i < employeeSubAreaCodesGrp1.length; i++)
            {
                if (empDataDemp.getPersonnelSubAreaCode().equalsIgnoreCase(employeeSubAreaCodesGrp1[i]))
                {
                    employee = 1;
                    return employee;
                }
            }
            for (int i = 0; i < employeeSubAreaCodesGrp2.length; i++)
            {
                if (empDataDemp.getPersonnelSubAreaCode().equalsIgnoreCase(employeeSubAreaCodesGrp2[i]))
                {
                    employee = 2;
                    return employee;
                }
            }
            //DSI:END::Veera Reddy::To provide different logic for employee based on sub area code 
        }
        LOGGER.info("employee is "+employee);
        return employee;
    }

    /**
     * This method checks whether edit action can be enabled or not depends upon the status
     * @param renderRequest
     * @return boolean
     */
    public static boolean isStatusEdit(String status, String type)
    {
        String[] statusEditList = PGCCommonConstants.PGC_STATUS_EDIT_ALLOWED;
        for (String stat : statusEditList)
        {
            if (status.equalsIgnoreCase("PGC Approved-Agreement Pending"))
            {
                if (type.equalsIgnoreCase("dsi_pgc_display_exhibit") || type.equalsIgnoreCase("dsi_pgc_corp_sup") || type.equalsIgnoreCase("dsi_pgc_charitable_donation")) 
                {
                    return true;
                }
            } else if (status.equalsIgnoreCase(stat))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method makes the bean information to empty
     * @param pgcForm
     * @return PGC form
     */
    public static PGCForm setBlockValuesToNull(PGCForm appForm, boolean remeoveAll)
    {
        CheckRequestInformation checkInfo = new CheckRequestInformation();
        ProductInformation productInfo = new ProductInformation();
        DisplayExhibitInformation displayInfo = new DisplayExhibitInformation();
        BudgetInformation budgetInfo = new BudgetInformation();
        POMembershipInformation poMembershipInfo = new POMembershipInformation();
        EducationalItemsInformation educationalItemsInfo = new EducationalItemsInformation();
        ContractInformation contractInfo = new ContractInformation();
        ServiceAgreement serviceAgreementInfo = new ServiceAgreement();
        HCPConsultant hcpConsultant = new HCPConsultant();
        AdvisoryBoardInformation advisoryInfo = new AdvisoryBoardInformation();
        CorporateSupportInformation corporateInfo = new CorporateSupportInformation();
        CharitableDonationInformation donationInfo = new CharitableDonationInformation();
        GeneralRequestInformation requestInfo = new GeneralRequestInformation();
        if (remeoveAll)
        {
            RequestorInformation reqInfo = new RequestorInformation();
            appForm.setReqInfo(reqInfo);
        }
        appForm.setCheckReqInfo(checkInfo);
        appForm.setProductInfo(productInfo);
        appForm.setDispExhibitInfo(displayInfo);
        appForm.setBudgetInfo(budgetInfo);
        appForm.setPOMemInfo(poMembershipInfo);
        appForm.setEduItemsInfo(educationalItemsInfo);
        appForm.setContractInfo(contractInfo);
        appForm.setServiceAgreement(serviceAgreementInfo);
        appForm.setHcpConsultantInfo(hcpConsultant);
        appForm.setAdvisoryBoardInfo(advisoryInfo);
        appForm.setCorporateSupportInformation(corporateInfo);
        appForm.setDonationInfo(donationInfo);
        appForm.setRequestInfo(requestInfo);
        appForm.setFormStatus("");
        appForm.setFormId("");
        appForm.setFormVersion("");
        appForm.setRequestId("");
        appForm.setObjectId("");
        appForm.setFormStatus("");
        appForm.setFormTitle("");
        return appForm;
    }

    /**
     * Set view permissions to the expando attribute
     * 
     * @param companyId
     * @throws PortalException
     * @throws SystemException
     */
    public static void setExpandoPermissions(long companyId) throws PortalException, SystemException
    {

        ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(companyId,User.class.getName());

        ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(companyId,expandoBridge.getClassName(),
                        ExpandoTableConstants.DEFAULT_TABLE_NAME, PGCCommonConstants.EXPANDO_MANAGER_ID);
        
        //IntranetCommonUtil.setResourcePermissions(companyId, 0, RoleConstants.USER, ExpandoColumn.class.getName(), String.valueOf(column.getColumnId()), new String[] { ActionKeys.VIEW });
    }
  //DSI:START::Veera Reddy:: To create out going request xmls
    /**
     * 
     * @param formType
     * @param xmlContent
     */
    public static void createXml(String formType,String xmlContent)
    {
    	String pgcTrackFolderPath = PortalUtil.getPortalWebDir()+"../../pgcTrack/";
    	File pgcTrackDir = new File(pgcTrackFolderPath);
    	if(!pgcTrackDir.exists()){
    		pgcTrackDir.mkdir();
    	}
    	String fileName=formType+StringPool.UNDERLINE +getDateTime()+".xml";
    	BufferedWriter out = null;
    	try{
	    	out = new BufferedWriter(new FileWriter(pgcTrackFolderPath+fileName));
			out.write(xmlContent);
			out.close();
		} 
		catch (IOException e) { 
			 LOGGER.error("while creating request Xml:" +e.getCause());
		}
		finally {
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					 LOGGER.error("while closing writer object : " +e.getCause());
				}
			}
		}
    }
    /**
     * 
     * @return dateTime
     */
    private  final static String getDateTime()  
    {  
    	String dateTime = null;
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy_hh:mm:ss");  
        df.setTimeZone(TimeZone.getTimeZone("EST"));  
        dateTime = df.format(new Date());  
        return dateTime.replaceAll(":","-");
    }  
  //DSI:END::Veera Reddy::  To create out going request xmls    
    
    public static String wbselementValidation(String dataValue){
    	
    	 String wbselementData = "";
    	try {
			List<WBSElements> wbsElementsList = WBSElementsLocalServiceUtil.getWBSElementses(-1, -1);
			List<String> wbsPosidList = new ArrayList<String>();
			for(WBSElements wbsElements :wbsElementsList){
				wbsPosidList.add(wbsElements.getPosid());
			}
			wbselementData = costOrWbsDataCheck(HttpUtil.decodeURL(dataValue),wbsPosidList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return wbselementData;
    }
    
 public static String costCenterValidation(String dataValue){
      
	 String costCenterErrorData = "";
	 try {
		List<CostCenter>  costCenterList = CostCenterLocalServiceUtil.getCostCenters(-1, -1);
		List<String> costKostlList = new ArrayList<String>();
		for(CostCenter costCenter :costCenterList){
			costKostlList.add(costCenter.getKostl());
		}
		costCenterErrorData = costOrWbsDataCheck(dataValue,costKostlList);
	
	} catch (SystemException e) {
		e.printStackTrace();
	}
    return costCenterErrorData;
}
 /**
  * cost center and wbs element data check
  * 
  * @param dataValue
  * @param list
  */
 public static String costOrWbsDataCheck(String dataValue,List<String> list){
	 List<String> dataList = Arrays.asList(dataValue.split(","));
	 StringBuilder sepValueBuilder = new StringBuilder();

		for(String autoPickValue :dataList ){
			if(!list.contains(autoPickValue)){
				sepValueBuilder.append(autoPickValue).append(',');
			}
		}
		if(sepValueBuilder.length() > 0 ){
			 return sepValueBuilder.substring(0, sepValueBuilder.length() - 1);
		 }else{
			 return "";
		 }
   }
 
 public static List<PGCRequestSummary> dashBoardStatusList(List<PGCRequestSummary> reqsList){
	   
	   List<PGCRequestSummary> filteredList =  new ArrayList<PGCRequestSummary>();
  	for(PGCRequestSummary pgcRequestSummary : reqsList){
  		if(!pgcRequestSummary.getStatus().equals("PGC Cancelled")){
  			filteredList.add(pgcRequestSummary);
  		}
  	}
	   return filteredList;
  }
}
