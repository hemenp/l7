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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link EprocurementRequestServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestServiceSoap
 * @see HttpPrincipal
 * @see EprocurementRequestServiceUtil
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceHttp {
	public static com.dsi.intranet.eprocurement.model.EprocurementRequest approveDeclineRequest(
		HttpPrincipal httpPrincipal,
		com.dsi.intranet.xml.EProcurementProcessInfo eprocurementInfo) {
		try {
			MethodKey methodKey = new MethodKey(EprocurementRequestServiceUtil.class,
					"approveDeclineRequest",
					_approveDeclineRequestParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					eprocurementInfo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.dsi.intranet.eprocurement.model.EprocurementRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequest getEProcurementRequest(
		HttpPrincipal httpPrincipal, long eProcRequestId) {
		try {
			MethodKey methodKey = new MethodKey(EprocurementRequestServiceUtil.class,
					"getEProcurementRequest",
					_getEProcurementRequestParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					eProcRequestId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.dsi.intranet.eprocurement.model.EprocurementRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String sayHello(HttpPrincipal httpPrincipal,
		java.lang.String name) {
		try {
			MethodKey methodKey = new MethodKey(EprocurementRequestServiceUtil.class,
					"sayHello", _sayHelloParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void sendNotificationByInitialApprover(
		HttpPrincipal httpPrincipal, long requestId,
		java.lang.String viewRequestUrl) {
		try {
			MethodKey methodKey = new MethodKey(EprocurementRequestServiceUtil.class,
					"sendNotificationByInitialApprover",
					_sendNotificationByInitialApproverParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					requestId, viewRequestUrl);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementRequest updateEProcurementRequest(
		HttpPrincipal httpPrincipal, long eProcRequestId,
		java.lang.String status, java.lang.String reason) {
		try {
			MethodKey methodKey = new MethodKey(EprocurementRequestServiceUtil.class,
					"updateEProcurementRequest",
					_updateEProcurementRequestParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					eProcRequestId, status, reason);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.dsi.intranet.eprocurement.model.EprocurementRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EprocurementRequestServiceHttp.class);
	private static final Class<?>[] _approveDeclineRequestParameterTypes0 = new Class[] {
			com.dsi.intranet.xml.EProcurementProcessInfo.class
		};
	private static final Class<?>[] _getEProcurementRequestParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _sayHelloParameterTypes2 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _sendNotificationByInitialApproverParameterTypes3 =
		new Class[] { long.class, java.lang.String.class };
	private static final Class<?>[] _updateEProcurementRequestParameterTypes4 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class
		};
}