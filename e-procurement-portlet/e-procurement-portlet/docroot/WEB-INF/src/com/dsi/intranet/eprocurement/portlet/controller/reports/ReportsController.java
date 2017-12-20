package com.dsi.intranet.eprocurement.portlet.controller.reports;

import com.dsi.intranet.eprocurement.model.EprocurementLocation;
import com.dsi.intranet.eprocurement.portlet.bean.EprocurementReportDataObject;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.portlet.util.EProcurementUtil;
import com.dsi.intranet.eprocurement.portlet.util.EprocurementCommonUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@Controller("reportsController")
@RequestMapping(value = "VIEW")
public class ReportsController
{
    /** constant for the log **/
    private static final Log LOGGER = LogFactoryUtil.getLog(ReportsController.class);

    /**
     * This method is responsible for exporting search results to E-procurement_reports.xls file.
     * @param resourceRequest
     * @param resourceResponse
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    @ResourceMapping(value = "executeExportToExcel")
    public void executeExportToExcel(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException
    {
        PortletSession session = resourceRequest.getPortletSession();

        if (session != null && session.getAttribute("resultList") != null)
        {
            List<EprocurementReportDataObject> result = (List<EprocurementReportDataObject>) session
                    .getAttribute("resultList");

            JRBeanCollectionDataSource resultList = new JRBeanCollectionDataSource(result);
            try
            {

                JasperReport report = JasperCompileManager.compileReport(session.getPortletContext().getRealPath(
                        "/report/eprocurement-reports.jrxml"));
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), resultList);
                OutputStream os = resourceResponse.getPortletOutputStream();

                JRXlsExporter exporterXLS = new JRXlsExporter();
                exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
                exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, os);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "E-procurement_reports.xls");
                exporterXLS.exportReport();

                // Prompt user to save the excel file
                resourceResponse.setContentType("application/x-excel");
                resourceResponse.setProperty("Content-Disposition", "attachment; filename=E-procurement_reports.xls");

            } catch (Exception e)
            {
                LOGGER.error("ERROR while exporting Excel Report: " + e.getMessage(), e);
            }
        }
    }

    /**
     * This method is reponsible for setting reports search form values in map to show again in JSP after search is done.
     * @param renderRequest
     * @param paramMap
     * @param renderURL
     * @return Boolean 
     */
    public boolean populateMapAndURL(RenderRequest renderRequest, Map<String, String> paramMap, PortletURL renderURL)
    {
        boolean firstRender = true;

        String userId = ParamUtil.getString(renderRequest, Field.USER_ID);
        String requestId = ParamUtil.getString(renderRequest, EProcurementConstants.REQUEST_ID);
        String requestorName = ParamUtil.getString(renderRequest, EProcurementConstants.EPROCURE_USER);
        String contractId = ParamUtil.getString(renderRequest, EProcurementConstants.CONTRACT_ID);
        String poNumber = ParamUtil.getString(renderRequest, EProcurementConstants.PONUMBER);
        String vendorName = ParamUtil.getString(renderRequest, EProcurementConstants.VENDOR_NAME);
        String address = ParamUtil.getString(renderRequest, EProcurementConstants.ADDRESS);
        String itemNameDesc = ParamUtil.getString(renderRequest, EProcurementConstants.ITEM_NAME_DESC);
        String status = renderRequest.getParameter(EProcurementConstants.PARAM_STATUS);
        String startDate = ParamUtil.getString(renderRequest, EProcurementConstants.PARAM_START_DATE);
        String endDate = ParamUtil.getString(renderRequest, EProcurementConstants.PARAM_END_DATE);
        String stageUserId = ParamUtil.getString(renderRequest, EProcurementConstants.STAGE_USER_ID);
        String stageUserName = ParamUtil.getString(renderRequest, EProcurementConstants.STAGE_USER);

        if (Validator.isNull(userId) && Validator.isNull(requestId) && Validator.isNull(requestorName)
                && Validator.isNull(contractId) && Validator.isNull(poNumber) && Validator.isNull(vendorName)
                && Validator.isNull(address) && Validator.isNull(itemNameDesc) && Validator.isNull(status)
                && Validator.isNull(startDate) && Validator.isNull(endDate))
        {
            firstRender = false;
        }

        renderURL.setParameter("myActions", "searchEprocurementReports");

        /**
         * Set in parameters map to search in Database and also set in Request to show again in JSP after search is done.
         */

        if (Validator.isNotNull(userId) && !userId.equalsIgnoreCase("0"))
        {
            userId = StringUtil.trim(userId);
            paramMap.put(Field.USER_ID, userId);
            renderRequest.setAttribute("curUserId", userId);
            renderURL.setParameter(Field.USER_ID, userId);
        }

        if (Validator.isNotNull(requestId))
        {
            requestId = StringUtil.trim(requestId);
            paramMap.put(EProcurementConstants.REQUEST_ID, requestId);
            renderRequest.setAttribute("curRequestId", requestId);
            renderURL.setParameter(EProcurementConstants.REQUEST_ID, requestId);
        }

        if (Validator.isNotNull(requestorName))
        {
            requestorName = StringUtil.trim(requestorName);
            paramMap.put(EProcurementConstants.EPROCURE_USER, requestorName);
            renderRequest.setAttribute("curRequestorName", requestorName);
            renderURL.setParameter(EProcurementConstants.EPROCURE_USER, requestorName);
        }

        if (Validator.isNotNull(contractId))
        {
            contractId = StringUtil.trim(contractId);
            paramMap.put(EProcurementConstants.CONTRACT_ID, contractId);
            renderRequest.setAttribute("curContractId", contractId);
            renderURL.setParameter(EProcurementConstants.CONTRACT_ID, contractId);
        }

        if (Validator.isNotNull(poNumber))
        {
            poNumber = StringUtil.trim(poNumber);
            paramMap.put(EProcurementConstants.PURCHASE_ORDER_NUMBER, poNumber);
            renderRequest.setAttribute("curPONumber", poNumber);
            renderURL.setParameter(EProcurementConstants.PURCHASE_ORDER_NUMBER, poNumber);
        }

        if (Validator.isNotNull(vendorName))
        {
            vendorName = StringUtil.trim(vendorName);
            paramMap.put(EProcurementConstants.VENDOR_NAME, vendorName);
            renderRequest.setAttribute("curVendorName", vendorName);
            renderURL.setParameter(EProcurementConstants.VENDOR_NAME, vendorName);
        }

        if (Validator.isNotNull(address) && !address.equalsIgnoreCase(EProcurementConstants.PARAM_VALUE_SELECT))
        {
            address = StringUtil.trim(address);
            paramMap.put(EProcurementConstants.ADDRESS, address);
            renderRequest.setAttribute("curAddress", address);
            renderURL.setParameter(EProcurementConstants.ADDRESS, address);
        }

        if (Validator.isNotNull(itemNameDesc))
        {
            itemNameDesc = StringUtil.trim(itemNameDesc);
            paramMap.put(EProcurementConstants.ITEM_NAME_DESC, itemNameDesc);
            renderRequest.setAttribute("curItemNameDesc", itemNameDesc);
            renderURL.setParameter(EProcurementConstants.ITEM_NAME_DESC, itemNameDesc);
        }

        if (Validator.isNotNull(status) && !status.equalsIgnoreCase(EProcurementConstants.PARAM_VALUE_SELECT))
        {
            status = StringUtil.trim(status);
            paramMap.put(EProcurementConstants.PARAM_STATUS, status);
            renderRequest.setAttribute("curStatus", status);
            renderURL.setParameter(EProcurementConstants.PARAM_STATUS, status);
            
            if(status.equalsIgnoreCase(EProcurementConstants.STATUS_COMPLETED)){
            	
            	if(Validator.isNotNull(stageUserName)){
            		stageUserName = StringUtil.trim(stageUserName);
            		paramMap.put(EProcurementConstants.STAGE_USER, stageUserName);
            		renderRequest.setAttribute("curStageUserName", stageUserName);
                	renderURL.setParameter(EProcurementConstants.STAGE_USER, stageUserName);
            	}
                
                if (Validator.isNotNull(stageUserId) && !stageUserId.equalsIgnoreCase("0"))
                {
                	stageUserId = StringUtil.trim(stageUserId);
                    paramMap.put(EProcurementConstants.STAGE_USER_ID, stageUserId);
                    renderRequest.setAttribute("curStageUserId", stageUserId);
                    renderURL.setParameter(EProcurementConstants.STAGE_USER_ID, stageUserId);
                }
            }
        }

        if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate))
        {
            startDate = StringUtil.trim(startDate);
            paramMap.put(EProcurementConstants.PARAM_START_DATE, startDate);
            renderRequest.setAttribute("curStartDate", startDate);
            renderURL.setParameter(EProcurementConstants.PARAM_START_DATE, startDate);

            endDate = StringUtil.trim(endDate);
            paramMap.put(EProcurementConstants.PARAM_END_DATE, endDate);
            renderRequest.setAttribute("curEndDate", endDate);
            renderURL.setParameter(EProcurementConstants.PARAM_END_DATE, endDate);
        }
        return firstRender;
    }

    /**
     * This method is responsible for searching requests based on user filter criteria. 
     * @param renderRequest
     * @param renderResponse
     * @return String (eprocurement reports page)
     */
    @SuppressWarnings("unchecked")
    @RenderMapping(params = "myActions=searchEprocurementReports")
    public String searchEprocurementReports(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletSession session = renderRequest.getPortletSession();

        Map<String, String> paramMap = new HashMap<String, String>();

        // code for temphire locations
        try
        {
            List<EprocurementLocation> locations = EprocurementCommonUtil.getLocations();
            if (Validator.isNotNull(locations))
            {
                renderRequest.setAttribute("shipToAddresses", EprocurementCommonUtil.getLocations());
            }
            EProcurementUtil.setAllStatus(renderRequest);
        } catch (Exception e)
        {
            LOGGER.error("Error while getting temphire locations " + e.getMessage(), e);
        }
        // end of code for temphire locations

        PortletURL renderURL = renderResponse.createRenderURL();
        boolean firstRender = populateMapAndURL(renderRequest, paramMap, renderURL);

        if (firstRender)
        {
            SearchContainer reportsSearchContainer = new SearchContainer(renderRequest, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, EProcurementConstants.REQUEST_DASHBOARD_DEFAULT_DELTA,
                    renderURL, null, StringPool.BLANK);

            List<EprocurementReportDataObject> reportsDataObjectList = new ArrayList<>(); //Indexer.search(renderRequest, themeDisplay,
                    //reportsSearchContainer, paramMap);
            List<EprocurementReportDataObject> results = ListUtil.subList(reportsDataObjectList, reportsSearchContainer
                    .getStart(), reportsSearchContainer.getEnd());

            session.setAttribute("resultList", reportsDataObjectList);
            renderRequest.setAttribute("reportsDataObjectList", results);
            renderRequest.setAttribute("reportsSearchContainer", reportsSearchContainer);
        }

        return "reports/eprocurement_reports";
    }

    /**
     * This shows default view of eprocurement reports
     * @param renderRequest
     * @param renderResponse
     * @return String (eprocurement reports page)
     */
    @SuppressWarnings("unchecked")
    @RenderMapping(params = "myActions=showEprocurementReports")
    public String showEprocurementReports(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        List<EprocurementReportDataObject> reportsDataObjectList = new ArrayList<EprocurementReportDataObject>();
        // code for temphire locations
        try
        {
            List<EprocurementLocation> locations = EprocurementCommonUtil.getLocations();
            if (Validator.isNotNull(locations))
            {
                renderRequest.setAttribute("shipToAddresses", EprocurementCommonUtil.getLocations());
            }
            EProcurementUtil.setAllStatus(renderRequest);
        } catch (Exception e)
        {
            LOGGER.error("Error while getting temphire locations " + e.getMessage(), e);
        }
        // end of code for temphire locations
        PortletURL renderURL = renderResponse.createRenderURL();

        SearchContainer reportsSearchContainer = new SearchContainer(renderRequest, null, null,
                SearchContainer.DEFAULT_CUR_PARAM, EProcurementConstants.REQUEST_DASHBOARD_DEFAULT_DELTA, renderURL,
                null, StringPool.BLANK);

        renderRequest.setAttribute("reportsSearchContainer", reportsSearchContainer);
        renderRequest.setAttribute("reportsDataObjectList", reportsDataObjectList);
        return "reports/eprocurement_reports";
    }

    /**
     * This is the default view method for reports
     * 
     * @param renderRequest
     * @param renderResponse
     * @return String (view page)
     */
    @RenderMapping
    public String showReports(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        return "reports/view";
    }
}
