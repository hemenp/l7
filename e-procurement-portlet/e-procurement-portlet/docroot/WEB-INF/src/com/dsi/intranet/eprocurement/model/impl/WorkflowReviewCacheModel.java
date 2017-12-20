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

package com.dsi.intranet.eprocurement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.dsi.intranet.eprocurement.model.WorkflowReview;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkflowReview in entity cache.
 *
 * @author CIGNEX Technologies
 * @see WorkflowReview
 * @generated
 */
@ProviderType
public class WorkflowReviewCacheModel implements CacheModel<WorkflowReview>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowReviewCacheModel)) {
			return false;
		}

		WorkflowReviewCacheModel workflowReviewCacheModel = (WorkflowReviewCacheModel)obj;

		if (workflowReviewId == workflowReviewCacheModel.workflowReviewId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workflowReviewId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{workflowReviewId=");
		sb.append(workflowReviewId);
		sb.append(", workflowRequestId=");
		sb.append(workflowRequestId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedToStatus=");
		sb.append(updatedToStatus);
		sb.append(", nextStage=");
		sb.append(nextStage);
		sb.append(", isApproverRole=");
		sb.append(isApproverRole);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", approverComments=");
		sb.append(approverComments);
		sb.append(", emailComments=");
		sb.append(emailComments);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkflowReview toEntityModel() {
		WorkflowReviewImpl workflowReviewImpl = new WorkflowReviewImpl();

		workflowReviewImpl.setWorkflowReviewId(workflowReviewId);
		workflowReviewImpl.setWorkflowRequestId(workflowRequestId);
		workflowReviewImpl.setClassNameId(classNameId);
		workflowReviewImpl.setClassPK(classPK);
		workflowReviewImpl.setUpdatedBy(updatedBy);

		if (updatedToStatus == null) {
			workflowReviewImpl.setUpdatedToStatus(StringPool.BLANK);
		}
		else {
			workflowReviewImpl.setUpdatedToStatus(updatedToStatus);
		}

		if (nextStage == null) {
			workflowReviewImpl.setNextStage(StringPool.BLANK);
		}
		else {
			workflowReviewImpl.setNextStage(nextStage);
		}

		if (isApproverRole == null) {
			workflowReviewImpl.setIsApproverRole(StringPool.BLANK);
		}
		else {
			workflowReviewImpl.setIsApproverRole(isApproverRole);
		}

		if (updatedDate == Long.MIN_VALUE) {
			workflowReviewImpl.setUpdatedDate(null);
		}
		else {
			workflowReviewImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (approverComments == null) {
			workflowReviewImpl.setApproverComments(StringPool.BLANK);
		}
		else {
			workflowReviewImpl.setApproverComments(approverComments);
		}

		if (emailComments == null) {
			workflowReviewImpl.setEmailComments(StringPool.BLANK);
		}
		else {
			workflowReviewImpl.setEmailComments(emailComments);
		}

		workflowReviewImpl.setCompanyId(companyId);
		workflowReviewImpl.setGroupId(groupId);

		workflowReviewImpl.resetOriginalValues();

		return workflowReviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowReviewId = objectInput.readLong();

		workflowRequestId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		updatedBy = objectInput.readLong();
		updatedToStatus = objectInput.readUTF();
		nextStage = objectInput.readUTF();
		isApproverRole = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		approverComments = objectInput.readUTF();
		emailComments = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workflowReviewId);

		objectOutput.writeLong(workflowRequestId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(updatedBy);

		if (updatedToStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedToStatus);
		}

		if (nextStage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nextStage);
		}

		if (isApproverRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isApproverRole);
		}

		objectOutput.writeLong(updatedDate);

		if (approverComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(approverComments);
		}

		if (emailComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailComments);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);
	}

	public long workflowReviewId;
	public long workflowRequestId;
	public long classNameId;
	public long classPK;
	public long updatedBy;
	public String updatedToStatus;
	public String nextStage;
	public String isApproverRole;
	public long updatedDate;
	public String approverComments;
	public String emailComments;
	public long companyId;
	public long groupId;
}