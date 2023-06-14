package com.micron.web.core.solr.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import com.micron.web.core.solr.services.SolrConfigurationService;
import com.micron.web.core.solr.config.SolrOsgiConfig;


@Component(service = SolrConfigurationService.class, immediate = true)
@Designate(ocd = SolrOsgiConfig.class, factory = true)
public class SolrConfigurationServiceImpl implements SolrConfigurationService {


    private String siteId;

    private String solrServerEndPoint;

    private String solrUsername;

    private String solrPassword;

    private String[] solrResponseFields;

    @Modified
    @Activate
    private void activate(final SolrOsgiConfig solrConfig) {

        this.siteId = solrConfig.siteId();
        this.solrServerEndPoint = solrConfig.solrServerEndPoint();
        this.solrUsername = solrConfig.solrUserName();
        this.solrPassword = solrConfig.solrPassword();
        this.solrResponseFields = solrConfig.solrResponseFiled();

    }


    @Override
    public String getSiteId() {
        return this.siteId;
    }

    @Override
    public String getSolrServerEndPoint() {
        return this.solrServerEndPoint;
    }

    @Override
    public String getSolrUserName() {
        return this.solrUsername;
    }

    @Override
    public String getSolrPassword() {
        return this.solrPassword;
    }

    @Override
    public String[] getSolrResponseFields() {
        return this.solrResponseFields;
    }

}
