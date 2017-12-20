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

import com.dsi.intranet.eprocurement.model.RequestAttachment;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RequestAttachment in entity cache.
 *
 * @author CIGNEX Technologies
 * @see RequestAttachment
 * @generated
 */
@ProviderType
public class RequestAttachmentCacheModel implements CacheModel<RequestAttachment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequestAttachmentCacheModel)) {
			return false;
		}

		RequestAttachmentCacheModel requestAttachmentCacheModel = (RequestAttachmentCacheModel)obj;

		if (requestAttachmentId == requestAttachmentCacheModel.requestAttachmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestAttachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{requestAttachmentId=");
		sb.append(requestAttachmentId);
		sb.append(", requestId=");
		sb.append(requestId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RequestAttachment toEntityModel() {
		RequestAttachmentImpl requestAttachmentImpl = new RequestAttachmentImpl();

		requestAttachmentImpl.setRequestAttachmentId(requestAttachmentId);
		requestAttachmentImpl.setRequestId(requestId);
		requestAttachmentImpl.setFileEntryId(fileEntryId);

		requestAttachmentImpl.resetOriginalValues();

		return requestAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requestAttachmentId = objectInput.readLong();

		requestId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(requestAttachmentId);

		objectOutput.writeLong(requestId);

		objectOutput.writeLong(fileEntryId);
	}

	public long requestAttachmentId;
	public long requestId;
	public long fileEntryId;
}