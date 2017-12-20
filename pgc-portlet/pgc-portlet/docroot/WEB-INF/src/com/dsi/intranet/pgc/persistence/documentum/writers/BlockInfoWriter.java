/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.DocumentumRequest;
import com.dsi.intranet.pgc.persistence.documentum.IRequestWriter;
import com.dsi.intranet.pgc.portlet.model.PGCForm;

/**
 * <a href="BlockInfoWriter.java"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public abstract class BlockInfoWriter implements IRequestWriter
{
    
    public DocumentumRequest createRequest(PGCForm form)
    {
        return null;
    }

}
