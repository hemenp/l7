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
 * <a href="POMembershipInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class POMembershipInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;
    @DocumentumFileWriteMapping(attachmentType = "Completed W9")
    private List<CommonsMultipartFile> completedW9;
    @DocumentumFileReadMapping(attachmentType = "Completed W9")
    private List<DocumentumFile> completedW9ExistingFile;
    @DocumentumPropertyMapping(name = "pgc_mem_benefits")
    private String membershipBenifits;
    @DocumentumFileWriteMapping(attachmentType = "Membership brochure / documentation")
    private List<CommonsMultipartFile> membershipBroucher;
    @DocumentumFileReadMapping(attachmentType = "Membership brochure / documentation")
    private List<DocumentumFile> membershipBroucherExistingFile;
    @DocumentumPropertyMapping(name = "pgc_bus_need_mem")
    private String membershipBusinessNeeds;
    @DocumentumPropertyMapping(name = "pgc_mem_fee")
    private String membershipFee;
    @DocumentumPropertyMapping(name = "pgc_term_mem_months", mapToType = "numberProperty")
    private int membershipMonths;
    @DocumentumPropertyMapping(name = "pgc_term_mem_years", mapToType = "numberProperty")
    private int membershipYears;
    @DocumentumPropertyMapping(name = "pgc_org_name")
    private String orgName;
    @DocumentumPropertyMapping(name = "pgc_web_address")
    private String orgWebSiteAddress;

    public List<CommonsMultipartFile> getCompletedW9()
    {
        return completedW9;
    }

    public List<DocumentumFile> getCompletedW9ExistingFile()
    {
        return completedW9ExistingFile;
    }

    public String getMembershipBenifits()
    {
        return membershipBenifits;
    }

    public List<CommonsMultipartFile> getMembershipBroucher()
    {
        return membershipBroucher;
    }

    public List<DocumentumFile> getMembershipBroucherExistingFile()
    {
        return membershipBroucherExistingFile;
    }

    public String getMembershipBusinessNeeds()
    {
        return membershipBusinessNeeds;
    }

    public String getMembershipFee()
    {
        return membershipFee;
    }

    public int getMembershipMonths()
    {
        return membershipMonths;
    }

    public int getMembershipYears()
    {
        return membershipYears;
    }

    public String getOrgName()
    {
        return orgName;
    }

    public String getOrgWebSiteAddress()
    {
        return orgWebSiteAddress;
    }

    public void setCompletedW9(List<CommonsMultipartFile> completedW9)
    {
        this.completedW9 = completedW9;
    }

    public void setCompletedW9ExistingFile(List<DocumentumFile> completedW9ExistingFile)
    {
        this.completedW9ExistingFile = completedW9ExistingFile;
    }

    public void setMembershipBenifits(String membershipBenifits)
    {
        this.membershipBenifits = membershipBenifits;
    }

    public void setMembershipBroucher(List<CommonsMultipartFile> membershipBroucher)
    {
        this.membershipBroucher = membershipBroucher;
    }

    public void setMembershipBroucherExistingFile(List<DocumentumFile> membershipBroucherExistingFile)
    {
        this.membershipBroucherExistingFile = membershipBroucherExistingFile;
    }

    public void setMembershipBusinessNeeds(String membershipBusinessNeeds)
    {
        this.membershipBusinessNeeds = membershipBusinessNeeds;
    }

    public void setMembershipFee(String membershipFee)
    {
        this.membershipFee = membershipFee;
    }

    public void setMembershipMonths(int membershipMonths)
    {
        this.membershipMonths = membershipMonths;
    }

    public void setMembershipYears(int membershipYears)
    {
        this.membershipYears = membershipYears;
    }

    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }

    public void setOrgWebSiteAddress(String orgWebSiteAddress)
    {
        this.orgWebSiteAddress = orgWebSiteAddress;
    }
}
