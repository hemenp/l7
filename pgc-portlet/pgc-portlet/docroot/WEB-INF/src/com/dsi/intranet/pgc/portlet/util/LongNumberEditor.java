/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.beans.PropertyEditorSupport;

/**
 * <a href="LongNumberEditor.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description editor support for long number
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class LongNumberEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        String returnVal = "";
        if (getValue() instanceof Long)
        {
            returnVal = String.valueOf(getValue());
        }
        if (getValue() instanceof String[])
        {
            returnVal = ((String[]) getValue())[0];
        }
        return returnVal;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        setValue(Long.valueOf(text));
    }
}
