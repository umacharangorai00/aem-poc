package com.micron.web.core.helper;
import org.apache.sling.api.resource.Resource;

import lombok.Getter;

public class AttributeHelper {

    @Getter
    private String attributeName;
    @Getter
    private String attributeValue;

    public AttributeHelper(Resource resource) {

        if(resource.getValueMap().get("attributeName", String.class)!=null) {
            this.attributeName = resource.getValueMap().get("attributeName", String.class);
        }
        if(resource.getValueMap().get("attributeValue",String.class)!=null){
            this.attributeValue=resource.getValueMap().get("attributeValue",String.class);
        }

    }

}
