package com.dsi.intranet.pgc.persistence.documentum.readers;

import com.dsi.intranet.pgc.persistence.documentum.ResponseReadersFactory;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.model.DocumentumFile;
import com.dsi.intranet.pgc.portlet.model.PGCForm;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

public class CharitableDonationFormReader extends FormReader{

	@Override
	protected void parseResponseIntoPGCForm(Document xmlDoc,
			Map<String, List<DocumentumFile>> existingFilesByType, PGCForm form) {
		
		ResponseReadersFactory.getResponseReader(FormCommonInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form);
        
		ResponseReadersFactory.getResponseReader(RequestorInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getReqInfo());
        
		if (form.getFormStatus().equalsIgnoreCase(PGCCommonConstants.STATUS_APPROVED)){
            
        	ResponseReadersFactory.getResponseReader(ModificationInformationReader.class).parseResponsePart(xmlDoc,
                    existingFilesByType, form.getModInfo());
        }
        
        ResponseReadersFactory.getResponseReader(CheckRequestInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getCheckReqInfo());
        
        ResponseReadersFactory.getResponseReader(ProductInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getProductInfo());
        
        ResponseReadersFactory.getResponseReader(CharitableDonationInformationReader.class).parseResponsePart(xmlDoc,
                existingFilesByType, form.getDonationInfo());
		
	}

}
