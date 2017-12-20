/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <a href="DocumentumRequest.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class DocumentumRequest
{
    private List<CommonsMultipartFile> attachmentFiles;

    private String xml;

    public List<CommonsMultipartFile> getAttachmentFiles()
    {
        return attachmentFiles;
    }

    public String getXml()
    {
        return xml;
    }

    public void setAttachmentFiles(List<CommonsMultipartFile> attachmentFiles)
    {
        this.attachmentFiles = attachmentFiles;
    }

    public void setXml(String xml)
    {
        this.xml = xml;
    }

}
