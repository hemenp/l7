package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.GeneralRequestInformation;

public class GeneralRequestInformationWriter extends BlockInfoWriter{

	@Override
	public String createRequestPart(Object dataObject) {
		
		if (!(dataObject instanceof GeneralRequestInformation)) {
			
			throw new IllegalArgumentException("");
		
		}
		
		return DocumentumAnnotationProcessor.beanDataToXmlStr(dataObject);
	}

}
