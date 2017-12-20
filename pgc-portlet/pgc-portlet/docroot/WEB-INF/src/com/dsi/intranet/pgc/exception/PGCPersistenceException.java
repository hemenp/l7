/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.exception;

/**
 * <a href="PGCPersistenceException.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class PGCPersistenceException extends Exception
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    public PGCPersistenceException()
    {
        super();
    }

    public PGCPersistenceException(String msg)
    {
        super(msg);
    }

    public PGCPersistenceException(String msg, Throwable t)
    {
        super(msg, t);
    }

}
