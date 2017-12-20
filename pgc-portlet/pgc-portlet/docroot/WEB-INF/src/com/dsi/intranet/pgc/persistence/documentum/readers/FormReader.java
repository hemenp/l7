/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.dsi.intranet.pgc.persistence.documentum.IResponseReader;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.PGCForm;

/**
 * <a href="FormReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public abstract class FormReader implements IResponseReader
{
	/**
	 * Logger for this class
	 */
	private static final Log LOGGER = LogFactoryUtil
		.getLog(FormReader.class);

    public void parseResponse(String xmlResponse, Object objToPopulate)
    {
        if (!(objToPopulate instanceof PGCForm))
        {
            throw new IllegalArgumentException("objToPopulate must be a PGCForm. But got: " + objToPopulate.getClass());
        }

        try
        {
        	Document xmlDoc = DocumentHelper.parseText(xmlResponse);
        	MultiValueMap<String, DocumentumFile> tempFilesByType = new LinkedMultiValueMap<String, DocumentumFile>();
            Node countAttrNode = xmlDoc.selectSingleNode("//objects/count");
            int countValue = Integer.parseInt(countAttrNode.getText());
       
        if (countValue > 0)
        {
            List<Node> fileAttachmentNodes = xmlDoc.selectNodes("//objects/object");
            for (Node n : fileAttachmentNodes)
            {
                Node attrNode = n.selectSingleNode("properties/StringProperty[name=\"r_object_type\"]/value");
                if (attrNode != null && attrNode.getText().equalsIgnoreCase("dsi_pgc_attachment"))
                {
                    DocumentumFile existingDocFile = new DocumentumFile();
                    attrNode = n.selectSingleNode("properties/StringProperty[name=\"object_name\"]/value");
                    if (attrNode != null)
                    {
                        existingDocFile.setFileName(attrNode.getText());
                    }
                    attrNode = n.selectSingleNode("properties/StringProperty[name=\"pgc_attachment_type\"]/value");
                    if (attrNode != null)
                    {
                        existingDocFile.setFileType(attrNode.getText());
                    }
                    attrNode = n.selectSingleNode("properties/StringProperty[name=\"r_object_id\"]/value");
                    if (attrNode != null)
                    {
                        existingDocFile.setFileId(attrNode.getText());
                    }

                    tempFilesByType.add(existingDocFile.getFileType(), existingDocFile);

                }
            }
        }
       
	        Map<String, List<DocumentumFile>> filesByType = new HashMap<String, List<DocumentumFile>>(tempFilesByType
	                .keySet().size());
	        for (Entry<String, List<DocumentumFile>> e : tempFilesByType.entrySet())
	        {
	            filesByType.put(e.getKey(), e.getValue());
	        }
	        parseResponseIntoPGCForm(xmlDoc, filesByType, (PGCForm) objToPopulate);
        } catch (DocumentException e)
        {
			LOGGER.error("parseResponse()", e);
        }
        
    }

    protected abstract void parseResponseIntoPGCForm(Document xmlResponseDoc,
            Map<String, List<DocumentumFile>> existingFilesByType, PGCForm form);

    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> filesByFileType,
            Object objToPopulate)
    {
    }

}
