package com.dsi.intranet.eprocurement.portlet.controller.workflow;

import com.dsi.intranet.eprocurement.model.WorkflowDefinition;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionImpl;
import com.dsi.intranet.eprocurement.portlet.bean.WorkflowDataObject;
import com.dsi.intranet.eprocurement.portlet.util.WorkflowPortletUtil;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.WorkflowRequestLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
@Controller("workflowController")
@RequestMapping(value = "VIEW")
public class WorkflowController
{
    /** constant for the log **/
    private static final Log _log = LogFactoryUtil.getLog(WorkflowController.class);

    /**
     * This method is responsible for deleting a workflow when workflow not assigned to any request.
     * @param renderRequest
     * @param renderResponse
     * @return String (view workflow dashboard page)
     */
    @RenderMapping(params = "myActions=deleteWorkflow")
    public String deleteWorkflow(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        String workflowDefinitionId = ParamUtil.getString(renderRequest, "workflowDefinitionId");
        if (Validator.isNotNull(workflowDefinitionId))
        {
            List<String> errors = new ArrayList<String>();

            try
            {
                WorkflowDefinition workflowDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(Long
                        .parseLong(workflowDefinitionId));

                List<WorkflowRequest> workflowRequest = WorkflowRequestLocalServiceUtil
                        .getWorkflowRequestsByWorkflowDefinitionId(workflowDefinition.getCompanyId(),
                                workflowDefinition.getGroupId(), Long.parseLong(workflowDefinitionId), true);

                if (Validator.isNotNull(workflowRequest) && workflowRequest.size() > 0)
                {
                    errors.add(workflowDefinition.getWorkflowName()
                            + " workflow is already assigned to a request. Cannot delete assigned workflow.");
                    renderRequest.setAttribute("errors", errors);
                } else
                {
                    try
                    {
                        WorkflowDefinitionLocalServiceUtil.deleteWorkflowDefinition(Long
                                .parseLong(workflowDefinitionId));
                        renderRequest.setAttribute("success", "Workflow deleted successfully.");
                    } catch (Exception e)
                    {
                        _log.error("Error while deleting workflow " + e.getMessage(), e);
                    }
                }
            } catch (Exception e)
            {
                _log.error("Error while deleting workflow " + e.getMessage(), e);
            }

        }

        WorkflowPortletUtil.getAllWorkflow(renderRequest, renderResponse);
        return "workflow/view";
    }

