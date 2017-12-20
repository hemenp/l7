package com.dsi.intranet.pgc.portlet.util;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import javax.annotation.PostConstruct;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.rfc.model.CostCenter;
import com.dsi.intranet.rfc.model.EmployeeDataDump;
import com.dsi.intranet.rfc.model.WBSElements;
import com.dsi.intranet.rfc.service.CostCenterLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalServiceUtil;
import com.dsi.intranet.rfc.service.WBSElementsLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ServiceTrackerUtil {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceTrackerUtil.class);
	 /**
     * This method checks whether logged in user is from Field sales employee or not
     * @param renderRequest
     * @return boolean
     */
	
	
	
    public int getEmployeeType(User user)
    {
        int employee = 0;
        EmployeeDataDump empDataDemp = null;

        try
        {
        	Bundle bundle = FrameworkUtil.getBundle(this.getClass());
    	    BundleContext bundleContext = bundle.getBundleContext();
    	    EmployeeDataDumpServiceTracker employeeDataDumpServiceTracker = new EmployeeDataDumpServiceTracker(bundleContext);
    	    employeeDataDumpServiceTracker.open();
			if(!employeeDataDumpServiceTracker.isEmpty()){
        		EmployeeDataDumpLocalService eddService = employeeDataDumpServiceTracker.getService();
        		empDataDemp = eddService.getEmployeeDataDump(getExpandoEmployeeId(user));
        		LOGGER.info(empDataDemp.toString());
        	} else {
        		LOGGER.error("EmployeeDataDump service is temporarily unavailable");
			}
			employeeDataDumpServiceTracker.close();
        	
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
        return employee;
    }
    
    /**
     * Get value of Expando Arrtibute Employee Id
     * 
     * @param user
     * @return
     */
    public static String getExpandoEmployeeId(User user)
    {
        String employeeId = StringPool.BLANK;
        try
        {
            ExpandoBridge expandoBridge = user.getExpandoBridge();
            employeeId = (String) expandoBridge.getAttribute(PGCCommonConstants.EXPANDO_EMPLOYEE_ID);

        } catch (Exception e)
        {
            LOGGER.error("Error in getting employeeId" + e.getMessage(), e);
        }
        return employeeId != null ? employeeId : StringPool.BLANK;
    }
	
}
