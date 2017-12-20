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
 * Provides a wrapper for {@link RequestAttachmentLocalService}.
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentLocalService
 * @generated
 */
@ProviderType
public class RequestAttachmentLocalServiceWrapper
	implements RequestAttachmentLocalService,
		ServiceWrapper<RequestAttachmentLocalService> {
	public RequestAttachmentLocalServiceWrapper(
		RequestAttachmentLocalService requestAttachmentLocalService) {
		_requestAttachmentLocalService = requestAttachmentLocalService;
	}

	/**
	* Adds the request attachment to the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was added
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment addRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return _requestAttachmentLocalService.addRequestAttachment(requestAttachment);
	}

	/**
	* Creates a new request attachment with the primary key. Does not add the request attachment to the database.
	*
	* @param requestAttachmentId the primary key for the new request attachment
	* @return the new request attachment
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment createRequestAttachment(
		long requestAttachmentId) {
		return _requestAttachmentLocalService.createRequestAttachment(requestAttachmentId);
	}

	/**
	* Deletes the request attachment from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was removed
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment deleteRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return _requestAttachmentLocalService.deleteRequestAttachment(requestAttachment);
	}

	/**
	* Deletes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment that was removed
	* @throws PortalException if a request attachment with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment deleteRequestAttachment(
		long requestAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _requestAttachmentLocalService.deleteRequestAttachment(requestAttachmentId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment fetchRequestAttachment(
		long requestAttachmentId) {
		return _requestAttachmentLocalService.fetchRequestAttachment(requestAttachmentId);
	}

	/**
	* Returns the request attachment with the primary key.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment
	* @throws PortalException if a request attachment with the primary key could not be found
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment getRequestAttachment(
		long requestAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _requestAttachmentLocalService.getRequestAttachment(requestAttachmentId);
	}

	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment getRequestAttachmentsByFileEntryId(
		long fileEntryId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return _requestAttachmentLocalService.getRequestAttachmentsByFileEntryId(fileEntryId);
	}

	/**
	* Updates the request attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was updated
	*/
	@Override
	public com.dsi.intranet.eprocurement.model.RequestAttachment updateRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return _requestAttachmentLocalService.updateRequestAttachment(requestAttachment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _requestAttachmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _requestAttachmentLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _requestAttachmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _requestAttachmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _requestAttachmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of request attachments.
	*
	* @return the number of request attachments
	*/
	@Override
	public int getRequestAttachmentsCount() {
		return _requestAttachmentLocalService.getRequestAttachmentsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _requestAttachmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _requestAttachmentLocalService.getOSGiServiceIdentifier();
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
		return _requestAttachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _requestAttachmentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _requestAttachmentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the request attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @return the range of request attachments
	*/
	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.RequestAttachment> getRequestAttachments(
		int start, int end) {
		return _requestAttachmentLocalService.getRequestAttachments(start, end);
	}

	@Override
	public java.util.List<com.dsi.intranet.eprocurement.model.RequestAttachment> getRequestAttachmentsByRequestId(
		long requestId) {
		return _requestAttachmentLocalService.getRequestAttachmentsByRequestId(requestId);
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
		return _requestAttachmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _requestAttachmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public RequestAttachmentLocalService getWrappedService() {
		return _requestAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		RequestAttachmentLocalService requestAttachmentLocalService) {
		_requestAttachmentLocalService = requestAttachmentLocalService;
	}

	private RequestAttachmentLocalService _requestAttachmentLocalService;
}