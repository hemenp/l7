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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class WorkflowDefinitionSoap implements Serializable {
	public static WorkflowDefinitionSoap toSoapModel(WorkflowDefinition model) {
		WorkflowDefinitionSoap soapModel = new WorkflowDefinitionSoap();

		soapModel.setWorkflowDefinitionId(model.getWorkflowDefinitionId());
		soapModel.setWorkflowName(model.getWorkflowName());
		soapModel.setStages(model.getStages());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static WorkflowDefinitionSoap[] toSoapModels(
		WorkflowDefinition[] models) {
		WorkflowDefinitionSoap[] soapModels = new WorkflowDefinitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowDefinitionSoap[][] toSoapModels(
		WorkflowDefinition[][] models) {
		WorkflowDefinitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowDefinitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowDefinitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowDefinitionSoap[] toSoapModels(
		List<WorkflowDefinition> models) {
		List<WorkflowDefinitionSoap> soapModels = new ArrayList<WorkflowDefinitionSoap>(models.size());

		for (WorkflowDefinition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowDefinitionSoap[soapModels.size()]);
	}

	public WorkflowDefinitionSoap() {
	}

	public long getPrimaryKey() {
		return _workflowDefinitionId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowDefinitionId(pk);
	}

	public long getWorkflowDefinitionId() {
		return _workflowDefinitionId;
	}

	public void setWorkflowDefinitionId(long workflowDefinitionId) {
		_workflowDefinitionId = workflowDefinitionId;
	}

	public String getWorkflowName() {
		return _workflowName;
	}

	public void setWorkflowName(String workflowName) {
		_workflowName = workflowName;
	}

	public String getStages() {
		return _stages;
	}

	public void setStages(String stages) {
		_stages = stages;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _workflowDefinitionId;
	private String _workflowName;
	private String _stages;
	private boolean _isActive;
	private long _createdBy;
	private Date _createdDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private long _companyId;
	private long _groupId;
}