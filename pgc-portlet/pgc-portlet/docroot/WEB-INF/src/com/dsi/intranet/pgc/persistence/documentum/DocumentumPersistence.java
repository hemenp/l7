/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dsi.common.service.bean.RequestTO;
import com.dsi.common.service.bean.ResponseTO;
import com.dsi.common.service.client.WebServiceClient;
import com.dsi.common.service.exception.WebServiceCallException;
import com.dsi.intranet.pgc.exception.PGCPersistenceException;
import com.dsi.intranet.pgc.persistence.IPGCPersistence;
import com.dsi.intranet.pgc.persistence.documentum.readers.AdvisoryBoardFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.CharitableDonationFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.CorporateSupportFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.DisplayExhibitFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.EduItemsValFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.GeneralRequestFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.GeneralRequestInformationReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.HCPConsultantFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.POMembershipFormReader;
import com.dsi.intranet.pgc.persistence.documentum.readers.ServiceAgreementFormReader;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumServiceUtil;
import com.dsi.intranet.pgc.persistence.documentum.writers.AdvisoryBoardFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.CharitableDonationFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.CharitableDonationInformationWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.CorporateSupportFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.DisplayExhibitFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.EduItemsValFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.GeneralRequestFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.HCPConsultantFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.POMembershipFormWriter;
import com.dsi.intranet.pgc.persistence.documentum.writers.ServiceAgreementFormWriter;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;
import com.dsi.intranet.pgc.portlet.model.RequestorInformation;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;


/**
 * <a href="DocumentumPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 *  Veera Reddy		|	Aug 06 2012		|	Modified To fetch the value from object_name instead of pgc_req_title 
 *  Veera Reddy		|	Dec 13 2012		|	Modified to fix the issue for the incident 79032
 */
public class DocumentumPersistence implements IPGCPersistence
{

    private static final Log LOGGER = LogFactoryUtil.getLog(DocumentumPersistence.class);

    public String getCompleteFormXML(String requestId, String typeName)
    {
        String formXML = getFormXML(requestId, typeName);
        String fileContentXML = getFileContentXML(requestId, typeName);
        String completeFormXML = StringPool.BLANK;

        if (Validator.isNotNull(fileContentXML))
        {
            Document xmlDoc = null;
            String count = StringPool.BLANK;
			try
            {
                xmlDoc = DocumentHelper.parseText(fileContentXML);
            
            Node attrNode = xmlDoc.selectSingleNode("//objects/count");
            count  = attrNode.getText();
            } catch (DocumentException e)
            {
                LOGGER.error("Error while converting string to xml Document: " + e.getMessage(), e);
            } 
            if (count.equalsIgnoreCase("0"))
            {
                completeFormXML = formXML;
            } else
            {
                formXML = formXML.substring(0, formXML.lastIndexOf("</objects>"));
                int firstindex = fileContentXML.indexOf("<object uri=");
                fileContentXML = fileContentXML.substring(firstindex);
                completeFormXML = formXML.concat(fileContentXML);
            }
        }

        return completeFormXML;
    }

