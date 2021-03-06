/**
 * Copyright � 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.DocumentumRequest;
import com.dsi.intranet.pgc.persistence.documentum.IRequestWriter;
import com.dsi.intranet.pgc.persistence.documentum.RequestWritersFactory;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumConstants;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumConstants.FilePaths;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.util.PGCCommonUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <a href="CorporateSupportFormWriter.java"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name             |       Date       	|       Reason
 * ---------------------------------------------------------------------------------
 *  Veera Reddy		|	Aug 22 2012		|	Modified To create out going request xmls
 */
public class CorporateSupportFormWriter implements IRequestWriter
{
    @Override
    public DocumentumRequest createRequest(PGCForm form)
    {
        DocumentumRequest req = new DocumentumRequest();
        String path = FilePaths.CORPORATEUPPORT_PATH;
        if (form != null)
        {
            StringBuilder xmlStrBuf = new StringBuilder();

            xmlStrBuf.append(DocumentumConstants.XML_PREFIX).append(
                    DocumentumConstants.XML_FORM_OBJECT_FORMAT.format(new String[] { "Test Corporate Support",
                            "dsi_pgc_corp_sup", path }));

            String xmlStrPart = null;

            xmlStrPart = RequestWritersFactory.getRequestWriter(FormCommonInformationWriter.class).createRequestPart(form);
            xmlStrBuf.append(xmlStrPart);

            if (form.getFormStatus().equalsIgnoreCase(PGCCommonConstants.STATUS_APPROVED))
            {
                xmlStrPart = RequestWritersFactory.getRequestWriter(ModificationInformationWriter.class)
                        .createRequestPart(form.getModInfo());
                xmlStrBuf.append(xmlStrPart);
            }

            xmlStrPart = RequestWritersFactory.getRequestWriter(RequestorInformationWriter.class).createRequestPart(
                    form.getReqInfo());
            xmlStrBuf.append(xmlStrPart);

            xmlStrPart = RequestWritersFactory.getRequestWriter(CheckRequestInformationWriter.class).createRequestPart(
                    form.getCheckReqInfo());
            xmlStrBuf.append(xmlStrPart);

            xmlStrBuf.append(xmlStrPart);

            xmlStrPart = RequestWritersFactory.getRequestWriter(CorporateSupportWriter.class).createRequestPart(
                    form.getCorporateSupport());
            xmlStrBuf.append(xmlStrPart).append(DocumentumConstants.XMLElements.PROPERTY_ELEMENT_END).append(
                    DocumentumConstants.XMLElements.OBJECT_ELEMENT_END);

            Object[] fileContainerBlocks = new Object[] { form.getCorporateSupport() };
            List<CommonsMultipartFile> allFiles = new ArrayList<CommonsMultipartFile>();
            xmlStrPart = DocumentumAnnotationProcessor.beanFilesToXml(path, fileContainerBlocks, allFiles);

            xmlStrBuf.append(xmlStrPart);

            xmlStrBuf.append(DocumentumConstants.XML_SUFFIX);
          //DSI:START::Veera Reddy:: To create out going request xmls
            PGCCommonUtil.createXml("Corporate Support",xmlStrBuf.toString());
          //DSI:END::Veera Reddy:: To create out going request xmls
            req.setXml(xmlStrBuf.toString());
            req.setAttachmentFiles(allFiles);
        }

        return req;
    }

    public String createRequestPart(Object dataObject)
    {
        return null;
    }

}
