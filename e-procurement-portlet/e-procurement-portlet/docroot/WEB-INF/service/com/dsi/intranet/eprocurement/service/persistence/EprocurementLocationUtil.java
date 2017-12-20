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

import com.dsi.intranet.eprocurement.model.EprocurementLocation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the eprocurement location service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementLocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementLocationPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementLocationPersistenceImpl
 * @generated
 */
@ProviderType
public class EprocurementLocationUtil {
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
	public static void clearCache(EprocurementLocation eprocurementLocation) {
		getPersistence().clearCache(eprocurementLocation);
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
	public static List<EprocurementLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EprocurementLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EprocurementLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EprocurementLocation> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EprocurementLocation update(
		EprocurementLocation eprocurementLocation) {
		return getPersistence().update(eprocurementLocation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EprocurementLocation update(
		EprocurementLocation eprocurementLocation, ServiceContext serviceContext) {
		return getPersistence().update(eprocurementLocation, serviceContext);
	}

	/**
	* Caches the eprocurement location in the entity cache if it is enabled.
	*
	* @param eprocurementLocation the eprocurement location
	*/
	public static void cacheResult(EprocurementLocation eprocurementLocation) {
		getPersistence().cacheResult(eprocurementLocation);
	}

	/**
	* Caches the eprocurement locations in the entity cache if it is enabled.
	*
	* @param eprocurementLocations the eprocurement locations
	*/
	public static void cacheResult(
		List<EprocurementLocation> eprocurementLocations) {
		getPersistence().cacheResult(eprocurementLocations);
	}

	/**
	* Creates a new eprocurement location with the primary key. Does not add the eprocurement location to the database.
	*
	* @param locationId the primary key for the new eprocurement location
	* @return the new eprocurement location
	*/
	public static EprocurementLocation create(java.lang.String locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the eprocurement location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location that was removed
	* @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	*/
	public static EprocurementLocation remove(java.lang.String locationId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchLocationException {
		return getPersistence().remove(locationId);
	}

	public static EprocurementLocation updateImpl(
		EprocurementLocation eprocurementLocation) {
		return getPersistence().updateImpl(eprocurementLocation);
	}

	/**
	* Returns the eprocurement location with the primary key or throws a {@link NoSuchLocationException} if it could not be found.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location
	* @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	*/
	public static EprocurementLocation findByPrimaryKey(
		java.lang.String locationId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchLocationException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the eprocurement location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location, or <code>null</code> if a eprocurement location with the primary key could not be found
	*/
	public static EprocurementLocation fetchByPrimaryKey(
		java.lang.String locationId) {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	public static java.util.Map<java.io.Serializable, EprocurementLocation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the eprocurement locations.
	*
	* @return the eprocurement locations
	*/
	public static List<EprocurementLocation> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the eprocurement locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement locations
	* @param end the upper bound of the range of eprocurement locations (not inclusive)
	* @return the range of eprocurement locations
	*/
	public static List<EprocurementLocation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the eprocurement locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement locations
	* @param end the upper bound of the range of eprocurement locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprocurement locations
	*/
	public static List<EprocurementLocation> findAll(int start, int end,
		OrderByComparator<EprocurementLocation> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eprocurement locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement locations
	* @param end the upper bound of the range of eprocurement locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of eprocurement locations
	*/
	public static List<EprocurementLocation> findAll(int start, int end,
		OrderByComparator<EprocurementLocation> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the eprocurement locations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eprocurement locations.
	*
	* @return the number of eprocurement locations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EprocurementLocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EprocurementLocationPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					EprocurementLocationPersistence.class.getName());

			ReferenceRegistry.registerReference(EprocurementLocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static EprocurementLocationPersistence _persistence;
}