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
 *  Comparator for RequesterName Column
 *
 */
public class RequesterNameComparator extends OrderByComparator
{
	private static final long serialVersionUID = -6151086231814268700L;
	private final boolean asc;

    /**
     * Constructor without arguments
     */
    public RequesterNameComparator()
    {
        this(true);
    }

    /**
     * Constructor with asc parameter
     * 
     * @param asc
     */
    public RequesterNameComparator(boolean asc)
    {
        this.asc = asc;
    }
    public int compare(Object obj1, Object obj2)
    {
        DashboardBean dashBoardDataBean1 = (DashboardBean)obj1;
        DashboardBean dashBoardDataBean2 = (DashboardBean)obj2;
        int value = dashBoardDataBean1.getUserFullName().toLowerCase().compareTo(dashBoardDataBean2.getUserFullName().toLowerCase());
        if (asc)
        {
            return value;
        } else
        {
            return -value;
        }
    }

   
}
