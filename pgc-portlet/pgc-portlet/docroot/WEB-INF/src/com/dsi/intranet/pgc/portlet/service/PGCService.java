/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.service;

import java.util.List;

import com.dsi.intranet.pgc.exception.PGCPersistenceException;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;

/**
 * <a href="PGCService.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface PGCService
{

    List<PGCRequestSummary> getUserPGCRequestsList(PGCRequestSummary pgcSummary, String employeeId);

    void populateFormData(PGCForm form, String typeName) throws PGCPersistenceException;

    void saveForm(PGCForm form) throws PGCPersistenceException;

}
