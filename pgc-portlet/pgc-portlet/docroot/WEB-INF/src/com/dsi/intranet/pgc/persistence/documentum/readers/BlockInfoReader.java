/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.readers;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.dsi.intranet.pgc.persistence.documentum.IResponseReader;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

/**
 * <a href="BlockInfoReader.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public abstract class BlockInfoReader implements IResponseReader
{

    public void parseResponse(String xmlResponse, Object objToPopulate)
    {
    }

    public abstract void parseResponsePart(Document xmlRespDoc, Map<String, List<DocumentumFile>> existingFilesByType,
            Object objToPopulate);

}
