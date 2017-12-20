package com.dsi.intranet.pgc.persistence.documentum.writers;

import com.dsi.intranet.pgc.persistence.documentum.DocumentumRequest;
import com.dsi.intranet.pgc.persistence.documentum.IRequestWriter;
import com.dsi.intranet.pgc.persistence.documentum.RequestWritersFactory;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumAnnotationProcessor;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumConstants;
import com.dsi.intranet.pgc.persistence.documentum.util.DocumentumConstants.FilePaths;
import com.dsi.intranet.pgc.portlet.constants.PGCCommonConstants;
import com.dsi.intranet.pgc.portlet.model.PGCForm;
import com.dsi.intranet.pgc.portlet.util.PGCCommonUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class GeneralRequestFormWriter implements IRequestWriter{

	@Override
	public DocumentumRequest createRequest(PGCForm form) {
		
		DocumentumRequest req = new DocumentumRequest();
		String path = FilePaths.GENERALREQUEST_PATH;

		if (form != null) {
			StringBuilder xmlStrBuf = new StringBuilder();

			xmlStrBuf.append(DocumentumConstants.XML_PREFIX).append( DocumentumConstants.XML_FORM_OBJECT_FORMAT
							.format(new String[] { "Test General Request", "dsi_pgc_general_request", path }));

			String xmlStrPart = null;

			xmlStrPart = RequestWritersFactory.getRequestWriter(FormCommonInformationWriter.class).createRequestPart(form);
			xmlStrBuf.append(xmlStrPart);

			if (form.getFormStatus().equalsIgnoreCase(
					PGCCommonConstants.STATUS_APPROVED)) {
				xmlStrPart = RequestWritersFactory.getRequestWriter(ModificationInformationWriter.class).createRequestPart(
						form.getModInfo());
				xmlStrBuf.append(xmlStrPart);
			}

			xmlStrPart = RequestWritersFactory.getRequestWriter(RequestorInformationWriter.class).createRequestPart(
					form.getReqInfo());
			xmlStrBuf.append(xmlStrPart);
			
			xmlStrPart = RequestWritersFactory.getRequestWriter(ProductInformationWriter.class).createRequestPart(
                    form.getProductInfo());
            xmlStrBuf.append(xmlStrPart);
            
			xmlStrPart = RequestWritersFactory.getRequestWriter(GeneralRequestInformationWriter.class).createRequestPart(
					form.getRequestInfo());
			xmlStrBuf
					.append(xmlStrPart)
					.append(DocumentumConstants.XMLElements.PROPERTY_ELEMENT_END)
					.append(DocumentumConstants.XMLElements.OBJECT_ELEMENT_END);

			Object[] fileContainerBlocks = new Object[] { form.getRequestInfo() };
			List<CommonsMultipartFile> allFiles = new ArrayList<CommonsMultipartFile>();

			xmlStrPart = DocumentumAnnotationProcessor.beanFilesToXml(path,	fileContainerBlocks, allFiles);
			xmlStrBuf.append(xmlStrPart);

			xmlStrBuf.append(DocumentumConstants.XML_SUFFIX);
			// DSI:START::Veera Reddy:: To create out going request xmls
			PGCCommonUtil.createXml("General Request", xmlStrBuf.toString());
			// DSI:END::Veera Reddy:: To create out going request xmls
			
			req.setXml(xmlStrBuf.toString());
			req.setAttachmentFiles(allFiles);
		}

		return req;
	}

	@Override
	public String createRequestPart(Object dataObject) {
		
		return null;
	}

}
