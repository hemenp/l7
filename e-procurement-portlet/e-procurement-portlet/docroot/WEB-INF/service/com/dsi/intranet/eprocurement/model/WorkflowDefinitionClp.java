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
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class WorkflowDefinitionClp extends BaseModelImpl<WorkflowDefinition>
	implements WorkflowDefinition {
	public WorkflowDefinitionClp() {
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
	public long getPrimaryKey() {
		return _workflowDefinitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowDefinitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowDefinitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getWorkflowDefinitionId() {
		return _workflowDefinitionId;
	}

	@Override
	public void setWorkflowDefinitionId(long workflowDefinitionId) {
		_workflowDefinitionId = workflowDefinitionId;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowDefinitionId",
						long.class);

				method.invoke(_workflowDefinitionRemoteModel,
					workflowDefinitionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkflowName() {
		return _workflowName;
	}

	@Override
	public void setWorkflowName(String workflowName) {
		_workflowName = workflowName;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowName", String.class);

				method.invoke(_workflowDefinitionRemoteModel, workflowName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStages() {
		return _stages;
	}

	@Override
	public void setStages(String stages) {
		_stages = stages;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setStages", String.class);

				method.invoke(_workflowDefinitionRemoteModel, stages);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", boolean.class);

				method.invoke(_workflowDefinitionRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_workflowDefinitionRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_workflowDefinitionRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_workflowDefinitionRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workflowDefinitionRemoteModel, modifiedDate);
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

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workflowDefinitionRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_workflowDefinitionRemoteModel != null) {
			try {
				Class<?> clazz = _workflowDefinitionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workflowDefinitionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkflowDefinitionRemoteModel() {
		return _workflowDefinitionRemoteModel;
	}

	public void setWorkflowDefinitionRemoteModel(
		BaseModel<?> workflowDefinitionRemoteModel) {
		_workflowDefinitionRemoteModel = workflowDefinitionRemoteModel;
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

		Class<?> remoteModelClass = _workflowDefinitionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workflowDefinitionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			WorkflowDefinitionLocalServiceUtil.addWorkflowDefinition(this);
		}
		else {
			WorkflowDefinitionLocalServiceUtil.updateWorkflowDefinition(this);
		}
	}

	@Override
	public WorkflowDefinition toEscapedModel() {
		return (WorkflowDefinition)ProxyUtil.newProxyInstance(WorkflowDefinition.class.getClassLoader(),
			new Class[] { WorkflowDefinition.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkflowDefinitionClp clone = new WorkflowDefinitionClp();

		clone.setWorkflowDefinitionId(getWorkflowDefinitionId());
		clone.setWorkflowName(getWorkflowName());
		clone.setStages(getStages());
		clone.setIsActive(getIsActive());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedBy(getModifiedBy());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(WorkflowDefinition workflowDefinition) {
		long primaryKey = workflowDefinition.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowDefinitionClp)) {
			return false;
		}

		WorkflowDefinitionClp workflowDefinition = (WorkflowDefinitionClp)obj;

		long primaryKey = workflowDefinition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
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

		sb.append("{workflowDefinitionId=");
		sb.append(getWorkflowDefinitionId());
		sb.append(", workflowName=");
		sb.append(getWorkflowName());
		sb.append(", stages=");
		sb.append(getStages());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.WorkflowDefinition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowName</column-name><column-value><![CDATA[");
		sb.append(getWorkflowName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stages</column-name><column-value><![CDATA[");
		sb.append(getStages());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _workflowDefinitionRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}