/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence;

import java.util.List;

import com.dsi.intranet.pgc.exception.PGCPersistenceException;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;

/**
 * <a href="IPGCPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface IPGCPersistence
{

    List<PGCRequestSummary> getUserRequestsList(PGCRequestSummary pgcSummary, String employeeId);

    void populateRequestFormFromDB(PGCForm form, String formRObjId, String typeName) throws PGCPersistenceException;
	
    void saveRequestForm(PGCForm form, boolean createNew) throws PGCPersistenceException;

}
