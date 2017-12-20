package com.dsi.intranet.pgc.persistence.documentum.readers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.CharitableDonationInformation;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

public class CharitableDonationInformationReader extends BlockInfoReader {

	@Override
	public void parseResponsePart(Document xmlRespDoc,
			Map<String, List<DocumentumFile>> existingFilesByType,
			Object objToPopulate) {
		
		if (!(objToPopulate instanceof CharitableDonationInformation)) {
			throw new IllegalArgumentException(
					"objToPopulate to CharitableDonationInfoReader should be a CharitableDonation block!");
		}
		if (xmlRespDoc != null) {
			CharitableDonationInformation infoObj = (CharitableDonationInformation) objToPopulate;

			Element propertiesElem = (Element) xmlRespDoc.selectSingleNode("//objects/object/properties");
			DocumentumAnnotationProcessor.beanDataFromXml(infoObj, propertiesElem, existingFilesByType);
		}

	}

}
