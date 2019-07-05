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
@Component(service = WorkflowProcess.class, property = {"process.label=First Step WF"})
public class FirstStep implements WorkflowProcess {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
		log.info("Executing first workflow step");
		// Setting value in the first workflow step
		workItem.getWorkflow().getWorkflowData().getMetaDataMap().put("FirstStepData", "This is the data to be passed in the first step");
	}

}
