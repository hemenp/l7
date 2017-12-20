/**
 * Copyright © 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.pgc.portlet.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.liferay.portal.kernel.util.StringUtil;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.multipart.CommonsPortletMultipartResolver;

/**
 * <a href="PGCPortletMultipartResolver.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project PGC
 * @Author Resmy Mathew
 * @Description PGCPortletMultipartResolver class for pgc.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public class PGCPortletMultipartResolver extends CommonsPortletMultipartResolver
{

    @Override
    protected MultipartParsingResult parseFileItems(List fileItems, String encoding)
    {
        MultipartParsingResult result = super.parseFileItems(fileItems, encoding);
        MultiValueMap<String, MultipartFile> filesMap = result.getMultipartFiles();
        Set<String> fileNameParamKeys = filesMap.keySet();
        if (fileNameParamKeys != null && fileNameParamKeys.size() > 0)
        {
            Set<String> fileNameParamKeysDup = new HashSet<String>(fileNameParamKeys);
            for (String fileNameParam : fileNameParamKeysDup)
            {
                List<MultipartFile> filesList = filesMap.remove(fileNameParam);
                fileNameParam = StringUtil.replace(fileNameParam, "_", ".");
                filesMap.put(fileNameParam, filesList);
            }
        }
        return result;
    }

}
