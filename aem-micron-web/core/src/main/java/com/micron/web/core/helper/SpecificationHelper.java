package com.micron.web.core.helper;

import java.util.List;

import org.apache.sling.api.resource.Resource;

import lombok.Getter;
import lombok.Setter;

public class SpecificationHelper {

    @Getter
    @Setter
    private String heading;
    @Getter
    @Setter
    private String subHeading;
    @Getter
    @Setter
    private List<AttributeHelper> attributes;

    public SpecificationHelper (Resource resource) {

        if(resource.getValueMap().get("heading", String.class)!=null) {
            this.heading = resource.getValueMap().get("heading", String.class);
        }
        if(resource.getValueMap().get("subHeading",String.class)!=null){
            this.subHeading=resource.getValueMap().get("subHeading",String.class);
        }

    }

}
