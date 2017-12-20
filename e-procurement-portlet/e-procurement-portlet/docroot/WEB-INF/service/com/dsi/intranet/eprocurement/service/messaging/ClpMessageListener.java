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

package com.dsi.intranet.eprocurement.service.messaging;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.service.ClpSerializer;
import com.dsi.intranet.eprocurement.service.EprocurementLocationLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.RequestAttachmentLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowReviewLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author CIGNEX Technologies
 */
@ProviderType
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			EprocurementLocationLocalServiceUtil.clearService();

			EprocurementRequestLocalServiceUtil.clearService();

			EprocurementRequestServiceUtil.clearService();
			ItemLocalServiceUtil.clearService();

			RequestAttachmentLocalServiceUtil.clearService();

			WorkflowDefinitionLocalServiceUtil.clearService();

			WorkflowRequestLocalServiceUtil.clearService();

			WorkflowReviewLocalServiceUtil.clearService();
		}
	}
}