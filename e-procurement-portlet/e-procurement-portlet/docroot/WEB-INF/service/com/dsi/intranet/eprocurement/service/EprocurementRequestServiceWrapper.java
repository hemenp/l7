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

package com.dsi.intranet.eprocurement.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EprocurementRequestService}.
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestService
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceWrapper
	implements EprocurementRequestService,
		ServiceWrapper<EprocurementRequestService> {
	public EprocurementRequestServiceWrapper(
		EprocurementRequestService eprocurementRequestService) {
		_eprocurementRequestService = eprocurementRequestService;
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest approveDeclineRequest(
		com.dsi.intranet.xml.EProcurementProcessInfo eprocurementInfo) {
		return _eprocurementRequestService.approveDeclineRequest(eprocurementInfo);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest getEProcurementRequest(
		long eProcRequestId) {
		return _eprocurementRequestService.getEProcurementRequest(eProcRequestId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest updateEProcurementRequest(
		long eProcRequestId, java.lang.String status, java.lang.String reason) {
		return _eprocurementRequestService.updateEProcurementRequest(eProcRequestId,
			status, reason);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprocurementRequestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _eprocurementRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String sayHello(java.lang.String name) {
		return _eprocurementRequestService.sayHello(name);
	}

	@Override
	public void sendNotificationByInitialApprover(long requestId,
		java.lang.String viewRequestUrl) {
		_eprocurementRequestService.sendNotificationByInitialApprover(requestId,
			viewRequestUrl);
	}

	@Override
	public EprocurementRequestService getWrappedService() {
		return _eprocurementRequestService;
	}

	@Override
	public void setWrappedService(
		EprocurementRequestService eprocurementRequestService) {
		_eprocurementRequestService = eprocurementRequestService;
	}

	private EprocurementRequestService _eprocurementRequestService;
}