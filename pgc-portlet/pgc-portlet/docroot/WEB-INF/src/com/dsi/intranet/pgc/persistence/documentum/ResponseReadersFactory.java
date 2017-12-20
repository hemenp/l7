/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.util.Map;
import java.util.HashMap;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * <a href="ResponseReadersFactory.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description 
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public final class ResponseReadersFactory
{

    private static final Log LOGGER = LogFactoryUtil.getLog(ResponseReadersFactory.class);

    private static Map<String, IResponseReader> READERS_MAP = new HashMap<String, IResponseReader>();

    public static IResponseReader getResponseReader(Class<? extends IResponseReader> readerClass)
    {
        String readerClassName = readerClass.getName();
        IResponseReader reader = READERS_MAP.get(readerClassName);

        if (reader == null)
        {
            try
            {
                reader = readerClass.newInstance();
                READERS_MAP.put(readerClassName, reader);
            } catch (InstantiationException ie)
            {
                LOGGER.error("Got exception when trying to instantiate response reader class - " + readerClassName, ie);
            } catch (IllegalAccessException iae)
            {
                LOGGER.error("Got exception when trying to instantiate response reader class - " + readerClassName, iae);
            }
        }
        return reader;
    }

    private ResponseReadersFactory()
    {
    }

}
