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

package com.dsi.intranet.eprocurement.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.model.Item;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the item service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.ItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see ItemPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.ItemPersistenceImpl
 * @generated
 */
@ProviderType
public class ItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Item item) {
		getPersistence().clearCache(item);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Item> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Item> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Item update(Item item) {
		return getPersistence().update(item);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Item update(Item item, ServiceContext serviceContext) {
		return getPersistence().update(item, serviceContext);
	}

	/**
	* Returns the item where requestId = &#63; or throws a {@link NoSuchItemException} if it could not be found.
	*
	* @param requestId the request ID
	* @return the matching item
	* @throws NoSuchItemException if a matching item could not be found
	*/
	public static Item findByitem(long requestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().findByitem(requestId);
	}

	/**
	* Returns the item where requestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param requestId the request ID
	* @return the matching item, or <code>null</code> if a matching item could not be found
	*/
	public static Item fetchByitem(long requestId) {
		return getPersistence().fetchByitem(requestId);
	}

	/**
	* Returns the item where requestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param requestId the request ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching item, or <code>null</code> if a matching item could not be found
	*/
	public static Item fetchByitem(long requestId, boolean retrieveFromCache) {
		return getPersistence().fetchByitem(requestId, retrieveFromCache);
	}

	/**
	* Removes the item where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	* @return the item that was removed
	*/
	public static Item removeByitem(long requestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().removeByitem(requestId);
	}

	/**
	* Returns the number of items where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching items
	*/
	public static int countByitem(long requestId) {
		return getPersistence().countByitem(requestId);
	}

	/**
	* Returns all the items where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the matching items
	*/
	public static List<Item> findByitems(long requestId) {
		return getPersistence().findByitems(requestId);
	}

	/**
	* Returns a range of all the items where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of matching items
	*/
	public static List<Item> findByitems(long requestId, int start, int end) {
		return getPersistence().findByitems(requestId, start, end);
	}

	/**
	* Returns an ordered range of all the items where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching items
	*/
	public static List<Item> findByitems(long requestId, int start, int end,
		OrderByComparator<Item> orderByComparator) {
		return getPersistence()
				   .findByitems(requestId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the items where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching items
	*/
	public static List<Item> findByitems(long requestId, int start, int end,
		OrderByComparator<Item> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByitems(requestId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first item in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item
	* @throws NoSuchItemException if a matching item could not be found
	*/
	public static Item findByitems_First(long requestId,
		OrderByComparator<Item> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().findByitems_First(requestId, orderByComparator);
	}

	/**
	* Returns the first item in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item, or <code>null</code> if a matching item could not be found
	*/
	public static Item fetchByitems_First(long requestId,
		OrderByComparator<Item> orderByComparator) {
		return getPersistence().fetchByitems_First(requestId, orderByComparator);
	}

	/**
	* Returns the last item in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item
	* @throws NoSuchItemException if a matching item could not be found
	*/
	public static Item findByitems_Last(long requestId,
		OrderByComparator<Item> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().findByitems_Last(requestId, orderByComparator);
	}

	/**
	* Returns the last item in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item, or <code>null</code> if a matching item could not be found
	*/
	public static Item fetchByitems_Last(long requestId,
		OrderByComparator<Item> orderByComparator) {
		return getPersistence().fetchByitems_Last(requestId, orderByComparator);
	}

	/**
	* Returns the items before and after the current item in the ordered set where requestId = &#63;.
	*
	* @param itemId the primary key of the current item
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item
	* @throws NoSuchItemException if a item with the primary key could not be found
	*/
	public static Item[] findByitems_PrevAndNext(long itemId, long requestId,
		OrderByComparator<Item> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence()
				   .findByitems_PrevAndNext(itemId, requestId, orderByComparator);
	}

	/**
	* Removes all the items where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	*/
	public static void removeByitems(long requestId) {
		getPersistence().removeByitems(requestId);
	}

	/**
	* Returns the number of items where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching items
	*/
	public static int countByitems(long requestId) {
		return getPersistence().countByitems(requestId);
	}

	/**
	* Caches the item in the entity cache if it is enabled.
	*
	* @param item the item
	*/
	public static void cacheResult(Item item) {
		getPersistence().cacheResult(item);
	}

	/**
	* Caches the items in the entity cache if it is enabled.
	*
	* @param items the items
	*/
	public static void cacheResult(List<Item> items) {
		getPersistence().cacheResult(items);
	}

	/**
	* Creates a new item with the primary key. Does not add the item to the database.
	*
	* @param itemId the primary key for the new item
	* @return the new item
	*/
	public static Item create(long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the item
	* @return the item that was removed
	* @throws NoSuchItemException if a item with the primary key could not be found
	*/
	public static Item remove(long itemId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().remove(itemId);
	}

	public static Item updateImpl(Item item) {
		return getPersistence().updateImpl(item);
	}

	/**
	* Returns the item with the primary key or throws a {@link NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the item
	* @return the item
	* @throws NoSuchItemException if a item with the primary key could not be found
	*/
	public static Item findByPrimaryKey(long itemId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchItemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Returns the item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the item
	* @return the item, or <code>null</code> if a item with the primary key could not be found
	*/
	public static Item fetchByPrimaryKey(long itemId) {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	public static java.util.Map<java.io.Serializable, Item> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the items.
	*
	* @return the items
	*/
	public static List<Item> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @return the range of items
	*/
	public static List<Item> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of items
	*/
	public static List<Item> findAll(int start, int end,
		OrderByComparator<Item> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of items
	* @param end the upper bound of the range of items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of items
	*/
	public static List<Item> findAll(int start, int end,
		OrderByComparator<Item> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the items from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of items.
	*
	* @return the number of items
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ItemPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					ItemPersistence.class.getName());

			ReferenceRegistry.registerReference(ItemUtil.class, "_persistence");
		}

		return _persistence;
	}

	private static ItemPersistence _persistence;
}