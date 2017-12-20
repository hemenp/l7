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

import com.dsi.intranet.eprocurement.model.WorkflowDefinition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the workflow definition service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowDefinitionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinitionPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowDefinitionPersistenceImpl
 * @generated
 */
@ProviderType
public class WorkflowDefinitionUtil {
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
	public static void clearCache(WorkflowDefinition workflowDefinition) {
		getPersistence().clearCache(workflowDefinition);
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
	public static List<WorkflowDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowDefinition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkflowDefinition> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkflowDefinition update(
		WorkflowDefinition workflowDefinition) {
		return getPersistence().update(workflowDefinition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkflowDefinition update(
		WorkflowDefinition workflowDefinition, ServiceContext serviceContext) {
		return getPersistence().update(workflowDefinition, serviceContext);
	}

	/**
	* Returns all the workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @return the matching workflow definitions
	*/
	public static List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive) {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions(companyId, isActive);
	}

	/**
	* Returns a range of all the workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @return the range of matching workflow definitions
	*/
	public static List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end) {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions(companyId, isActive,
			start, end);
	}

	/**
	* Returns an ordered range of all the workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow definitions
	*/
	public static List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end,
		OrderByComparator<WorkflowDefinition> orderByComparator) {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions(companyId, isActive,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching workflow definitions
	*/
	public static List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end,
		OrderByComparator<WorkflowDefinition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions(companyId, isActive,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition findByGetActiveWorkflowDefinitions_First(
		long companyId, boolean isActive,
		OrderByComparator<WorkflowDefinition> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions_First(companyId,
			isActive, orderByComparator);
	}

	/**
	* Returns the first workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition fetchByGetActiveWorkflowDefinitions_First(
		long companyId, boolean isActive,
		OrderByComparator<WorkflowDefinition> orderByComparator) {
		return getPersistence()
				   .fetchByGetActiveWorkflowDefinitions_First(companyId,
			isActive, orderByComparator);
	}

	/**
	* Returns the last workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition findByGetActiveWorkflowDefinitions_Last(
		long companyId, boolean isActive,
		OrderByComparator<WorkflowDefinition> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions_Last(companyId,
			isActive, orderByComparator);
	}

	/**
	* Returns the last workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition fetchByGetActiveWorkflowDefinitions_Last(
		long companyId, boolean isActive,
		OrderByComparator<WorkflowDefinition> orderByComparator) {
		return getPersistence()
				   .fetchByGetActiveWorkflowDefinitions_Last(companyId,
			isActive, orderByComparator);
	}

	/**
	* Returns the workflow definitions before and after the current workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param workflowDefinitionId the primary key of the current workflow definition
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow definition
	* @throws NoSuchWorkflowDefinitionException if a workflow definition with the primary key could not be found
	*/
	public static WorkflowDefinition[] findByGetActiveWorkflowDefinitions_PrevAndNext(
		long workflowDefinitionId, long companyId, boolean isActive,
		OrderByComparator<WorkflowDefinition> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence()
				   .findByGetActiveWorkflowDefinitions_PrevAndNext(workflowDefinitionId,
			companyId, isActive, orderByComparator);
	}

	/**
	* Removes all the workflow definitions where companyId = &#63; and isActive = &#63; from the database.
	*
	* @param companyId the company ID
	* @param isActive the is active
	*/
	public static void removeByGetActiveWorkflowDefinitions(long companyId,
		boolean isActive) {
		getPersistence()
			.removeByGetActiveWorkflowDefinitions(companyId, isActive);
	}

	/**
	* Returns the number of workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @return the number of matching workflow definitions
	*/
	public static int countByGetActiveWorkflowDefinitions(long companyId,
		boolean isActive) {
		return getPersistence()
				   .countByGetActiveWorkflowDefinitions(companyId, isActive);
	}

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or throws a {@link NoSuchWorkflowDefinitionException} if it could not be found.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition findByGetWorkflowDefinition(
		long companyId, java.lang.String workflowName)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence()
				   .findByGetWorkflowDefinition(companyId, workflowName);
	}

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition fetchByGetWorkflowDefinition(
		long companyId, java.lang.String workflowName) {
		return getPersistence()
				   .fetchByGetWorkflowDefinition(companyId, workflowName);
	}

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public static WorkflowDefinition fetchByGetWorkflowDefinition(
		long companyId, java.lang.String workflowName, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByGetWorkflowDefinition(companyId, workflowName,
			retrieveFromCache);
	}

	/**
	* Removes the workflow definition where companyId = &#63; and workflowName = &#63; from the database.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the workflow definition that was removed
	*/
	public static WorkflowDefinition removeByGetWorkflowDefinition(
		long companyId, java.lang.String workflowName)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence()
				   .removeByGetWorkflowDefinition(companyId, workflowName);
	}

	/**
	* Returns the number of workflow definitions where companyId = &#63; and workflowName = &#63;.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the number of matching workflow definitions
	*/
	public static int countByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName) {
		return getPersistence()
				   .countByGetWorkflowDefinition(companyId, workflowName);
	}