    /**
     * This method is responsible for adding new or updating existing working 
     * @param actionRequest
     * @param actionResponse
     * @throws Exception
     */
    @ActionMapping(params = "myActions=saveNewWorkflow")
    public void saveNewWorkflow(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
    {
        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String workflowName = ParamUtil.getString(actionRequest, "workflowName");
        String approverIds = ParamUtil.getString(actionRequest, "approverIds");
        String redirectURL = StringPool.BLANK;

        String error = StringPool.BLANK;
        String successVal = StringPool.BLANK;
        try
        {
            WorkflowDefinition workflowDefinition = new WorkflowDefinitionImpl();
            if (cmd.equalsIgnoreCase(Constants.ADD))
            {
                successVal = "Workflow has been created successfully.";
                long workflowDefinitionId = CounterLocalServiceUtil.increment(WorkflowDefinition.class.getName());
                workflowDefinition.setWorkflowDefinitionId(workflowDefinitionId);
                workflowDefinition.setCompanyId(themeDisplay.getCompanyId());
                workflowDefinition.setGroupId(themeDisplay.getScopeGroupId());
                workflowDefinition.setWorkflowName(workflowName);
                workflowDefinition.setStages(WorkflowPortletUtil.getStages(approverIds));
                workflowDefinition.setCreatedBy(themeDisplay.getUserId());
                workflowDefinition.setCreatedDate(new Date());
                workflowDefinition.setModifiedBy(themeDisplay.getUserId());
                workflowDefinition.setModifiedDate(new Date());
                workflowDefinition.setIsActive(true);
            } else if (cmd.equalsIgnoreCase(Constants.UPDATE))
            {
                successVal = "Workflow updated successfully.";
                String workflowDefinitionId = ParamUtil.getString(actionRequest, "workflowDefinitionId");
                if (Validator.isNotNull(workflowDefinitionId))
                {
                    WorkflowDefinition workflow = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(Long
                            .parseLong(workflowDefinitionId));
                    workflowDefinition.setWorkflowDefinitionId(Long.parseLong(workflowDefinitionId));
                    workflowDefinition.setCompanyId(workflow.getCompanyId());
                    workflowDefinition.setGroupId(workflow.getGroupId());
                    workflowDefinition.setWorkflowName(workflowName);
                    workflowDefinition.setStages(WorkflowPortletUtil.getStages(approverIds));
                    workflowDefinition.setCreatedBy(workflow.getCreatedBy());
                    workflowDefinition.setCreatedDate(workflow.getCreatedDate());
                    workflowDefinition.setModifiedBy(themeDisplay.getUserId());
                    workflowDefinition.setModifiedDate(new Date());
                    workflowDefinition.setIsActive(true);
                }
            }

            // validation for unique workflow name
            error = updateWorkflow(workflowDefinition, cmd);
            if (Validator.isNotNull(error))
            {
                String returnWorkflowVal = "&error=" + error + "&workflowName=" + workflowDefinition.getWorkflowName()
                        + "&workflowStages=" + workflowDefinition.getStages();
                redirectURL = ParamUtil.getString(actionRequest, "redirectToEditPage");
                redirectURL = redirectURL + returnWorkflowVal;

            } else
            {
                List<WorkflowDataObject> workflowDataObjectList = WorkflowPortletUtil.getWorkflowDataObjects();
                actionRequest.setAttribute("workflowDataObjectList", workflowDataObjectList);
                redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
                redirectURL = redirectURL + "&success=" + successVal;
            }
        } catch (SystemException e)
        {
            _log.error("Error while adding workflow: " + e.getMessage(), e);
        }

        actionResponse.sendRedirect(redirectURL);
    }

    /**
     * This method shows Edit screen of workflow when workflow is not assigned to any request. 
     * If workflow is already assigned to any request it will show workflow dashboard view page.
     * 
     * @param renderRequest
     * @param renderResponse
     * @return String (view dashboard or edit workflow page)
     */
    @RenderMapping(params = "myActions=showEditWorkflowScreen")
    public String showEditWorkflowScreen(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        String returnValue = StringPool.BLANK;
        String workflowDefinitionId = ParamUtil.getString(renderRequest, "workflowDefinitionId");

        if (Validator.isNotNull(workflowDefinitionId))
        {
            long workflowId = Long.valueOf(workflowDefinitionId);
            List<String> errors = new ArrayList<String>();
            try
            {
                WorkflowDefinition workflowDefinition = WorkflowDefinitionLocalServiceUtil
                        .getWorkflowDefinition(workflowId);

                List<WorkflowRequest> workflowRequest = new ArrayList<WorkflowRequest>();
                try
                {
                    workflowRequest = WorkflowRequestLocalServiceUtil.getWorkflowRequestsByWorkflowDefinitionId(
                            workflowDefinition.getCompanyId(), workflowDefinition.getGroupId(), workflowId, true);
                } catch (Exception e)
                {
                    _log.info("Workflow not assigned to any request.");
                }

                if (Validator.isNotNull(workflowRequest) && workflowRequest.size() > 0)
                {
                    errors.add(workflowDefinition.getWorkflowName()
                            + " workflow is already assigned to a request. Cannot edit assigned workflow.");
                    renderRequest.setAttribute("errors", errors);
                    returnValue = "workflow/view";
                    WorkflowPortletUtil.getAllWorkflow(renderRequest, renderResponse);
                } else
                {
                    List<Long> approversIdList = WorkflowPortletUtil.getApproverIdList(workflowDefinition.getStages());
                    LinkedHashMap<Long, String> approverIdNameMap = WorkflowPortletUtil
                            .getApproversNameMap(approversIdList);
                    _log.info("showEditworkflow workflowName"+workflowDefinition.getWorkflowName());
                    /*
                     * removed logger as per sonar
                    for (Long key : approverIdNameMap.keySet())
                    {    _log.info("Key: " + key + ", Value: " + approverIdNameMap.get(key)); 
                    } 
                     */
                    renderRequest.setAttribute("workflowDefinitionId", workflowDefinitionId);
                    renderRequest.setAttribute("workflowName", workflowDefinition.getWorkflowName());
                    renderRequest.setAttribute("approverIdNameMap", approverIdNameMap);
                    returnValue = "workflow/edit_workflow";
                }

            } catch (Exception e)
            {
                _log.error("Error while displaying edit Workflow screen " + e.getMessage(), e);
            }
        }

        return returnValue;
    }

    /**
     * view method for add workflow page
     * 
     * @param renderRequest
     * @param renderResponse
     * @return String (add workflow page)
     */
    @RenderMapping(params = "myActions=showNewWorkflowScreen")
    public String showNewWorkflowScreen(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        return "workflow/add_workflow";
    }

    /**
     * This is the default view method for Workflow Dashboard
     * 
     * @param renderRequest
     * @param renderResponse
     * @return String (view page)
     */
    @RenderMapping
    public String showWorkflowDashboardScreen(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        WorkflowPortletUtil.getAllWorkflow(renderRequest, renderResponse);

        return "workflow/view";
    }

    /**
     * This method is responsible for validating unique workflow name during workflow add or update.
     * @param workflowDefinition
     * @return String (error message)
     */
    protected String updateWorkflow(WorkflowDefinition workflowDefinition, String cmd)
    {
        String error = StringPool.BLANK;
        try
        {
            boolean duplicateWorkflowName = WorkflowPortletUtil
                    .validateWorkflowName(workflowDefinition.getWorkflowDefinitionId(), workflowDefinition
                            .getCompanyId(), workflowDefinition.getWorkflowName());

            if (duplicateWorkflowName)
            {
                error = "Workflow Name must be unique.";
            } else if(cmd.equals(Constants.ADD))
            {

                WorkflowDefinitionLocalServiceUtil.addWorkflowDefinition(workflowDefinition);
            } else  if(cmd.equals(Constants.UPDATE)){
                WorkflowDefinitionLocalServiceUtil.updateWorkflowDefinition(workflowDefinition);

                _log.info("workflow name1: "+workflowDefinition.getWorkflowName());
                WorkflowDefinitionLocalServiceUtil.updateWorkflowDefinition(workflowDefinition);
                _log.info("workflow name2: "+workflowDefinition.getWorkflowName());
            }
        } catch (SystemException e)
        {
            _log.error("Error while updating workflow: " + e.getMessage(), e);
        }
        return error;
    }

}
