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

import com.dsi.intranet.eprocurement.model.WorkflowDefinition;

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
 * The cache model class for representing WorkflowDefinition in entity cache.
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinition
 * @generated
 */
@ProviderType
public class WorkflowDefinitionCacheModel implements CacheModel<WorkflowDefinition>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowDefinitionCacheModel)) {
			return false;
		}

		WorkflowDefinitionCacheModel workflowDefinitionCacheModel = (WorkflowDefinitionCacheModel)obj;

		if (workflowDefinitionId == workflowDefinitionCacheModel.workflowDefinitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowDefinitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{workflowDefinitionId=");
		sb.append(workflowDefinitionId);
		sb.append(", workflowName=");
		sb.append(workflowName);
		sb.append(", stages=");
		sb.append(stages);
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
	public WorkflowDefinition toEntityModel() {
		WorkflowDefinitionImpl workflowDefinitionImpl = new WorkflowDefinitionImpl();

		workflowDefinitionImpl.setWorkflowDefinitionId(workflowDefinitionId);

		if (workflowName == null) {
			workflowDefinitionImpl.setWorkflowName(StringPool.BLANK);
		}
		else {
			workflowDefinitionImpl.setWorkflowName(workflowName);
		}

		if (stages == null) {
			workflowDefinitionImpl.setStages(StringPool.BLANK);
		}
		else {
			workflowDefinitionImpl.setStages(stages);
		}

		workflowDefinitionImpl.setIsActive(isActive);
		workflowDefinitionImpl.setCreatedBy(createdBy);

		if (createdDate == Long.MIN_VALUE) {
			workflowDefinitionImpl.setCreatedDate(null);
		}
		else {
			workflowDefinitionImpl.setCreatedDate(new Date(createdDate));
		}

		workflowDefinitionImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			workflowDefinitionImpl.setModifiedDate(null);
		}
		else {
			workflowDefinitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		workflowDefinitionImpl.setCompanyId(companyId);
		workflowDefinitionImpl.setGroupId(groupId);

		workflowDefinitionImpl.resetOriginalValues();

		return workflowDefinitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowDefinitionId = objectInput.readLong();
		workflowName = objectInput.readUTF();
		stages = objectInput.readUTF();

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
		objectOutput.writeLong(workflowDefinitionId);

		if (workflowName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowName);
		}

		if (stages == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stages);
		}

		objectOutput.writeBoolean(isActive);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);
	}

	public long workflowDefinitionId;
	public String workflowName;
	public String stages;
	public boolean isActive;
	public long createdBy;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;
	public long companyId;
	public long groupId;
}