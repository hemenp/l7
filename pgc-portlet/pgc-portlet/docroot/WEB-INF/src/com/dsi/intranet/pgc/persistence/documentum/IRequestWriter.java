/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import com.dsi.intranet.pgc.portlet.model.PGCForm;

/**
 * <a href="IRequestWriter.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface IRequestWriter
{
    DocumentumRequest createRequest(PGCForm form);

    String createRequestPart(Object dataObject);
}
