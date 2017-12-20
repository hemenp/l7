/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsi.intranet.pgc.exception.PGCPersistenceException;
import com.dsi.intranet.pgc.persistence.IPGCPersistence;
import com.dsi.intranet.pgc.persistence.documentum.DocumentumPersistence;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;

/**
 * <a href="DefaultPGCServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
@Service(value = "defaultImpl")
public class DefaultPGCServiceImpl implements PGCService
{
    private IPGCPersistence persistSvc = new DocumentumPersistence();

    public List<PGCRequestSummary> getUserPGCRequestsList(PGCRequestSummary pgcSummary, String employeeId)
    {
        return persistSvc.getUserRequestsList(pgcSummary, employeeId);
    }

    public void populateFormData(PGCForm form, String typeName) throws PGCPersistenceException
    {
        persistSvc.populateRequestFormFromDB(form, form.getRequestId(), typeName);
    }

    public void saveForm(PGCForm form) throws PGCPersistenceException
    {
        persistSvc.saveRequestForm(form, true);
    }

}
