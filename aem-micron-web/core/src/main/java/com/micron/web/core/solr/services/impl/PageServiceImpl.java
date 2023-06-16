package com.micron.web.core.solr.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.services.PageService;
import com.micron.web.core.solr.util.PocUtil;

@Component(service = PageService.class, immediate = true)
public class PageServiceImpl implements PageService {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public List<PageDetails> getPageDetail(final String sitePath) {

        List<PageDetails> pageDetail = new ArrayList<>();

        try {

            final ResourceResolver resourceResolver = PocUtil.newResolver(this.resourceResolverFactory);
            Optional<Page> page = Optional.ofNullable(resourceResolver.adaptTo(PageManager.class))
                                            .map(pageManager -> pageManager.getPage(sitePath));

            page.map(parentPage -> pageDetail.add( new PageDetails(
            parentPage.getTitle(),
            parentPage.getName(),
            parentPage.getDescription(),
            parentPage.getPath() )));

            page.map(Page :: listChildren)
            .map(childPageIterator -> {
                childPageIterator.forEachRemaining(childPage -> {
                    String title = StringUtils.isNotBlank(childPage.getTitle()) ? childPage.getTitle() : childPage.getName();
                    String name = childPage.getName();
                    String description = StringUtils.isNotBlank(childPage.getDescription()) ? childPage.getDescription() : childPage.getName();
                    String path = childPage.getPath();
                    pageDetail.add(new PageDetails(title, name, description, path));
                });
                return pageDetail;

            });

            return pageDetail;

        } catch (Exception exception) {

        }
        return pageDetail;
    }

    @Override
    public PageDetails getPageContent(final String sitePath, ResourceResolver resourceResolver) {

        final AtomicReference<PageDetails> pageDetails = null;
        Optional<Page> page = Optional.ofNullable(resourceResolver.adaptTo(PageManager.class))
                                      .map(pageManager -> pageManager.getPage(sitePath));

        page.map(contentPage -> {
            pageDetails.set(new PageDetails(
              contentPage.getTitle(),
              contentPage.getName(),
              contentPage.getDescription(),
              contentPage.getPath()
            ));
            return pageDetails.get();
        });

        return pageDetails.get();
    }

}
