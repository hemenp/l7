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
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
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
public class ItemClp extends BaseModelImpl<Item> implements Item {
	public ItemClp() {
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
	public long getPrimaryKey() {
		return _itemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_itemRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemName() {
		return _itemName;
	}

	@Override
	public void setItemName(String itemName) {
		_itemName = itemName;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemName", String.class);

				method.invoke(_itemRemoteModel, itemName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemDescription() {
		return _itemDescription;
	}

	@Override
	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemDescription",
						String.class);

				method.invoke(_itemRemoteModel, itemDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(long quantity) {
		_quantity = quantity;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", long.class);

				method.invoke(_itemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_itemRemoteModel, cost);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setOriginalCost", double.class);

				method.invoke(_itemRemoteModel, originalCost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWbselement() {
		return _wbselement;
	}

	@Override
	public void setWbselement(String wbselement) {
		_wbselement = wbselement;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setWbselement", String.class);

				method.invoke(_itemRemoteModel, wbselement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlAccNo() {
		return _glAccNo;
	}

	@Override
	public void setGlAccNo(String glAccNo) {
		_glAccNo = glAccNo;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setGlAccNo", String.class);

				method.invoke(_itemRemoteModel, glAccNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCostCenter() {
		return _costCenter;
	}

	@Override
	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setCostCenter", String.class);

				method.invoke(_itemRemoteModel, costCenter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRequestId() {
		return _requestId;
	}

	@Override
	public void setRequestId(long requestId) {
		_requestId = requestId;

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestId", long.class);

				method.invoke(_itemRemoteModel, requestId);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemInStock", boolean.class);

				method.invoke(_itemRemoteModel, itemInStock);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorCode", String.class);

				method.invoke(_itemRemoteModel, vendorCode);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOrder", String.class);

				method.invoke(_itemRemoteModel, purchaseOrder);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setRecievedDate", Date.class);

				method.invoke(_itemRemoteModel, recievedDate);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnedDate", Date.class);

				method.invoke(_itemRemoteModel, returnedDate);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setAssetInfo", String.class);

				method.invoke(_itemRemoteModel, assetInfo);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setReturnedAssets",
						String.class);

				method.invoke(_itemRemoteModel, returnedAssets);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_itemRemoteModel, createdBy);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_itemRemoteModel, createdDate);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_itemRemoteModel, modifiedBy);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_itemRemoteModel, modifiedDate);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_itemRemoteModel, companyId);
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

		if (_itemRemoteModel != null) {
			try {
				Class<?> clazz = _itemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_itemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getItemRemoteModel() {
		return _itemRemoteModel;
	}

	public void setItemRemoteModel(BaseModel<?> itemRemoteModel) {
		_itemRemoteModel = itemRemoteModel;
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

		Class<?> remoteModelClass = _itemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_itemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ItemLocalServiceUtil.addItem(this);
		}
		else {
			ItemLocalServiceUtil.updateItem(this);
		}
	}

	@Override
	public Item toEscapedModel() {
		return (Item)ProxyUtil.newProxyInstance(Item.class.getClassLoader(),
			new Class[] { Item.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ItemClp clone = new ItemClp();

		clone.setItemId(getItemId());
		clone.setItemName(getItemName());
		clone.setItemDescription(getItemDescription());
		clone.setQuantity(getQuantity());
		clone.setCost(getCost());
		clone.setOriginalCost(getOriginalCost());
		clone.setWbselement(getWbselement());
		clone.setGlAccNo(getGlAccNo());
		clone.setCostCenter(getCostCenter());
		clone.setRequestId(getRequestId());
		clone.setItemInStock(getItemInStock());
		clone.setVendorCode(getVendorCode());
		clone.setPurchaseOrder(getPurchaseOrder());
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

		return clone;
	}

	@Override
	public int compareTo(Item item) {
		long primaryKey = item.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemClp)) {
			return false;
		}

		ItemClp item = (ItemClp)obj;

		long primaryKey = item.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", itemName=");
		sb.append(getItemName());
		sb.append(", itemDescription=");
		sb.append(getItemDescription());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", originalCost=");
		sb.append(getOriginalCost());
		sb.append(", wbselement=");
		sb.append(getWbselement());
		sb.append(", glAccNo=");
		sb.append(getGlAccNo());
		sb.append(", costCenter=");
		sb.append(getCostCenter());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", itemInStock=");
		sb.append(getItemInStock());
		sb.append(", vendorCode=");
		sb.append(getVendorCode());
		sb.append(", purchaseOrder=");
		sb.append(getPurchaseOrder());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.Item");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemName</column-name><column-value><![CDATA[");
		sb.append(getItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemDescription</column-name><column-value><![CDATA[");
		sb.append(getItemDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalCost</column-name><column-value><![CDATA[");
		sb.append(getOriginalCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wbselement</column-name><column-value><![CDATA[");
		sb.append(getWbselement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glAccNo</column-name><column-value><![CDATA[");
		sb.append(getGlAccNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>costCenter</column-name><column-value><![CDATA[");
		sb.append(getCostCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemInStock</column-name><column-value><![CDATA[");
		sb.append(getItemInStock());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorCode</column-name><column-value><![CDATA[");
		sb.append(getVendorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaseOrder</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOrder());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private String _itemName;
	private String _itemDescription;
	private long _quantity;
	private double _cost;
	private double _originalCost;
	private String _wbselement;
	private String _glAccNo;
	private String _costCenter;
	private long _requestId;
	private boolean _itemInStock;
	private String _vendorCode;
	private String _purchaseOrder;
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
	private BaseModel<?> _itemRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}