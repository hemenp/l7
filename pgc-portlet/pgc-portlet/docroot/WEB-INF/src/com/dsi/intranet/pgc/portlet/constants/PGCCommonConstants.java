/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.portal.kernel.util.StringPool;
import java.util.List;
import java.util.Arrays;

/**
 * <a href="PGCCommonConstants.java"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface PGCCommonConstants
{
    // used for query limit . all record will be getting
    
    int ALL_POS = -1;

    int AUTO_COMPLETE_COUNT = 15;
    int SEARCH_CONTAINER_COUNT = 5;

    String FRIENDLY_URL_PGC_DASHBOARD = "pgc";
    String FRIENDLY_URL_PGC_FORM = "/pgc-form";

    boolean IS_PRIVATE_LAYOUT = Boolean.FALSE;

    String EXPANDO_MANAGER_ID = PropsUtil.get("sap.Emp.customAttribute.name.supervisorEmployeeId");
    String EXPANDO_DEFAULT_TABLE = "DEFAULT_TABLE";
    String EXPANDO_EMPLOYEE_ID = PropsUtil.get("sap.emp.customattribute.name.employee.id");
    String EXPANDO_DEPARTMENT = PropsUtil.get("sap.Emp.customAttribute.name.department");
    String EXPANDO_TERRORITY_CODE = PropsUtil.get("sap.emp.customattribute.name.territory.code");
    String EXPANDO_TERRORITY = PropsUtil.get("sap.Emp.customAttribute.name.territory");
    String EXPANDO_COST_CENTER = PropsUtil.get("sap.Emp.customAttribute.name.costCenter");
    String[] PGC_SUPERVISOR_GROUPS = PortletProps.get("supervisor.usergroups.name").split(StringPool.COMMA);
    String[] PGC_MANAGER_GROUPS = PortletProps.get("supervisor.usergroups.name").split(StringPool.COMMA);

    String APPLICATION_DATE_FORMAT = "MM/dd/yyyy";
    DateFormat APPLICATION_DATE_FORMATTER = new SimpleDateFormat(APPLICATION_DATE_FORMAT);

    String TEMP_DIR = "java.io.tmpdir";
    String CONTENT_REQUIRED_T = "T";
    String CONTENT_REQUIRED_F = "F";

    String BASE_URL = PortletProps.get("base-url");
    String DCTM_AUTH_HEADER_VAL = PortletProps.get("dctm-auth-header-val");
    String DCTM_CLIENT_HEADER_VAL = PortletProps.get("dctm-client-header-val");
    String REPOSITORY_NAME = PortletProps.get("repository-name");
    String AUTH_HEADER = PortletProps.get("auth-header");
    int SUCCESS_STATUS_CODE = 200;
    String REST_CLIENT_HEADER = PortletProps.get("rest-client-header");
    String START_INDEX = PortletProps.get("start-index");
    String END_INDEX = PortletProps.get("end-index");
    String TYPE_NAME = PortletProps.get("type-name");
    String MAX_RESULTS = PortletProps.get("max-results");
    String DOCUMENT_CONTENT_REQUIRED_QRY = "/documents/pgccreate.xml?contentRequired=";

    String DISPLAY_EXHIBIT_COST = PortletProps.get("display.exhibit.budget.costcenter");
    String PO_MEMBER_GLACC = PortletProps.get("pomember.budget");
    String[] PGC_STATUS_EDIT_ALLOWED = PortletProps.getArray("statusEdit");
    String STATUS_APPROVED = PortletProps.get("approved");
    // Field name is used in the annocation class to map number property to boolean property.
    List<String> FIELD_NAMES = Arrays.asList(PortletProps.getArray("radio.number.to.boolean.fields"));
    
    int FORM_TYPES = 0;
    int FIELD_SALES_EMPLOYEE = 1;
    int HOME_OFFICE_EMPLOYEE = 2;
}
