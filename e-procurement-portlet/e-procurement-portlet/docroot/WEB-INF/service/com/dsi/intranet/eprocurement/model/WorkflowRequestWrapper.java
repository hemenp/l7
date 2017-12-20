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
 * This class is a wrapper for {@link WorkflowRequest}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequest
 * @generated
 */
@ProviderType
public class WorkflowRequestWrapper implements WorkflowRequest,
	ModelWrapper<WorkflowRequest> {
	public WorkflowRequestWrapper(WorkflowRequest workflowRequest) {
		_workflowRequest = workflowRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowRequest.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowRequestId", getWorkflowRequestId());
		attributes.put("workflowDefinitionId", getWorkflowDefinitionId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
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
		Long workflowRequestId = (Long)attributes.get("workflowRequestId");

		if (workflowRequestId != null) {
			setWorkflowRequestId(workflowRequestId);
		}

		Long workflowDefinitionId = (Long)attributes.get("workflowDefinitionId");

		if (workflowDefinitionId != null) {
			setWorkflowDefinitionId(workflowDefinitionId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
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
	public WorkflowRequest toEscapedModel() {
		return new WorkflowRequestWrapper(_workflowRequest.toEscapedModel());
	}

	@Override
	public WorkflowRequest toUnescapedModel() {
		return new WorkflowRequestWrapper(_workflowRequest.toUnescapedModel());
	}

	/**
	* Returns the is active of this workflow request.
	*
	* @return the is active of this workflow request
	*/
	@Override
	public boolean getIsActive() {
		return _workflowRequest.getIsActive();
	}

	@Override
	public boolean isCachedModel() {
		return _workflowRequest.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workflowRequest.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this workflow request is is active.
	*
	* @return <code>true</code> if this workflow request is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _workflowRequest.isIsActive();
	}

	@Override
	public boolean isNew() {
		return _workflowRequest.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workflowRequest.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkflowRequest> toCacheModel() {
		return _workflowRequest.toCacheModel();
	}

	@Override
	public int compareTo(WorkflowRequest workflowRequest) {
		return _workflowRequest.compareTo(workflowRequest);
	}

	@Override
	public int hashCode() {
		return _workflowRequest.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowRequest.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowRequestWrapper((WorkflowRequest)_workflowRequest.clone());
	}

	/**
	* Returns the fully qualified class name of this workflow request.
	*
	* @return the fully qualified class name of this workflow request
	*/
	@Override
	public java.lang.String getClassName() {
		return _workflowRequest.getClassName();
	}

	@Override
	public java.lang.String toString() {
		return _workflowRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflowRequest.toXmlString();
	}

	/**
	* Returns the created date of this workflow request.
	*
	* @return the created date of this workflow request
	*/
	@Override
	public Date getCreatedDate() {
		return _workflowRequest.getCreatedDate();
	}

	/**
	* Returns the modified date of this workflow request.
	*
	* @return the modified date of this workflow request
	*/
	@Override
	public Date getModifiedDate() {
		return _workflowRequest.getModifiedDate();
	}

	/**
	* Returns the class name ID of this workflow request.
	*
	* @return the class name ID of this workflow request
	*/
	@Override
	public long getClassNameId() {
		return _workflowRequest.getClassNameId();
	}

	/**
	* Returns the class pk of this workflow request.
	*
	* @return the class pk of this workflow request
	*/
	@Override
	public long getClassPK() {
		return _workflowRequest.getClassPK();
	}

	/**
	* Returns the company ID of this workflow request.
	*
	* @return the company ID of this workflow request
	*/
	@Override
	public long getCompanyId() {
		return _workflowRequest.getCompanyId();
	}

	/**
	* Returns the created by of this workflow request.
	*
	* @return the created by of this workflow request
	*/
	@Override
	public long getCreatedBy() {
		return _workflowRequest.getCreatedBy();
	}

	/**
	* Returns the group ID of this workflow request.
	*
	* @return the group ID of this workflow request
	*/
	@Override
	public long getGroupId() {
		return _workflowRequest.getGroupId();
	}

	/**
	* Returns the modified by of this workflow request.
	*
	* @return the modified by of this workflow request
	*/
	@Override
	public long getModifiedBy() {
		return _workflowRequest.getModifiedBy();
	}

	/**
	* Returns the primary key of this workflow request.
	*
	* @return the primary key of this workflow request
	*/
	@Override
	public long getPrimaryKey() {
		return _workflowRequest.getPrimaryKey();
	}

	/**
	* Returns the workflow definition ID of this workflow request.
	*
	* @return the workflow definition ID of this workflow request
	*/
	@Override
	public long getWorkflowDefinitionId() {
		return _workflowRequest.getWorkflowDefinitionId();
	}

	/**
	* Returns the workflow request ID of this workflow request.
	*
	* @return the workflow request ID of this workflow request
	*/
	@Override
	public long getWorkflowRequestId() {
		return _workflowRequest.getWorkflowRequestId();
	}

	@Override
	public void persist() {
		_workflowRequest.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflowRequest.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_workflowRequest.setClassName(className);
	}

	/**
	* Sets the class name ID of this workflow request.
	*
	* @param classNameId the class name ID of this workflow request
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_workflowRequest.setClassNameId(classNameId);
	}

	/**
	* Sets the class pk of this workflow request.
	*
	* @param classPK the class pk of this workflow request
	*/
	@Override
	public void setClassPK(long classPK) {
		_workflowRequest.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this workflow request.
	*
	* @param companyId the company ID of this workflow request
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workflowRequest.setCompanyId(companyId);
	}

	/**
	* Sets the created by of this workflow request.
	*
	* @param createdBy the created by of this workflow request
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_workflowRequest.setCreatedBy(createdBy);
	}

	/**
	* Sets the created date of this workflow request.
	*
	* @param createdDate the created date of this workflow request
	*/
	@Override
	public void setCreatedDate(Date createdDate) {
		_workflowRequest.setCreatedDate(createdDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workflowRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workflowRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workflowRequest.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this workflow request.
	*
	* @param groupId the group ID of this workflow request
	*/
	@Override
	public void setGroupId(long groupId) {
		_workflowRequest.setGroupId(groupId);
	}

	/**
	* Sets whether this workflow request is is active.
	*
	* @param isActive the is active of this workflow request
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_workflowRequest.setIsActive(isActive);
	}

	/**
	* Sets the modified by of this workflow request.
	*
	* @param modifiedBy the modified by of this workflow request
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_workflowRequest.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this workflow request.
	*
	* @param modifiedDate the modified date of this workflow request
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_workflowRequest.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_workflowRequest.setNew(n);
	}

	/**
	* Sets the primary key of this workflow request.
	*
	* @param primaryKey the primary key of this workflow request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflowRequest.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workflowRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the workflow definition ID of this workflow request.
	*
	* @param workflowDefinitionId the workflow definition ID of this workflow request
	*/
	@Override
	public void setWorkflowDefinitionId(long workflowDefinitionId) {
		_workflowRequest.setWorkflowDefinitionId(workflowDefinitionId);
	}

	/**
	* Sets the workflow request ID of this workflow request.
	*
	* @param workflowRequestId the workflow request ID of this workflow request
	*/
	@Override
	public void setWorkflowRequestId(long workflowRequestId) {
		_workflowRequest.setWorkflowRequestId(workflowRequestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowRequestWrapper)) {
			return false;
		}

		WorkflowRequestWrapper workflowRequestWrapper = (WorkflowRequestWrapper)obj;

		if (Objects.equals(_workflowRequest,
					workflowRequestWrapper._workflowRequest)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkflowRequest getWrappedModel() {
		return _workflowRequest;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workflowRequest.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workflowRequest.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workflowRequest.resetOriginalValues();
	}

	private final WorkflowRequest _workflowRequest;
}