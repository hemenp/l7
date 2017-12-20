package com.dsi.intranet.pgc.portlet.model;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileReadMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileWriteMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class GeneralRequestInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DocumentumPropertyMapping(name = "pgc_project_name")
	private String projectName;
	@DocumentumPropertyMapping(name = "pgc_is_cust_or_hcp")
	private Boolean isCustInvolved;
	@DocumentumPropertyMapping(name = "pgc_cus_desc")
	private String custInvolved;
	@DocumentumPropertyMapping(name = "pgc_requestor_name")
	private String requestorName;
	@DocumentumPropertyMapping(name = "pgc_business_function")
	private String businessFunction;
	@DocumentumPropertyMapping(name = "pgc_business_need")
	private String businessNeed;
	@DocumentumPropertyMapping(name = "pgc_purpose_info")
	private String purposeInfo;
	@DocumentumPropertyMapping(name = "pgc_any_item_desc")
	private String itemDescription;
	@DocumentumPropertyMapping(name = "pgc_prom_activity")
	private Boolean promotionalActivity;
	@DocumentumPropertyMapping(name = "pgc_is_info_to_hcp")
	private Boolean isHCPInfoProvided;
	
	@DocumentumFileWriteMapping(attachmentType = "Other documentation that supports this request")
    private List<CommonsMultipartFile> otherDocumentsList;
    @DocumentumFileReadMapping(attachmentType = "Other documentation that supports this request")
    private List<DocumentumFile> otherDocumentsExistingFile;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCustInvolved() {
		return custInvolved;
	}

	public void setCustInvolved(String custInvolved) {
		this.custInvolved = custInvolved;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public String getBusinessFunction() {
		return businessFunction;
	}

	public void setBusinessFunction(String businessFunction) {
		this.businessFunction = businessFunction;
	}

	public String getBusinessNeed() {
		return businessNeed;
	}

	public void setBusinessNeed(String businessNeed) {
		this.businessNeed = businessNeed;
	}

	public String getPurposeInfo() {
		return purposeInfo;
	}

	public void setPurposeInfo(String purposeInfo) {
		this.purposeInfo = purposeInfo;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Boolean getPromotionalActivity() {
		return promotionalActivity;
	}

	public void setPromotionalActivity(Boolean promotionalActivity) {
		this.promotionalActivity = promotionalActivity;
	}

	public Boolean getIsHCPInfoProvided() {
		return isHCPInfoProvided;
	}

	public void setIsHCPInfoProvided(Boolean isHCPInfoProvided) {
		this.isHCPInfoProvided = isHCPInfoProvided;
	}

	public Boolean getIsCustInvolved() {
		return isCustInvolved;
	}

	public void setIsCustInvolved(Boolean isCustInvolved) {
		this.isCustInvolved = isCustInvolved;
	}

	public List<CommonsMultipartFile> getOtherDocumentsList() {
		return otherDocumentsList;
	}

	public void setOtherDocumentsList(List<CommonsMultipartFile> otherDocumentsList) {
		this.otherDocumentsList = otherDocumentsList;
	}

	public List<DocumentumFile> getOtherDocumentsExistingFile() {
		return otherDocumentsExistingFile;
	}

	public void setOtherDocumentsExistingFile(
			List<DocumentumFile> otherDocumentsExistingFile) {
		this.otherDocumentsExistingFile = otherDocumentsExistingFile;
	}
	
}
