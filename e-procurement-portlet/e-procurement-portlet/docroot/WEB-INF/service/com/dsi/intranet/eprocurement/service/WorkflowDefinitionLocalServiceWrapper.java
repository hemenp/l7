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

package com.dsi.intranet.eprocurement.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkflowDefinitionLocalService}.
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinitionLocalService
 * @generated
 */
@ProviderType
public class WorkflowDefinitionLocalServiceWrapper
	implements WorkflowDefinitionLocalService,
		ServiceWrapper<WorkflowDefinitionLocalService> {
	public WorkflowDefinitionLocalServiceWrapper(
		WorkflowDefinitionLocalService workflowDefinitionLocalService) {
		_workflowDefinitionLocalService = workflowDefinitionLocalService;
	}

	/**
	* Adds the workflow definition to the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was added
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition addWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return _workflowDefinitionLocalService.addWorkflowDefinition(workflowDefinition);
	}

	/**
	* Creates a new workflow definition with the primary key. Does not add the workflow definition to the database.
	*
	* @param workflowDefinitionId the primary key for the new workflow definition
	* @return the new workflow definition
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition createWorkflowDefinition(
		long workflowDefinitionId) {
		return _workflowDefinitionLocalService.createWorkflowDefinition(workflowDefinitionId);
	}

	/**
	* Deletes the workflow definition from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was removed
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition deleteWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return _workflowDefinitionLocalService.deleteWorkflowDefinition(workflowDefinition);
	}

	/**
	* Deletes the workflow definition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition that was removed
	* @throws PortalException if a workflow definition with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition deleteWorkflowDefinition(
		long workflowDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workflowDefinitionLocalService.deleteWorkflowDefinition(workflowDefinitionId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition fetchWorkflowDefinition(
		long workflowDefinitionId) {
		return _workflowDefinitionLocalService.fetchWorkflowDefinition(workflowDefinitionId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition getWorkflowDefinition(
		long companyId, java.lang.String workflowName)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return _workflowDefinitionLocalService.getWorkflowDefinition(companyId,
			workflowName);
	}

	/**
	* Returns the workflow definition with the primary key.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition
	* @throws PortalException if a workflow definition with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition getWorkflowDefinition(
		long workflowDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workflowDefinitionLocalService.getWorkflowDefinition(workflowDefinitionId);
	}

	/**
	* Updates the workflow definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was updated
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.WorkflowDefinition updateWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return _workflowDefinitionLocalService.updateWorkflowDefinition(workflowDefinition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _workflowDefinitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workflowDefinitionLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _workflowDefinitionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workflowDefinitionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workflowDefinitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of workflow definitions.
	*
	* @return the number of workflow definitions
	*/
	@Override
	public int getWorkflowDefinitionsCount() {
		return _workflowDefinitionLocalService.getWorkflowDefinitionsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workflowDefinitionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _workflowDefinitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _workflowDefinitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _workflowDefinitionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _workflowDefinitionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.WorkflowDefinition> getActiveWorkflowDefinitions(
		long companyId, boolean isActive) {
		return _workflowDefinitionLocalService.getActiveWorkflowDefinitions(companyId,
			isActive);
	}

	/**
	* Returns a range of all the workflow definitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow definitions
	* @param end the upper bound of the range of workflow definitions (not inclusive)
	* @return the range of workflow definitions
	*/
	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.WorkflowDefinition> getWorkflowDefinitions(
		int start, int end) {
		return _workflowDefinitionLocalService.getWorkflowDefinitions(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _workflowDefinitionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _workflowDefinitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WorkflowDefinitionLocalService getWrappedService() {
		return _workflowDefinitionLocalService;
	}

	@Override
	public void setWrappedService(
		WorkflowDefinitionLocalService workflowDefinitionLocalService) {
		_workflowDefinitionLocalService = workflowDefinitionLocalService;
	}

	private WorkflowDefinitionLocalService _workflowDefinitionLocalService;
}