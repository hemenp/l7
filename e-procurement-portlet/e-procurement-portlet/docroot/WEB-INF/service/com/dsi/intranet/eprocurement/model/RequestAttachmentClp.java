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
import com.dsi.intranet.eprocurement.service.RequestAttachmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class RequestAttachmentClp extends BaseModelImpl<RequestAttachment>
	implements RequestAttachment {
	public RequestAttachmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RequestAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return RequestAttachment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _requestAttachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequestAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _requestAttachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestAttachmentId", getRequestAttachmentId());
		attributes.put("requestId", getRequestId());
		attributes.put("fileEntryId", getFileEntryId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requestAttachmentId = (Long)attributes.get("requestAttachmentId");

		if (requestAttachmentId != null) {
			setRequestAttachmentId(requestAttachmentId);
		}

		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getRequestAttachmentId() {
		return _requestAttachmentId;
	}

	@Override
	public void setRequestAttachmentId(long requestAttachmentId) {
		_requestAttachmentId = requestAttachmentId;

		if (_requestAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _requestAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestAttachmentId",
						long.class);

				method.invoke(_requestAttachmentRemoteModel, requestAttachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRequestId() {
		return _requestId;
	}

	@Override
	public void setRequestId(long requestId) {
		_requestId = requestId;

		if (_requestAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _requestAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestId", long.class);

				method.invoke(_requestAttachmentRemoteModel, requestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_requestAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _requestAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_requestAttachmentRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRequestAttachmentRemoteModel() {
		return _requestAttachmentRemoteModel;
	}

	public void setRequestAttachmentRemoteModel(
		BaseModel<?> requestAttachmentRemoteModel) {
		_requestAttachmentRemoteModel = requestAttachmentRemoteModel;
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

		Class<?> remoteModelClass = _requestAttachmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_requestAttachmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			RequestAttachmentLocalServiceUtil.addRequestAttachment(this);
		}
		else {
			RequestAttachmentLocalServiceUtil.updateRequestAttachment(this);
		}
	}

	@Override
	public RequestAttachment toEscapedModel() {
		return (RequestAttachment)ProxyUtil.newProxyInstance(RequestAttachment.class.getClassLoader(),
			new Class[] { RequestAttachment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RequestAttachmentClp clone = new RequestAttachmentClp();

		clone.setRequestAttachmentId(getRequestAttachmentId());
		clone.setRequestId(getRequestId());
		clone.setFileEntryId(getFileEntryId());

		return clone;
	}

	@Override
	public int compareTo(RequestAttachment requestAttachment) {
		long primaryKey = requestAttachment.getPrimaryKey();

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

		if (!(obj instanceof RequestAttachmentClp)) {
			return false;
		}

		RequestAttachmentClp requestAttachment = (RequestAttachmentClp)obj;

		long primaryKey = requestAttachment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{requestAttachmentId=");
		sb.append(getRequestAttachmentId());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.dsi.intranet.eprocurement.model.RequestAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requestAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getRequestAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requestAttachmentId;
	private long _requestId;
	private long _fileEntryId;
	private BaseModel<?> _requestAttachmentRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}