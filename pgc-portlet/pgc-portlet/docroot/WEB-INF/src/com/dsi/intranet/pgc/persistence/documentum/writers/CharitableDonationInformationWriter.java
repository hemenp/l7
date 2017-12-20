package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.portlet.model.CharitableDonationInformation;

public class CharitableDonationInformationWriter extends BlockInfoWriter {

	@Override
	public String createRequestPart(Object dataObject) {
		
		if (!(dataObject instanceof CharitableDonationInformation)) {
		
			throw new IllegalArgumentException("");
		
		}
		
		return DocumentumAnnotationProcessor.beanDataToXmlStr(dataObject);
	}

}
