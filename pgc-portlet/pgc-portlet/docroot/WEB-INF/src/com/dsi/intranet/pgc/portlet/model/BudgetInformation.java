/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="BudgetInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class BudgetInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    @DocumentumPropertyMapping(name = "pgc_bud_disp_exhibit")
    private String displayExhibitBudget;
    @DocumentumPropertyMapping(name = "pgc_budget_prof_org")
    private String poMemberBudget;

    public String getDisplayExhibitBudget()
    {
        return displayExhibitBudget;
    }

    public String getPoMemberBudget()
    {
        return poMemberBudget;
    }

    public void setDisplayExhibitBudget(String displayExhibitBudget)
    {
        this.displayExhibitBudget = displayExhibitBudget;
    }

    public void setPoMemberBudget(String poMemberBudget)
    {
        this.poMemberBudget = poMemberBudget;
    }

}
