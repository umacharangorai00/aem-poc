package com.micron.web.core.services.impl;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.util.AssetReferenceSearch;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.micron.web.core.services.ReplicationService;
import com.micron.web.core.solr.util.PocUtil;

import static com.day.cq.dam.api.DamConstants.MOUNTPOINT_ASSETS;

@Component(service = ReplicationService.class, immediate = true)
public class ReplicationServiceImpl implements ReplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ReplicationServiceImpl.class);
    private static final String CLASS_NAME = ReplicationServiceImpl.class.getSimpleName();

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    Replicator replicator;


    @Override
    public void replicateContent(final String payload) {
        logger.info("{} :execution started, method :replicateContent", CLASS_NAME);

        // Getting resource resolver
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = PocUtil.newResolver(this.resourceResolverFactory);
            // Getting the session
            Session session = resourceResolver.adaptTo(Session.class);
            // Replicate the page
            replicate(session, payload);
            // Get all the assets on the page(s)
            Set<String> assetsOnPage = getAssetsOnPage(resourceResolver, payload);
            for (String assetPath : assetsOnPage) {
                replicate(session, assetPath);
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }

        logger.info("{}: replication completed successfully", CLASS_NAME);

    }

    private Set<String> getAssetsOnPage(ResourceResolver resourceResolver, String payload) {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Optional<Page> page = Optional.ofNullable(pageManager).map(pm -> pm.getPage(payload));
        if (!page.isPresent()) {
            return new LinkedHashSet<>();
        }
        Resource resource = page.get().getContentResource();
        AssetReferenceSearch assetReferenceSearch = new AssetReferenceSearch(resource.adaptTo(Node.class),
          MOUNTPOINT_ASSETS, resourceResolver);
        Map<String, Asset> assetMap = assetReferenceSearch.search();
        return assetMap.keySet();
    }

    private void replicate(Session session, String path) {
        try {
            logger.info("{}: Replicating: {}", CLASS_NAME, path);
            replicator.replicate(session, ReplicationActionType.ACTIVATE, path);
        } catch (ReplicationException e) {
            logger.error("{}: replication failed due to: {}", CLASS_NAME, e.getMessage());
        }
    }

}
