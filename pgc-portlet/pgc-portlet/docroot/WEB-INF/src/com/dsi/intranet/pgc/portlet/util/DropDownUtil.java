/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="DropDownUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Dec 13 2012		|	Modified to add option in state list 'International'
 */
public final class DropDownUtil
{
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(DropDownUtil.class);

    public static Map<String, Object> getAllDropDownRefs()
    {
        Map<String, Object> dropDownRefs = new HashMap<String, Object>();
        dropDownRefs.put("contractSpecialists", getContractSpecialists());
        dropDownRefs.put("usStates", getRegions());
        dropDownRefs.put("productList", getProductList());
        dropDownRefs.put("therapeuticArea", getTherapeuticArea());
        dropDownRefs.put("statusList", getStatusList());
        dropDownRefs.put("formTitles", getFormTitles());
        dropDownRefs.put("formTypes", getFormTypes(PGCCommonConstants.FORM_TYPES));
        dropDownRefs.put("monthValues", getMonthValues());
        dropDownRefs.put("businessFunctionList", getBusinessFunctionList());
        return dropDownRefs;
    }

    public static String[] getContractSpecialists()
    {
        return PortletProps.getArray("contractSpecialists");
    }
    public static String[] getMonthValues()
    {
        return PortletProps.getArray("MonthValues");
    }
    public static String[] getBusinessFunctionList()
    {
        return PortletProps.getArray("businessFunctionList");
    }
    public static Map<String, String> getFormTitles()
    {
        Map<String, String> formTitles = new LinkedHashMap<String, String>();
        String formTitlesValue = PortletProps.get("formTypeTitles");
        String[] formTitleValues = formTitlesValue.split("#");
        for (String formTitleValue : formTitleValues)
        {
            String[] ddElemVals = formTitleValue.split(":");
            if (ddElemVals.length < 2)
            {
                ddElemVals = new String[] { formTitleValue, formTitleValue };
            }
            formTitles.put(ddElemVals[1], ddElemVals[0].replace(",", ", "));
        }
        return formTitles;
    }

    public static Map<String, String> getFormTypesSearchList()
    {
        Map<String, String> formList = new LinkedHashMap<String, String>();
        String[] formTypeDDValues = PortletProps.getArray("formTypesSearchList");
        for (String formTypeDDValue : formTypeDDValues)
        {
            String[] ddElemVals = formTypeDDValue.split(":");
            if (ddElemVals.length < 2)
            {
                ddElemVals = new String[] { formTypeDDValue, formTypeDDValue };
            }
            formList.put(ddElemVals[0], ddElemVals[1]);
        }
        return formList;
    }
    
    public static Map<String, String> getFormTypesSearch()
    {
        Map<String, String> formList = new LinkedHashMap<String, String>();
        String[] formTypeDDValues = PortletProps.getArray("formTypesSearch");
        for (String formTypeDDValue : formTypeDDValues)
        {
            String[] ddElemVals = formTypeDDValue.split(":");
            if (ddElemVals.length < 2)
            {
                ddElemVals = new String[] { formTypeDDValue, formTypeDDValue };
            }
            formList.put(ddElemVals[0], ddElemVals[1]);
        }
        return formList;
    }

    public static Map<String, String> getFormTypes(int type)
    {
        Map<String, String> formTypes = new LinkedHashMap<String, String>();
        String[] formTypeDDValues = {};
        
        switch (type){
        	case PGCCommonConstants.FORM_TYPES:
        		formTypeDDValues = PortletProps.getArray("formTypes");
        		break;
        	case PGCCommonConstants.FIELD_SALES_EMPLOYEE:
        		formTypeDDValues = PortletProps.getArray("formTypeDDValues");
        		break;
        	case PGCCommonConstants.HOME_OFFICE_EMPLOYEE:
        		formTypeDDValues = PortletProps.getArray("formTypeHomeOfficeValues");
        		break;
        	default:
        		break;
        }
   
        for (String formTypeDDValue : formTypeDDValues)
        {
            String[] ddElemVals = formTypeDDValue.split(":");
            if (ddElemVals.length < 2)
            {
                ddElemVals = new String[] { formTypeDDValue, formTypeDDValue };
            }
            formTypes.put(ddElemVals[1], ddElemVals[0]);
        }
        return formTypes;
    }

    public static String[] getProductList()
    {
        return PortletProps.getArray("productList");
    }

    public static Map<String, String> getStatusList()
    {
        Map<String, String> statusList = new LinkedHashMap<String, String>();
        String[] formTypeDDValues = PortletProps.getArray("statusList");
        for (String formTypeDDValue : formTypeDDValues)
        {
            statusList.put(formTypeDDValue, formTypeDDValue);
        }
        return statusList;
    }

    public static String[] getTherapeuticArea()
    {
        return PortletProps.getArray("therapeuticArea");
    }
    /**
     * Getting all Regions.
     */
    public static Map<String, String> getRegions()
    {
        Map<String, String> statesMap = new LinkedHashMap<String, String>();
        try
        {
            Country country = CountryServiceUtil.getCountryByName(PortletProps.get("countryName"));
            List<Region> states = RegionServiceUtil.getRegions(country.getCountryId());
            //Begin::Veera Reddy ::Modified to add option in state list 'International'
            String[] defaultStates = PortletProps.getArray("defaultStates");
            for (String defaultState : defaultStates)
            {
            	statesMap.put(defaultState, defaultState);
            }
            //End::Veera Reddy ::Modified to add option in state list 'International'
            for (Region state : states)
            {
                statesMap.put(state.getRegionCode(), state.getRegionCode());
            }
        } catch (Exception e)
        {

            LOGGER.error("Error while retrieving US statesusers " + e.getMessage(), e);
        }
        return statesMap;
    }

    /**
     * Making private so that the class can't be instantiated.
     */
    private DropDownUtil()
    {
    }

}
