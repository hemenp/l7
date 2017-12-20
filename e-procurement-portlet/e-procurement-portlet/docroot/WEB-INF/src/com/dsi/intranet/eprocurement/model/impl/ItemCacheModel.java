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

import com.dsi.intranet.eprocurement.model.Item;

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
 * The cache model class for representing Item in entity cache.
 *
 * @author CIGNEX Technologies
 * @see Item
 * @generated
 */
@ProviderType
public class ItemCacheModel implements CacheModel<Item>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemCacheModel)) {
			return false;
		}

		ItemCacheModel itemCacheModel = (ItemCacheModel)obj;

		if (itemId == itemCacheModel.itemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, itemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", itemName=");
		sb.append(itemName);
		sb.append(", itemDescription=");
		sb.append(itemDescription);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", originalCost=");
		sb.append(originalCost);
		sb.append(", wbselement=");
		sb.append(wbselement);
		sb.append(", glAccNo=");
		sb.append(glAccNo);
		sb.append(", costCenter=");
		sb.append(costCenter);
		sb.append(", requestId=");
		sb.append(requestId);
		sb.append(", itemInStock=");
		sb.append(itemInStock);
		sb.append(", vendorCode=");
		sb.append(vendorCode);
		sb.append(", purchaseOrder=");
		sb.append(purchaseOrder);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Item toEntityModel() {
		ItemImpl itemImpl = new ItemImpl();

		itemImpl.setItemId(itemId);

		if (itemName == null) {
			itemImpl.setItemName(StringPool.BLANK);
		}
		else {
			itemImpl.setItemName(itemName);
		}

		if (itemDescription == null) {
			itemImpl.setItemDescription(StringPool.BLANK);
		}
		else {
			itemImpl.setItemDescription(itemDescription);
		}

		itemImpl.setQuantity(quantity);
		itemImpl.setCost(cost);
		itemImpl.setOriginalCost(originalCost);

		if (wbselement == null) {
			itemImpl.setWbselement(StringPool.BLANK);
		}
		else {
			itemImpl.setWbselement(wbselement);
		}

		if (glAccNo == null) {
			itemImpl.setGlAccNo(StringPool.BLANK);
		}
		else {
			itemImpl.setGlAccNo(glAccNo);
		}

		if (costCenter == null) {
			itemImpl.setCostCenter(StringPool.BLANK);
		}
		else {
			itemImpl.setCostCenter(costCenter);
		}

		itemImpl.setRequestId(requestId);
		itemImpl.setItemInStock(itemInStock);

		if (vendorCode == null) {
			itemImpl.setVendorCode(StringPool.BLANK);
		}
		else {
			itemImpl.setVendorCode(vendorCode);
		}

		if (purchaseOrder == null) {
			itemImpl.setPurchaseOrder(StringPool.BLANK);
		}
		else {
			itemImpl.setPurchaseOrder(purchaseOrder);
		}

		if (recievedDate == Long.MIN_VALUE) {
			itemImpl.setRecievedDate(null);
		}
		else {
			itemImpl.setRecievedDate(new Date(recievedDate));
		}

		if (returnedDate == Long.MIN_VALUE) {
			itemImpl.setReturnedDate(null);
		}
		else {
			itemImpl.setReturnedDate(new Date(returnedDate));
		}

		if (assetInfo == null) {
			itemImpl.setAssetInfo(StringPool.BLANK);
		}
		else {
			itemImpl.setAssetInfo(assetInfo);
		}

		if (returnedAssets == null) {
			itemImpl.setReturnedAssets(StringPool.BLANK);
		}
		else {
			itemImpl.setReturnedAssets(returnedAssets);
		}

		itemImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			itemImpl.setCreatedDate(null);
		}
		else {
			itemImpl.setCreatedDate(new Date(createdDate));
		}

		itemImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			itemImpl.setModifiedDate(null);
		}
		else {
			itemImpl.setModifiedDate(new Date(modifiedDate));
		}

		itemImpl.setCompanyId(companyId);
		itemImpl.setGroupId(groupId);

		itemImpl.resetOriginalValues();

		return itemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		itemName = objectInput.readUTF();
		itemDescription = objectInput.readUTF();

		quantity = objectInput.readLong();

		cost = objectInput.readDouble();

		originalCost = objectInput.readDouble();
		wbselement = objectInput.readUTF();
		glAccNo = objectInput.readUTF();
		costCenter = objectInput.readUTF();

		requestId = objectInput.readLong();

		itemInStock = objectInput.readBoolean();
		vendorCode = objectInput.readUTF();
		purchaseOrder = objectInput.readUTF();
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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);

		if (itemName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemName);
		}

		if (itemDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemDescription);
		}

		objectOutput.writeLong(quantity);

		objectOutput.writeDouble(cost);

		objectOutput.writeDouble(originalCost);

		if (wbselement == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wbselement);
		}

		if (glAccNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glAccNo);
		}

		if (costCenter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCenter);
		}

		objectOutput.writeLong(requestId);

		objectOutput.writeBoolean(itemInStock);

		if (vendorCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vendorCode);
		}

		if (purchaseOrder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(purchaseOrder);
		}

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
	}

	public long itemId;
	public String itemName;
	public String itemDescription;
	public long quantity;
	public double cost;
	public double originalCost;
	public String wbselement;
	public String glAccNo;
	public String costCenter;
	public long requestId;
	public boolean itemInStock;
	public String vendorCode;
	public String purchaseOrder;
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
}