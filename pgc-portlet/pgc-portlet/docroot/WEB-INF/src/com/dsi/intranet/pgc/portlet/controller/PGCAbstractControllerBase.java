/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.controller;

import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;
import com.dsi.intranet.pgc.portlet.util.DropDownUtil;
import com.dsi.intranet.pgc.portlet.util.LongNumberEditor;
import com.dsi.intranet.pgc.portlet.util.PGCFormTypeEditor;

/**
 * <a href="PGCAbstractControllerBase.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public abstract class PGCAbstractControllerBase
{
    protected void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Long.class, new LongNumberEditor());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(PGCCommonConstants.APPLICATION_DATE_FORMATTER,
                true));
        binder.registerCustomEditor(PGCFormType.class, new PGCFormTypeEditor());
    }

    @ModelAttribute
    public void referenceData(ModelMap refMap)
    {
        refMap.putAll(DropDownUtil.getAllDropDownRefs());
    }

}