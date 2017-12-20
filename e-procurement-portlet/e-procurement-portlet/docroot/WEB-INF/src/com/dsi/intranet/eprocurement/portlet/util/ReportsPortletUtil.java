/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;

import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.portlet.bean.EprocurementReportDataObject;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="ReportsPortletUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project E-procurement
 * @Author Devaki Subramaniam
 * @Description ReportsPortletUtil class for the Reports portlet.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public final class ReportsPortletUtil
{
	 /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(ReportsPortletUtil.class);

    /**
     * This method converts date from yyyymmdd to mm/dd/yy format
     * @param dateString
     * @return String 
     */
    
    private ReportsPortletUtil()
    {
    }
    
    public static String getRequestDateFormat(String dateString)
    {
        String requestDate = StringPool.BLANK;
        DateFormat format = new SimpleDateFormat("yyyymmdd");
        DateFormat displayFormat = new SimpleDateFormat("mm/dd/yy");
        try
        {
            Date date = format.parse(dateString.substring(0, EProcurementConstants.NUMBER_8));
            requestDate = displayFormat.format(date);
        } catch (ParseException e)
        {
            LOGGER.error("Error while converting date to yy/mm/dd " + e.getMessage(), e);
        }

        return requestDate;
    }

    /**
     * This method constructs tool tip for request
     * @param requestId
     * @return String (tool tip)
     */
    public static String getToolTip(long requestId)
    {
        StringBuffer toolTip = new StringBuffer();

        try
        {
            List<Item> itemsList = ItemLocalServiceUtil.getItemsByRequestId(requestId);
            int count = 0;
            if (itemsList.size() > 0)
            {
                for (Item item : itemsList)
                {
                    toolTip.append(item.getItemName());
                    count = count + 1;
                    if (count < itemsList.size())
                    {
                        toolTip.append(StringPool.COMMA_AND_SPACE);
                    }
                }
            }

        } catch (Exception e)
        {
            LOGGER.error("Error while constructing tooltip string: " + e.getMessage(), e);
        }

        return toolTip.toString();
    }

    /**
     * This method is responsible for setting requests in ReportsDataObject obtained through reports search.
     * @param renderRequest
     * @param themeDisplay
     * @param hits
     * @return List<EprocurementReportDataObject>
     * @throws java.text.ParseException
     */
    public static List<EprocurementReportDataObject> populateRequests(RenderRequest renderRequest,
            ThemeDisplay themeDisplay, Hits hits) throws java.text.ParseException
    {
        List<EprocurementReportDataObject> requestList = new ArrayList<EprocurementReportDataObject>(hits.getLength());
        EprocurementReportDataObject reportsDO = null;
        if (hits.getLength() > 0)
        {
            for (Document document : hits.getDocs())
            {
                String viewEditURL = StringPool.BLANK;
                String toolTip = StringPool.BLANK;
                String itemNames = StringPool.BLANK;
                String[] items = document.getValues(EProcurementConstants.ITEM_NAME);

                reportsDO = new EprocurementReportDataObject();
                reportsDO.setContractId(document.get(EProcurementConstants.CONTRACT_ID));
                reportsDO.setCurrentStatus(document.get(EProcurementConstants.CURRENT_STATUS));
                reportsDO.setItemDescription(document.getValues(EProcurementConstants.ITEM_DESCRIPTION));
                reportsDO.setItemName(document.getValues(EProcurementConstants.ITEM_NAME));

                // item names
                for (int i = 0; i < items.length; i++)
                {
                    if (i == items.length - 1)
                    {
                        itemNames = itemNames.concat(items[i]);
                    } else
                    {
                        itemNames = itemNames.concat(items[i]).concat(StringPool.COMMA);
                    }
                }
                reportsDO.setItemNames(itemNames);

                // Request status Open/Closed
                if (document.get(EProcurementConstants.CURRENT_STATUS).equalsIgnoreCase(
                        EProcurementConstants.STATUS_CANCELLED)
                        || document.get(EProcurementConstants.CURRENT_STATUS).equalsIgnoreCase(
                                EProcurementConstants.STATUS_COMPLETED))
                {
                    reportsDO.setOpenOrClosed(EProcurementConstants.REQUEST_CLOSED);
                } else
                {
                    reportsDO.setOpenOrClosed(EProcurementConstants.REQUEST_OPEN);
                }
                reportsDO.setPoNumber(document.get(EProcurementConstants.PURCHASE_ORDER_NUMBER));
                //reportsDO.setRequestDate(getRequestDateFormat(document.get(Field.MODIFIED)));
                if (Validator.isNotNull(document.get(Field.ENTRY_CLASS_PK)))
                {
                    reportsDO.setRequestId(Long.parseLong(document.get(Field.ENTRY_CLASS_PK)));
                }

                // Request edit URL
                viewEditURL = EProcurementUtil.createEditRequestURL(renderRequest, themeDisplay,
                        EProcurementConstants.IS_PRIVATE_LAYOUT, reportsDO.getRequestId());
                reportsDO.setRequestURL(viewEditURL.concat(EProcurementConstants.PARAM_REPORTS));
                String requestorId = document.get(EProcurementConstants.REQUESTOR_ID);
                if (Validator.isNotNull(requestorId))
                {
                    reportsDO.setRequestorId(Long.parseLong(document.get(EProcurementConstants.REQUESTOR_ID)));
                    try
                    {
                        User user = UserLocalServiceUtil.getUser(reportsDO.getRequestorId());
                        reportsDO.setRequestor(user.getFullName());
                    } catch (Exception e)
                    {
                        LOGGER.error("populateRequests: Error while retrieving username : " + e.getMessage(), e);
                    }
                }

                reportsDO.setVendor(document.get(EProcurementConstants.VENDOR_NAME));

                // Tool Tip
                toolTip = EProcurementUtil.createToolTip(reportsDO.getRequestId());
                reportsDO.setToolTip(toolTip);

                requestList.add(reportsDO);
            }
        }

        return requestList;
    }
}
