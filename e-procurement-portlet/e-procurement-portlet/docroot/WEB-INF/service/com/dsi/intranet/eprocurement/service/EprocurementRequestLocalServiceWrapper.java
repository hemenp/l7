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
 * Provides a wrapper for {@link EprocurementRequestLocalService}.
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestLocalService
 * @generated
 */
@ProviderType
public class EprocurementRequestLocalServiceWrapper
	implements EprocurementRequestLocalService,
		ServiceWrapper<EprocurementRequestLocalService> {
	public EprocurementRequestLocalServiceWrapper(
		EprocurementRequestLocalService eprocurementRequestLocalService) {
		_eprocurementRequestLocalService = eprocurementRequestLocalService;
	}

	/**
	* Adds the eprocurement request to the database. Also notifies the appropriate model listeners.
	*
	* @param eprocurementRequest the eprocurement request
	* @return the eprocurement request that was added
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest addEprocurementRequest(
		com.dsi.intranet.eprocurement.model.EprocurementRequest eprocurementRequest) {
		return _eprocurementRequestLocalService.addEprocurementRequest(eprocurementRequest);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest addEprocurementRequest(
		com.dsi.intranet.eprocurement.model.EprocurementRequest eprocurementRequest,
		java.lang.String[] itemRows) {
		return _eprocurementRequestLocalService.addEprocurementRequest(eprocurementRequest,
			itemRows);
	}

	/**
	* Creates a new eprocurement request with the primary key. Does not add the eprocurement request to the database.
	*
	* @param requestId the primary key for the new eprocurement request
	* @return the new eprocurement request
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest createEprocurementRequest(
		long requestId) {
		return _eprocurementRequestLocalService.createEprocurementRequest(requestId);
	}

	/**
	* Deletes the eprocurement request from the database. Also notifies the appropriate model listeners.
	*
	* @param eprocurementRequest the eprocurement request
	* @return the eprocurement request that was removed
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest deleteEprocurementRequest(
		com.dsi.intranet.eprocurement.model.EprocurementRequest eprocurementRequest) {
		return _eprocurementRequestLocalService.deleteEprocurementRequest(eprocurementRequest);
	}

	/**
	* Deletes the eprocurement request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request that was removed
	* @throws PortalException if a eprocurement request with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest deleteEprocurementRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eprocurementRequestLocalService.deleteEprocurementRequest(requestId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest fetchEprocurementRequest(
		long requestId) {
		return _eprocurementRequestLocalService.fetchEprocurementRequest(requestId);
	}

	/**
	* Returns the eprocurement request with the primary key.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request
	* @throws PortalException if a eprocurement request with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest getEprocurementRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eprocurementRequestLocalService.getEprocurementRequest(requestId);
	}

	/**
	* Updates the eprocurement request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprocurementRequest the eprocurement request
	* @return the eprocurement request that was updated
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.EprocurementRequest updateEprocurementRequest(
		com.dsi.intranet.eprocurement.model.EprocurementRequest eprocurementRequest) {
		return _eprocurementRequestLocalService.updateEprocurementRequest(eprocurementRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _eprocurementRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eprocurementRequestLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _eprocurementRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eprocurementRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eprocurementRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int countByStatus(long companyId, long groupId,
		java.lang.String status) {
		return _eprocurementRequestLocalService.countByStatus(companyId,
			groupId, status);
	}

	@Override
	public int countByStatusAndCity(long companyId, long groupId,
		java.lang.String status, java.lang.String city) {
		return _eprocurementRequestLocalService.countByStatusAndCity(companyId,
			groupId, status, city);
	}

	/**
	* Returns the number of eprocurement requests.
	*
	* @return the number of eprocurement requests
	*/
	@Override
	public int getEprocurementRequestsCount() {
		return _eprocurementRequestLocalService.getEprocurementRequestsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eprocurementRequestLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _eprocurementRequestLocalService.getOSGiServiceIdentifier();
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
		return _eprocurementRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprocurementRequestLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eprocurementRequestLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.EprocurementRequest> findByStatus(
		long companyId, long groupId, java.lang.String status, int start,
		int end) {
		return _eprocurementRequestLocalService.findByStatus(companyId,
			groupId, status, start, end);
	}

	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.EprocurementRequest> findByStatusAndCity(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end) {
		return _eprocurementRequestLocalService.findByStatusAndCity(companyId,
			groupId, status, city, start, end);
	}

	/**
	* Returns a range of all the eprocurement requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of eprocurement requests
	*/
	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.EprocurementRequest> getEprocurementRequests(
		int start, int end) {
		return _eprocurementRequestLocalService.getEprocurementRequests(start,
			end);
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
		return _eprocurementRequestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eprocurementRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public EprocurementRequestLocalService getWrappedService() {
		return _eprocurementRequestLocalService;
	}

	@Override
	public void setWrappedService(
		EprocurementRequestLocalService eprocurementRequestLocalService) {
		_eprocurementRequestLocalService = eprocurementRequestLocalService;
	}

	private EprocurementRequestLocalService _eprocurementRequestLocalService;
}