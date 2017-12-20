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

package com.dsi.intranet.eprocurement.service.base;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.service.EprocurementRequestServiceUtil;

import java.util.Arrays;

/**
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class EprocurementRequestServiceClpInvoker {
	public EprocurementRequestServiceClpInvoker() {
		_methodName48 = "getOSGiServiceIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName53 = "approveDeclineRequest";

		_methodParameterTypes53 = new String[] {
				"com.dsi.intranet.xml.EProcurementProcessInfo"
			};

		_methodName54 = "getEProcurementRequest";

		_methodParameterTypes54 = new String[] { "long" };

		_methodName55 = "sayHello";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName56 = "sendNotificationByInitialApprover";

		_methodParameterTypes56 = new String[] { "long", "java.lang.String" };

		_methodName57 = "updateEProcurementRequest";

		_methodParameterTypes57 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return EprocurementRequestServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return EprocurementRequestServiceUtil.approveDeclineRequest((com.dsi.intranet.xml.EProcurementProcessInfo)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return EprocurementRequestServiceUtil.getEProcurementRequest(((Long)arguments[0]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return EprocurementRequestServiceUtil.sayHello((java.lang.String)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			EprocurementRequestServiceUtil.sendNotificationByInitialApprover(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return EprocurementRequestServiceUtil.updateEProcurementRequest(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
}