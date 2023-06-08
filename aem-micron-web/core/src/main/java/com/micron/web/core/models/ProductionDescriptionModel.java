package com.micron.web.core.models;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.micron.web.core.services.ProductDescriptionService;

import lombok.Getter;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductionDescriptionModel {

    @SlingObject
    private SlingHttpServletRequest request;

    @OSGiService
    private ProductDescriptionService productDescriptionService;

    @Self
    @Getter
    private ProductDetailCfModel productDetailCfModel;

    @SlingObject
    private Resource resource;

    @Getter
    private String xfPath;

    @Getter
    private String title;


    @PostConstruct
    protected void init() {

        String category = this.request.getAttribute("category").toString();
        String subCategory = this.request.getAttribute("subCategory").toString();
        String product = this.request.getAttribute("product").toString();
        if (StringUtils.contains(product, ".html")) {
            product = StringUtils.remove(product, ".html");
        }
        this.title = StringUtils.upperCase(product);
        productDetailCfModel = this.productDescriptionService.getCfData(category, subCategory);
        this.xfPath = this.productDescriptionService.getExperienceFragmentPath(category,subCategory);

    }


}
