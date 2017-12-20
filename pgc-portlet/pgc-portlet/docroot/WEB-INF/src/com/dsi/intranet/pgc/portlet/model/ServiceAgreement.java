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
*
* @project PGC
* @author Vijayan Chendrayan
* @Description
* @ChangeLog:
* Name                         |       Date                    |       Reason
* ---------------------------------------------------------------------------------
*/
public class ServiceAgreement implements Serializable
{
    /** Default Serial Version UID */
    private static final long serialVersionUID = 1L;

    @DocumentumPropertyMapping(name = "pgc_serv_usage_desc")
    private String agreementDesc;
    @DocumentumFileWriteMapping(attachmentType = "Copy of applicable agreement / contract")
    private List<CommonsMultipartFile> applicableAgreement;
    @DocumentumFileReadMapping(attachmentType = "Copy of applicable agreement / contract")
    private List<DocumentumFile> applicableAgreementExistingFile;
    @DocumentumPropertyMapping(name = "pgc_bus_need_desc")
    private String businessNeed;
    @DocumentumFileWriteMapping(attachmentType = "Completed W9")
    private List<CommonsMultipartFile> completedW9;
    @DocumentumFileReadMapping(attachmentType = "Completed W9")
    private List<DocumentumFile> completedW9ExistingFile;
    @DocumentumPropertyMapping(name = "pgc_cust_success_desc")
    private String customerDemonstrateDesc;
    @DocumentumPropertyMapping(name = "pgc_cust_qual")
    private String customerQualifications;
    @DocumentumPropertyMapping(name = "pgc_cust_compensation")
    private String customerServicesDesc;
    @DocumentumPropertyMapping(name = "pgc_is_comparable_serv")
    private Boolean isComparableService;
    @DocumentumPropertyMapping(name = "pgc_is_cust_success")
    private Boolean isCustomerDemonstrate;
    @DocumentumPropertyMapping(name = "pgc_is_fees_market_value")
    private Boolean isFairMarketValue;
    @DocumentumPropertyMapping(name = "pgc_is_cust_pat_adv_org")
    private Boolean isPatientAdvocacyOrg;
    @DocumentumPropertyMapping(name = "pgc_is_cust_prof_med_soc")
    private Boolean isProfMedicalSociety;
    @DocumentumPropertyMapping(name = "pgc_is_prod_promotion")
    private Boolean isRelatedToProduct;
    @DocumentumPropertyMapping(name = "pgc_serv_per_of_time")
    private Boolean isServiceTime;
    @DocumentumPropertyMapping(name = "pgc_dates_of_service")
    private String serviceDate;
    @DocumentumPropertyMapping(name = "pgc_is_cust_unique_exp")
    private Boolean isUniqueExperience;
    @DocumentumFileWriteMapping(attachmentType = "Itemized budget")
    private List<CommonsMultipartFile> itemizedBudget;
    @DocumentumFileReadMapping(attachmentType = "Itemized budget")
    private List<DocumentumFile> itemizedBudgetExistingFile;
    @DocumentumFileWriteMapping(attachmentType = "Proposal")
    private List<CommonsMultipartFile> proposal;
    @DocumentumFileReadMapping(attachmentType = "Proposal")
    private List<DocumentumFile> proposalExistingFile;
    @DocumentumPropertyMapping(name = "pgc_rev_med_society")
    private String revOfMedicalSociety;
    @DocumentumPropertyMapping(name = "pgc_rev_pat_adv_org")
    private String revOfPatientAdvocacyOrg;
    @DocumentumPropertyMapping(name = "pgc_serv_cust_desc")
    private String serviceProvided;
    private String specialistName;
    @DocumentumPropertyMapping(name = "pgc_cust_unique_exp")
    private String uniqueExperienceDesc;

    public String getAgreementDesc()
    {
        return agreementDesc;
    }

    public List<CommonsMultipartFile> getApplicableAgreement()
    {
        return applicableAgreement;
    }

    public List<DocumentumFile> getApplicableAgreementExistingFile()
    {
        return applicableAgreementExistingFile;
    }

    public String getBusinessNeed()
    {
        return businessNeed;
    }

    public List<CommonsMultipartFile> getCompletedW9()
    {
        return completedW9;
    }

    public List<DocumentumFile> getCompletedW9ExistingFile()
    {
        return completedW9ExistingFile;
    }

    public String getCustomerDemonstrateDesc()
    {
        return customerDemonstrateDesc;
    }

    public String getCustomerQualifications()
    {
        return customerQualifications;
    }

    public String getCustomerServicesDesc()
    {
        return customerServicesDesc;
    }

    public Boolean getIsComparableService()
    {
        return isComparableService;
    }

    public Boolean getIsServiceTime()
    {
        return isServiceTime;
    }

    public Boolean getIsCustomerDemonstrate()
    {
        return isCustomerDemonstrate;
    }

    public Boolean getIsFairMarketValue()
    {
        return isFairMarketValue;
    }

    public Boolean getIsPatientAdvocacyOrg()
    {
        return isPatientAdvocacyOrg;
    }