	/**
	* Caches the workflow definition in the entity cache if it is enabled.
	*
	* @param workflowDefinition the workflow definition
	*/
	public static void cacheResult(WorkflowDefinition workflowDefinition) {
		getPersistence().cacheResult(workflowDefinition);
	}

	/**
	* Caches the workflow definitions in the entity cache if it is enabled.
	*
	* @param workflowDefinitions the workflow definitions
	*/
	public static void cacheResult(List<WorkflowDefinition> workflowDefinitions) {
		getPersistence().cacheResult(workflowDefinitions);
	}

	/**
	* Creates a new workflow definition with the primary key. Does not add the workflow definition to the database.
	*
	* @param workflowDefinitionId the primary key for the new workflow definition
	* @return the new workflow definition
	*/
	public static WorkflowDefinition create(long workflowDefinitionId) {
		return getPersistence().create(workflowDefinitionId);
	}

	/**
	* Removes the workflow definition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition that was removed
	* @throws NoSuchWorkflowDefinitionException if a workflow definition with the primary key could not be found
	*/
	public static WorkflowDefinition remove(long workflowDefinitionId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence().remove(workflowDefinitionId);
	}

	public static WorkflowDefinition updateImpl(
		WorkflowDefinition workflowDefinition) {
		return getPersistence().updateImpl(workflowDefinition);
	}

	/**
	* Returns the workflow definition with the primary key or throws a {@link NoSuchWorkflowDefinitionException} if it could not be found.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition
	* @throws NoSuchWorkflowDefinitionException if a workflow definition with the primary key could not be found
	*/
	public static WorkflowDefinition findByPrimaryKey(long workflowDefinitionId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getPersistence().findByPrimaryKey(workflowDefinitionId);
	}

	/**
	* Returns the workflow definition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition, or <code>null</code> if a workflow definition with the primary key could not be found
	*/
	public static WorkflowDefinition fetchByPrimaryKey(
		long workflowDefinitionId) {
		return getPersistence().fetchByPrimaryKey(workflowDefinitionId);
	}

	public static java.util.Map<java.io.Serializable, WorkflowDefinition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the workflow definitions.
	*
	* @return the workflow definitions
	*/
	public static List<WorkflowDefinition> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the workflow definitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @return the range of workflow definitions
	*/
	public static List<WorkflowDefinition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the workflow definitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow definitions
	*/
	public static List<WorkflowDefinition> findAll(int start, int end,
		OrderByComparator<WorkflowDefinition> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the workflow definitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of workflow definitions
	*/
	public static List<WorkflowDefinition> findAll(int start, int end,
		OrderByComparator<WorkflowDefinition> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the workflow definitions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflow definitions.
	*
	* @return the number of workflow definitions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkflowDefinitionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowDefinitionPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					WorkflowDefinitionPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowDefinitionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static WorkflowDefinitionPersistence _persistence;
}