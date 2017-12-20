/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileReadMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileWriteMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="EducationalItemsInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class EducationalItemsInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;
    @DocumentumPropertyMapping(name = "pgc_edu_item_desc")
    private String eduItemDescription;
    @DocumentumPropertyMapping(name = "pgc_hcp_select_desc")
    private String hcpSelectDescription;
    @DocumentumFileWriteMapping(attachmentType = "Documentation of the retail price and item description")
    private List<CommonsMultipartFile> itemRetailAttachment;
    @DocumentumFileReadMapping(attachmentType = "Documentation of the retail price and item description")
    private List<DocumentumFile> itemRetailExistingFile;
    @DocumentumPropertyMapping(name = "pgc_retail_value_of_item")
    private String itemRetailValue;
    @DocumentumPropertyMapping(name = "pgc_no_of_hcps")
    private int numOfHcp;
    @DocumentumPropertyMapping(name = "pgc_no_of_edu_items")
    private int numOfItems;
    @DocumentumPropertyMapping(name = "pgc_edu_val_phy_pat")
    private String physicianEduValue;

    public String getEduItemDescription()
    {
        return eduItemDescription;
    }

    public String getHcpSelectDescription()
    {
        return hcpSelectDescription;
    }

    public List<CommonsMultipartFile> getItemRetailAttachment()
    {
        return itemRetailAttachment;
    }

    public List<DocumentumFile> getItemRetailExistingFile()
    {
        return itemRetailExistingFile;
    }

    public String getItemRetailValue()
    {
        return itemRetailValue;
    }

    public int getNumOfHcp()
    {
        return numOfHcp;
    }

    public int getNumOfItems()
    {
        return numOfItems;
    }

    public String getPhysicianEduValue()
    {
        return physicianEduValue;
    }

    public void setEduItemDescription(String eduItemDescription)
    {
        this.eduItemDescription = eduItemDescription;
    }

    public void setHcpSelectDescription(String hcpSelectDescription)
    {
        this.hcpSelectDescription = hcpSelectDescription;
    }

    public void setItemRetailAttachment(List<CommonsMultipartFile> itemRetailAttachment)
    {
        this.itemRetailAttachment = itemRetailAttachment;
    }

    public void setItemRetailExistingFile(List<DocumentumFile> itemRetailExistingFile)
    {
        this.itemRetailExistingFile = itemRetailExistingFile;
    }

    public void setItemRetailValue(String itemRetailValue)
    {
        this.itemRetailValue = itemRetailValue;
    }

    public void setNumOfHcp(int numOfHcp)
    {
        this.numOfHcp = numOfHcp;
    }

    public void setNumOfItems(int numOfItems)
    {
        this.numOfItems = numOfItems;
    }

    public void setPhysicianEduValue(String physicianEduValue)
    {
        this.physicianEduValue = physicianEduValue;
    }
}
