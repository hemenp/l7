/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

/**
 * <a href="IResponseReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface IResponseReader
{
    void parseResponse(String xmlResponse, Object objToPopulate);

    void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate);
}
