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

import com.dsi.intranet.eprocurement.model.RequestAttachment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the request attachment service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.RequestAttachmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see RequestAttachmentPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.RequestAttachmentPersistenceImpl
 * @generated
 */
@ProviderType
public class RequestAttachmentUtil {
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
	public static void clearCache(RequestAttachment requestAttachment) {
		getPersistence().clearCache(requestAttachment);
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
	public static List<RequestAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RequestAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RequestAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RequestAttachment update(RequestAttachment requestAttachment) {
		return getPersistence().update(requestAttachment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RequestAttachment update(
		RequestAttachment requestAttachment, ServiceContext serviceContext) {
		return getPersistence().update(requestAttachment, serviceContext);
	}

	/**
	* Returns all the request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the matching request attachments
	*/
	public static List<RequestAttachment> findByGetRequestAttachments(
		long requestId) {
		return getPersistence().findByGetRequestAttachments(requestId);
	}

	/**
	* Returns a range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @return the range of matching request attachments
	*/
	public static List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end) {
		return getPersistence()
				   .findByGetRequestAttachments(requestId, start, end);
	}

	/**
	* Returns an ordered range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching request attachments
	*/
	public static List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .findByGetRequestAttachments(requestId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching request attachments
	*/
	public static List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGetRequestAttachments(requestId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public static RequestAttachment findByGetRequestAttachments_First(
		long requestId, OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByGetRequestAttachments_First(requestId,
			orderByComparator);
	}

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByGetRequestAttachments_First(
		long requestId, OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .fetchByGetRequestAttachments_First(requestId,
			orderByComparator);
	}

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public static RequestAttachment findByGetRequestAttachments_Last(
		long requestId, OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByGetRequestAttachments_Last(requestId,
			orderByComparator);
	}

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByGetRequestAttachments_Last(
		long requestId, OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .fetchByGetRequestAttachments_Last(requestId,
			orderByComparator);
	}

	/**
	* Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestAttachmentId the primary key of the current request attachment
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public static RequestAttachment[] findByGetRequestAttachments_PrevAndNext(
		long requestAttachmentId, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByGetRequestAttachments_PrevAndNext(requestAttachmentId,
			requestId, orderByComparator);
	}

	/**
	* Removes all the request attachments where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	*/
	public static void removeByGetRequestAttachments(long requestId) {
		getPersistence().removeByGetRequestAttachments(requestId);
	}

	/**
	* Returns the number of request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching request attachments
	*/
	public static int countByGetRequestAttachments(long requestId) {
		return getPersistence().countByGetRequestAttachments(requestId);
	}

	/**
	* Returns the request attachment where fileEntryId = &#63; or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	*
	* @param fileEntryId the file entry ID
	* @return the matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public static RequestAttachment findByGetRequestAttachmentByFileEntryId(
		long fileEntryId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByGetRequestAttachmentByFileEntryId(fileEntryId);
	}

	/**
	* Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId) {
		return getPersistence()
				   .fetchByGetRequestAttachmentByFileEntryId(fileEntryId);
	}

	/**
	* Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByGetRequestAttachmentByFileEntryId(fileEntryId,
			retrieveFromCache);
	}

	/**
	* Removes the request attachment where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @return the request attachment that was removed
	*/
	public static RequestAttachment removeByGetRequestAttachmentByFileEntryId(
		long fileEntryId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .removeByGetRequestAttachmentByFileEntryId(fileEntryId);
	}

	/**
	* Returns the number of request attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching request attachments
	*/
	public static int countByGetRequestAttachmentByFileEntryId(long fileEntryId) {
		return getPersistence()
				   .countByGetRequestAttachmentByFileEntryId(fileEntryId);
	}

	/**
	* Returns all the request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the matching request attachments
	*/
	public static List<RequestAttachment> findByfileEntryId(long requestId) {
		return getPersistence().findByfileEntryId(requestId);
	}

	/**
	* Returns a range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @return the range of matching request attachments
	*/
	public static List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end) {
		return getPersistence().findByfileEntryId(requestId, start, end);
	}

	/**
	* Returns an ordered range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching request attachments
	*/
	public static List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .findByfileEntryId(requestId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the request attachments where requestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestId the request ID
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching request attachments
	*/
	public static List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByfileEntryId(requestId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public static RequestAttachment findByfileEntryId_First(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByfileEntryId_First(requestId, orderByComparator);
	}

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByfileEntryId_First(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .fetchByfileEntryId_First(requestId, orderByComparator);
	}

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public static RequestAttachment findByfileEntryId_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByfileEntryId_Last(requestId, orderByComparator);
	}

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public static RequestAttachment fetchByfileEntryId_Last(long requestId,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence()
				   .fetchByfileEntryId_Last(requestId, orderByComparator);
	}

	/**
	* Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestAttachmentId the primary key of the current request attachment
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public static RequestAttachment[] findByfileEntryId_PrevAndNext(
		long requestAttachmentId, long requestId,
		OrderByComparator<RequestAttachment> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence()
				   .findByfileEntryId_PrevAndNext(requestAttachmentId,
			requestId, orderByComparator);
	}

	/**
	* Removes all the request attachments where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	*/
	public static void removeByfileEntryId(long requestId) {
		getPersistence().removeByfileEntryId(requestId);
	}

	/**
	* Returns the number of request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching request attachments
	*/
	public static int countByfileEntryId(long requestId) {
		return getPersistence().countByfileEntryId(requestId);
	}

	/**
	* Caches the request attachment in the entity cache if it is enabled.
	*
	* @param requestAttachment the request attachment
	*/
	public static void cacheResult(RequestAttachment requestAttachment) {
		getPersistence().cacheResult(requestAttachment);
	}

	/**
	* Caches the request attachments in the entity cache if it is enabled.
	*
	* @param requestAttachments the request attachments
	*/
	public static void cacheResult(List<RequestAttachment> requestAttachments) {
		getPersistence().cacheResult(requestAttachments);
	}

	/**
	* Creates a new request attachment with the primary key. Does not add the request attachment to the database.
	*
	* @param requestAttachmentId the primary key for the new request attachment
	* @return the new request attachment
	*/
	public static RequestAttachment create(long requestAttachmentId) {
		return getPersistence().create(requestAttachmentId);
	}

	/**
	* Removes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment that was removed
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public static RequestAttachment remove(long requestAttachmentId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence().remove(requestAttachmentId);
	}

	public static RequestAttachment updateImpl(
		RequestAttachment requestAttachment) {
		return getPersistence().updateImpl(requestAttachment);
	}

	/**
	* Returns the request attachment with the primary key or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public static RequestAttachment findByPrimaryKey(long requestAttachmentId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException {
		return getPersistence().findByPrimaryKey(requestAttachmentId);
	}

	/**
	* Returns the request attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment, or <code>null</code> if a request attachment with the primary key could not be found
	*/
	public static RequestAttachment fetchByPrimaryKey(long requestAttachmentId) {
		return getPersistence().fetchByPrimaryKey(requestAttachmentId);
	}

	public static java.util.Map<java.io.Serializable, RequestAttachment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the request attachments.
	*
	* @return the request attachments
	*/
	public static List<RequestAttachment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the request attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @return the range of request attachments
	*/
	public static List<RequestAttachment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the request attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of request attachments
	*/
	public static List<RequestAttachment> findAll(int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the request attachments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RequestAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of request attachments
	* @param end the upper bound of the range of request attachments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of request attachments
	*/
	public static List<RequestAttachment> findAll(int start, int end,
		OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the request attachments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of request attachments.
	*
	* @return the number of request attachments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RequestAttachmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RequestAttachmentPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					RequestAttachmentPersistence.class.getName());

			ReferenceRegistry.registerReference(RequestAttachmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static RequestAttachmentPersistence _persistence;
}