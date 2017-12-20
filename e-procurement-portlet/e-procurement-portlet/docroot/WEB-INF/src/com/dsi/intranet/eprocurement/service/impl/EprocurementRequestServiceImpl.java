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

package com.dsi.intranet.eprocurement.service.impl;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementRequestTrackerWSUtil;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.base.EprocurementRequestServiceBaseImpl;
import com.dsi.intranet.xml.EProcurementProcessInfo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the eprocurement request remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dsi.intranet.eprocurement.service.EprocurementRequestService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.EprocurementRequestServiceUtil
 */
public class EprocurementRequestServiceImpl
	extends EprocurementRequestServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dsi.intranet.eprocurement.service.EprocurementRequestServiceUtil} to access the eprocurement request remote service.
	 */
	 private static final Log LOGGER = LogFactoryUtil.getLog(EprocurementRequestServiceImpl.class);
	 
		public EprocurementRequest approveDeclineRequest(
				EProcurementProcessInfo eprocurementInfo) {
			EprocurementRequest eprocRequest = null;

			EProcurementProcessInfo eprocurementProcessInfo = EProcurementRequestTrackerWSUtil
					.loadEProcurementData(eprocurementInfo);
			EProcurementRequestTrackerWSUtil
					.approveDeclineRequest(eprocurementProcessInfo);
			try {
				eprocRequest = EprocurementRequestLocalServiceUtil
						.getEprocurementRequest(eprocurementProcessInfo.getRequestId());
			} catch (PortalException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}

			return eprocRequest;
		}
		
		 public  EprocurementRequest getEProcurementRequest(long eProcRequestId) 
		    {
		        EprocurementRequest eprocurementRequest = null;
		        
		            try {
						eprocurementRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(eProcRequestId);
					} catch (PortalException e) {
						if (LOGGER.isDebugEnabled()){
							LOGGER.error(e.getMessage(), e);
						}
					} catch (SystemException e) {
						if (LOGGER.isDebugEnabled()){
							LOGGER.error(e.getMessage(), e);
						}
					}
		        
		        return eprocurementRequest;
		    }

		    public String sayHello(String name) 
		    {
		        String result;
		        result = "say hello";
		        return result;
		    }

		public void sendNotificationByInitialApprover(long requestId,String viewRequestUrl) {
			EprocurementRequest eprocRequest = null;
			try {
				eprocRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
			} catch (PortalException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			//EProcurementRequestTrackerWSUtil.sendEmailByInitialApprover(viewRequestUrl, eprocRequest);

		}

		public EprocurementRequest updateEProcurementRequest(long eProcRequestId,
				String status, String reason)

		{
			EprocurementRequest eprocurementRequest = null;
			try {
				eprocurementRequest = EprocurementRequestLocalServiceUtil
						.getEprocurementRequest(eProcRequestId);
				eprocurementRequest.setStatus(status);
				if (Validator.isNotNull(reason)) {
					eprocurementRequest.setReason(reason);
				}
				eprocurementRequest = EprocurementRequestLocalServiceUtil
						.updateEprocurementRequest(eprocurementRequest);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			} catch (PortalException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}

			// sendNotificationByInitialApprover(eProcRequestId, "viewRequestUrl");
			return eprocurementRequest;
		}
}