package com.micron.web.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import lombok.Getter;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DynamicComponentModel {

    @Getter
    @ValueMapValue
    private String productType;

    @Getter
    @ValueMapValue
    private String operatingSystem;

    @Getter
    @ValueMapValue
    private String camera;

    @Getter
    @ValueMapValue
    private String screenSize;

    @Getter
    @ValueMapValue
    private String keyboardLayout;

    @Getter
    @ValueMapValue
    private boolean supportHdr;

    @Getter
    @ValueMapValue
    private String resolution;

}
