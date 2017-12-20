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

import com.dsi.intranet.eprocurement.service.ClpSerializer;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class EprocurementRequestClp extends BaseModelImpl<EprocurementRequest>
	implements EprocurementRequest {
	public EprocurementRequestClp() {
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
	public long getPrimaryKey() {
		return _requestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _requestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getRequestId() {
		return _requestId;
	}

	@Override
	public void setRequestId(long requestId) {
		_requestId = requestId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, requestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShipToOther() {
		return _shipToOther;
	}

	@Override
	public void setShipToOther(String shipToOther) {
		_shipToOther = shipToOther;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setShipToOther", String.class);

				method.invoke(_eprocurementRequestRemoteModel, shipToOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpendDepartment() {
		return _spendDepartment;
	}

	@Override
	public void setSpendDepartment(String spendDepartment) {
		_spendDepartment = spendDepartment;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSpendDepartment",
						String.class);

				method.invoke(_eprocurementRequestRemoteModel, spendDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpendYear() {
		return _spendYear;
	}

	@Override
	public void setSpendYear(String spendYear) {
		_spendYear = spendYear;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSpendYear", String.class);

				method.invoke(_eprocurementRequestRemoteModel, spendYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_eprocurementRequestRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_eprocurementRequestRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_eprocurementRequestRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZip() {
		return _zip;
	}

	@Override
	public void setZip(String zip) {
		_zip = zip;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", String.class);

				method.invoke(_eprocurementRequestRemoteModel, zip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsBudgetedRequest() {
		return _isBudgetedRequest;
	}

	@Override
	public void setIsBudgetedRequest(String isBudgetedRequest) {
		_isBudgetedRequest = isBudgetedRequest;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setIsBudgetedRequest",
						String.class);

				method.invoke(_eprocurementRequestRemoteModel, isBudgetedRequest);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsRelatedtoProject() {
		return _isRelatedtoProject;
	}

	@Override
	public void setIsRelatedtoProject(String isRelatedtoProject) {
		_isRelatedtoProject = isRelatedtoProject;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setIsRelatedtoProject",
						String.class);

				method.invoke(_eprocurementRequestRemoteModel,
					isRelatedtoProject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectName() {
		return _projectName;
	}

	@Override
	public void setProjectName(String projectName) {
		_projectName = projectName;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectName", String.class);

				method.invoke(_eprocurementRequestRemoteModel, projectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectOwnerId() {
		return _projectOwnerId;
	}

	@Override
	public void setProjectOwnerId(long projectOwnerId) {
		_projectOwnerId = projectOwnerId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectOwnerId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, projectOwnerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalCost() {
		return _totalCost;
	}

	@Override
	public void setTotalCost(double totalCost) {
		_totalCost = totalCost;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalCost", double.class);

				method.invoke(_eprocurementRequestRemoteModel, totalCost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getOriginalCost() {
		return _originalCost;
	}

	@Override
	public void setOriginalCost(double originalCost) {
		_originalCost = originalCost;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setOriginalCost", double.class);

				method.invoke(_eprocurementRequestRemoteModel, originalCost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReason() {
		return _reason;
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setReason", String.class);

				method.invoke(_eprocurementRequestRemoteModel, reason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_eprocurementRequestRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVendorCode() {
		return _vendorCode;
	}

	@Override
	public void setVendorCode(String vendorCode) {
		_vendorCode = vendorCode;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorCode", String.class);

				method.invoke(_eprocurementRequestRemoteModel, vendorCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVendorEmail() {
		return _vendorEmail;
	}

	@Override
	public void setVendorEmail(String vendorEmail) {
		_vendorEmail = vendorEmail;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorEmail", String.class);

				method.invoke(_eprocurementRequestRemoteModel, vendorEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(String contractId) {
		_contractId = contractId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", String.class);

				method.invoke(_eprocurementRequestRemoteModel, contractId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPurchaseOrder() {
		return _purchaseOrder;
	}

	@Override
	public void setPurchaseOrder(String purchaseOrder) {
		_purchaseOrder = purchaseOrder;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOrder", String.class);

				method.invoke(_eprocurementRequestRemoteModel, purchaseOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getItemInStock() {
		return _itemInStock;
	}

	@Override
	public boolean isItemInStock() {
		return _itemInStock;
	}

	@Override
	public void setItemInStock(boolean itemInStock) {
		_itemInStock = itemInStock;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setItemInStock", boolean.class);

				method.invoke(_eprocurementRequestRemoteModel, itemInStock);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRecievedDate() {
		return _recievedDate;
	}

	@Override
	public void setRecievedDate(Date recievedDate) {
		_recievedDate = recievedDate;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRecievedDate", Date.class);

				method.invoke(_eprocurementRequestRemoteModel, recievedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReturnedDate() {
		return _returnedDate;
	}

	@Override
	public void setReturnedDate(Date returnedDate) {
		_returnedDate = returnedDate;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnedDate", Date.class);

				method.invoke(_eprocurementRequestRemoteModel, returnedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssetInfo() {
		return _assetInfo;
	}

	@Override
	public void setAssetInfo(String assetInfo) {
		_assetInfo = assetInfo;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setAssetInfo", String.class);

				method.invoke(_eprocurementRequestRemoteModel, assetInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReturnedAssets() {
		return _returnedAssets;
	}

	@Override
	public void setReturnedAssets(String returnedAssets) {
		_returnedAssets = returnedAssets;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnedAssets",
						String.class);

				method.invoke(_eprocurementRequestRemoteModel, returnedAssets);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_eprocurementRequestRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_eprocurementRequestRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_eprocurementRequestRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eprocurementRequestRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRequestorId() {
		return _requestorId;
	}

	@Override
	public void setRequestorId(long requestorId) {
		_requestorId = requestorId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestorId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, requestorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSupervisorId() {
		return _supervisorId;
	}

	@Override
	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSupervisorId", long.class);

				method.invoke(_eprocurementRequestRemoteModel, supervisorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_eprocurementRequestRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStage() {
		return _stage;
	}

	@Override
	public void setStage(String stage) {
		_stage = stage;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setStage", String.class);

				method.invoke(_eprocurementRequestRemoteModel, stage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNextStage() {
		return _nextStage;
	}

	@Override
	public void setNextStage(String nextStage) {
		_nextStage = nextStage;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setNextStage", String.class);

				method.invoke(_eprocurementRequestRemoteModel, nextStage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsApproverRole() {
		return _isApproverRole;
	}

	@Override
	public void setIsApproverRole(String isApproverRole) {
		_isApproverRole = isApproverRole;

		if (_eprocurementRequestRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverRole",
						String.class);

				method.invoke(_eprocurementRequestRemoteModel, isApproverRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprocurementRequestRemoteModel() {
		return _eprocurementRequestRemoteModel;
	}

	public void setEprocurementRequestRemoteModel(
		BaseModel<?> eprocurementRequestRemoteModel) {
		_eprocurementRequestRemoteModel = eprocurementRequestRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _eprocurementRequestRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_eprocurementRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			EprocurementRequestLocalServiceUtil.addEprocurementRequest(this);
		}
		else {
			EprocurementRequestLocalServiceUtil.updateEprocurementRequest(this);
		}
	}

	@Override
	public EprocurementRequest toEscapedModel() {
		return (EprocurementRequest)ProxyUtil.newProxyInstance(EprocurementRequest.class.getClassLoader(),
			new Class[] { EprocurementRequest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EprocurementRequestClp clone = new EprocurementRequestClp();

		clone.setRequestId(getRequestId());
		clone.setShipToOther(getShipToOther());
		clone.setSpendDepartment(getSpendDepartment());
		clone.setSpendYear(getSpendYear());
		clone.setAddress(getAddress());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setZip(getZip());
		clone.setIsBudgetedRequest(getIsBudgetedRequest());
		clone.setIsRelatedtoProject(getIsRelatedtoProject());
		clone.setProjectName(getProjectName());
		clone.setProjectOwnerId(getProjectOwnerId());
		clone.setTotalCost(getTotalCost());
		clone.setOriginalCost(getOriginalCost());
		clone.setReason(getReason());
		clone.setNotes(getNotes());
		clone.setVendorCode(getVendorCode());
		clone.setVendorEmail(getVendorEmail());
		clone.setContractId(getContractId());
		clone.setPurchaseOrder(getPurchaseOrder());
		clone.setItemInStock(getItemInStock());
		clone.setRecievedDate(getRecievedDate());
		clone.setReturnedDate(getReturnedDate());
		clone.setAssetInfo(getAssetInfo());
		clone.setReturnedAssets(getReturnedAssets());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setRequestorId(getRequestorId());
		clone.setSupervisorId(getSupervisorId());
		clone.setStatus(getStatus());
		clone.setStage(getStage());
		clone.setNextStage(getNextStage());
		clone.setIsApproverRole(getIsApproverRole());

		return clone;
	}

	@Override
	public int compareTo(EprocurementRequest eprocurementRequest) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				eprocurementRequest.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedDate(),
				eprocurementRequest.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementRequestClp)) {
			return false;
		}

		EprocurementRequestClp eprocurementRequest = (EprocurementRequestClp)obj;

		long primaryKey = eprocurementRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{requestId=");
		sb.append(getRequestId());
		sb.append(", shipToOther=");
		sb.append(getShipToOther());
		sb.append(", spendDepartment=");
		sb.append(getSpendDepartment());
		sb.append(", spendYear=");
		sb.append(getSpendYear());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", isBudgetedRequest=");
		sb.append(getIsBudgetedRequest());
		sb.append(", isRelatedtoProject=");
		sb.append(getIsRelatedtoProject());
		sb.append(", projectName=");
		sb.append(getProjectName());
		sb.append(", projectOwnerId=");
		sb.append(getProjectOwnerId());
		sb.append(", totalCost=");
		sb.append(getTotalCost());
		sb.append(", originalCost=");
		sb.append(getOriginalCost());
		sb.append(", reason=");
		sb.append(getReason());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", vendorCode=");
		sb.append(getVendorCode());
		sb.append(", vendorEmail=");
		sb.append(getVendorEmail());
		sb.append(", contractId=");
		sb.append(getContractId());
		sb.append(", purchaseOrder=");
		sb.append(getPurchaseOrder());
		sb.append(", itemInStock=");
		sb.append(getItemInStock());
		sb.append(", recievedDate=");
		sb.append(getRecievedDate());
		sb.append(", returnedDate=");
		sb.append(getReturnedDate());
		sb.append(", assetInfo=");
		sb.append(getAssetInfo());
		sb.append(", returnedAssets=");
		sb.append(getReturnedAssets());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", requestorId=");
		sb.append(getRequestorId());
		sb.append(", supervisorId=");
		sb.append(getSupervisorId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", stage=");
		sb.append(getStage());
		sb.append(", nextStage=");
		sb.append(getNextStage());
		sb.append(", isApproverRole=");
		sb.append(getIsApproverRole());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.EprocurementRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipToOther</column-name><column-value><![CDATA[");
		sb.append(getShipToOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spendDepartment</column-name><column-value><![CDATA[");
		sb.append(getSpendDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spendYear</column-name><column-value><![CDATA[");
		sb.append(getSpendYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isBudgetedRequest</column-name><column-value><![CDATA[");
		sb.append(getIsBudgetedRequest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRelatedtoProject</column-name><column-value><![CDATA[");
		sb.append(getIsRelatedtoProject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectName</column-name><column-value><![CDATA[");
		sb.append(getProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectOwnerId</column-name><column-value><![CDATA[");
		sb.append(getProjectOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalCost</column-name><column-value><![CDATA[");
		sb.append(getTotalCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalCost</column-name><column-value><![CDATA[");
		sb.append(getOriginalCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorCode</column-name><column-value><![CDATA[");
		sb.append(getVendorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorEmail</column-name><column-value><![CDATA[");
		sb.append(getVendorEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaseOrder</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemInStock</column-name><column-value><![CDATA[");
		sb.append(getItemInStock());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recievedDate</column-name><column-value><![CDATA[");
		sb.append(getRecievedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnedDate</column-name><column-value><![CDATA[");
		sb.append(getReturnedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetInfo</column-name><column-value><![CDATA[");
		sb.append(getAssetInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>returnedAssets</column-name><column-value><![CDATA[");
		sb.append(getReturnedAssets());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestorId</column-name><column-value><![CDATA[");
		sb.append(getRequestorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisorId</column-name><column-value><![CDATA[");
		sb.append(getSupervisorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stage</column-name><column-value><![CDATA[");
		sb.append(getStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextStage</column-name><column-value><![CDATA[");
		sb.append(getNextStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproverRole</column-name><column-value><![CDATA[");
		sb.append(getIsApproverRole());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _eprocurementRequestRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}