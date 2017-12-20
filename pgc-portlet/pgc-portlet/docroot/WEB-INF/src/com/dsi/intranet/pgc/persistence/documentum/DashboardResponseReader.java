/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumServiceUtil;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;
import com.dsi.intranet.pgc.portlet.util.PGCCommonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

/**
 * <a href="DashboardResponseReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 *  Veera Reddy		|	Aug 06 2012		|	Modified To fetch the value from object_name instead of pgc_req_title 
 * 
 */
public class DashboardResponseReader implements IResponseReader
{
    private static final Log LOGGER = LogFactoryUtil.getLog(DashboardResponseReader.class);

    private PGCRequestSummary getResultBean(Node node) throws Exception
    {
        PGCRequestSummary result = new PGCRequestSummary();
        String xml = node.asXML();
        String value = StringPool.BLANK;
        try
        {
            // requestor
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='pgc_req_name']/value/text()");
            result.setRequestor(value);

            // requestId
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='pgc_req_id']/value/text()");
            result.setRequestId(value);

            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='r_object_type']/value/text()");
            result.setFormType(value);
            // formType ,converting to actual Form Name for dashboard display
            if (Validator.isNotNull(value))
            {
                value = PGCCommonUtil.FormTypeConvertion(value);
                result.setFormTypeName(value);
            }
            // check amount
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='pgc_check_amount']/value/text()");
            result.setCheckAmount(value);
            // status
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='pgc_status']/value/text()");
            result.setStatus(value);
            //DSI:START::Veera Reddy:: To fetch the value from object_name instead of pgc_req_title 
            // request title
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='object_name']/value/text()");
            result.setRequestTitle(value);
            //DSI:END::Veera Reddy:: To fetch the value from object_name instead of pgc_req_title 
            // objectId
            value = DocumentumServiceUtil.getDataByXpath(xml, "//StringProperty[name='r_object_id']/value/text()");
            result.setObjectId(value);

            // Event Date(Start Date is considered here to be Event Date)
            value = DocumentumServiceUtil.getDataByXpath(xml, "//DateProperty[name='pgc_start_date']/value/text()");
            if (Validator.isNotNull(value))
            {
                value = PGCCommonUtil.convertTimetoString(value);
            }
            result.setEventDate(value);

            // PGC Meeting Date
            value = DocumentumServiceUtil.getDataByXpath(xml, "//DateProperty[name='pgc_meeting_date']/value/text()");
            if (Validator.isNotNull(value))
            {
                value = PGCCommonUtil.convertMeetingDate(value);
            }
            result.setMeetingDate(value);
        } catch (Exception e)
        {
            LOGGER.error("Error while getting value from xml for Dashboard: " + e.getMessage(), e);
        }
        return result;
    }

    @SuppressWarnings(value = "unchecked")
    public void parseResponse(String xmlResponse, Object objToPopulate) throws IllegalArgumentException
    {
        List<PGCRequestSummary> pgcList = null;
        try
        {
            pgcList = (List<PGCRequestSummary>) objToPopulate;
        } catch (ClassCastException cce)
        {
            throw new IllegalArgumentException("objToPopulate needs to be a List of PGCRequestSummary");
        }
        if ((Validator.isNotNull(xmlResponse)) && (Validator.isNotNull(pgcList)))
        {
            try
            {
                com.liferay.portal.kernel.xml.Document contentDoc = SAXReaderUtil.read(new ByteArrayInputStream(
                        xmlResponse.getBytes(StringPool.UTF8)));
                XPath xpathSelector = SAXReaderUtil.createXPath("//properties");
                List<Node> results = xpathSelector.selectNodes(contentDoc);
                if (results != null && results.size() > 0)
                {
                    for (Node node : results)
                    {
                        pgcList.add(getResultBean(node));
                    }
                }
            } catch (UnsupportedEncodingException e)
            {
                LOGGER.error("Error while reading xml for Dashboard: " + e.getMessage(), e);
            } catch (DocumentException e)
            {
                LOGGER.error("Error while reading xml for Dashboard: " + e.getMessage(), e);
            } catch (Exception e)
            {
                LOGGER.error("Error while reading xml for Dashboard: " + e.getMessage(), e);
            }
        }
    }

    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate)
    {
        return;
    }

}
