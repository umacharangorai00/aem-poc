package com.micron.web.core.eventhandler.osgilevel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.PageEvent;
import com.day.cq.wcm.api.PageModification;
import com.micron.web.core.constants.AemConstant;

@Component(service = EventHandler.class,
        immediate = true,
          property = {
            EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
            EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
            EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/REMOVED",
            EventConstants.EVENT_FILTER +"=(path=/content/micron-web/in/de/job-testing-page/*)"

          }
)
public class PageActivationEventHandler implements EventHandler {

    private static final String CLASS_NAME =  PageActivationEventHandler.class.getSimpleName();
    private static final Logger logger = LoggerFactory.getLogger(PageActivationEventHandler.class);

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

