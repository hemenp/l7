/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import com.dsi.intranet.eprocurement.portlet.comparator.CreatedDateComparator;
import com.dsi.intranet.eprocurement.portlet.comparator.NextApproverComparator;
import com.dsi.intranet.eprocurement.portlet.comparator.RequesterNameComparator;
import com.dsi.intranet.eprocurement.portlet.comparator.StatusComparator;
import com.dsi.intranet.eprocurement.portlet.comparator.WorkflowNameComparator;
import com.liferay.portal.kernel.util.OrderByComparator;


public final class DashBoardComparatorUtil
{
    /**
     * Utility method to decide comparator
     * @param orderByCol
     * @param orderByType
     * @return
     */
	
	private DashBoardComparatorUtil()
	{
	}
	
    public static OrderByComparator getDashBoardComparator(String orderByCol, String orderByType)
    {
        boolean orderByAsc = true;

        if (orderByType.equals("desc"))
        {
            orderByAsc = false;
        }
        OrderByComparator dashBoardComparator = null;
        
        if (orderByCol.equalsIgnoreCase("Requester Name"))
        {
            dashBoardComparator = new RequesterNameComparator(orderByAsc);
            
        } else if (orderByCol.equalsIgnoreCase("Created Date"))
        {
            dashBoardComparator = new CreatedDateComparator(orderByAsc);
            
        } else if (orderByCol.equalsIgnoreCase("Status"))
        {
            dashBoardComparator = new StatusComparator(orderByAsc);
            
        } else if (orderByCol.equalsIgnoreCase("Next Approver"))
        {
            dashBoardComparator = new NextApproverComparator(orderByAsc);
            
        } else if (orderByCol.equalsIgnoreCase("Workflow Name"))
        {
            dashBoardComparator = new WorkflowNameComparator(orderByAsc);
        }
        return dashBoardComparator;
    }

}
