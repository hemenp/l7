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

import com.dsi.intranet.eprocurement.exception.NoSuchLocationException;
import com.dsi.intranet.eprocurement.model.EprocurementLocation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the eprocurement location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementLocationPersistenceImpl
 * @see EprocurementLocationUtil
 * @generated
 */
@ProviderType
public interface EprocurementLocationPersistence extends BasePersistence<EprocurementLocation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprocurementLocationUtil} to access the eprocurement location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eprocurement location in the entity cache if it is enabled.
	*
	* @param eprocurementLocation the eprocurement location
	*/
	public void cacheResult(EprocurementLocation eprocurementLocation);

	/**
	* Caches the eprocurement locations in the entity cache if it is enabled.
	*
	* @param eprocurementLocations the eprocurement locations
	*/
	public void cacheResult(
		java.util.List<EprocurementLocation> eprocurementLocations);

	/**
	* Creates a new eprocurement location with the primary key. Does not add the eprocurement location to the database.
	*
	* @param locationId the primary key for the new eprocurement location
	* @return the new eprocurement location
	*/
	public EprocurementLocation create(java.lang.String locationId);

	/**
	* Removes the eprocurement location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location that was removed
	* @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	*/
	public EprocurementLocation remove(java.lang.String locationId)
		throws NoSuchLocationException;

	public EprocurementLocation updateImpl(
		EprocurementLocation eprocurementLocation);

	/**
	* Returns the eprocurement location with the primary key or throws a {@link NoSuchLocationException} if it could not be found.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location
	* @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	*/
	public EprocurementLocation findByPrimaryKey(java.lang.String locationId)
		throws NoSuchLocationException;

	/**
	* Returns the eprocurement location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location, or <code>null</code> if a eprocurement location with the primary key could not be found
	*/
	public EprocurementLocation fetchByPrimaryKey(java.lang.String locationId);

	@Override
	public java.util.Map<java.io.Serializable, EprocurementLocation> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the eprocurement locations.
	*
	* @return the eprocurement locations
	*/
	public java.util.List<EprocurementLocation> findAll();

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
	public java.util.List<EprocurementLocation> findAll(int start, int end);

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
	public java.util.List<EprocurementLocation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementLocation> orderByComparator);

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
	public java.util.List<EprocurementLocation> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementLocation> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the eprocurement locations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of eprocurement locations.
	*
	* @return the number of eprocurement locations
	*/
	public int countAll();
}