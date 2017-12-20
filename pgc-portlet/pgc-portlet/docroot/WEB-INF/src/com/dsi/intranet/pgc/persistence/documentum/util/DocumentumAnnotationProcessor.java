/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.persistence.documentum.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.util.DropDownUtil;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="DocumentumAnnotationProcessor.java.html"><b><i>View Source</i></b></a>
 *
 * @project PGC
 * @author Devaki Subramaniam
 * @Description
 * @ChangeLog:
 * Name       	    |Date 	            |       Reason
 * ---------------------------------------------------------------------------------
 * Veera Reddy		|	Aug 22 2012		|	Modified To make unique attachment name for single submition
 */
public final class DocumentumAnnotationProcessor
{

    private static final String UNCHECKED = "unchecked";
	private static final Log LOGGER = LogFactoryUtil.getLog(DocumentumAnnotationProcessor.class);

    public static void beanDataFromXml(Object bean, Element xmlPropsElem, Map<String, List<DocumentumFile>> filesByType)
    {
        if (filesByType == null)
        {
            filesByType = new HashMap<String, List<DocumentumFile>>();
        }
        beanDataFromXml(bean, StringPool.BLANK, xmlPropsElem, filesByType);
    }

    public static void beanDataFromXml(Object bean, String prefixToUse, Element xmlPropsElem,
            Map<String, List<DocumentumFile>> filesByType)
    {
        if (Validator.isNotNull(bean) && Validator.isNotNull(xmlPropsElem))
        {
            BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
            Field[] members = wrapper.getWrappedClass().getDeclaredFields();
            List<String> fieldNames = PGCCommonConstants.FIELD_NAMES;
            for (Field f : members)
            {
                DocumentumPropertyMapping m = f.getAnnotation(DocumentumPropertyMapping.class);
                if (Validator.isNotNull(m))
                {
                    Class propClass = f.getType();
                    if (Iterable.class.isAssignableFrom(propClass))
                    {
                        Type t = f.getGenericType();
                        if (t instanceof ParameterizedType
                                && ((ParameterizedType) t).getActualTypeArguments().length > 0)
                        {
                            Class listMemberClass = (Class) ((ParameterizedType) t).getActualTypeArguments()[0];
                            boolean listMemberIsDate = Date.class.isAssignableFrom(listMemberClass);
                            String propTypeName = m.mapToType();

                            // mapping to Numberproperty for radiobutton
                            // response fields
                            if (Validator.isNotNull(fieldNames) && fieldNames.contains(f.getName()))
                            {
                                propTypeName = DocumentumConstants.XMLPropertyTypes.NUMBER_PROP_CAMEL_CASE;
                            }

                            if (propTypeName.length() == 0)
                            {
                                propTypeName = isNumericType(listMemberClass) ? DocumentumConstants.XMLPropertyTypes.NUMBER_LIST_PROP_CAMEL_CASE
                                        : listMemberClass.getSimpleName() + "ArrayProperty";
                            } else if (propTypeName.equals(DocumentumConstants.XMLPropertyTypes.NUMBER_PROP))
                            {
                                propTypeName = DocumentumConstants.XMLPropertyTypes.NUMBER_PROP_CAMEL_CASE;
                            }
                            String propXPath = propTypeName + "[" + DocumentumConstants.XMLElements.NAME + "=\""
                                    + prefixToUse + m.name() + "\"]/" + DocumentumConstants.XMLElements.VALUES;
                            Element matchingElem = (Element) xmlPropsElem.selectSingleNode(propXPath);
                            if (matchingElem != null)
                            {
                                List<Node> valueNodes = matchingElem.selectNodes(DocumentumConstants.XMLElements.VALUE);
                                if (valueNodes != null)
                                {
                                    List<Object> values = new ArrayList<Object>(valueNodes.size());
                                    for (Node n : valueNodes)
                                    {
                                        Object propVal = StringEscapeUtils.unescapeXml(((Element) n).getText());
                                        if (listMemberIsDate)
                                        {
                                            try
                                            {
                                                propVal = DocumentumDateConverter.parse((String) propVal);
                                            } catch (ParseException e)
                                            {
                                                LOGGER.error("Got ParseException when parsing date " + propVal
                                                        + ". Skipping from adding to list." + e.getMessage(), e);
                                                propVal = null;
                                            }
                                        }

                                        // mapping 1 to true and 0 to false
                                        if (Validator.isNotNull(fieldNames) && fieldNames.contains(f.getName()))
                                        {
                                            if (propVal.equals("1"))
                                            {
                                                propVal = "true";
                                            } else
                                            {
                                                propVal = "false";
                                            }
                                        }
                                        values.add(propVal);
                                    }

                                    // other product value
                                    if (m.name().equalsIgnoreCase("pgc_product"))
                                    {
                                        String[] products = DropDownUtil.getProductList();
                                        List<String> productList = Arrays.asList(products);
                                        for (Object productValue : values)
                                        {
                                            boolean notOther = productList.contains(productValue.toString());
                                            if (!notOther)
                                            {
                                                wrapper.setPropertyValue("otherMaterial", productValue.toString());
                                            }
                                        }
                                    } else if (m.name().equalsIgnoreCase("pgc_therapeutic_area"))
                                    {
                                        String[] therapeuticAreas = DropDownUtil.getTherapeuticArea();
                                        List<String> therapeuticAreaList = Arrays.asList(therapeuticAreas);
                                        for (Object therapeuticValue : values)
                                        {
                                            boolean notOther = therapeuticAreaList
                                                    .contains(therapeuticValue.toString());
                                            if (!notOther)
                                            {
                                                wrapper.setPropertyValue("otherTherapeutic",
                                                        therapeuticValue.toString());
                                            }
                                        }
                                    }

                                    wrapper.setPropertyValue(f.getName(), values);
                                }
                            }
                        }
                    } else
                    {
                        String propTypeName = m.mapToType();
                        // mapping to Numberproperty for radiobutton response
                        // fields
                        if (Validator.isNotNull(fieldNames) && fieldNames.contains(f.getName()))
                        {
                            propTypeName = DocumentumConstants.XMLPropertyTypes.NUMBER_PROP_CAMEL_CASE;
                        }

                        if (propTypeName.length() == 0)
                        {
                            propTypeName = isNumericType(propClass) ? DocumentumConstants.XMLPropertyTypes.NUMBER_PROP_CAMEL_CASE
                                    : propClass.getSimpleName() + "Property";
                        } else if (propTypeName.equals(DocumentumConstants.XMLPropertyTypes.NUMBER_PROP))
                        {
                            propTypeName = DocumentumConstants.XMLPropertyTypes.NUMBER_PROP_CAMEL_CASE;
                        }

                        String propXPath = propTypeName + "[" + DocumentumConstants.XMLElements.NAME + "=\""
                                + prefixToUse + m.name() + "\"]/" + DocumentumConstants.XMLElements.VALUE;
                        Element matchingElem = (Element) xmlPropsElem.selectSingleNode(propXPath);
                        if (Validator.isNotNull(matchingElem))
                        {
                            Object propVal = StringEscapeUtils.unescapeXml(matchingElem.getText());
                            if (Date.class.isAssignableFrom(propClass))
                            {
                                // Need to parse dates ...
                                try
                                {
                                    propVal = DocumentumDateConverter.parse((String) propVal);
                                } catch (ParseException e)
                                {
                                    LOGGER.error("Got ParseException when parsing date " + propVal
                                            + ". Skipping set value for property: " + f.getName() + e.getMessage(), e);
                                    propVal = null;
                                }
                            }

                            // mapping 1 to true and 0 to false
                            if (Validator.isNotNull(fieldNames) && fieldNames.contains(f.getName()))
                            {
                                if (propVal.equals("1"))
                                {
                                    propVal = "true";
                                } else
                                {
                                    propVal = "false";
                                }
                            }
                            wrapper.setPropertyValue(f.getName(), propVal);
                        }
                    }
                } else
                {
                    DocumentumEmbeddedPropertyMapping em = f.getAnnotation(DocumentumEmbeddedPropertyMapping.class);
                    if (Validator.isNotNull(em))
                    {
                        String prefix = prefixToUse + em.prefixName();
                        Object embeddedMem = wrapper.getPropertyValue(f.getName());
                        beanDataFromXml(embeddedMem, prefix, xmlPropsElem, filesByType);
                    } else
                    {
                        DocumentumFileReadMapping fm = f.getAnnotation(DocumentumFileReadMapping.class);
                        if (Validator.isNotNull(fm))
                        {
                            String fileAttachmentType = fm.attachmentType();
                            List<DocumentumFile> files = filesByType.get(fileAttachmentType);
                            if (Validator.isNotNull(files))
                            {
                            	//DSI:START::Veera Reddy:: To make unique attachment name for single submition
                            	List<DocumentumFile> modfiles = new ArrayList<DocumentumFile>();
                            	for(DocumentumFile df:files){
                            		df.setFileName(df.getFileName().replaceFirst(fileAttachmentType+StringPool.UNDERLINE, StringPool.BLANK));
                            		modfiles.add(df);
                            	}
                                wrapper.setPropertyValue(f.getName(), modfiles);
                               //DSI:END::Veera Reddy:: To make unique attachment name for single submition
                            } else
                            {
                                // setting empty list to fix files populate
                                // issue
                                List<DocumentumFile> documentumFiles = new ArrayList<DocumentumFile>();
                                wrapper.setPropertyValue(f.getName(), documentumFiles);
                            }
                        }
                    }
                }
            }
        }
    }

