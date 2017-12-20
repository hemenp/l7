/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.beans.PropertyEditorSupport;

import com.dsi.intranet.pgc.portlet.constants.PGCFormType;

/**
 * <a href="PGCFormTypeEditor.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project PGC
 * @Author Resmy Mathew
 * @Description 
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public class PGCFormTypeEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        return getValue() == null ? "" : getValue().toString();
    }

    @Override
    public void setAsText(String textVal) throws IllegalArgumentException
    {
        setValue(PGCFormType.valueOf(textVal));
    }

}
