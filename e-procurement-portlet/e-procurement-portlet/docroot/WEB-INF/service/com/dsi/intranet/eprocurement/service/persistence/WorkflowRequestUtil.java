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

import com.dsi.intranet.eprocurement.model.WorkflowRequest;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the workflow request service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowRequestPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowRequestPersistenceImpl
 * @generated
 */
@ProviderType
public class WorkflowRequestUtil {
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
	public static void clearCache(WorkflowRequest workflowRequest) {
		getPersistence().clearCache(workflowRequest);
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
	public static List<WorkflowRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkflowRequest update(WorkflowRequest workflowRequest) {
		return getPersistence().update(workflowRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkflowRequest update(WorkflowRequest workflowRequest,
		ServiceContext serviceContext) {
		return getPersistence().update(workflowRequest, serviceContext);
	}

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
	public static WorkflowRequest findByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence()
				   .findByClassPK(companyId, groupId, classNameId, classPK,
			isActive);
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
	public static WorkflowRequest fetchByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive) {
		return getPersistence()
				   .fetchByClassPK(companyId, groupId, classNameId, classPK,
			isActive);
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
	public static WorkflowRequest fetchByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByClassPK(companyId, groupId, classNameId, classPK,
			isActive, retrieveFromCache);
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
	public static WorkflowRequest removeByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence()
				   .removeByClassPK(companyId, groupId, classNameId, classPK,
			isActive);
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
	public static int countByClassPK(long companyId, long groupId,
		long classNameId, long classPK, boolean isActive) {
		return getPersistence()
				   .countByClassPK(companyId, groupId, classNameId, classPK,
			isActive);
	}

	/**
	* Returns all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param workflowDefinitionId the workflow definition ID
	* @param isActive the is active
	* @return the matching workflow requests
	*/
	public static List<WorkflowRequest> findByworkflowDefinitionId(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive) {
		return getPersistence()
				   .findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive);
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
	public static List<WorkflowRequest> findByworkflowDefinitionId(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, int start, int end) {
		return getPersistence()
				   .findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, start, end);
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
	public static List<WorkflowRequest> findByworkflowDefinitionId(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		return getPersistence()
				   .findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, start, end, orderByComparator);
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
	public static List<WorkflowRequest> findByworkflowDefinitionId(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive, start, end, orderByComparator,
			retrieveFromCache);
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
	public static WorkflowRequest findByworkflowDefinitionId_First(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, OrderByComparator<WorkflowRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence()
				   .findByworkflowDefinitionId_First(companyId, groupId,
			workflowDefinitionId, isActive, orderByComparator);
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
	public static WorkflowRequest fetchByworkflowDefinitionId_First(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, OrderByComparator<WorkflowRequest> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowDefinitionId_First(companyId, groupId,
			workflowDefinitionId, isActive, orderByComparator);
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
	public static WorkflowRequest findByworkflowDefinitionId_Last(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, OrderByComparator<WorkflowRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence()
				   .findByworkflowDefinitionId_Last(companyId, groupId,
			workflowDefinitionId, isActive, orderByComparator);
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
	public static WorkflowRequest fetchByworkflowDefinitionId_Last(
		long companyId, long groupId, long workflowDefinitionId,
		boolean isActive, OrderByComparator<WorkflowRequest> orderByComparator) {
		return getPersistence()
				   .fetchByworkflowDefinitionId_Last(companyId, groupId,
			workflowDefinitionId, isActive, orderByComparator);
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
	public static WorkflowRequest[] findByworkflowDefinitionId_PrevAndNext(
		long workflowRequestId, long companyId, long groupId,
		long workflowDefinitionId, boolean isActive,
		OrderByComparator<WorkflowRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence()
				   .findByworkflowDefinitionId_PrevAndNext(workflowRequestId,
			companyId, groupId, workflowDefinitionId, isActive,
			orderByComparator);
	}

	/**
	* Removes all the workflow requests where companyId = &#63; and groupId = &#63; and workflowDefinitionId = &#63; and isActive = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param workflowDefinitionId the workflow definition ID
	* @param isActive the is active
	*/
	public static void removeByworkflowDefinitionId(long companyId,
		long groupId, long workflowDefinitionId, boolean isActive) {
		getPersistence()
			.removeByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive);
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
	public static int countByworkflowDefinitionId(long companyId, long groupId,
		long workflowDefinitionId, boolean isActive) {
		return getPersistence()
				   .countByworkflowDefinitionId(companyId, groupId,
			workflowDefinitionId, isActive);
	}

	/**
	* Caches the workflow request in the entity cache if it is enabled.
	*
	* @param workflowRequest the workflow request
	*/
	public static void cacheResult(WorkflowRequest workflowRequest) {
		getPersistence().cacheResult(workflowRequest);
	}

	/**
	* Caches the workflow requests in the entity cache if it is enabled.
	*
	* @param workflowRequests the workflow requests
	*/
	public static void cacheResult(List<WorkflowRequest> workflowRequests) {
		getPersistence().cacheResult(workflowRequests);
	}

	/**
	* Creates a new workflow request with the primary key. Does not add the workflow request to the database.
	*
	* @param workflowRequestId the primary key for the new workflow request
	* @return the new workflow request
	*/
	public static WorkflowRequest create(long workflowRequestId) {
		return getPersistence().create(workflowRequestId);
	}

	/**
	* Removes the workflow request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowRequestId the primary key of the workflow request
	* @return the workflow request that was removed
	* @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	*/
	public static WorkflowRequest remove(long workflowRequestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence().remove(workflowRequestId);
	}

	public static WorkflowRequest updateImpl(WorkflowRequest workflowRequest) {
		return getPersistence().updateImpl(workflowRequest);
	}

	/**
	* Returns the workflow request with the primary key or throws a {@link NoSuchWorkflowRequestException} if it could not be found.
	*
	* @param workflowRequestId the primary key of the workflow request
	* @return the workflow request
	* @throws NoSuchWorkflowRequestException if a workflow request with the primary key could not be found
	*/
	public static WorkflowRequest findByPrimaryKey(long workflowRequestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException {
		return getPersistence().findByPrimaryKey(workflowRequestId);
	}

	/**
	* Returns the workflow request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowRequestId the primary key of the workflow request
	* @return the workflow request, or <code>null</code> if a workflow request with the primary key could not be found
	*/
	public static WorkflowRequest fetchByPrimaryKey(long workflowRequestId) {
		return getPersistence().fetchByPrimaryKey(workflowRequestId);
	}

	public static java.util.Map<java.io.Serializable, WorkflowRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the workflow requests.
	*
	* @return the workflow requests
	*/
	public static List<WorkflowRequest> findAll() {
		return getPersistence().findAll();
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
	public static List<WorkflowRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<WorkflowRequest> findAll(int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<WorkflowRequest> findAll(int start, int end,
		OrderByComparator<WorkflowRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the workflow requests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflow requests.
	*
	* @return the number of workflow requests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkflowRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowRequestPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					WorkflowRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static WorkflowRequestPersistence _persistence;
}