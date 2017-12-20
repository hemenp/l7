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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class EprocurementLocationSoap implements Serializable {
	public static EprocurementLocationSoap toSoapModel(
		EprocurementLocation model) {
		EprocurementLocationSoap soapModel = new EprocurementLocationSoap();

		soapModel.setLocationId(model.getLocationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLocation(model.getLocation());
		soapModel.setFlowType(model.getFlowType());
		soapModel.setLocationType(model.getLocationType());
		soapModel.setAddress(model.getAddress());
		soapModel.setPersonnelArea(model.getPersonnelArea());
		soapModel.setPersonnelSubArea(model.getPersonnelSubArea());
		soapModel.setBuildingNumber(model.getBuildingNumber());
		soapModel.setAppName(model.getAppName());

		return soapModel;
	}

	public static EprocurementLocationSoap[] toSoapModels(
		EprocurementLocation[] models) {
		EprocurementLocationSoap[] soapModels = new EprocurementLocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprocurementLocationSoap[][] toSoapModels(
		EprocurementLocation[][] models) {
		EprocurementLocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprocurementLocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprocurementLocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprocurementLocationSoap[] toSoapModels(
		List<EprocurementLocation> models) {
		List<EprocurementLocationSoap> soapModels = new ArrayList<EprocurementLocationSoap>(models.size());

		for (EprocurementLocation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprocurementLocationSoap[soapModels.size()]);
	}

	public EprocurementLocationSoap() {
	}

	public String getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(String pk) {
		setLocationId(pk);
	}

	public String getLocationId() {
		return _locationId;
	}

	public void setLocationId(String locationId) {
		_locationId = locationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getFlowType() {
		return _flowType;
	}

	public void setFlowType(String flowType) {
		_flowType = flowType;
	}

	public String getLocationType() {
		return _locationType;
	}

	public void setLocationType(String locationType) {
		_locationType = locationType;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getPersonnelArea() {
		return _personnelArea;
	}

	public void setPersonnelArea(String personnelArea) {
		_personnelArea = personnelArea;
	}

	public String getPersonnelSubArea() {
		return _personnelSubArea;
	}

	public void setPersonnelSubArea(String personnelSubArea) {
		_personnelSubArea = personnelSubArea;
	}

	public String getBuildingNumber() {
		return _buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		_buildingNumber = buildingNumber;
	}

	public String getAppName() {
		return _appName;
	}

	public void setAppName(String appName) {
		_appName = appName;
	}

	private String _locationId;
	private long _companyId;
	private String _location;
	private String _flowType;
	private String _locationType;
	private String _address;
	private String _personnelArea;
	private String _personnelSubArea;
	private String _buildingNumber;
	private String _appName;
}