/**
 * Copyright � 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.DisplayExhibitInformation;

/**
 * <a href="DisplayExhibitInformationWriter.java"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class DisplayExhibitInformationWriter extends BlockInfoWriter
{
    @Override
    public String createRequestPart(Object dataObject)
    {
        if (!(dataObject instanceof DisplayExhibitInformation))
        {
            throw new IllegalArgumentException("");
        }
        return DocumentumAnnotationProcessor.beanDataToXmlStr(dataObject);
    }

}
