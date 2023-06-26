package com.micron.web.core.eventhandler.osgilevel;

import com.day.cq.wcm.api.PageEvent;
import com.day.cq.wcm.api.PageModification;
import com.micron.web.core.constants.AemConstant;

import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component(service = EventHandler.class,
        immediate = true,
        property = {
                EventConstants.EVENT_TOPIC + "=" + PageEvent.EVENT_TOPIC
        })
public class PageReplicationEventHandler implements EventHandler {

    private static final String CLASS_NAME =  PageReplicationEventHandler.class.getSimpleName();
    private static final Logger logger = LoggerFactory.getLogger(PageReplicationEventHandler.class);

    @Reference
    private JobManager jobManager;

    public void handleEvent(final Event event)  {
        try {
            Iterator<PageModification> pageInfo=PageEvent.fromEvent(event).getModifications();
            while (pageInfo.hasNext()){
                PageModification pageModification=pageInfo.next();
                Map<String, Object> jobProperties = new HashMap<>();
                jobProperties.put("payload", pageModification.getPath());
                jobManager.addJob(AemConstant.PAGE_REPLICATION_TOPIC, jobProperties);
                logger.info("{}: job is completed successfully", CLASS_NAME);
            }

        }catch (Exception e){
            logger.info("\n Error while Activating/Deactivating - {} " , e.getMessage());
        }
    }
}

