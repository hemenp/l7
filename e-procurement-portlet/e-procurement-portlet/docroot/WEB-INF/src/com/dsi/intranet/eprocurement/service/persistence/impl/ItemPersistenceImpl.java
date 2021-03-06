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

import com.dsi.intranet.eprocurement.exception.NoSuchItemException;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.model.impl.ItemImpl;
import com.dsi.intranet.eprocurement.model.impl.ItemModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.ItemPersistence;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see ItemPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.ItemUtil
 * @generated
 */
@ProviderType
public class ItemPersistenceImpl extends BasePersistenceImpl<Item>
	implements ItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ItemUtil} to access the item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ITEM = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByitem",
			new String[] { Long.class.getName() },
			ItemModelImpl.REQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEM = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByitem",
			new String[] { Long.class.getName() });

	/**
	 * Returns the item where requestId = &#63; or throws a {@link NoSuchItemException} if it could not be found.
	 *
	 * @param requestId the request ID
	 * @return the matching item
	 * @throws NoSuchItemException if a matching item could not be found
	 */
	@Override
	public Item findByitem(long requestId) throws NoSuchItemException {
		Item item = fetchByitem(requestId);

		if (item == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("requestId=");
			msg.append(requestId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchItemException(msg.toString());
		}

		return item;
	}

	/**
	 * Returns the item where requestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param requestId the request ID
	 * @return the matching item, or <code>null</code> if a matching item could not be found
	 */
	@Override
	public Item fetchByitem(long requestId) {
		return fetchByitem(requestId, true);
	}

	/**
	 * Returns the item where requestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param requestId the request ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching item, or <code>null</code> if a matching item could not be found
	 */
	@Override
	public Item fetchByitem(long requestId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { requestId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ITEM,
					finderArgs, this);
		}

		if (result instanceof Item) {
			Item item = (Item)result;

			if ((requestId != item.getRequestId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ITEM_WHERE);

			query.append(_FINDER_COLUMN_ITEM_REQUESTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				List<Item> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ITEM,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ItemPersistenceImpl.fetchByitem(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Item item = list.get(0);

					result = item;

					cacheResult(item);

					if ((item.getRequestId() != requestId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_ITEM,
							finderArgs, item);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ITEM, finderArgs);

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
			return (Item)result;
		}
	}

	/**
	 * Removes the item where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 * @return the item that was removed
	 */
	@Override
	public Item removeByitem(long requestId) throws NoSuchItemException {
		Item item = findByitem(requestId);

		return remove(item);
	}

	/**
	 * Returns the number of items where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching items
	 */
	@Override
	public int countByitem(long requestId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEM;

		Object[] finderArgs = new Object[] { requestId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEM_WHERE);

			query.append(_FINDER_COLUMN_ITEM_REQUESTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

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

	private static final String _FINDER_COLUMN_ITEM_REQUESTID_2 = "item.requestId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMS = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByitems",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, ItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByitems",
			new String[] { Long.class.getName() },
			ItemModelImpl.REQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMS = new FinderPath(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByitems",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the items where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching items
	 */
	@Override
	public List<Item> findByitems(long requestId) {
		return findByitems(requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Item> findByitems(long requestId, int start, int end) {
		return findByitems(requestId, start, end, null);
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
	@Override
	public List<Item> findByitems(long requestId, int start, int end,
		OrderByComparator<Item> orderByComparator) {
		return findByitems(requestId, start, end, orderByComparator, true);
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
	@Override
	public List<Item> findByitems(long requestId, int start, int end,
		OrderByComparator<Item> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS;
			finderArgs = new Object[] { requestId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMS;
			finderArgs = new Object[] { requestId, start, end, orderByComparator };
		}

		List<Item> list = null;

		if (retrieveFromCache) {
			list = (List<Item>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Item item : list) {
					if ((requestId != item.getRequestId())) {
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

			query.append(_SQL_SELECT_ITEM_WHERE);

			query.append(_FINDER_COLUMN_ITEMS_REQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				if (!pagination) {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first item in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item
	 * @throws NoSuchItemException if a matching item could not be found
	 */
	@Override
	public Item findByitems_First(long requestId,
		OrderByComparator<Item> orderByComparator) throws NoSuchItemException {
		Item item = fetchByitems_First(requestId, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the first item in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item, or <code>null</code> if a matching item could not be found
	 */
	@Override
	public Item fetchByitems_First(long requestId,
		OrderByComparator<Item> orderByComparator) {
		List<Item> list = findByitems(requestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item
	 * @throws NoSuchItemException if a matching item could not be found
	 */
	@Override
	public Item findByitems_Last(long requestId,
		OrderByComparator<Item> orderByComparator) throws NoSuchItemException {
		Item item = fetchByitems_Last(requestId, orderByComparator);

		if (item != null) {
			return item;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the last item in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item, or <code>null</code> if a matching item could not be found
	 */
	@Override
	public Item fetchByitems_Last(long requestId,
		OrderByComparator<Item> orderByComparator) {
		int count = countByitems(requestId);

		if (count == 0) {
			return null;
		}

		List<Item> list = findByitems(requestId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Item[] findByitems_PrevAndNext(long itemId, long requestId,
		OrderByComparator<Item> orderByComparator) throws NoSuchItemException {
		Item item = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			Item[] array = new ItemImpl[3];

			array[0] = getByitems_PrevAndNext(session, item, requestId,
					orderByComparator, true);

			array[1] = item;

			array[2] = getByitems_PrevAndNext(session, item, requestId,
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

	protected Item getByitems_PrevAndNext(Session session, Item item,
		long requestId, OrderByComparator<Item> orderByComparator,
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

		query.append(_SQL_SELECT_ITEM_WHERE);

		query.append(_FINDER_COLUMN_ITEMS_REQUESTID_2);

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
			query.append(ItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(requestId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(item);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Item> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the items where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	@Override
	public void removeByitems(long requestId) {
		for (Item item : findByitems(requestId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(item);
		}
	}

	/**
	 * Returns the number of items where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching items
	 */
	@Override
	public int countByitems(long requestId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMS;

		Object[] finderArgs = new Object[] { requestId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEM_WHERE);

			query.append(_FINDER_COLUMN_ITEMS_REQUESTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

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

	private static final String _FINDER_COLUMN_ITEMS_REQUESTID_2 = "item.requestId = ?";

	public ItemPersistenceImpl() {
		setModelClass(Item.class);
	}

	/**
	 * Caches the item in the entity cache if it is enabled.
	 *
	 * @param item the item
	 */
	@Override
	public void cacheResult(Item item) {
		entityCache.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey(), item);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ITEM,
			new Object[] { item.getRequestId() }, item);

		item.resetOriginalValues();
	}

	/**
	 * Caches the items in the entity cache if it is enabled.
	 *
	 * @param items the items
	 */
	@Override
	public void cacheResult(List<Item> items) {
		for (Item item : items) {
			if (entityCache.getResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
						ItemImpl.class, item.getPrimaryKey()) == null) {
				cacheResult(item);
			}
			else {
				item.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all items.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Item item) {
		entityCache.removeResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ItemModelImpl)item, true);
	}

	@Override
	public void clearCache(List<Item> items) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Item item : items) {
			entityCache.removeResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
				ItemImpl.class, item.getPrimaryKey());

			clearUniqueFindersCache((ItemModelImpl)item, true);
		}
	}

	protected void cacheUniqueFindersCache(ItemModelImpl itemModelImpl) {
		Object[] args = new Object[] { itemModelImpl.getRequestId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ITEM, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ITEM, args, itemModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(ItemModelImpl itemModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { itemModelImpl.getRequestId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ITEM, args);
		}

		if ((itemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ITEM.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { itemModelImpl.getOriginalRequestId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ITEM, args);
		}
	}

	/**
	 * Creates a new item with the primary key. Does not add the item to the database.
	 *
	 * @param itemId the primary key for the new item
	 * @return the new item
	 */
	@Override
	public Item create(long itemId) {
		Item item = new ItemImpl();

		item.setNew(true);
		item.setPrimaryKey(itemId);

		item.setCompanyId(companyProvider.getCompanyId());

		return item;
	}

	/**
	 * Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the item
	 * @return the item that was removed
	 * @throws NoSuchItemException if a item with the primary key could not be found
	 */
	@Override
	public Item remove(long itemId) throws NoSuchItemException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item that was removed
	 * @throws NoSuchItemException if a item with the primary key could not be found
	 */
	@Override
	public Item remove(Serializable primaryKey) throws NoSuchItemException {
		Session session = null;

		try {
			session = openSession();

			Item item = (Item)session.get(ItemImpl.class, primaryKey);

			if (item == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(item);
		}
		catch (NoSuchItemException nsee) {
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
	protected Item removeImpl(Item item) {
		item = toUnwrappedModel(item);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(item)) {
				item = (Item)session.get(ItemImpl.class, item.getPrimaryKeyObj());
			}

			if (item != null) {
				session.delete(item);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (item != null) {
			clearCache(item);
		}

		return item;
	}

	@Override
	public Item updateImpl(Item item) {
		item = toUnwrappedModel(item);

		boolean isNew = item.isNew();

		ItemModelImpl itemModelImpl = (ItemModelImpl)item;

		Session session = null;

		try {
			session = openSession();

			if (item.isNew()) {
				session.save(item);

				item.setNew(false);
			}
			else {
				item = (Item)session.merge(item);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ItemModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { itemModelImpl.getRequestId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEMS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((itemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemModelImpl.getOriginalRequestId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEMS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS,
					args);

				args = new Object[] { itemModelImpl.getRequestId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEMS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMS,
					args);
			}
		}

		entityCache.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
			ItemImpl.class, item.getPrimaryKey(), item, false);

		clearUniqueFindersCache(itemModelImpl, false);
		cacheUniqueFindersCache(itemModelImpl);

		item.resetOriginalValues();

		return item;
	}

	protected Item toUnwrappedModel(Item item) {
		if (item instanceof ItemImpl) {
			return item;
		}

		ItemImpl itemImpl = new ItemImpl();

		itemImpl.setNew(item.isNew());
		itemImpl.setPrimaryKey(item.getPrimaryKey());

		itemImpl.setItemId(item.getItemId());
		itemImpl.setItemName(item.getItemName());
		itemImpl.setItemDescription(item.getItemDescription());
		itemImpl.setQuantity(item.getQuantity());
		itemImpl.setCost(item.getCost());
		itemImpl.setOriginalCost(item.getOriginalCost());
		itemImpl.setWbselement(item.getWbselement());
		itemImpl.setGlAccNo(item.getGlAccNo());
		itemImpl.setCostCenter(item.getCostCenter());
		itemImpl.setRequestId(item.getRequestId());
		itemImpl.setItemInStock(item.isItemInStock());
		itemImpl.setVendorCode(item.getVendorCode());
		itemImpl.setPurchaseOrder(item.getPurchaseOrder());
		itemImpl.setRecievedDate(item.getRecievedDate());
		itemImpl.setReturnedDate(item.getReturnedDate());
		itemImpl.setAssetInfo(item.getAssetInfo());
		itemImpl.setReturnedAssets(item.getReturnedAssets());
		itemImpl.setCreatedBy(item.getCreatedBy());
		itemImpl.setCreatedDate(item.getCreatedDate());
		itemImpl.setModifiedBy(item.getModifiedBy());
		itemImpl.setModifiedDate(item.getModifiedDate());
		itemImpl.setCompanyId(item.getCompanyId());
		itemImpl.setGroupId(item.getGroupId());

		return itemImpl;
	}

	/**
	 * Returns the item with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item
	 * @throws NoSuchItemException if a item with the primary key could not be found
	 */
	@Override
	public Item findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemException {
		Item item = fetchByPrimaryKey(primaryKey);

		if (item == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return item;
	}

	/**
	 * Returns the item with the primary key or throws a {@link NoSuchItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the item
	 * @return the item
	 * @throws NoSuchItemException if a item with the primary key could not be found
	 */
	@Override
	public Item findByPrimaryKey(long itemId) throws NoSuchItemException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item
	 * @return the item, or <code>null</code> if a item with the primary key could not be found
	 */
	@Override
	public Item fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
				ItemImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Item item = (Item)serializable;

		if (item == null) {
			Session session = null;

			try {
				session = openSession();

				item = (Item)session.get(ItemImpl.class, primaryKey);

				if (item != null) {
					cacheResult(item);
				}
				else {
					entityCache.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
						ItemImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
					ItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return item;
	}

	/**
	 * Returns the item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the item
	 * @return the item, or <code>null</code> if a item with the primary key could not be found
	 */
	@Override
	public Item fetchByPrimaryKey(long itemId) {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	@Override
	public Map<Serializable, Item> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Item> map = new HashMap<Serializable, Item>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Item item = fetchByPrimaryKey(primaryKey);

			if (item != null) {
				map.put(primaryKey, item);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
					ItemImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Item)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ITEM_WHERE_PKS_IN);

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

			for (Item item : (List<Item>)q.list()) {
				map.put(item.getPrimaryKeyObj(), item);

				cacheResult(item);

				uncachedPrimaryKeys.remove(item.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ItemModelImpl.ENTITY_CACHE_ENABLED,
					ItemImpl.class, primaryKey, nullModel);
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
	 * Returns all the items.
	 *
	 * @return the items
	 */
	@Override
	public List<Item> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Item> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Item> findAll(int start, int end,
		OrderByComparator<Item> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Item> findAll(int start, int end,
		OrderByComparator<Item> orderByComparator, boolean retrieveFromCache) {
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

		List<Item> list = null;

		if (retrieveFromCache) {
			list = (List<Item>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEM;

				if (pagination) {
					sql = sql.concat(ItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Item>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Item item : findAll()) {
			remove(item);
		}
	}

	/**
	 * Returns the number of items.
	 *
	 * @return the number of items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ITEM);

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
		return ItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the item persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ItemImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_ITEM = "SELECT item FROM Item item";
	private static final String _SQL_SELECT_ITEM_WHERE_PKS_IN = "SELECT item FROM Item item WHERE itemId IN (";
	private static final String _SQL_SELECT_ITEM_WHERE = "SELECT item FROM Item item WHERE ";
	private static final String _SQL_COUNT_ITEM = "SELECT COUNT(item) FROM Item item";
	private static final String _SQL_COUNT_ITEM_WHERE = "SELECT COUNT(item) FROM Item item WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "item.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Item exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Item exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ItemPersistenceImpl.class);
}