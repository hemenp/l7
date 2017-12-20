/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.RequestorInformation;

/**
 * <a href="RequestorInformationReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class RequestorInformationReader extends BlockInfoReader
{

    @Override
    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate)
    {

        if (!(objToPopulate instanceof RequestorInformation))
        {
            throw new IllegalArgumentException("objToPopulate to RequestorInfoReader should be a Requestor block!");
        }
        if (xmlRespDoc != null)
        {
            RequestorInformation infoObj = (RequestorInformation) objToPopulate;

            Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
            DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
        }
    }

}
