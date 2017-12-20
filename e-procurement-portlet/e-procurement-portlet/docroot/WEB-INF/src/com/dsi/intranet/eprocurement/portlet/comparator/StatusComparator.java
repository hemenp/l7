/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.comparator;

import com.dsi.intranet.eprocurement.portlet.bean.DashboardBean;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * @author jitendra.rajput
 *  Comparator for Status Column in Dashboard
 *
 */
public class StatusComparator extends OrderByComparator
{

	private static final long serialVersionUID = 5348291349474769109L;
	private final boolean asc;

    /**
     * Constructor without arguments
     */
    public StatusComparator()
    {
        this(true);
    }

    /**
     * Constructor with asc parameter
     * 
     * @param asc
     */
    public StatusComparator(boolean asc)
    {
        this.asc = asc;
    }
    public int compare(Object obj1, Object obj2)
    {
        DashboardBean dashBoardDataBean1 = (DashboardBean)obj1;
        DashboardBean dashBoardDataBean2 = (DashboardBean)obj2;
        int value = dashBoardDataBean1.getStatus().toLowerCase().compareTo(dashBoardDataBean2.getStatus().toLowerCase());
        if (asc)
        {
            return value;
        } else
        {
            return -value;
        }
    }
}
