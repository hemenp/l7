package com.dsi.intranet.eprocurement.portlet.model;

import com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl;

public class ExtendedRequest extends EprocurementRequestImpl{
	
	private static final long serialVersionUID = 2770865313790002996L;
	private String workFlowDefinitionName;

	public String getWorkFlowDefinitionName() {
		return workFlowDefinitionName;
	}

	public void setWorkFlowDefinitionName(String workFlowDefinitionName) {
		this.workFlowDefinitionName = workFlowDefinitionName;
	}

	
}
