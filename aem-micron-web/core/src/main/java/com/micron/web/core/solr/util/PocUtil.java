package com.micron.web.core.solr.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.caconfig.ConfigurationBuilder;

import com.micron.web.core.solr.config.SolrCAConfig;

public class PocUtil {

    public static final String SUB_SERVICE_NAME= "poc-service-user";

    public PocUtil() {

    }

    public static Optional<ResourceResolver> getResourceResolver (ResourceResolverFactory resourceResolverFactory) throws LoginException {

        final Map<String, Object> param = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, SUB_SERVICE_NAME);
        return Optional.of(resourceResolverFactory.getServiceResourceResolver(param));

    }

    public static ResourceResolver newResolver( ResourceResolverFactory resourceResolverFactory ) throws LoginException {
        final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put( ResourceResolverFactory.SUBSERVICE, SUB_SERVICE_NAME );
        ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
        return resolver;
    }

    public static SolrCAConfig getContextAwareConfig(final String pagePath, final ResourceResolver resourceResolver, final Class<SolrCAConfig> solrCAConfig) {

        String currentPath = StringUtils.isNotBlank(pagePath) ? pagePath : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(solrCAConfig);
            }
        }
        return null;

    }

}
