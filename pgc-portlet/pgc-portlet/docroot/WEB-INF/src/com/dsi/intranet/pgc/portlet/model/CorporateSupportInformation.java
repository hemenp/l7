/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileReadMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileWriteMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

/**
 * <a href="RequestorInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public class CorporateSupportInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    @DocumentumPropertyMapping(name = "pgc_amount_req")
    private String amountRequested;
    @DocumentumFileWriteMapping(attachmentType = "Completed W9")
    private List<CommonsMultipartFile> completedW9;
    @DocumentumFileReadMapping(attachmentType = "Completed W9")
    private List<DocumentumFile> completedW9ExistingFile;
    @DocumentumPropertyMapping(name = "pgc_dsi_control_event")
    private Boolean contentResponsibility;
    @DocumentumPropertyMapping(name = "pgc_event_dates")
    private String eventDates;
    @DocumentumPropertyMapping(name = "pgc_event_location")
    private String eventLocation;
    @DocumentumPropertyMapping(name = "pgc_event_name")
    private String eventName;
    @DocumentumPropertyMapping(name = "pgc_funds_usage")
    private String eventPurpose;

    @DocumentumPropertyMapping(name = "pgc_start_date")
    private Date eventStartDate;
    @DocumentumPropertyMapping(name = "pgc_is_therapeutic_promote")
    private Boolean isEventDedicatedInTime;
    @DocumentumPropertyMapping(name = "pgc_is_knowledge_promotion")
    private Boolean isEventPurposePresented;
    @DocumentumPropertyMapping(name = "pgc_dsi_sup_event")
    private Boolean isEventSupport;
    @DocumentumFileWriteMapping(attachmentType = "Agreement if provided by professional organization")
    private List<CommonsMultipartFile> profOrgAgreement;

    @DocumentumFileReadMapping(attachmentType = "Agreement if provided by professional organization")
    private List<DocumentumFile> profOrgAgreementExistingFile;

    @DocumentumPropertyMapping(name = "pgc_prof_org_name")
    private String profOrgName;
    @DocumentumFileWriteMapping(attachmentType = "Proposed Agenda for program")
    private List<CommonsMultipartFile> programAgenda;
    @DocumentumFileReadMapping(attachmentType = "Proposed Agenda for program")
    private List<DocumentumFile> programAgendaExistingFile;
    @DocumentumFileWriteMapping(attachmentType = "Detailed, itemized budget for the program")
    private List<CommonsMultipartFile> programBudget;
    @DocumentumFileReadMapping(attachmentType = "Detailed, itemized budget for the program")
    private List<DocumentumFile> programBudgetExistingFile;
    @DocumentumPropertyMapping(name = "pgc_draft_agreement")
    private Boolean proposedAgreement;
    @DocumentumFileWriteMapping(attachmentType = "Request letter")
    private List<CommonsMultipartFile> requestLetter;
    @DocumentumFileReadMapping(attachmentType = "Request letter")
    private List<DocumentumFile> requestLetterExistingFile;
    @DocumentumFileWriteMapping(attachmentType = "Contract")
    private List<CommonsMultipartFile> contract;
    @DocumentumFileReadMapping(attachmentType = "Contract")
    private List<DocumentumFile> contractFile;
    
    private String otherTherapeutic;

    @DocumentumPropertyMapping(name = "pgc_therapeutic_area")
    private List<String> therapeuticArea;
    @DocumentumPropertyMapping(name = "pgc_total_rev")
    private String totalAnnualRevenue;
    
    @DocumentumPropertyMapping(name = "pgc_corp_sub_type")
    private String subType;

    public String getAmountRequested()
    {
        return amountRequested;
    }

    public List<CommonsMultipartFile> getCompletedW9()
    {
        return completedW9;
    }

    public List<DocumentumFile> getCompletedW9ExistingFile()
    {
        return completedW9ExistingFile;
    }

    public List<CommonsMultipartFile> getContract()
    {
        return contract;
    }

    public List<DocumentumFile> getContractFile()
    {
        return contractFile;
    }

    public Boolean getContentResponsibility()
    {
        return contentResponsibility;
    }

    public String getEventDates()
    {
        return eventDates;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public String getEventName()
    {
        return eventName;
    }

    public String getEventPurpose()
    {
        return eventPurpose;
    }

    public Date getEventStartDate()
    {
        return eventStartDate;
    }

    public Boolean getIsEventDedicatedInTime()
    {
        return isEventDedicatedInTime;
    }

    public Boolean getIsEventPurposePresented()
    {
        return isEventPurposePresented;
    }

    public Boolean getIsEventSupport()
    {
        return isEventSupport;
    }

    public List<CommonsMultipartFile> getProfOrgAgreement()
    {
        return profOrgAgreement;
    }

    public List<DocumentumFile> getProfOrgAgreementExistingFile()
    {
        return profOrgAgreementExistingFile;
    }

    public String getProfOrgName()
    {
        return profOrgName;
    }

    public List<CommonsMultipartFile> getProgramAgenda()
    {
        return programAgenda;
    }

    public List<DocumentumFile> getProgramAgendaExistingFile()
    {
        return programAgendaExistingFile;
    }

    public List<CommonsMultipartFile> getProgramBudget()
    {
        return programBudget;
    }

    public List<DocumentumFile> getProgramBudgetExistingFile()
    {
        return programBudgetExistingFile;
    }

    public Boolean getProposedAgreement()
    {
        return proposedAgreement;
    }

    public List<CommonsMultipartFile> getRequestLetter()
    {
        return requestLetter;
    }

    public List<DocumentumFile> getRequestLetterExistingFile()
    {
        return requestLetterExistingFile;
    }

    public List<String> getTherapeuticArea()
    {
        return therapeuticArea;
    }

    public String getTotalAnnualRevenue()
    {
        return totalAnnualRevenue;
    }

    public void setAmountRequested(String amountRequested)
    {
        this.amountRequested = amountRequested;
    }

    public void setCompletedW9(List<CommonsMultipartFile> completedW9)
    {
        this.completedW9 = completedW9;
    }

    public void setCompletedW9ExistingFile(List<DocumentumFile> completedW9ExistingFile)
    {
        this.completedW9ExistingFile = completedW9ExistingFile;
    }

    public void setContract(List<CommonsMultipartFile> contract)
    {
        this.contract = contract;
    }

    public void setcontractFile(List<DocumentumFile> contractFile)
    {
        this.contractFile = contractFile;
    }
    
    public void setContentResponsibility(Boolean contentResponsibility)
    {
        this.contentResponsibility = contentResponsibility;
    }

    public void setEventDates(String eventDates)
    {
        this.eventDates = eventDates;
    }

    public void setEventLocation(String eventLocation)
    {
        this.eventLocation = eventLocation;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public void setEventPurpose(String eventPurpose)
    {
        this.eventPurpose = eventPurpose;
    }

    public void setEventStartDate(Date eventDate)
    {
        this.eventStartDate = eventDate;
    }

    public void setIsEventDedicatedInTime(Boolean isEventDedicatedInTime)
    {
        this.isEventDedicatedInTime = isEventDedicatedInTime;
    }

    public void setIsEventPurposePresented(Boolean isEventPurposePresented)
    {
        this.isEventPurposePresented = isEventPurposePresented;
    }

    public void setIsEventSupport(Boolean isEventSupport)
    {
        this.isEventSupport = isEventSupport;
    }

    public void setProfOrgAgreement(List<CommonsMultipartFile> profOrgAgreement)
    {
        this.profOrgAgreement = profOrgAgreement;
    }

    public void setProfOrgAgreementExistingFile(List<DocumentumFile> profOrgAgreementExistingFile)
    {
        this.profOrgAgreementExistingFile = profOrgAgreementExistingFile;
    }

    public void setProfOrgName(String profOrgName)
    {
        this.profOrgName = profOrgName;
    }

    public void setProgramAgenda(List<CommonsMultipartFile> programAgenda)
    {
        this.programAgenda = programAgenda;
    }

    public void setProgramAgendaExistingFile(List<DocumentumFile> programAgendaExistingFile)
    {
        this.programAgendaExistingFile = programAgendaExistingFile;
    }

    public void setProgramBudget(List<CommonsMultipartFile> programBudget)
    {
        this.programBudget = programBudget;
    }

    public void setProgramBudgetExistingFile(List<DocumentumFile> programBudgetExistingFile)
    {
        this.programBudgetExistingFile = programBudgetExistingFile;
    }

    public void setProposedAgreement(Boolean proposedAgreement)
    {
        this.proposedAgreement = proposedAgreement;
    }

    public void setRequestLetter(List<CommonsMultipartFile> requestLetter)
    {
        this.requestLetter = requestLetter;
    }

    public void setRequestLetterExistingFile(List<DocumentumFile> requestLetterExistingFile)
    {
        this.requestLetterExistingFile = requestLetterExistingFile;
    }

    public void setTherapeuticArea(List<String> therapeuticArea)
    {
        this.therapeuticArea = therapeuticArea;
    }

    public void setTotalAnnualRevenue(String totalAnnualRevenue)
    {
        this.totalAnnualRevenue = totalAnnualRevenue;
    }
    
    public String getOtherTherapeutic()
    {
        return otherTherapeutic;
    }

    public void setOtherTherapeutic(String otherTherapeutic)
    {
        this.otherTherapeutic = otherTherapeutic;
    }

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}
}
