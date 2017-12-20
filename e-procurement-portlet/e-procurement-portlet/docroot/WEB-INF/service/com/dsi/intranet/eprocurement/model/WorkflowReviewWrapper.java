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

package com.dsi.intranet.eprocurement.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WorkflowReview}.
 * </p>
 *
 * @author CIGNEX Technologies
 * @see WorkflowReview
 * @generated
 */
@ProviderType
public class WorkflowReviewWrapper implements WorkflowReview,
	ModelWrapper<WorkflowReview> {
	public WorkflowReviewWrapper(WorkflowReview workflowReview) {
		_workflowReview = workflowReview;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowReview.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowReview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowReviewId", getWorkflowReviewId());
		attributes.put("workflowRequestId", getWorkflowRequestId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedToStatus", getUpdatedToStatus());
		attributes.put("nextStage", getNextStage());
		attributes.put("isApproverRole", getIsApproverRole());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("approverComments", getApproverComments());
		attributes.put("emailComments", getEmailComments());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowReviewId = (Long)attributes.get("workflowReviewId");

		if (workflowReviewId != null) {
			setWorkflowReviewId(workflowReviewId);
		}

		Long workflowRequestId = (Long)attributes.get("workflowRequestId");

		if (workflowRequestId != null) {
			setWorkflowRequestId(workflowRequestId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		String updatedToStatus = (String)attributes.get("updatedToStatus");

		if (updatedToStatus != null) {
			setUpdatedToStatus(updatedToStatus);
		}

		String nextStage = (String)attributes.get("nextStage");

		if (nextStage != null) {
			setNextStage(nextStage);
		}

		String isApproverRole = (String)attributes.get("isApproverRole");

		if (isApproverRole != null) {
			setIsApproverRole(isApproverRole);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}

		String approverComments = (String)attributes.get("approverComments");

		if (approverComments != null) {
			setApproverComments(approverComments);
		}

		String emailComments = (String)attributes.get("emailComments");

		if (emailComments != null) {
			setEmailComments(emailComments);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public WorkflowReview toEscapedModel() {
		return new WorkflowReviewWrapper(_workflowReview.toEscapedModel());
	}

	@Override
	public WorkflowReview toUnescapedModel() {
		return new WorkflowReviewWrapper(_workflowReview.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _workflowReview.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workflowReview.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _workflowReview.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workflowReview.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkflowReview> toCacheModel() {
		return _workflowReview.toCacheModel();
	}

	@Override
	public int compareTo(WorkflowReview workflowReview) {
		return _workflowReview.compareTo(workflowReview);
	}

	@Override
	public int hashCode() {
		return _workflowReview.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowReview.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowReviewWrapper((WorkflowReview)_workflowReview.clone());
	}

	/**
	* Returns the approver comments of this workflow review.
	*
	* @return the approver comments of this workflow review
	*/
	@Override
	public java.lang.String getApproverComments() {
		return _workflowReview.getApproverComments();
	}

	/**
	* Returns the fully qualified class name of this workflow review.
	*
	* @return the fully qualified class name of this workflow review
	*/
	@Override
	public java.lang.String getClassName() {
		return _workflowReview.getClassName();
	}

	/**
	* Returns the email comments of this workflow review.
	*
	* @return the email comments of this workflow review
	*/
	@Override
	public java.lang.String getEmailComments() {
		return _workflowReview.getEmailComments();
	}

	/**
	* Returns the is approver role of this workflow review.
	*
	* @return the is approver role of this workflow review
	*/
	@Override
	public java.lang.String getIsApproverRole() {
		return _workflowReview.getIsApproverRole();
	}

	/**
	* Returns the next stage of this workflow review.
	*
	* @return the next stage of this workflow review
	*/
	@Override
	public java.lang.String getNextStage() {
		return _workflowReview.getNextStage();
	}

	/**
	* Returns the updated to status of this workflow review.
	*
	* @return the updated to status of this workflow review
	*/
	@Override
	public java.lang.String getUpdatedToStatus() {
		return _workflowReview.getUpdatedToStatus();
	}

	@Override
	public java.lang.String toString() {
		return _workflowReview.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflowReview.toXmlString();
	}

	/**
	* Returns the updated date of this workflow review.
	*
	* @return the updated date of this workflow review
	*/
	@Override
	public Date getUpdatedDate() {
		return _workflowReview.getUpdatedDate();
	}

	/**
	* Returns the class name ID of this workflow review.
	*
	* @return the class name ID of this workflow review
	*/
	@Override
	public long getClassNameId() {
		return _workflowReview.getClassNameId();
	}

	/**
	* Returns the class pk of this workflow review.
	*
	* @return the class pk of this workflow review
	*/
	@Override
	public long getClassPK() {
		return _workflowReview.getClassPK();
	}

	/**
	* Returns the company ID of this workflow review.
	*
	* @return the company ID of this workflow review
	*/
	@Override
	public long getCompanyId() {
		return _workflowReview.getCompanyId();
	}

	/**
	* Returns the group ID of this workflow review.
	*
	* @return the group ID of this workflow review
	*/
	@Override
	public long getGroupId() {
		return _workflowReview.getGroupId();
	}

	/**
	* Returns the primary key of this workflow review.
	*
	* @return the primary key of this workflow review
	*/
	@Override
	public long getPrimaryKey() {
		return _workflowReview.getPrimaryKey();
	}

	/**
	* Returns the updated by of this workflow review.
	*
	* @return the updated by of this workflow review
	*/
	@Override
	public long getUpdatedBy() {
		return _workflowReview.getUpdatedBy();
	}

	/**
	* Returns the workflow request ID of this workflow review.
	*
	* @return the workflow request ID of this workflow review
	*/
	@Override
	public long getWorkflowRequestId() {
		return _workflowReview.getWorkflowRequestId();
	}

	/**
	* Returns the workflow review ID of this workflow review.
	*
	* @return the workflow review ID of this workflow review
	*/
	@Override
	public long getWorkflowReviewId() {
		return _workflowReview.getWorkflowReviewId();
	}

	@Override
	public void persist() {
		_workflowReview.persist();
	}

	/**
	* Sets the approver comments of this workflow review.
	*
	* @param approverComments the approver comments of this workflow review
	*/
	@Override
	public void setApproverComments(java.lang.String approverComments) {
		_workflowReview.setApproverComments(approverComments);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflowReview.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_workflowReview.setClassName(className);
	}

	/**
	* Sets the class name ID of this workflow review.
	*
	* @param classNameId the class name ID of this workflow review
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_workflowReview.setClassNameId(classNameId);
	}

	/**
	* Sets the class pk of this workflow review.
	*
	* @param classPK the class pk of this workflow review
	*/
	@Override
	public void setClassPK(long classPK) {
		_workflowReview.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this workflow review.
	*
	* @param companyId the company ID of this workflow review
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workflowReview.setCompanyId(companyId);
	}

	/**
	* Sets the email comments of this workflow review.
	*
	* @param emailComments the email comments of this workflow review
	*/
	@Override
	public void setEmailComments(java.lang.String emailComments) {
		_workflowReview.setEmailComments(emailComments);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workflowReview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workflowReview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workflowReview.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this workflow review.
	*
	* @param groupId the group ID of this workflow review
	*/
	@Override
	public void setGroupId(long groupId) {
		_workflowReview.setGroupId(groupId);
	}

	/**
	* Sets the is approver role of this workflow review.
	*
	* @param isApproverRole the is approver role of this workflow review
	*/
	@Override
	public void setIsApproverRole(java.lang.String isApproverRole) {
		_workflowReview.setIsApproverRole(isApproverRole);
	}

	@Override
	public void setNew(boolean n) {
		_workflowReview.setNew(n);
	}

	/**
	* Sets the next stage of this workflow review.
	*
	* @param nextStage the next stage of this workflow review
	*/
	@Override
	public void setNextStage(java.lang.String nextStage) {
		_workflowReview.setNextStage(nextStage);
	}

	/**
	* Sets the primary key of this workflow review.
	*
	* @param primaryKey the primary key of this workflow review
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflowReview.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workflowReview.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the updated by of this workflow review.
	*
	* @param updatedBy the updated by of this workflow review
	*/
	@Override
	public void setUpdatedBy(long updatedBy) {
		_workflowReview.setUpdatedBy(updatedBy);
	}

	/**
	* Sets the updated date of this workflow review.
	*
	* @param updatedDate the updated date of this workflow review
	*/
	@Override
	public void setUpdatedDate(Date updatedDate) {
		_workflowReview.setUpdatedDate(updatedDate);
	}

	/**
	* Sets the updated to status of this workflow review.
	*
	* @param updatedToStatus the updated to status of this workflow review
	*/
	@Override
	public void setUpdatedToStatus(java.lang.String updatedToStatus) {
		_workflowReview.setUpdatedToStatus(updatedToStatus);
	}

	/**
	* Sets the workflow request ID of this workflow review.
	*
	* @param workflowRequestId the workflow request ID of this workflow review
	*/
	@Override
	public void setWorkflowRequestId(long workflowRequestId) {
		_workflowReview.setWorkflowRequestId(workflowRequestId);
	}

	/**
	* Sets the workflow review ID of this workflow review.
	*
	* @param workflowReviewId the workflow review ID of this workflow review
	*/
	@Override
	public void setWorkflowReviewId(long workflowReviewId) {
		_workflowReview.setWorkflowReviewId(workflowReviewId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowReviewWrapper)) {
			return false;
		}

		WorkflowReviewWrapper workflowReviewWrapper = (WorkflowReviewWrapper)obj;

		if (Objects.equals(_workflowReview,
					workflowReviewWrapper._workflowReview)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkflowReview getWrappedModel() {
		return _workflowReview;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workflowReview.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workflowReview.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workflowReview.resetOriginalValues();
	}

	private final WorkflowReview _workflowReview;
}