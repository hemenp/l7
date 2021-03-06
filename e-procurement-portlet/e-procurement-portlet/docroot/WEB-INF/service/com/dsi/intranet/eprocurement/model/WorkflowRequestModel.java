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

import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkflowRequest service. Represents a row in the &quot;eproc_workflow_request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dsi.intranet.eprocurement.model.impl.WorkflowRequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequest
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowRequestModelImpl
 * @generated
 */
@ProviderType
public interface WorkflowRequestModel extends AttachedModel,
	BaseModel<WorkflowRequest>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workflow request model instance should use the {@link WorkflowRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this workflow request.
	 *
	 * @return the primary key of this workflow request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workflow request.
	 *
	 * @param primaryKey the primary key of this workflow request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the workflow request ID of this workflow request.
	 *
	 * @return the workflow request ID of this workflow request
	 */
	public long getWorkflowRequestId();

	/**
	 * Sets the workflow request ID of this workflow request.
	 *
	 * @param workflowRequestId the workflow request ID of this workflow request
	 */
	public void setWorkflowRequestId(long workflowRequestId);

	/**
	 * Returns the workflow definition ID of this workflow request.
	 *
	 * @return the workflow definition ID of this workflow request
	 */
	public long getWorkflowDefinitionId();

	/**
	 * Sets the workflow definition ID of this workflow request.
	 *
	 * @param workflowDefinitionId the workflow definition ID of this workflow request
	 */
	public void setWorkflowDefinitionId(long workflowDefinitionId);

	/**
	 * Returns the fully qualified class name of this workflow request.
	 *
	 * @return the fully qualified class name of this workflow request
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this workflow request.
	 *
	 * @return the class name ID of this workflow request
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this workflow request.
	 *
	 * @param classNameId the class name ID of this workflow request
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this workflow request.
	 *
	 * @return the class pk of this workflow request
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this workflow request.
	 *
	 * @param classPK the class pk of this workflow request
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the is active of this workflow request.
	 *
	 * @return the is active of this workflow request
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this workflow request is is active.
	 *
	 * @return <code>true</code> if this workflow request is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this workflow request is is active.
	 *
	 * @param isActive the is active of this workflow request
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the created by of this workflow request.
	 *
	 * @return the created by of this workflow request
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this workflow request.
	 *
	 * @param createdBy the created by of this workflow request
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created date of this workflow request.
	 *
	 * @return the created date of this workflow request
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this workflow request.
	 *
	 * @param createdDate the created date of this workflow request
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this workflow request.
	 *
	 * @return the modified by of this workflow request
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this workflow request.
	 *
	 * @param modifiedBy the modified by of this workflow request
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this workflow request.
	 *
	 * @return the modified date of this workflow request
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workflow request.
	 *
	 * @param modifiedDate the modified date of this workflow request
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the company ID of this workflow request.
	 *
	 * @return the company ID of this workflow request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this workflow request.
	 *
	 * @param companyId the company ID of this workflow request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this workflow request.
	 *
	 * @return the group ID of this workflow request
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this workflow request.
	 *
	 * @param groupId the group ID of this workflow request
	 */
	public void setGroupId(long groupId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WorkflowRequest workflowRequest);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkflowRequest> toCacheModel();

	@Override
	public WorkflowRequest toEscapedModel();

	@Override
	public WorkflowRequest toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}