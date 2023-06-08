package com.micron.web.core.services.impl;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.micron.web.core.models.ProductDetailCfModel;
import com.micron.web.core.services.ProductDescriptionService;

@Component(service = ProductDescriptionService.class, immediate = true)
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private static final String CF_ROOT_PATH = "/content/dam/micron-web/us/en/content-fragment/dram/jcr:content/data/";
    private static final String XF_ROOT_PATH = "/content/experience-fragments/micron-web/us/en/dram/";
    private static final String SUB_SERVICE_NAME= "poc-service-user";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public ProductDetailCfModel getCfData(final String category, final String subCategory) {
        final AtomicReference<ProductDetailCfModel> productDetailCfModel = new AtomicReference<ProductDetailCfModel>();

        this.getResourceResolver().ifPresent(resourceResolver -> {
            Resource cFragmentSubcategory = resourceResolver.getResource(CF_ROOT_PATH+subCategory);
            if (null != cFragmentSubcategory) {
                productDetailCfModel.set(cFragmentSubcategory.adaptTo(ProductDetailCfModel.class));
            } else {
                Resource cFragmentCategory = resourceResolver.getResource(CF_ROOT_PATH+"master");
                productDetailCfModel.set(cFragmentCategory.adaptTo(ProductDetailCfModel.class));
            }
        });

        return productDetailCfModel.get();
    }

    @Override
    public String getExperienceFragmentPath(final String category, final String subCategory) {

        String experienceFragmentPath;
        final AtomicReference<Resource> xFragmentSubcategory = new AtomicReference<Resource>();
        this.getResourceResolver().ifPresent(resourceResolver -> {
            xFragmentSubcategory.set(resourceResolver.getResource(XF_ROOT_PATH+subCategory));
        });
        if (null != xFragmentSubcategory.get()) {
            experienceFragmentPath = XF_ROOT_PATH+subCategory;
        } else {
            experienceFragmentPath = XF_ROOT_PATH+"master";
        }
        return experienceFragmentPath;
    }

    private Optional<ResourceResolver> getResourceResolver() {
        try {
            final Map<String, Object> param = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, SUB_SERVICE_NAME);
            return Optional.of(this.resourceResolverFactory.getServiceResourceResolver(param));
        } catch (final LoginException e) {
            return Optional.empty();
        }
    }


}
