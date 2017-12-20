/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * <a href="RequestWritersFactory.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public final class RequestWritersFactory
{

    private static final Log LOGGER = LogFactoryUtil.getLog(RequestWritersFactory.class);

    private static Map<String, IRequestWriter> WRITERS_MAP = new HashMap<String, IRequestWriter>();

    public static IRequestWriter getRequestWriter(Class<? extends IRequestWriter> writerClass)
    {
        String writerClassName = writerClass.getName();
        IRequestWriter writer = WRITERS_MAP.get(writerClassName);
        if (writer == null)
        {
            try
            {
                writer = writerClass.newInstance();
                WRITERS_MAP.put(writerClassName, writer);
            } catch (InstantiationException ie)
            {
                LOGGER.error("Got exception when trying to instantiate request writer class - " + writerClassName, ie);
            } catch (IllegalAccessException iae)
            {
                LOGGER.error("Got exception when trying to instantiate request writer class - " + writerClassName, iae);
            }
        }
        return writer;
    }

    private RequestWritersFactory()
    {
    }

}
