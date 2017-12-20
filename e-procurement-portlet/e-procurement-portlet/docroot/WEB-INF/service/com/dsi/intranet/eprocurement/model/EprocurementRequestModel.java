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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EprocurementRequest service. Represents a row in the &quot;eproc_request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequest
 * @see com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl
 * @see com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl
 * @generated
 */
@ProviderType
public interface EprocurementRequestModel extends BaseModel<EprocurementRequest>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a eprocurement request model instance should use the {@link EprocurementRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this eprocurement request.
	 *
	 * @return the primary key of this eprocurement request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this eprocurement request.
	 *
	 * @param primaryKey the primary key of this eprocurement request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the request ID of this eprocurement request.
	 *
	 * @return the request ID of this eprocurement request
	 */
	public long getRequestId();

	/**
	 * Sets the request ID of this eprocurement request.
	 *
	 * @param requestId the request ID of this eprocurement request
	 */
	public void setRequestId(long requestId);

	/**
	 * Returns the ship to other of this eprocurement request.
	 *
	 * @return the ship to other of this eprocurement request
	 */
	@AutoEscape
	public String getShipToOther();

	/**
	 * Sets the ship to other of this eprocurement request.
	 *
	 * @param shipToOther the ship to other of this eprocurement request
	 */
	public void setShipToOther(String shipToOther);

	/**
	 * Returns the spend department of this eprocurement request.
	 *
	 * @return the spend department of this eprocurement request
	 */
	@AutoEscape
	public String getSpendDepartment();

	/**
	 * Sets the spend department of this eprocurement request.
	 *
	 * @param spendDepartment the spend department of this eprocurement request
	 */
	public void setSpendDepartment(String spendDepartment);

	/**
	 * Returns the spend year of this eprocurement request.
	 *
	 * @return the spend year of this eprocurement request
	 */
	@AutoEscape
	public String getSpendYear();

	/**
	 * Sets the spend year of this eprocurement request.
	 *
	 * @param spendYear the spend year of this eprocurement request
	 */
	public void setSpendYear(String spendYear);

	/**
	 * Returns the address of this eprocurement request.
	 *
	 * @return the address of this eprocurement request
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this eprocurement request.
	 *
	 * @param address the address of this eprocurement request
	 */
	public void setAddress(String address);

	/**
	 * Returns the city of this eprocurement request.
	 *
	 * @return the city of this eprocurement request
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this eprocurement request.
	 *
	 * @param city the city of this eprocurement request
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this eprocurement request.
	 *
	 * @return the state of this eprocurement request
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this eprocurement request.
	 *
	 * @param state the state of this eprocurement request
	 */
	public void setState(String state);

	/**
	 * Returns the zip of this eprocurement request.
	 *
	 * @return the zip of this eprocurement request
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this eprocurement request.
	 *
	 * @param zip the zip of this eprocurement request
	 */
	public void setZip(String zip);

	/**
	 * Returns the is budgeted request of this eprocurement request.
	 *
	 * @return the is budgeted request of this eprocurement request
	 */
	@AutoEscape
	public String getIsBudgetedRequest();

	/**
	 * Sets the is budgeted request of this eprocurement request.
	 *
	 * @param isBudgetedRequest the is budgeted request of this eprocurement request
	 */
	public void setIsBudgetedRequest(String isBudgetedRequest);

	/**
	 * Returns the is relatedto project of this eprocurement request.
	 *
	 * @return the is relatedto project of this eprocurement request
	 */
	@AutoEscape
	public String getIsRelatedtoProject();

	/**
	 * Sets the is relatedto project of this eprocurement request.
	 *
	 * @param isRelatedtoProject the is relatedto project of this eprocurement request
	 */
	public void setIsRelatedtoProject(String isRelatedtoProject);

	/**
	 * Returns the project name of this eprocurement request.
	 *
	 * @return the project name of this eprocurement request
	 */
	@AutoEscape
	public String getProjectName();

	/**
	 * Sets the project name of this eprocurement request.
	 *
	 * @param projectName the project name of this eprocurement request
	 */
	public void setProjectName(String projectName);

