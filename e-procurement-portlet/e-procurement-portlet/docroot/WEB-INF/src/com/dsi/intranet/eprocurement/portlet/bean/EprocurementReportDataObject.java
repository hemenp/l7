/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.bean;

import java.util.Arrays;

import com.liferay.portal.kernel.util.StringPool;

/**
 * <a href="EprocurementReportDataObject.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project E-procurement
 * @Author Devaki Subramaniam
 * @Description Bean class for the Reports.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public class EprocurementReportDataObject
{
    private String contractId = StringPool.BLANK;
    private String currentStatus = StringPool.BLANK;
    private String[] itemDescription;
    private String[] itemName;
    private String itemNames = StringPool.BLANK;
    private String openOrClosed = StringPool.BLANK;
    private String poNumber = StringPool.BLANK;
    private String requestDate;
    private long requestId;
    private String requestor = StringPool.BLANK;
    private long requestorId;
    private String requestURL = StringPool.BLANK;
    private String toolTip = StringPool.BLANK;
    private String vendor = StringPool.BLANK;

    public String getContractId()
    {
        return contractId;
    }

    public String getCurrentStatus()
    {
        return currentStatus;
    }

    public String[] getItemDescription()
    {
        return itemDescription.clone();
    }

    public String[] getItemName()
    {
        return itemName.clone();
    }

    public String getItemNames()
    {
        return itemNames;
    }

    public String getOpenOrClosed()
    {
        return openOrClosed;
    }

    public String getPoNumber()
    {
        return poNumber;
    }

    public String getRequestDate()
    {
        return requestDate;
    }

    public long getRequestId()
    {
        return requestId;
    }

    public String getRequestor()
    {
        return requestor;
    }

    public long getRequestorId()
    {
        return requestorId;
    }

    public String getRequestURL()
    {
        return requestURL;
    }

    public String getToolTip()
    {
        return toolTip;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setContractId(String contractId)
    {
        this.contractId = contractId;
    }

    public void setCurrentStatus(String currentStatus)
    {
        this.currentStatus = currentStatus;
    }

    public void setItemDescription(String[] newItemDescription)
    {
        if (newItemDescription == null)
        {
            this.itemDescription = new String[0];
        } else
        {
            this.itemDescription = Arrays.copyOf(newItemDescription, newItemDescription.length);
        }
    }

    public void setItemName(String[] newItemName)
    {
        if (newItemName == null)
        {
            this.itemName = new String[0];
        } else
        {
            this.itemName = Arrays.copyOf(newItemName, newItemName.length);
        }
    }

    public void setItemNames(String itemNames)
    {
        this.itemNames = itemNames;
    }

    public void setOpenOrClosed(String openOrClosed)
    {
        this.openOrClosed = openOrClosed;
    }

    public void setPoNumber(String poNumber)
    {
        this.poNumber = poNumber;
    }

    public void setRequestDate(String requestDate)
    {
        this.requestDate = requestDate;
    }

    public void setRequestId(long requestId)
    {
        this.requestId = requestId;
    }

    public void setRequestor(String requestor)
    {
        this.requestor = requestor;
    }

    public void setRequestorId(long requestorId)
    {
        this.requestorId = requestorId;
    }

    public void setRequestURL(String requestURL)
    {
        this.requestURL = requestURL;
    }

    public void setToolTip(String toolTip)
    {
        this.toolTip = toolTip;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }
}
