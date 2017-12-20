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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RequestAttachment}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see RequestAttachment
 * @generated
 */
@ProviderType
public class RequestAttachmentWrapper implements RequestAttachment,
	ModelWrapper<RequestAttachment> {
	public RequestAttachmentWrapper(RequestAttachment requestAttachment) {
		_requestAttachment = requestAttachment;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestAttachmentId", getRequestAttachmentId());
		attributes.put("requestId", getRequestId());
		attributes.put("fileEntryId", getFileEntryId());

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
	}

	@Override
	public RequestAttachment toEscapedModel() {
		return new RequestAttachmentWrapper(_requestAttachment.toEscapedModel());
	}

	@Override
	public RequestAttachment toUnescapedModel() {
		return new RequestAttachmentWrapper(_requestAttachment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _requestAttachment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _requestAttachment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _requestAttachment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _requestAttachment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RequestAttachment> toCacheModel() {
		return _requestAttachment.toCacheModel();
	}

	@Override
	public int compareTo(RequestAttachment requestAttachment) {
		return _requestAttachment.compareTo(requestAttachment);
	}

	@Override
	public int hashCode() {
		return _requestAttachment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _requestAttachment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RequestAttachmentWrapper((RequestAttachment)_requestAttachment.clone());
	}

	@Override
	public java.lang.String toString() {
		return _requestAttachment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _requestAttachment.toXmlString();
	}

	/**
	* Returns the file entry ID of this request attachment.
	*
	* @return the file entry ID of this request attachment
	*/
	@Override
	public long getFileEntryId() {
		return _requestAttachment.getFileEntryId();
	}

	/**
	* Returns the primary key of this request attachment.
	*
	* @return the primary key of this request attachment
	*/
	@Override
	public long getPrimaryKey() {
		return _requestAttachment.getPrimaryKey();
	}

	/**
	* Returns the request attachment ID of this request attachment.
	*
	* @return the request attachment ID of this request attachment
	*/
	@Override
	public long getRequestAttachmentId() {
		return _requestAttachment.getRequestAttachmentId();
	}

	/**
	* Returns the request ID of this request attachment.
	*
	* @return the request ID of this request attachment
	*/
	@Override
	public long getRequestId() {
		return _requestAttachment.getRequestId();
	}

	@Override
	public void persist() {
		_requestAttachment.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_requestAttachment.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_requestAttachment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_requestAttachment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_requestAttachment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this request attachment.
	*
	* @param fileEntryId the file entry ID of this request attachment
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_requestAttachment.setFileEntryId(fileEntryId);
	}

	@Override
	public void setNew(boolean n) {
		_requestAttachment.setNew(n);
	}

	/**
	* Sets the primary key of this request attachment.
	*
	* @param primaryKey the primary key of this request attachment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_requestAttachment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_requestAttachment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the request attachment ID of this request attachment.
	*
	* @param requestAttachmentId the request attachment ID of this request attachment
	*/
	@Override
	public void setRequestAttachmentId(long requestAttachmentId) {
		_requestAttachment.setRequestAttachmentId(requestAttachmentId);
	}

	/**
	* Sets the request ID of this request attachment.
	*
	* @param requestId the request ID of this request attachment
	*/
	@Override
	public void setRequestId(long requestId) {
		_requestAttachment.setRequestId(requestId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequestAttachmentWrapper)) {
			return false;
		}

		RequestAttachmentWrapper requestAttachmentWrapper = (RequestAttachmentWrapper)obj;

		if (Objects.equals(_requestAttachment,
					requestAttachmentWrapper._requestAttachment)) {
			return true;
		}

		return false;
	}

	@Override
	public RequestAttachment getWrappedModel() {
		return _requestAttachment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _requestAttachment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _requestAttachment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_requestAttachment.resetOriginalValues();
	}

	private final RequestAttachment _requestAttachment;
}