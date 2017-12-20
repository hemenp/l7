/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.CheckRequestInformation;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

/**
 * <a href="CheckRequestInformationReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class CheckRequestInformationReader extends BlockInfoReader
{

    @Override
    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existinFilesByType,
            Object objToPopulate)
    {
        if (!(objToPopulate instanceof CheckRequestInformation))
        {
            throw new IllegalArgumentException("objToPopulate to CheckRequestInfoReader should be a CheckRequest!");
        }
        if (xmlRespDoc != null)
        {
            CheckRequestInformation infoObj = (CheckRequestInformation) objToPopulate;

            Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
            DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existinFilesByType);
        }
    }

}
