package org.redquark.aem.workflow;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

/**
 * @author Anirudh Sharma
 */
@Component(service = WorkflowProcess.class, property = {"process.label=Second Step WF"})
public class SecondStep implements WorkflowProcess {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
			throws WorkflowException {
		log.info("Executing second workflow step");
		String data = (String) workItem.getWorkflow().getWorkflowData().getMetaDataMap().get("FirstStepData");
		log.info("Data obtained from first step in second step is: {}", data);
	}

}
