/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumConstants;
import com.dsi.intranet.pgc.portlet.constants.PGCFormType;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * <a href="FormCommonInformationWriter.java"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Resmy Mathew
 * @Description
 * @ChangeLog:
 * Name             |       Date        |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 06 2012		|	Modified to Pass Object Name while updating the record
 */
public class FormCommonInformationWriter extends BlockInfoWriter
{

    private Map<PGCFormType, String> formTypeToDocumentumObjName = null;

    public FormCommonInformationWriter()
    {
        formTypeToDocumentumObjName = new HashMap<PGCFormType, String>();
        formTypeToDocumentumObjName.put(PGCFormType.DispExhibit, "Test Display Exhibit");
        formTypeToDocumentumObjName.put(PGCFormType.AdvBoard, "Test Advisory Board");
    }
    @Override
    public String createRequestPart(Object dataObject)
    {
        if (!(dataObject instanceof PGCForm))
        {
            throw new IllegalArgumentException("dataObject to FormInfoWriter should be a PGCForm!");
        }
        PGCForm formObj = (PGCForm) dataObject;

        StringBuilder xmlResultBuf = new StringBuilder();
        //DSI:START::Veera Reddy:: To pass the object name while editing the record 
        String formTypeName = null;
        if(Validator.isNotNull(formObj.getObjectName())){
        	formTypeName = formObj.getObjectName();
        }else {
        	formTypeName = formTypeToDocumentumObjName.get(formObj.getFormType());
        }
        //DSI:END::Veera Reddy:: To pass the object name while editing the record 
        if (!Validator.isNull(formTypeName))
        {
            xmlResultBuf.append("<" + DocumentumConstants.XMLPropertyTypes.STRING_PROP + ">").append(
                    DocumentumConstants.XMLElements.NAME_ELEMENT_BEGIN).append("object_name").append(
                    DocumentumConstants.XMLElements.NAME_ELEMENT_END).append(
                    DocumentumConstants.XMLElements.VALUE_ELEMENT_BEGIN).append(StringEscapeUtils.escapeXml(formTypeName)).append(
                    DocumentumConstants.XMLElements.VALUE_ELEMENT_END).append(
                    "</" + DocumentumConstants.XMLPropertyTypes.STRING_PROP + ">");
        }
        xmlResultBuf.append(DocumentumAnnotationProcessor.beanDataToXmlStr(dataObject));
        return xmlResultBuf.toString();
    }

}
