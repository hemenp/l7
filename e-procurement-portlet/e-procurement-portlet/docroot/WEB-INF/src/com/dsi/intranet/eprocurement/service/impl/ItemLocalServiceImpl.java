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

import com.dsi.intranet.eprocurement.service.base.ItemLocalServiceBaseImpl;
import com.dsi.intranet.eprocurement.exception.NoSuchItemException;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.service.persistence.ItemUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dsi.intranet.eprocurement.service.ItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see ItemLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil
 */
public class ItemLocalServiceImpl extends ItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil} to access the item local service.
	 */
private static final Log LOGGER = LogFactoryUtil.getLog(ItemLocalServiceImpl.class);
	
    public Item getItemByRequestId(long requestId)
    throws NoSuchItemException {
            try {
				return ItemUtil.findByitem(requestId);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return null;

    }
    public List<Item> getItemsByRequestId(long requestId)
     {
            try {
				return ItemUtil.findByitems(requestId);
			} catch (SystemException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.error(e.getMessage(), e);
				}
			}
			return null;
    }
}