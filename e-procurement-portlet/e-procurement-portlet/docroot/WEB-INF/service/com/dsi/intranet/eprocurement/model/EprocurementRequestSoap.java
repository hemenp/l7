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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dsi.intranet.eprocurement.service.http.EprocurementRequestServiceSoap}.
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.http.EprocurementRequestServiceSoap
 * @generated
 */
@ProviderType
public class EprocurementRequestSoap implements Serializable {
	public static EprocurementRequestSoap toSoapModel(EprocurementRequest model) {
		EprocurementRequestSoap soapModel = new EprocurementRequestSoap();

		soapModel.setRequestId(model.getRequestId());
		soapModel.setShipToOther(model.getShipToOther());
		soapModel.setSpendDepartment(model.getSpendDepartment());
		soapModel.setSpendYear(model.getSpendYear());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZip(model.getZip());
		soapModel.setIsBudgetedRequest(model.getIsBudgetedRequest());
		soapModel.setIsRelatedtoProject(model.getIsRelatedtoProject());
		soapModel.setProjectName(model.getProjectName());
		soapModel.setProjectOwnerId(model.getProjectOwnerId());
		soapModel.setTotalCost(model.getTotalCost());
		soapModel.setOriginalCost(model.getOriginalCost());
		soapModel.setReason(model.getReason());
		soapModel.setNotes(model.getNotes());
		soapModel.setVendorCode(model.getVendorCode());
		soapModel.setVendorEmail(model.getVendorEmail());
		soapModel.setContractId(model.getContractId());
		soapModel.setPurchaseOrder(model.getPurchaseOrder());
		soapModel.setItemInStock(model.getItemInStock());
		soapModel.setRecievedDate(model.getRecievedDate());
		soapModel.setReturnedDate(model.getReturnedDate());
		soapModel.setAssetInfo(model.getAssetInfo());
		soapModel.setReturnedAssets(model.getReturnedAssets());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRequestorId(model.getRequestorId());
		soapModel.setSupervisorId(model.getSupervisorId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStage(model.getStage());
		soapModel.setNextStage(model.getNextStage());
		soapModel.setIsApproverRole(model.getIsApproverRole());

		return soapModel;
	}

	public static EprocurementRequestSoap[] toSoapModels(
		EprocurementRequest[] models) {
		EprocurementRequestSoap[] soapModels = new EprocurementRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprocurementRequestSoap[][] toSoapModels(
		EprocurementRequest[][] models) {
		EprocurementRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprocurementRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprocurementRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprocurementRequestSoap[] toSoapModels(
		List<EprocurementRequest> models) {
		List<EprocurementRequestSoap> soapModels = new ArrayList<EprocurementRequestSoap>(models.size());

		for (EprocurementRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprocurementRequestSoap[soapModels.size()]);
	}

	public EprocurementRequestSoap() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public String getShipToOther() {
		return _shipToOther;
	}

	public void setShipToOther(String shipToOther) {
		_shipToOther = shipToOther;
	}

	public String getSpendDepartment() {
		return _spendDepartment;
	}

	public void setSpendDepartment(String spendDepartment) {
		_spendDepartment = spendDepartment;
	}

	public String getSpendYear() {
		return _spendYear;
	}

	public void setSpendYear(String spendYear) {
		_spendYear = spendYear;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getIsBudgetedRequest() {
		return _isBudgetedRequest;
	}

	public void setIsBudgetedRequest(String isBudgetedRequest) {
		_isBudgetedRequest = isBudgetedRequest;
	}

	public String getIsRelatedtoProject() {
		return _isRelatedtoProject;
	}

	public void setIsRelatedtoProject(String isRelatedtoProject) {
		_isRelatedtoProject = isRelatedtoProject;
	}

	public String getProjectName() {
		return _projectName;
	}

	public void setProjectName(String projectName) {
		_projectName = projectName;
	}

	public long getProjectOwnerId() {
		return _projectOwnerId;
	}

	public void setProjectOwnerId(long projectOwnerId) {
		_projectOwnerId = projectOwnerId;
	}

	public double getTotalCost() {
		return _totalCost;
	}

	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;
	}

	public double getOriginalCost() {
		return _originalCost;
	}

	public void setOriginalCost(double originalCost) {
		_originalCost = originalCost;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public String getVendorCode() {
		return _vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		_vendorCode = vendorCode;
	}

	public String getVendorEmail() {
		return _vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		_vendorEmail = vendorEmail;
	}

	public String getContractId() {
		return _contractId;
	}

	public void setContractId(String contractId) {
		_contractId = contractId;
	}

	public String getPurchaseOrder() {
		return _purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		_purchaseOrder = purchaseOrder;
	}

	public boolean getItemInStock() {
		return _itemInStock;
	}

	public boolean isItemInStock() {
		return _itemInStock;
	}

	public void setItemInStock(boolean itemInStock) {
		_itemInStock = itemInStock;
	}

	public Date getRecievedDate() {
		return _recievedDate;
	}

	public void setRecievedDate(Date recievedDate) {
		_recievedDate = recievedDate;
	}

	public Date getReturnedDate() {
		return _returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		_returnedDate = returnedDate;
	}

	public String getAssetInfo() {
		return _assetInfo;
	}

	public void setAssetInfo(String assetInfo) {
		_assetInfo = assetInfo;
	}

	public String getReturnedAssets() {
		return _returnedAssets;
	}

	public void setReturnedAssets(String returnedAssets) {
		_returnedAssets = returnedAssets;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getRequestorId() {
		return _requestorId;
	}

	public void setRequestorId(long requestorId) {
		_requestorId = requestorId;
	}

	public long getSupervisorId() {
		return _supervisorId;
	}

	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getStage() {
		return _stage;
	}

	public void setStage(String stage) {
		_stage = stage;
	}

	public String getNextStage() {
		return _nextStage;
	}

	public void setNextStage(String nextStage) {
		_nextStage = nextStage;
	}

	public String getIsApproverRole() {
		return _isApproverRole;
	}

	public void setIsApproverRole(String isApproverRole) {
		_isApproverRole = isApproverRole;
	}

	private long _requestId;
	private String _shipToOther;
	private String _spendDepartment;
	private String _spendYear;
	private String _address;
	private String _city;
	private String _state;
	private String _zip;
	private String _isBudgetedRequest;
	private String _isRelatedtoProject;
	private String _projectName;
	private long _projectOwnerId;
	private double _totalCost;
	private double _originalCost;
	private String _reason;
	private String _notes;
	private String _vendorCode;
	private String _vendorEmail;
	private String _contractId;
	private String _purchaseOrder;
	private boolean _itemInStock;
	private Date _recievedDate;
	private Date _returnedDate;
	private String _assetInfo;
	private String _returnedAssets;
	private long _createdBy;
	private Date _createdDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private long _companyId;
	private long _groupId;
	private long _requestorId;
	private long _supervisorId;
	private String _status;
	private String _stage;
	private String _nextStage;
	private String _isApproverRole;
}