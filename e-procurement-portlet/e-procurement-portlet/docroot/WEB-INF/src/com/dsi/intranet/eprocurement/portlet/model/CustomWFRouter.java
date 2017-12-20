package com.dsi.intranet.eprocurement.portlet.model;

import java.util.List;

/**
 * 
 * @author Jay Patel
 *
 */
public class CustomWFRouter 
{
	private long wfDefinitionId;
	
	private String wfDefinitionName;
	
	private List<CustomStageRouter> listStageRouter;

	public long getWfDefinitionId() {
		return wfDefinitionId;
	}

	public void setWfDefinitionId(long wfDefinitionId) {
		this.wfDefinitionId = wfDefinitionId;
	}

	public String getWfDefinitionName() {
		return wfDefinitionName;
	}

	public void setWfDefinitionName(String wfDefinitionName) {
		this.wfDefinitionName = wfDefinitionName;
	}

	public List<CustomStageRouter> getListStageRouter() {
		return listStageRouter;
	}

	public void setListStageRouter(List<CustomStageRouter> listStageRouter) {
		this.listStageRouter = listStageRouter;
	}
	
	
}
