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

package com.dsi.intranet.eprocurement.service.impl;

import com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException;
import com.dsi.intranet.eprocurement.model.RequestAttachment;
import com.dsi.intranet.eprocurement.service.base.RequestAttachmentLocalServiceBaseImpl;
import com.dsi.intranet.eprocurement.service.persistence.RequestAttachmentUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the request attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dsi.intranet.eprocurement.service.RequestAttachmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.RequestAttachmentLocalServiceUtil
 */
public class RequestAttachmentLocalServiceImpl
	extends RequestAttachmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dsi.intranet.eprocurement.service.RequestAttachmentLocalServiceUtil} to access the request attachment local service.
	 */
	 private static final Log LOGGER = LogFactoryUtil.getLog(RequestAttachmentLocalServiceImpl.class);
	 
	    public List<RequestAttachment> getRequestAttachmentsByRequestId(long requestId)
	    {
	            try {
					return RequestAttachmentUtil.findByGetRequestAttachments(requestId);
				} catch (com.liferay.portal.kernel.exception.SystemException e) {
					if (LOGGER.isDebugEnabled()){
						LOGGER.error(e.getMessage(), e);
					}
				}
				return null;
	    }
	    public RequestAttachment getRequestAttachmentsByFileEntryId(long fileEntryId)
	    throws NoSuchRequestAttachmentException{
	            try {
					return RequestAttachmentUtil.findByGetRequestAttachmentByFileEntryId(fileEntryId);
				} catch (com.liferay.portal.kernel.exception.SystemException e) {
					if (LOGGER.isDebugEnabled()){
						LOGGER.error(e.getMessage(), e);
					}
				}
				return null;
	    }
}