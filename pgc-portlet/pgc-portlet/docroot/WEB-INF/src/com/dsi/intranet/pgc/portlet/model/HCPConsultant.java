/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumEmbeddedPropertyMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileReadMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileWriteMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;
import com.dsi.intranet.pgc.portlet.model.basic.Address;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <a href="HCPConsultant.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class HCPConsultant implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    @DocumentumFileWriteMapping(attachmentType = "Itemized budget for the Consultant relationship")
    private List<CommonsMultipartFile> budget;
    @DocumentumFileReadMapping(attachmentType = "Itemized budget for the Consultant relationship")
    private List<DocumentumFile> budgetExistingFile;
    @DocumentumPropertyMapping(name = "pgc_bus_need_more_consul")
    private String businessNeed;
    @DocumentumPropertyMapping(name = "pgc_bus_need_consul")
    private String businessNeedDesc;
    @DocumentumPropertyMapping(name = "pgc_services_usage")
    private String companyAgreement;
    @DocumentumFileWriteMapping(attachmentType = "Copy of CV (if available) Note: A CV is required for FMV and Contracting")
    private List<CommonsMultipartFile> cvCopy;
    @DocumentumFileReadMapping(attachmentType = "Copy of CV (if available) Note: A CV is required for FMV and Contracting")
    private List<DocumentumFile> cvCopyExistingFile;
    @DocumentumPropertyMapping(name = "pgc_start_date")
    private Date eventStartDate;
    @DocumentumPropertyMapping(name = "pgc_end_date")
    private Date eventEndDate;
    public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	@DocumentumPropertyMapping(name = "pgc_hcp_qualification")
    private String hcpsQualification;
    @DocumentumFileWriteMapping(attachmentType = "Attach all materials (invitations, slide decks, etc.) that will be used in connection with the relationship / program")
    private List<CommonsMultipartFile> materials;
    @DocumentumFileReadMapping(attachmentType = "Attach all materials (invitations, slide decks, etc.) that will be used in connection with the relationship / program")
    private List<DocumentumFile> materialsExistingFile;
    @DocumentumEmbeddedPropertyMapping(prefixName = "pgc_meeting_")
    private Address meetingLocation;
    @DocumentumPropertyMapping(name = "pgc_meeting_name")
    private String meetingName;
    @DocumentumPropertyMapping(name = "pgc_prog_format_comb")
    private String programCombination;
    @DocumentumPropertyMapping(name = "pgc_program_format")
    private List<String> programFormat;
    @DocumentumPropertyMapping(name = "pgc_consul_qual")
    private String qualificationDesc;
    @DocumentumPropertyMapping(name = "pgc_dates_of_service")
    private String serviceDates;
    @DocumentumPropertyMapping(name = "pgc_consul_info")
    private String serviceDetail;
    @DocumentumPropertyMapping(name = "pgc_serv_per_of_time")
    private Boolean servicePeriod;
    @DocumentumFileWriteMapping(attachmentType = "Completed W9")
    private List<CommonsMultipartFile> w9Completed;
    @DocumentumFileReadMapping(attachmentType = "Completed W9")
    private List<DocumentumFile> w9CompletedExistingFile;
    @DocumentumPropertyMapping(name = "pgc_consul_total_hours")
    private String totalBrkdownHrs;
    @DocumentumPropertyMapping(name = "pgc_is_sub_include_aep")
    private Boolean isSubmIncludeAEP = false;
    @DocumentumPropertyMapping(name = "pgc_aep_explain")
    private String aepExplaination;
    
    public HCPConsultant()
    {
        meetingLocation = new Address();
    }

    public List<CommonsMultipartFile> getBudget()
    {
        return budget;
    }

    public List<DocumentumFile> getBudgetExistingFile()
    {
        return budgetExistingFile;
    }

    public String getBusinessNeed()
    {
        return businessNeed;
    }

    public String getBusinessNeedDesc()
    {
        return businessNeedDesc;
    }

    public String getCompanyAgreement()
    {
        return companyAgreement;
    }

    public List<CommonsMultipartFile> getCvCopy()
    {
        return cvCopy;
    }

    public List<DocumentumFile> getCvCopyExistingFile()
    {
        return cvCopyExistingFile;
    }

    public Date getEventStartDate()
    {
        return eventStartDate;
    }

    public String getHcpsQualification()
    {
        return hcpsQualification;
    }

    public List<CommonsMultipartFile> getMaterials()
    {
        return materials;
    }

    public List<DocumentumFile> getMaterialsExistingFile()
    {
        return materialsExistingFile;
    }

    public Address getMeetingLocation()
    {
        return meetingLocation;
    }

    public String getMeetingName()
    {
        return meetingName;
    }

    public String getProgramCombination()
    {
        return programCombination;
    }

    public List<String> getProgramFormat()
    {
        return programFormat;
    }

    public String getQualificationDesc()
    {
        return qualificationDesc;
    }

    public String getServiceDates()
    {
        return serviceDates;
    }

    public String getServiceDetail()
    {
        return serviceDetail;
    }

    public List<CommonsMultipartFile> getW9Completed()
    {
        return w9Completed;
    }

    public List<DocumentumFile> getW9CompletedExistingFile()
    {
        return w9CompletedExistingFile;
    }

    public Boolean getServicePeriod()
    {
        return servicePeriod;
    }

    public void setBudget(List<CommonsMultipartFile> budget)
    {
        this.budget = budget;
    }

    public void setBudgetExistingFile(List<DocumentumFile> budgetExistingFile)
    {
        this.budgetExistingFile = budgetExistingFile;
    }

    public void setBusinessNeed(String businessNeed)
    {
        this.businessNeed = businessNeed;
    }

    public void setBusinessNeedDesc(String businessNeedDesc)
    {
        this.businessNeedDesc = businessNeedDesc;
    }

    public void setCompanyAgreement(String companyAgreement)
    {
        this.companyAgreement = companyAgreement;
    }

    public void setCvCopy(List<CommonsMultipartFile> cvCopy)
    {
        this.cvCopy = cvCopy;
    }

    public void setCvCopyExistingFile(List<DocumentumFile> cvCopyExistingFile)
    {
        this.cvCopyExistingFile = cvCopyExistingFile;
    }

    public void setEventStartDate(Date eventDate)
    {
        this.eventStartDate = eventDate;
    }

    public void setHcpsQualification(String hcpsQualification)
    {
        this.hcpsQualification = hcpsQualification;
    }

    public void setMaterials(List<CommonsMultipartFile> materials)
    {
        this.materials = materials;
    }

    public void setMaterialsExistingFile(List<DocumentumFile> materialsExistingFile)
    {
        this.materialsExistingFile = materialsExistingFile;
    }

    public void setMeetingLocation(Address meetingLocation)
    {
        this.meetingLocation = meetingLocation;
    }

    public void setMeetingName(String meetingName)
    {
        this.meetingName = meetingName;
    }

    public void setProgramCombination(String programCombination)
    {
        this.programCombination = programCombination;
    }

    public void setProgramFormat(List<String> programFormat)
    {
        this.programFormat = programFormat;
    }

    public void setQualificationDesc(String qualificationDesc)
    {
        this.qualificationDesc = qualificationDesc;
    }

    public void setServiceDates(String serviceDates)
    {
        this.serviceDates = serviceDates;
    }

    public void setServiceDetail(String serviceDetail)
    {
        this.serviceDetail = serviceDetail;
    }

    public void setServicePeriod(Boolean servicePeriod)
    {
        this.servicePeriod = servicePeriod;
    }

    public void setW9Completed(List<CommonsMultipartFile> w9Completed)
    {
        this.w9Completed = w9Completed;
    }

    public void setW9CompletedExistingFile(List<DocumentumFile> w9CompletedExistingFile)
    {
        this.w9CompletedExistingFile = w9CompletedExistingFile;
    }

	public String getTotalBrkdownHrs() {
		return totalBrkdownHrs;
	}

	public void setTotalBrkdownHrs(String totalBrkdownHrs) {
		this.totalBrkdownHrs = totalBrkdownHrs;
	}

	public Boolean getIsSubmIncludeAEP() {
		return isSubmIncludeAEP;
	}

	public void setIsSubmIncludeAEP(Boolean isSubmIncludeAEP) {
		this.isSubmIncludeAEP = isSubmIncludeAEP;
	}

	public String getAepExplaination() {
		return aepExplaination;
	}

	public void setAepExplaination(String aepExplaination) {
		this.aepExplaination = aepExplaination;
	}
    
}