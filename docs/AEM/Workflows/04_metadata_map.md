# Metadata Map

AEM's rich workflow APIs give us the facility to pass some data in one step of a workflow for processing and this 
data can be retrieved in any other step of the same workflow. 

Values that can be passed between workflow steps are primitive data types like string and integer values. Values are 
passed within a Map instance. 

If you need to pass non-primitive data (binary data), you can pass it within a byte[]. However if the byte array is too 
large, a better approach is to write the data to a JCR node in a given step and retrieve it in a later step. 

`Do not try to store data as an InputStream in the Map`

A MetaDataMap is the data structure which acts as a value map and allows users to set and get data among the steps.

For e.g. below workflow step sets data in the map - 

```java
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
```

We are setting value against the key `FirstStepData`. The same key will be used to retrieve data in another step as 
below -

```java
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
```

Thus, it is very simple to get and set data among different workflow steps.