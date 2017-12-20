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
 * <a href="DisplayExhibitInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Kruti Doshi					|	Sep 16 2014		|	Added new properties for Therapeutic Area		
 * 
 */
public class DisplayExhibitInformation implements Serializable
{

    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    @DocumentumPropertyMapping(name = "pgc_disp_exh_desc")
    private String displayDesc;

    @DocumentumFileWriteMapping(attachmentType = "Agenda")
    private List<CommonsMultipartFile> eventAgenda;
    @DocumentumFileReadMapping(attachmentType = "Agenda")
    private List<DocumentumFile> eventAgendaExistingFile;

    @DocumentumFileWriteMapping(attachmentType = "Request letter or brochure from entity")
    private List<CommonsMultipartFile> eventBrochure;

    @DocumentumFileReadMapping(attachmentType = "Request letter or brochure from entity")
    private List<DocumentumFile> eventBrochureExistingFile;

    @DocumentumPropertyMapping(name = "pgc_event_dates")
    private String eventDates;

    @DocumentumPropertyMapping(name = "pgc_event_desc")
    private String eventDesc;

    @DocumentumPropertyMapping(name = "pgc_disp_setup_desc")
    private String eventDispDesc;

    @DocumentumPropertyMapping(name = "pgc_disp_exh_time_hr", mapToType = "numberProperty")
    private int eventDispHrs;

    @DocumentumPropertyMapping(name = "pgc_product")
    private List<String> eventDispMaterials;

    @DocumentumPropertyMapping(name = "pgc_disp_exh_time_min", mapToType = "numberProperty")
    private int eventDispMins;

    @DocumentumPropertyMapping(name = "pgc_disp_exh_cost")
    private String eventFee;

    @DocumentumPropertyMapping(name = "pgc_event_location")
    private String eventLocation;

    @DocumentumPropertyMapping(name = "pgc_event_name")
    private String eventName;

    private String eventOrgAgmt;

    @DocumentumPropertyMapping(name = "pgc_disp_exh_agreement")
    private Boolean eventOrgAgmtDone;

    @DocumentumFileReadMapping(attachmentType = "Draft or proposed agreement from event organizer")
    private List<DocumentumFile> eventOrgAgmtExistingFile;

    @DocumentumFileWriteMapping(attachmentType = "Draft or proposed agreement from event organizer")
    private List<CommonsMultipartFile> eventOrgAgmtFile;

    @DocumentumPropertyMapping(name = "pgc_event_organizer")
    private String eventOrganizer;

    @DocumentumPropertyMapping(name = "pgc_ques_reviewed")
    private Boolean eventSatisfyCondition;

    @DocumentumPropertyMapping(name = "pgc_start_date")
    private Date eventStartDate;

    @DocumentumPropertyMapping(name = "pgc_event_type")
    private String eventType;

    @DocumentumFileWriteMapping(attachmentType = "W9")
    private List<CommonsMultipartFile> eventW9;

