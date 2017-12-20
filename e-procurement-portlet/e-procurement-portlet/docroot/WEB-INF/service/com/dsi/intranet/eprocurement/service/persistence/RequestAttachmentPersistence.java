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

import com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException;
import com.dsi.intranet.eprocurement.model.RequestAttachment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the request attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.RequestAttachmentPersistenceImpl
 * @see RequestAttachmentUtil
 * @generated
 */
@ProviderType
public interface RequestAttachmentPersistence extends BasePersistence<RequestAttachment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RequestAttachmentUtil} to access the request attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the matching request attachments
	*/
	public java.util.List<RequestAttachment> findByGetRequestAttachments(
		long requestId);

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
	public java.util.List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end);

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
	public java.util.List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

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
	public java.util.List<RequestAttachment> findByGetRequestAttachments(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public RequestAttachment findByGetRequestAttachments_First(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByGetRequestAttachments_First(
		long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public RequestAttachment findByGetRequestAttachments_Last(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByGetRequestAttachments_Last(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

	/**
	* Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestAttachmentId the primary key of the current request attachment
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public RequestAttachment[] findByGetRequestAttachments_PrevAndNext(
		long requestAttachmentId, long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Removes all the request attachments where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	*/
	public void removeByGetRequestAttachments(long requestId);

	/**
	* Returns the number of request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching request attachments
	*/
	public int countByGetRequestAttachments(long requestId);

	/**
	* Returns the request attachment where fileEntryId = &#63; or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	*
	* @param fileEntryId the file entry ID
	* @return the matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public RequestAttachment findByGetRequestAttachmentByFileEntryId(
		long fileEntryId) throws NoSuchRequestAttachmentException;

	/**
	* Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId);

	/**
	* Returns the request attachment where fileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fileEntryId the file entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByGetRequestAttachmentByFileEntryId(
		long fileEntryId, boolean retrieveFromCache);

	/**
	* Removes the request attachment where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @return the request attachment that was removed
	*/
	public RequestAttachment removeByGetRequestAttachmentByFileEntryId(
		long fileEntryId) throws NoSuchRequestAttachmentException;

	/**
	* Returns the number of request attachments where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching request attachments
	*/
	public int countByGetRequestAttachmentByFileEntryId(long fileEntryId);

	/**
	* Returns all the request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the matching request attachments
	*/
	public java.util.List<RequestAttachment> findByfileEntryId(long requestId);

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
	public java.util.List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end);

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
	public java.util.List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

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
	public java.util.List<RequestAttachment> findByfileEntryId(long requestId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public RequestAttachment findByfileEntryId_First(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Returns the first request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByfileEntryId_First(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment
	* @throws NoSuchRequestAttachmentException if a matching request attachment could not be found
	*/
	public RequestAttachment findByfileEntryId_Last(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Returns the last request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching request attachment, or <code>null</code> if a matching request attachment could not be found
	*/
	public RequestAttachment fetchByfileEntryId_Last(long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

	/**
	* Returns the request attachments before and after the current request attachment in the ordered set where requestId = &#63;.
	*
	* @param requestAttachmentId the primary key of the current request attachment
	* @param requestId the request ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public RequestAttachment[] findByfileEntryId_PrevAndNext(
		long requestAttachmentId, long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator)
		throws NoSuchRequestAttachmentException;

	/**
	* Removes all the request attachments where requestId = &#63; from the database.
	*
	* @param requestId the request ID
	*/
	public void removeByfileEntryId(long requestId);

	/**
	* Returns the number of request attachments where requestId = &#63;.
	*
	* @param requestId the request ID
	* @return the number of matching request attachments
	*/
	public int countByfileEntryId(long requestId);

	/**
	* Caches the request attachment in the entity cache if it is enabled.
	*
	* @param requestAttachment the request attachment
	*/
	public void cacheResult(RequestAttachment requestAttachment);

	/**
	* Caches the request attachments in the entity cache if it is enabled.
	*
	* @param requestAttachments the request attachments
	*/
	public void cacheResult(
		java.util.List<RequestAttachment> requestAttachments);

	/**
	* Creates a new request attachment with the primary key. Does not add the request attachment to the database.
	*
	* @param requestAttachmentId the primary key for the new request attachment
	* @return the new request attachment
	*/
	public RequestAttachment create(long requestAttachmentId);

	/**
	* Removes the request attachment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment that was removed
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public RequestAttachment remove(long requestAttachmentId)
		throws NoSuchRequestAttachmentException;

	public RequestAttachment updateImpl(RequestAttachment requestAttachment);

	/**
	* Returns the request attachment with the primary key or throws a {@link NoSuchRequestAttachmentException} if it could not be found.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment
	* @throws NoSuchRequestAttachmentException if a request attachment with the primary key could not be found
	*/
	public RequestAttachment findByPrimaryKey(long requestAttachmentId)
		throws NoSuchRequestAttachmentException;

	/**
	* Returns the request attachment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestAttachmentId the primary key of the request attachment
	* @return the request attachment, or <code>null</code> if a request attachment with the primary key could not be found
	*/
	public RequestAttachment fetchByPrimaryKey(long requestAttachmentId);

	@Override
	public java.util.Map<java.io.Serializable, RequestAttachment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the request attachments.
	*
	* @return the request attachments
	*/
	public java.util.List<RequestAttachment> findAll();

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
	public java.util.List<RequestAttachment> findAll(int start, int end);

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
	public java.util.List<RequestAttachment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator);

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
	public java.util.List<RequestAttachment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RequestAttachment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the request attachments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of request attachments.
	*
	* @return the number of request attachments
	*/
	public int countAll();
}