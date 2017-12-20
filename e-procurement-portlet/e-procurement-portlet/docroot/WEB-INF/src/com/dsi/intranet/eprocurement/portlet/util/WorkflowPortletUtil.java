/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException;
import com.dsi.intranet.eprocurement.model.WorkflowDefinition;
import com.dsi.intranet.eprocurement.portlet.bean.WorkflowDataObject;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.WorkflowDefinitionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * <a href="WorkflowPortletUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project E-procurement
 * @Author Devaki Subramaniam
 * @Description WorkflowPortletUtil class for the Workflow portlet.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public final class WorkflowPortletUtil
{
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(WorkflowPortletUtil.class);

    /** constant for the stage end tag **/
    private static final String STAGE_END = "</stage>";

    /** constant for the stage start tag **/
    private static final String STAGE_START = "<stage>";

    /** constant for the log stages end tag**/
    private static final String STAGES_END = "</stages>";

    /** constant for the log stages start tag**/
    private static final String STAGES_START = "<stages>";
    
    private WorkflowPortletUtil()
    {
    	
    }

    /**
     * Utility method to get all workflows
     * @param renderRequest
     * @param renderResponse
     */
    @SuppressWarnings("unchecked")
    public static void getAllWorkflow(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        PortletURL renderURL = renderResponse.createRenderURL();

        SearchContainer workflowSearchContainer = new SearchContainer(renderRequest, null, null,
                SearchContainer.DEFAULT_CUR_PARAM, EProcurementConstants.REQUEST_DASHBOARD_DEFAULT_DELTA, renderURL,
                null, StringPool.BLANK);

        List<WorkflowDataObject> workflowDataObjectList = WorkflowPortletUtil.getWorkflowDataObjects();

        workflowSearchContainer.setTotal(workflowDataObjectList.size());
        List<WorkflowDataObject> results = ListUtil.subList(workflowDataObjectList, workflowSearchContainer.getStart(),
                workflowSearchContainer.getEnd());

        renderRequest.setAttribute("workflowDataObjectList", results);
        renderRequest.setAttribute("workflowSearchContainer", workflowSearchContainer);
    }

    /**
     * This method is responsible for getting stage value from xml
     * @param xmlString
     * @return List<Long> (approverId list)
     */
    public static List<Long> getApproverIdList(String xmlString)
    {
        List<Long> approverIdList = new ArrayList<Long>();
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            InputSource inStream = new InputSource();
            inStream.setCharacterStream(new StringReader(xmlString));
            Document doc = db.parse(inStream);
            NodeList nodeList = doc.getElementsByTagName("stages");
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;

                    NodeList nameNode = element.getElementsByTagName("stage");

                    for (int iIndex = 0; iIndex < nameNode.getLength(); iIndex++)
                    {
                        if (nameNode.item(iIndex).getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element stageElement = (Element) nameNode.item(iIndex);
                            approverIdList.add(Long.valueOf(stageElement.getFirstChild().getNodeValue().trim()));
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            LOGGER.error("Error while parsing stages xml: " + e.getMessage(), e);
        }

        return approverIdList;
    }

    /**
     * This method is responsible for constructing jobtitle - username string from approversId
     * @param approversIdList
     * @return LinkedHashMap<Long, String>
     */
    public static LinkedHashMap<Long, String> getApproversNameMap(List<Long> approversIdList)
    {
        StringBuffer approversName;
        LinkedHashMap<Long, String> approverIdNameMap = new LinkedHashMap<Long, String>();

        for (long approverId : approversIdList)
        {
            approversName = new StringBuffer();

            User user = null;
            try
            {
                user = UserLocalServiceUtil.getUser(approverId);
            } catch (Exception e)
            {
                LOGGER.error("Error while retrieving user for approverId: " + e.getMessage(), e);
            }
            if(Validator.isNotNull(user)){
                approversName.append(user.getJobTitle());
                approversName.append(StringPool.SPACE);
                approversName.append(StringPool.DASH);
                approversName.append(StringPool.SPACE);
                approversName.append(user.getFirstName());
                approversName.append(StringPool.SPACE);
                approversName.append(user.getLastName());

                approverIdNameMap.put(approverId, approversName.toString());
            }
        }
        return approverIdNameMap;
    }

    /**
     * This method is responsible for generating stages xml from approverIds
     * @param approverIds
     * @return String (xml string)
     */
    public static String getStages(String approverIds)
    {
        String[] approverIdArray = approverIds.split(",");
        StringBuffer stagesBuffer = new StringBuffer();
        stagesBuffer.append(STAGES_START);
        for (String approverId : approverIdArray)
        {
            stagesBuffer.append(STAGE_START);
            stagesBuffer.append(approverId);
            stagesBuffer.append(STAGE_END);
        }
        stagesBuffer.append(STAGES_END);

        return stagesBuffer.toString();
    }

    /**
     * This method retrieves all users whose job title value is not empty or null.
     * @param jobTitleList
     * @param renderRequest
     */
    public static void getUserMap(List<String> jobTitleList, RenderRequest renderRequest)
    {
        HashMap<Long, String> userMap = null;
        HashMap<String, HashMap<Long, String>> jobTitleUserMap = new HashMap<String, HashMap<Long, String>>();

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        for (String jobTitle : jobTitleList)
        {
            userMap = new HashMap<Long, String>();
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil
                    .getClassLoader());
            dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", themeDisplay.getCompanyId()));
            dynamicQuery.add(RestrictionsFactoryUtil.eq("jobTitle", jobTitle));
            try
            {
                List<Object> results = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
                for (Object userObject : results)
                {
                    User user = (User) userObject;
                    userMap.put(user.getUserId(), user.getFullName());
                }
            } catch (SystemException e)
            {
                LOGGER.error("Error while retrieving users for approvers: " + e.getMessage(), e);
            }
            jobTitleUserMap.put(jobTitle, userMap);
        }

        renderRequest.setAttribute("jobTitleUserMap", jobTitleUserMap);
    }

    /**
     * Utility method to set workflow in WorkflowDataObject
     * @return List<WorkflowDataObject>
     */
    public static List<WorkflowDataObject> getWorkflowDataObjects()
    {
        WorkflowDataObject workflowDataObject = null;
        List<WorkflowDataObject> workflowDataObjectList = new ArrayList<WorkflowDataObject>();
        try
        {
            List<WorkflowDefinition> wfList = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinitions(0,
                    WorkflowDefinitionLocalServiceUtil.getWorkflowDefinitionsCount());
            StringBuffer approversName;

            for (WorkflowDefinition wfDef : wfList)
            {
                approversName = new StringBuffer();
                int approversCount = 0;
                int initialCount = 0;
                workflowDataObject = new WorkflowDataObject();

                List<Long> approverIdList = getApproverIdList(wfDef.getStages());
                approversCount = approverIdList.size();
                for (Long approverId : approverIdList)
                {
                    initialCount += 1;
                    User user = UserLocalServiceUtil.getUser(approverId);
                    approversName.append(user.getJobTitle());
                    approversName.append(StringPool.SPACE);
                    approversName.append(StringPool.DASH);
                    approversName.append(StringPool.SPACE);
                    approversName.append(user.getFirstName());
                    approversName.append(StringPool.SPACE);
                    approversName.append(user.getLastName());
                    if (initialCount < approversCount)
                    {
                        approversName.append(StringPool.COMMA);
                    }
                }
                workflowDataObject.setWorkflowDefinitionID(wfDef.getWorkflowDefinitionId());
                workflowDataObject.setWorkflowName(wfDef.getWorkflowName());
                workflowDataObject.setApprovers(approversName.toString());
                workflowDataObjectList.add(workflowDataObject);
            }

        } catch (Exception e)
        {
            LOGGER.error("Error while retrieving workflow definition: " + e.getMessage(), e);
        }
        return workflowDataObjectList;
    }

    /**
     * method to validate unique workflow name
     * @param workflowDefinitionId
     * @param companyId
     * @param workflowName
     * @return boolean
     * @throws SystemException
     */
    public static boolean validateWorkflowName(long workflowDefinitionId, long companyId, String workflowName)
            throws SystemException
    {
        boolean workflowNameExists = Boolean.FALSE;
        if (Validator.isNotNull(workflowName))
        {
            try
            {
                WorkflowDefinition workflowDefinition = WorkflowDefinitionLocalServiceUtil.getWorkflowDefinition(
                        companyId, workflowName);

                if (workflowDefinitionId <= 0 || workflowDefinition.getWorkflowDefinitionId() != workflowDefinitionId)
                {
                    workflowNameExists = Boolean.TRUE;
                }
            } catch (NoSuchWorkflowDefinitionException nsge)
            {
                workflowNameExists = Boolean.FALSE;
            }

        }
        return workflowNameExists;
    }
}
