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

import com.liferay.portal.kernel.service.InvokableService;

/**
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceClp implements EprocurementRequestService {
	public EprocurementRequestServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "approveDeclineRequest";

		_methodParameterTypes0 = new String[] {
				"com.dsi.intranet.xml.EProcurementProcessInfo"
			};

		_methodName1 = "getEProcurementRequest";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "updateEProcurementRequest";

		_methodParameterTypes2 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName4 = "getOSGiServiceIdentifier";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "sayHello";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "sendNotificationByInitialApprover";

		_methodParameterTypes6 = new String[] { "long", "java.lang.String" };
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest approveDeclineRequest(
		com.dsi.intranet.xml.EProcurementProcessInfo eprocurementInfo) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(
							eprocurementInfo) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.dsi.intranet.eprocurement.model.EprocurementRequest)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest getEProcurementRequest(
		long eProcRequestId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { eProcRequestId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.dsi.intranet.eprocurement.model.EprocurementRequest)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest updateEProcurementRequest(
		long eProcRequestId, java.lang.String status, java.lang.String reason) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName2,
					_methodParameterTypes2,
					new Object[] {
						eProcRequestId,
						
					ClpSerializer.translateInput(status),
						
					ClpSerializer.translateInput(reason)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.dsi.intranet.eprocurement.model.EprocurementRequest)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String sayHello(java.lang.String name) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(name) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void sendNotificationByInitialApprover(long requestId,
		java.lang.String viewRequestUrl) {
		try {
			_invokableService.invokeMethod(_methodName6,
				_methodParameterTypes6,
				new Object[] {
					requestId,
					
				ClpSerializer.translateInput(viewRequestUrl)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
}