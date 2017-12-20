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

import com.dsi.intranet.eprocurement.model.WorkflowRequest;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkflowRequest in entity cache.
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequest
 * @generated
 */
@ProviderType
public class WorkflowRequestCacheModel implements CacheModel<WorkflowRequest>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowRequestCacheModel)) {
			return false;
		}

		WorkflowRequestCacheModel workflowRequestCacheModel = (WorkflowRequestCacheModel)obj;

		if (workflowRequestId == workflowRequestCacheModel.workflowRequestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{workflowRequestId=");
		sb.append(workflowRequestId);
		sb.append(", workflowDefinitionId=");
		sb.append(workflowDefinitionId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", isActive=");
		sb.append(isActive);
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
	public WorkflowRequest toEntityModel() {
		WorkflowRequestImpl workflowRequestImpl = new WorkflowRequestImpl();

		workflowRequestImpl.setWorkflowRequestId(workflowRequestId);
		workflowRequestImpl.setWorkflowDefinitionId(workflowDefinitionId);
		workflowRequestImpl.setClassNameId(classNameId);
		workflowRequestImpl.setClassPK(classPK);
		workflowRequestImpl.setIsActive(isActive);
		workflowRequestImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			workflowRequestImpl.setCreatedDate(null);
		}
		else {
			workflowRequestImpl.setCreatedDate(new Date(createdDate));
		}

		workflowRequestImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			workflowRequestImpl.setModifiedDate(null);
		}
		else {
			workflowRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		workflowRequestImpl.setCompanyId(companyId);
		workflowRequestImpl.setGroupId(groupId);

		workflowRequestImpl.resetOriginalValues();

		return workflowRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowRequestId = objectInput.readLong();

		workflowDefinitionId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		isActive = objectInput.readBoolean();

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
		objectOutput.writeLong(workflowRequestId);

		objectOutput.writeLong(workflowDefinitionId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeBoolean(isActive);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);
	}

	public long workflowRequestId;
	public long workflowDefinitionId;
	public long classNameId;
	public long classPK;
	public boolean isActive;
	public long createdBy;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long companyId;
	public long groupId;
}