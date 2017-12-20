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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WorkflowDefinition}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinition
 * @generated
 */
@ProviderType
public class WorkflowDefinitionWrapper implements WorkflowDefinition,
	ModelWrapper<WorkflowDefinition> {
	public WorkflowDefinitionWrapper(WorkflowDefinition workflowDefinition) {
		_workflowDefinition = workflowDefinition;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowDefinition.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowDefinition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowDefinitionId", getWorkflowDefinitionId());
		attributes.put("workflowName", getWorkflowName());
		attributes.put("stages", getStages());
		attributes.put("isActive", getIsActive());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowDefinitionId = (Long)attributes.get("workflowDefinitionId");

		if (workflowDefinitionId != null) {
			setWorkflowDefinitionId(workflowDefinitionId);
		}

		String workflowName = (String)attributes.get("workflowName");

		if (workflowName != null) {
			setWorkflowName(workflowName);
		}

		String stages = (String)attributes.get("stages");

		if (stages != null) {
			setStages(stages);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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
	}

	@Override
	public WorkflowDefinition toEscapedModel() {
		return new WorkflowDefinitionWrapper(_workflowDefinition.toEscapedModel());
	}

	@Override
	public WorkflowDefinition toUnescapedModel() {
		return new WorkflowDefinitionWrapper(_workflowDefinition.toUnescapedModel());
	}

	/**
	* Returns the is active of this workflow definition.
	*
	* @return the is active of this workflow definition
	*/
	@Override
	public boolean getIsActive() {
		return _workflowDefinition.getIsActive();
	}

	@Override
	public boolean isCachedModel() {
		return _workflowDefinition.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workflowDefinition.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this workflow definition is is active.
	*
	* @return <code>true</code> if this workflow definition is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _workflowDefinition.isIsActive();
	}

	@Override
	public boolean isNew() {
		return _workflowDefinition.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workflowDefinition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkflowDefinition> toCacheModel() {
		return _workflowDefinition.toCacheModel();
	}

	@Override
	public int compareTo(WorkflowDefinition workflowDefinition) {
		return _workflowDefinition.compareTo(workflowDefinition);
	}

	@Override
	public int hashCode() {
		return _workflowDefinition.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowDefinition.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowDefinitionWrapper((WorkflowDefinition)_workflowDefinition.clone());
	}

	/**
	* Returns the stages of this workflow definition.
	*
	* @return the stages of this workflow definition
	*/
	@Override
	public java.lang.String getStages() {
		return _workflowDefinition.getStages();
	}

	/**
	* Returns the workflow name of this workflow definition.
	*
	* @return the workflow name of this workflow definition
	*/
	@Override
	public java.lang.String getWorkflowName() {
		return _workflowDefinition.getWorkflowName();
	}

	@Override
	public java.lang.String toString() {
		return _workflowDefinition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflowDefinition.toXmlString();
	}

	/**
	* Returns the created date of this workflow definition.
	*
	* @return the created date of this workflow definition
	*/
	@Override
	public Date getCreatedDate() {
		return _workflowDefinition.getCreatedDate();
	}

	/**
	* Returns the modified date of this workflow definition.
	*
	* @return the modified date of this workflow definition
	*/
	@Override
	public Date getModifiedDate() {
		return _workflowDefinition.getModifiedDate();
	}

	/**
	* Returns the company ID of this workflow definition.
	*
	* @return the company ID of this workflow definition
	*/
	@Override
	public long getCompanyId() {
		return _workflowDefinition.getCompanyId();
	}

	/**
	* Returns the created by of this workflow definition.
	*
	* @return the created by of this workflow definition
	*/
	@Override
	public long getCreatedBy() {
		return _workflowDefinition.getCreatedBy();
	}

	/**
	* Returns the group ID of this workflow definition.
	*
	* @return the group ID of this workflow definition
	*/
	@Override
	public long getGroupId() {
		return _workflowDefinition.getGroupId();
	}

	/**
	* Returns the modified by of this workflow definition.
	*
	* @return the modified by of this workflow definition
	*/
	@Override
	public long getModifiedBy() {
		return _workflowDefinition.getModifiedBy();
	}

	/**
	* Returns the primary key of this workflow definition.
	*
	* @return the primary key of this workflow definition
	*/
	@Override
	public long getPrimaryKey() {
		return _workflowDefinition.getPrimaryKey();
	}

	/**
	* Returns the workflow definition ID of this workflow definition.
	*
	* @return the workflow definition ID of this workflow definition
	*/
	@Override
	public long getWorkflowDefinitionId() {
		return _workflowDefinition.getWorkflowDefinitionId();
	}

	@Override
	public void persist() {
		_workflowDefinition.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflowDefinition.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this workflow definition.
	*
	* @param companyId the company ID of this workflow definition
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workflowDefinition.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this workflow definition.
	*
	* @param createdBy the created by of this workflow definition
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_workflowDefinition.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this workflow definition.
	*
	* @param createdDate the created date of this workflow definition
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_workflowDefinition.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workflowDefinition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workflowDefinition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workflowDefinition.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this workflow definition.
	*
	* @param groupId the group ID of this workflow definition
	*/
	@Override
	public void setGroupId(long groupId) {
		_workflowDefinition.setGroupId(groupId);
	}

	/**
	* Sets whether this workflow definition is is active.
	*
	* @param isActive the is active of this workflow definition
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_workflowDefinition.setIsActive(isActive);
	}

	/**
	* Sets the modified by of this workflow definition.
	*
	* @param modifiedBy the modified by of this workflow definition
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_workflowDefinition.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this workflow definition.
	*
	* @param modifiedDate the modified date of this workflow definition
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_workflowDefinition.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_workflowDefinition.setNew(n);
	}

	/**
	* Sets the primary key of this workflow definition.
	*
	* @param primaryKey the primary key of this workflow definition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflowDefinition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workflowDefinition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the stages of this workflow definition.
	*
	* @param stages the stages of this workflow definition
	*/
	@Override
	public void setStages(java.lang.String stages) {
		_workflowDefinition.setStages(stages);
	}

	/**
	* Sets the workflow definition ID of this workflow definition.
	*
	* @param workflowDefinitionId the workflow definition ID of this workflow definition
	*/
	@Override
	public void setWorkflowDefinitionId(long workflowDefinitionId) {
		_workflowDefinition.setWorkflowDefinitionId(workflowDefinitionId);
	}

	/**
	* Sets the workflow name of this workflow definition.
	*
	* @param workflowName the workflow name of this workflow definition
	*/
	@Override
	public void setWorkflowName(java.lang.String workflowName) {
		_workflowDefinition.setWorkflowName(workflowName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowDefinitionWrapper)) {
			return false;
		}

		WorkflowDefinitionWrapper workflowDefinitionWrapper = (WorkflowDefinitionWrapper)obj;

		if (Objects.equals(_workflowDefinition,
					workflowDefinitionWrapper._workflowDefinition)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkflowDefinition getWrappedModel() {
		return _workflowDefinition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workflowDefinition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workflowDefinition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workflowDefinition.resetOriginalValues();
	}

	private final WorkflowDefinition _workflowDefinition;
}