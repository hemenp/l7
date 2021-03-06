 /**
 * Copyright � 2011 DAIICHI SANKYO COMPANY, LIMITED. All Rights Reserved.
 */
package com.dsi.intranet.eprocurement.portlet.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.dsi.intranet.eprocurement.model.EprocurementRequest;
import com.dsi.intranet.eprocurement.model.Item;
import com.dsi.intranet.eprocurement.portlet.bean.EprocurementReportDataObject;
import com.dsi.intranet.eprocurement.portlet.constants.EProcurementConstants;
import com.dsi.intranet.eprocurement.service.EprocurementRequestLocalServiceUtil;
import com.dsi.intranet.eprocurement.service.ItemLocalServiceUtil;
import com.dsi.intranet.rfc.exception.NoSuchVendorException;
import com.liferay.blogs.kernel.model.BlogsEntry;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineHelperUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="Indexer.java.html"><b><i>View Source</i></b></a>
 * 
 * @Project E-procurement
 * @Author Devaki Subramaniam
 * @Description Indexer class for Purchase Request Portlet.
 * @ChangeLog: Name | Date | Reason
 *             ----------------------------------------------
 *             ---------------------------------
 */
public class Indexer extends BaseIndexer
{

    /** constant for the class names **/
    //private static final String[] _CLASS_NAMES = new String[] { EProcurementConstants.CLASS_NAME_EPROCUREMENT_REQUEST };
    
    public static final String CLASS_NAME = BlogsEntry.class.getName();

    /** constant for the log **/
    private static final Log _log = LogFactoryUtil.getLog(Indexer.class);

    /** constant for the portlet id **/
    public static final String PORTLET_ID = EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS;

    /**
     * This method is responsible for indexing purchase request when new request is created.
     * @param eprocureRequest
     * @param itemName
     * @param itemDescription
     * @throws SearchException
     */
    public static void addRequest(EprocurementRequest eprocureRequest, String[] itemName, String[] itemDescription)
            throws SearchException
    {

        Document doc = getRequestEntryDocument(eprocureRequest, itemName, itemDescription);
        _log.debug("Purchase Request DOC: "+doc);
        if (doc != null)
        {   
        	String searchEngineId = SearchEngineHelperUtil.getDefaultSearchEngineId();
        	IndexWriterHelperUtil.addDocument(searchEngineId, eprocureRequest.getCompanyId(), doc, true);
            //SearchEngineUtil.addDocument(serachEngineId,eprocureRequest.getCompanyId(), doc);
            _log.info("After adding the Document into Index");
        }
    }
    
