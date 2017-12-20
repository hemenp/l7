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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the RequestAttachment service. Represents a row in the &quot;eproc_request_attachment&quot; database table, with each column mapped to a property of this class.
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentModel
 * @see com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl
 * @see com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl
 * @generated
 */
@ImplementationClassName("com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl")
@ProviderType
public interface RequestAttachment extends RequestAttachmentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RequestAttachment, Long> REQUEST_ATTACHMENT_ID_ACCESSOR =
		new Accessor<RequestAttachment, Long>() {
			@Override
			public Long get(RequestAttachment requestAttachment) {
				return requestAttachment.getRequestAttachmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RequestAttachment> getTypeClass() {
				return RequestAttachment.class;
			}
		};
}