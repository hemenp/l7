/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.dsi.common.service.bean.RequestTO;
import com.dsi.common.service.bean.ResponseTO;
import com.dsi.common.service.client.WebServiceClient;
import com.dsi.common.service.exception.WebServiceCallException;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

/**
 * <a href="DocumentumServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public final class DocumentumServiceUtil
{
	private DocumentumServiceUtil(){}
    private static final Log LOGGER = LogFactoryUtil.getLog(DocumentumServiceUtil.class.getName());

    private static RequestTO createRequestPOJO(String connectionURL) throws WebServiceCallException
    {
        RequestTO requestTO = null;
        Map<String, String> headerMap = null;
        trustSelfSignedSSL();
        try
        {
            requestTO = new RequestTO();
            requestTO.setConnectionURL(connectionURL);

            // Setting up Header Values
            headerMap = new HashMap<String, String>();
            headerMap.put(PGCCommonConstants.AUTH_HEADER, PGCCommonConstants.DCTM_AUTH_HEADER_VAL);
            headerMap.put(PGCCommonConstants.REST_CLIENT_HEADER, PGCCommonConstants.DCTM_CLIENT_HEADER_VAL);
            requestTO.setHeaderMap(headerMap);
        } catch (Exception e)
        {
            throw new WebServiceCallException();
        }
        return requestTO;
    }

    public static String deleteAttachment(String documentId)
    {
        String prune = "F";
        String responseStr = "";

        StringBuilder deleteURL = new StringBuilder(PGCCommonConstants.BASE_URL + PGCCommonConstants.REPOSITORY_NAME
                + "/documents/pgcproperties/" + documentId + "?prune=" + prune);

        try
        {
            responseStr = DocumentumServiceUtil.getDelete(deleteURL.toString());
        } catch (WebServiceCallException e)
        {
            LOGGER.error("Error while deleting attachment: " + e.getMessage(), e);
        }

        return responseStr;
    }

    public static String getDataByXpath(String xml, String xpath) throws DocumentException,
            UnsupportedEncodingException
    {

        StringBuilder data = new StringBuilder(StringPool.BLANK);
        Document contentDoc = SAXReaderUtil.read(new ByteArrayInputStream(xml.getBytes(StringPool.UTF8)));
        XPath xpathSelector = SAXReaderUtil.createXPath(xpath);
        List<Node> results = xpathSelector.selectNodes(contentDoc);
        if (results != null)
        {
            for (Node node : results)
            {
                data.append(node.getStringValue());
            }
        }
        return data.toString();
    }

    public static String getDelete(String url) throws WebServiceCallException
    {
        RequestTO request = createRequestPOJO(url);
        String statuscode = "";
        trustSelfSignedSSL();
        try
        {
            if (request != null)
            {
                WebServiceClient webServiceClient = WebServiceClient.getInstance();
                ResponseTO responseStatus = webServiceClient.executeDelete(request);
                if (responseStatus.getStatusCode() == PGCCommonConstants.SUCCESS_STATUS_CODE)
                {
                    statuscode = "success";
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("Error occured in getting Message " + e.getMessage(), e);
        }
        return statuscode;
    }

    public static String getMessage(String url) throws WebServiceCallException
    {
        RequestTO request = createRequestPOJO(url);
        String xmlFileContent = null;
        try
        {
            if (request != null)
            {
            	trustSelfSignedSSL();
                WebServiceClient webServiceClient = WebServiceClient.getInstance();
                ResponseTO responseStatus = webServiceClient.executeGet(request, false);
                if (responseStatus != null && responseStatus.getStatusCode() == PGCCommonConstants.SUCCESS_STATUS_CODE)
                {
                    xmlFileContent = responseStatus.getMessage();
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("Error occured in getting Message " + e.getMessage(), e);
        }
        return xmlFileContent;
    }

    /**
     * 
     * @param request
     * @return
     * @throws WebServiceCallException
     */
    public static byte[] getPGCDocument(String documentId) throws WebServiceCallException
    {
        String fileURL = PGCCommonConstants.BASE_URL + PGCCommonConstants.REPOSITORY_NAME + "/documents/" + documentId
                + "/content";
        byte[] fileContent = null;
        RequestTO requestTO = DocumentumServiceUtil.createRequestPOJO(fileURL);
        trustSelfSignedSSL();
        if (requestTO != null)
        {
            WebServiceClient webServiceClient = WebServiceClient.getInstance();
            ResponseTO responseStatus = webServiceClient.executeGet(requestTO, true);

            if (responseStatus != null && responseStatus.getStatusCode() == PGCCommonConstants.SUCCESS_STATUS_CODE)
            {
                fileContent = responseStatus.getBytes();
            }
        }
        return fileContent;
    }

    /**
     * Saves the xml file to the temporary location.
     * @param xml xml to save.
     * @return File object of the persisted file
     * @throws IOException @see java.io.IOException.
     * @throws DossierRequestException 
     */
    public static File persistXml(String xml) throws IOException
    {
        File f = null;
        FileWriter fw = null;
        try
        {
            f = new File(System.getProperty(PGCCommonConstants.TEMP_DIR) + "/" + System.currentTimeMillis() + ".xml");
            fw = new FileWriter(f);
            fw.write(xml);
        } catch (Exception e)
        {
            LOGGER.error("Error occured in persistXml " + e.getMessage(), e);

        } finally
        {
            if (fw != null)
            {
                fw.close();
            }
        }
        return f;
    }

    /**
     * This method creates RequestTO POJO In case of XML Upload 
     * (E dossier request Creation with Content and without content,Address XML Upload)
     * @param xml
     * @throws DossierRequestException 
     */
    public static RequestTO processXML(String xml, String contentType, String documentumId) throws Exception
    {
        String documentumContent = PGCCommonConstants.DOCUMENT_CONTENT_REQUIRED_QRY;
        if (Validator.isNotNull(documentumId))
        {
            documentumContent = "/documents/" + documentumId + "/updatepgcproperties.xml?contentRequired=";
        }
        RequestTO requestTO = null;
        Map<String, String> headerMap = null;
        try
        {
            requestTO = new RequestTO();
            requestTO.setData(xml);

            requestTO.setConnectionURL(PGCCommonConstants.BASE_URL + PGCCommonConstants.REPOSITORY_NAME
                    + documentumContent + contentType);

            // Setting up Header Values
            headerMap = new HashMap<String, String>();
            headerMap.put(PGCCommonConstants.AUTH_HEADER, PGCCommonConstants.DCTM_AUTH_HEADER_VAL);
            headerMap.put(PGCCommonConstants.REST_CLIENT_HEADER, PGCCommonConstants.DCTM_CLIENT_HEADER_VAL);
            requestTO.setHeaderMap(headerMap);
        } catch (Exception e)
        {
            LOGGER.error("Error occured in processXML " + e.getMessage(), e);
        }
        return requestTO;
    }
    
    public static void trustSelfSignedSSL() {

		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] xcs, String string) {

				}

				public void checkServerTrusted(X509Certificate[] xcs, String string) {

				}

				public X509Certificate[] getAcceptedIssuers() {

					return null;
				}
			};
			ctx.init(null, new TrustManager[] {
				tm
			}, null);
			SSLContext.setDefault(ctx);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
}