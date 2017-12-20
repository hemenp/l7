/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="DocumentumDateConverter.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public final class DocumentumDateConverter
{
    private static final SimpleDateFormat DT_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    private static final SimpleDateFormat DT_PARSER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S z");

    public static synchronized String format(Date dt)
    {
        String dateFormatted = DT_FORMATTER.format(dt);
        String documentumDateFormatted = dateFormatted.substring(0, dateFormatted.length() - 2) + ':'
                + dateFormatted.substring(dateFormatted.length() - 2);
        return documentumDateFormatted;
    }

    public static synchronized String format(Object dt)
    {
        String dateFormatted = DT_FORMATTER.format(dt);
        String documentumDateFormatted = dateFormatted.substring(0, dateFormatted.length() - 2) + ':'
                + dateFormatted.substring(dateFormatted.length() - 2);
        return documentumDateFormatted;
    }

    public static synchronized Date parse(String documentumDateStr) throws ParseException
    {
        Date dateValue = null;
        if(Validator.isNotNull(documentumDateStr)){
	        String trimedDate = documentumDateStr.trim();
	        if (trimedDate.length() > 0)
	        {
	            dateValue = DT_PARSER.parse(trimedDate);
	        }
        }
        return dateValue;
    }

    private DocumentumDateConverter()
    {
    }

}
