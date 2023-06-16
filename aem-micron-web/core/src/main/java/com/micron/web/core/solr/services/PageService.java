package com.micron.web.core.solr.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.helper.SolrSearchHelper;

public interface PageService {

    List<PageDetails> getPageDetail(String sitePath);
    PageDetails getPageContent(String sitePath, ResourceResolver resourceResolver);


}
