/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.dsi.intranet.pgc.persistence.documentum.ResponseReadersFactory;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.PGCForm;

/**
 * <a href="POMembershipFormReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class POMembershipFormReader extends FormReader
{

    @Override
    protected void parseResponseIntoPGCForm(Document xmlDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            PGCForm form)
    {
        ResponseReadersFactory.getResponseReader(FormCommonInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form);
        ResponseReadersFactory.getResponseReader(RequestorInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getReqInfo());
        if (form.getFormStatus().equalsIgnoreCase(PGCCommonConstants.STATUS_APPROVED))
        {
            ResponseReadersFactory.getResponseReader(ModificationInformationReader.class).parseResponsePart(xmlDoc,
                    existingFilesByType, form.getModInfo());
        }
        ResponseReadersFactory.getResponseReader(CheckRequestInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getCheckReqInfo());
        ResponseReadersFactory.getResponseReader(BudgetInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getBudgetInfo());
        ResponseReadersFactory.getResponseReader(POMembershipInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getpOMemInfo());
    }

}
