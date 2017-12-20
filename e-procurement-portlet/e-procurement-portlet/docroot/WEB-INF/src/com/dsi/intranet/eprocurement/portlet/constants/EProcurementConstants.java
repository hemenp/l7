/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.constants;

import java.util.Date;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.WorkflowRequest;
import com.dsi.intranet.eprocurement.model.WorkflowReview;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.portlet.PortletProps;

/**
 * 
 * @author jay.patel
 * @ChangeLog:
 * Name				|	Date			| 	Reason
 * --------------------------------------------------------------------------------------------------------------------------
 * Veera Reddy		|	May 14, 2012	|	modified to fix the redirect issue in prod - LRPS-244,LRPS-245
 */

public interface EProcurementConstants {

        String STATUS_NEW = "NEW";
        String STATUS_LEVEL1_APPROVED = "Level1 Approved";
        String STATUS_WORKFLOW_ASSIGNED = "WORKFLOW ASSIGNED";
        String STATUS_SUBMITTED = "SUBMITTED";
        String STATUS_APPROVED = "APPROVED";
        String STATUS_DECLINED = "DECLINED";
        String STATUS_INPROCESS = "INPROCESS";
        String STATUS_CANCELLED = "CANCELLED";
        String STATUS_COMPLETED = "COMPLETED";
        
        String[] ARRAY_STATUS = {STATUS_NEW, STATUS_LEVEL1_APPROVED, STATUS_WORKFLOW_ASSIGNED,
            STATUS_INPROCESS, STATUS_CANCELLED, STATUS_COMPLETED};
        
        String PARAM_STATUS = "status";
        String PARAM_CITY = "city";
        String PARAM_ADDRESS = "address";
        String PARAM_USERID = "userId";
        String PARAM_START_DATE = "searchStartDate";
        String PARAM_END_DATE = "searchEndDate";
        String PARAM_VALUE_SELECT = "--Select--";
        String PURCHASE_REQUEST_PORTLET_ID = "purchase-request";
        
        String CLASS_NAME_EPROCUREMENT_REQUEST = EprocurementRequest.class.getName();    
        String CLASS_NAME_WF_REVIEW = WorkflowReview.class.getName();
        String CLASS_NAME_WF_REQUEST = WorkflowRequest.class.getName();
        
        String PURCHASE_ORDER_NUMBER ="poNumber";
        String VENDOR_NAME ="vendorName";
        String ADDRESS ="address";
        String CURRENT_STATUS ="currentStatus";
        String REASON ="reason";
        String NOTES ="notes";
        String PROJECT_NAME ="projectName";
        String CONTRACT_ID ="contractId";
        String ITEM_ID ="itemId";
        String ITEM_NAME ="itemName";
        String ITEM_DESCRIPTION ="itemDescription";
        String REQUESTOR_ID ="requestorId";
        String REQUEST_ID ="requestId";
        String KEYWORDS ="keywords";
        String ITEM_NAME_DESC ="itemNameDesc";
        String EPROCURE_USER ="eprocureUser";
        String SHIP_TO_OTHER ="shipToOther";
        String STAGE = "stage";
        String STAGE_USER = "stageUser";
        String STAGE_USER_ID = "stageUserId";
        String PONUMBER="PONumber";
        
        int REQUEST_DASHBOARD_DEFAULT_DELTA = 10;
        
        String EPROCUREMENT_ROLE_WEB_ADMIN = "E-Procurement-Web-Admin";
        String EPROCUREMENT_ROLE_PROJECT_SPEND = "E-Procurement-Project-Spend";
        
        String FRIENDLY_URL_REQUEST_DASHBOARD = "/request-dashboard";
        String FRIENDLY_URL_WF_DEFINITION = "/workflow-definition";
        String FRIENDLY_URL_REQUEST_DETAILS = "/request-details";
        //BEGIN::veera reddy::modified to fix the redirect issue in prod
        String PORTLET_NAME_REQUEST_DETAILS = "purchaserequest_WAR_eprocurementportlet";
        String PORTLET_NAME_REQUEST_DASHBOARD = "requestdashboard_WAR_eprocurementportlet";
      //END::veera reddy::modified to fix the redirect issue in prod
        String PARAM_ACTION_SHOW_REQUEST = "&eProcAction=";
        String PARAM_ACTION_NAME_SHOW_REQUEST = "showSavedRequest";
        String PARAM_REQUEST_ID = "&requestId=";
        String PARAM_REPORTS = "&reports=1";
        
        String INPUT_DATE_FORMAT = "MM/dd/yyyy";
        String YEAR = "yyyy";
        String MONTH = "MM";
        String DAY = "dd";
        String MIN_TIME = "000001";
        String MAX_TIME = "235959";
        String REQUEST_OPEN ="Open";
        String REQUEST_CLOSED ="Closed";
        
        Date CURRENT_DATE = new Date();
        boolean IS_PRIVATE_LAYOUT = Boolean.FALSE;
        
        String EPROCURE_FOLDER_NAME ="eprocurement";
        
        String SHIP_TO_OTHER_PARAM = "Other";
        String SHIP_TO_OTHER_VALUE = "YES";
        String SHIP_TO_OTHER_COL = "shipToOther";
        
