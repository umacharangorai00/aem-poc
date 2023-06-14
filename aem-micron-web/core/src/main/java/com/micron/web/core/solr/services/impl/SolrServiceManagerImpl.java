package com.micron.web.core.solr.services.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.micron.web.core.solr.services.SolrConfigurationService;
import com.micron.web.core.solr.services.SolrServiceManager;

@Component(service = SolrServiceManager.class, immediate = true)
public class SolrServiceManagerImpl implements SolrServiceManager {


    private Map<String, SolrConfigurationService> configurationList;

    @Reference(service = SolrConfigurationService.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    protected synchronized void bindApiServiceConfiguration(final SolrConfigurationService solrConfig) {

        if (null == configurationList) {
            configurationList = new ConcurrentHashMap<>();
        }
        configurationList.put(solrConfig.getSiteId(), solrConfig);

    }

    protected synchronized void unbindApiServiceConfiguration(final SolrConfigurationService solrConfig) {

        this.configurationList.remove(solrConfig.getSiteId());

    }



    @Override
    public SolrConfigurationService getServiceConfiguration(final String siteId) {
        return this.configurationList.get(siteId);
    }

}
