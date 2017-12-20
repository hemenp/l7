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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkflowDefinition service. Represents a row in the &quot;eproc_workflow_definition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionImpl}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinition
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionImpl
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionModelImpl
 * @generated
 */
@ProviderType
public interface WorkflowDefinitionModel extends BaseModel<WorkflowDefinition>,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workflow definition model instance should use the {@link WorkflowDefinition} interface instead.
	 */

	/**
	 * Returns the primary key of this workflow definition.
	 *
	 * @return the primary key of this workflow definition
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workflow definition.
	 *
	 * @param primaryKey the primary key of this workflow definition
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the workflow definition ID of this workflow definition.
	 *
	 * @return the workflow definition ID of this workflow definition
	 */
	public long getWorkflowDefinitionId();

	/**
	 * Sets the workflow definition ID of this workflow definition.
	 *
	 * @param workflowDefinitionId the workflow definition ID of this workflow definition
	 */
	public void setWorkflowDefinitionId(long workflowDefinitionId);

	/**
	 * Returns the workflow name of this workflow definition.
	 *
	 * @return the workflow name of this workflow definition
	 */
	@AutoEscape
	public String getWorkflowName();

	/**
	 * Sets the workflow name of this workflow definition.
	 *
	 * @param workflowName the workflow name of this workflow definition
	 */
	public void setWorkflowName(String workflowName);

	/**
	 * Returns the stages of this workflow definition.
	 *
	 * @return the stages of this workflow definition
	 */
	@AutoEscape
	public String getStages();

	/**
	 * Sets the stages of this workflow definition.
	 *
	 * @param stages the stages of this workflow definition
	 */
	public void setStages(String stages);

	/**
	 * Returns the is active of this workflow definition.
	 *
	 * @return the is active of this workflow definition
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this workflow definition is is active.
	 *
	 * @return <code>true</code> if this workflow definition is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this workflow definition is is active.
	 *
	 * @param isActive the is active of this workflow definition
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the created by of this workflow definition.
	 *
	 * @return the created by of this workflow definition
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this workflow definition.
	 *
	 * @param createdBy the created by of this workflow definition
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created date of this workflow definition.
	 *
	 * @return the created date of this workflow definition
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this workflow definition.
	 *
	 * @param createdDate the created date of this workflow definition
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified by of this workflow definition.
	 *
	 * @return the modified by of this workflow definition
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this workflow definition.
	 *
	 * @param modifiedBy the modified by of this workflow definition
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this workflow definition.
	 *
	 * @return the modified date of this workflow definition
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workflow definition.
	 *
	 * @param modifiedDate the modified date of this workflow definition
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the company ID of this workflow definition.
	 *
	 * @return the company ID of this workflow definition
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this workflow definition.
	 *
	 * @param companyId the company ID of this workflow definition
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this workflow definition.
	 *
	 * @return the group ID of this workflow definition
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this workflow definition.
	 *
	 * @param groupId the group ID of this workflow definition
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
	public int compareTo(WorkflowDefinition workflowDefinition);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkflowDefinition> toCacheModel();

	@Override
	public WorkflowDefinition toEscapedModel();

	@Override
	public WorkflowDefinition toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}