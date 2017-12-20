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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author CIGNEX Technologies
 * @generated
 */
@ProviderType
public class WorkflowReviewSoap implements Serializable {
	public static WorkflowReviewSoap toSoapModel(WorkflowReview model) {
		WorkflowReviewSoap soapModel = new WorkflowReviewSoap();

		soapModel.setWorkflowReviewId(model.getWorkflowReviewId());
		soapModel.setWorkflowRequestId(model.getWorkflowRequestId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedToStatus(model.getUpdatedToStatus());
		soapModel.setNextStage(model.getNextStage());
		soapModel.setIsApproverRole(model.getIsApproverRole());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setApproverComments(model.getApproverComments());
		soapModel.setEmailComments(model.getEmailComments());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static WorkflowReviewSoap[] toSoapModels(WorkflowReview[] models) {
		WorkflowReviewSoap[] soapModels = new WorkflowReviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowReviewSoap[][] toSoapModels(WorkflowReview[][] models) {
		WorkflowReviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowReviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowReviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowReviewSoap[] toSoapModels(List<WorkflowReview> models) {
		List<WorkflowReviewSoap> soapModels = new ArrayList<WorkflowReviewSoap>(models.size());

		for (WorkflowReview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowReviewSoap[soapModels.size()]);
	}

	public WorkflowReviewSoap() {
	}

	public long getPrimaryKey() {
		return _workflowReviewId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowReviewId(pk);
	}

	public long getWorkflowReviewId() {
		return _workflowReviewId;
	}

	public void setWorkflowReviewId(long workflowReviewId) {
		_workflowReviewId = workflowReviewId;
	}

	public long getWorkflowRequestId() {
		return _workflowRequestId;
	}

	public void setWorkflowRequestId(long workflowRequestId) {
		_workflowRequestId = workflowRequestId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;
	}

	public String getUpdatedToStatus() {
		return _updatedToStatus;
	}

	public void setUpdatedToStatus(String updatedToStatus) {
		_updatedToStatus = updatedToStatus;
	}

	public String getNextStage() {
		return _nextStage;
	}

	public void setNextStage(String nextStage) {
		_nextStage = nextStage;
	}

	public String getIsApproverRole() {
		return _isApproverRole;
	}

	public void setIsApproverRole(String isApproverRole) {
		_isApproverRole = isApproverRole;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	public String getApproverComments() {
		return _approverComments;
	}

	public void setApproverComments(String approverComments) {
		_approverComments = approverComments;
	}

	public String getEmailComments() {
		return _emailComments;
	}

	public void setEmailComments(String emailComments) {
		_emailComments = emailComments;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _workflowReviewId;
	private long _workflowRequestId;
	private long _classNameId;
	private long _classPK;
	private long _updatedBy;
	private String _updatedToStatus;
	private String _nextStage;
	private String _isApproverRole;
	private Date _updatedDate;
	private String _approverComments;
	private String _emailComments;
	private long _companyId;
	private long _groupId;
}