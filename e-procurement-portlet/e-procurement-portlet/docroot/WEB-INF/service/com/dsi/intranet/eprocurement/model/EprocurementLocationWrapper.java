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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EprocurementLocation}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementLocation
 * @generated
 */
@ProviderType
public class EprocurementLocationWrapper implements EprocurementLocation,
	ModelWrapper<EprocurementLocation> {
	public EprocurementLocationWrapper(
		EprocurementLocation eprocurementLocation) {
		_eprocurementLocation = eprocurementLocation;
	}

	@Override
	public Class<?> getModelClass() {
		return EprocurementLocation.class;
	}

	@Override
	public String getModelClassName() {
		return EprocurementLocation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("location", getLocation());
		attributes.put("flowType", getFlowType());
		attributes.put("locationType", getLocationType());
		attributes.put("address", getAddress());
		attributes.put("personnelArea", getPersonnelArea());
		attributes.put("personnelSubArea", getPersonnelSubArea());
		attributes.put("buildingNumber", getBuildingNumber());
		attributes.put("appName", getAppName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String locationId = (String)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String flowType = (String)attributes.get("flowType");

		if (flowType != null) {
			setFlowType(flowType);
		}

		String locationType = (String)attributes.get("locationType");

		if (locationType != null) {
			setLocationType(locationType);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String personnelArea = (String)attributes.get("personnelArea");

		if (personnelArea != null) {
			setPersonnelArea(personnelArea);
		}

		String personnelSubArea = (String)attributes.get("personnelSubArea");

		if (personnelSubArea != null) {
			setPersonnelSubArea(personnelSubArea);
		}

		String buildingNumber = (String)attributes.get("buildingNumber");

		if (buildingNumber != null) {
			setBuildingNumber(buildingNumber);
		}

		String appName = (String)attributes.get("appName");

		if (appName != null) {
			setAppName(appName);
		}
	}

	@Override
	public EprocurementLocation toEscapedModel() {
		return new EprocurementLocationWrapper(_eprocurementLocation.toEscapedModel());
	}

	@Override
	public EprocurementLocation toUnescapedModel() {
		return new EprocurementLocationWrapper(_eprocurementLocation.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _eprocurementLocation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _eprocurementLocation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _eprocurementLocation.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _eprocurementLocation.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EprocurementLocation> toCacheModel() {
		return _eprocurementLocation.toCacheModel();
	}

	@Override
	public int compareTo(EprocurementLocation eprocurementLocation) {
		return _eprocurementLocation.compareTo(eprocurementLocation);
	}

	@Override
	public int hashCode() {
		return _eprocurementLocation.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eprocurementLocation.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EprocurementLocationWrapper((EprocurementLocation)_eprocurementLocation.clone());
	}

	/**
	* Returns the address of this eprocurement location.
	*
	* @return the address of this eprocurement location
	*/
	@Override
	public java.lang.String getAddress() {
		return _eprocurementLocation.getAddress();
	}

	/**
	* Returns the app name of this eprocurement location.
	*
	* @return the app name of this eprocurement location
	*/
	@Override
	public java.lang.String getAppName() {
		return _eprocurementLocation.getAppName();
	}

	/**
	* Returns the building number of this eprocurement location.
	*
	* @return the building number of this eprocurement location
	*/
	@Override
	public java.lang.String getBuildingNumber() {
		return _eprocurementLocation.getBuildingNumber();
	}

	/**
	* Returns the flow type of this eprocurement location.
	*
	* @return the flow type of this eprocurement location
	*/
	@Override
	public java.lang.String getFlowType() {
		return _eprocurementLocation.getFlowType();
	}

	/**
	* Returns the location of this eprocurement location.
	*
	* @return the location of this eprocurement location
	*/
	@Override
	public java.lang.String getLocation() {
		return _eprocurementLocation.getLocation();
	}

	/**
	* Returns the location ID of this eprocurement location.
	*
	* @return the location ID of this eprocurement location
	*/
	@Override
	public java.lang.String getLocationId() {
		return _eprocurementLocation.getLocationId();
	}

	/**
	* Returns the location type of this eprocurement location.
	*
	* @return the location type of this eprocurement location
	*/
	@Override
	public java.lang.String getLocationType() {
		return _eprocurementLocation.getLocationType();
	}

	/**
	* Returns the personnel area of this eprocurement location.
	*
	* @return the personnel area of this eprocurement location
	*/
	@Override
	public java.lang.String getPersonnelArea() {
		return _eprocurementLocation.getPersonnelArea();
	}

	/**
	* Returns the personnel sub area of this eprocurement location.
	*
	* @return the personnel sub area of this eprocurement location
	*/
	@Override
	public java.lang.String getPersonnelSubArea() {
		return _eprocurementLocation.getPersonnelSubArea();
	}

	/**
	* Returns the primary key of this eprocurement location.
	*
	* @return the primary key of this eprocurement location
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _eprocurementLocation.getPrimaryKey();
	}

	@Override
	public java.lang.String toString() {
		return _eprocurementLocation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eprocurementLocation.toXmlString();
	}

	/**
	* Returns the company ID of this eprocurement location.
	*
	* @return the company ID of this eprocurement location
	*/
	@Override
	public long getCompanyId() {
		return _eprocurementLocation.getCompanyId();
	}

	@Override
	public void persist() {
		_eprocurementLocation.persist();
	}

	/**
	* Sets the address of this eprocurement location.
	*
	* @param address the address of this eprocurement location
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_eprocurementLocation.setAddress(address);
	}

	/**
	* Sets the app name of this eprocurement location.
	*
	* @param appName the app name of this eprocurement location
	*/
	@Override
	public void setAppName(java.lang.String appName) {
		_eprocurementLocation.setAppName(appName);
	}

	/**
	* Sets the building number of this eprocurement location.
	*
	* @param buildingNumber the building number of this eprocurement location
	*/
	@Override
	public void setBuildingNumber(java.lang.String buildingNumber) {
		_eprocurementLocation.setBuildingNumber(buildingNumber);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eprocurementLocation.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this eprocurement location.
	*
	* @param companyId the company ID of this eprocurement location
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eprocurementLocation.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_eprocurementLocation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_eprocurementLocation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_eprocurementLocation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flow type of this eprocurement location.
	*
	* @param flowType the flow type of this eprocurement location
	*/
	@Override
	public void setFlowType(java.lang.String flowType) {
		_eprocurementLocation.setFlowType(flowType);
	}

	/**
	* Sets the location of this eprocurement location.
	*
	* @param location the location of this eprocurement location
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_eprocurementLocation.setLocation(location);
	}

	/**
	* Sets the location ID of this eprocurement location.
	*
	* @param locationId the location ID of this eprocurement location
	*/
	@Override
	public void setLocationId(java.lang.String locationId) {
		_eprocurementLocation.setLocationId(locationId);
	}

	/**
	* Sets the location type of this eprocurement location.
	*
	* @param locationType the location type of this eprocurement location
	*/
	@Override
	public void setLocationType(java.lang.String locationType) {
		_eprocurementLocation.setLocationType(locationType);
	}

	@Override
	public void setNew(boolean n) {
		_eprocurementLocation.setNew(n);
	}

	/**
	* Sets the personnel area of this eprocurement location.
	*
	* @param personnelArea the personnel area of this eprocurement location
	*/
	@Override
	public void setPersonnelArea(java.lang.String personnelArea) {
		_eprocurementLocation.setPersonnelArea(personnelArea);
	}

	/**
	* Sets the personnel sub area of this eprocurement location.
	*
	* @param personnelSubArea the personnel sub area of this eprocurement location
	*/
	@Override
	public void setPersonnelSubArea(java.lang.String personnelSubArea) {
		_eprocurementLocation.setPersonnelSubArea(personnelSubArea);
	}

	/**
	* Sets the primary key of this eprocurement location.
	*
	* @param primaryKey the primary key of this eprocurement location
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_eprocurementLocation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_eprocurementLocation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementLocationWrapper)) {
			return false;
		}

		EprocurementLocationWrapper eprocurementLocationWrapper = (EprocurementLocationWrapper)obj;

		if (Objects.equals(_eprocurementLocation,
					eprocurementLocationWrapper._eprocurementLocation)) {
			return true;
		}

		return false;
	}

	@Override
	public EprocurementLocation getWrappedModel() {
		return _eprocurementLocation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _eprocurementLocation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _eprocurementLocation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_eprocurementLocation.resetOriginalValues();
	}

	private final EprocurementLocation _eprocurementLocation;
}