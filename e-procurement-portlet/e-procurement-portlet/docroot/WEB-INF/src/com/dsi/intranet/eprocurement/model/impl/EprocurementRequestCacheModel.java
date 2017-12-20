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

package com.dsi.intranet.eprocurement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EprocurementRequest in entity cache.
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequest
 * @generated
 */
@ProviderType
public class EprocurementRequestCacheModel implements CacheModel<EprocurementRequest>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementRequestCacheModel)) {
			return false;
		}

		EprocurementRequestCacheModel eprocurementRequestCacheModel = (EprocurementRequestCacheModel)obj;

		if (requestId == eprocurementRequestCacheModel.requestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{requestId=");
		sb.append(requestId);
		sb.append(", shipToOther=");
		sb.append(shipToOther);
		sb.append(", spendDepartment=");
		sb.append(spendDepartment);
		sb.append(", spendYear=");
		sb.append(spendYear);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", isBudgetedRequest=");
		sb.append(isBudgetedRequest);
		sb.append(", isRelatedtoProject=");
		sb.append(isRelatedtoProject);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", projectOwnerId=");
		sb.append(projectOwnerId);
		sb.append(", totalCost=");
		sb.append(totalCost);
		sb.append(", originalCost=");
		sb.append(originalCost);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", vendorCode=");
		sb.append(vendorCode);
		sb.append(", vendorEmail=");
		sb.append(vendorEmail);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", purchaseOrder=");
		sb.append(purchaseOrder);
		sb.append(", itemInStock=");
		sb.append(itemInStock);
		sb.append(", recievedDate=");
		sb.append(recievedDate);
		sb.append(", returnedDate=");
		sb.append(returnedDate);
		sb.append(", assetInfo=");
		sb.append(assetInfo);
		sb.append(", returnedAssets=");
		sb.append(returnedAssets);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", requestorId=");
		sb.append(requestorId);
		sb.append(", supervisorId=");
		sb.append(supervisorId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", stage=");
		sb.append(stage);
		sb.append(", nextStage=");
		sb.append(nextStage);
		sb.append(", isApproverRole=");
		sb.append(isApproverRole);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EprocurementRequest toEntityModel() {
		EprocurementRequestImpl eprocurementRequestImpl = new EprocurementRequestImpl();

		eprocurementRequestImpl.setRequestId(requestId);

		if (shipToOther == null) {
			eprocurementRequestImpl.setShipToOther(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setShipToOther(shipToOther);
		}

		if (spendDepartment == null) {
			eprocurementRequestImpl.setSpendDepartment(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setSpendDepartment(spendDepartment);
		}

		if (spendYear == null) {
			eprocurementRequestImpl.setSpendYear(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setSpendYear(spendYear);
		}

		if (address == null) {
			eprocurementRequestImpl.setAddress(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setAddress(address);
		}

		if (city == null) {
			eprocurementRequestImpl.setCity(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setCity(city);
		}

		if (state == null) {
			eprocurementRequestImpl.setState(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setState(state);
		}

		if (zip == null) {
			eprocurementRequestImpl.setZip(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setZip(zip);
		}

		if (isBudgetedRequest == null) {
			eprocurementRequestImpl.setIsBudgetedRequest(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setIsBudgetedRequest(isBudgetedRequest);
		}

		if (isRelatedtoProject == null) {
			eprocurementRequestImpl.setIsRelatedtoProject(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setIsRelatedtoProject(isRelatedtoProject);
		}

		if (projectName == null) {
			eprocurementRequestImpl.setProjectName(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setProjectName(projectName);
		}

		eprocurementRequestImpl.setProjectOwnerId(projectOwnerId);
		eprocurementRequestImpl.setTotalCost(totalCost);
		eprocurementRequestImpl.setOriginalCost(originalCost);

		if (reason == null) {
			eprocurementRequestImpl.setReason(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setReason(reason);
		}

		if (notes == null) {
			eprocurementRequestImpl.setNotes(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setNotes(notes);
		}

		if (vendorCode == null) {
			eprocurementRequestImpl.setVendorCode(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setVendorCode(vendorCode);
		}

		if (vendorEmail == null) {
			eprocurementRequestImpl.setVendorEmail(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setVendorEmail(vendorEmail);
		}

		if (contractId == null) {
			eprocurementRequestImpl.setContractId(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setContractId(contractId);
		}

		if (purchaseOrder == null) {
			eprocurementRequestImpl.setPurchaseOrder(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setPurchaseOrder(purchaseOrder);
		}

		eprocurementRequestImpl.setItemInStock(itemInStock);

		if (recievedDate == Long.MIN_VALUE) {
			eprocurementRequestImpl.setRecievedDate(null);
		}
		else {
			eprocurementRequestImpl.setRecievedDate(new Date(recievedDate));
		}

		if (returnedDate == Long.MIN_VALUE) {
			eprocurementRequestImpl.setReturnedDate(null);
		}
		else {
			eprocurementRequestImpl.setReturnedDate(new Date(returnedDate));
		}

		if (assetInfo == null) {
			eprocurementRequestImpl.setAssetInfo(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setAssetInfo(assetInfo);
		}

		if (returnedAssets == null) {
			eprocurementRequestImpl.setReturnedAssets(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setReturnedAssets(returnedAssets);
		}

		eprocurementRequestImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			eprocurementRequestImpl.setCreatedDate(null);
		}
		else {
			eprocurementRequestImpl.setCreatedDate(new Date(createdDate));
		}

		eprocurementRequestImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			eprocurementRequestImpl.setModifiedDate(null);
		}
		else {
			eprocurementRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		eprocurementRequestImpl.setCompanyId(companyId);
		eprocurementRequestImpl.setGroupId(groupId);
		eprocurementRequestImpl.setRequestorId(requestorId);
		eprocurementRequestImpl.setSupervisorId(supervisorId);

		if (status == null) {
			eprocurementRequestImpl.setStatus(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setStatus(status);
		}

		if (stage == null) {
			eprocurementRequestImpl.setStage(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setStage(stage);
		}

		if (nextStage == null) {
			eprocurementRequestImpl.setNextStage(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setNextStage(nextStage);
		}

		if (isApproverRole == null) {
			eprocurementRequestImpl.setIsApproverRole(StringPool.BLANK);
		}
		else {
			eprocurementRequestImpl.setIsApproverRole(isApproverRole);
		}

		eprocurementRequestImpl.resetOriginalValues();

		return eprocurementRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requestId = objectInput.readLong();
		shipToOther = objectInput.readUTF();
		spendDepartment = objectInput.readUTF();
		spendYear = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zip = objectInput.readUTF();
		isBudgetedRequest = objectInput.readUTF();
		isRelatedtoProject = objectInput.readUTF();
		projectName = objectInput.readUTF();

		projectOwnerId = objectInput.readLong();

		totalCost = objectInput.readDouble();

		originalCost = objectInput.readDouble();
		reason = objectInput.readUTF();
		notes = objectInput.readUTF();
		vendorCode = objectInput.readUTF();
		vendorEmail = objectInput.readUTF();
		contractId = objectInput.readUTF();
		purchaseOrder = objectInput.readUTF();

		itemInStock = objectInput.readBoolean();
		recievedDate = objectInput.readLong();
		returnedDate = objectInput.readLong();
		assetInfo = objectInput.readUTF();
		returnedAssets = objectInput.readUTF();

		createdBy = objectInput.readLong();
		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		requestorId = objectInput.readLong();

		supervisorId = objectInput.readLong();
		status = objectInput.readUTF();
		stage = objectInput.readUTF();
		nextStage = objectInput.readUTF();
		isApproverRole = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(requestId);

		if (shipToOther == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shipToOther);
		}

		if (spendDepartment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spendDepartment);
		}

		if (spendYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spendYear);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (isBudgetedRequest == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isBudgetedRequest);
		}

		if (isRelatedtoProject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isRelatedtoProject);
		}

		if (projectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		objectOutput.writeLong(projectOwnerId);

		objectOutput.writeDouble(totalCost);

		objectOutput.writeDouble(originalCost);

		if (reason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (vendorCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vendorCode);
		}

		if (vendorEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vendorEmail);
		}

		if (contractId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractId);
		}

		if (purchaseOrder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(purchaseOrder);
		}

		objectOutput.writeBoolean(itemInStock);
		objectOutput.writeLong(recievedDate);
		objectOutput.writeLong(returnedDate);

		if (assetInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assetInfo);
		}

		if (returnedAssets == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(returnedAssets);
		}

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(requestorId);

		objectOutput.writeLong(supervisorId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (stage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stage);
		}

		if (nextStage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nextStage);
		}

		if (isApproverRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isApproverRole);
		}
	}

	public long requestId;
	public String shipToOther;
	public String spendDepartment;
	public String spendYear;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String isBudgetedRequest;
	public String isRelatedtoProject;
	public String projectName;
	public long projectOwnerId;
	public double totalCost;
	public double originalCost;
	public String reason;
	public String notes;
	public String vendorCode;
	public String vendorEmail;
	public String contractId;
	public String purchaseOrder;
	public boolean itemInStock;
	public long recievedDate;
	public long returnedDate;
	public String assetInfo;
	public String returnedAssets;
	public long createdBy;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long companyId;
	public long groupId;
	public long requestorId;
	public long supervisorId;
	public String status;
	public String stage;
	public String nextStage;
	public String isApproverRole;
}