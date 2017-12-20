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
 * <a href="AdvisoryBoardInformation.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name                         |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Kruti Doshi					|	Sep 16 2014		|	Added new properties			
 */
public class AdvisoryBoardInformation implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    @DocumentumFileWriteMapping(attachmentType = "Desired questions to be addressed at Program")
    private List<CommonsMultipartFile> addressedQuestions;
    @DocumentumFileReadMapping(attachmentType = "Desired questions to be addressed at Program")
    private List<DocumentumFile> addressedQuestionsExistingFile;
    @DocumentumPropertyMapping(name = "pgc_adv_board_prog_title")
    private String advisoryBoardTitle;
    @DocumentumFileWriteMapping(attachmentType = "List of attendees (if available)")
    private List<CommonsMultipartFile> attendeesList;
    @DocumentumFileReadMapping(attachmentType = "List of attendees (if available)")
    private List<DocumentumFile> attendeesListExistingFile;
    @DocumentumPropertyMapping(name = "pgc_attendee_part_hr")
    private String attendeesParticipateHrs;
    @DocumentumPropertyMapping(name = "pgc_attendee_prep_hr")
    private String attendeesPreparationHrs;
    @DocumentumPropertyMapping(name = "pgc_attend_post_work_hr")
    private String attendeesPostWorkHrs;
    @DocumentumPropertyMapping(name = "pgc_attend_qual")
    private String attendeesQualification;
    @DocumentumPropertyMapping(name = "pgc_attendee_services")
    private String attendeesServiceDesc;
    @DocumentumPropertyMapping(name = "pgc_attendee_total_hr")
    private String attendeesTotalHrs;
    @DocumentumPropertyMapping(name = "pgc_bus_need_adv")
    private String businessNeedDesc;
    @DocumentumPropertyMapping(name = "pgc_bus_obj_desc")
    private String businessObjDesc;
    @DocumentumPropertyMapping(name = "pgc_is_chairperson")
    private boolean chairPerson;
    @DocumentumPropertyMapping(name = "pgc_num_chairper")
    private String chairPersonCount;
    @DocumentumPropertyMapping(name = "pgc_chairper_part_hr")
    private String chairPersonParticipateHrs;
    @DocumentumPropertyMapping(name = "pgc_chairper_prep_hr")
    private String chairPersonPreparationHrs;
    @DocumentumPropertyMapping(name = "pgc_chairper_post_work_hr")
    private String chairPersonPostWorkHrs;
    @DocumentumPropertyMapping(name = "pgc_chairper_qual")
    private String chairPersonQualification;
    @DocumentumPropertyMapping(name = "pgc_chairper_services")
    private String chairPersonServiceDesc;
    @DocumentumPropertyMapping(name = "pgc_chairper_degrees")
    private String chairPersonTitle;
    @DocumentumPropertyMapping(name = "pgc_chairper_total_hr")
    private String chairPersonTotalHrs;
    @DocumentumPropertyMapping(name = "pgc_cont_spec_name")
    private String contractSpecialistName;
    private String otherContract;
    @DocumentumFileWriteMapping(attachmentType = "Copy of CV (if available)")
    private List<CommonsMultipartFile> cvCopy;
    @DocumentumFileReadMapping(attachmentType = "Copy of CV (if available)")
    private List<DocumentumFile> cvCopyExistingFile;
    @DocumentumFileWriteMapping(attachmentType = "Proposed detailed Agenda for program")
    private List<CommonsMultipartFile> detailAgenda;
    @DocumentumFileReadMapping(attachmentType = "Proposed detailed Agenda for program")
    private List<DocumentumFile> detailAgendaExistingFile;

    @DocumentumPropertyMapping(name = "pgc_info_use_dsi")
    private String dsiDesc;
    @DocumentumPropertyMapping(name = "pgc_dsi_emp_attend")
    private int dsiEmployeeCount;
    @DocumentumPropertyMapping(name = "pgc_dsi_emp_role")
    private String dsiEmployeeRole;
    @DocumentumPropertyMapping(name = "pgc_start_date")
    private Date eventStartDate;

    @DocumentumPropertyMapping(name = "pgc_mds_attendees")
    private String mdsAttendeesCount;
    @DocumentumEmbeddedPropertyMapping(prefixName = "pgc_meeting_")
    private Address meetingLocation;
    @DocumentumPropertyMapping(name = "pgc_meeting_name")
    private String meetingName;
    @DocumentumPropertyMapping(name = "pgc_is_mod")
    private boolean moderator;

    @DocumentumPropertyMapping(name = "pgc_num_moderators")
    private String moderatorCount;
    @DocumentumPropertyMapping(name = "pgc_mod_part_hr")
    private String moderatorParticipateHrs;
    @DocumentumPropertyMapping(name = "pgc_mod_prep_hr")
    private String moderatorPreparationHrs;
    @DocumentumPropertyMapping(name = "pgc_mod_post_work_hr")
    private String moderatorPostWorkHrs;
    @DocumentumPropertyMapping(name = "pgc_mod_qual")
    private String moderatorQualification;

    @DocumentumPropertyMapping(name = "pgc_mod_services")
    private String moderatorServiceDesc;
    @DocumentumPropertyMapping(name = "pgc_mod_degrees")
    private String moderatorTitle;
    @DocumentumPropertyMapping(name = "pgc_mod_total_hr")
    private String moderatorTotalHrs;
    @DocumentumPropertyMapping(name = "pgc_nurses_attendees")
    private String nursesAttendeesCount;
    @DocumentumPropertyMapping(name = "pgc_other_attendees")
    private String otherAttendeesCount;

    @DocumentumPropertyMapping(name = "pgc_other_attend_name")
    private String otherAttendeesName;
    @DocumentumPropertyMapping(name = "pgc_pa_attendees")
    private String paAttendeesCount;
    @DocumentumPropertyMapping(name = "pgc_pharma_attendees")
    private String pharmaAttendeesCount;
    @DocumentumFileWriteMapping(attachmentType = "Program budget")
    private List<CommonsMultipartFile> programBudget;
    @DocumentumFileReadMapping(attachmentType = "Program budget")
    private List<DocumentumFile> programBudgetExistingFile;
    @DocumentumPropertyMapping(name = "pgc_prog_dates")
    private String programDate;
    @DocumentumPropertyMapping(name = "pgc_program_format")
    private List<String> programFormat;
    @DocumentumPropertyMapping(name = "pgc_prog_format_comb")
    private String programFormatSpecification;
    @DocumentumPropertyMapping(name = "pgc_meet_plan_rep_name")
    private String representativeName;
    @DocumentumPropertyMapping(name = "pgc_meet_plan_rep_phone")
    private String representativePhone;

    @DocumentumPropertyMapping(name = "pgc_total_attendees")
    private String totalAttendees;

    @DocumentumFileWriteMapping(attachmentType = "Pre-work materials (if applicable)")
    private List<CommonsMultipartFile> preworkMaterialsList;
    @DocumentumFileReadMapping(attachmentType = "Pre-work materials (if applicable)")
    private List<DocumentumFile> preworkMaterialsListExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "Post work materials (if applicable)")
    private List<CommonsMultipartFile> postworkMaterialsList;
    @DocumentumFileReadMapping(attachmentType = "Post work materials (if applicable)")
    private List<DocumentumFile> postworkMaterialsListExistingFile;
    
    @DocumentumPropertyMapping(name = "pgc_is_sub_include_aep")
    private Boolean isSubmIncludeAEP = false;
    @DocumentumPropertyMapping(name = "pgc_aep_explain")
    private String aepExplaination;
    
    public AdvisoryBoardInformation()
    {
        meetingLocation = new Address();
    }

    public List<CommonsMultipartFile> getAddressedQuestions()
    {
        return addressedQuestions;
    }

    public List<DocumentumFile> getAddressedQuestionsExistingFile()
    {
        return addressedQuestionsExistingFile;
    }

    public String getAdvisoryBoardTitle()
    {
        return advisoryBoardTitle;
    }

    public List<CommonsMultipartFile> getAttendeesList()
    {
        return attendeesList;
    }

    public List<DocumentumFile> getAttendeesListExistingFile()
    {
        return attendeesListExistingFile;
    }

    public String getAttendeesParticipateHrs()
    {
        return attendeesParticipateHrs;
    }

    public String getAttendeesPreparationHrs()
    {
        return attendeesPreparationHrs;
    }

    public String getAttendeesQualification()
    {
        return attendeesQualification;
    }

    public String getAttendeesServiceDesc()
    {
        return attendeesServiceDesc;
    }

    public String getAttendeesTotalHrs()
    {
        return attendeesTotalHrs;
    }

    public String getBusinessNeedDesc()
    {
        return businessNeedDesc;
    }

    public String getBusinessObjDesc()
    {
        return businessObjDesc;
    }

    public String getChairPersonCount()
    {
        return chairPersonCount;
    }

    public String getChairPersonParticipateHrs()
    {
        return chairPersonParticipateHrs;
    }

    public String getChairPersonPreparationHrs()
    {
        return chairPersonPreparationHrs;
    }

    public String getChairPersonQualification()
    {
        return chairPersonQualification;
    }

    public String getChairPersonServiceDesc()
    {
        return chairPersonServiceDesc;
    }

    public String getChairPersonTitle()
    {
        return chairPersonTitle;
    }

    public String getChairPersonTotalHrs()
    {
        return chairPersonTotalHrs;
    }

    public String getContractSpecialistName()
    {
        return contractSpecialistName;
    }

    public String getOtherContract()
    {
        return otherContract;
    }

    public List<CommonsMultipartFile> getCvCopy()
    {
        return cvCopy;
    }

    public List<DocumentumFile> getCvCopyExistingFile()
    {
        return cvCopyExistingFile;
    }

    public List<CommonsMultipartFile> getDetailAgenda()
    {
        return detailAgenda;
    }

    public List<DocumentumFile> getDetailAgendaExistingFile()
    {
        return detailAgendaExistingFile;
    }

    public String getDsiDesc()
    {
        return dsiDesc;
    }

    public int getDsiEmployeeCount()
    {
        return dsiEmployeeCount;
    }

    public String getDsiEmployeeRole()
    {
        return dsiEmployeeRole;
    }

    public Date getEventStartDate()
    {
        return eventStartDate;
    }

    public String getMdsAttendeesCount()
    {
        return mdsAttendeesCount;
    }

    public Address getMeetingLocation()
    {
        return meetingLocation;
    }

    public String getMeetingName()
    {
        return meetingName;
    }

    public String getModeratorCount()
    {
        return moderatorCount;
    }

    public String getModeratorParticipateHrs()
    {
        return moderatorParticipateHrs;
    }

    public String getModeratorPreparationHrs()
    {
        return moderatorPreparationHrs;
    }

    public String getModeratorQualification()
    {
        return moderatorQualification;
    }

    public String getModeratorServiceDesc()
    {
        return moderatorServiceDesc;
    }

    public String getModeratorTitle()
    {
        return moderatorTitle;
    }

    public String getModeratorTotalHrs()
    {
        return moderatorTotalHrs;
    }

    public String getNursesAttendeesCount()
    {
        return nursesAttendeesCount;
    }

    public String getOtherAttendeesCount()
    {
        return otherAttendeesCount;
    }

    public String getOtherAttendeesName()
    {
        return otherAttendeesName;
    }

    public String getPaAttendeesCount()
    {
        return paAttendeesCount;
    }

    public String getPharmaAttendeesCount()
    {
        return pharmaAttendeesCount;
    }

    public List<CommonsMultipartFile> getProgramBudget()
    {
        return programBudget;
    }

    public List<DocumentumFile> getProgramBudgetExistingFile()
    {
        return programBudgetExistingFile;
    }

    public String getProgramDate()
    {
        return programDate;
    }

    public List<String> getProgramFormat()
    {
        return programFormat;
    }

    public String getProgramFormatSpecification()
    {
        return programFormatSpecification;
    }

    public String getRepresentativeName()
    {
        return representativeName;
    }

    public String getRepresentativePhone()
    {
        return representativePhone;
    }

    public String getTotalAttendees()
    {
        return totalAttendees;
    }

    public boolean isChairPerson()
    {
        return chairPerson;
    }

    public boolean isModerator()
    {
        return moderator;
    }

    public void setAddressedQuestions(List<CommonsMultipartFile> addressedQuestions)
    {
        this.addressedQuestions = addressedQuestions;
    }

    public void setAddressedQuestionsExistingFile(List<DocumentumFile> addressedQuestionsExistingFile)
    {
        this.addressedQuestionsExistingFile = addressedQuestionsExistingFile;
    }

    public void setAdvisoryBoardTitle(String advisoryBoardTitle)
    {
        this.advisoryBoardTitle = advisoryBoardTitle;
    }

    public void setAttendeesList(List<CommonsMultipartFile> attendeesList)
    {
        this.attendeesList = attendeesList;
    }

    public void setAttendeesListExistingFile(List<DocumentumFile> attendeesListExistingFile)
    {
        this.attendeesListExistingFile = attendeesListExistingFile;
    }

    public void setAttendeesParticipateHrs(String attendeesParticipateHrs)
    {
        this.attendeesParticipateHrs = attendeesParticipateHrs;
    }

    public void setAttendeesPreparationHrs(String attendeesPreparationHrs)
    {
        this.attendeesPreparationHrs = attendeesPreparationHrs;
    }

    public void setAttendeesQualification(String attendeesQualification)
    {
        this.attendeesQualification = attendeesQualification;
    }

    public void setAttendeesServiceDesc(String attendeesServiceDesc)
    {
        this.attendeesServiceDesc = attendeesServiceDesc;
    }

    public void setAttendeesTotalHrs(String attendeesTotalHrs)
    {
        this.attendeesTotalHrs = attendeesTotalHrs;
    }

    public void setBusinessNeedDesc(String businessNeedDesc)
    {
        this.businessNeedDesc = businessNeedDesc;
    }

    public void setBusinessObjDesc(String businessObjDesc)
    {
        this.businessObjDesc = businessObjDesc;
    }

    public void setChairPerson(boolean chairPerson)
    {
        this.chairPerson = chairPerson;
    }

    public void setChairPersonCount(String chairPersonCount)
    {
        this.chairPersonCount = chairPersonCount;
    }

    public void setChairPersonParticipateHrs(String chairPersonParticipateHrs)
    {
        this.chairPersonParticipateHrs = chairPersonParticipateHrs;
    }

    public void setChairPersonPreparationHrs(String chairPersonPreparationHrs)
    {
        this.chairPersonPreparationHrs = chairPersonPreparationHrs;
    }

    public void setChairPersonQualification(String chairPersonQualification)
    {
        this.chairPersonQualification = chairPersonQualification;
    }

    public void setChairPersonServiceDesc(String chairPersonServiceDesc)
    {
        this.chairPersonServiceDesc = chairPersonServiceDesc;
    }

    public void setChairPersonTitle(String chairPersonTitle)
    {
        this.chairPersonTitle = chairPersonTitle;
    }

    public void setChairPersonTotalHrs(String chairPersonTotalHrs)
    {
        this.chairPersonTotalHrs = chairPersonTotalHrs;
    }

    public void setContractSpecialistName(String contractSpecialistName)
    {
        this.contractSpecialistName = contractSpecialistName;
    }

    public void setOtherContract(String otherContract)
    {
        this.otherContract = otherContract;
    }

    public void setCvCopy(List<CommonsMultipartFile> cvCopy)
    {
        this.cvCopy = cvCopy;
    }

    public void setCvCopyExistingFile(List<DocumentumFile> cvCopyExistingFile)
    {
        this.cvCopyExistingFile = cvCopyExistingFile;
    }

    public void setDetailAgenda(List<CommonsMultipartFile> detailAgenda)
    {
        this.detailAgenda = detailAgenda;
    }

    public void setDetailAgendaExistingFile(List<DocumentumFile> detailAgendaExistingFile)
    {
        this.detailAgendaExistingFile = detailAgendaExistingFile;
    }

    public void setDsiDesc(String dsiDesc)
    {
        this.dsiDesc = dsiDesc;
    }

    public void setDsiEmployeeCount(int dsiEmployeeCount)
    {
        this.dsiEmployeeCount = dsiEmployeeCount;
    }

    public void setDsiEmployeeRole(String dsiEmployeeRole)
    {
        this.dsiEmployeeRole = dsiEmployeeRole;
    }

    public void setEventStartDate(Date eventDate)
    {
        this.eventStartDate = eventDate;
    }

    public void setMdsAttendeesCount(String mdsAttendeesCount)
    {
        this.mdsAttendeesCount = mdsAttendeesCount;
    }

    public void setMeetingLocation(Address meetingLocation)
    {
        this.meetingLocation = meetingLocation;
    }

    public void setMeetingName(String meetingName)
    {
        this.meetingName = meetingName;
    }

    public void setModerator(boolean moderator)
    {
        this.moderator = moderator;
    }

    public void setModeratorCount(String moderatorCount)
    {
        this.moderatorCount = moderatorCount;
    }

    public void setModeratorParticipateHrs(String moderatorParticipateHrs)
    {
        this.moderatorParticipateHrs = moderatorParticipateHrs;
    }

    public void setModeratorPreparationHrs(String moderatorPreparationHrs)
    {
        this.moderatorPreparationHrs = moderatorPreparationHrs;
    }

    public void setModeratorQualification(String moderatorQualification)
    {
        this.moderatorQualification = moderatorQualification;
    }

    public void setModeratorServiceDesc(String moderatorServiceDesc)
    {
        this.moderatorServiceDesc = moderatorServiceDesc;
    }

    public void setModeratorTitle(String moderatorTitle)
    {
        this.moderatorTitle = moderatorTitle;
    }

    public void setModeratorTotalHrs(String moderatorTotalHrs)
    {
        this.moderatorTotalHrs = moderatorTotalHrs;
    }

    public void setNursesAttendeesCount(String nursesAttendeesCount)
    {
        this.nursesAttendeesCount = nursesAttendeesCount;
    }

    public void setOtherAttendeesCount(String otherAttendeesCount)
    {
        this.otherAttendeesCount = otherAttendeesCount;
    }

    public void setOtherAttendeesName(String otherAttendeesName)
    {
        this.otherAttendeesName = otherAttendeesName;
    }

    public void setPaAttendeesCount(String paAttendeesCount)
    {
        this.paAttendeesCount = paAttendeesCount;
    }

    public void setPharmaAttendeesCount(String pharmaAttendeesCount)
    {
        this.pharmaAttendeesCount = pharmaAttendeesCount;
    }

    public void setProgramBudget(List<CommonsMultipartFile> programBudget)
    {
        this.programBudget = programBudget;
    }

    public void setProgramBudgetExistingFile(List<DocumentumFile> programBudgetExistingFile)
    {
        this.programBudgetExistingFile = programBudgetExistingFile;
    }

    public void setProgramDate(String programDate)
    {
        this.programDate = programDate;
    }

    public void setProgramFormat(List<String> programFormat)
    {
        this.programFormat = programFormat;
    }

    public void setProgramFormatSpecification(String programFormatSpecification)
    {
        this.programFormatSpecification = programFormatSpecification;
    }

    public void setRepresentativeName(String representativeName)
    {
        this.representativeName = representativeName;
    }

    public void setRepresentativePhone(String representativePhone)
    {
        this.representativePhone = representativePhone;
    }

    public void setTotalAttendees(String totalAttendees)
    {
        this.totalAttendees = totalAttendees;
    }

	public String getAttendeesPostWorkHrs() {
		return attendeesPostWorkHrs;
	}

	public void setAttendeesPostWorkHrs(String attendeesPostWorkHrs) {
		this.attendeesPostWorkHrs = attendeesPostWorkHrs;
	}

	public String getChairPersonPostWorkHrs() {
		return chairPersonPostWorkHrs;
	}

	public void setChairPersonPostWorkHrs(String chairPersonPostWorkHrs) {
		this.chairPersonPostWorkHrs = chairPersonPostWorkHrs;
	}

	public String getModeratorPostWorkHrs() {
		return moderatorPostWorkHrs;
	}

	public void setModeratorPostWorkHrs(String moderatorPostWorkHrs) {
		this.moderatorPostWorkHrs = moderatorPostWorkHrs;
	}

	public List<CommonsMultipartFile> getPreworkMaterialsList() {
		return preworkMaterialsList;
	}

	public void setPreworkMaterialsList(
			List<CommonsMultipartFile> preworkMaterialsList) {
		this.preworkMaterialsList = preworkMaterialsList;
	}

	public List<DocumentumFile> getPreworkMaterialsListExistingFile() {
		return preworkMaterialsListExistingFile;
	}

	public void setPreworkMaterialsListExistingFile(
			List<DocumentumFile> preworkMaterialsListExistingFile) {
		this.preworkMaterialsListExistingFile = preworkMaterialsListExistingFile;
	}

	public List<CommonsMultipartFile> getPostworkMaterialsList() {
		return postworkMaterialsList;
	}

	public void setPostworkMaterialsList(
			List<CommonsMultipartFile> postworkMaterialsList) {
		this.postworkMaterialsList = postworkMaterialsList;
	}

	public List<DocumentumFile> getPostworkMaterialsListExistingFile() {
		return postworkMaterialsListExistingFile;
	}

	public void setPostworkMaterialsListExistingFile(
			List<DocumentumFile> postworkMaterialsListExistingFile) {
		this.postworkMaterialsListExistingFile = postworkMaterialsListExistingFile;
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