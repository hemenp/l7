/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.rfc.model.CostCenter;
import com.dsi.intranet.rfc.model.GLAccounts;
import com.dsi.intranet.rfc.model.Vendor;
import com.dsi.intranet.rfc.model.WBSElements;
import com.dsi.intranet.rfc.service.CostCenterLocalServiceUtil;
import com.dsi.intranet.rfc.service.GLAccountsLocalServiceUtil;
import com.dsi.intranet.rfc.service.VendorLocalServiceUtil;
import com.dsi.intranet.rfc.service.WBSElementsLocalServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * <a href="EprocureAutoCompleteUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Author Devaki Subramaniam
 * @Description EprocureAutoCompleteUtil class
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public final class EprocureAutoCompleteUtil
{
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(EprocureAutoCompleteUtil.class);

    private static final String COMPANY_ID = "companyId";
    private static final String COSTCENTER_END_TAG = "</costcenter>";
    private static final String COSTCENTER_START_TAG = "<costcenter>";
    private static final String COSTCENTER_ID_END_TAG = "</costcenterId>";
    private static final String COSTCENTER_ID_START_TAG = "<costcenterId>";
    private static final String COSTCENTERS_END_TAG = "</costcenters>";
    private static final String COSTCENTERS_START_TAG = "<costcenters>";
    private static final String EMAIL_END_TAG = "</email>";
    private static final String EMAIL_START_TAG = "<email>";
    private static final String GLACCOUNT_END_TAG = "</glaccount>";
    private static final String GLACCOUNT_START_TAG = "<glaccount>";
    private static final String GLACCOUNT_ID_END_TAG = "</glaccountId>";
    private static final String GLACCOUNT_ID_START_TAG = "<glaccountId>";
    private static final String GLACCOUNTS_END_TAG = "</glaccounts>";
    private static final String GLACCOUNTS_START_TAG = "<glaccounts>";
    private static final String JOB_TITLE_END_TAG = "</jobTitle>";
    private static final String JOB_TITLE_START_TAG = "<jobTitle>";
    private static final String KEYWORD_PARAM = "q";
    private static final String NAME_END_TAG = "</name>";
    private static final String NAME_START_TAG = "<name>";
    private static final String USER_END_TAG = "</user>";
    private static final String USER_ID_END_TAG = "</userId>";
    private static final String USER_ID_START_TAG = "<userId>";
    private static final String USER_START_TAG = "<user>";
    private static final String USERS_END_TAG = "</users>";
    private static final String USERS_START_TAG = "<users>";
    private static final String VENDOR_END_TAG = "</vendor>";
    private static final String VENDOR_START_TAG = "<vendor>";
    private static final String VENDORS_END_TAG = "</vendors>";
    private static final String VENDORS_START_TAG = "<vendors>";
    private static final String VENDOR_CODE_END_TAG = "</vendorcode>";
    private static final String VENDOR_CODE_START_TAG = "<vendorcode>";
    private static final String WBSELEMENT_END_TAG = "</wbselement>";
    private static final String WBSELEMENT_START_TAG = "<wbselement>";
    private static final String WBSELEMENT_ID_END_TAG = "</wbselementId>";
    private static final String WBSELEMENT_ID_START_TAG = "<wbselementId>";
    private static final String WBSELEMENTS_END_TAG = "</wbselements>";
    private static final String WBSELEMENTS_START_TAG = "<wbselements>";

    /**
     * method to construct xml element for cost center
     * @param query
     * @param costCenter
     * @param xmlObject
     */
    
    private EprocureAutoCompleteUtil()
    {
    	
    }
    
    private static void addCostCenterXMLElement(Object costCenter, StringBuilder xmlObject)
    {
        xmlObject.append(COSTCENTER_START_TAG);
        xmlObject.append(NAME_START_TAG + ((CostCenter) costCenter).getKostl() + NAME_END_TAG);
        xmlObject.append(COSTCENTER_ID_START_TAG + ((CostCenter) costCenter).getId() + COSTCENTER_ID_END_TAG);
        xmlObject.append(COSTCENTER_END_TAG);
    }

    /**
     * method to construct xml element for GLAccount
     * @param query
     * @param glAccount
     * @param xmlObject
     */
    private static void addGlAccountXMLElement(Object glAccount, StringBuilder xmlObject)
    {
        xmlObject.append(GLACCOUNT_START_TAG);
        xmlObject.append(NAME_START_TAG + ((GLAccounts) glAccount).getNumber() + NAME_END_TAG);
        xmlObject.append(GLACCOUNT_ID_START_TAG + ((GLAccounts) glAccount).getId() + GLACCOUNT_ID_END_TAG);
        xmlObject.append(GLACCOUNT_END_TAG);
    }

    /**
     * method to construct xml element for user
     * @param query
     * @param user
     * @param xmlObject
     * @return
     */
    private static boolean addUserXMLElement(String query, User user, StringBuilder xmlObject)
    {
        boolean isUserAdded = false;
        if (user.getFirstName().toLowerCase().startsWith(query) || user.getLastName().toLowerCase(Locale.getDefault()).startsWith(query))
        {
            xmlObject.append(USER_START_TAG);
            xmlObject.append(NAME_START_TAG + user.getFullName() + NAME_END_TAG);
            xmlObject.append(USER_ID_START_TAG + user.getUserId() + USER_ID_END_TAG);
            xmlObject.append(JOB_TITLE_START_TAG + HtmlUtil.escape(user.getJobTitle()) + JOB_TITLE_END_TAG);
            xmlObject.append(EMAIL_START_TAG + user.getEmailAddress() + EMAIL_END_TAG);
            xmlObject.append(USER_END_TAG);
            isUserAdded = true;
        }
        return isUserAdded;
    }

    /**
     * method to construct xml element for vendor
     * @param query
     * @param vendor
     * @param xmlObject
     */
    private static void addVendorXMLElement(Object vendor, StringBuilder xmlObject)
    {
        xmlObject.append(VENDOR_START_TAG);
        xmlObject.append(NAME_START_TAG + HtmlUtil.escape(((Vendor) vendor).getVendorName1()) + NAME_END_TAG);
        xmlObject.append(VENDOR_CODE_START_TAG + ((Vendor) vendor).getAccountNumber() + VENDOR_CODE_END_TAG);
        xmlObject.append(EMAIL_START_TAG + ((Vendor) vendor).getEmailAddress() + EMAIL_END_TAG);
        xmlObject.append(VENDOR_END_TAG);
    }

    /**
     * method to construct xml element for WBS element
     * @param query
     * @param wbsElement
     * @param xmlObject
     */
    private static void addWbsElementXMLElement(Object wbsElement, StringBuilder xmlObject)
    {
    	WBSElements wbsElements=(WBSElements) wbsElement;
    	StringBuilder name=new StringBuilder(wbsElements.getPosid());
    	
        if(Validator.isNotNull(wbsElements.getPost1())){
        	name.append(StringPool.SPACE);
        	name.append(StringPool.PIPE);
        	name.append(StringPool.SPACE);
        	name.append(wbsElements.getPost1().replace("&", " "));
        }
        
        if(Validator.isNotNull(wbsElements.getVerna())){
        	name.append(StringPool.SPACE);
        	name.append(StringPool.PIPE);
            name.append(StringPool.SPACE);
            name.append(wbsElements.getVerna().replace("&"," "));
        }
        
        
        xmlObject.append(WBSELEMENT_START_TAG);
        xmlObject.append(NAME_START_TAG + name + NAME_END_TAG);
        xmlObject.append(WBSELEMENT_ID_START_TAG + wbsElements.getElementId() + WBSELEMENT_ID_END_TAG);
        xmlObject.append(WBSELEMENT_END_TAG);
    }

    /**
     * This method is resposible for returning user or vendor or cost center or wbs values for auto complete
     * @param request
     * @return String 
     */
    public static String getData(HttpServletRequest request)
    {
        long companyId = Long.valueOf(request.getParameter(COMPANY_ID));
        String data = request.getParameter("data");
        String query = request.getParameter(KEYWORD_PARAM);
        LOGGER.info("inside getData method==" + query);
        List<User> userList = null;
        String resultString=StringPool.BLANK;
        if (Validator.isNotNull(data) && data.equalsIgnoreCase("workflow"))
        {
            LOGGER.info("if user for workflow....");
            userList = getWorkflowUsers(query, companyId);
            LOGGER.info("Userlist size==" + userList.size());
            resultString= getXMLUser(userList, query);
        } else if (data.equalsIgnoreCase("vendor"))
        {
        	resultString=getVendors(companyId, query);
        } else if (data.equalsIgnoreCase("supervisor"))
        {
        	resultString=getSupervisor(companyId, query);
        } else if (data.equalsIgnoreCase("wbselement"))
        {
        	resultString=getWBSElement(companyId, query);
        } else if (data.equalsIgnoreCase("glAcccount"))
        {
        	resultString=getGLAccount(companyId, query);
        } else if (data.equalsIgnoreCase("costInfo"))
        {
        	resultString=getCostCenter(companyId, query);

        } else if (data.equalsIgnoreCase("user"))
        {
        	resultString=getUsers(companyId, query, WorkflowConstants.STATUS_APPROVED);
        }
        else if (data.equalsIgnoreCase("alluser"))
        {
        	resultString=getUsers(companyId, query, WorkflowConstants.STATUS_ANY);
        }
        else if(data.equalsIgnoreCase("webadmin"))
        {
        	resultString=getWebAdminUsers(companyId, query);
        }
       
        return resultString;
    }
    
     
    private static String getVendors(long companyId,String query){
    	StringBuilder xmlObject=new StringBuilder();
    	try
        {
            List<Object> vendorList = searchVendorName(companyId, query);
            if (Validator.isNotNull(vendorList))
            {
                int count = 0;
                xmlObject.append(VENDORS_START_TAG);

                for (Object vendor : vendorList)
                {
                    addVendorXMLElement(vendor, xmlObject);
                    count = count + 1;
                    if (count >= EProcurementConstants.NUMBER_15)
                    {
                        break;
                    }
                }
                xmlObject.append(VENDORS_END_TAG);

            }
        } catch (SystemException se)
        {
            LOGGER.error("error in searchVendorName: " + se.getMessage(), se);
        }
    	return xmlObject.toString();
    }
    
    private static String getSupervisor(long companyId,String query){
    	List<User> userList = getUserFromUserGroup(companyId, query);
    	return getXMLUser(userList, query);
    }
    
    private static String getWBSElement(long companyId,String query){
    	StringBuilder xmlObject=new StringBuilder();
    	try
        {
    		List<Object> wbsList = searchWBSElements(companyId, query);
    		if (Validator.isNotNull(wbsList))
            {
                int count = 0;
                xmlObject.append(WBSELEMENTS_START_TAG);
                for (Object wbsElement : wbsList)
                {
                    addWbsElementXMLElement(wbsElement, xmlObject);
                    count = count + 1;
                    if (count >= 30)
                    {
                        break;
                    }
                }
                xmlObject.append(WBSELEMENTS_END_TAG);
            }
        } catch (SystemException se)
        {
            LOGGER.error("error in searchWBSElements: " + se.getMessage(), se);
        }
    	return xmlObject.toString();
    }
    
    private static String getGLAccount(long companyId,String query){
    	StringBuilder xmlObject=new StringBuilder();
    	try
        {
            List<Object> glAccountList = searchGlAccountNumber(companyId, query);
            if (Validator.isNotNull(glAccountList))
            {
                int count = 0;
                xmlObject.append(GLACCOUNTS_START_TAG);
                for (Object glAccount : glAccountList)
                {
                    addGlAccountXMLElement(glAccount, xmlObject);
                    count = count + 1;
                    if (count >= EProcurementConstants.NUMBER_15)
                    {
                        break;
                    }
                }
                xmlObject.append(GLACCOUNTS_END_TAG);
            }
        } catch (SystemException se)
        {
            LOGGER.error("error in searchGlAccountNumber: " + se.getMessage(), se);
        }
    	return xmlObject.toString();
    }

    private static String getCostCenter(long companyId,String query){
    	StringBuilder xmlObject=new StringBuilder();
    	try
        {
            List<Object> costCenterList = searchCostCenter(companyId, query);
            if (Validator.isNotNull(costCenterList))
            {
                int count = 0;
                xmlObject.append(COSTCENTERS_START_TAG);
                for (Object costCenter : costCenterList)
                {
                    addCostCenterXMLElement(costCenter, xmlObject);
                    count = count + 1;
                    if (count >= EProcurementConstants.NUMBER_15)
                    {
                        break;
                    }
                }
                xmlObject.append(COSTCENTERS_END_TAG);
            }
        } catch (SystemException se)
        {
            LOGGER.error("error in searchWBSElements: " + se.getMessage(), se);
        }
    	return xmlObject.toString();
    }
    
    private static String getUsers(long companyId,String query, int status){
    	List<User> userList = getUsers(query, companyId, status);
    	return getXMLUser(userList, query);
    }
    private static String getXMLUser(List<User> userList,String query){
    	StringBuilder xmlObject=new StringBuilder();
    	if (Validator.isNotNull(userList))
        {
            int count = 0;
            boolean userAddedToXML = false;
            xmlObject.append(USERS_START_TAG);
            for (User user : userList)
            {
                userAddedToXML = addUserXMLElement(query, user, xmlObject);
                if (userAddedToXML)
                {
                    count = count + 1;
                    if (count >= EProcurementConstants.NUMBER_25)
                    {
                        break;
                    }
                }
            }
            xmlObject.append(USERS_END_TAG);
            LOGGER.info("xmlObject in autocompleteutil= " + xmlObject);
        }
    	return xmlObject.toString();
    }
    /**
     * method to get all users available in instance
     * @param query
     * @param companyId
     * @return List<User>
     */
    private static List<User> getUsers(String query, long companyId, int status)
    {
        List<User> userList = new ArrayList<User>();
        try
        {
            OrderByComparator obc = null;
            userList = UserLocalServiceUtil.search(companyId, query, status, new LinkedHashMap<String, Object>(), -1, -1,
                    obc);
            
            
            		
        } catch (SystemException e)
        {
            LOGGER.error("Error while retrieving users " + e.getMessage(), e);
        }

        return userList;
    }

    /**
     * method to get all users whose jobtile is not empty
     * @param query
     * @param companyId
     * @return List<User>
     */
    private static List<User> getWorkflowUsers(String query, long companyId)
    {
        List<User> userList = new ArrayList<User>();
        List<User> workflowUsers = new ArrayList<User>();
        try
        {
            OrderByComparator obc = null;
            userList = UserLocalServiceUtil.search(companyId, query, WorkflowConstants.STATUS_APPROVED, new LinkedHashMap<String, Object>(), -1, -1,
                    obc);
        } catch (SystemException e)
        {
            LOGGER.error("Error while retrieving users " + e.getMessage(), e);
        }

        for (User user : userList)
        {
            if (Validator.isNotNull(user.getJobTitle()))
            {
                workflowUsers.add(user);
            }
        }
        return workflowUsers;
    }

    /**
     * Search Cost Centers by keyword
     * 
     * @param companyId
     * @param keywords
     * 
     * @throws SystemException
     */
    private static List<Object> searchCostCenter(long companyId, String keywords) throws SystemException
    {
        List<Object> costCenterList = CostCenterLocalServiceUtil.findByKostl(companyId, keywords);

        return costCenterList;
    }

    /**
     * Search GlAccout number by keyword
     * 
     * @param companyId
     * @param keywords
     * 
     * @throws SystemException
     */
    private static List<Object> searchGlAccountNumber(long companyId, String keywords) throws SystemException
    {
        String applicationName = EProcurementConstants.GLACCOUNT_APPLICATIONNAME;
        List<Object> glAccountList = GLAccountsLocalServiceUtil.findByAccountNumberAndName(companyId, keywords,
                applicationName);

        return glAccountList;
    }

    /**
     * Search  users from supervisor user groups
     * 
     * @param companyId
     * @param userGroupName
     * @param keywords
     */
    private static List<User> searchSupervisorUsers(long companyId, String userGroupName)
    {
        
        List<User> supervisorUsers = null;
        try
        {
            UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, userGroupName);
            supervisorUsers = UserLocalServiceUtil.getUserGroupUsers(userGroup.getUserGroupId());

        } catch (NoSuchUserGroupException nsuge)
        {
            LOGGER.error("UserGroup does not exist with name:" + userGroupName + nsuge.getMessage(), nsuge);
        } catch (Exception se)
        {
            LOGGER.error("Error while getting user group:" + se.getMessage(), se);
        }
        return supervisorUsers;
    }
    
    public static List<User> getUserFromUserGroup(long companyId,String keywords){
        
        String[] superVisorGroupNames = EProcurementConstants.EPROC_SUPERVISOR_GROUPS;
        List<User> allSuperVisorList = new ArrayList<User>();
        for(String userGroupName : superVisorGroupNames){
            
            List<User> supervisorUsers = searchSupervisorUsers(companyId, userGroupName);
            if(Validator.isNotNull(supervisorUsers)){
                allSuperVisorList.addAll(supervisorUsers);
            }
        }
        return allSuperVisorList;
    }

    /**
     * Search Vendor Names by keyword
     * 
     * @param companyId
     * @param keywords
     * @param jsonObject
     * @throws SystemException
     */
    private static List<Object> searchVendorName(long companyId, String keywords) throws SystemException
    {
        List<Object> vendorList = VendorLocalServiceUtil.findByVendorName(companyId, keywords);

        return vendorList;
    }

    /**
     * Search WBS elements by keyword
     * 
     * @param companyId
     * @param keywords
     * @param jsonObject
     * @throws SystemException
     */
    private static List<Object> searchWBSElements(long companyId, String keywords) throws SystemException
    {
    	List<Object> wbsList = WBSElementsLocalServiceUtil.findByPosId(companyId, keywords);

        return wbsList;
    }
    
    
    /**
     * search web admin users
     * 
     * @param companyId
     * @return List<User>
     */
    private static List<User> getWebAdminUsersList(long companyId){
    	List<User> userList = new ArrayList<User>();
    	
    	Role role = null;
		try {
			role = EProcurementUtil.getEprocWebAdminRole(companyId);
		} catch (PortalException e) {
			 LOGGER.error("Problem while retrieving web admin role : " + e.getMessage());
		} catch (SystemException e) {
			 LOGGER.error("Problem while retrievingweb admin role : " + e.getMessage());
		}
    	
    	if(Validator.isNotNull(role)){
    		try {
				userList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
			} catch (SystemException e) {
				 LOGGER.error("Problem while retrieving users with web amin roleId : " + role.getRoleId());
			}
    	}
    	
    	return userList;
    }
    
    /**
     * Search Web Admin users and return details in xml
     * 
     * @param companyId
     * @param query
     */
    private static String getWebAdminUsers(long companyId,String query){
    	List<User> webAdminUsersList = getWebAdminUsersList(companyId);
    	return getXMLUser(webAdminUsersList, query);
    }

}