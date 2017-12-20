/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import com.dsi.intranet.common.services.api.IntranetCommonService;
import com.dsi.intranet.eprocurement.model.EprocurementLocation;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.rfc.exception.NoSuchVendorException;
import com.dsi.intranet.rfc.model.Vendor;
import com.dsi.intranet.rfc.service.VendorLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;

/**
 * <a href="EprocurementCommonUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project Eprocurement
 * @Author Resmy Mathew
 * @Description Common Utility class for eprocurement.
* @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 * Veera Reddy	Jun 12 2012 Modified to get location based on AppName          
 */
public final class EprocurementCommonUtil
{
	/** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(EprocurementCommonUtil.class);
    

    /**
      * This method is to the Group Name for project managers
      * @param renderRequest
      * @param action
      * @return group Name
      */
    
    private EprocurementCommonUtil()
    {
    }
    
    public static List<User> getGroupByName(RenderRequest request) throws SystemException, PortalException
    {
        String groupName = EProcurementConstants.GROUP_NAME;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, groupName);
        long groupId = userGroup.getUserGroupId();
        List<User> userGroupUsers = UserLocalServiceUtil.getUserGroupUsers(groupId);

        return userGroupUsers;
    }
    public static String getVendorName(long companyId,String vendorCode) throws NoSuchVendorException,SystemException {
       
        String vendorName = StringPool.BLANK;
        Vendor vendorDetails=null;
        if(Validator.isNotNull(vendorCode)){
            vendorDetails = VendorLocalServiceUtil.getVendorByVendorCode(companyId,vendorCode);
        }
        if(Validator.isNotNull(vendorDetails)){
            vendorName = vendorDetails.getVendorName1();
        }
        return vendorName;
        
    }
    /**
      * This method is to the Group Name for project managers
      * @param renderRequest
      * @param action
      * @return group Name
      */
    public static long getFolderId(RenderRequest request) throws SystemException, PortalException
    {
        String folderName = EProcurementConstants.EPROCURE_FOLDER_NAME;
        long folderId = 0;
        long parentFolderId = 0;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        try
        {
            DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
            folderId = dlFolder.getFolderId();
        } catch (NoSuchFolderException ep)
        {
            folderId = 0;
            LOGGER.error("fodler doesn't exist with name" + folderName + ep.getMessage(), ep);
        }

        return folderId;
    }
    
    /**
     * This method is to get the shipto address from temphire location table
     * @param renderRequest
     * @param action
     * @return locations
     */
    public static List<EprocurementLocation> getLocations() throws SystemException, PortalException
    {
        List<EprocurementLocation> locations = EProcurementUtil.getEprocureLocations();
        String filterValue = "offsite";
        EprocurementLocation shipToAddress = null;
        String sAddress = StringPool.BLANK;
        if (Validator.isNotNull(locations))
        {
            for (int i = 0; i < locations.size(); i++)
            {
                shipToAddress = locations.get(i);

                sAddress = shipToAddress.getAddress();
                sAddress = sAddress.toLowerCase();

                if (sAddress.contains(filterValue))
                {

                    locations.remove(locations.get(i));
                }
            }
        }
        return locations;
    }

    /**
     * This method is to get the project Details
     * @param renderRequest
     * @param action
     * @return project details for drop down display of budgeted request 
     */
    @SuppressWarnings("unchecked")
    public static List<String> getProjectDetails() throws SystemException, PortalException
    {
        List<String> projectDetails = new ArrayList<String>();
        ResourceBundle budgetedProject = ResourceBundle.getBundle("eprocurement");
        Enumeration projectKeys = budgetedProject.getKeys();
        while (projectKeys.hasMoreElements())
        {
            String key = (String) projectKeys.nextElement();
            String value = budgetedProject.getString(key);
            projectDetails.add(value);

        }

        return projectDetails;

    }

    /**
     * This method is to get superviosr details
     * @param renderRequest
     * @param action
     * @return supervisor objetc for logged in user 
     */
    public static User getSupervisorObject(RenderRequest request) throws SystemException, PortalException
    {
        User userObj = null;
        User userSupervisorObj = null;
        String supervisorId = StringPool.BLANK;
        long userId = 0;
        try
        {
            String remoteUserId = request.getRemoteUser(); // logged in user
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            EprocurementCommonUtil.setExpandoPermissions(themeDisplay);
            // object
            if (Validator.isNotNull(remoteUserId))
            {
                userId = Long.parseLong(remoteUserId);

            }
            userObj = UserLocalServiceUtil.getUserById(userId);

            supervisorId = getExpandoSupervisorId(userObj);

            if (Validator.isNotNull(supervisorId))
            {
                //userSupervisorObj = getUserDataByExpandoSupervisorId(supervisorId,themeDisplay);
                userSupervisorObj= getUsersByExpandoFieldValue(EProcurementConstants.EXPANDO_EMPLOYEE_ID, supervisorId, themeDisplay.getCompanyId());

            }

        } catch (SystemException e)
        {
            LOGGER.error("eprocurement:getSupervisorObject:" + e.getMessage(), e);
        } catch (PortalException e)
        {
            LOGGER.error("eprocurement:getSupervisorObject:" + e.getMessage(), e);
        }
        return userSupervisorObj;
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

        String supervisorId = (String) expandoBridge.getAttribute(EProcurementConstants.EXPANDO_SUPERVISOR_ID);

        return supervisorId != null ? supervisorId : StringPool.BLANK;
    }

    /**
     * Get value of Expando Arrtibute Employee Id
     * 
     * @param user
     * @return
     */
    public static String getExpandoEmployeeId(User user)
    {
        ExpandoBridge expandoBridge = user.getExpandoBridge();

        String employeeId = (String) expandoBridge.getAttribute(EProcurementConstants.EXPANDO_EMPLOYEE_ID);

        return employeeId != null ? employeeId : StringPool.BLANK;
    }

    /**
     * This method will return Employee Full Name from the employee ID.
     * 
     * @param employeeId
     * @return
     */
    public static User getUserDataByExpandoSupervisorId(String supervisorId,ThemeDisplay themeDisplay)
    {
   
        User user = null;
        User supervisorUser = null;
        String employeeId = StringPool.BLANK;

        long empId = 0;
     
        long supervisorEmployeeId = Long.parseLong(supervisorId);
        try
        {
            List<ExpandoValue> expandoValues =  ExpandoValueLocalServiceUtil.getColumnValues(themeDisplay.getCompanyId(),User.class.getName(),
                    EProcurementConstants.EXPANDO_DEFAULT_TABLE, EProcurementConstants.EXPANDO_SUPERVISOR_ID, -1, -1);

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

                                    supervisorUser = user;

                                    break;
                                }
                            }

                        }
                    } catch (Exception e)
                    {
                        LOGGER.error("eprocurement:Error while getting user for the expando value:" + e.getMessage(), e);
                    }
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("eprocurement:Error while getting user for the expando value:" + e.getMessage(), e);
        }
        return supervisorUser;
    }

    /**
     * Set view permissions to the expando attribute
     * 
     * @param companyId
     * @throws PortalException
     * @throws SystemException
     */
    public static void setExpandoPermissions(ThemeDisplay themeDisplay) throws PortalException, SystemException
    {
        ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(themeDisplay.getCompanyId(),User.class.getName());
        ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(themeDisplay.getCompanyId(),expandoBridge.getClassName(),
                ExpandoTableConstants.DEFAULT_TABLE_NAME, EProcurementConstants.EXPANDO_SUPERVISOR_ID);
        if (column != null)
        {
            String[] actionsRO = new String[] { ActionKeys.VIEW };
            
            //intranetCommonService.setResourcePermissions(themeDisplay.getCompanyId(), 0, RoleConstants.USER, ExpandoColumn.class.getName(), 
            		//String.valueOf(column.getColumnId()), actionsRO);
            
            
        }
    }

    /**
     * Send email
     * @param fromEmailAddress
     * @param toEmailAddress
     * @param subject
     * @param mailBody
     */
    public static void sendEmail(String fromName, String fromAddress, String toName, String toAddress, String subject,
            String body) 
    {
        
       
        try
        {
            InternetAddress from = new InternetAddress(fromAddress, fromName);
            InternetAddress to = new InternetAddress(toAddress, toName);

            MailMessage message = new MailMessage(from, to, subject, body, true);

            message.setHTMLFormat(true);

            if (Validator.isNotNull(message))
            {
                MailServiceUtil.sendEmail(message);
            }
        } catch (UnsupportedEncodingException e)
        {
          LOGGER.error(e.getMessage(),e);
        }
       
    }
    
    public static User getUsersByExpandoFieldValue(String columnName, String value, long companyId)
    {
        User user = null;
        try
        {
            ExpandoColumn column = ExpandoColumnLocalServiceUtil.getDefaultTableColumn(companyId, User.class.getName(), columnName);
            DynamicQuery dynamicQuery = ExpandoValueLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(PropertyFactoryUtil.forName("columnId").eq(Long.valueOf(column.getColumnId()))).add(
                    PropertyFactoryUtil.forName("data").eq(value)).add(
                    PropertyFactoryUtil.forName("classNameId").eq(
                            Long.valueOf(ClassNameLocalServiceUtil.getClassNameId(User.class.getName()))));
            /*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class, PortalClassLoaderUtil.getClassLoader())
                    .add(PropertyFactoryUtil.forName("columnId").eq(Long.valueOf(column.getColumnId()))).add(
                            PropertyFactoryUtil.forName("data").eq(value)).add(
                            PropertyFactoryUtil.forName("classNameId").eq(
                                    Long.valueOf(ClassNameLocalServiceUtil.getClassNameId(User.class.getName()))));*/
            List expandoValueList = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);
            Iterator i = expandoValueList.iterator();
            do
            {
                if (!i.hasNext())
                {
                    break;
                }
                ExpandoValue expandoValue = (ExpandoValue) i.next();
                if (expandoValue.getClassPK() > 0L)
                {

                  user = UserLocalServiceUtil.getUser(expandoValue.getClassPK());
                  break;
                }
            } while (true);
        } catch (Exception e)
        {
            LOGGER.error(e.getMessage(),e);
        }
        return user;
    }
    
    private static IntranetCommonService getIntranetCommonService() {
  		return intranetCommonService;
  	}
   
  	 private static IntranetCommonService intranetCommonService;
}
