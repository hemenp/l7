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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class RequestAttachmentSoap implements Serializable {
	public static RequestAttachmentSoap toSoapModel(RequestAttachment model) {
		RequestAttachmentSoap soapModel = new RequestAttachmentSoap();

		soapModel.setRequestAttachmentId(model.getRequestAttachmentId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static RequestAttachmentSoap[] toSoapModels(
		RequestAttachment[] models) {
		RequestAttachmentSoap[] soapModels = new RequestAttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequestAttachmentSoap[][] toSoapModels(
		RequestAttachment[][] models) {
		RequestAttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequestAttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequestAttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequestAttachmentSoap[] toSoapModels(
		List<RequestAttachment> models) {
		List<RequestAttachmentSoap> soapModels = new ArrayList<RequestAttachmentSoap>(models.size());

		for (RequestAttachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequestAttachmentSoap[soapModels.size()]);
	}

	public RequestAttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _requestAttachmentId;
	}

	public void setPrimaryKey(long pk) {
		setRequestAttachmentId(pk);
	}

	public long getRequestAttachmentId() {
		return _requestAttachmentId;
	}

	public void setRequestAttachmentId(long requestAttachmentId) {
		_requestAttachmentId = requestAttachmentId;
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _requestAttachmentId;
	private long _requestId;
	private long _fileEntryId;
}