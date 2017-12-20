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

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.xml.EProcurementProcessInfo;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the remote service interface for EprocurementRequest. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestServiceUtil
 * @see com.dsi.intranet.eprocurement.service.base.EprocurementRequestServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.impl.EprocurementRequestServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EprocurementRequestService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprocurementRequestServiceUtil} to access the eprocurement request remote service. Add custom service methods to {@link com.dsi.intranet.eprocurement.service.impl.EprocurementRequestServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public EprocurementRequest approveDeclineRequest(
		EProcurementProcessInfo eprocurementInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EprocurementRequest getEProcurementRequest(long eProcRequestId);

	public EprocurementRequest updateEProcurementRequest(long eProcRequestId,
		java.lang.String status, java.lang.String reason);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public java.lang.String sayHello(java.lang.String name);

	public void sendNotificationByInitialApprover(long requestId,
		java.lang.String viewRequestUrl);
}