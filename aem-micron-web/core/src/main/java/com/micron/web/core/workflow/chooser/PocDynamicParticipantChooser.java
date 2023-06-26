package com.micron.web.core.workflow.chooser;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.micron.web.core.solr.config.SolrCAConfig;
import com.micron.web.core.solr.util.PocUtil;

@Component(service = ParticipantStepChooser.class, immediate = true,
            property = {
              "chooser.label=" + "POC Dynamic Participant Workflow"
            }
)
public class PocDynamicParticipantChooser implements ParticipantStepChooser {

    private static final Logger logger = LoggerFactory.getLogger(PocDynamicParticipantChooser.class);
    private static final String CLASS_NAME = PocDynamicParticipantChooser.class.getSimpleName();

    @Reference
    private ResourceResolverFactory resourceResolverFactory;



    @Override
    public String getParticipant(final WorkItem workItem, final WorkflowSession workflowSession, final MetaDataMap metaDataMap) throws WorkflowException {
        logger.info("{} Execution started, method: getParticipant", CLASS_NAME);

        String approverName = StringUtils.EMPTY;

        try {
            WorkflowData workflowData = workItem.getWorkflowData();
            if (workflowData.getPayloadType().equals("JCR_PATH")) {
                String pagePath = workflowData.getPayload().toString();
                ResourceResolver resourceResolver = PocUtil.newResolver(this.resourceResolverFactory);
                SolrCAConfig solrCAConfig = PocUtil.getContextAwareConfig(pagePath, resourceResolver, SolrCAConfig.class);
                if (solrCAConfig != null) {
                    approverName = solrCAConfig.workflowApprover();
                }
            }
        }catch (Exception ex){
            logger.error("Error during process the page activation {}", ex.getMessage());
        }

        return approverName;
    }

}
