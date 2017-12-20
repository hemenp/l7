package com.dsi.intranet.pgc.persistence.documentum.readers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.GeneralRequestInformation;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

public class GeneralRequestInformationReader extends BlockInfoReader{

	@Override
	public void parseResponsePart(Document xmlRespDoc,
			Map<String, List<DocumentumFile>> existingFilesByType,
			Object objToPopulate) {

		if (!(objToPopulate instanceof GeneralRequestInformation)) {
			throw new IllegalArgumentException(
					"objToPopulate to GeneralRequestInfoReader should be a GeneralRequestInformation block!");
		}
		if (xmlRespDoc != null) {
			GeneralRequestInformation infoObj = (GeneralRequestInformation) objToPopulate;

			Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
			DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
		}
		
	}

}
