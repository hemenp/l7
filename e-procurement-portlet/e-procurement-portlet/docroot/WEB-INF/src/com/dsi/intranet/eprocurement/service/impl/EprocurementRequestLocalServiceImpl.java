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
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.base.EprocurementRequestLocalServiceBaseImpl;
import com.dsi.intranet.eprocurement.service.persistence.EprocurementRequestUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

/**
 * The implementation of the eprocurement request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dsi.intranet.eprocurement.service.EprocurementRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil
 */
public class EprocurementRequestLocalServiceImpl
	extends EprocurementRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil} to access the eprocurement request local service.
	 */
	 private static final Log LOGGER = LogFactoryUtil.getLog(EprocurementRequestLocalServiceImpl.class);

	    public EprocurementRequest addEprocurementRequest(EprocurementRequest eprocurementRequest, String[] itemRows)
	    {
	        EprocurementRequest eproRequest = null;
			try {
				eproRequest = EprocurementRequestLocalServiceUtil
				        .addEprocurementRequest(eprocurementRequest);
			} catch (SystemException e1) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e1.getMessage(), e1);
				}
			}

	        // Start: Indexing Request
	        int rowsLength = itemRows.length;
	        String[] itemName = new String[rowsLength];
	        String[] itemDescription = new String[rowsLength];
	        int count = 0;
	        for (String item : itemRows)
	        {
	            String[] itemValues = StringUtil.split(item, "^^^");
	            itemName[count] = itemValues[0];
	            itemDescription[count] = itemValues[1];
	            count = count + 1;
	        }

	       /* try
	        {
	            Indexer.addRequest(eprocurementRequest, itemName, itemDescription);
	        } catch (SearchException e)
	        {
	            LOGGER.error("Error while indexing request: " + e.getMessage());
	            if (LOGGER.isDebugEnabled()){
	            	LOGGER.error(e.getMessage(), e);
				}
	        }*/
	        // End: Indexing Request

	        return eproRequest;
	    }

	    public int countByStatus(long companyId, long groupId, java.lang.String status)
	    {
	        try {
				return EprocurementRequestUtil.countByStatus(companyId, groupId, status);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return 0;
	    }

	    public int countByStatusAndCity(long companyId, long groupId, String status, String city)
	    {
	        try {
				return EprocurementRequestUtil.countByStatusAddress(companyId, groupId, status, city);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return 0;
	    }

	    public List<com.dsi.intranet.eprocurement.model.EprocurementRequest> findByStatus(long companyId, long groupId,
	            String status, int start, int end) 
	    {
	        try {
				return EprocurementRequestUtil.findByStatus(companyId, groupId, status, start, end);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return null;
	    }

	    public List<com.dsi.intranet.eprocurement.model.EprocurementRequest> findByStatusAndCity(long companyId,
	            long groupId, String status, String city, int start, int end) 
	    {
	        try {
				return EprocurementRequestUtil.findByStatusAddress(companyId, groupId, status, city, start, end);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return null;
	    }

	  
	    public EprocurementRequest updateEprocurementRequest(EprocurementRequest eprocurementRequest)
	    {
	        try {
				//EprocurementRequest eprocureRequest = eprocurementRequestPersistence.update(eprocurementRequest,true);
				EprocurementRequest eprocureRequest = super.updateEprocurementRequest(eprocurementRequest);
				// Start: Indexing
				List<Item> items = ItemLocalServiceUtil.getItemsByRequestId(eprocureRequest.getRequestId());
				int rowsLength = items.size();
				String[] itemName = new String[rowsLength];
				String[] itemDescription = new String[rowsLength];
				int count = 0;
				for (Item requestItem : items)
				{
				    itemName[count] = requestItem.getItemName();
				    itemDescription[count] = requestItem.getItemDescription();
				    count = count + 1;
				}
				/*try
				{
				    Indexer.updateRequest(eprocureRequest, itemName, itemDescription);
				} catch (SearchException e)
				{
				    LOGGER.error("Error while updating request " + e.getMessage());
				}*/
				// End: Indexing

				return eprocureRequest;
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return eprocurementRequest;
	    }
}