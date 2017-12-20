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
import com.dsi.intranet.pgc.portlet.model.EducationalItemsInformation;

/**
 * <a href="EduItemsInformationReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class EduItemsInformationReader extends BlockInfoReader
{

    @Override
    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate)
    {
        if (!(objToPopulate instanceof EducationalItemsInformation))
        {
            throw new IllegalArgumentException(
                    "objToPopulate to EducationalItemsInfoReader should be a EducationalItems block!");
        }
        if (xmlRespDoc != null)
        {
            EducationalItemsInformation infoObj = (EducationalItemsInformation) objToPopulate;

            Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
            DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
        }
    }
}
