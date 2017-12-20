/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.util;

import java.text.MessageFormat;

/**
 * <a href="DocumentumConstants.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name                         |       Date                    |       Reason
 * ---------------------------------------------------------------------------------
 */
public interface DocumentumConstants
{
    public interface FilePaths
    {
        String ADVISORY_PATH = "/LCA/PGC/Advisory Board Program";
        String CORPORATEUPPORT_PATH = "/LCA/PGC/Corporate Support 3rd Party Professional Org";
        String DISPLAY_PATH = "/LCA/PGC/Display Exhibit";
        String EDUCATIONAL_PATH = "/LCA/PGC/Educational Items of Value";
        String HCPCONSULTANT_PATH = "/LCA/PGC/HCP Consultant";
        String POMEMBERSHIP_PATH = "/LCA/PGC/Professional Organization Membership";
        String SERVICEAGREMENT_PATH = "/LCA/PGC/Service Agreement with Customer";
        String CHARITYDONATION_PATH = "/LCA/PGC/Charitable Contribution";
        String GENERALREQUEST_PATH = "/LCA/PGC/General Request";
    }

    public interface XMLElements
    {
        String FILETYPE = "dsi_pgc_attachment";
        String NAME = "name";
        String NAME_ELEMENT_BEGIN = "<name>";
        String NAME_ELEMENT_END = "</name>";
        String OBJECT = "object";
        String OBJECT_ELEMENT_BEGIN = "<object>";
        String OBJECT_ELEMENT_END = "</object>";
        String OBJECTS = "objects";
        String PROPERTY_ELEMENT_BEGIN = "<properties>";
        String PROPERTY_ELEMENT_END = "</properties>";
        String VALUE = "value";
        String VALUE_ELEMENT_BEGIN = "<value>";
        String VALUE_ELEMENT_END = "</value>";
        String VALUES = "values";
        String VALUES_ELEMENT_BEGIN = "<values>";
        String VALUES_ELEMENT_END = "</values>";

    }

    public interface XMLPropertyTypes
    {
        String BOOLEAN_PROP = "booleanProperty";
        String DATE_PROP = "dateProperty";
        String NUMBER_LIST_PROP = "numberArrayProperty";
        String NUMBER_LIST_PROP_CAMEL_CASE = "NumberArrayProperty";
        String NUMBER_PROP = "numberProperty";
        String NUMBER_PROP_CAMEL_CASE = "NumberProperty";
        String STRING_LIST_PROP = "stringArrayProperty";
        String STRING_PROP = "stringProperty";
    }

    MessageFormat FILE_OBJ_XML = new MessageFormat(
            "<object><name>Test Attachment</name><type>{0}</type><path>{1}</path><properties>"
                    + "<stringProperty><name>object_name</name><value>{2}</value></stringProperty>"
                    + "<stringProperty><name>pgc_attachment_type</name><value>{3}</value></stringProperty></properties></object>");
    MessageFormat XML_FORM_OBJECT_FORMAT = new MessageFormat(
            "<object><name>{0}</name><type>{1}</type><path>{2}</path><properties>");

    String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<objects xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"..\\..\\..\\jaxb-ri-20091104\\bin\\SysObjectRequest.xsd\">";

    String XML_SUFFIX = "</objects>";

}
