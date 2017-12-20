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
 * This class is a wrapper for {@link Item}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see Item
 * @generated
 */
@ProviderType
public class ItemWrapper implements Item, ModelWrapper<Item> {
	public ItemWrapper(Item item) {
		_item = item;
	}

	@Override
	public Class<?> getModelClass() {
		return Item.class;
	}

	@Override
	public String getModelClassName() {
		return Item.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("itemName", getItemName());
		attributes.put("itemDescription", getItemDescription());
		attributes.put("quantity", getQuantity());
		attributes.put("cost", getCost());
		attributes.put("originalCost", getOriginalCost());
		attributes.put("wbselement", getWbselement());
		attributes.put("glAccNo", getGlAccNo());
		attributes.put("costCenter", getCostCenter());
		attributes.put("requestId", getRequestId());
		attributes.put("itemInStock", getItemInStock());
		attributes.put("vendorCode", getVendorCode());
		attributes.put("purchaseOrder", getPurchaseOrder());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		String itemName = (String)attributes.get("itemName");

		if (itemName != null) {
			setItemName(itemName);
		}

		String itemDescription = (String)attributes.get("itemDescription");

		if (itemDescription != null) {
			setItemDescription(itemDescription);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Double originalCost = (Double)attributes.get("originalCost");

		if (originalCost != null) {
			setOriginalCost(originalCost);
		}

		String wbselement = (String)attributes.get("wbselement");

		if (wbselement != null) {
			setWbselement(wbselement);
		}

		String glAccNo = (String)attributes.get("glAccNo");

		if (glAccNo != null) {
			setGlAccNo(glAccNo);
		}

		String costCenter = (String)attributes.get("costCenter");

		if (costCenter != null) {
			setCostCenter(costCenter);
		}

		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		Boolean itemInStock = (Boolean)attributes.get("itemInStock");

		if (itemInStock != null) {
			setItemInStock(itemInStock);
		}

		String vendorCode = (String)attributes.get("vendorCode");

		if (vendorCode != null) {
			setVendorCode(vendorCode);
		}

		String purchaseOrder = (String)attributes.get("purchaseOrder");

		if (purchaseOrder != null) {
			setPurchaseOrder(purchaseOrder);
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
	}

	@Override
	public Item toEscapedModel() {
		return new ItemWrapper(_item.toEscapedModel());
	}

	@Override
	public Item toUnescapedModel() {
		return new ItemWrapper(_item.toUnescapedModel());
	}

	/**
	* Returns the item in stock of this item.
	*
	* @return the item in stock of this item
	*/
	@Override
	public boolean getItemInStock() {
		return _item.getItemInStock();
	}

	@Override
	public boolean isCachedModel() {
		return _item.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _item.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this item is item in stock.
	*
	* @return <code>true</code> if this item is item in stock; <code>false</code> otherwise
	*/
	@Override
	public boolean isItemInStock() {
		return _item.isItemInStock();
	}

	@Override
	public boolean isNew() {
		return _item.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _item.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Item> toCacheModel() {
		return _item.toCacheModel();
	}

	/**
	* Returns the cost of this item.
	*
	* @return the cost of this item
	*/
	@Override
	public double getCost() {
		return _item.getCost();
	}

	/**
	* Returns the original cost of this item.
	*
	* @return the original cost of this item
	*/
	@Override
	public double getOriginalCost() {
		return _item.getOriginalCost();
	}

	@Override
	public int compareTo(Item item) {
		return _item.compareTo(item);
	}

	@Override
	public int hashCode() {
		return _item.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _item.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ItemWrapper((Item)_item.clone());
	}

	/**
	* Returns the asset info of this item.
	*
	* @return the asset info of this item
	*/
	@Override
	public java.lang.String getAssetInfo() {
		return _item.getAssetInfo();
	}

	/**
	* Returns the cost center of this item.
	*
	* @return the cost center of this item
	*/
	@Override
	public java.lang.String getCostCenter() {
		return _item.getCostCenter();
	}

	/**
	* Returns the gl acc no of this item.
	*
	* @return the gl acc no of this item
	*/
	@Override
	public java.lang.String getGlAccNo() {
		return _item.getGlAccNo();
	}

	/**
	* Returns the item description of this item.
	*
	* @return the item description of this item
	*/
	@Override
	public java.lang.String getItemDescription() {
		return _item.getItemDescription();
	}

	/**
	* Returns the item name of this item.
	*
	* @return the item name of this item
	*/
	@Override
	public java.lang.String getItemName() {
		return _item.getItemName();
	}

	/**
	* Returns the purchase order of this item.
	*
	* @return the purchase order of this item
	*/
	@Override
	public java.lang.String getPurchaseOrder() {
		return _item.getPurchaseOrder();
	}

	/**
	* Returns the returned assets of this item.
	*
	* @return the returned assets of this item
	*/
	@Override
	public java.lang.String getReturnedAssets() {
		return _item.getReturnedAssets();
	}

	/**
	* Returns the vendor code of this item.
	*
	* @return the vendor code of this item
	*/
	@Override
	public java.lang.String getVendorCode() {
		return _item.getVendorCode();
	}

	/**
	* Returns the wbselement of this item.
	*
	* @return the wbselement of this item
	*/
	@Override
	public java.lang.String getWbselement() {
		return _item.getWbselement();
	}

	@Override
	public java.lang.String toString() {
		return _item.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _item.toXmlString();
	}

	/**
	* Returns the created date of this item.
	*
	* @return the created date of this item
	*/
	@Override
	public Date getCreatedDate() {
		return _item.getCreatedDate();
	}

	/**
	* Returns the modified date of this item.
	*
	* @return the modified date of this item
	*/
	@Override
	public Date getModifiedDate() {
		return _item.getModifiedDate();
	}

	/**
	* Returns the recieved date of this item.
	*
	* @return the recieved date of this item
	*/
	@Override
	public Date getRecievedDate() {
		return _item.getRecievedDate();
	}

	/**
	* Returns the returned date of this item.
	*
	* @return the returned date of this item
	*/
	@Override
	public Date getReturnedDate() {
		return _item.getReturnedDate();
	}

	/**
	* Returns the company ID of this item.
	*
	* @return the company ID of this item
	*/
	@Override
	public long getCompanyId() {
		return _item.getCompanyId();
	}

	/**
	* Returns the created by of this item.
	*
	* @return the created by of this item
	*/
	@Override
	public long getCreatedBy() {
		return _item.getCreatedBy();
	}

	/**
	* Returns the group ID of this item.
	*
	* @return the group ID of this item
	*/
	@Override
	public long getGroupId() {
		return _item.getGroupId();
	}

	/**
	* Returns the item ID of this item.
	*
	* @return the item ID of this item
	*/
	@Override
	public long getItemId() {
		return _item.getItemId();
	}

	/**
	* Returns the modified by of this item.
	*
	* @return the modified by of this item
	*/
	@Override
	public long getModifiedBy() {
		return _item.getModifiedBy();
	}

	/**
	* Returns the primary key of this item.
	*
	* @return the primary key of this item
	*/
	@Override
	public long getPrimaryKey() {
		return _item.getPrimaryKey();
	}

	/**
	* Returns the quantity of this item.
	*
	* @return the quantity of this item
	*/
	@Override
	public long getQuantity() {
		return _item.getQuantity();
	}

	/**
	* Returns the request ID of this item.
	*
	* @return the request ID of this item
	*/
	@Override
	public long getRequestId() {
		return _item.getRequestId();
	}

	@Override
	public void persist() {
		_item.persist();
	}

	/**
	* Sets the asset info of this item.
	*
	* @param assetInfo the asset info of this item
	*/
	@Override
	public void setAssetInfo(java.lang.String assetInfo) {
		_item.setAssetInfo(assetInfo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_item.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this item.
	*
	* @param companyId the company ID of this item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_item.setCompanyId(companyId);
	}

	/**
	* Sets the cost of this item.
	*
	* @param cost the cost of this item
	*/
	@Override
	public void setCost(double cost) {
		_item.setCost(cost);
	}

	/**
	* Sets the cost center of this item.
	*
	* @param costCenter the cost center of this item
	*/
	@Override
	public void setCostCenter(java.lang.String costCenter) {
		_item.setCostCenter(costCenter);
	}

	/**
	* Sets the created by of this item.
	*
	* @param createdBy the created by of this item
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_item.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this item.
	*
	* @param createdDate the created date of this item
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_item.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_item.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_item.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_item.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gl acc no of this item.
	*
	* @param glAccNo the gl acc no of this item
	*/
	@Override
	public void setGlAccNo(java.lang.String glAccNo) {
		_item.setGlAccNo(glAccNo);
	}

	/**
	* Sets the group ID of this item.
	*
	* @param groupId the group ID of this item
	*/
	@Override
	public void setGroupId(long groupId) {
		_item.setGroupId(groupId);
	}

	/**
	* Sets the item description of this item.
	*
	* @param itemDescription the item description of this item
	*/
	@Override
	public void setItemDescription(java.lang.String itemDescription) {
		_item.setItemDescription(itemDescription);
	}

	/**
	* Sets the item ID of this item.
	*
	* @param itemId the item ID of this item
	*/
	@Override
	public void setItemId(long itemId) {
		_item.setItemId(itemId);
	}

	/**
	* Sets whether this item is item in stock.
	*
	* @param itemInStock the item in stock of this item
	*/
	@Override
	public void setItemInStock(boolean itemInStock) {
		_item.setItemInStock(itemInStock);
	}

	/**
	* Sets the item name of this item.
	*
	* @param itemName the item name of this item
	*/
	@Override
	public void setItemName(java.lang.String itemName) {
		_item.setItemName(itemName);
	}

	/**
	* Sets the modified by of this item.
	*
	* @param modifiedBy the modified by of this item
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_item.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this item.
	*
	* @param modifiedDate the modified date of this item
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_item.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_item.setNew(n);
	}

	/**
	* Sets the original cost of this item.
	*
	* @param originalCost the original cost of this item
	*/
	@Override
	public void setOriginalCost(double originalCost) {
		_item.setOriginalCost(originalCost);
	}

	/**
	* Sets the primary key of this item.
	*
	* @param primaryKey the primary key of this item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_item.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_item.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the purchase order of this item.
	*
	* @param purchaseOrder the purchase order of this item
	*/
	@Override
	public void setPurchaseOrder(java.lang.String purchaseOrder) {
		_item.setPurchaseOrder(purchaseOrder);
	}

	/**
	* Sets the quantity of this item.
	*
	* @param quantity the quantity of this item
	*/
	@Override
	public void setQuantity(long quantity) {
		_item.setQuantity(quantity);
	}

	/**
	* Sets the recieved date of this item.
	*
	* @param recievedDate the recieved date of this item
	*/
	@Override
	public void setRecievedDate(Date recievedDate) {
		_item.setRecievedDate(recievedDate);
	}

	/**
	* Sets the request ID of this item.
	*
	* @param requestId the request ID of this item
	*/
	@Override
	public void setRequestId(long requestId) {
		_item.setRequestId(requestId);
	}

	/**
	* Sets the returned assets of this item.
	*
	* @param returnedAssets the returned assets of this item
	*/
	@Override
	public void setReturnedAssets(java.lang.String returnedAssets) {
		_item.setReturnedAssets(returnedAssets);
	}

	/**
	* Sets the returned date of this item.
	*
	* @param returnedDate the returned date of this item
	*/
	@Override
	public void setReturnedDate(Date returnedDate) {
		_item.setReturnedDate(returnedDate);
	}

	/**
	* Sets the vendor code of this item.
	*
	* @param vendorCode the vendor code of this item
	*/
	@Override
	public void setVendorCode(java.lang.String vendorCode) {
		_item.setVendorCode(vendorCode);
	}

	/**
	* Sets the wbselement of this item.
	*
	* @param wbselement the wbselement of this item
	*/
	@Override
	public void setWbselement(java.lang.String wbselement) {
		_item.setWbselement(wbselement);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemWrapper)) {
			return false;
		}

		ItemWrapper itemWrapper = (ItemWrapper)obj;

		if (Objects.equals(_item, itemWrapper._item)) {
			return true;
		}

		return false;
	}

	@Override
	public Item getWrappedModel() {
		return _item;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _item.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _item.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_item.resetOriginalValues();
	}

	private final Item _item;
}