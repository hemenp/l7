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

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;

/**
 * The extended model base implementation for the EprocurementRequest service. Represents a row in the &quot;eproc_request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EprocurementRequestImpl}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestImpl
 * @see EprocurementRequest
 * @generated
 */
@ProviderType
public abstract class EprocurementRequestBaseImpl
	extends EprocurementRequestModelImpl implements EprocurementRequest {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a eprocurement request model instance should use the {@link EprocurementRequest} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			EprocurementRequestLocalServiceUtil.addEprocurementRequest(this);
		}
		else {
			EprocurementRequestLocalServiceUtil.updateEprocurementRequest(this);
		}
	}
}