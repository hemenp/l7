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

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException;
import com.dsi.intranet.eprocurement.model.WorkflowReview;
import com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl;
import com.dsi.intranet.eprocurement.model.impl.WorkflowReviewModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.WorkflowReviewPersistence;

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
 * The persistence implementation for the workflow review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowReviewPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.WorkflowReviewUtil
 * @generated
 */
@ProviderType
public class WorkflowReviewPersistenceImpl extends BasePersistenceImpl<WorkflowReview>
	implements WorkflowReviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkflowReviewUtil} to access the workflow review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkflowReviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED,
			WorkflowReviewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED,
			WorkflowReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED,
			WorkflowReviewImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED,
			WorkflowReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			WorkflowReviewModelImpl.COMPANYID_COLUMN_BITMASK |
			WorkflowReviewModelImpl.GROUPID_COLUMN_BITMASK |
			WorkflowReviewModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			WorkflowReviewModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK = new FinderPath(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameAndClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching workflow reviews
	 */
	@Override
	public List<WorkflowReview> findByClassNameAndClassPK(long companyId,
		long groupId, long classNameId, long classPK) {
		return findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @return the range of matching workflow reviews
	 */
	@Override
	public List<WorkflowReview> findByClassNameAndClassPK(long companyId,
		long groupId, long classNameId, long classPK, int start, int end) {
		return findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflow reviews
	 */
	@Override
	public List<WorkflowReview> findByClassNameAndClassPK(long companyId,
		long groupId, long classNameId, long classPK, int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching workflow reviews
	 */
	@Override
	public List<WorkflowReview> findByClassNameAndClassPK(long companyId,
		long groupId, long classNameId, long classPK, int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] { companyId, groupId, classNameId, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] {
					companyId, groupId, classNameId, classPK,
					
					start, end, orderByComparator
				};
		}

		List<WorkflowReview> list = null;

		if (retrieveFromCache) {
			list = (List<WorkflowReview>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkflowReview workflowReview : list) {
					if ((companyId != workflowReview.getCompanyId()) ||
							(groupId != workflowReview.getGroupId()) ||
							(classNameId != workflowReview.getClassNameId()) ||
							(classPK != workflowReview.getClassPK())) {
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

			query.append(_SQL_SELECT_WORKFLOWREVIEW_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkflowReviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<WorkflowReview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkflowReview>)QueryUtil.list(q,
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
	 * Returns the first workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow review
	 * @throws NoSuchWorkflowReviewException if a matching workflow review could not be found
	 */
	@Override
	public WorkflowReview findByClassNameAndClassPK_First(long companyId,
		long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException {
		WorkflowReview workflowReview = fetchByClassNameAndClassPK_First(companyId,
				groupId, classNameId, classPK, orderByComparator);

		if (workflowReview != null) {
			return workflowReview;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowReviewException(msg.toString());
	}

	/**
	 * Returns the first workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow review, or <code>null</code> if a matching workflow review could not be found
	 */
	@Override
	public WorkflowReview fetchByClassNameAndClassPK_First(long companyId,
		long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator) {
		List<WorkflowReview> list = findByClassNameAndClassPK(companyId,
				groupId, classNameId, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow review
	 * @throws NoSuchWorkflowReviewException if a matching workflow review could not be found
	 */
	@Override
	public WorkflowReview findByClassNameAndClassPK_Last(long companyId,
		long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException {
		WorkflowReview workflowReview = fetchByClassNameAndClassPK_Last(companyId,
				groupId, classNameId, classPK, orderByComparator);

		if (workflowReview != null) {
			return workflowReview;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowReviewException(msg.toString());
	}

	/**
	 * Returns the last workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow review, or <code>null</code> if a matching workflow review could not be found
	 */
	@Override
	public WorkflowReview fetchByClassNameAndClassPK_Last(long companyId,
		long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator) {
		int count = countByClassNameAndClassPK(companyId, groupId, classNameId,
				classPK);

		if (count == 0) {
			return null;
		}

		List<WorkflowReview> list = findByClassNameAndClassPK(companyId,
				groupId, classNameId, classPK, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflow reviews before and after the current workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param workflowReviewId the primary key of the current workflow review
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow review
	 * @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview[] findByClassNameAndClassPK_PrevAndNext(
		long workflowReviewId, long companyId, long groupId, long classNameId,
		long classPK, OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException {
		WorkflowReview workflowReview = findByPrimaryKey(workflowReviewId);

		Session session = null;

		try {
			session = openSession();

			WorkflowReview[] array = new WorkflowReviewImpl[3];

			array[0] = getByClassNameAndClassPK_PrevAndNext(session,
					workflowReview, companyId, groupId, classNameId, classPK,
					orderByComparator, true);

			array[1] = workflowReview;

			array[2] = getByClassNameAndClassPK_PrevAndNext(session,
					workflowReview, companyId, groupId, classNameId, classPK,
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

	protected WorkflowReview getByClassNameAndClassPK_PrevAndNext(
		Session session, WorkflowReview workflowReview, long companyId,
		long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_WORKFLOWREVIEW_WHERE);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

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
			query.append(WorkflowReviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workflowReview);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkflowReview> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 */
	@Override
	public void removeByClassNameAndClassPK(long companyId, long groupId,
		long classNameId, long classPK) {
		for (WorkflowReview workflowReview : findByClassNameAndClassPK(
				companyId, groupId, classNameId, classPK, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workflowReview);
		}
	}

	/**
	 * Returns the number of workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching workflow reviews
	 */
	@Override
	public int countByClassNameAndClassPK(long companyId, long groupId,
		long classNameId, long classPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK;

		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, classPK
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_WORKFLOWREVIEW_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_COMPANYID_2 = "workflowReview.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_GROUPID_2 = "workflowReview.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAMEID_2 =
		"workflowReview.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2 = "workflowReview.classPK = ?";

	public WorkflowReviewPersistenceImpl() {
		setModelClass(WorkflowReview.class);
	}

	/**
	 * Caches the workflow review in the entity cache if it is enabled.
	 *
	 * @param workflowReview the workflow review
	 */
	@Override
	public void cacheResult(WorkflowReview workflowReview) {
		entityCache.putResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewImpl.class, workflowReview.getPrimaryKey(),
			workflowReview);

		workflowReview.resetOriginalValues();
	}

	/**
	 * Caches the workflow reviews in the entity cache if it is enabled.
	 *
	 * @param workflowReviews the workflow reviews
	 */
	@Override
	public void cacheResult(List<WorkflowReview> workflowReviews) {
		for (WorkflowReview workflowReview : workflowReviews) {
			if (entityCache.getResult(
						WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowReviewImpl.class, workflowReview.getPrimaryKey()) == null) {
				cacheResult(workflowReview);
			}
			else {
				workflowReview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workflow reviews.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkflowReviewImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workflow review.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkflowReview workflowReview) {
		entityCache.removeResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewImpl.class, workflowReview.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkflowReview> workflowReviews) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkflowReview workflowReview : workflowReviews) {
			entityCache.removeResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowReviewImpl.class, workflowReview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new workflow review with the primary key. Does not add the workflow review to the database.
	 *
	 * @param workflowReviewId the primary key for the new workflow review
	 * @return the new workflow review
	 */
	@Override
	public WorkflowReview create(long workflowReviewId) {
		WorkflowReview workflowReview = new WorkflowReviewImpl();

		workflowReview.setNew(true);
		workflowReview.setPrimaryKey(workflowReviewId);

		workflowReview.setCompanyId(companyProvider.getCompanyId());

		return workflowReview;
	}

	/**
	 * Removes the workflow review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowReviewId the primary key of the workflow review
	 * @return the workflow review that was removed
	 * @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview remove(long workflowReviewId)
		throws NoSuchWorkflowReviewException {
		return remove((Serializable)workflowReviewId);
	}

	/**
	 * Removes the workflow review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workflow review
	 * @return the workflow review that was removed
	 * @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview remove(Serializable primaryKey)
		throws NoSuchWorkflowReviewException {
		Session session = null;

		try {
			session = openSession();

			WorkflowReview workflowReview = (WorkflowReview)session.get(WorkflowReviewImpl.class,
					primaryKey);

			if (workflowReview == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkflowReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workflowReview);
		}
		catch (NoSuchWorkflowReviewException nsee) {
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
	protected WorkflowReview removeImpl(WorkflowReview workflowReview) {
		workflowReview = toUnwrappedModel(workflowReview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workflowReview)) {
				workflowReview = (WorkflowReview)session.get(WorkflowReviewImpl.class,
						workflowReview.getPrimaryKeyObj());
			}

			if (workflowReview != null) {
				session.delete(workflowReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workflowReview != null) {
			clearCache(workflowReview);
		}

		return workflowReview;
	}

	@Override
	public WorkflowReview updateImpl(WorkflowReview workflowReview) {
		workflowReview = toUnwrappedModel(workflowReview);

		boolean isNew = workflowReview.isNew();

		WorkflowReviewModelImpl workflowReviewModelImpl = (WorkflowReviewModelImpl)workflowReview;

		Session session = null;

		try {
			session = openSession();

			if (workflowReview.isNew()) {
				session.save(workflowReview);

				workflowReview.setNew(false);
			}
			else {
				workflowReview = (WorkflowReview)session.merge(workflowReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WorkflowReviewModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					workflowReviewModelImpl.getCompanyId(),
					workflowReviewModelImpl.getGroupId(),
					workflowReviewModelImpl.getClassNameId(),
					workflowReviewModelImpl.getClassPK()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((workflowReviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workflowReviewModelImpl.getOriginalCompanyId(),
						workflowReviewModelImpl.getOriginalGroupId(),
						workflowReviewModelImpl.getOriginalClassNameId(),
						workflowReviewModelImpl.getOriginalClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);

				args = new Object[] {
						workflowReviewModelImpl.getCompanyId(),
						workflowReviewModelImpl.getGroupId(),
						workflowReviewModelImpl.getClassNameId(),
						workflowReviewModelImpl.getClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);
			}
		}

		entityCache.putResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowReviewImpl.class, workflowReview.getPrimaryKey(),
			workflowReview, false);

		workflowReview.resetOriginalValues();

		return workflowReview;
	}

	protected WorkflowReview toUnwrappedModel(WorkflowReview workflowReview) {
		if (workflowReview instanceof WorkflowReviewImpl) {
			return workflowReview;
		}

		WorkflowReviewImpl workflowReviewImpl = new WorkflowReviewImpl();

		workflowReviewImpl.setNew(workflowReview.isNew());
		workflowReviewImpl.setPrimaryKey(workflowReview.getPrimaryKey());

		workflowReviewImpl.setWorkflowReviewId(workflowReview.getWorkflowReviewId());
		workflowReviewImpl.setWorkflowRequestId(workflowReview.getWorkflowRequestId());
		workflowReviewImpl.setClassNameId(workflowReview.getClassNameId());
		workflowReviewImpl.setClassPK(workflowReview.getClassPK());
		workflowReviewImpl.setUpdatedBy(workflowReview.getUpdatedBy());
		workflowReviewImpl.setUpdatedToStatus(workflowReview.getUpdatedToStatus());
		workflowReviewImpl.setNextStage(workflowReview.getNextStage());
		workflowReviewImpl.setIsApproverRole(workflowReview.getIsApproverRole());
		workflowReviewImpl.setUpdatedDate(workflowReview.getUpdatedDate());
		workflowReviewImpl.setApproverComments(workflowReview.getApproverComments());
		workflowReviewImpl.setEmailComments(workflowReview.getEmailComments());
		workflowReviewImpl.setCompanyId(workflowReview.getCompanyId());
		workflowReviewImpl.setGroupId(workflowReview.getGroupId());

		return workflowReviewImpl;
	}

	/**
	 * Returns the workflow review with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow review
	 * @return the workflow review
	 * @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkflowReviewException {
		WorkflowReview workflowReview = fetchByPrimaryKey(primaryKey);

		if (workflowReview == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkflowReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workflowReview;
	}

	/**
	 * Returns the workflow review with the primary key or throws a {@link NoSuchWorkflowReviewException} if it could not be found.
	 *
	 * @param workflowReviewId the primary key of the workflow review
	 * @return the workflow review
	 * @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview findByPrimaryKey(long workflowReviewId)
		throws NoSuchWorkflowReviewException {
		return findByPrimaryKey((Serializable)workflowReviewId);
	}

	/**
	 * Returns the workflow review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow review
	 * @return the workflow review, or <code>null</code> if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowReviewImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorkflowReview workflowReview = (WorkflowReview)serializable;

		if (workflowReview == null) {
			Session session = null;

			try {
				session = openSession();

				workflowReview = (WorkflowReview)session.get(WorkflowReviewImpl.class,
						primaryKey);

				if (workflowReview != null) {
					cacheResult(workflowReview);
				}
				else {
					entityCache.putResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowReviewImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowReviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workflowReview;
	}

	/**
	 * Returns the workflow review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowReviewId the primary key of the workflow review
	 * @return the workflow review, or <code>null</code> if a workflow review with the primary key could not be found
	 */
	@Override
	public WorkflowReview fetchByPrimaryKey(long workflowReviewId) {
		return fetchByPrimaryKey((Serializable)workflowReviewId);
	}

	@Override
	public Map<Serializable, WorkflowReview> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorkflowReview> map = new HashMap<Serializable, WorkflowReview>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorkflowReview workflowReview = fetchByPrimaryKey(primaryKey);

			if (workflowReview != null) {
				map.put(primaryKey, workflowReview);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowReviewImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorkflowReview)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKFLOWREVIEW_WHERE_PKS_IN);

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

			for (WorkflowReview workflowReview : (List<WorkflowReview>)q.list()) {
				map.put(workflowReview.getPrimaryKeyObj(), workflowReview);

				cacheResult(workflowReview);

				uncachedPrimaryKeys.remove(workflowReview.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorkflowReviewModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowReviewImpl.class, primaryKey, nullModel);
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
	 * Returns all the workflow reviews.
	 *
	 * @return the workflow reviews
	 */
	@Override
	public List<WorkflowReview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @return the range of workflow reviews
	 */
	@Override
	public List<WorkflowReview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflow reviews
	 */
	@Override
	public List<WorkflowReview> findAll(int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workflow reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow reviews
	 * @param end the upper bound of the range of workflow reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of workflow reviews
	 */
	@Override
	public List<WorkflowReview> findAll(int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator,
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

		List<WorkflowReview> list = null;

		if (retrieveFromCache) {
			list = (List<WorkflowReview>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKFLOWREVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOWREVIEW;

				if (pagination) {
					sql = sql.concat(WorkflowReviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkflowReview>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkflowReview>)QueryUtil.list(q,
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
	 * Removes all the workflow reviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkflowReview workflowReview : findAll()) {
			remove(workflowReview);
		}
	}

	/**
	 * Returns the number of workflow reviews.
	 *
	 * @return the number of workflow reviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKFLOWREVIEW);

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
		return WorkflowReviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the workflow review persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorkflowReviewImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_WORKFLOWREVIEW = "SELECT workflowReview FROM WorkflowReview workflowReview";
	private static final String _SQL_SELECT_WORKFLOWREVIEW_WHERE_PKS_IN = "SELECT workflowReview FROM WorkflowReview workflowReview WHERE workflowReviewId IN (";
	private static final String _SQL_SELECT_WORKFLOWREVIEW_WHERE = "SELECT workflowReview FROM WorkflowReview workflowReview WHERE ";
	private static final String _SQL_COUNT_WORKFLOWREVIEW = "SELECT COUNT(workflowReview) FROM WorkflowReview workflowReview";
	private static final String _SQL_COUNT_WORKFLOWREVIEW_WHERE = "SELECT COUNT(workflowReview) FROM WorkflowReview workflowReview WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workflowReview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkflowReview exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkflowReview exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WorkflowReviewPersistenceImpl.class);
}