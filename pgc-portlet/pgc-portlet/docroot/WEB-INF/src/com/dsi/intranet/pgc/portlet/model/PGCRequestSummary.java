/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

import com.liferay.portal.kernel.util.StringPool;

/**
 * <a href="PGCRequestSummary.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class PGCRequestSummary implements Serializable
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    private String dateType = StringPool.BLANK;
    private String endDate = StringPool.BLANK;
    private String eventDate = StringPool.BLANK;
    private String formType = StringPool.BLANK;
    private String meetingDate = StringPool.BLANK;
    private String objectId = StringPool.BLANK;
    private String requestId = StringPool.BLANK;
    private String requestor = StringPool.BLANK;
    private String requestTitle = StringPool.BLANK;
    private String startDate = StringPool.BLANK;
    private String status = StringPool.BLANK;
    private String formTypeName = StringPool.BLANK;
    private String checkAmount = StringPool.BLANK;

    public String getDateType()
    {
        return dateType;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public String getFormType()
    {
        return formType;
    }

    public String getMeetingDate()
    {
        return meetingDate;
    }

    public String getObjectId()
    {
        return objectId;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public String getRequestor()
    {
        return requestor;
    }

    public String getRequestTitle()
    {
        return requestTitle;
    }
    public String getFormTypeName()
    {
        return formTypeName;
    }
    public String getCheckAmount()
    {
        return checkAmount;
    }
    public String getStartDate()
    {
        return startDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setDateType(String dateType)
    {
        this.dateType = dateType;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public void setEventDate(String eventDate)
    {
        this.eventDate = eventDate;
    }

    public void setFormType(String formType)
    {
        this.formType = formType;
    }

    public void setMeetingDate(String meetingDate)
    {
        this.meetingDate = meetingDate;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public void setRequestor(String requestor)
    {
        this.requestor = requestor;
    }

    public void setRequestTitle(String requestTitle)
    {
        this.requestTitle = requestTitle;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    public void setFormTypeName(String formTypeName)
    {
        this.formTypeName = formTypeName;
    }
    public void setCheckAmount(String checkAmount)
    {
        this.checkAmount = checkAmount;
    }
}