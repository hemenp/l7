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

import com.dsi.intranet.eprocurement.exception.NoSuchRequestException;
import com.dsi.intranet.eprocurement.model.EprocurementRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the eprocurement request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementRequestPersistenceImpl
 * @see EprocurementRequestUtil
 * @generated
 */
@ProviderType
public interface EprocurementRequestPersistence extends BasePersistence<EprocurementRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EprocurementRequestUtil} to access the eprocurement request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the eprocurement requests where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @return the matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate);

	/**
	* Returns a range of all the eprocurement requests where modifiedDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end);

	/**
	* Returns an ordered range of all the eprocurement requests where modifiedDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns an ordered range of all the eprocurement requests where modifiedDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByModifiedDate_First(Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByModifiedDate_First(Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByModifiedDate_Last(Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByModifiedDate_Last(Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest[] findByModifiedDate_PrevAndNext(
		long requestId, Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Removes all the eprocurement requests where modifiedDate = &#63; from the database.
	*
	* @param modifiedDate the modified date
	*/
	public void removeByModifiedDate(Date modifiedDate);

	/**
	* Returns the number of eprocurement requests where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @return the number of matching eprocurement requests
	*/
	public int countByModifiedDate(Date modifiedDate);

	/**
	* Returns all the eprocurement requests where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @return the matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByRequestorName(
		long requestorId);

	/**
	* Returns a range of all the eprocurement requests where requestorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestorId the requestor ID
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end);

	/**
	* Returns an ordered range of all the eprocurement requests where requestorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestorId the requestor ID
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns an ordered range of all the eprocurement requests where requestorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param requestorId the requestor ID
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByRequestorName_First(long requestorId,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByRequestorName_First(long requestorId,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByRequestorName_Last(long requestorId,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByRequestorName_Last(long requestorId,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest[] findByRequestorName_PrevAndNext(
		long requestId, long requestorId,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Removes all the eprocurement requests where requestorId = &#63; from the database.
	*
	* @param requestorId the requestor ID
	*/
	public void removeByRequestorName(long requestorId);

	/**
	* Returns the number of eprocurement requests where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @return the number of matching eprocurement requests
	*/
	public int countByRequestorName(long requestorId);

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or throws a {@link NoSuchRequestException} if it could not be found.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByeprocurementrequest(Date modifiedDate,
		long requestorId) throws NoSuchRequestException;

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByeprocurementrequest(Date modifiedDate,
		long requestorId);

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByeprocurementrequest(Date modifiedDate,
		long requestorId, boolean retrieveFromCache);

	/**
	* Removes the eprocurement request where modifiedDate = &#63; and requestorId = &#63; from the database.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the eprocurement request that was removed
	*/
	public EprocurementRequest removeByeprocurementrequest(Date modifiedDate,
		long requestorId) throws NoSuchRequestException;

	/**
	* Returns the number of eprocurement requests where modifiedDate = &#63; and requestorId = &#63;.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the number of matching eprocurement requests
	*/
	public int countByeprocurementrequest(Date modifiedDate, long requestorId);

	/**
	* Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status);

	/**
	* Returns a range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end);

	/**
	* Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByStatus_First(long companyId, long groupId,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByStatus_First(long companyId,
		long groupId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByStatus_Last(long companyId, long groupId,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByStatus_Last(long companyId, long groupId,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest[] findByStatus_PrevAndNext(long requestId,
		long companyId, long groupId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByStatus(long companyId, long groupId,
		java.lang.String status);

	/**
	* Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching eprocurement requests
	*/
	public int countByStatus(long companyId, long groupId,
		java.lang.String status);

	/**
	* Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @return the matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city);

	/**
	* Returns a range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end);

	/**
	* Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns an ordered range of all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByStatusAddress_First(long companyId,
		long groupId, java.lang.String status, java.lang.String city,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByStatusAddress_First(long companyId,
		long groupId, java.lang.String status, java.lang.String city,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public EprocurementRequest findByStatusAddress_Last(long companyId,
		long groupId, java.lang.String status, java.lang.String city,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public EprocurementRequest fetchByStatusAddress_Last(long companyId,
		long groupId, java.lang.String status, java.lang.String city,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest[] findByStatusAddress_PrevAndNext(
		long requestId, long companyId, long groupId, java.lang.String status,
		java.lang.String city,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator)
		throws NoSuchRequestException;

	/**
	* Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	*/
	public void removeByStatusAddress(long companyId, long groupId,
		java.lang.String status, java.lang.String city);

	/**
	* Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @return the number of matching eprocurement requests
	*/
	public int countByStatusAddress(long companyId, long groupId,
		java.lang.String status, java.lang.String city);

	/**
	* Caches the eprocurement request in the entity cache if it is enabled.
	*
	* @param eprocurementRequest the eprocurement request
	*/
	public void cacheResult(EprocurementRequest eprocurementRequest);

	/**
	* Caches the eprocurement requests in the entity cache if it is enabled.
	*
	* @param eprocurementRequests the eprocurement requests
	*/
	public void cacheResult(
		java.util.List<EprocurementRequest> eprocurementRequests);

	/**
	* Creates a new eprocurement request with the primary key. Does not add the eprocurement request to the database.
	*
	* @param requestId the primary key for the new eprocurement request
	* @return the new eprocurement request
	*/
	public EprocurementRequest create(long requestId);

	/**
	* Removes the eprocurement request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request that was removed
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest remove(long requestId)
		throws NoSuchRequestException;

	public EprocurementRequest updateImpl(
		EprocurementRequest eprocurementRequest);

	/**
	* Returns the eprocurement request with the primary key or throws a {@link NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest findByPrimaryKey(long requestId)
		throws NoSuchRequestException;

	/**
	* Returns the eprocurement request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request, or <code>null</code> if a eprocurement request with the primary key could not be found
	*/
	public EprocurementRequest fetchByPrimaryKey(long requestId);

	@Override
	public java.util.Map<java.io.Serializable, EprocurementRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the eprocurement requests.
	*
	* @return the eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findAll();

	/**
	* Returns a range of all the eprocurement requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @return the range of eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findAll(int start, int end);

	/**
	* Returns an ordered range of all the eprocurement requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator);

	/**
	* Returns an ordered range of all the eprocurement requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EprocurementRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement requests
	* @param end the upper bound of the range of eprocurement requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of eprocurement requests
	*/
	public java.util.List<EprocurementRequest> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the eprocurement requests from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of eprocurement requests.
	*
	* @return the number of eprocurement requests
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}