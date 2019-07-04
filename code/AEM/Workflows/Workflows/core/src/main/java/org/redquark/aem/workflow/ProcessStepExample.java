package org.redquark.aem.workflow;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

/**
 * @author Anirudh Sharma
 */
@Component(service = WorkflowProcess.class, property = { "process.label=" + "Sample Process Step" })
public class ProcessStepExample implements WorkflowProcess {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
			throws WorkflowException {

		// Get the workflow data - which is being passed through for this work item
		final WorkflowData workflowData = workItem.getWorkflowData();

		// Get the payload type
		String payloadType = workflowData.getPayloadType();

		// Check if the payload is a path in the JCR; The other (less common) type is
		// JCR_UUID
		if (!StringUtils.equals(payloadType, "JCR_PATH")) {
			return;
		}

		// Get the path to the JCR from the payload
		final String path = workflowData.getPayload().toString();
		log.info("Payload path: {}", path);

		// Get workflow process arguments
		String processArguments = metaDataMap.get("PROCESS_ARGS", "Default");

		// Storing the process arguments in an array
		String[] processArgumentValues = processArguments.split(",");
		log.info("Process arguments: {}", Arrays.toString(processArgumentValues));

		/* Single and Multi value arguments */
		// Some WF Process steps support Single and MultiValue args; these are can
		// access via named properties
		// Custom WF inputs stored under ./metaData/argSingle and ./metadata/argMulti
		String singleValue = metaDataMap.get("argSingle", "Not Set");
		String[] multiValue = metaDataMap.get("argMulti", new String[] { "Not Set" });
		log.info("Single value: {}", singleValue);
		log.info("Multi value: {}", Arrays.toString(multiValue));

		// Get data set in previous workflow step
		String previouslySetData = this.getPersistedData(workItem, "previousStepKey", String.class);
		log.info(previouslySetData);

		// Persist data for use in subsequent workflow step
		this.persistData(workItem, workflowSession, "nextStepKey", "nextStepValue");

	}

	private <T> T getPersistedData(WorkItem workItem, String key, Class<T> type) {
		MetaDataMap metaDataMap = workItem.getWorkflow().getWorkflowData().getMetaDataMap();
		return metaDataMap.get(key, type);
	}

	private <T> boolean persistData(WorkItem workItem, WorkflowSession workflowSession, String key, T value) {
		WorkflowData workflowData = workItem.getWorkflow().getWorkflowData();
		if (workflowData.getMetaDataMap() == null) {
			return false;
		}
		workflowData.getMetaDataMap().put(key, value);
		workflowSession.updateWorkflowData(workItem.getWorkflow(), workflowData);
		return true;
	}
}