        String ACTION_DECLINE = "DECLINE";
        String EXPANDO_SUPERVISOR_ID = PropsUtil.get("sap.Emp.customAttribute.name.supervisorEmployeeId"); // to do to read it from property file
        String EXPANDO_DEFAULT_TABLE = ExpandoTableConstants.DEFAULT_TABLE_NAME;
        String EXPANDO_EMPLOYEE_ID =PropsUtil.get("sap.emp.customattribute.name.employee.id");
        String GLACCOUNT_APPLICATIONNAME = "e-procurement ";
        String GROUP_NAME = "eprocu_project_managers ";
        String SUPERVISOR_GROUP = "eprocu_supervisors ";
        String PATH_CREATE = "com/dsi/intranet/eprocurement/email/templates/";
        String EMAIL_NOTIFICATION_BODY_TEMPLATE = PATH_CREATE.concat("create_request_body.tmpl");
        String CHANGE_REQUEST_NOTIFICATION_BODY_TEMPLATE = PATH_CREATE.concat("edit_request_body.tmpl");
        String CHANGE_REQUEST_FOR_PREV_APPROVER_BODY_TEMPLATE = PATH_CREATE.concat("edit_previous_approver_body.tmpl");
        String EMAIL_NOTIFICATION_SUBJECT_TEMPLATE = PATH_CREATE.concat("create_subject.tmpl");
        String EMAIL_REQUESTOR_BODY_TEMPLATE = PATH_CREATE.concat("email_requestor_body.tmpl");
        String EMAIL_REQUESTOR_SUBJECT_TEMPLATE = PATH_CREATE.concat("email_requestor_subject.tmpl");
                
        String EPROC_INTIAL_APPROVED_EMAIL_BODY_TEMPLATE = PATH_CREATE.concat("eproc_initial_approved_request.tmpl");
        String EPROC_FIN_APPROVED_EMAIL_BODY_TEMPLATE = PATH_CREATE.concat("eproc_final_approved_request.tmpl");
        String EPROC_INTIAL_APPROVED_EMAIL_SUBJECT = "E-Procurement Purchase Request Approval:";
        String EPROC_FINAL_APPROVED_EMAIL_SUBJECT = "E-Procurement Purchase Request Approval:";
        String EPROC_EMAIL_FROM_ADDRESS = "isprocurement@dsi.com";
        String EPROC_EMAIL_FROM_NAME = "eProcurement-Admin";
        
        String MSG_SUBMITTED_APPROVED = "SUBMITTED & APPROVED";
        String MSG_PENDING_APPROVAL = "PENDING FOR APPROVAL";
        String ITEM_IN_STOCK="Instock";
        String ITEM_NOT_IN_STOCK="Not Instock";
        
        String CREATED_DATE="createdDate";
        String REDIRECT = "redirect";
        int NUMBER_23 = 23;
        
        String ORDER_BY_COLUMN = "orderByCol";
        String ORDER_BY_TYPE = "orderByType";
        String EPROCUREMENT_NAME_SPACE = "eprocurement";
        String YES="Yes";
        
        String EPROC_CANCELLED_REQUEST_SUBJECT = "E-Procurement Purchase Request Cancellation :";
        String EPROC_CANCELLED_REQUEST_BODY_TEMPLATE = PATH_CREATE.concat("eproc_canceled_request.tmpl");
        String NOT_AVAILABLE = "N/A";
        String LINE_BREAK="&#10;";
        
        String EPROC_STAGE_APPROVER_NOTIFCATION_SUBJECT= "E-Procurement Purchase Request Approval:";
        String EPROC_STAGE_APPROVER_NOTIFCATION_BODY_TEMPLATE =PATH_CREATE.concat("epro_stage_approvers_notification.tmpl");
        
        /**
         * For Eprocurement Supervisor change
         */
        
        String[] EPROC_SUPERVISOR_GROUPS = PortletProps.get("supervisor.usergroups.name").split(StringPool.COMMA);
        
        String[] DL_USER_FILE_PERMISSION = PortletProps.get("default.eproc.user.documentlibrary.filepermission").split(StringPool.COMMA);
        
        String REMINDER_MSG = "REMINDER :";
        //BEGIN::veera reddy::modified to fix the redirect issue in prod
        String FOLLOW_UP_STOCK_SUCESS_MESSAGE = PortletProps.get("follow.up.stcck.success.message");
        String FOLLOW_UP_STOCK_ERROR_MESSAGE = PortletProps.get("follow.up.stcck.error.message");
        //END::veera reddy::modified to fix the redirect issue in prod
        String EPROCUREMENT_LOCATION_APPNAME =  PortletProps.get("eprocurement.location.appname");
        
        String REQUESTID_VAR = "[$requestId]";
        String REQUESTNAME_VAR = "[$requestorName]";
        String VIEWREQUEST_VAR = "[$viewRequest]";
        String SUCCESS_MESSAGE = "sucessMessage";
        String ERROR_MESSAGE = "errorMessage";
        
        int NUMBER_25 = 25;
        int NUMBER_15 = 15;
        int NUMBER_12 = 12;
        int NUMBER_8 = 8;
        
}
