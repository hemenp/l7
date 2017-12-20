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

package com.dsi.intranet.eprocurement.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.exception.NoSuchLocationException;
import com.dsi.intranet.eprocurement.model.EprocurementLocation;
import com.dsi.intranet.eprocurement.model.impl.EprocurementLocationImpl;
import com.dsi.intranet.eprocurement.model.impl.EprocurementLocationModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.EprocurementLocationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the eprocurement location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementLocationPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.EprocurementLocationUtil
 * @generated
 */
@ProviderType
public class EprocurementLocationPersistenceImpl extends BasePersistenceImpl<EprocurementLocation>
	implements EprocurementLocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprocurementLocationUtil} to access the eprocurement location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprocurementLocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationModelImpl.FINDER_CACHE_ENABLED,
			EprocurementLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationModelImpl.FINDER_CACHE_ENABLED,
			EprocurementLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EprocurementLocationPersistenceImpl() {
		setModelClass(EprocurementLocation.class);
	}

	/**
	 * Caches the eprocurement location in the entity cache if it is enabled.
	 *
	 * @param eprocurementLocation the eprocurement location
	 */
	@Override
	public void cacheResult(EprocurementLocation eprocurementLocation) {
		entityCache.putResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationImpl.class,
			eprocurementLocation.getPrimaryKey(), eprocurementLocation);

		eprocurementLocation.resetOriginalValues();
	}

	/**
	 * Caches the eprocurement locations in the entity cache if it is enabled.
	 *
	 * @param eprocurementLocations the eprocurement locations
	 */
	@Override
	public void cacheResult(List<EprocurementLocation> eprocurementLocations) {
		for (EprocurementLocation eprocurementLocation : eprocurementLocations) {
			if (entityCache.getResult(
						EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
						EprocurementLocationImpl.class,
						eprocurementLocation.getPrimaryKey()) == null) {
				cacheResult(eprocurementLocation);
			}
			else {
				eprocurementLocation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprocurement locations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EprocurementLocationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprocurement location.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EprocurementLocation eprocurementLocation) {
		entityCache.removeResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationImpl.class, eprocurementLocation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EprocurementLocation> eprocurementLocations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EprocurementLocation eprocurementLocation : eprocurementLocations) {
			entityCache.removeResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
				EprocurementLocationImpl.class,
				eprocurementLocation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new eprocurement location with the primary key. Does not add the eprocurement location to the database.
	 *
	 * @param locationId the primary key for the new eprocurement location
	 * @return the new eprocurement location
	 */
	@Override
	public EprocurementLocation create(String locationId) {
		EprocurementLocation eprocurementLocation = new EprocurementLocationImpl();

		eprocurementLocation.setNew(true);
		eprocurementLocation.setPrimaryKey(locationId);

		eprocurementLocation.setCompanyId(companyProvider.getCompanyId());

		return eprocurementLocation;
	}

	/**
	 * Removes the eprocurement location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the eprocurement location
	 * @return the eprocurement location that was removed
	 * @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation remove(String locationId)
		throws NoSuchLocationException {
		return remove((Serializable)locationId);
	}

	/**
	 * Removes the eprocurement location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprocurement location
	 * @return the eprocurement location that was removed
	 * @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation remove(Serializable primaryKey)
		throws NoSuchLocationException {
		Session session = null;

		try {
			session = openSession();

			EprocurementLocation eprocurementLocation = (EprocurementLocation)session.get(EprocurementLocationImpl.class,
					primaryKey);

			if (eprocurementLocation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprocurementLocation);
		}
		catch (NoSuchLocationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EprocurementLocation removeImpl(
		EprocurementLocation eprocurementLocation) {
		eprocurementLocation = toUnwrappedModel(eprocurementLocation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eprocurementLocation)) {
				eprocurementLocation = (EprocurementLocation)session.get(EprocurementLocationImpl.class,
						eprocurementLocation.getPrimaryKeyObj());
			}

			if (eprocurementLocation != null) {
				session.delete(eprocurementLocation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eprocurementLocation != null) {
			clearCache(eprocurementLocation);
		}

		return eprocurementLocation;
	}

	@Override
	public EprocurementLocation updateImpl(
		EprocurementLocation eprocurementLocation) {
		eprocurementLocation = toUnwrappedModel(eprocurementLocation);

		boolean isNew = eprocurementLocation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eprocurementLocation.isNew()) {
				session.save(eprocurementLocation);

				eprocurementLocation.setNew(false);
			}
			else {
				eprocurementLocation = (EprocurementLocation)session.merge(eprocurementLocation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementLocationImpl.class,
			eprocurementLocation.getPrimaryKey(), eprocurementLocation, false);

		eprocurementLocation.resetOriginalValues();

		return eprocurementLocation;
	}

	protected EprocurementLocation toUnwrappedModel(
		EprocurementLocation eprocurementLocation) {
		if (eprocurementLocation instanceof EprocurementLocationImpl) {
			return eprocurementLocation;
		}

		EprocurementLocationImpl eprocurementLocationImpl = new EprocurementLocationImpl();

		eprocurementLocationImpl.setNew(eprocurementLocation.isNew());
		eprocurementLocationImpl.setPrimaryKey(eprocurementLocation.getPrimaryKey());

		eprocurementLocationImpl.setLocationId(eprocurementLocation.getLocationId());
		eprocurementLocationImpl.setCompanyId(eprocurementLocation.getCompanyId());
		eprocurementLocationImpl.setLocation(eprocurementLocation.getLocation());
		eprocurementLocationImpl.setFlowType(eprocurementLocation.getFlowType());
		eprocurementLocationImpl.setLocationType(eprocurementLocation.getLocationType());
		eprocurementLocationImpl.setAddress(eprocurementLocation.getAddress());
		eprocurementLocationImpl.setPersonnelArea(eprocurementLocation.getPersonnelArea());
		eprocurementLocationImpl.setPersonnelSubArea(eprocurementLocation.getPersonnelSubArea());
		eprocurementLocationImpl.setBuildingNumber(eprocurementLocation.getBuildingNumber());
		eprocurementLocationImpl.setAppName(eprocurementLocation.getAppName());

		return eprocurementLocationImpl;
	}

	/**
	 * Returns the eprocurement location with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprocurement location
	 * @return the eprocurement location
	 * @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocationException {
		EprocurementLocation eprocurementLocation = fetchByPrimaryKey(primaryKey);

		if (eprocurementLocation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eprocurementLocation;
	}

	/**
	 * Returns the eprocurement location with the primary key or throws a {@link NoSuchLocationException} if it could not be found.
	 *
	 * @param locationId the primary key of the eprocurement location
	 * @return the eprocurement location
	 * @throws NoSuchLocationException if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation findByPrimaryKey(String locationId)
		throws NoSuchLocationException {
		return findByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns the eprocurement location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprocurement location
	 * @return the eprocurement location, or <code>null</code> if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
				EprocurementLocationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EprocurementLocation eprocurementLocation = (EprocurementLocation)serializable;

		if (eprocurementLocation == null) {
			Session session = null;

			try {
				session = openSession();

				eprocurementLocation = (EprocurementLocation)session.get(EprocurementLocationImpl.class,
						primaryKey);

				if (eprocurementLocation != null) {
					cacheResult(eprocurementLocation);
				}
				else {
					entityCache.putResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
						EprocurementLocationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementLocationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eprocurementLocation;
	}

	/**
	 * Returns the eprocurement location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the eprocurement location
	 * @return the eprocurement location, or <code>null</code> if a eprocurement location with the primary key could not be found
	 */
	@Override
	public EprocurementLocation fetchByPrimaryKey(String locationId) {
		return fetchByPrimaryKey((Serializable)locationId);
	}

	@Override
	public Map<Serializable, EprocurementLocation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EprocurementLocation> map = new HashMap<Serializable, EprocurementLocation>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EprocurementLocation eprocurementLocation = fetchByPrimaryKey(primaryKey);

			if (eprocurementLocation != null) {
				map.put(primaryKey, eprocurementLocation);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementLocationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EprocurementLocation)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EPROCUREMENTLOCATION_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			query.append(StringPool.QUESTION);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				qPos.add((String)primaryKey);
			}

			for (EprocurementLocation eprocurementLocation : (List<EprocurementLocation>)q.list()) {
				map.put(eprocurementLocation.getPrimaryKeyObj(),
					eprocurementLocation);

				cacheResult(eprocurementLocation);

				uncachedPrimaryKeys.remove(eprocurementLocation.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EprocurementLocationModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementLocationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the eprocurement locations.
	 *
	 * @return the eprocurement locations
	 */
	@Override
	public List<EprocurementLocation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EprocurementLocation> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EprocurementLocation> findAll(int start, int end,
		OrderByComparator<EprocurementLocation> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EprocurementLocation> findAll(int start, int end,
		OrderByComparator<EprocurementLocation> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EprocurementLocation> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementLocation>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EPROCUREMENTLOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPROCUREMENTLOCATION;

				if (pagination) {
					sql = sql.concat(EprocurementLocationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EprocurementLocation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementLocation>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the eprocurement locations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EprocurementLocation eprocurementLocation : findAll()) {
			remove(eprocurementLocation);
		}
	}

	/**
	 * Returns the number of eprocurement locations.
	 *
	 * @return the number of eprocurement locations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EPROCUREMENTLOCATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EprocurementLocationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the eprocurement location persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EprocurementLocationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_EPROCUREMENTLOCATION = "SELECT eprocurementLocation FROM EprocurementLocation eprocurementLocation";
	private static final String _SQL_SELECT_EPROCUREMENTLOCATION_WHERE_PKS_IN = "SELECT eprocurementLocation FROM EprocurementLocation eprocurementLocation WHERE locationId IN (";
	private static final String _SQL_COUNT_EPROCUREMENTLOCATION = "SELECT COUNT(eprocurementLocation) FROM EprocurementLocation eprocurementLocation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprocurementLocation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EprocurementLocation exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(EprocurementLocationPersistenceImpl.class);
}