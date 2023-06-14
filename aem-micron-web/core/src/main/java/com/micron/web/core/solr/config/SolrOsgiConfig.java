package com.micron.web.core.solr.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Solr osgi configuration", description = "Osgi configuration for solr")
public @interface SolrOsgiConfig {

    @AttributeDefinition(name = "Site Id")
    String siteId();

    @AttributeDefinition(name = "Server end point")
    String solrServerEndPoint();

    @AttributeDefinition(name = "User name")
    String solrUserName();

    @AttributeDefinition(name = "Password ")
    String solrPassword();

    @AttributeDefinition(name = "Solr response fields")
    String[] solrResponseFiled();


}
