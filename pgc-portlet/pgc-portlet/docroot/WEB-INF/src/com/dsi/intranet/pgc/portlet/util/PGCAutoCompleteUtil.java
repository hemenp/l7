/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.rfc.model.CostCenter;
import com.dsi.intranet.rfc.model.WBSElements;
import com.dsi.intranet.rfc.service.CostCenterLocalServiceUtil;
import com.dsi.intranet.rfc.service.WBSElementsLocalServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;


/**
 * <a href="PGCCommonUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project PGC
 * @Author Resmy Mathew
 * @Description Common Utility class for pgc.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */

public final class PGCAutoCompleteUtil
{
	private PGCAutoCompleteUtil(){}
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(PGCAutoCompleteUtil.class);

    private static final String COMPANY_ID = "companyId";
    private static final String COSTCENTER_END_TAG = "</costcenter>";
    private static final String COSTCENTER_ID_END_TAG = "</costcenterId>";
    private static final String COSTCENTER_ID_START_TAG = "<costcenterId>";
    private static final String COSTCENTER_START_TAG = "<costcenter>";
    private static final String COSTCENTERS_END_TAG = "</costcenters>";
    private static final String COSTCENTERS_START_TAG = "<costcenters>";
    private static final String EMAIL_END_TAG = "</email>";
    private static final String EMAIL_START_TAG = "<email>";
    private static final String EMPLOYEE_ID_END_TAG = "</employeeId>";
    private static final String EMPLOYEE_ID_START_TAG = "<employeeId>";
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
    private static final String WBSELEMENT_END_TAG = "</wbselement>";
    private static final String WBSELEMENT_ID_END_TAG = "</wbselementId>";
    private static final String WBSELEMENT_ID_START_TAG = "<wbselementId>";
    private static final String WBSELEMENT_START_TAG = "<wbselement>";
    private static final String WBSELEMENTS_END_TAG = "</wbselements>";
    private static final String WBSELEMENTS_START_TAG = "<wbselements>";

    /**
     * method to construct xml element for cost center
     * @param query
     * @param costCenter
     * @param xmlObject
     */
    private static void addCostCenterXMLElement(Object costCenter, StringBuilder xmlObject)
    {
        xmlObject.append(COSTCENTER_START_TAG);
        xmlObject.append(NAME_START_TAG + ((CostCenter) costCenter).getKostl() + NAME_END_TAG);
        xmlObject.append(COSTCENTER_ID_START_TAG + ((CostCenter) costCenter).getId() + COSTCENTER_ID_END_TAG);
        xmlObject.append(COSTCENTER_END_TAG);
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
        String employeeId = StringPool.BLANK;
        employeeId = PGCCommonUtil.getExpandoEmployeeId(user);

        if (user.getFirstName().toLowerCase().startsWith(query) || user.getLastName().toLowerCase().startsWith(query))
        {
            xmlObject.append(USER_START_TAG);
            xmlObject.append(NAME_START_TAG + user.getFullName() + NAME_END_TAG);
            xmlObject.append(USER_ID_START_TAG + user.getUserId() + USER_ID_END_TAG);
            xmlObject.append(EMPLOYEE_ID_START_TAG + employeeId + EMPLOYEE_ID_END_TAG);
            xmlObject.append(JOB_TITLE_START_TAG + HtmlUtil.escape(user.getJobTitle()) + JOB_TITLE_END_TAG);
            xmlObject.append(EMAIL_START_TAG + user.getEmailAddress() + EMAIL_END_TAG);
            xmlObject.append(USER_END_TAG);
            isUserAdded = true;
        }
        return isUserAdded;
    }

    /**
     * method to construct xml element for WBS element
     * @param query
     * @param wbsElement
     * @param xmlObject
     */
    private static void addWbsElementXMLElement(Object wbsElement, StringBuilder xmlObject)
    {
        xmlObject.append(WBSELEMENT_START_TAG);
        String posId = ((WBSElements) wbsElement).getPosid();
        xmlObject.append(NAME_START_TAG + posId.replaceAll("&(?!amp;)", "&amp;") + NAME_END_TAG);
        xmlObject.append(WBSELEMENT_ID_START_TAG + ((WBSElements) wbsElement).getElementId() + WBSELEMENT_ID_END_TAG);
        xmlObject.append(WBSELEMENT_END_TAG);
    }

