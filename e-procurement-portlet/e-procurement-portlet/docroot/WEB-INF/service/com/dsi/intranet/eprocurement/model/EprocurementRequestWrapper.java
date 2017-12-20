/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dsi.intranet.eprocurement.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EprocurementRequest}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequest
 * @generated
 */
@ProviderType
public class EprocurementRequestWrapper implements EprocurementRequest,
	ModelWrapper<EprocurementRequest> {
	public EprocurementRequestWrapper(EprocurementRequest eprocurementRequest) {
		_eprocurementRequest = eprocurementRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return EprocurementRequest.class;
	}

	@Override
	public String getModelClassName() {
		return EprocurementRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestId", getRequestId());
		attributes.put("shipToOther", getShipToOther());
		attributes.put("spendDepartment", getSpendDepartment());
		attributes.put("spendYear", getSpendYear());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());
		attributes.put("isBudgetedRequest", getIsBudgetedRequest());
		attributes.put("isRelatedtoProject", getIsRelatedtoProject());
		attributes.put("projectName", getProjectName());
		attributes.put("projectOwnerId", getProjectOwnerId());
		attributes.put("totalCost", getTotalCost());
		attributes.put("originalCost", getOriginalCost());
		attributes.put("reason", getReason());
		attributes.put("notes", getNotes());
		attributes.put("vendorCode", getVendorCode());
		attributes.put("vendorEmail", getVendorEmail());
		attributes.put("contractId", getContractId());
		attributes.put("purchaseOrder", getPurchaseOrder());
		attributes.put("itemInStock", getItemInStock());
		attributes.put("recievedDate", getRecievedDate());
		attributes.put("returnedDate", getReturnedDate());
		attributes.put("assetInfo", getAssetInfo());
		attributes.put("returnedAssets", getReturnedAssets());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("requestorId", getRequestorId());
		attributes.put("supervisorId", getSupervisorId());
		attributes.put("status", getStatus());
		attributes.put("stage", getStage());
		attributes.put("nextStage", getNextStage());
		attributes.put("isApproverRole", getIsApproverRole());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		String shipToOther = (String)attributes.get("shipToOther");

		if (shipToOther != null) {
			setShipToOther(shipToOther);
		}

		String spendDepartment = (String)attributes.get("spendDepartment");

		if (spendDepartment != null) {
			setSpendDepartment(spendDepartment);
		}

		String spendYear = (String)attributes.get("spendYear");

		if (spendYear != null) {
			setSpendYear(spendYear);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String isBudgetedRequest = (String)attributes.get("isBudgetedRequest");

		if (isBudgetedRequest != null) {
			setIsBudgetedRequest(isBudgetedRequest);
		}

		String isRelatedtoProject = (String)attributes.get("isRelatedtoProject");

		if (isRelatedtoProject != null) {
			setIsRelatedtoProject(isRelatedtoProject);
		}

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		Long projectOwnerId = (Long)attributes.get("projectOwnerId");

		if (projectOwnerId != null) {
			setProjectOwnerId(projectOwnerId);
		}

		Double totalCost = (Double)attributes.get("totalCost");

		if (totalCost != null) {
			setTotalCost(totalCost);
		}

		Double originalCost = (Double)attributes.get("originalCost");

		if (originalCost != null) {
			setOriginalCost(originalCost);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String vendorCode = (String)attributes.get("vendorCode");

		if (vendorCode != null) {
			setVendorCode(vendorCode);
		}

		String vendorEmail = (String)attributes.get("vendorEmail");

		if (vendorEmail != null) {
			setVendorEmail(vendorEmail);
		}

		String contractId = (String)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		String purchaseOrder = (String)attributes.get("purchaseOrder");

		if (purchaseOrder != null) {
			setPurchaseOrder(purchaseOrder);
		}

		Boolean itemInStock = (Boolean)attributes.get("itemInStock");

		if (itemInStock != null) {
			setItemInStock(itemInStock);
		}

		Date recievedDate = (Date)attributes.get("recievedDate");

		if (recievedDate != null) {
			setRecievedDate(recievedDate);
		}

		Date returnedDate = (Date)attributes.get("returnedDate");

		if (returnedDate != null) {
			setReturnedDate(returnedDate);
		}

		String assetInfo = (String)attributes.get("assetInfo");

		if (assetInfo != null) {
			setAssetInfo(assetInfo);
		}

		String returnedAssets = (String)attributes.get("returnedAssets");

		if (returnedAssets != null) {
			setReturnedAssets(returnedAssets);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long requestorId = (Long)attributes.get("requestorId");

		if (requestorId != null) {
			setRequestorId(requestorId);
		}

		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		String nextStage = (String)attributes.get("nextStage");

		if (nextStage != null) {
			setNextStage(nextStage);
		}

		String isApproverRole = (String)attributes.get("isApproverRole");

		if (isApproverRole != null) {
			setIsApproverRole(isApproverRole);
		}
	}

	@Override
	public EprocurementRequest toEscapedModel() {
		return new EprocurementRequestWrapper(_eprocurementRequest.toEscapedModel());
	}

	@Override
	public EprocurementRequest toUnescapedModel() {
		return new EprocurementRequestWrapper(_eprocurementRequest.toUnescapedModel());
	}

	/**
	* Returns the item in stock of this eprocurement request.
	*
	* @return the item in stock of this eprocurement request
	*/
	@Override
	public boolean getItemInStock() {
		return _eprocurementRequest.getItemInStock();
	}

	@Override
	public boolean isCachedModel() {
		return _eprocurementRequest.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _eprocurementRequest.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this eprocurement request is item in stock.
	*
	* @return <code>true</code> if this eprocurement request is item in stock; <code>false</code> otherwise
	*/
	@Override
	public boolean isItemInStock() {
		return _eprocurementRequest.isItemInStock();
	}

	@Override
	public boolean isNew() {
		return _eprocurementRequest.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _eprocurementRequest.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EprocurementRequest> toCacheModel() {
		return _eprocurementRequest.toCacheModel();
	}

	/**
	* Returns the original cost of this eprocurement request.
	*
	* @return the original cost of this eprocurement request
	*/
	@Override
	public double getOriginalCost() {
		return _eprocurementRequest.getOriginalCost();
	}

	/**
	* Returns the total cost of this eprocurement request.
	*
	* @return the total cost of this eprocurement request
	*/
	@Override
	public double getTotalCost() {
		return _eprocurementRequest.getTotalCost();
	}

	@Override
	public int compareTo(EprocurementRequest eprocurementRequest) {
		return _eprocurementRequest.compareTo(eprocurementRequest);
	}

	@Override
	public int hashCode() {
		return _eprocurementRequest.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eprocurementRequest.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EprocurementRequestWrapper((EprocurementRequest)_eprocurementRequest.clone());
	}

	/**
	* Returns the address of this eprocurement request.
	*
	* @return the address of this eprocurement request
	*/
	@Override
	public java.lang.String getAddress() {
		return _eprocurementRequest.getAddress();
	}

	/**
	* Returns the asset info of this eprocurement request.
	*
	* @return the asset info of this eprocurement request
	*/
	@Override
	public java.lang.String getAssetInfo() {
		return _eprocurementRequest.getAssetInfo();
	}

	/**
	* Returns the city of this eprocurement request.
	*
	* @return the city of this eprocurement request
	*/
	@Override
	public java.lang.String getCity() {
		return _eprocurementRequest.getCity();
	}

	/**
	* Returns the contract ID of this eprocurement request.
	*
	* @return the contract ID of this eprocurement request
	*/
	@Override
	public java.lang.String getContractId() {
		return _eprocurementRequest.getContractId();
	}

	/**
	* Returns the is approver role of this eprocurement request.
	*
	* @return the is approver role of this eprocurement request
	*/
	@Override
	public java.lang.String getIsApproverRole() {
		return _eprocurementRequest.getIsApproverRole();
	}

	/**
	* Returns the is budgeted request of this eprocurement request.
	*
	* @return the is budgeted request of this eprocurement request
	*/
	@Override
	public java.lang.String getIsBudgetedRequest() {
		return _eprocurementRequest.getIsBudgetedRequest();
	}

	/**
	* Returns the is relatedto project of this eprocurement request.
	*
	* @return the is relatedto project of this eprocurement request
	*/
	@Override
	public java.lang.String getIsRelatedtoProject() {
		return _eprocurementRequest.getIsRelatedtoProject();
	}

	/**
	* Returns the next stage of this eprocurement request.
	*
	* @return the next stage of this eprocurement request
	*/
	@Override
	public java.lang.String getNextStage() {
		return _eprocurementRequest.getNextStage();
	}

	/**
	* Returns the notes of this eprocurement request.
	*
	* @return the notes of this eprocurement request
	*/
	@Override
	public java.lang.String getNotes() {
		return _eprocurementRequest.getNotes();
	}

	/**
	* Returns the project name of this eprocurement request.
	*
	* @return the project name of this eprocurement request
	*/
	@Override
	public java.lang.String getProjectName() {
		return _eprocurementRequest.getProjectName();
	}

	/**
	* Returns the purchase order of this eprocurement request.
	*
	* @return the purchase order of this eprocurement request
	*/
	@Override
	public java.lang.String getPurchaseOrder() {
		return _eprocurementRequest.getPurchaseOrder();
	}

	/**
	* Returns the reason of this eprocurement request.
	*
	* @return the reason of this eprocurement request
	*/
	@Override
	public java.lang.String getReason() {
		return _eprocurementRequest.getReason();
	}

	/**
	* Returns the returned assets of this eprocurement request.
	*
	* @return the returned assets of this eprocurement request
	*/
	@Override
	public java.lang.String getReturnedAssets() {
		return _eprocurementRequest.getReturnedAssets();
	}

	/**
	* Returns the ship to other of this eprocurement request.
	*
	* @return the ship to other of this eprocurement request
	*/
	@Override
	public java.lang.String getShipToOther() {
		return _eprocurementRequest.getShipToOther();
	}

	/**
	* Returns the spend department of this eprocurement request.
	*
	* @return the spend department of this eprocurement request
	*/
	@Override
	public java.lang.String getSpendDepartment() {
		return _eprocurementRequest.getSpendDepartment();
	}

	/**
	* Returns the spend year of this eprocurement request.
	*
	* @return the spend year of this eprocurement request
	*/
	@Override
	public java.lang.String getSpendYear() {
		return _eprocurementRequest.getSpendYear();
	}

	/**
	* Returns the stage of this eprocurement request.
	*
	* @return the stage of this eprocurement request
	*/
	@Override
	public java.lang.String getStage() {
		return _eprocurementRequest.getStage();
	}

	/**
	* Returns the state of this eprocurement request.
	*
	* @return the state of this eprocurement request
	*/
	@Override
	public java.lang.String getState() {
		return _eprocurementRequest.getState();
	}

	/**
	* Returns the status of this eprocurement request.
	*
	* @return the status of this eprocurement request
	*/
	@Override
	public java.lang.String getStatus() {
		return _eprocurementRequest.getStatus();
	}

	/**
	* Returns the vendor code of this eprocurement request.
	*
	* @return the vendor code of this eprocurement request
	*/
	@Override
	public java.lang.String getVendorCode() {
		return _eprocurementRequest.getVendorCode();
	}

	/**
	* Returns the vendor email of this eprocurement request.
	*
	* @return the vendor email of this eprocurement request
	*/
	@Override
	public java.lang.String getVendorEmail() {
		return _eprocurementRequest.getVendorEmail();
	}

	/**
	* Returns the zip of this eprocurement request.
	*
	* @return the zip of this eprocurement request
	*/
	@Override
	public java.lang.String getZip() {
		return _eprocurementRequest.getZip();
	}

	@Override
	public java.lang.String toString() {
		return _eprocurementRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eprocurementRequest.toXmlString();
	}

	/**
	* Returns the created date of this eprocurement request.
	*
	* @return the created date of this eprocurement request
	*/
	@Override
	public Date getCreatedDate() {
		return _eprocurementRequest.getCreatedDate();
	}

	/**
	* Returns the modified date of this eprocurement request.
	*
	* @return the modified date of this eprocurement request
	*/
	@Override
	public Date getModifiedDate() {
		return _eprocurementRequest.getModifiedDate();
	}

	/**
	* Returns the recieved date of this eprocurement request.
	*
	* @return the recieved date of this eprocurement request
	*/
	@Override
	public Date getRecievedDate() {
		return _eprocurementRequest.getRecievedDate();
	}

	/**
	* Returns the returned date of this eprocurement request.
	*
	* @return the returned date of this eprocurement request
	*/
	@Override
	public Date getReturnedDate() {
		return _eprocurementRequest.getReturnedDate();
	}

	/**
	* Returns the company ID of this eprocurement request.
	*
	* @return the company ID of this eprocurement request
	*/
	@Override
	public long getCompanyId() {
		return _eprocurementRequest.getCompanyId();
	}

	/**
	* Returns the created by of this eprocurement request.
	*
	* @return the created by of this eprocurement request
	*/
	@Override
	public long getCreatedBy() {
		return _eprocurementRequest.getCreatedBy();
	}

	/**
	* Returns the group ID of this eprocurement request.
	*
	* @return the group ID of this eprocurement request
	*/
	@Override
	public long getGroupId() {
		return _eprocurementRequest.getGroupId();
	}

	/**
	* Returns the modified by of this eprocurement request.
	*
	* @return the modified by of this eprocurement request
	*/
	@Override
	public long getModifiedBy() {
		return _eprocurementRequest.getModifiedBy();
	}

	/**
	* Returns the primary key of this eprocurement request.
	*
	* @return the primary key of this eprocurement request
	*/
	@Override
	public long getPrimaryKey() {
		return _eprocurementRequest.getPrimaryKey();
	}

	/**
	* Returns the project owner ID of this eprocurement request.
	*
	* @return the project owner ID of this eprocurement request
	*/
	@Override
	public long getProjectOwnerId() {
		return _eprocurementRequest.getProjectOwnerId();
	}

	/**
	* Returns the request ID of this eprocurement request.
	*
	* @return the request ID of this eprocurement request
	*/
	@Override
	public long getRequestId() {
		return _eprocurementRequest.getRequestId();
	}

	/**
	* Returns the requestor ID of this eprocurement request.
	*
	* @return the requestor ID of this eprocurement request
	*/
	@Override
	public long getRequestorId() {
		return _eprocurementRequest.getRequestorId();
	}

	/**
	* Returns the supervisor ID of this eprocurement request.
	*
	* @return the supervisor ID of this eprocurement request
	*/
	@Override
	public long getSupervisorId() {
		return _eprocurementRequest.getSupervisorId();
	}

	@Override
	public void persist() {
		_eprocurementRequest.persist();
	}

	/**
	* Sets the address of this eprocurement request.
	*
	* @param address the address of this eprocurement request
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_eprocurementRequest.setAddress(address);
	}

	/**
	* Sets the asset info of this eprocurement request.
	*
	* @param assetInfo the asset info of this eprocurement request
	*/
	@Override
	public void setAssetInfo(java.lang.String assetInfo) {
		_eprocurementRequest.setAssetInfo(assetInfo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eprocurementRequest.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this eprocurement request.
	*
	* @param city the city of this eprocurement request
	*/
	@Override
	public void setCity(java.lang.String city) {
		_eprocurementRequest.setCity(city);
	}

	/**
	* Sets the company ID of this eprocurement request.
	*
	* @param companyId the company ID of this eprocurement request
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eprocurementRequest.setCompanyId(companyId);
	}

	/**
	* Sets the contract ID of this eprocurement request.
	*
	* @param contractId the contract ID of this eprocurement request
	*/
	@Override
	public void setContractId(java.lang.String contractId) {
		_eprocurementRequest.setContractId(contractId);
	}

	/**
	* Sets the created by of this eprocurement request.
	*
	* @param createdBy the created by of this eprocurement request
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_eprocurementRequest.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this eprocurement request.
	*
	* @param createdDate the created date of this eprocurement request
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_eprocurementRequest.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_eprocurementRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_eprocurementRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_eprocurementRequest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this eprocurement request.
	*
	* @param groupId the group ID of this eprocurement request
	*/
	@Override
	public void setGroupId(long groupId) {
		_eprocurementRequest.setGroupId(groupId);
	}

	/**
	* Sets the is approver role of this eprocurement request.
	*
	* @param isApproverRole the is approver role of this eprocurement request
	*/
	@Override
	public void setIsApproverRole(java.lang.String isApproverRole) {
		_eprocurementRequest.setIsApproverRole(isApproverRole);
	}

	/**
	* Sets the is budgeted request of this eprocurement request.
	*
	* @param isBudgetedRequest the is budgeted request of this eprocurement request
	*/
	@Override
	public void setIsBudgetedRequest(java.lang.String isBudgetedRequest) {
		_eprocurementRequest.setIsBudgetedRequest(isBudgetedRequest);
	}

	/**
	* Sets the is relatedto project of this eprocurement request.
	*
	* @param isRelatedtoProject the is relatedto project of this eprocurement request
	*/
	@Override
	public void setIsRelatedtoProject(java.lang.String isRelatedtoProject) {
		_eprocurementRequest.setIsRelatedtoProject(isRelatedtoProject);
	}

	/**
	* Sets whether this eprocurement request is item in stock.
	*
	* @param itemInStock the item in stock of this eprocurement request
	*/
	@Override
	public void setItemInStock(boolean itemInStock) {
		_eprocurementRequest.setItemInStock(itemInStock);
	}

	/**
	* Sets the modified by of this eprocurement request.
	*
	* @param modifiedBy the modified by of this eprocurement request
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_eprocurementRequest.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this eprocurement request.
	*
	* @param modifiedDate the modified date of this eprocurement request
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_eprocurementRequest.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_eprocurementRequest.setNew(n);
	}

	/**
	* Sets the next stage of this eprocurement request.
	*
	* @param nextStage the next stage of this eprocurement request
	*/
	@Override
	public void setNextStage(java.lang.String nextStage) {
		_eprocurementRequest.setNextStage(nextStage);
	}

	/**
	* Sets the notes of this eprocurement request.
	*
	* @param notes the notes of this eprocurement request
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_eprocurementRequest.setNotes(notes);
	}

	/**
	* Sets the original cost of this eprocurement request.
	*
	* @param originalCost the original cost of this eprocurement request
	*/
	@Override
	public void setOriginalCost(double originalCost) {
		_eprocurementRequest.setOriginalCost(originalCost);
	}

	/**
	* Sets the primary key of this eprocurement request.
	*
	* @param primaryKey the primary key of this eprocurement request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eprocurementRequest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_eprocurementRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project name of this eprocurement request.
	*
	* @param projectName the project name of this eprocurement request
	*/
	@Override
	public void setProjectName(java.lang.String projectName) {
		_eprocurementRequest.setProjectName(projectName);
	}

	/**
	* Sets the project owner ID of this eprocurement request.
	*
	* @param projectOwnerId the project owner ID of this eprocurement request
	*/
	@Override
	public void setProjectOwnerId(long projectOwnerId) {
		_eprocurementRequest.setProjectOwnerId(projectOwnerId);
	}

	/**
	* Sets the purchase order of this eprocurement request.
	*
	* @param purchaseOrder the purchase order of this eprocurement request
	*/
	@Override
	public void setPurchaseOrder(java.lang.String purchaseOrder) {
		_eprocurementRequest.setPurchaseOrder(purchaseOrder);
	}

	/**
	* Sets the reason of this eprocurement request.
	*
	* @param reason the reason of this eprocurement request
	*/
	@Override
	public void setReason(java.lang.String reason) {
		_eprocurementRequest.setReason(reason);
	}

	/**
	* Sets the recieved date of this eprocurement request.
	*
	* @param recievedDate the recieved date of this eprocurement request
	*/
	@Override
	public void setRecievedDate(Date recievedDate) {
		_eprocurementRequest.setRecievedDate(recievedDate);
	}

	/**
	* Sets the request ID of this eprocurement request.
	*
	* @param requestId the request ID of this eprocurement request
	*/
	@Override
	public void setRequestId(long requestId) {
		_eprocurementRequest.setRequestId(requestId);
	}

	/**
	* Sets the requestor ID of this eprocurement request.
	*
	* @param requestorId the requestor ID of this eprocurement request
	*/
	@Override
	public void setRequestorId(long requestorId) {
		_eprocurementRequest.setRequestorId(requestorId);
	}

	/**
	* Sets the returned assets of this eprocurement request.
	*
	* @param returnedAssets the returned assets of this eprocurement request
	*/
	@Override
	public void setReturnedAssets(java.lang.String returnedAssets) {
		_eprocurementRequest.setReturnedAssets(returnedAssets);
	}

	/**
	* Sets the returned date of this eprocurement request.
	*
	* @param returnedDate the returned date of this eprocurement request
	*/
	@Override
	public void setReturnedDate(Date returnedDate) {
		_eprocurementRequest.setReturnedDate(returnedDate);
	}

	/**
	* Sets the ship to other of this eprocurement request.
	*
	* @param shipToOther the ship to other of this eprocurement request
	*/
	@Override
	public void setShipToOther(java.lang.String shipToOther) {
		_eprocurementRequest.setShipToOther(shipToOther);
	}

	/**
	* Sets the spend department of this eprocurement request.
	*
	* @param spendDepartment the spend department of this eprocurement request
	*/
	@Override
	public void setSpendDepartment(java.lang.String spendDepartment) {
		_eprocurementRequest.setSpendDepartment(spendDepartment);
	}

	/**
	* Sets the spend year of this eprocurement request.
	*
	* @param spendYear the spend year of this eprocurement request
	*/
	@Override
	public void setSpendYear(java.lang.String spendYear) {
		_eprocurementRequest.setSpendYear(spendYear);
	}

	/**
	* Sets the stage of this eprocurement request.
	*
	* @param stage the stage of this eprocurement request
	*/
	@Override
	public void setStage(java.lang.String stage) {
		_eprocurementRequest.setStage(stage);
	}

	/**
	* Sets the state of this eprocurement request.
	*
	* @param state the state of this eprocurement request
	*/
	@Override
	public void setState(java.lang.String state) {
		_eprocurementRequest.setState(state);
	}

	/**
	* Sets the status of this eprocurement request.
	*
	* @param status the status of this eprocurement request
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_eprocurementRequest.setStatus(status);
	}

	/**
	* Sets the supervisor ID of this eprocurement request.
	*
	* @param supervisorId the supervisor ID of this eprocurement request
	*/
	@Override
	public void setSupervisorId(long supervisorId) {
		_eprocurementRequest.setSupervisorId(supervisorId);
	}

	/**
	* Sets the total cost of this eprocurement request.
	*
	* @param totalCost the total cost of this eprocurement request
	*/
	@Override
	public void setTotalCost(double totalCost) {
		_eprocurementRequest.setTotalCost(totalCost);
	}

	/**
	* Sets the vendor code of this eprocurement request.
	*
	* @param vendorCode the vendor code of this eprocurement request
	*/
	@Override
	public void setVendorCode(java.lang.String vendorCode) {
		_eprocurementRequest.setVendorCode(vendorCode);
	}

	/**
	* Sets the vendor email of this eprocurement request.
	*
	* @param vendorEmail the vendor email of this eprocurement request
	*/
	@Override
	public void setVendorEmail(java.lang.String vendorEmail) {
		_eprocurementRequest.setVendorEmail(vendorEmail);
	}

	/**
	* Sets the zip of this eprocurement request.
	*
	* @param zip the zip of this eprocurement request
	*/
	@Override
	public void setZip(java.lang.String zip) {
		_eprocurementRequest.setZip(zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementRequestWrapper)) {
			return false;
		}

		EprocurementRequestWrapper eprocurementRequestWrapper = (EprocurementRequestWrapper)obj;

		if (Objects.equals(_eprocurementRequest,
					eprocurementRequestWrapper._eprocurementRequest)) {
			return true;
		}

		return false;
	}

	@Override
	public EprocurementRequest getWrappedModel() {
		return _eprocurementRequest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _eprocurementRequest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _eprocurementRequest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_eprocurementRequest.resetOriginalValues();
	}

	private final EprocurementRequest _eprocurementRequest;
}