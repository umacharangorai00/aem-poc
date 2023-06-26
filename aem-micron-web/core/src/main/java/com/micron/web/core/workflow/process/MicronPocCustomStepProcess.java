package com.micron.web.core.workflow.process;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true,
            property = {
              "process.label" + " = Micron POC Custom Process"
            }
)
public class MicronPocCustomStepProcess implements WorkflowProcess {

    private static final Logger logger = LoggerFactory.getLogger(MicronPocCustomStepProcess.class);
    private static final String CLASS_NAME = MicronPocCustomStepProcess.class.getSimpleName();

    @Override
    public void execute(final WorkItem workItem, final WorkflowSession workflowSession, final MetaDataMap metaDataMap) throws WorkflowException {
        logger.info("{} execution start, method: execute", CLASS_NAME);

        String brand = metaDataMap.get("BRAND", "");
        boolean isMultinational = metaDataMap.get("MULTINATIONAL", false);

        String[] countryList = metaDataMap.get("COUNTRIES", String[].class);

        logger.info("Band is {} and Multinational is {} ", brand,isMultinational);
        for (String country : countryList) {

            logger.info("Country name is {}", country);
        }

        logger.info("{} execution end, method: execute", CLASS_NAME);

    }

}