    @DocumentumFileReadMapping(attachmentType = "W9")
    private List<DocumentumFile> eventW9ExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "contract")
    private List<CommonsMultipartFile> contract;

    @DocumentumFileReadMapping(attachmentType = "contract")
    private List<DocumentumFile> contractFile;

    private String otherMaterial;
    
    @DocumentumPropertyMapping(name = "pgc_therapeutic_area")
    private List<String> therapeuticArea;
    
    private String otherTherapeutic;

    public String getDisplayDesc()
    {
        return displayDesc;
    }

    public List<CommonsMultipartFile> getEventAgenda()
    {
        return eventAgenda;
    }

    public List<DocumentumFile> getEventAgendaExistingFile()
    {
        return eventAgendaExistingFile;
    }

    public List<CommonsMultipartFile> getEventBrochure()
    {
        return eventBrochure;
    }

    public List<DocumentumFile> getEventBrochureExistingFile()
    {
        return eventBrochureExistingFile;
    }

    public String getEventDates()
    {
        return eventDates;
    }

    public String getEventDesc()
    {
        return eventDesc;
    }

    public String getEventDispDesc()
    {
        return eventDispDesc;
    }

    public int getEventDispHrs()
    {
        return eventDispHrs;
    }

    public List<String> getEventDispMaterials()
    {
        return eventDispMaterials;
    }

    public int getEventDispMins()
    {
        return eventDispMins;
    }

    public String getEventFee()
    {
        return eventFee;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public String getEventName()
    {
        return eventName;
    }

    public String getEventOrgAgmt()
    {
        return eventOrgAgmt;
    }

    public List<DocumentumFile> getEventOrgAgmtExistingFile()
    {
        return eventOrgAgmtExistingFile;
    }

    public List<CommonsMultipartFile> getEventOrgAgmtFile()
    {
        return eventOrgAgmtFile;
    }

    public String getEventOrganizer()
    {
        return eventOrganizer;
    }

    public Date getEventStartDate()
    {
        return eventStartDate;
    }

    public String getEventType()
    {
        return eventType;
    }

    public List<CommonsMultipartFile> getEventW9()
    {
        return eventW9;
    }

    public List<DocumentumFile> getEventW9ExistingFile()
    {
        return eventW9ExistingFile;
    }
    public List<CommonsMultipartFile> getContract()
    {
        return contract;
    }
    public List<DocumentumFile> getContractFile()
    {
        return contractFile;
    }

    public String getOtherMaterial()
    {
        return otherMaterial;
    }

    public Boolean getEventOrgAgmtDone()
    {
        return eventOrgAgmtDone;
    }

    public Boolean getEventSatisfyCondition()
    {
        return eventSatisfyCondition;
    }

    public void setDisplayDesc(String displayDesc)
    {
        this.displayDesc = displayDesc;
    }

    public void setEventAgenda(List<CommonsMultipartFile> eventAgenda)
    {
        this.eventAgenda = eventAgenda;
    }

    public void setEventAgendaExistingFile(List<DocumentumFile> eventAgendaExistingFile)
    {
        this.eventAgendaExistingFile = eventAgendaExistingFile;
    }

    public void setEventBrochure(List<CommonsMultipartFile> eventBrochure)
    {
        this.eventBrochure = eventBrochure;
    }

    public void setEventBrochureExistingFile(List<DocumentumFile> eventBrochureExistingFile)
    {
        this.eventBrochureExistingFile = eventBrochureExistingFile;
    }

    public void setEventDates(String eventDates)
    {
        this.eventDates = eventDates;
    }

    public void setEventDesc(String eventDesc)
    {
        this.eventDesc = eventDesc;
    }

    public void setEventDispDesc(String eventDispDesc)
    {
        this.eventDispDesc = eventDispDesc;
    }

    public void setEventDispHrs(int eventDispHrs)
    {
        this.eventDispHrs = eventDispHrs;
    }

    public void setEventDispMaterials(List<String> eventDispMaterials)
    {
        this.eventDispMaterials = eventDispMaterials;
    }

    public void setEventDispMins(int eventDispMins)
    {
        this.eventDispMins = eventDispMins;
    }

    public void setEventFee(String eventFee)
    {
        this.eventFee = eventFee;
    }

    public void setEventLocation(String eventLocation)
    {
        this.eventLocation = eventLocation;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public void setEventOrgAgmt(String eventOrgAgmt)
    {
        this.eventOrgAgmt = eventOrgAgmt;
    }

    public void setEventOrgAgmtDone(Boolean eventOrgAgmtDone)
    {
        this.eventOrgAgmtDone = eventOrgAgmtDone;
    }

    public void setEventOrgAgmtExistingFile(List<DocumentumFile> eventOrgAgmtExistingFile)
    {
        this.eventOrgAgmtExistingFile = eventOrgAgmtExistingFile;
    }

    public void setEventOrgAgmtFile(List<CommonsMultipartFile> eventOrgAgmtFile)
    {
        this.eventOrgAgmtFile = eventOrgAgmtFile;
    }

    public void setEventOrganizer(String eventOrganizer)
    {
        this.eventOrganizer = eventOrganizer;
    }

    public void setEventSatisfyCondition(Boolean eventSatisfyCondition)
    {
        this.eventSatisfyCondition = eventSatisfyCondition;
    }

    public void setEventStartDate(Date eventDate)
    {
        this.eventStartDate = eventDate;
    }

    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }

    public void setEventW9(List<CommonsMultipartFile> eventW9)
    {
        this.eventW9 = eventW9;
    }

    public void setEventW9ExistingFile(List<DocumentumFile> eventW9ExistingFile)
    {
        this.eventW9ExistingFile = eventW9ExistingFile;
    }
    public void setContract(List<CommonsMultipartFile> contract)
    {
        this.contract = contract;
    }

    public void setContractFile(List<DocumentumFile> contractFile)
    {
        this.contractFile = contractFile;
    }
    public void setOtherMaterial(String otherMaterial)
    {
        this.otherMaterial = otherMaterial;
    }

	public List<String> getTherapeuticArea() {
		return therapeuticArea;
	}

	public void setTherapeuticArea(List<String> therapeuticArea) {
		this.therapeuticArea = therapeuticArea;
	}

	public String getOtherTherapeutic() {
		return otherTherapeutic;
	}

	public void setOtherTherapeutic(String otherTherapeutic) {
		this.otherTherapeutic = otherTherapeutic;
	}

}
