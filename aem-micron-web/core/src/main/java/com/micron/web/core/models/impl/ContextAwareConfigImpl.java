package com.micron.web.core.models.impl;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.day.cq.wcm.api.Page;
import com.micron.web.core.config.PocCAConfig;
import com.micron.web.core.models.ContextAwareConfig;

@Model(adaptables = {SlingHttpServletRequest.class},
        adapters = {ContextAwareConfig.class},
        resourceType = ContextAwareConfigImpl.RESOURCE_PATH,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ContextAwareConfigImpl implements ContextAwareConfig {

    protected static final String RESOURCE_PATH = "micron-web/components/content/contextaware-configuration";

    @SlingObject
    ResourceResolver resourceResolver;

    @ScriptVariable
    Page currentPage;

    @OSGiService
    ConfigurationResolver configurationResolver;

    private String siteCountry;
    private String siteLocale;
    private String siteAdmin;
    private String siteSection;

    @Override
    public String getSiteCountry() {
        return this.siteCountry;
    }

    @Override
    public String getSiteLocale() {
        return this.siteLocale;
    }

    @Override
    public String getSiteAdmin() {
        return this.siteAdmin;
    }

    @Override
    public String getSiteSection() {
        return this.siteSection;
    }

    @PostConstruct
    protected void init() {

        PocCAConfig caConfig=getContextAwareConfig(currentPage,resourceResolver);
        this.siteCountry=caConfig.siteCountry();
        this.siteLocale=caConfig.siteLocale();
        this.siteAdmin=caConfig.siteAdmin();
        this.siteSection=caConfig.siteSection();

    }

    /*private PocCAConfig getContextAwareConfig(final String currentPage, final ResourceResolver resourceResolver) {

        String currentPath = StringUtils.isNotBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(PocCAConfig.class);
            }
        }
        return null;
    }*/

    private PocCAConfig getContextAwareConfig(final Page currentPage, final ResourceResolver resourceResolver) {
        
        if (currentPage != null) {
            ConfigurationBuilder configurationBuilder = currentPage.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(PocCAConfig.class);
            }
        }
        return null;
    }

}
