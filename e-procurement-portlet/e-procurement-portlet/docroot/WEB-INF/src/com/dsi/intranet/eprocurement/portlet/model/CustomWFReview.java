package com.dsi.intranet.eprocurement.portlet.model;

import java.util.Date;

/**
 * 
 * @author Jay Patel
 *
 * This is the Custom WFReview class that is used to show various comments, status, date/time etc. in WF Request screen.
 * 
 */

public class CustomWFReview
{
    private Date updatedDate;

    private String updatedToStatus;

    private long updatedBy;

    private String updatedByName;

    private String approverComments;

    private String emailComments;

    public Date getUpdatedDate()
    {
        return (Date) updatedDate.clone();
    }

    public void setUpdatedDate(Date updatedDate)
    {
        this.updatedDate = (Date) updatedDate.clone();
    }

    public String getUpdatedToStatus()
    {
        return updatedToStatus;
    }

    public void setUpdatedToStatus(String updatedToStatus)
    {
        this.updatedToStatus = updatedToStatus;
    }

    public long getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedByName()
    {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName)
    {
        this.updatedByName = updatedByName;
    }

    public String getApproverComments()
    {
        return approverComments;
    }

    public void setApproverComments(String approverComments)
    {
        this.approverComments = approverComments;
    }

    public String getEmailComments()
    {
        return emailComments;
    }

    public void setEmailComments(String emailComments)
    {
        this.emailComments = emailComments;
    }

}
