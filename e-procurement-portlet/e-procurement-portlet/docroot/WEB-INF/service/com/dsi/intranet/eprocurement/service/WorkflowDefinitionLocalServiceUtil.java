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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for WorkflowDefinition. This utility wraps
 * {@link com.dsi.intranet.eprocurement.service.impl.WorkflowDefinitionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author CIGNEX Technologies
 * @see WorkflowDefinitionLocalService
 * @see com.dsi.intranet.eprocurement.service.base.WorkflowDefinitionLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.impl.WorkflowDefinitionLocalServiceImpl
 * @generated
 */
@ProviderType
public class WorkflowDefinitionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dsi.intranet.eprocurement.service.impl.WorkflowDefinitionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the workflow definition to the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was added
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition addWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return getService().addWorkflowDefinition(workflowDefinition);
	}

	/**
	* Creates a new workflow definition with the primary key. Does not add the workflow definition to the database.
	*
	* @param workflowDefinitionId the primary key for the new workflow definition
	* @return the new workflow definition
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition createWorkflowDefinition(
		long workflowDefinitionId) {
		return getService().createWorkflowDefinition(workflowDefinitionId);
	}

	/**
	* Deletes the workflow definition from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was removed
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition deleteWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return getService().deleteWorkflowDefinition(workflowDefinition);
	}

	/**
	* Deletes the workflow definition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition that was removed
	* @throws PortalException if a workflow definition with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition deleteWorkflowDefinition(
		long workflowDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWorkflowDefinition(workflowDefinitionId);
	}

	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition fetchWorkflowDefinition(
		long workflowDefinitionId) {
		return getService().fetchWorkflowDefinition(workflowDefinitionId);
	}

	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition getWorkflowDefinition(
		long companyId, java.lang.String workflowName)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException {
		return getService().getWorkflowDefinition(companyId, workflowName);
	}

	/**
	* Returns the workflow definition with the primary key.
	*
	* @param workflowDefinitionId the primary key of the workflow definition
	* @return the workflow definition
	* @throws PortalException if a workflow definition with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition getWorkflowDefinition(
		long workflowDefinitionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWorkflowDefinition(workflowDefinitionId);
	}

	/**
	* Updates the workflow definition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinition the workflow definition
	* @return the workflow definition that was updated
	*/
	public static com.dsi.intranet.eprocurement.model.WorkflowDefinition updateWorkflowDefinition(
		com.dsi.intranet.eprocurement.model.WorkflowDefinition workflowDefinition) {
		return getService().updateWorkflowDefinition(workflowDefinition);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of workflow definitions.
	*
	* @return the number of workflow definitions
	*/
	public static int getWorkflowDefinitionsCount() {
		return getService().getWorkflowDefinitionsCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.dsi.intranet.eprocurement.model.WorkflowDefinition> getActiveWorkflowDefinitions(
		long companyId, boolean isActive) {
		return getService().getActiveWorkflowDefinitions(companyId, isActive);
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
	public static java.util.List<com.dsi.intranet.eprocurement.model.WorkflowDefinition> getWorkflowDefinitions(
		int start, int end) {
		return getService().getWorkflowDefinitions(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void clearService() {
		_service = null;
	}

	public static WorkflowDefinitionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkflowDefinitionLocalService.class.getName());

			if (invokableLocalService instanceof WorkflowDefinitionLocalService) {
				_service = (WorkflowDefinitionLocalService)invokableLocalService;
			}
			else {
				_service = new WorkflowDefinitionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WorkflowDefinitionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static WorkflowDefinitionLocalService _service;
}