package com.micron.web.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.micron.web.core.helper.AttributeHelper;
import com.micron.web.core.helper.SpecificationHelper;
import com.micron.web.core.models.Specifications;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class },
        adapters = Specifications.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SpecificationModel implements Specifications {

    private static final Logger LOG = LoggerFactory.getLogger(SpecificationModel.class);

    @SlingObject
    private SlingHttpServletRequest request;

    @SlingObject
    protected Resource resource;


    @Override
    public List<SpecificationHelper> getSpecificationDetails() {
        List<SpecificationHelper> specificationDetails = new ArrayList<>();
        try {
            Resource specDetails = resource.getChild("specificationDetails");
            if(specDetails != null){
                for (Resource spec : specDetails.getChildren()) {
                    SpecificationHelper specificationHelper = new SpecificationHelper(spec);
                    if(spec.hasChildren()){
                        List<AttributeHelper> attributeList = new ArrayList<>();
                        Resource attributeResource = spec.getChild("attributes");
                        for(Resource attr : attributeResource.getChildren()){
                            attributeList.add(new AttributeHelper(attr));
                        }
                        specificationHelper.setAttributes(attributeList);
                    }
                    specificationDetails.add(specificationHelper);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Attribute Details With Multifield {} ",e.getMessage());
        }

        return specificationDetails;
    }

}
