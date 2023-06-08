package com.micron.web.core.services;

import org.apache.sling.api.resource.ResourceResolver;

import com.micron.web.core.models.ProductDetailCfModel;

public interface ProductDescriptionService {

    ProductDetailCfModel getCfData(String category, String subCategory);
    String getExperienceFragmentPath(String category, String subCategory);

}
