/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.bean;

import com.liferay.portal.kernel.util.StringPool;

/**
 * Bean for Dashboard columns
 * @author jitendra.rajput
 *
 */
public class DashboardBean
{
    private long requestId;
    private String userFullName = StringPool.BLANK;
    private String createdDate = StringPool.BLANK;
    private String status = StringPool.BLANK;
    private String nextApprover = StringPool.BLANK;
    private String workFlowName = StringPool.BLANK;
   
    
    public long getRequestId()
    {
        return requestId;
    }
    public void setRequestId(long requestId)
    {
        this.requestId = requestId;
    }
    public String getUserFullName()
    {
        return userFullName;
    }
    public void setUserFullName(String userFullName)
    {
        this.userFullName = userFullName;
    }
    public String getCreatedDate()
    {
        return createdDate;
    }
    public void setCreatedDate(String createdDate)
    {
        this.createdDate = createdDate;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getNextApprover()
    {
        return nextApprover;
    }
    public void setNextApprover(String nextApprover)
    {
        this.nextApprover = nextApprover;
    }
    public String getWorkFlowName()
    {
        return workFlowName;
    }
    public void setWorkFlowName(String workFlowName)
    {
        this.workFlowName = workFlowName;
    }
    
}
