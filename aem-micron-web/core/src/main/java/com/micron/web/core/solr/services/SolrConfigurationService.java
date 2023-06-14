package com.micron.web.core.solr.services;

public interface SolrConfigurationService {

    String getSiteId();

    String getSolrServerEndPoint();

    String getSolrUserName();

    String getSolrPassword();

    String[] getSolrResponseFields();
}
