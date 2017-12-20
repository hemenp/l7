/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Configurable;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;

/**
 * <a href="PGCForm.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author 
 * @Description
 * @ChangeLog:
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to Pass Object Name while updating the record
 * Kruti Doshi		|	Sep 15 2014		|	Added property for 2 newly added forms i.e Charitable Donation form & General Req Form
 */
@Configurable
public class PGCForm implements Serializable
{

    /** Default serial version UID */
    private static final long serialVersionUID = 1L;

    private AdvisoryBoardInformation advisoryBoardInfo;
    private BudgetInformation budgetInfo;

    private CheckRequestInformation checkReqInfo;
    private ContractInformation contractInfo;

    private CorporateSupportInformation corporateSupport;

    private DisplayExhibitInformation dispExhibitInfo;

    private EducationalItemsInformation eduItemsInfo;

    private String formId;

    @DocumentumPropertyMapping(name = "pgc_status")
    private String formStatus;
    @DocumentumPropertyMapping(name = "pgc_status_notes")
    private String formStatusNotes;
    @DocumentumPropertyMapping(name = "title")
    private String formTitle;
    private PGCFormType formType;
    private String formVersion;

    private HCPConsultant hcpConsultantInfo;
    private ModificationInformation modInfo;

    private String objectId;
    private POMembershipInformation pOMemInfo;

    private ProductInformation productInfo;

    private RequestorInformation reqInfo;
    
    private CharitableDonationInformation donationInfo;
    
    private GeneralRequestInformation requestInfo;

    @DocumentumPropertyMapping(name = "pgc_req_id")
    private String requestId;

    private ServiceAgreement serviceAgreement;
    //DSI:START::Veera Reddy:: To pass the object name while editing the record 
    @DocumentumPropertyMapping(name = "object_name")
    private String objectName;
    //DSI:END::Veera Reddy:: To pass the object name while editing the record 

	public PGCForm()
    {
        reqInfo = new RequestorInformation();
        checkReqInfo = new CheckRequestInformation();
        modInfo = new ModificationInformation();
        contractInfo = new ContractInformation();
        serviceAgreement = new ServiceAgreement();
        corporateSupport = new CorporateSupportInformation();
        dispExhibitInfo = new DisplayExhibitInformation();
        eduItemsInfo = new EducationalItemsInformation();
        pOMemInfo = new POMembershipInformation();
        advisoryBoardInfo = new AdvisoryBoardInformation();
        hcpConsultantInfo = new HCPConsultant();
        productInfo = new ProductInformation();
        budgetInfo = new BudgetInformation();
        donationInfo = new CharitableDonationInformation();
        requestInfo = new GeneralRequestInformation();

        // TODO: Need to remove this later on, or have a proper status value ...
        formStatusNotes = "";
        formTitle = "Test title";
    }

    public AdvisoryBoardInformation getAdvisoryBoardInfo()
    {
        return advisoryBoardInfo;
    }

    public BudgetInformation getBudgetInfo()
    {
        return budgetInfo;
    }

    public CheckRequestInformation getCheckReqInfo()
    {
        return checkReqInfo;
    }

    public ContractInformation getContractInfo()
    {
        return contractInfo;
    }

    public CorporateSupportInformation getCorporateSupport()
    {
        return corporateSupport;
    }

    public DisplayExhibitInformation getDispExhibitInfo()
    {
        return dispExhibitInfo;
    }

    public EducationalItemsInformation getEduItemsInfo()
    {
        return eduItemsInfo;
    }

    public String getFormId()
    {
        return formId;
    }

    public String getFormStatus()
    {
        return formStatus;
    }

    public String getFormStatusNotes()
    {
        return formStatusNotes;
    }

    public String getFormTitle()
    {
        return formTitle;
    }

    public PGCFormType getFormType()
    {
        return formType;
    }

    public String getFormVersion()
    {
        return formVersion;
    }

