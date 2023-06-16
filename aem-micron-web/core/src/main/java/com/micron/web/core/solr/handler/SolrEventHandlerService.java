package com.micron.web.core.solr.handler;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.micron.web.core.solr.helper.SolrSearchHelper;
import com.micron.web.core.solr.services.PageService;
import com.micron.web.core.solr.services.SolrService;
import com.micron.web.core.solr.services.SolrServiceManager;
import com.micron.web.core.solr.util.PocUtil;

@Component(service = EventHandler.class, immediate = true,
            property = { EventConstants.EVENT_TOPIC  +"="+ ReplicationAction.EVENT_TOPIC
            })
public class SolrEventHandlerService implements EventHandler {

    @Reference
    private SolrServiceManager solrServiceManager;

    @Reference
    private PageService pageService;

    @Reference
    private SolrService solrService;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;


    @Override
    public void handleEvent(final Event event) {

        try {
            String pagePath = ReplicationAction.fromEvent(event).getPath();
            ResourceResolver resourceResolver = PocUtil.newResolver(this.resourceResolverFactory);
            SolrSearchHelper solrSearchHelper = new SolrSearchHelper(pagePath, solrServiceManager, resourceResolver);
            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.ACTIVATE)) {

                solrSearchHelper.indexPageContent(pagePath, pageService, solrService, resourceResolver);

            } else if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.DEACTIVATE)) {

                solrSearchHelper.deletePageIndex(pagePath,solrService);

            } else {


            }

        } catch (Exception exception) {


        }

    }

}
