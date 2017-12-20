/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

/**
 * <a href="DocumentumFile.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class DocumentumFile implements Serializable
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    private String fileId;
    private String fileName;
    private String fileType;

    public String getFileId()
    {
        return fileId;
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getFileType()
    {
        return fileType;
    }

    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

}
