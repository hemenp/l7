/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.BudgetInformation;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

/**
 * <a href="BudgetInformationReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class BudgetInformationReader extends BlockInfoReader
{

    @Override
    public void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate)
    {
        if (!(objToPopulate instanceof BudgetInformation))
        {
            throw new IllegalArgumentException("objToPopulate to BudgetInfoReader should be a Budget!");
        }
        if (xmlRespDoc != null)
        {
            BudgetInformation infoObj = (BudgetInformation) objToPopulate;

            Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
            DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
        }
    }

}