    public String getFileContentXML(String requestId, String formTypeName)
    {
        String expression = "spi_legal_id='" + requestId + "' AND pgc_uploaded_by = 'Uploaded by Requestor'";
        String typeName = "dsi_pgc_attachment";
        String maxresult = PGCCommonConstants.MAX_RESULTS;

        try
        {
            expression = URLEncoder.encode(expression, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Error while retrieving document response xml: " + e.getMessage(), e);
        }

        StringBuilder connectionURL = new StringBuilder(PGCCommonConstants.BASE_URL
                + PGCCommonConstants.REPOSITORY_NAME + "/query.xml?expression=" + expression + "&typeName=" + typeName
                + "&maxResults=" + maxresult + "&startIndex=" + PGCCommonConstants.START_INDEX + "&endIndex="
                + PGCCommonConstants.END_INDEX);
        String fileContentXML = StringPool.BLANK;

        try
        {
            fileContentXML = DocumentumServiceUtil.getMessage(connectionURL.toString());
        } catch (WebServiceCallException e)
        {
            LOGGER.error("Error while getting document response xml: " + e.getMessage(), e);
        }

        return fileContentXML;
    }

    public String getFormXML(String requestId, String typeName)
    {
        String expression = "spi_legal_id='" + requestId + "'";
        String maxresult = PGCCommonConstants.MAX_RESULTS;

        try
        {
            expression = URLEncoder.encode(expression, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Error while encoding: " + e.getMessage(), e);
        }

        StringBuilder connectionURL = new StringBuilder(PGCCommonConstants.BASE_URL
                + PGCCommonConstants.REPOSITORY_NAME + "/query.xml?expression=" + expression + "&typeName=" + typeName
                + "&maxResults=" + maxresult + "&startIndex=" + PGCCommonConstants.START_INDEX + "&endIndex="
                + PGCCommonConstants.END_INDEX);
        String xmlContent = StringPool.BLANK;

        try
        {
            xmlContent = DocumentumServiceUtil.getMessage(connectionURL.toString());
        } catch (WebServiceCallException e)
        {
            LOGGER.error("Error while getting response form xml: " + e.getMessage(), e);
        }

        return xmlContent;
    }

    public List<PGCRequestSummary> getUserRequestsList(PGCRequestSummary pgcSummary, String employeeId)
    {
        List<PGCRequestSummary> requests = new ArrayList<PGCRequestSummary>();
        String typeName = PGCCommonConstants.TYPE_NAME;
        StringBuilder sb = new StringBuilder();
        if (Validator.isNull(employeeId))
        {
            return requests;
        }
        sb.append("(pgc_req_emp_id = '");
        sb.append(employeeId);
        sb.append("' or pgc_creator_emp_id = '");
        sb.append(employeeId);
        sb.append("')");
        if (Validator.isNotNull(pgcSummary))
        {
            if (Validator.isNotNull(pgcSummary.getFormType()))
            {
                typeName = pgcSummary.getFormType();
                sb.append("and r_object_type ='"); // form type is passed
                sb.append(pgcSummary.getFormType());
                sb.append("'");
            }
             //DSI:START::Veera Reddy:: To fetch the value from object_name instead of pgc_req_title 
            if (Validator.isNotNull(pgcSummary.getRequestTitle()))
            {
                sb.append(" and lower(object_name) like '%"); // request title
                sb.append(pgcSummary.getRequestTitle().toLowerCase(Locale.US));
                sb.append("%'");
            }
             //DSI:END::Veera Reddy:: To fetch the value from object_name instead of pgc_req_title 
            if (Validator.isNotNull(pgcSummary.getRequestor()))
            {
                sb.append(" and lower(pgc_req_name) like '%");
                sb.append(pgcSummary.getRequestor().toLowerCase(Locale.US));
                sb.append("%'");
            }
            if (Validator.isNotNull(pgcSummary.getStatus()))
            {
                sb.append(" and pgc_status = '");
                sb.append(pgcSummary.getStatus());
                sb.append("'");
            }
            if (Validator.isNotNull(pgcSummary.getDateType()))
            {
                String dateType = "pgc_meeting_date";
                if (pgcSummary.getDateType().equalsIgnoreCase("eventDate"))
                {
                    dateType = "pgc_start_date";
                }
                if (Validator.isNotNull(pgcSummary.getStartDate()) && Validator.isNotNull(pgcSummary.getEndDate()))
                {
                    sb.append(" and (");
                    sb.append(dateType);
                    sb.append(" between '");
                    sb.append(pgcSummary.getStartDate());
                    sb.append("' and '");
                    sb.append(pgcSummary.getEndDate());
                    sb.append("')");
                } else if (Validator.isNotNull(pgcSummary.getStartDate()))
                {
                    sb.append(" and (");
                    sb.append(dateType);
                    sb.append(" between '");
                    sb.append(pgcSummary.getStartDate() + " 00:00:00");
                    sb.append("' and '");
                    sb.append(pgcSummary.getStartDate() + " 11:23:59");
                    sb.append("')");

                } else if (Validator.isNotNull(pgcSummary.getEndDate()))
                {
                    sb.append(" and (");
                    sb.append(dateType);
                    sb.append(" between '");
                    sb.append(pgcSummary.getEndDate() + " 00:00:00");
                    sb.append("' and '");
                    sb.append(pgcSummary.getEndDate() + " 11:23:59");
                    sb.append("')");

                }
            }
        }
        sb.append(" ORDER BY pgc_req_id DESC");
        String expression = sb.toString();
        String maxresult = PGCCommonConstants.MAX_RESULTS;
        try
        {
            expression = URLEncoder.encode(expression, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            LOGGER.error("Error while encoding: " + e.getMessage(), e);
        }
        /*
         * creating URL to get all requests for the logged in user
         */
        StringBuilder connectionURL = new StringBuilder(PGCCommonConstants.BASE_URL
                + PGCCommonConstants.REPOSITORY_NAME + "/query.xml?expression=" + expression + "&typeName=" + typeName
                + "&maxResults=" + maxresult + "&startIndex=" + PGCCommonConstants.START_INDEX + "&endIndex="
                + PGCCommonConstants.END_INDEX);
        String xmlContent = null;

        try
        {
            xmlContent = DocumentumServiceUtil.getMessage(connectionURL.toString());
        } catch (WebServiceCallException e)
        {
            LOGGER.error("Error while retrieving response xml: " + e.getMessage(), e);
        }
        if (Validator.isNotNull(xmlContent))
        {
            ResponseReadersFactory.getResponseReader(DashboardResponseReader.class).parseResponse(xmlContent, requests);
        }
        return requests;
    }

    public void populateRequestFormFromDB(PGCForm form, String requestId, String typeName)
    {
        String xmlResponse = getCompleteFormXML(requestId, typeName);
        switch (form.getFormType())
        {
        case DispExhibit:
            ResponseReadersFactory.getResponseReader(DisplayExhibitFormReader.class).parseResponse(xmlResponse, form);
            break;
        case POMembership:
            ResponseReadersFactory.getResponseReader(POMembershipFormReader.class).parseResponse(xmlResponse, form);
            break;
        case EduItemsVal:
            ResponseReadersFactory.getResponseReader(EduItemsValFormReader.class).parseResponse(xmlResponse, form);
            break;
        case AdvBoard:
            ResponseReadersFactory.getResponseReader(AdvisoryBoardFormReader.class).parseResponse(xmlResponse, form);
            break;
        case CorporateSupport:
            ResponseReadersFactory.getResponseReader(CorporateSupportFormReader.class).parseResponse(xmlResponse, form);
            break;
        case CSAgreement:
            ResponseReadersFactory.getResponseReader(ServiceAgreementFormReader.class).parseResponse(xmlResponse, form);
            break;
        case HCPConsultant:
            ResponseReadersFactory.getResponseReader(HCPConsultantFormReader.class).parseResponse(xmlResponse, form);
            break;
        case CharitableDonation:
            ResponseReadersFactory.getResponseReader(CharitableDonationFormReader.class).parseResponse(xmlResponse, form);
            break;
        case GenRequest:
            ResponseReadersFactory.getResponseReader(GeneralRequestFormReader.class).parseResponse(xmlResponse, form);
            break;
       default : LOGGER.info("Default case populateRequestFormFromDB()");
        	   
        }
    }

    public String saveDocumentumForm(DocumentumRequest request, String documentumId) throws PGCPersistenceException
    {
        String statusCode = StringPool.BLANK;
        RequestTO requestTO = null;
        WebServiceClient webServiceClient = WebServiceClient.getInstance();
        ResponseTO responseTO = new ResponseTO();
        ArrayList<File> contentUpload = new ArrayList<File>();
        trustSelfSignedSSL();
        try
        {
            if (Validator.isNotNull(request))
            {
                String xmlStr = request.getXml();
                List<CommonsMultipartFile> attachments = request.getAttachmentFiles();
                if (!attachments.isEmpty())
                {
                    requestTO = DocumentumServiceUtil.processXML(xmlStr, PGCCommonConstants.CONTENT_REQUIRED_T,
                            documentumId);
                    LOGGER.info("XML Content with Attachment"+xmlStr);
                    contentUpload.add(DocumentumServiceUtil.persistXml(requestTO.getData()));

                    for (CommonsMultipartFile f : attachments)
                    {

                        if (!f.isEmpty())
                        {
                            File file = new File(f.getOriginalFilename());
                            f.transferTo(file);
                            if (file.isFile())
                            {
                                contentUpload.add(file);
                            }

                        }
                    }

                    responseTO = webServiceClient.executePost(requestTO, contentUpload);
                    LOGGER.info("Response status code With File Attachment" + responseTO.getStatusCode());
                } else
                {
                    // To Get Request POJO
                    requestTO = DocumentumServiceUtil.processXML(xmlStr, PGCCommonConstants.CONTENT_REQUIRED_F,
                            documentumId);
                    LOGGER.info("XML Content without Attachment"+xmlStr);
                    responseTO = webServiceClient.executePost(requestTO);
                    LOGGER.info("Response status code Without File Attachment" + responseTO.getStatusCode());
                }
            }
            if (Validator.isNotNull(responseTO.getStatusCode()))
            {
                statusCode = Integer.toString(responseTO.getStatusCode());
           
            }
        } catch (WebServiceCallException e)
        {
            LOGGER.error("webservice call exeption: " + e.getMessage(), e);
            throw new PGCPersistenceException(e.getMessage(), e);
        } catch (Exception e)
        {
            LOGGER.error("PGCPersistenceException exp in save" + e.getMessage(), e);
            throw new PGCPersistenceException(e.getMessage(), e);
        } finally
        {
        	LOGGER.info("saveDocumentumForm()-finally");
            /*
            if (Validator.isNotNull(contentUpload) && contentUpload.size() > 0)
            {
                for (File f : contentUpload)
                {
                   f.delete();
                }
            } */
        }

        return statusCode;
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

    public void saveRequestForm(PGCForm form, boolean createNew) throws PGCPersistenceException
    {

        DocumentumRequest req = null;
      //Begin::Veera Reddy ::Modified to fix the issue for the incident 79032
        if("Submitted".equalsIgnoreCase(form.getFormStatus()) || "PGC Approved-Agreement Pending".equalsIgnoreCase(form.getFormStatus())){
        	RequestorInformation reqInfo=form.getReqInfo();
        	if(reqInfo != null){
        		switch (form.getFormType())
                {
                case AdvBoard:
                	reqInfo.setVpApprovalReq(true);
                	form.setReqInfo(reqInfo);
                    break;
                default :
                	reqInfo.setMApprovalReq(true);
            		form.setReqInfo(reqInfo);
            		break;
                }
        	}
        }
      //End::Veera Reddy ::Modified to fix the issue for the incident 79032
        switch (form.getFormType())
        {
        case DispExhibit:
            req = RequestWritersFactory.getRequestWriter(DisplayExhibitFormWriter.class).createRequest(form);
            break;
        case POMembership:
            req = RequestWritersFactory.getRequestWriter(POMembershipFormWriter.class).createRequest(form);
            break;
        case EduItemsVal:
            req = RequestWritersFactory.getRequestWriter(EduItemsValFormWriter.class).createRequest(form);
            break;
        case HCPConsultant:
            req = RequestWritersFactory.getRequestWriter(HCPConsultantFormWriter.class).createRequest(form);
            break;
        case AdvBoard:
            req = RequestWritersFactory.getRequestWriter(AdvisoryBoardFormWriter.class).createRequest(form);
            break;
        case CSAgreement:
            req = RequestWritersFactory.getRequestWriter(ServiceAgreementFormWriter.class).createRequest(form);
            break;
        case CorporateSupport:
            req = RequestWritersFactory.getRequestWriter(CorporateSupportFormWriter.class).createRequest(form);
            break;
        case CharitableDonation:
            req = RequestWritersFactory.getRequestWriter(CharitableDonationFormWriter.class).createRequest(form);
            break;
        case GenRequest:
            req = RequestWritersFactory.getRequestWriter(GeneralRequestFormWriter.class).createRequest(form);
            break;
        default : LOGGER.info("Default in saveRequestForm()");
        }
        String documentumId = StringPool.BLANK;
        if (Validator.isNotNull(form.getObjectId()))
        {
            documentumId = form.getObjectId();
        }
        try
        {
            String statusCode = saveDocumentumForm(req, documentumId);
             if(!statusCode.equalsIgnoreCase("200")){
                
                LOGGER.error("Error while saving RequestForm:"+statusCode);
                throw new PGCPersistenceException();
                   
                
            }
        } catch (PGCPersistenceException pe)
        {
        	LOGGER.error("PGCPersistenceException while saving RequestForm: " + pe.getMessage(), pe);
            throw new PGCPersistenceException();
           
        }
    }
}
