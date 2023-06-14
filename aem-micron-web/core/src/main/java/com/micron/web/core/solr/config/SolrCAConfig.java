package com.micron.web.core.solr.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "Solr CA Config", collection = true, description = "Context aware configuration for solr")
public @interface SolrCAConfig {

    @Property(label = "Site Id", description = "Site Id")
    String siteId();

    @Property(label = "Core name", description = "Core name for each site")
    String collectionName();

    @Property(label = "Filed names", description = "Filed names")
    String filedNames();

}
