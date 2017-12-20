/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.model.PGCRequestSummary;
import com.dsi.intranet.pgc.portlet.service.PGCService;
import com.dsi.intranet.pgc.portlet.util.DropDownUtil;
import com.dsi.intranet.pgc.portlet.util.LongNumberEditor;
import com.dsi.intranet.pgc.portlet.util.PGCCommonUtil;
import com.dsi.intranet.pgc.portlet.util.PGCFormTypeEditor;
import com.dsi.intranet.pgc.portlet.util.ServiceTrackerUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.portlet.PortletProps;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import com.dsi.intranet.rfc.model.CostCenter;
import com.dsi.intranet.rfc.model.EmployeeDataDump;
import com.dsi.intranet.rfc.model.WBSElements;
import com.dsi.intranet.rfc.service.CostCenterLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalServiceUtil;
import com.dsi.intranet.rfc.service.WBSElementsLocalServiceUtil;
import com.dsi.intranet.rfc.service.EmployeeDataDumpLocalService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;


/**
 * <a href="PGCDashboardController.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Vijayan Chendrayan
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
@Controller("pgcDashboadController")
@RequestMapping(value = "VIEW")
@SessionAttributes({ "appForm" })
public class PGCDashboardController extends PGCAbstractControllerBase
{

	private static final Log LOGGER = LogFactoryUtil.getLog(PGCDashboardController.class);
		
    @Autowired
    @Qualifier("defaultImpl")
    private PGCService pgcService;

    @ModelAttribute("appForm")
    public PGCForm getNewRequestCommandObject()
    {
        return new PGCForm();
    }

    @InitBinder("appForm")
    public void initNewRequestCmdBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Long.class, new LongNumberEditor());
        binder.registerCustomEditor(PGCFormType.class, new PGCFormTypeEditor());
    }

    @RenderMapping
    public String showDashboard(RenderRequest renderRequest, RenderResponse renderResponse, ModelMap modMap)
    {
        boolean iSDSIEmployee = false;
        User user = ((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).getUser();
        iSDSIEmployee = PGCCommonUtil.IsDSIEmployee(user);
        
        if (iSDSIEmployee)
        {
            Map<String, String> formTypes = null;
            //ServiceTrackerUtil serviceTrackerUtil = new ServiceTrackerUtil();
            //int employeeType = serviceTrackerUtil.getEmployeeType(user);
            int employeeType = PGCCommonUtil.getEmployeeType(user);
            LOGGER.info("EMployee Type is "+employeeType);
            formTypes = DropDownUtil.getFormTypes(employeeType);
            
            if (employeeType == 0) {
            	return "other_group";
            }
            
            PortletSession portletSession = renderRequest.getPortletSession();
            PortletURL renderURL = renderResponse.createRenderURL();
            renderURL.setParameter("appAction", "navigator");
            PGCRequestSummary pgcSummary = new PGCRequestSummary();
            List<PGCRequestSummary> reqsList = new ArrayList<PGCRequestSummary>();
            String appAction = ParamUtil.getString(renderRequest, "appAction");
            String employeeId = PGCCommonUtil.getExpandoEmployeeId(user);
            
            if (Validator.isNotNull(appAction))
            {
                if (appAction.equalsIgnoreCase("search"))
                {
                    pgcSummary = new PGCRequestSummary();
                    pgcSummary.setDateType(ParamUtil.getString(renderRequest, "dateType"));
                    pgcSummary.setStartDate(ParamUtil.getString(renderRequest, "startDate"));
                    pgcSummary.setEndDate(ParamUtil.getString(renderRequest, "endDate"));
                    pgcSummary.setRequestor(ParamUtil.getString(renderRequest, "requestor"));
                    pgcSummary.setRequestTitle(ParamUtil.getString(renderRequest, "requestTitle"));
                    pgcSummary.setStatus(ParamUtil.getString(renderRequest, "status"));
                    pgcSummary.setFormType(ParamUtil.getString(renderRequest, "formTypeValue"));
                    reqsList = pgcService.getUserPGCRequestsList(pgcSummary, employeeId);
                    portletSession.setAttribute("PGCSUMMARY", pgcSummary);
                } else if (appAction.equalsIgnoreCase("navigator"))
                {
                    if (Validator.isNotNull(portletSession.getAttribute("reqsListObj")))
                    {
                        reqsList = (List<PGCRequestSummary>) portletSession.getAttribute("reqsListObj");
                    } else
                    {
                        portletSession.removeAttribute("PGCSUMMARY");
                        reqsList = pgcService.getUserPGCRequestsList(pgcSummary, employeeId);
                    }
                }
            } else
            {
                portletSession.removeAttribute("PGCSUMMARY");
                reqsList = pgcService.getUserPGCRequestsList(pgcSummary, employeeId);
            }
            
            List<PGCRequestSummary> filteredList = PGCCommonUtil.dashBoardStatusList(reqsList);
            LOGGER.info("filteredList size is "+filteredList.size());
            SearchContainer dashBoardSearchContainer = new SearchContainer(renderRequest, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, PGCCommonConstants.SEARCH_CONTAINER_COUNT, renderURL, null,
                    "No Request Available.");
            renderRequest.setAttribute("dashBoardSearchContainer", dashBoardSearchContainer);
            dashBoardSearchContainer.setTotal(filteredList.size());
            if(filteredList.size()>0){
            	List<PGCRequestSummary> results = ListUtil.subList(filteredList, dashBoardSearchContainer.getStart(),dashBoardSearchContainer.getEnd());
            	renderRequest.setAttribute("results", results);
            }else{
            	List<PGCRequestSummary> results = new ArrayList<>();
            	renderRequest.setAttribute("results", results);
            }
            portletSession.setAttribute("reqsListObj", filteredList);
            
            renderRequest.setAttribute("filteredFormTypes", formTypes);

            return "dashboard";
        } else
        {
            return "error";
        }
    }
}