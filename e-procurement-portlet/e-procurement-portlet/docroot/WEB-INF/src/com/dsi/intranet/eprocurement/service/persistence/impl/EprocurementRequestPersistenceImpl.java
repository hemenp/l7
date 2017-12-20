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

import com.dsi.intranet.eprocurement.exception.NoSuchRequestException;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl;
import com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.EprocurementRequestPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the eprocurement request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.EprocurementRequestUtil
 * @generated
 */
@ProviderType
public class EprocurementRequestPersistenceImpl extends BasePersistenceImpl<EprocurementRequest>
	implements EprocurementRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EprocurementRequestUtil} to access the eprocurement request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EprocurementRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODIFIEDDATE =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModifiedDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModifiedDate",
			new String[] { Date.class.getName() },
			EprocurementRequestModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			EprocurementRequestModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODIFIEDDATE = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModifiedDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the eprocurement requests where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByModifiedDate(Date modifiedDate) {
		return findByModifiedDate(modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprocurement requests where modifiedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @return the range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByModifiedDate(Date modifiedDate,
		int start, int end) {
		return findByModifiedDate(modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where modifiedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByModifiedDate(Date modifiedDate,
		int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return findByModifiedDate(modifiedDate, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where modifiedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByModifiedDate(Date modifiedDate,
		int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE;
			finderArgs = new Object[] { modifiedDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODIFIEDDATE;
			finderArgs = new Object[] {
					modifiedDate,
					
					start, end, orderByComparator
				};
		}

		List<EprocurementRequest> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EprocurementRequest eprocurementRequest : list) {
					if (!Objects.equals(modifiedDate,
								eprocurementRequest.getModifiedDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (!pagination) {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
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
	 * Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByModifiedDate_First(Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByModifiedDate_First(modifiedDate,
				orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByModifiedDate_First(Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		List<EprocurementRequest> list = findByModifiedDate(modifiedDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByModifiedDate_Last(Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByModifiedDate_Last(modifiedDate,
				orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByModifiedDate_Last(Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		int count = countByModifiedDate(modifiedDate);

		if (count == 0) {
			return null;
		}

		List<EprocurementRequest> list = findByModifiedDate(modifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eprocurement requests before and after the current eprocurement request in the ordered set where modifiedDate = &#63;.
	 *
	 * @param requestId the primary key of the current eprocurement request
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest[] findByModifiedDate_PrevAndNext(
		long requestId, Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EprocurementRequest[] array = new EprocurementRequestImpl[3];

			array[0] = getByModifiedDate_PrevAndNext(session,
					eprocurementRequest, modifiedDate, orderByComparator, true);

			array[1] = eprocurementRequest;

			array[2] = getByModifiedDate_PrevAndNext(session,
					eprocurementRequest, modifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EprocurementRequest getByModifiedDate_PrevAndNext(
		Session session, EprocurementRequest eprocurementRequest,
		Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindModifiedDate) {
			qPos.add(new Timestamp(modifiedDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eprocurementRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EprocurementRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eprocurement requests where modifiedDate = &#63; from the database.
	 *
	 * @param modifiedDate the modified date
	 */
	@Override
	public void removeByModifiedDate(Date modifiedDate) {
		for (EprocurementRequest eprocurementRequest : findByModifiedDate(
				modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eprocurementRequest);
		}
	}

	/**
	 * Returns the number of eprocurement requests where modifiedDate = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the number of matching eprocurement requests
	 */
	@Override
	public int countByModifiedDate(Date modifiedDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODIFIEDDATE;

		Object[] finderArgs = new Object[] { modifiedDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPROCUREMENTREQUEST_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_1 = "eprocurementRequest.modifiedDate IS NULL";
	private static final String _FINDER_COLUMN_MODIFIEDDATE_MODIFIEDDATE_2 = "eprocurementRequest.modifiedDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTORNAME =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestorName",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestorName",
			new String[] { Long.class.getName() },
			EprocurementRequestModelImpl.REQUESTORID_COLUMN_BITMASK |
			EprocurementRequestModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			EprocurementRequestModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTORNAME = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestorName",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the eprocurement requests where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @return the matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByRequestorName(long requestorId) {
		return findByRequestorName(requestorId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprocurement requests where requestorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestorId the requestor ID
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @return the range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByRequestorName(long requestorId,
		int start, int end) {
		return findByRequestorName(requestorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where requestorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestorId the requestor ID
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByRequestorName(long requestorId,
		int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return findByRequestorName(requestorId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where requestorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestorId the requestor ID
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByRequestorName(long requestorId,
		int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME;
			finderArgs = new Object[] { requestorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTORNAME;
			finderArgs = new Object[] { requestorId, start, end, orderByComparator };
		}

		List<EprocurementRequest> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EprocurementRequest eprocurementRequest : list) {
					if ((requestorId != eprocurementRequest.getRequestorId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTORNAME_REQUESTORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestorId);

				if (!pagination) {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
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
	 * Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByRequestorName_First(long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByRequestorName_First(requestorId,
				orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestorId=");
		msg.append(requestorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByRequestorName_First(long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		List<EprocurementRequest> list = findByRequestorName(requestorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByRequestorName_Last(long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByRequestorName_Last(requestorId,
				orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestorId=");
		msg.append(requestorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByRequestorName_Last(long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		int count = countByRequestorName(requestorId);

		if (count == 0) {
			return null;
		}

		List<EprocurementRequest> list = findByRequestorName(requestorId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eprocurement requests before and after the current eprocurement request in the ordered set where requestorId = &#63;.
	 *
	 * @param requestId the primary key of the current eprocurement request
	 * @param requestorId the requestor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest[] findByRequestorName_PrevAndNext(
		long requestId, long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EprocurementRequest[] array = new EprocurementRequestImpl[3];

			array[0] = getByRequestorName_PrevAndNext(session,
					eprocurementRequest, requestorId, orderByComparator, true);

			array[1] = eprocurementRequest;

			array[2] = getByRequestorName_PrevAndNext(session,
					eprocurementRequest, requestorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EprocurementRequest getByRequestorName_PrevAndNext(
		Session session, EprocurementRequest eprocurementRequest,
		long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

		query.append(_FINDER_COLUMN_REQUESTORNAME_REQUESTORID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(requestorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eprocurementRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EprocurementRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eprocurement requests where requestorId = &#63; from the database.
	 *
	 * @param requestorId the requestor ID
	 */
	@Override
	public void removeByRequestorName(long requestorId) {
		for (EprocurementRequest eprocurementRequest : findByRequestorName(
				requestorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eprocurementRequest);
		}
	}

	/**
	 * Returns the number of eprocurement requests where requestorId = &#63;.
	 *
	 * @param requestorId the requestor ID
	 * @return the number of matching eprocurement requests
	 */
	@Override
	public int countByRequestorName(long requestorId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REQUESTORNAME;

		Object[] finderArgs = new Object[] { requestorId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_REQUESTORNAME_REQUESTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestorId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REQUESTORNAME_REQUESTORID_2 = "eprocurementRequest.requestorId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByeprocurementrequest",
			new String[] { Date.class.getName(), Long.class.getName() },
			EprocurementRequestModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			EprocurementRequestModelImpl.REQUESTORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EPROCUREMENTREQUEST = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByeprocurementrequest",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or throws a {@link NoSuchRequestException} if it could not be found.
	 *
	 * @param modifiedDate the modified date
	 * @param requestorId the requestor ID
	 * @return the matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByeprocurementrequest(Date modifiedDate,
		long requestorId) throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByeprocurementrequest(modifiedDate,
				requestorId);

		if (eprocurementRequest == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("modifiedDate=");
			msg.append(modifiedDate);

			msg.append(", requestorId=");
			msg.append(requestorId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRequestException(msg.toString());
		}

		return eprocurementRequest;
	}

	/**
	 * Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param modifiedDate the modified date
	 * @param requestorId the requestor ID
	 * @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByeprocurementrequest(Date modifiedDate,
		long requestorId) {
		return fetchByeprocurementrequest(modifiedDate, requestorId, true);
	}

	/**
	 * Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param modifiedDate the modified date
	 * @param requestorId the requestor ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByeprocurementrequest(Date modifiedDate,
		long requestorId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { modifiedDate, requestorId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
					finderArgs, this);
		}

		if (result instanceof EprocurementRequest) {
			EprocurementRequest eprocurementRequest = (EprocurementRequest)result;

			if (!Objects.equals(modifiedDate,
						eprocurementRequest.getModifiedDate()) ||
					(requestorId != eprocurementRequest.getRequestorId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_2);
			}

			query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_REQUESTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				qPos.add(requestorId);

				List<EprocurementRequest> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EprocurementRequestPersistenceImpl.fetchByeprocurementrequest(Date, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EprocurementRequest eprocurementRequest = list.get(0);

					result = eprocurementRequest;

					cacheResult(eprocurementRequest);

					if ((eprocurementRequest.getModifiedDate() == null) ||
							!eprocurementRequest.getModifiedDate()
													.equals(modifiedDate) ||
							(eprocurementRequest.getRequestorId() != requestorId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
							finderArgs, eprocurementRequest);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EprocurementRequest)result;
		}
	}

	/**
	 * Removes the eprocurement request where modifiedDate = &#63; and requestorId = &#63; from the database.
	 *
	 * @param modifiedDate the modified date
	 * @param requestorId the requestor ID
	 * @return the eprocurement request that was removed
	 */
	@Override
	public EprocurementRequest removeByeprocurementrequest(Date modifiedDate,
		long requestorId) throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = findByeprocurementrequest(modifiedDate,
				requestorId);

		return remove(eprocurementRequest);
	}

	/**
	 * Returns the number of eprocurement requests where modifiedDate = &#63; and requestorId = &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param requestorId the requestor ID
	 * @return the number of matching eprocurement requests
	 */
	@Override
	public int countByeprocurementrequest(Date modifiedDate, long requestorId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EPROCUREMENTREQUEST;

		Object[] finderArgs = new Object[] { modifiedDate, requestorId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EPROCUREMENTREQUEST_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_2);
			}

			query.append(_FINDER_COLUMN_EPROCUREMENTREQUEST_REQUESTORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				qPos.add(requestorId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_1 =
		"eprocurementRequest.modifiedDate IS NULL AND ";
	private static final String _FINDER_COLUMN_EPROCUREMENTREQUEST_MODIFIEDDATE_2 =
		"eprocurementRequest.modifiedDate = ? AND ";
	private static final String _FINDER_COLUMN_EPROCUREMENTREQUEST_REQUESTORID_2 =
		"eprocurementRequest.requestorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			EprocurementRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			EprocurementRequestModelImpl.GROUPID_COLUMN_BITMASK |
			EprocurementRequestModelImpl.STATUS_COLUMN_BITMASK |
			EprocurementRequestModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			EprocurementRequestModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatus(long companyId, long groupId,
		String status) {
		return findByStatus(companyId, groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @return the range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatus(long companyId, long groupId,
		String status, int start, int end) {
		return findByStatus(companyId, groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatus(long companyId, long groupId,
		String status, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return findByStatus(companyId, groupId, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatus(long companyId, long groupId,
		String status, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { companyId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					companyId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<EprocurementRequest> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EprocurementRequest eprocurementRequest : list) {
					if ((companyId != eprocurementRequest.getCompanyId()) ||
							(groupId != eprocurementRequest.getGroupId()) ||
							!Objects.equals(status,
								eprocurementRequest.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
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
	 * Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByStatus_First(long companyId, long groupId,
		String status, OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByStatus_First(companyId,
				groupId, status, orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByStatus_First(long companyId,
		long groupId, String status,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		List<EprocurementRequest> list = findByStatus(companyId, groupId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByStatus_Last(long companyId, long groupId,
		String status, OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByStatus_Last(companyId,
				groupId, status, orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByStatus_Last(long companyId, long groupId,
		String status, OrderByComparator<EprocurementRequest> orderByComparator) {
		int count = countByStatus(companyId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<EprocurementRequest> list = findByStatus(companyId, groupId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eprocurement requests before and after the current eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param requestId the primary key of the current eprocurement request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest[] findByStatus_PrevAndNext(long requestId,
		long companyId, long groupId, String status,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EprocurementRequest[] array = new EprocurementRequestImpl[3];

			array[0] = getByStatus_PrevAndNext(session, eprocurementRequest,
					companyId, groupId, status, orderByComparator, true);

			array[1] = eprocurementRequest;

			array[2] = getByStatus_PrevAndNext(session, eprocurementRequest,
					companyId, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EprocurementRequest getByStatus_PrevAndNext(Session session,
		EprocurementRequest eprocurementRequest, long companyId, long groupId,
		String status,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

		query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eprocurementRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EprocurementRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long companyId, long groupId, String status) {
		for (EprocurementRequest eprocurementRequest : findByStatus(companyId,
				groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eprocurementRequest);
		}
	}

	/**
	 * Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching eprocurement requests
	 */
	@Override
	public int countByStatus(long companyId, long groupId, String status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { companyId, groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindStatus) {
					qPos.add(status);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_COMPANYID_2 = "eprocurementRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 = "eprocurementRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "eprocurementRequest.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "eprocurementRequest.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(eprocurementRequest.status IS NULL OR eprocurementRequest.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSADDRESS =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAddress",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS =
		new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED,
			EprocurementRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAddress",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			EprocurementRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			EprocurementRequestModelImpl.GROUPID_COLUMN_BITMASK |
			EprocurementRequestModelImpl.STATUS_COLUMN_BITMASK |
			EprocurementRequestModelImpl.CITY_COLUMN_BITMASK |
			EprocurementRequestModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			EprocurementRequestModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSADDRESS = new FinderPath(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusAddress",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @return the matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatusAddress(long companyId,
		long groupId, String status, String city) {
		return findByStatusAddress(companyId, groupId, status, city,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @return the range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatusAddress(long companyId,
		long groupId, String status, String city, int start, int end) {
		return findByStatusAddress(companyId, groupId, status, city, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatusAddress(long companyId,
		long groupId, String status, String city, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return findByStatusAddress(companyId, groupId, status, city, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findByStatusAddress(long companyId,
		long groupId, String status, String city, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS;
			finderArgs = new Object[] { companyId, groupId, status, city };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSADDRESS;
			finderArgs = new Object[] {
					companyId, groupId, status, city,
					
					start, end, orderByComparator
				};
		}

		List<EprocurementRequest> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EprocurementRequest eprocurementRequest : list) {
					if ((companyId != eprocurementRequest.getCompanyId()) ||
							(groupId != eprocurementRequest.getGroupId()) ||
							!Objects.equals(status,
								eprocurementRequest.getStatus()) ||
							!Objects.equals(city, eprocurementRequest.getCity())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STATUSADDRESS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSADDRESS_GROUPID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_2);
			}

			boolean bindCity = false;

			if (city == null) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_1);
			}
			else if (city.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_3);
			}
			else {
				bindCity = true;

				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindCity) {
					qPos.add(city);
				}

				if (!pagination) {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
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
	 * Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByStatusAddress_First(long companyId,
		long groupId, String status, String city,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByStatusAddress_First(companyId,
				groupId, status, city, orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", city=");
		msg.append(city);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByStatusAddress_First(long companyId,
		long groupId, String status, String city,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		List<EprocurementRequest> list = findByStatusAddress(companyId,
				groupId, status, city, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request
	 * @throws NoSuchRequestException if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest findByStatusAddress_Last(long companyId,
		long groupId, String status, String city,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByStatusAddress_Last(companyId,
				groupId, status, city, orderByComparator);

		if (eprocurementRequest != null) {
			return eprocurementRequest;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", city=");
		msg.append(city);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestException(msg.toString());
	}

	/**
	 * Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	 */
	@Override
	public EprocurementRequest fetchByStatusAddress_Last(long companyId,
		long groupId, String status, String city,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		int count = countByStatusAddress(companyId, groupId, status, city);

		if (count == 0) {
			return null;
		}

		List<EprocurementRequest> list = findByStatusAddress(companyId,
				groupId, status, city, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the eprocurement requests before and after the current eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param requestId the primary key of the current eprocurement request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest[] findByStatusAddress_PrevAndNext(
		long requestId, long companyId, long groupId, String status,
		String city, OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EprocurementRequest[] array = new EprocurementRequestImpl[3];

			array[0] = getByStatusAddress_PrevAndNext(session,
					eprocurementRequest, companyId, groupId, status, city,
					orderByComparator, true);

			array[1] = eprocurementRequest;

			array[2] = getByStatusAddress_PrevAndNext(session,
					eprocurementRequest, companyId, groupId, status, city,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EprocurementRequest getByStatusAddress_PrevAndNext(
		Session session, EprocurementRequest eprocurementRequest,
		long companyId, long groupId, String status, String city,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE);

		query.append(_FINDER_COLUMN_STATUSADDRESS_COMPANYID_2);

		query.append(_FINDER_COLUMN_STATUSADDRESS_GROUPID_2);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_2);
		}

		boolean bindCity = false;

		if (city == null) {
			query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_1);
		}
		else if (city.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_3);
		}
		else {
			bindCity = true;

			query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EprocurementRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (bindStatus) {
			qPos.add(status);
		}

		if (bindCity) {
			qPos.add(city);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eprocurementRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EprocurementRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 */
	@Override
	public void removeByStatusAddress(long companyId, long groupId,
		String status, String city) {
		for (EprocurementRequest eprocurementRequest : findByStatusAddress(
				companyId, groupId, status, city, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eprocurementRequest);
		}
	}

	/**
	 * Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param city the city
	 * @return the number of matching eprocurement requests
	 */
	@Override
	public int countByStatusAddress(long companyId, long groupId,
		String status, String city) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSADDRESS;

		Object[] finderArgs = new Object[] { companyId, groupId, status, city };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EPROCUREMENTREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STATUSADDRESS_COMPANYID_2);

			query.append(_FINDER_COLUMN_STATUSADDRESS_GROUPID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUSADDRESS_STATUS_2);
			}

			boolean bindCity = false;

			if (city == null) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_1);
			}
			else if (city.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_3);
			}
			else {
				bindCity = true;

				query.append(_FINDER_COLUMN_STATUSADDRESS_CITY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindStatus) {
					qPos.add(status);
				}

				if (bindCity) {
					qPos.add(city);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUSADDRESS_COMPANYID_2 = "eprocurementRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSADDRESS_GROUPID_2 = "eprocurementRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSADDRESS_STATUS_1 = "eprocurementRequest.status IS NULL AND ";
	private static final String _FINDER_COLUMN_STATUSADDRESS_STATUS_2 = "eprocurementRequest.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSADDRESS_STATUS_3 = "(eprocurementRequest.status IS NULL OR eprocurementRequest.status = '') AND ";
	private static final String _FINDER_COLUMN_STATUSADDRESS_CITY_1 = "eprocurementRequest.city IS NULL";
	private static final String _FINDER_COLUMN_STATUSADDRESS_CITY_2 = "eprocurementRequest.city = ?";
	private static final String _FINDER_COLUMN_STATUSADDRESS_CITY_3 = "(eprocurementRequest.city IS NULL OR eprocurementRequest.city = '')";

	public EprocurementRequestPersistenceImpl() {
		setModelClass(EprocurementRequest.class);
	}

	/**
	 * Caches the eprocurement request in the entity cache if it is enabled.
	 *
	 * @param eprocurementRequest the eprocurement request
	 */
	@Override
	public void cacheResult(EprocurementRequest eprocurementRequest) {
		entityCache.putResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestImpl.class, eprocurementRequest.getPrimaryKey(),
			eprocurementRequest);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
			new Object[] {
				eprocurementRequest.getModifiedDate(),
				eprocurementRequest.getRequestorId()
			}, eprocurementRequest);

		eprocurementRequest.resetOriginalValues();
	}

	/**
	 * Caches the eprocurement requests in the entity cache if it is enabled.
	 *
	 * @param eprocurementRequests the eprocurement requests
	 */
	@Override
	public void cacheResult(List<EprocurementRequest> eprocurementRequests) {
		for (EprocurementRequest eprocurementRequest : eprocurementRequests) {
			if (entityCache.getResult(
						EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
						EprocurementRequestImpl.class,
						eprocurementRequest.getPrimaryKey()) == null) {
				cacheResult(eprocurementRequest);
			}
			else {
				eprocurementRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eprocurement requests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EprocurementRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the eprocurement request.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EprocurementRequest eprocurementRequest) {
		entityCache.removeResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestImpl.class, eprocurementRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EprocurementRequestModelImpl)eprocurementRequest,
			true);
	}

	@Override
	public void clearCache(List<EprocurementRequest> eprocurementRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EprocurementRequest eprocurementRequest : eprocurementRequests) {
			entityCache.removeResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
				EprocurementRequestImpl.class,
				eprocurementRequest.getPrimaryKey());

			clearUniqueFindersCache((EprocurementRequestModelImpl)eprocurementRequest,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		EprocurementRequestModelImpl eprocurementRequestModelImpl) {
		Object[] args = new Object[] {
				eprocurementRequestModelImpl.getModifiedDate(),
				eprocurementRequestModelImpl.getRequestorId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EPROCUREMENTREQUEST, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST, args,
			eprocurementRequestModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EprocurementRequestModelImpl eprocurementRequestModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					eprocurementRequestModelImpl.getModifiedDate(),
					eprocurementRequestModelImpl.getRequestorId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EPROCUREMENTREQUEST,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
				args);
		}

		if ((eprocurementRequestModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					eprocurementRequestModelImpl.getOriginalModifiedDate(),
					eprocurementRequestModelImpl.getOriginalRequestorId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EPROCUREMENTREQUEST,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EPROCUREMENTREQUEST,
				args);
		}
	}

	/**
	 * Creates a new eprocurement request with the primary key. Does not add the eprocurement request to the database.
	 *
	 * @param requestId the primary key for the new eprocurement request
	 * @return the new eprocurement request
	 */
	@Override
	public EprocurementRequest create(long requestId) {
		EprocurementRequest eprocurementRequest = new EprocurementRequestImpl();

		eprocurementRequest.setNew(true);
		eprocurementRequest.setPrimaryKey(requestId);

		eprocurementRequest.setCompanyId(companyProvider.getCompanyId());

		return eprocurementRequest;
	}

	/**
	 * Removes the eprocurement request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the eprocurement request
	 * @return the eprocurement request that was removed
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest remove(long requestId)
		throws NoSuchRequestException {
		return remove((Serializable)requestId);
	}

	/**
	 * Removes the eprocurement request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the eprocurement request
	 * @return the eprocurement request that was removed
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest remove(Serializable primaryKey)
		throws NoSuchRequestException {
		Session session = null;

		try {
			session = openSession();

			EprocurementRequest eprocurementRequest = (EprocurementRequest)session.get(EprocurementRequestImpl.class,
					primaryKey);

			if (eprocurementRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eprocurementRequest);
		}
		catch (NoSuchRequestException nsee) {
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
	protected EprocurementRequest removeImpl(
		EprocurementRequest eprocurementRequest) {
		eprocurementRequest = toUnwrappedModel(eprocurementRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eprocurementRequest)) {
				eprocurementRequest = (EprocurementRequest)session.get(EprocurementRequestImpl.class,
						eprocurementRequest.getPrimaryKeyObj());
			}

			if (eprocurementRequest != null) {
				session.delete(eprocurementRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eprocurementRequest != null) {
			clearCache(eprocurementRequest);
		}

		return eprocurementRequest;
	}

	@Override
	public EprocurementRequest updateImpl(
		EprocurementRequest eprocurementRequest) {
		eprocurementRequest = toUnwrappedModel(eprocurementRequest);

		boolean isNew = eprocurementRequest.isNew();

		EprocurementRequestModelImpl eprocurementRequestModelImpl = (EprocurementRequestModelImpl)eprocurementRequest;

		Session session = null;

		try {
			session = openSession();

			if (eprocurementRequest.isNew()) {
				session.save(eprocurementRequest);

				eprocurementRequest.setNew(false);
			}
			else {
				eprocurementRequest = (EprocurementRequest)session.merge(eprocurementRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EprocurementRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					eprocurementRequestModelImpl.getModifiedDate()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MODIFIEDDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE,
				args);

			args = new Object[] { eprocurementRequestModelImpl.getRequestorId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUESTORNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME,
				args);

			args = new Object[] {
					eprocurementRequestModelImpl.getCompanyId(),
					eprocurementRequestModelImpl.getGroupId(),
					eprocurementRequestModelImpl.getStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			args = new Object[] {
					eprocurementRequestModelImpl.getCompanyId(),
					eprocurementRequestModelImpl.getGroupId(),
					eprocurementRequestModelImpl.getStatus(),
					eprocurementRequestModelImpl.getCity()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUSADDRESS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((eprocurementRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprocurementRequestModelImpl.getOriginalModifiedDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MODIFIEDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE,
					args);

				args = new Object[] {
						eprocurementRequestModelImpl.getModifiedDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MODIFIEDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODIFIEDDATE,
					args);
			}

			if ((eprocurementRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprocurementRequestModelImpl.getOriginalRequestorId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUESTORNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME,
					args);

				args = new Object[] {
						eprocurementRequestModelImpl.getRequestorId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUESTORNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTORNAME,
					args);
			}

			if ((eprocurementRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprocurementRequestModelImpl.getOriginalCompanyId(),
						eprocurementRequestModelImpl.getOriginalGroupId(),
						eprocurementRequestModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						eprocurementRequestModelImpl.getCompanyId(),
						eprocurementRequestModelImpl.getGroupId(),
						eprocurementRequestModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((eprocurementRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eprocurementRequestModelImpl.getOriginalCompanyId(),
						eprocurementRequestModelImpl.getOriginalGroupId(),
						eprocurementRequestModelImpl.getOriginalStatus(),
						eprocurementRequestModelImpl.getOriginalCity()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUSADDRESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS,
					args);

				args = new Object[] {
						eprocurementRequestModelImpl.getCompanyId(),
						eprocurementRequestModelImpl.getGroupId(),
						eprocurementRequestModelImpl.getStatus(),
						eprocurementRequestModelImpl.getCity()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUSADDRESS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSADDRESS,
					args);
			}
		}

		entityCache.putResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
			EprocurementRequestImpl.class, eprocurementRequest.getPrimaryKey(),
			eprocurementRequest, false);

		clearUniqueFindersCache(eprocurementRequestModelImpl, false);
		cacheUniqueFindersCache(eprocurementRequestModelImpl);

		eprocurementRequest.resetOriginalValues();

		return eprocurementRequest;
	}

	protected EprocurementRequest toUnwrappedModel(
		EprocurementRequest eprocurementRequest) {
		if (eprocurementRequest instanceof EprocurementRequestImpl) {
			return eprocurementRequest;
		}

		EprocurementRequestImpl eprocurementRequestImpl = new EprocurementRequestImpl();

		eprocurementRequestImpl.setNew(eprocurementRequest.isNew());
		eprocurementRequestImpl.setPrimaryKey(eprocurementRequest.getPrimaryKey());

		eprocurementRequestImpl.setRequestId(eprocurementRequest.getRequestId());
		eprocurementRequestImpl.setShipToOther(eprocurementRequest.getShipToOther());
		eprocurementRequestImpl.setSpendDepartment(eprocurementRequest.getSpendDepartment());
		eprocurementRequestImpl.setSpendYear(eprocurementRequest.getSpendYear());
		eprocurementRequestImpl.setAddress(eprocurementRequest.getAddress());
		eprocurementRequestImpl.setCity(eprocurementRequest.getCity());
		eprocurementRequestImpl.setState(eprocurementRequest.getState());
		eprocurementRequestImpl.setZip(eprocurementRequest.getZip());
		eprocurementRequestImpl.setIsBudgetedRequest(eprocurementRequest.getIsBudgetedRequest());
		eprocurementRequestImpl.setIsRelatedtoProject(eprocurementRequest.getIsRelatedtoProject());
		eprocurementRequestImpl.setProjectName(eprocurementRequest.getProjectName());
		eprocurementRequestImpl.setProjectOwnerId(eprocurementRequest.getProjectOwnerId());
		eprocurementRequestImpl.setTotalCost(eprocurementRequest.getTotalCost());
		eprocurementRequestImpl.setOriginalCost(eprocurementRequest.getOriginalCost());
		eprocurementRequestImpl.setReason(eprocurementRequest.getReason());
		eprocurementRequestImpl.setNotes(eprocurementRequest.getNotes());
		eprocurementRequestImpl.setVendorCode(eprocurementRequest.getVendorCode());
		eprocurementRequestImpl.setVendorEmail(eprocurementRequest.getVendorEmail());
		eprocurementRequestImpl.setContractId(eprocurementRequest.getContractId());
		eprocurementRequestImpl.setPurchaseOrder(eprocurementRequest.getPurchaseOrder());
		eprocurementRequestImpl.setItemInStock(eprocurementRequest.isItemInStock());
		eprocurementRequestImpl.setRecievedDate(eprocurementRequest.getRecievedDate());
		eprocurementRequestImpl.setReturnedDate(eprocurementRequest.getReturnedDate());
		eprocurementRequestImpl.setAssetInfo(eprocurementRequest.getAssetInfo());
		eprocurementRequestImpl.setReturnedAssets(eprocurementRequest.getReturnedAssets());
		eprocurementRequestImpl.setCreatedBy(eprocurementRequest.getCreatedBy());
		eprocurementRequestImpl.setCreatedDate(eprocurementRequest.getCreatedDate());
		eprocurementRequestImpl.setModifiedBy(eprocurementRequest.getModifiedBy());
		eprocurementRequestImpl.setModifiedDate(eprocurementRequest.getModifiedDate());
		eprocurementRequestImpl.setCompanyId(eprocurementRequest.getCompanyId());
		eprocurementRequestImpl.setGroupId(eprocurementRequest.getGroupId());
		eprocurementRequestImpl.setRequestorId(eprocurementRequest.getRequestorId());
		eprocurementRequestImpl.setSupervisorId(eprocurementRequest.getSupervisorId());
		eprocurementRequestImpl.setStatus(eprocurementRequest.getStatus());
		eprocurementRequestImpl.setStage(eprocurementRequest.getStage());
		eprocurementRequestImpl.setNextStage(eprocurementRequest.getNextStage());
		eprocurementRequestImpl.setIsApproverRole(eprocurementRequest.getIsApproverRole());

		return eprocurementRequestImpl;
	}

	/**
	 * Returns the eprocurement request with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprocurement request
	 * @return the eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequestException {
		EprocurementRequest eprocurementRequest = fetchByPrimaryKey(primaryKey);

		if (eprocurementRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eprocurementRequest;
	}

	/**
	 * Returns the eprocurement request with the primary key or throws a {@link NoSuchRequestException} if it could not be found.
	 *
	 * @param requestId the primary key of the eprocurement request
	 * @return the eprocurement request
	 * @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest findByPrimaryKey(long requestId)
		throws NoSuchRequestException {
		return findByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns the eprocurement request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the eprocurement request
	 * @return the eprocurement request, or <code>null</code> if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
				EprocurementRequestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EprocurementRequest eprocurementRequest = (EprocurementRequest)serializable;

		if (eprocurementRequest == null) {
			Session session = null;

			try {
				session = openSession();

				eprocurementRequest = (EprocurementRequest)session.get(EprocurementRequestImpl.class,
						primaryKey);

				if (eprocurementRequest != null) {
					cacheResult(eprocurementRequest);
				}
				else {
					entityCache.putResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
						EprocurementRequestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eprocurementRequest;
	}

	/**
	 * Returns the eprocurement request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the eprocurement request
	 * @return the eprocurement request, or <code>null</code> if a eprocurement request with the primary key could not be found
	 */
	@Override
	public EprocurementRequest fetchByPrimaryKey(long requestId) {
		return fetchByPrimaryKey((Serializable)requestId);
	}

	@Override
	public Map<Serializable, EprocurementRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EprocurementRequest> map = new HashMap<Serializable, EprocurementRequest>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EprocurementRequest eprocurementRequest = fetchByPrimaryKey(primaryKey);

			if (eprocurementRequest != null) {
				map.put(primaryKey, eprocurementRequest);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementRequestImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EprocurementRequest)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EPROCUREMENTREQUEST_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (EprocurementRequest eprocurementRequest : (List<EprocurementRequest>)q.list()) {
				map.put(eprocurementRequest.getPrimaryKeyObj(),
					eprocurementRequest);

				cacheResult(eprocurementRequest);

				uncachedPrimaryKeys.remove(eprocurementRequest.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EprocurementRequestModelImpl.ENTITY_CACHE_ENABLED,
					EprocurementRequestImpl.class, primaryKey, nullModel);
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
	 * Returns all the eprocurement requests.
	 *
	 * @return the eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the eprocurement requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @return the range of eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findAll(int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the eprocurement requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of eprocurement requests
	 * @param end the upper bound of the range of eprocurement requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of eprocurement requests
	 */
	@Override
	public List<EprocurementRequest> findAll(int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
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

		List<EprocurementRequest> list = null;

		if (retrieveFromCache) {
			list = (List<EprocurementRequest>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EPROCUREMENTREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EPROCUREMENTREQUEST;

				if (pagination) {
					sql = sql.concat(EprocurementRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EprocurementRequest>)QueryUtil.list(q,
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
	 * Removes all the eprocurement requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EprocurementRequest eprocurementRequest : findAll()) {
			remove(eprocurementRequest);
		}
	}

	/**
	 * Returns the number of eprocurement requests.
	 *
	 * @return the number of eprocurement requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EPROCUREMENTREQUEST);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EprocurementRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the eprocurement request persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EprocurementRequestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_EPROCUREMENTREQUEST = "SELECT eprocurementRequest FROM EprocurementRequest eprocurementRequest";
	private static final String _SQL_SELECT_EPROCUREMENTREQUEST_WHERE_PKS_IN = "SELECT eprocurementRequest FROM EprocurementRequest eprocurementRequest WHERE requestId IN (";
	private static final String _SQL_SELECT_EPROCUREMENTREQUEST_WHERE = "SELECT eprocurementRequest FROM EprocurementRequest eprocurementRequest WHERE ";
	private static final String _SQL_COUNT_EPROCUREMENTREQUEST = "SELECT COUNT(eprocurementRequest) FROM EprocurementRequest eprocurementRequest";
	private static final String _SQL_COUNT_EPROCUREMENTREQUEST_WHERE = "SELECT COUNT(eprocurementRequest) FROM EprocurementRequest eprocurementRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eprocurementRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EprocurementRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EprocurementRequest exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EprocurementRequestPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}