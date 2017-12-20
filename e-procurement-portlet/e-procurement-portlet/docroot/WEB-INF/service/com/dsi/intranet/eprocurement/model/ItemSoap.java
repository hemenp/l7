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
 * This class is used by SOAP remote services.
 *
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class ItemSoap implements Serializable {
	public static ItemSoap toSoapModel(Item model) {
		ItemSoap soapModel = new ItemSoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setItemName(model.getItemName());
		soapModel.setItemDescription(model.getItemDescription());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setCost(model.getCost());
		soapModel.setOriginalCost(model.getOriginalCost());
		soapModel.setWbselement(model.getWbselement());
		soapModel.setGlAccNo(model.getGlAccNo());
		soapModel.setCostCenter(model.getCostCenter());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setItemInStock(model.getItemInStock());
		soapModel.setVendorCode(model.getVendorCode());
		soapModel.setPurchaseOrder(model.getPurchaseOrder());
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

		return soapModel;
	}

	public static ItemSoap[] toSoapModels(Item[] models) {
		ItemSoap[] soapModels = new ItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemSoap[][] toSoapModels(Item[][] models) {
		ItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemSoap[] toSoapModels(List<Item> models) {
		List<ItemSoap> soapModels = new ArrayList<ItemSoap>(models.size());

		for (Item model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemSoap[soapModels.size()]);
	}

	public ItemSoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public String getItemName() {
		return _itemName;
	}

	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	public String getItemDescription() {
		return _itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;
	}

	public long getQuantity() {
		return _quantity;
	}

	public void setQuantity(long quantity) {
		_quantity = quantity;
	}

	public double getCost() {
		return _cost;
	}

	public void setCost(double cost) {
		_cost = cost;
	}

	public double getOriginalCost() {
		return _originalCost;
	}

	public void setOriginalCost(double originalCost) {
		_originalCost = originalCost;
	}

	public String getWbselement() {
		return _wbselement;
	}

	public void setWbselement(String wbselement) {
		_wbselement = wbselement;
	}

	public String getGlAccNo() {
		return _glAccNo;
	}

	public void setGlAccNo(String glAccNo) {
		_glAccNo = glAccNo;
	}

	public String getCostCenter() {
		return _costCenter;
	}

	public void setCostCenter(String costCenter) {
		_costCenter = costCenter;
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
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

	public String getVendorCode() {
		return _vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		_vendorCode = vendorCode;
	}

	public String getPurchaseOrder() {
		return _purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		_purchaseOrder = purchaseOrder;
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
}