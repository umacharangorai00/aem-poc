package com.micron.web.core.workflow.process;

import javax.jcr.Session;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true,
            property = {"process.label" + " = Image Upload Process"}
)
public class ImageUploadWorkflowProcess implements WorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(ImageUploadWorkflowProcess.class);

    @Override
    public void execute(final WorkItem workItem, final WorkflowSession workflowSession, final MetaDataMap processArguments) throws WorkflowException {
        log.info("================================================================================= ");
        try {
            WorkflowData workflowData = workItem.getWorkflowData();
            if (workflowData.getPayloadType().equals("JCR_PATH")) {
                String imagePath = workflowData.getPayload().toString();
                Session session = workflowSession.adaptTo(Session.class);

            }
        }catch (Exception e){

        }
    }

}
