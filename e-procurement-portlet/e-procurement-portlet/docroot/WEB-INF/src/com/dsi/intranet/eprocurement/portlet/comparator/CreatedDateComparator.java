/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.comparator;

import com.dsi.intranet.eprocurement.portlet.bean.DashboardBean;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * @author jitendra.rajput
 * 
 * Comparator for Create Date 
 *
 */
public class CreatedDateComparator extends OrderByComparator
{

	private static final long serialVersionUID = -1598767564530472535L;
	private final boolean asc;

    /**
     * Constructor without arguments
     */
    public CreatedDateComparator()
    {
        this(true);
    }

    /**
     * Constructor with asc parameter
     * 
     * @param asc
     */
    public CreatedDateComparator(boolean asc)
    {
        this.asc = asc;
    }

    /**
     * @param obj1 - the DashBoardDataObject object 
     * @param obj2 - the DashBoardDataObject object 
     */
    public int compare(Object obj1, Object obj2)
    {
        DashboardBean dashBoardDataBean1 = (DashboardBean)obj1;
        DashboardBean dashBoardDataBean2 = (DashboardBean)obj2;
        int value = dashBoardDataBean1.getCreatedDate().toLowerCase().compareTo(dashBoardDataBean2.getCreatedDate().toLowerCase());
        if (asc)
        {
            return value;
        } else
        {
            return -value;
        }
    }

}