    public Boolean getIsProfMedicalSociety()
    {
        return isProfMedicalSociety;
    }

    public Boolean getIsRelatedToProduct()
    {
        return isRelatedToProduct;
    }

    public String getServiceDate()
    {
        return serviceDate;
    }

    public Boolean getIsUniqueExperience()
    {
        return isUniqueExperience;
    }

    public List<CommonsMultipartFile> getItemizedBudget()
    {
        return itemizedBudget;
    }

    public List<DocumentumFile> getItemizedBudgetExistingFile()
    {
        return itemizedBudgetExistingFile;
    }

    public List<CommonsMultipartFile> getProposal()
    {
        return proposal;
    }

    public List<DocumentumFile> getProposalExistingFile()
    {
        return proposalExistingFile;
    }

    public String getRevOfMedicalSociety()
    {
        return revOfMedicalSociety;
    }

    public String getRevOfPatientAdvocacyOrg()
    {
        return revOfPatientAdvocacyOrg;
    }

    public String getServiceProvided()
    {
        return serviceProvided;
    }

    public String getSpecialistName()
    {
        return specialistName;
    }

    public String getUniqueExperienceDesc()
    {
        return uniqueExperienceDesc;
    }

    public void setAgreementDesc(String agreementDesc)
    {
        this.agreementDesc = agreementDesc;
    }

    public void setApplicableAgreement(List<CommonsMultipartFile> applicableAgreement)
    {
        this.applicableAgreement = applicableAgreement;
    }

    public void setApplicableAgreementExistingFile(List<DocumentumFile> applicableAgreementExistingFile)
    {
        this.applicableAgreementExistingFile = applicableAgreementExistingFile;
    }

    public void setBusinessNeed(String businessNeed)
    {
        this.businessNeed = businessNeed;
    }

    public void setCompletedW9(List<CommonsMultipartFile> completedW9)
    {
        this.completedW9 = completedW9;
    }

    public void setCompletedW9ExistingFile(List<DocumentumFile> completedW9ExistingFile)
    {
        this.completedW9ExistingFile = completedW9ExistingFile;
    }

    public void setCustomerDemonstrateDesc(String customerDemonstrateDesc)
    {
        this.customerDemonstrateDesc = customerDemonstrateDesc;
    }

    public void setCustomerQualifications(String customerQualifications)
    {
        this.customerQualifications = customerQualifications;
    }

    public void setCustomerServicesDesc(String customerServicesDesc)
    {
        this.customerServicesDesc = customerServicesDesc;
    }

    public void setIsComparableService(Boolean isComparableService)
    {
        this.isComparableService = isComparableService;
    }

    public void setIsServiceTime(Boolean isServiceTime)
    {
        this.isServiceTime = isServiceTime;
    }

    public void setIsCustomerDemonstrate(Boolean isCustomerDemonstrate)
    {
        this.isCustomerDemonstrate = isCustomerDemonstrate;
    }

    public void setIsFairMarketValue(Boolean isFairMarketValue)
    {
        this.isFairMarketValue = isFairMarketValue;
    }

    public void setIsPatientAdvocacyOrg(Boolean isPatientAdvocacyOrg)
    {
        this.isPatientAdvocacyOrg = isPatientAdvocacyOrg;
    }

    public void setIsProfMedicalSociety(Boolean isProfMedicalSociety)
    {
        this.isProfMedicalSociety = isProfMedicalSociety;
    }

    public void setIsRelatedToProduct(Boolean isRelatedToProd)
    {
        this.isRelatedToProduct = isRelatedToProd;
    }

    public void setIsUniqueExperience(Boolean isUniqueExperience)
    {
        this.isUniqueExperience = isUniqueExperience;
    }

    public void setItemizedBudget(List<CommonsMultipartFile> itemizedBudget)
    {
        this.itemizedBudget = itemizedBudget;
    }

    public void setItemizedBudgetExistingFile(List<DocumentumFile> itemizedBudgetExistingFile)
    {
        this.itemizedBudgetExistingFile = itemizedBudgetExistingFile;
    }

    public void setProposal(List<CommonsMultipartFile> proposal)
    {
        this.proposal = proposal;
    }

    public void setProposalExistingFile(List<DocumentumFile> proposalExistingFile)
    {
        this.proposalExistingFile = proposalExistingFile;
    }

    public void setRevOfMedicalSociety(String revOfMedicalSociety)
    {
        this.revOfMedicalSociety = revOfMedicalSociety;
    }

    public void setRevOfPatientAdvocacyOrg(String revOfPatientAdvocacyOrg)
    {
        this.revOfPatientAdvocacyOrg = revOfPatientAdvocacyOrg;
    }

    public void setServiceProvided(String serviceProvided)
    {
        this.serviceProvided = serviceProvided;
    }

    public void setSpecialistName(String specialistName)
    {
        this.specialistName = specialistName;
    }

    public void setUniqueExperienceDesc(String uniqueExperienceDesc)
    {
        this.uniqueExperienceDesc = uniqueExperienceDesc;
    }

    public void setServiceDate(String serviceDate)
    {
        this.serviceDate = serviceDate;
    }
}
