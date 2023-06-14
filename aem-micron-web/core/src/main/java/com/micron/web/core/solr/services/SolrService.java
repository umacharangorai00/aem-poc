package com.micron.web.core.solr.services;

import java.util.List;

import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.helper.SolrSearchHelper;

public interface SolrService {

    String addDocuments(List<PageDetails> pageDetail, SolrSearchHelper solrSearchHelper);
    String testAddDocuments(List<PageDetails> pageDetail);


}
