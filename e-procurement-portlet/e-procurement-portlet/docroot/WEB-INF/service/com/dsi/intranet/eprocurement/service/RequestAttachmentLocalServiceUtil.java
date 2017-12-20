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
 * Provides the local service utility for RequestAttachment. This utility wraps
 * {@link com.dsi.intranet.eprocurement.service.impl.RequestAttachmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentLocalService
 * @see com.dsi.intranet.eprocurement.service.base.RequestAttachmentLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.impl.RequestAttachmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class RequestAttachmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dsi.intranet.eprocurement.service.impl.RequestAttachmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the request attachment to the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was added
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment addRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return getService().addRequestAttachment(requestAttachment);
	}

	/**
	* Creates a new request attachment with the primary key. Does not add the request attachment to the database.
	*
	* @param requestAttachmentId the primary key for the new request attachment
	* @return the new request attachment
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment createRequestAttachment(
		long requestAttachmentId) {
		return getService().createRequestAttachment(requestAttachmentId);
	}

	/**
	* Deletes the request attachment from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was removed
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment deleteRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return getService().deleteRequestAttachment(requestAttachment);
	}

	/**
	* Deletes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment that was removed
	* @throws PortalException if a request attachment with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment deleteRequestAttachment(
		long requestAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRequestAttachment(requestAttachmentId);
	}

	public static com.dsi.intranet.eprocurement.model.RequestAttachment fetchRequestAttachment(
		long requestAttachmentId) {
		return getService().fetchRequestAttachment(requestAttachmentId);
	}

	/**
	* Returns the request attachment with the primary key.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment
	* @throws PortalException if a request attachment with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment getRequestAttachment(
		long requestAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRequestAttachment(requestAttachmentId);
	}

	public static com.dsi.intranet.eprocurement.model.RequestAttachment getRequestAttachmentsByFileEntryId(
		long fileEntryId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getService().getRequestAttachmentsByFileEntryId(fileEntryId);
	}

	/**
	* Updates the request attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param requestAttachment the request attachment
	* @return the request attachment that was updated
	*/
	public static com.dsi.intranet.eprocurement.model.RequestAttachment updateRequestAttachment(
		com.dsi.intranet.eprocurement.model.RequestAttachment requestAttachment) {
		return getService().updateRequestAttachment(requestAttachment);
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
	* Returns the number of request attachments.
	*
	* @return the number of request attachments
	*/
	public static int getRequestAttachmentsCount() {
		return getService().getRequestAttachmentsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<com.dsi.intranet.eprocurement.model.RequestAttachment> getRequestAttachments(
		int start, int end) {
		return getService().getRequestAttachments(start, end);
	}

	public static java.util.List<com.dsi.intranet.eprocurement.model.RequestAttachment> getRequestAttachmentsByRequestId(
		long requestId) {
		return getService().getRequestAttachmentsByRequestId(requestId);
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

	public static RequestAttachmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RequestAttachmentLocalService.class.getName());

			if (invokableLocalService instanceof RequestAttachmentLocalService) {
				_service = (RequestAttachmentLocalService)invokableLocalService;
			}
			else {
				_service = new RequestAttachmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RequestAttachmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static RequestAttachmentLocalService _service;
}