    public HCPConsultant getHcpConsultantInfo()
    {
        return hcpConsultantInfo;
    }

    public ModificationInformation getModInfo()
    {
        return modInfo;
    }

    public String getObjectId()
    {
        return objectId;
    }

    public POMembershipInformation getpOMemInfo()
    {
        return pOMemInfo;
    }

    public ProductInformation getProductInfo()
    {
        return productInfo;
    }

    /*
     * public CommonsMultipartFile getFile1() { return file1; } public void
     * setFile1(CommonsMultipartFile file1) { this.file1 = file1; } public
     * CommonsMultipartFile getFile2() { return file2; } public void
     * setFile2(CommonsMultipartFile file2) { this.file2 = file2; } public
     * CommonsMultipartFile getFile3() { return file3; } public void
     * setFile3(CommonsMultipartFile file3) { this.file3 = file3; } public
     * CommonsMultipartFile getFile4() { return file4; } public void
     * setFile4(CommonsMultipartFile file4) { this.file4 = file4; }
     */

    public RequestorInformation getReqInfo()
    {
        return reqInfo;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public ServiceAgreement getServiceAgreement()
    {
        return serviceAgreement;
    }

    public void setAdvisoryBoardInfo(AdvisoryBoardInformation advisoryBoardInfo)
    {
        this.advisoryBoardInfo = advisoryBoardInfo;
    }

    public void setBudgetInfo(BudgetInformation budgetInfo)
    {
        this.budgetInfo = budgetInfo;
    }

    public void setCheckReqInfo(CheckRequestInformation checkReqInfo)
    {
        this.checkReqInfo = checkReqInfo;
    }

    public void setContractInfo(ContractInformation contractInfo)
    {
        this.contractInfo = contractInfo;
    }

    public void setCorporateSupportInformation(CorporateSupportInformation corporateSupport)
    {
        this.corporateSupport = corporateSupport;
    }

    public void setDispExhibitInfo(DisplayExhibitInformation dispExhibitInfo)
    {
        this.dispExhibitInfo = dispExhibitInfo;
    }

    public void setEduItemsInfo(EducationalItemsInformation eduItemsInfo)
    {
        this.eduItemsInfo = eduItemsInfo;
    }

    public void setFormId(String id)
    {
        this.formId = id;
    }

    public void setFormStatus(String status)
    {
        this.formStatus = status;
    }

    public void setFormStatusNotes(String statusNotes)
    {
        this.formStatusNotes = statusNotes;
    }

    public void setFormTitle(String title)
    {
        this.formTitle = title;
    }

    public void setFormType(PGCFormType formType)
    {
        this.formType = formType;
    }

    public void setFormVersion(String ver)
    {
        this.formVersion = ver;
    }

    public void setHcpConsultantInfo(HCPConsultant hcpConsultantInfo)
    {
        this.hcpConsultantInfo = hcpConsultantInfo;
    }

    public void setModInfo(ModificationInformation modInfo)
    {
        this.modInfo = modInfo;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    public void setPOMemInfo(POMembershipInformation pOMemInfo)
    {
        this.pOMemInfo = pOMemInfo;
    }

    public void setProductInfo(ProductInformation productInfo)
    {
        this.productInfo = productInfo;
    }

    public void setReqInfo(RequestorInformation reqInfo)
    {
        this.reqInfo = reqInfo;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public void setServiceAgreement(ServiceAgreement serviceAgreement)
    {
        this.serviceAgreement = serviceAgreement;
    }    
    
	public CharitableDonationInformation getDonationInfo() {
		return donationInfo;
	}

	public void setDonationInfo(CharitableDonationInformation donationInfo) {
		this.donationInfo = donationInfo;
	}

	public GeneralRequestInformation getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(GeneralRequestInformation requestInfo) {
		this.requestInfo = requestInfo;
	}

	//DSI:START::Veera Reddy:: To pass the object name while editing the record 
    public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
    //DSI:END::Veera Reddy:: To pass the object name while editing the record 
}
