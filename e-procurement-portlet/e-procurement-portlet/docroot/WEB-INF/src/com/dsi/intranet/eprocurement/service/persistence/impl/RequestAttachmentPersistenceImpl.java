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

import com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException;
import com.dsi.intranet.eprocurement.model.RequestAttachment;
import com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl;
import com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.RequestAttachmentPersistence;

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
 * The persistence implementation for the request attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.RequestAttachmentUtil
 * @generated
 */
@ProviderType
public class RequestAttachmentPersistenceImpl extends BasePersistenceImpl<RequestAttachment>
	implements RequestAttachmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RequestAttachmentUtil} to access the request attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RequestAttachmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGetRequestAttachments",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGetRequestAttachments",
			new String[] { Long.class.getName() },
			RequestAttachmentModelImpl.REQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTS = new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetRequestAttachments",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the request attachments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByGetRequestAttachments(long requestId) {
		return findByGetRequestAttachments(requestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @return the range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByGetRequestAttachments(long requestId,
		int start, int end) {
		return findByGetRequestAttachments(requestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByGetRequestAttachments(long requestId,
		int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return findByGetRequestAttachments(requestId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByGetRequestAttachments(long requestId,
		int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS;
			finderArgs = new Object[] { requestId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS;
			finderArgs = new Object[] { requestId, start, end, orderByComparator };
		}

		List<RequestAttachment> list = null;

		if (retrieveFromCache) {
			list = (List<RequestAttachment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RequestAttachment requestAttachment : list) {
					if ((requestId != requestAttachment.getRequestId())) {
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

			query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_GETREQUESTATTACHMENTS_REQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RequestAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				if (!pagination) {
					list = (List<RequestAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RequestAttachment>)QueryUtil.list(q,
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
	 * Returns the first request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching request attachment
	 * @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment findByGetRequestAttachments_First(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByGetRequestAttachments_First(requestId,
				orderByComparator);

		if (requestAttachment != null) {
			return requestAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestAttachmentException(msg.toString());
	}

	/**
	 * Returns the first request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByGetRequestAttachments_First(
		long requestId, OrderByComparator<RequestAttachment> orderByComparator) {
		List<RequestAttachment> list = findByGetRequestAttachments(requestId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching request attachment
	 * @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment findByGetRequestAttachments_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByGetRequestAttachments_Last(requestId,
				orderByComparator);

		if (requestAttachment != null) {
			return requestAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestAttachmentException(msg.toString());
	}

	/**
	 * Returns the last request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByGetRequestAttachments_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator) {
		int count = countByGetRequestAttachments(requestId);

		if (count == 0) {
			return null;
		}

		List<RequestAttachment> list = findByGetRequestAttachments(requestId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestAttachmentId the primary key of the current request attachment
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next request attachment
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment[] findByGetRequestAttachments_PrevAndNext(
		long requestAttachmentId, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = findByPrimaryKey(requestAttachmentId);

		Session session = null;

		try {
			session = openSession();

			RequestAttachment[] array = new RequestAttachmentImpl[3];

			array[0] = getByGetRequestAttachments_PrevAndNext(session,
					requestAttachment, requestId, orderByComparator, true);

			array[1] = requestAttachment;

			array[2] = getByGetRequestAttachments_PrevAndNext(session,
					requestAttachment, requestId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RequestAttachment getByGetRequestAttachments_PrevAndNext(
		Session session, RequestAttachment requestAttachment, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_GETREQUESTATTACHMENTS_REQUESTID_2);

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
			query.append(RequestAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(requestId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(requestAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RequestAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the request attachments where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	@Override
	public void removeByGetRequestAttachments(long requestId) {
		for (RequestAttachment requestAttachment : findByGetRequestAttachments(
				requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(requestAttachment);
		}
	}

	/**
	 * Returns the number of request attachments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching request attachments
	 */
	@Override
	public int countByGetRequestAttachments(long requestId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTS;

		Object[] finderArgs = new Object[] { requestId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_GETREQUESTATTACHMENTS_REQUESTID_2);

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

	private static final String _FINDER_COLUMN_GETREQUESTATTACHMENTS_REQUESTID_2 =
		"requestAttachment.requestId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGetRequestAttachmentByFileEntryId",
			new String[] { Long.class.getName() },
			RequestAttachmentModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTBYFILEENTRYID =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGetRequestAttachmentByFileEntryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the request attachment where fileEntryId = &#63; or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching request attachment
	 * @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment findByGetRequestAttachmentByFileEntryId(
		long fileEntryId) throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByGetRequestAttachmentByFileEntryId(fileEntryId);

		if (requestAttachment == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fileEntryId=");
			msg.append(fileEntryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchRequestAttachmentException(msg.toString());
		}

		return requestAttachment;
	}

	/**
	 * Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId) {
		return fetchByGetRequestAttachmentByFileEntryId(fileEntryId, true);
	}

	/**
	 * Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fileEntryId the file entry ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { fileEntryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
					finderArgs, this);
		}

		if (result instanceof RequestAttachment) {
			RequestAttachment requestAttachment = (RequestAttachment)result;

			if ((fileEntryId != requestAttachment.getFileEntryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_GETREQUESTATTACHMENTBYFILEENTRYID_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				List<RequestAttachment> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"RequestAttachmentPersistenceImpl.fetchByGetRequestAttachmentByFileEntryId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RequestAttachment requestAttachment = list.get(0);

					result = requestAttachment;

					cacheResult(requestAttachment);

					if ((requestAttachment.getFileEntryId() != fileEntryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
							finderArgs, requestAttachment);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
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
			return (RequestAttachment)result;
		}
	}

	/**
	 * Removes the request attachment where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the request attachment that was removed
	 */
	@Override
	public RequestAttachment removeByGetRequestAttachmentByFileEntryId(
		long fileEntryId) throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = findByGetRequestAttachmentByFileEntryId(fileEntryId);

		return remove(requestAttachment);
	}

	/**
	 * Returns the number of request attachments where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching request attachments
	 */
	@Override
	public int countByGetRequestAttachmentByFileEntryId(long fileEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTBYFILEENTRYID;

		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_GETREQUESTATTACHMENTBYFILEENTRYID_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

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

	private static final String _FINDER_COLUMN_GETREQUESTATTACHMENTBYFILEENTRYID_FILEENTRYID_2 =
		"requestAttachment.fileEntryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfileEntryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED,
			RequestAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfileEntryId",
			new String[] { Long.class.getName() },
			RequestAttachmentModelImpl.REQUESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEENTRYID = new FinderPath(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfileEntryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the request attachments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByfileEntryId(long requestId) {
		return findByfileEntryId(requestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @return the range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByfileEntryId(long requestId, int start,
		int end) {
		return findByfileEntryId(requestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByfileEntryId(long requestId, int start,
		int end, OrderByComparator<RequestAttachment> orderByComparator) {
		return findByfileEntryId(requestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the request attachments where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching request attachments
	 */
	@Override
	public List<RequestAttachment> findByfileEntryId(long requestId, int start,
		int end, OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { requestId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { requestId, start, end, orderByComparator };
		}

		List<RequestAttachment> list = null;

		if (retrieveFromCache) {
			list = (List<RequestAttachment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RequestAttachment requestAttachment : list) {
					if ((requestId != requestAttachment.getRequestId())) {
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

			query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_REQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RequestAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(requestId);

				if (!pagination) {
					list = (List<RequestAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RequestAttachment>)QueryUtil.list(q,
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
	 * Returns the first request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching request attachment
	 * @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment findByfileEntryId_First(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByfileEntryId_First(requestId,
				orderByComparator);

		if (requestAttachment != null) {
			return requestAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestAttachmentException(msg.toString());
	}

	/**
	 * Returns the first request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByfileEntryId_First(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator) {
		List<RequestAttachment> list = findByfileEntryId(requestId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching request attachment
	 * @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment findByfileEntryId_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByfileEntryId_Last(requestId,
				orderByComparator);

		if (requestAttachment != null) {
			return requestAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("requestId=");
		msg.append(requestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequestAttachmentException(msg.toString());
	}

	/**
	 * Returns the last request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	 */
	@Override
	public RequestAttachment fetchByfileEntryId_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator) {
		int count = countByfileEntryId(requestId);

		if (count == 0) {
			return null;
		}

		List<RequestAttachment> list = findByfileEntryId(requestId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	 *
	 * @param requestAttachmentId the primary key of the current request attachment
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next request attachment
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment[] findByfileEntryId_PrevAndNext(
		long requestAttachmentId, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = findByPrimaryKey(requestAttachmentId);

		Session session = null;

		try {
			session = openSession();

			RequestAttachment[] array = new RequestAttachmentImpl[3];

			array[0] = getByfileEntryId_PrevAndNext(session, requestAttachment,
					requestId, orderByComparator, true);

			array[1] = requestAttachment;

			array[2] = getByfileEntryId_PrevAndNext(session, requestAttachment,
					requestId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RequestAttachment getByfileEntryId_PrevAndNext(Session session,
		RequestAttachment requestAttachment, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_FILEENTRYID_REQUESTID_2);

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
			query.append(RequestAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(requestId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(requestAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RequestAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the request attachments where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	@Override
	public void removeByfileEntryId(long requestId) {
		for (RequestAttachment requestAttachment : findByfileEntryId(
				requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(requestAttachment);
		}
	}

	/**
	 * Returns the number of request attachments where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching request attachments
	 */
	@Override
	public int countByfileEntryId(long requestId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEENTRYID;

		Object[] finderArgs = new Object[] { requestId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REQUESTATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_REQUESTID_2);

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

	private static final String _FINDER_COLUMN_FILEENTRYID_REQUESTID_2 = "requestAttachment.requestId = ?";

	public RequestAttachmentPersistenceImpl() {
		setModelClass(RequestAttachment.class);
	}

	/**
	 * Caches the request attachment in the entity cache if it is enabled.
	 *
	 * @param requestAttachment the request attachment
	 */
	@Override
	public void cacheResult(RequestAttachment requestAttachment) {
		entityCache.putResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentImpl.class, requestAttachment.getPrimaryKey(),
			requestAttachment);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
			new Object[] { requestAttachment.getFileEntryId() },
			requestAttachment);

		requestAttachment.resetOriginalValues();
	}

	/**
	 * Caches the request attachments in the entity cache if it is enabled.
	 *
	 * @param requestAttachments the request attachments
	 */
	@Override
	public void cacheResult(List<RequestAttachment> requestAttachments) {
		for (RequestAttachment requestAttachment : requestAttachments) {
			if (entityCache.getResult(
						RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						RequestAttachmentImpl.class,
						requestAttachment.getPrimaryKey()) == null) {
				cacheResult(requestAttachment);
			}
			else {
				requestAttachment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all request attachments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RequestAttachmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the request attachment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RequestAttachment requestAttachment) {
		entityCache.removeResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentImpl.class, requestAttachment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((RequestAttachmentModelImpl)requestAttachment,
			true);
	}

	@Override
	public void clearCache(List<RequestAttachment> requestAttachments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RequestAttachment requestAttachment : requestAttachments) {
			entityCache.removeResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				RequestAttachmentImpl.class, requestAttachment.getPrimaryKey());

			clearUniqueFindersCache((RequestAttachmentModelImpl)requestAttachment,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		RequestAttachmentModelImpl requestAttachmentModelImpl) {
		Object[] args = new Object[] { requestAttachmentModelImpl.getFileEntryId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
			args, requestAttachmentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		RequestAttachmentModelImpl requestAttachmentModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					requestAttachmentModelImpl.getFileEntryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
				args);
		}

		if ((requestAttachmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					requestAttachmentModelImpl.getOriginalFileEntryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GETREQUESTATTACHMENTBYFILEENTRYID,
				args);
		}
	}

	/**
	 * Creates a new request attachment with the primary key. Does not add the request attachment to the database.
	 *
	 * @param requestAttachmentId the primary key for the new request attachment
	 * @return the new request attachment
	 */
	@Override
	public RequestAttachment create(long requestAttachmentId) {
		RequestAttachment requestAttachment = new RequestAttachmentImpl();

		requestAttachment.setNew(true);
		requestAttachment.setPrimaryKey(requestAttachmentId);

		return requestAttachment;
	}

	/**
	 * Removes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestAttachmentId the primary key of the request attachment
	 * @return the request attachment that was removed
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment remove(long requestAttachmentId)
		throws NoSuchRequestAttachmentException {
		return remove((Serializable)requestAttachmentId);
	}

	/**
	 * Removes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the request attachment
	 * @return the request attachment that was removed
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment remove(Serializable primaryKey)
		throws NoSuchRequestAttachmentException {
		Session session = null;

		try {
			session = openSession();

			RequestAttachment requestAttachment = (RequestAttachment)session.get(RequestAttachmentImpl.class,
					primaryKey);

			if (requestAttachment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequestAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(requestAttachment);
		}
		catch (NoSuchRequestAttachmentException nsee) {
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
	protected RequestAttachment removeImpl(RequestAttachment requestAttachment) {
		requestAttachment = toUnwrappedModel(requestAttachment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(requestAttachment)) {
				requestAttachment = (RequestAttachment)session.get(RequestAttachmentImpl.class,
						requestAttachment.getPrimaryKeyObj());
			}

			if (requestAttachment != null) {
				session.delete(requestAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (requestAttachment != null) {
			clearCache(requestAttachment);
		}

		return requestAttachment;
	}

	@Override
	public RequestAttachment updateImpl(RequestAttachment requestAttachment) {
		requestAttachment = toUnwrappedModel(requestAttachment);

		boolean isNew = requestAttachment.isNew();

		RequestAttachmentModelImpl requestAttachmentModelImpl = (RequestAttachmentModelImpl)requestAttachment;

		Session session = null;

		try {
			session = openSession();

			if (requestAttachment.isNew()) {
				session.save(requestAttachment);

				requestAttachment.setNew(false);
			}
			else {
				requestAttachment = (RequestAttachment)session.merge(requestAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RequestAttachmentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					requestAttachmentModelImpl.getRequestId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS,
				args);

			args = new Object[] { requestAttachmentModelImpl.getRequestId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((requestAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						requestAttachmentModelImpl.getOriginalRequestId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS,
					args);

				args = new Object[] { requestAttachmentModelImpl.getRequestId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GETREQUESTATTACHMENTS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETREQUESTATTACHMENTS,
					args);
			}

			if ((requestAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						requestAttachmentModelImpl.getOriginalRequestId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);

				args = new Object[] { requestAttachmentModelImpl.getRequestId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);
			}
		}

		entityCache.putResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			RequestAttachmentImpl.class, requestAttachment.getPrimaryKey(),
			requestAttachment, false);

		clearUniqueFindersCache(requestAttachmentModelImpl, false);
		cacheUniqueFindersCache(requestAttachmentModelImpl);

		requestAttachment.resetOriginalValues();

		return requestAttachment;
	}

	protected RequestAttachment toUnwrappedModel(
		RequestAttachment requestAttachment) {
		if (requestAttachment instanceof RequestAttachmentImpl) {
			return requestAttachment;
		}

		RequestAttachmentImpl requestAttachmentImpl = new RequestAttachmentImpl();

		requestAttachmentImpl.setNew(requestAttachment.isNew());
		requestAttachmentImpl.setPrimaryKey(requestAttachment.getPrimaryKey());

		requestAttachmentImpl.setRequestAttachmentId(requestAttachment.getRequestAttachmentId());
		requestAttachmentImpl.setRequestId(requestAttachment.getRequestId());
		requestAttachmentImpl.setFileEntryId(requestAttachment.getFileEntryId());

		return requestAttachmentImpl;
	}

	/**
	 * Returns the request attachment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the request attachment
	 * @return the request attachment
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequestAttachmentException {
		RequestAttachment requestAttachment = fetchByPrimaryKey(primaryKey);

		if (requestAttachment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequestAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return requestAttachment;
	}

	/**
	 * Returns the request attachment with the primary key or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	 *
	 * @param requestAttachmentId the primary key of the request attachment
	 * @return the request attachment
	 * @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment findByPrimaryKey(long requestAttachmentId)
		throws NoSuchRequestAttachmentException {
		return findByPrimaryKey((Serializable)requestAttachmentId);
	}

	/**
	 * Returns the request attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the request attachment
	 * @return the request attachment, or <code>null</code> if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				RequestAttachmentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RequestAttachment requestAttachment = (RequestAttachment)serializable;

		if (requestAttachment == null) {
			Session session = null;

			try {
				session = openSession();

				requestAttachment = (RequestAttachment)session.get(RequestAttachmentImpl.class,
						primaryKey);

				if (requestAttachment != null) {
					cacheResult(requestAttachment);
				}
				else {
					entityCache.putResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						RequestAttachmentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					RequestAttachmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return requestAttachment;
	}

	/**
	 * Returns the request attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestAttachmentId the primary key of the request attachment
	 * @return the request attachment, or <code>null</code> if a request attachment with the primary key could not be found
	 */
	@Override
	public RequestAttachment fetchByPrimaryKey(long requestAttachmentId) {
		return fetchByPrimaryKey((Serializable)requestAttachmentId);
	}

	@Override
	public Map<Serializable, RequestAttachment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RequestAttachment> map = new HashMap<Serializable, RequestAttachment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RequestAttachment requestAttachment = fetchByPrimaryKey(primaryKey);

			if (requestAttachment != null) {
				map.put(primaryKey, requestAttachment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					RequestAttachmentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RequestAttachment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_REQUESTATTACHMENT_WHERE_PKS_IN);

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

			for (RequestAttachment requestAttachment : (List<RequestAttachment>)q.list()) {
				map.put(requestAttachment.getPrimaryKeyObj(), requestAttachment);

				cacheResult(requestAttachment);

				uncachedPrimaryKeys.remove(requestAttachment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RequestAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					RequestAttachmentImpl.class, primaryKey, nullModel);
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
	 * Returns all the request attachments.
	 *
	 * @return the request attachments
	 */
	@Override
	public List<RequestAttachment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the request attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @return the range of request attachments
	 */
	@Override
	public List<RequestAttachment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the request attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of request attachments
	 */
	@Override
	public List<RequestAttachment> findAll(int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the request attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of request attachments
	 * @param end the upper bound of the range of request attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of request attachments
	 */
	@Override
	public List<RequestAttachment> findAll(int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator,
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

		List<RequestAttachment> list = null;

		if (retrieveFromCache) {
			list = (List<RequestAttachment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_REQUESTATTACHMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUESTATTACHMENT;

				if (pagination) {
					sql = sql.concat(RequestAttachmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RequestAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RequestAttachment>)QueryUtil.list(q,
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
	 * Removes all the request attachments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RequestAttachment requestAttachment : findAll()) {
			remove(requestAttachment);
		}
	}

	/**
	 * Returns the number of request attachments.
	 *
	 * @return the number of request attachments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_REQUESTATTACHMENT);

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
		return RequestAttachmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the request attachment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RequestAttachmentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_REQUESTATTACHMENT = "SELECT requestAttachment FROM RequestAttachment requestAttachment";
	private static final String _SQL_SELECT_REQUESTATTACHMENT_WHERE_PKS_IN = "SELECT requestAttachment FROM RequestAttachment requestAttachment WHERE requestAttachmentId IN (";
	private static final String _SQL_SELECT_REQUESTATTACHMENT_WHERE = "SELECT requestAttachment FROM RequestAttachment requestAttachment WHERE ";
	private static final String _SQL_COUNT_REQUESTATTACHMENT = "SELECT COUNT(requestAttachment) FROM RequestAttachment requestAttachment";
	private static final String _SQL_COUNT_REQUESTATTACHMENT_WHERE = "SELECT COUNT(requestAttachment) FROM RequestAttachment requestAttachment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "requestAttachment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RequestAttachment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RequestAttachment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RequestAttachmentPersistenceImpl.class);
}