	/**
	 * Returns the project owner ID of this eprocurement request.
	 *
	 * @return the project owner ID of this eprocurement request
	 */
	public long getProjectOwnerId();

	/**
	 * Sets the project owner ID of this eprocurement request.
	 *
	 * @param projectOwnerId the project owner ID of this eprocurement request
	 */
	public void setProjectOwnerId(long projectOwnerId);

	/**
	 * Returns the total cost of this eprocurement request.
	 *
	 * @return the total cost of this eprocurement request
	 */
	public double getTotalCost();

	/**
	 * Sets the total cost of this eprocurement request.
	 *
	 * @param totalCost the total cost of this eprocurement request
	 */
	public void setTotalCost(double totalCost);

	/**
	 * Returns the original cost of this eprocurement request.
	 *
	 * @return the original cost of this eprocurement request
	 */
	public double getOriginalCost();

	/**
	 * Sets the original cost of this eprocurement request.
	 *
	 * @param originalCost the original cost of this eprocurement request
	 */
	public void setOriginalCost(double originalCost);

	/**
	 * Returns the reason of this eprocurement request.
	 *
	 * @return the reason of this eprocurement request
	 */
	@AutoEscape
	public String getReason();

	/**
	 * Sets the reason of this eprocurement request.
	 *
	 * @param reason the reason of this eprocurement request
	 */
	public void setReason(String reason);

	/**
	 * Returns the notes of this eprocurement request.
	 *
	 * @return the notes of this eprocurement request
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this eprocurement request.
	 *
	 * @param notes the notes of this eprocurement request
	 */
	public void setNotes(String notes);

	/**
	 * Returns the vendor code of this eprocurement request.
	 *
	 * @return the vendor code of this eprocurement request
	 */
	@AutoEscape
	public String getVendorCode();

	/**
	 * Sets the vendor code of this eprocurement request.
	 *
	 * @param vendorCode the vendor code of this eprocurement request
	 */
	public void setVendorCode(String vendorCode);

	/**
	 * Returns the vendor email of this eprocurement request.
	 *
	 * @return the vendor email of this eprocurement request
	 */
	@AutoEscape
	public String getVendorEmail();

	/**
	 * Sets the vendor email of this eprocurement request.
	 *
	 * @param vendorEmail the vendor email of this eprocurement request
	 */
	public void setVendorEmail(String vendorEmail);

	/**
	 * Returns the contract ID of this eprocurement request.
	 *
	 * @return the contract ID of this eprocurement request
	 */
	@AutoEscape
	public String getContractId();

	/**
	 * Sets the contract ID of this eprocurement request.
	 *
	 * @param contractId the contract ID of this eprocurement request
	 */
	public void setContractId(String contractId);

	/**
	 * Returns the purchase order of this eprocurement request.
	 *
	 * @return the purchase order of this eprocurement request
	 */
	@AutoEscape
	public String getPurchaseOrder();

	/**
	 * Sets the purchase order of this eprocurement request.
	 *
	 * @param purchaseOrder the purchase order of this eprocurement request
	 */
	public void setPurchaseOrder(String purchaseOrder);

	/**
	 * Returns the item in stock of this eprocurement request.
	 *
	 * @return the item in stock of this eprocurement request
	 */
	public boolean getItemInStock();

	/**
	 * Returns <code>true</code> if this eprocurement request is item in stock.
	 *
	 * @return <code>true</code> if this eprocurement request is item in stock; <code>false</code> otherwise
	 */
	public boolean isItemInStock();

	/**
	 * Sets whether this eprocurement request is item in stock.
	 *
	 * @param itemInStock the item in stock of this eprocurement request
	 */
	public void setItemInStock(boolean itemInStock);

	/**
	 * Returns the recieved date of this eprocurement request.
	 *
	 * @return the recieved date of this eprocurement request
	 */
	public Date getRecievedDate();

	/**
	 * Sets the recieved date of this eprocurement request.
	 *
	 * @param recievedDate the recieved date of this eprocurement request
	 */
	public void setRecievedDate(Date recievedDate);

	/**
	 * Returns the returned date of this eprocurement request.
	 *
	 * @return the returned date of this eprocurement request
	 */
	public Date getReturnedDate();

