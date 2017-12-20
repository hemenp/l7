/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.bean;

import com.liferay.portal.kernel.util.StringPool;
/**
 * <a href="WorkflowDataObject.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project E-procurement
 * @Author Devaki Subramaniam
 * @Description bean for Workflow data.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public class WorkflowDataObject {
	
	private String approvers = StringPool.BLANK;
	private long workflowDefinitionID;
	private String workflowName = StringPool.BLANK;
	    
	public long getWorkflowDefinitionID() {
		return workflowDefinitionID;
	}
	public void setWorkflowDefinitionID(long workflowDefinitionID) {
		this.workflowDefinitionID = workflowDefinitionID;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getApprovers() {
		return approvers;
	}
	public void setApprovers(String approvers) {
		this.approvers = approvers;
	}
		
}
