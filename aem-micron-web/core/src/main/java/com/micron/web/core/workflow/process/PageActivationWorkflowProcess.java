package com.micron.web.core.workflow.process;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.micron.web.core.constants.AemConstant;

@Component(service = WorkflowProcess.class, immediate = true,
            property = {
              "process.label" + " = Micron Page Activation Process"
            }
)
public class PageActivationWorkflowProcess implements WorkflowProcess {

    private static final Logger logger = LoggerFactory.getLogger(PageActivationWorkflowProcess.class);
    private static final String CLASS_NAME = PageActivationWorkflowProcess.class.getSimpleName();

    @Reference
    private JobManager jobManager;


    @Override
    public void execute(final WorkItem workItem, final WorkflowSession workflowSession, final MetaDataMap metaDataMap) throws WorkflowException {
        logger.info("{} Execution started, Method: execute", CLASS_NAME);
        try {
            WorkflowData workflowData = workItem.getWorkflowData();
            if (workflowData.getPayloadType().equals("JCR_PATH")) {

                String pagePath = workflowData.getPayload().toString();
                Map<String, Object> jobProperties = new HashMap<>();
                jobProperties.put("payload", pagePath);
                jobManager.addJob(AemConstant.PAGE_REPLICATION_TOPIC, jobProperties);

            }
        }catch (Exception ex){
            logger.error("Error during process the page activation {}", ex.getMessage());
        }


        logger.info("{} Execution completed, Method: execute", CLASS_NAME);
    }

}
