package com.micron.web.core.job;

import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.micron.web.core.constants.AemConstant;
import com.micron.web.core.services.ReplicationService;

import static com.micron.web.core.constants.AemConstant.PAGE_REPLICATION_TOPIC;
import static com.micron.web.core.job.PageReplicationJobConsumer.SERVICE_NAME;
import static org.apache.sling.event.jobs.consumer.JobConsumer.PROPERTY_TOPICS;
import static org.osgi.framework.Constants.SERVICE_DESCRIPTION;
import static org.osgi.service.event.EventConstants.SERVICE_ID;

@Component(immediate = true, service = JobConsumer.class,
      property = {
        SERVICE_ID + AemConstant.EQUALS + SERVICE_NAME,
        SERVICE_DESCRIPTION + AemConstant.EQUALS + "This job replicates the given payload",
        PROPERTY_TOPICS + AemConstant.EQUALS + PAGE_REPLICATION_TOPIC
      }
)
public class PageReplicationJobConsumer implements JobConsumer {

    protected static final String SERVICE_NAME = "Page Replication Job";
    private static final String CLASS_NAME = PageReplicationJobConsumer.class.getSimpleName();
    private static final Logger logger = LoggerFactory.getLogger(PageReplicationJobConsumer.class);

    @Reference
    private ReplicationService replicationService;

    @Override
    public JobResult process(final Job job) {

        logger.debug("{}: trying to execute job: {}", CLASS_NAME, job.getTopic());
        try {
            // Get the payload path from the job properties
            String payloadPath = (String) job.getProperty("payload");
            // Call the replication service
            replicationService.replicateContent(payloadPath);
            return JobResult.OK;
        } catch (Exception e) {
            logger.error("{}: job failed due to: {}", CLASS_NAME, e.getMessage());
            return JobResult.FAILED;
        }
    }

}
