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
import com.dsi.intranet.eprocurement.service.EprocurementLocationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class EprocurementLocationClp extends BaseModelImpl<EprocurementLocation>
	implements EprocurementLocation {
	public EprocurementLocationClp() {
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
	public String getPrimaryKey() {
		return _locationId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setLocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _locationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public String getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(String locationId) {
		_locationId = locationId;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", String.class);

				method.invoke(_eprocurementLocationRemoteModel, locationId);
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

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eprocurementLocationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_eprocurementLocationRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlowType() {
		return _flowType;
	}

	@Override
	public void setFlowType(String flowType) {
		_flowType = flowType;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setFlowType", String.class);

				method.invoke(_eprocurementLocationRemoteModel, flowType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationType() {
		return _locationType;
	}

	@Override
	public void setLocationType(String locationType) {
		_locationType = locationType;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationType", String.class);

				method.invoke(_eprocurementLocationRemoteModel, locationType);
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

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_eprocurementLocationRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonnelArea() {
		return _personnelArea;
	}

	@Override
	public void setPersonnelArea(String personnelArea) {
		_personnelArea = personnelArea;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonnelArea", String.class);

				method.invoke(_eprocurementLocationRemoteModel, personnelArea);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonnelSubArea() {
		return _personnelSubArea;
	}

	@Override
	public void setPersonnelSubArea(String personnelSubArea) {
		_personnelSubArea = personnelSubArea;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonnelSubArea",
						String.class);

				method.invoke(_eprocurementLocationRemoteModel, personnelSubArea);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBuildingNumber() {
		return _buildingNumber;
	}

	@Override
	public void setBuildingNumber(String buildingNumber) {
		_buildingNumber = buildingNumber;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setBuildingNumber",
						String.class);

				method.invoke(_eprocurementLocationRemoteModel, buildingNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppName() {
		return _appName;
	}

	@Override
	public void setAppName(String appName) {
		_appName = appName;

		if (_eprocurementLocationRemoteModel != null) {
			try {
				Class<?> clazz = _eprocurementLocationRemoteModel.getClass();

				Method method = clazz.getMethod("setAppName", String.class);

				method.invoke(_eprocurementLocationRemoteModel, appName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEprocurementLocationRemoteModel() {
		return _eprocurementLocationRemoteModel;
	}

	public void setEprocurementLocationRemoteModel(
		BaseModel<?> eprocurementLocationRemoteModel) {
		_eprocurementLocationRemoteModel = eprocurementLocationRemoteModel;
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

		Class<?> remoteModelClass = _eprocurementLocationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eprocurementLocationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			EprocurementLocationLocalServiceUtil.addEprocurementLocation(this);
		}
		else {
			EprocurementLocationLocalServiceUtil.updateEprocurementLocation(this);
		}
	}

	@Override
	public EprocurementLocation toEscapedModel() {
		return (EprocurementLocation)ProxyUtil.newProxyInstance(EprocurementLocation.class.getClassLoader(),
			new Class[] { EprocurementLocation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EprocurementLocationClp clone = new EprocurementLocationClp();

		clone.setLocationId(getLocationId());
		clone.setCompanyId(getCompanyId());
		clone.setLocation(getLocation());
		clone.setFlowType(getFlowType());
		clone.setLocationType(getLocationType());
		clone.setAddress(getAddress());
		clone.setPersonnelArea(getPersonnelArea());
		clone.setPersonnelSubArea(getPersonnelSubArea());
		clone.setBuildingNumber(getBuildingNumber());
		clone.setAppName(getAppName());

		return clone;
	}

	@Override
	public int compareTo(EprocurementLocation eprocurementLocation) {
		String primaryKey = eprocurementLocation.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementLocationClp)) {
			return false;
		}

		EprocurementLocationClp eprocurementLocation = (EprocurementLocationClp)obj;

		String primaryKey = eprocurementLocation.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
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
		StringBundler sb = new StringBundler(21);

		sb.append("{locationId=");
		sb.append(getLocationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", flowType=");
		sb.append(getFlowType());
		sb.append(", locationType=");
		sb.append(getLocationType());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", personnelArea=");
		sb.append(getPersonnelArea());
		sb.append(", personnelSubArea=");
		sb.append(getPersonnelSubArea());
		sb.append(", buildingNumber=");
		sb.append(getBuildingNumber());
		sb.append(", appName=");
		sb.append(getAppName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.EprocurementLocation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flowType</column-name><column-value><![CDATA[");
		sb.append(getFlowType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationType</column-name><column-value><![CDATA[");
		sb.append(getLocationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personnelArea</column-name><column-value><![CDATA[");
		sb.append(getPersonnelArea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personnelSubArea</column-name><column-value><![CDATA[");
		sb.append(getPersonnelSubArea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buildingNumber</column-name><column-value><![CDATA[");
		sb.append(getBuildingNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appName</column-name><column-value><![CDATA[");
		sb.append(getAppName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _eprocurementLocationRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}