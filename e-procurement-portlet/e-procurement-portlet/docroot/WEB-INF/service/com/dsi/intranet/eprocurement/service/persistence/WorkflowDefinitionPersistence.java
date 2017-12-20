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

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException;
import com.dsi.intranet.eprocurement.model.WorkflowDefinition;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the workflow definition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowDefinitionPersistenceImpl
 * @see WorkflowDefinitionUtil
 * @generated
 */
@ProviderType
public interface WorkflowDefinitionPersistence extends BasePersistence<WorkflowDefinition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowDefinitionUtil} to access the workflow definition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @return the matching workflow definitions
	*/
	public java.util.List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive);

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
	public java.util.List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end);

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
	public java.util.List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator);

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
	public java.util.List<WorkflowDefinition> findByGetActiveWorkflowDefinitions(
		long companyId, boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public WorkflowDefinition findByGetActiveWorkflowDefinitions_First(
		long companyId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator)
		throws NoSuchWorkflowDefinitionException;

	/**
	* Returns the first workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public WorkflowDefinition fetchByGetActiveWorkflowDefinitions_First(
		long companyId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator);

	/**
	* Returns the last workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public WorkflowDefinition findByGetActiveWorkflowDefinitions_Last(
		long companyId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator)
		throws NoSuchWorkflowDefinitionException;

	/**
	* Returns the last workflow definition in the ordered set where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public WorkflowDefinition fetchByGetActiveWorkflowDefinitions_Last(
		long companyId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator);

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
	public WorkflowDefinition[] findByGetActiveWorkflowDefinitions_PrevAndNext(
		long workflowDefinitionId, long companyId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator)
		throws NoSuchWorkflowDefinitionException;

	/**
	* Removes all the workflow definitions where companyId = &#63; and isActive = &#63; from the database.
	*
	* @param companyId the company ID
	* @param isActive the is active
	*/
	public void removeByGetActiveWorkflowDefinitions(long companyId,
		boolean isActive);

	/**
	* Returns the number of workflow definitions where companyId = &#63; and isActive = &#63;.
	*
	* @param companyId the company ID
	* @param isActive the is active
	* @return the number of matching workflow definitions
	*/
	public int countByGetActiveWorkflowDefinitions(long companyId,
		boolean isActive);

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or throws a {@link NoSuchWorkflowDefinitionException} if it could not be found.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the matching workflow definition
	* @throws NoSuchWorkflowDefinitionException if a matching workflow definition could not be found
	*/
	public WorkflowDefinition findByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName) throws NoSuchWorkflowDefinitionException;

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public WorkflowDefinition fetchByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName);

	/**
	* Returns the workflow definition where companyId = &#63; and workflowName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching workflow definition, or <code>null</code> if a matching workflow definition could not be found
	*/
	public WorkflowDefinition fetchByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName, boolean retrieveFromCache);

	/**
	* Removes the workflow definition where companyId = &#63; and workflowName = &#63; from the database.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the workflow definition that was removed
	*/
	public WorkflowDefinition removeByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName) throws NoSuchWorkflowDefinitionException;

	/**
	* Returns the number of workflow definitions where companyId = &#63; and workflowName = &#63;.
	*
	* @param companyId the company ID
	* @param workflowName the workflow name
	* @return the number of matching workflow definitions
	*/
	public int countByGetWorkflowDefinition(long companyId,
		java.lang.String workflowName);

	/**
	* Caches the workflow definition in the entity cache if it is enabled.
	*
	* @param workflowDefinition the workflow definition
	*/
	public void cacheResult(WorkflowDefinition workflowDefinition);

	/**
	* Caches the workflow definitions in the entity cache if it is enabled.
	*
	* @param workflowDefinitions the workflow definitions
	*/
	public void cacheResult(
		java.util.List<WorkflowDefinition> workflowDefinitions);

	/**
	* Creates a new workflow definition with the primary key. Does not add the workflow definition to the database.
	*
	* @param workflowDefinitionId the primary key for the new workflow definition
	* @return the new workflow definition
	*/
	public WorkflowDefinition create(long workflowDefinitionId);

	/**
	* Removes the workflow definition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition that was removed
	* @throws NoSuchWorkflowDefinitionException if a workflow definition with the primary key could not be found
	*/
	public WorkflowDefinition remove(long workflowDefinitionId)
		throws NoSuchWorkflowDefinitionException;

	public WorkflowDefinition updateImpl(WorkflowDefinition workflowDefinition);

	/**
	* Returns the workflow definition with the primary key or throws a {@link NoSuchWorkflowDefinitionException} if it could not be found.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition
	* @throws NoSuchWorkflowDefinitionException if a workflow definition with the primary key could not be found
	*/
	public WorkflowDefinition findByPrimaryKey(long workflowDefinitionId)
		throws NoSuchWorkflowDefinitionException;

	/**
	* Returns the workflow definition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition, or <code>null</code> if a workflow definition with the primary key could not be found
	*/
	public WorkflowDefinition fetchByPrimaryKey(long workflowDefinitionId);

	@Override
	public java.util.Map<java.io.Serializable, WorkflowDefinition> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the workflow definitions.
	*
	* @return the workflow definitions
	*/
	public java.util.List<WorkflowDefinition> findAll();

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
	public java.util.List<WorkflowDefinition> findAll(int start, int end);

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
	public java.util.List<WorkflowDefinition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator);

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
	public java.util.List<WorkflowDefinition> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowDefinition> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the workflow definitions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of workflow definitions.
	*
	* @return the number of workflow definitions
	*/
	public int countAll();
}