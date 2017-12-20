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

import com.dsi.intranet.eprocurement.model.EprocurementLocation;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EprocurementLocation in entity cache.
 *
 * @author CIGNEX Technologies
 * @see EprocurementLocation
 * @generated
 */
@ProviderType
public class EprocurementLocationCacheModel implements CacheModel<EprocurementLocation>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EprocurementLocationCacheModel)) {
			return false;
		}

		EprocurementLocationCacheModel eprocurementLocationCacheModel = (EprocurementLocationCacheModel)obj;

		if (locationId.equals(eprocurementLocationCacheModel.locationId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, locationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", location=");
		sb.append(location);
		sb.append(", flowType=");
		sb.append(flowType);
		sb.append(", locationType=");
		sb.append(locationType);
		sb.append(", address=");
		sb.append(address);
		sb.append(", personnelArea=");
		sb.append(personnelArea);
		sb.append(", personnelSubArea=");
		sb.append(personnelSubArea);
		sb.append(", buildingNumber=");
		sb.append(buildingNumber);
		sb.append(", appName=");
		sb.append(appName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EprocurementLocation toEntityModel() {
		EprocurementLocationImpl eprocurementLocationImpl = new EprocurementLocationImpl();

		if (locationId == null) {
			eprocurementLocationImpl.setLocationId(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setLocationId(locationId);
		}

		eprocurementLocationImpl.setCompanyId(companyId);

		if (location == null) {
			eprocurementLocationImpl.setLocation(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setLocation(location);
		}

		if (flowType == null) {
			eprocurementLocationImpl.setFlowType(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setFlowType(flowType);
		}

		if (locationType == null) {
			eprocurementLocationImpl.setLocationType(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setLocationType(locationType);
		}

		if (address == null) {
			eprocurementLocationImpl.setAddress(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setAddress(address);
		}

		if (personnelArea == null) {
			eprocurementLocationImpl.setPersonnelArea(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setPersonnelArea(personnelArea);
		}

		if (personnelSubArea == null) {
			eprocurementLocationImpl.setPersonnelSubArea(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setPersonnelSubArea(personnelSubArea);
		}

		if (buildingNumber == null) {
			eprocurementLocationImpl.setBuildingNumber(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setBuildingNumber(buildingNumber);
		}

		if (appName == null) {
			eprocurementLocationImpl.setAppName(StringPool.BLANK);
		}
		else {
			eprocurementLocationImpl.setAppName(appName);
		}

		eprocurementLocationImpl.resetOriginalValues();

		return eprocurementLocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		locationId = objectInput.readUTF();

		companyId = objectInput.readLong();
		location = objectInput.readUTF();
		flowType = objectInput.readUTF();
		locationType = objectInput.readUTF();
		address = objectInput.readUTF();
		personnelArea = objectInput.readUTF();
		personnelSubArea = objectInput.readUTF();
		buildingNumber = objectInput.readUTF();
		appName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (locationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationId);
		}

		objectOutput.writeLong(companyId);

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (flowType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flowType);
		}

		if (locationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(locationType);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (personnelArea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personnelArea);
		}

		if (personnelSubArea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personnelSubArea);
		}

		if (buildingNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(buildingNumber);
		}

		if (appName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appName);
		}
	}

	public String locationId;
	public long companyId;
	public String location;
	public String flowType;
	public String locationType;
	public String address;
	public String personnelArea;
	public String personnelSubArea;
	public String buildingNumber;
	public String appName;
}