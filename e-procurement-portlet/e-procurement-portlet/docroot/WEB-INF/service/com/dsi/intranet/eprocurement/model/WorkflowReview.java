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
 * The extended model interface for the WorkflowReview service. Represents a row in the &quot;eproc_workflow_review&quot; database table, with each column mapped to a property of this class.
 *
 * @author CIGNEX Technologies
 * @see WorkflowReviewModel
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl
 * @see com.dsi.intranet.eprocurement.model.impl.WorkflowReviewModelImpl
 * @generated
 */
@ImplementationClassName("com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl")
@ProviderType
public interface WorkflowReview extends WorkflowReviewModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WorkflowReview, Long> WORKFLOW_REVIEW_ID_ACCESSOR =
		new Accessor<WorkflowReview, Long>() {
			@Override
			public Long get(WorkflowReview workflowReview) {
				return workflowReview.getWorkflowReviewId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WorkflowReview> getTypeClass() {
				return WorkflowReview.class;
			}
		};
}