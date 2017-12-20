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
 * The extended model interface for the WorkflowRequest service. Represents a row in the &quot;eproc_workflow_request&quot; database table, with each column mapped to a property of this class.
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequestModel
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowRequestModelImpl
 * @generated
 */
@ImplementationClassName("com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl")
@ProviderType
public interface WorkflowRequest extends WorkflowRequestModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WorkflowRequest, Long> WORKFLOW_REQUEST_ID_ACCESSOR =
		new Accessor<WorkflowRequest, Long>() {
			@Override
			public Long get(WorkflowRequest workflowRequest) {
				return workflowRequest.getWorkflowRequestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WorkflowRequest> getTypeClass() {
				return WorkflowRequest.class;
			}
		};
}