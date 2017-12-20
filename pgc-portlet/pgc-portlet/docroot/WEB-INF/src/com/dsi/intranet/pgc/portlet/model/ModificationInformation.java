/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;
import java.util.Date;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="ModificationInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class ModificationInformation implements Serializable
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    @DocumentumPropertyMapping(name = "pgc_bus_need_mod")
    private String businessNeed;
    @DocumentumPropertyMapping(name = "pgc_mod_eff_date")
    private Date modEffectiveDate;
    @DocumentumPropertyMapping(name = "pgc_proposed_mod")
    private String modificationDesc;

    public String getBusinessNeed()
    {
        return businessNeed;
    }

    public Date getModEffectiveDate()
    {
        return modEffectiveDate;
    }

    public String getModificationDesc()
    {
        return modificationDesc;
    }

    public void setBusinessNeed(String businessNeed)
    {
        this.businessNeed = businessNeed;
    }

    public void setModEffectiveDate(Date modEffectiveDate)
    {
        this.modEffectiveDate = modEffectiveDate;
    }

    public void setModificationDesc(String modificationDesc)
    {
        this.modificationDesc = modificationDesc;
    }

}