    public static String beanDataToXmlStr(Object bean)
    {
        return beanDataToXmlStr(bean, StringPool.BLANK);
    }

    @SuppressWarnings(UNCHECKED)
    public static String beanDataToXmlStr(Object bean, String prefix)
    {
        String xmlStr = StringPool.BLANK;
        if (Validator.isNotNull(bean))
        {
            BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
            Field[] members = wrapper.getWrappedClass().getDeclaredFields();
            StringBuilder xmlStrBuf = new StringBuilder();
            for (Field f : members)
            {
                DocumentumPropertyMapping m = f.getAnnotation(DocumentumPropertyMapping.class);
                DocumentumEmbeddedPropertyMapping em = f.getAnnotation(DocumentumEmbeddedPropertyMapping.class);
                Object val = null;
                if (Validator.isNotNull(m) || Validator.isNotNull(em))
                {
                    val = wrapper.getPropertyValue(f.getName());
                }

                boolean fieldProcessed = Validator.isNotNull(m);
                if (Validator.isNotNull(m) && val != null) // TODO: Use
                {
                    String propTypeElem = m.mapToType();
                    Class propClass = f.getType();
                    if (Iterable.class.isAssignableFrom(propClass))
                    {
                        Type t = f.getGenericType();
                        if (t instanceof ParameterizedType
                                && ((ParameterizedType) t).getActualTypeArguments().length > 0)
                        {
                            Class listMemberClass = (Class) ((ParameterizedType) t).getActualTypeArguments()[0];
                            StringBuilder valsBuf = new StringBuilder();
                            boolean listMemberIsDate = Date.class.isAssignableFrom(listMemberClass);
                            for (Object listItem : (Iterable) val)
                            {
                                if (listItem != null)
                                {
                                    String formattedVal = listMemberIsDate ? DocumentumDateConverter
                                            .format(listItem) : String.valueOf(listItem);
                                    valsBuf.append(DocumentumConstants.XMLElements.VALUE_ELEMENT_BEGIN)
                                            .append(StringEscapeUtils.escapeXml(formattedVal))
                                            .append(DocumentumConstants.XMLElements.VALUE_ELEMENT_END);
                                }
                            }
                            String valsStr = valsBuf.toString();
                            if (valsStr.length() > 0)
                            {
                                if (propTypeElem.length() == 0)
                                {
                                    propTypeElem = isNumericType(listMemberClass) ? DocumentumConstants.XMLPropertyTypes.NUMBER_LIST_PROP
                                            : listMemberClass.getSimpleName().toLowerCase() + "ArrayProperty";
                                }
                                xmlStrBuf.append("<").append(propTypeElem).append(">")
                                        .append(DocumentumConstants.XMLElements.NAME_ELEMENT_BEGIN).append(prefix)
                                        .append(m.name()).append(DocumentumConstants.XMLElements.NAME_ELEMENT_END)
                                        .append(DocumentumConstants.XMLElements.VALUES_ELEMENT_BEGIN).append(valsStr)
                                        .append(DocumentumConstants.XMLElements.VALUES_ELEMENT_END).append("</")
                                        .append(propTypeElem).append(">");
                            }
                        }
                    } else
                    {
                        String formattedVal = Date.class.isAssignableFrom(propClass) ? DocumentumDateConverter
                                .format(val) : String.valueOf(val);
                        if (propTypeElem.length() == 0)
                        {
                            propTypeElem = isNumericType(propClass) ? DocumentumConstants.XMLPropertyTypes.NUMBER_PROP
                                    : propClass.getSimpleName().toLowerCase() + "Property";
                        }
                        String valuePrefix = DocumentumConstants.XMLPropertyTypes.NUMBER_PROP.equals(propTypeElem) ? "<value type=\""
                                + getNumericTypeName(propClass) + "\">"
                                : DocumentumConstants.XMLElements.VALUE_ELEMENT_BEGIN;
                        xmlStrBuf.append("<").append(propTypeElem).append(">")
                                .append(DocumentumConstants.XMLElements.NAME_ELEMENT_BEGIN).append(prefix)
                                .append(m.name()).append(DocumentumConstants.XMLElements.NAME_ELEMENT_END)
                                .append(valuePrefix).append(StringEscapeUtils.escapeXml(formattedVal))
                                .append(DocumentumConstants.XMLElements.VALUE_ELEMENT_END).append("</")
                                .append(propTypeElem).append(">");
                    }
                }

                if (!fieldProcessed && Validator.isNotNull(em))
                {
                    String prefixToUse = prefix + em.prefixName();
                    xmlStrBuf.append(beanDataToXmlStr(val, prefixToUse));
                    fieldProcessed = true;
                }
            }
            xmlStr = xmlStrBuf.toString();
        }
        return xmlStr;
    }

