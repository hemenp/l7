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

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl;
import com.dsi.intranet.eprocurement.model.impl.WorkflowRequestModelImpl;
import com.dsi.intranet.eprocurement.service.persistence.WorkflowRequestPersistence;

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
 * The persistence implementation for the workflow request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequestPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.WorkflowRequestUtil
 * @generated
 */
@ProviderType
public class WorkflowRequestPersistenceImpl extends BasePersistenceImpl<WorkflowRequest>
	implements WorkflowRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkflowRequestUtil} to access the workflow request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkflowRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED,
			WorkflowRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED,
			WorkflowRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CLASSPK = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED,
			WorkflowRequestImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			WorkflowRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.GROUPID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.CLASSPK_COLUMN_BITMASK |
			WorkflowRequestModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSPK = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

	/**
	 * Returns the workflow request where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; and isActive = &#63; or throws a {@link NoSuchWorkflowRequestException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param isActive the is active
	 * @return the matching workflow request
	 * @throws NoSuchWorkflowRequestException if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest findByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = fetchByClassPK(companyId, groupId,
				classNameId, classPK, isActive);

		if (workflowRequest == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", isActive=");
			msg.append(isActive);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchWorkflowRequestException(msg.toString());
		}

		return workflowRequest;
	}

	/**
	 * Returns the workflow request where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param isActive the is active
	 * @return the matching workflow request, or <code>null</code> if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest fetchByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive) {
		return fetchByClassPK(companyId, groupId, classNameId, classPK,
			isActive, true);
	}

	/**
	 * Returns the workflow request where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param isActive the is active
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching workflow request, or <code>null</code> if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest fetchByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, classPK, isActive
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CLASSPK,
					finderArgs, this);
		}

		if (result instanceof WorkflowRequest) {
			WorkflowRequest workflowRequest = (WorkflowRequest)result;

			if ((companyId != workflowRequest.getCompanyId()) ||
					(groupId != workflowRequest.getGroupId()) ||
					(classNameId != workflowRequest.getClassNameId()) ||
					(classPK != workflowRequest.getClassPK()) ||
					(isActive != workflowRequest.getIsActive())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_WORKFLOWREQUEST_WHERE);

			query.append(_FINDER_COLUMN_CLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSPK_ISACTIVE_2);

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

				qPos.add(isActive);

				List<WorkflowRequest> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CLASSPK,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"WorkflowRequestPersistenceImpl.fetchByClassPK(long, long, long, long, boolean, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WorkflowRequest workflowRequest = list.get(0);

					result = workflowRequest;

					cacheResult(workflowRequest);

					if ((workflowRequest.getCompanyId() != companyId) ||
							(workflowRequest.getGroupId() != groupId) ||
							(workflowRequest.getClassNameId() != classNameId) ||
							(workflowRequest.getClassPK() != classPK) ||
							(workflowRequest.getIsActive() != isActive)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CLASSPK,
							finderArgs, workflowRequest);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CLASSPK,
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
			return (WorkflowRequest)result;
		}
	}

	/**
	 * Removes the workflow request where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; and isActive = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param isActive the is active
	 * @return the workflow request that was removed
	 */
	@Override
	public WorkflowRequest removeByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = findByClassPK(companyId, groupId,
				classNameId, classPK, isActive);

		return remove(workflowRequest);
	}

	/**
	 * Returns the number of workflow requests where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param isActive the is active
	 * @return the number of matching workflow requests
	 */
	@Override
	public int countByClassPK(long companyId, long groupId, long classNameId,
		long classPK, boolean isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSPK;

		Object[] finderArgs = new Object[] {
				companyId, groupId, classNameId, classPK, isActive
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_WORKFLOWREQUEST_WHERE);

			query.append(_FINDER_COLUMN_CLASSPK_COMPANYID_2);

			query.append(_FINDER_COLUMN_CLASSPK_GROUPID_2);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSPK_ISACTIVE_2);

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

				qPos.add(isActive);

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

	private static final String _FINDER_COLUMN_CLASSPK_COMPANYID_2 = "workflowRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSPK_GROUPID_2 = "workflowRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSPK_CLASSNAMEID_2 = "workflowRequest.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSPK_CLASSPK_2 = "workflowRequest.classPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSPK_ISACTIVE_2 = "workflowRequest.isActive = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID =
		new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED,
			WorkflowRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByworkflowDefinitionId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID =
		new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED,
			WorkflowRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByworkflowDefinitionId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			WorkflowRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.GROUPID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.WORKFLOWDEFINITIONID_COLUMN_BITMASK |
			WorkflowRequestModelImpl.ISACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOWDEFINITIONID = new FinderPath(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByworkflowDefinitionId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @return the matching workflow requests
	 */
	@Override
	public List<WorkflowRequest> findByworkflowDefinitionId(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive) {
		return findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @return the range of matching workflow requests
	 */
	@Override
	public List<WorkflowRequest> findByworkflowDefinitionId(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive, int start,
		int end) {
		return findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflow requests
	 */
	@Override
	public List<WorkflowRequest> findByworkflowDefinitionId(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive, int start,
		int end, OrderByComparator<WorkflowRequest> orderByComparator) {
		return findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching workflow requests
	 */
	@Override
	public List<WorkflowRequest> findByworkflowDefinitionId(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive, int start,
		int end, OrderByComparator<WorkflowRequest> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID;
			finderArgs = new Object[] {
					companyId, groupId, workflowDefinitionId, isActive
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID;
			finderArgs = new Object[] {
					companyId, groupId, workflowDefinitionId, isActive,
					
					start, end, orderByComparator
				};
		}

		List<WorkflowRequest> list = null;

		if (retrieveFromCache) {
			list = (List<WorkflowRequest>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkflowRequest workflowRequest : list) {
					if ((companyId != workflowRequest.getCompanyId()) ||
							(groupId != workflowRequest.getGroupId()) ||
							(workflowDefinitionId != workflowRequest.getWorkflowDefinitionId()) ||
							(isActive != workflowRequest.getIsActive())) {
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

			query.append(_SQL_SELECT_WORKFLOWREQUEST_WHERE);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_COMPANYID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_GROUPID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_WORKFLOWDEFINITIONID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkflowRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(workflowDefinitionId);

				qPos.add(isActive);

				if (!pagination) {
					list = (List<WorkflowRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkflowRequest>)QueryUtil.list(q,
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
	 * Returns the first workflow request in the ordered set where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow request
	 * @throws NoSuchWorkflowRequestException if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest findByworkflowDefinitionId_First(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = fetchByworkflowDefinitionId_First(companyId,
				groupId, workflowDefinitionId, isActive, orderByComparator);

		if (workflowRequest != null) {
			return workflowRequest;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", workflowDefinitionId=");
		msg.append(workflowDefinitionId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowRequestException(msg.toString());
	}

	/**
	 * Returns the first workflow request in the ordered set where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow request, or <code>null</code> if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest fetchByworkflowDefinitionId_First(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		List<WorkflowRequest> list = findByworkflowDefinitionId(companyId,
				groupId, workflowDefinitionId, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow request in the ordered set where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow request
	 * @throws NoSuchWorkflowRequestException if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest findByworkflowDefinitionId_Last(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = fetchByworkflowDefinitionId_Last(companyId,
				groupId, workflowDefinitionId, isActive, orderByComparator);

		if (workflowRequest != null) {
			return workflowRequest;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", workflowDefinitionId=");
		msg.append(workflowDefinitionId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowRequestException(msg.toString());
	}

	/**
	 * Returns the last workflow request in the ordered set where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow request, or <code>null</code> if a matching workflow request could not be found
	 */
	@Override
	public WorkflowRequest fetchByworkflowDefinitionId_Last(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		int count = countByworkflowDefinitionId(companyId, groupId,
				workflowDefinitionId, isActive);

		if (count == 0) {
			return null;
		}

		List<WorkflowRequest> list = findByworkflowDefinitionId(companyId,
				groupId, workflowDefinitionId, isActive, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflow requests before and after the current workflow request in the ordered set where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param workflowRequestId the primary key of the current workflow request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow request
	 * @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest[] findByworkflowDefinitionId_PrevAndNext(
		long workflowRequestId, long companyId, long groupId,
		long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = findByPrimaryKey(workflowRequestId);

		Session session = null;

		try {
			session = openSession();

			WorkflowRequest[] array = new WorkflowRequestImpl[3];

			array[0] = getByworkflowDefinitionId_PrevAndNext(session,
					workflowRequest, companyId, groupId, workflowDefinitionId,
					isActive, orderByComparator, true);

			array[1] = workflowRequest;

			array[2] = getByworkflowDefinitionId_PrevAndNext(session,
					workflowRequest, companyId, groupId, workflowDefinitionId,
					isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkflowRequest getByworkflowDefinitionId_PrevAndNext(
		Session session, WorkflowRequest workflowRequest, long companyId,
		long groupId, long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_WORKFLOWREQUEST_WHERE);

		query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_COMPANYID_2);

		query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_GROUPID_2);

		query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_WORKFLOWDEFINITIONID_2);

		query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_ISACTIVE_2);

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
			query.append(WorkflowRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(workflowDefinitionId);

		qPos.add(isActive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workflowRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkflowRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 */
	@Override
	public void removeByworkflowDefinitionId(long companyId, long groupId,
		long workflowDefinitionId, boolean isActive) {
		for (WorkflowRequest workflowRequest : findByworkflowDefinitionId(
				companyId, groupId, workflowDefinitionId, isActive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workflowRequest);
		}
	}

	/**
	 * Returns the number of workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param workflowDefinitionId the workflow definition ID
	 * @param isActive the is active
	 * @return the number of matching workflow requests
	 */
	@Override
	public int countByworkflowDefinitionId(long companyId, long groupId,
		long workflowDefinitionId, boolean isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKFLOWDEFINITIONID;

		Object[] finderArgs = new Object[] {
				companyId, groupId, workflowDefinitionId, isActive
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_WORKFLOWREQUEST_WHERE);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_COMPANYID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_GROUPID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_WORKFLOWDEFINITIONID_2);

			query.append(_FINDER_COLUMN_WORKFLOWDEFINITIONID_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(workflowDefinitionId);

				qPos.add(isActive);

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

	private static final String _FINDER_COLUMN_WORKFLOWDEFINITIONID_COMPANYID_2 = "workflowRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_WORKFLOWDEFINITIONID_GROUPID_2 = "workflowRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_WORKFLOWDEFINITIONID_WORKFLOWDEFINITIONID_2 =
		"workflowRequest.workflowDefinitionId = ? AND ";
	private static final String _FINDER_COLUMN_WORKFLOWDEFINITIONID_ISACTIVE_2 = "workflowRequest.isActive = ?";

	public WorkflowRequestPersistenceImpl() {
		setModelClass(WorkflowRequest.class);
	}

	/**
	 * Caches the workflow request in the entity cache if it is enabled.
	 *
	 * @param workflowRequest the workflow request
	 */
	@Override
	public void cacheResult(WorkflowRequest workflowRequest) {
		entityCache.putResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestImpl.class, workflowRequest.getPrimaryKey(),
			workflowRequest);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CLASSPK,
			new Object[] {
				workflowRequest.getCompanyId(), workflowRequest.getGroupId(),
				workflowRequest.getClassNameId(), workflowRequest.getClassPK(),
				workflowRequest.getIsActive()
			}, workflowRequest);

		workflowRequest.resetOriginalValues();
	}

	/**
	 * Caches the workflow requests in the entity cache if it is enabled.
	 *
	 * @param workflowRequests the workflow requests
	 */
	@Override
	public void cacheResult(List<WorkflowRequest> workflowRequests) {
		for (WorkflowRequest workflowRequest : workflowRequests) {
			if (entityCache.getResult(
						WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowRequestImpl.class,
						workflowRequest.getPrimaryKey()) == null) {
				cacheResult(workflowRequest);
			}
			else {
				workflowRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workflow requests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkflowRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workflow request.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkflowRequest workflowRequest) {
		entityCache.removeResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestImpl.class, workflowRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WorkflowRequestModelImpl)workflowRequest, true);
	}

	@Override
	public void clearCache(List<WorkflowRequest> workflowRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkflowRequest workflowRequest : workflowRequests) {
			entityCache.removeResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowRequestImpl.class, workflowRequest.getPrimaryKey());

			clearUniqueFindersCache((WorkflowRequestModelImpl)workflowRequest,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		WorkflowRequestModelImpl workflowRequestModelImpl) {
		Object[] args = new Object[] {
				workflowRequestModelImpl.getCompanyId(),
				workflowRequestModelImpl.getGroupId(),
				workflowRequestModelImpl.getClassNameId(),
				workflowRequestModelImpl.getClassPK(),
				workflowRequestModelImpl.getIsActive()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_CLASSPK, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CLASSPK, args,
			workflowRequestModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WorkflowRequestModelImpl workflowRequestModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					workflowRequestModelImpl.getCompanyId(),
					workflowRequestModelImpl.getGroupId(),
					workflowRequestModelImpl.getClassNameId(),
					workflowRequestModelImpl.getClassPK(),
					workflowRequestModelImpl.getIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSPK, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CLASSPK, args);
		}

		if ((workflowRequestModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLASSPK.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					workflowRequestModelImpl.getOriginalCompanyId(),
					workflowRequestModelImpl.getOriginalGroupId(),
					workflowRequestModelImpl.getOriginalClassNameId(),
					workflowRequestModelImpl.getOriginalClassPK(),
					workflowRequestModelImpl.getOriginalIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSPK, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CLASSPK, args);
		}
	}

	/**
	 * Creates a new workflow request with the primary key. Does not add the workflow request to the database.
	 *
	 * @param workflowRequestId the primary key for the new workflow request
	 * @return the new workflow request
	 */
	@Override
	public WorkflowRequest create(long workflowRequestId) {
		WorkflowRequest workflowRequest = new WorkflowRequestImpl();

		workflowRequest.setNew(true);
		workflowRequest.setPrimaryKey(workflowRequestId);

		workflowRequest.setCompanyId(companyProvider.getCompanyId());

		return workflowRequest;
	}

	/**
	 * Removes the workflow request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowRequestId the primary key of the workflow request
	 * @return the workflow request that was removed
	 * @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest remove(long workflowRequestId)
		throws NoSuchWorkflowRequestException {
		return remove((Serializable)workflowRequestId);
	}

	/**
	 * Removes the workflow request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workflow request
	 * @return the workflow request that was removed
	 * @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest remove(Serializable primaryKey)
		throws NoSuchWorkflowRequestException {
		Session session = null;

		try {
			session = openSession();

			WorkflowRequest workflowRequest = (WorkflowRequest)session.get(WorkflowRequestImpl.class,
					primaryKey);

			if (workflowRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkflowRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workflowRequest);
		}
		catch (NoSuchWorkflowRequestException nsee) {
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
	protected WorkflowRequest removeImpl(WorkflowRequest workflowRequest) {
		workflowRequest = toUnwrappedModel(workflowRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workflowRequest)) {
				workflowRequest = (WorkflowRequest)session.get(WorkflowRequestImpl.class,
						workflowRequest.getPrimaryKeyObj());
			}

			if (workflowRequest != null) {
				session.delete(workflowRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workflowRequest != null) {
			clearCache(workflowRequest);
		}

		return workflowRequest;
	}

	@Override
	public WorkflowRequest updateImpl(WorkflowRequest workflowRequest) {
		workflowRequest = toUnwrappedModel(workflowRequest);

		boolean isNew = workflowRequest.isNew();

		WorkflowRequestModelImpl workflowRequestModelImpl = (WorkflowRequestModelImpl)workflowRequest;

		Session session = null;

		try {
			session = openSession();

			if (workflowRequest.isNew()) {
				session.save(workflowRequest);

				workflowRequest.setNew(false);
			}
			else {
				workflowRequest = (WorkflowRequest)session.merge(workflowRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WorkflowRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					workflowRequestModelImpl.getCompanyId(),
					workflowRequestModelImpl.getGroupId(),
					workflowRequestModelImpl.getWorkflowDefinitionId(),
					workflowRequestModelImpl.getIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWDEFINITIONID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((workflowRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workflowRequestModelImpl.getOriginalCompanyId(),
						workflowRequestModelImpl.getOriginalGroupId(),
						workflowRequestModelImpl.getOriginalWorkflowDefinitionId(),
						workflowRequestModelImpl.getOriginalIsActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWDEFINITIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID,
					args);

				args = new Object[] {
						workflowRequestModelImpl.getCompanyId(),
						workflowRequestModelImpl.getGroupId(),
						workflowRequestModelImpl.getWorkflowDefinitionId(),
						workflowRequestModelImpl.getIsActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WORKFLOWDEFINITIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKFLOWDEFINITIONID,
					args);
			}
		}

		entityCache.putResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowRequestImpl.class, workflowRequest.getPrimaryKey(),
			workflowRequest, false);

		clearUniqueFindersCache(workflowRequestModelImpl, false);
		cacheUniqueFindersCache(workflowRequestModelImpl);

		workflowRequest.resetOriginalValues();

		return workflowRequest;
	}

	protected WorkflowRequest toUnwrappedModel(WorkflowRequest workflowRequest) {
		if (workflowRequest instanceof WorkflowRequestImpl) {
			return workflowRequest;
		}

		WorkflowRequestImpl workflowRequestImpl = new WorkflowRequestImpl();

		workflowRequestImpl.setNew(workflowRequest.isNew());
		workflowRequestImpl.setPrimaryKey(workflowRequest.getPrimaryKey());

		workflowRequestImpl.setWorkflowRequestId(workflowRequest.getWorkflowRequestId());
		workflowRequestImpl.setWorkflowDefinitionId(workflowRequest.getWorkflowDefinitionId());
		workflowRequestImpl.setClassNameId(workflowRequest.getClassNameId());
		workflowRequestImpl.setClassPK(workflowRequest.getClassPK());
		workflowRequestImpl.setIsActive(workflowRequest.isIsActive());
		workflowRequestImpl.setCreatedBy(workflowRequest.getCreatedBy());
		workflowRequestImpl.setCreatedDate(workflowRequest.getCreatedDate());
		workflowRequestImpl.setModifiedBy(workflowRequest.getModifiedBy());
		workflowRequestImpl.setModifiedDate(workflowRequest.getModifiedDate());
		workflowRequestImpl.setCompanyId(workflowRequest.getCompanyId());
		workflowRequestImpl.setGroupId(workflowRequest.getGroupId());

		return workflowRequestImpl;
	}

	/**
	 * Returns the workflow request with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow request
	 * @return the workflow request
	 * @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkflowRequestException {
		WorkflowRequest workflowRequest = fetchByPrimaryKey(primaryKey);

		if (workflowRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkflowRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workflowRequest;
	}

	/**
	 * Returns the workflow request with the primary key or throws a {@link NoSuchWorkflowRequestException} if it could not be found.
	 *
	 * @param workflowRequestId the primary key of the workflow request
	 * @return the workflow request
	 * @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest findByPrimaryKey(long workflowRequestId)
		throws NoSuchWorkflowRequestException {
		return findByPrimaryKey((Serializable)workflowRequestId);
	}

	/**
	 * Returns the workflow request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow request
	 * @return the workflow request, or <code>null</code> if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowRequestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorkflowRequest workflowRequest = (WorkflowRequest)serializable;

		if (workflowRequest == null) {
			Session session = null;

			try {
				session = openSession();

				workflowRequest = (WorkflowRequest)session.get(WorkflowRequestImpl.class,
						primaryKey);

				if (workflowRequest != null) {
					cacheResult(workflowRequest);
				}
				else {
					entityCache.putResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowRequestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workflowRequest;
	}

	/**
	 * Returns the workflow request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowRequestId the primary key of the workflow request
	 * @return the workflow request, or <code>null</code> if a workflow request with the primary key could not be found
	 */
	@Override
	public WorkflowRequest fetchByPrimaryKey(long workflowRequestId) {
		return fetchByPrimaryKey((Serializable)workflowRequestId);
	}

	@Override
	public Map<Serializable, WorkflowRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorkflowRequest> map = new HashMap<Serializable, WorkflowRequest>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorkflowRequest workflowRequest = fetchByPrimaryKey(primaryKey);

			if (workflowRequest != null) {
				map.put(primaryKey, workflowRequest);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowRequestImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorkflowRequest)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKFLOWREQUEST_WHERE_PKS_IN);

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

			for (WorkflowRequest workflowRequest : (List<WorkflowRequest>)q.list()) {
				map.put(workflowRequest.getPrimaryKeyObj(), workflowRequest);

				cacheResult(workflowRequest);

				uncachedPrimaryKeys.remove(workflowRequest.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorkflowRequestModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowRequestImpl.class, primaryKey, nullModel);
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
	 * Returns all the workflow requests.
	 *
	 * @return the workflow requests
	 */
	@Override
	public List<WorkflowRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @return the range of workflow requests
	 */
	@Override
	public List<WorkflowRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflow requests
	 */
	@Override
	public List<WorkflowRequest> findAll(int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the workflow requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow requests
	 * @param end the upper bound of the range of workflow requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of workflow requests
	 */
	@Override
	public List<WorkflowRequest> findAll(int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator,
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

		List<WorkflowRequest> list = null;

		if (retrieveFromCache) {
			list = (List<WorkflowRequest>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKFLOWREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOWREQUEST;

				if (pagination) {
					sql = sql.concat(WorkflowRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkflowRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkflowRequest>)QueryUtil.list(q,
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
	 * Removes all the workflow requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkflowRequest workflowRequest : findAll()) {
			remove(workflowRequest);
		}
	}

	/**
	 * Returns the number of workflow requests.
	 *
	 * @return the number of workflow requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKFLOWREQUEST);

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
		return WorkflowRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the workflow request persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorkflowRequestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_WORKFLOWREQUEST = "SELECT workflowRequest FROM WorkflowRequest workflowRequest";
	private static final String _SQL_SELECT_WORKFLOWREQUEST_WHERE_PKS_IN = "SELECT workflowRequest FROM WorkflowRequest workflowRequest WHERE workflowRequestId IN (";
	private static final String _SQL_SELECT_WORKFLOWREQUEST_WHERE = "SELECT workflowRequest FROM WorkflowRequest workflowRequest WHERE ";
	private static final String _SQL_COUNT_WORKFLOWREQUEST = "SELECT COUNT(workflowRequest) FROM WorkflowRequest workflowRequest";
	private static final String _SQL_COUNT_WORKFLOWREQUEST_WHERE = "SELECT COUNT(workflowRequest) FROM WorkflowRequest workflowRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workflowRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkflowRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkflowRequest exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WorkflowRequestPersistenceImpl.class);
}