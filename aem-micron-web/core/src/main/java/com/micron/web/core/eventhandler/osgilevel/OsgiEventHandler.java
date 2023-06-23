package com.micron.web.core.eventhandler.osgilevel;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import com.micron.web.core.solr.util.PocUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(service = EventHandler.class, immediate = true,
            property = {
              EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
              EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
              EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED",
              EventConstants.EVENT_FILTER +"=(path=/content/micron-web/in/de/content-page/*)"

            }
)
public class OsgiEventHandler implements EventHandler {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(final Event event) {
        log.info("This is OSGI even handler Type: {} Path: {}", event.getTopic(), event.getProperty(SlingConstants.PROPERTY_PATH));

        try (ResourceResolver resourceResolver = PocUtil.newResolver(this.resourceResolverFactory)) {
            Session session = resourceResolver.adaptTo(Session.class);
            Node node = session.getNode(event.getProperty(SlingConstants.PROPERTY_PATH).toString());
            node.setProperty("Property is added by", "Uma C Gorai");
            session.save();

            for(String prop : event.getPropertyNames()){
                log.info("\n Property : {} , Value : {} ", prop,event.getProperty(prop));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
