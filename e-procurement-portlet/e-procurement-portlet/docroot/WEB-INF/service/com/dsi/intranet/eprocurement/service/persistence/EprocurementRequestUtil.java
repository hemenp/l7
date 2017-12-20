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

import com.dsi.intranet.eprocurement.model.EprocurementRequest;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the eprocurement request service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see EprocurementRequestPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.EprocurementRequestPersistenceImpl
 * @generated
 */
@ProviderType
public class EprocurementRequestUtil {
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
	public static void clearCache(EprocurementRequest eprocurementRequest) {
		getPersistence().clearCache(eprocurementRequest);
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
	public static List<EprocurementRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EprocurementRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EprocurementRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EprocurementRequest update(
		EprocurementRequest eprocurementRequest) {
		return getPersistence().update(eprocurementRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EprocurementRequest update(
		EprocurementRequest eprocurementRequest, ServiceContext serviceContext) {
		return getPersistence().update(eprocurementRequest, serviceContext);
	}

	/**
	* Returns all the eprocurement requests where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @return the matching eprocurement requests
	*/
	public static List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate) {
		return getPersistence().findByModifiedDate(modifiedDate);
	}

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
	public static List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end) {
		return getPersistence().findByModifiedDate(modifiedDate, start, end);
	}

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
	public static List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .findByModifiedDate(modifiedDate, start, end,
			orderByComparator);
	}

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
	public static List<EprocurementRequest> findByModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByModifiedDate(modifiedDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest findByModifiedDate_First(
		Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByModifiedDate_First(modifiedDate, orderByComparator);
	}

	/**
	* Returns the first eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByModifiedDate_First(
		Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByModifiedDate_First(modifiedDate, orderByComparator);
	}

	/**
	* Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest findByModifiedDate_Last(
		Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByModifiedDate_Last(modifiedDate, orderByComparator);
	}

	/**
	* Returns the last eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByModifiedDate_Last(
		Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByModifiedDate_Last(modifiedDate, orderByComparator);
	}

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where modifiedDate = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public static EprocurementRequest[] findByModifiedDate_PrevAndNext(
		long requestId, Date modifiedDate,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByModifiedDate_PrevAndNext(requestId, modifiedDate,
			orderByComparator);
	}

	/**
	* Removes all the eprocurement requests where modifiedDate = &#63; from the database.
	*
	* @param modifiedDate the modified date
	*/
	public static void removeByModifiedDate(Date modifiedDate) {
		getPersistence().removeByModifiedDate(modifiedDate);
	}

	/**
	* Returns the number of eprocurement requests where modifiedDate = &#63;.
	*
	* @param modifiedDate the modified date
	* @return the number of matching eprocurement requests
	*/
	public static int countByModifiedDate(Date modifiedDate) {
		return getPersistence().countByModifiedDate(modifiedDate);
	}

	/**
	* Returns all the eprocurement requests where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @return the matching eprocurement requests
	*/
	public static List<EprocurementRequest> findByRequestorName(
		long requestorId) {
		return getPersistence().findByRequestorName(requestorId);
	}

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
	public static List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end) {
		return getPersistence().findByRequestorName(requestorId, start, end);
	}

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
	public static List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .findByRequestorName(requestorId, start, end,
			orderByComparator);
	}

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
	public static List<EprocurementRequest> findByRequestorName(
		long requestorId, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRequestorName(requestorId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest findByRequestorName_First(
		long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByRequestorName_First(requestorId, orderByComparator);
	}

	/**
	* Returns the first eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByRequestorName_First(
		long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByRequestorName_First(requestorId, orderByComparator);
	}

	/**
	* Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest findByRequestorName_Last(
		long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByRequestorName_Last(requestorId, orderByComparator);
	}

	/**
	* Returns the last eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByRequestorName_Last(
		long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByRequestorName_Last(requestorId, orderByComparator);
	}

	/**
	* Returns the eprocurement requests before and after the current eprocurement request in the ordered set where requestorId = &#63;.
	*
	* @param requestId the primary key of the current eprocurement request
	* @param requestorId the requestor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public static EprocurementRequest[] findByRequestorName_PrevAndNext(
		long requestId, long requestorId,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByRequestorName_PrevAndNext(requestId, requestorId,
			orderByComparator);
	}

	/**
	* Removes all the eprocurement requests where requestorId = &#63; from the database.
	*
	* @param requestorId the requestor ID
	*/
	public static void removeByRequestorName(long requestorId) {
		getPersistence().removeByRequestorName(requestorId);
	}

	/**
	* Returns the number of eprocurement requests where requestorId = &#63;.
	*
	* @param requestorId the requestor ID
	* @return the number of matching eprocurement requests
	*/
	public static int countByRequestorName(long requestorId) {
		return getPersistence().countByRequestorName(requestorId);
	}

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or throws a {@link NoSuchRequestException} if it could not be found.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the matching eprocurement request
	* @throws NoSuchRequestException if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest findByeprocurementrequest(
		Date modifiedDate, long requestorId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByeprocurementrequest(modifiedDate, requestorId);
	}

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByeprocurementrequest(
		Date modifiedDate, long requestorId) {
		return getPersistence()
				   .fetchByeprocurementrequest(modifiedDate, requestorId);
	}

	/**
	* Returns the eprocurement request where modifiedDate = &#63; and requestorId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByeprocurementrequest(
		Date modifiedDate, long requestorId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByeprocurementrequest(modifiedDate, requestorId,
			retrieveFromCache);
	}

	/**
	* Removes the eprocurement request where modifiedDate = &#63; and requestorId = &#63; from the database.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the eprocurement request that was removed
	*/
	public static EprocurementRequest removeByeprocurementrequest(
		Date modifiedDate, long requestorId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .removeByeprocurementrequest(modifiedDate, requestorId);
	}

	/**
	* Returns the number of eprocurement requests where modifiedDate = &#63; and requestorId = &#63;.
	*
	* @param modifiedDate the modified date
	* @param requestorId the requestor ID
	* @return the number of matching eprocurement requests
	*/
	public static int countByeprocurementrequest(Date modifiedDate,
		long requestorId) {
		return getPersistence()
				   .countByeprocurementrequest(modifiedDate, requestorId);
	}

	/**
	* Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching eprocurement requests
	*/
	public static List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status) {
		return getPersistence().findByStatus(companyId, groupId, status);
	}

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
	public static List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end) {
		return getPersistence()
				   .findByStatus(companyId, groupId, status, start, end);
	}

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
	public static List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .findByStatus(companyId, groupId, status, start, end,
			orderByComparator);
	}

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
	public static List<EprocurementRequest> findByStatus(long companyId,
		long groupId, java.lang.String status, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus(companyId, groupId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

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
	public static EprocurementRequest findByStatus_First(long companyId,
		long groupId, java.lang.String status,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatus_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByStatus_First(long companyId,
		long groupId, java.lang.String status,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_First(companyId, groupId, status,
			orderByComparator);
	}

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
	public static EprocurementRequest findByStatus_Last(long companyId,
		long groupId, java.lang.String status,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatus_Last(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last eprocurement request in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching eprocurement request, or <code>null</code> if a matching eprocurement request could not be found
	*/
	public static EprocurementRequest fetchByStatus_Last(long companyId,
		long groupId, java.lang.String status,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_Last(companyId, groupId, status,
			orderByComparator);
	}

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
	public static EprocurementRequest[] findByStatus_PrevAndNext(
		long requestId, long companyId, long groupId, java.lang.String status,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatus_PrevAndNext(requestId, companyId, groupId,
			status, orderByComparator);
	}

	/**
	* Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeByStatus(long companyId, long groupId,
		java.lang.String status) {
		getPersistence().removeByStatus(companyId, groupId, status);
	}

	/**
	* Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching eprocurement requests
	*/
	public static int countByStatus(long companyId, long groupId,
		java.lang.String status) {
		return getPersistence().countByStatus(companyId, groupId, status);
	}

	/**
	* Returns all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @return the matching eprocurement requests
	*/
	public static List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city) {
		return getPersistence()
				   .findByStatusAddress(companyId, groupId, status, city);
	}

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
	public static List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end) {
		return getPersistence()
				   .findByStatusAddress(companyId, groupId, status, city,
			start, end);
	}

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
	public static List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .findByStatusAddress(companyId, groupId, status, city,
			start, end, orderByComparator);
	}

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
	public static List<EprocurementRequest> findByStatusAddress(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city, int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatusAddress(companyId, groupId, status, city,
			start, end, orderByComparator, retrieveFromCache);
	}

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
	public static EprocurementRequest findByStatusAddress_First(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatusAddress_First(companyId, groupId, status, city,
			orderByComparator);
	}

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
	public static EprocurementRequest fetchByStatusAddress_First(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByStatusAddress_First(companyId, groupId, status,
			city, orderByComparator);
	}

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
	public static EprocurementRequest findByStatusAddress_Last(long companyId,
		long groupId, java.lang.String status, java.lang.String city,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatusAddress_Last(companyId, groupId, status, city,
			orderByComparator);
	}

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
	public static EprocurementRequest fetchByStatusAddress_Last(
		long companyId, long groupId, java.lang.String status,
		java.lang.String city,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence()
				   .fetchByStatusAddress_Last(companyId, groupId, status, city,
			orderByComparator);
	}

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
	public static EprocurementRequest[] findByStatusAddress_PrevAndNext(
		long requestId, long companyId, long groupId, java.lang.String status,
		java.lang.String city,
		OrderByComparator<EprocurementRequest> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence()
				   .findByStatusAddress_PrevAndNext(requestId, companyId,
			groupId, status, city, orderByComparator);
	}

	/**
	* Removes all the eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	*/
	public static void removeByStatusAddress(long companyId, long groupId,
		java.lang.String status, java.lang.String city) {
		getPersistence().removeByStatusAddress(companyId, groupId, status, city);
	}

	/**
	* Returns the number of eprocurement requests where companyId = &#63; and groupId = &#63; and status = &#63; and city = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param city the city
	* @return the number of matching eprocurement requests
	*/
	public static int countByStatusAddress(long companyId, long groupId,
		java.lang.String status, java.lang.String city) {
		return getPersistence()
				   .countByStatusAddress(companyId, groupId, status, city);
	}

	/**
	* Caches the eprocurement request in the entity cache if it is enabled.
	*
	* @param eprocurementRequest the eprocurement request
	*/
	public static void cacheResult(EprocurementRequest eprocurementRequest) {
		getPersistence().cacheResult(eprocurementRequest);
	}

	/**
	* Caches the eprocurement requests in the entity cache if it is enabled.
	*
	* @param eprocurementRequests the eprocurement requests
	*/
	public static void cacheResult(
		List<EprocurementRequest> eprocurementRequests) {
		getPersistence().cacheResult(eprocurementRequests);
	}

	/**
	* Creates a new eprocurement request with the primary key. Does not add the eprocurement request to the database.
	*
	* @param requestId the primary key for the new eprocurement request
	* @return the new eprocurement request
	*/
	public static EprocurementRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	* Removes the eprocurement request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request that was removed
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public static EprocurementRequest remove(long requestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence().remove(requestId);
	}

	public static EprocurementRequest updateImpl(
		EprocurementRequest eprocurementRequest) {
		return getPersistence().updateImpl(eprocurementRequest);
	}

	/**
	* Returns the eprocurement request with the primary key or throws a {@link NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request
	* @throws NoSuchRequestException if a eprocurement request with the primary key could not be found
	*/
	public static EprocurementRequest findByPrimaryKey(long requestId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchRequestException {
		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	* Returns the eprocurement request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the eprocurement request
	* @return the eprocurement request, or <code>null</code> if a eprocurement request with the primary key could not be found
	*/
	public static EprocurementRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	public static java.util.Map<java.io.Serializable, EprocurementRequest> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the eprocurement requests.
	*
	* @return the eprocurement requests
	*/
	public static List<EprocurementRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EprocurementRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EprocurementRequest> findAll(int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EprocurementRequest> findAll(int start, int end,
		OrderByComparator<EprocurementRequest> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the eprocurement requests from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eprocurement requests.
	*
	* @return the number of eprocurement requests
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EprocurementRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EprocurementRequestPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					EprocurementRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(EprocurementRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static EprocurementRequestPersistence _persistence;
}