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

import com.dsi.intranet.eprocurement.model.WorkflowReview;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the workflow review service. This utility wraps {@link com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowReviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowReviewPersistence
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowReviewPersistenceImpl
 * @generated
 */
@ProviderType
public class WorkflowReviewUtil {
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
	public static void clearCache(WorkflowReview workflowReview) {
		getPersistence().clearCache(workflowReview);
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
	public static List<WorkflowReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkflowReview update(WorkflowReview workflowReview) {
		return getPersistence().update(workflowReview);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkflowReview update(WorkflowReview workflowReview,
		ServiceContext serviceContext) {
		return getPersistence().update(workflowReview, serviceContext);
	}

	/**
	* Returns all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching workflow reviews
	*/
	public static List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK) {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK);
	}

	/**
	* Returns a range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @return the range of matching workflow reviews
	*/
	public static List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end) {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, start, end);
	}

	/**
	* Returns an ordered range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow reviews
	*/
	public static List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end, OrderByComparator<WorkflowReview> orderByComparator) {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching workflow reviews
	*/
	public static List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow review
	* @throws NoSuchWorkflowReviewException if a matching workflow review could not be found
	*/
	public static WorkflowReview findByClassNameAndClassPK_First(
		long companyId, long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException {
		return getPersistence()
				   .findByClassNameAndClassPK_First(companyId, groupId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the first workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow review, or <code>null</code> if a matching workflow review could not be found
	*/
	public static WorkflowReview fetchByClassNameAndClassPK_First(
		long companyId, long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return getPersistence()
				   .fetchByClassNameAndClassPK_First(companyId, groupId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the last workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow review
	* @throws NoSuchWorkflowReviewException if a matching workflow review could not be found
	*/
	public static WorkflowReview findByClassNameAndClassPK_Last(
		long companyId, long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException {
		return getPersistence()
				   .findByClassNameAndClassPK_Last(companyId, groupId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the last workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow review, or <code>null</code> if a matching workflow review could not be found
	*/
	public static WorkflowReview fetchByClassNameAndClassPK_Last(
		long companyId, long groupId, long classNameId, long classPK,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return getPersistence()
				   .fetchByClassNameAndClassPK_Last(companyId, groupId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Returns the workflow reviews before and after the current workflow review in the ordered set where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param workflowReviewId the primary key of the current workflow review
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow review
	* @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	*/
	public static WorkflowReview[] findByClassNameAndClassPK_PrevAndNext(
		long workflowReviewId, long companyId, long groupId, long classNameId,
		long classPK, OrderByComparator<WorkflowReview> orderByComparator)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException {
		return getPersistence()
				   .findByClassNameAndClassPK_PrevAndNext(workflowReviewId,
			companyId, groupId, classNameId, classPK, orderByComparator);
	}

	/**
	* Removes all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	*/
	public static void removeByClassNameAndClassPK(long companyId,
		long groupId, long classNameId, long classPK) {
		getPersistence()
			.removeByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK);
	}

	/**
	* Returns the number of workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching workflow reviews
	*/
	public static int countByClassNameAndClassPK(long companyId, long groupId,
		long classNameId, long classPK) {
		return getPersistence()
				   .countByClassNameAndClassPK(companyId, groupId, classNameId,
			classPK);
	}

	/**
	* Caches the workflow review in the entity cache if it is enabled.
	*
	* @param workflowReview the workflow review
	*/
	public static void cacheResult(WorkflowReview workflowReview) {
		getPersistence().cacheResult(workflowReview);
	}

	/**
	* Caches the workflow reviews in the entity cache if it is enabled.
	*
	* @param workflowReviews the workflow reviews
	*/
	public static void cacheResult(List<WorkflowReview> workflowReviews) {
		getPersistence().cacheResult(workflowReviews);
	}

	/**
	* Creates a new workflow review with the primary key. Does not add the workflow review to the database.
	*
	* @param workflowReviewId the primary key for the new workflow review
	* @return the new workflow review
	*/
	public static WorkflowReview create(long workflowReviewId) {
		return getPersistence().create(workflowReviewId);
	}

	/**
	* Removes the workflow review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review that was removed
	* @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	*/
	public static WorkflowReview remove(long workflowReviewId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException {
		return getPersistence().remove(workflowReviewId);
	}

	public static WorkflowReview updateImpl(WorkflowReview workflowReview) {
		return getPersistence().updateImpl(workflowReview);
	}

	/**
	* Returns the workflow review with the primary key or throws a {@link NoSuchWorkflowReviewException} if it could not be found.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review
	* @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	*/
	public static WorkflowReview findByPrimaryKey(long workflowReviewId)
		throws com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException {
		return getPersistence().findByPrimaryKey(workflowReviewId);
	}

	/**
	* Returns the workflow review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review, or <code>null</code> if a workflow review with the primary key could not be found
	*/
	public static WorkflowReview fetchByPrimaryKey(long workflowReviewId) {
		return getPersistence().fetchByPrimaryKey(workflowReviewId);
	}

	public static java.util.Map<java.io.Serializable, WorkflowReview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the workflow reviews.
	*
	* @return the workflow reviews
	*/
	public static List<WorkflowReview> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the workflow reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @return the range of workflow reviews
	*/
	public static List<WorkflowReview> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the workflow reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow reviews
	*/
	public static List<WorkflowReview> findAll(int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the workflow reviews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkflowReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow reviews
	* @param end the upper bound of the range of workflow reviews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of workflow reviews
	*/
	public static List<WorkflowReview> findAll(int start, int end,
		OrderByComparator<WorkflowReview> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the workflow reviews from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflow reviews.
	*
	* @return the number of workflow reviews
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkflowReviewPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowReviewPersistence)PortletBeanLocatorUtil.locate(com.dsi.intranet.eprocurement.service.ClpSerializer.getServletContextName(),
					WorkflowReviewPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowReviewUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static WorkflowReviewPersistence _persistence;
}