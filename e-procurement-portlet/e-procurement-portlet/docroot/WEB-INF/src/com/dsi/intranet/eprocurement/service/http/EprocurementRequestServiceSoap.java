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

package com.dsi.intranet.eprocurement.service.http;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.service.EprocurementRequestServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link EprocurementRequestServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.dsi.intranet.eprocurement.model.EprocurementRequestSoap}.
 * If the method in the service utility returns a
 * {@link com.dsi.intranet.eprocurement.model.EprocurementRequest}, that is translated to a
 * {@link com.dsi.intranet.eprocurement.model.EprocurementRequestSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestServiceHttp
 * @see com.dsi.intranet.eprocurement.model.EprocurementRequestSoap
 * @see EprocurementRequestServiceUtil
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceSoap {
	public static com.dsi.intranet.eprocurement.model.EprocurementRequestSoap approveDeclineRequest(
		com.dsi.intranet.xml.EProcurementProcessInfo eprocurementInfo)
		throws RemoteException {
		try {
			com.dsi.intranet.eprocurement.model.EprocurementRequest returnValue = EprocurementRequestServiceUtil.approveDeclineRequest(eprocurementInfo);

			return com.dsi.intranet.eprocurement.model.EprocurementRequestSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequestSoap getEProcurementRequest(
		long eProcRequestId) throws RemoteException {
		try {
			com.dsi.intranet.eprocurement.model.EprocurementRequest returnValue = EprocurementRequestServiceUtil.getEProcurementRequest(eProcRequestId);

			return com.dsi.intranet.eprocurement.model.EprocurementRequestSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String sayHello(java.lang.String name)
		throws RemoteException {
		try {
			java.lang.String returnValue = EprocurementRequestServiceUtil.sayHello(name);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void sendNotificationByInitialApprover(long requestId,
		java.lang.String viewRequestUrl) throws RemoteException {
		try {
			EprocurementRequestServiceUtil.sendNotificationByInitialApprover(requestId,
				viewRequestUrl);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequestSoap updateEProcurementRequest(
		long eProcRequestId, java.lang.String status, java.lang.String reason)
		throws RemoteException {
		try {
			com.dsi.intranet.eprocurement.model.EprocurementRequest returnValue = EprocurementRequestServiceUtil.updateEProcurementRequest(eProcRequestId,
					status, reason);

			return com.dsi.intranet.eprocurement.model.EprocurementRequestSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EprocurementRequestServiceSoap.class);
}