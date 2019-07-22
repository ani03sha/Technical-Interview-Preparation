# Workflows

A workflow is a way to automate AEM activities. It contains some steps that are executed in a specific order to 
achieve the desired results.

Each step performs some activity such as publishing a page, creating a version of the page, sending an email message 
etc. In short, workflow can coordinate complicated activities that involve every aspect of AEM.

For example, the most common activity in AEM is publishing the page from the author instance to the publish instance.
 Normally, this functionality is often subjected to organizational processes, such as approval and sign-off by 
 various participants. These processes can be achieved by implementing Workflows.
 
There are many custom workflows provided out of the box in AEM. Apart from those, we can also define our custom 
workflows for our specific activities.


## Workflow console

The workflow console is the centralized location for workflow management in AEM. There are five tabs in this 
console - 

- **Models:** Lists the workflow models that are currently available. We can also create, edit and delete a new workflow here.
- **Instances:** This tab shows the details of the currently active workflow. These instances are also version dependent.
- **Archive:** This shows the list of terminated workflows, for whatever reason.
- **Launcher:** Allows us to define a workflow to be launched if a specific node has been updated.
- **Failures:** This enables us to manage and monitor failed workflow instances.


## Workflows steps

Workflow models consist of a series of steps of various types. According to the type, these steps can be configured 
and extended with parameters and scripts to provide the functionality and control require. 

There are following types of steps in Workflows - 

- **Process Step:** It executes an ECMA script or an OSGi service to perform automatic processing. A process can be 
implemented using the following steps - 
    1. Create an OSGi service implementing the interface `com.adobe.granite.workflow.exec.WorkflowProcess`.
    2. Set the property "process.label". This is the String value by which our workflow needs to be listed.
    3. Implement the `execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metadataMap)` method with the implementation code.
    
`execute()` method has three parameters :-
1. WorkItem - It is the unit that is passed through a Workflow instance of a `WorkflowModel`. It contains the `WorkflowData`. The instances acts on and a reference to the WorkflowNode that describes the underlying workflow step. 
2. WorkflowSession - This class provides all functionality (depending on the users rights) for managing `WorkflowModels`, Workflow instances and their execution.
3. MetaDataMap - A value map for generic access to meta data values.
    
- **Participant Step:** This enables us to assign ownership for a particular action. The workflow will only proceed 
when the user has manually acknowledged the step. This is used when we want to someone to take an action on the 
workflow. For e.g. a review step.

The user whom we assign the action must have access to the page that is the workflow payload.

- **Dialog Participant Step:** This is used to collect information from the user who is assigned the work item. The 
data can be later used in the workflow. 

Upon completing the step, the Complete Work Item dialog contains the fields that you define in your dialog. The data that 
is collected in the fields is stored in nodes of the workflow payload. Subsequent workflow steps can then read the value 
from the repository.

To configure the step, you specify the group or user to assign the work item to, and the path to the dialog.

- **Dynamic Participant Step:** This is similar to the participant step with the difference that the participant is 
selected automatically at run time. 

To configure the step, we select a Participant Chooser that identifies the participant to assign the work item to, 
together with a dialog.

- **OR Split:** This creates a split in the workflow, after which only one branch will be active. This step enables us
 to introduce conditional processing paths into your workflow. We add workflow steps to each branch as required.
 
- **AND Split:** The AND Split creates a split in the workflow, after which both branches will be active. We add 
workflow steps to each branch as required. This step enables us to introduce multiple processing paths into the 
workflow. For example, we can allow certain review steps to occur in parallel, so saving time.

- **Container Step:** A container step starts another workflow model that executes as a child workflow.
This container can allow you to reuse workflow models to implement common sequences of steps. For example a translation 
workflow model could be used in multiple editing workflows.

- **GOTO Step:** The Goto Step allows us to specify the next step in the workflow model to execute, dependent on the 
result of an ECMAScript:
      - true: The Goto Step completes and the workflow engine executes the specified step.
      - false: The Goto Step completes and the normal routing logic determines the next step to execute.
The Goto Step enables you to implement advanced routing structures in your workflow models. 
For example, to implement a loop, the Goto Step can be defined to execute a prior step in the workflow, with the script 
evaluating a loop condition.
