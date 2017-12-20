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

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException;
import com.dsi.intranet.eprocurement.model.WorkflowReview;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the workflow review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author CIGNEX Technologies
 * @see com.dsi.intranet.eprocurement.service.persistence.impl.WorkflowReviewPersistenceImpl
 * @see WorkflowReviewUtil
 * @generated
 */
@ProviderType
public interface WorkflowReviewPersistence extends BasePersistence<WorkflowReview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowReviewUtil} to access the workflow review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching workflow reviews
	*/
	public java.util.List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK);

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
	public java.util.List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end);

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
	public java.util.List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator);

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
	public java.util.List<WorkflowReview> findByClassNameAndClassPK(
		long companyId, long groupId, long classNameId, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator,
		boolean retrieveFromCache);

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
	public WorkflowReview findByClassNameAndClassPK_First(long companyId,
		long groupId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException;

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
	public WorkflowReview fetchByClassNameAndClassPK_First(long companyId,
		long groupId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator);

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
	public WorkflowReview findByClassNameAndClassPK_Last(long companyId,
		long groupId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException;

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
	public WorkflowReview fetchByClassNameAndClassPK_Last(long companyId,
		long groupId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator);

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
	public WorkflowReview[] findByClassNameAndClassPK_PrevAndNext(
		long workflowReviewId, long companyId, long groupId, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator)
		throws NoSuchWorkflowReviewException;

	/**
	* Removes all the workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	*/
	public void removeByClassNameAndClassPK(long companyId, long groupId,
		long classNameId, long classPK);

	/**
	* Returns the number of workflow reviews where companyId = &#63; and groupId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching workflow reviews
	*/
	public int countByClassNameAndClassPK(long companyId, long groupId,
		long classNameId, long classPK);

	/**
	* Caches the workflow review in the entity cache if it is enabled.
	*
	* @param workflowReview the workflow review
	*/
	public void cacheResult(WorkflowReview workflowReview);

	/**
	* Caches the workflow reviews in the entity cache if it is enabled.
	*
	* @param workflowReviews the workflow reviews
	*/
	public void cacheResult(java.util.List<WorkflowReview> workflowReviews);

	/**
	* Creates a new workflow review with the primary key. Does not add the workflow review to the database.
	*
	* @param workflowReviewId the primary key for the new workflow review
	* @return the new workflow review
	*/
	public WorkflowReview create(long workflowReviewId);

	/**
	* Removes the workflow review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review that was removed
	* @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	*/
	public WorkflowReview remove(long workflowReviewId)
		throws NoSuchWorkflowReviewException;

	public WorkflowReview updateImpl(WorkflowReview workflowReview);

	/**
	* Returns the workflow review with the primary key or throws a {@link NoSuchWorkflowReviewException} if it could not be found.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review
	* @throws NoSuchWorkflowReviewException if a workflow review with the primary key could not be found
	*/
	public WorkflowReview findByPrimaryKey(long workflowReviewId)
		throws NoSuchWorkflowReviewException;

	/**
	* Returns the workflow review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowReviewId the primary key of the workflow review
	* @return the workflow review, or <code>null</code> if a workflow review with the primary key could not be found
	*/
	public WorkflowReview fetchByPrimaryKey(long workflowReviewId);

	@Override
	public java.util.Map<java.io.Serializable, WorkflowReview> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the workflow reviews.
	*
	* @return the workflow reviews
	*/
	public java.util.List<WorkflowReview> findAll();

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
	public java.util.List<WorkflowReview> findAll(int start, int end);

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
	public java.util.List<WorkflowReview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator);

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
	public java.util.List<WorkflowReview> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkflowReview> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the workflow reviews from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of workflow reviews.
	*
	* @return the number of workflow reviews
	*/
	public int countAll();
}