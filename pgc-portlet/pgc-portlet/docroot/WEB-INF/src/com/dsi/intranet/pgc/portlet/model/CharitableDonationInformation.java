package com.dsi.intranet.pgc.portlet.model;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileReadMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumFileWriteMapping;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumPropertyMapping;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CharitableDonationInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@DocumentumPropertyMapping(name = "pgc_char_recpt_name")
	private String recipientName;
	@DocumentumPropertyMapping(name = "pgc_donation_purpose")
	private String donationPurpose;
	@DocumentumPropertyMapping(name = "pgc_donation_amount")
	private String donationAmount;*/
	
	@DocumentumFileWriteMapping(attachmentType = "Cyber Grants application")
    private List<CommonsMultipartFile> cyberGrantsList;
    @DocumentumFileReadMapping(attachmentType = "Cyber Grants application")
    private List<DocumentumFile> cyberGrantsExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "Proposed Agenda for program")
    private List<CommonsMultipartFile> proposedAgendaList;
    @DocumentumFileReadMapping(attachmentType = "Proposed Agenda for program")
    private List<DocumentumFile> proposedAgendaExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "Request letter")
    private List<CommonsMultipartFile> requestLetterList;
    @DocumentumFileReadMapping(attachmentType = "Request letter")
    private List<DocumentumFile> requestLetterExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "Budget")
    private List<CommonsMultipartFile> budgetList;
    @DocumentumFileReadMapping(attachmentType = "Budget")
    private List<DocumentumFile> budgetExistingFile;
    
	@DocumentumFileWriteMapping(attachmentType = "Completed W9 Form")
    private List<CommonsMultipartFile> w9FormList;
    @DocumentumFileReadMapping(attachmentType = "Completed W9 Form")
    private List<DocumentumFile> w9FormListExistingFile;
    		
    @DocumentumFileWriteMapping(attachmentType = "Current 990 form")
    private List<CommonsMultipartFile> current990List;
    @DocumentumFileReadMapping(attachmentType = "Current 990 form")
    private List<DocumentumFile> current990ExistingFile;
    
    @DocumentumFileWriteMapping(attachmentType = "Other documentation that supports this request")
    private List<CommonsMultipartFile> otherDocumentsList;
    @DocumentumFileReadMapping(attachmentType = "Other documentation that supports this request")
    private List<DocumentumFile> otherDocumentsExistingFile;

	/*public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getDonationPurpose() {
		return donationPurpose;
	}

	public void setDonationPurpose(String donationPurpose) {
		this.donationPurpose = donationPurpose;
	}
		
	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}*/

	public List<CommonsMultipartFile> getW9FormList() {
		return w9FormList;
	}

	public void setW9FormList(List<CommonsMultipartFile> w9FormList) {
		this.w9FormList = w9FormList;
	}

	public List<DocumentumFile> getW9FormListExistingFile() {
		return w9FormListExistingFile;
	}

	public void setW9FormListExistingFile(
			List<DocumentumFile> w9FormListExistingFile) {
		this.w9FormListExistingFile = w9FormListExistingFile;
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
	
	public List<CommonsMultipartFile> getCyberGrantsList() {
		return cyberGrantsList;
	}

	public void setCyberGrantsList(List<CommonsMultipartFile> cyberGrantsList) {
		this.cyberGrantsList = cyberGrantsList;
	}

	public List<DocumentumFile> getCyberGrantsExistingFile() {
		return cyberGrantsExistingFile;
	}

	public void setCyberGrantsExistingFile(
			List<DocumentumFile> cyberGrantsExistingFile) {
		this.cyberGrantsExistingFile = cyberGrantsExistingFile;
	}

	public List<CommonsMultipartFile> getProposedAgendaList() {
		return proposedAgendaList;
	}

	public void setProposedAgendaList(List<CommonsMultipartFile> proposedAgendaList) {
		this.proposedAgendaList = proposedAgendaList;
	}

	public List<DocumentumFile> getProposedAgendaExistingFile() {
		return proposedAgendaExistingFile;
	}

	public void setProposedAgendaExistingFile(
			List<DocumentumFile> proposedAgendaExistingFile) {
		this.proposedAgendaExistingFile = proposedAgendaExistingFile;
	}

	public List<CommonsMultipartFile> getRequestLetterList() {
		return requestLetterList;
	}

	public void setRequestLetterList(List<CommonsMultipartFile> requestLetterList) {
		this.requestLetterList = requestLetterList;
	}

	public List<DocumentumFile> getRequestLetterExistingFile() {
		return requestLetterExistingFile;
	}

	public void setRequestLetterExistingFile(
			List<DocumentumFile> requestLetterExistingFile) {
		this.requestLetterExistingFile = requestLetterExistingFile;
	}

	public List<CommonsMultipartFile> getBudgetList() {
		return budgetList;
	}

	public void setBudgetList(List<CommonsMultipartFile> budgetList) {
		this.budgetList = budgetList;
	}

	public List<DocumentumFile> getBudgetExistingFile() {
		return budgetExistingFile;
	}

	public void setBudgetExistingFile(List<DocumentumFile> budgetExistingFile) {
		this.budgetExistingFile = budgetExistingFile;
	}

	public List<CommonsMultipartFile> getCurrent990List() {
		return current990List;
	}

	public void setCurrent990List(List<CommonsMultipartFile> current990List) {
		this.current990List = current990List;
	}

	public List<DocumentumFile> getCurrent990ExistingFile() {
		return current990ExistingFile;
	}

	public void setCurrent990ExistingFile(
			List<DocumentumFile> current990ExistingFile) {
		this.current990ExistingFile = current990ExistingFile;
	}
		
}
