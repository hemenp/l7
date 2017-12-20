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
import com.dsi.intranet.eprocurement.service.WorkflowReviewLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class WorkflowReviewClp extends BaseModelImpl<WorkflowReview>
	implements WorkflowReview {
	public WorkflowReviewClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowReview.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowReview.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workflowReviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowReviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowReviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowReviewId", getWorkflowReviewId());
		attributes.put("workflowRequestId", getWorkflowRequestId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedToStatus", getUpdatedToStatus());
		attributes.put("nextStage", getNextStage());
		attributes.put("isApproverRole", getIsApproverRole());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("approverComments", getApproverComments());
		attributes.put("emailComments", getEmailComments());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowReviewId = (Long)attributes.get("workflowReviewId");

		if (workflowReviewId != null) {
			setWorkflowReviewId(workflowReviewId);
		}

		Long workflowRequestId = (Long)attributes.get("workflowRequestId");

		if (workflowRequestId != null) {
			setWorkflowRequestId(workflowRequestId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		String updatedToStatus = (String)attributes.get("updatedToStatus");

		if (updatedToStatus != null) {
			setUpdatedToStatus(updatedToStatus);
		}

		String nextStage = (String)attributes.get("nextStage");

		if (nextStage != null) {
			setNextStage(nextStage);
		}

		String isApproverRole = (String)attributes.get("isApproverRole");

		if (isApproverRole != null) {
			setIsApproverRole(isApproverRole);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}

		String approverComments = (String)attributes.get("approverComments");

		if (approverComments != null) {
			setApproverComments(approverComments);
		}

		String emailComments = (String)attributes.get("emailComments");

		if (emailComments != null) {
			setEmailComments(emailComments);
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
	public long getWorkflowReviewId() {
		return _workflowReviewId;
	}

	@Override
	public void setWorkflowReviewId(long workflowReviewId) {
		_workflowReviewId = workflowReviewId;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowReviewId",
						long.class);

				method.invoke(_workflowReviewRemoteModel, workflowReviewId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkflowRequestId() {
		return _workflowRequestId;
	}

	@Override
	public void setWorkflowRequestId(long workflowRequestId) {
		_workflowRequestId = workflowRequestId;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowRequestId",
						long.class);

				method.invoke(_workflowReviewRemoteModel, workflowRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_workflowReviewRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_workflowReviewRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", long.class);

				method.invoke(_workflowReviewRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedToStatus() {
		return _updatedToStatus;
	}

	@Override
	public void setUpdatedToStatus(String updatedToStatus) {
		_updatedToStatus = updatedToStatus;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedToStatus",
						String.class);

				method.invoke(_workflowReviewRemoteModel, updatedToStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNextStage() {
		return _nextStage;
	}

	@Override
	public void setNextStage(String nextStage) {
		_nextStage = nextStage;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setNextStage", String.class);

				method.invoke(_workflowReviewRemoteModel, nextStage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsApproverRole() {
		return _isApproverRole;
	}

	@Override
	public void setIsApproverRole(String isApproverRole) {
		_isApproverRole = isApproverRole;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setIsApproverRole",
						String.class);

				method.invoke(_workflowReviewRemoteModel, isApproverRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_workflowReviewRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApproverComments() {
		return _approverComments;
	}

	@Override
	public void setApproverComments(String approverComments) {
		_approverComments = approverComments;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setApproverComments",
						String.class);

				method.invoke(_workflowReviewRemoteModel, approverComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailComments() {
		return _emailComments;
	}

	@Override
	public void setEmailComments(String emailComments) {
		_emailComments = emailComments;

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailComments", String.class);

				method.invoke(_workflowReviewRemoteModel, emailComments);
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

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workflowReviewRemoteModel, companyId);
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

		if (_workflowReviewRemoteModel != null) {
			try {
				Class<?> clazz = _workflowReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workflowReviewRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkflowReviewRemoteModel() {
		return _workflowReviewRemoteModel;
	}

	public void setWorkflowReviewRemoteModel(
		BaseModel<?> workflowReviewRemoteModel) {
		_workflowReviewRemoteModel = workflowReviewRemoteModel;
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

		Class<?> remoteModelClass = _workflowReviewRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workflowReviewRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			WorkflowReviewLocalServiceUtil.addWorkflowReview(this);
		}
		else {
			WorkflowReviewLocalServiceUtil.updateWorkflowReview(this);
		}
	}

	@Override
	public WorkflowReview toEscapedModel() {
		return (WorkflowReview)ProxyUtil.newProxyInstance(WorkflowReview.class.getClassLoader(),
			new Class[] { WorkflowReview.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkflowReviewClp clone = new WorkflowReviewClp();

		clone.setWorkflowReviewId(getWorkflowReviewId());
		clone.setWorkflowRequestId(getWorkflowRequestId());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedToStatus(getUpdatedToStatus());
		clone.setNextStage(getNextStage());
		clone.setIsApproverRole(getIsApproverRole());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setApproverComments(getApproverComments());
		clone.setEmailComments(getEmailComments());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(WorkflowReview workflowReview) {
		long primaryKey = workflowReview.getPrimaryKey();

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

		if (!(obj instanceof WorkflowReviewClp)) {
			return false;
		}

		WorkflowReviewClp workflowReview = (WorkflowReviewClp)obj;

		long primaryKey = workflowReview.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{workflowReviewId=");
		sb.append(getWorkflowReviewId());
		sb.append(", workflowRequestId=");
		sb.append(getWorkflowRequestId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedToStatus=");
		sb.append(getUpdatedToStatus());
		sb.append(", nextStage=");
		sb.append(getNextStage());
		sb.append(", isApproverRole=");
		sb.append(getIsApproverRole());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", approverComments=");
		sb.append(getApproverComments());
		sb.append(", emailComments=");
		sb.append(getEmailComments());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.WorkflowReview");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowReviewId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowReviewId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowRequestId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedToStatus</column-name><column-value><![CDATA[");
		sb.append(getUpdatedToStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nextStage</column-name><column-value><![CDATA[");
		sb.append(getNextStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproverRole</column-name><column-value><![CDATA[");
		sb.append(getIsApproverRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverComments</column-name><column-value><![CDATA[");
		sb.append(getApproverComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailComments</column-name><column-value><![CDATA[");
		sb.append(getEmailComments());
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

	private long _workflowReviewId;
	private long _workflowRequestId;
	private long _classNameId;
	private long _classPK;
	private long _updatedBy;
	private String _updatedToStatus;
	private String _nextStage;
	private String _isApproverRole;
	private Date _updatedDate;
	private String _approverComments;
	private String _emailComments;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _workflowReviewRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}