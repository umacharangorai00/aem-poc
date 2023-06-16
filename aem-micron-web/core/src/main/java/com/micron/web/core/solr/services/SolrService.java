package com.micron.web.core.solr.services;

import java.util.List;

import org.json.JSONArray;

import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.helper.SolrSearchHelper;

public interface SolrService {

    String addDocuments(List<PageDetails> pageDetail, SolrSearchHelper solrSearchHelper);
    String deleteIndex(List<PageDetails> pageDetail, SolrSearchHelper solrSearchHelper);
    JSONArray searchResult(String searchTerm, SolrSearchHelper solrSearchHelper);
    void indexContent(PageDetails pageDetails, SolrSearchHelper solrSearchHelper);
    void deletePageIndex(String pagePath, SolrSearchHelper solrSearchHelper);

}