    @SuppressWarnings(UNCHECKED)
    public static String beanFilesToXml(String filePathParam, Object[] fileContainerBeans,
            List<CommonsMultipartFile> allFilesList)
    {
        String fileTypeName = DocumentumConstants.XMLElements.FILETYPE;
        StringBuilder xmlStrBuf = new StringBuilder();
        MultiValueMap<String, CommonsMultipartFile> fileTypeToFiles = new LinkedMultiValueMap<String, CommonsMultipartFile>();
        if (fileContainerBeans != null && allFilesList != null)
        {
            for (Object infoBean : fileContainerBeans)
            {
                if (infoBean != null)
                {
                    BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(infoBean);
                    Field[] members = wrapper.getWrappedClass().getDeclaredFields();
                    for (Field f : members)
                    {
                        DocumentumFileWriteMapping fm = f.getAnnotation(DocumentumFileWriteMapping.class);
                        if (fm != null)
                        {
                            Object val = wrapper.getPropertyValue(f.getName());
                            Class propClass = f.getType();
                            if (Validator.isNotNull(val) && Iterable.class.isAssignableFrom(propClass))
                            {
                                try
                                {
                                    for (CommonsMultipartFile file : (Iterable<CommonsMultipartFile>) val)
                                    {
                                        if (!file.isEmpty())
                                        {
                                            fileTypeToFiles.add(fm.attachmentType(), file);
                                        }
                                    }
                                } catch (ClassCastException cce)
                                {
                                    LOGGER.error(
                                            "Got Class cast exception, while casting Object to List of CommonsMultipartFile! Skipping XML conversion of member "
                                                    + f.getName() + cce.getMessage(), cce);
                                }
                            } else if (Validator.isNotNull(val)
                                    && CommonsMultipartFile.class.isAssignableFrom(propClass))
                            {
                                CommonsMultipartFile file = (CommonsMultipartFile) val;
                                if (!file.isEmpty())
                                {
                                    fileTypeToFiles.add(fm.attachmentType(), file);
                                }
                            }
                        }
                    }
                }
            }
            allFilesList.clear();
            for (Entry<String, List<CommonsMultipartFile>> fileType : fileTypeToFiles.entrySet())
            {
                for (CommonsMultipartFile f : fileType.getValue())
                {
                    allFilesList.add(f);
                  //DSI:START::Veera Reddy:: To make unique attachment name for single submition
                    xmlStrBuf.append(DocumentumConstants.FILE_OBJ_XML.format(new String[] { fileTypeName,
                            filePathParam, StringEscapeUtils.escapeXml(f.getOriginalFilename()), fileType.getKey() }));
                  //DSI:END::Veera Reddy:: To make unique attachment name for single submition
                }
            }
        }
        return xmlStrBuf.toString();
    }

    @SuppressWarnings(UNCHECKED)
    private static String getNumericTypeName(Class numericClass)
    {
        String typeName = numericClass.getSimpleName();
        if (numericClass.isPrimitive())
        {
            typeName = numericClass.getSimpleName();
        } else if (Integer.class.isAssignableFrom(numericClass))
        {
            typeName = Integer.TYPE.getSimpleName();
        } else if (Long.class.isAssignableFrom(numericClass))
        {
            typeName = Long.TYPE.getSimpleName();
        } else if (Float.class.isAssignableFrom(numericClass))
        {
            typeName = Float.TYPE.getSimpleName();
        } else if (Double.class.isAssignableFrom(numericClass))
        {
            typeName = Double.TYPE.getSimpleName();
        }
        return typeName;
    }

    @SuppressWarnings(UNCHECKED)
    private static boolean isNumericType(Class c)
    {
        return int.class.equals(c) || long.class.equals(c) || float.class.equals(c) || double.class.equals(c)
                || Number.class.isAssignableFrom(c);
    }

    private DocumentumAnnotationProcessor()
    {
    }
}
