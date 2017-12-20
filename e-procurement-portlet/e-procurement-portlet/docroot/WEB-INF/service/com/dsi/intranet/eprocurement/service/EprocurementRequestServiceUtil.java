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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for EprocurementRequest. This utility wraps
 * {@link com.dsi.intranet.eprocurement.service.impl.EprocurementRequestServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestService
 * @see com.dsi.intranet.eprocurement.service.base.EprocurementRequestServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.impl.EprocurementRequestServiceImpl
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dsi.intranet.eprocurement.service.impl.EprocurementRequestServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.dsi.intranet.eprocurement.model.EprocurementRequest approveDeclineRequest(
		com.dsi.intranet.xml.EProcurementProcessInfo eprocurementInfo) {
		return getService().approveDeclineRequest(eprocurementInfo);
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequest getEProcurementRequest(
		long eProcRequestId) {
		return getService().getEProcurementRequest(eProcRequestId);
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequest updateEProcurementRequest(
		long eProcRequestId, java.lang.String status, java.lang.String reason) {
		return getService()
				   .updateEProcurementRequest(eProcRequestId, status, reason);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String sayHello(java.lang.String name) {
		return getService().sayHello(name);
	}

	public static void sendNotificationByInitialApprover(long requestId,
		java.lang.String viewRequestUrl) {
		getService().sendNotificationByInitialApprover(requestId, viewRequestUrl);
	}

	public static void clearService() {
		_service = null;
	}

	public static EprocurementRequestService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EprocurementRequestService.class.getName());

			if (invokableService instanceof EprocurementRequestService) {
				_service = (EprocurementRequestService)invokableService;
			}
			else {
				_service = new EprocurementRequestServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EprocurementRequestServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static EprocurementRequestService _service;
}