	/**
	 * Sets the returned date of this eprocurement request.
	 *
	 * @param returnedDate the returned date of this eprocurement request
	 */
	public void setReturnedDate(Date returnedDate);

	/**
	 * Returns the asset info of this eprocurement request.
	 *
	 * @return the asset info of this eprocurement request
	 */
	@AutoEscape
	public String getAssetInfo();

	/**
	 * Sets the asset info of this eprocurement request.
	 *
	 * @param assetInfo the asset info of this eprocurement request
	 */
	public void setAssetInfo(String assetInfo);

	/**
	 * Returns the returned assets of this eprocurement request.
	 *
	 * @return the returned assets of this eprocurement request
	 */
	@AutoEscape
	public String getReturnedAssets();

	/**
	 * Sets the returned assets of this eprocurement request.
	 *
	 * @param returnedAssets the returned assets of this eprocurement request
	 */
	public void setReturnedAssets(String returnedAssets);

	/**
	 * Returns the created by of this eprocurement request.
	 *
	 * @return the created by of this eprocurement request
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this eprocurement request.
	 *
	 * @param createdBy the created by of this eprocurement request
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created date of this eprocurement request.
	 *
	 * @return the created date of this eprocurement request
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this eprocurement request.
	 *
	 * @param createdDate the created date of this eprocurement request
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this eprocurement request.
	 *
	 * @return the modified by of this eprocurement request
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this eprocurement request.
	 *
	 * @param modifiedBy the modified by of this eprocurement request
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this eprocurement request.
	 *
	 * @return the modified date of this eprocurement request
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this eprocurement request.
	 *
	 * @param modifiedDate the modified date of this eprocurement request
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the company ID of this eprocurement request.
	 *
	 * @return the company ID of this eprocurement request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this eprocurement request.
	 *
	 * @param companyId the company ID of this eprocurement request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this eprocurement request.
	 *
	 * @return the group ID of this eprocurement request
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this eprocurement request.
	 *
	 * @param groupId the group ID of this eprocurement request
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the requestor ID of this eprocurement request.
	 *
	 * @return the requestor ID of this eprocurement request
	 */
	public long getRequestorId();

	/**
	 * Sets the requestor ID of this eprocurement request.
	 *
	 * @param requestorId the requestor ID of this eprocurement request
	 */
	public void setRequestorId(long requestorId);

	/**
	 * Returns the supervisor ID of this eprocurement request.
	 *
	 * @return the supervisor ID of this eprocurement request
	 */
	public long getSupervisorId();

	/**
	 * Sets the supervisor ID of this eprocurement request.
	 *
	 * @param supervisorId the supervisor ID of this eprocurement request
	 */
	public void setSupervisorId(long supervisorId);

	/**
	 * Returns the status of this eprocurement request.
	 *
	 * @return the status of this eprocurement request
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this eprocurement request.
	 *
	 * @param status the status of this eprocurement request
	 */
	public void setStatus(String status);

	/**
	 * Returns the stage of this eprocurement request.
	 *
	 * @return the stage of this eprocurement request
	 */
	@AutoEscape
	public String getStage();

	/**
	 * Sets the stage of this eprocurement request.
	 *
	 * @param stage the stage of this eprocurement request
	 */
	public void setStage(String stage);

	/**
	 * Returns the next stage of this eprocurement request.
	 *
	 * @return the next stage of this eprocurement request
	 */
	@AutoEscape
	public String getNextStage();

	/**
	 * Sets the next stage of this eprocurement request.
	 *
	 * @param nextStage the next stage of this eprocurement request
	 */
	public void setNextStage(String nextStage);

	/**
	 * Returns the is approver role of this eprocurement request.
	 *
	 * @return the is approver role of this eprocurement request
	 */
	@AutoEscape
	public String getIsApproverRole();

	/**
	 * Sets the is approver role of this eprocurement request.
	 *
	 * @param isApproverRole the is approver role of this eprocurement request
	 */
	public void setIsApproverRole(String isApproverRole);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(EprocurementRequest eprocurementRequest);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EprocurementRequest> toCacheModel();

	@Override
	public EprocurementRequest toEscapedModel();

	@Override
	public EprocurementRequest toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}