/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;

/**
 * <a href="MyPropertyEditorRegistrar.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description property editor register for PGC
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar
{

    public void registerCustomEditors(PropertyEditorRegistry registry)
    {
        registry.registerCustomEditor(Long.class, new LongNumberEditor());
        registry.registerCustomEditor(PGCFormType.class, new PGCFormTypeEditor());
        registry.registerCustomEditor(Date.class, new CustomDateEditor(PGCCommonConstants.APPLICATION_DATE_FORMATTER,
                true));
    }

}
