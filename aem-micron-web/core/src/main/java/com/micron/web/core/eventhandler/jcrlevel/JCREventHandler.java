package com.micron.web.core.eventhandler.jcrlevel;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.micron.web.core.solr.util.PocUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(service = EventListener.class, immediate = true)
public class JCREventHandler implements EventListener {

    private Session session;

    @Reference
    private SlingRepository slingRepository;

    /**
     * register the event listener using ObservationManager
     * @throws Exception
     */
    @Activate
    public void activate() throws Exception {
        try {

            //String[] nodetypes = {"cq:PageContent"};
            session = slingRepository.loginService(PocUtil.SUB_SERVICE_NAME,null);
            session.getWorkspace().getObservationManager().addEventListener(
              this,                                                    //handler
              Event.NODE_ADDED | Event.PROPERTY_ADDED,             //int code for event type
              "/content/micron-web/in/fr/content-page",             //path
              true,                                                //is Deep?
              null,                                                 //UUIDs filter
              null,                                        //nodetypes filter
              true);

        } catch (RepositoryException e){
            log.info(" \n Error while adding Event Listener : {} ",e.getMessage());
        }
    }


    @Override
    public void onEvent(final EventIterator events) {

        try {
            while (events.hasNext()){
                log.info("\n This is the JCR event handle JCREventHandler, Type : {}, Path : {} ",events.nextEvent().getType(), events.nextEvent().getPath());
            }
        } catch(Exception e){
            log.error("\n Error while processing events : {} ",e.getMessage());
        }

    }

}
