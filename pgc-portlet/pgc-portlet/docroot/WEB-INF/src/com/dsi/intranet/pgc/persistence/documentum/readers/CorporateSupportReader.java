/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.CorporateSupportInformation;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

/**
 * <a href="CorporateSupportReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class CorporateSupportReader extends BlockInfoReader
{

    @Override
    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate)
    {
        if (!(objToPopulate instanceof CorporateSupportInformation))
        {
            throw new IllegalArgumentException(
                    "objToPopulate to CorporateSupportInfoReader should be a CorporateSupport block!");
        }
        if (xmlRespDoc != null)
        {
            CorporateSupportInformation infoObj = (CorporateSupportInformation) objToPopulate;

            Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
            DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
        }
    }

}
