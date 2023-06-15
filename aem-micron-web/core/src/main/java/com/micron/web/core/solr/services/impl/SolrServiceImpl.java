package com.micron.web.core.solr.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.helper.SolrSearchHelper;
import com.micron.web.core.solr.services.SolrService;
import com.micron.web.core.solr.constants.SolrConstants;
import com.micron.web.core.solr.util.SolrUtil;

@Component(service = SolrService.class, immediate = true)
public class SolrServiceImpl implements SolrService {

    /**
     *  add documents to solr and index data
     * @param pageDetail
     * @param solrSearchHelper
     * @return
     */
    @Override
    public String addDocuments(final List<PageDetails> pageDetail, final SolrSearchHelper solrSearchHelper) {

        try {

            final String solrServer = solrSearchHelper.getSolrConfigurationService().getSolrServerEndPoint();
            final SolrClient solrClient = SolrUtil.getSolrClient(solrServer);
            final String coreName = solrSearchHelper.getSolrCAConfig().collectionName();

            pageDetail.stream().forEach(page -> {
                final SolrInputDocument doc = new SolrInputDocument();
                doc.addField(SolrConstants.PAGE_ID, SolrUtil.getPageName(page.getPath()));
                doc.addField(SolrConstants.PAGE_NAME, page.getName());
                doc.addField(SolrConstants.PAGE_TITLE, page.getTitle());
                doc.addField(SolrConstants.PAGE_DESCRIPTION, page.getDescription());
                try {
                    final UpdateResponse updateResponse = solrClient.add(coreName, doc);
                } catch (SolrServerException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            solrClient.commit(coreName);
            return "Total "+pageDetail.size()+" document added";

        } catch (Exception exception) {

        }
        return "documents could not added to solr";
    }

    /**
     * delete the indexes for a specific core
     * @param pageDetail
     * @param solrSearchHelper
     * @return
     */
    @Override
    public String deleteIndex(final List<PageDetails> pageDetail, final SolrSearchHelper solrSearchHelper) {

        final String solrServer = solrSearchHelper.getSolrConfigurationService().getSolrServerEndPoint();
        final SolrClient solrClient = SolrUtil.getSolrClient(solrServer);
        final String coreName = solrSearchHelper.getSolrCAConfig().collectionName();
        final List<String> pageId = new ArrayList<>();

        pageDetail.stream().forEach(page -> {
            pageId.add(SolrUtil.getPageName(page.getPath()));
        });
        try {
            final UpdateResponse updateResponse = solrClient.deleteById(coreName,pageId);
            solrClient.commit(coreName);
            return "Total "+pageDetail.size()+" document deleted";
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "documents could not be deleted from solr";
    }

    /**
     * search solr using search term
     * @param searchTerm
     * @param solrSearchHelper
     * @return
     */
    @Override
    public JSONArray searchResult(final String searchTerm, final SolrSearchHelper solrSearchHelper) {

        JSONArray searchResult = new JSONArray();

        try{
            final String solrServer = solrSearchHelper.getSolrConfigurationService().getSolrServerEndPoint();
            final SolrClient solrClient = SolrUtil.getSolrClient(solrServer);
            final String coreName = solrSearchHelper.getSolrCAConfig().collectionName();
            String query = StringUtils.isNotBlank(searchTerm) ? searchTerm : "*:*";
            final SolrQuery solrQuery = new SolrQuery(query);
            final QueryResponse response = solrClient.query(coreName, solrQuery);

            final SolrDocumentList solrDocuments = response.getResults();
            solrDocuments.stream().forEach(documents -> {
                JSONObject result = new JSONObject();
                try {
                    result.put(SolrConstants.PAGE_ID, documents.getFirstValue(SolrConstants.PAGE_ID));
                    result.put(SolrConstants.PAGE_TITLE, documents.getFirstValue(SolrConstants.PAGE_TITLE));
                    result.put(SolrConstants.PAGE_NAME, documents.getFirstValue(SolrConstants.PAGE_NAME));
                    result.put(SolrConstants.PAGE_DESCRIPTION, documents.getFirstValue(SolrConstants.PAGE_DESCRIPTION));
                    searchResult.put(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return searchResult;
    }

}