    /**
     * This method is resposible for returning requestor or vice president or cost center 
     * or wbs values or manager
     * for auto complete
     * @param request
     * @return String 
     */
    public static String getData(HttpServletRequest request)
    {
        long companyId = Long.valueOf(request.getParameter(COMPANY_ID));
        String data = request.getParameter("data");
        String query = request.getParameter(KEYWORD_PARAM);
        StringBuilder xmlObject = new StringBuilder();
        List<User> userList = null;

        List<Object> wbsList = null;

        List<Object> costCenterList = null;
        // getting wbs elements
        if (data.equalsIgnoreCase("wbselement"))
        {
            try
            {
                wbsList = searchWBSElements(companyId, query);
            } catch (SystemException se)
            {
                LOGGER.error("error in searchWBSElements: " + se.getMessage(), se);
            }
            // getting cost center
        } else if (data.equalsIgnoreCase("costInfo"))
        {
            try
            {
                costCenterList = searchCostCenter(companyId, query);
            } catch (SystemException se)
            {
                LOGGER.error("error in searchWBSElements: " + se.getMessage(), se);
            }
            // getting requestor informarion
        } else if (data.equalsIgnoreCase("requestor"))
        {
            userList = getUsers(query, companyId);

        } else if (data.equalsIgnoreCase("vicepresident")) // getting vice
        // president group
        {

            userList = getVicePresidentFromUserGroup(companyId, query);

        } else if (data.equalsIgnoreCase("manager"))
        {

            userList = getManagerFromUserGroup(companyId, query);

        }

        if (Validator.isNotNull(wbsList))
        {
            int count = 0;
            xmlObject.append(WBSELEMENTS_START_TAG);
            for (Object wbsElement : wbsList)
            {
                addWbsElementXMLElement(wbsElement, xmlObject);
                count = count + 1;
                if (count >= PGCCommonConstants.AUTO_COMPLETE_COUNT)
                {
                    break;
                }
            }
            xmlObject.append(WBSELEMENTS_END_TAG);
        }

        if (Validator.isNotNull(costCenterList))
        {
            int count = 0;
            xmlObject.append(COSTCENTERS_START_TAG);
            for (Object costCenter : costCenterList)
            {
                addCostCenterXMLElement(costCenter, xmlObject);
                count = count + 1;
                if (count >= PGCCommonConstants.AUTO_COMPLETE_COUNT)
                {
                    break;
                }
            }
            xmlObject.append(COSTCENTERS_END_TAG);
        }
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
                    if (count >= PGCCommonConstants.AUTO_COMPLETE_COUNT)
                    {
                        break;
                    }
                }
            }
            xmlObject.append(USERS_END_TAG);

        }
        
        return xmlObject.toString();
    }

    /**
     * method to return manager user
     * @param query
     * @param user
     * @param xmlObject
     * @return
     */
    public static List<User> getManagerFromUserGroup(long companyId, String keywords)
    {

        String[] managerGroupNames = PGCCommonConstants.PGC_MANAGER_GROUPS;
        List<User> allManagerList = new ArrayList<User>();
        for (String userGroupName : managerGroupNames)
        {
            List<User> managerUsers = searchGroupUsers(companyId, userGroupName);
            if (Validator.isNotNull(managerUsers))
            {
                allManagerList.addAll(managerUsers);
            }
        }
        return allManagerList;
    }

    /**
     * method to get all users available in instance and 
     * checks for employeeId also.only dsi employees will be added
     * @param query
     * @param companyId
     * @return List<User>
     */
    private static List<User> getUsers(String query, long companyId)
    {
        List<User> userList = new ArrayList<User>();
        List<User> requestorsList = new ArrayList<User>();
        try
        {
			userList = UserLocalServiceUtil
					.search(companyId, query,
							WorkflowConstants.STATUS_APPROVED,
							new LinkedHashMap<String, Object>(),
							PGCCommonConstants.ALL_POS,
							PGCCommonConstants.ALL_POS,
							(OrderByComparator)null);
        } catch (SystemException e)
        {
            LOGGER.error("Error while retrieving users " + e.getMessage(), e);
        }
        // employeeId check
		if(Validator.isNotNull(userList)){
		        for (User user : userList)
		        {
		            if (PGCCommonUtil.IsDSIEmployee(user))
		
		            {
		                requestorsList.add(user);
		            }
		        }
		}
        return userList;
    }

    /**
     * method to return vice presient user
     * @param query
     * @param user
     * @param xmlObject
     * @return
     */
    public static List<User> getVicePresidentFromUserGroup(long companyId, String keywords)
    {

        String[] superVisorGroupNames = PGCCommonConstants.PGC_SUPERVISOR_GROUPS;
        List<User> allSuperVisorList = new ArrayList<User>();
        for (String userGroupName : superVisorGroupNames)
        {
            List<User> supervisorUsers = searchGroupUsers(companyId, userGroupName);
            if (Validator.isNotNull(supervisorUsers))
            {
                allSuperVisorList.addAll(supervisorUsers);
            }
        }
        return allSuperVisorList;
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
     * method to return user groups for different bands to select VP or manager users
     * @param query
     * @param user
     * @param xmlObject
     * @return
     */
    private static List<User> searchGroupUsers(long companyId, String userGroupName)
    {

        List<User> groupUsers = null;
        try
        {
            UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, userGroupName);
            groupUsers = UserLocalServiceUtil.getUserGroupUsers(userGroup.getUserGroupId());

        } catch (NoSuchUserGroupException nsuge)
        {
            LOGGER.error("UserGroup does not exist with name:" + userGroupName + nsuge.getMessage(), nsuge);
        } catch (Exception se)
        {
            LOGGER.error("Error while getting user group:" + se.getMessage(), se);
        }
        return groupUsers;
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

}