    private static String _getSearchEngineId(Document document) {
		String entryClassName = document.get("entryClassName");

		com.liferay.portal.kernel.search.Indexer indexer = IndexerRegistryUtil.getIndexer(entryClassName);

		String searchEngineId = indexer.getSearchEngineId();

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Search engine ID for " + indexer.getClass() + " is " +
					searchEngineId);
		}

		return searchEngineId;
	}

    /**
     * Creates date range query for the given arguments
     * @param fromMonth from month selected by user.
     * @param toMonth to year selected by user
     * @param fromYear from year selected by user
     * @param toYear to year selected by user
     * @return date query
     */
    public static BooleanQuery createDateRangeQuery(String fromDate, String toDate)
    {
        String fromYear = fromDate.substring(EProcurementConstants.INPUT_DATE_FORMAT
                .indexOf(EProcurementConstants.YEAR));
        String fromMonth = fromDate.substring(EProcurementConstants.INPUT_DATE_FORMAT
                .indexOf(EProcurementConstants.MONTH), EProcurementConstants.INPUT_DATE_FORMAT
                .indexOf(EProcurementConstants.MONTH) + 2);
        String fromDay = fromDate.substring(EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.DAY),
                EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.DAY) + 2);

        String toYear = toDate.substring(EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.YEAR));
        String toMonth = toDate.substring(EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.MONTH),
                EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.MONTH) + 2);
        String toDay = toDate.substring(EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.DAY),
                EProcurementConstants.INPUT_DATE_FORMAT.indexOf(EProcurementConstants.DAY) + 2);
        
        BooleanQuery dateQuery = new BooleanQueryImpl();
        //BooleanQuery dateQuery = BooleanQueryFactoryUtil.create(new SearchContext());
        
        String lowerBound = fromYear + fromMonth + fromDay + EProcurementConstants.MIN_TIME;
        String upperBound = toYear + toMonth + toDay + EProcurementConstants.MAX_TIME;
        try
        {
            dateQuery.addTerm(Field.MODIFIED_DATE, "[" + lowerBound + " TO " + upperBound + "]");
        } catch (ParseException e)
        {
            _log.error("Error while creating date range query: " + e.getMessage(), e);
        }
        return dateQuery;
    }

    /**
     * This method is responsible for deleting indexes for request while deleting request.
     * @param companyId
     * @param groupId
     * @param requestId
     */
    public static void deleteRequest(long companyId, long groupId, String requestId)
    {

        try
        {
        	
            //SearchEngineUtil.deleteDocument(companyId, getRequestUID(groupId, requestId));
            String searchEngineId = SearchEngineHelperUtil.getDefaultSearchEngineId();
            IndexWriterHelperUtil.deleteDocument(searchEngineId, companyId, getRequestUID(groupId, requestId), true);
        } catch (SearchException e)
        {
            _log.error("Error while deleting indexed document for requestId: " + requestId + " : " + e.getMessage(), e);
        }
    }

    /**
     * This method creates indexes document for request 
     * @param eprocureRequest
     * @param itemName
     * @param itemDescription
     * @return
     */
	public static Document getRequestEntryDocument(EprocurementRequest eprocureRequest, String[] itemName,
            String[] itemDescription)
    {

        long scopeGroupId = eprocureRequest.getGroupId();
        String vendorName = StringPool.BLANK;

        try
        {
            Group group = GroupLocalServiceUtil.getGroup(eprocureRequest.getGroupId());

            if (group.isLayout())
            {
                eprocureRequest.setGroupId(group.getParentGroupId());
            }
        } catch (PortalException pe)
        {
            _log.error("Error while retrieving group: " + pe.getMessage(), pe);
        } catch (SystemException se)
        {
            _log.error("Error while retrieving group: " + se.getMessage(), se);
        }

        try
        {
            vendorName = EprocurementCommonUtil.getVendorName(eprocureRequest.getCompanyId(), eprocureRequest
                    .getVendorCode());
        } catch (NoSuchVendorException e)
        {
            _log.error("Error while getting vendorname from vendorcode: " + e.getMessage(), e);
        } catch (SystemException e)
        {
            _log.error("Error while getting vendorname from vendorcode: " + e.getMessage(), e);
        }

        Document doc = new DocumentImpl();

        doc.addUID(PORTLET_ID, eprocureRequest.getRequestId());

        doc.addDate(
				Field.MODIFIED_DATE, eprocureRequest.getModifiedDate());
        doc.addKeyword(
				Field.ENTRY_CLASS_NAME, eprocureRequest.getModelClassName());
        doc.addKeyword(Field.COMPANY_ID, eprocureRequest.getCompanyId());
        doc.addKeyword(Field.PORTLET_ID, EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS);
        doc.addKeyword(Field.GROUP_ID, eprocureRequest.getGroupId());
        doc.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);

        doc.addKeyword(Field.ENTRY_CLASS_PK, eprocureRequest.getRequestId());
        doc.addKeyword(EProcurementConstants.REQUESTOR_ID, eprocureRequest.getRequestorId());
        doc.addText(EProcurementConstants.CONTRACT_ID, eprocureRequest.getContractId());
        doc.addText(EProcurementConstants.PURCHASE_ORDER_NUMBER, eprocureRequest.getPurchaseOrder());
        doc.addKeyword(EProcurementConstants.VENDOR_NAME, vendorName);
        doc.addKeyword(EProcurementConstants.ADDRESS, eprocureRequest.getAddress());
        doc.addKeyword(EProcurementConstants.SHIP_TO_OTHER, eprocureRequest.getShipToOther());
        doc.addText(EProcurementConstants.REASON, eprocureRequest.getReason());
        doc.addText(EProcurementConstants.NOTES, eprocureRequest.getNotes());
        doc.addText(EProcurementConstants.PROJECT_NAME, eprocureRequest.getProjectName());
        doc.addKeyword(EProcurementConstants.STAGE, eprocureRequest.getStage());
        doc.addKeyword(EProcurementConstants.CURRENT_STATUS, eprocureRequest.getStatus());
        doc.addKeyword(EProcurementConstants.ITEM_NAME, itemName);
        doc.addKeyword(EProcurementConstants.ITEM_DESCRIPTION, itemDescription);
        _log.info("Document prepared for " + eprocureRequest.getRequestId());
        return doc;
    }

    /**
     * method to create uid for request
     * @param groupId
     * @param requestId
     * @return
     */
    public static String getRequestUID(long groupId, String requestId)
    {
        Document doc = new DocumentImpl();

        doc.addUID(EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS, groupId, requestId);

        return doc.get(Field.UID);
    }

    /**
     * method performs reindexing for request
     * @param eprocurementRequest
     * @throws SearchException
     */
    public static void reIndex(EprocurementRequest eprocurementRequest) throws SearchException
    {
        try
        {
            List<Item> itemList = ItemLocalServiceUtil.getItemsByRequestId(eprocurementRequest.getRequestId());

            String[] itemName = StringUtil.split(ListUtil.toString(itemList, "itemName"));
            String[] itemDescription = StringUtil.split(ListUtil.toString(itemList, "itemDescription"));

            addRequest(eprocurementRequest, itemName, itemDescription);

        } catch (Exception e)
        {
            _log.error("Error while reindexing EprocurementRequest: " + e.getMessage(), e);
        }

    }

    /**
     * This method is responsible for searching request indexes
     * @param renderRequest
     * @param themeDisplay
     * @param searchContainer
     * @param paramMap
     * @return
     */
    public static List<EprocurementReportDataObject> search(RenderRequest renderRequest, ThemeDisplay themeDisplay,
            SearchContainer searchContainer, Map<String, String> paramMap)
    {
        List<EprocurementReportDataObject> resultList = new ArrayList<EprocurementReportDataObject>();
        
        try
        {
        	SearchContext searchContext = new SearchContext();
            searchContext.setSearchEngineId(SearchEngineHelperUtil.getDefaultSearchEngineId());
            
            BooleanQuery contextQuery = new BooleanQueryImpl();
            contextQuery.addRequiredTerm(Field.COMPANY_ID, themeDisplay.getCompanyId());
            contextQuery.addRequiredTerm(Field.GROUP_ID, themeDisplay.getScopeGroupId());
            
            contextQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, EprocurementRequest.class.getName());

            BooleanQuery fullQuery = new BooleanQueryImpl();
            fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

            BooleanQuery searchQuery = new BooleanQueryImpl();

            if (paramMap.containsKey(Field.USER_ID))
            {
                searchQuery.addRequiredTerm(EProcurementConstants.REQUESTOR_ID, paramMap.get(Field.USER_ID));
            }

            if (paramMap.containsKey(EProcurementConstants.CONTRACT_ID))
            {
                searchQuery.addRequiredTerm(EProcurementConstants.CONTRACT_ID, paramMap
                        .get(EProcurementConstants.CONTRACT_ID));
            }

            if (paramMap.containsKey(EProcurementConstants.REQUEST_ID))
            {
                searchQuery.addRequiredTerm(Field.ENTRY_CLASS_PK, paramMap.get(EProcurementConstants.REQUEST_ID));
            }
            // Uncommented code
             if (paramMap.containsKey(EProcurementConstants.PURCHASE_ORDER_NUMBER))
            {
                searchQuery.addRequiredTerm(EProcurementConstants.PURCHASE_ORDER_NUMBER, paramMap
                        .get(EProcurementConstants.PURCHASE_ORDER_NUMBER));
            }
             
            if (paramMap.containsKey(EProcurementConstants.VENDOR_NAME)) 
            {
                searchQuery.addRequiredTerm(EProcurementConstants.VENDOR_NAME, paramMap.get(EProcurementConstants.VENDOR_NAME).replace(StringPool.SPACE,StringPool.COMMA));
            }
            // Uncommented code
            if (paramMap.containsKey(EProcurementConstants.ADDRESS))
            {
            	String address=(String)paramMap.get(EProcurementConstants.ADDRESS).replace(StringPool.SPACE,StringPool.COMMA);
            	
                if (paramMap.get(EProcurementConstants.ADDRESS).equalsIgnoreCase(
                        EProcurementConstants.SHIP_TO_OTHER_PARAM))
                {
                    searchQuery.addRequiredTerm(EProcurementConstants.SHIP_TO_OTHER,
                            EProcurementConstants.SHIP_TO_OTHER_VALUE);
                } else
                {
                    searchQuery.addRequiredTerm(EProcurementConstants.ADDRESS,address);
                }

            }
            
            if (paramMap.containsKey(EProcurementConstants.PARAM_STATUS))
            {
            	
                searchQuery.addRequiredTerm(EProcurementConstants.CURRENT_STATUS, paramMap
                        .get(EProcurementConstants.PARAM_STATUS));
               
                //search query for webadmin completed requests
                if(paramMap.get(EProcurementConstants.PARAM_STATUS).equalsIgnoreCase(EProcurementConstants.STATUS_COMPLETED) && paramMap.containsKey(EProcurementConstants.STAGE_USER_ID)){
                	searchQuery.addRequiredTerm(EProcurementConstants.STAGE, paramMap.get(EProcurementConstants.STAGE_USER_ID));
                }
            }

            // creating & adding date range query
            if (paramMap.containsKey(EProcurementConstants.PARAM_START_DATE)
                    && paramMap.containsKey(EProcurementConstants.PARAM_END_DATE))
            {
                BooleanQuery dateQuery = createDateRangeQuery(paramMap.get(EProcurementConstants.PARAM_START_DATE),
                        paramMap.get(EProcurementConstants.PARAM_END_DATE));
                fullQuery.add(dateQuery, BooleanClauseOccur.MUST);
            }

            if (searchQuery.clauses().size() > 0)
            {
                fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
            }

            BooleanQuery requestItemSearchQuery = new BooleanQueryImpl();

            if (paramMap.containsKey(EProcurementConstants.ITEM_NAME_DESC))
            {
                requestItemSearchQuery.addTerm(EProcurementConstants.ITEM_NAME, paramMap
                        .get(EProcurementConstants.ITEM_NAME_DESC), true);
                requestItemSearchQuery.addTerm(EProcurementConstants.ITEM_DESCRIPTION, paramMap
                        .get(EProcurementConstants.ITEM_NAME_DESC), true);
                requestItemSearchQuery.addTerm(EProcurementConstants.REASON, paramMap
                        .get(EProcurementConstants.ITEM_NAME_DESC), true);
                requestItemSearchQuery.addTerm(EProcurementConstants.NOTES, paramMap
                        .get(EProcurementConstants.ITEM_NAME_DESC), true);
                requestItemSearchQuery.addTerm(EProcurementConstants.PROJECT_NAME, paramMap
                        .get(EProcurementConstants.ITEM_NAME_DESC), true);
                fullQuery.add(requestItemSearchQuery, BooleanClauseOccur.MUST);
            }
            Sort sort = new Sort(Field.MODIFIED_DATE, true);
            long groupId[] = {themeDisplay.getScopeGroupId()};
            
            
			//String searchEngineId = SearchEngineHelperUtil.getDefaultSearchEngineId();
			_log.debug("Reports search query: "+fullQuery);
			
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setSorts(sort);
			searchContext.setStart(-1);
			searchContext.setEnd(-1);
			
			Hits hits = IndexSearcherHelperUtil.search(searchContext, fullQuery);
            //Hits hits = SearchEngineUtil.search(searchEngineId, themeDisplay.getCompanyId(), fullQuery, sort, -1, -1);
            
            if (hits != null && hits.getLength() > 0)
            {
                resultList = ReportsPortletUtil.populateRequests(renderRequest, themeDisplay, hits);
                if (resultList != null)
                {
                    searchContainer.setTotal(resultList.size());
                }
            }

        } catch (Exception e)
        {
            _log.error("Error while executing boolean search query for reports: " + e.getMessage(), e);
        }

        return resultList;
    }
    
    /**
     * method updates indexes for request
     * @param eprocurementRequest
     * @param itemName
     * @param itemDescription
     * @throws SearchException
     */
    public static void updateRequest(EprocurementRequest eprocurementRequest, String[] itemName,
            String[] itemDescription) throws SearchException
    {

        Document doc = getRequestEntryDocument(eprocurementRequest, itemName, itemDescription);
        IndexWriterHelperUtil.updateDocument(_getSearchEngineId(doc), eprocurementRequest.getCompanyId(),doc, true);
        //SearchEngineUtil.updateDocument(_getSearchEngineId(doc),eprocurementRequest.getCompanyId(),doc);
    }


   /* *//**
     * default method needs to be overridden when any class implements Indexer
     *//*
    public DocumentSummary getDocumentSummary(Document arg0, String arg1, PortletURL arg2)
    {
        return null;
    }*/

    /**
     * method to reindex request 
     * @param requestId
     * @throws SystemException
     */
    public void reIndex(long requestId) throws SystemException
    {
        EprocurementRequest eprocurementRequest = null;

        try
        {
            eprocurementRequest = EprocurementRequestLocalServiceUtil.getEprocurementRequest(requestId);
        } catch (Exception e)
        {
            _log.error("Error while retrieving eprocurement request: " + e.getMessage(), e);
        }

        try
        {
            if (Validator.isNotNull(eprocurementRequest))
            {
                reIndex(eprocurementRequest);
            }
        } catch (SearchException e)
        {
            _log
                    .error("Error while reindexing eprocurement request for requestId" + requestId + " : "
                            + e.getMessage(), e);
        }
    }

    /**
     * reindex based on classPK
     */
    public void reIndex(String className, long classPK) throws SearchException
    {
        try
        {
            reIndex(classPK);
        } catch (Exception e)
        {
            throw new SearchException(e);
        }
    }

    /**
     * This method is responsible for reindexing all requests for the ids available in array
     */
    public void reIndex(String[] ids) throws SearchException
    {
        if (IndexWriterHelperUtil.isIndexReadOnly())
        {
            return;
        }

        long companyId = GetterUtil.getLong(ids[0]);

        try
        {
            reIndexRequest(companyId);
        } catch (SystemException se)
        {
            _log.error("Error while reindexing ids: " + se.getMessage(), se);
        }
    }

    /**
     * This method is responsible for reindexing all requests available in particular instance
     * @param companyId
     * @throws SystemException
     */
    protected void reIndexRequest(long companyId) throws SystemException
    {

        List<EprocurementRequest> eprocurementRequests = EprocurementRequestLocalServiceUtil.getEprocurementRequests(0,
                EprocurementRequestLocalServiceUtil.getEprocurementRequestsCount());
        
        Collection<String> uids = new HashSet<>();
        
        for(EprocurementRequest request: eprocurementRequests){
        	uids.add(getRequestUID(request.getGroupId(), String.valueOf(request.getRequestId())));
        }

        try
        {
        	IndexWriterHelperUtil.deleteDocuments(getSearchEngineId(),companyId, uids, true);
            //SearchEngineUtil.deletePortletDocuments(getSearchEngineId(),companyId, EProcurementConstants.PORTLET_NAME_REQUEST_DETAILS);
        } catch (SearchException e1)
        {
            _log.error("Error while deleting purchase request portlet documents: " + e1.getMessage(), e1);
        }
        for (EprocurementRequest eprocurementRequest : eprocurementRequests)
        {
            try
            {
                reIndex(eprocurementRequest);
            } catch (SearchException e)
            {
                _log.error("Error while reindexing all requests: " + e.getMessage(), e);
            }
        }

    }

    @Override
    protected void doDelete(Object obj) throws Exception
    {

    	EprocurementRequest eprocurementRequest = (EprocurementRequest) obj;
        deleteDocument(eprocurementRequest.getCompanyId(), getEprocurementRequestID(eprocurementRequest.getRequestId()));
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception
    {

    	EprocurementRequest eprocurementRequest = (EprocurementRequest) obj;
        Document doc = getIndex(eprocurementRequest);

        return doc;
    }

   //@Override
   /* protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
            throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }*/
    
	@Override
    protected void doReindex(Object arg0) throws Exception
    {

		EprocurementRequest eProcurementRequest = (EprocurementRequest) arg0;
        reIndex(eProcurementRequest);

    }

    @Override
    protected void doReindex(String[] employeeIds) throws Exception
    {
        if (IndexWriterHelperUtil.isIndexReadOnly())
        {
            return;
        }

        long companyId = GetterUtil.getLong(employeeIds[0]);

        try
        {
            reIndexRequest(companyId);
        } catch (SystemException e)
        {
            _log.error("Not able to reindex by employeeIds. " + e.getMessage());
        } catch (Exception e)
        {
            _log.error("Not able to reindex by employeeIds. " + e.getMessage());
        }

    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception
    {
        _log.debug("reIndex(String className, long classPK)------>");
        try
        {
            reIndex(classPK);
        } catch (Exception e)
        {
            throw new SearchException(e);
        }
    }

	@Override
    protected String getPortletId(SearchContext arg0)
    {
        return PORTLET_ID;
    }

    public String getPortletId()
    {
        return PORTLET_ID;
    }
    
    public static String getEprocurementRequestID(long requestId)
    {
        Document doc = new DocumentImpl();
        doc.addUID(PORTLET_ID, requestId);
        return doc.get(Field.UID);
    }
    
    public static Document getIndex(EprocurementRequest eProcurementRequest)
    {

        Document doc = new DocumentImpl();
        doc.addUID(PORTLET_ID, eProcurementRequest.getRequestId());
        doc.addKeyword(Field.COMPANY_ID, eProcurementRequest.getCompanyId());
        doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
        doc.addKeyword(Field.ENTRY_CLASS_PK, eProcurementRequest.getRequestId());
        doc.addKeyword(
				Field.ENTRY_CLASS_NAME, EprocurementRequest.class.getName());
        return doc;
    }

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}